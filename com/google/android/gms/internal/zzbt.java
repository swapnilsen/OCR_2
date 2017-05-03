package com.google.android.gms.internal;

import com.google.android.gms.internal.zzag.zza;
import java.util.List;

public class zzbt extends zzca {
    private List<Long> zzqY;

    public zzbt(zzbd com_google_android_gms_internal_zzbd, String str, String str2, zza com_google_android_gms_internal_zzag_zza, int i, int i2) {
        super(com_google_android_gms_internal_zzbd, str, str2, com_google_android_gms_internal_zzag_zza, i, i2);
        this.zzqY = null;
    }

    protected void zzbd() {
        this.zzqV.zzbx = Long.valueOf(-1);
        this.zzqV.zzby = Long.valueOf(-1);
        if (this.zzqY == null) {
            this.zzqY = (List) this.zzre.invoke(null, new Object[]{this.zzpz.getContext()});
        }
        if (this.zzqY != null && this.zzqY.size() == 2) {
            synchronized (this.zzqV) {
                this.zzqV.zzbx = Long.valueOf(((Long) this.zzqY.get(0)).longValue());
                this.zzqV.zzby = Long.valueOf(((Long) this.zzqY.get(1)).longValue());
            }
        }
    }
}
