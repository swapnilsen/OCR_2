package com.google.android.gms.internal;

import com.google.android.gms.internal.zzqp.zzc;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

@zzme
public class zzqq<T> implements zzqp<T> {
    protected int zzJO;
    protected final BlockingQueue<zza> zzZo;
    protected T zzZp;
    private final Object zzrJ;

    class zza {
        public final zzc<T> zzZq;
        public final com.google.android.gms.internal.zzqp.zza zzZr;

        public zza(zzqq com_google_android_gms_internal_zzqq, zzc<T> com_google_android_gms_internal_zzqp_zzc_T, com.google.android.gms.internal.zzqp.zza com_google_android_gms_internal_zzqp_zza) {
            this.zzZq = com_google_android_gms_internal_zzqp_zzc_T;
            this.zzZr = com_google_android_gms_internal_zzqp_zza;
        }
    }

    public zzqq() {
        this.zzrJ = new Object();
        this.zzJO = 0;
        this.zzZo = new LinkedBlockingQueue();
    }

    public int getStatus() {
        return this.zzJO;
    }

    public void reject() {
        synchronized (this.zzrJ) {
            if (this.zzJO != 0) {
                throw new UnsupportedOperationException();
            }
            this.zzJO = -1;
            for (zza com_google_android_gms_internal_zzqq_zza : this.zzZo) {
                com_google_android_gms_internal_zzqq_zza.zzZr.run();
            }
            this.zzZo.clear();
        }
    }

    public void zza(zzc<T> com_google_android_gms_internal_zzqp_zzc_T, com.google.android.gms.internal.zzqp.zza com_google_android_gms_internal_zzqp_zza) {
        synchronized (this.zzrJ) {
            if (this.zzJO == 1) {
                com_google_android_gms_internal_zzqp_zzc_T.zzd(this.zzZp);
            } else if (this.zzJO == -1) {
                com_google_android_gms_internal_zzqp_zza.run();
            } else if (this.zzJO == 0) {
                this.zzZo.add(new zza(this, com_google_android_gms_internal_zzqp_zzc_T, com_google_android_gms_internal_zzqp_zza));
            }
        }
    }

    public void zzg(T t) {
        synchronized (this.zzrJ) {
            if (this.zzJO != 0) {
                throw new UnsupportedOperationException();
            }
            this.zzZp = t;
            this.zzJO = 1;
            for (zza com_google_android_gms_internal_zzqq_zza : this.zzZo) {
                com_google_android_gms_internal_zzqq_zza.zzZq.zzd(t);
            }
            this.zzZo.clear();
        }
    }
}
