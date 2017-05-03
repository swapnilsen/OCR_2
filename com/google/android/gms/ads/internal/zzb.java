package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.webkit.CookieManager;
import com.google.android.gms.ads.internal.overlay.zzh;
import com.google.android.gms.ads.internal.purchase.GInAppPurchaseManagerInfoParcel;
import com.google.android.gms.ads.internal.purchase.zzc;
import com.google.android.gms.ads.internal.purchase.zzd;
import com.google.android.gms.ads.internal.purchase.zzf;
import com.google.android.gms.ads.internal.purchase.zzg;
import com.google.android.gms.ads.internal.purchase.zzj;
import com.google.android.gms.ads.internal.purchase.zzk;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.internal.zzadg;
import com.google.android.gms.internal.zzec;
import com.google.android.gms.internal.zzeg;
import com.google.android.gms.internal.zzel;
import com.google.android.gms.internal.zzgd;
import com.google.android.gms.internal.zzgl;
import com.google.android.gms.internal.zzif;
import com.google.android.gms.internal.zzjc;
import com.google.android.gms.internal.zzjs;
import com.google.android.gms.internal.zzka;
import com.google.android.gms.internal.zzld;
import com.google.android.gms.internal.zzle;
import com.google.android.gms.internal.zzli;
import com.google.android.gms.internal.zzme;
import com.google.android.gms.internal.zzmk.zza;
import com.google.android.gms.internal.zzmr;
import com.google.android.gms.internal.zzpb;
import com.google.android.gms.internal.zzpc;
import com.google.android.gms.internal.zzpd;
import com.google.android.gms.internal.zzpn;
import com.google.android.gms.internal.zzpo;
import com.google.android.gms.internal.zzqf;
import com.google.android.gms.internal.zzqh;
import com.google.android.gms.internal.zzqj;
import com.google.android.gms.internal.zzqm;
import com.google.android.gms.internal.zzqw;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

@zzme
public abstract class zzb extends zza implements zzh, zzj, zzu, zzif, zzjs {
    protected transient boolean zzsA;
    protected final zzka zzsz;

    /* renamed from: com.google.android.gms.ads.internal.zzb.1 */
    class C09291 implements Callable<Boolean> {
        final /* synthetic */ zzb zzsB;

        C09291(zzb com_google_android_gms_ads_internal_zzb) {
            this.zzsB = com_google_android_gms_ads_internal_zzb;
        }

        public /* synthetic */ Object call() {
            return zzbX();
        }

        public Boolean zzbX() {
            return Boolean.valueOf(false);
        }
    }

    /* renamed from: com.google.android.gms.ads.internal.zzb.2 */
    class C09302 implements Callable<String> {
        final /* synthetic */ zzb zzsB;

        C09302(zzb com_google_android_gms_ads_internal_zzb) {
            this.zzsB = com_google_android_gms_ads_internal_zzb;
        }

        public /* synthetic */ Object call() {
            return zzbY();
        }

        public String zzbY() {
            String str = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING;
            if (((Boolean) zzgd.zzFb.get()).booleanValue()) {
                CookieManager zzX = zzw.zzcO().zzX(this.zzsB.zzss.zzqn);
                if (zzX != null) {
                    return zzX.getCookie("googleads.g.doubleclick.net");
                }
            }
            return str;
        }
    }

    /* renamed from: com.google.android.gms.ads.internal.zzb.3 */
    class C09313 implements Callable<String> {
        final /* synthetic */ zzb zzsB;

        C09313(zzb com_google_android_gms_ads_internal_zzb) {
            this.zzsB = com_google_android_gms_ads_internal_zzb;
        }

        public /* synthetic */ Object call() {
            return zzbY();
        }

        public String zzbY() {
            return this.zzsB.zzss.zzvm.zzT().zzb(this.zzsB.zzss.zzqn);
        }
    }

    /* renamed from: com.google.android.gms.ads.internal.zzb.4 */
    class C09324 implements Runnable {
        final /* synthetic */ zzqm zzsC;
        final /* synthetic */ zzqj zzsD;
        final /* synthetic */ boolean zzsE;
        final /* synthetic */ boolean zzsF;

        C09324(zzb com_google_android_gms_ads_internal_zzb, zzqm com_google_android_gms_internal_zzqm, zzqj com_google_android_gms_internal_zzqj, boolean z, boolean z2) {
            this.zzsC = com_google_android_gms_internal_zzqm;
            this.zzsD = com_google_android_gms_internal_zzqj;
            this.zzsE = z;
            this.zzsF = z2;
        }

        public void run() {
            boolean z = false;
            try {
                z = this.zzsC.isDone() ? ((Boolean) this.zzsC.get()).booleanValue() : false;
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } catch (Throwable e2) {
                zzqf.zzb("Error receiving app streaming support", e2);
            }
            this.zzsD.zzh(new zzmr(this.zzsE, this.zzsF, z));
        }
    }

    /* renamed from: com.google.android.gms.ads.internal.zzb.5 */
    class C09335 implements Runnable {
        final /* synthetic */ zzb zzsB;
        final /* synthetic */ Intent zzsG;

        C09335(zzb com_google_android_gms_ads_internal_zzb, Intent intent) {
            this.zzsB = com_google_android_gms_ads_internal_zzb;
            this.zzsG = intent;
        }

        public void run() {
            int zzd = zzw.zzda().zzd(this.zzsG);
            zzw.zzda();
            if (!(zzd != 0 || this.zzsB.zzss.zzvs == null || this.zzsB.zzss.zzvs.zzNH == null || this.zzsB.zzss.zzvs.zzNH.zzlt() == null)) {
                this.zzsB.zzss.zzvs.zzNH.zzlt().close();
            }
            this.zzsB.zzss.zzvP = false;
        }
    }

    /* renamed from: com.google.android.gms.ads.internal.zzb.6 */
    class C09346 implements Runnable {
        final /* synthetic */ zzb zzsB;

        C09346(zzb com_google_android_gms_ads_internal_zzb) {
            this.zzsB = com_google_android_gms_ads_internal_zzb;
        }

        public void run() {
            this.zzsB.zzsr.pause();
        }
    }

    /* renamed from: com.google.android.gms.ads.internal.zzb.7 */
    class C09357 implements Runnable {
        final /* synthetic */ zzb zzsB;

        C09357(zzb com_google_android_gms_ads_internal_zzb) {
            this.zzsB = com_google_android_gms_ads_internal_zzb;
        }

        public void run() {
            this.zzsB.zzsr.resume();
        }
    }

    public zzb(Context context, zzeg com_google_android_gms_internal_zzeg, String str, zzka com_google_android_gms_internal_zzka, zzqh com_google_android_gms_internal_zzqh, zze com_google_android_gms_ads_internal_zze) {
        this(new zzx(context, com_google_android_gms_internal_zzeg, str, com_google_android_gms_internal_zzqh), com_google_android_gms_internal_zzka, null, com_google_android_gms_ads_internal_zze);
    }

    protected zzb(zzx com_google_android_gms_ads_internal_zzx, zzka com_google_android_gms_internal_zzka, @Nullable zzt com_google_android_gms_ads_internal_zzt, zze com_google_android_gms_ads_internal_zze) {
        super(com_google_android_gms_ads_internal_zzx, com_google_android_gms_ads_internal_zzt, com_google_android_gms_ads_internal_zze);
        this.zzsz = com_google_android_gms_internal_zzka;
        this.zzsA = false;
    }

    private zza zza(zzec com_google_android_gms_internal_zzec, Bundle bundle, zzpd com_google_android_gms_internal_zzpd) {
        PackageInfo packageInfo;
        ApplicationInfo applicationInfo = this.zzss.zzqn.getApplicationInfo();
        try {
            packageInfo = zzadg.zzbi(this.zzss.zzqn).getPackageInfo(applicationInfo.packageName, 0);
        } catch (NameNotFoundException e) {
            packageInfo = null;
        }
        DisplayMetrics displayMetrics = this.zzss.zzqn.getResources().getDisplayMetrics();
        Bundle bundle2 = null;
        if (!(this.zzss.zzvo == null || this.zzss.zzvo.getParent() == null)) {
            int[] iArr = new int[2];
            this.zzss.zzvo.getLocationOnScreen(iArr);
            int i = iArr[0];
            int i2 = iArr[1];
            int width = this.zzss.zzvo.getWidth();
            int height = this.zzss.zzvo.getHeight();
            int i3 = 0;
            if (this.zzss.zzvo.isShown() && i + width > 0 && i2 + height > 0 && i <= displayMetrics.widthPixels && i2 <= displayMetrics.heightPixels) {
                i3 = 1;
            }
            bundle2 = new Bundle(5);
            bundle2.putInt("x", i);
            bundle2.putInt("y", i2);
            bundle2.putInt("width", width);
            bundle2.putInt("height", height);
            bundle2.putInt("visible", i3);
        }
        String zzki = zzw.zzcQ().zzki();
        this.zzss.zzvu = new zzpc(zzki, this.zzss.zzvl);
        this.zzss.zzvu.zzs(com_google_android_gms_internal_zzec);
        String zza = zzw.zzcM().zza(this.zzss.zzqn, this.zzss.zzvo, this.zzss.zzvr);
        long j = 0;
        if (this.zzss.zzvy != null) {
            try {
                j = this.zzss.zzvy.getValue();
            } catch (RemoteException e2) {
                zzqf.zzbh("Cannot get correlation id, default to 0.");
            }
        }
        String uuid = UUID.randomUUID().toString();
        Bundle zza2 = zzw.zzcQ().zza(this.zzss.zzqn, this, zzki);
        List arrayList = new ArrayList();
        for (i = 0; i < this.zzss.zzvE.size(); i++) {
            arrayList.add((String) this.zzss.zzvE.keyAt(i));
        }
        boolean z = this.zzss.zzvz != null;
        boolean z2 = this.zzss.zzvA != null && zzw.zzcQ().zzkz();
        zzqm zza3 = zzpn.zza(new C09291(this));
        Future zza4 = zzpn.zza(new C09302(this));
        Future zza5 = zzpn.zza(new C09313(this));
        String str = null;
        if (com_google_android_gms_internal_zzpd != null) {
            str = com_google_android_gms_internal_zzpd.zzkd();
        }
        zzqj com_google_android_gms_internal_zzqj = new zzqj();
        zza3.zzc(new C09324(this, zza3, com_google_android_gms_internal_zzqj, z, z2));
        return new zza(bundle2, com_google_android_gms_internal_zzec, this.zzss.zzvr, this.zzss.zzvl, applicationInfo, packageInfo, zzki, zzw.zzcQ().getSessionId(), this.zzss.zzvn, zza2, this.zzss.zzvK, arrayList, bundle, zzw.zzcQ().zzkm(), displayMetrics.widthPixels, displayMetrics.heightPixels, displayMetrics.density, zza, j, uuid, zzgd.zzfs(), this.zzss.zzvk, this.zzss.zzvF, com_google_android_gms_internal_zzqj, this.zzss.zzdu(), zzw.zzcM().zzcq(), zzw.zzcM().zzcs(), zzw.zzcM().zzT(this.zzss.zzqn), zzw.zzcM().zzs(this.zzss.zzvo), this.zzss.zzqn instanceof Activity, zzw.zzcQ().zzkr(), zza4, str, zzw.zzcQ().zzkv(), zzw.zzdj().zzgr(), zzw.zzcM().zzkP(), zzw.zzcU().zzkY(), this.zzss.zzvH, zzw.zzcU().zzkZ(), zzjc.zzgC().asBundle(), zzw.zzcQ().zzm(this.zzss.zzqn, this.zzss.zzvl), zza5);
    }

    public String getMediationAdapterClassName() {
        return this.zzss.zzvs == null ? null : this.zzss.zzvs.zzLk;
    }

    public void onAdClicked() {
        if (this.zzss.zzvs == null) {
            zzqf.zzbh("Ad state was null when trying to ping click URLs.");
            return;
        }
        if (!(this.zzss.zzvs.zzWc == null || this.zzss.zzvs.zzWc.zzKF == null)) {
            String zzF = zzw.zzdl().zzF(this.zzss.zzqn);
            zzw.zzdf().zza(this.zzss.zzqn, this.zzss.zzvn.zzba, this.zzss.zzvs, this.zzss.zzvl, false, zza(zzF, this.zzss.zzvs.zzWc.zzKF));
            if (this.zzss.zzvs.zzWc.zzKF.size() > 0) {
                zzw.zzdl().zzf(this.zzss.zzqn, zzF);
            }
        }
        if (!(this.zzss.zzvs.zzLi == null || this.zzss.zzvs.zzLi.zzKs == null)) {
            zzw.zzdf().zza(this.zzss.zzqn, this.zzss.zzvn.zzba, this.zzss.zzvs, this.zzss.zzvl, false, this.zzss.zzvs.zzLi.zzKs);
        }
        super.onAdClicked();
    }

    public void onPause() {
        this.zzsu.zzl(this.zzss.zzvs);
    }

    public void onResume() {
        this.zzsu.zzm(this.zzss.zzvs);
    }

    public void pause() {
        zzac.zzdj("pause must be called on the main UI thread.");
        if (!(this.zzss.zzvs == null || this.zzss.zzvs.zzNH == null || !this.zzss.zzdq())) {
            zzw.zzcO().zzl(this.zzss.zzvs.zzNH);
        }
        if (!(this.zzss.zzvs == null || this.zzss.zzvs.zzLj == null)) {
            try {
                this.zzss.zzvs.zzLj.pause();
            } catch (RemoteException e) {
                zzqf.zzbh("Could not pause mediation adapter.");
            }
        }
        this.zzsu.zzl(this.zzss.zzvs);
        this.zzsr.pause();
    }

    public void recordImpression() {
        zza(this.zzss.zzvs, false);
    }

    public void resume() {
        zzac.zzdj("resume must be called on the main UI thread.");
        zzqw com_google_android_gms_internal_zzqw = null;
        if (!(this.zzss.zzvs == null || this.zzss.zzvs.zzNH == null)) {
            com_google_android_gms_internal_zzqw = this.zzss.zzvs.zzNH;
        }
        if (com_google_android_gms_internal_zzqw != null && this.zzss.zzdq()) {
            zzw.zzcO().zzm(this.zzss.zzvs.zzNH);
        }
        if (!(this.zzss.zzvs == null || this.zzss.zzvs.zzLj == null)) {
            try {
                this.zzss.zzvs.zzLj.resume();
            } catch (RemoteException e) {
                zzqf.zzbh("Could not resume mediation adapter.");
            }
        }
        if (com_google_android_gms_internal_zzqw == null || !com_google_android_gms_internal_zzqw.zzlC()) {
            this.zzsr.resume();
        }
        this.zzsu.zzm(this.zzss.zzvs);
    }

    public void showInterstitial() {
        throw new IllegalStateException("showInterstitial is not supported for current ad type");
    }

    public void zza(zzle com_google_android_gms_internal_zzle) {
        zzac.zzdj("setInAppPurchaseListener must be called on the main UI thread.");
        this.zzss.zzvz = com_google_android_gms_internal_zzle;
    }

    public void zza(zzli com_google_android_gms_internal_zzli, @Nullable String str) {
        zzac.zzdj("setPlayStorePurchaseParams must be called on the main UI thread.");
        this.zzss.zzvL = new zzk(str);
        this.zzss.zzvA = com_google_android_gms_internal_zzli;
        if (!zzw.zzcQ().zzkl() && com_google_android_gms_internal_zzli != null) {
            new zzc(this.zzss.zzqn, this.zzss.zzvA, this.zzss.zzvL).zziP();
        }
    }

    protected void zza(@Nullable zzpb com_google_android_gms_internal_zzpb, boolean z) {
        if (com_google_android_gms_internal_zzpb == null) {
            zzqf.zzbh("Ad state was null when trying to ping impression URLs.");
            return;
        }
        super.zzc(com_google_android_gms_internal_zzpb);
        if (!(com_google_android_gms_internal_zzpb.zzWc == null || com_google_android_gms_internal_zzpb.zzWc.zzKG == null)) {
            String zzF = zzw.zzdl().zzF(this.zzss.zzqn);
            zzw.zzdf().zza(this.zzss.zzqn, this.zzss.zzvn.zzba, com_google_android_gms_internal_zzpb, this.zzss.zzvl, z, zza(zzF, com_google_android_gms_internal_zzpb.zzWc.zzKG));
            if (com_google_android_gms_internal_zzpb.zzWc.zzKG.size() > 0) {
                zzw.zzdl().zzg(this.zzss.zzqn, zzF);
            }
        }
        if (com_google_android_gms_internal_zzpb.zzLi != null && com_google_android_gms_internal_zzpb.zzLi.zzKt != null) {
            zzw.zzdf().zza(this.zzss.zzqn, this.zzss.zzvn.zzba, com_google_android_gms_internal_zzpb, this.zzss.zzvl, z, com_google_android_gms_internal_zzpb.zzLi.zzKt);
        }
    }

    public void zza(String str, ArrayList<String> arrayList) {
        zzld com_google_android_gms_ads_internal_purchase_zzd = new zzd(str, arrayList, this.zzss.zzqn, this.zzss.zzvn.zzba);
        if (this.zzss.zzvz == null) {
            zzqf.zzbh("InAppPurchaseListener is not set. Try to launch default purchase flow.");
            if (!zzel.zzeT().zzaf(this.zzss.zzqn)) {
                zzqf.zzbh("Google Play Service unavailable, cannot launch default purchase flow.");
                return;
            } else if (this.zzss.zzvA == null) {
                zzqf.zzbh("PlayStorePurchaseListener is not set.");
                return;
            } else if (this.zzss.zzvL == null) {
                zzqf.zzbh("PlayStorePurchaseVerifier is not initialized.");
                return;
            } else if (this.zzss.zzvP) {
                zzqf.zzbh("An in-app purchase request is already in progress, abort");
                return;
            } else {
                this.zzss.zzvP = true;
                try {
                    if (this.zzss.zzvA.isValidPurchase(str)) {
                        zzw.zzda().zza(this.zzss.zzqn, this.zzss.zzvn.zzYY, new GInAppPurchaseManagerInfoParcel(this.zzss.zzqn, this.zzss.zzvL, com_google_android_gms_ads_internal_purchase_zzd, (zzj) this));
                        return;
                    } else {
                        this.zzss.zzvP = false;
                        return;
                    }
                } catch (RemoteException e) {
                    zzqf.zzbh("Could not start In-App purchase.");
                    this.zzss.zzvP = false;
                    return;
                }
            }
        }
        try {
            this.zzss.zzvz.zza(com_google_android_gms_ads_internal_purchase_zzd);
        } catch (RemoteException e2) {
            zzqf.zzbh("Could not start In-App purchase.");
        }
    }

    public void zza(String str, boolean z, int i, Intent intent, zzf com_google_android_gms_ads_internal_purchase_zzf) {
        try {
            if (this.zzss.zzvA != null) {
                this.zzss.zzvA.zza(new zzg(this.zzss.zzqn, str, z, i, intent, com_google_android_gms_ads_internal_purchase_zzf));
            }
        } catch (RemoteException e) {
            zzqf.zzbh("Fail to invoke PlayStorePurchaseListener.");
        }
        zzpo.zzXC.postDelayed(new C09335(this, intent), 500);
    }

    public boolean zza(zzec com_google_android_gms_internal_zzec, zzgl com_google_android_gms_internal_zzgl) {
        if (!zzbM()) {
            return false;
        }
        zzpd zzkw;
        Bundle zzV = zzw.zzcM().zzV(this.zzss.zzqn);
        this.zzsr.cancel();
        this.zzss.zzvO = 0;
        if (((Boolean) zzgd.zzEJ.get()).booleanValue()) {
            zzkw = zzw.zzcQ().zzkw();
            zzw.zzdi().zza(this.zzss.zzqn, this.zzss.zzvn, this.zzss.zzvl, zzkw);
        } else {
            zzkw = null;
        }
        zza zza = zza(com_google_android_gms_internal_zzec, zzV, zzkw);
        com_google_android_gms_internal_zzgl.zzh("seq_num", zza.zzRB);
        com_google_android_gms_internal_zzgl.zzh("request_id", zza.zzRL);
        com_google_android_gms_internal_zzgl.zzh("session_id", zza.zzRC);
        if (zza.zzRz != null) {
            com_google_android_gms_internal_zzgl.zzh("app_version", String.valueOf(zza.zzRz.versionCode));
        }
        this.zzss.zzvp = zzw.zzcI().zza(this.zzss.zzqn, zza, this);
        return true;
    }

    protected boolean zza(zzec com_google_android_gms_internal_zzec, zzpb com_google_android_gms_internal_zzpb, boolean z) {
        if (!z && this.zzss.zzdq()) {
            if (com_google_android_gms_internal_zzpb.zzKL > 0) {
                this.zzsr.zza(com_google_android_gms_internal_zzec, com_google_android_gms_internal_zzpb.zzKL);
            } else if (com_google_android_gms_internal_zzpb.zzWc != null && com_google_android_gms_internal_zzpb.zzWc.zzKL > 0) {
                this.zzsr.zza(com_google_android_gms_internal_zzec, com_google_android_gms_internal_zzpb.zzWc.zzKL);
            } else if (!com_google_android_gms_internal_zzpb.zzSn && com_google_android_gms_internal_zzpb.errorCode == 2) {
                this.zzsr.zzh(com_google_android_gms_internal_zzec);
            }
        }
        return this.zzsr.zzcy();
    }

    boolean zza(zzpb com_google_android_gms_internal_zzpb) {
        zzec com_google_android_gms_internal_zzec;
        boolean z = false;
        if (this.zzst != null) {
            com_google_android_gms_internal_zzec = this.zzst;
            this.zzst = null;
        } else {
            com_google_android_gms_internal_zzec = com_google_android_gms_internal_zzpb.zzRy;
            if (com_google_android_gms_internal_zzec.extras != null) {
                z = com_google_android_gms_internal_zzec.extras.getBoolean("_noRefresh", false);
            }
        }
        return zza(com_google_android_gms_internal_zzec, com_google_android_gms_internal_zzpb, z);
    }

    protected boolean zza(@Nullable zzpb com_google_android_gms_internal_zzpb, zzpb com_google_android_gms_internal_zzpb2) {
        int i;
        int i2 = 0;
        if (!(com_google_android_gms_internal_zzpb == null || com_google_android_gms_internal_zzpb.zzLl == null)) {
            com_google_android_gms_internal_zzpb.zzLl.zza(null);
        }
        if (com_google_android_gms_internal_zzpb2.zzLl != null) {
            com_google_android_gms_internal_zzpb2.zzLl.zza((zzjs) this);
        }
        if (com_google_android_gms_internal_zzpb2.zzWc != null) {
            i = com_google_android_gms_internal_zzpb2.zzWc.zzKS;
            i2 = com_google_android_gms_internal_zzpb2.zzWc.zzKT;
        } else {
            i = 0;
        }
        this.zzss.zzvM.zzk(i, i2);
        return true;
    }

    public void zzb(zzpb com_google_android_gms_internal_zzpb) {
        super.zzb(com_google_android_gms_internal_zzpb);
        if (com_google_android_gms_internal_zzpb.zzLi != null) {
            zzqf.zzbf("Disable the debug gesture detector on the mediation ad frame.");
            if (this.zzss.zzvo != null) {
                this.zzss.zzvo.zzdy();
            }
            zzqf.zzbf("Pinging network fill URLs.");
            zzw.zzdf().zza(this.zzss.zzqn, this.zzss.zzvn.zzba, com_google_android_gms_internal_zzpb, this.zzss.zzvl, false, com_google_android_gms_internal_zzpb.zzLi.zzKu);
            if (!(com_google_android_gms_internal_zzpb.zzWc == null || com_google_android_gms_internal_zzpb.zzWc.zzKI == null || com_google_android_gms_internal_zzpb.zzWc.zzKI.size() <= 0)) {
                zzqf.zzbf("Pinging urls remotely");
                zzw.zzcM().zza(this.zzss.zzqn, com_google_android_gms_internal_zzpb.zzWc.zzKI);
            }
        } else {
            zzqf.zzbf("Enable the debug gesture detector on the admob ad frame.");
            if (this.zzss.zzvo != null) {
                this.zzss.zzvo.zzdx();
            }
        }
        if (com_google_android_gms_internal_zzpb.errorCode == 3 && com_google_android_gms_internal_zzpb.zzWc != null && com_google_android_gms_internal_zzpb.zzWc.zzKH != null) {
            zzqf.zzbf("Pinging no fill URLs.");
            zzw.zzdf().zza(this.zzss.zzqn, this.zzss.zzvn.zzba, com_google_android_gms_internal_zzpb, this.zzss.zzvl, false, com_google_android_gms_internal_zzpb.zzWc.zzKH);
        }
    }

    protected boolean zzbM() {
        return zzw.zzcM().zze(this.zzss.zzqn, this.zzss.zzqn.getPackageName(), "android.permission.INTERNET") && zzw.zzcM().zzJ(this.zzss.zzqn);
    }

    public void zzbN() {
        this.zzsu.zzj(this.zzss.zzvs);
        this.zzsA = false;
        zzbG();
        this.zzss.zzvu.zzjX();
    }

    public void zzbO() {
        this.zzsA = true;
        zzbI();
    }

    public void zzbP() {
        onAdClicked();
    }

    public void zzbQ() {
        zzbN();
    }

    public void zzbR() {
        zzbD();
    }

    public void zzbS() {
        zzbO();
    }

    public void zzbT() {
        if (this.zzss.zzvs != null) {
            String str = this.zzss.zzvs.zzLk;
            zzqf.zzbh(new StringBuilder(String.valueOf(str).length() + 74).append("Mediation adapter ").append(str).append(" refreshed, but mediation adapters should never refresh.").toString());
        }
        zza(this.zzss.zzvs, true);
        zzbJ();
    }

    public void zzbU() {
        recordImpression();
    }

    public void zzbV() {
        zzw.zzcM().runOnUiThread(new C09346(this));
    }

    public void zzbW() {
        zzw.zzcM().runOnUiThread(new C09357(this));
    }

    protected boolean zzc(zzec com_google_android_gms_internal_zzec) {
        return super.zzc(com_google_android_gms_internal_zzec) && !this.zzsA;
    }
}
