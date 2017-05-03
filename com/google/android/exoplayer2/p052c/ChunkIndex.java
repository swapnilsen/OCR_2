package com.google.android.exoplayer2.p052c;

import com.google.android.exoplayer2.p050j.Util;

/* renamed from: com.google.android.exoplayer2.c.a */
public final class ChunkIndex implements SeekMap {
    public final int f2550a;
    public final int[] f2551b;
    public final long[] f2552c;
    public final long[] f2553d;
    public final long[] f2554e;
    private final long f2555f;

    public ChunkIndex(int[] iArr, long[] jArr, long[] jArr2, long[] jArr3) {
        this.f2551b = iArr;
        this.f2552c = jArr;
        this.f2553d = jArr2;
        this.f2554e = jArr3;
        this.f2550a = iArr.length;
        this.f2555f = jArr2[this.f2550a - 1] + jArr3[this.f2550a - 1];
    }

    public int m3158a(long j) {
        return Util.m4509a(this.f2554e, j, true, true);
    }

    public boolean m3159a() {
        return true;
    }

    public long m3160b() {
        return this.f2555f;
    }

    public long m3161b(long j) {
        return this.f2552c[m3158a(j)];
    }
}
