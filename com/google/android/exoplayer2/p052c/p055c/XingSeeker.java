package com.google.android.exoplayer2.p052c.p055c;

import com.google.android.exoplayer2.p050j.ParsableByteArray;
import com.google.android.exoplayer2.p050j.Util;
import com.google.android.exoplayer2.p052c.MpegAudioHeader;
import com.google.android.exoplayer2.p052c.p055c.Mp3Extractor.Mp3Extractor;

/* renamed from: com.google.android.exoplayer2.c.c.e */
final class XingSeeker implements Mp3Extractor {
    private final long f2680a;
    private final long f2681b;
    private final long f2682c;
    private final long[] f2683d;
    private final long f2684e;
    private final int f2685f;

    public static XingSeeker m3290a(MpegAudioHeader mpegAudioHeader, ParsableByteArray parsableByteArray, long j, long j2) {
        int i = mpegAudioHeader.f3265g;
        int i2 = mpegAudioHeader.f3262d;
        long j3 = j + ((long) mpegAudioHeader.f3261c);
        int n = parsableByteArray.m4468n();
        if ((n & 1) == 1) {
            int t = parsableByteArray.m4474t();
            if (t != 0) {
                long a = Util.m4510a((long) t, ((long) i) * 1000000, (long) i2);
                if ((n & 6) != 6) {
                    return new XingSeeker(j3, a, j2);
                }
                long t2 = (long) parsableByteArray.m4474t();
                parsableByteArray.m4457d(1);
                long[] jArr = new long[99];
                for (t = 0; t < 99; t++) {
                    jArr[t] = (long) parsableByteArray.m4461g();
                }
                return new XingSeeker(j3, a, j2, jArr, t2, mpegAudioHeader.f3261c);
            }
        }
        return null;
    }

    private XingSeeker(long j, long j2, long j3) {
        this(j, j2, j3, null, 0, 0);
    }

    private XingSeeker(long j, long j2, long j3, long[] jArr, long j4, int i) {
        this.f2680a = j;
        this.f2681b = j2;
        this.f2682c = j3;
        this.f2683d = jArr;
        this.f2684e = j4;
        this.f2685f = i;
    }

    public boolean m3292a() {
        return this.f2683d != null;
    }

    public long m3294b(long j) {
        float f = 256.0f;
        float f2 = 0.0f;
        if (!m3292a()) {
            return this.f2680a;
        }
        float f3 = (((float) j) * 100.0f) / ((float) this.f2681b);
        if (f3 <= 0.0f) {
            f = 0.0f;
        } else if (f3 < 100.0f) {
            int i = (int) f3;
            if (i != 0) {
                f2 = (float) this.f2683d[i - 1];
            }
            if (i < 99) {
                f = (float) this.f2683d[i];
            }
            f = ((f - f2) * (f3 - ((float) i))) + f2;
        }
        return Math.min(this.f2680a + Math.round((((double) f) * 0.00390625d) * ((double) this.f2684e)), this.f2682c != -1 ? this.f2682c - 1 : ((this.f2680a - ((long) this.f2685f)) + this.f2684e) - 1);
    }

    public long m3291a(long j) {
        if (!m3292a() || j < this.f2680a) {
            return 0;
        }
        double d = (256.0d * ((double) (j - this.f2680a))) / ((double) this.f2684e);
        int a = Util.m4509a(this.f2683d, (long) d, true, false) + 1;
        long a2 = m3289a(a);
        long j2 = a == 0 ? 0 : this.f2683d[a - 1];
        long j3 = a == 99 ? 256 : this.f2683d[a];
        return a2 + (j3 == j2 ? 0 : (long) ((((double) (m3289a(a + 1) - a2)) * (d - ((double) j2))) / ((double) (j3 - j2))));
    }

    public long m3293b() {
        return this.f2681b;
    }

    private long m3289a(int i) {
        return (this.f2681b * ((long) i)) / 100;
    }
}
