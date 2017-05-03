package com.google.android.gms.internal;

import java.util.Map;

@zzme
public final class zzhy implements zzid {
    private final zzhz zzHC;

    public zzhy(zzhz com_google_android_gms_internal_zzhz) {
        this.zzHC = com_google_android_gms_internal_zzhz;
    }

    public void zza(zzqw com_google_android_gms_internal_zzqw, Map<String, String> map) {
        String str = (String) map.get("name");
        if (str == null) {
            zzqf.zzbh("App event with no name parameter.");
        } else {
            this.zzHC.onAppEvent(str, (String) map.get("info"));
        }
    }
}
