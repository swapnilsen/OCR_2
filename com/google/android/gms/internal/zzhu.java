package com.google.android.gms.internal;

import com.google.android.gms.ads.formats.NativeAppInstallAd.OnAppInstallAdLoadedListener;
import com.google.android.gms.internal.zzhp.zza;

@zzme
public class zzhu extends zza {
    private final OnAppInstallAdLoadedListener zzHy;

    public zzhu(OnAppInstallAdLoadedListener onAppInstallAdLoadedListener) {
        this.zzHy = onAppInstallAdLoadedListener;
    }

    public void zza(zzhj com_google_android_gms_internal_zzhj) {
        this.zzHy.onAppInstallAdLoaded(zzb(com_google_android_gms_internal_zzhj));
    }

    zzhk zzb(zzhj com_google_android_gms_internal_zzhj) {
        return new zzhk(com_google_android_gms_internal_zzhj);
    }
}
