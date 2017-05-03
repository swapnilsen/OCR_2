package com.google.android.gms.internal;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.google.android.gms.common.internal.zzac;

@zzme
public class zzpw {
    private Handler mHandler;
    private HandlerThread zzYy;
    private int zzYz;
    private final Object zzrJ;

    /* renamed from: com.google.android.gms.internal.zzpw.1 */
    class C13791 implements Runnable {
        final /* synthetic */ zzpw zzYA;

        C13791(zzpw com_google_android_gms_internal_zzpw) {
            this.zzYA = com_google_android_gms_internal_zzpw;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
            r2 = this;
            r0 = r2.zzYA;
            r1 = r0.zzrJ;
            monitor-enter(r1);
            r0 = "Suspending the looper thread";
            com.google.android.gms.internal.zzpk.m4709v(r0);	 Catch:{ all -> 0x002a }
        L_0x000c:
            r0 = r2.zzYA;	 Catch:{ all -> 0x002a }
            r0 = r0.zzYz;	 Catch:{ all -> 0x002a }
            if (r0 != 0) goto L_0x002d;
        L_0x0014:
            r0 = r2.zzYA;	 Catch:{ InterruptedException -> 0x0023 }
            r0 = r0.zzrJ;	 Catch:{ InterruptedException -> 0x0023 }
            r0.wait();	 Catch:{ InterruptedException -> 0x0023 }
            r0 = "Looper thread resumed";
            com.google.android.gms.internal.zzpk.m4709v(r0);	 Catch:{ InterruptedException -> 0x0023 }
            goto L_0x000c;
        L_0x0023:
            r0 = move-exception;
            r0 = "Looper thread interrupted.";
            com.google.android.gms.internal.zzpk.m4709v(r0);	 Catch:{ all -> 0x002a }
            goto L_0x000c;
        L_0x002a:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x002a }
            throw r0;
        L_0x002d:
            monitor-exit(r1);	 Catch:{ all -> 0x002a }
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzpw.1.run():void");
        }
    }

    public zzpw() {
        this.zzYy = null;
        this.mHandler = null;
        this.zzYz = 0;
        this.zzrJ = new Object();
    }

    public Looper zzlb() {
        Looper looper;
        synchronized (this.zzrJ) {
            if (this.zzYz != 0) {
                zzac.zzb(this.zzYy, (Object) "Invalid state: mHandlerThread should already been initialized.");
            } else if (this.zzYy == null) {
                zzpk.m4709v("Starting the looper thread.");
                this.zzYy = new HandlerThread("LooperProvider");
                this.zzYy.start();
                this.mHandler = new Handler(this.zzYy.getLooper());
                zzpk.m4709v("Looper thread started.");
            } else {
                zzpk.m4709v("Resuming the looper thread");
                this.zzrJ.notifyAll();
            }
            this.zzYz++;
            looper = this.zzYy.getLooper();
        }
        return looper;
    }

    public void zzlc() {
        synchronized (this.zzrJ) {
            zzac.zzb(this.zzYz > 0, (Object) "Invalid state: release() called more times than expected.");
            int i = this.zzYz - 1;
            this.zzYz = i;
            if (i == 0) {
                this.mHandler.post(new C13791(this));
            }
        }
    }
}
