package com.p013a.p014a.p015a.p020e;

import android.support.v4.view.PointerIconCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.api.client.http.HttpStatusCodes;
import com.p013a.p014a.p015a.p020e.BufferRecycler.BufferRecycler;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.a.a.a.e.b */
public final class ByteArrayBuilder extends OutputStream {
    private static final byte[] f626a;
    private final BufferRecycler f627b;
    private final LinkedList<byte[]> f628c;
    private int f629d;
    private byte[] f630e;
    private int f631f;

    static {
        f626a = new byte[0];
    }

    public ByteArrayBuilder() {
        this(null);
    }

    public ByteArrayBuilder(BufferRecycler bufferRecycler) {
        this(bufferRecycler, HttpStatusCodes.STATUS_CODE_SERVER_ERROR);
    }

    public ByteArrayBuilder(BufferRecycler bufferRecycler, int i) {
        this.f628c = new LinkedList();
        this.f627b = bufferRecycler;
        if (bufferRecycler == null) {
            this.f630e = new byte[i];
        } else {
            this.f630e = bufferRecycler.m914a(BufferRecycler.WRITE_CONCAT_BUFFER);
        }
    }

    public void m918a() {
        this.f629d = 0;
        this.f631f = 0;
        if (!this.f628c.isEmpty()) {
            this.f628c.clear();
        }
    }

    public void m919a(int i) {
        if (this.f631f >= this.f630e.length) {
            m917e();
        }
        byte[] bArr = this.f630e;
        int i2 = this.f631f;
        this.f631f = i2 + 1;
        bArr[i2] = (byte) i;
    }

    public byte[] m920b() {
        int i = this.f629d + this.f631f;
        if (i == 0) {
            return f626a;
        }
        Object obj = new byte[i];
        Iterator it = this.f628c.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            byte[] bArr = (byte[]) it.next();
            int length = bArr.length;
            System.arraycopy(bArr, 0, obj, i2, length);
            i2 += length;
        }
        System.arraycopy(this.f630e, 0, obj, i2, this.f631f);
        int i3 = this.f631f + i2;
        if (i3 != i) {
            throw new RuntimeException("Internal error: total len assumed to be " + i + ", copied " + i3 + " bytes");
        }
        if (!this.f628c.isEmpty()) {
            m918a();
        }
        return obj;
    }

    public byte[] m922c() {
        m918a();
        return this.f630e;
    }

    public byte[] m923d() {
        m917e();
        return this.f630e;
    }

    public byte[] m921b(int i) {
        this.f631f = i;
        return m920b();
    }

    public void write(byte[] bArr) {
        write(bArr, 0, bArr.length);
    }

    public void write(byte[] bArr, int i, int i2) {
        while (true) {
            int min = Math.min(this.f630e.length - this.f631f, i2);
            if (min > 0) {
                System.arraycopy(bArr, i, this.f630e, this.f631f, min);
                i += min;
                this.f631f += min;
                i2 -= min;
            }
            if (i2 > 0) {
                m917e();
            } else {
                return;
            }
        }
    }

    public void write(int i) {
        m919a(i);
    }

    public void close() {
    }

    public void flush() {
    }

    private void m917e() {
        int i = AccessibilityNodeInfoCompat.ACTION_EXPAND;
        this.f629d += this.f630e.length;
        int max = Math.max(this.f629d >> 1, PointerIconCompat.TYPE_DEFAULT);
        if (max <= AccessibilityNodeInfoCompat.ACTION_EXPAND) {
            i = max;
        }
        this.f628c.add(this.f630e);
        this.f630e = new byte[i];
        this.f631f = 0;
    }
}
