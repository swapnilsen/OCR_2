package com.google.android.gms.internal;

import android.support.annotation.Nullable;
import android.text.TextUtils;

@zzme
public class zzgg {
    @Nullable
    public zzgf zza(@Nullable zzge com_google_android_gms_internal_zzge) {
        if (com_google_android_gms_internal_zzge == null) {
            throw new IllegalArgumentException("CSI configuration can't be null. ");
        } else if (!com_google_android_gms_internal_zzge.zzfu()) {
            zzpk.m4709v("CsiReporterFactory: CSI is not enabled. No CSI reporter created.");
            return null;
        } else if (com_google_android_gms_internal_zzge.getContext() == null) {
            throw new IllegalArgumentException("Context can't be null. Please set up context in CsiConfiguration.");
        } else if (!TextUtils.isEmpty(com_google_android_gms_internal_zzge.zzdA())) {
            return new zzgf(com_google_android_gms_internal_zzge.getContext(), com_google_android_gms_internal_zzge.zzdA(), com_google_android_gms_internal_zzge.zzfv(), com_google_android_gms_internal_zzge.zzfw());
        } else {
            throw new IllegalArgumentException("AfmaVersion can't be null or empty. Please set up afmaVersion in CsiConfiguration.");
        }
    }
}
