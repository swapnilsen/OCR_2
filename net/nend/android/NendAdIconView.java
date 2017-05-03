package net.nend.android;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Rect;
import android.os.Handler;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.Timer;
import java.util.TimerTask;
import net.nend.android.NendAdView.NendError;
import net.nend.android.NendHelper.AsyncTaskHelper;

public class NendAdIconView extends LinearLayout implements EventListener {
    private static final int DEFAULT_TEXT_PIXEL_SIZE = 10;
    private static final int ICON_CONTAINER_SIZE = 75;
    private static final int ICON_SIZE = 57;
    private static final int MINIMUM_TEXT_PIXEL_SIZE = 6;
    private static final int OPTOUT_HEIGHT = 12;
    private static final int OPTOUT_MARGIN = 3;
    private static final int WP = -2;
    private AdParameter mAdParameter;
    private float mDensity;
    private Handler mHandler;
    private int mHorizontalIconMargin;
    private boolean mIconSpaceEnabled;
    private AdListener mListener;
    private String mOptoutBaseUrl;
    private Bitmap mOptoutBitmap;
    private int mOptoutHeight;
    private float mOptoutMargin;
    private int mPosition;
    private Rect mRect;
    private int mRight;
    private int mScrollLength;
    private Runnable mSetFontSizeRunnable;
    private Rect mSrcRect;
    private int mTitleColor;
    private TextView mTitleTextView;
    private boolean mTitleVisible;
    private NendAdViewSwitcher mViewSwitcher;

    interface AdListener {
        void onClick(View view);

        void onFailedToReceive(NendIconError nendIconError);

        void onReceive(View view);

        void onWindowFocusChanged(boolean z);
    }

    /* renamed from: net.nend.android.NendAdIconView.1 */
    class C16311 implements Runnable {
        C16311() {
        }

        public void run() {
            NendAdIconView.this.adjustTextView(NendAdIconView.this.mTitleTextView);
        }
    }

    /* renamed from: net.nend.android.NendAdIconView.2 */
    class C16322 implements OnFinishListener {
        C16322() {
        }

        public void onFinish(String str) {
            NendHelper.startBrowser(NendAdIconView.this.getContext(), new StringBuilder(String.valueOf(NendAdIconView.this.mOptoutBaseUrl)).append("&gaid=").append(str).toString());
        }
    }

    /* renamed from: net.nend.android.NendAdIconView.3 */
    class C16343 extends TimerTask {

        /* renamed from: net.nend.android.NendAdIconView.3.1 */
        class C16331 implements Runnable {
            C16331() {
            }

            public void run() {
                if (NendAdIconView.this.mPosition <= NendAdIconView.this.mScrollLength) {
                    NendAdIconView access$0 = NendAdIconView.this;
                    access$0.mPosition = access$0.mPosition + 1;
                    NendAdIconView.this.invalidate();
                    return;
                }
                NendAdIconView.this.mPosition = NendAdIconView.this.mScrollLength;
                NendAdIconView.this.invalidate();
                C16343.this.cancel();
                NendAdIconView.this.scrollRight();
            }
        }

        C16343() {
        }

        public void run() {
            NendAdIconView.this.mHandler.post(new C16331());
        }
    }

    /* renamed from: net.nend.android.NendAdIconView.4 */
    class C16364 extends TimerTask {

        /* renamed from: net.nend.android.NendAdIconView.4.1 */
        class C16351 implements Runnable {
            C16351() {
            }

            public void run() {
                NendAdIconView access$0 = NendAdIconView.this;
                access$0.mPosition = access$0.mPosition - 1;
                NendAdIconView.this.invalidate();
            }
        }

        C16364() {
        }

        public void run() {
            if (NendAdIconView.this.mPosition >= 0) {
                NendAdIconView.this.mHandler.post(new C16351());
                return;
            }
            NendAdIconView.this.scrollReset();
            cancel();
        }
    }

    /* renamed from: net.nend.android.NendAdIconView.5 */
    class C16375 implements Runnable {
        C16375() {
        }

        public void run() {
            NendAdIconView.this.mPosition = 0;
            NendAdIconView.this.invalidate();
        }
    }

    private static final class ScrollParams {
        private static final int SCROLL_INTERVAL = 4;
        private static final int WAIT_TIME_IN_SECOND = 1000;

        private ScrollParams() {
        }
    }

    public NendAdIconView(Context context) {
        super(context);
        this.mTitleVisible = true;
        this.mIconSpaceEnabled = true;
        this.mTitleColor = ViewCompat.MEASURED_STATE_MASK;
        this.mOptoutBitmap = null;
        this.mHandler = new Handler();
        this.mSetFontSizeRunnable = new C16311();
        init(context);
    }

    public NendAdIconView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mTitleVisible = true;
        this.mIconSpaceEnabled = true;
        this.mTitleColor = ViewCompat.MEASURED_STATE_MASK;
        this.mOptoutBitmap = null;
        this.mHandler = new Handler();
        this.mSetFontSizeRunnable = new C16311();
        Object attributeValue = attributeSet.getAttributeValue(null, IconAttribute.TITLE_COLOR.getName());
        if (!TextUtils.isEmpty(attributeValue)) {
            try {
                this.mTitleColor = Color.parseColor(attributeValue);
            } catch (Exception e) {
                this.mTitleColor = ViewCompat.MEASURED_STATE_MASK;
            }
        }
        this.mTitleVisible = attributeSet.getAttributeBooleanValue(null, IconAttribute.TITLE_VISIBLE.getName(), true);
        this.mIconSpaceEnabled = attributeSet.getAttributeBooleanValue(null, IconAttribute.ICON_SPACE.getName(), true);
        init(context);
    }

    private void init(Context context) {
        setOrientation(1);
        this.mDensity = context.getResources().getDisplayMetrics().density;
        this.mOptoutMargin = 3.0f * this.mDensity;
        this.mRect = new Rect();
        this.mSrcRect = new Rect();
        this.mOptoutBitmap = NendHelper.getBitmapImageInformationFromByteData();
        this.mViewSwitcher = new NendAdViewSwitcher(context);
        LayoutParams layoutParams = new LinearLayout.LayoutParams(WP, WP);
        layoutParams.gravity = 1;
        addView(this.mViewSwitcher, layoutParams);
        this.mTitleTextView = new TextView(context);
        this.mTitleTextView.setTextColor(this.mTitleColor);
        this.mTitleTextView.setLines(1);
        this.mTitleTextView.setGravity(17);
        layoutParams = new LinearLayout.LayoutParams(WP, WP);
        layoutParams.gravity = 1;
        addView(this.mTitleTextView, layoutParams);
    }

    void loadImage(AdParameter adParameter, int i) {
        if (adParameter == null) {
            notifyError();
            return;
        }
        this.mAdParameter = adParameter;
        this.mOptoutBaseUrl = "http://nend.net/privacy/optsdkgate?uid=" + NendHelper.makeUid(getContext()) + "&spot=" + i;
        this.mViewSwitcher.download(adParameter, this);
    }

    void deallocate() {
        this.mListener = null;
        this.mViewSwitcher.abort();
    }

    protected void onMeasure(int i, int i2) {
        int i3;
        super.onMeasure(i, i2);
        int i4 = (int) (57.0f * this.mDensity);
        int i5 = (int) (75.0f * this.mDensity);
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        int mode2 = MeasureSpec.getMode(i2);
        int size2 = MeasureSpec.getSize(i2);
        if (1073741824 == mode && 1073741824 == mode2 && size != size2) {
            size2 = Math.min(size, size2);
            size = size2;
        }
        if (1073741824 != mode) {
            size = this.mIconSpaceEnabled ? i5 : i4;
        }
        if (1073741824 == mode2) {
            if (this.mIconSpaceEnabled || !this.mTitleVisible) {
                i3 = size2;
            } else {
                i3 = (int) ((((((float) size2) / ((float) i5)) * ((float) (i5 - i4))) + ((float) size2)) + 0.5f);
            }
        } else if (this.mIconSpaceEnabled || (!this.mIconSpaceEnabled && this.mTitleVisible)) {
            i3 = i5;
        } else {
            i3 = i4;
        }
        setMeasuredDimension(MeasureSpec.makeMeasureSpec(size, 1073741824), MeasureSpec.makeMeasureSpec(i3, 1073741824));
        if (1073741824 == mode || 1073741824 == mode2) {
            if (this.mIconSpaceEnabled) {
                i4 = (int) (((((float) size) / ((float) i5)) * ((float) i4)) + 0.5f);
            } else {
                i4 = size;
            }
        }
        i5 = MeasureSpec.makeMeasureSpec(i4, 1073741824);
        this.mViewSwitcher.measure(i5, i5);
        if (!this.mIconSpaceEnabled) {
            size = i4;
        }
        this.mTitleTextView.measure(MeasureSpec.makeMeasureSpec(size, 1073741824), MeasureSpec.makeMeasureSpec(i3 - i4, 1073741824));
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        int i5 = i3 - i;
        int width = this.mViewSwitcher.getWidth();
        this.mHorizontalIconMargin = (i5 - width) / 2;
        this.mOptoutHeight = (int) ((((float) width) / (57.0f * this.mDensity)) * (12.0f * this.mDensity));
        this.mRight = this.mHorizontalIconMargin + width;
        this.mScrollLength = this.mOptoutBitmap.getWidth() - this.mOptoutBitmap.getHeight();
        this.mSrcRect.top = 0;
        this.mSrcRect.left = 0;
        this.mSrcRect.right = this.mOptoutBitmap.getHeight();
        this.mSrcRect.bottom = this.mOptoutBitmap.getHeight();
        this.mRect.top = 0;
        this.mRect.left = this.mRight - this.mOptoutHeight;
        this.mRect.right = this.mRight;
        this.mRect.bottom = this.mOptoutHeight;
    }

    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.mViewSwitcher.hasAdImage() && this.mOptoutBitmap != null) {
            this.mSrcRect.right = this.mOptoutBitmap.getHeight() + this.mPosition;
            this.mRect.left = (int) (((float) (this.mRight - this.mOptoutHeight)) - ((((float) this.mPosition) * this.mDensity) / 2.0f));
            canvas.drawBitmap(this.mOptoutBitmap, this.mSrcRect, this.mRect, null);
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        switch (motionEvent.getAction()) {
            case NendIconError.ERROR_ICONVIEW /*1*/:
                if (!this.mViewSwitcher.hasAdImage() || this.mOptoutBitmap == null || x <= ((float) this.mRect.left) - this.mOptoutMargin || x >= ((float) this.mRect.right) || y <= ((float) this.mRect.top) || y >= ((float) this.mRect.bottom) + this.mOptoutMargin) {
                    return false;
                }
                if (this.mPosition >= this.mScrollLength) {
                    AsyncTaskHelper.execute(new GetAdvertisingIdTask(getContext(), new C16322()), new Void[0]);
                } else {
                    scrollLeft();
                }
                return true;
            default:
                return false;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.mListener != null) {
            this.mListener.onWindowFocusChanged(z);
        }
        if (!z) {
            scrollReset();
        }
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        deallocate();
    }

    public void setTitleVisible(boolean z) {
        if (this.mTitleVisible != z) {
            this.mTitleVisible = z;
            requestLayout();
            if (z && !TextUtils.isEmpty(this.mTitleTextView.getText())) {
                post(this.mSetFontSizeRunnable);
            }
            this.mTitleTextView.setVisibility(z ? 0 : 4);
            invalidate();
        }
    }

    public void setTitleColor(int i) {
        if (this.mTitleColor != i) {
            this.mTitleColor = i;
            this.mTitleTextView.setTextColor(i);
            invalidate();
        }
    }

    public void setIconSpaceEnabled(boolean z) {
        if (this.mIconSpaceEnabled != z) {
            this.mIconSpaceEnabled = z;
            requestLayout();
            invalidate();
        }
    }

    void setListner(AdListener adListener) {
        this.mListener = adListener;
    }

    private void scrollLeft() {
        new Timer().scheduleAtFixedRate(new C16343(), 0, 4);
    }

    private void scrollRight() {
        new Timer().scheduleAtFixedRate(new C16364(), 1000, 4);
    }

    private void scrollReset() {
        this.mHandler.post(new C16375());
    }

    private void adjustTextView(TextView textView) {
        float displayableTextPixelSize = getDisplayableTextPixelSize(textView);
        if (0.0f != displayableTextPixelSize) {
            textView.setTextSize(0, (float) ((int) displayableTextPixelSize));
            return;
        }
        textView.setTextSize(0, 6.0f);
        textView.setText(TextUtils.ellipsize(textView.getText(), textView.getPaint(), (float) getWidth(), TruncateAt.END).toString());
    }

    private float getDisplayableTextPixelSize(TextView textView) {
        String charSequence = textView.getText().toString();
        Paint paint = new Paint(textView.getPaint());
        paint.setTextSize(10.0f * this.mDensity);
        int width = textView.getWidth();
        int height = textView.getHeight();
        while (true) {
            FontMetrics fontMetrics = paint.getFontMetrics();
            if (((float) width) > paint.measureText(charSequence) && ((float) height) > Math.abs(fontMetrics.ascent - fontMetrics.descent)) {
                return paint.getTextSize();
            }
            float textSize = paint.getTextSize() - 1.0f;
            if (6.0f * this.mDensity > textSize) {
                return 0.0f;
            }
            paint.setTextSize(textSize);
        }
    }

    private void notifySuccess() {
        if (this.mListener != null) {
            this.mListener.onReceive(this);
        }
    }

    private void notifyError() {
        NendLog.m5584d("onFailedToImageDownload!");
        if (this.mListener != null) {
            NendIconError nendIconError = new NendIconError();
            nendIconError.setIconView(this);
            nendIconError.setErrorType(1);
            nendIconError.setNendError(NendError.FAILED_AD_DOWNLOAD);
            this.mListener.onFailedToReceive(nendIconError);
        }
    }

    public boolean onValidation(int i, int i2) {
        return true;
    }

    public void onClickAd() {
        if (this.mListener != null) {
            this.mListener.onClick(this);
        }
    }

    public void onSuccess() {
        this.mTitleTextView.setText(this.mAdParameter.getTitleText());
        adjustTextView(this.mTitleTextView);
        this.mTitleTextView.setVisibility(this.mTitleVisible ? 0 : 4);
        postInvalidate();
        notifySuccess();
    }

    public void onFailure() {
        notifyError();
    }
}
