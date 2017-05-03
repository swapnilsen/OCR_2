package com.facebook.ads;

import android.support.v4.view.PointerIconCompat;
import android.text.TextUtils;

/* renamed from: com.facebook.ads.c */
public class C0439c {
    public static final C0439c f736a;
    public static final C0439c f737b;
    public static final C0439c f738c;
    public static final C0439c f739d;
    public static final C0439c f740e;
    public static final C0439c f741f;
    @Deprecated
    public static final C0439c f742g;
    private final int f743h;
    private final String f744i;

    static {
        f736a = new C0439c(PointerIconCompat.TYPE_DEFAULT, "Network Error");
        f737b = new C0439c(PointerIconCompat.TYPE_CONTEXT_MENU, "No Fill");
        f738c = new C0439c(PointerIconCompat.TYPE_HAND, "Ad was re-loaded too frequently");
        f739d = new C0439c(2000, "Server Error");
        f740e = new C0439c(2001, "Internal Error");
        f741f = new C0439c(3001, "Mediation Error");
        f742g = new C0439c(2002, "Native ad failed to load due to missing properties");
    }

    public C0439c(int i, String str) {
        if (TextUtils.isEmpty(str)) {
            str = "unknown error";
        }
        this.f743h = i;
        this.f744i = str;
    }

    public int m1047a() {
        return this.f743h;
    }

    public String m1048b() {
        return this.f744i;
    }
}
