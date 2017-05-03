package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.zzah;
import com.google.android.gms.internal.zzak.zza;
import java.util.Map;

class zzc extends zzam {
    private static final String ID;
    private final zza zzbEL;

    static {
        ID = zzah.ADVERTISING_TRACKING_ENABLED.toString();
    }

    public zzc(Context context) {
        this(zza.zzbS(context));
    }

    zzc(zza com_google_android_gms_tagmanager_zza) {
        super(ID, new String[0]);
        this.zzbEL = com_google_android_gms_tagmanager_zza;
    }

    public boolean zzQb() {
        return false;
    }

    public zza zzZ(Map<String, zza> map) {
        return zzdl.zzR(Boolean.valueOf(!this.zzbEL.isLimitAdTrackingEnabled()));
    }
}
