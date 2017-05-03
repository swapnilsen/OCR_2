package com.facebook.ads.internal.p027l;

import android.content.Context;
import com.facebook.ads.internal.C0455a;
import com.facebook.ads.internal.C0536d;
import com.facebook.ads.internal.C0649j;
import com.facebook.ads.internal.p021m.C0675b;
import com.facebook.ads.internal.p021m.C0676c;
import com.facebook.ads.internal.p021m.C0708r;
import com.facebook.ads.internal.p021m.ak;
import com.facebook.ads.internal.p021m.ak.C0672a;
import com.facebook.ads.internal.p027l.C0664e.C0663a;
import com.facebook.ads.internal.p031g.C0557d;
import com.facebook.ads.internal.p031g.C0561f;
import com.facebook.ads.internal.p031g.C0564i;
import com.facebook.ads.internal.p033j.p034a.C0599a;
import com.facebook.ads.internal.p033j.p034a.C0600b;
import com.facebook.ads.internal.p033j.p034a.C0611m;
import com.facebook.ads.internal.p033j.p034a.C0612n;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import net.nend.android.NendIconError;
import org.json.JSONException;

/* renamed from: com.facebook.ads.internal.l.b */
public class C0660b {
    private static final C0676c f1543i;
    private static final ThreadPoolExecutor f1544j;
    Map<String, String> f1545a;
    private final Context f1546b;
    private final C0662d f1547c;
    private final C0649j f1548d;
    private C0520a f1549e;
    private C0561f f1550f;
    private C0599a f1551g;
    private final String f1552h;

    /* renamed from: com.facebook.ads.internal.l.b.a */
    public interface C0520a {
        void m1557a(C0536d c0536d);

        void m1558a(C0665f c0665f);
    }

    /* renamed from: com.facebook.ads.internal.l.b.1 */
    class C06571 implements Runnable {
        final /* synthetic */ C0561f f1539a;
        final /* synthetic */ C0660b f1540b;

        C06571(C0660b c0660b, C0561f c0561f) {
            this.f1540b = c0660b;
            this.f1539a = c0561f;
        }

        public void run() {
            C0564i.m1747b(this.f1540b.f1546b);
            this.f1540b.f1545a = this.f1539a.m1742e();
            try {
                this.f1540b.f1551g = ak.m2168b(this.f1540b.f1546b, this.f1539a.f1286e);
                this.f1540b.f1551g.m1885a(this.f1540b.f1552h, this.f1540b.f1551g.m1892b().m1928a(this.f1540b.f1545a), this.f1540b.m2111b());
            } catch (Exception e) {
                this.f1540b.m2106a(C0455a.AD_REQUEST_FAILED.m1130a(e.getMessage()));
            }
        }
    }

    /* renamed from: com.facebook.ads.internal.l.b.2 */
    class C06582 extends C0600b {
        final /* synthetic */ C0660b f1541a;

        C06582(C0660b c0660b) {
            this.f1541a = c0660b;
        }

        public void m2101a(C0611m c0611m) {
            C0708r.m2284b(this.f1541a.f1550f);
            this.f1541a.f1551g = null;
            try {
                C0612n a = c0611m.m1920a();
                if (a != null) {
                    String e = a.m1925e();
                    C0664e a2 = this.f1541a.f1547c.m2126a(e);
                    if (a2.m2127a() == C0663a.ERROR) {
                        C0666g c0666g = (C0666g) a2;
                        String c = c0666g.m2129c();
                        this.f1541a.m2106a(C0455a.m1128a(c0666g.m2130d(), C0455a.ERROR_MESSAGE).m1130a(c == null ? e : c));
                        return;
                    }
                }
            } catch (JSONException e2) {
            }
            this.f1541a.m2106a(new C0536d(C0455a.NETWORK_ERROR, c0611m.getMessage()));
        }

        public void m2102a(C0612n c0612n) {
            if (c0612n != null) {
                String e = c0612n.m1925e();
                C0708r.m2284b(this.f1541a.f1550f);
                this.f1541a.f1551g = null;
                this.f1541a.m2110a(e);
            }
        }

        public void m2103a(Exception exception) {
            if (C0611m.class.equals(exception.getClass())) {
                m2101a((C0611m) exception);
            } else {
                this.f1541a.m2106a(new C0536d(C0455a.NETWORK_ERROR, exception.getMessage()));
            }
        }
    }

    /* renamed from: com.facebook.ads.internal.l.b.3 */
    static /* synthetic */ class C06593 {
        static final /* synthetic */ int[] f1542a;

        static {
            f1542a = new int[C0663a.values().length];
            try {
                f1542a[C0663a.ADS.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f1542a[C0663a.ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    static {
        f1543i = new C0676c();
        f1544j = (ThreadPoolExecutor) Executors.newCachedThreadPool(f1543i);
    }

    public C0660b(Context context) {
        this.f1546b = context.getApplicationContext();
        this.f1547c = C0662d.m2122a();
        this.f1548d = new C0649j(this.f1546b);
        this.f1552h = C0661c.m2120a();
    }

    private void m2106a(C0536d c0536d) {
        if (this.f1549e != null) {
            this.f1549e.m1557a(c0536d);
        }
        m2117a();
    }

    private void m2109a(C0665f c0665f) {
        if (this.f1549e != null) {
            this.f1549e.m1558a(c0665f);
        }
        m2117a();
    }

    private void m2110a(String str) {
        try {
            C0664e a = this.f1547c.m2126a(str);
            C0557d b = a.m2128b();
            if (b != null) {
                this.f1548d.m2066a(b.m1720b());
                C0708r.m2281a(b.m1718a().m1725c(), this.f1550f);
            }
            switch (C06593.f1542a[a.m2127a().ordinal()]) {
                case NendIconError.ERROR_ICONVIEW /*1*/:
                    C0665f c0665f = (C0665f) a;
                    if (b != null && b.m1718a().m1726d()) {
                        C0708r.m2282a(str, this.f1550f);
                    }
                    m2109a(c0665f);
                    return;
                case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                    C0666g c0666g = (C0666g) a;
                    String c = c0666g.m2129c();
                    C0455a a2 = C0455a.m1128a(c0666g.m2130d(), C0455a.ERROR_MESSAGE);
                    if (c != null) {
                        str = c;
                    }
                    m2106a(a2.m1130a(str));
                    return;
                default:
                    m2106a(C0455a.UNKNOWN_RESPONSE.m1130a(str));
                    return;
            }
        } catch (Exception e) {
            m2106a(C0455a.PARSER_FAILURE.m1130a(e.getMessage()));
        }
        m2106a(C0455a.PARSER_FAILURE.m1130a(e.getMessage()));
    }

    private C0600b m2111b() {
        return new C06582(this);
    }

    public void m2117a() {
        if (this.f1551g != null) {
            this.f1551g.m1895c(1);
            this.f1551g.m1893b(1);
            this.f1551g = null;
        }
    }

    public void m2118a(C0561f c0561f) {
        m2117a();
        if (ak.m2169c(this.f1546b) == C0672a.NONE) {
            m2106a(new C0536d(C0455a.NETWORK_ERROR, "No network connection"));
            return;
        }
        this.f1550f = c0561f;
        C0675b.m2180a(this.f1546b);
        if (C0708r.m2283a(c0561f)) {
            String c = C0708r.m2285c(c0561f);
            if (c != null) {
                m2110a(c);
                return;
            } else {
                m2106a(C0455a.LOAD_TOO_FREQUENTLY.m1130a(null));
                return;
            }
        }
        f1544j.submit(new C06571(this, c0561f));
    }

    public void m2119a(C0520a c0520a) {
        this.f1549e = c0520a;
    }
}
