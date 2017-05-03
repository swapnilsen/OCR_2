package com.facebook.ads.internal.p021m;

import android.support.annotation.Nullable;
import com.facebook.ads.internal.p027l.C0656a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.internal.m.p */
public class C0705p {
    public static String f1723a;
    private String f1724b;
    private Map<String, Object> f1725c;
    private int f1726d;
    private String f1727e;

    /* renamed from: com.facebook.ads.internal.m.p.a */
    public enum C0703a {
        OPEN_STORE(0),
        OPEN_LINK(1),
        XOUT(2),
        OPEN_URL(3),
        SHOW_INTERSTITIAL(4);
        
        int f1719f;

        private C0703a(int i) {
            this.f1719f = i;
        }
    }

    /* renamed from: com.facebook.ads.internal.m.p.b */
    public enum C0704b {
        LOADING_AD(0);
        
        int f1722b;

        private C0704b(int i) {
            this.f1722b = i;
        }
    }

    static {
        f1723a = null;
    }

    public C0705p(String str, Map<String, Object> map, int i, String str2) {
        this.f1724b = str;
        this.f1725c = map;
        this.f1726d = i;
        this.f1727e = str2;
    }

    public static C0705p m2274a(long j, C0703a c0703a, String str) {
        long currentTimeMillis = System.currentTimeMillis();
        Map hashMap = new HashMap();
        hashMap.put("Time", String.valueOf(currentTimeMillis - j));
        hashMap.put("AdAction", String.valueOf(c0703a.f1719f));
        return new C0705p("bounceback", hashMap, (int) (currentTimeMillis / 1000), str);
    }

    public static C0705p m2275a(C0704b c0704b, C0656a c0656a, long j, String str) {
        Map hashMap = new HashMap();
        hashMap.put("LatencyType", String.valueOf(c0704b.f1722b));
        hashMap.put("AdPlacementType", c0656a.toString());
        hashMap.put("Time", String.valueOf(j));
        String str2 = "latency";
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        if (str == null) {
            str = f1723a;
        }
        return new C0705p(str2, hashMap, currentTimeMillis, str);
    }

    public static C0705p m2276a(@Nullable Throwable th, @Nullable String str) {
        Map hashMap = new HashMap();
        if (th != null) {
            hashMap.put("ex", th.getClass().getSimpleName());
            hashMap.put("ex_msg", th.getMessage());
        }
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        String str2 = "error";
        if (str == null) {
            str = f1723a;
        }
        return new C0705p(str2, hashMap, currentTimeMillis, str);
    }

    public JSONObject m2277a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", this.f1724b);
            jSONObject.put("data", new JSONObject(this.f1725c));
            jSONObject.put("time", this.f1726d);
            jSONObject.put("request_id", this.f1727e);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
