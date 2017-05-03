package com.facebook.ads.internal.p031g;

import java.util.UUID;

/* renamed from: com.facebook.ads.internal.g.g */
public class C0562g {
    private static final String f1291a;
    private static volatile boolean f1292b;
    private static double f1293c;
    private static String f1294d;

    static {
        f1291a = C0562g.class.getSimpleName();
        f1292b = false;
    }

    public static void m1743a() {
        if (!f1292b) {
            synchronized (f1291a) {
                if (!f1292b) {
                    f1292b = true;
                    f1293c = ((double) System.currentTimeMillis()) / 1000.0d;
                    f1294d = UUID.randomUUID().toString();
                }
            }
        }
    }

    public static double m1744b() {
        return f1293c;
    }

    public static String m1745c() {
        return f1294d;
    }
}
