package com.facebook.ads.internal.p024b;

import android.content.Context;
import android.view.View;
import com.facebook.ads.C0869n;
import com.facebook.ads.C0869n.C0864a;
import com.facebook.ads.C0869n.C0866c;
import com.facebook.ads.C0872p;
import com.facebook.ads.internal.p021m.C0699k;
import com.facebook.ads.internal.p021m.C0712u;
import com.facebook.ads.internal.p021m.aj;
import com.facebook.ads.internal.p025h.C0578f;
import com.flurry.android.FlurryAgent;
import com.flurry.android.ads.FlurryAdNative;
import com.flurry.android.ads.FlurryAdNativeListener;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.internal.b.t */
public class C0513t extends ab implements C0481z {
    private static volatile boolean f1052a;
    private ac f1053b;
    private FlurryAdNative f1054c;
    private boolean f1055d;
    private String f1056e;
    private String f1057f;
    private String f1058g;
    private String f1059h;
    private String f1060i;
    private C0864a f1061j;
    private C0864a f1062k;
    private C0864a f1063l;

    /* renamed from: com.facebook.ads.internal.b.t.1 */
    class C05121 implements FlurryAdNativeListener {
        final /* synthetic */ Context f1050a;
        final /* synthetic */ C0513t f1051b;

        C05121(C0513t c0513t, Context context) {
            this.f1051b = c0513t;
            this.f1050a = context;
        }
    }

    public String m1460A() {
        return null;
    }

    public List<C0869n> m1461B() {
        return null;
    }

    public String m1462C() {
        return null;
    }

    public C0485k m1463D() {
        return C0485k.YAHOO;
    }

    public void m1464a(int i) {
    }

    public void m1465a(Context context, ac acVar, C0578f c0578f, Map<String, Object> map) {
        JSONObject jSONObject = (JSONObject) map.get("data");
        String optString = jSONObject.optString("api_key");
        String optString2 = jSONObject.optString("placement_id");
        synchronized (C0513t.class) {
            if (!f1052a) {
                C0712u.m2307a(context, aj.m2160a(m1463D()) + " Initializing");
                FlurryAgent.setLogEnabled(true);
                FlurryAgent.init(context, optString);
                f1052a = true;
            }
        }
        C0712u.m2307a(context, aj.m2160a(m1463D()) + " Loading");
        this.f1053b = acVar;
        this.f1054c = new FlurryAdNative(context, optString2);
        this.f1054c.setListener(new C05121(this, context));
        this.f1054c.fetchAd();
    }

    public void m1466a(View view, List<View> list) {
        if (this.f1054c != null) {
            this.f1054c.setTrackingView(view);
        }
    }

    public void m1467a(ac acVar) {
        this.f1053b = acVar;
    }

    public void m1468a(Map<String, String> map) {
    }

    public void m1469b() {
        m1471c();
        this.f1053b = null;
        if (this.f1054c != null) {
            this.f1054c.destroy();
            this.f1054c = null;
        }
    }

    public void m1470b(Map<String, String> map) {
    }

    public void m1471c() {
        if (this.f1054c != null) {
            this.f1054c.removeTrackingView();
        }
    }

    public boolean m1472d() {
        return this.f1055d;
    }

    public boolean m1473e() {
        return false;
    }

    public boolean m1474f() {
        return false;
    }

    public boolean m1475g() {
        return false;
    }

    public boolean m1476h() {
        return true;
    }

    public int m1477i() {
        return 0;
    }

    public int m1478j() {
        return 0;
    }

    public int m1479k() {
        return 0;
    }

    public C0864a m1480l() {
        return this.f1061j;
    }

    public C0864a m1481m() {
        return this.f1062k;
    }

    public C0872p m1482n() {
        return null;
    }

    public String m1483o() {
        return this.f1056e;
    }

    public String m1484p() {
        return this.f1058g;
    }

    public String m1485q() {
        return this.f1057f;
    }

    public String m1486r() {
        return this.f1059h;
    }

    public String m1487s() {
        return this.f1060i;
    }

    public C0866c m1488t() {
        return null;
    }

    public C0864a m1489u() {
        return this.f1063l;
    }

    public String m1490v() {
        return null;
    }

    public String m1491w() {
        return "Ad";
    }

    public String m1492x() {
        return null;
    }

    public String m1493y() {
        return null;
    }

    public C0699k m1494z() {
        return C0699k.UNKNOWN;
    }
}
