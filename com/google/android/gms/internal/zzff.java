package com.google.android.gms.internal;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.Correlator;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.doubleclick.OnCustomRenderedAdLoadedListener;
import com.google.android.gms.ads.purchase.InAppPurchaseListener;
import com.google.android.gms.ads.purchase.PlayStorePurchaseListener;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.zzd;
import java.util.concurrent.atomic.AtomicBoolean;

@zzme
public class zzff {
    private final zzjz zzAj;
    private final AtomicBoolean zzAk;
    private final VideoController zzAl;
    final zzen zzAm;
    private Correlator zzAn;
    private zzet zzAo;
    private InAppPurchaseListener zzAp;
    private OnCustomRenderedAdLoadedListener zzAq;
    private PlayStorePurchaseListener zzAr;
    private String zzAs;
    private ViewGroup zzAt;
    private int zzAu;
    private VideoOptions zzrX;
    private final zzef zzrw;
    private boolean zzsS;
    private String zzts;
    private zzdx zzyR;
    private AdListener zzyS;
    private AppEventListener zzzE;
    private AdSize[] zzzF;

    /* renamed from: com.google.android.gms.internal.zzff.1 */
    class C11731 extends zzen {
        final /* synthetic */ zzff zzAv;

        C11731(zzff com_google_android_gms_internal_zzff) {
            this.zzAv = com_google_android_gms_internal_zzff;
        }

        public void onAdFailedToLoad(int i) {
            this.zzAv.zzAl.zza(this.zzAv.zzbs());
            super.onAdFailedToLoad(i);
        }

        public void onAdLoaded() {
            this.zzAv.zzAl.zza(this.zzAv.zzbs());
            super.onAdLoaded();
        }
    }

    public zzff(ViewGroup viewGroup) {
        this(viewGroup, null, false, zzef.zzeD(), 0);
    }

    public zzff(ViewGroup viewGroup, int i) {
        this(viewGroup, null, false, zzef.zzeD(), i);
    }

    public zzff(ViewGroup viewGroup, AttributeSet attributeSet, boolean z) {
        this(viewGroup, attributeSet, z, zzef.zzeD(), 0);
    }

    public zzff(ViewGroup viewGroup, AttributeSet attributeSet, boolean z, int i) {
        this(viewGroup, attributeSet, z, zzef.zzeD(), i);
    }

    zzff(ViewGroup viewGroup, AttributeSet attributeSet, boolean z, zzef com_google_android_gms_internal_zzef, int i) {
        this(viewGroup, attributeSet, z, com_google_android_gms_internal_zzef, null, i);
    }

    zzff(ViewGroup viewGroup, AttributeSet attributeSet, boolean z, zzef com_google_android_gms_internal_zzef, zzet com_google_android_gms_internal_zzet, int i) {
        this.zzAj = new zzjz();
        this.zzAl = new VideoController();
        this.zzAm = new C11731(this);
        this.zzAt = viewGroup;
        this.zzrw = com_google_android_gms_internal_zzef;
        this.zzAo = com_google_android_gms_internal_zzet;
        this.zzAk = new AtomicBoolean(false);
        this.zzAu = i;
        if (attributeSet != null) {
            Context context = viewGroup.getContext();
            try {
                zzej com_google_android_gms_internal_zzej = new zzej(context, attributeSet);
                this.zzzF = com_google_android_gms_internal_zzej.zzm(z);
                this.zzts = com_google_android_gms_internal_zzej.getAdUnitId();
                if (viewGroup.isInEditMode()) {
                    zzel.zzeT().zza(viewGroup, zza(context, this.zzzF[0], this.zzAu), "Ads by Google");
                }
            } catch (IllegalArgumentException e) {
                zzel.zzeT().zza(viewGroup, new zzeg(context, AdSize.BANNER), e.getMessage(), e.getMessage());
            }
        }
    }

    private static zzeg zza(Context context, AdSize adSize, int i) {
        zzeg com_google_android_gms_internal_zzeg = new zzeg(context, adSize);
        com_google_android_gms_internal_zzeg.zzl(zzz(i));
        return com_google_android_gms_internal_zzeg;
    }

    private static zzeg zza(Context context, AdSize[] adSizeArr, int i) {
        zzeg com_google_android_gms_internal_zzeg = new zzeg(context, adSizeArr);
        com_google_android_gms_internal_zzeg.zzl(zzz(i));
        return com_google_android_gms_internal_zzeg;
    }

    private void zzfh() {
        try {
            IObjectWrapper zzbB = this.zzAo.zzbB();
            if (zzbB != null) {
                this.zzAt.addView((View) zzd.zzF(zzbB));
            }
        } catch (Throwable e) {
            zzqf.zzc("Failed to get an ad frame.", e);
        }
    }

    private static boolean zzz(int i) {
        return i == 1;
    }

    public void destroy() {
        try {
            if (this.zzAo != null) {
                this.zzAo.destroy();
            }
        } catch (Throwable e) {
            zzqf.zzc("Failed to destroy AdView.", e);
        }
    }

    public AdListener getAdListener() {
        return this.zzyS;
    }

    public AdSize getAdSize() {
        try {
            if (this.zzAo != null) {
                zzeg zzbC = this.zzAo.zzbC();
                if (zzbC != null) {
                    return zzbC.zzeF();
                }
            }
        } catch (Throwable e) {
            zzqf.zzc("Failed to get the current AdSize.", e);
        }
        return this.zzzF != null ? this.zzzF[0] : null;
    }

    public AdSize[] getAdSizes() {
        return this.zzzF;
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

    public VideoController getVideoController() {
        return this.zzAl;
    }

    public VideoOptions getVideoOptions() {
        return this.zzrX;
    }

    public boolean isLoading() {
        try {
            if (this.zzAo != null) {
                return this.zzAo.isLoading();
            }
        } catch (Throwable e) {
            zzqf.zzc("Failed to check if ad is loading.", e);
        }
        return false;
    }

    public void pause() {
        try {
            if (this.zzAo != null) {
                this.zzAo.pause();
            }
        } catch (Throwable e) {
            zzqf.zzc("Failed to call pause.", e);
        }
    }

    public void recordManualImpression() {
        if (!this.zzAk.getAndSet(true)) {
            try {
                if (this.zzAo != null) {
                    this.zzAo.zzbE();
                }
            } catch (Throwable e) {
                zzqf.zzc("Failed to record impression.", e);
            }
        }
    }

    public void resume() {
        try {
            if (this.zzAo != null) {
                this.zzAo.resume();
            }
        } catch (Throwable e) {
            zzqf.zzc("Failed to call resume.", e);
        }
    }

    public void setAdListener(AdListener adListener) {
        this.zzyS = adListener;
        this.zzAm.zza(adListener);
    }

    public void setAdSizes(AdSize... adSizeArr) {
        if (this.zzzF != null) {
            throw new IllegalStateException("The ad size can only be set once on AdView.");
        }
        zza(adSizeArr);
    }

    public void setAdUnitId(String str) {
        if (this.zzts != null) {
            throw new IllegalStateException("The ad unit ID can only be set once on AdView.");
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

    public void setManualImpressionsEnabled(boolean z) {
        this.zzsS = z;
        try {
            if (this.zzAo != null) {
                this.zzAo.setManualImpressionsEnabled(this.zzsS);
            }
        } catch (Throwable e) {
            zzqf.zzc("Failed to set manual impressions.", e);
        }
    }

    public void setOnCustomRenderedAdLoadedListener(OnCustomRenderedAdLoadedListener onCustomRenderedAdLoadedListener) {
        this.zzAq = onCustomRenderedAdLoadedListener;
        try {
            if (this.zzAo != null) {
                this.zzAo.zza(onCustomRenderedAdLoadedListener != null ? new zzgq(onCustomRenderedAdLoadedListener) : null);
            }
        } catch (Throwable e) {
            zzqf.zzc("Failed to set the onCustomRenderedAdLoadedListener.", e);
        }
    }

    public void setPlayStorePurchaseParams(PlayStorePurchaseListener playStorePurchaseListener, String str) {
        if (this.zzAp != null) {
            throw new IllegalStateException("InAppPurchaseListener has already been set.");
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

    public void setVideoOptions(VideoOptions videoOptions) {
        this.zzrX = videoOptions;
        try {
            if (this.zzAo != null) {
                this.zzAo.zza(videoOptions == null ? null : new zzft(videoOptions));
            }
        } catch (Throwable e) {
            zzqf.zzc("Failed to set video options.", e);
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
                zzfi();
            }
            if (this.zzAo.zzb(this.zzrw.zza(this.zzAt.getContext(), com_google_android_gms_internal_zzfe))) {
                this.zzAj.zzi(com_google_android_gms_internal_zzfe.zzfd());
            }
        } catch (Throwable e) {
            zzqf.zzc("Failed to load ad.", e);
        }
    }

    public void zza(AdSize... adSizeArr) {
        this.zzzF = adSizeArr;
        try {
            if (this.zzAo != null) {
                this.zzAo.zza(zza(this.zzAt.getContext(), this.zzzF, this.zzAu));
            }
        } catch (Throwable e) {
            zzqf.zzc("Failed to set the ad size.", e);
        }
        this.zzAt.requestLayout();
    }

    public boolean zzb(zzeg com_google_android_gms_internal_zzeg) {
        return "search_v2".equals(com_google_android_gms_internal_zzeg.zzzy);
    }

    public zzfa zzbs() {
        zzfa com_google_android_gms_internal_zzfa = null;
        if (this.zzAo != null) {
            try {
                com_google_android_gms_internal_zzfa = this.zzAo.zzbF();
            } catch (Throwable e) {
                zzqf.zzc("Failed to retrieve VideoController.", e);
            }
        }
        return com_google_android_gms_internal_zzfa;
    }

    void zzfi() {
        if ((this.zzzF == null || this.zzts == null) && this.zzAo == null) {
            throw new IllegalStateException("The ad size and ad unit ID must be set before loadAd is called.");
        }
        this.zzAo = zzfj();
        this.zzAo.zza(new zzdz(this.zzAm));
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
        if (this.zzrX != null) {
            this.zzAo.zza(new zzft(this.zzrX));
        }
        this.zzAo.setManualImpressionsEnabled(this.zzsS);
        zzfh();
    }

    protected zzet zzfj() {
        Context context = this.zzAt.getContext();
        zzeg zza = zza(context, this.zzzF, this.zzAu);
        return zzb(zza) ? zzel.zzeU().zza(context, zza, this.zzts) : zzel.zzeU().zza(context, zza, this.zzts, this.zzAj);
    }
}
