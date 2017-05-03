package com.google.android.exoplayer2.p051b;

/* renamed from: com.google.android.exoplayer2.b.a */
public abstract class Buffer {
    private int f2486a;

    public void m3073a() {
        this.f2486a = 0;
    }

    public final boolean b_() {
        return m3077d(RtlSpacingHelper.UNDEFINED);
    }

    public final boolean m3076c() {
        return m3077d(4);
    }

    public final void a_(int i) {
        this.f2486a = i;
    }

    public final void m3074b(int i) {
        this.f2486a |= i;
    }

    public final void m3075c(int i) {
        this.f2486a &= i ^ -1;
    }

    protected final boolean m3077d(int i) {
        return (this.f2486a & i) == i;
    }
}
