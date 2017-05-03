package com.google.api.client.p082b;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* renamed from: com.google.api.client.b.g */
public final class ByteStreams {

    /* renamed from: com.google.api.client.b.g.a */
    private static final class ByteStreams extends FilterInputStream {
        private long f4137a;
        private long f4138b;

        ByteStreams(InputStream inputStream, long j) {
            super(inputStream);
            this.f4138b = -1;
            Preconditions.m4968a((Object) inputStream);
            Preconditions.m4972a(j >= 0, (Object) "limit must be non-negative");
            this.f4137a = j;
        }

        public int available() {
            return (int) Math.min((long) this.in.available(), this.f4137a);
        }

        public synchronized void mark(int i) {
            this.in.mark(i);
            this.f4138b = this.f4137a;
        }

        public int read() {
            if (this.f4137a == 0) {
                return -1;
            }
            int read = this.in.read();
            if (read != -1) {
                this.f4137a--;
            }
            return read;
        }

        public int read(byte[] bArr, int i, int i2) {
            if (this.f4137a == 0) {
                return -1;
            }
            int read = this.in.read(bArr, i, (int) Math.min((long) i2, this.f4137a));
            if (read != -1) {
                this.f4137a -= (long) read;
            }
            return read;
        }

        public synchronized void reset() {
            if (!this.in.markSupported()) {
                throw new IOException("Mark not supported");
            } else if (this.f4138b == -1) {
                throw new IOException("Mark not set");
            } else {
                this.in.reset();
                this.f4137a = this.f4138b;
            }
        }

        public long skip(long j) {
            long skip = this.in.skip(Math.min(j, this.f4137a));
            this.f4137a -= skip;
            return skip;
        }
    }

    public static long m4888a(InputStream inputStream, OutputStream outputStream) {
        Preconditions.m4968a((Object) inputStream);
        Preconditions.m4968a((Object) outputStream);
        byte[] bArr = new byte[CodedOutputStream.DEFAULT_BUFFER_SIZE];
        long j = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return j;
            }
            outputStream.write(bArr, 0, read);
            j += (long) read;
        }
    }

    public static InputStream m4889a(InputStream inputStream, long j) {
        return new ByteStreams(inputStream, j);
    }

    public static int m4887a(InputStream inputStream, byte[] bArr, int i, int i2) {
        Preconditions.m4968a((Object) inputStream);
        Preconditions.m4968a((Object) bArr);
        if (i2 < 0) {
            throw new IndexOutOfBoundsException("len is negative");
        }
        int i3 = 0;
        while (i3 < i2) {
            int read = inputStream.read(bArr, i + i3, i2 - i3);
            if (read == -1) {
                break;
            }
            i3 += read;
        }
        return i3;
    }
}
