package com.google.android.exoplayer2.p063i;

import android.content.Context;
import com.google.android.exoplayer2.p063i.DataSource.DataSource;

/* renamed from: com.google.android.exoplayer2.i.l */
public final class DefaultDataSourceFactory implements DataSource {
    private final Context f3743a;
    private final TransferListener<? super DataSource> f3744b;
    private final DataSource f3745c;

    public /* synthetic */ DataSource m4363a() {
        return m4364b();
    }

    public DefaultDataSourceFactory(Context context, String str, TransferListener<? super DataSource> transferListener) {
        this(context, (TransferListener) transferListener, new DefaultHttpDataSourceFactory(str, transferListener));
    }

    public DefaultDataSourceFactory(Context context, TransferListener<? super DataSource> transferListener, DataSource dataSource) {
        this.f3743a = context.getApplicationContext();
        this.f3744b = transferListener;
        this.f3745c = dataSource;
    }

    public DefaultDataSource m4364b() {
        return new DefaultDataSource(this.f3743a, this.f3744b, this.f3745c.m4342a());
    }
}
