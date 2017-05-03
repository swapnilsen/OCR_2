package com.google.android.gms.internal;

import com.google.android.gms.common.util.zze;

public class zztb {
    private final String zzadb;
    private final long zzagm;
    private final int zzagn;
    private double zzago;
    private long zzagp;
    private final Object zzagq;
    private final zze zzuP;

    public zztb(int i, long j, String str, zze com_google_android_gms_common_util_zze) {
        this.zzagq = new Object();
        this.zzagn = i;
        this.zzago = (double) this.zzagn;
        this.zzagm = j;
        this.zzadb = str;
        this.zzuP = com_google_android_gms_common_util_zze;
    }

    public zztb(String str, zze com_google_android_gms_common_util_zze) {
        this(60, 2000, str, com_google_android_gms_common_util_zze);
    }

    public boolean zzpV() {
        boolean z;
        synchronized (this.zzagq) {
            long currentTimeMillis = this.zzuP.currentTimeMillis();
            if (this.zzago < ((double) this.zzagn)) {
                double d = ((double) (currentTimeMillis - this.zzagp)) / ((double) this.zzagm);
                if (d > 0.0d) {
                    this.zzago = Math.min((double) this.zzagn, d + this.zzago);
                }
            }
            this.zzagp = currentTimeMillis;
            if (this.zzago >= 1.0d) {
                this.zzago -= 1.0d;
                z = true;
            } else {
                String str = this.zzadb;
                zztc.zzbh(new StringBuilder(String.valueOf(str).length() + 34).append("Excessive ").append(str).append(" detected; call ignored.").toString());
                z = false;
            }
        }
        return z;
    }
}
