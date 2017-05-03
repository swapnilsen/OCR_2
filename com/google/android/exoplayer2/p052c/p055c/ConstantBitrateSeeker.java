package com.google.android.exoplayer2.p052c.p055c;

import com.google.android.exoplayer2.p052c.p055c.Mp3Extractor.Mp3Extractor;

/* renamed from: com.google.android.exoplayer2.c.c.a */
final class ConstantBitrateSeeker implements Mp3Extractor {
    private final long f2657a;
    private final int f2658b;
    private final long f2659c;

    public ConstantBitrateSeeker(long j, int i, long j2) {
        this.f2657a = j;
        this.f2658b = i;
        this.f2659c = j2 == -1 ? -9223372036854775807L : m3263a(j2);
    }

    public boolean m3264a() {
        return this.f2659c != -9223372036854775807L;
    }

    public long m3266b(long j) {
        return this.f2659c == -9223372036854775807L ? 0 : this.f2657a + ((((long) this.f2658b) * j) / 8000000);
    }

    public long m3263a(long j) {
        return ((Math.max(0, j - this.f2657a) * 1000000) * 8) / ((long) this.f2658b);
    }

    public long m3265b() {
        return this.f2659c;
    }
}
