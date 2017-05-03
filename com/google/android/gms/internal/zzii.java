package com.google.android.gms.internal;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;
import org.json.JSONObject;

@zzme
public class zzii implements zzid {
    final HashMap<String, zzqj<JSONObject>> zzIn;

    public zzii() {
        this.zzIn = new HashMap();
    }

    public void zza(zzqw com_google_android_gms_internal_zzqw, Map<String, String> map) {
        zzi((String) map.get("request_id"), (String) map.get("fetched_ad"));
    }

    public Future<JSONObject> zzab(String str) {
        Future com_google_android_gms_internal_zzqj = new zzqj();
        this.zzIn.put(str, com_google_android_gms_internal_zzqj);
        return com_google_android_gms_internal_zzqj;
    }

    public void zzac(String str) {
        zzqj com_google_android_gms_internal_zzqj = (zzqj) this.zzIn.get(str);
        if (com_google_android_gms_internal_zzqj == null) {
            zzqf.m4708e("Could not find the ad request for the corresponding ad response.");
            return;
        }
        if (!com_google_android_gms_internal_zzqj.isDone()) {
            com_google_android_gms_internal_zzqj.cancel(true);
        }
        this.zzIn.remove(str);
    }

    public void zzi(String str, String str2) {
        zzqf.zzbf("Received ad from the cache.");
        zzqj com_google_android_gms_internal_zzqj = (zzqj) this.zzIn.get(str);
        if (com_google_android_gms_internal_zzqj == null) {
            zzqf.m4708e("Could not find the ad request for the corresponding ad response.");
            return;
        }
        try {
            com_google_android_gms_internal_zzqj.zzh(new JSONObject(str2));
        } catch (Throwable e) {
            zzqf.zzb("Failed constructing JSON object from value passed from javascript", e);
            com_google_android_gms_internal_zzqj.zzh(null);
        } finally {
            this.zzIn.remove(str);
        }
    }
}
