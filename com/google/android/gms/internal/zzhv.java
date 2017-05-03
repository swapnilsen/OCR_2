package com.google.android.gms.internal;

import com.google.android.gms.ads.formats.NativeContentAd.OnContentAdLoadedListener;
import com.google.android.gms.internal.zzhq.zza;

@zzme
public class zzhv extends zza {
    private final OnContentAdLoadedListener zzHz;

    public zzhv(OnContentAdLoadedListener onContentAdLoadedListener) {
        this.zzHz = onContentAdLoadedListener;
    }

    public void zza(zzhl com_google_android_gms_internal_zzhl) {
        this.zzHz.onContentAdLoaded(zzb(com_google_android_gms_internal_zzhl));
    }

    zzhm zzb(zzhl com_google_android_gms_internal_zzhl) {
        return new zzhm(com_google_android_gms_internal_zzhl);
    }
}
