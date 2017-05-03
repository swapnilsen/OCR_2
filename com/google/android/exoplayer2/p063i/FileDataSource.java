package com.google.android.exoplayer2.p063i;

import android.net.Uri;
import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* renamed from: com.google.android.exoplayer2.i.o */
public final class FileDataSource implements DataSource {
    private final TransferListener<? super FileDataSource> f3769a;
    private RandomAccessFile f3770b;
    private Uri f3771c;
    private long f3772d;
    private boolean f3773e;

    /* renamed from: com.google.android.exoplayer2.i.o.a */
    public static class FileDataSource extends IOException {
        public FileDataSource(IOException iOException) {
            super(iOException);
        }
    }

    public FileDataSource() {
        this(null);
    }

    public FileDataSource(TransferListener<? super FileDataSource> transferListener) {
        this.f3769a = transferListener;
    }

    public long m4380a(DataSpec dataSpec) {
        try {
            this.f3771c = dataSpec.f3710a;
            this.f3770b = new RandomAccessFile(dataSpec.f3710a.getPath(), "r");
            this.f3770b.seek(dataSpec.f3713d);
            this.f3772d = dataSpec.f3714e == -1 ? this.f3770b.length() - dataSpec.f3713d : dataSpec.f3714e;
            if (this.f3772d < 0) {
                throw new EOFException();
            }
            this.f3773e = true;
            if (this.f3769a != null) {
                this.f3769a.m4353a((Object) this, dataSpec);
            }
            return this.f3772d;
        } catch (IOException e) {
            throw new FileDataSource(e);
        }
    }

    public int m4379a(byte[] bArr, int i, int i2) {
        if (i2 == 0) {
            return 0;
        }
        if (this.f3772d == 0) {
            return -1;
        }
        try {
            int read = this.f3770b.read(bArr, i, (int) Math.min(this.f3772d, (long) i2));
            if (read <= 0) {
                return read;
            }
            this.f3772d -= (long) read;
            if (this.f3769a == null) {
                return read;
            }
            this.f3769a.m4352a((Object) this, read);
            return read;
        } catch (IOException e) {
            throw new FileDataSource(e);
        }
    }

    public void m4381a() {
        this.f3771c = null;
        try {
            if (this.f3770b != null) {
                this.f3770b.close();
            }
            this.f3770b = null;
            if (this.f3773e) {
                this.f3773e = false;
                if (this.f3769a != null) {
                    this.f3769a.m4351a(this);
                }
            }
        } catch (IOException e) {
            throw new FileDataSource(e);
        } catch (Throwable th) {
            this.f3770b = null;
            if (this.f3773e) {
                this.f3773e = false;
                if (this.f3769a != null) {
                    this.f3769a.m4351a(this);
                }
            }
        }
    }
}
