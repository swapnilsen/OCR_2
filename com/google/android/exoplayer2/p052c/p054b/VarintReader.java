package com.google.android.exoplayer2.p052c.p054b;

import android.support.v4.view.MotionEventCompat;
import com.google.android.exoplayer2.p052c.ExtractorInput;

/* renamed from: com.google.android.exoplayer2.c.b.f */
final class VarintReader {
    private static final long[] f2646a;
    private final byte[] f2647b;
    private int f2648c;
    private int f2649d;

    static {
        f2646a = new long[]{128, 64, 32, 16, 8, 4, 2, 1};
    }

    public VarintReader() {
        this.f2647b = new byte[8];
    }

    public void m3228a() {
        this.f2648c = 0;
        this.f2649d = 0;
    }

    public long m3227a(ExtractorInput extractorInput, boolean z, boolean z2, int i) {
        if (this.f2648c == 0) {
            if (!extractorInput.m3233a(this.f2647b, 0, 1, z)) {
                return -1;
            }
            this.f2649d = VarintReader.m3225a(this.f2647b[0] & MotionEventCompat.ACTION_MASK);
            if (this.f2649d == -1) {
                throw new IllegalStateException("No valid varint length mask found");
            }
            this.f2648c = 1;
        }
        if (this.f2649d > i) {
            this.f2648c = 0;
            return -2;
        }
        if (this.f2649d != 1) {
            extractorInput.m3236b(this.f2647b, 1, this.f2649d - 1);
        }
        this.f2648c = 0;
        return VarintReader.m3226a(this.f2647b, this.f2649d, z2);
    }

    public int m3229b() {
        return this.f2649d;
    }

    public static int m3225a(int i) {
        for (int i2 = 0; i2 < f2646a.length; i2++) {
            if ((f2646a[i2] & ((long) i)) != 0) {
                return i2 + 1;
            }
        }
        return -1;
    }

    public static long m3226a(byte[] bArr, int i, boolean z) {
        long j = ((long) bArr[0]) & 255;
        if (z) {
            j &= f2646a[i - 1] ^ -1;
        }
        long j2 = j;
        for (int i2 = 1; i2 < i; i2++) {
            j2 = (j2 << 8) | (((long) bArr[i2]) & 255);
        }
        return j2;
    }
}
