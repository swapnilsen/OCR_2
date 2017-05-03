package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.zzw;

@zzme
public class zzpz {
    private long zzYE;
    private long zzYF;
    private Object zzrJ;

    public zzpz(long j) {
        this.zzYF = Long.MIN_VALUE;
        this.zzrJ = new Object();
        this.zzYE = j;
    }

    public boolean tryAcquire() {
        boolean z;
        synchronized (this.zzrJ) {
            long elapsedRealtime = zzw.zzcS().elapsedRealtime();
            if (this.zzYF + this.zzYE > elapsedRealtime) {
                z = false;
            } else {
                this.zzYF = elapsedRealtime;
                z = true;
            }
        }
        return z;
    }
}
