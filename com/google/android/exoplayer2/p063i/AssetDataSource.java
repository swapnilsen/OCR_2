package com.google.android.exoplayer2.p063i;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.google.android.exoplayer2.i.c */
public final class AssetDataSource implements DataSource {
    private final AssetManager f3696a;
    private final TransferListener<? super AssetDataSource> f3697b;
    private Uri f3698c;
    private InputStream f3699d;
    private long f3700e;
    private boolean f3701f;

    /* renamed from: com.google.android.exoplayer2.i.c.a */
    public static final class AssetDataSource extends IOException {
        public AssetDataSource(IOException iOException) {
            super(iOException);
        }
    }

    public AssetDataSource(Context context, TransferListener<? super AssetDataSource> transferListener) {
        this.f3696a = context.getAssets();
        this.f3697b = transferListener;
    }

    public long m4335a(DataSpec dataSpec) {
        try {
            this.f3698c = dataSpec.f3710a;
            String path = this.f3698c.getPath();
            if (path.startsWith("/android_asset/")) {
                path = path.substring(15);
            } else if (path.startsWith("/")) {
                path = path.substring(1);
            }
            this.f3699d = this.f3696a.open(path, 1);
            if (this.f3699d.skip(dataSpec.f3713d) < dataSpec.f3713d) {
                throw new EOFException();
            }
            if (dataSpec.f3714e != -1) {
                this.f3700e = dataSpec.f3714e;
            } else {
                this.f3700e = (long) this.f3699d.available();
                if (this.f3700e == 2147483647L) {
                    this.f3700e = -1;
                }
            }
            this.f3701f = true;
            if (this.f3697b != null) {
                this.f3697b.m4353a((Object) this, dataSpec);
            }
            return this.f3700e;
        } catch (IOException e) {
            throw new AssetDataSource(e);
        }
    }

    public int m4334a(byte[] bArr, int i, int i2) {
        if (i2 == 0) {
            return 0;
        }
        if (this.f3700e == 0) {
            return -1;
        }
        try {
            if (this.f3700e != -1) {
                i2 = (int) Math.min(this.f3700e, (long) i2);
            }
            int read = this.f3699d.read(bArr, i, i2);
            if (read != -1) {
                if (this.f3700e != -1) {
                    this.f3700e -= (long) read;
                }
                if (this.f3697b != null) {
                    this.f3697b.m4352a((Object) this, read);
                }
                return read;
            } else if (this.f3700e == -1) {
                return -1;
            } else {
                throw new AssetDataSource(new EOFException());
            }
        } catch (IOException e) {
            throw new AssetDataSource(e);
        }
    }

    public void m4336a() {
        this.f3698c = null;
        try {
            if (this.f3699d != null) {
                this.f3699d.close();
            }
            this.f3699d = null;
            if (this.f3701f) {
                this.f3701f = false;
                if (this.f3697b != null) {
                    this.f3697b.m4351a(this);
                }
            }
        } catch (IOException e) {
            throw new AssetDataSource(e);
        } catch (Throwable th) {
            this.f3699d = null;
            if (this.f3701f) {
                this.f3701f = false;
                if (this.f3697b != null) {
                    this.f3697b.m4351a(this);
                }
            }
        }
    }
}
