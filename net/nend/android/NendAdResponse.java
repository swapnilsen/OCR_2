package net.nend.android;

import android.text.TextUtils;
import com.google.firebase.messaging.SendException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import net.nend.android.AdParameter.ViewType;

final class NendAdResponse implements AdParameter {
    private static /* synthetic */ int[] $SWITCH_TABLE$net$nend$android$AdParameter$ViewType;
    private final String mAdId;
    private final String mClickUrl;
    private final int mHeight;
    private final String mIconId;
    private final String mImageUrl;
    private final boolean mIsAnimationGif;
    private final int mReloadIntervalInSeconds;
    private final String mTitleText;
    private final ViewType mViewType;
    private final String mWebViewUrl;
    private final int mWidth;

    static final class Builder {
        static final /* synthetic */ boolean $assertionsDisabled;
        private String mAdId;
        private String mClickUrl;
        private int mHeight;
        private String mIconId;
        private String mImageUrl;
        private boolean mIsAnimationGif;
        private int mReloadIntervalInSeconds;
        private String mTitleText;
        private ViewType mViewType;
        private String mWebViewUrl;
        private int mWidth;

        static {
            $assertionsDisabled = !NendAdResponse.class.desiredAssertionStatus();
        }

        Builder() {
            this.mViewType = ViewType.NONE;
            this.mIsAnimationGif = false;
        }

        Builder setViewType(ViewType viewType) {
            if ($assertionsDisabled || viewType != null) {
                this.mViewType = viewType;
                return this;
            }
            throw new AssertionError();
        }

        Builder setImageUrl(String str) {
            if (str != null) {
                this.mImageUrl = str.replaceAll(" ", "%20");
            } else {
                this.mImageUrl = null;
            }
            return this;
        }

        Builder setClickUrl(String str) {
            if (str != null) {
                this.mClickUrl = str.replaceAll(" ", "%20");
            } else {
                this.mClickUrl = null;
            }
            return this;
        }

        Builder setWebViewUrl(String str) {
            if (str != null) {
                this.mWebViewUrl = str.replaceAll(" ", "%20");
            } else {
                this.mWebViewUrl = null;
            }
            return this;
        }

        Builder setTitleText(String str) {
            this.mTitleText = str;
            return this;
        }

        Builder setReloadIntervalInSeconds(int i) {
            this.mReloadIntervalInSeconds = i;
            return this;
        }

        Builder setHeight(int i) {
            this.mHeight = i;
            return this;
        }

        Builder setWidth(int i) {
            this.mWidth = i;
            return this;
        }

        Builder setIconId(String str) {
            this.mIconId = str;
            return this;
        }

        Builder setAdId(String str) {
            this.mAdId = str;
            return this;
        }

        Builder setAnimationGifFlag(String str) {
            this.mIsAnimationGif = "1".equals(str);
            return this;
        }

        NendAdResponse build() {
            return new NendAdResponse();
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

    private NendAdResponse(Builder builder) {
        switch ($SWITCH_TABLE$net$nend$android$AdParameter$ViewType()[builder.mViewType.ordinal()]) {
            case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                if (TextUtils.isEmpty(builder.mImageUrl)) {
                    throw new IllegalArgumentException("Image url is invalid.");
                } else if (TextUtils.isEmpty(builder.mClickUrl)) {
                    throw new IllegalArgumentException("Click url is invalid");
                } else {
                    this.mViewType = ViewType.ADVIEW;
                    this.mImageUrl = builder.mImageUrl;
                    this.mClickUrl = builder.mClickUrl;
                    this.mWebViewUrl = null;
                    this.mTitleText = builder.mTitleText;
                    this.mReloadIntervalInSeconds = builder.mReloadIntervalInSeconds;
                    this.mHeight = builder.mHeight;
                    this.mWidth = builder.mWidth;
                    this.mIconId = builder.mIconId;
                    this.mAdId = builder.mAdId;
                    this.mIsAnimationGif = builder.mIsAnimationGif;
                }
            case SendException.ERROR_TTL_EXCEEDED /*3*/:
                if (TextUtils.isEmpty(builder.mWebViewUrl)) {
                    throw new IllegalArgumentException("Web view url is invalid");
                }
                this.mViewType = ViewType.WEBVIEW;
                this.mImageUrl = null;
                this.mClickUrl = null;
                this.mWebViewUrl = builder.mWebViewUrl;
                this.mTitleText = null;
                this.mReloadIntervalInSeconds = 0;
                this.mHeight = builder.mHeight;
                this.mWidth = builder.mWidth;
                this.mIconId = null;
                this.mAdId = null;
                this.mIsAnimationGif = false;
            default:
                throw new IllegalArgumentException("Uknown view type.");
        }
    }

    public ViewType getViewType() {
        return this.mViewType;
    }

    public String getImageUrl() {
        return this.mImageUrl;
    }

    public String getClickUrl() {
        return this.mClickUrl;
    }

    public String getWebViewUrl() {
        return this.mWebViewUrl;
    }

    public String getTitleText() {
        return this.mTitleText;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getReloadIntervalInSeconds() {
        return this.mReloadIntervalInSeconds;
    }

    public String getIconId() {
        return this.mIconId;
    }

    public String getAdId() {
        return this.mAdId;
    }

    public boolean isAnimationGif() {
        return this.mIsAnimationGif;
    }
}
