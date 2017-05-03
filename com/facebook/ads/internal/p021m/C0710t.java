package com.facebook.ads.internal.p021m;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.text.TextUtils;
import com.facebook.ads.internal.p025h.C0580g;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;

/* renamed from: com.facebook.ads.internal.m.t */
public class C0710t {

    /* renamed from: com.facebook.ads.internal.m.t.a */
    public interface C0507a {
        String m1398C();

        C0709s m1399D();

        String m1400E();

        Collection<String> m1401F();
    }

    public static Collection<String> m2288a(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() == 0) {
            return null;
        }
        Set hashSet = new HashSet();
        for (int i = 0; i < jSONArray.length(); i++) {
            hashSet.add(jSONArray.optString(i));
        }
        return hashSet;
    }

    public static boolean m2289a(Context context, C0507a c0507a) {
        C0709s D = c0507a.m1399D();
        if (D == null || D == C0709s.NONE) {
            return false;
        }
        Collection<String> F = c0507a.m1401F();
        if (F == null || F.isEmpty()) {
            return false;
        }
        for (String a : F) {
            if (C0710t.m2290a(context, a)) {
                int i = 1;
                break;
            }
        }
        boolean z = false;
        if (D == C0709s.INSTALLED) {
            int i2 = 1;
        } else {
            boolean z2 = false;
        }
        if (i != i2) {
            return false;
        }
        CharSequence E = c0507a.m1400E();
        Object C = c0507a.m1398C();
        if (!TextUtils.isEmpty(C)) {
            C0580g.m1799a(context).m1817g(C, null);
            return true;
        } else if (TextUtils.isEmpty(E)) {
            return true;
        } else {
            new al().execute(new String[]{E});
            return false;
        }
    }

    public static boolean m2290a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            context.getPackageManager().getPackageInfo(str, 1);
            return true;
        } catch (NameNotFoundException e) {
            return false;
        } catch (RuntimeException e2) {
            return false;
        }
    }
}
