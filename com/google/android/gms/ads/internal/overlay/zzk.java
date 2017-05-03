package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.support.annotation.Nullable;
import com.google.android.gms.common.util.zzt;
import com.google.android.gms.internal.zzgl;
import com.google.android.gms.internal.zzme;
import com.google.android.gms.internal.zzqw;

@zzme
public abstract class zzk {
    @Nullable
    public abstract zzj zza(Context context, zzqw com_google_android_gms_internal_zzqw, int i, boolean z, zzgl com_google_android_gms_internal_zzgl);

    protected boolean zzh(zzqw com_google_android_gms_internal_zzqw) {
        return com_google_android_gms_internal_zzqw.zzbC().zzzz;
    }

    protected boolean zzs(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        zzt.zzzg();
        return applicationInfo == null || applicationInfo.targetSdkVersion >= 11;
    }
}
