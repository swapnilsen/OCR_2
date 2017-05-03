package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzah;
import com.google.android.gms.internal.zzak.zza;
import java.util.Map;

class zzs extends zzdg {
    private static final String ID;

    static {
        ID = zzah.CONTAINS.toString();
    }

    public zzs() {
        super(ID);
    }

    protected boolean zza(String str, String str2, Map<String, zza> map) {
        return str.contains(str2);
    }
}
