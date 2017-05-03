package com.google.android.gms.internal;

import android.support.annotation.Nullable;
import com.google.ads.mediation.facebook.FacebookAdapter;
import com.google.android.gms.ads.internal.zzw;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

@zzme
public final class zzjq {
    public final String zzKA;
    @Nullable
    public final List<String> zzKB;
    public final String zzKC;
    public final String zzKn;
    public final String zzKo;
    public final List<String> zzKp;
    public final String zzKq;
    public final String zzKr;
    public final List<String> zzKs;
    public final List<String> zzKt;
    public final List<String> zzKu;
    public final String zzKv;
    public final List<String> zzKw;
    public final List<String> zzKx;
    @Nullable
    public final String zzKy;
    @Nullable
    public final String zzKz;

    public zzjq(String str, String str2, List<String> list, String str3, String str4, List<String> list2, List<String> list3, String str5, String str6, List<String> list4, List<String> list5, String str7, String str8, String str9, List<String> list6, String str10, List<String> list7) {
        this.zzKn = str;
        this.zzKo = str2;
        this.zzKp = list;
        this.zzKq = str3;
        this.zzKr = str4;
        this.zzKs = list2;
        this.zzKt = list3;
        this.zzKv = str5;
        this.zzKw = list4;
        this.zzKx = list5;
        this.zzKy = str7;
        this.zzKz = str8;
        this.zzKA = str9;
        this.zzKB = list6;
        this.zzKC = str10;
        this.zzKu = list7;
    }

    public zzjq(JSONObject jSONObject) {
        String str = null;
        this.zzKo = jSONObject.optString(FacebookAdapter.KEY_ID);
        JSONArray jSONArray = jSONObject.getJSONArray("adapters");
        List arrayList = new ArrayList(jSONArray.length());
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(jSONArray.getString(i));
        }
        this.zzKp = Collections.unmodifiableList(arrayList);
        this.zzKq = jSONObject.optString("allocation_id", null);
        this.zzKs = zzw.zzdf().zza(jSONObject, "clickurl");
        this.zzKt = zzw.zzdf().zza(jSONObject, "imp_urls");
        this.zzKu = zzw.zzdf().zza(jSONObject, "fill_urls");
        this.zzKw = zzw.zzdf().zza(jSONObject, "video_start_urls");
        this.zzKx = zzw.zzdf().zza(jSONObject, "video_complete_urls");
        JSONObject optJSONObject = jSONObject.optJSONObject("ad");
        this.zzKn = optJSONObject != null ? optJSONObject.toString() : null;
        JSONObject optJSONObject2 = jSONObject.optJSONObject("data");
        this.zzKv = optJSONObject2 != null ? optJSONObject2.toString() : null;
        this.zzKr = optJSONObject2 != null ? optJSONObject2.optString("class_name") : null;
        this.zzKy = jSONObject.optString("html_template", null);
        this.zzKz = jSONObject.optString("ad_base_url", null);
        optJSONObject = jSONObject.optJSONObject("assets");
        this.zzKA = optJSONObject != null ? optJSONObject.toString() : null;
        this.zzKB = zzw.zzdf().zza(jSONObject, "template_ids");
        optJSONObject = jSONObject.optJSONObject("ad_loader_options");
        if (optJSONObject != null) {
            str = optJSONObject.toString();
        }
        this.zzKC = str;
    }
}
