package com.facebook.ads.internal.p024b;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import com.facebook.ads.C0439c;
import com.facebook.ads.C0442f;
import com.facebook.ads.internal.p021m.C0705p;
import com.facebook.ads.internal.p021m.C0705p.C0703a;
import com.facebook.ads.internal.p021m.C0706q;
import com.facebook.ads.internal.p021m.C0710t;
import com.facebook.ads.internal.p021m.C0710t.C0507a;
import com.facebook.ads.internal.p021m.C0713v;
import com.facebook.ads.internal.p023a.C0449a;
import com.facebook.ads.internal.p023a.C0450b;
import com.facebook.ads.internal.p031g.C0558e;
import com.facebook.ads.internal.view.C0737b;
import com.facebook.ads.internal.view.C0737b.C0428b;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.internal.b.n */
public class C0491n extends C0473b {
    private static final String f918a;
    private C0737b f919b;
    private C0516v f920c;
    private C0456c f921d;
    private Map<String, Object> f922e;
    private Context f923f;
    private long f924g;
    private C0703a f925h;

    /* renamed from: com.facebook.ads.internal.b.n.1 */
    class C04891 implements C0428b {
        final /* synthetic */ C0514u f915a;
        final /* synthetic */ C0491n f916b;

        C04891(C0491n c0491n, C0514u c0514u) {
            this.f916b = c0491n;
            this.f915a = c0514u;
        }

        public void m1306a() {
            this.f916b.f920c.m1518b();
        }

        public void m1307a(int i) {
            if (i == 0 && this.f916b.f924g > 0 && this.f916b.f925h != null) {
                C0706q.m2279a(C0705p.m2274a(this.f916b.f924g, this.f916b.f925h, this.f915a.m1508f()));
                this.f916b.f924g = 0;
                this.f916b.f925h = null;
            }
        }

        public void m1308a(String str, Map<String, String> map) {
            Uri parse = Uri.parse(str);
            if ("fbad".equals(parse.getScheme()) && C0450b.m1112a(parse.getAuthority()) && this.f916b.f921d != null) {
                this.f916b.f921d.m1152b(this.f916b);
            }
            C0449a a = C0450b.m1111a(this.f916b.f923f, this.f915a.m1498C(), parse, map);
            if (a != null) {
                try {
                    this.f916b.f925h = a.m1108a();
                    this.f916b.f924g = System.currentTimeMillis();
                    a.m1110b();
                } catch (Throwable e) {
                    Log.e(C0491n.f918a, "Error executing action", e);
                }
            }
        }

        public void m1309b() {
            if (this.f916b.f920c != null) {
                this.f916b.f920c.m1186a();
            }
        }
    }

    /* renamed from: com.facebook.ads.internal.b.n.2 */
    class C04902 extends C0476h {
        final /* synthetic */ C0491n f917a;

        C04902(C0491n c0491n) {
            this.f917a = c0491n;
        }

        public void m1310d() {
            if (this.f917a.f921d != null) {
                this.f917a.f921d.m1149a(this.f917a);
            }
        }
    }

    static {
        f918a = C0491n.class.getSimpleName();
    }

    private void m1314a(C0558e c0558e) {
        this.f924g = 0;
        this.f925h = null;
        C0514u a = C0514u.m1496a((JSONObject) this.f922e.get("data"));
        if (C0710t.m2289a(this.f923f, (C0507a) a)) {
            this.f921d.m1151a((C0473b) this, C0439c.f737b);
            return;
        }
        this.f919b = new C0737b(this.f923f, new C04891(this, a), c0558e.m1727e());
        this.f919b.m2370a(c0558e.m1729g(), c0558e.m1730h());
        this.f920c = new C0516v(this.f923f, this.f919b, this.f919b.getViewabilityChecker(), new C04902(this));
        this.f920c.m1516a(a);
        this.f919b.loadDataWithBaseURL(C0713v.m2314a(), a.m1502a(), "text/html", "utf-8", null);
        if (this.f921d != null) {
            this.f921d.m1150a((C0473b) this, this.f919b);
        }
    }

    public void m1320a(Context context, C0442f c0442f, C0456c c0456c, Map<String, Object> map) {
        this.f923f = context;
        this.f921d = c0456c;
        this.f922e = map;
        m1314a((C0558e) map.get("definition"));
    }

    public void m1321b() {
        if (this.f919b != null) {
            C0713v.m2315a(this.f919b);
            this.f919b.destroy();
            this.f919b = null;
        }
    }
}
