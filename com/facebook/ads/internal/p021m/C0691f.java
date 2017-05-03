package com.facebook.ads.internal.p021m;

import android.graphics.Bitmap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* renamed from: com.facebook.ads.internal.m.f */
public class C0691f {
    static final int f1665a;
    static final ExecutorService f1666b;
    private static volatile boolean f1667c;
    private final Bitmap f1668d;
    private Bitmap f1669e;
    private final C0670x f1670f;

    static {
        f1665a = Runtime.getRuntime().availableProcessors();
        f1666b = Executors.newFixedThreadPool(f1665a);
        f1667c = true;
    }

    public C0691f(Bitmap bitmap) {
        this.f1668d = bitmap;
        this.f1670f = new ai();
    }

    public Bitmap m2250a() {
        return this.f1669e;
    }

    public Bitmap m2251a(int i) {
        this.f1669e = this.f1670f.m2156a(this.f1668d, (float) i);
        return this.f1669e;
    }
}
