package com.p013a.p014a.p015a.p020e;

import com.google.api.client.http.HttpStatusCodes;

/* renamed from: com.a.a.a.e.a */
public class BufferRecycler {
    protected final byte[][] f624a;
    protected final char[][] f625b;

    /* renamed from: com.a.a.a.e.a.a */
    public enum BufferRecycler {
        READ_IO_BUFFER(4000),
        WRITE_ENCODING_BUFFER(4000),
        WRITE_CONCAT_BUFFER(2000),
        BASE64_CODEC_BUFFER(2000);
        
        protected final int f617e;

        private BufferRecycler(int i) {
            this.f617e = i;
        }
    }

    /* renamed from: com.a.a.a.e.a.b */
    public enum BufferRecycler {
        TOKEN_BUFFER(2000),
        CONCAT_BUFFER(2000),
        TEXT_BUFFER(HttpStatusCodes.STATUS_CODE_OK),
        NAME_COPY_BUFFER(HttpStatusCodes.STATUS_CODE_OK);
        
        protected final int f623e;

        private BufferRecycler(int i) {
            this.f623e = i;
        }
    }

    public BufferRecycler() {
        this.f624a = new byte[BufferRecycler.values().length][];
        this.f625b = new char[BufferRecycler.values().length][];
    }

    public final byte[] m914a(BufferRecycler bufferRecycler) {
        int ordinal = bufferRecycler.ordinal();
        byte[] bArr = this.f624a[ordinal];
        if (bArr == null) {
            return m910a(bufferRecycler.f617e);
        }
        this.f624a[ordinal] = null;
        return bArr;
    }

    public final void m912a(BufferRecycler bufferRecycler, byte[] bArr) {
        this.f624a[bufferRecycler.ordinal()] = bArr;
    }

    public final char[] m915a(BufferRecycler bufferRecycler) {
        return m916a(bufferRecycler, 0);
    }

    public final char[] m916a(BufferRecycler bufferRecycler, int i) {
        if (bufferRecycler.f623e > i) {
            i = bufferRecycler.f623e;
        }
        int ordinal = bufferRecycler.ordinal();
        char[] cArr = this.f625b[ordinal];
        if (cArr == null || cArr.length < i) {
            return m911b(i);
        }
        this.f625b[ordinal] = null;
        return cArr;
    }

    public final void m913a(BufferRecycler bufferRecycler, char[] cArr) {
        this.f625b[bufferRecycler.ordinal()] = cArr;
    }

    private byte[] m910a(int i) {
        return new byte[i];
    }

    private char[] m911b(int i) {
        return new char[i];
    }
}
