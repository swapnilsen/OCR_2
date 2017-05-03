package com.facebook.ads.internal.p027l;

import android.support.v4.os.EnvironmentCompat;
import android.text.TextUtils;
import java.util.Locale;

/* renamed from: com.facebook.ads.internal.l.a */
public enum C0656a {
    UNKNOWN(EnvironmentCompat.MEDIA_UNKNOWN),
    BANNER("banner"),
    INTERSTITIAL("interstitial"),
    NATIVE("native"),
    INSTREAM("instream"),
    REWARDED_VIDEO("rewarded_video");
    
    private String f1538g;

    private C0656a(String str) {
        this.f1538g = str;
    }

    public static C0656a m2100a(String str) {
        if (TextUtils.isEmpty(str)) {
            return UNKNOWN;
        }
        try {
            return C0656a.valueOf(str.toUpperCase(Locale.US));
        } catch (Exception e) {
            return UNKNOWN;
        }
    }

    public String toString() {
        return this.f1538g;
    }
}
