package com.facebook.ads.internal.p024b;

import android.text.TextUtils;
import java.util.Locale;

/* renamed from: com.facebook.ads.internal.b.k */
public enum C0485k {
    UNKNOWN,
    AN,
    ADMOB,
    INMOBI,
    YAHOO;

    public static C0485k m1299a(String str) {
        if (TextUtils.isEmpty(str)) {
            return UNKNOWN;
        }
        try {
            return (C0485k) Enum.valueOf(C0485k.class, str.toUpperCase(Locale.getDefault()));
        } catch (Exception e) {
            return UNKNOWN;
        }
    }
}
