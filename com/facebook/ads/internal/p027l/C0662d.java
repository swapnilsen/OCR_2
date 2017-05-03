package com.facebook.ads.internal.p027l;

import android.text.TextUtils;
import com.facebook.ads.internal.p027l.C0664e.C0663a;
import com.facebook.ads.internal.p031g.C0553a;
import com.facebook.ads.internal.p031g.C0557d;
import com.facebook.ads.internal.p031g.C0558e;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import net.nend.android.NendAdIconLayout;
import net.nend.android.NendIconError;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.internal.l.d */
public class C0662d {
    private static C0662d f1553a;

    static {
        f1553a = new C0662d();
    }

    public static synchronized C0662d m2122a() {
        C0662d c0662d;
        synchronized (C0662d.class) {
            c0662d = f1553a;
        }
        return c0662d;
    }

    private C0665f m2123a(JSONObject jSONObject) {
        int i = 0;
        JSONObject jSONObject2 = jSONObject.getJSONArray("placements").getJSONObject(0);
        C0557d c0557d = new C0557d(C0558e.m1722a(jSONObject2.getJSONObject("definition")), jSONObject2.optString("feature_config"));
        if (jSONObject2.has("ads")) {
            JSONArray jSONArray = jSONObject2.getJSONArray("ads");
            while (i < jSONArray.length()) {
                JSONObject jSONObject3 = jSONArray.getJSONObject(i);
                c0557d.m1719a(new C0553a(jSONObject3.optString("adapter"), jSONObject3.optJSONObject("data"), jSONObject3.optJSONArray("trackers")));
                i++;
            }
        }
        return new C0665f(c0557d);
    }

    private C0666g m2124b(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = jSONObject.getJSONArray("placements").getJSONObject(0);
            return new C0666g(jSONObject.optString("message", FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING), jSONObject.optInt("code", 0), new C0557d(C0558e.m1722a(jSONObject2.getJSONObject("definition")), jSONObject2.optString("feature_config")));
        } catch (JSONException e) {
            return m2125c(jSONObject);
        }
    }

    private C0666g m2125c(JSONObject jSONObject) {
        return new C0666g(jSONObject.optString("message", FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING), jSONObject.optInt("code", 0), null);
    }

    public C0664e m2126a(String str) {
        if (!TextUtils.isEmpty(str)) {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("type");
            Object obj = -1;
            switch (optString.hashCode()) {
                case 96432:
                    if (optString.equals("ads")) {
                        obj = null;
                        break;
                    }
                    break;
                case 96784904:
                    if (optString.equals("error")) {
                        obj = 1;
                        break;
                    }
                    break;
            }
            switch (obj) {
                case NendAdIconLayout.HORIZONTAL /*0*/:
                    return m2123a(jSONObject);
                case NendIconError.ERROR_ICONVIEW /*1*/:
                    return m2124b(jSONObject);
                default:
                    JSONObject optJSONObject = jSONObject.optJSONObject("error");
                    if (optJSONObject != null) {
                        return m2125c(optJSONObject);
                    }
                    break;
            }
        }
        return new C0664e(C0663a.UNKNOWN, null);
    }
}
