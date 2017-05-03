package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzah;
import com.google.android.gms.internal.zzai;
import com.google.android.gms.internal.zzak.zza;
import java.util.Map;

class zzw extends zzam {
    private static final String ID;
    private static final String NAME;
    private static final String zzbFK;
    private final DataLayer zzbEV;

    static {
        ID = zzah.CUSTOM_VAR.toString();
        NAME = zzai.NAME.toString();
        zzbFK = zzai.DEFAULT_VALUE.toString();
    }

    public zzw(DataLayer dataLayer) {
        super(ID, NAME);
        this.zzbEV = dataLayer;
    }

    public boolean zzQb() {
        return false;
    }

    public zza zzZ(Map<String, zza> map) {
        Object obj = this.zzbEV.get(zzdl.zze((zza) map.get(NAME)));
        if (obj != null) {
            return zzdl.zzR(obj);
        }
        zza com_google_android_gms_internal_zzak_zza = (zza) map.get(zzbFK);
        return com_google_android_gms_internal_zzak_zza != null ? com_google_android_gms_internal_zzak_zza : zzdl.zzRR();
    }
}
