package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Window;
import com.google.ads.mediation.AbstractAdViewAdapter;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.util.zzt;
import com.google.android.gms.internal.zzcy;
import com.google.android.gms.internal.zzec;
import com.google.android.gms.internal.zzeg;
import com.google.android.gms.internal.zzgd;
import com.google.android.gms.internal.zzgl;
import com.google.android.gms.internal.zzih;
import com.google.android.gms.internal.zzin;
import com.google.android.gms.internal.zzjj;
import com.google.android.gms.internal.zzjq;
import com.google.android.gms.internal.zzjr;
import com.google.android.gms.internal.zzka;
import com.google.android.gms.internal.zzme;
import com.google.android.gms.internal.zzmn;
import com.google.android.gms.internal.zznd;
import com.google.android.gms.internal.zzoo;
import com.google.android.gms.internal.zzot;
import com.google.android.gms.internal.zzov;
import com.google.android.gms.internal.zzpb;
import com.google.android.gms.internal.zzpj;
import com.google.android.gms.internal.zzpo;
import com.google.android.gms.internal.zzqf;
import com.google.android.gms.internal.zzqh;
import com.google.android.gms.internal.zzqw;
import com.google.android.gms.internal.zzqx;
import com.google.android.gms.internal.zzqx.zzc;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.Collections;
import org.json.JSONObject;

@zzme
public class zzm extends zzc implements zzih, com.google.android.gms.internal.zzin.zza {
    protected transient boolean zztB;
    private int zztC;
    private boolean zztD;
    private float zztE;
    private final zzov zztF;

    /* renamed from: com.google.android.gms.ads.internal.zzm.1 */
    class C09481 implements zzc {
        final /* synthetic */ zzpb zzsX;
        final /* synthetic */ zzm zztG;

        C09481(zzm com_google_android_gms_ads_internal_zzm, zzpb com_google_android_gms_internal_zzpb) {
            this.zztG = com_google_android_gms_ads_internal_zzm;
            this.zzsX = com_google_android_gms_internal_zzpb;
        }

        public void zzcf() {
            new zzcy(this.zztG.zzss.zzqn, this.zzsX.zzNH.getView()).zza(this.zzsX.zzNH);
        }
    }

    @zzme
    private class zza extends zzpj {
        final /* synthetic */ zzm zztG;
        private final int zztH;

        /* renamed from: com.google.android.gms.ads.internal.zzm.zza.1 */
        class C09491 implements Runnable {
            final /* synthetic */ AdOverlayInfoParcel zztI;
            final /* synthetic */ zza zztJ;

            C09491(zza com_google_android_gms_ads_internal_zzm_zza, AdOverlayInfoParcel adOverlayInfoParcel) {
                this.zztJ = com_google_android_gms_ads_internal_zzm_zza;
                this.zztI = adOverlayInfoParcel;
            }

            public void run() {
                zzw.zzcK().zza(this.zztJ.zztG.zzss.zzqn, this.zztI);
            }
        }

        public zza(zzm com_google_android_gms_ads_internal_zzm, int i) {
            this.zztG = com_google_android_gms_ads_internal_zzm;
            this.zztH = i;
        }

        public void onStop() {
        }

        public void zzco() {
            zzn com_google_android_gms_ads_internal_zzn = new zzn(this.zztG.zzss.zztK, this.zztG.zzcl(), this.zztG.zztD, this.zztG.zztE, this.zztG.zzss.zztK ? this.zztH : -1);
            int requestedOrientation = this.zztG.zzss.zzvs.zzNH.getRequestedOrientation();
            zzpo.zzXC.post(new C09491(this, new AdOverlayInfoParcel(this.zztG, this.zztG, this.zztG, this.zztG.zzss.zzvs.zzNH, requestedOrientation == -1 ? this.zztG.zzss.zzvs.orientation : requestedOrientation, this.zztG.zzss.zzvn, this.zztG.zzss.zzvs.zzSs, com_google_android_gms_ads_internal_zzn)));
        }
    }

    public zzm(Context context, zzeg com_google_android_gms_internal_zzeg, String str, zzka com_google_android_gms_internal_zzka, zzqh com_google_android_gms_internal_zzqh, zze com_google_android_gms_ads_internal_zze) {
        super(context, com_google_android_gms_internal_zzeg, str, com_google_android_gms_internal_zzka, com_google_android_gms_internal_zzqh, com_google_android_gms_ads_internal_zze);
        this.zztC = -1;
        this.zztB = false;
        this.zztF = zzw.zzdl().zzjT() ? new zzov(context, str) : null;
    }

    static com.google.android.gms.internal.zzpb.zza zzc(com.google.android.gms.internal.zzpb.zza com_google_android_gms_internal_zzpb_zza) {
        try {
            String jSONObject = zznd.zzb(com_google_android_gms_internal_zzpb_zza.zzWm).toString();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(AbstractAdViewAdapter.AD_UNIT_ID_PARAMETER, com_google_android_gms_internal_zzpb_zza.zzTi.zzvl);
            zzjq com_google_android_gms_internal_zzjq = new zzjq(jSONObject, null, Collections.singletonList("com.google.ads.mediation.admob.AdMobAdapter"), null, null, Collections.emptyList(), Collections.emptyList(), jSONObject2.toString(), null, Collections.emptyList(), Collections.emptyList(), null, null, null, null, null, Collections.emptyList());
            zzmn com_google_android_gms_internal_zzmn = com_google_android_gms_internal_zzpb_zza.zzWm;
            zzjr com_google_android_gms_internal_zzjr = new zzjr(Collections.singletonList(com_google_android_gms_internal_zzjq), ((Long) zzgd.zzDM.get()).longValue(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), com_google_android_gms_internal_zzmn.zzKI, com_google_android_gms_internal_zzmn.zzKJ, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING, -1, 0, 1, null, 0, -1, -1, false);
            return new com.google.android.gms.internal.zzpb.zza(com_google_android_gms_internal_zzpb_zza.zzTi, new zzmn(com_google_android_gms_internal_zzpb_zza.zzTi, com_google_android_gms_internal_zzmn.zzNJ, com_google_android_gms_internal_zzmn.body, Collections.emptyList(), Collections.emptyList(), com_google_android_gms_internal_zzmn.zzSm, true, com_google_android_gms_internal_zzmn.zzSo, Collections.emptyList(), com_google_android_gms_internal_zzmn.zzKL, com_google_android_gms_internal_zzmn.orientation, com_google_android_gms_internal_zzmn.zzSq, com_google_android_gms_internal_zzmn.zzSr, com_google_android_gms_internal_zzmn.zzSs, com_google_android_gms_internal_zzmn.zzSt, com_google_android_gms_internal_zzmn.zzSu, null, com_google_android_gms_internal_zzmn.zzSw, com_google_android_gms_internal_zzmn.zzzB, com_google_android_gms_internal_zzmn.zzRG, com_google_android_gms_internal_zzmn.zzSx, com_google_android_gms_internal_zzmn.zzSy, com_google_android_gms_internal_zzmn.zzSB, com_google_android_gms_internal_zzmn.zzzC, com_google_android_gms_internal_zzmn.zzzD, null, Collections.emptyList(), Collections.emptyList(), com_google_android_gms_internal_zzmn.zzSF, com_google_android_gms_internal_zzmn.zzSG, com_google_android_gms_internal_zzmn.zzRV, com_google_android_gms_internal_zzmn.zzRW, com_google_android_gms_internal_zzmn.zzKI, com_google_android_gms_internal_zzmn.zzKJ, com_google_android_gms_internal_zzmn.zzSH, null, com_google_android_gms_internal_zzmn.zzSJ, com_google_android_gms_internal_zzmn.zzSK, com_google_android_gms_internal_zzmn.zzSh), com_google_android_gms_internal_zzjr, com_google_android_gms_internal_zzpb_zza.zzvr, com_google_android_gms_internal_zzpb_zza.errorCode, com_google_android_gms_internal_zzpb_zza.zzWg, com_google_android_gms_internal_zzpb_zza.zzWh, null);
        } catch (Throwable e) {
            zzqf.zzb("Unable to generate ad state for an interstitial ad with pooling.", e);
            return com_google_android_gms_internal_zzpb_zza;
        }
    }

    private void zzc(Bundle bundle) {
        zzw.zzcM().zzb(this.zzss.zzqn, this.zzss.zzvn.zzba, "gmob-apps", bundle, false);
    }

    public void showInterstitial() {
        zzac.zzdj("showInterstitial must be called on the main UI thread.");
        if (this.zzss.zzvs == null) {
            zzqf.zzbh("The interstitial has not loaded.");
            return;
        }
        if (((Boolean) zzgd.zzDx.get()).booleanValue()) {
            Bundle bundle;
            String packageName = this.zzss.zzqn.getApplicationContext() != null ? this.zzss.zzqn.getApplicationContext().getPackageName() : this.zzss.zzqn.getPackageName();
            if (!this.zztB) {
                zzqf.zzbh("It is not recommended to show an interstitial before onAdLoaded completes.");
                bundle = new Bundle();
                bundle.putString("appid", packageName);
                bundle.putString("action", "show_interstitial_before_load_finish");
                zzc(bundle);
            }
            if (!zzw.zzcM().zzP(this.zzss.zzqn)) {
                zzqf.zzbh("It is not recommended to show an interstitial when app is not in foreground.");
                bundle = new Bundle();
                bundle.putString("appid", packageName);
                bundle.putString("action", "show_interstitial_app_not_in_foreground");
                zzc(bundle);
            }
        }
        if (!this.zzss.zzdr()) {
            if (this.zzss.zzvs.zzSn && this.zzss.zzvs.zzLj != null) {
                try {
                    this.zzss.zzvs.zzLj.showInterstitial();
                } catch (Throwable e) {
                    zzqf.zzc("Could not show interstitial.", e);
                    zzcm();
                }
            } else if (this.zzss.zzvs.zzNH == null) {
                zzqf.zzbh("The interstitial failed to load.");
            } else if (this.zzss.zzvs.zzNH.zzlz()) {
                zzqf.zzbh("The interstitial is already showing.");
            } else {
                this.zzss.zzvs.zzNH.zzK(true);
                if (this.zzss.zzvs.zzWa != null) {
                    this.zzsu.zza(this.zzss.zzvr, this.zzss.zzvs);
                }
                zzt.zzzg();
                zzpb com_google_android_gms_internal_zzpb = this.zzss.zzvs;
                if (com_google_android_gms_internal_zzpb.zzdD()) {
                    new zzcy(this.zzss.zzqn, com_google_android_gms_internal_zzpb.zzNH.getView()).zza(com_google_android_gms_internal_zzpb.zzNH);
                } else {
                    com_google_android_gms_internal_zzpb.zzNH.zzlv().zza(new C09481(this, com_google_android_gms_internal_zzpb));
                }
                Bitmap zzQ = this.zzss.zztK ? zzw.zzcM().zzQ(this.zzss.zzqn) : null;
                this.zztC = zzw.zzdh().zzb(zzQ);
                if (!((Boolean) zzgd.zzEa.get()).booleanValue() || zzQ == null) {
                    zzn com_google_android_gms_ads_internal_zzn = new zzn(this.zzss.zztK, zzcl(), false, 0.0f, -1);
                    int requestedOrientation = this.zzss.zzvs.zzNH.getRequestedOrientation();
                    if (requestedOrientation == -1) {
                        requestedOrientation = this.zzss.zzvs.orientation;
                    }
                    zzw.zzcK().zza(this.zzss.zzqn, new AdOverlayInfoParcel(this, this, this, this.zzss.zzvs.zzNH, requestedOrientation, this.zzss.zzvn, this.zzss.zzvs.zzSs, com_google_android_gms_ads_internal_zzn));
                    return;
                }
                new zza(this, this.zztC).zziP();
            }
        }
    }

    protected zzqw zza(com.google.android.gms.internal.zzpb.zza com_google_android_gms_internal_zzpb_zza, @Nullable zzf com_google_android_gms_ads_internal_zzf, @Nullable zzot com_google_android_gms_internal_zzot) {
        zzqw zza = zzw.zzcN().zza(this.zzss.zzqn, this.zzss.zzvr, false, false, this.zzss.zzvm, this.zzss.zzvn, this.zzsn, this, this.zzsv);
        zza.zzlv().zza(this, null, this, this, ((Boolean) zzgd.zzCv.get()).booleanValue(), this, this, com_google_android_gms_ads_internal_zzf, null, com_google_android_gms_internal_zzot);
        zza((zzjj) zza);
        zza.zzbj(com_google_android_gms_internal_zzpb_zza.zzTi.zzRL);
        zzin.zza(zza, (com.google.android.gms.internal.zzin.zza) this);
        return zza;
    }

    public void zza(com.google.android.gms.internal.zzpb.zza com_google_android_gms_internal_zzpb_zza, zzgl com_google_android_gms_internal_zzgl) {
        Object obj = 1;
        if (!((Boolean) zzgd.zzDc.get()).booleanValue()) {
            super.zza(com_google_android_gms_internal_zzpb_zza, com_google_android_gms_internal_zzgl);
        } else if (com_google_android_gms_internal_zzpb_zza.errorCode != -2) {
            super.zza(com_google_android_gms_internal_zzpb_zza, com_google_android_gms_internal_zzgl);
        } else {
            Bundle bundle = com_google_android_gms_internal_zzpb_zza.zzTi.zzRy.zzzd.getBundle("com.google.ads.mediation.admob.AdMobAdapter");
            Object obj2 = (bundle == null || !bundle.containsKey("gw")) ? 1 : null;
            if (com_google_android_gms_internal_zzpb_zza.zzWm.zzSn) {
                obj = null;
            }
            if (!(obj2 == null || r2 == null)) {
                this.zzss.zzvt = zzc(com_google_android_gms_internal_zzpb_zza);
            }
            super.zza(this.zzss.zzvt, com_google_android_gms_internal_zzgl);
        }
    }

    public void zza(boolean z, float f) {
        this.zztD = z;
        this.zztE = f;
    }

    public boolean zza(zzec com_google_android_gms_internal_zzec, zzgl com_google_android_gms_internal_zzgl) {
        if (this.zzss.zzvs == null) {
            return super.zza(com_google_android_gms_internal_zzec, com_google_android_gms_internal_zzgl);
        }
        zzqf.zzbh("An interstitial is already loading. Aborting.");
        return false;
    }

    protected boolean zza(zzec com_google_android_gms_internal_zzec, zzpb com_google_android_gms_internal_zzpb, boolean z) {
        if (this.zzss.zzdq() && com_google_android_gms_internal_zzpb.zzNH != null) {
            zzw.zzcO().zzl(com_google_android_gms_internal_zzpb.zzNH);
        }
        return this.zzsr.zzcy();
    }

    public boolean zza(@Nullable zzpb com_google_android_gms_internal_zzpb, zzpb com_google_android_gms_internal_zzpb2) {
        if (!super.zza(com_google_android_gms_internal_zzpb, com_google_android_gms_internal_zzpb2)) {
            return false;
        }
        if (!(this.zzss.zzdq() || this.zzss.zzvN == null || com_google_android_gms_internal_zzpb2.zzWa == null)) {
            this.zzsu.zza(this.zzss.zzvr, com_google_android_gms_internal_zzpb2, this.zzss.zzvN);
        }
        return true;
    }

    public void zzb(zzoo com_google_android_gms_internal_zzoo) {
        if (this.zzss.zzvs != null) {
            if (this.zzss.zzvs.zzSE != null) {
                zzw.zzcM().zza(this.zzss.zzqn, this.zzss.zzvn.zzba, this.zzss.zzvs.zzSE);
            }
            if (this.zzss.zzvs.zzSC != null) {
                com_google_android_gms_internal_zzoo = this.zzss.zzvs.zzSC;
            }
        }
        zza(com_google_android_gms_internal_zzoo);
    }

    protected void zzbG() {
        zzcm();
        super.zzbG();
    }

    protected void zzbJ() {
        super.zzbJ();
        this.zztB = true;
    }

    public void zzbN() {
        super.zzbN();
        if (zzw.zzdl().zzjT()) {
            this.zztF.zzC(false);
        }
    }

    public void zzbO() {
        recordImpression();
        super.zzbO();
        if (!(this.zzss.zzvs == null || this.zzss.zzvs.zzNH == null)) {
            zzqx zzlv = this.zzss.zzvs.zzNH.zzlv();
            if (zzlv != null) {
                zzlv.zzlT();
            }
        }
        if (zzw.zzdl().zzjT()) {
            zzw.zzdl().zza(this.zzss.zzqn, this.zzss.zzvl, zzw.zzdl().zzC(this.zzss.zzqn));
            this.zztF.zzC(true);
        }
    }

    protected boolean zzcl() {
        if (!(this.zzss.zzqn instanceof Activity)) {
            return false;
        }
        Window window = ((Activity) this.zzss.zzqn).getWindow();
        if (window == null || window.getDecorView() == null) {
            return false;
        }
        Rect rect = new Rect();
        Rect rect2 = new Rect();
        window.getDecorView().getGlobalVisibleRect(rect, null);
        window.getDecorView().getWindowVisibleDisplayFrame(rect2);
        boolean z = (rect.bottom == 0 || rect2.bottom == 0 || rect.top != rect2.top) ? false : true;
        return z;
    }

    public void zzcm() {
        zzw.zzdh().zzb(Integer.valueOf(this.zztC));
        if (this.zzss.zzdq()) {
            this.zzss.zzdn();
            this.zzss.zzvs = null;
            this.zzss.zztK = false;
            this.zztB = false;
        }
    }

    public void zzcn() {
        if (!(this.zzss.zzvs == null || this.zzss.zzvs.zzWf == null)) {
            zzw.zzcM().zza(this.zzss.zzqn, this.zzss.zzvn.zzba, this.zzss.zzvs.zzWf);
        }
        zzbK();
    }

    public void zzg(boolean z) {
        this.zzss.zztK = z;
    }
}
