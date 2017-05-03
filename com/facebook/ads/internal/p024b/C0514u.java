package com.facebook.ads.internal.p024b;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PointerIconCompat;
import com.facebook.ads.internal.p021m.C0709s;
import com.facebook.ads.internal.p021m.C0710t;
import com.facebook.ads.internal.p021m.C0710t.C0507a;
import com.facebook.ads.internal.p021m.C0712u;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.internal.b.u */
public class C0514u implements C0507a {
    private final String f1064a;
    private final String f1065b;
    private final String f1066c;
    private final C0709s f1067d;
    private final String f1068e;
    private final Collection<String> f1069f;
    private final Map<String, String> f1070g;
    private final String f1071h;
    private final int f1072i;
    private final int f1073j;
    private final int f1074k;
    private final String f1075l;

    private C0514u(String str, String str2, String str3, C0709s c0709s, String str4, Collection<String> collection, Map<String, String> map, String str5, int i, int i2, int i3, String str6) {
        this.f1064a = str;
        this.f1065b = str2;
        this.f1066c = str3;
        this.f1067d = c0709s;
        this.f1068e = str4;
        this.f1069f = collection;
        this.f1070g = map;
        this.f1071h = str5;
        this.f1072i = i;
        this.f1073j = i2;
        this.f1074k = i3;
        this.f1075l = str6;
    }

    public static C0514u m1495a(Bundle bundle) {
        return new C0514u(C0712u.m2302a(bundle.getByteArray("markup")), null, bundle.getString("native_impression_report_url"), C0709s.NONE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING, null, null, bundle.getString("request_id"), bundle.getInt("viewability_check_initial_delay"), bundle.getInt("viewability_check_interval"), bundle.getInt("skip_after_seconds", 0), bundle.getString("ct"));
    }

    public static C0514u m1496a(JSONObject jSONObject) {
        int i = 0;
        if (jSONObject == null) {
            return null;
        }
        JSONArray jSONArray;
        String optString = jSONObject.optString("markup");
        String optString2 = jSONObject.optString("activation_command");
        String optString3 = jSONObject.optString("native_impression_report_url");
        String optString4 = jSONObject.optString("request_id");
        String a = C0712u.m2300a(jSONObject, "ct");
        C0709s a2 = C0709s.m2287a(jSONObject.optString("invalidation_behavior"));
        String optString5 = jSONObject.optString("invalidation_report_url");
        try {
            jSONArray = new JSONArray(jSONObject.optString("detection_strings"));
        } catch (JSONException e) {
            e.printStackTrace();
            jSONArray = null;
        }
        Collection a3 = C0710t.m2288a(jSONArray);
        JSONObject optJSONObject = jSONObject.optJSONObject("metadata");
        Map hashMap = new HashMap();
        if (optJSONObject != null) {
            Iterator keys = optJSONObject.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                hashMap.put(str, optJSONObject.optString(str));
            }
        }
        int i2 = PointerIconCompat.TYPE_DEFAULT;
        int parseInt = hashMap.containsKey("viewability_check_initial_delay") ? Integer.parseInt((String) hashMap.get("viewability_check_initial_delay")) : 0;
        if (hashMap.containsKey("viewability_check_interval")) {
            i2 = Integer.parseInt((String) hashMap.get("viewability_check_interval"));
        }
        if (hashMap.containsKey("skip_after_seconds")) {
            i = Integer.parseInt((String) hashMap.get("skip_after_seconds"));
        }
        return new C0514u(optString, optString2, optString3, a2, optString5, a3, hashMap, optString4, parseInt, i2, i, a);
    }

    public static C0514u m1497b(Intent intent) {
        return new C0514u(C0712u.m2302a(intent.getByteArrayExtra("markup")), intent.getStringExtra("activation_command"), intent.getStringExtra("native_impression_report_url"), C0709s.NONE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING, null, null, intent.getStringExtra("request_id"), intent.getIntExtra("viewability_check_initial_delay", 0), intent.getIntExtra("viewability_check_interval", PointerIconCompat.TYPE_DEFAULT), intent.getIntExtra("skipAfterSeconds", 0), intent.getStringExtra("ct"));
    }

    public String m1498C() {
        return this.f1075l;
    }

    public C0709s m1499D() {
        return this.f1067d;
    }

    public String m1500E() {
        return this.f1068e;
    }

    public Collection<String> m1501F() {
        return this.f1069f;
    }

    public String m1502a() {
        return this.f1064a;
    }

    public void m1503a(Intent intent) {
        intent.putExtra("markup", C0712u.m2311a(this.f1064a));
        intent.putExtra("activation_command", this.f1065b);
        intent.putExtra("native_impression_report_url", this.f1066c);
        intent.putExtra("request_id", this.f1071h);
        intent.putExtra("viewability_check_initial_delay", this.f1072i);
        intent.putExtra("viewability_check_interval", this.f1073j);
        intent.putExtra("skipAfterSeconds", this.f1074k);
        intent.putExtra("ct", this.f1075l);
    }

    public String m1504b() {
        return this.f1065b;
    }

    public String m1505c() {
        return this.f1066c;
    }

    public String m1506d() {
        return "facebookAd.sendImpression();";
    }

    public Map<String, String> m1507e() {
        return this.f1070g;
    }

    public String m1508f() {
        return this.f1071h;
    }

    public int m1509g() {
        return this.f1072i;
    }

    public int m1510h() {
        return this.f1073j;
    }

    public Bundle m1511i() {
        Bundle bundle = new Bundle();
        bundle.putByteArray("markup", C0712u.m2311a(this.f1064a));
        bundle.putString("native_impression_report_url", this.f1066c);
        bundle.putString("request_id", this.f1071h);
        bundle.putInt("viewability_check_initial_delay", this.f1072i);
        bundle.putInt("viewability_check_interval", this.f1073j);
        bundle.putInt("skip_after_seconds", this.f1074k);
        bundle.putString("ct", this.f1075l);
        return bundle;
    }
}
