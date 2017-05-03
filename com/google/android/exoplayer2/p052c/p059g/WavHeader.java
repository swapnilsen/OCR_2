package com.google.android.exoplayer2.p052c.p059g;

/* renamed from: com.google.android.exoplayer2.c.g.b */
final class WavHeader {
    private final int f3239a;
    private final int f3240b;
    private final int f3241c;
    private final int f3242d;
    private final int f3243e;
    private final int f3244f;
    private long f3245g;
    private long f3246h;

    public WavHeader(int i, int i2, int i3, int i4, int i5, int i6) {
        this.f3239a = i;
        this.f3240b = i2;
        this.f3241c = i3;
        this.f3242d = i4;
        this.f3243e = i5;
        this.f3244f = i6;
    }

    public long m3712a() {
        return ((this.f3246h / ((long) this.f3242d)) * 1000000) / ((long) this.f3240b);
    }

    public int m3715b() {
        return this.f3242d;
    }

    public int m3717c() {
        return (this.f3240b * this.f3243e) * this.f3239a;
    }

    public int m3718d() {
        return this.f3240b;
    }

    public int m3719e() {
        return this.f3239a;
    }

    public long m3713a(long j) {
        return Math.min((((((long) this.f3241c) * j) / 1000000) / ((long) this.f3242d)) * ((long) this.f3242d), this.f3246h - ((long) this.f3242d)) + this.f3245g;
    }

    public long m3716b(long j) {
        return (1000000 * j) / ((long) this.f3241c);
    }

    public boolean m3720f() {
        return (this.f3245g == 0 || this.f3246h == 0) ? false : true;
    }

    public void m3714a(long j, long j2) {
        this.f3245g = j;
        this.f3246h = j2;
    }

    public int m3721g() {
        return this.f3244f;
    }
}
