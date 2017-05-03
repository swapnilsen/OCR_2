package com.facebook.ads.internal.p021m;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;

/* renamed from: com.facebook.ads.internal.m.q */
public class C0706q {
    private static final List<C0705p> f1728a;

    static {
        f1728a = new ArrayList();
    }

    public static String m2278a() {
        synchronized (f1728a) {
            if (f1728a.isEmpty()) {
                String str = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING;
                return str;
            }
            List<C0705p> arrayList = new ArrayList(f1728a);
            f1728a.clear();
            JSONArray jSONArray = new JSONArray();
            for (C0705p a : arrayList) {
                jSONArray.put(a.m2277a());
            }
            return jSONArray.toString();
        }
    }

    public static void m2279a(C0705p c0705p) {
        synchronized (f1728a) {
            f1728a.add(c0705p);
        }
    }
}
