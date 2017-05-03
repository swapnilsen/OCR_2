package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.dynamic.zzd;

@zzme
public class zzfh {
    private static zzfh zzAy;
    private static final Object zztX;
    private RewardedVideoAd zzAA;
    private zzey zzAz;

    /* renamed from: com.google.android.gms.internal.zzfh.1 */
    class C11741 implements Runnable {
        final /* synthetic */ zzfh zzAB;
        final /* synthetic */ Context zztf;

        C11741(zzfh com_google_android_gms_internal_zzfh, Context context) {
            this.zzAB = com_google_android_gms_internal_zzfh;
            this.zztf = context;
        }

        public void run() {
            this.zzAB.getRewardedVideoAdInstance(this.zztf);
        }
    }

    static {
        zztX = new Object();
    }

    private zzfh() {
    }

    public static zzfh zzfk() {
        zzfh com_google_android_gms_internal_zzfh;
        synchronized (zztX) {
            if (zzAy == null) {
                zzAy = new zzfh();
            }
            com_google_android_gms_internal_zzfh = zzAy;
        }
        return com_google_android_gms_internal_zzfh;
    }

    public RewardedVideoAd getRewardedVideoAdInstance(Context context) {
        RewardedVideoAd rewardedVideoAd;
        synchronized (zztX) {
            if (this.zzAA != null) {
                rewardedVideoAd = this.zzAA;
            } else {
                this.zzAA = new zzoc(context, zzel.zzeU().zza(context, new zzjz()));
                rewardedVideoAd = this.zzAA;
            }
        }
        return rewardedVideoAd;
    }

    public void openDebugMenu(Context context, String str) {
        zzac.zza(this.zzAz != null, (Object) "MobileAds.initialize() must be called prior to opening debug menu.");
        try {
            this.zzAz.zzb(zzd.zzA(context), str);
        } catch (Throwable e) {
            zzqf.zzb("Unable to open debug menu.", e);
        }
    }

    public void setAppMuted(boolean z) {
        zzac.zza(this.zzAz != null, (Object) "MobileAds.initialize() must be called prior to setting the app volume.");
        try {
            this.zzAz.setAppMuted(z);
        } catch (Throwable e) {
            zzqf.zzb("Unable to set app mute state.", e);
        }
    }

    public void setAppVolume(float f) {
        boolean z = true;
        boolean z2 = 0.0f <= f && f <= 1.0f;
        zzac.zzb(z2, (Object) "The app volume must be a value between 0 and 1 inclusive.");
        if (this.zzAz == null) {
            z = false;
        }
        zzac.zza(z, (Object) "MobileAds.initialize() must be called prior to setting the app volume.");
        try {
            this.zzAz.setAppVolume(f);
        } catch (Throwable e) {
            zzqf.zzb("Unable to set app volume.", e);
        }
    }

    public void zza(Context context, String str, zzfi com_google_android_gms_internal_zzfi) {
        synchronized (zztX) {
            if (this.zzAz != null) {
            } else if (context == null) {
                throw new IllegalArgumentException("Context cannot be null.");
            } else {
                try {
                    this.zzAz = zzel.zzeU().zzl(context);
                    this.zzAz.initialize();
                    if (str != null) {
                        this.zzAz.zzc(str, zzd.zzA(new C11741(this, context)));
                    }
                } catch (Throwable e) {
                    zzqf.zzc("MobileAdsSettingManager initialization failed", e);
                }
            }
        }
    }
}
