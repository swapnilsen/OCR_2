package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.internal.zznt.zza;

@zzme
public class zznq extends zza {
    private final String zzUA;
    private final int zzVi;

    public zznq(String str, int i) {
        this.zzUA = str;
        this.zzVi = i;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof zznq)) {
            return false;
        }
        zznq com_google_android_gms_internal_zznq = (zznq) obj;
        return zzaa.equal(getType(), com_google_android_gms_internal_zznq.getType()) && zzaa.equal(Integer.valueOf(getAmount()), Integer.valueOf(com_google_android_gms_internal_zznq.getAmount()));
    }

    public int getAmount() {
        return this.zzVi;
    }

    public String getType() {
        return this.zzUA;
    }
}
