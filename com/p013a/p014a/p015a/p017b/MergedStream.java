package com.p013a.p014a.p015a.p017b;

import android.support.v4.view.MotionEventCompat;
import java.io.InputStream;

/* renamed from: com.a.a.a.b.g */
public final class MergedStream extends InputStream {
    protected final IOContext f437a;
    final InputStream f438b;
    byte[] f439c;
    int f440d;
    final int f441e;

    public MergedStream(IOContext iOContext, InputStream inputStream, byte[] bArr, int i, int i2) {
        this.f437a = iOContext;
        this.f438b = inputStream;
        this.f439c = bArr;
        this.f440d = i;
        this.f441e = i2;
    }

    public int available() {
        if (this.f439c != null) {
            return this.f441e - this.f440d;
        }
        return this.f438b.available();
    }

    public void close() {
        m586a();
        this.f438b.close();
    }

    public void mark(int i) {
        if (this.f439c == null) {
            this.f438b.mark(i);
        }
    }

    public boolean markSupported() {
        return this.f439c == null && this.f438b.markSupported();
    }

    public int read() {
        if (this.f439c == null) {
            return this.f438b.read();
        }
        byte[] bArr = this.f439c;
        int i = this.f440d;
        this.f440d = i + 1;
        int i2 = bArr[i] & MotionEventCompat.ACTION_MASK;
        if (this.f440d < this.f441e) {
            return i2;
        }
        m586a();
        return i2;
    }

    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    public int read(byte[] bArr, int i, int i2) {
        if (this.f439c == null) {
            return this.f438b.read(bArr, i, i2);
        }
        int i3 = this.f441e - this.f440d;
        if (i2 > i3) {
            i2 = i3;
        }
        System.arraycopy(this.f439c, this.f440d, bArr, i, i2);
        this.f440d += i2;
        if (this.f440d < this.f441e) {
            return i2;
        }
        m586a();
        return i2;
    }

    public void reset() {
        if (this.f439c == null) {
            this.f438b.reset();
        }
    }

    public long skip(long j) {
        long j2;
        if (this.f439c != null) {
            int i = this.f441e - this.f440d;
            if (((long) i) > j) {
                this.f440d += (int) j;
                return j;
            }
            m586a();
            j2 = ((long) i) + 0;
            j -= (long) i;
        } else {
            j2 = 0;
        }
        if (j > 0) {
            j2 += this.f438b.skip(j);
        }
        return j2;
    }

    private void m586a() {
        byte[] bArr = this.f439c;
        if (bArr != null) {
            this.f439c = null;
            if (this.f437a != null) {
                this.f437a.m568a(bArr);
            }
        }
    }
}
