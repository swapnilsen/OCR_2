package com.google.android.gms.tasks;

import android.support.annotation.NonNull;
import java.util.concurrent.Executor;

class zza<TResult, TContinuationResult> implements zzf<TResult> {
    private final Executor zzbFM;
    private final Continuation<TResult, TContinuationResult> zzbNp;
    private final zzh<TContinuationResult> zzbNq;

    /* renamed from: com.google.android.gms.tasks.zza.1 */
    class C14691 implements Runnable {
        final /* synthetic */ Task zzbNr;
        final /* synthetic */ zza zzbNs;

        C14691(zza com_google_android_gms_tasks_zza, Task task) {
            this.zzbNs = com_google_android_gms_tasks_zza;
            this.zzbNr = task;
        }

        public void run() {
            try {
                this.zzbNs.zzbNq.setResult(this.zzbNs.zzbNp.then(this.zzbNr));
            } catch (Exception e) {
                if (e.getCause() instanceof Exception) {
                    this.zzbNs.zzbNq.setException((Exception) e.getCause());
                } else {
                    this.zzbNs.zzbNq.setException(e);
                }
            } catch (Exception e2) {
                this.zzbNs.zzbNq.setException(e2);
            }
        }
    }

    public zza(@NonNull Executor executor, @NonNull Continuation<TResult, TContinuationResult> continuation, @NonNull zzh<TContinuationResult> com_google_android_gms_tasks_zzh_TContinuationResult) {
        this.zzbFM = executor;
        this.zzbNp = continuation;
        this.zzbNq = com_google_android_gms_tasks_zzh_TContinuationResult;
    }

    public void cancel() {
        throw new UnsupportedOperationException();
    }

    public void onComplete(@NonNull Task<TResult> task) {
        this.zzbFM.execute(new C14691(this, task));
    }
}
