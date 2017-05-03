package com.google.android.gms.ads.internal;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.util.SimpleArrayMap;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.internal.zzec;
import com.google.android.gms.internal.zzeg;
import com.google.android.gms.internal.zzgd;
import com.google.android.gms.internal.zzgl;
import com.google.android.gms.internal.zzgp;
import com.google.android.gms.internal.zzgv;
import com.google.android.gms.internal.zzgw;
import com.google.android.gms.internal.zzgx;
import com.google.android.gms.internal.zzgy;
import com.google.android.gms.internal.zzgz;
import com.google.android.gms.internal.zzha;
import com.google.android.gms.internal.zzhc;
import com.google.android.gms.internal.zzhp;
import com.google.android.gms.internal.zzhq;
import com.google.android.gms.internal.zzhr;
import com.google.android.gms.internal.zzhs;
import com.google.android.gms.internal.zzka;
import com.google.android.gms.internal.zzke;
import com.google.android.gms.internal.zzkf;
import com.google.android.gms.internal.zzle;
import com.google.android.gms.internal.zzlw;
import com.google.android.gms.internal.zzme;
import com.google.android.gms.internal.zzpb;
import com.google.android.gms.internal.zzpb.zza;
import com.google.android.gms.internal.zzpo;
import com.google.android.gms.internal.zzqf;
import com.google.android.gms.internal.zzqh;
import com.google.android.gms.internal.zzqw;
import java.util.List;

@zzme
public class zzs extends zzb {
    private zzqw zzug;

    /* renamed from: com.google.android.gms.ads.internal.zzs.1 */
    class C09571 implements Runnable {
        final /* synthetic */ zza zzsI;
        final /* synthetic */ zzs zzuh;

        C09571(zzs com_google_android_gms_ads_internal_zzs, zza com_google_android_gms_internal_zzpb_zza) {
            this.zzuh = com_google_android_gms_ads_internal_zzs;
            this.zzsI = com_google_android_gms_internal_zzpb_zza;
        }

        public void run() {
            this.zzuh.zzb(new zzpb(this.zzsI, null, null, null, null, null, null, null));
        }
    }

    /* renamed from: com.google.android.gms.ads.internal.zzs.2 */
    class C09582 implements Runnable {
        final /* synthetic */ zzs zzuh;
        final /* synthetic */ zzgv zzui;

        C09582(zzs com_google_android_gms_ads_internal_zzs, zzgv com_google_android_gms_internal_zzgv) {
            this.zzuh = com_google_android_gms_ads_internal_zzs;
            this.zzui = com_google_android_gms_internal_zzgv;
        }

        public void run() {
            try {
                if (this.zzuh.zzss.zzvB != null) {
                    this.zzuh.zzss.zzvB.zza(this.zzui);
                }
            } catch (Throwable e) {
                zzqf.zzc("Could not call OnAppInstallAdLoadedListener.onAppInstallAdLoaded().", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.ads.internal.zzs.3 */
    class C09593 implements Runnable {
        final /* synthetic */ zzs zzuh;
        final /* synthetic */ zzgw zzuj;

        C09593(zzs com_google_android_gms_ads_internal_zzs, zzgw com_google_android_gms_internal_zzgw) {
            this.zzuh = com_google_android_gms_ads_internal_zzs;
            this.zzuj = com_google_android_gms_internal_zzgw;
        }

        public void run() {
            try {
                if (this.zzuh.zzss.zzvC != null) {
                    this.zzuh.zzss.zzvC.zza(this.zzuj);
                }
            } catch (Throwable e) {
                zzqf.zzc("Could not call OnContentAdLoadedListener.onContentAdLoaded().", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.ads.internal.zzs.4 */
    class C09604 implements Runnable {
        final /* synthetic */ zzpb zzsX;
        final /* synthetic */ zzs zzuh;
        final /* synthetic */ String zzuk;

        C09604(zzs com_google_android_gms_ads_internal_zzs, String str, zzpb com_google_android_gms_internal_zzpb) {
            this.zzuh = com_google_android_gms_ads_internal_zzs;
            this.zzuk = str;
            this.zzsX = com_google_android_gms_internal_zzpb;
        }

        public void run() {
            try {
                ((zzhs) this.zzuh.zzss.zzvE.get(this.zzuk)).zza((zzgx) this.zzsX.zzWi);
            } catch (Throwable e) {
                zzqf.zzc("Could not call onCustomTemplateAdLoadedListener.onCustomTemplateAdLoaded().", e);
            }
        }
    }

    public zzs(Context context, zze com_google_android_gms_ads_internal_zze, zzeg com_google_android_gms_internal_zzeg, String str, zzka com_google_android_gms_internal_zzka, zzqh com_google_android_gms_internal_zzqh) {
        super(context, com_google_android_gms_internal_zzeg, str, com_google_android_gms_internal_zzka, com_google_android_gms_internal_zzqh, com_google_android_gms_ads_internal_zze);
    }

    private static zzgv zza(zzke com_google_android_gms_internal_zzke) {
        return new zzgv(com_google_android_gms_internal_zzke.getHeadline(), com_google_android_gms_internal_zzke.getImages(), com_google_android_gms_internal_zzke.getBody(), com_google_android_gms_internal_zzke.zzfQ() != null ? com_google_android_gms_internal_zzke.zzfQ() : null, com_google_android_gms_internal_zzke.getCallToAction(), com_google_android_gms_internal_zzke.getStarRating(), com_google_android_gms_internal_zzke.getStore(), com_google_android_gms_internal_zzke.getPrice(), null, com_google_android_gms_internal_zzke.getExtras(), com_google_android_gms_internal_zzke.zzbF(), null);
    }

    private static zzgw zza(zzkf com_google_android_gms_internal_zzkf) {
        return new zzgw(com_google_android_gms_internal_zzkf.getHeadline(), com_google_android_gms_internal_zzkf.getImages(), com_google_android_gms_internal_zzkf.getBody(), com_google_android_gms_internal_zzkf.zzfV() != null ? com_google_android_gms_internal_zzkf.zzfV() : null, com_google_android_gms_internal_zzkf.getCallToAction(), com_google_android_gms_internal_zzkf.getAdvertiser(), null, com_google_android_gms_internal_zzkf.getExtras(), com_google_android_gms_internal_zzkf.zzbF(), null);
    }

    private void zza(zzgv com_google_android_gms_internal_zzgv) {
        zzpo.zzXC.post(new C09582(this, com_google_android_gms_internal_zzgv));
    }

    private void zza(zzgw com_google_android_gms_internal_zzgw) {
        zzpo.zzXC.post(new C09593(this, com_google_android_gms_internal_zzgw));
    }

    private void zza(zzpb com_google_android_gms_internal_zzpb, String str) {
        zzpo.zzXC.post(new C09604(this, str, com_google_android_gms_internal_zzpb));
    }

    public String getAdUnitId() {
        return this.zzss.zzvl;
    }

    public void pause() {
        throw new IllegalStateException("Native Ad DOES NOT support pause().");
    }

    public void resume() {
        throw new IllegalStateException("Native Ad DOES NOT support resume().");
    }

    public void showInterstitial() {
        throw new IllegalStateException("Interstitial is NOT supported by NativeAdManager.");
    }

    public void zza(SimpleArrayMap<String, zzhs> simpleArrayMap) {
        zzac.zzdj("setOnCustomTemplateAdLoadedListeners must be called on the main UI thread.");
        this.zzss.zzvE = simpleArrayMap;
    }

    public void zza(zzgp com_google_android_gms_internal_zzgp) {
        throw new IllegalStateException("CustomRendering is NOT supported by NativeAdManager.");
    }

    public void zza(zzgy com_google_android_gms_internal_zzgy) {
        if (this.zzug != null) {
            this.zzug.zzb(com_google_android_gms_internal_zzgy);
        }
    }

    public void zza(zzha com_google_android_gms_internal_zzha) {
        if (this.zzss.zzvs.zzWa != null) {
            zzw.zzcQ().zzkx().zza(this.zzss.zzvr, this.zzss.zzvs, com_google_android_gms_internal_zzha);
        }
    }

    public void zza(zzle com_google_android_gms_internal_zzle) {
        throw new IllegalStateException("In App Purchase is NOT supported by NativeAdManager.");
    }

    public void zza(zza com_google_android_gms_internal_zzpb_zza, zzgl com_google_android_gms_internal_zzgl) {
        if (com_google_android_gms_internal_zzpb_zza.zzvr != null) {
            this.zzss.zzvr = com_google_android_gms_internal_zzpb_zza.zzvr;
        }
        if (com_google_android_gms_internal_zzpb_zza.errorCode != -2) {
            zzpo.zzXC.post(new C09571(this, com_google_android_gms_internal_zzpb_zza));
            return;
        }
        this.zzss.zzvO = 0;
        this.zzss.zzvq = zzw.zzcL().zza(this.zzss.zzqn, this, com_google_android_gms_internal_zzpb_zza, this.zzss.zzvm, null, this.zzsz, this, com_google_android_gms_internal_zzgl);
        String str = "AdRenderer: ";
        String valueOf = String.valueOf(this.zzss.zzvq.getClass().getName());
        zzqf.zzbf(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
    }

    public boolean zza(zzec com_google_android_gms_internal_zzec, zzgl com_google_android_gms_internal_zzgl) {
        if (((Boolean) zzgd.zzEm.get()).booleanValue() && ((Boolean) zzgd.zzEn.get()).booleanValue()) {
            zzlw com_google_android_gms_internal_zzlw = new zzlw(this.zzss.zzqn, this, this.zzss.zzvm, this.zzss.zzvn);
            com_google_android_gms_internal_zzlw.zziT();
            try {
                com_google_android_gms_internal_zzlw.zziU();
            } catch (Throwable e) {
                zzqf.zzc("Initializing javascript failed", e);
                return false;
            }
        }
        return super.zza(com_google_android_gms_internal_zzec, com_google_android_gms_internal_zzgl);
    }

    protected boolean zza(zzec com_google_android_gms_internal_zzec, zzpb com_google_android_gms_internal_zzpb, boolean z) {
        return this.zzsr.zzcy();
    }

    protected boolean zza(zzpb com_google_android_gms_internal_zzpb, zzpb com_google_android_gms_internal_zzpb2) {
        zzb(null);
        if (this.zzss.zzdq()) {
            if (com_google_android_gms_internal_zzpb2.zzSn) {
                try {
                    zzke zzhc = com_google_android_gms_internal_zzpb2.zzLj != null ? com_google_android_gms_internal_zzpb2.zzLj.zzhc() : null;
                    zzkf zzhd = com_google_android_gms_internal_zzpb2.zzLj != null ? com_google_android_gms_internal_zzpb2.zzLj.zzhd() : null;
                    if (zzhc == null || this.zzss.zzvB == null) {
                        if (zzhd != null) {
                            if (this.zzss.zzvC != null) {
                                zzgw zza = zza(zzhd);
                                zza.zzb(new zzgz(this.zzss.zzqn, this, this.zzss.zzvm, zzhd, (zzha.zza) zza));
                                zza(zza);
                            }
                        }
                        zzqf.zzbh("No matching mapper/listener for retrieved native ad template.");
                        zzh(0);
                        return false;
                    }
                    zzgv zza2 = zza(zzhc);
                    zza2.zzb(new zzgz(this.zzss.zzqn, this, this.zzss.zzvm, zzhc, (zzha.zza) zza2));
                    zza(zza2);
                } catch (Throwable e) {
                    zzqf.zzc("Failed to get native ad mapper", e);
                }
            } else {
                zzha.zza com_google_android_gms_internal_zzha_zza = com_google_android_gms_internal_zzpb2.zzWi;
                if ((com_google_android_gms_internal_zzha_zza instanceof zzgw) && this.zzss.zzvC != null) {
                    zza((zzgw) com_google_android_gms_internal_zzpb2.zzWi);
                } else if ((com_google_android_gms_internal_zzha_zza instanceof zzgv) && this.zzss.zzvB != null) {
                    zza((zzgv) com_google_android_gms_internal_zzpb2.zzWi);
                } else if (!(com_google_android_gms_internal_zzha_zza instanceof zzgx) || this.zzss.zzvE == null || this.zzss.zzvE.get(((zzgx) com_google_android_gms_internal_zzha_zza).getCustomTemplateId()) == null) {
                    zzqf.zzbh("No matching listener for retrieved native ad template.");
                    zzh(0);
                    return false;
                } else {
                    zza(com_google_android_gms_internal_zzpb2, ((zzgx) com_google_android_gms_internal_zzha_zza).getCustomTemplateId());
                }
            }
            return super.zza(com_google_android_gms_internal_zzpb, com_google_android_gms_internal_zzpb2);
        }
        throw new IllegalStateException("Native ad DOES NOT have custom rendering mode.");
    }

    public void zzb(SimpleArrayMap<String, zzhr> simpleArrayMap) {
        zzac.zzdj("setOnCustomClickListener must be called on the main UI thread.");
        this.zzss.zzvD = simpleArrayMap;
    }

    public void zzb(zzhc com_google_android_gms_internal_zzhc) {
        zzac.zzdj("setNativeAdOptions must be called on the main UI thread.");
        this.zzss.zzvF = com_google_android_gms_internal_zzhc;
    }

    public void zzb(zzhp com_google_android_gms_internal_zzhp) {
        zzac.zzdj("setOnAppInstallAdLoadedListener must be called on the main UI thread.");
        this.zzss.zzvB = com_google_android_gms_internal_zzhp;
    }

    public void zzb(zzhq com_google_android_gms_internal_zzhq) {
        zzac.zzdj("setOnContentAdLoadedListener must be called on the main UI thread.");
        this.zzss.zzvC = com_google_android_gms_internal_zzhq;
    }

    public void zzb(@Nullable List<String> list) {
        zzac.zzdj("setNativeTemplates must be called on the main UI thread.");
        this.zzss.zzvK = list;
    }

    public void zzc(zzqw com_google_android_gms_internal_zzqw) {
        this.zzug = com_google_android_gms_internal_zzqw;
    }

    public void zzct() {
        if (this.zzss.zzvs == null || this.zzug == null) {
            zzqf.zzbh("Request to enable ActiveView before adState is available.");
        } else {
            zzw.zzcQ().zzkx().zza(this.zzss.zzvr, this.zzss.zzvs, this.zzug.getView(), this.zzug);
        }
    }

    public SimpleArrayMap<String, zzhs> zzcu() {
        zzac.zzdj("getOnCustomTemplateAdLoadedListeners must be called on the main UI thread.");
        return this.zzss.zzvE;
    }

    public void zzcv() {
        if (this.zzug != null) {
            this.zzug.destroy();
            this.zzug = null;
        }
    }

    public void zzcw() {
        if (this.zzug != null && this.zzug.zzlG() != null && this.zzss.zzvF != null && this.zzss.zzvF.zzHe != null) {
            this.zzug.zzlG().zzQ(this.zzss.zzvF.zzHe.zzAU);
        }
    }

    public boolean zzcx() {
        return this.zzss.zzvs != null && this.zzss.zzvs.zzSn && this.zzss.zzvs.zzWc != null && this.zzss.zzvs.zzWc.zzKR;
    }

    @Nullable
    public zzhr zzz(String str) {
        zzac.zzdj("getOnCustomClickListener must be called on the main UI thread.");
        return (zzhr) this.zzss.zzvD.get(str);
    }
}
