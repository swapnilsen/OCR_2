package com.p013a.p014a.p015a.p017b;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

/* renamed from: com.a.a.a.b.a */
abstract class BaseReader extends Reader {
    protected final IOContext f407a;
    protected InputStream f408b;
    protected byte[] f409c;
    protected int f410d;
    protected int f411e;
    protected char[] f412f;

    protected BaseReader(IOContext iOContext, InputStream inputStream, byte[] bArr, int i, int i2) {
        this.f412f = null;
        this.f407a = iOContext;
        this.f408b = inputStream;
        this.f409c = bArr;
        this.f410d = i;
        this.f411e = i2;
    }

    public void close() {
        InputStream inputStream = this.f408b;
        if (inputStream != null) {
            this.f408b = null;
            m551a();
            inputStream.close();
        }
    }

    public int read() {
        if (this.f412f == null) {
            this.f412f = new char[1];
        }
        if (read(this.f412f, 0, 1) < 1) {
            return -1;
        }
        return this.f412f[0];
    }

    public final void m551a() {
        byte[] bArr = this.f409c;
        if (bArr != null) {
            this.f409c = null;
            this.f407a.m568a(bArr);
        }
    }

    protected void m552a(char[] cArr, int i, int i2) {
        throw new ArrayIndexOutOfBoundsException("read(buf," + i + "," + i2 + "), cbuf[" + cArr.length + "]");
    }

    protected void m553b() {
        throw new IOException("Strange I/O stream, returned 0 bytes on read");
    }
}
