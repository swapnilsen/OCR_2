package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.zzah;
import com.google.android.gms.internal.zzai;
import com.google.android.gms.internal.zzak.zza;
import java.util.Map;

class zze extends zzam {
    private static final String ID;
    private static final String zzbEM;
    private static final String zzbEN;
    private final Context zzqn;

    static {
        ID = zzah.ADWORDS_CLICK_REFERRER.toString();
        zzbEM = zzai.COMPONENT.toString();
        zzbEN = zzai.CONVERSION_ID.toString();
    }

    public zze(Context context) {
        super(ID, zzbEN);
        this.zzqn = context;
    }

    public boolean zzQb() {
        return true;
    }

    public zza zzZ(Map<String, zza> map) {
        zza com_google_android_gms_internal_zzak_zza = (zza) map.get(zzbEN);
        if (com_google_android_gms_internal_zzak_zza == null) {
            return zzdl.zzRR();
        }
        String zze = zzdl.zze(com_google_android_gms_internal_zzak_zza);
        com_google_android_gms_internal_zzak_zza = (zza) map.get(zzbEM);
        String zzr = zzbf.zzr(this.zzqn, zze, com_google_android_gms_internal_zzak_zza != null ? zzdl.zze(com_google_android_gms_internal_zzak_zza) : null);
        return zzr != null ? zzdl.zzR(zzr) : zzdl.zzRR();
    }
}
