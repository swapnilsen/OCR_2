package com.facebook.ads.internal.p021m;

import com.facebook.ads.internal.p031g.C0556c;
import com.facebook.ads.internal.p031g.C0561f;
import com.google.firebase.messaging.SendException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import net.nend.android.NendIconError;

/* renamed from: com.facebook.ads.internal.m.r */
public class C0708r {
    private static Map<String, Long> f1730a;
    private static Map<String, Long> f1731b;
    private static Map<String, String> f1732c;

    /* renamed from: com.facebook.ads.internal.m.r.1 */
    static /* synthetic */ class C07071 {
        static final /* synthetic */ int[] f1729a;

        static {
            f1729a = new int[C0556c.values().length];
            try {
                f1729a[C0556c.BANNER.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f1729a[C0556c.INTERSTITIAL.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f1729a[C0556c.NATIVE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f1729a[C0556c.UNKNOWN.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    static {
        f1730a = new ConcurrentHashMap();
        f1731b = new ConcurrentHashMap();
        f1732c = new ConcurrentHashMap();
    }

    private static long m2280a(String str, C0556c c0556c) {
        if (f1730a.containsKey(str)) {
            return ((Long) f1730a.get(str)).longValue();
        }
        switch (C07071.f1729a[c0556c.ordinal()]) {
            case NendIconError.ERROR_ICONVIEW /*1*/:
                return 15000;
            case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
            case SendException.ERROR_TTL_EXCEEDED /*3*/:
                return -1000;
            default:
                return -1000;
        }
    }

    public static void m2281a(long j, C0561f c0561f) {
        f1730a.put(C0708r.m2286d(c0561f), Long.valueOf(j));
    }

    public static void m2282a(String str, C0561f c0561f) {
        f1732c.put(C0708r.m2286d(c0561f), str);
    }

    public static boolean m2283a(C0561f c0561f) {
        String d = C0708r.m2286d(c0561f);
        if (!f1731b.containsKey(d)) {
            return false;
        }
        return System.currentTimeMillis() - ((Long) f1731b.get(d)).longValue() < C0708r.m2280a(d, c0561f.m1739b());
    }

    public static void m2284b(C0561f c0561f) {
        f1731b.put(C0708r.m2286d(c0561f), Long.valueOf(System.currentTimeMillis()));
    }

    public static String m2285c(C0561f c0561f) {
        return (String) f1732c.get(C0708r.m2286d(c0561f));
    }

    private static String m2286d(C0561f c0561f) {
        int i = 0;
        String str = "%s:%s:%s:%d:%d:%d";
        Object[] objArr = new Object[6];
        objArr[0] = c0561f.m1738a();
        objArr[1] = c0561f.m1739b();
        objArr[2] = c0561f.f1286e;
        objArr[3] = Integer.valueOf(c0561f.m1740c() == null ? 0 : c0561f.m1740c().m1061b());
        if (c0561f.m1740c() != null) {
            i = c0561f.m1740c().m1060a();
        }
        objArr[4] = Integer.valueOf(i);
        objArr[5] = Integer.valueOf(c0561f.m1741d());
        return String.format(str, objArr);
    }
}
