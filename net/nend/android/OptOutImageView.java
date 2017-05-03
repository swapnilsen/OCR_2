package net.nend.android;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.view.PointerIconCompat;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.Scroller;
import java.lang.ref.WeakReference;
import net.nend.android.NendHelper.AsyncTaskHelper;
import net.nend.android.NendHelper.MetaDataHelper;

@SuppressLint({"ViewConstructor"})
final class OptOutImageView extends ImageView implements OnClickListener {
    private static final int MESSAGE_CODE = 718;
    private final float mDensity;
    private final Handler mHandler;
    private Bitmap mOptOutImage;
    private final String mOptOutUrl;
    private final Scroller mScroller;

    /* renamed from: net.nend.android.OptOutImageView.1 */
    class C16461 implements OnFinishListener {
        C16461() {
        }

        public void onFinish(String str) {
            NendHelper.startBrowser(OptOutImageView.this.getContext(), new StringBuilder(String.valueOf(OptOutImageView.this.mOptOutUrl)).append("&gaid=").append(str).toString());
        }
    }

    private static class OptOutHandler extends Handler {
        private WeakReference<OptOutImageView> weakReference;

        OptOutHandler(Looper looper, OptOutImageView optOutImageView) {
            super(looper);
            this.weakReference = new WeakReference(optOutImageView);
        }

        public void handleMessage(Message message) {
            super.handleMessage(message);
            OptOutImageView optOutImageView = (OptOutImageView) this.weakReference.get();
            if (optOutImageView != null) {
                optOutImageView.scrollRight();
            }
        }
    }

    private static final class ScrollParams {
        private static final int SCROLL_LENGTH = 45;
        private static final int SCROLL_TIME_IN_SECOND = 1;
        private static final int WAIT_TIME_IN_SECOND = 1;

        private ScrollParams() {
        }
    }

    private static final class TapMargin {
        private static final int BOTTOM = 18;
        private static final int LEFT = 18;

        private TapMargin() {
        }
    }

    OptOutImageView(Context context, String str, int i) {
        super(context);
        this.mDensity = getContext().getResources().getDisplayMetrics().density;
        this.mScroller = new Scroller(context);
        this.mHandler = new OptOutHandler(Looper.getMainLooper(), this);
        this.mOptOutUrl = MetaDataHelper.getStringValue(context, MetaData.OPT_OUT_URL.getName(), "http://nend.net/privacy/optsdkgate") + "?uid=" + str + "&spot=" + i;
        setPadding(realScrollLength(18), 0, realScrollLength(45) * -1, realScrollLength(18));
        setOnClickListener(this);
        this.mOptOutImage = NendHelper.loadAssets(getContext(), "nend_information_icon.png");
        if (this.mOptOutImage != null) {
            setImageBitmap(this.mOptOutImage);
        }
    }

    boolean hasDrawable() {
        return getDrawable() != null;
    }

    public void onClick(View view) {
        if (this.mScroller.getCurrX() == ((int) (45.0f * this.mDensity))) {
            AsyncTaskHelper.execute(new GetAdvertisingIdTask(getContext(), new C16461()), new Void[0]);
            return;
        }
        scrollLeft();
        this.mHandler.removeMessages(MESSAGE_CODE);
        this.mHandler.sendEmptyMessageDelayed(MESSAGE_CODE, 2000);
    }

    public void deallocateImage() {
        if (this.mOptOutImage != null) {
            if (!this.mOptOutImage.isRecycled()) {
                this.mOptOutImage.recycle();
            }
            this.mOptOutImage = null;
        }
    }

    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            setPadding(this.mScroller.getCurrX() + ((realScrollLength(18) * (realScrollLength(45) - this.mScroller.getCurrX())) / realScrollLength(45)), 0, realScrollLength(45) * -1, realScrollLength(18));
            scrollTo(this.mScroller.getCurrX(), this.mScroller.getCurrY());
            postInvalidate();
        }
    }

    void scrollLeft() {
        this.mScroller.forceFinished(true);
        this.mScroller.startScroll(this.mScroller.getCurrX(), this.mScroller.getCurrY(), realScrollLength(45) - this.mScroller.getCurrX(), 0, PointerIconCompat.TYPE_DEFAULT);
        invalidate();
    }

    void scrollRight() {
        this.mScroller.startScroll(this.mScroller.getCurrX(), this.mScroller.getCurrY(), this.mScroller.getCurrX() * -1, 0, PointerIconCompat.TYPE_DEFAULT);
        invalidate();
    }

    private int realScrollLength(int i) {
        return (int) (((float) i) * this.mDensity);
    }
}
