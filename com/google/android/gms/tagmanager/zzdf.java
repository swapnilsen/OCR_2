package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzah;
import com.google.android.gms.internal.zzak.zza;
import java.util.Map;

class zzdf extends zzdg {
    private static final String ID;

    static {
        ID = zzah.STARTS_WITH.toString();
    }

    public zzdf() {
        super(ID);
    }

    protected boolean zza(String str, String str2, Map<String, zza> map) {
        return str.startsWith(str2);
    }
}
