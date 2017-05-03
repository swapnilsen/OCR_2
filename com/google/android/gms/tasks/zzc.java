package com.google.android.gms.tasks;

import android.support.annotation.NonNull;
import java.util.concurrent.Executor;

class zzc<TResult> implements zzf<TResult> {
    private final Executor zzbFM;
    private OnCompleteListener<TResult> zzbNu;
    private final Object zzrJ;

    /* renamed from: com.google.android.gms.tasks.zzc.1 */
    class C14711 implements Runnable {
        final /* synthetic */ Task zzbNr;
        final /* synthetic */ zzc zzbNv;

        C14711(zzc com_google_android_gms_tasks_zzc, Task task) {
            this.zzbNv = com_google_android_gms_tasks_zzc;
            this.zzbNr = task;
        }

        public void run() {
            synchronized (this.zzbNv.zzrJ) {
                if (this.zzbNv.zzbNu != null) {
                    this.zzbNv.zzbNu.onComplete(this.zzbNr);
                }
            }
        }
    }

    public zzc(@NonNull Executor executor, @NonNull OnCompleteListener<TResult> onCompleteListener) {
        this.zzrJ = new Object();
        this.zzbFM = executor;
        this.zzbNu = onCompleteListener;
    }

    public void cancel() {
        synchronized (this.zzrJ) {
            this.zzbNu = null;
        }
    }

    public void onComplete(@NonNull Task<TResult> task) {
        synchronized (this.zzrJ) {
            if (this.zzbNu == null) {
                return;
            }
            this.zzbFM.execute(new C14711(this, task));
        }
    }
}
