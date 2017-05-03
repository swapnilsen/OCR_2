package com.facebook.ads.internal.p021m;

import java.util.Locale;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/* renamed from: com.facebook.ads.internal.m.c */
public class C0676c implements ThreadFactory {
    protected final AtomicLong f1625a;
    private int f1626b;

    public C0676c() {
        this.f1625a = new AtomicLong();
        this.f1626b = Thread.currentThread().getPriority();
    }

    protected String m2190a() {
        return String.format(Locale.ENGLISH, "com.facebook.ads thread-%d %tF %<tT", new Object[]{Long.valueOf(this.f1625a.incrementAndGet()), Long.valueOf(System.currentTimeMillis())});
    }

    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(null, runnable, m2190a(), 0);
        thread.setPriority(this.f1626b);
        return thread;
    }
}
