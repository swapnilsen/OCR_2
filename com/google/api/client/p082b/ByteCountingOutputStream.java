package com.google.api.client.p082b;

import java.io.OutputStream;

/* renamed from: com.google.api.client.b.f */
final class ByteCountingOutputStream extends OutputStream {
    long f4136a;

    ByteCountingOutputStream() {
    }

    public void write(byte[] bArr, int i, int i2) {
        this.f4136a += (long) i2;
    }

    public void write(int i) {
        this.f4136a++;
    }
}
