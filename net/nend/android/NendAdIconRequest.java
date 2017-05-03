package net.nend.android;

import android.content.Context;
import android.net.Uri.Builder;

public class NendAdIconRequest extends AbsNendAdRequest {
    private int mRequestCount;

    NendAdIconRequest(Context context, int i, String str) {
        super(context, i, str);
    }

    String getDomain() {
        return "ad3.nend.net";
    }

    String getPath() {
        return "nia.php";
    }

    String buildRequestUrl(String str) {
        return new Builder().scheme(this.mProtocol).authority(this.mDomain).path(this.mPath).appendQueryParameter("apikey", this.mApiKey).appendQueryParameter("spot", String.valueOf(this.mSpotId)).appendQueryParameter("uid", str).appendQueryParameter("os", getOS()).appendQueryParameter("version", getVersion()).appendQueryParameter("model", getModel()).appendQueryParameter("device", getDevice()).appendQueryParameter("localize", getLocale()).appendQueryParameter("sdkver", getSDKVersion()).appendQueryParameter("ad_num", String.valueOf(getRequestCount())).appendQueryParameter("gaid", getAdvertisingId()).toString();
    }

    void setRequestCount(int i) {
        this.mRequestCount = i;
    }

    int getRequestCount() {
        return this.mRequestCount;
    }
}
