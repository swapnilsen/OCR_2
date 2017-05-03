package com.facebook.ads.internal.p033j.p035b;

import android.util.Log;
import java.lang.Thread.State;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.facebook.ads.internal.j.b.k */
class C0629k {
    private final C0640n f1438a;
    private final C0616a f1439b;
    private final Object f1440c;
    private final Object f1441d;
    private final AtomicInteger f1442e;
    private volatile Thread f1443f;
    private volatile boolean f1444g;
    private volatile int f1445h;

    /* renamed from: com.facebook.ads.internal.j.b.k.a */
    private class C0646a implements Runnable {
        final /* synthetic */ C0629k f1480a;

        private C0646a(C0629k c0629k) {
            this.f1480a = c0629k;
        }

        public void run() {
            this.f1480a.m1977e();
        }
    }

    public C0629k(C0640n c0640n, C0616a c0616a) {
        this.f1440c = new Object();
        this.f1441d = new Object();
        this.f1445h = -1;
        this.f1438a = (C0640n) C0644j.m2038a(c0640n);
        this.f1439b = (C0616a) C0644j.m2038a(c0616a);
        this.f1442e = new AtomicInteger();
    }

    private void m1973b() {
        int i = this.f1442e.get();
        if (i >= 1) {
            this.f1442e.set(0);
            throw new C0642l("Error reading source " + i + " times");
        }
    }

    private void m1974b(long j, long j2) {
        m1984a(j, j2);
        synchronized (this.f1440c) {
            this.f1440c.notifyAll();
        }
    }

    private synchronized void m1975c() {
        Object obj = (this.f1443f == null || this.f1443f.getState() == State.TERMINATED) ? null : 1;
        if (!(this.f1444g || this.f1439b.m1940d() || obj != null)) {
            this.f1443f = new Thread(new C0646a(), "Source reader for " + this.f1438a);
            this.f1443f.start();
        }
    }

    private void m1976d() {
        synchronized (this.f1440c) {
            try {
                this.f1440c.wait(1000);
            } catch (Throwable e) {
                throw new C0642l("Waiting source data is interrupted!", e);
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m1977e() {
        /*
        r8 = this;
        r3 = -1;
        r1 = 0;
        r0 = r8.f1439b;	 Catch:{ Throwable -> 0x006d, all -> 0x006a }
        r1 = r0.m1935a();	 Catch:{ Throwable -> 0x006d, all -> 0x006a }
        r0 = r8.f1438a;	 Catch:{ Throwable -> 0x006d, all -> 0x006a }
        r0.m2028a(r1);	 Catch:{ Throwable -> 0x006d, all -> 0x006a }
        r0 = r8.f1438a;	 Catch:{ Throwable -> 0x006d, all -> 0x006a }
        r2 = r0.m2026a();	 Catch:{ Throwable -> 0x006d, all -> 0x006a }
        r0 = 8192; // 0x2000 float:1.14794E-41 double:4.0474E-320;
        r0 = new byte[r0];	 Catch:{ Throwable -> 0x003f }
    L_0x0017:
        r4 = r8.f1438a;	 Catch:{ Throwable -> 0x003f }
        r4 = r4.m2027a(r0);	 Catch:{ Throwable -> 0x003f }
        if (r4 == r3) goto L_0x005e;
    L_0x001f:
        r5 = r8.f1441d;	 Catch:{ Throwable -> 0x003f }
        monitor-enter(r5);	 Catch:{ Throwable -> 0x003f }
        r6 = r8.m1979g();	 Catch:{ all -> 0x0051 }
        if (r6 == 0) goto L_0x0032;
    L_0x0028:
        monitor-exit(r5);	 Catch:{ all -> 0x0051 }
        r8.m1980h();
        r0 = (long) r1;
        r2 = (long) r2;
        r8.m1974b(r0, r2);
    L_0x0031:
        return;
    L_0x0032:
        r6 = r8.f1439b;	 Catch:{ all -> 0x0051 }
        r6.m1937a(r0, r4);	 Catch:{ all -> 0x0051 }
        monitor-exit(r5);	 Catch:{ all -> 0x0051 }
        r1 = r1 + r4;
        r4 = (long) r1;
        r6 = (long) r2;
        r8.m1974b(r4, r6);	 Catch:{ Throwable -> 0x003f }
        goto L_0x0017;
    L_0x003f:
        r0 = move-exception;
    L_0x0040:
        r3 = r8.f1442e;	 Catch:{ all -> 0x0054 }
        r3.incrementAndGet();	 Catch:{ all -> 0x0054 }
        r8.m1985a(r0);	 Catch:{ all -> 0x0054 }
        r8.m1980h();
        r0 = (long) r1;
        r2 = (long) r2;
        r8.m1974b(r0, r2);
        goto L_0x0031;
    L_0x0051:
        r0 = move-exception;
        monitor-exit(r5);	 Catch:{ all -> 0x0051 }
        throw r0;	 Catch:{ Throwable -> 0x003f }
    L_0x0054:
        r0 = move-exception;
    L_0x0055:
        r8.m1980h();
        r4 = (long) r1;
        r2 = (long) r2;
        r8.m1974b(r4, r2);
        throw r0;
    L_0x005e:
        r8.m1978f();	 Catch:{ Throwable -> 0x003f }
        r8.m1980h();
        r0 = (long) r1;
        r2 = (long) r2;
        r8.m1974b(r0, r2);
        goto L_0x0031;
    L_0x006a:
        r0 = move-exception;
        r2 = r3;
        goto L_0x0055;
    L_0x006d:
        r0 = move-exception;
        r2 = r3;
        goto L_0x0040;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.j.b.k.e():void");
    }

    private void m1978f() {
        synchronized (this.f1441d) {
            if (!m1979g() && this.f1439b.m1935a() == this.f1438a.m2026a()) {
                this.f1439b.m1939c();
            }
        }
    }

    private boolean m1979g() {
        return Thread.currentThread().isInterrupted() || this.f1444g;
    }

    private void m1980h() {
        try {
            this.f1438a.m2029b();
        } catch (Throwable e) {
            m1985a(new C0642l("Error closing source " + this.f1438a, e));
        }
    }

    public int m1981a(byte[] bArr, long j, int i) {
        C0647m.m2044a(bArr, j, i);
        while (!this.f1439b.m1940d() && ((long) this.f1439b.m1935a()) < ((long) i) + j && !this.f1444g) {
            m1975c();
            m1976d();
            m1973b();
        }
        int a = this.f1439b.m1936a(bArr, j, i);
        if (this.f1439b.m1940d() && this.f1445h != 100) {
            this.f1445h = 100;
            m1983a(100);
        }
        return a;
    }

    public void m1982a() {
        synchronized (this.f1441d) {
            Log.d("ProxyCache", "Shutdown proxy for " + this.f1438a);
            try {
                this.f1444g = true;
                if (this.f1443f != null) {
                    this.f1443f.interrupt();
                }
                this.f1439b.m1938b();
            } catch (Throwable e) {
                m1985a(e);
            }
        }
    }

    protected void m1983a(int i) {
    }

    protected void m1984a(long j, long j2) {
        Object obj = 1;
        int i = ((j2 > 0 ? 1 : (j2 == 0 ? 0 : -1)) == 0 ? 1 : null) != null ? 100 : (int) ((100 * j) / j2);
        Object obj2 = i != this.f1445h ? 1 : null;
        if (j2 < 0) {
            obj = null;
        }
        if (!(obj == null || obj2 == null)) {
            m1983a(i);
        }
        this.f1445h = i;
    }

    protected final void m1985a(Throwable th) {
        if (th instanceof C0643i) {
            Log.d("ProxyCache", "ProxyCache is interrupted");
        } else {
            Log.e("ProxyCache", "ProxyCache error", th);
        }
    }
}
