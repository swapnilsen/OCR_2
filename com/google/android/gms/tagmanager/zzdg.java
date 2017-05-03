package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzak.zza;
import java.util.Map;

abstract class zzdg extends zzci {
    public zzdg(String str) {
        super(str);
    }

    protected boolean zza(zza com_google_android_gms_internal_zzak_zza, zza com_google_android_gms_internal_zzak_zza2, Map<String, zza> map) {
        String zze = zzdl.zze(com_google_android_gms_internal_zzak_zza);
        String zze2 = zzdl.zze(com_google_android_gms_internal_zzak_zza2);
        return (zze == zzdl.zzRQ() || zze2 == zzdl.zzRQ()) ? false : zza(zze, zze2, (Map) map);
    }

    protected abstract boolean zza(String str, String str2, Map<String, zza> map);
}
