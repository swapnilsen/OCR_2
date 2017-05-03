package com.facebook.ads.internal.p026d;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/* renamed from: com.facebook.ads.internal.d.b */
public class C0532b {
    private static final String f1158a;
    private final Handler f1159b;
    private final ExecutorService f1160c;
    private final C0533c f1161d;
    private final C0535d f1162e;
    private final List<Callable<Boolean>> f1163f;

    /* renamed from: com.facebook.ads.internal.d.b.1 */
    class C05291 implements Runnable {
        final /* synthetic */ ArrayList f1151a;
        final /* synthetic */ C0509a f1152b;
        final /* synthetic */ C0532b f1153c;

        /* renamed from: com.facebook.ads.internal.d.b.1.1 */
        class C05281 implements Runnable {
            final /* synthetic */ C05291 f1150a;

            C05281(C05291 c05291) {
                this.f1150a = c05291;
            }

            public void run() {
                this.f1150a.f1152b.m1448a();
            }
        }

        C05291(C0532b c0532b, ArrayList arrayList, C0509a c0509a) {
            this.f1153c = c0532b;
            this.f1151a = arrayList;
            this.f1152b = c0509a;
        }

        public void run() {
            Throwable e;
            List<Future> arrayList = new ArrayList(this.f1151a.size());
            Iterator it = this.f1151a.iterator();
            while (it.hasNext()) {
                arrayList.add(this.f1153c.f1160c.submit((Callable) it.next()));
            }
            try {
                for (Future future : arrayList) {
                    future.get();
                }
            } catch (InterruptedException e2) {
                e = e2;
                Log.e(C0532b.f1158a, "Exception while executing cache downloads.", e);
                this.f1153c.f1159b.post(new C05281(this));
            } catch (ExecutionException e3) {
                e = e3;
                Log.e(C0532b.f1158a, "Exception while executing cache downloads.", e);
                this.f1153c.f1159b.post(new C05281(this));
            }
            this.f1153c.f1159b.post(new C05281(this));
        }
    }

    /* renamed from: com.facebook.ads.internal.d.b.a */
    private class C0530a implements Callable<Boolean> {
        final /* synthetic */ C0532b f1154a;
        private final String f1155b;

        public C0530a(C0532b c0532b, String str) {
            this.f1154a = c0532b;
            this.f1155b = str;
        }

        public Boolean m1638a() {
            this.f1154a.f1161d.m1653a(this.f1155b);
            return Boolean.valueOf(true);
        }

        public /* synthetic */ Object call() {
            return m1638a();
        }
    }

    /* renamed from: com.facebook.ads.internal.d.b.b */
    private class C0531b implements Callable<Boolean> {
        final /* synthetic */ C0532b f1156a;
        private final String f1157b;

        public C0531b(C0532b c0532b, String str) {
            this.f1156a = c0532b;
            this.f1157b = str;
        }

        public Boolean m1639a() {
            this.f1156a.f1162e.m1658a(this.f1157b);
            return Boolean.valueOf(true);
        }

        public /* synthetic */ Object call() {
            return m1639a();
        }
    }

    static {
        f1158a = C0532b.class.getSimpleName();
    }

    public C0532b(Context context) {
        this.f1159b = new Handler();
        this.f1160c = Executors.newFixedThreadPool(10);
        this.f1161d = C0533c.m1649a(context);
        this.f1162e = C0535d.m1656a(context);
        this.f1163f = new ArrayList();
    }

    public void m1645a(C0509a c0509a) {
        this.f1160c.submit(new C05291(this, new ArrayList(this.f1163f), c0509a));
        this.f1163f.clear();
    }

    public void m1646a(String str) {
        this.f1163f.add(new C0530a(this, str));
    }

    public void m1647b(String str) {
        this.f1163f.add(new C0531b(this, str));
    }

    public String m1648c(String str) {
        return this.f1162e.m1659b(str);
    }
}
