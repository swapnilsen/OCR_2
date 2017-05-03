package com.google.android.exoplayer2.p050j;

import java.util.Arrays;

/* renamed from: com.google.android.exoplayer2.j.f */
public final class LongArray {
    private int f3808a;
    private long[] f3809b;

    public LongArray() {
        this(32);
    }

    public LongArray(int i) {
        this.f3809b = new long[i];
    }

    public void m4423a(long j) {
        if (this.f3808a == this.f3809b.length) {
            this.f3809b = Arrays.copyOf(this.f3809b, this.f3808a * 2);
        }
        long[] jArr = this.f3809b;
        int i = this.f3808a;
        this.f3808a = i + 1;
        jArr[i] = j;
    }

    public long m4422a(int i) {
        if (i >= 0 && i < this.f3808a) {
            return this.f3809b[i];
        }
        throw new IndexOutOfBoundsException("Invalid index " + i + ", size is " + this.f3808a);
    }

    public int m4421a() {
        return this.f3808a;
    }

    public long[] m4424b() {
        return Arrays.copyOf(this.f3809b, this.f3808a);
    }
}
