package net.nend.android;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.view.MotionEventCompat;
import android.util.Base64;
import android.view.MotionEvent;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.api.client.http.HttpMethods;
import com.google.api.client.http.HttpStatusCodes;
import com.google.firebase.messaging.SendException;
import java.net.HttpURLConnection;
import java.net.URL;
import net.nend.android.NendHelper.AsyncTaskHelper;
import org.apache.http.HttpEntity;
import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.util.EntityUtils;

class NendAdAnimationWebView extends WebView {
    private EventListener mEventListener;
    private boolean mIsDestroyed;
    private boolean mIsLoaded;
    private boolean mIsTouchDown;
    private OnClickListener mOnClickListener;
    private GetImageTask mTask;

    /* renamed from: net.nend.android.NendAdAnimationWebView.1 */
    class C16271 extends WebViewClient {
        C16271() {
        }

        public void onPageFinished(WebView webView, String str) {
            NendAdAnimationWebView.this.mIsLoaded = true;
            NendAdAnimationWebView.this.onSuccess();
        }

        public void onReceivedError(WebView webView, int i, String str, String str2) {
            NendAdAnimationWebView.this.onFailure();
        }
    }

    private interface OnGetImageListener {
        void onGetImage(AnimationGif animationGif);
    }

    /* renamed from: net.nend.android.NendAdAnimationWebView.2 */
    class C16282 implements OnGetImageListener {
        C16282() {
        }

        public void onGetImage(AnimationGif animationGif) {
            NendAdAnimationWebView.this.mTask = null;
            if (animationGif == null || !animationGif.hasData()) {
                NendAdAnimationWebView.this.onFailure();
            } else if (!NendAdAnimationWebView.this.onValidation(animationGif.width, animationGif.height)) {
            } else {
                if (NendAdAnimationWebView.this.mIsDestroyed) {
                    NendAdAnimationWebView.this.onFailure();
                    return;
                }
                NendAdAnimationWebView.this.loadDataWithBaseURL(null, NendAdAnimationWebView.htmlForAdImage(String.format("data:image/gif;base64,%s", new Object[]{Base64.encodeToString(animationGif.data, 2)})), "text/html", "utf-8", null);
            }
        }
    }

    private static class AnimationGif {
        private final byte[] data;
        private final int height;
        private final int width;

        private AnimationGif(byte[] bArr, int i, int i2) {
            this.data = bArr;
            this.width = i;
            this.height = i2;
        }

        private boolean hasData() {
            return this.data != null && this.data.length > 0;
        }
    }

    interface EventListener {
        void onFailure();

        void onSuccess();

        boolean onValidation(int i, int i2);
    }

    private static class GetImageTask extends AsyncTask<Void, Void, AnimationGif> {
        private static final int TIMEOUT = 3000;
        private final OnGetImageListener mListener;
        private final String mUrl;

        /* renamed from: net.nend.android.NendAdAnimationWebView.GetImageTask.1 */
        class C16291 implements Runnable {
            private final /* synthetic */ AnimationGif val$result;

            C16291(AnimationGif animationGif) {
                this.val$result = animationGif;
            }

            public void run() {
                GetImageTask.this.mListener.onGetImage(this.val$result);
            }
        }

        private GetImageTask(String str, OnGetImageListener onGetImageListener) {
            this.mUrl = str;
            this.mListener = onGetImageListener;
        }

        protected AnimationGif doInBackground(Void... voidArr) {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.mUrl).openConnection();
                httpURLConnection.setRequestMethod(HttpMethods.GET);
                httpURLConnection.setConnectTimeout(TIMEOUT);
                httpURLConnection.setReadTimeout(TIMEOUT);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setDoInput(true);
                int responseCode = httpURLConnection.getResponseCode();
                if (HttpStatusCodes.STATUS_CODE_OK != responseCode) {
                    throw new Exception("response code: " + responseCode);
                }
                byte[] toByteArray = EntityUtils.toByteArray(NendAdAnimationWebView.entityFromConnection(httpURLConnection));
                Options options = new Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeByteArray(toByteArray, 0, toByteArray.length, options);
                httpURLConnection.disconnect();
                return new AnimationGif(options.outWidth, options.outHeight, null);
            } catch (Throwable e) {
                NendLog.m5597e(NendStatus.ERR_HTTP_REQUEST, e);
                return null;
            }
        }

        protected void onPostExecute(AnimationGif animationGif) {
            if (!isCancelled()) {
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    this.mListener.onGetImage(animationGif);
                } else {
                    new Handler(Looper.getMainLooper()).post(new C16291(animationGif));
                }
            }
        }
    }

    @SuppressLint({"NewApi"})
    NendAdAnimationWebView(Context context) {
        super(context);
        this.mIsTouchDown = false;
        this.mIsLoaded = false;
        this.mIsDestroyed = false;
        this.mOnClickListener = null;
        this.mEventListener = null;
        this.mIsLoaded = false;
        this.mIsDestroyed = false;
        setBackgroundColor(0);
        if (11 <= VERSION.SDK_INT) {
            setLayerType(1, null);
        }
        setVerticalScrollBarEnabled(false);
        setHorizontalScrollBarEnabled(false);
        setWebViewClient(new C16271());
        getSettings().setSupportZoom(false);
        getSettings().setBuiltInZoomControls(false);
        getSettings().setUseWideViewPort(false);
        getSettings().setLoadWithOverviewMode(false);
    }

    protected void onDetachedFromWindow() {
        try {
            super.onDetachedFromWindow();
        } catch (Throwable e) {
            NendLog.m5615w("AndroidSDK internal error", e);
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & MotionEventCompat.ACTION_MASK) {
            case NendAdIconLayout.HORIZONTAL /*0*/:
                this.mIsTouchDown = true;
                return true;
            case NendIconError.ERROR_ICONVIEW /*1*/:
                if (this.mIsTouchDown) {
                    if (this.mOnClickListener != null) {
                        this.mOnClickListener.onClick(this);
                    }
                    this.mIsTouchDown = false;
                    return true;
                }
                break;
            case SendException.ERROR_TTL_EXCEEDED /*3*/:
                this.mIsTouchDown = false;
                break;
        }
        return false;
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void destroy() {
        super.destroy();
        this.mIsDestroyed = true;
    }

    void loadAnimationGif(String str, EventListener eventListener) {
        this.mEventListener = eventListener;
        this.mTask = new GetImageTask(new C16282(), null);
        AsyncTaskHelper.execute(this.mTask, new Void[0]);
    }

    void cancel() {
        this.mEventListener = null;
        if (this.mTask != null && !this.mTask.isCancelled()) {
            this.mTask.cancel(true);
        }
    }

    boolean isLoaded() {
        return this.mIsLoaded;
    }

    private void onSuccess() {
        if (this.mEventListener != null) {
            this.mEventListener.onSuccess();
        }
    }

    private void onFailure() {
        if (this.mEventListener != null) {
            this.mEventListener.onFailure();
        }
    }

    private boolean onValidation(int i, int i2) {
        if (this.mEventListener != null) {
            return this.mEventListener.onValidation(i, i2);
        }
        return false;
    }

    private static String htmlForAdImage(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<html>");
        stringBuilder.append("<head>");
        stringBuilder.append("<style type='text/css'>");
        stringBuilder.append("body{margin: auto auto} img{max-width: 100%; max-height: 100%;}");
        stringBuilder.append("</style>");
        stringBuilder.append("</head>");
        stringBuilder.append("<body>");
        stringBuilder.append("<img src=\"" + str + "\" width=\"100%\" height=\"100%\" />");
        stringBuilder.append("</body>");
        stringBuilder.append("</html>");
        return stringBuilder.toString();
    }

    private static HttpEntity entityFromConnection(HttpURLConnection httpURLConnection) {
        HttpEntity basicHttpEntity = new BasicHttpEntity();
        basicHttpEntity.setContent(httpURLConnection.getInputStream());
        basicHttpEntity.setContentLength((long) httpURLConnection.getContentLength());
        basicHttpEntity.setContentEncoding(httpURLConnection.getContentEncoding());
        basicHttpEntity.setContentType(httpURLConnection.getContentType());
        return basicHttpEntity;
    }
}
