package com.google.android.gms.internal;

import android.os.Handler;
import java.util.concurrent.Executor;

public class zzf implements zzo {
    private final Executor zzr;

    /* renamed from: com.google.android.gms.internal.zzf.1 */
    class C11721 implements Executor {
        final /* synthetic */ Handler zzs;
        final /* synthetic */ zzf zzt;

        C11721(zzf com_google_android_gms_internal_zzf, Handler handler) {
            this.zzt = com_google_android_gms_internal_zzf;
            this.zzs = handler;
        }

        public void execute(Runnable runnable) {
            this.zzs.post(runnable);
        }
    }

    private class zza implements Runnable {
        final /* synthetic */ zzf zzt;
        private final zzl zzu;
        private final zzn zzv;
        private final Runnable zzw;

        public zza(zzf com_google_android_gms_internal_zzf, zzl com_google_android_gms_internal_zzl, zzn com_google_android_gms_internal_zzn, Runnable runnable) {
            this.zzt = com_google_android_gms_internal_zzf;
            this.zzu = com_google_android_gms_internal_zzl;
            this.zzv = com_google_android_gms_internal_zzn;
            this.zzw = runnable;
        }

        public void run() {
            if (this.zzv.isSuccess()) {
                this.zzu.zza(this.zzv.result);
            } else {
                this.zzu.zzc(this.zzv.zzag);
            }
            if (this.zzv.zzah) {
                this.zzu.zzc("intermediate-response");
            } else {
                this.zzu.zzd("done");
            }
            if (this.zzw != null) {
                this.zzw.run();
            }
        }
    }

    public zzf(Handler handler) {
        this.zzr = new C11721(this, handler);
    }

    public void zza(zzl<?> com_google_android_gms_internal_zzl_, zzn<?> com_google_android_gms_internal_zzn_) {
        zza(com_google_android_gms_internal_zzl_, com_google_android_gms_internal_zzn_, null);
    }

    public void zza(zzl<?> com_google_android_gms_internal_zzl_, zzn<?> com_google_android_gms_internal_zzn_, Runnable runnable) {
        com_google_android_gms_internal_zzl_.zzr();
        com_google_android_gms_internal_zzl_.zzc("post-response");
        this.zzr.execute(new zza(this, com_google_android_gms_internal_zzl_, com_google_android_gms_internal_zzn_, runnable));
    }

    public void zza(zzl<?> com_google_android_gms_internal_zzl_, zzs com_google_android_gms_internal_zzs) {
        com_google_android_gms_internal_zzl_.zzc("post-error");
        this.zzr.execute(new zza(this, com_google_android_gms_internal_zzl_, zzn.zzd(com_google_android_gms_internal_zzs), null));
    }
}
