package com.google.android.gms.ads.internal;

import android.os.Debug;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewParent;
import com.google.android.gms.ads.internal.overlay.zzq;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.util.zzj;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.internal.zzcs;
import com.google.android.gms.internal.zzdx;
import com.google.android.gms.internal.zzec;
import com.google.android.gms.internal.zzed;
import com.google.android.gms.internal.zzeg;
import com.google.android.gms.internal.zzel;
import com.google.android.gms.internal.zzeo;
import com.google.android.gms.internal.zzep;
import com.google.android.gms.internal.zzev;
import com.google.android.gms.internal.zzex;
import com.google.android.gms.internal.zzfa;
import com.google.android.gms.internal.zzfc;
import com.google.android.gms.internal.zzfr;
import com.google.android.gms.internal.zzft;
import com.google.android.gms.internal.zzgd;
import com.google.android.gms.internal.zzgj;
import com.google.android.gms.internal.zzgl;
import com.google.android.gms.internal.zzgp;
import com.google.android.gms.internal.zzhz;
import com.google.android.gms.internal.zzle;
import com.google.android.gms.internal.zzli;
import com.google.android.gms.internal.zzme;
import com.google.android.gms.internal.zznq;
import com.google.android.gms.internal.zznw;
import com.google.android.gms.internal.zzoo;
import com.google.android.gms.internal.zzpb;
import com.google.android.gms.internal.zzpc;
import com.google.android.gms.internal.zzpg;
import com.google.android.gms.internal.zzph;
import com.google.android.gms.internal.zzqf;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CountDownLatch;

@zzme
public abstract class zza extends com.google.android.gms.internal.zzet.zza implements zzq, zzdx, zzhz, com.google.android.gms.internal.zzlq.zza, com.google.android.gms.internal.zzmf.zza, zzpg {
    protected zzgl zzsn;
    protected zzgj zzso;
    protected zzgj zzsp;
    protected boolean zzsq;
    protected final zzt zzsr;
    protected final zzx zzss;
    @Nullable
    protected transient zzec zzst;
    protected final zzcs zzsu;
    protected final zze zzsv;

    /* renamed from: com.google.android.gms.ads.internal.zza.1 */
    class C09281 extends TimerTask {
        final /* synthetic */ CountDownLatch zzsw;
        final /* synthetic */ Timer zzsx;
        final /* synthetic */ zza zzsy;

        C09281(zza com_google_android_gms_ads_internal_zza, CountDownLatch countDownLatch, Timer timer) {
            this.zzsy = com_google_android_gms_ads_internal_zza;
            this.zzsw = countDownLatch;
            this.zzsx = timer;
        }

        public void run() {
            if (((long) ((Integer) zzgd.zzEB.get()).intValue()) != this.zzsw.getCount()) {
                zzqf.zzbf("Stopping method tracing");
                Debug.stopMethodTracing();
                if (this.zzsw.getCount() == 0) {
                    this.zzsx.cancel();
                    return;
                }
            }
            String concat = String.valueOf(this.zzsy.zzss.zzqn.getPackageName()).concat("_adsTrace_");
            try {
                zzqf.zzbf("Starting method tracing");
                this.zzsw.countDown();
                Debug.startMethodTracing(new StringBuilder(String.valueOf(concat).length() + 20).append(concat).append(zzw.zzcS().currentTimeMillis()).toString(), ((Integer) zzgd.zzEC.get()).intValue());
            } catch (Throwable e) {
                zzqf.zzc("Exception occurred while starting method tracing.", e);
            }
        }
    }

    zza(zzx com_google_android_gms_ads_internal_zzx, @Nullable zzt com_google_android_gms_ads_internal_zzt, zze com_google_android_gms_ads_internal_zze) {
        this.zzsq = false;
        this.zzss = com_google_android_gms_ads_internal_zzx;
        if (com_google_android_gms_ads_internal_zzt == null) {
            com_google_android_gms_ads_internal_zzt = new zzt(this);
        }
        this.zzsr = com_google_android_gms_ads_internal_zzt;
        this.zzsv = com_google_android_gms_ads_internal_zze;
        zzw.zzcM().zzK(this.zzss.zzqn);
        zzw.zzcQ().zzc(this.zzss.zzqn, this.zzss.zzvn);
        zzw.zzcR().initialize(this.zzss.zzqn);
        this.zzsu = zzw.zzcQ().zzkx();
        zzw.zzcP().initialize(this.zzss.zzqn);
        zzbz();
    }

    private zzec zza(zzec com_google_android_gms_internal_zzec) {
        return (!zzj.zzbb(this.zzss.zzqn) || com_google_android_gms_internal_zzec.zzzb == null) ? com_google_android_gms_internal_zzec : new zzed(com_google_android_gms_internal_zzec).zza(null).zzeC();
    }

    private TimerTask zza(Timer timer, CountDownLatch countDownLatch) {
        return new C09281(this, countDownLatch, timer);
    }

    private void zzbz() {
        if (((Boolean) zzgd.zzEz.get()).booleanValue()) {
            Timer timer = new Timer();
            timer.schedule(zza(timer, new CountDownLatch(((Integer) zzgd.zzEB.get()).intValue())), 0, ((Long) zzgd.zzEA.get()).longValue());
        }
    }

    public void destroy() {
        zzac.zzdj("destroy must be called on the main UI thread.");
        this.zzsr.cancel();
        this.zzsu.zzk(this.zzss.zzvs);
        this.zzss.destroy();
    }

    public boolean isLoading() {
        return this.zzsq;
    }

    public boolean isReady() {
        zzac.zzdj("isLoaded must be called on the main UI thread.");
        return this.zzss.zzvp == null && this.zzss.zzvq == null && this.zzss.zzvs != null;
    }

    public void onAdClicked() {
        if (this.zzss.zzvs == null) {
            zzqf.zzbh("Ad state was null when trying to ping click URLs.");
            return;
        }
        zzqf.zzbf("Pinging click URLs.");
        if (this.zzss.zzvu != null) {
            this.zzss.zzvu.zzjW();
        }
        if (this.zzss.zzvs.zzKF != null) {
            String zzF = zzw.zzdl().zzF(this.zzss.zzqn);
            zzw.zzcM().zza(this.zzss.zzqn, this.zzss.zzvn.zzba, zza(zzF, this.zzss.zzvs.zzKF));
            if (this.zzss.zzvs.zzKF.size() > 0) {
                zzw.zzdl().zzf(this.zzss.zzqn, zzF);
            }
        }
        if (this.zzss.zzvv != null) {
            try {
                this.zzss.zzvv.onAdClicked();
            } catch (Throwable e) {
                zzqf.zzc("Could not notify onAdClicked event.", e);
            }
        }
    }

    public void onAppEvent(String str, @Nullable String str2) {
        if (this.zzss.zzvx != null) {
            try {
                this.zzss.zzvx.onAppEvent(str, str2);
            } catch (Throwable e) {
                zzqf.zzc("Could not call the AppEventListener.", e);
            }
        }
    }

    public void pause() {
        zzac.zzdj("pause must be called on the main UI thread.");
    }

    public void resume() {
        zzac.zzdj("resume must be called on the main UI thread.");
    }

    public void setManualImpressionsEnabled(boolean z) {
        throw new UnsupportedOperationException("Attempt to call setManualImpressionsEnabled for an unsupported ad type.");
    }

    public void setUserId(String str) {
        zzqf.zzbh("RewardedVideoAd.setUserId() is deprecated. Please do not call this method.");
    }

    public void stopLoading() {
        zzac.zzdj("stopLoading must be called on the main UI thread.");
        this.zzsq = false;
        this.zzss.zzi(true);
    }

    protected List<String> zza(String str, List<String> list) {
        if (str == null) {
            return list;
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (String zze : list) {
            arrayList.add(zze(str, zze));
        }
        return arrayList;
    }

    public void zza(zzeg com_google_android_gms_internal_zzeg) {
        zzac.zzdj("setAdSize must be called on the main UI thread.");
        this.zzss.zzvr = com_google_android_gms_internal_zzeg;
        if (!(this.zzss.zzvs == null || this.zzss.zzvs.zzNH == null || this.zzss.zzvO != 0)) {
            this.zzss.zzvs.zzNH.zza(com_google_android_gms_internal_zzeg);
        }
        if (this.zzss.zzvo != null) {
            if (this.zzss.zzvo.getChildCount() > 1) {
                this.zzss.zzvo.removeView(this.zzss.zzvo.getNextView());
            }
            this.zzss.zzvo.setMinimumWidth(com_google_android_gms_internal_zzeg.widthPixels);
            this.zzss.zzvo.setMinimumHeight(com_google_android_gms_internal_zzeg.heightPixels);
            this.zzss.zzvo.requestLayout();
        }
    }

    public void zza(zzeo com_google_android_gms_internal_zzeo) {
        zzac.zzdj("setAdListener must be called on the main UI thread.");
        this.zzss.zzvv = com_google_android_gms_internal_zzeo;
    }

    public void zza(zzep com_google_android_gms_internal_zzep) {
        zzac.zzdj("setAdListener must be called on the main UI thread.");
        this.zzss.zzvw = com_google_android_gms_internal_zzep;
    }

    public void zza(zzev com_google_android_gms_internal_zzev) {
        zzac.zzdj("setAppEventListener must be called on the main UI thread.");
        this.zzss.zzvx = com_google_android_gms_internal_zzev;
    }

    public void zza(zzex com_google_android_gms_internal_zzex) {
        zzac.zzdj("setCorrelationIdProvider must be called on the main UI thread");
        this.zzss.zzvy = com_google_android_gms_internal_zzex;
    }

    public void zza(@Nullable zzfc com_google_android_gms_internal_zzfc) {
        zzac.zzdj("setIconAdOptions must be called on the main UI thread.");
        this.zzss.zzvH = com_google_android_gms_internal_zzfc;
    }

    public void zza(@Nullable zzft com_google_android_gms_internal_zzft) {
        zzac.zzdj("setVideoOptions must be called on the main UI thread.");
        this.zzss.zzvG = com_google_android_gms_internal_zzft;
    }

    public void zza(zzgp com_google_android_gms_internal_zzgp) {
        throw new IllegalStateException("setOnCustomRenderedAdLoadedListener is not supported for current ad type");
    }

    public void zza(zzle com_google_android_gms_internal_zzle) {
        throw new IllegalStateException("setInAppPurchaseListener is not supported for current ad type");
    }

    public void zza(zzli com_google_android_gms_internal_zzli, String str) {
        throw new IllegalStateException("setPlayStorePurchaseParams is not supported for current ad type");
    }

    public void zza(zznw com_google_android_gms_internal_zznw) {
        zzac.zzdj("setRewardedVideoAdListener can only be called from the UI thread.");
        this.zzss.zzvJ = com_google_android_gms_internal_zznw;
    }

    protected void zza(@Nullable zzoo com_google_android_gms_internal_zzoo) {
        if (this.zzss.zzvJ != null) {
            try {
                String str = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING;
                int i = 1;
                if (com_google_android_gms_internal_zzoo != null) {
                    str = com_google_android_gms_internal_zzoo.type;
                    i = com_google_android_gms_internal_zzoo.zzVP;
                }
                this.zzss.zzvJ.zza(new zznq(str, i));
            } catch (Throwable e) {
                zzqf.zzc("Could not call RewardedVideoAdListener.onRewarded().", e);
            }
        }
    }

    public void zza(com.google.android.gms.internal.zzpb.zza com_google_android_gms_internal_zzpb_zza) {
        if (!(com_google_android_gms_internal_zzpb_zza.zzWm.zzSr == -1 || TextUtils.isEmpty(com_google_android_gms_internal_zzpb_zza.zzWm.zzSA))) {
            long zzw = zzw(com_google_android_gms_internal_zzpb_zza.zzWm.zzSA);
            if (zzw != -1) {
                zzgj zzc = this.zzsn.zzc(zzw + com_google_android_gms_internal_zzpb_zza.zzWm.zzSr);
                this.zzsn.zza(zzc, "stc");
            }
        }
        this.zzsn.zzX(com_google_android_gms_internal_zzpb_zza.zzWm.zzSA);
        this.zzsn.zza(this.zzso, "arf");
        this.zzsp = this.zzsn.zzfB();
        this.zzsn.zzh("gqi", com_google_android_gms_internal_zzpb_zza.zzWm.zzSB);
        this.zzss.zzvp = null;
        this.zzss.zzvt = com_google_android_gms_internal_zzpb_zza;
        zza(com_google_android_gms_internal_zzpb_zza, this.zzsn);
    }

    protected abstract void zza(com.google.android.gms.internal.zzpb.zza com_google_android_gms_internal_zzpb_zza, zzgl com_google_android_gms_internal_zzgl);

    public void zza(HashSet<zzpc> hashSet) {
        this.zzss.zza(hashSet);
    }

    protected abstract boolean zza(zzec com_google_android_gms_internal_zzec, zzgl com_google_android_gms_internal_zzgl);

    boolean zza(zzpb com_google_android_gms_internal_zzpb) {
        return false;
    }

    protected abstract boolean zza(@Nullable zzpb com_google_android_gms_internal_zzpb, zzpb com_google_android_gms_internal_zzpb2);

    protected void zzb(View view) {
        com.google.android.gms.ads.internal.zzx.zza com_google_android_gms_ads_internal_zzx_zza = this.zzss.zzvo;
        if (com_google_android_gms_ads_internal_zzx_zza != null) {
            com_google_android_gms_ads_internal_zzx_zza.addView(view, zzw.zzcO().zzkT());
        }
    }

    public void zzb(zzpb com_google_android_gms_internal_zzpb) {
        this.zzsn.zza(this.zzsp, "awr");
        this.zzss.zzvq = null;
        if (!(com_google_android_gms_internal_zzpb.errorCode == -2 || com_google_android_gms_internal_zzpb.errorCode == 3)) {
            zzw.zzcQ().zzb(this.zzss.zzdm());
        }
        if (com_google_android_gms_internal_zzpb.errorCode == -1) {
            this.zzsq = false;
            return;
        }
        if (zza(com_google_android_gms_internal_zzpb)) {
            zzqf.zzbf("Ad refresh scheduled.");
        }
        if (com_google_android_gms_internal_zzpb.errorCode != -2) {
            zzh(com_google_android_gms_internal_zzpb.errorCode);
            return;
        }
        if (this.zzss.zzvM == null) {
            this.zzss.zzvM = new zzph(this.zzss.zzvl);
        }
        this.zzsu.zzj(this.zzss.zzvs);
        if (zza(this.zzss.zzvs, com_google_android_gms_internal_zzpb)) {
            this.zzss.zzvs = com_google_android_gms_internal_zzpb;
            this.zzss.zzdv();
            this.zzsn.zzh("is_mraid", this.zzss.zzvs.zzdD() ? "1" : "0");
            this.zzsn.zzh("is_mediation", this.zzss.zzvs.zzSn ? "1" : "0");
            if (!(this.zzss.zzvs.zzNH == null || this.zzss.zzvs.zzNH.zzlv() == null)) {
                this.zzsn.zzh("is_delay_pl", this.zzss.zzvs.zzNH.zzlv().zzlR() ? "1" : "0");
            }
            this.zzsn.zza(this.zzso, "ttc");
            if (zzw.zzcQ().zzkk() != null) {
                zzw.zzcQ().zzkk().zza(this.zzsn);
            }
            if (this.zzss.zzdq()) {
                zzbJ();
            }
        }
        if (com_google_android_gms_internal_zzpb.zzKI != null) {
            zzw.zzcM().zza(this.zzss.zzqn, com_google_android_gms_internal_zzpb.zzKI);
        }
    }

    public boolean zzb(zzec com_google_android_gms_internal_zzec) {
        zzac.zzdj("loadAd must be called on the main UI thread.");
        zzw.zzcR().zzev();
        if (((Boolean) zzgd.zzCX.get()).booleanValue()) {
            zzec.zzi(com_google_android_gms_internal_zzec);
        }
        zzec zza = zza(com_google_android_gms_internal_zzec);
        if (this.zzss.zzvp == null && this.zzss.zzvq == null) {
            zzqf.zzbg("Starting ad request.");
            zzbA();
            this.zzso = this.zzsn.zzfB();
            if (!zza.zzyW) {
                String valueOf = String.valueOf(zzel.zzeT().zzad(this.zzss.zzqn));
                zzqf.zzbg(new StringBuilder(String.valueOf(valueOf).length() + 71).append("Use AdRequest.Builder.addTestDevice(\"").append(valueOf).append("\") to get test ads on this device.").toString());
            }
            this.zzsr.zzg(zza);
            this.zzsq = zza(zza, this.zzsn);
            return this.zzsq;
        }
        if (this.zzst != null) {
            zzqf.zzbh("Aborting last ad request since another ad request is already in progress. The current request object will still be cached for future refreshes.");
        } else {
            zzqf.zzbh("Loading already in progress, saving this object for future refreshes.");
        }
        this.zzst = zza;
        return false;
    }

    public void zzbA() {
        this.zzsn = new zzgl(((Boolean) zzgd.zzBZ.get()).booleanValue(), "load_ad", this.zzss.zzvr.zzzy);
        this.zzso = new zzgj(-1, null, null);
        this.zzsp = new zzgj(-1, null, null);
    }

    public IObjectWrapper zzbB() {
        zzac.zzdj("getAdFrame must be called on the main UI thread.");
        return zzd.zzA(this.zzss.zzvo);
    }

    @Nullable
    public zzeg zzbC() {
        zzac.zzdj("getAdSize must be called on the main UI thread.");
        return this.zzss.zzvr == null ? null : new zzfr(this.zzss.zzvr);
    }

    public void zzbD() {
        zzbH();
    }

    public void zzbE() {
        zzac.zzdj("recordManualImpression must be called on the main UI thread.");
        if (this.zzss.zzvs == null) {
            zzqf.zzbh("Ad state was null when trying to ping manual tracking URLs.");
            return;
        }
        zzqf.zzbf("Pinging manual tracking URLs.");
        if (this.zzss.zzvs.zzSp != null && !this.zzss.zzvs.zzWk) {
            zzw.zzcM().zza(this.zzss.zzqn, this.zzss.zzvn.zzba, this.zzss.zzvs.zzSp);
            this.zzss.zzvs.zzWk = true;
            zzbL();
        }
    }

    public zzfa zzbF() {
        return null;
    }

    protected void zzbG() {
        zzqf.zzbg("Ad closing.");
        if (this.zzss.zzvw != null) {
            try {
                this.zzss.zzvw.onAdClosed();
            } catch (Throwable e) {
                zzqf.zzc("Could not call AdListener.onAdClosed().", e);
            }
        }
        if (this.zzss.zzvJ != null) {
            try {
                this.zzss.zzvJ.onRewardedVideoAdClosed();
            } catch (Throwable e2) {
                zzqf.zzc("Could not call RewardedVideoAdListener.onRewardedVideoAdClosed().", e2);
            }
        }
    }

    protected void zzbH() {
        zzqf.zzbg("Ad leaving application.");
        if (this.zzss.zzvw != null) {
            try {
                this.zzss.zzvw.onAdLeftApplication();
            } catch (Throwable e) {
                zzqf.zzc("Could not call AdListener.onAdLeftApplication().", e);
            }
        }
        if (this.zzss.zzvJ != null) {
            try {
                this.zzss.zzvJ.onRewardedVideoAdLeftApplication();
            } catch (Throwable e2) {
                zzqf.zzc("Could not call  RewardedVideoAdListener.onRewardedVideoAdLeftApplication().", e2);
            }
        }
    }

    protected void zzbI() {
        zzqf.zzbg("Ad opening.");
        if (this.zzss.zzvw != null) {
            try {
                this.zzss.zzvw.onAdOpened();
            } catch (Throwable e) {
                zzqf.zzc("Could not call AdListener.onAdOpened().", e);
            }
        }
        if (this.zzss.zzvJ != null) {
            try {
                this.zzss.zzvJ.onRewardedVideoAdOpened();
            } catch (Throwable e2) {
                zzqf.zzc("Could not call RewardedVideoAdListener.onRewardedVideoAdOpened().", e2);
            }
        }
    }

    protected void zzbJ() {
        zzqf.zzbg("Ad finished loading.");
        this.zzsq = false;
        if (this.zzss.zzvw != null) {
            try {
                this.zzss.zzvw.onAdLoaded();
            } catch (Throwable e) {
                zzqf.zzc("Could not call AdListener.onAdLoaded().", e);
            }
        }
        if (this.zzss.zzvJ != null) {
            try {
                this.zzss.zzvJ.onRewardedVideoAdLoaded();
            } catch (Throwable e2) {
                zzqf.zzc("Could not call RewardedVideoAdListener.onRewardedVideoAdLoaded().", e2);
            }
        }
    }

    protected void zzbK() {
        if (this.zzss.zzvJ != null) {
            try {
                this.zzss.zzvJ.onRewardedVideoStarted();
            } catch (Throwable e) {
                zzqf.zzc("Could not call RewardedVideoAdListener.onVideoStarted().", e);
            }
        }
    }

    public void zzbL() {
        zzd(this.zzss.zzvs);
    }

    public zze zzby() {
        return this.zzsv;
    }

    protected void zzc(@Nullable zzpb com_google_android_gms_internal_zzpb) {
        if (com_google_android_gms_internal_zzpb == null) {
            zzqf.zzbh("Ad state was null when trying to ping impression URLs.");
            return;
        }
        zzqf.zzbf("Pinging Impression URLs.");
        if (this.zzss.zzvu != null) {
            this.zzss.zzvu.zzjV();
        }
        if (com_google_android_gms_internal_zzpb.zzKG != null && !com_google_android_gms_internal_zzpb.zzWj) {
            String zzF = zzw.zzdl().zzF(this.zzss.zzqn);
            zzw.zzcM().zza(this.zzss.zzqn, this.zzss.zzvn.zzba, zza(zzF, com_google_android_gms_internal_zzpb.zzKG));
            com_google_android_gms_internal_zzpb.zzWj = true;
            zzd(com_google_android_gms_internal_zzpb);
            if (com_google_android_gms_internal_zzpb.zzKG.size() > 0) {
                zzw.zzdl().zzg(this.zzss.zzqn, zzF);
            }
        }
    }

    protected boolean zzc(zzec com_google_android_gms_internal_zzec) {
        if (this.zzss.zzvo == null) {
            return false;
        }
        ViewParent parent = this.zzss.zzvo.getParent();
        if (!(parent instanceof View)) {
            return false;
        }
        View view = (View) parent;
        return zzw.zzcM().zza(view, view.getContext());
    }

    public void zzd(zzec com_google_android_gms_internal_zzec) {
        if (zzc(com_google_android_gms_internal_zzec)) {
            zzb(com_google_android_gms_internal_zzec);
            return;
        }
        zzqf.zzbg("Ad is not visible. Not refreshing ad.");
        this.zzsr.zzh(com_google_android_gms_internal_zzec);
    }

    protected void zzd(zzpb com_google_android_gms_internal_zzpb) {
        if (com_google_android_gms_internal_zzpb != null && !TextUtils.isEmpty(com_google_android_gms_internal_zzpb.zzSJ) && !com_google_android_gms_internal_zzpb.zzWl && zzw.zzcU().zzkZ()) {
            zzqf.zzbf("Sending troubleshooting signals to the server.");
            zzw.zzcU().zza(this.zzss.zzqn, this.zzss.zzvn.zzba, com_google_android_gms_internal_zzpb.zzSJ, this.zzss.zzvl);
            com_google_android_gms_internal_zzpb.zzWl = true;
        }
    }

    protected String zze(String str, String str2) {
        return (str == null || TextUtils.isEmpty(str2)) ? str2 : zzw.zzcM().zzc(str2, "fbs_aeid", str).toString();
    }

    protected void zzh(int i) {
        zzqf.zzbh("Failed to load ad: " + i);
        this.zzsq = false;
        if (this.zzss.zzvw != null) {
            try {
                this.zzss.zzvw.onAdFailedToLoad(i);
            } catch (Throwable e) {
                zzqf.zzc("Could not call AdListener.onAdFailedToLoad().", e);
            }
        }
        if (this.zzss.zzvJ != null) {
            try {
                this.zzss.zzvJ.onRewardedVideoAdFailedToLoad(i);
            } catch (Throwable e2) {
                zzqf.zzc("Could not call RewardedVideoAdListener.onRewardedVideoAdFailedToLoad().", e2);
            }
        }
    }

    long zzw(String str) {
        int indexOf = str.indexOf("ufe");
        int indexOf2 = str.indexOf(44, indexOf);
        if (indexOf2 == -1) {
            indexOf2 = str.length();
        }
        try {
            return Long.parseLong(str.substring(indexOf + 4, indexOf2));
        } catch (IndexOutOfBoundsException e) {
            zzqf.zzbh("Invalid index for Url fetch time in CSI latency info.");
            return -1;
        } catch (NumberFormatException e2) {
            zzqf.zzbh("Cannot find valid format of Url fetch time in CSI latency info.");
            return -1;
        }
    }
}
