package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzah;
import com.google.android.gms.internal.zzak.zza;
import java.util.Map;

class zzag extends zzdg {
    private static final String ID;

    static {
        ID = zzah.ENDS_WITH.toString();
    }

    public zzag() {
        super(ID);
    }

    protected boolean zza(String str, String str2, Map<String, zza> map) {
        return str.endsWith(str2);
    }
}
