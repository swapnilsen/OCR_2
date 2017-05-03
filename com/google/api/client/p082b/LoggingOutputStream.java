package com.google.api.client.p082b;

import java.io.FilterOutputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/* renamed from: com.google.api.client.b.t */
public class LoggingOutputStream extends FilterOutputStream {
    private final LoggingByteArrayOutputStream f4213a;

    public LoggingOutputStream(OutputStream outputStream, Logger logger, Level level, int i) {
        super(outputStream);
        this.f4213a = new LoggingByteArrayOutputStream(logger, level, i);
    }

    public void write(int i) {
        this.out.write(i);
        this.f4213a.write(i);
    }

    public void write(byte[] bArr, int i, int i2) {
        this.out.write(bArr, i, i2);
        this.f4213a.write(bArr, i, i2);
    }

    public void close() {
        this.f4213a.close();
        super.close();
    }

    public final LoggingByteArrayOutputStream m4960a() {
        return this.f4213a;
    }
}
