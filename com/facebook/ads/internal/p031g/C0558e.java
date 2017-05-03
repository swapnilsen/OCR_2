package com.facebook.ads.internal.p031g;

import android.support.v4.view.PointerIconCompat;
import com.facebook.ads.internal.p027l.C0656a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.internal.g.e */
public class C0558e {
    private static final String f1262c;
    private static final C0656a f1263d;
    public int f1264a;
    public int f1265b;
    private C0656a f1266e;
    private int f1267f;
    private int f1268g;
    private int f1269h;
    private int f1270i;
    private int f1271j;
    private int f1272k;
    private int f1273l;
    private boolean f1274m;
    private List<C0554b> f1275n;

    static {
        f1262c = C0558e.class.getSimpleName();
        f1263d = C0656a.UNKNOWN;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private C0558e(java.util.Map<java.lang.String, java.lang.String> r11) {
        /*
        r10 = this;
        r4 = 1;
        r3 = -1;
        r2 = 0;
        r10.<init>();
        r10.f1264a = r3;
        r10.f1265b = r3;
        r0 = f1263d;
        r10.f1266e = r0;
        r10.f1267f = r4;
        r10.f1268g = r2;
        r10.f1269h = r2;
        r0 = 20;
        r10.f1270i = r0;
        r10.f1271j = r2;
        r0 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r10.f1272k = r0;
        r0 = 10000; // 0x2710 float:1.4013E-41 double:4.9407E-320;
        r10.f1273l = r0;
        r10.f1274m = r2;
        r0 = 0;
        r10.f1275n = r0;
        r0 = r11.entrySet();
        r5 = r0.iterator();
    L_0x002f:
        r0 = r5.hasNext();
        if (r0 == 0) goto L_0x01f5;
    L_0x0035:
        r0 = r5.next();
        r0 = (java.util.Map.Entry) r0;
        r1 = r0.getKey();
        r1 = (java.lang.String) r1;
        r6 = r1.hashCode();
        switch(r6) {
            case -1899431321: goto L_0x00cc;
            case -1561601017: goto L_0x0082;
            case -856794442: goto L_0x00b5;
            case -726276175: goto L_0x00c0;
            case -553208868: goto L_0x008c;
            case 3575610: goto L_0x005a;
            case 700812481: goto L_0x0064;
            case 858630459: goto L_0x006e;
            case 1085444827: goto L_0x0078;
            case 1183549815: goto L_0x00aa;
            case 1503616961: goto L_0x00a0;
            case 2002133996: goto L_0x0096;
            default: goto L_0x0048;
        };
    L_0x0048:
        r1 = r3;
    L_0x0049:
        switch(r1) {
            case 0: goto L_0x004d;
            case 1: goto L_0x00d8;
            case 2: goto L_0x00e6;
            case 3: goto L_0x00f4;
            case 4: goto L_0x0102;
            case 5: goto L_0x0110;
            case 6: goto L_0x0122;
            case 7: goto L_0x0130;
            case 8: goto L_0x013e;
            case 9: goto L_0x014c;
            case 10: goto L_0x015a;
            case 11: goto L_0x0168;
            default: goto L_0x004c;
        };
    L_0x004c:
        goto L_0x002f;
    L_0x004d:
        r0 = r0.getValue();
        r0 = (java.lang.String) r0;
        r0 = com.facebook.ads.internal.p027l.C0656a.m2100a(r0);
        r10.f1266e = r0;
        goto L_0x002f;
    L_0x005a:
        r6 = "type";
        r1 = r1.equals(r6);
        if (r1 == 0) goto L_0x0048;
    L_0x0062:
        r1 = r2;
        goto L_0x0049;
    L_0x0064:
        r6 = "min_viewability_percentage";
        r1 = r1.equals(r6);
        if (r1 == 0) goto L_0x0048;
    L_0x006c:
        r1 = r4;
        goto L_0x0049;
    L_0x006e:
        r6 = "viewability_check_ticker";
        r1 = r1.equals(r6);
        if (r1 == 0) goto L_0x0048;
    L_0x0076:
        r1 = 2;
        goto L_0x0049;
    L_0x0078:
        r6 = "refresh";
        r1 = r1.equals(r6);
        if (r1 == 0) goto L_0x0048;
    L_0x0080:
        r1 = 3;
        goto L_0x0049;
    L_0x0082:
        r6 = "refresh_threshold";
        r1 = r1.equals(r6);
        if (r1 == 0) goto L_0x0048;
    L_0x008a:
        r1 = 4;
        goto L_0x0049;
    L_0x008c:
        r6 = "cacheable";
        r1 = r1.equals(r6);
        if (r1 == 0) goto L_0x0048;
    L_0x0094:
        r1 = 5;
        goto L_0x0049;
    L_0x0096:
        r6 = "placement_width";
        r1 = r1.equals(r6);
        if (r1 == 0) goto L_0x0048;
    L_0x009e:
        r1 = 6;
        goto L_0x0049;
    L_0x00a0:
        r6 = "placement_height";
        r1 = r1.equals(r6);
        if (r1 == 0) goto L_0x0048;
    L_0x00a8:
        r1 = 7;
        goto L_0x0049;
    L_0x00aa:
        r6 = "viewability_check_initial_delay";
        r1 = r1.equals(r6);
        if (r1 == 0) goto L_0x0048;
    L_0x00b2:
        r1 = 8;
        goto L_0x0049;
    L_0x00b5:
        r6 = "viewability_check_interval";
        r1 = r1.equals(r6);
        if (r1 == 0) goto L_0x0048;
    L_0x00bd:
        r1 = 9;
        goto L_0x0049;
    L_0x00c0:
        r6 = "request_timeout";
        r1 = r1.equals(r6);
        if (r1 == 0) goto L_0x0048;
    L_0x00c8:
        r1 = 10;
        goto L_0x0049;
    L_0x00cc:
        r6 = "conv_tracking_data";
        r1 = r1.equals(r6);
        if (r1 == 0) goto L_0x0048;
    L_0x00d4:
        r1 = 11;
        goto L_0x0049;
    L_0x00d8:
        r0 = r0.getValue();
        r0 = (java.lang.String) r0;
        r0 = java.lang.Integer.parseInt(r0);
        r10.f1267f = r0;
        goto L_0x002f;
    L_0x00e6:
        r0 = r0.getValue();
        r0 = (java.lang.String) r0;
        r0 = java.lang.Integer.parseInt(r0);
        r10.f1268g = r0;
        goto L_0x002f;
    L_0x00f4:
        r0 = r0.getValue();
        r0 = (java.lang.String) r0;
        r0 = java.lang.Integer.parseInt(r0);
        r10.f1269h = r0;
        goto L_0x002f;
    L_0x0102:
        r0 = r0.getValue();
        r0 = (java.lang.String) r0;
        r0 = java.lang.Integer.parseInt(r0);
        r10.f1270i = r0;
        goto L_0x002f;
    L_0x0110:
        r0 = r0.getValue();
        r0 = (java.lang.String) r0;
        r0 = java.lang.Boolean.valueOf(r0);
        r0 = r0.booleanValue();
        r10.f1274m = r0;
        goto L_0x002f;
    L_0x0122:
        r0 = r0.getValue();
        r0 = (java.lang.String) r0;
        r0 = java.lang.Integer.parseInt(r0);
        r10.f1264a = r0;
        goto L_0x002f;
    L_0x0130:
        r0 = r0.getValue();
        r0 = (java.lang.String) r0;
        r0 = java.lang.Integer.parseInt(r0);
        r10.f1265b = r0;
        goto L_0x002f;
    L_0x013e:
        r0 = r0.getValue();
        r0 = (java.lang.String) r0;
        r0 = java.lang.Integer.parseInt(r0);
        r10.f1271j = r0;
        goto L_0x002f;
    L_0x014c:
        r0 = r0.getValue();
        r0 = (java.lang.String) r0;
        r0 = java.lang.Integer.parseInt(r0);
        r10.f1272k = r0;
        goto L_0x002f;
    L_0x015a:
        r0 = r0.getValue();
        r0 = (java.lang.String) r0;
        r0 = java.lang.Integer.parseInt(r0);
        r10.f1273l = r0;
        goto L_0x002f;
    L_0x0168:
        r0 = r0.getValue();
        r0 = (java.lang.String) r0;
        r0 = com.facebook.ads.internal.p031g.C0554b.m1714a(r0);
        r10.f1275n = r0;
        r1 = android.webkit.CookieManager.getInstance();	 Catch:{ Exception -> 0x01d9 }
        r6 = r1.acceptCookie();	 Catch:{ Exception -> 0x01d9 }
        r0 = 1;
        r1.setAcceptCookie(r0);	 Catch:{ Exception -> 0x01d9 }
        r0 = r10.f1275n;	 Catch:{ Exception -> 0x01d9 }
        r7 = r0.iterator();	 Catch:{ Exception -> 0x01d9 }
    L_0x0186:
        r0 = r7.hasNext();	 Catch:{ Exception -> 0x01d9 }
        if (r0 == 0) goto L_0x01e3;
    L_0x018c:
        r0 = r7.next();	 Catch:{ Exception -> 0x01d9 }
        r0 = (com.facebook.ads.internal.p031g.C0554b) r0;	 Catch:{ Exception -> 0x01d9 }
        r8 = r0.m1716b();	 Catch:{ Exception -> 0x01d9 }
        if (r8 == 0) goto L_0x0186;
    L_0x0198:
        r8 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x01d9 }
        r8.<init>();	 Catch:{ Exception -> 0x01d9 }
        r9 = r0.f1247b;	 Catch:{ Exception -> 0x01d9 }
        r8 = r8.append(r9);	 Catch:{ Exception -> 0x01d9 }
        r9 = "=";
        r8 = r8.append(r9);	 Catch:{ Exception -> 0x01d9 }
        r9 = r0.f1248c;	 Catch:{ Exception -> 0x01d9 }
        r8 = r8.append(r9);	 Catch:{ Exception -> 0x01d9 }
        r9 = ";Domain=";
        r8 = r8.append(r9);	 Catch:{ Exception -> 0x01d9 }
        r9 = r0.f1246a;	 Catch:{ Exception -> 0x01d9 }
        r8 = r8.append(r9);	 Catch:{ Exception -> 0x01d9 }
        r9 = ";Expires=";
        r8 = r8.append(r9);	 Catch:{ Exception -> 0x01d9 }
        r9 = r0.m1715a();	 Catch:{ Exception -> 0x01d9 }
        r8 = r8.append(r9);	 Catch:{ Exception -> 0x01d9 }
        r9 = ";path=/";
        r8 = r8.append(r9);	 Catch:{ Exception -> 0x01d9 }
        r8 = r8.toString();	 Catch:{ Exception -> 0x01d9 }
        r0 = r0.f1246a;	 Catch:{ Exception -> 0x01d9 }
        r1.setCookie(r0, r8);	 Catch:{ Exception -> 0x01d9 }
        goto L_0x0186;
    L_0x01d9:
        r0 = move-exception;
        r0 = f1262c;
        r1 = "Failed to set cookie.";
        android.util.Log.w(r0, r1);
        goto L_0x002f;
    L_0x01e3:
        r0 = android.os.Build.VERSION.SDK_INT;	 Catch:{ Exception -> 0x01d9 }
        r7 = 21;
        if (r0 >= r7) goto L_0x01f0;
    L_0x01e9:
        r0 = android.webkit.CookieSyncManager.getInstance();	 Catch:{ Exception -> 0x01d9 }
        r0.startSync();	 Catch:{ Exception -> 0x01d9 }
    L_0x01f0:
        r1.setAcceptCookie(r6);	 Catch:{ Exception -> 0x01d9 }
        goto L_0x002f;
    L_0x01f5:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.g.e.<init>(java.util.Map):void");
    }

    public static C0558e m1722a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        Iterator keys = jSONObject.keys();
        Map hashMap = new HashMap();
        while (keys.hasNext()) {
            String str = (String) keys.next();
            hashMap.put(str, String.valueOf(jSONObject.opt(str)));
        }
        return new C0558e(hashMap);
    }

    public C0656a m1723a() {
        return this.f1266e;
    }

    public long m1724b() {
        return (long) (this.f1269h * PointerIconCompat.TYPE_DEFAULT);
    }

    public long m1725c() {
        return (long) (this.f1270i * PointerIconCompat.TYPE_DEFAULT);
    }

    public boolean m1726d() {
        return this.f1274m;
    }

    public int m1727e() {
        return this.f1267f;
    }

    public int m1728f() {
        return this.f1268g;
    }

    public int m1729g() {
        return this.f1271j;
    }

    public int m1730h() {
        return this.f1272k;
    }

    public int m1731i() {
        return this.f1273l;
    }
}
