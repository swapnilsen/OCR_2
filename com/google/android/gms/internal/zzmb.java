package com.google.android.gms.internal;

import android.support.v4.util.SimpleArrayMap;
import android.view.View;
import com.google.android.gms.internal.zzlx.zza;
import java.util.concurrent.Future;
import org.json.JSONArray;
import org.json.JSONObject;

@zzme
public class zzmb implements zza<zzgx> {
    private final boolean zzRc;

    public zzmb(boolean z) {
        this.zzRc = z;
    }

    private void zza(zzlx com_google_android_gms_internal_zzlx, JSONObject jSONObject, SimpleArrayMap<String, Future<zzgu>> simpleArrayMap) {
        simpleArrayMap.put(jSONObject.getString("name"), com_google_android_gms_internal_zzlx.zza(jSONObject, "image_value", this.zzRc));
    }

    private void zza(JSONObject jSONObject, SimpleArrayMap<String, String> simpleArrayMap) {
        simpleArrayMap.put(jSONObject.getString("name"), jSONObject.getString("string_value"));
    }

    private <K, V> SimpleArrayMap<K, V> zzc(SimpleArrayMap<K, Future<V>> simpleArrayMap) {
        SimpleArrayMap<K, V> simpleArrayMap2 = new SimpleArrayMap();
        for (int i = 0; i < simpleArrayMap.size(); i++) {
            simpleArrayMap2.put(simpleArrayMap.keyAt(i), ((Future) simpleArrayMap.valueAt(i)).get());
        }
        return simpleArrayMap2;
    }

    public /* synthetic */ zzha.zza zza(zzlx com_google_android_gms_internal_zzlx, JSONObject jSONObject) {
        return zzd(com_google_android_gms_internal_zzlx, jSONObject);
    }

    public zzgx zzd(zzlx com_google_android_gms_internal_zzlx, JSONObject jSONObject) {
        String valueOf;
        View view = null;
        SimpleArrayMap simpleArrayMap = new SimpleArrayMap();
        SimpleArrayMap simpleArrayMap2 = new SimpleArrayMap();
        Future zzd = com_google_android_gms_internal_zzlx.zzd(jSONObject);
        zzqm zzc = com_google_android_gms_internal_zzlx.zzc(jSONObject, "video");
        JSONArray jSONArray = jSONObject.getJSONArray("custom_assets");
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
            String string = jSONObject2.getString("type");
            if ("string".equals(string)) {
                zza(jSONObject2, simpleArrayMap2);
            } else if ("image".equals(string)) {
                zza(com_google_android_gms_internal_zzlx, jSONObject2, simpleArrayMap);
            } else {
                String str = "Unknown custom asset type: ";
                valueOf = String.valueOf(string);
                zzqf.zzbh(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            }
        }
        zzqw zzb = zzlx.zzb(zzc);
        valueOf = jSONObject.getString("custom_template_id");
        simpleArrayMap = zzc(simpleArrayMap);
        zzgs com_google_android_gms_internal_zzgs = (zzgs) zzd.get();
        zzfa zzlG = zzb != null ? zzb.zzlG() : null;
        if (zzb != null) {
            view = zzb.getView();
        }
        return new zzgx(valueOf, simpleArrayMap, simpleArrayMap2, com_google_android_gms_internal_zzgs, zzlG, view);
    }
}
