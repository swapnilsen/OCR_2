package com.facebook.ads.internal.p021m;

import android.text.TextUtils;
import java.util.Locale;

/* renamed from: com.facebook.ads.internal.m.s */
public enum C0709s {
    NONE,
    INSTALLED,
    NOT_INSTALLED;

    public static C0709s m2287a(String str) {
        if (TextUtils.isEmpty(str)) {
            return NONE;
        }
        try {
            return C0709s.valueOf(str.toUpperCase(Locale.US));
        } catch (IllegalArgumentException e) {
            return NONE;
        }
    }
}
