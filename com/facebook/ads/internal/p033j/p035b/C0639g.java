package com.facebook.ads.internal.p033j.p035b;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.facebook.ads.internal.p033j.p035b.p036a.C0617b;
import java.io.File;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.facebook.ads.internal.j.b.g */
final class C0639g {
    private final AtomicInteger f1469a;
    private final String f1470b;
    private volatile C0630e f1471c;
    private final List<C0626b> f1472d;
    private final C0626b f1473e;
    private final C0627c f1474f;

    /* renamed from: com.facebook.ads.internal.j.b.g.a */
    private static final class C0638a extends Handler implements C0626b {
        private final String f1467a;
        private final List<C0626b> f1468b;

        public C0638a(String str, List<C0626b> list) {
            super(Looper.getMainLooper());
            this.f1467a = str;
            this.f1468b = list;
        }

        public void m2019a(File file, String str, int i) {
            Message obtainMessage = obtainMessage();
            obtainMessage.arg1 = i;
            obtainMessage.obj = file;
            sendMessage(obtainMessage);
        }

        public void handleMessage(Message message) {
            for (C0626b a : this.f1468b) {
                a.m1967a((File) message.obj, this.f1467a, message.arg1);
            }
        }
    }

    public C0639g(String str, C0627c c0627c) {
        this.f1469a = new AtomicInteger(0);
        this.f1472d = new CopyOnWriteArrayList();
        this.f1470b = (String) C0644j.m2038a(str);
        this.f1474f = (C0627c) C0644j.m2038a(c0627c);
        this.f1473e = new C0638a(str, this.f1472d);
    }

    private synchronized void m2020c() {
        this.f1471c = this.f1471c == null ? m2022e() : this.f1471c;
    }

    private synchronized void m2021d() {
        if (this.f1469a.decrementAndGet() <= 0) {
            this.f1471c.m1982a();
            this.f1471c = null;
        }
    }

    private C0630e m2022e() {
        C0630e c0630e = new C0630e(new C0641h(this.f1470b), new C0617b(this.f1474f.m1968a(this.f1470b), this.f1474f.f1432c));
        c0630e.m1991a(this.f1473e);
        return c0630e;
    }

    public void m2023a() {
        this.f1472d.clear();
        if (this.f1471c != null) {
            this.f1471c.m1991a(null);
            this.f1471c.m1982a();
            this.f1471c = null;
        }
        this.f1469a.set(0);
    }

    public void m2024a(C0628d c0628d, Socket socket) {
        m2020c();
        try {
            this.f1469a.incrementAndGet();
            this.f1471c.m1992a(c0628d, socket);
        } finally {
            m2021d();
        }
    }

    public int m2025b() {
        return this.f1469a.get();
    }
}
