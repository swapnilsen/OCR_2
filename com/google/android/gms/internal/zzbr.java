package com.google.android.gms.internal;

import com.google.android.gms.internal.zzag.zza;

public class zzbr extends zzca {
    private long zzqX;

    public zzbr(zzbd com_google_android_gms_internal_zzbd, String str, String str2, zza com_google_android_gms_internal_zzag_zza, int i, int i2) {
        super(com_google_android_gms_internal_zzbd, str, str2, com_google_android_gms_internal_zzag_zza, i, i2);
        this.zzqX = -1;
    }

    protected void zzbd() {
        this.zzqV.zzbl = Long.valueOf(-1);
        if (this.zzqX == -1) {
            this.zzqX = (long) ((Integer) this.zzre.invoke(null, new Object[]{this.zzpz.getContext()})).intValue();
        }
        synchronized (this.zzqV) {
            this.zzqV.zzbl = Long.valueOf(this.zzqX);
        }
    }
}
