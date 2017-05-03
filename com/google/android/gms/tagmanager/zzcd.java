package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzak.zza;
import java.util.Map;

abstract class zzcd extends zzci {
    public zzcd(String str) {
        super(str);
    }

    protected boolean zza(zza com_google_android_gms_internal_zzak_zza, zza com_google_android_gms_internal_zzak_zza2, Map<String, zza> map) {
        zzdk zzf = zzdl.zzf(com_google_android_gms_internal_zzak_zza);
        zzdk zzf2 = zzdl.zzf(com_google_android_gms_internal_zzak_zza2);
        return (zzf == zzdl.zzRP() || zzf2 == zzdl.zzRP()) ? false : zza(zzf, zzf2, (Map) map);
    }

    protected abstract boolean zza(zzdk com_google_android_gms_tagmanager_zzdk, zzdk com_google_android_gms_tagmanager_zzdk2, Map<String, zza> map);
}
