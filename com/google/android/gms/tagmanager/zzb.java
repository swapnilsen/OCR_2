package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.zzah;
import com.google.android.gms.internal.zzak.zza;
import java.util.Map;

class zzb extends zzam {
    private static final String ID;
    private final zza zzbEL;

    static {
        ID = zzah.ADVERTISER_ID.toString();
    }

    public zzb(Context context) {
        this(zza.zzbS(context));
    }

    zzb(zza com_google_android_gms_tagmanager_zza) {
        super(ID, new String[0]);
        this.zzbEL = com_google_android_gms_tagmanager_zza;
        this.zzbEL.zzPV();
    }

    public boolean zzQb() {
        return false;
    }

    public zza zzZ(Map<String, zza> map) {
        String zzPV = this.zzbEL.zzPV();
        return zzPV == null ? zzdl.zzRR() : zzdl.zzR(zzPV);
    }
}
