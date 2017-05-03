package com.google.android.gms.ads.internal;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.util.zzt;
import com.google.android.gms.internal.zzcy;
import com.google.android.gms.internal.zzec;
import com.google.android.gms.internal.zzeg;
import com.google.android.gms.internal.zzel;
import com.google.android.gms.internal.zzfa;
import com.google.android.gms.internal.zzgd;
import com.google.android.gms.internal.zzka;
import com.google.android.gms.internal.zzme;
import com.google.android.gms.internal.zzot;
import com.google.android.gms.internal.zzov;
import com.google.android.gms.internal.zzpb;
import com.google.android.gms.internal.zzpo;
import com.google.android.gms.internal.zzqf;
import com.google.android.gms.internal.zzqh;
import com.google.android.gms.internal.zzqw;
import com.google.android.gms.internal.zzqx;
import com.google.android.gms.internal.zzqx.zzc;
import com.google.android.gms.internal.zzqx.zze;
import com.google.android.gms.internal.zzrb;
import java.util.List;

@zzme
public class zzg extends zzc implements OnGlobalLayoutListener, OnScrollChangedListener {
    private boolean zzsS;

    /* renamed from: com.google.android.gms.ads.internal.zzg.1 */
    class C09411 implements Runnable {
        final /* synthetic */ zzg zzsT;

        C09411(zzg com_google_android_gms_ads_internal_zzg) {
            this.zzsT = com_google_android_gms_ads_internal_zzg;
        }

        public void run() {
            this.zzsT.zzf(this.zzsT.zzss.zzvs);
        }
    }

    /* renamed from: com.google.android.gms.ads.internal.zzg.2 */
    class C09422 implements zze {
        final /* synthetic */ zzpb zzsU;
        final /* synthetic */ Runnable zzsV;

        C09422(zzg com_google_android_gms_ads_internal_zzg, zzpb com_google_android_gms_internal_zzpb, Runnable runnable) {
            this.zzsU = com_google_android_gms_internal_zzpb;
            this.zzsV = runnable;
        }

        public void zzce() {
            if (!this.zzsU.zzWb) {
                zzw.zzcM();
                zzpo.zzb(this.zzsV);
            }
        }
    }

    /* renamed from: com.google.android.gms.ads.internal.zzg.3 */
    class C09433 implements zzc {
        final /* synthetic */ zzcy zzsW;
        final /* synthetic */ zzpb zzsX;

        C09433(zzg com_google_android_gms_ads_internal_zzg, zzcy com_google_android_gms_internal_zzcy, zzpb com_google_android_gms_internal_zzpb) {
            this.zzsW = com_google_android_gms_internal_zzcy;
            this.zzsX = com_google_android_gms_internal_zzpb;
        }

        public void zzcf() {
            this.zzsW.zza(this.zzsX.zzNH);
        }
    }

    public class zza {
        final /* synthetic */ zzg zzsT;

        public zza(zzg com_google_android_gms_ads_internal_zzg) {
            this.zzsT = com_google_android_gms_ads_internal_zzg;
        }

        public void onClick() {
            this.zzsT.onAdClicked();
        }
    }

    public zzg(Context context, zzeg com_google_android_gms_internal_zzeg, String str, zzka com_google_android_gms_internal_zzka, zzqh com_google_android_gms_internal_zzqh, zze com_google_android_gms_ads_internal_zze) {
        super(context, com_google_android_gms_internal_zzeg, str, com_google_android_gms_internal_zzka, com_google_android_gms_internal_zzqh, com_google_android_gms_ads_internal_zze);
    }

    private zzeg zzb(com.google.android.gms.internal.zzpb.zza com_google_android_gms_internal_zzpb_zza) {
        if (com_google_android_gms_internal_zzpb_zza.zzWm.zzzC) {
            return this.zzss.zzvr;
        }
        AdSize adSize;
        String str = com_google_android_gms_internal_zzpb_zza.zzWm.zzSq;
        if (str != null) {
            String[] split = str.split("[xX]");
            split[0] = split[0].trim();
            split[1] = split[1].trim();
            adSize = new AdSize(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
        } else {
            adSize = this.zzss.zzvr.zzeF();
        }
        return new zzeg(this.zzss.zzqn, adSize);
    }

    private boolean zzb(@Nullable zzpb com_google_android_gms_internal_zzpb, zzpb com_google_android_gms_internal_zzpb2) {
        if (com_google_android_gms_internal_zzpb2.zzSn) {
            View zzg = zzp.zzg(com_google_android_gms_internal_zzpb2);
            if (zzg == null) {
                zzqf.zzbh("Could not get mediation view");
                return false;
            }
            View nextView = this.zzss.zzvo.getNextView();
            if (nextView != null) {
                if (nextView instanceof zzqw) {
                    ((zzqw) nextView).destroy();
                }
                this.zzss.zzvo.removeView(nextView);
            }
            if (!zzp.zzh(com_google_android_gms_internal_zzpb2)) {
                try {
                    zzb(zzg);
                } catch (Throwable th) {
                    zzw.zzcQ().zza(th, "BannerAdManager.swapViews");
                    zzqf.zzc("Could not add mediation view to view hierarchy.", th);
                    return false;
                }
            }
        } else if (!(com_google_android_gms_internal_zzpb2.zzWe == null || com_google_android_gms_internal_zzpb2.zzNH == null)) {
            com_google_android_gms_internal_zzpb2.zzNH.zza(com_google_android_gms_internal_zzpb2.zzWe);
            this.zzss.zzvo.removeAllViews();
            this.zzss.zzvo.setMinimumWidth(com_google_android_gms_internal_zzpb2.zzWe.widthPixels);
            this.zzss.zzvo.setMinimumHeight(com_google_android_gms_internal_zzpb2.zzWe.heightPixels);
            zzb(com_google_android_gms_internal_zzpb2.zzNH.getView());
        }
        if (this.zzss.zzvo.getChildCount() > 1) {
            this.zzss.zzvo.showNext();
        }
        if (com_google_android_gms_internal_zzpb != null) {
            View nextView2 = this.zzss.zzvo.getNextView();
            if (nextView2 instanceof zzqw) {
                ((zzqw) nextView2).zza(this.zzss.zzqn, this.zzss.zzvr, this.zzsn);
            } else if (nextView2 != null) {
                this.zzss.zzvo.removeView(nextView2);
            }
            this.zzss.zzdp();
        }
        this.zzss.zzvo.setVisibility(0);
        return true;
    }

    private void zze(zzpb com_google_android_gms_internal_zzpb) {
        zzt.zzzg();
        if (this.zzss.zzdq()) {
            if (com_google_android_gms_internal_zzpb.zzNH != null) {
                if (com_google_android_gms_internal_zzpb.zzWa != null) {
                    this.zzsu.zza(this.zzss.zzvr, com_google_android_gms_internal_zzpb);
                }
                zzcy com_google_android_gms_internal_zzcy = new zzcy(this.zzss.zzqn, com_google_android_gms_internal_zzpb.zzNH.getView());
                if (zzw.zzdl().zzjR()) {
                    com_google_android_gms_internal_zzcy.zza(new zzov(this.zzss.zzqn, this.zzss.zzvl));
                }
                if (com_google_android_gms_internal_zzpb.zzdD()) {
                    com_google_android_gms_internal_zzcy.zza(com_google_android_gms_internal_zzpb.zzNH);
                } else {
                    com_google_android_gms_internal_zzpb.zzNH.zzlv().zza(new C09433(this, com_google_android_gms_internal_zzcy, com_google_android_gms_internal_zzpb));
                }
            }
        } else if (this.zzss.zzvN != null && com_google_android_gms_internal_zzpb.zzWa != null) {
            this.zzsu.zza(this.zzss.zzvr, com_google_android_gms_internal_zzpb, this.zzss.zzvN);
        }
    }

    public void onGlobalLayout() {
        zzf(this.zzss.zzvs);
    }

    public void onScrollChanged() {
        zzf(this.zzss.zzvs);
    }

    public void setManualImpressionsEnabled(boolean z) {
        zzac.zzdj("setManualImpressionsEnabled must be called from the main thread.");
        this.zzsS = z;
    }

    public void showInterstitial() {
        throw new IllegalStateException("Interstitial is NOT supported by BannerAdManager.");
    }

    protected zzqw zza(com.google.android.gms.internal.zzpb.zza com_google_android_gms_internal_zzpb_zza, @Nullable zzf com_google_android_gms_ads_internal_zzf, @Nullable zzot com_google_android_gms_internal_zzot) {
        if (this.zzss.zzvr.zzzA == null && this.zzss.zzvr.zzzC) {
            this.zzss.zzvr = zzb(com_google_android_gms_internal_zzpb_zza);
        }
        return super.zza(com_google_android_gms_internal_zzpb_zza, com_google_android_gms_ads_internal_zzf, com_google_android_gms_internal_zzot);
    }

    protected void zza(@Nullable zzpb com_google_android_gms_internal_zzpb, boolean z) {
        super.zza(com_google_android_gms_internal_zzpb, z);
        if (zzp.zzh(com_google_android_gms_internal_zzpb)) {
            zzp.zza(com_google_android_gms_internal_zzpb, new zza(this));
        }
    }

    public boolean zza(@Nullable zzpb com_google_android_gms_internal_zzpb, zzpb com_google_android_gms_internal_zzpb2) {
        if (!super.zza(com_google_android_gms_internal_zzpb, com_google_android_gms_internal_zzpb2)) {
            return false;
        }
        if (!this.zzss.zzdq() || zzb(com_google_android_gms_internal_zzpb, com_google_android_gms_internal_zzpb2)) {
            zzrb zzlG;
            if (com_google_android_gms_internal_zzpb2.zzSF) {
                zzf(com_google_android_gms_internal_zzpb2);
                zzw.zzdk().zza(this.zzss.zzvo, (OnGlobalLayoutListener) this);
                zzw.zzdk().zza(this.zzss.zzvo, (OnScrollChangedListener) this);
                if (!com_google_android_gms_internal_zzpb2.zzWb) {
                    Runnable c09411 = new C09411(this);
                    zzqx zzlv = com_google_android_gms_internal_zzpb2.zzNH != null ? com_google_android_gms_internal_zzpb2.zzNH.zzlv() : null;
                    if (zzlv != null) {
                        zzlv.zza(new C09422(this, com_google_android_gms_internal_zzpb2, c09411));
                    }
                }
            } else if (!this.zzss.zzdr() || ((Boolean) zzgd.zzEh.get()).booleanValue()) {
                zza(com_google_android_gms_internal_zzpb2, false);
            }
            if (com_google_android_gms_internal_zzpb2.zzNH != null) {
                zzlG = com_google_android_gms_internal_zzpb2.zzNH.zzlG();
                zzqx zzlv2 = com_google_android_gms_internal_zzpb2.zzNH.zzlv();
                if (zzlv2 != null) {
                    zzlv2.zzlT();
                }
            } else {
                zzlG = null;
            }
            if (!(this.zzss.zzvG == null || zzlG == null)) {
                zzlG.zzQ(this.zzss.zzvG.zzAU);
            }
            zze(com_google_android_gms_internal_zzpb2);
            return true;
        }
        zzh(0);
        return false;
    }

    public boolean zzb(zzec com_google_android_gms_internal_zzec) {
        return super.zzb(zze(com_google_android_gms_internal_zzec));
    }

    @Nullable
    public zzfa zzbF() {
        zzac.zzdj("getVideoController must be called from the main thread.");
        return (this.zzss.zzvs == null || this.zzss.zzvs.zzNH == null) ? null : this.zzss.zzvs.zzNH.zzlG();
    }

    protected boolean zzbM() {
        boolean z = true;
        if (!zzw.zzcM().zze(this.zzss.zzqn, this.zzss.zzqn.getPackageName(), "android.permission.INTERNET")) {
            zzel.zzeT().zza(this.zzss.zzvo, this.zzss.zzvr, "Missing internet permission in AndroidManifest.xml.", "Missing internet permission in AndroidManifest.xml. You must have the following declaration: <uses-permission android:name=\"android.permission.INTERNET\" />");
            z = false;
        }
        if (!zzw.zzcM().zzJ(this.zzss.zzqn)) {
            zzel.zzeT().zza(this.zzss.zzvo, this.zzss.zzvr, "Missing AdActivity with android:configChanges in AndroidManifest.xml.", "Missing AdActivity with android:configChanges in AndroidManifest.xml. You must have the following declaration within the <application> element: <activity android:name=\"com.google.android.gms.ads.AdActivity\" android:configChanges=\"keyboard|keyboardHidden|orientation|screenLayout|uiMode|screenSize|smallestScreenSize\" />");
            z = false;
        }
        if (!(z || this.zzss.zzvo == null)) {
            this.zzss.zzvo.setVisibility(0);
        }
        return z;
    }

    zzec zze(zzec com_google_android_gms_internal_zzec) {
        if (com_google_android_gms_internal_zzec.zzyY == this.zzsS) {
            return com_google_android_gms_internal_zzec;
        }
        int i = com_google_android_gms_internal_zzec.versionCode;
        long j = com_google_android_gms_internal_zzec.zzyT;
        Bundle bundle = com_google_android_gms_internal_zzec.extras;
        int i2 = com_google_android_gms_internal_zzec.zzyU;
        List list = com_google_android_gms_internal_zzec.zzyV;
        boolean z = com_google_android_gms_internal_zzec.zzyW;
        int i3 = com_google_android_gms_internal_zzec.zzyX;
        boolean z2 = com_google_android_gms_internal_zzec.zzyY || this.zzsS;
        return new zzec(i, j, bundle, i2, list, z, i3, z2, com_google_android_gms_internal_zzec.zzyZ, com_google_android_gms_internal_zzec.zzza, com_google_android_gms_internal_zzec.zzzb, com_google_android_gms_internal_zzec.zzzc, com_google_android_gms_internal_zzec.zzzd, com_google_android_gms_internal_zzec.zzze, com_google_android_gms_internal_zzec.zzzf, com_google_android_gms_internal_zzec.zzzg, com_google_android_gms_internal_zzec.zzzh, com_google_android_gms_internal_zzec.zzzi);
    }

    void zzf(@Nullable zzpb com_google_android_gms_internal_zzpb) {
        if (com_google_android_gms_internal_zzpb != null && !com_google_android_gms_internal_zzpb.zzWb && this.zzss.zzvo != null && zzw.zzcM().zza(this.zzss.zzvo, this.zzss.zzqn) && this.zzss.zzvo.getGlobalVisibleRect(new Rect(), null)) {
            if (!(com_google_android_gms_internal_zzpb == null || com_google_android_gms_internal_zzpb.zzNH == null || com_google_android_gms_internal_zzpb.zzNH.zzlv() == null)) {
                com_google_android_gms_internal_zzpb.zzNH.zzlv().zza(null);
            }
            zza(com_google_android_gms_internal_zzpb, false);
            com_google_android_gms_internal_zzpb.zzWb = true;
        }
    }
}
