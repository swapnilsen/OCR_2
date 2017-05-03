package com.facebook.ads.internal.p021m;

import java.util.HashMap;
import java.util.Map;

/* renamed from: com.facebook.ads.internal.m.aa */
public class aa {
    private final String f1563a;
    private final String f1564b;
    private final String f1565c;

    public aa(String str, String str2) {
        this(str, str2, false);
    }

    public aa(String str, String str2, boolean z) {
        this.f1563a = str;
        this.f1564b = str2;
        this.f1565c = z ? "1" : "0";
    }

    public Map<String, String> m2131a() {
        Map<String, String> hashMap = new HashMap();
        hashMap.put("stacktrace", this.f1563a);
        hashMap.put("app_crashed_version", this.f1564b);
        hashMap.put("caught_exception", this.f1565c);
        return hashMap;
    }
}
