package com.facebook.ads.internal.p023a;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import com.facebook.ads.internal.p021m.C0705p.C0703a;
import com.facebook.ads.internal.p021m.C0712u;

/* renamed from: com.facebook.ads.internal.a.f */
public class C0454f extends C0449a {
    private static final String f797a;
    private final Context f798b;
    private final String f799c;
    private final Uri f800d;

    static {
        f797a = C0454f.class.getSimpleName();
    }

    public C0454f(Context context, String str, Uri uri) {
        this.f798b = context;
        this.f799c = str;
        this.f800d = uri;
    }

    public C0703a m1125a() {
        return C0703a.OPEN_LINK;
    }

    public void m1126b() {
        try {
            Log.w("REDIRECTACTION: ", this.f800d.toString());
            C0712u.m2306a(this.f798b, this.f800d, this.f799c);
        } catch (Throwable e) {
            Log.d(f797a, "Failed to open link url: " + this.f800d.toString(), e);
        }
    }
}
