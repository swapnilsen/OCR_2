package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.zzf;
import com.google.android.gms.plus.model.people.Person.Urls.Type;
import com.google.firebase.messaging.SendException;
import java.util.Map;
import net.nend.android.NendIconError;

@zzme
public class zzik implements zzid {
    static final Map<String, Integer> zzIq;
    private final zzf zzIo;
    private final zzkr zzIp;

    static {
        zzIq = com.google.android.gms.common.util.zzf.zza("resize", Integer.valueOf(1), "playVideo", Integer.valueOf(2), "storePicture", Integer.valueOf(3), "createCalendarEvent", Integer.valueOf(4), "setOrientationProperties", Integer.valueOf(5), "closeResizedAd", Integer.valueOf(6));
    }

    public zzik(zzf com_google_android_gms_ads_internal_zzf, zzkr com_google_android_gms_internal_zzkr) {
        this.zzIo = com_google_android_gms_ads_internal_zzf;
        this.zzIp = com_google_android_gms_internal_zzkr;
    }

    public void zza(zzqw com_google_android_gms_internal_zzqw, Map<String, String> map) {
        int intValue = ((Integer) zzIq.get((String) map.get("a"))).intValue();
        if (intValue == 5 || this.zzIo == null || this.zzIo.zzcd()) {
            switch (intValue) {
                case NendIconError.ERROR_ICONVIEW /*1*/:
                    this.zzIp.execute(map);
                    return;
                case SendException.ERROR_TTL_EXCEEDED /*3*/:
                    new zzkt(com_google_android_gms_internal_zzqw, map).execute();
                    return;
                case SendException.ERROR_TOO_MANY_MESSAGES /*4*/:
                    new zzkq(com_google_android_gms_internal_zzqw, map).execute();
                    return;
                case Type.OTHER_PROFILE /*5*/:
                    new zzks(com_google_android_gms_internal_zzqw, map).execute();
                    return;
                case Type.CONTRIBUTOR /*6*/:
                    this.zzIp.zzs(true);
                    return;
                default:
                    zzqf.zzbg("Unknown MRAID command called.");
                    return;
            }
        }
        this.zzIo.zzx(null);
    }
}
