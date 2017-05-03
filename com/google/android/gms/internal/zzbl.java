package com.google.android.gms.internal;

import com.google.android.gms.internal.zzag.zza;

public class zzbl extends zzca {
    public zzbl(zzbd com_google_android_gms_internal_zzbd, String str, String str2, zza com_google_android_gms_internal_zzag_zza, int i, int i2) {
        super(com_google_android_gms_internal_zzbd, str, str2, com_google_android_gms_internal_zzag_zza, i, i2);
    }

    protected void zzbd() {
        this.zzqV.zzbe = Long.valueOf(-1);
        this.zzqV.zzbf = Long.valueOf(-1);
        int[] iArr = (int[]) this.zzre.invoke(null, new Object[]{this.zzpz.getContext()});
        synchronized (this.zzqV) {
            this.zzqV.zzbe = Long.valueOf((long) iArr[0]);
            this.zzqV.zzbf = Long.valueOf((long) iArr[1]);
        }
    }
}
