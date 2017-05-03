package com.google.android.gms.internal;

import com.google.android.gms.internal.zzmu.zza;
import java.lang.ref.WeakReference;

@zzme
public final class zzmm extends zza {
    private final WeakReference<zzmh.zza> zzSl;

    public zzmm(zzmh.zza com_google_android_gms_internal_zzmh_zza) {
        this.zzSl = new WeakReference(com_google_android_gms_internal_zzmh_zza);
    }

    public void zza(zzmn com_google_android_gms_internal_zzmn) {
        zzmh.zza com_google_android_gms_internal_zzmh_zza = (zzmh.zza) this.zzSl.get();
        if (com_google_android_gms_internal_zzmh_zza != null) {
            com_google_android_gms_internal_zzmh_zza.zza(com_google_android_gms_internal_zzmn);
        }
    }
}
