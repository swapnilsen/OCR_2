package net.nend.android;

import android.text.TextUtils;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.ArrayList;
import net.nend.android.AdParameter.ViewType;

final class NendAdIconResponse {
    private static /* synthetic */ int[] $SWITCH_TABLE$net$nend$android$AdParameter$ViewType;
    private ArrayList<AdParameter> mAdParameterList;
    private String mImpressionCountUrl;
    private String mMessage;
    private final int mReloadIntervalInSeconds;
    private int mStatusCode;
    private final ViewType mViewType;

    static final class Builder {
        static final /* synthetic */ boolean $assertionsDisabled;
        private ArrayList<AdParameter> mAdParameterList;
        private String mImpressionCountUrl;
        private String mMessage;
        private int mReloadIntervalInSeconds;
        private int mStatusCode;
        private ViewType mViewType;

        static {
            $assertionsDisabled = !NendAdIconResponse.class.desiredAssertionStatus();
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

        Builder setReloadIntervalInSeconds(int i) {
            this.mReloadIntervalInSeconds = i;
            return this;
        }

        Builder setStatusCode(int i) {
            this.mStatusCode = i;
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

        Builder setAdParameterList(ArrayList<AdParameter> arrayList) {
            this.mAdParameterList = arrayList;
            return this;
        }

        NendAdIconResponse build() {
            return new NendAdIconResponse();
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

    private NendAdIconResponse(Builder builder) {
        switch ($SWITCH_TABLE$net$nend$android$AdParameter$ViewType()[builder.mViewType.ordinal()]) {
            case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                if (TextUtils.isEmpty(builder.mImpressionCountUrl)) {
                    throw new IllegalArgumentException("ImpressionCount Url is invalid.");
                }
                this.mViewType = ViewType.ADVIEW;
                this.mReloadIntervalInSeconds = builder.mReloadIntervalInSeconds;
                this.mStatusCode = builder.mStatusCode;
                this.mMessage = builder.mMessage;
                this.mImpressionCountUrl = builder.mImpressionCountUrl;
                this.mAdParameterList = builder.mAdParameterList;
            default:
                throw new IllegalArgumentException("Unknown view type.");
        }
    }

    public ViewType getViewType() {
        return this.mViewType;
    }

    public int getReloadIntervalInSeconds() {
        return this.mReloadIntervalInSeconds;
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

    public ArrayList<AdParameter> getAdParameterList() {
        return this.mAdParameterList;
    }
}
