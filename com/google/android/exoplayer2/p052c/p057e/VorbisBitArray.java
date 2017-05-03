package com.google.android.exoplayer2.p052c.p057e;

import android.support.v4.view.MotionEventCompat;
import com.google.android.exoplayer2.p050j.Assertions;

/* renamed from: com.google.android.exoplayer2.c.e.i */
final class VorbisBitArray {
    public final byte[] f2970a;
    private int f2971b;
    private int f2972c;
    private int f2973d;

    public VorbisBitArray(byte[] bArr) {
        this(bArr, bArr.length);
    }

    public VorbisBitArray(byte[] bArr, int i) {
        this.f2970a = bArr;
        this.f2971b = i * 8;
    }

    public boolean m3518a() {
        return m3517a(1) == 1;
    }

    public int m3517a(int i) {
        Assertions.m4406b(m3519b() + i <= this.f2971b);
        if (i == 0) {
            return 0;
        }
        long min;
        int i2;
        int i3;
        int i4;
        if (this.f2973d != 0) {
            min = Math.min(i, 8 - this.f2973d);
            i2 = (MotionEventCompat.ACTION_MASK >>> (8 - min)) & (this.f2970a[this.f2972c] >>> this.f2973d);
            this.f2973d += min;
            if (this.f2973d == 8) {
                this.f2972c++;
                this.f2973d = 0;
            }
        } else {
            min = 0;
            i2 = 0;
        }
        if (i - min > 7) {
            int i5 = (i - min) / 8;
            i3 = i2;
            i2 = 0;
            while (i2 < i5) {
                long j = (long) i3;
                byte[] bArr = this.f2970a;
                int i6 = this.f2972c;
                this.f2972c = i6 + 1;
                min += 8;
                i2++;
                i3 = (int) (j | ((((long) bArr[i6]) & 255) << min));
            }
            int i7 = min;
            i4 = i3;
            i3 = i7;
        } else {
            i3 = min;
            i4 = i2;
        }
        if (i > i3) {
            i2 = i - i3;
            i4 |= ((MotionEventCompat.ACTION_MASK >>> (8 - i2)) & this.f2970a[this.f2972c]) << i3;
            this.f2973d += i2;
        }
        return i4;
    }

    public void m3520b(int i) {
        Assertions.m4406b(m3519b() + i <= this.f2971b);
        this.f2972c += i / 8;
        this.f2973d += i % 8;
        if (this.f2973d > 7) {
            this.f2972c++;
            this.f2973d -= 8;
        }
    }

    public int m3519b() {
        return (this.f2972c * 8) + this.f2973d;
    }
}
