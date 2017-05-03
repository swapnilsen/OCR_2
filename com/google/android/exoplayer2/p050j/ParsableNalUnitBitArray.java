package com.google.android.exoplayer2.p050j;

import android.support.v4.view.MotionEventCompat;

/* renamed from: com.google.android.exoplayer2.j.l */
public final class ParsableNalUnitBitArray {
    private byte[] f3834a;
    private int f3835b;
    private int f3836c;
    private int f3837d;

    public ParsableNalUnitBitArray(byte[] bArr, int i, int i2) {
        m4484a(bArr, i, i2);
    }

    public void m4484a(byte[] bArr, int i, int i2) {
        this.f3834a = bArr;
        this.f3836c = i;
        this.f3835b = i2;
        this.f3837d = 0;
        m4482f();
    }

    public void m4483a(int i) {
        int i2 = this.f3836c;
        this.f3836c += i / 8;
        this.f3837d += i % 8;
        if (this.f3837d > 7) {
            this.f3836c++;
            this.f3837d -= 8;
        }
        i2++;
        while (i2 <= this.f3836c) {
            if (m4480d(i2)) {
                this.f3836c++;
                i2 += 2;
            }
            i2++;
        }
        m4482f();
    }

    public boolean m4487b(int i) {
        int i2 = this.f3836c;
        int i3 = (i / 8) + this.f3836c;
        int i4 = this.f3837d + (i % 8);
        if (i4 > 7) {
            i3++;
            i4 -= 8;
        }
        int i5 = i2 + 1;
        i2 = i3;
        i3 = i5;
        while (i3 <= i2 && i2 < this.f3835b) {
            if (m4480d(i3)) {
                i2++;
                i3 += 2;
            }
            i3++;
        }
        return i2 < this.f3835b || (i2 == this.f3835b && i4 == 0);
    }

    public boolean m4485a() {
        return m4489c(1) == 1;
    }

    public int m4489c(int i) {
        int i2 = 0;
        if (i != 0) {
            int i3;
            int i4;
            int i5 = i / 8;
            int i6 = 0;
            for (i3 = 0; i3 < i5; i3++) {
                i2 = m4480d(this.f3836c + 1) ? this.f3836c + 2 : this.f3836c + 1;
                if (this.f3837d != 0) {
                    i4 = ((this.f3834a[this.f3836c] & MotionEventCompat.ACTION_MASK) << this.f3837d) | ((this.f3834a[i2] & MotionEventCompat.ACTION_MASK) >>> (8 - this.f3837d));
                } else {
                    i4 = this.f3834a[this.f3836c];
                }
                i -= 8;
                i6 |= (i4 & MotionEventCompat.ACTION_MASK) << i;
                this.f3836c = i2;
            }
            if (i > 0) {
                i3 = this.f3837d + i;
                byte b = (byte) (MotionEventCompat.ACTION_MASK >> (8 - i));
                i4 = m4480d(this.f3836c + 1) ? this.f3836c + 2 : this.f3836c + 1;
                if (i3 > 8) {
                    i2 = ((((this.f3834a[this.f3836c] & MotionEventCompat.ACTION_MASK) << (i3 - 8)) | ((this.f3834a[i4] & MotionEventCompat.ACTION_MASK) >> (16 - i3))) & b) | i6;
                    this.f3836c = i4;
                } else {
                    i2 = (((this.f3834a[this.f3836c] & MotionEventCompat.ACTION_MASK) >> (8 - i3)) & b) | i6;
                    if (i3 == 8) {
                        this.f3836c = i4;
                    }
                }
                this.f3837d = i3 % 8;
            } else {
                i2 = i6;
            }
            m4482f();
        }
        return i2;
    }

    public boolean m4486b() {
        boolean z;
        int i = this.f3836c;
        int i2 = this.f3837d;
        int i3 = 0;
        while (this.f3836c < this.f3835b && !m4485a()) {
            i3++;
        }
        if (this.f3836c == this.f3835b) {
            z = true;
        } else {
            z = false;
        }
        this.f3836c = i;
        this.f3837d = i2;
        if (z || !m4487b((i3 * 2) + 1)) {
            return false;
        }
        return true;
    }

    public int m4488c() {
        return m4481e();
    }

    public int m4490d() {
        int e = m4481e();
        return (e % 2 == 0 ? -1 : 1) * ((e + 1) / 2);
    }

    private int m4481e() {
        int i = 0;
        int i2 = 0;
        while (!m4485a()) {
            i2++;
        }
        int i3 = (1 << i2) - 1;
        if (i2 > 0) {
            i = m4489c(i2);
        }
        return i3 + i;
    }

    private boolean m4480d(int i) {
        return 2 <= i && i < this.f3835b && this.f3834a[i] == 3 && this.f3834a[i - 2] == null && this.f3834a[i - 1] == null;
    }

    private void m4482f() {
        boolean z = this.f3836c >= 0 && this.f3837d >= 0 && this.f3837d < 8 && (this.f3836c < this.f3835b || (this.f3836c == this.f3835b && this.f3837d == 0));
        Assertions.m4406b(z);
    }
}
