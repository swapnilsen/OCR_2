package com.google.android.gms.internal;

import com.google.android.gms.internal.zzag.zza;

public class zzbn extends zzca {
    private long startTime;

    public zzbn(zzbd com_google_android_gms_internal_zzbd, String str, String str2, zza com_google_android_gms_internal_zzag_zza, long j, int i, int i2) {
        super(com_google_android_gms_internal_zzbd, str, str2, com_google_android_gms_internal_zzag_zza, i, i2);
        this.startTime = j;
    }

    protected void zzbd() {
        long longValue = ((Long) this.zzre.invoke(null, new Object[0])).longValue();
        synchronized (this.zzqV) {
            this.zzqV.zzca = Long.valueOf(longValue);
            if (this.startTime != 0) {
                this.zzqV.zzbq = Long.valueOf(longValue - this.startTime);
                this.zzqV.zzbv = Long.valueOf(this.startTime);
            }
        }
    }
}
