package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.zze;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.internal.zznu.zza;

@zzme
public class zznr extends zza {
    private final Context mContext;
    private final zzns zzVj;
    private final Object zzrJ;
    private final zzqh zztt;

    public zznr(Context context, zze com_google_android_gms_ads_internal_zze, zzka com_google_android_gms_internal_zzka, zzqh com_google_android_gms_internal_zzqh) {
        this(context, com_google_android_gms_internal_zzqh, new zzns(context, com_google_android_gms_ads_internal_zze, zzeg.zzeE(), com_google_android_gms_internal_zzka, com_google_android_gms_internal_zzqh));
    }

    zznr(Context context, zzqh com_google_android_gms_internal_zzqh, zzns com_google_android_gms_internal_zzns) {
        this.zzrJ = new Object();
        this.mContext = context;
        this.zztt = com_google_android_gms_internal_zzqh;
        this.zzVj = com_google_android_gms_internal_zzns;
    }

    public void destroy() {
        zzh(null);
    }

    public boolean isLoaded() {
        boolean isLoaded;
        synchronized (this.zzrJ) {
            isLoaded = this.zzVj.isLoaded();
        }
        return isLoaded;
    }

    public void pause() {
        zzf(null);
    }

    public void resume() {
        zzg(null);
    }

    public void setUserId(String str) {
        zzqf.zzbh("RewardedVideoAd.setUserId() is deprecated. Please do not call this method.");
    }

    public void show() {
        synchronized (this.zzrJ) {
            this.zzVj.zzjF();
        }
    }

    public void zza(zznw com_google_android_gms_internal_zznw) {
        synchronized (this.zzrJ) {
            this.zzVj.zza(com_google_android_gms_internal_zznw);
        }
    }

    public void zza(zzoa com_google_android_gms_internal_zzoa) {
        synchronized (this.zzrJ) {
            this.zzVj.zza(com_google_android_gms_internal_zzoa);
        }
    }

    public void zzf(IObjectWrapper iObjectWrapper) {
        synchronized (this.zzrJ) {
            this.zzVj.pause();
        }
    }

    public void zzg(IObjectWrapper iObjectWrapper) {
        synchronized (this.zzrJ) {
            Context context = iObjectWrapper == null ? null : (Context) zzd.zzF(iObjectWrapper);
            if (context != null) {
                try {
                    this.zzVj.onContextChanged(context);
                } catch (Throwable e) {
                    zzqf.zzc("Unable to extract updated context.", e);
                }
            }
            this.zzVj.resume();
        }
    }

    public void zzh(IObjectWrapper iObjectWrapper) {
        synchronized (this.zzrJ) {
            this.zzVj.destroy();
        }
    }
}
