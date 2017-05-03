package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.analytics.zzh;
import com.google.android.gms.common.internal.zzac;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class zzry extends zzsa {
    private final zzsi zzadG;

    /* renamed from: com.google.android.gms.internal.zzry.1 */
    class C14001 implements Runnable {
        final /* synthetic */ int zzadH;
        final /* synthetic */ zzry zzadI;

        C14001(zzry com_google_android_gms_internal_zzry, int i) {
            this.zzadI = com_google_android_gms_internal_zzry;
            this.zzadH = i;
        }

        public void run() {
            this.zzadI.zzadG.zzx(((long) this.zzadH) * 1000);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzry.2 */
    class C14012 implements Runnable {
        final /* synthetic */ zzry zzadI;
        final /* synthetic */ boolean zzadJ;

        C14012(zzry com_google_android_gms_internal_zzry, boolean z) {
            this.zzadI = com_google_android_gms_internal_zzry;
            this.zzadJ = z;
        }

        public void run() {
            this.zzadI.zzadG.zzW(this.zzadJ);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzry.3 */
    class C14023 implements Runnable {
        final /* synthetic */ zzry zzadI;
        final /* synthetic */ String zzadK;
        final /* synthetic */ Runnable zzadL;

        C14023(zzry com_google_android_gms_internal_zzry, String str, Runnable runnable) {
            this.zzadI = com_google_android_gms_internal_zzry;
            this.zzadK = str;
            this.zzadL = runnable;
        }

        public void run() {
            this.zzadI.zzadG.zzbX(this.zzadK);
            if (this.zzadL != null) {
                this.zzadL.run();
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzry.4 */
    class C14034 implements Runnable {
        final /* synthetic */ zzry zzadI;
        final /* synthetic */ zzsz zzadM;

        C14034(zzry com_google_android_gms_internal_zzry, zzsz com_google_android_gms_internal_zzsz) {
            this.zzadI = com_google_android_gms_internal_zzry;
            this.zzadM = com_google_android_gms_internal_zzsz;
        }

        public void run() {
            this.zzadI.zzadG.zza(this.zzadM);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzry.5 */
    class C14045 implements Runnable {
        final /* synthetic */ zzry zzadI;

        C14045(zzry com_google_android_gms_internal_zzry) {
            this.zzadI = com_google_android_gms_internal_zzry;
        }

        public void run() {
            this.zzadI.zzadG.zznK();
        }
    }

    /* renamed from: com.google.android.gms.internal.zzry.6 */
    class C14056 implements Runnable {
        final /* synthetic */ zzry zzadI;
        final /* synthetic */ zzsu zzadN;

        C14056(zzry com_google_android_gms_internal_zzry, zzsu com_google_android_gms_internal_zzsu) {
            this.zzadI = com_google_android_gms_internal_zzry;
            this.zzadN = com_google_android_gms_internal_zzsu;
        }

        public void run() {
            this.zzadI.zzadG.zzb(this.zzadN);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzry.7 */
    class C14067 implements Callable<Void> {
        final /* synthetic */ zzry zzadI;

        C14067(zzry com_google_android_gms_internal_zzry) {
            this.zzadI = com_google_android_gms_internal_zzry;
        }

        public /* synthetic */ Object call() {
            return zzbk();
        }

        public Void zzbk() {
            this.zzadI.zzadG.zzoG();
            return null;
        }
    }

    public zzry(zzsc com_google_android_gms_internal_zzsc, zzsd com_google_android_gms_internal_zzsd) {
        super(com_google_android_gms_internal_zzsc);
        zzac.zzw(com_google_android_gms_internal_zzsd);
        this.zzadG = com_google_android_gms_internal_zzsd.zzj(com_google_android_gms_internal_zzsc);
    }

    void onServiceConnected() {
        zzmR();
        this.zzadG.onServiceConnected();
    }

    public void setLocalDispatchPeriod(int i) {
        zzob();
        zzb("setLocalDispatchPeriod (sec)", Integer.valueOf(i));
        zznU().zzg(new C14001(this, i));
    }

    public void start() {
        this.zzadG.start();
    }

    public void zzW(boolean z) {
        zza("Network connectivity status changed", Boolean.valueOf(z));
        zznU().zzg(new C14012(this, z));
    }

    public long zza(zzse com_google_android_gms_internal_zzse) {
        zzob();
        zzac.zzw(com_google_android_gms_internal_zzse);
        zzmR();
        long zza = this.zzadG.zza(com_google_android_gms_internal_zzse, true);
        if (zza == 0) {
            this.zzadG.zzc(com_google_android_gms_internal_zzse);
        }
        return zza;
    }

    public void zza(zzsu com_google_android_gms_internal_zzsu) {
        zzob();
        zznU().zzg(new C14056(this, com_google_android_gms_internal_zzsu));
    }

    public void zza(zzsz com_google_android_gms_internal_zzsz) {
        zzac.zzw(com_google_android_gms_internal_zzsz);
        zzob();
        zzb("Hit delivery requested", com_google_android_gms_internal_zzsz);
        zznU().zzg(new C14034(this, com_google_android_gms_internal_zzsz));
    }

    public void zza(String str, Runnable runnable) {
        zzac.zzh(str, "campaign param can't be empty");
        zznU().zzg(new C14023(this, str, runnable));
    }

    protected void zzmS() {
        this.zzadG.initialize();
    }

    public void zznK() {
        zzob();
        zznU().zzg(new C14045(this));
    }

    public void zznL() {
        zzob();
        Context context = getContext();
        if (zzth.zzak(context) && zzti.zzal(context)) {
            Intent intent = new Intent("com.google.android.gms.analytics.ANALYTICS_DISPATCH");
            intent.setComponent(new ComponentName(context, "com.google.android.gms.analytics.AnalyticsService"));
            context.startService(intent);
            return;
        }
        zza(null);
    }

    public boolean zznM() {
        zzob();
        try {
            zznU().zzc(new C14067(this)).get(4, TimeUnit.SECONDS);
            return true;
        } catch (InterruptedException e) {
            zzd("syncDispatchLocalHits interrupted", e);
            return false;
        } catch (ExecutionException e2) {
            zze("syncDispatchLocalHits failed", e2);
            return false;
        } catch (TimeoutException e3) {
            zzd("syncDispatchLocalHits timed out", e3);
            return false;
        }
    }

    public void zznN() {
        zzob();
        zzh.zzmR();
        this.zzadG.zznN();
    }

    public void zznO() {
        zzbP("Radio powered up");
        zznL();
    }

    void zznP() {
        zzmR();
        this.zzadG.zznP();
    }
}
