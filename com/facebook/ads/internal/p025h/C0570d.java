package com.facebook.ads.internal.p025h;

import android.content.Context;
import com.facebook.ads.internal.p021m.C0675b;
import com.facebook.ads.internal.p021m.C0712u;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.facebook.ads.internal.h.d */
public abstract class C0570d {
    protected final String f1341a;
    protected final double f1342b;
    protected final double f1343c;
    protected final String f1344d;
    protected final Map<String, String> f1345e;

    public C0570d(Context context, String str, double d, String str2, Map<String, String> map) {
        this.f1341a = str;
        this.f1342b = ((double) System.currentTimeMillis()) / 1000.0d;
        this.f1343c = d;
        this.f1344d = str2;
        Map hashMap = new HashMap();
        if (!(map == null || map.isEmpty())) {
            hashMap.putAll(map);
        }
        if (m1757c()) {
            hashMap.put("analog", C0712u.m2299a(C0675b.m2179a()));
        }
        this.f1345e = C0570d.m1754a(hashMap);
    }

    public C0570d(String str, double d, String str2, Map<String, String> map) {
        this(null, str, d, str2, map);
    }

    private static Map<String, String> m1754a(Map<String, String> map) {
        Map<String, String> hashMap = new HashMap();
        for (Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            String str2 = (String) entry.getValue();
            if (str2 != null) {
                hashMap.put(str, str2);
            }
        }
        return hashMap;
    }

    public abstract C0581h m1755a();

    public abstract String m1756b();

    public abstract boolean m1757c();

    public String m1758d() {
        return this.f1341a;
    }

    public double m1759e() {
        return this.f1342b;
    }

    public double m1760f() {
        return this.f1343c;
    }

    public String m1761g() {
        return this.f1344d;
    }

    public Map<String, String> m1762h() {
        return this.f1345e;
    }

    public final boolean m1763i() {
        return m1755a() == C0581h.IMMEDIATE;
    }
}
