package com.google.android.exoplayer2.p050j;

import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import java.nio.charset.Charset;

/* renamed from: com.google.android.exoplayer2.j.k */
public final class ParsableByteArray {
    public byte[] f3831a;
    private int f3832b;
    private int f3833c;

    public ParsableByteArray(int i) {
        this.f3831a = new byte[i];
        this.f3833c = i;
    }

    public ParsableByteArray(byte[] bArr) {
        this.f3831a = bArr;
        this.f3833c = bArr.length;
    }

    public ParsableByteArray(byte[] bArr, int i) {
        this.f3831a = bArr;
        this.f3833c = i;
    }

    public void m4448a(int i) {
        m4450a(m4458e() < i ? new byte[i] : this.f3831a, i);
    }

    public void m4450a(byte[] bArr, int i) {
        this.f3831a = bArr;
        this.f3833c = i;
        this.f3832b = 0;
    }

    public void m4447a() {
        this.f3832b = 0;
        this.f3833c = 0;
    }

    public int m4452b() {
        return this.f3833c - this.f3832b;
    }

    public int m4454c() {
        return this.f3833c;
    }

    public void m4453b(int i) {
        boolean z = i >= 0 && i <= this.f3831a.length;
        Assertions.m4404a(z);
        this.f3833c = i;
    }

    public int m4456d() {
        return this.f3832b;
    }

    public int m4458e() {
        return this.f3831a == null ? 0 : this.f3831a.length;
    }

    public void m4455c(int i) {
        boolean z = i >= 0 && i <= this.f3833c;
        Assertions.m4404a(z);
        this.f3832b = i;
    }

    public void m4457d(int i) {
        m4455c(this.f3832b + i);
    }

    public void m4449a(ParsableBitArray parsableBitArray, int i) {
        m4451a(parsableBitArray.f3827a, 0, i);
        parsableBitArray.m4442a(0);
    }

    public void m4451a(byte[] bArr, int i, int i2) {
        System.arraycopy(this.f3831a, this.f3832b, bArr, i, i2);
        this.f3832b += i2;
    }

    public int m4460f() {
        return this.f3831a[this.f3832b] & MotionEventCompat.ACTION_MASK;
    }

    public int m4461g() {
        byte[] bArr = this.f3831a;
        int i = this.f3832b;
        this.f3832b = i + 1;
        return bArr[i] & MotionEventCompat.ACTION_MASK;
    }

    public int m4462h() {
        byte[] bArr = this.f3831a;
        int i = this.f3832b;
        this.f3832b = i + 1;
        int i2 = (bArr[i] & MotionEventCompat.ACTION_MASK) << 8;
        byte[] bArr2 = this.f3831a;
        int i3 = this.f3832b;
        this.f3832b = i3 + 1;
        return i2 | (bArr2[i3] & MotionEventCompat.ACTION_MASK);
    }

    public int m4463i() {
        byte[] bArr = this.f3831a;
        int i = this.f3832b;
        this.f3832b = i + 1;
        int i2 = bArr[i] & MotionEventCompat.ACTION_MASK;
        byte[] bArr2 = this.f3831a;
        int i3 = this.f3832b;
        this.f3832b = i3 + 1;
        return i2 | ((bArr2[i3] & MotionEventCompat.ACTION_MASK) << 8);
    }

    public short m4464j() {
        byte[] bArr = this.f3831a;
        int i = this.f3832b;
        this.f3832b = i + 1;
        int i2 = (bArr[i] & MotionEventCompat.ACTION_MASK) << 8;
        byte[] bArr2 = this.f3831a;
        int i3 = this.f3832b;
        this.f3832b = i3 + 1;
        return (short) (i2 | (bArr2[i3] & MotionEventCompat.ACTION_MASK));
    }

    public int m4465k() {
        byte[] bArr = this.f3831a;
        int i = this.f3832b;
        this.f3832b = i + 1;
        int i2 = (bArr[i] & MotionEventCompat.ACTION_MASK) << 16;
        byte[] bArr2 = this.f3831a;
        int i3 = this.f3832b;
        this.f3832b = i3 + 1;
        i2 |= (bArr2[i3] & MotionEventCompat.ACTION_MASK) << 8;
        bArr2 = this.f3831a;
        i3 = this.f3832b;
        this.f3832b = i3 + 1;
        return i2 | (bArr2[i3] & MotionEventCompat.ACTION_MASK);
    }

    public long m4466l() {
        byte[] bArr = this.f3831a;
        int i = this.f3832b;
        this.f3832b = i + 1;
        long j = (((long) bArr[i]) & 255) << 24;
        byte[] bArr2 = this.f3831a;
        int i2 = this.f3832b;
        this.f3832b = i2 + 1;
        j |= (((long) bArr2[i2]) & 255) << 16;
        bArr2 = this.f3831a;
        i2 = this.f3832b;
        this.f3832b = i2 + 1;
        j |= (((long) bArr2[i2]) & 255) << 8;
        bArr2 = this.f3831a;
        i2 = this.f3832b;
        this.f3832b = i2 + 1;
        return j | (((long) bArr2[i2]) & 255);
    }

    public long m4467m() {
        byte[] bArr = this.f3831a;
        int i = this.f3832b;
        this.f3832b = i + 1;
        long j = ((long) bArr[i]) & 255;
        byte[] bArr2 = this.f3831a;
        int i2 = this.f3832b;
        this.f3832b = i2 + 1;
        j |= (((long) bArr2[i2]) & 255) << 8;
        bArr2 = this.f3831a;
        i2 = this.f3832b;
        this.f3832b = i2 + 1;
        j |= (((long) bArr2[i2]) & 255) << 16;
        bArr2 = this.f3831a;
        i2 = this.f3832b;
        this.f3832b = i2 + 1;
        return j | ((((long) bArr2[i2]) & 255) << 24);
    }

    public int m4468n() {
        byte[] bArr = this.f3831a;
        int i = this.f3832b;
        this.f3832b = i + 1;
        int i2 = (bArr[i] & MotionEventCompat.ACTION_MASK) << 24;
        byte[] bArr2 = this.f3831a;
        int i3 = this.f3832b;
        this.f3832b = i3 + 1;
        i2 |= (bArr2[i3] & MotionEventCompat.ACTION_MASK) << 16;
        bArr2 = this.f3831a;
        i3 = this.f3832b;
        this.f3832b = i3 + 1;
        i2 |= (bArr2[i3] & MotionEventCompat.ACTION_MASK) << 8;
        bArr2 = this.f3831a;
        i3 = this.f3832b;
        this.f3832b = i3 + 1;
        return i2 | (bArr2[i3] & MotionEventCompat.ACTION_MASK);
    }

    public int m4469o() {
        byte[] bArr = this.f3831a;
        int i = this.f3832b;
        this.f3832b = i + 1;
        int i2 = bArr[i] & MotionEventCompat.ACTION_MASK;
        byte[] bArr2 = this.f3831a;
        int i3 = this.f3832b;
        this.f3832b = i3 + 1;
        i2 |= (bArr2[i3] & MotionEventCompat.ACTION_MASK) << 8;
        bArr2 = this.f3831a;
        i3 = this.f3832b;
        this.f3832b = i3 + 1;
        i2 |= (bArr2[i3] & MotionEventCompat.ACTION_MASK) << 16;
        bArr2 = this.f3831a;
        i3 = this.f3832b;
        this.f3832b = i3 + 1;
        return i2 | ((bArr2[i3] & MotionEventCompat.ACTION_MASK) << 24);
    }

    public long m4470p() {
        byte[] bArr = this.f3831a;
        int i = this.f3832b;
        this.f3832b = i + 1;
        long j = (((long) bArr[i]) & 255) << 56;
        byte[] bArr2 = this.f3831a;
        int i2 = this.f3832b;
        this.f3832b = i2 + 1;
        j |= (((long) bArr2[i2]) & 255) << 48;
        bArr2 = this.f3831a;
        i2 = this.f3832b;
        this.f3832b = i2 + 1;
        j |= (((long) bArr2[i2]) & 255) << 40;
        bArr2 = this.f3831a;
        i2 = this.f3832b;
        this.f3832b = i2 + 1;
        j |= (((long) bArr2[i2]) & 255) << 32;
        bArr2 = this.f3831a;
        i2 = this.f3832b;
        this.f3832b = i2 + 1;
        j |= (((long) bArr2[i2]) & 255) << 24;
        bArr2 = this.f3831a;
        i2 = this.f3832b;
        this.f3832b = i2 + 1;
        j |= (((long) bArr2[i2]) & 255) << 16;
        bArr2 = this.f3831a;
        i2 = this.f3832b;
        this.f3832b = i2 + 1;
        j |= (((long) bArr2[i2]) & 255) << 8;
        bArr2 = this.f3831a;
        i2 = this.f3832b;
        this.f3832b = i2 + 1;
        return j | (((long) bArr2[i2]) & 255);
    }

    public long m4471q() {
        byte[] bArr = this.f3831a;
        int i = this.f3832b;
        this.f3832b = i + 1;
        long j = ((long) bArr[i]) & 255;
        byte[] bArr2 = this.f3831a;
        int i2 = this.f3832b;
        this.f3832b = i2 + 1;
        j |= (((long) bArr2[i2]) & 255) << 8;
        bArr2 = this.f3831a;
        i2 = this.f3832b;
        this.f3832b = i2 + 1;
        j |= (((long) bArr2[i2]) & 255) << 16;
        bArr2 = this.f3831a;
        i2 = this.f3832b;
        this.f3832b = i2 + 1;
        j |= (((long) bArr2[i2]) & 255) << 24;
        bArr2 = this.f3831a;
        i2 = this.f3832b;
        this.f3832b = i2 + 1;
        j |= (((long) bArr2[i2]) & 255) << 32;
        bArr2 = this.f3831a;
        i2 = this.f3832b;
        this.f3832b = i2 + 1;
        j |= (((long) bArr2[i2]) & 255) << 40;
        bArr2 = this.f3831a;
        i2 = this.f3832b;
        this.f3832b = i2 + 1;
        j |= (((long) bArr2[i2]) & 255) << 48;
        bArr2 = this.f3831a;
        i2 = this.f3832b;
        this.f3832b = i2 + 1;
        return j | ((((long) bArr2[i2]) & 255) << 56);
    }

    public int m4472r() {
        byte[] bArr = this.f3831a;
        int i = this.f3832b;
        this.f3832b = i + 1;
        int i2 = (bArr[i] & MotionEventCompat.ACTION_MASK) << 8;
        byte[] bArr2 = this.f3831a;
        int i3 = this.f3832b;
        this.f3832b = i3 + 1;
        i2 |= bArr2[i3] & MotionEventCompat.ACTION_MASK;
        this.f3832b += 2;
        return i2;
    }

    public int m4473s() {
        return (((m4461g() << 21) | (m4461g() << 14)) | (m4461g() << 7)) | m4461g();
    }

    public int m4474t() {
        int n = m4468n();
        if (n >= 0) {
            return n;
        }
        throw new IllegalStateException("Top bit not zero: " + n);
    }

    public int m4475u() {
        int o = m4469o();
        if (o >= 0) {
            return o;
        }
        throw new IllegalStateException("Top bit not zero: " + o);
    }

    public long m4476v() {
        long p = m4470p();
        if (p >= 0) {
            return p;
        }
        throw new IllegalStateException("Top bit not zero: " + p);
    }

    public double m4477w() {
        return Double.longBitsToDouble(m4470p());
    }

    public String m4459e(int i) {
        return m4446a(i, Charset.defaultCharset());
    }

    public String m4446a(int i, Charset charset) {
        String str = new String(this.f3831a, this.f3832b, i, charset);
        this.f3832b += i;
        return str;
    }

    public String m4478x() {
        if (m4452b() == 0) {
            return null;
        }
        int i = this.f3832b;
        while (i < this.f3833c && this.f3831a[i] != (byte) 10 && this.f3831a[i] != (byte) 13) {
            i++;
        }
        if (i - this.f3832b >= 3 && this.f3831a[this.f3832b] == -17 && this.f3831a[this.f3832b + 1] == -69 && this.f3831a[this.f3832b + 2] == -65) {
            this.f3832b += 3;
        }
        String str = new String(this.f3831a, this.f3832b, i - this.f3832b);
        this.f3832b = i;
        if (this.f3832b == this.f3833c) {
            return str;
        }
        if (this.f3831a[this.f3832b] == (byte) 13) {
            this.f3832b++;
            if (this.f3832b == this.f3833c) {
                return str;
            }
        }
        if (this.f3831a[this.f3832b] == (byte) 10) {
            this.f3832b++;
        }
        return str;
    }

    public long m4479y() {
        int i = 1;
        int i2 = 0;
        long j = (long) this.f3831a[this.f3832b];
        for (int i3 = 7; i3 >= 0; i3--) {
            byte b;
            if ((((long) (1 << i3)) & j) == 0) {
                if (i3 < 6) {
                    j &= (long) ((1 << i3) - 1);
                    i2 = 7 - i3;
                } else if (i3 == 7) {
                    i2 = 1;
                }
                if (i2 != 0) {
                    throw new NumberFormatException("Invalid UTF-8 sequence first byte: " + j);
                }
                while (i < i2) {
                    b = this.f3831a[this.f3832b + i];
                    if ((b & 192) == AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS) {
                        throw new NumberFormatException("Invalid UTF-8 sequence continuation byte: " + j);
                    }
                    j = (j << 6) | ((long) (b & 63));
                    i++;
                }
                this.f3832b += i2;
                return j;
            }
        }
        if (i2 != 0) {
            while (i < i2) {
                b = this.f3831a[this.f3832b + i];
                if ((b & 192) == AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS) {
                    j = (j << 6) | ((long) (b & 63));
                    i++;
                } else {
                    throw new NumberFormatException("Invalid UTF-8 sequence continuation byte: " + j);
                }
            }
            this.f3832b += i2;
            return j;
        }
        throw new NumberFormatException("Invalid UTF-8 sequence first byte: " + j);
    }
}
