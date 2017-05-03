package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.zzw;
import com.google.android.gms.internal.zzcy.zza;
import com.google.android.gms.internal.zzcy.zzb;

@zzme
public class zzov implements zzb {
    private final Context mContext;
    boolean zzVV;
    private final Object zzrJ;
    private final String zzts;

    public zzov(Context context, String str) {
        this.mContext = context;
        this.zzts = str;
        this.zzVV = false;
        this.zzrJ = new Object();
    }

    public void zzC(boolean z) {
        if (zzw.zzdl().zzjQ()) {
            synchronized (this.zzrJ) {
                if (this.zzVV == z) {
                    return;
                }
                this.zzVV = z;
                if (this.zzVV) {
                    zzw.zzdl().zzd(this.mContext, this.zzts);
                } else {
                    zzw.zzdl().zze(this.mContext, this.zzts);
                }
            }
        }
    }

    public void zza(zza com_google_android_gms_internal_zzcy_zza) {
        zzC(com_google_android_gms_internal_zzcy_zza.zzxl);
    }
}
