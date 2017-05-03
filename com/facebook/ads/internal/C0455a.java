package com.facebook.ads.internal;

import android.support.v4.view.PointerIconCompat;

/* renamed from: com.facebook.ads.internal.a */
public enum C0455a {
    UNKNOWN_ERROR(-1, "unknown error", false),
    NETWORK_ERROR(PointerIconCompat.TYPE_DEFAULT, "Network Error", true),
    NO_FILL(PointerIconCompat.TYPE_CONTEXT_MENU, "No Fill", true),
    LOAD_TOO_FREQUENTLY(PointerIconCompat.TYPE_HAND, "Ad was re-loaded too frequently", true),
    DISABLED_APP(1005, "App is disabled from making ad requests", true),
    SERVER_ERROR(2000, "Server Error", true),
    INTERNAL_ERROR(2001, "Internal Error", true),
    START_BEFORE_INIT(2004, "initAd must be called before startAd", true),
    AD_REQUEST_FAILED(1111, "Facebook Ads SDK request for ads failed", false),
    AD_REQUEST_TIMEOUT(1112, "Facebook Ads SDK request for ads timed out", false),
    PARSER_FAILURE(1201, "Failed to parse Facebook Ads SDK delivery response", false),
    UNKNOWN_RESPONSE(1202, "Unknown Facebook Ads SDK delivery response type", false),
    ERROR_MESSAGE(1203, "Facebook Ads SDK delivery response Error message", true),
    NO_AD_PLACEMENT(1302, "Facebook Ads SDK returned no ad placements", false);
    
    private final int f816o;
    private final String f817p;
    private final boolean f818q;

    private C0455a(int i, String str, boolean z) {
        this.f816o = i;
        this.f817p = str;
        this.f818q = z;
    }

    public static C0455a m1127a(int i) {
        return C0455a.m1128a(i, UNKNOWN_ERROR);
    }

    public static C0455a m1128a(int i, C0455a c0455a) {
        for (C0455a c0455a2 : C0455a.values()) {
            if (c0455a2.m1129a() == i) {
                return c0455a2;
            }
        }
        return c0455a;
    }

    public int m1129a() {
        return this.f816o;
    }

    public C0536d m1130a(String str) {
        return new C0536d(this, str);
    }

    public String m1131b() {
        return this.f817p;
    }

    boolean m1132c() {
        return this.f818q;
    }
}
