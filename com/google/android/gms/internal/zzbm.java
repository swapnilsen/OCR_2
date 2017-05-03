package com.google.android.gms.internal;

import com.google.android.gms.internal.zzag.zza;

public class zzbm extends zzca {
    private static volatile Long zzbI;
    private static final Object zzqS;

    static {
        zzbI = null;
        zzqS = new Object();
    }

    public zzbm(zzbd com_google_android_gms_internal_zzbd, String str, String str2, zza com_google_android_gms_internal_zzag_zza, int i, int i2) {
        super(com_google_android_gms_internal_zzbd, str, str2, com_google_android_gms_internal_zzag_zza, i, i2);
    }

    protected void zzbd() {
        if (zzbI == null) {
            synchronized (zzqS) {
                if (zzbI == null) {
                    zzbI = (Long) this.zzre.invoke(null, new Object[0]);
                }
            }
        }
        synchronized (this.zzqV) {
            this.zzqV.zzbI = zzbI;
        }
    }
}
