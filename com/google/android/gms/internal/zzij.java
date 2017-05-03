package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.zzw;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.Map;
import net.nend.android.NendAdIconLayout;
import net.nend.android.NendIconError;

@zzme
public class zzij implements zzid {
    public void zza(zzqw com_google_android_gms_internal_zzqw, Map<String, String> map) {
        if (zzw.zzdl().zzjQ()) {
            int i = -1;
            try {
                i = Integer.parseInt((String) map.get("eventType"));
            } catch (Throwable e) {
                zzqf.zzb("Parse Scion log event type error", e);
            }
            String str = (String) map.get("eventId");
            switch (i) {
                case NendAdIconLayout.HORIZONTAL /*0*/:
                    zzw.zzdl().zzf(com_google_android_gms_internal_zzqw.getContext(), str);
                case NendIconError.ERROR_ICONVIEW /*1*/:
                    zzw.zzdl().zzg(com_google_android_gms_internal_zzqw.getContext(), str);
                case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                    zzw.zzdl().zzi(com_google_android_gms_internal_zzqw.getContext(), str);
                default:
            }
        }
    }
}
