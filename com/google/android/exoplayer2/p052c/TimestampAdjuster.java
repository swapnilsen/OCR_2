package com.google.android.exoplayer2.p052c;

/* renamed from: com.google.android.exoplayer2.c.n */
public final class TimestampAdjuster {
    private final long f3268a;
    private long f3269b;
    private volatile long f3270c;

    public TimestampAdjuster(long j) {
        this.f3268a = j;
        this.f3270c = -9223372036854775807L;
    }

    public void m3740a() {
        this.f3270c = -9223372036854775807L;
    }

    public long m3739a(long j) {
        long j2;
        if (this.f3270c != -9223372036854775807L) {
            long d = TimestampAdjuster.m3738d(this.f3270c);
            long j3 = (4294967296L + d) / 8589934592L;
            j2 = ((j3 - 1) * 8589934592L) + j;
            j3 = (j3 * 8589934592L) + j;
            if (Math.abs(j2 - d) >= Math.abs(j3 - d)) {
                j2 = j3;
            }
        } else {
            j2 = j;
        }
        return m3741b(TimestampAdjuster.m3737c(j2));
    }

    public long m3741b(long j) {
        if (this.f3270c != -9223372036854775807L) {
            this.f3270c = j;
        } else {
            if (this.f3268a != Long.MAX_VALUE) {
                this.f3269b = this.f3268a - j;
            }
            synchronized (this) {
                this.f3270c = j;
                notifyAll();
            }
        }
        return this.f3269b + j;
    }

    public static long m3737c(long j) {
        return (1000000 * j) / 90000;
    }

    public static long m3738d(long j) {
        return (90000 * j) / 1000000;
    }
}
