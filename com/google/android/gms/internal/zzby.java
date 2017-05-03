package com.google.android.gms.internal;

import android.view.View;
import com.google.android.gms.internal.zzag.zza;
import com.google.android.gms.internal.zzag.zza.zzb;

public class zzby extends zzca {
    private final View zzrb;

    public zzby(zzbd com_google_android_gms_internal_zzbd, String str, String str2, zza com_google_android_gms_internal_zzag_zza, int i, int i2, View view) {
        super(com_google_android_gms_internal_zzbd, str, str2, com_google_android_gms_internal_zzag_zza, i, i2);
        this.zzrb = view;
    }

    protected void zzbd() {
        if (this.zzrb != null) {
            zzbg com_google_android_gms_internal_zzbg = new zzbg((String) this.zzre.invoke(null, new Object[]{this.zzrb}));
            synchronized (this.zzqV) {
                this.zzqV.zzbU = new zzb();
                this.zzqV.zzbU.zzcn = com_google_android_gms_internal_zzbg.zzqQ;
            }
        }
    }
}
