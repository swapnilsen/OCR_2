package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzah;
import com.google.android.gms.internal.zzai;
import com.google.android.gms.internal.zzak.zza;
import java.util.Map;

class zzbq extends zzam {
    private static final String ID;
    private static final String zzbGf;

    static {
        ID = zzah.LOWERCASE_STRING.toString();
        zzbGf = zzai.ARG0.toString();
    }

    public zzbq() {
        super(ID, zzbGf);
    }

    public boolean zzQb() {
        return true;
    }

    public zza zzZ(Map<String, zza> map) {
        return zzdl.zzR(zzdl.zze((zza) map.get(zzbGf)).toLowerCase());
    }
}
