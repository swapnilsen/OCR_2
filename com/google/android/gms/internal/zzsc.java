package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.zzh;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.util.zze;
import com.google.android.gms.common.util.zzi;
import java.lang.Thread.UncaughtExceptionHandler;

public class zzsc {
    private static volatile zzsc zzadR;
    private final Context mContext;
    private final Context zzadS;
    private final zzsp zzadT;
    private final zztd zzadU;
    private final zzh zzadV;
    private final zzry zzadW;
    private final zzst zzadX;
    private final zztn zzadY;
    private final zztg zzadZ;
    private final GoogleAnalytics zzaea;
    private final zzsk zzaeb;
    private final zzrx zzaec;
    private final zzsh zzaed;
    private final zzss zzaee;
    private final zze zzuP;

    /* renamed from: com.google.android.gms.internal.zzsc.1 */
    class C14071 implements UncaughtExceptionHandler {
        final /* synthetic */ zzsc zzaef;

        C14071(zzsc com_google_android_gms_internal_zzsc) {
            this.zzaef = com_google_android_gms_internal_zzsc;
        }

        public void uncaughtException(Thread thread, Throwable th) {
            zztd zzoe = this.zzaef.zzoe();
            if (zzoe != null) {
                zzoe.zze("Job execution failed", th);
            }
        }
    }

    protected zzsc(zzsd com_google_android_gms_internal_zzsd) {
        Object applicationContext = com_google_android_gms_internal_zzsd.getApplicationContext();
        zzac.zzb(applicationContext, (Object) "Application context can't be null");
        Context zzod = com_google_android_gms_internal_zzsd.zzod();
        zzac.zzw(zzod);
        this.mContext = applicationContext;
        this.zzadS = zzod;
        this.zzuP = com_google_android_gms_internal_zzsd.zzh(this);
        this.zzadT = com_google_android_gms_internal_zzsd.zzg(this);
        zztd zzf = com_google_android_gms_internal_zzsd.zzf(this);
        zzf.initialize();
        this.zzadU = zzf;
        zzf = zznS();
        String str = zzsb.VERSION;
        zzf.zzbR(new StringBuilder(String.valueOf(str).length() + 134).append("Google Analytics ").append(str).append(" is starting up. To enable debug logging on a device run:\n  adb shell setprop log.tag.GAv4 DEBUG\n  adb logcat -s GAv4").toString());
        zztg zzq = com_google_android_gms_internal_zzsd.zzq(this);
        zzq.initialize();
        this.zzadZ = zzq;
        zztn zze = com_google_android_gms_internal_zzsd.zze(this);
        zze.initialize();
        this.zzadY = zze;
        zzry zzl = com_google_android_gms_internal_zzsd.zzl(this);
        zzsk zzd = com_google_android_gms_internal_zzsd.zzd(this);
        zzrx zzc = com_google_android_gms_internal_zzsd.zzc(this);
        zzsh zzb = com_google_android_gms_internal_zzsd.zzb(this);
        zzss zza = com_google_android_gms_internal_zzsd.zza(this);
        zzh zzao = com_google_android_gms_internal_zzsd.zzao(applicationContext);
        zzao.zza(zzoc());
        this.zzadV = zzao;
        GoogleAnalytics zzi = com_google_android_gms_internal_zzsd.zzi(this);
        zzd.initialize();
        this.zzaeb = zzd;
        zzc.initialize();
        this.zzaec = zzc;
        zzb.initialize();
        this.zzaed = zzb;
        zza.initialize();
        this.zzaee = zza;
        zzst zzp = com_google_android_gms_internal_zzsd.zzp(this);
        zzp.initialize();
        this.zzadX = zzp;
        zzl.initialize();
        this.zzadW = zzl;
        zzi.initialize();
        this.zzaea = zzi;
        zzl.start();
    }

    private void zza(zzsa com_google_android_gms_internal_zzsa) {
        zzac.zzb((Object) com_google_android_gms_internal_zzsa, (Object) "Analytics service not created/initialized");
        zzac.zzb(com_google_android_gms_internal_zzsa.isInitialized(), (Object) "Analytics service not initialized");
    }

    public static zzsc zzan(Context context) {
        zzac.zzw(context);
        if (zzadR == null) {
            synchronized (zzsc.class) {
                if (zzadR == null) {
                    zze zzzc = zzi.zzzc();
                    long elapsedRealtime = zzzc.elapsedRealtime();
                    zzsc com_google_android_gms_internal_zzsc = new zzsc(new zzsd(context));
                    zzadR = com_google_android_gms_internal_zzsc;
                    GoogleAnalytics.zzmx();
                    elapsedRealtime = zzzc.elapsedRealtime() - elapsedRealtime;
                    long longValue = ((Long) zzsw.zzafZ.get()).longValue();
                    if (elapsedRealtime > longValue) {
                        com_google_android_gms_internal_zzsc.zznS().zzc("Slow initialization (ms)", Long.valueOf(elapsedRealtime), Long.valueOf(longValue));
                    }
                }
            }
        }
        return zzadR;
    }

    public Context getContext() {
        return this.mContext;
    }

    public zzry zzmA() {
        zza(this.zzadW);
        return this.zzadW;
    }

    public zztn zzmB() {
        zza(this.zzadY);
        return this.zzadY;
    }

    public void zzmR() {
        zzh.zzmR();
    }

    public zze zznR() {
        return this.zzuP;
    }

    public zztd zznS() {
        zza(this.zzadU);
        return this.zzadU;
    }

    public zzsp zznT() {
        return this.zzadT;
    }

    public zzh zznU() {
        zzac.zzw(this.zzadV);
        return this.zzadV;
    }

    public zzst zznV() {
        zza(this.zzadX);
        return this.zzadX;
    }

    public zztg zznW() {
        zza(this.zzadZ);
        return this.zzadZ;
    }

    public zzsh zznZ() {
        zza(this.zzaed);
        return this.zzaed;
    }

    public zzss zzoa() {
        return this.zzaee;
    }

    protected UncaughtExceptionHandler zzoc() {
        return new C14071(this);
    }

    public Context zzod() {
        return this.zzadS;
    }

    public zztd zzoe() {
        return this.zzadU;
    }

    public GoogleAnalytics zzof() {
        zzac.zzw(this.zzaea);
        zzac.zzb(this.zzaea.isInitialized(), (Object) "Analytics instance not initialized");
        return this.zzaea;
    }

    public zztg zzog() {
        return (this.zzadZ == null || !this.zzadZ.isInitialized()) ? null : this.zzadZ;
    }

    public zzrx zzoh() {
        zza(this.zzaec);
        return this.zzaec;
    }

    public zzsk zzoi() {
        zza(this.zzaeb);
        return this.zzaeb;
    }
}
