package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzah;
import com.google.android.gms.internal.zzak.zza;
import java.util.Map;

class zzr extends zzam {
    private static final String ID;
    private final String zzavB;

    static {
        ID = zzah.CONTAINER_VERSION.toString();
    }

    public zzr(String str) {
        super(ID, new String[0]);
        this.zzavB = str;
    }

    public boolean zzQb() {
        return true;
    }

    public zza zzZ(Map<String, zza> map) {
        return this.zzavB == null ? zzdl.zzRR() : zzdl.zzR(this.zzavB);
    }
}
