package com.facebook.ads.internal.p026d;

import android.content.Context;
import android.support.annotation.Nullable;
import com.facebook.ads.internal.p033j.p035b.C0637f;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/* renamed from: com.facebook.ads.internal.d.d */
public class C0535d {
    private static final String f1169a;
    private static C0535d f1170b;
    private final Future<C0637f> f1171c;

    /* renamed from: com.facebook.ads.internal.d.d.1 */
    class C05341 implements Callable<C0637f> {
        final /* synthetic */ Context f1167a;
        final /* synthetic */ C0535d f1168b;

        C05341(C0535d c0535d, Context context) {
            this.f1168b = c0535d;
            this.f1167a = context;
        }

        public C0637f m1655a() {
            return new C0637f(this.f1167a);
        }

        public /* synthetic */ Object call() {
            return m1655a();
        }
    }

    static {
        f1169a = C0535d.class.getSimpleName();
    }

    private C0535d(Context context) {
        this.f1171c = Executors.newSingleThreadExecutor().submit(new C05341(this, context));
    }

    public static C0535d m1656a(Context context) {
        if (f1170b == null) {
            Context applicationContext = context.getApplicationContext();
            synchronized (applicationContext) {
                if (f1170b == null) {
                    f1170b = new C0535d(applicationContext);
                }
            }
        }
        return f1170b;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @android.support.annotation.Nullable
    private com.facebook.ads.internal.p033j.p035b.C0637f m1657a() {
        /*
        r4 = this;
        r0 = r4.f1171c;	 Catch:{ InterruptedException -> 0x000d, ExecutionException -> 0x0017, TimeoutException -> 0x0019 }
        r2 = 500; // 0x1f4 float:7.0E-43 double:2.47E-321;
        r1 = java.util.concurrent.TimeUnit.MILLISECONDS;	 Catch:{ InterruptedException -> 0x000d, ExecutionException -> 0x0017, TimeoutException -> 0x0019 }
        r0 = r0.get(r2, r1);	 Catch:{ InterruptedException -> 0x000d, ExecutionException -> 0x0017, TimeoutException -> 0x0019 }
        r0 = (com.facebook.ads.internal.p033j.p035b.C0637f) r0;	 Catch:{ InterruptedException -> 0x000d, ExecutionException -> 0x0017, TimeoutException -> 0x0019 }
    L_0x000c:
        return r0;
    L_0x000d:
        r0 = move-exception;
    L_0x000e:
        r1 = f1169a;
        r2 = "Timed out waiting for cache server.";
        android.util.Log.e(r1, r2, r0);
        r0 = 0;
        goto L_0x000c;
    L_0x0017:
        r0 = move-exception;
        goto L_0x000e;
    L_0x0019:
        r0 = move-exception;
        goto L_0x000e;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.d.d.a():com.facebook.ads.internal.j.b.f");
    }

    public void m1658a(String str) {
        C0637f a = m1657a();
        if (a != null) {
            a.m2017a(str);
        }
    }

    @Nullable
    public String m1659b(String str) {
        C0637f a = m1657a();
        return a == null ? null : a.m2018b(str);
    }
}
