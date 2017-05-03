package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;

@zzme
@TargetApi(11)
public class zzre extends zzrg {
    public zzre(zzqw com_google_android_gms_internal_zzqw, boolean z) {
        super(com_google_android_gms_internal_zzqw, z);
    }

    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        return zza(webView, str, null);
    }
}
