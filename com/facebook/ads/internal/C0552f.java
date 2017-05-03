package com.facebook.ads.internal;

import org.json.JSONArray;

/* renamed from: com.facebook.ads.internal.f */
public enum C0552f {
    APP_AD(0),
    LINK_AD(1),
    APP_AD_V2(2),
    LINK_AD_V2(3),
    APP_ENGAGEMENT_AD(4),
    AD_CHOICES(5),
    JS_TRIGGER(6),
    JS_TRIGGER_NO_AUTO_IMP_LOGGING(7),
    VIDEO_AD(8),
    INLINE_VIDEO_AD(9),
    BANNER_TO_INTERSTITIAL(10),
    NATIVE_CLOSE_BUTTON(11),
    UNIFIED_LOGGING(16),
    HTTP_LINKS(17);
    
    public static final C0552f[] f1239o;
    private static final String f1240q;
    private final int f1242p;

    static {
        f1239o = new C0552f[]{LINK_AD_V2, APP_ENGAGEMENT_AD, AD_CHOICES, JS_TRIGGER_NO_AUTO_IMP_LOGGING, NATIVE_CLOSE_BUTTON, UNIFIED_LOGGING, HTTP_LINKS};
        JSONArray jSONArray = new JSONArray();
        C0552f[] c0552fArr = f1239o;
        int length = c0552fArr.length;
        int i;
        while (i < length) {
            jSONArray.put(c0552fArr[i].m1710a());
            i++;
        }
        f1240q = jSONArray.toString();
    }

    private C0552f(int i) {
        this.f1242p = i;
    }

    public static String m1709b() {
        return f1240q;
    }

    public int m1710a() {
        return this.f1242p;
    }

    public String toString() {
        return String.valueOf(this.f1242p);
    }
}
