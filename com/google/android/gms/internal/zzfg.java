package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.Correlator;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.doubleclick.OnCustomRenderedAdLoadedListener;
import com.google.android.gms.ads.doubleclick.PublisherInterstitialAd;
import com.google.android.gms.ads.purchase.InAppPurchaseListener;
import com.google.android.gms.ads.purchase.PlayStorePurchaseListener;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;

@zzme
public class zzfg {
    private final Context mContext;
    private final zzjz zzAj;
    private Correlator zzAn;
    private zzet zzAo;
    private InAppPurchaseListener zzAp;
    private OnCustomRenderedAdLoadedListener zzAq;
    private PlayStorePurchaseListener zzAr;
    private String zzAs;
    private PublisherInterstitialAd zzAw;
    private boolean zzAx;
    private RewardedVideoAdListener zzcJ;
    private final zzef zzrw;
    private String zzts;
    private zzdx zzyR;
    private AdListener zzyS;
    private AppEventListener zzzE;

    public zzfg(Context context) {
        this(context, zzef.zzeD(), null);
    }

    public zzfg(Context context, PublisherInterstitialAd publisherInterstitialAd) {
        this(context, zzef.zzeD(), publisherInterstitialAd);
    }

    public zzfg(Context context, zzef com_google_android_gms_internal_zzef, PublisherInterstitialAd publisherInterstitialAd) {
        this.zzAj = new zzjz();
        this.mContext = context;
        this.zzrw = com_google_android_gms_internal_zzef;
        this.zzAw = publisherInterstitialAd;
    }

    private void zzS(String str) {
        if (this.zzts == null) {
            zzT(str);
        }
        this.zzAo = zzel.zzeU().zzb(this.mContext, this.zzAx ? zzeg.zzeE() : new zzeg(), this.zzts, this.zzAj);
        if (this.zzyS != null) {
            this.zzAo.zza(new zzdz(this.zzyS));
        }
        if (this.zzyR != null) {
            this.zzAo.zza(new zzdy(this.zzyR));
        }
        if (this.zzzE != null) {
            this.zzAo.zza(new zzei(this.zzzE));
        }
        if (this.zzAp != null) {
            this.zzAo.zza(new zzlj(this.zzAp));
        }
        if (this.zzAr != null) {
            this.zzAo.zza(new zzln(this.zzAr), this.zzAs);
        }
        if (this.zzAq != null) {
            this.zzAo.zza(new zzgq(this.zzAq));
        }
        if (this.zzAn != null) {
            this.zzAo.zza(this.zzAn.zzbq());
        }
        if (this.zzcJ != null) {
            this.zzAo.zza(new zznz(this.zzcJ));
        }
    }

    private void zzT(String str) {
        if (this.zzAo == null) {
            throw new IllegalStateException(new StringBuilder(String.valueOf(str).length() + 63).append("The ad unit ID must be set on InterstitialAd before ").append(str).append(" is called.").toString());
        }
    }

    public AdListener getAdListener() {
        return this.zzyS;
    }

    public String getAdUnitId() {
        return this.zzts;
    }

    public AppEventListener getAppEventListener() {
        return this.zzzE;
    }

    public InAppPurchaseListener getInAppPurchaseListener() {
        return this.zzAp;
    }

    public String getMediationAdapterClassName() {
        try {
            if (this.zzAo != null) {
                return this.zzAo.getMediationAdapterClassName();
            }
        } catch (Throwable e) {
            zzqf.zzc("Failed to get the mediation adapter class name.", e);
        }
        return null;
    }

    public OnCustomRenderedAdLoadedListener getOnCustomRenderedAdLoadedListener() {
        return this.zzAq;
    }

    public boolean isLoaded() {
        boolean z = false;
        try {
            if (this.zzAo != null) {
                z = this.zzAo.isReady();
            }
        } catch (Throwable e) {
            zzqf.zzc("Failed to check if ad is ready.", e);
        }
        return z;
    }

    public boolean isLoading() {
        boolean z = false;
        try {
            if (this.zzAo != null) {
                z = this.zzAo.isLoading();
            }
        } catch (Throwable e) {
            zzqf.zzc("Failed to check if ad is loading.", e);
        }
        return z;
    }

    public void setAdListener(AdListener adListener) {
        try {
            this.zzyS = adListener;
            if (this.zzAo != null) {
                this.zzAo.zza(adListener != null ? new zzdz(adListener) : null);
            }
        } catch (Throwable e) {
            zzqf.zzc("Failed to set the AdListener.", e);
        }
    }

    public void setAdUnitId(String str) {
        if (this.zzts != null) {
            throw new IllegalStateException("The ad unit ID can only be set once on InterstitialAd.");
        }
        this.zzts = str;
    }

    public void setAppEventListener(AppEventListener appEventListener) {
        try {
            this.zzzE = appEventListener;
            if (this.zzAo != null) {
                this.zzAo.zza(appEventListener != null ? new zzei(appEventListener) : null);
            }
        } catch (Throwable e) {
            zzqf.zzc("Failed to set the AppEventListener.", e);
        }
    }

    public void setCorrelator(Correlator correlator) {
        this.zzAn = correlator;
        try {
            if (this.zzAo != null) {
                this.zzAo.zza(this.zzAn == null ? null : this.zzAn.zzbq());
            }
        } catch (Throwable e) {
            zzqf.zzc("Failed to set correlator.", e);
        }
    }

    public void setInAppPurchaseListener(InAppPurchaseListener inAppPurchaseListener) {
        if (this.zzAr != null) {
            throw new IllegalStateException("Play store purchase parameter has already been set.");
        }
        try {
            this.zzAp = inAppPurchaseListener;
            if (this.zzAo != null) {
                this.zzAo.zza(inAppPurchaseListener != null ? new zzlj(inAppPurchaseListener) : null);
            }
        } catch (Throwable e) {
            zzqf.zzc("Failed to set the InAppPurchaseListener.", e);
        }
    }

    public void setOnCustomRenderedAdLoadedListener(OnCustomRenderedAdLoadedListener onCustomRenderedAdLoadedListener) {
        try {
            this.zzAq = onCustomRenderedAdLoadedListener;
            if (this.zzAo != null) {
                this.zzAo.zza(onCustomRenderedAdLoadedListener != null ? new zzgq(onCustomRenderedAdLoadedListener) : null);
            }
        } catch (Throwable e) {
            zzqf.zzc("Failed to set the OnCustomRenderedAdLoadedListener.", e);
        }
    }

    public void setPlayStorePurchaseParams(PlayStorePurchaseListener playStorePurchaseListener, String str) {
        if (this.zzAp != null) {
            throw new IllegalStateException("In app purchase parameter has already been set.");
        }
        try {
            this.zzAr = playStorePurchaseListener;
            this.zzAs = str;
            if (this.zzAo != null) {
                this.zzAo.zza(playStorePurchaseListener != null ? new zzln(playStorePurchaseListener) : null, str);
            }
        } catch (Throwable e) {
            zzqf.zzc("Failed to set the play store purchase parameter.", e);
        }
    }

    public void setRewardedVideoAdListener(RewardedVideoAdListener rewardedVideoAdListener) {
        try {
            this.zzcJ = rewardedVideoAdListener;
            if (this.zzAo != null) {
                this.zzAo.zza(rewardedVideoAdListener != null ? new zznz(rewardedVideoAdListener) : null);
            }
        } catch (Throwable e) {
            zzqf.zzc("Failed to set the AdListener.", e);
        }
    }

    public void show() {
        try {
            zzT("show");
            this.zzAo.showInterstitial();
        } catch (Throwable e) {
            zzqf.zzc("Failed to show interstitial.", e);
        }
    }

    public void zza(zzdx com_google_android_gms_internal_zzdx) {
        try {
            this.zzyR = com_google_android_gms_internal_zzdx;
            if (this.zzAo != null) {
                this.zzAo.zza(com_google_android_gms_internal_zzdx != null ? new zzdy(com_google_android_gms_internal_zzdx) : null);
            }
        } catch (Throwable e) {
            zzqf.zzc("Failed to set the AdClickListener.", e);
        }
    }

    public void zza(zzfe com_google_android_gms_internal_zzfe) {
        try {
            if (this.zzAo == null) {
                zzS("loadAd");
            }
            if (this.zzAo.zzb(this.zzrw.zza(this.mContext, com_google_android_gms_internal_zzfe))) {
                this.zzAj.zzi(com_google_android_gms_internal_zzfe.zzfd());
            }
        } catch (Throwable e) {
            zzqf.zzc("Failed to load ad.", e);
        }
    }

    public void zzd(boolean z) {
        this.zzAx = z;
    }
}
