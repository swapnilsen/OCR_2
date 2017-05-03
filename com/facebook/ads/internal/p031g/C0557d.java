package com.facebook.ads.internal.p031g;

import android.support.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.facebook.ads.internal.g.d */
public class C0557d {
    private List<C0553a> f1258a;
    private int f1259b;
    private C0558e f1260c;
    @Nullable
    private String f1261d;

    public C0557d(C0558e c0558e, @Nullable String str) {
        this.f1259b = 0;
        this.f1258a = new ArrayList();
        this.f1260c = c0558e;
        this.f1261d = str;
    }

    public C0558e m1718a() {
        return this.f1260c;
    }

    public void m1719a(C0553a c0553a) {
        this.f1258a.add(c0553a);
    }

    @Nullable
    public String m1720b() {
        return this.f1261d;
    }

    public C0553a m1721c() {
        if (this.f1259b >= this.f1258a.size()) {
            return null;
        }
        this.f1259b++;
        return (C0553a) this.f1258a.get(this.f1259b - 1);
    }
}
