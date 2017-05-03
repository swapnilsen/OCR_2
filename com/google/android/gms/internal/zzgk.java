package com.google.android.gms.internal;

import android.support.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;

@zzme
public class zzgk {
    private final Map<String, zzgj> zzFN;
    @Nullable
    private final zzgl zzsn;

    public zzgk(@Nullable zzgl com_google_android_gms_internal_zzgl) {
        this.zzsn = com_google_android_gms_internal_zzgl;
        this.zzFN = new HashMap();
    }

    public void zza(String str, zzgj com_google_android_gms_internal_zzgj) {
        this.zzFN.put(str, com_google_android_gms_internal_zzgj);
    }

    public void zza(String str, String str2, long j) {
        zzgh.zza(this.zzsn, (zzgj) this.zzFN.get(str2), j, str);
        this.zzFN.put(str, zzgh.zza(this.zzsn, j));
    }

    @Nullable
    public zzgl zzfA() {
        return this.zzsn;
    }
}
