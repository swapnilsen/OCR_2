package com.google.android.gms.internal;

import com.google.android.gms.internal.zzag.zza;

public class zzbv extends zzca {
    public zzbv(zzbd com_google_android_gms_internal_zzbd, String str, String str2, zza com_google_android_gms_internal_zzag_zza, int i, int i2) {
        super(com_google_android_gms_internal_zzbd, str, str2, com_google_android_gms_internal_zzag_zza, i, i2);
    }

    protected void zzbd() {
        synchronized (this.zzqV) {
            zzbc com_google_android_gms_internal_zzbc = new zzbc((String) this.zzre.invoke(null, new Object[0]));
            this.zzqV.zzbM = com_google_android_gms_internal_zzbc.zzql;
            this.zzqV.zzbN = com_google_android_gms_internal_zzbc.zzqm;
        }
    }
}
