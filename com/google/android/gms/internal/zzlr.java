package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.internal.zzqx.zza;

@zzme
public class zzlr extends zzlo implements zza {
    zzlr(Context context, zzpb.zza com_google_android_gms_internal_zzpb_zza, zzqw com_google_android_gms_internal_zzqw, zzlq.zza com_google_android_gms_internal_zzlq_zza) {
        super(context, com_google_android_gms_internal_zzpb_zza, com_google_android_gms_internal_zzqw, com_google_android_gms_internal_zzlq_zza);
    }

    protected void zziO() {
        if (this.zzPS.errorCode == -2) {
            this.zzIs.zzlv().zza((zza) this);
            zziQ();
            zzqf.zzbf("Loading HTML in WebView.");
            this.zzIs.loadDataWithBaseURL(this.zzPS.zzNJ, this.zzPS.body, "text/html", "UTF-8", null);
        }
    }

    protected void zziQ() {
    }
}
