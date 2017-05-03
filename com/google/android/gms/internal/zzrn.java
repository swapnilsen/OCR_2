package com.google.android.gms.internal;

import com.google.android.gms.analytics.zzf;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public final class zzrn extends zzf<zzrn> {
    private Map<Integer, Double> zzacW;

    public zzrn() {
        this.zzacW = new HashMap(4);
    }

    public String toString() {
        Map hashMap = new HashMap();
        for (Entry entry : this.zzacW.entrySet()) {
            String valueOf = String.valueOf(entry.getKey());
            hashMap.put(new StringBuilder(String.valueOf(valueOf).length() + 6).append("metric").append(valueOf).toString(), entry.getValue());
        }
        return zzf.zzj(hashMap);
    }

    public void zza(zzrn com_google_android_gms_internal_zzrn) {
        com_google_android_gms_internal_zzrn.zzacW.putAll(this.zzacW);
    }

    public /* synthetic */ void zzb(zzf com_google_android_gms_analytics_zzf) {
        zza((zzrn) com_google_android_gms_analytics_zzf);
    }

    public Map<Integer, Double> zzni() {
        return Collections.unmodifiableMap(this.zzacW);
    }
}
