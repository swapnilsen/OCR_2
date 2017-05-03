package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.view.View;
import android.webkit.WebChromeClient.CustomViewCallback;

@zzme
@TargetApi(14)
public final class zzrf extends zzrd {
    public zzrf(zzqw com_google_android_gms_internal_zzqw) {
        super(com_google_android_gms_internal_zzqw);
    }

    public void onShowCustomView(View view, int i, CustomViewCallback customViewCallback) {
        zza(view, i, customViewCallback);
    }
}
