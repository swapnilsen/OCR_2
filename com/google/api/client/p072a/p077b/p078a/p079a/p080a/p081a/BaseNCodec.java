package com.google.api.client.p072a.p077b.p078a.p079a.p080a.p081a;

import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;

/* renamed from: com.google.api.client.a.b.a.a.a.a.b */
public abstract class BaseNCodec {
    private final int f4084a;
    protected final byte f4085b;
    protected final int f4086c;
    protected byte[] f4087d;
    protected int f4088e;
    protected boolean f4089f;
    protected int f4090g;
    protected int f4091h;
    private final int f4092i;
    private final int f4093j;
    private int f4094k;

    abstract void m4784a(byte[] bArr, int i, int i2);

    protected abstract boolean m4785a(byte b);

    abstract void m4787b(byte[] bArr, int i, int i2);

    protected BaseNCodec(int i, int i2, int i3, int i4) {
        this.f4085b = (byte) 61;
        this.f4084a = i;
        this.f4092i = i2;
        int i5 = (i3 <= 0 || i4 <= 0) ? 0 : (i3 / i2) * i2;
        this.f4086c = i5;
        this.f4093j = i4;
    }

    int m4782a() {
        return this.f4087d != null ? this.f4088e - this.f4094k : 0;
    }

    protected int m4786b() {
        return AccessibilityNodeInfoCompat.ACTION_SCROLL_BACKWARD;
    }

    private void m4780c() {
        if (this.f4087d == null) {
            this.f4087d = new byte[m4786b()];
            this.f4088e = 0;
            this.f4094k = 0;
            return;
        }
        Object obj = new byte[(this.f4087d.length * 2)];
        System.arraycopy(this.f4087d, 0, obj, 0, this.f4087d.length);
        this.f4087d = obj;
    }

    protected void m4783a(int i) {
        if (this.f4087d == null || this.f4087d.length < this.f4088e + i) {
            m4780c();
        }
    }

    int m4789c(byte[] bArr, int i, int i2) {
        if (this.f4087d == null) {
            return this.f4089f ? -1 : 0;
        } else {
            int min = Math.min(m4782a(), i2);
            System.arraycopy(this.f4087d, this.f4094k, bArr, i, min);
            this.f4094k += min;
            if (this.f4094k < this.f4088e) {
                return min;
            }
            this.f4087d = null;
            return min;
        }
    }

    private void m4781d() {
        this.f4087d = null;
        this.f4088e = 0;
        this.f4094k = 0;
        this.f4090g = 0;
        this.f4091h = 0;
        this.f4089f = false;
    }

    public byte[] m4788b(String str) {
        return m4790c(StringUtils.m4806a(str));
    }

    public byte[] m4790c(byte[] bArr) {
        m4781d();
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        m4787b(bArr, 0, bArr.length);
        m4787b(bArr, 0, -1);
        bArr = new byte[this.f4088e];
        m4789c(bArr, 0, bArr.length);
        return bArr;
    }

    public byte[] m4791d(byte[] bArr) {
        m4781d();
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        m4784a(bArr, 0, bArr.length);
        m4784a(bArr, 0, -1);
        bArr = new byte[(this.f4088e - this.f4094k)];
        m4789c(bArr, 0, bArr.length);
        return bArr;
    }

    protected boolean m4792e(byte[] bArr) {
        if (bArr == null) {
            return false;
        }
        for (byte b : bArr) {
            if (61 == b || m4785a(b)) {
                return true;
            }
        }
        return false;
    }

    public long m4793f(byte[] bArr) {
        long length = ((long) (((bArr.length + this.f4084a) - 1) / this.f4084a)) * ((long) this.f4092i);
        if (this.f4086c > 0) {
            return length + ((((((long) this.f4086c) + length) - 1) / ((long) this.f4086c)) * ((long) this.f4093j));
        }
        return length;
    }
}
