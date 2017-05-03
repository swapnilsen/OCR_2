package com.google.android.gms.internal;

import com.google.android.gms.internal.zzag.zza;

public class zzbu extends zzca {
    private final StackTraceElement[] zzqZ;

    public zzbu(zzbd com_google_android_gms_internal_zzbd, String str, String str2, zza com_google_android_gms_internal_zzag_zza, int i, int i2, StackTraceElement[] stackTraceElementArr) {
        super(com_google_android_gms_internal_zzbd, str, str2, com_google_android_gms_internal_zzag_zza, i, i2);
        this.zzqZ = stackTraceElementArr;
    }

    protected void zzbd() {
        if (this.zzqZ != null) {
            zzbb com_google_android_gms_internal_zzbb = new zzbb((String) this.zzre.invoke(null, new Object[]{this.zzqZ}));
            synchronized (this.zzqV) {
                this.zzqV.zzbJ = com_google_android_gms_internal_zzbb.zzqi;
                if (com_google_android_gms_internal_zzbb.zzqj.booleanValue()) {
                    this.zzqV.zzbR = Integer.valueOf(com_google_android_gms_internal_zzbb.zzqk.booleanValue() ? 0 : 1);
                }
            }
        }
    }
}
