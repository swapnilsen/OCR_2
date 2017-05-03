package com.facebook.ads.internal.p024b;

import com.facebook.ads.internal.p027l.C0656a;
import com.facebook.ads.internal.p032i.C0594a;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.facebook.ads.internal.b.l */
public enum C0486l {
    ANBANNER(C0491n.class, C0485k.AN, C0656a.BANNER),
    ANINTERSTITIAL(C0501p.class, C0485k.AN, C0656a.INTERSTITIAL),
    ADMOBNATIVE(C0482i.class, C0485k.ADMOB, C0656a.NATIVE),
    ANNATIVE(C0508r.class, C0485k.AN, C0656a.NATIVE),
    ANINSTREAMVIDEO(C0498o.class, C0485k.AN, C0656a.INSTREAM),
    ANREWARDEDVIDEO(C0511s.class, C0485k.AN, C0656a.REWARDED_VIDEO),
    INMOBINATIVE(C0518w.class, C0485k.INMOBI, C0656a.NATIVE),
    YAHOONATIVE(C0513t.class, C0485k.YAHOO, C0656a.NATIVE);
    
    private static List<C0486l> f903m;
    public Class<?> f905i;
    public String f906j;
    public C0485k f907k;
    public C0656a f908l;

    private C0486l(Class<?> cls, C0485k c0485k, C0656a c0656a) {
        this.f905i = cls;
        this.f907k = c0485k;
        this.f908l = c0656a;
    }

    public static List<C0486l> m1300a() {
        if (f903m == null) {
            synchronized (C0486l.class) {
                f903m = new ArrayList();
                f903m.add(ANBANNER);
                f903m.add(ANINTERSTITIAL);
                f903m.add(ANNATIVE);
                f903m.add(ANINSTREAMVIDEO);
                f903m.add(ANREWARDEDVIDEO);
                if (C0594a.m1855a(C0485k.YAHOO)) {
                    f903m.add(YAHOONATIVE);
                }
                if (C0594a.m1855a(C0485k.INMOBI)) {
                    f903m.add(INMOBINATIVE);
                }
                if (C0594a.m1855a(C0485k.ADMOB)) {
                    f903m.add(ADMOBNATIVE);
                }
            }
        }
        return f903m;
    }
}
