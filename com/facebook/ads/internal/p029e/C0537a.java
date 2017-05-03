package com.facebook.ads.internal.p029e;

import android.content.Context;
import android.util.Log;
import com.facebook.ads.internal.C0649j;

/* renamed from: com.facebook.ads.internal.e.a */
public class C0537a {
    private static final String f1174a;
    private static C0537a f1175b;
    private static boolean f1176c;
    private Context f1177d;

    static {
        f1174a = C0537a.class.getName();
        f1176c = false;
    }

    private C0537a(Context context) {
        this.f1177d = context;
    }

    public static C0537a m1662a(Context context) {
        if (f1175b == null) {
            Context applicationContext = context.getApplicationContext();
            synchronized (applicationContext) {
                if (f1175b == null) {
                    f1175b = new C0537a(applicationContext);
                }
            }
        }
        return f1175b;
    }

    public synchronized void m1663a() {
        if (!f1176c) {
            if (C0649j.m2054d(this.f1177d)) {
                try {
                    Thread.setDefaultUncaughtExceptionHandler(new C0538b(Thread.getDefaultUncaughtExceptionHandler(), this.f1177d));
                } catch (Throwable e) {
                    Log.e(f1174a, "No permissions to set the default uncaught exception handler", e);
                }
            }
            f1176c = true;
        }
    }
}
