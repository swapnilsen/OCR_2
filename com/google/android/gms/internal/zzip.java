package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzw;
import java.util.Map;

@zzme
class zzip implements zzid {
    zzip() {
    }

    private int zzh(Map<String, String> map) {
        int parseInt = Integer.parseInt((String) map.get("playbackState"));
        return (parseInt < 0 || 3 < parseInt) ? 0 : parseInt;
    }

    public void zza(zzqw com_google_android_gms_internal_zzqw, Map<String, String> map) {
        Throwable e;
        if (((Boolean) zzgd.zzDE.get()).booleanValue()) {
            zzrb com_google_android_gms_internal_zzrb;
            zzrb zzlG = com_google_android_gms_internal_zzqw.zzlG();
            if (zzlG == null) {
                try {
                    zzlG = new zzrb(com_google_android_gms_internal_zzqw, Float.parseFloat((String) map.get("duration")));
                    com_google_android_gms_internal_zzqw.zza(zzlG);
                    com_google_android_gms_internal_zzrb = zzlG;
                } catch (NullPointerException e2) {
                    e = e2;
                    zzqf.zzb("Unable to parse videoMeta message.", e);
                    zzw.zzcQ().zza(e, "VideoMetaGmsgHandler.onGmsg");
                    return;
                } catch (NumberFormatException e3) {
                    e = e3;
                    zzqf.zzb("Unable to parse videoMeta message.", e);
                    zzw.zzcQ().zza(e, "VideoMetaGmsgHandler.onGmsg");
                    return;
                }
            }
            com_google_android_gms_internal_zzrb = zzlG;
            boolean equals = "1".equals(map.get("muted"));
            float parseFloat = Float.parseFloat((String) map.get("currentTime"));
            int zzh = zzh(map);
            String str = (String) map.get("aspectRatio");
            float parseFloat2 = TextUtils.isEmpty(str) ? 0.0f : Float.parseFloat(str);
            if (zzqf.zzak(3)) {
                zzqf.zzbf(new StringBuilder(String.valueOf(str).length() + 79).append("Video Meta GMSG: isMuted : ").append(equals).append(" , playbackState : ").append(zzh).append(" , aspectRatio : ").append(str).toString());
            }
            com_google_android_gms_internal_zzrb.zza(parseFloat, zzh, equals, parseFloat2);
        }
    }
}
