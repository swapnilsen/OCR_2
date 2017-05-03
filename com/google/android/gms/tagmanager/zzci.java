package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzai;
import com.google.android.gms.internal.zzak.zza;
import java.util.Map;
import java.util.Set;

public abstract class zzci extends zzam {
    private static final String zzbGf;
    private static final String zzbHc;

    static {
        zzbGf = zzai.ARG0.toString();
        zzbHc = zzai.ARG1.toString();
    }

    public zzci(String str) {
        super(str, zzbGf, zzbHc);
    }

    public /* bridge */ /* synthetic */ String zzQL() {
        return super.zzQL();
    }

    public /* bridge */ /* synthetic */ Set zzQM() {
        return super.zzQM();
    }

    public boolean zzQb() {
        return true;
    }

    public zza zzZ(Map<String, zza> map) {
        for (zza com_google_android_gms_internal_zzak_zza : map.values()) {
            if (com_google_android_gms_internal_zzak_zza == zzdl.zzRR()) {
                return zzdl.zzR(Boolean.valueOf(false));
            }
        }
        zza com_google_android_gms_internal_zzak_zza2 = (zza) map.get(zzbGf);
        zza com_google_android_gms_internal_zzak_zza3 = (zza) map.get(zzbHc);
        boolean zza = (com_google_android_gms_internal_zzak_zza2 == null || com_google_android_gms_internal_zzak_zza3 == null) ? false : zza(com_google_android_gms_internal_zzak_zza2, com_google_android_gms_internal_zzak_zza3, map);
        return zzdl.zzR(Boolean.valueOf(zza));
    }

    protected abstract boolean zza(zza com_google_android_gms_internal_zzak_zza, zza com_google_android_gms_internal_zzak_zza2, Map<String, zza> map);
}
