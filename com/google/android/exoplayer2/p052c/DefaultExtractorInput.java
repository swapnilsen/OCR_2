package com.google.android.exoplayer2.p052c;

import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.exoplayer2.p063i.DataSource;
import java.io.EOFException;
import java.util.Arrays;

/* renamed from: com.google.android.exoplayer2.c.b */
public final class DefaultExtractorInput implements ExtractorInput {
    private static final byte[] f2650a;
    private final DataSource f2651b;
    private final long f2652c;
    private long f2653d;
    private byte[] f2654e;
    private int f2655f;
    private int f2656g;

    static {
        f2650a = new byte[CodedOutputStream.DEFAULT_BUFFER_SIZE];
    }

    public DefaultExtractorInput(DataSource dataSource, long j, long j2) {
        this.f2651b = dataSource;
        this.f2653d = j;
        this.f2652c = j2;
        this.f2654e = new byte[AccessibilityNodeInfoCompat.ACTION_SCROLL_BACKWARD];
    }

    public int m3249a(byte[] bArr, int i, int i2) {
        int d = m3243d(bArr, i, i2);
        if (d == 0) {
            d = m3242a(bArr, i, i2, 0, true);
        }
        m3247g(d);
        return d;
    }

    public boolean m3252a(byte[] bArr, int i, int i2, boolean z) {
        int d = m3243d(bArr, i, i2);
        while (d < i2 && d != -1) {
            d = m3242a(bArr, i, i2, d, z);
        }
        m3247g(d);
        return d != -1;
    }

    public void m3255b(byte[] bArr, int i, int i2) {
        m3252a(bArr, i, i2, false);
    }

    public int m3248a(int i) {
        int e = m3245e(i);
        if (e == 0) {
            e = m3242a(f2650a, 0, Math.min(i, f2650a.length), 0, true);
        }
        m3247g(e);
        return e;
    }

    public boolean m3251a(int i, boolean z) {
        int e = m3245e(i);
        while (e < i && e != -1) {
            e = m3242a(f2650a, -e, Math.min(i, f2650a.length + e), e, z);
        }
        m3247g(e);
        return e != -1;
    }

    public void m3254b(int i) {
        m3251a(i, false);
    }

    public boolean m3257b(byte[] bArr, int i, int i2, boolean z) {
        if (!m3256b(i2, z)) {
            return false;
        }
        System.arraycopy(this.f2654e, this.f2655f - i2, bArr, i, i2);
        return true;
    }

    public void m3260c(byte[] bArr, int i, int i2) {
        m3257b(bArr, i, i2, false);
    }

    public boolean m3256b(int i, boolean z) {
        m3244d(i);
        int min = Math.min(this.f2656g - this.f2655f, i);
        while (min < i) {
            min = m3242a(this.f2654e, this.f2655f, i, min, z);
            if (min == -1) {
                return false;
            }
        }
        this.f2655f += i;
        this.f2656g = Math.max(this.f2656g, this.f2655f);
        return true;
    }

    public void m3259c(int i) {
        m3256b(i, false);
    }

    public void m3250a() {
        this.f2655f = 0;
    }

    public long m3253b() {
        return this.f2653d + ((long) this.f2655f);
    }

    public long m3258c() {
        return this.f2653d;
    }

    public long m3261d() {
        return this.f2652c;
    }

    private void m3244d(int i) {
        int i2 = this.f2655f + i;
        if (i2 > this.f2654e.length) {
            this.f2654e = Arrays.copyOf(this.f2654e, Math.max(this.f2654e.length * 2, i2));
        }
    }

    private int m3245e(int i) {
        int min = Math.min(this.f2656g, i);
        m3246f(min);
        return min;
    }

    private int m3243d(byte[] bArr, int i, int i2) {
        if (this.f2656g == 0) {
            return 0;
        }
        int min = Math.min(this.f2656g, i2);
        System.arraycopy(this.f2654e, 0, bArr, i, min);
        m3246f(min);
        return min;
    }

    private void m3246f(int i) {
        this.f2656g -= i;
        this.f2655f = 0;
        System.arraycopy(this.f2654e, i, this.f2654e, 0, this.f2656g);
    }

    private int m3242a(byte[] bArr, int i, int i2, int i3, boolean z) {
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        int a = this.f2651b.m4331a(bArr, i + i3, i2 - i3);
        if (a != -1) {
            return i3 + a;
        }
        if (i3 == 0 && z) {
            return -1;
        }
        throw new EOFException();
    }

    private void m3247g(int i) {
        if (i != -1) {
            this.f2653d += (long) i;
        }
    }
}
