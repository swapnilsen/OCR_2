package com.google.api.client.p082b;

import java.io.FilterInputStream;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/* renamed from: com.google.api.client.b.s */
public class LoggingInputStream extends FilterInputStream {
    private final LoggingByteArrayOutputStream f4212a;

    public LoggingInputStream(InputStream inputStream, Logger logger, Level level, int i) {
        super(inputStream);
        this.f4212a = new LoggingByteArrayOutputStream(logger, level, i);
    }

    public int read() {
        int read = super.read();
        this.f4212a.write(read);
        return read;
    }

    public int read(byte[] bArr, int i, int i2) {
        int read = super.read(bArr, i, i2);
        if (read > 0) {
            this.f4212a.write(bArr, i, read);
        }
        return read;
    }

    public void close() {
        this.f4212a.close();
        super.close();
    }
}
