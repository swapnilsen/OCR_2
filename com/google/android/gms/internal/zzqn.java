package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.List;

@zzme
class zzqn {
    private final Object zzZk;
    private final List<Runnable> zzZl;
    private final List<Runnable> zzZm;
    private boolean zzZn;

    public zzqn() {
        this.zzZk = new Object();
        this.zzZl = new ArrayList();
        this.zzZm = new ArrayList();
        this.zzZn = false;
    }

    private void zze(Runnable runnable) {
        zzpn.zza(runnable);
    }

    private void zzf(Runnable runnable) {
        zzqe.zzYP.post(runnable);
    }

    public void zzc(Runnable runnable) {
        synchronized (this.zzZk) {
            if (this.zzZn) {
                zze(runnable);
            } else {
                this.zzZl.add(runnable);
            }
        }
    }

    public void zzd(Runnable runnable) {
        synchronized (this.zzZk) {
            if (this.zzZn) {
                zzf(runnable);
            } else {
                this.zzZm.add(runnable);
            }
        }
    }

    public void zzlm() {
        synchronized (this.zzZk) {
            if (this.zzZn) {
                return;
            }
            for (Runnable zze : this.zzZl) {
                zze(zze);
            }
            for (Runnable zze2 : this.zzZm) {
                zzf(zze2);
            }
            this.zzZl.clear();
            this.zzZm.clear();
            this.zzZn = true;
        }
    }
}
