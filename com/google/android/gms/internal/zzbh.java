package com.google.android.gms.internal;

import com.google.android.gms.internal.zzag.zza;

public class zzbh extends zzca {
    public zzbh(zzbd com_google_android_gms_internal_zzbd, String str, String str2, zza com_google_android_gms_internal_zzag_zza, int i, int i2) {
        super(com_google_android_gms_internal_zzbd, str, str2, com_google_android_gms_internal_zzag_zza, i, i2);
    }

    protected void zzbd() {
        synchronized (this.zzqV) {
            this.zzqV.zzbc = Long.valueOf(-1);
            this.zzqV.zzbc = (Long) this.zzre.invoke(null, new Object[]{this.zzpz.getContext()});
        }
    }
}
