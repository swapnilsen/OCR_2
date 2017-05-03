package net.nend.android;

import android.text.TextUtils;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.ArrayList;
import net.nend.android.AdParameter.ViewType;
import net.nend.android.NendAdInterstitial.NendAdInterstitialStatusCode;

final class NendAdInterstitialResponse {
    private static /* synthetic */ int[] $SWITCH_TABLE$net$nend$android$AdParameter$ViewType;
    private String mAdId;
    private ArrayList<AdParameter> mAdParameterList;
    private NendAdInterstitialStatusCode mErrorCode;
    private int mFrequency;
    private String mImpressionCountUrl;
    private int mLandscapeHeight;
    private int mLandscapeWidth;
    private String mMessage;
    private int mPortraitHeight;
    private int mPortraitWidth;
    private String mRequestUrl;
    private int mStatusCode;
    private final ViewType mViewType;

    static final class Builder {
        static final /* synthetic */ boolean $assertionsDisabled;
        private String mAdId;
        private ArrayList<AdParameter> mAdParameterList;
        private NendAdInterstitialStatusCode mErrorCode;
        private int mFrequency;
        private String mImpressionCountUrl;
        private int mLandscapeHeight;
        private int mLandscapeWidth;
        private String mMessage;
        private int mPortraitHeight;
        private int mPortraitWidth;
        private String mRequestUrl;
        private int mStatusCode;
        private ViewType mViewType;

        static {
            $assertionsDisabled = !NendAdInterstitialResponse.class.desiredAssertionStatus();
        }

        Builder() {
            this.mViewType = ViewType.NONE;
        }

        Builder setViewType(ViewType viewType) {
            if ($assertionsDisabled || viewType != null) {
                this.mViewType = viewType;
                return this;
            }
            throw new AssertionError();
        }

        Builder setStatusCode(int i) {
            this.mStatusCode = i;
            return this;
        }

        Builder setAdId(String str) {
            this.mAdId = str;
            return this;
        }

        Builder setMessage(String str) {
            this.mMessage = str;
            return this;
        }

        Builder setImpressionCountUrl(String str) {
            if (str != null) {
                this.mImpressionCountUrl = str.replaceAll(" ", "%20");
            } else {
                this.mImpressionCountUrl = null;
            }
            return this;
        }

        Builder setRequestUrl(String str) {
            if (str != null) {
                this.mRequestUrl = str.replaceAll(" ", "%20");
            } else {
                this.mRequestUrl = null;
            }
            return this;
        }

        Builder setFrequency(int i) {
            this.mFrequency = i;
            return this;
        }

        Builder setAdParameterList(ArrayList<AdParameter> arrayList) {
            this.mAdParameterList = arrayList;
            return this;
        }

        Builder setErrorCode(NendAdInterstitialStatusCode nendAdInterstitialStatusCode) {
            this.mErrorCode = nendAdInterstitialStatusCode;
            return this;
        }

        Builder setPortraitWidth(int i) {
            this.mPortraitWidth = i;
            return this;
        }

        Builder setPortraitHeight(int i) {
            this.mPortraitHeight = i;
            return this;
        }

        Builder setLandscapeWidth(int i) {
            this.mLandscapeWidth = i;
            return this;
        }

        Builder setLandscapeHeight(int i) {
            this.mLandscapeHeight = i;
            return this;
        }

        NendAdInterstitialResponse build() {
            return new NendAdInterstitialResponse();
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

    private NendAdInterstitialResponse(Builder builder) {
        switch ($SWITCH_TABLE$net$nend$android$AdParameter$ViewType()[builder.mViewType.ordinal()]) {
            case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                if (builder.mErrorCode == null) {
                    if (TextUtils.isEmpty(builder.mImpressionCountUrl)) {
                        throw new IllegalArgumentException("ImpressionCount url is invalid.");
                    } else if (TextUtils.isEmpty(builder.mRequestUrl)) {
                        throw new IllegalArgumentException("Request url is invalid.");
                    }
                }
                this.mViewType = ViewType.ADVIEW;
                this.mStatusCode = builder.mStatusCode;
                this.mMessage = builder.mMessage;
                this.mImpressionCountUrl = builder.mImpressionCountUrl;
                this.mRequestUrl = builder.mRequestUrl;
                this.mFrequency = builder.mFrequency;
                this.mAdId = builder.mAdId;
                this.mAdParameterList = builder.mAdParameterList;
                this.mErrorCode = builder.mErrorCode;
                this.mPortraitWidth = builder.mPortraitWidth;
                this.mPortraitHeight = builder.mPortraitHeight;
                this.mLandscapeWidth = builder.mLandscapeWidth;
                this.mLandscapeHeight = builder.mLandscapeHeight;
            default:
                throw new IllegalArgumentException("Unknown view type.");
        }
    }

    public ViewType getViewType() {
        return this.mViewType;
    }

    public int getStatusCode() {
        return this.mStatusCode;
    }

    public String getMessage() {
        return this.mMessage;
    }

    public String getImpressionCountUrl() {
        return this.mImpressionCountUrl;
    }

    public String getRequestUrl() {
        return this.mRequestUrl;
    }

    public int getFrequency() {
        return this.mFrequency;
    }

    public String getAdId() {
        return this.mAdId;
    }

    public int getPortraitWidth() {
        return this.mPortraitWidth;
    }

    public int getPortraitHeight() {
        return this.mPortraitHeight;
    }

    public int getLandscapeWidth() {
        return this.mLandscapeWidth;
    }

    public int getLandscapeHeight() {
        return this.mLandscapeHeight;
    }

    public ArrayList<AdParameter> getAdParameterList() {
        return this.mAdParameterList;
    }

    public NendAdInterstitialStatusCode getErrorCode() {
        return this.mErrorCode;
    }
}
