package com.google.android.gms.tagmanager;

import android.os.Build;
import android.support.v4.os.EnvironmentCompat;
import com.google.android.gms.internal.zzah;
import com.google.android.gms.internal.zzak.zza;
import java.util.Map;

class zzac extends zzam {
    private static final String ID;

    static {
        ID = zzah.DEVICE_NAME.toString();
    }

    public zzac() {
        super(ID, new String[0]);
    }

    public boolean zzQb() {
        return true;
    }

    public zza zzZ(Map<String, zza> map) {
        String str = Build.MANUFACTURER;
        Object obj = Build.MODEL;
        if (!(obj.startsWith(str) || str.equals(EnvironmentCompat.MEDIA_UNKNOWN))) {
            obj = new StringBuilder((String.valueOf(str).length() + 1) + String.valueOf(obj).length()).append(str).append(" ").append(obj).toString();
        }
        return zzdl.zzR(obj);
    }
}
