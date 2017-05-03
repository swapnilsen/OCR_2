package com.google.android.gms.tasks;

import android.support.annotation.NonNull;
import java.util.concurrent.Executor;

class zzd<TResult> implements zzf<TResult> {
    private final Executor zzbFM;
    private OnFailureListener zzbNw;
    private final Object zzrJ;

    /* renamed from: com.google.android.gms.tasks.zzd.1 */
    class C14721 implements Runnable {
        final /* synthetic */ Task zzbNr;
        final /* synthetic */ zzd zzbNx;

        C14721(zzd com_google_android_gms_tasks_zzd, Task task) {
            this.zzbNx = com_google_android_gms_tasks_zzd;
            this.zzbNr = task;
        }

        public void run() {
            synchronized (this.zzbNx.zzrJ) {
                if (this.zzbNx.zzbNw != null) {
                    this.zzbNx.zzbNw.onFailure(this.zzbNr.getException());
                }
            }
        }
    }

    public zzd(@NonNull Executor executor, @NonNull OnFailureListener onFailureListener) {
        this.zzrJ = new Object();
        this.zzbFM = executor;
        this.zzbNw = onFailureListener;
    }

    public void cancel() {
        synchronized (this.zzrJ) {
            this.zzbNw = null;
        }
    }

    public void onComplete(@NonNull Task<TResult> task) {
        if (!task.isSuccessful()) {
            synchronized (this.zzrJ) {
                if (this.zzbNw == null) {
                    return;
                }
                this.zzbFM.execute(new C14721(this, task));
            }
        }
    }
}
