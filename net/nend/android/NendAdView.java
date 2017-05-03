package net.nend.android;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import com.google.firebase.messaging.SendException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import net.nend.android.AdParameter.ViewType;

public final class NendAdView extends RelativeLayout implements AdListener, EventListener {
    private static /* synthetic */ int[] $SWITCH_TABLE$net$nend$android$AdParameter$ViewType;
    static final /* synthetic */ boolean $assertionsDisabled;
    private Ad mAd;
    private String mApiKey;
    private NendAdController mController;
    private float mDensity;
    private boolean mHasWindowFocus;
    private boolean mIsClicked;
    private RelativeLayout mLayout;
    private NendAdListener mListener;
    private DisplayMetrics mMetrics;
    private NendError mNendError;
    private OptOutImageView mOptOutImageView;
    private int mSpotId;
    private NendAdViewSwitcher mViewSwitcher;
    private WebView mWebView;

    public enum NendError {
        AD_SIZE_TOO_LARGE(840, "Ad size will not fit on screen."),
        INVALID_RESPONSE_TYPE(841, "Response type is invalid."),
        FAILED_AD_REQUEST(842, "Failed to Ad request."),
        FAILED_AD_DOWNLOAD(843, "Failed to Ad download."),
        AD_SIZE_DIFFERENCES(844, "Ad size differences.");
        
        private final int code;
        private final String message;

        private NendError(int i, String str) {
            this.code = i;
            this.message = str;
        }

        public String getMessage() {
            return this.message;
        }

        public int getCode() {
            return this.code;
        }
    }

    static /* synthetic */ int[] $SWITCH_TABLE$net$nend$android$AdParameter$ViewType() {
        int[] iArr = $SWITCH_TABLE$net$nend$android$AdParameter$ViewType;
        if (iArr == null) {
            iArr = new int[ViewType.values().length];
            try {
                iArr[ViewType.ADVIEW.ordinal()] = 2;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[ViewType.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[ViewType.WEBVIEW.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            $SWITCH_TABLE$net$nend$android$AdParameter$ViewType = iArr;
        }
        return iArr;
    }

    static {
        $assertionsDisabled = !NendAdView.class.desiredAssertionStatus();
    }

    public NendAdView(Context context, int i, String str) {
        super(context, null, 0);
        this.mDensity = 1.0f;
        this.mAd = null;
        this.mController = null;
        this.mListener = null;
        this.mHasWindowFocus = false;
        this.mLayout = null;
        this.mOptOutImageView = null;
        this.mWebView = null;
        this.mIsClicked = false;
        init(context, i, str);
    }

    public NendAdView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NendAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mDensity = 1.0f;
        this.mAd = null;
        this.mController = null;
        this.mListener = null;
        this.mHasWindowFocus = false;
        this.mLayout = null;
        this.mOptOutImageView = null;
        this.mWebView = null;
        this.mIsClicked = false;
        if (attributeSet == null) {
            throw new NullPointerException(NendStatus.ERR_INVALID_ATTRIBUTE_SET.getMsg());
        }
        init(context, Integer.parseInt(attributeSet.getAttributeValue(null, Attribute.SPOT_ID.getName())), attributeSet.getAttributeValue(null, Attribute.API_KEY.getName()));
        if (!attributeSet.getAttributeBooleanValue(null, Attribute.RELOADABLE.getName(), true)) {
            pause();
        }
        loadAd();
    }

    @SuppressLint({"NewApi"})
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        deallocateField();
        init(getContext(), this.mSpotId, this.mApiKey);
        loadAd();
    }

    private void init(Context context, int i, String str) {
        if (i <= 0) {
            throw new IllegalArgumentException(NendStatus.ERR_INVALID_SPOT_ID.getMsg("spot id : " + i));
        } else if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException(NendStatus.ERR_INVALID_API_KEY.getMsg("api key : " + str));
        } else {
            NendHelper.setDebuggable(context);
            this.mMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(this.mMetrics);
            this.mDensity = this.mMetrics.density;
            this.mSpotId = i;
            this.mApiKey = str;
            this.mAd = new NendAd(context, i, str, this.mMetrics);
            this.mAd.setListener(this);
            this.mController = new NendAdController(this.mAd);
            this.mViewSwitcher = new NendAdViewSwitcher(getContext());
        }
    }

    public void loadAd() {
        restartController();
        this.mController.requestAd();
    }

    public void setListener(NendAdListener nendAdListener) {
        this.mListener = nendAdListener;
    }

    public void removeListener() {
        this.mListener = null;
    }

    public void resume() {
        NendLog.m5584d("resume!");
        restartController();
        this.mController.setReloadable(true);
        if (this.mAd.getViewType() == ViewType.WEBVIEW) {
            setWebView();
        }
    }

    public void pause() {
        NendLog.m5584d("pause!");
        restartController();
        this.mController.setReloadable(false);
        if (this.mAd.getViewType() == ViewType.WEBVIEW) {
            deallocateWebView();
        }
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mAd == null) {
            this.mAd = new NendAd(getContext(), this.mSpotId, this.mApiKey, this.mMetrics);
            this.mAd.setListener(this);
            this.mController = new NendAdController(this.mAd);
            loadAd();
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            this.mController.onWindowFocusChanged(true);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        NendLog.m5584d("onWindowFocusChanged!" + String.valueOf(z));
        super.onWindowFocusChanged(z);
        this.mHasWindowFocus = z;
        if (this.mController != null) {
            this.mController.onWindowFocusChanged(z);
            if (z && this.mIsClicked) {
                this.mIsClicked = false;
                if (this.mListener != null) {
                    this.mListener.onDismissScreen(this);
                }
            }
        }
    }

    public void onReceiveAd() {
        NendLog.m5584d("onReceive!");
        if (!$assertionsDisabled && this.mAd == null) {
            throw new AssertionError();
        } else if (!isDeallocate()) {
            this.mNendError = null;
            if (getWidth() == 0 || getHeight() == 0 || isShown()) {
                switch ($SWITCH_TABLE$net$nend$android$AdParameter$ViewType()[this.mAd.getViewType().ordinal()]) {
                    case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                        this.mViewSwitcher.download(this.mAd, this);
                        return;
                    case SendException.ERROR_TTL_EXCEEDED /*3*/:
                        if (this.mHasWindowFocus) {
                            setWebView();
                        }
                        if (this.mListener != null) {
                            this.mListener.onReceiveAd(this);
                            return;
                        }
                        return;
                    default:
                        onFailedToReceiveAd(NendError.INVALID_RESPONSE_TYPE);
                        return;
                }
            }
            this.mController.onWindowFocusChanged(false);
        }
    }

    public void onFailedToReceiveAd(NendError nendError) {
        NendLog.m5584d("onFailedToReceive!");
        if (!$assertionsDisabled && this.mController == null) {
            throw new AssertionError();
        } else if (!isDeallocate() && this.mController != null) {
            if (!this.mController.reloadAd()) {
                NendLog.m5584d("Failed to reload.");
            }
            if (this.mListener != null) {
                this.mNendError = nendError;
                this.mListener.onFailedToReceiveAd(this);
            }
        }
    }

    private boolean isSizeAppropriate(int i, int i2) {
        int height = this.mAd.getHeight();
        int width = this.mAd.getWidth();
        if (i == 320 && i2 == 48) {
            i2 = 50;
        }
        return (height == i2 && width == i) || (height * 2 == i2 && width * 2 == i);
    }

    private void initAdView() {
        removeAllViews();
        deallocateWebView();
        LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (((float) this.mAd.getWidth()) * this.mDensity), (int) (((float) this.mAd.getHeight()) * this.mDensity));
        if (this.mLayout == null || this.mOptOutImageView == null || !this.mOptOutImageView.hasDrawable()) {
            this.mLayout = new RelativeLayout(getContext());
            this.mLayout.addView(this.mViewSwitcher, layoutParams);
            this.mOptOutImageView = new OptOutImageView(getContext(), this.mAd.getUid(), this.mSpotId);
            LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams2.addRule(11);
            this.mLayout.addView(this.mOptOutImageView, layoutParams2);
        }
        this.mOptOutImageView.bringToFront();
        addView(this.mLayout, layoutParams);
    }

    private void setWebView() {
        if ($assertionsDisabled || this.mAd != null) {
            removeAllViews();
            deallocateAdView();
            this.mWebView = new NendAdWebView(getContext());
            addView(this.mWebView, new RelativeLayout.LayoutParams((int) (((float) this.mAd.getWidth()) * this.mDensity), (int) (((float) this.mAd.getHeight()) * this.mDensity)));
            this.mWebView.loadUrl(this.mAd.getWebViewUrl());
            return;
        }
        throw new AssertionError();
    }

    protected void onDetachedFromWindow() {
        NendLog.m5584d("onDetachedFromWindow!");
        deallocateField();
        super.onDetachedFromWindow();
    }

    private void deallocateField() {
        deallocateController();
        deallocateAd();
        removeListener();
        deallocateChildView();
    }

    private void deallocateController() {
        if (this.mController != null) {
            this.mController.cancelRequest();
            this.mController = null;
        }
    }

    private void deallocateAd() {
        if (this.mAd != null) {
            this.mAd.removeListener();
            this.mAd = null;
        }
    }

    private void deallocateChildView() {
        removeAllViews();
        deallocateAdView();
        deallocateWebView();
    }

    private void deallocateAdView() {
        if (this.mLayout != null) {
            this.mLayout.removeAllViews();
            this.mLayout = null;
        }
        if (this.mOptOutImageView != null) {
            this.mOptOutImageView.setImageDrawable(null);
            this.mOptOutImageView.deallocateImage();
            this.mOptOutImageView = null;
        }
        if (this.mViewSwitcher != null) {
            this.mViewSwitcher.abort();
        }
    }

    private void deallocateWebView() {
        if (this.mWebView != null) {
            this.mWebView.stopLoading();
            this.mWebView.getSettings().setJavaScriptEnabled(false);
            this.mWebView.setWebChromeClient(null);
            this.mWebView.setWebViewClient(null);
            removeView(this.mWebView);
            this.mWebView.removeAllViews();
            this.mWebView.destroy();
            this.mWebView = null;
        }
    }

    boolean hasView(View view) {
        if (indexOfChild(view) >= 0) {
            return true;
        }
        return false;
    }

    private boolean isDeallocate() {
        return this.mAd == null;
    }

    private void restartController() {
        if (this.mController == null) {
            if (this.mAd == null) {
                this.mAd = new NendAd(getContext(), this.mSpotId, this.mApiKey, this.mMetrics);
                this.mAd.setListener(this);
            }
            this.mController = new NendAdController(this.mAd);
        }
    }

    public NendError getNendError() {
        return this.mNendError;
    }

    public boolean onValidation(int i, int i2) {
        if (isDeallocate()) {
            return false;
        }
        if (isSizeAppropriate(i, i2)) {
            return true;
        }
        onFailedToReceiveAd(NendError.AD_SIZE_DIFFERENCES);
        return false;
    }

    public void onClickAd() {
        this.mIsClicked = true;
        if (this.mListener != null) {
            this.mListener.onClick(this);
        }
    }

    public void onSuccess() {
        if (this.mController != null && this.mAd != null) {
            initAdView();
            this.mController.reloadAd();
            if (this.mListener != null) {
                this.mListener.onReceiveAd(this);
            }
        }
    }

    public void onFailure() {
        onFailedToReceiveAd(NendError.FAILED_AD_DOWNLOAD);
    }
}
