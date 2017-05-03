package com.google.android.gms.internal;

import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.internal.zzom.zza;

@zzme
public class zzoi extends zza {
    private volatile zzog zzVE;
    private volatile zzoh zzVF;
    private volatile zzoj zzVs;

    public zzoi(zzoh com_google_android_gms_internal_zzoh) {
        this.zzVF = com_google_android_gms_internal_zzoh;
    }

    public void zza(IObjectWrapper iObjectWrapper, zzoo com_google_android_gms_internal_zzoo) {
        if (this.zzVF != null) {
            this.zzVF.zzc(com_google_android_gms_internal_zzoo);
        }
    }

    public void zza(zzog com_google_android_gms_internal_zzog) {
        this.zzVE = com_google_android_gms_internal_zzog;
    }

    public void zza(zzoj com_google_android_gms_internal_zzoj) {
        this.zzVs = com_google_android_gms_internal_zzoj;
    }

    public void zzc(IObjectWrapper iObjectWrapper, int i) {
        if (this.zzVE != null) {
            this.zzVE.zzad(i);
        }
    }

    public void zzd(IObjectWrapper iObjectWrapper, int i) {
        if (this.zzVs != null) {
            this.zzVs.zza(zzd.zzF(iObjectWrapper).getClass().getName(), i);
        }
    }

    public void zzr(IObjectWrapper iObjectWrapper) {
        if (this.zzVE != null) {
            this.zzVE.zzjJ();
        }
    }

    public void zzs(IObjectWrapper iObjectWrapper) {
        if (this.zzVs != null) {
            this.zzVs.zzaO(zzd.zzF(iObjectWrapper).getClass().getName());
        }
    }

    public void zzt(IObjectWrapper iObjectWrapper) {
        if (this.zzVF != null) {
            this.zzVF.onRewardedVideoAdOpened();
        }
    }

    public void zzu(IObjectWrapper iObjectWrapper) {
        if (this.zzVF != null) {
            this.zzVF.onRewardedVideoStarted();
        }
    }

    public void zzv(IObjectWrapper iObjectWrapper) {
        if (this.zzVF != null) {
            this.zzVF.onRewardedVideoAdClosed();
        }
    }

    public void zzw(IObjectWrapper iObjectWrapper) {
        if (this.zzVF != null) {
            this.zzVF.zzjG();
        }
    }

    public void zzx(IObjectWrapper iObjectWrapper) {
        if (this.zzVF != null) {
            this.zzVF.onRewardedVideoAdLeftApplication();
        }
    }
}
