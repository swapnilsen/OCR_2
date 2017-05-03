package com.facebook.ads.internal.p021m;

import android.database.ContentObserver;
import android.os.Handler;

/* renamed from: com.facebook.ads.internal.m.d */
class C0677d extends ContentObserver {
    private final C0689j f1627a;

    public C0677d(Handler handler, C0689j c0689j) {
        super(handler);
        this.f1627a = c0689j;
    }

    public boolean deliverSelfNotifications() {
        return false;
    }

    public void onChange(boolean z) {
        this.f1627a.m2239e();
    }
}
