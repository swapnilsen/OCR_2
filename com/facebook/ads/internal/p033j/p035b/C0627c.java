package com.facebook.ads.internal.p033j.p035b;

import com.facebook.ads.internal.p033j.p035b.p036a.C0615a;
import com.facebook.ads.internal.p033j.p035b.p036a.C0618c;
import java.io.File;

/* renamed from: com.facebook.ads.internal.j.b.c */
class C0627c {
    public final File f1430a;
    public final C0618c f1431b;
    public final C0615a f1432c;

    C0627c(File file, C0618c c0618c, C0615a c0615a) {
        this.f1430a = file;
        this.f1431b = c0618c;
        this.f1432c = c0615a;
    }

    File m1968a(String str) {
        return new File(this.f1430a, this.f1431b.m1948a(str));
    }
}
