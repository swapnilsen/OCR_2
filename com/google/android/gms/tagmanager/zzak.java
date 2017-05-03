package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzah;
import com.google.android.gms.internal.zzak.zza;
import java.util.Map;

class zzak extends zzam {
    private static final String ID;
    private final zzcx zzbEW;

    static {
        ID = zzah.EVENT.toString();
    }

    public zzak(zzcx com_google_android_gms_tagmanager_zzcx) {
        super(ID, new String[0]);
        this.zzbEW = com_google_android_gms_tagmanager_zzcx;
    }

    public boolean zzQb() {
        return false;
    }

    public zza zzZ(Map<String, zza> map) {
        String zzRo = this.zzbEW.zzRo();
        return zzRo == null ? zzdl.zzRR() : zzdl.zzR(zzRo);
    }
}
