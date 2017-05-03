package android.support.v4.view;

import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.UiThread;
import android.support.v4.util.Pools.SynchronizedPool;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.concurrent.ArrayBlockingQueue;

public final class AsyncLayoutInflater {
    private static final String TAG = "AsyncLayoutInflater";
    Handler mHandler;
    private Callback mHandlerCallback;
    InflateThread mInflateThread;
    LayoutInflater mInflater;

    /* renamed from: android.support.v4.view.AsyncLayoutInflater.1 */
    class C01951 implements Callback {
        C01951() {
        }

        public boolean handleMessage(Message message) {
            InflateRequest inflateRequest = (InflateRequest) message.obj;
            if (inflateRequest.view == null) {
                inflateRequest.view = AsyncLayoutInflater.this.mInflater.inflate(inflateRequest.resid, inflateRequest.parent, false);
            }
            inflateRequest.callback.onInflateFinished(inflateRequest.view, inflateRequest.resid, inflateRequest.parent);
            AsyncLayoutInflater.this.mInflateThread.releaseRequest(inflateRequest);
            return true;
        }
    }

    private static class BasicInflater extends LayoutInflater {
        private static final String[] sClassPrefixList;

        static {
            sClassPrefixList = new String[]{"android.widget.", "android.webkit.", "android.app."};
        }

        BasicInflater(Context context) {
            super(context);
        }

        public LayoutInflater cloneInContext(Context context) {
            return new BasicInflater(context);
        }

        protected View onCreateView(String str, AttributeSet attributeSet) {
            String[] strArr = sClassPrefixList;
            int length = strArr.length;
            int i = 0;
            while (i < length) {
                try {
                    View createView = createView(str, strArr[i], attributeSet);
                    if (createView != null) {
                        return createView;
                    }
                    i++;
                } catch (ClassNotFoundException e) {
                }
            }
            return super.onCreateView(str, attributeSet);
        }
    }

    private static class InflateRequest {
        OnInflateFinishedListener callback;
        AsyncLayoutInflater inflater;
        ViewGroup parent;
        int resid;
        View view;

        InflateRequest() {
        }
    }

    private static class InflateThread extends Thread {
        private static final InflateThread sInstance;
        private ArrayBlockingQueue<InflateRequest> mQueue;
        private SynchronizedPool<InflateRequest> mRequestPool;

        private InflateThread() {
            this.mQueue = new ArrayBlockingQueue(10);
            this.mRequestPool = new SynchronizedPool(10);
        }

        static {
            sInstance = new InflateThread();
            sInstance.start();
        }

        public static InflateThread getInstance() {
            return sInstance;
        }

        public void run() {
            while (true) {
                try {
                    InflateRequest inflateRequest = (InflateRequest) this.mQueue.take();
                    try {
                        inflateRequest.view = inflateRequest.inflater.mInflater.inflate(inflateRequest.resid, inflateRequest.parent, false);
                    } catch (Throwable e) {
                        Log.w(AsyncLayoutInflater.TAG, "Failed to inflate resource in the background! Retrying on the UI thread", e);
                    }
                    Message.obtain(inflateRequest.inflater.mHandler, 0, inflateRequest).sendToTarget();
                } catch (Throwable e2) {
                    Log.w(AsyncLayoutInflater.TAG, e2);
                }
            }
        }

        public InflateRequest obtainRequest() {
            InflateRequest inflateRequest = (InflateRequest) this.mRequestPool.acquire();
            if (inflateRequest == null) {
                return new InflateRequest();
            }
            return inflateRequest;
        }

        public void releaseRequest(InflateRequest inflateRequest) {
            inflateRequest.callback = null;
            inflateRequest.inflater = null;
            inflateRequest.parent = null;
            inflateRequest.resid = 0;
            inflateRequest.view = null;
            this.mRequestPool.release(inflateRequest);
        }

        public void enqueue(InflateRequest inflateRequest) {
            try {
                this.mQueue.put(inflateRequest);
            } catch (Throwable e) {
                throw new RuntimeException("Failed to enqueue async inflate request", e);
            }
        }
    }

    public interface OnInflateFinishedListener {
        void onInflateFinished(View view, int i, ViewGroup viewGroup);
    }

    public AsyncLayoutInflater(@NonNull Context context) {
        this.mHandlerCallback = new C01951();
        this.mInflater = new BasicInflater(context);
        this.mHandler = new Handler(this.mHandlerCallback);
        this.mInflateThread = InflateThread.getInstance();
    }

    @UiThread
    public void inflate(@LayoutRes int i, @Nullable ViewGroup viewGroup, @NonNull OnInflateFinishedListener onInflateFinishedListener) {
        if (onInflateFinishedListener == null) {
            throw new NullPointerException("callback argument may not be null!");
        }
        InflateRequest obtainRequest = this.mInflateThread.obtainRequest();
        obtainRequest.inflater = this;
        obtainRequest.resid = i;
        obtainRequest.parent = viewGroup;
        obtainRequest.callback = onInflateFinishedListener;
        this.mInflateThread.enqueue(obtainRequest);
    }
}
