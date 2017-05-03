package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.widget.FrameLayout;
import com.google.android.gms.dynamic.zzd;
import com.google.firebase.analytics.FirebaseAnalytics.Event;

@zzme
public class zzek {
    private final Object zzrJ;
    private zzew zzzG;
    private final zzeb zzzH;
    private final zzea zzzI;
    private final zzfj zzzJ;
    private final zzht zzzK;
    private final zzny zzzL;
    private final zzlk zzzM;
    private final zzky zzzN;

    @VisibleForTesting
    abstract class zza<T> {
        final /* synthetic */ zzek zzzQ;

        zza(zzek com_google_android_gms_internal_zzek) {
            this.zzzQ = com_google_android_gms_internal_zzek;
        }

        @Nullable
        protected abstract T zzb(zzew com_google_android_gms_internal_zzew);

        @Nullable
        protected abstract T zzeJ();

        @Nullable
        protected final T zzeQ() {
            T t = null;
            zzew zza = this.zzzQ.zzeH();
            if (zza == null) {
                zzqf.zzbh("ClientApi class cannot be loaded.");
            } else {
                try {
                    t = zzb(zza);
                } catch (Throwable e) {
                    zzqf.zzc("Cannot invoke local loader using ClientApi class", e);
                }
            }
            return t;
        }

        @Nullable
        protected final T zzeR() {
            try {
                return zzeJ();
            } catch (Throwable e) {
                zzqf.zzc("Cannot invoke remote loader", e);
                return null;
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzek.1 */
    class C11631 extends zza<zzet> {
        final /* synthetic */ String zztd;
        final /* synthetic */ Context zztf;
        final /* synthetic */ zzeg zzzO;
        final /* synthetic */ zzka zzzP;
        final /* synthetic */ zzek zzzQ;

        C11631(zzek com_google_android_gms_internal_zzek, Context context, zzeg com_google_android_gms_internal_zzeg, String str, zzka com_google_android_gms_internal_zzka) {
            this.zzzQ = com_google_android_gms_internal_zzek;
            this.zztf = context;
            this.zzzO = com_google_android_gms_internal_zzeg;
            this.zztd = str;
            this.zzzP = com_google_android_gms_internal_zzka;
            super(com_google_android_gms_internal_zzek);
        }

        public zzet zza(zzew com_google_android_gms_internal_zzew) {
            return com_google_android_gms_internal_zzew.createBannerAdManager(zzd.zzA(this.zztf), this.zzzO, this.zztd, this.zzzP, 10298000);
        }

        public /* synthetic */ Object zzb(zzew com_google_android_gms_internal_zzew) {
            return zza(com_google_android_gms_internal_zzew);
        }

        public zzet zzeI() {
            zzet zza = this.zzzQ.zzzH.zza(this.zztf, this.zzzO, this.zztd, this.zzzP, 1);
            if (zza != null) {
                return zza;
            }
            this.zzzQ.zzc(this.zztf, "banner");
            return new zzfl();
        }

        public /* synthetic */ Object zzeJ() {
            return zzeI();
        }
    }

    /* renamed from: com.google.android.gms.internal.zzek.2 */
    class C11642 extends zza<zzet> {
        final /* synthetic */ String zztd;
        final /* synthetic */ Context zztf;
        final /* synthetic */ zzeg zzzO;
        final /* synthetic */ zzek zzzQ;

        C11642(zzek com_google_android_gms_internal_zzek, Context context, zzeg com_google_android_gms_internal_zzeg, String str) {
            this.zzzQ = com_google_android_gms_internal_zzek;
            this.zztf = context;
            this.zzzO = com_google_android_gms_internal_zzeg;
            this.zztd = str;
            super(com_google_android_gms_internal_zzek);
        }

        public zzet zza(zzew com_google_android_gms_internal_zzew) {
            return com_google_android_gms_internal_zzew.createSearchAdManager(zzd.zzA(this.zztf), this.zzzO, this.zztd, 10298000);
        }

        public /* synthetic */ Object zzb(zzew com_google_android_gms_internal_zzew) {
            return zza(com_google_android_gms_internal_zzew);
        }

        public zzet zzeI() {
            zzet zza = this.zzzQ.zzzH.zza(this.zztf, this.zzzO, this.zztd, null, 3);
            if (zza != null) {
                return zza;
            }
            this.zzzQ.zzc(this.zztf, Event.SEARCH);
            return new zzfl();
        }

        public /* synthetic */ Object zzeJ() {
            return zzeI();
        }
    }

    /* renamed from: com.google.android.gms.internal.zzek.3 */
    class C11653 extends zza<zzet> {
        final /* synthetic */ String zztd;
        final /* synthetic */ Context zztf;
        final /* synthetic */ zzeg zzzO;
        final /* synthetic */ zzka zzzP;
        final /* synthetic */ zzek zzzQ;

        C11653(zzek com_google_android_gms_internal_zzek, Context context, zzeg com_google_android_gms_internal_zzeg, String str, zzka com_google_android_gms_internal_zzka) {
            this.zzzQ = com_google_android_gms_internal_zzek;
            this.zztf = context;
            this.zzzO = com_google_android_gms_internal_zzeg;
            this.zztd = str;
            this.zzzP = com_google_android_gms_internal_zzka;
            super(com_google_android_gms_internal_zzek);
        }

        public zzet zza(zzew com_google_android_gms_internal_zzew) {
            return com_google_android_gms_internal_zzew.createInterstitialAdManager(zzd.zzA(this.zztf), this.zzzO, this.zztd, this.zzzP, 10298000);
        }

        public /* synthetic */ Object zzb(zzew com_google_android_gms_internal_zzew) {
            return zza(com_google_android_gms_internal_zzew);
        }

        public zzet zzeI() {
            zzet zza = this.zzzQ.zzzH.zza(this.zztf, this.zzzO, this.zztd, this.zzzP, 2);
            if (zza != null) {
                return zza;
            }
            this.zzzQ.zzc(this.zztf, "interstitial");
            return new zzfl();
        }

        public /* synthetic */ Object zzeJ() {
            return zzeI();
        }
    }

    /* renamed from: com.google.android.gms.internal.zzek.4 */
    class C11664 extends zza<zzer> {
        final /* synthetic */ String zztd;
        final /* synthetic */ Context zztf;
        final /* synthetic */ zzka zzzP;
        final /* synthetic */ zzek zzzQ;

        C11664(zzek com_google_android_gms_internal_zzek, Context context, String str, zzka com_google_android_gms_internal_zzka) {
            this.zzzQ = com_google_android_gms_internal_zzek;
            this.zztf = context;
            this.zztd = str;
            this.zzzP = com_google_android_gms_internal_zzka;
            super(com_google_android_gms_internal_zzek);
        }

        public /* synthetic */ Object zzb(zzew com_google_android_gms_internal_zzew) {
            return zzc(com_google_android_gms_internal_zzew);
        }

        public zzer zzc(zzew com_google_android_gms_internal_zzew) {
            return com_google_android_gms_internal_zzew.createAdLoaderBuilder(zzd.zzA(this.zztf), this.zztd, this.zzzP, 10298000);
        }

        public /* synthetic */ Object zzeJ() {
            return zzeK();
        }

        public zzer zzeK() {
            zzer zza = this.zzzQ.zzzI.zza(this.zztf, this.zztd, this.zzzP);
            if (zza != null) {
                return zza;
            }
            this.zzzQ.zzc(this.zztf, "native_ad");
            return new zzfk();
        }
    }

    /* renamed from: com.google.android.gms.internal.zzek.5 */
    class C11675 extends zza<zzey> {
        final /* synthetic */ Context zztf;
        final /* synthetic */ zzek zzzQ;

        C11675(zzek com_google_android_gms_internal_zzek, Context context) {
            this.zzzQ = com_google_android_gms_internal_zzek;
            this.zztf = context;
            super(com_google_android_gms_internal_zzek);
        }

        public /* synthetic */ Object zzb(zzew com_google_android_gms_internal_zzew) {
            return zzd(com_google_android_gms_internal_zzew);
        }

        public zzey zzd(zzew com_google_android_gms_internal_zzew) {
            return com_google_android_gms_internal_zzew.getMobileAdsSettingsManagerWithClientJarVersion(zzd.zzA(this.zztf), 10298000);
        }

        public /* synthetic */ Object zzeJ() {
            return zzeL();
        }

        public zzey zzeL() {
            zzey zzm = this.zzzQ.zzzJ.zzm(this.zztf);
            if (zzm != null) {
                return zzm;
            }
            this.zzzQ.zzc(this.zztf, "mobile_ads_settings");
            return new zzfm();
        }
    }

    /* renamed from: com.google.android.gms.internal.zzek.6 */
    class C11686 extends zza<zzhh> {
        final /* synthetic */ Context zztf;
        final /* synthetic */ zzek zzzQ;
        final /* synthetic */ FrameLayout zzzR;
        final /* synthetic */ FrameLayout zzzS;

        C11686(zzek com_google_android_gms_internal_zzek, FrameLayout frameLayout, FrameLayout frameLayout2, Context context) {
            this.zzzQ = com_google_android_gms_internal_zzek;
            this.zzzR = frameLayout;
            this.zzzS = frameLayout2;
            this.zztf = context;
            super(com_google_android_gms_internal_zzek);
        }

        public /* synthetic */ Object zzb(zzew com_google_android_gms_internal_zzew) {
            return zze(com_google_android_gms_internal_zzew);
        }

        public zzhh zze(zzew com_google_android_gms_internal_zzew) {
            return com_google_android_gms_internal_zzew.createNativeAdViewDelegate(zzd.zzA(this.zzzR), zzd.zzA(this.zzzS));
        }

        public /* synthetic */ Object zzeJ() {
            return zzeM();
        }

        public zzhh zzeM() {
            zzhh zzb = this.zzzQ.zzzK.zzb(this.zztf, this.zzzR, this.zzzS);
            if (zzb != null) {
                return zzb;
            }
            this.zzzQ.zzc(this.zztf, "native_ad_view_delegate");
            return new zzfn();
        }
    }

    /* renamed from: com.google.android.gms.internal.zzek.7 */
    class C11697 extends zza<zznu> {
        final /* synthetic */ Context zztf;
        final /* synthetic */ zzka zzzP;
        final /* synthetic */ zzek zzzQ;

        C11697(zzek com_google_android_gms_internal_zzek, Context context, zzka com_google_android_gms_internal_zzka) {
            this.zzzQ = com_google_android_gms_internal_zzek;
            this.zztf = context;
            this.zzzP = com_google_android_gms_internal_zzka;
            super(com_google_android_gms_internal_zzek);
        }

        public /* synthetic */ Object zzb(zzew com_google_android_gms_internal_zzew) {
            return zzf(com_google_android_gms_internal_zzew);
        }

        public /* synthetic */ Object zzeJ() {
            return zzeN();
        }

        public zznu zzeN() {
            zznu zzb = this.zzzQ.zzzL.zzb(this.zztf, this.zzzP);
            if (zzb != null) {
                return zzb;
            }
            this.zzzQ.zzc(this.zztf, "rewarded_video");
            return new zzfo();
        }

        public zznu zzf(zzew com_google_android_gms_internal_zzew) {
            return com_google_android_gms_internal_zzew.createRewardedVideoAd(zzd.zzA(this.zztf), this.zzzP, 10298000);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzek.8 */
    class C11708 extends zza<zzlf> {
        final /* synthetic */ Activity val$activity;
        final /* synthetic */ zzek zzzQ;

        C11708(zzek com_google_android_gms_internal_zzek, Activity activity) {
            this.zzzQ = com_google_android_gms_internal_zzek;
            this.val$activity = activity;
            super(com_google_android_gms_internal_zzek);
        }

        public /* synthetic */ Object zzb(zzew com_google_android_gms_internal_zzew) {
            return zzg(com_google_android_gms_internal_zzew);
        }

        public /* synthetic */ Object zzeJ() {
            return zzeO();
        }

        public zzlf zzeO() {
            zzlf zzg = this.zzzQ.zzzM.zzg(this.val$activity);
            if (zzg != null) {
                return zzg;
            }
            this.zzzQ.zzc(this.val$activity, "iap");
            return null;
        }

        public zzlf zzg(zzew com_google_android_gms_internal_zzew) {
            return com_google_android_gms_internal_zzew.createInAppPurchaseManager(zzd.zzA(this.val$activity));
        }
    }

    /* renamed from: com.google.android.gms.internal.zzek.9 */
    class C11719 extends zza<zzkz> {
        final /* synthetic */ Activity val$activity;
        final /* synthetic */ zzek zzzQ;

        C11719(zzek com_google_android_gms_internal_zzek, Activity activity) {
            this.zzzQ = com_google_android_gms_internal_zzek;
            this.val$activity = activity;
            super(com_google_android_gms_internal_zzek);
        }

        public /* synthetic */ Object zzb(zzew com_google_android_gms_internal_zzew) {
            return zzh(com_google_android_gms_internal_zzew);
        }

        public /* synthetic */ Object zzeJ() {
            return zzeP();
        }

        public zzkz zzeP() {
            zzkz zzf = this.zzzQ.zzzN.zzf(this.val$activity);
            if (zzf != null) {
                return zzf;
            }
            this.zzzQ.zzc(this.val$activity, "ad_overlay");
            return null;
        }

        public zzkz zzh(zzew com_google_android_gms_internal_zzew) {
            return com_google_android_gms_internal_zzew.createAdOverlay(zzd.zzA(this.val$activity));
        }
    }

    public zzek(zzeb com_google_android_gms_internal_zzeb, zzea com_google_android_gms_internal_zzea, zzfj com_google_android_gms_internal_zzfj, zzht com_google_android_gms_internal_zzht, zzny com_google_android_gms_internal_zzny, zzlk com_google_android_gms_internal_zzlk, zzky com_google_android_gms_internal_zzky) {
        this.zzrJ = new Object();
        this.zzzH = com_google_android_gms_internal_zzeb;
        this.zzzI = com_google_android_gms_internal_zzea;
        this.zzzJ = com_google_android_gms_internal_zzfj;
        this.zzzK = com_google_android_gms_internal_zzht;
        this.zzzL = com_google_android_gms_internal_zzny;
        this.zzzM = com_google_android_gms_internal_zzlk;
        this.zzzN = com_google_android_gms_internal_zzky;
    }

    private static boolean zza(Activity activity, String str) {
        Intent intent = activity.getIntent();
        if (intent.hasExtra(str)) {
            return intent.getBooleanExtra(str, false);
        }
        zzqf.m4708e("useClientJar flag not found in activity intent extras.");
        return false;
    }

    private void zzc(Context context, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("action", "no_ads_fallback");
        bundle.putString("flow", str);
        zzel.zzeT().zza(context, null, "gmob-apps", bundle, true);
    }

    @Nullable
    private static zzew zzeG() {
        try {
            Object newInstance = zzek.class.getClassLoader().loadClass("com.google.android.gms.ads.internal.ClientApi").newInstance();
            if (newInstance instanceof IBinder) {
                return com.google.android.gms.internal.zzew.zza.asInterface((IBinder) newInstance);
            }
            zzqf.zzbh("ClientApi class is not an instance of IBinder");
            return null;
        } catch (Throwable e) {
            zzqf.zzc("Failed to instantiate ClientApi class.", e);
            return null;
        }
    }

    @Nullable
    private zzew zzeH() {
        zzew com_google_android_gms_internal_zzew;
        synchronized (this.zzrJ) {
            if (this.zzzG == null) {
                this.zzzG = zzeG();
            }
            com_google_android_gms_internal_zzew = this.zzzG;
        }
        return com_google_android_gms_internal_zzew;
    }

    public zzet zza(Context context, zzeg com_google_android_gms_internal_zzeg, String str) {
        return (zzet) zza(context, false, new C11642(this, context, com_google_android_gms_internal_zzeg, str));
    }

    public zzet zza(Context context, zzeg com_google_android_gms_internal_zzeg, String str, zzka com_google_android_gms_internal_zzka) {
        return (zzet) zza(context, false, new C11631(this, context, com_google_android_gms_internal_zzeg, str, com_google_android_gms_internal_zzka));
    }

    public zzhh zza(Context context, FrameLayout frameLayout, FrameLayout frameLayout2) {
        return (zzhh) zza(context, false, new C11686(this, frameLayout, frameLayout2, context));
    }

    public zznu zza(Context context, zzka com_google_android_gms_internal_zzka) {
        return (zznu) zza(context, false, new C11697(this, context, com_google_android_gms_internal_zzka));
    }

    @VisibleForTesting
    <T> T zza(Context context, boolean z, zza<T> com_google_android_gms_internal_zzek_zza_T) {
        if (!(z || zzel.zzeT().zzaf(context))) {
            zzqf.zzbf("Google Play Services is not available");
            z = true;
        }
        T zzeQ;
        if (z) {
            zzeQ = com_google_android_gms_internal_zzek_zza_T.zzeQ();
            return zzeQ == null ? com_google_android_gms_internal_zzek_zza_T.zzeR() : zzeQ;
        } else {
            zzeQ = com_google_android_gms_internal_zzek_zza_T.zzeR();
            return zzeQ == null ? com_google_android_gms_internal_zzek_zza_T.zzeQ() : zzeQ;
        }
    }

    public zzer zzb(Context context, String str, zzka com_google_android_gms_internal_zzka) {
        return (zzer) zza(context, false, new C11664(this, context, str, com_google_android_gms_internal_zzka));
    }

    public zzet zzb(Context context, zzeg com_google_android_gms_internal_zzeg, String str, zzka com_google_android_gms_internal_zzka) {
        return (zzet) zza(context, false, new C11653(this, context, com_google_android_gms_internal_zzeg, str, com_google_android_gms_internal_zzka));
    }

    @Nullable
    public zzlf zzb(Activity activity) {
        return (zzlf) zza((Context) activity, zza(activity, "com.google.android.gms.ads.internal.purchase.useClientJar"), new C11708(this, activity));
    }

    @Nullable
    public zzkz zzc(Activity activity) {
        return (zzkz) zza((Context) activity, zza(activity, "com.google.android.gms.ads.internal.overlay.useClientJar"), new C11719(this, activity));
    }

    public zzey zzl(Context context) {
        return (zzey) zza(context, false, new C11675(this, context));
    }
}
