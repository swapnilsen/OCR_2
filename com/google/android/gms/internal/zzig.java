package com.google.android.gms.internal;

import java.util.Map;

@zzme
public class zzig implements zzid {
    private final zzih zzIm;

    public zzig(zzih com_google_android_gms_internal_zzih) {
        this.zzIm = com_google_android_gms_internal_zzih;
    }

    public void zza(zzqw com_google_android_gms_internal_zzqw, Map<String, String> map) {
        float parseFloat;
        boolean equals = "1".equals(map.get("transparentBackground"));
        boolean equals2 = "1".equals(map.get("blur"));
        try {
            if (map.get("blurRadius") != null) {
                parseFloat = Float.parseFloat((String) map.get("blurRadius"));
                this.zzIm.zzg(equals);
                this.zzIm.zza(equals2, parseFloat);
            }
        } catch (Throwable e) {
            zzqf.zzb("Fail to parse float", e);
        }
        parseFloat = 0.0f;
        this.zzIm.zzg(equals);
        this.zzIm.zza(equals2, parseFloat);
    }
}
