package com.google.android.gms.tagmanager;

import android.os.Build.VERSION;
import com.google.android.gms.internal.zzah;
import com.google.android.gms.internal.zzak.zza;
import java.util.Map;

class zzcf extends zzam {
    private static final String ID;

    static {
        ID = zzah.OS_VERSION.toString();
    }

    public zzcf() {
        super(ID, new String[0]);
    }

    public boolean zzQb() {
        return true;
    }

    public zza zzZ(Map<String, zza> map) {
        return zzdl.zzR(VERSION.RELEASE);
    }
}
