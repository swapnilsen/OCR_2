package com.google.android.gms.internal;

import android.provider.Settings.SettingNotFoundException;
import com.google.android.gms.internal.zzag.zza;
import java.lang.reflect.InvocationTargetException;

public class zzbi extends zzca {
    public zzbi(zzbd com_google_android_gms_internal_zzbd, String str, String str2, zza com_google_android_gms_internal_zzag_zza, int i, int i2) {
        super(com_google_android_gms_internal_zzbd, str, str2, com_google_android_gms_internal_zzag_zza, i, i2);
    }

    protected void zzbd() {
        this.zzqV.zzbL = Integer.valueOf(2);
        try {
            this.zzqV.zzbL = Integer.valueOf(((Boolean) this.zzre.invoke(null, new Object[]{this.zzpz.getApplicationContext()})).booleanValue() ? 1 : 0);
        } catch (InvocationTargetException e) {
            if (!(e.getTargetException() instanceof SettingNotFoundException)) {
                throw e;
            }
        }
    }
}
