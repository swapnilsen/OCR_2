package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzw;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

@zzme
public class zzpd {
    private String mAppId;
    private final Map<String, zzjr> zzWA;
    private String zzWB;
    private boolean zzWC;
    private final long zzWy;
    private final List<String> zzWz;

    public zzpd(String str, long j) {
        this.zzWz = new ArrayList();
        this.zzWA = new HashMap();
        this.zzWC = false;
        this.zzWB = str;
        this.zzWy = j;
        zzaT(str);
    }

    private void zzaT(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.optInt(NotificationCompatApi24.CATEGORY_STATUS, -1) != 1) {
                    this.zzWC = false;
                    zzqf.zzbh("App settings could not be fetched successfully.");
                    return;
                }
                this.zzWC = true;
                this.mAppId = jSONObject.optString("app_id");
                JSONArray optJSONArray = jSONObject.optJSONArray("ad_unit_id_settings");
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        zzi(optJSONArray.getJSONObject(i));
                    }
                }
            } catch (Throwable e) {
                zzqf.zzc("Exception occurred while processing app setting json", e);
                zzw.zzcQ().zza(e, "AppSettings.parseAppSettingsJson");
            }
        }
    }

    private void zzi(JSONObject jSONObject) {
        String optString = jSONObject.optString("format");
        CharSequence optString2 = jSONObject.optString("ad_unit_id");
        if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
            if ("interstitial".equalsIgnoreCase(optString)) {
                this.zzWz.add(optString2);
            } else if ("rewarded".equalsIgnoreCase(optString)) {
                JSONObject optJSONObject = jSONObject.optJSONObject("mediation_config");
                if (optJSONObject != null) {
                    this.zzWA.put(optString2, new zzjr(optJSONObject));
                }
            }
        }
    }

    public long zzkb() {
        return this.zzWy;
    }

    public boolean zzkc() {
        return this.zzWC;
    }

    public String zzkd() {
        return this.zzWB;
    }

    public String zzke() {
        return this.mAppId;
    }

    public Map<String, zzjr> zzkf() {
        return this.zzWA;
    }
}
