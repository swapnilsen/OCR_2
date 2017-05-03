package com.facebook.ads.internal.p021m;

import java.lang.ref.WeakReference;

/* renamed from: com.facebook.ads.internal.m.m */
public abstract class C0467m<T> implements Runnable {
    private final WeakReference<T> f846a;

    public C0467m(T t) {
        this.f846a = new WeakReference(t);
    }

    public T m1183a() {
        return this.f846a.get();
    }
}
