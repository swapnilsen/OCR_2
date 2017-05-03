package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.zzw;
import com.google.android.gms.common.internal.zzc;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.Map;

@zzme
public class zzit implements zzid {
    public void zza(zzqw com_google_android_gms_internal_zzqw, Map<String, String> map) {
        zzir zzdj = zzw.zzdj();
        if (!map.containsKey("abort")) {
            String str = (String) map.get("src");
            if (str == null) {
                zzqf.zzbh("Precache video action is missing the src parameter.");
                return;
            }
            int parseInt;
            try {
                parseInt = Integer.parseInt((String) map.get("player"));
            } catch (NumberFormatException e) {
                parseInt = 0;
            }
            String str2 = map.containsKey("mimetype") ? (String) map.get("mimetype") : FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING;
            if (zzdj.zzf(com_google_android_gms_internal_zzqw)) {
                zzqf.zzbh("Precache task already running.");
                return;
            }
            zzc.zzt(com_google_android_gms_internal_zzqw.zzby());
            new zziq(com_google_android_gms_internal_zzqw, com_google_android_gms_internal_zzqw.zzby().zzsM.zza(com_google_android_gms_internal_zzqw, parseInt, str2), str).zziP();
        } else if (!zzdj.zze(com_google_android_gms_internal_zzqw)) {
            zzqf.zzbh("Precache abort but no preload task running.");
        }
    }
}
