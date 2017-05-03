package com.google.android.gms.internal;

import android.content.Context;
import android.support.annotation.Nullable;
import com.google.android.gms.ads.internal.zze;
import com.google.android.gms.ads.internal.zzm;
import com.google.android.gms.ads.internal.zzw;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.zzet.zza;

@zzme
public class zzjd extends zza {
    private final zziw zzJc;
    @Nullable
    private zzm zzJh;
    private final zziy zzJu;
    @Nullable
    private zzli zzJv;
    private String zzJw;
    private final String zzts;

    public zzjd(Context context, String str, zzka com_google_android_gms_internal_zzka, zzqh com_google_android_gms_internal_zzqh, zze com_google_android_gms_ads_internal_zze) {
        this(str, new zziw(context, com_google_android_gms_internal_zzka, com_google_android_gms_internal_zzqh, com_google_android_gms_ads_internal_zze));
    }

    zzjd(String str, zziw com_google_android_gms_internal_zziw) {
        this.zzts = str;
        this.zzJc = com_google_android_gms_internal_zziw;
        this.zzJu = new zziy();
        zzw.zzdb().zza(com_google_android_gms_internal_zziw);
    }

    private void zzgK() {
        if (this.zzJh != null && this.zzJv != null) {
            this.zzJh.zza(this.zzJv, this.zzJw);
        }
    }

    static boolean zzp(zzec com_google_android_gms_internal_zzec) {
        return zziz.zzj(com_google_android_gms_internal_zzec).contains("gw");
    }

    static boolean zzq(zzec com_google_android_gms_internal_zzec) {
        return zziz.zzj(com_google_android_gms_internal_zzec).contains("_ad");
    }

    void abort() {
        if (this.zzJh == null) {
            this.zzJh = this.zzJc.zzag(this.zzts);
            this.zzJu.zzc(this.zzJh);
            zzgK();
        }
    }

    public void destroy() {
        if (this.zzJh != null) {
            this.zzJh.destroy();
        }
    }

    @Nullable
    public String getMediationAdapterClassName() {
        return this.zzJh != null ? this.zzJh.getMediationAdapterClassName() : null;
    }

    public boolean isLoading() {
        return this.zzJh != null && this.zzJh.isLoading();
    }

    public boolean isReady() {
        return this.zzJh != null && this.zzJh.isReady();
    }

    public void pause() {
        if (this.zzJh != null) {
            this.zzJh.pause();
        }
    }

    public void resume() {
        if (this.zzJh != null) {
            this.zzJh.resume();
        }
    }

    public void setManualImpressionsEnabled(boolean z) {
        abort();
        if (this.zzJh != null) {
            this.zzJh.setManualImpressionsEnabled(z);
        }
    }

    public void setUserId(String str) {
    }

    public void showInterstitial() {
        if (this.zzJh != null) {
            this.zzJh.showInterstitial();
        } else {
            zzqf.zzbh("Interstitial ad must be loaded before showInterstitial().");
        }
    }

    public void stopLoading() {
        if (this.zzJh != null) {
            this.zzJh.stopLoading();
        }
    }

    public void zza(zzeg com_google_android_gms_internal_zzeg) {
        if (this.zzJh != null) {
            this.zzJh.zza(com_google_android_gms_internal_zzeg);
        }
    }

    public void zza(zzeo com_google_android_gms_internal_zzeo) {
        this.zzJu.zzIY = com_google_android_gms_internal_zzeo;
        if (this.zzJh != null) {
            this.zzJu.zzc(this.zzJh);
        }
    }

    public void zza(zzep com_google_android_gms_internal_zzep) {
        this.zzJu.zztk = com_google_android_gms_internal_zzep;
        if (this.zzJh != null) {
            this.zzJu.zzc(this.zzJh);
        }
    }

    public void zza(zzev com_google_android_gms_internal_zzev) {
        this.zzJu.zzIV = com_google_android_gms_internal_zzev;
        if (this.zzJh != null) {
            this.zzJu.zzc(this.zzJh);
        }
    }

    public void zza(zzex com_google_android_gms_internal_zzex) {
        abort();
        if (this.zzJh != null) {
            this.zzJh.zza(com_google_android_gms_internal_zzex);
        }
    }

    public void zza(zzfc com_google_android_gms_internal_zzfc) {
        throw new IllegalStateException("Unused method");
    }

    public void zza(zzft com_google_android_gms_internal_zzft) {
        throw new IllegalStateException("getVideoController not implemented for interstitials");
    }

    public void zza(zzgp com_google_android_gms_internal_zzgp) {
        this.zzJu.zzIX = com_google_android_gms_internal_zzgp;
        if (this.zzJh != null) {
            this.zzJu.zzc(this.zzJh);
        }
    }

    public void zza(zzle com_google_android_gms_internal_zzle) {
        this.zzJu.zzIW = com_google_android_gms_internal_zzle;
        if (this.zzJh != null) {
            this.zzJu.zzc(this.zzJh);
        }
    }

    public void zza(zzli com_google_android_gms_internal_zzli, String str) {
        this.zzJv = com_google_android_gms_internal_zzli;
        this.zzJw = str;
        zzgK();
    }

    public void zza(zznw com_google_android_gms_internal_zznw) {
        this.zzJu.zzIZ = com_google_android_gms_internal_zznw;
        if (this.zzJh != null) {
            this.zzJu.zzc(this.zzJh);
        }
    }

    public boolean zzb(zzec com_google_android_gms_internal_zzec) {
        if (!zzp(com_google_android_gms_internal_zzec)) {
            abort();
        }
        if (zziz.zzl(com_google_android_gms_internal_zzec)) {
            abort();
        }
        if (com_google_android_gms_internal_zzec.zzza != null) {
            abort();
        }
        if (this.zzJh != null) {
            return this.zzJh.zzb(com_google_android_gms_internal_zzec);
        }
        zziz zzdb = zzw.zzdb();
        if (zzq(com_google_android_gms_internal_zzec)) {
            zzdb.zzb(com_google_android_gms_internal_zzec, this.zzts);
        }
        zza zza = zzdb.zza(com_google_android_gms_internal_zzec, this.zzts);
        if (zza != null) {
            if (zza.zzJl) {
                zzjc.zzgC().zzgF();
            } else {
                zza.load();
                zzjc.zzgC().zzgG();
            }
            this.zzJh = zza.zzJh;
            zza.zzJj.zza(this.zzJu);
            this.zzJu.zzc(this.zzJh);
            zzgK();
            return zza.zzJm;
        }
        abort();
        zzjc.zzgC().zzgG();
        return this.zzJh.zzb(com_google_android_gms_internal_zzec);
    }

    @Nullable
    public IObjectWrapper zzbB() {
        return this.zzJh != null ? this.zzJh.zzbB() : null;
    }

    @Nullable
    public zzeg zzbC() {
        return this.zzJh != null ? this.zzJh.zzbC() : null;
    }

    public void zzbE() {
        if (this.zzJh != null) {
            this.zzJh.zzbE();
        } else {
            zzqf.zzbh("Interstitial ad must be loaded before pingManualTrackingUrl().");
        }
    }

    public zzfa zzbF() {
        throw new IllegalStateException("getVideoController not implemented for interstitials");
    }
}
