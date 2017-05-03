package com.google.android.exoplayer2.p063i;

import android.content.Context;
import com.google.android.exoplayer2.p050j.Assertions;
import com.google.android.exoplayer2.p050j.Util;
import com.google.firebase.analytics.FirebaseAnalytics.Param;

/* renamed from: com.google.android.exoplayer2.i.k */
public final class DefaultDataSource implements DataSource {
    private final DataSource f3738a;
    private final DataSource f3739b;
    private final DataSource f3740c;
    private final DataSource f3741d;
    private DataSource f3742e;

    public DefaultDataSource(Context context, TransferListener<? super DataSource> transferListener, DataSource dataSource) {
        this.f3738a = (DataSource) Assertions.m4402a((Object) dataSource);
        this.f3739b = new FileDataSource(transferListener);
        this.f3740c = new AssetDataSource(context, transferListener);
        this.f3741d = new ContentDataSource(context, transferListener);
    }

    public long m4361a(DataSpec dataSpec) {
        Assertions.m4406b(this.f3742e == null);
        String scheme = dataSpec.f3710a.getScheme();
        if (Util.m4516a(dataSpec.f3710a)) {
            if (dataSpec.f3710a.getPath().startsWith("/android_asset/")) {
                this.f3742e = this.f3740c;
            } else {
                this.f3742e = this.f3739b;
            }
        } else if ("asset".equals(scheme)) {
            this.f3742e = this.f3740c;
        } else if (Param.CONTENT.equals(scheme)) {
            this.f3742e = this.f3741d;
        } else {
            this.f3742e = this.f3738a;
        }
        return this.f3742e.m4332a(dataSpec);
    }

    public int m4360a(byte[] bArr, int i, int i2) {
        return this.f3742e.m4331a(bArr, i, i2);
    }

    public void m4362a() {
        if (this.f3742e != null) {
            try {
                this.f3742e.m4333a();
            } finally {
                this.f3742e = null;
            }
        }
    }
}
