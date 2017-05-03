package com.google.android.exoplayer2.p063i;

import com.google.android.exoplayer2.p063i.HttpDataSource.C0897a;
import p000a.p001a.p002a.p003a.p004a.p009d.EventsFilesManager;

/* renamed from: com.google.android.exoplayer2.i.n */
public final class DefaultHttpDataSourceFactory implements C0897a {
    private final String f3764a;
    private final TransferListener<? super DataSource> f3765b;
    private final int f3766c;
    private final int f3767d;
    private final boolean f3768e;

    public /* synthetic */ DataSource m4377a() {
        return m4378b();
    }

    public DefaultHttpDataSourceFactory(String str, TransferListener<? super DataSource> transferListener) {
        this(str, transferListener, EventsFilesManager.MAX_BYTE_SIZE_PER_FILE, EventsFilesManager.MAX_BYTE_SIZE_PER_FILE, false);
    }

    public DefaultHttpDataSourceFactory(String str, TransferListener<? super DataSource> transferListener, int i, int i2, boolean z) {
        this.f3764a = str;
        this.f3765b = transferListener;
        this.f3766c = i;
        this.f3767d = i2;
        this.f3768e = z;
    }

    public DefaultHttpDataSource m4378b() {
        return new DefaultHttpDataSource(this.f3764a, null, this.f3765b, this.f3766c, this.f3767d, this.f3768e);
    }
}
