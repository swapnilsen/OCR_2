package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzah;
import com.google.android.gms.internal.zzak.zza;
import java.util.Map;

class zzch extends zzam {
    private static final String ID;
    private static final zza zzbHb;

    static {
        ID = zzah.PLATFORM.toString();
        zzbHb = zzdl.zzR("Android");
    }

    public zzch() {
        super(ID, new String[0]);
    }

    public boolean zzQb() {
        return true;
    }

    public zza zzZ(Map<String, zza> map) {
        return zzbHb;
    }
}
