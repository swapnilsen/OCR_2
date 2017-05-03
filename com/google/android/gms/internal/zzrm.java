package com.google.android.gms.internal;

import com.google.android.gms.analytics.zzf;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public final class zzrm extends zzf<zzrm> {
    private Map<Integer, String> zzacV;

    public zzrm() {
        this.zzacV = new HashMap(4);
    }

    public String toString() {
        Map hashMap = new HashMap();
        for (Entry entry : this.zzacV.entrySet()) {
            String valueOf = String.valueOf(entry.getKey());
            hashMap.put(new StringBuilder(String.valueOf(valueOf).length() + 9).append("dimension").append(valueOf).toString(), entry.getValue());
        }
        return zzf.zzj(hashMap);
    }

    public void zza(zzrm com_google_android_gms_internal_zzrm) {
        com_google_android_gms_internal_zzrm.zzacV.putAll(this.zzacV);
    }

    public /* synthetic */ void zzb(zzf com_google_android_gms_analytics_zzf) {
        zza((zzrm) com_google_android_gms_analytics_zzf);
    }

    public Map<Integer, String> zznh() {
        return Collections.unmodifiableMap(this.zzacV);
    }
}
