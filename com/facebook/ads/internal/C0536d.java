package com.facebook.ads.internal;

import android.text.TextUtils;
import com.facebook.ads.C0439c;

/* renamed from: com.facebook.ads.internal.d */
public class C0536d {
    private final C0455a f1172a;
    private final String f1173b;

    public C0536d(int i, String str) {
        this(C0455a.m1127a(i), str);
    }

    public C0536d(C0455a c0455a, String str) {
        if (TextUtils.isEmpty(str)) {
            str = c0455a.m1131b();
        }
        this.f1172a = c0455a;
        this.f1173b = str;
    }

    public C0455a m1660a() {
        return this.f1172a;
    }

    public C0439c m1661b() {
        return this.f1172a.m1132c() ? new C0439c(this.f1172a.m1129a(), this.f1173b) : new C0439c(C0455a.UNKNOWN_ERROR.m1129a(), C0455a.UNKNOWN_ERROR.m1131b());
    }
}
