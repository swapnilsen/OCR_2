package com.facebook.ads.internal.p023a;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import com.facebook.ads.internal.p021m.C0705p.C0703a;
import com.facebook.ads.internal.p021m.C0712u;
import java.util.Map;

/* renamed from: com.facebook.ads.internal.a.d */
public class C0452d extends C0449a {
    private static final String f787a;
    private final Context f788b;
    private final String f789c;
    private final Uri f790d;
    private final Map<String, String> f791e;

    static {
        f787a = C0452d.class.getSimpleName();
    }

    public C0452d(Context context, String str, Uri uri, Map<String, String> map) {
        this.f788b = context;
        this.f789c = str;
        this.f790d = uri;
        this.f791e = map;
    }

    public C0703a m1121a() {
        return C0703a.OPEN_LINK;
    }

    public void m1122b() {
        m1109a(this.f788b, this.f789c, this.f790d, this.f791e);
        try {
            C0712u.m2306a(this.f788b, Uri.parse(this.f790d.getQueryParameter("link")), this.f789c);
        } catch (Throwable e) {
            Log.d(f787a, "Failed to open link url: " + this.f790d.toString(), e);
        }
    }
}
