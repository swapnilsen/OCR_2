package com.facebook.ads.internal.p023a;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.facebook.ads.internal.p021m.C0705p.C0703a;
import com.facebook.ads.internal.p025h.C0580g;
import com.facebook.ads.internal.p025h.C0581h;
import java.util.Map;

/* renamed from: com.facebook.ads.internal.a.e */
public class C0453e extends C0449a {
    private static final String f792a;
    private final Context f793b;
    private final String f794c;
    private final Uri f795d;
    private final Map<String, String> f796e;

    static {
        f792a = C0453e.class.getSimpleName();
    }

    public C0453e(Context context, String str, Uri uri, Map<String, String> map) {
        this.f793b = context;
        this.f794c = str;
        this.f795d = uri;
        this.f796e = map;
    }

    public C0703a m1123a() {
        return null;
    }

    public void m1124b() {
        C0580g a = C0580g.m1799a(this.f793b);
        C0581h c0581h = C0581h.IMMEDIATE;
        Object queryParameter = this.f795d.getQueryParameter("priority");
        if (!TextUtils.isEmpty(queryParameter)) {
            try {
                c0581h = C0581h.values()[Integer.valueOf(queryParameter).intValue()];
            } catch (Exception e) {
            }
        }
        a.m1807a(this.f794c, this.f796e, this.f795d.getQueryParameter("type"), c0581h);
    }
}
