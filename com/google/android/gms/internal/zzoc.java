package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import com.google.android.gms.dynamic.zzd;

@zzme
public class zzoc implements RewardedVideoAd {
    private final Context mContext;
    private final zznu zzVq;
    private RewardedVideoAdListener zzcJ;
    private final Object zzrJ;

    public zzoc(Context context, zznu com_google_android_gms_internal_zznu) {
        this.zzrJ = new Object();
        this.zzVq = com_google_android_gms_internal_zznu;
        this.mContext = context;
    }

    public void destroy() {
        destroy(null);
    }

    public void destroy(Context context) {
        synchronized (this.zzrJ) {
            if (this.zzVq == null) {
                return;
            }
            try {
                this.zzVq.zzh(zzd.zzA(context));
            } catch (Throwable e) {
                zzqf.zzc("Could not forward destroy to RewardedVideoAd", e);
            }
        }
    }

    public RewardedVideoAdListener getRewardedVideoAdListener() {
        RewardedVideoAdListener rewardedVideoAdListener;
        synchronized (this.zzrJ) {
            rewardedVideoAdListener = this.zzcJ;
        }
        return rewardedVideoAdListener;
    }

    public String getUserId() {
        zzqf.zzbh("RewardedVideoAd.getUserId() is deprecated. Please do not call this method.");
        return null;
    }

    public boolean isLoaded() {
        boolean z = false;
        synchronized (this.zzrJ) {
            if (this.zzVq == null) {
            } else {
                try {
                    z = this.zzVq.isLoaded();
                } catch (Throwable e) {
                    zzqf.zzc("Could not forward isLoaded to RewardedVideoAd", e);
                }
            }
        }
        return z;
    }

    public void loadAd(String str, AdRequest adRequest) {
        synchronized (this.zzrJ) {
            if (this.zzVq == null) {
                return;
            }
            try {
                this.zzVq.zza(zzef.zzeD().zza(this.mContext, adRequest.zzbp(), str));
            } catch (Throwable e) {
                zzqf.zzc("Could not forward loadAd to RewardedVideoAd", e);
            }
        }
    }

    public void pause() {
        pause(null);
    }

    public void pause(Context context) {
        synchronized (this.zzrJ) {
            if (this.zzVq == null) {
                return;
            }
            try {
                this.zzVq.zzf(zzd.zzA(context));
            } catch (Throwable e) {
                zzqf.zzc("Could not forward pause to RewardedVideoAd", e);
            }
        }
    }

    public void resume() {
        resume(null);
    }

    public void resume(Context context) {
        synchronized (this.zzrJ) {
            if (this.zzVq == null) {
                return;
            }
            try {
                this.zzVq.zzg(zzd.zzA(context));
            } catch (Throwable e) {
                zzqf.zzc("Could not forward resume to RewardedVideoAd", e);
            }
        }
    }

    public void setRewardedVideoAdListener(RewardedVideoAdListener rewardedVideoAdListener) {
        synchronized (this.zzrJ) {
            this.zzcJ = rewardedVideoAdListener;
            if (this.zzVq != null) {
                try {
                    this.zzVq.zza(new zznz(rewardedVideoAdListener));
                } catch (Throwable e) {
                    zzqf.zzc("Could not forward setRewardedVideoAdListener to RewardedVideoAd", e);
                }
            }
        }
    }

    public void setUserId(String str) {
        zzqf.zzbh("RewardedVideoAd.setUserId() is deprecated. Please do not call this method.");
    }

    public void show() {
        synchronized (this.zzrJ) {
            if (this.zzVq == null) {
                return;
            }
            try {
                this.zzVq.show();
            } catch (Throwable e) {
                zzqf.zzc("Could not forward show to RewardedVideoAd", e);
            }
        }
    }
}
