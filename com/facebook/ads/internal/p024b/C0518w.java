package com.facebook.ads.internal.p024b;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.facebook.ads.C0439c;
import com.facebook.ads.C0869n;
import com.facebook.ads.C0869n.C0864a;
import com.facebook.ads.C0869n.C0866c;
import com.facebook.ads.C0872p;
import com.facebook.ads.internal.p021m.C0699k;
import com.facebook.ads.internal.p021m.C0712u;
import com.facebook.ads.internal.p021m.aj;
import com.facebook.ads.internal.p025h.C0578f;
import com.inmobi.ads.InMobiNative;
import com.inmobi.ads.InMobiNative.NativeAdListener;
import com.inmobi.sdk.InMobiSdk;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.internal.b.w */
public class C0518w extends ab implements C0481z {
    private ac f1084a;
    private InMobiNative f1085b;
    private boolean f1086c;
    private View f1087d;
    private String f1088e;
    private String f1089f;
    private String f1090g;
    private C0864a f1091h;
    private C0864a f1092i;

    /* renamed from: com.facebook.ads.internal.b.w.1 */
    class C05171 implements NativeAdListener {
        final /* synthetic */ Context f1082a;
        final /* synthetic */ C0518w f1083b;

        C05171(C0518w c0518w, Context context) {
            this.f1083b = c0518w;
            this.f1082a = context;
        }
    }

    public String m1520A() {
        return null;
    }

    public List<C0869n> m1521B() {
        return null;
    }

    public String m1522C() {
        return null;
    }

    public C0485k m1523D() {
        return C0485k.INMOBI;
    }

    public void m1524a(int i) {
    }

    public void m1525a(Context context, ac acVar, C0578f c0578f, Map<String, Object> map) {
        C0712u.m2307a(context, aj.m2160a(m1523D()) + " Loading");
        JSONObject jSONObject = (JSONObject) map.get("data");
        Object optString = jSONObject.optString("account_id");
        Long valueOf = Long.valueOf(jSONObject.optLong("placement_id"));
        if (TextUtils.isEmpty(optString) || valueOf == null) {
            acVar.m1170a(this, C0439c.f741f);
            return;
        }
        this.f1084a = acVar;
        InMobiSdk.init(context, optString);
        this.f1085b = new InMobiNative(valueOf.longValue(), new C05171(this, context));
        this.f1085b.load();
    }

    public void m1526a(View view, List<View> list) {
        this.f1087d = view;
        if (m1532d()) {
            InMobiNative inMobiNative = this.f1085b;
            InMobiNative.bind(this.f1087d, this.f1085b);
        }
    }

    public void m1527a(ac acVar) {
        this.f1084a = acVar;
    }

    public void m1528a(Map<String, String> map) {
        this.f1084a.m1171b(this);
    }

    public void m1529b() {
        m1531c();
        this.f1085b = null;
        this.f1084a = null;
    }

    public void m1530b(Map<String, String> map) {
        if (m1532d()) {
            this.f1084a.m1172c(this);
            this.f1085b.reportAdClickAndOpenLandingPage(null);
        }
    }

    public void m1531c() {
        if (m1532d()) {
            InMobiNative inMobiNative = this.f1085b;
            InMobiNative.unbind(this.f1087d);
        }
        this.f1087d = null;
    }

    public boolean m1532d() {
        return this.f1085b != null && this.f1086c;
    }

    public boolean m1533e() {
        return false;
    }

    public boolean m1534f() {
        return false;
    }

    public boolean m1535g() {
        return false;
    }

    public boolean m1536h() {
        return true;
    }

    public int m1537i() {
        return 0;
    }

    public int m1538j() {
        return 0;
    }

    public int m1539k() {
        return 0;
    }

    public C0864a m1540l() {
        return this.f1091h;
    }

    public C0864a m1541m() {
        return this.f1092i;
    }

    public C0872p m1542n() {
        return null;
    }

    public String m1543o() {
        return this.f1088e;
    }

    public String m1544p() {
        return null;
    }

    public String m1545q() {
        return this.f1089f;
    }

    public String m1546r() {
        return this.f1090g;
    }

    public String m1547s() {
        return null;
    }

    public C0866c m1548t() {
        return null;
    }

    public C0864a m1549u() {
        return null;
    }

    public String m1550v() {
        return null;
    }

    public String m1551w() {
        return "Ad";
    }

    public String m1552x() {
        return null;
    }

    public String m1553y() {
        return null;
    }

    public C0699k m1554z() {
        return C0699k.UNKNOWN;
    }
}
