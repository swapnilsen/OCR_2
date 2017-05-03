package net.nend.android;

import android.content.Context;
import android.net.Uri.Builder;

public class NendAdRequest extends AbsNendAdRequest {
    public NendAdRequest(Context context, int i, String str) {
        super(context, i, str);
    }

    String getDomain() {
        return "ad1.nend.net";
    }

    String getPath() {
        return "na.php";
    }

    String buildRequestUrl(String str) {
        return new Builder().scheme(this.mProtocol).authority(this.mDomain).path(this.mPath).appendQueryParameter("apikey", this.mApiKey).appendQueryParameter("spot", String.valueOf(this.mSpotId)).appendQueryParameter("uid", str).appendQueryParameter("os", getOS()).appendQueryParameter("version", getVersion()).appendQueryParameter("model", getModel()).appendQueryParameter("device", getDevice()).appendQueryParameter("localize", getLocale()).appendQueryParameter("sdkver", getSDKVersion()).appendQueryParameter("gaid", getAdvertisingId()).toString();
    }
}
