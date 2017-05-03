package com.facebook.ads.internal.p031g;

import android.content.Context;
import com.facebook.ads.C0441e;
import com.facebook.ads.C0442f;
import com.facebook.ads.internal.C0539e;
import com.facebook.ads.internal.C0552f;
import com.facebook.ads.internal.C0565g;
import com.facebook.ads.internal.p021m.C0701n;
import com.facebook.ads.internal.p021m.C0706q;
import com.facebook.ads.internal.p021m.C0712u;
import com.facebook.ads.internal.p021m.ac;
import com.facebook.ads.internal.p021m.ac.C0668a;
import com.facebook.ads.internal.p021m.ag;
import com.facebook.ads.internal.p021m.ak;
import com.facebook.ads.internal.p024b.C0484j;
import com.facebook.ads.internal.p027l.C0656a;
import com.google.firebase.messaging.SendException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import net.nend.android.NendIconError;
import p000a.p001a.p002a.p003a.p004a.p006b.AbstractSpiCall;

/* renamed from: com.facebook.ads.internal.g.f */
public class C0561f {
    private static final ExecutorService f1279g;
    private static String f1280h;
    private static C0668a f1281i;
    protected String f1282a;
    protected C0656a f1283b;
    protected C0556c f1284c;
    public Context f1285d;
    public C0565g f1286e;
    public boolean f1287f;
    private C0539e f1288j;
    private int f1289k;
    private C0442f f1290l;

    /* renamed from: com.facebook.ads.internal.g.f.1 */
    class C05591 implements Runnable {
        final /* synthetic */ Context f1276a;
        final /* synthetic */ C0561f f1277b;

        C05591(C0561f c0561f, Context context) {
            this.f1277b = c0561f;
            this.f1276a = context;
        }

        public void run() {
            if (C0561f.f1280h == null) {
                C0561f.f1280h = ag.m2148a(this.f1276a, this.f1276a.getPackageName());
            }
        }
    }

    /* renamed from: com.facebook.ads.internal.g.f.2 */
    static /* synthetic */ class C05602 {
        static final /* synthetic */ int[] f1278a;

        static {
            f1278a = new int[C0556c.values().length];
            try {
                f1278a[C0556c.INTERSTITIAL.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f1278a[C0556c.BANNER.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f1278a[C0556c.NATIVE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f1278a[C0556c.REWARDED_VIDEO.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    static {
        f1279g = Executors.newSingleThreadExecutor();
        f1280h = null;
        f1281i = ac.m2137a();
    }

    public C0561f(Context context, String str, C0442f c0442f, C0565g c0565g, C0539e c0539e, int i, boolean z) {
        this.f1282a = str;
        this.f1290l = c0442f;
        this.f1286e = c0565g;
        this.f1284c = C0556c.m1717a(c0565g);
        this.f1288j = c0539e;
        this.f1289k = i;
        this.f1287f = z;
        m1733a(context);
    }

    private void m1733a(Context context) {
        this.f1285d = context;
        C0562g.m1743a();
        C0564i.m1746a(context);
        m1737g();
        f1279g.submit(new C05591(this, context));
    }

    private void m1734a(Map<String, String> map, String str, String str2) {
        map.put(str, str2);
    }

    private static Map<String, String> m1735b(Context context) {
        Map<String, String> hashMap = new HashMap();
        hashMap.put("SDK", AbstractSpiCall.ANDROID_CLIENT_TYPE);
        hashMap.put("SDK_VERSION", "4.21.1");
        hashMap.put("LOCALE", Locale.getDefault().toString());
        float f = context.getResources().getDisplayMetrics().density;
        int i = context.getResources().getDisplayMetrics().widthPixels;
        int i2 = context.getResources().getDisplayMetrics().heightPixels;
        hashMap.put("DENSITY", String.valueOf(f));
        hashMap.put("SCREEN_WIDTH", String.valueOf((int) (((float) i) / f)));
        hashMap.put("SCREEN_HEIGHT", String.valueOf((int) (((float) i2) / f)));
        hashMap.put("IDFA", C0564i.f1313o);
        hashMap.put("IDFA_FLAG", C0564i.f1314p ? "0" : "1");
        hashMap.put("ATTRIBUTION_ID", C0564i.f1312n);
        hashMap.put("ID_SOURCE", C0564i.f1315q);
        hashMap.put("OS", "Android");
        hashMap.put("OSVERS", C0564i.f1299a);
        hashMap.put("BUNDLE", C0564i.f1302d);
        hashMap.put("APPNAME", C0564i.f1303e);
        hashMap.put("APPVERS", C0564i.f1304f);
        hashMap.put("APPBUILD", String.valueOf(C0564i.f1305g));
        hashMap.put("CARRIER", C0564i.f1307i);
        hashMap.put("MAKE", C0564i.f1300b);
        hashMap.put("MODEL", C0564i.f1301c);
        hashMap.put("ROOTED", String.valueOf(f1281i.f1572d));
        hashMap.put("COPPA", String.valueOf(C0441e.m1059e()));
        hashMap.put("INSTALLER", C0564i.f1306h);
        hashMap.put("SDK_CAPABILITY", C0552f.m1709b());
        hashMap.put("NETWORK_TYPE", String.valueOf(ak.m2169c(context).f1607g));
        hashMap.put("REQUEST_TIME", C0712u.m2297a(System.currentTimeMillis()));
        hashMap.put("SESSION_TIME", C0712u.m2296a(C0562g.m1744b()));
        hashMap.put("SESSION_ID", C0562g.m1745c());
        return hashMap;
    }

    private void m1737g() {
        if (this.f1284c == null) {
            this.f1284c = C0556c.UNKNOWN;
        }
        switch (C05602.f1278a[this.f1284c.ordinal()]) {
            case NendIconError.ERROR_ICONVIEW /*1*/:
                this.f1283b = C0656a.INTERSTITIAL;
            case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                this.f1283b = C0656a.BANNER;
            case SendException.ERROR_TTL_EXCEEDED /*3*/:
                this.f1283b = C0656a.NATIVE;
            case SendException.ERROR_TOO_MANY_MESSAGES /*4*/:
                this.f1283b = C0656a.REWARDED_VIDEO;
            default:
                this.f1283b = C0656a.UNKNOWN;
        }
    }

    public String m1738a() {
        return this.f1282a;
    }

    public C0556c m1739b() {
        return this.f1284c;
    }

    public C0442f m1740c() {
        return this.f1290l;
    }

    public int m1741d() {
        return this.f1289k;
    }

    public Map<String, String> m1742e() {
        Map<String, String> hashMap = new HashMap();
        m1734a(hashMap, "PLACEMENT_ID", this.f1282a);
        if (this.f1283b != C0656a.UNKNOWN) {
            m1734a(hashMap, "PLACEMENT_TYPE", this.f1283b.toString().toLowerCase());
        }
        for (Entry entry : C0561f.m1735b(this.f1285d).entrySet()) {
            m1734a(hashMap, (String) entry.getKey(), (String) entry.getValue());
        }
        if (this.f1290l != null) {
            m1734a(hashMap, "WIDTH", String.valueOf(this.f1290l.m1060a()));
            m1734a(hashMap, "HEIGHT", String.valueOf(this.f1290l.m1061b()));
        }
        m1734a(hashMap, "ADAPTERS", C0484j.m1297a(this.f1283b));
        if (this.f1286e != null) {
            m1734a(hashMap, "TEMPLATE_ID", String.valueOf(this.f1286e.m1750a()));
        }
        if (this.f1288j != null) {
            m1734a(hashMap, "REQUEST_TYPE", String.valueOf(this.f1288j.m1665a()));
        }
        if (this.f1287f) {
            m1734a(hashMap, "TEST_MODE", "1");
        }
        if (this.f1289k != 0) {
            m1734a(hashMap, "NUM_ADS_REQUESTED", String.valueOf(this.f1289k));
        }
        String d = C0441e.m1058d();
        if (d != null) {
            m1734a(hashMap, "MEDIATION_SERVICE", d);
        }
        m1734a(hashMap, "CLIENT_EVENTS", C0706q.m2278a());
        if (f1280h != null) {
            m1734a(hashMap, "AFP", f1280h);
        }
        m1734a(hashMap, "UNITY", String.valueOf(C0712u.m2309a(this.f1285d)));
        m1734a(hashMap, "KG_RESTRICTED", String.valueOf(C0701n.m2270b(this.f1285d)));
        return hashMap;
    }
}
