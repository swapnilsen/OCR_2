package com.google.android.gms.ads.internal;

import android.os.Handler;
import android.support.annotation.Nullable;
import com.google.android.gms.internal.zzec;
import com.google.android.gms.internal.zzme;
import com.google.android.gms.internal.zzpo;
import com.google.android.gms.internal.zzqf;
import java.lang.ref.WeakReference;

@zzme
public class zzt {
    private final zza zzul;
    @Nullable
    private zzec zzum;
    private boolean zzun;
    private boolean zzuo;
    private long zzup;
    private final Runnable zzw;

    /* renamed from: com.google.android.gms.ads.internal.zzt.1 */
    class C09611 implements Runnable {
        final /* synthetic */ WeakReference zzuq;
        final /* synthetic */ zzt zzur;

        C09611(zzt com_google_android_gms_ads_internal_zzt, WeakReference weakReference) {
            this.zzur = com_google_android_gms_ads_internal_zzt;
            this.zzuq = weakReference;
        }

        public void run() {
            this.zzur.zzun = false;
            zza com_google_android_gms_ads_internal_zza = (zza) this.zzuq.get();
            if (com_google_android_gms_ads_internal_zza != null) {
                com_google_android_gms_ads_internal_zza.zzd(this.zzur.zzum);
            }
        }
    }

    public static class zza {
        private final Handler mHandler;

        public zza(Handler handler) {
            this.mHandler = handler;
        }

        public boolean postDelayed(Runnable runnable, long j) {
            return this.mHandler.postDelayed(runnable, j);
        }

        public void removeCallbacks(Runnable runnable) {
            this.mHandler.removeCallbacks(runnable);
        }
    }

    public zzt(zza com_google_android_gms_ads_internal_zza) {
        this(com_google_android_gms_ads_internal_zza, new zza(zzpo.zzXC));
    }

    zzt(zza com_google_android_gms_ads_internal_zza, zza com_google_android_gms_ads_internal_zzt_zza) {
        this.zzun = false;
        this.zzuo = false;
        this.zzup = 0;
        this.zzul = com_google_android_gms_ads_internal_zzt_zza;
        this.zzw = new C09611(this, new WeakReference(com_google_android_gms_ads_internal_zza));
    }

    public void cancel() {
        this.zzun = false;
        this.zzul.removeCallbacks(this.zzw);
    }

    public void pause() {
        this.zzuo = true;
        if (this.zzun) {
            this.zzul.removeCallbacks(this.zzw);
        }
    }

    public void resume() {
        this.zzuo = false;
        if (this.zzun) {
            this.zzun = false;
            zza(this.zzum, this.zzup);
        }
    }

    public void zza(zzec com_google_android_gms_internal_zzec, long j) {
        if (this.zzun) {
            zzqf.zzbh("An ad refresh is already scheduled.");
            return;
        }
        this.zzum = com_google_android_gms_internal_zzec;
        this.zzun = true;
        this.zzup = j;
        if (!this.zzuo) {
            zzqf.zzbg("Scheduling ad refresh " + j + " milliseconds from now.");
            this.zzul.postDelayed(this.zzw, j);
        }
    }

    public boolean zzcy() {
        return this.zzun;
    }

    public void zzg(zzec com_google_android_gms_internal_zzec) {
        this.zzum = com_google_android_gms_internal_zzec;
    }

    public void zzh(zzec com_google_android_gms_internal_zzec) {
        zza(com_google_android_gms_internal_zzec, 60000);
    }
}
