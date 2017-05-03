package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.support.annotation.Nullable;
import com.google.android.gms.internal.zzgl;
import com.google.android.gms.internal.zzme;
import com.google.android.gms.internal.zzqw;

@zzme
public class zzo extends zzk {
    @Nullable
    public zzj zza(Context context, zzqw com_google_android_gms_internal_zzqw, int i, boolean z, zzgl com_google_android_gms_internal_zzgl) {
        if (!zzs(context)) {
            return null;
        }
        return new zzd(context, z, zzh(com_google_android_gms_internal_zzqw), new zzz(context, com_google_android_gms_internal_zzqw.zzly(), com_google_android_gms_internal_zzqw.getRequestId(), com_google_android_gms_internal_zzgl, com_google_android_gms_internal_zzqw.zzlE()));
    }
}
