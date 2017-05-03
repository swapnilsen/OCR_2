package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.zzw;
import java.util.Map;

@zzme
public class zzks {
    private final zzqw zzIs;
    private final boolean zzMm;
    private final String zzMn;

    public zzks(zzqw com_google_android_gms_internal_zzqw, Map<String, String> map) {
        this.zzIs = com_google_android_gms_internal_zzqw;
        this.zzMn = (String) map.get("forceOrientation");
        if (map.containsKey("allowOrientationChange")) {
            this.zzMm = Boolean.parseBoolean((String) map.get("allowOrientationChange"));
        } else {
            this.zzMm = true;
        }
    }

    public void execute() {
        if (this.zzIs == null) {
            zzqf.zzbh("AdWebView is null");
            return;
        }
        int zzkR = "portrait".equalsIgnoreCase(this.zzMn) ? zzw.zzcO().zzkR() : "landscape".equalsIgnoreCase(this.zzMn) ? zzw.zzcO().zzkQ() : this.zzMm ? -1 : zzw.zzcO().zzkS();
        this.zzIs.setRequestedOrientation(zzkR);
    }
}
