package com.facebook.ads.internal.p024b;

import com.facebook.ads.internal.p021m.C0694i;
import com.facebook.ads.internal.p027l.C0656a;
import com.google.android.gms.plus.model.people.Person.Urls.Type;
import com.google.firebase.messaging.SendException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import net.nend.android.NendIconError;

/* renamed from: com.facebook.ads.internal.b.j */
public class C0484j {
    private static final Set<C0486l> f887a;
    private static final Map<C0656a, String> f888b;

    /* renamed from: com.facebook.ads.internal.b.j.1 */
    static /* synthetic */ class C04831 {
        static final /* synthetic */ int[] f886a;

        static {
            f886a = new int[C0656a.values().length];
            try {
                f886a[C0656a.BANNER.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f886a[C0656a.INTERSTITIAL.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f886a[C0656a.NATIVE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f886a[C0656a.INSTREAM.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f886a[C0656a.REWARDED_VIDEO.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    static {
        f887a = new HashSet();
        f888b = new ConcurrentHashMap();
        for (C0486l c0486l : C0486l.m1300a()) {
            Class cls;
            switch (C04831.f886a[c0486l.f908l.ordinal()]) {
                case NendIconError.ERROR_ICONVIEW /*1*/:
                    cls = C0473b.class;
                    break;
                case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                    cls = C0474d.class;
                    break;
                case SendException.ERROR_TTL_EXCEEDED /*3*/:
                    cls = ab.class;
                    break;
                case SendException.ERROR_TOO_MANY_MESSAGES /*4*/:
                    cls = C0497x.class;
                    break;
                case Type.OTHER_PROFILE /*5*/:
                    cls = ad.class;
                    break;
                default:
                    cls = null;
                    break;
            }
            if (cls != null) {
                Class cls2 = c0486l.f905i;
                if (cls2 == null) {
                    try {
                        cls2 = Class.forName(c0486l.f906j);
                    } catch (ClassNotFoundException e) {
                    }
                }
                if (cls2 != null && cls.isAssignableFrom(cls2)) {
                    f887a.add(c0486l);
                }
            }
        }
    }

    public static C0471a m1295a(C0485k c0485k, C0656a c0656a) {
        try {
            C0486l b = C0484j.m1298b(c0485k, c0656a);
            if (b != null && f887a.contains(b)) {
                Class cls = b.f905i;
                if (cls == null) {
                    cls = Class.forName(b.f906j);
                }
                return (C0471a) cls.newInstance();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static C0471a m1296a(String str, C0656a c0656a) {
        return C0484j.m1295a(C0485k.m1299a(str), c0656a);
    }

    public static String m1297a(C0656a c0656a) {
        if (f888b.containsKey(c0656a)) {
            return (String) f888b.get(c0656a);
        }
        Set hashSet = new HashSet();
        for (C0486l c0486l : f887a) {
            if (c0486l.f908l == c0656a) {
                hashSet.add(c0486l.f907k.toString());
            }
        }
        String a = C0694i.m2260a(hashSet, ",");
        f888b.put(c0656a, a);
        return a;
    }

    private static C0486l m1298b(C0485k c0485k, C0656a c0656a) {
        for (C0486l c0486l : f887a) {
            if (c0486l.f907k == c0485k && c0486l.f908l == c0656a) {
                return c0486l;
            }
        }
        return null;
    }
}
