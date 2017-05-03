package com.facebook.ads.internal.p023a;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.facebook.ads.internal.p021m.C0705p.C0703a;
import com.facebook.ads.internal.p021m.C0712u;
import com.facebook.ads.internal.p021m.al;
import com.facebook.ads.internal.p025h.C0580g;
import java.util.Map;

/* renamed from: com.facebook.ads.internal.a.a */
public abstract class C0449a {
    public abstract C0703a m1108a();

    protected void m1109a(Context context, String str, Uri uri, Map<String, String> map) {
        if (TextUtils.isEmpty(str)) {
            if (!TextUtils.isEmpty(uri.getQueryParameter("native_click_report_url"))) {
                new al(map).execute(new String[]{r0});
            } else {
                return;
            }
        }
        C0580g a = C0580g.m1799a(context);
        if (this instanceof C0451c) {
            a.m1818h(str, map);
        } else {
            a.m1813c(str, map);
        }
        C0712u.m2307a(context, "Click logged");
    }

    public abstract void m1110b();
}
