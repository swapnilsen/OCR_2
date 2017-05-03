package com.google.android.gms.tasks;

import android.support.annotation.NonNull;
import java.util.concurrent.Executor;

class zze<TResult> implements zzf<TResult> {
    private final Executor zzbFM;
    private OnSuccessListener<? super TResult> zzbNy;
    private final Object zzrJ;

    /* renamed from: com.google.android.gms.tasks.zze.1 */
    class C14731 implements Runnable {
        final /* synthetic */ Task zzbNr;
        final /* synthetic */ zze zzbNz;

        C14731(zze com_google_android_gms_tasks_zze, Task task) {
            this.zzbNz = com_google_android_gms_tasks_zze;
            this.zzbNr = task;
        }

        public void run() {
            synchronized (this.zzbNz.zzrJ) {
                if (this.zzbNz.zzbNy != null) {
                    this.zzbNz.zzbNy.onSuccess(this.zzbNr.getResult());
                }
            }
        }
    }

    public zze(@NonNull Executor executor, @NonNull OnSuccessListener<? super TResult> onSuccessListener) {
        this.zzrJ = new Object();
        this.zzbFM = executor;
        this.zzbNy = onSuccessListener;
    }

    public void cancel() {
        synchronized (this.zzrJ) {
            this.zzbNy = null;
        }
    }

    public void onComplete(@NonNull Task<TResult> task) {
        if (task.isSuccessful()) {
            synchronized (this.zzrJ) {
                if (this.zzbNy == null) {
                    return;
                }
                this.zzbFM.execute(new C14731(this, task));
            }
        }
    }
}
