package com.google.api.client.p082b;

import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/* renamed from: com.google.api.client.b.u */
public final class LoggingStreamingContent implements ae {
    private final ae f4214a;
    private final int f4215b;
    private final Level f4216c;
    private final Logger f4217d;

    public LoggingStreamingContent(ae aeVar, Logger logger, Level level, int i) {
        this.f4214a = aeVar;
        this.f4217d = logger;
        this.f4216c = level;
        this.f4215b = i;
    }

    public void writeTo(OutputStream outputStream) {
        OutputStream loggingOutputStream = new LoggingOutputStream(outputStream, this.f4217d, this.f4216c, this.f4215b);
        try {
            this.f4214a.writeTo(loggingOutputStream);
            outputStream.flush();
        } finally {
            loggingOutputStream.m4960a().close();
        }
    }
}
