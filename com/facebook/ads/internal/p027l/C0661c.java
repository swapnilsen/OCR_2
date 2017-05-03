package com.facebook.ads.internal.p027l;

import android.text.TextUtils;
import com.facebook.ads.C0441e;

/* renamed from: com.facebook.ads.internal.l.c */
public class C0661c {
    public static String m2120a() {
        if (TextUtils.isEmpty(C0441e.m1052a())) {
            return "https://graph.facebook.com/network_ads_common";
        }
        return String.format("https://graph.%s.facebook.com/network_ads_common", new Object[]{C0441e.m1052a()});
    }

    public static String m2121b() {
        if (TextUtils.isEmpty(C0441e.m1052a())) {
            return "https://www.facebook.com/adnw_logging/";
        }
        return String.format("https://www.%s.facebook.com/adnw_logging/", new Object[]{C0441e.m1052a()});
    }
}
