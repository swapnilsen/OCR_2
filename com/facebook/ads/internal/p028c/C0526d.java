package com.facebook.ads.internal.p028c;

import android.os.Bundle;

/* renamed from: com.facebook.ads.internal.c.d */
public class C0526d {
    private C0525c f1144a;
    private final C0525c f1145b;
    private final C0523b f1146c;
    private boolean f1147d;
    private boolean f1148e;
    private boolean f1149f;

    public C0526d(C0523b c0523b) {
        this.f1147d = false;
        this.f1148e = false;
        this.f1149f = false;
        this.f1146c = c0523b;
        this.f1145b = new C0525c(c0523b.f1127a);
        this.f1144a = new C0525c(c0523b.f1127a);
    }

    public C0526d(C0523b c0523b, Bundle bundle) {
        this.f1147d = false;
        this.f1148e = false;
        this.f1149f = false;
        this.f1146c = c0523b;
        this.f1145b = (C0525c) bundle.getSerializable("testStats");
        this.f1144a = (C0525c) bundle.getSerializable("viewableStats");
        this.f1147d = bundle.getBoolean("ended");
        this.f1148e = bundle.getBoolean("passed");
        this.f1149f = bundle.getBoolean("complete");
    }

    private void m1626a() {
        this.f1148e = true;
        m1627b();
    }

    private void m1627b() {
        this.f1149f = true;
        m1628c();
    }

    private void m1628c() {
        this.f1147d = true;
        this.f1146c.m1612a(this.f1149f, this.f1148e, this.f1148e ? this.f1144a : this.f1145b);
    }

    public void m1629a(double d, double d2) {
        if (!this.f1147d) {
            this.f1145b.m1622a(d, d2);
            this.f1144a.m1622a(d, d2);
            double f = this.f1144a.m1623b().m1619f();
            if (this.f1146c.f1130d && d2 < this.f1146c.f1127a) {
                this.f1144a = new C0525c(this.f1146c.f1127a);
            }
            if (this.f1146c.f1128b >= 0.0d && this.f1145b.m1623b().m1618e() > this.f1146c.f1128b && f == 0.0d) {
                m1627b();
            } else if (f >= this.f1146c.f1129c) {
                m1626a();
            }
        }
    }
}
