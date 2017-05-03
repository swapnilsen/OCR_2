package com.google.android.gms.internal;

import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.zzet.zza;

public class zzfl extends zza {
    private zzep zztk;

    /* renamed from: com.google.android.gms.internal.zzfl.1 */
    class C11771 implements Runnable {
        final /* synthetic */ zzfl zzAE;

        C11771(zzfl com_google_android_gms_internal_zzfl) {
            this.zzAE = com_google_android_gms_internal_zzfl;
        }

        public void run() {
            if (this.zzAE.zztk != null) {
                try {
                    this.zzAE.zztk.onAdFailedToLoad(1);
                } catch (Throwable e) {
                    zzqf.zzc("Could not notify onAdFailedToLoad event.", e);
                }
            }
        }
    }

    public void destroy() {
    }

    public String getMediationAdapterClassName() {
        return null;
    }

    public boolean isLoading() {
        return false;
    }

    public boolean isReady() {
        return false;
    }

    public void pause() {
    }

    public void resume() {
    }

    public void setManualImpressionsEnabled(boolean z) {
    }

    public void setUserId(String str) {
    }

    public void showInterstitial() {
    }

    public void stopLoading() {
    }

    public void zza(zzeg com_google_android_gms_internal_zzeg) {
    }

    public void zza(zzeo com_google_android_gms_internal_zzeo) {
    }

    public void zza(zzep com_google_android_gms_internal_zzep) {
        this.zztk = com_google_android_gms_internal_zzep;
    }

    public void zza(zzev com_google_android_gms_internal_zzev) {
    }

    public void zza(zzex com_google_android_gms_internal_zzex) {
    }

    public void zza(zzfc com_google_android_gms_internal_zzfc) {
    }

    public void zza(zzft com_google_android_gms_internal_zzft) {
    }

    public void zza(zzgp com_google_android_gms_internal_zzgp) {
    }

    public void zza(zzle com_google_android_gms_internal_zzle) {
    }

    public void zza(zzli com_google_android_gms_internal_zzli, String str) {
    }

    public void zza(zznw com_google_android_gms_internal_zznw) {
    }

    public boolean zzb(zzec com_google_android_gms_internal_zzec) {
        zzqf.m4708e("This app is using a lightweight version of the Google Mobile Ads SDK that requires the latest Google Play services to be installed, but Google Play services is either missing or out of date.");
        zzqe.zzYP.post(new C11771(this));
        return false;
    }

    public IObjectWrapper zzbB() {
        return null;
    }

    public zzeg zzbC() {
        return null;
    }

    public void zzbE() {
    }

    public zzfa zzbF() {
        return null;
    }
}
