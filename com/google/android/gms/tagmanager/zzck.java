package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzah;
import com.google.android.gms.internal.zzai;
import com.google.android.gms.internal.zzak.zza;
import java.util.Map;

class zzck extends zzam {
    private static final String ID;
    private static final String zzbHl;
    private static final String zzbHm;

    static {
        ID = zzah.RANDOM.toString();
        zzbHl = zzai.MIN.toString();
        zzbHm = zzai.MAX.toString();
    }

    public zzck() {
        super(ID, new String[0]);
    }

    public boolean zzQb() {
        return false;
    }

    public zza zzZ(Map<String, zza> map) {
        double doubleValue;
        double d;
        zza com_google_android_gms_internal_zzak_zza = (zza) map.get(zzbHl);
        zza com_google_android_gms_internal_zzak_zza2 = (zza) map.get(zzbHm);
        if (!(com_google_android_gms_internal_zzak_zza == null || com_google_android_gms_internal_zzak_zza == zzdl.zzRR() || com_google_android_gms_internal_zzak_zza2 == null || com_google_android_gms_internal_zzak_zza2 == zzdl.zzRR())) {
            zzdk zzf = zzdl.zzf(com_google_android_gms_internal_zzak_zza);
            zzdk zzf2 = zzdl.zzf(com_google_android_gms_internal_zzak_zza2);
            if (!(zzf == zzdl.zzRP() || zzf2 == zzdl.zzRP())) {
                double doubleValue2 = zzf.doubleValue();
                doubleValue = zzf2.doubleValue();
                if (doubleValue2 <= doubleValue) {
                    d = doubleValue2;
                    return zzdl.zzR(Long.valueOf(Math.round(((doubleValue - d) * Math.random()) + d)));
                }
            }
        }
        doubleValue = 2.147483647E9d;
        d = 0.0d;
        return zzdl.zzR(Long.valueOf(Math.round(((doubleValue - d) * Math.random()) + d)));
    }
}
