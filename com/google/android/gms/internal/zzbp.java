package com.google.android.gms.internal;

import com.google.android.gms.internal.zzag.zza;
import java.util.concurrent.Callable;

public class zzbp implements Callable {
    private final zzbd zzpz;
    private final zza zzqV;

    public zzbp(zzbd com_google_android_gms_internal_zzbd, zza com_google_android_gms_internal_zzag_zza) {
        this.zzpz = com_google_android_gms_internal_zzbd;
        this.zzqV = com_google_android_gms_internal_zzag_zza;
    }

    public /* synthetic */ Object call() {
        return zzbk();
    }

    public Void zzbk() {
        if (this.zzpz.zzaS() != null) {
            this.zzpz.zzaS().get();
        }
        zzbxt zzaR = this.zzpz.zzaR();
        if (zzaR != null) {
            try {
                synchronized (this.zzqV) {
                    zzbxt.zza(this.zzqV, zzbxt.zzf(zzaR));
                }
            } catch (zzbxs e) {
            }
        }
        return null;
    }
}
