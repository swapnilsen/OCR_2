package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzah;
import com.google.android.gms.internal.zzak.zza;
import java.util.Map;

class zzaq extends zzam {
    private static final String ID;

    static {
        ID = zzah.GTM_VERSION.toString();
    }

    public zzaq() {
        super(ID, new String[0]);
    }

    public boolean zzQb() {
        return true;
    }

    public zza zzZ(Map<String, zza> map) {
        return zzdl.zzR("4.00");
    }
}
