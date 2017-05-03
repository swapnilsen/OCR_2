package com.google.android.exoplayer2.p050j;

import android.support.v4.view.MotionEventCompat;

/* renamed from: com.google.android.exoplayer2.j.j */
public final class ParsableBitArray {
    public byte[] f3827a;
    private int f3828b;
    private int f3829c;
    private int f3830d;

    public ParsableBitArray(byte[] bArr) {
        this(bArr, bArr.length);
    }

    public ParsableBitArray(byte[] bArr, int i) {
        this.f3827a = bArr;
        this.f3830d = i;
    }

    public int m4441a() {
        return (this.f3828b * 8) + this.f3829c;
    }

    public void m4442a(int i) {
        this.f3828b = i / 8;
        this.f3829c = i - (this.f3828b * 8);
        m4440c();
    }

    public void m4443b(int i) {
        this.f3828b += i / 8;
        this.f3829c += i % 8;
        if (this.f3829c > 7) {
            this.f3828b++;
            this.f3829c -= 8;
        }
        m4440c();
    }

    public boolean m4444b() {
        return m4445c(1) == 1;
    }

    public int m4445c(int i) {
        int i2 = 0;
        if (i != 0) {
            int i3;
            int i4 = i / 8;
            int i5 = 0;
            for (i3 = 0; i3 < i4; i3++) {
                if (this.f3829c != 0) {
                    i2 = ((this.f3827a[this.f3828b] & MotionEventCompat.ACTION_MASK) << this.f3829c) | ((this.f3827a[this.f3828b + 1] & MotionEventCompat.ACTION_MASK) >>> (8 - this.f3829c));
                } else {
                    i2 = this.f3827a[this.f3828b];
                }
                i -= 8;
                i5 |= (i2 & MotionEventCompat.ACTION_MASK) << i;
                this.f3828b++;
            }
            if (i > 0) {
                i3 = this.f3829c + i;
                byte b = (byte) (MotionEventCompat.ACTION_MASK >> (8 - i));
                if (i3 > 8) {
                    i2 = (b & (((this.f3827a[this.f3828b] & MotionEventCompat.ACTION_MASK) << (i3 - 8)) | ((this.f3827a[this.f3828b + 1] & MotionEventCompat.ACTION_MASK) >> (16 - i3)))) | i5;
                    this.f3828b++;
                } else {
                    i2 = (b & ((this.f3827a[this.f3828b] & MotionEventCompat.ACTION_MASK) >> (8 - i3))) | i5;
                    if (i3 == 8) {
                        this.f3828b++;
                    }
                }
                this.f3829c = i3 % 8;
            } else {
                i2 = i5;
            }
            m4440c();
        }
        return i2;
    }

    private void m4440c() {
        boolean z = this.f3828b >= 0 && this.f3829c >= 0 && this.f3829c < 8 && (this.f3828b < this.f3830d || (this.f3828b == this.f3830d && this.f3829c == 0));
        Assertions.m4406b(z);
    }
}
