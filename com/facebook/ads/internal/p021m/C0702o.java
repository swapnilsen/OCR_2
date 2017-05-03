package com.facebook.ads.internal.p021m;

/* renamed from: com.facebook.ads.internal.m.o */
public enum C0702o {
    BILLABLE_CLICK(0),
    CLICK_RESUME(8);
    
    int f1712c;

    private C0702o(int i) {
        this.f1712c = i;
    }

    public String m2273a(String str) {
        return str + "&action=" + this.f1712c;
    }
}
