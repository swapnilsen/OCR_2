package com.facebook.ads.internal.p033j.p035b.p036a;

import java.io.File;

/* renamed from: com.facebook.ads.internal.j.b.a.g */
public class C0625g extends C0623e {
    private final long f1429a;

    public C0625g(long j) {
        if (j <= 0) {
            throw new IllegalArgumentException("Max size must be positive number!");
        }
        this.f1429a = j;
    }

    public /* bridge */ /* synthetic */ void m1965a(File file) {
        super.m1961a(file);
    }

    protected boolean m1966a(File file, long j, int i) {
        return j <= this.f1429a;
    }
}
