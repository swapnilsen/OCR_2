package com.google.api.client.p082b;

import java.io.ByteArrayOutputStream;
import java.text.NumberFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/* renamed from: com.google.api.client.b.r */
public class LoggingByteArrayOutputStream extends ByteArrayOutputStream {
    private int f4207a;
    private final int f4208b;
    private boolean f4209c;
    private final Level f4210d;
    private final Logger f4211e;

    public LoggingByteArrayOutputStream(Logger logger, Level level, int i) {
        this.f4211e = (Logger) Preconditions.m4968a((Object) logger);
        this.f4210d = (Level) Preconditions.m4968a((Object) level);
        Preconditions.m4971a(i >= 0);
        this.f4208b = i;
    }

    public synchronized void write(int i) {
        Preconditions.m4971a(!this.f4209c);
        this.f4207a++;
        if (this.count < this.f4208b) {
            super.write(i);
        }
    }

    public synchronized void write(byte[] bArr, int i, int i2) {
        Preconditions.m4971a(!this.f4209c);
        this.f4207a += i2;
        if (this.count < this.f4208b) {
            int i3 = this.count + i2;
            if (i3 > this.f4208b) {
                i2 += this.f4208b - i3;
            }
            super.write(bArr, i, i2);
        }
    }

    public synchronized void close() {
        if (!this.f4209c) {
            if (this.f4207a != 0) {
                StringBuilder append = new StringBuilder().append("Total: ");
                LoggingByteArrayOutputStream.m4959a(append, this.f4207a);
                if (this.count != 0 && this.count < this.f4207a) {
                    append.append(" (logging first ");
                    LoggingByteArrayOutputStream.m4959a(append, this.count);
                    append.append(")");
                }
                this.f4211e.config(append.toString());
                if (this.count != 0) {
                    this.f4211e.log(this.f4210d, toString("UTF-8").replaceAll("[\\x00-\\x09\\x0B\\x0C\\x0E-\\x1F\\x7F]", " "));
                }
            }
            this.f4209c = true;
        }
    }

    private static void m4959a(StringBuilder stringBuilder, int i) {
        if (i == 1) {
            stringBuilder.append("1 byte");
        } else {
            stringBuilder.append(NumberFormat.getInstance().format((long) i)).append(" bytes");
        }
    }
}
