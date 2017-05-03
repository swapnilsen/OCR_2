package com.facebook.ads.internal.p028c;

import com.google.api.client.http.ExponentialBackOffPolicy;
import java.io.Serializable;

/* renamed from: com.facebook.ads.internal.c.c */
public class C0525c implements Serializable {
    private C0524a f1142a;
    private C0524a f1143b;

    /* renamed from: com.facebook.ads.internal.c.c.a */
    public static class C0524a implements Serializable {
        private double f1131a;
        private double f1132b;
        private double f1133c;
        private double f1134d;
        private double f1135e;
        private double f1136f;
        private double f1137g;
        private int f1138h;
        private double f1139i;
        private double f1140j;
        private double f1141k;

        public C0524a(double d) {
            this.f1135e = d;
        }

        public void m1613a() {
            this.f1131a = 0.0d;
            this.f1133c = 0.0d;
            this.f1134d = 0.0d;
            this.f1136f = 0.0d;
            this.f1138h = 0;
            this.f1139i = 0.0d;
            this.f1140j = 1.0d;
            this.f1141k = 0.0d;
        }

        public void m1614a(double d, double d2) {
            this.f1138h++;
            this.f1139i += d;
            this.f1133c = d2;
            this.f1141k += d2 * d;
            this.f1131a = this.f1141k / this.f1139i;
            this.f1140j = Math.min(this.f1140j, d2);
            this.f1136f = Math.max(this.f1136f, d2);
            if (d2 >= this.f1135e) {
                this.f1134d += d;
                this.f1132b += d;
                this.f1137g = Math.max(this.f1137g, this.f1132b);
                return;
            }
            this.f1132b = 0.0d;
        }

        public double m1615b() {
            return this.f1138h == 0 ? 0.0d : this.f1140j;
        }

        public double m1616c() {
            return this.f1131a;
        }

        public double m1617d() {
            return this.f1136f;
        }

        public double m1618e() {
            return this.f1139i;
        }

        public double m1619f() {
            return this.f1134d;
        }

        public double m1620g() {
            return this.f1137g;
        }
    }

    public C0525c() {
        this(ExponentialBackOffPolicy.DEFAULT_RANDOMIZATION_FACTOR, 0.05d);
    }

    public C0525c(double d) {
        this(d, 0.05d);
    }

    public C0525c(double d, double d2) {
        this.f1142a = new C0524a(d);
        this.f1143b = new C0524a(d2);
        m1621a();
    }

    void m1621a() {
        this.f1142a.m1613a();
        this.f1143b.m1613a();
    }

    void m1622a(double d, double d2) {
        this.f1142a.m1614a(d, d2);
    }

    public C0524a m1623b() {
        return this.f1142a;
    }

    void m1624b(double d, double d2) {
        this.f1143b.m1614a(d, d2);
    }

    public C0524a m1625c() {
        return this.f1143b;
    }
}
