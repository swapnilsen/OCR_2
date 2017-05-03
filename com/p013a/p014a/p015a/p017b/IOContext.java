package com.p013a.p014a.p015a.p017b;

import com.p013a.p014a.p015a.JsonEncoding;
import com.p013a.p014a.p015a.p020e.BufferRecycler;
import com.p013a.p014a.p015a.p020e.TextBuffer;

/* renamed from: com.a.a.a.b.d */
public final class IOContext {
    protected final Object f422a;
    protected JsonEncoding f423b;
    protected final boolean f424c;
    protected final BufferRecycler f425d;
    protected byte[] f426e;
    protected byte[] f427f;
    protected byte[] f428g;
    protected char[] f429h;
    protected char[] f430i;
    protected char[] f431j;

    public IOContext(BufferRecycler bufferRecycler, Object obj, boolean z) {
        this.f426e = null;
        this.f427f = null;
        this.f428g = null;
        this.f429h = null;
        this.f430i = null;
        this.f431j = null;
        this.f425d = bufferRecycler;
        this.f422a = obj;
        this.f424c = z;
    }

    public void m567a(JsonEncoding jsonEncoding) {
        this.f423b = jsonEncoding;
    }

    public Object m566a() {
        return this.f422a;
    }

    public JsonEncoding m570b() {
        return this.f423b;
    }

    public boolean m574c() {
        return this.f424c;
    }

    public TextBuffer m575d() {
        return new TextBuffer(this.f425d);
    }

    public byte[] m576e() {
        if (this.f426e != null) {
            throw new IllegalStateException("Trying to call allocReadIOBuffer() second time");
        }
        this.f426e = this.f425d.m914a(BufferRecycler.BufferRecycler.READ_IO_BUFFER);
        return this.f426e;
    }

    public byte[] m577f() {
        if (this.f427f != null) {
            throw new IllegalStateException("Trying to call allocWriteEncodingBuffer() second time");
        }
        this.f427f = this.f425d.m914a(BufferRecycler.BufferRecycler.WRITE_ENCODING_BUFFER);
        return this.f427f;
    }

    public char[] m578g() {
        if (this.f429h != null) {
            throw new IllegalStateException("Trying to call allocTokenBuffer() second time");
        }
        this.f429h = this.f425d.m915a(BufferRecycler.BufferRecycler.TOKEN_BUFFER);
        return this.f429h;
    }

    public char[] m579h() {
        if (this.f430i != null) {
            throw new IllegalStateException("Trying to call allocConcatBuffer() second time");
        }
        this.f430i = this.f425d.m915a(BufferRecycler.BufferRecycler.CONCAT_BUFFER);
        return this.f430i;
    }

    public void m568a(byte[] bArr) {
        if (bArr == null) {
            return;
        }
        if (bArr != this.f426e) {
            throw new IllegalArgumentException("Trying to release buffer not owned by the context");
        }
        this.f426e = null;
        this.f425d.m912a(BufferRecycler.BufferRecycler.READ_IO_BUFFER, bArr);
    }

    public void m571b(byte[] bArr) {
        if (bArr == null) {
            return;
        }
        if (bArr != this.f427f) {
            throw new IllegalArgumentException("Trying to release buffer not owned by the context");
        }
        this.f427f = null;
        this.f425d.m912a(BufferRecycler.BufferRecycler.WRITE_ENCODING_BUFFER, bArr);
    }

    public void m569a(char[] cArr) {
        if (cArr == null) {
            return;
        }
        if (cArr != this.f429h) {
            throw new IllegalArgumentException("Trying to release buffer not owned by the context");
        }
        this.f429h = null;
        this.f425d.m913a(BufferRecycler.BufferRecycler.TOKEN_BUFFER, cArr);
    }

    public void m572b(char[] cArr) {
        if (cArr == null) {
            return;
        }
        if (cArr != this.f430i) {
            throw new IllegalArgumentException("Trying to release buffer not owned by the context");
        }
        this.f430i = null;
        this.f425d.m913a(BufferRecycler.BufferRecycler.CONCAT_BUFFER, cArr);
    }

    public void m573c(char[] cArr) {
        if (cArr == null) {
            return;
        }
        if (cArr != this.f431j) {
            throw new IllegalArgumentException("Trying to release buffer not owned by the context");
        }
        this.f431j = null;
        this.f425d.m913a(BufferRecycler.BufferRecycler.NAME_COPY_BUFFER, cArr);
    }
}
