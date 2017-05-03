package net.nend.android;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.support.v4.view.PointerIconCompat;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import net.nend.android.NendAdInterstitial.NendAdInterstitialClickType;
import net.nend.android.NendAdInterstitial.NendAdInterstitialShowResult;
import net.nend.android.NendAdInterstitial.NendAdInterstitialStatusCode;

public class NendAdInterstitialView extends RelativeLayout implements android.view.View.OnClickListener, CompleationListener, OnAdClickListener {
    private static OnClickListener mClickListener;
    private static OnCompleationListener mCompleationListener;
    private final int WP;
    private boolean isFinishAd;
    private boolean isShown;
    private Activity mActivity;
    private ImageView mCloseView;
    private float mDensity;
    private LayoutParams mLandscapeCloseParams;
    private LayoutParams mLandscapeContainerParams;
    private NendAdInterstitialWebView mLandscapeWebView;
    private WindowManager.LayoutParams mParams;
    private LayoutParams mPortraitCloseParams;
    private LayoutParams mPortraitContainerParams;
    private NendAdInterstitialWebView mPortraitWebView;
    private RelativeLayout mRelativeLayout;
    private WindowManager mWindowManager;

    interface OnClickListener {
        void onClick(NendAdInterstitialClickType nendAdInterstitialClickType);
    }

    interface OnCompleationListener {
        void onCompleation(NendAdInterstitialStatusCode nendAdInterstitialStatusCode);
    }

    /* renamed from: net.nend.android.NendAdInterstitialView.1 */
    class C16431 implements android.view.View.OnClickListener {
        C16431() {
        }

        public void onClick(View view) {
            NendAdInterstitialView.this.dissmiss();
            if (NendAdInterstitialView.this.isFinishAd) {
                if (NendAdInterstitialView.mClickListener != null) {
                    NendAdInterstitialView.mClickListener.onClick(NendAdInterstitialClickType.EXIT);
                }
            } else if (NendAdInterstitialView.mClickListener != null) {
                NendAdInterstitialView.mClickListener.onClick(NendAdInterstitialClickType.CLOSE);
            }
        }
    }

    @SuppressLint({"InlinedApi"})
    public NendAdInterstitialView(Context context, NendAdInterstitialResponse nendAdInterstitialResponse) {
        super(context);
        this.WP = -2;
        this.isShown = false;
        this.isFinishAd = false;
        this.mDensity = getResources().getDisplayMetrics().density;
        int i = getResources().getConfiguration().orientation;
        this.mParams = new WindowManager.LayoutParams();
        this.mParams.gravity = 17;
        this.mParams.height = -1;
        this.mParams.width = -1;
        this.mParams.format = 1;
        this.mParams.type = PointerIconCompat.TYPE_HELP;
        this.mParams.flags = 262176;
        int portraitWidth = (int) (((float) nendAdInterstitialResponse.getPortraitWidth()) * this.mDensity);
        int portraitHeight = (int) (((float) nendAdInterstitialResponse.getPortraitHeight()) * this.mDensity);
        int landscapeWidth = (int) (((float) nendAdInterstitialResponse.getLandscapeWidth()) * this.mDensity);
        int landscapeHeight = (int) (((float) nendAdInterstitialResponse.getLandscapeHeight()) * this.mDensity);
        if (portraitWidth == 0 || portraitHeight == 0 || landscapeWidth == 0 || landscapeHeight == 0) {
            throw new IllegalArgumentException(NendStatus.ERR_INVALID_RESPONSE.getMsg());
        }
        LayoutParams layoutParams = new LayoutParams(portraitWidth, portraitHeight);
        layoutParams.addRule(13);
        this.mPortraitWebView = new NendAdInterstitialWebView(context, layoutParams);
        this.mPortraitWebView.setOnCompleationListener(this);
        this.mPortraitWebView.setOnAdClickListener(this);
        layoutParams = new LayoutParams(landscapeWidth, landscapeHeight);
        layoutParams.addRule(13);
        this.mLandscapeWebView = new NendAdInterstitialWebView(context, layoutParams);
        this.mLandscapeWebView.setOnCompleationListener(this);
        this.mLandscapeWebView.setOnAdClickListener(this);
        this.mPortraitCloseParams = new LayoutParams(-2, -2);
        this.mPortraitCloseParams.addRule(11);
        this.mLandscapeCloseParams = new LayoutParams(-2, -2);
        this.mLandscapeCloseParams.addRule(11);
        Bitmap loadAssets = NendHelper.loadAssets(getContext(), "nend_button_cancel.png");
        this.mCloseView = new ImageView(getContext());
        this.mCloseView.setImageBitmap(loadAssets);
        this.mCloseView.setOnClickListener(new C16431());
        int width = (loadAssets.getWidth() * 2) / 3;
        this.mPortraitContainerParams = new LayoutParams(portraitWidth + width, portraitHeight + width);
        this.mPortraitContainerParams.addRule(13);
        this.mLandscapeContainerParams = new LayoutParams((loadAssets.getWidth() * 2) + landscapeWidth, landscapeHeight);
        this.mLandscapeContainerParams.addRule(13);
        this.mRelativeLayout = new RelativeLayout(getContext());
        setBackgroundColor(Color.parseColor("#90000000"));
        setFocusable(true);
        setFocusableInTouchMode(true);
        setOnClickListener(this);
        setOrientation(i);
        this.mRelativeLayout.addView(this.mPortraitWebView, 0);
        this.mRelativeLayout.addView(this.mLandscapeWebView, 1);
        this.mRelativeLayout.addView(this.mCloseView, 2);
        addView(this.mRelativeLayout);
    }

    public void onClick(View view) {
        if (mClickListener != null) {
            mClickListener.onClick(NendAdInterstitialClickType.CLOSE);
        }
        dissmiss();
    }

    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        setOrientation(configuration.orientation);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4) {
            return super.dispatchKeyEvent(keyEvent);
        }
        if (mClickListener != null) {
            mClickListener.onClick(NendAdInterstitialClickType.CLOSE);
        }
        dissmiss();
        return true;
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (!z) {
            if (mClickListener != null) {
                mClickListener.onClick(NendAdInterstitialClickType.CLOSE);
            }
            dissmiss();
        }
    }

    private void loadCompleation() {
        if (this.mPortraitWebView.getStatusCode() != WebViewStatus.INCOMPLETE && this.mLandscapeWebView.getStatusCode() != WebViewStatus.INCOMPLETE && mCompleationListener != null) {
            if (this.mPortraitWebView.getStatusCode() == WebViewStatus.SUCCESS && this.mLandscapeWebView.getStatusCode() == WebViewStatus.SUCCESS) {
                mCompleationListener.onCompleation(NendAdInterstitialStatusCode.SUCCESS);
            } else {
                mCompleationListener.onCompleation(NendAdInterstitialStatusCode.FAILED_AD_DOWNLOAD);
            }
        }
    }

    private void setOrientation(int i) {
        ViewGroup.LayoutParams layoutParams;
        ViewGroup.LayoutParams layoutParams2;
        if (i == 1) {
            layoutParams = this.mPortraitContainerParams;
            layoutParams2 = this.mPortraitCloseParams;
            this.mLandscapeWebView.setVisibility(8);
            this.mPortraitWebView.setVisibility(0);
        } else {
            layoutParams = this.mLandscapeContainerParams;
            layoutParams2 = this.mLandscapeCloseParams;
            this.mPortraitWebView.setVisibility(8);
            this.mLandscapeWebView.setVisibility(0);
        }
        this.mCloseView.setLayoutParams(layoutParams2);
        this.mRelativeLayout.setLayoutParams(layoutParams);
        this.mRelativeLayout.invalidate();
    }

    public boolean show(Activity activity, boolean z) {
        this.mActivity = activity;
        this.mWindowManager = (WindowManager) activity.getSystemService("window");
        try {
            this.mWindowManager.addView(this, this.mParams);
            setOrientation(getResources().getConfiguration().orientation);
            this.isFinishAd = z;
            this.isShown = true;
            return true;
        } catch (Throwable e) {
            NendLog.m5594e("The context which NendAdInterstitialView has is already die.", e);
            return false;
        }
    }

    public boolean dissmiss() {
        if (!this.isShown) {
            return false;
        }
        try {
            this.mWindowManager.removeView(this);
            this.isShown = false;
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    public boolean isShown() {
        return this.isShown;
    }

    public void load(String str) {
        this.mPortraitWebView.load(new StringBuilder(String.valueOf(str)).append(1).toString());
        this.mLandscapeWebView.load(new StringBuilder(String.valueOf(str)).append(2).toString());
    }

    public boolean isStanby() {
        int i = getResources().getConfiguration().orientation;
        if (i == 1 && this.mPortraitWebView.getStatusCode() == WebViewStatus.SUCCESS) {
            return true;
        }
        if (i == 2 && this.mLandscapeWebView.getStatusCode() == WebViewStatus.SUCCESS) {
            return true;
        }
        return false;
    }

    public NendAdInterstitialShowResult getStatus() {
        if (this.mPortraitWebView.getStatusCode() == WebViewStatus.FAILD || this.mLandscapeWebView.getStatusCode() == WebViewStatus.FAILD) {
            return NendAdInterstitialShowResult.AD_DOWNLOAD_INCOMPLETE;
        }
        return NendAdInterstitialShowResult.AD_LOAD_INCOMPLETE;
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        mClickListener = onClickListener;
    }

    public void setOnCompleationListener(OnCompleationListener onCompleationListener) {
        mCompleationListener = onCompleationListener;
    }

    public void onCompleation() {
        loadCompleation();
    }

    public void onError() {
        loadCompleation();
    }

    public void onClick(NendAdInterstitialClickType nendAdInterstitialClickType, String str) {
        if (!(mClickListener == null || str.startsWith("http://nend.net/privacy/optsdkgate"))) {
            mClickListener.onClick(nendAdInterstitialClickType);
        }
        if (!TextUtils.isEmpty(str)) {
            this.mActivity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
        }
    }
}
