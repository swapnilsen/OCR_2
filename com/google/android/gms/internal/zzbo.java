package com.google.android.gms.internal;

import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.internal.zzag.zza;
import java.io.IOException;

public class zzbo extends zzca {
    public zzbo(zzbd com_google_android_gms_internal_zzbd, String str, String str2, zza com_google_android_gms_internal_zzag_zza, int i, int i2) {
        super(com_google_android_gms_internal_zzbd, str, str2, com_google_android_gms_internal_zzag_zza, i, i2);
    }

    private void zzbi() {
        synchronized (this.zzqV) {
            this.zzqV.zzbW = (String) this.zzre.invoke(null, new Object[]{this.zzpz.getApplicationContext()});
        }
    }

    private void zzbj() {
        AdvertisingIdClient zzaY = this.zzpz.zzaY();
        if (zzaY != null) {
            try {
                Info info = zzaY.getInfo();
                String zzr = zzbf.zzr(info.getId());
                if (zzr != null) {
                    synchronized (this.zzqV) {
                        this.zzqV.zzbW = zzr;
                        this.zzqV.zzbY = Boolean.valueOf(info.isLimitAdTrackingEnabled());
                        this.zzqV.zzbX = Integer.valueOf(5);
                    }
                }
            } catch (IOException e) {
            }
        }
    }

    protected void zzbd() {
        if (this.zzpz.zzaN()) {
            zzbj();
        } else {
            zzbi();
        }
    }
}
