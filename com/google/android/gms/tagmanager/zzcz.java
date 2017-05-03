package com.google.android.gms.tagmanager;

import android.os.Build.VERSION;
import com.google.android.gms.internal.zzah;
import com.google.android.gms.internal.zzak.zza;
import java.util.Map;

class zzcz extends zzam {
    private static final String ID;

    static {
        ID = zzah.SDK_VERSION.toString();
    }

    public zzcz() {
        super(ID, new String[0]);
    }

    public boolean zzQb() {
        return true;
    }

    public zza zzZ(Map<String, zza> map) {
        return zzdl.zzR(Integer.valueOf(VERSION.SDK_INT));
    }
}
