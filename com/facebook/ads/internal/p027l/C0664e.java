package com.facebook.ads.internal.p027l;

import com.facebook.ads.internal.p031g.C0557d;

/* renamed from: com.facebook.ads.internal.l.e */
public class C0664e {
    private C0557d f1558a;
    private C0663a f1559b;

    /* renamed from: com.facebook.ads.internal.l.e.a */
    public enum C0663a {
        UNKNOWN,
        ERROR,
        ADS
    }

    public C0664e(C0663a c0663a, C0557d c0557d) {
        this.f1559b = c0663a;
        this.f1558a = c0557d;
    }

    public C0663a m2127a() {
        return this.f1559b;
    }

    public C0557d m2128b() {
        return this.f1558a;
    }
}
