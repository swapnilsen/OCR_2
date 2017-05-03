package com.google.android.gms.tagmanager;

import com.google.android.gms.common.util.zze;
import com.google.android.gms.common.util.zzi;

class zzda implements zzcl {
    private final long zzagm;
    private final int zzagn;
    private double zzago;
    private final Object zzagq;
    private long zzbHZ;
    private final zze zzuP;

    public zzda() {
        this(60, 2000);
    }

    public zzda(int i, long j) {
        this.zzagq = new Object();
        this.zzagn = i;
        this.zzago = (double) this.zzagn;
        this.zzagm = j;
        this.zzuP = zzi.zzzc();
    }

    public boolean zzpV() {
        boolean z;
        synchronized (this.zzagq) {
            long currentTimeMillis = this.zzuP.currentTimeMillis();
            if (this.zzago < ((double) this.zzagn)) {
                double d = ((double) (currentTimeMillis - this.zzbHZ)) / ((double) this.zzagm);
                if (d > 0.0d) {
                    this.zzago = Math.min((double) this.zzagn, d + this.zzago);
                }
            }
            this.zzbHZ = currentTimeMillis;
            if (this.zzago >= 1.0d) {
                this.zzago -= 1.0d;
                z = true;
            } else {
                zzbo.zzbh("No more tokens available.");
                z = false;
            }
        }
        return z;
    }
}
