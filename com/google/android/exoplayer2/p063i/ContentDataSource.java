package com.google.android.exoplayer2.p063i;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.google.android.exoplayer2.i.e */
public final class ContentDataSource implements DataSource {
    private final ContentResolver f3702a;
    private final TransferListener<? super ContentDataSource> f3703b;
    private Uri f3704c;
    private AssetFileDescriptor f3705d;
    private InputStream f3706e;
    private long f3707f;
    private boolean f3708g;

    /* renamed from: com.google.android.exoplayer2.i.e.a */
    public static class ContentDataSource extends IOException {
        public ContentDataSource(IOException iOException) {
            super(iOException);
        }
    }

    public ContentDataSource(Context context, TransferListener<? super ContentDataSource> transferListener) {
        this.f3702a = context.getContentResolver();
        this.f3703b = transferListener;
    }

    public long m4340a(DataSpec dataSpec) {
        try {
            this.f3704c = dataSpec.f3710a;
            this.f3705d = this.f3702a.openAssetFileDescriptor(this.f3704c, "r");
            this.f3706e = new FileInputStream(this.f3705d.getFileDescriptor());
            if (this.f3706e.skip(dataSpec.f3713d) < dataSpec.f3713d) {
                throw new EOFException();
            }
            if (dataSpec.f3714e != -1) {
                this.f3707f = dataSpec.f3714e;
            } else {
                this.f3707f = (long) this.f3706e.available();
                if (this.f3707f == 0) {
                    this.f3707f = -1;
                }
            }
            this.f3708g = true;
            if (this.f3703b != null) {
                this.f3703b.m4353a((Object) this, dataSpec);
            }
            return this.f3707f;
        } catch (IOException e) {
            throw new ContentDataSource(e);
        }
    }

    public int m4339a(byte[] bArr, int i, int i2) {
        if (i2 == 0) {
            return 0;
        }
        if (this.f3707f == 0) {
            return -1;
        }
        try {
            if (this.f3707f != -1) {
                i2 = (int) Math.min(this.f3707f, (long) i2);
            }
            int read = this.f3706e.read(bArr, i, i2);
            if (read != -1) {
                if (this.f3707f != -1) {
                    this.f3707f -= (long) read;
                }
                if (this.f3703b != null) {
                    this.f3703b.m4352a((Object) this, read);
                }
                return read;
            } else if (this.f3707f == -1) {
                return -1;
            } else {
                throw new ContentDataSource(new EOFException());
            }
        } catch (IOException e) {
            throw new ContentDataSource(e);
        }
    }

    public void m4341a() {
        this.f3704c = null;
        try {
            if (this.f3706e != null) {
                this.f3706e.close();
            }
            this.f3706e = null;
            try {
                if (this.f3705d != null) {
                    this.f3705d.close();
                }
                this.f3705d = null;
                if (this.f3708g) {
                    this.f3708g = false;
                    if (this.f3703b != null) {
                        this.f3703b.m4351a(this);
                    }
                }
            } catch (IOException e) {
                throw new ContentDataSource(e);
            } catch (Throwable th) {
                this.f3705d = null;
                if (this.f3708g) {
                    this.f3708g = false;
                    if (this.f3703b != null) {
                        this.f3703b.m4351a(this);
                    }
                }
            }
        } catch (IOException e2) {
            throw new ContentDataSource(e2);
        } catch (Throwable th2) {
            this.f3706e = null;
            try {
                if (this.f3705d != null) {
                    this.f3705d.close();
                }
                this.f3705d = null;
                if (this.f3708g) {
                    this.f3708g = false;
                    if (this.f3703b != null) {
                        this.f3703b.m4351a(this);
                    }
                }
            } catch (IOException e22) {
                throw new ContentDataSource(e22);
            } catch (Throwable th3) {
                this.f3705d = null;
                if (this.f3708g) {
                    this.f3708g = false;
                    if (this.f3703b != null) {
                        this.f3703b.m4351a(this);
                    }
                }
            }
        }
    }
}
