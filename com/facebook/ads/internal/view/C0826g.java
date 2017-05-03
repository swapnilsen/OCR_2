package com.facebook.ads.internal.view;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.RelativeLayout.LayoutParams;
import com.facebook.ads.AudienceNetworkActivity;
import com.facebook.ads.internal.p021m.C0705p;
import com.facebook.ads.internal.p021m.C0705p.C0703a;
import com.facebook.ads.internal.p021m.C0706q;
import com.facebook.ads.internal.p021m.C0712u;
import com.facebook.ads.internal.p021m.C0713v;
import com.facebook.ads.internal.p023a.C0449a;
import com.facebook.ads.internal.p023a.C0450b;
import com.facebook.ads.internal.p024b.C0476h;
import com.facebook.ads.internal.p024b.C0514u;
import com.facebook.ads.internal.p024b.C0516v;
import com.facebook.ads.internal.p025h.C0580g;
import com.facebook.ads.internal.view.C0504c.C0417a;
import com.facebook.ads.internal.view.C0737b.C0428b;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.facebook.ads.internal.view.g */
public class C0826g implements C0504c {
    private static final String f2018a;
    private final C0417a f2019b;
    private final C0737b f2020c;
    private final C0516v f2021d;
    private C0514u f2022e;
    private long f2023f;
    private long f2024g;
    private C0703a f2025h;

    /* renamed from: com.facebook.ads.internal.view.g.1 */
    class C08241 implements C0428b {
        final /* synthetic */ AudienceNetworkActivity f2015a;
        final /* synthetic */ C0826g f2016b;

        C08241(C0826g c0826g, AudienceNetworkActivity audienceNetworkActivity) {
            this.f2016b = c0826g;
            this.f2015a = audienceNetworkActivity;
        }

        public void m2525a() {
            this.f2016b.f2021d.m1518b();
        }

        public void m2526a(int i) {
        }

        public void m2527a(String str, Map<String, String> map) {
            Uri parse = Uri.parse(str);
            if ("fbad".equals(parse.getScheme()) && "close".equals(parse.getAuthority())) {
                this.f2015a.finish();
                return;
            }
            if ("fbad".equals(parse.getScheme()) && C0450b.m1112a(parse.getAuthority())) {
                this.f2016b.f2019b.m982a("com.facebook.ads.interstitial.clicked");
            }
            C0449a a = C0450b.m1111a(this.f2015a, this.f2016b.f2022e.m1498C(), parse, map);
            if (a != null) {
                try {
                    this.f2016b.f2025h = a.m1108a();
                    this.f2016b.f2024g = System.currentTimeMillis();
                    a.m1110b();
                } catch (Throwable e) {
                    Log.e(C0826g.f2018a, "Error executing action", e);
                }
            }
        }

        public void m2528b() {
            this.f2016b.f2021d.m1186a();
        }
    }

    /* renamed from: com.facebook.ads.internal.view.g.2 */
    class C08252 extends C0476h {
        final /* synthetic */ C0826g f2017a;

        C08252(C0826g c0826g) {
            this.f2017a = c0826g;
        }

        public void m2529d() {
            this.f2017a.f2019b.m982a("com.facebook.ads.interstitial.impression.logged");
        }
    }

    static {
        f2018a = C0826g.class.getSimpleName();
    }

    public C0826g(AudienceNetworkActivity audienceNetworkActivity, C0417a c0417a) {
        this.f2019b = c0417a;
        this.f2023f = System.currentTimeMillis();
        this.f2020c = new C0737b(audienceNetworkActivity, new C08241(this, audienceNetworkActivity), 1);
        this.f2020c.setLayoutParams(new LayoutParams(-1, -1));
        this.f2021d = new C0516v(audienceNetworkActivity, this.f2020c, this.f2020c.getViewabilityChecker(), new C08252(this));
        this.f2021d.m1519c();
        c0417a.m981a(this.f2020c);
    }

    public void m2536a(Intent intent, Bundle bundle, AudienceNetworkActivity audienceNetworkActivity) {
        if (bundle == null || !bundle.containsKey("dataModel")) {
            this.f2022e = C0514u.m1497b(intent);
            if (this.f2022e != null) {
                this.f2021d.m1516a(this.f2022e);
                this.f2020c.loadDataWithBaseURL(C0713v.m2314a(), this.f2022e.m1502a(), "text/html", "utf-8", null);
                this.f2020c.m2370a(this.f2022e.m1509g(), this.f2022e.m1510h());
                return;
            }
            return;
        }
        this.f2022e = C0514u.m1495a(bundle.getBundle("dataModel"));
        if (this.f2022e != null) {
            this.f2020c.loadDataWithBaseURL(C0713v.m2314a(), this.f2022e.m1502a(), "text/html", "utf-8", null);
            this.f2020c.m2370a(this.f2022e.m1509g(), this.f2022e.m1510h());
        }
    }

    public void m2537a(Bundle bundle) {
        if (this.f2022e != null) {
            bundle.putBundle("dataModel", this.f2022e.m1511i());
        }
    }

    public void m2538a(C0417a c0417a) {
    }

    public void m2539i() {
        this.f2020c.onPause();
    }

    public void m2540j() {
        if (!(this.f2024g <= 0 || this.f2025h == null || this.f2022e == null)) {
            C0706q.m2279a(C0705p.m2274a(this.f2024g, this.f2025h, this.f2022e.m1508f()));
        }
        this.f2020c.onResume();
    }

    public void m2541k() {
        if (this.f2022e != null) {
            C0706q.m2279a(C0705p.m2274a(this.f2023f, C0703a.XOUT, this.f2022e.m1508f()));
            if (!TextUtils.isEmpty(this.f2022e.m1498C())) {
                Map hashMap = new HashMap();
                this.f2020c.getViewabilityChecker().m2090a(hashMap);
                hashMap.put("touch", C0712u.m2299a(this.f2020c.getTouchData()));
                C0580g.m1799a(this.f2020c.getContext()).m1816f(this.f2022e.m1498C(), hashMap);
            }
        }
        C0713v.m2315a(this.f2020c);
        this.f2020c.destroy();
    }
}
