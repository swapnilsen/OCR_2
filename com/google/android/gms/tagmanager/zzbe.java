package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.zzah;
import com.google.android.gms.internal.zzai;
import com.google.android.gms.internal.zzak.zza;
import java.util.Map;

class zzbe extends zzam {
    private static final String ID;
    private static final String zzbEM;
    private final Context zzqn;

    static {
        ID = zzah.INSTALL_REFERRER.toString();
        zzbEM = zzai.COMPONENT.toString();
    }

    public zzbe(Context context) {
        super(ID, new String[0]);
        this.zzqn = context;
    }

    public boolean zzQb() {
        return true;
    }

    public zza zzZ(Map<String, zza> map) {
        String zzO = zzbf.zzO(this.zzqn, ((zza) map.get(zzbEM)) != null ? zzdl.zze((zza) map.get(zzbEM)) : null);
        return zzO != null ? zzdl.zzR(zzO) : zzdl.zzRR();
    }
}
