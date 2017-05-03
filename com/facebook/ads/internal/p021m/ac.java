package com.facebook.ads.internal.p021m;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.PowerManager;
import android.util.Log;
import java.io.File;

/* renamed from: com.facebook.ads.internal.m.ac */
public class ac {
    private static final String f1573a;

    /* renamed from: com.facebook.ads.internal.m.ac.a */
    public enum C0668a {
        UNKNOWN(0),
        UNROOTED(1),
        ROOTED(2);
        
        public final int f1572d;

        private C0668a(int i) {
            this.f1572d = i;
        }
    }

    static {
        f1573a = ac.class.getSimpleName();
    }

    public static C0668a m2137a() {
        try {
            Object obj = (ac.m2142c() || ac.m2140b() || ac.m2139a("su")) ? 1 : null;
            return obj != null ? C0668a.ROOTED : C0668a.UNROOTED;
        } catch (Throwable th) {
            return C0668a.UNKNOWN;
        }
    }

    public static boolean m2138a(Context context) {
        return ac.m2141b(context) && C0701n.m2272c(context);
    }

    private static boolean m2139a(String str) {
        for (String file : System.getenv("PATH").split(":")) {
            File file2 = new File(file);
            if (file2.exists() && file2.isDirectory()) {
                File[] listFiles = file2.listFiles();
                if (listFiles != null) {
                    for (File name : listFiles) {
                        if (name.getName().equals(str)) {
                            return true;
                        }
                    }
                    continue;
                } else {
                    continue;
                }
            }
        }
        return false;
    }

    private static boolean m2140b() {
        String str = Build.TAGS;
        return str != null && str.contains("test-keys");
    }

    public static boolean m2141b(Context context) {
        if (context == null) {
            Log.v(f1573a, "Invalid context in screen interactive check, assuming interactive.");
            return true;
        }
        try {
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            return VERSION.SDK_INT >= 20 ? powerManager.isInteractive() : powerManager.isScreenOn();
        } catch (Exception e) {
            Log.e(f1573a, "Exception in screen interactive check, assuming interactive.", e);
            ab.m2132a(e, context);
            return true;
        }
    }

    private static boolean m2142c() {
        return new File("/system/app/Superuser.apk").exists();
    }
}
