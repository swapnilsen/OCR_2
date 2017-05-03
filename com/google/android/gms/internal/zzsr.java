package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.internal.zzac;

abstract class zzsr {
    private static volatile Handler zzafd;
    private final zzsc zzadO;
    private volatile long zzafe;
    private final Runnable zzw;

    /* renamed from: com.google.android.gms.internal.zzsr.1 */
    class C14181 implements Runnable {
        final /* synthetic */ zzsr zzaff;

        C14181(zzsr com_google_android_gms_internal_zzsr) {
            this.zzaff = com_google_android_gms_internal_zzsr;
        }

        public void run() {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                this.zzaff.zzadO.zznU().zzg(this);
                return;
            }
            boolean zzcy = this.zzaff.zzcy();
            this.zzaff.zzafe = 0;
            if (zzcy) {
                this.zzaff.run();
            }
        }
    }

    zzsr(zzsc com_google_android_gms_internal_zzsc) {
        zzac.zzw(com_google_android_gms_internal_zzsc);
        this.zzadO = com_google_android_gms_internal_zzsc;
        this.zzw = new C14181(this);
    }

    private Handler getHandler() {
        if (zzafd != null) {
            return zzafd;
        }
        Handler handler;
        synchronized (zzsr.class) {
            if (zzafd == null) {
                zzafd = new Handler(this.zzadO.getContext().getMainLooper());
            }
            handler = zzafd;
        }
        return handler;
    }

    public void cancel() {
        this.zzafe = 0;
        getHandler().removeCallbacks(this.zzw);
    }

    public abstract void run();

    public boolean zzcy() {
        return this.zzafe != 0;
    }

    public long zzpA() {
        return this.zzafe == 0 ? 0 : Math.abs(this.zzadO.zznR().currentTimeMillis() - this.zzafe);
    }

    public void zzy(long j) {
        cancel();
        if (j >= 0) {
            this.zzafe = this.zzadO.zznR().currentTimeMillis();
            if (!getHandler().postDelayed(this.zzw, j)) {
                this.zzadO.zznS().zze("Failed to schedule delayed post. time", Long.valueOf(j));
            }
        }
    }

    public void zzz(long j) {
        long j2 = 0;
        if (!zzcy()) {
            return;
        }
        if (j < 0) {
            cancel();
            return;
        }
        long abs = j - Math.abs(this.zzadO.zznR().currentTimeMillis() - this.zzafe);
        if (abs >= 0) {
            j2 = abs;
        }
        getHandler().removeCallbacks(this.zzw);
        if (!getHandler().postDelayed(this.zzw, j2)) {
            this.zzadO.zznS().zze("Failed to adjust delayed post. time", Long.valueOf(j2));
        }
    }
}
