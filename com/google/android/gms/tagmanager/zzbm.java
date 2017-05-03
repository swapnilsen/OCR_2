package com.google.android.gms.tagmanager;

import com.google.android.gms.common.util.zze;

class zzbm implements zzcl {
    private final String zzadb;
    private final long zzagm;
    private final int zzagn;
    private double zzago;
    private long zzagp;
    private final Object zzagq;
    private final long zzbGH;
    private final zze zzuP;

    public zzbm(int i, int i2, long j, long j2, String str, zze com_google_android_gms_common_util_zze) {
        this.zzagq = new Object();
        this.zzagn = i2;
        this.zzago = (double) Math.min(i, i2);
        this.zzagm = j;
        this.zzbGH = j2;
        this.zzadb = str;
        this.zzuP = com_google_android_gms_common_util_zze;
    }

    public boolean zzpV() {
        boolean z = false;
        synchronized (this.zzagq) {
            long currentTimeMillis = this.zzuP.currentTimeMillis();
            String str;
            if (currentTimeMillis - this.zzagp < this.zzbGH) {
                str = this.zzadb;
                zzbo.zzbh(new StringBuilder(String.valueOf(str).length() + 34).append("Excessive ").append(str).append(" detected; call ignored.").toString());
            } else {
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
                    str = this.zzadb;
                    zzbo.zzbh(new StringBuilder(String.valueOf(str).length() + 34).append("Excessive ").append(str).append(" detected; call ignored.").toString());
                }
            }
        }
        return z;
    }
}
