package com.facebook.ads.internal.p021m;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.internal.m.w */
public class C0714w {
    private final String f1743a;
    private final String f1744b;
    private final String f1745c;
    private final List<String> f1746d;
    private final String f1747e;
    private final String f1748f;

    private C0714w(String str, String str2, String str3, List<String> list, String str4, String str5) {
        this.f1743a = str;
        this.f1744b = str2;
        this.f1745c = str3;
        this.f1746d = list;
        this.f1747e = str4;
        this.f1748f = str5;
    }

    public static C0714w m2317a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        String optString = jSONObject.optString("package");
        String optString2 = jSONObject.optString("appsite");
        String optString3 = jSONObject.optString("appsite_url");
        JSONArray optJSONArray = jSONObject.optJSONArray("key_hashes");
        List arrayList = new ArrayList();
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                arrayList.add(optJSONArray.optString(i));
            }
        }
        return new C0714w(optString, optString2, optString3, arrayList, jSONObject.optString("market_uri"), jSONObject.optString("fallback_url"));
    }

    public String m2318a() {
        return this.f1743a;
    }

    public String m2319b() {
        return this.f1744b;
    }

    public String m2320c() {
        return this.f1745c;
    }
}
