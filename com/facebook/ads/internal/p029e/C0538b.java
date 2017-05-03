package com.facebook.ads.internal.p029e;

import android.content.Context;
import android.os.Process;
import android.support.annotation.Nullable;
import com.facebook.ads.internal.p021m.C0692g;
import com.facebook.ads.internal.p021m.aa;
import com.facebook.ads.internal.p021m.ab;
import com.facebook.ads.internal.p025h.C0589p;
import com.facebook.ads.internal.p031g.C0562g;
import com.facebook.ads.internal.p031g.C0564i;
import java.lang.Thread.UncaughtExceptionHandler;

/* renamed from: com.facebook.ads.internal.e.b */
public class C0538b implements UncaughtExceptionHandler {
    private final UncaughtExceptionHandler f1178a;
    private final Context f1179b;

    public C0538b(@Nullable UncaughtExceptionHandler uncaughtExceptionHandler, Context context) {
        this.f1178a = uncaughtExceptionHandler;
        if (context == null) {
            throw new IllegalArgumentException("Missing Context");
        }
        this.f1179b = context.getApplicationContext();
    }

    private void m1664a(Thread thread, Throwable th) {
        if (this.f1178a != null) {
            this.f1178a.uncaughtException(thread, th);
            return;
        }
        try {
            Process.killProcess(Process.myPid());
        } catch (Throwable th2) {
        }
        try {
            System.exit(10);
        } catch (Throwable th3) {
        }
    }

    public void uncaughtException(Thread thread, Throwable th) {
        String a = C0692g.m2252a(th);
        if (a != null && a.contains("com.facebook.ads")) {
            ab.m2135a(new C0589p(C0562g.m1744b(), C0562g.m1745c(), new aa(a, C0564i.f1304f)), this.f1179b);
        }
        m1664a(thread, th);
    }
}
