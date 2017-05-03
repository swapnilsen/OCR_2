package com.google.android.gms.internal;

import android.text.TextUtils;
import java.util.Map;

@zzme
public class zzin implements zzid {
    private final zza zzIu;

    public interface zza {
        void zzb(zzoo com_google_android_gms_internal_zzoo);

        void zzcn();
    }

    public zzin(zza com_google_android_gms_internal_zzin_zza) {
        this.zzIu = com_google_android_gms_internal_zzin_zza;
    }

    public static void zza(zzqw com_google_android_gms_internal_zzqw, zza com_google_android_gms_internal_zzin_zza) {
        com_google_android_gms_internal_zzqw.zzlv().zza("/reward", new zzin(com_google_android_gms_internal_zzin_zza));
    }

    private void zzf(Map<String, String> map) {
        zzoo com_google_android_gms_internal_zzoo;
        try {
            int parseInt = Integer.parseInt((String) map.get("amount"));
            String str = (String) map.get("type");
            if (!TextUtils.isEmpty(str)) {
                com_google_android_gms_internal_zzoo = new zzoo(str, parseInt);
                this.zzIu.zzb(com_google_android_gms_internal_zzoo);
            }
        } catch (Throwable e) {
            zzqf.zzc("Unable to parse reward amount.", e);
        }
        com_google_android_gms_internal_zzoo = null;
        this.zzIu.zzb(com_google_android_gms_internal_zzoo);
    }

    private void zzg(Map<String, String> map) {
        this.zzIu.zzcn();
    }

    public void zza(zzqw com_google_android_gms_internal_zzqw, Map<String, String> map) {
        String str = (String) map.get("action");
        if ("grant".equals(str)) {
            zzf(map);
        } else if ("video_start".equals(str)) {
            zzg(map);
        }
    }
}
