package com.facebook.ads.internal.p037k;

import java.util.HashMap;
import java.util.Map;

/* renamed from: com.facebook.ads.internal.k.b */
public class C0653b {
    private C0654c f1498a;
    private float f1499b;
    private Map<String, String> f1500c;

    public C0653b(C0654c c0654c) {
        this(c0654c, 0.0f);
    }

    public C0653b(C0654c c0654c, float f) {
        this(c0654c, f, null);
    }

    public C0653b(C0654c c0654c, float f, Map<String, String> map) {
        this.f1498a = c0654c;
        this.f1499b = f;
        if (map != null) {
            this.f1500c = map;
        } else {
            this.f1500c = new HashMap();
        }
    }

    public boolean m2093a() {
        return this.f1498a == C0654c.IS_VIEWABLE;
    }

    public int m2094b() {
        return this.f1498a.m2097a();
    }

    public float m2095c() {
        return this.f1499b;
    }

    public Map<String, String> m2096d() {
        return this.f1500c;
    }
}
