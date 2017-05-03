package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.zzh;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.util.zze;
import com.google.android.gms.common.util.zzi;

public class zzsd {
    private final Context zzaeg;
    private final Context zzwi;

    public zzsd(Context context) {
        zzac.zzw(context);
        Object applicationContext = context.getApplicationContext();
        zzac.zzb(applicationContext, (Object) "Application context can't be null");
        this.zzwi = applicationContext;
        this.zzaeg = applicationContext;
    }

    public Context getApplicationContext() {
        return this.zzwi;
    }

    protected zzss zza(zzsc com_google_android_gms_internal_zzsc) {
        return new zzss(com_google_android_gms_internal_zzsc);
    }

    protected zzh zzao(Context context) {
        return zzh.zzam(context);
    }

    protected zzsh zzb(zzsc com_google_android_gms_internal_zzsc) {
        return new zzsh(com_google_android_gms_internal_zzsc);
    }

    protected zzrx zzc(zzsc com_google_android_gms_internal_zzsc) {
        return new zzrx(com_google_android_gms_internal_zzsc);
    }

    protected zzsk zzd(zzsc com_google_android_gms_internal_zzsc) {
        return new zzsk(com_google_android_gms_internal_zzsc);
    }

    protected zztn zze(zzsc com_google_android_gms_internal_zzsc) {
        return new zztn(com_google_android_gms_internal_zzsc);
    }

    protected zztd zzf(zzsc com_google_android_gms_internal_zzsc) {
        return new zztd(com_google_android_gms_internal_zzsc);
    }

    protected zzsp zzg(zzsc com_google_android_gms_internal_zzsc) {
        return new zzsp(com_google_android_gms_internal_zzsc);
    }

    protected zze zzh(zzsc com_google_android_gms_internal_zzsc) {
        return zzi.zzzc();
    }

    protected GoogleAnalytics zzi(zzsc com_google_android_gms_internal_zzsc) {
        return new GoogleAnalytics(com_google_android_gms_internal_zzsc);
    }

    zzsi zzj(zzsc com_google_android_gms_internal_zzsc) {
        return new zzsi(com_google_android_gms_internal_zzsc, this);
    }

    zzte zzk(zzsc com_google_android_gms_internal_zzsc) {
        return new zzte(com_google_android_gms_internal_zzsc);
    }

    protected zzry zzl(zzsc com_google_android_gms_internal_zzsc) {
        return new zzry(com_google_android_gms_internal_zzsc, this);
    }

    public zzsg zzm(zzsc com_google_android_gms_internal_zzsc) {
        return new zzsg(com_google_android_gms_internal_zzsc);
    }

    public zztf zzn(zzsc com_google_android_gms_internal_zzsc) {
        return new zztf(com_google_android_gms_internal_zzsc);
    }

    public zzsf zzo(zzsc com_google_android_gms_internal_zzsc) {
        return new zzsf(com_google_android_gms_internal_zzsc);
    }

    public Context zzod() {
        return this.zzaeg;
    }

    public zzst zzp(zzsc com_google_android_gms_internal_zzsc) {
        return new zzst(com_google_android_gms_internal_zzsc);
    }

    public zztg zzq(zzsc com_google_android_gms_internal_zzsc) {
        return new zztg(com_google_android_gms_internal_zzsc);
    }
}
