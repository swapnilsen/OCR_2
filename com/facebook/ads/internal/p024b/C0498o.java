package com.facebook.ads.internal.p024b;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import com.facebook.ads.C0439c;
import com.facebook.ads.internal.p021m.C0689j;
import com.facebook.ads.internal.p021m.C0690e;
import com.facebook.ads.internal.p021m.C0702o;
import com.facebook.ads.internal.p025h.C0492s;
import com.facebook.ads.internal.p025h.C0578f;
import com.facebook.ads.internal.view.C0827j;
import com.facebook.ads.internal.view.p038c.p039a.C0738a;
import com.facebook.ads.internal.view.p038c.p039a.C0739b;
import com.facebook.ads.internal.view.p038c.p039a.C0741d;
import com.facebook.ads.internal.view.p038c.p039a.C0749l;
import com.facebook.ads.internal.view.p038c.p042b.C0764l;
import com.facebook.ads.internal.view.p038c.p042b.C0766a;
import com.facebook.ads.internal.view.p038c.p042b.C0771b;
import com.facebook.ads.internal.view.p038c.p042b.C0773c;
import com.facebook.ads.internal.view.p038c.p042b.C0783d;
import com.facebook.ads.internal.view.p038c.p042b.C0783d.C0782a;
import com.facebook.ads.internal.view.p038c.p042b.C0785e;
import com.facebook.ads.internal.view.p038c.p042b.C0792g;
import com.facebook.ads.internal.view.p038c.p042b.C0797i;
import com.facebook.ads.internal.view.p038c.p042b.C0802j;
import com.facebook.ads.p022a.C0431a;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.internal.b.o */
public class C0498o extends C0497x {
    static final /* synthetic */ boolean f930d;
    @Nullable
    protected C0827j f931a;
    @Nullable
    protected JSONObject f932b;
    @Nullable
    protected Context f933c;
    private final C0492s<C0739b> f934e;
    private final C0492s<C0749l> f935f;
    private final C0492s<C0741d> f936g;
    private final C0492s<C0738a> f937h;
    @Nullable
    private C0431a f938i;
    @Nullable
    private C0578f f939j;
    @Nullable
    private String f940k;
    private boolean f941l;
    @Nullable
    private String f942m;
    @Nullable
    private String f943n;
    @Nullable
    private String f944o;
    @Nullable
    private C0689j f945p;
    @Nullable
    private String f946q;

    /* renamed from: com.facebook.ads.internal.b.o.1 */
    class C04931 extends C0492s<C0739b> {
        final /* synthetic */ C0498o f926a;

        C04931(C0498o c0498o) {
            this.f926a = c0498o;
        }

        public Class<C0739b> m1325a() {
            return C0739b.class;
        }

        public void m1327a(C0739b c0739b) {
            if (this.f926a.f938i != null) {
                this.f926a.f938i.m1038d(this.f926a);
            }
        }
    }

    /* renamed from: com.facebook.ads.internal.b.o.2 */
    class C04942 extends C0492s<C0749l> {
        final /* synthetic */ C0498o f927a;

        C04942(C0498o c0498o) {
            this.f927a = c0498o;
        }

        public Class<C0749l> m1328a() {
            return C0749l.class;
        }

        public void m1330a(C0749l c0749l) {
            if (this.f927a.f938i != null) {
                this.f927a.f941l = true;
                this.f927a.f938i.m1033a(this.f927a);
            }
        }
    }

    /* renamed from: com.facebook.ads.internal.b.o.3 */
    class C04953 extends C0492s<C0741d> {
        final /* synthetic */ C0498o f928a;

        C04953(C0498o c0498o) {
            this.f928a = c0498o;
        }

        public Class<C0741d> m1331a() {
            return C0741d.class;
        }

        public void m1333a(C0741d c0741d) {
            if (this.f928a.f938i != null) {
                this.f928a.f938i.m1035a(this.f928a, C0439c.f740e);
            }
        }
    }

    /* renamed from: com.facebook.ads.internal.b.o.4 */
    class C04964 extends C0492s<C0738a> {
        final /* synthetic */ C0498o f929a;

        C04964(C0498o c0498o) {
            this.f929a = c0498o;
        }

        public Class<C0738a> m1334a() {
            return C0738a.class;
        }

        public void m1336a(C0738a c0738a) {
            if (this.f929a.f938i != null) {
                this.f929a.f938i.m1036b(this.f929a);
            }
            if (this.f929a.f939j == null) {
                return;
            }
            if (this.f929a.f946q != null) {
                this.f929a.f939j.m1791c(this.f929a.f946q, new HashMap());
            } else {
                this.f929a.f939j.m1787a(C0702o.BILLABLE_CLICK.m2273a(this.f929a.f944o));
            }
        }
    }

    static {
        f930d = !C0498o.class.desiredAssertionStatus();
    }

    public C0498o() {
        this.f934e = new C04931(this);
        this.f935f = new C04942(this);
        this.f936g = new C04953(this);
        this.f937h = new C04964(this);
        this.f941l = false;
    }

    private void m1341a(Context context, C0431a c0431a, JSONObject jSONObject, C0578f c0578f, @Nullable Bundle bundle) {
        this.f933c = context;
        this.f938i = c0431a;
        this.f939j = c0578f;
        this.f932b = jSONObject;
        this.f941l = false;
        JSONObject jSONObject2 = jSONObject.getJSONObject("video");
        JSONObject jSONObject3 = jSONObject.getJSONObject("trackers");
        this.f946q = jSONObject.optString("ct");
        this.f940k = jSONObject2.getString("videoURL");
        this.f942m = jSONObject3.getString("nativeImpression");
        this.f943n = jSONObject3.getString("impression");
        this.f944o = jSONObject3.getString(Promotion.ACTION_CLICK);
        this.f931a = new C0827j(context);
        m1348c();
        this.f931a.getEventBus().m1846a(this.f934e);
        this.f931a.getEventBus().m1846a(this.f936g);
        this.f931a.getEventBus().m1846a(this.f935f);
        this.f931a.getEventBus().m1846a(this.f937h);
        if (bundle != null) {
            this.f945p = new C0690e(context, c0578f, this.f931a, jSONObject3.getString("video"), this.f946q, bundle.getBundle("logger"));
        } else {
            this.f945p = new C0690e(context, c0578f, this.f931a, jSONObject3.getString("video"), this.f946q);
        }
        this.f938i.m1034a((C0497x) this, this.f931a);
        this.f931a.setVideoURI(this.f940k);
    }

    public final void m1346a(Context context, C0431a c0431a, Map<String, Object> map, C0578f c0578f) {
        try {
            m1341a(context, c0431a, (JSONObject) map.get("data"), c0578f, null);
        } catch (JSONException e) {
            c0431a.m1035a((C0497x) this, C0439c.f740e);
        }
    }

    public void m1347b() {
        if (this.f931a != null) {
            this.f931a.m2556g();
        }
        this.f938i = null;
        this.f939j = null;
        this.f940k = null;
        this.f941l = false;
        this.f942m = null;
        this.f943n = null;
        this.f944o = null;
        this.f931a = null;
        this.f945p = null;
        this.f932b = null;
        this.f933c = null;
    }

    protected void m1348c() {
        if (!f930d && this.f933c == null) {
            throw new AssertionError();
        } else if (f930d || this.f932b != null) {
            JSONObject jSONObject = this.f932b.getJSONObject("video");
            JSONObject optJSONObject = this.f932b.optJSONObject("text");
            if (optJSONObject == null) {
                optJSONObject = new JSONObject();
            }
            this.f931a.m2548a(new C0797i(this.f933c));
            C0764l c0802j = new C0802j(this.f933c);
            this.f931a.m2548a(c0802j);
            this.f931a.m2548a(new C0783d(c0802j, C0782a.INVSIBLE));
            this.f931a.m2548a(new C0771b(this.f933c));
            String d = m1349d();
            if (d != null) {
                C0764l c0773c = new C0773c(this.f933c, d);
                LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(12);
                layoutParams.addRule(9);
                c0773c.setLayoutParams(layoutParams);
                this.f931a.m2548a(c0773c);
            }
            if (jSONObject.has("destinationURL") && !jSONObject.isNull("destinationURL")) {
                Object string = jSONObject.getString("destinationURL");
                if (!TextUtils.isEmpty(string)) {
                    c0802j = new C0785e(this.f933c, string, this.f946q, optJSONObject.optString("learnMore", "Learn More"));
                    LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams2.addRule(10);
                    layoutParams2.addRule(11);
                    c0802j.setLayoutParams(layoutParams2);
                    this.f931a.m2548a(c0802j);
                }
            }
            this.f931a.m2548a(new C0766a(this.f933c, "http://m.facebook.com/ads/ad_choices", FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING, new float[]{0.0f, 0.0f, 8.0f, 0.0f}));
            int e = m1350e();
            if (e > 0) {
                c0802j = new C0792g(this.f933c, e, optJSONObject.optString("skipAdIn", "Skip Ad in"), optJSONObject.optString("skipAd", "Skip Ad"));
                LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams3.addRule(12);
                layoutParams3.addRule(11);
                c0802j.setLayoutParams(layoutParams3);
                c0802j.setPadding(0, 0, 0, 30);
                this.f931a.m2548a(c0802j);
            }
        } else {
            throw new AssertionError();
        }
    }

    protected String m1349d() {
        String str = null;
        if (f930d || this.f932b != null) {
            try {
                JSONObject jSONObject = this.f932b.getJSONObject("capabilities");
                if (jSONObject.has("countdown") && !jSONObject.isNull("countdown")) {
                    jSONObject = jSONObject.getJSONObject("countdown");
                    if (jSONObject.has("format")) {
                        str = jSONObject.optString("format");
                    }
                }
            } catch (Throwable e) {
                Log.w(String.valueOf(C0498o.class), "Invalid JSON", e);
            }
            return str;
        }
        throw new AssertionError();
    }

    protected int m1350e() {
        int i = -1;
        if (f930d || this.f932b != null) {
            try {
                JSONObject jSONObject = this.f932b.getJSONObject("capabilities");
                if (jSONObject.has("skipButton") && !jSONObject.isNull("skipButton")) {
                    jSONObject = jSONObject.getJSONObject("skipButton");
                    if (jSONObject.has("skippableSeconds")) {
                        i = jSONObject.getInt("skippableSeconds");
                    }
                }
            } catch (Throwable e) {
                Log.w(String.valueOf(C0498o.class), "Invalid JSON", e);
            }
            return i;
        }
        throw new AssertionError();
    }

    public boolean m1351f() {
        if (!this.f941l || this.f931a == null) {
            return false;
        }
        if (this.f945p.m2245k() > 0) {
            this.f931a.m2546a(this.f945p.m2245k());
            this.f931a.m2553d();
        } else {
            this.f931a.m2553d();
            m1352g();
        }
        return true;
    }

    protected void m1352g() {
        if (this.f939j != null) {
            if (this.f946q != null) {
                this.f939j.m1790b(this.f946q, new HashMap());
            } else {
                this.f939j.m1787a(this.f942m);
                this.f939j.m1787a(this.f943n);
            }
            if (this.f938i != null) {
                this.f938i.m1037c(this);
            }
        }
    }
}
