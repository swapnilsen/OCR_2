package com.facebook.ads.internal.p024b;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.view.PointerIconCompat;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.facebook.ads.C0439c;
import com.facebook.ads.C0869n;
import com.facebook.ads.C0869n.C0864a;
import com.facebook.ads.C0869n.C0866c;
import com.facebook.ads.C0872p;
import com.facebook.ads.internal.C0649j;
import com.facebook.ads.internal.p021m.C0699k;
import com.facebook.ads.internal.p021m.C0701n;
import com.facebook.ads.internal.p021m.C0705p;
import com.facebook.ads.internal.p021m.C0705p.C0703a;
import com.facebook.ads.internal.p021m.C0706q;
import com.facebook.ads.internal.p021m.C0709s;
import com.facebook.ads.internal.p021m.C0710t;
import com.facebook.ads.internal.p021m.C0710t.C0507a;
import com.facebook.ads.internal.p021m.C0712u;
import com.facebook.ads.internal.p023a.C0449a;
import com.facebook.ads.internal.p023a.C0450b;
import com.facebook.ads.internal.p025h.C0578f;
import com.google.ads.mediation.facebook.FacebookAdapter;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.google.android.gms.plus.PlusShare;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.internal.b.r */
public class C0508r extends ab implements C0507a {
    private static final String f988a;
    private String f989A;
    private String f990B;
    private C0699k f991C;
    private String f992D;
    private C0864a f993E;
    private String f994F;
    private String f995G;
    private C0872p f996H;
    private List<C0869n> f997I;
    private int f998J;
    private int f999K;
    private String f1000L;
    private boolean f1001M;
    private boolean f1002N;
    private boolean f1003O;
    private boolean f1004P;
    private boolean f1005Q;
    private long f1006R;
    private C0703a f1007S;
    @Nullable
    private C0578f f1008T;
    private Context f1009b;
    private ac f1010c;
    private Uri f1011d;
    private String f1012e;
    private String f1013f;
    private String f1014g;
    private String f1015h;
    private String f1016i;
    private C0864a f1017j;
    private C0864a f1018k;
    private C0866c f1019l;
    private String f1020m;
    private String f1021n;
    private String f1022o;
    private String f1023p;
    private C0709s f1024q;
    private String f1025r;
    private Collection<String> f1026s;
    private boolean f1027t;
    private boolean f1028u;
    private boolean f1029v;
    private int f1030w;
    private int f1031x;
    private int f1032y;
    private int f1033z;

    /* renamed from: com.facebook.ads.internal.b.r.1 */
    class C05061 implements Runnable {
        final /* synthetic */ Map f985a;
        final /* synthetic */ Map f986b;
        final /* synthetic */ C0508r f987c;

        C05061(C0508r c0508r, Map map, Map map2) {
            this.f987c = c0508r;
            this.f985a = map;
            this.f986b = map2;
        }

        public void run() {
            if (!TextUtils.isEmpty(this.f987c.f1000L)) {
                Map hashMap = new HashMap();
                hashMap.putAll(this.f985a);
                hashMap.putAll(this.f986b);
                if (this.f987c.f1008T != null) {
                    this.f987c.f1008T.m1793e(this.f987c.f1000L, hashMap);
                }
            } else if (this.f987c.f1008T != null) {
                this.f987c.f1008T.m1789a(this.f987c.f1021n, this.f985a, this.f986b);
            }
        }
    }

    static {
        f988a = C0508r.class.getSimpleName();
    }

    public C0508r() {
        this.f1006R = 0;
        this.f1007S = null;
    }

    private boolean m1402G() {
        return this.f1012e != null && this.f1012e.length() > 0 && this.f1015h != null && this.f1015h.length() > 0 && ((this.f1017j != null || this.f1001M) && this.f1018k != null);
    }

    private void m1403H() {
        if (!this.f1005Q) {
            if (this.f1008T != null) {
                this.f1008T.m1787a(this.f1023p);
            }
            this.f1005Q = true;
        }
    }

    private void m1405a(Context context, JSONObject jSONObject, String str, int i, int i2) {
        this.f1001M = true;
        this.f1009b = context;
        this.f998J = i;
        this.f999K = i2;
        m1407a(jSONObject, str);
    }

    private void m1406a(Map<String, String> map, Map<String, String> map2) {
        try {
            new Handler().postDelayed(new C05061(this, map2, m1410c((Map) map)), (long) (this.f1030w * PointerIconCompat.TYPE_DEFAULT));
        } catch (Exception e) {
        }
    }

    private void m1407a(JSONObject jSONObject, String str) {
        JSONArray jSONArray = null;
        int i = 0;
        if (this.f1002N) {
            throw new IllegalStateException("Adapter already loaded data");
        } else if (jSONObject != null) {
            C0712u.m2307a(this.f1009b, "Audience Network Loaded");
            this.f1000L = str;
            this.f1011d = Uri.parse(C0712u.m2300a(jSONObject, "fbad_command"));
            this.f1012e = C0712u.m2300a(jSONObject, PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE);
            this.f1013f = C0712u.m2300a(jSONObject, FacebookAdapter.KEY_SUBTITLE_ASSET);
            this.f1014g = C0712u.m2300a(jSONObject, "body");
            this.f1015h = C0712u.m2300a(jSONObject, "call_to_action");
            this.f1016i = C0712u.m2300a(jSONObject, FacebookAdapter.KEY_SOCIAL_CONTEXT_ASSET);
            this.f1017j = C0864a.m2664a(jSONObject.optJSONObject("icon"));
            this.f1018k = C0864a.m2664a(jSONObject.optJSONObject("image"));
            this.f1019l = C0866c.m2668a(jSONObject.optJSONObject("star_rating"));
            this.f1020m = C0712u.m2300a(jSONObject, "impression_report_url");
            this.f1021n = C0712u.m2300a(jSONObject, "native_view_report_url");
            this.f1022o = C0712u.m2300a(jSONObject, "click_report_url");
            this.f1023p = C0712u.m2300a(jSONObject, "used_report_url");
            this.f1027t = jSONObject.optBoolean("manual_imp");
            this.f1028u = jSONObject.optBoolean("enable_view_log");
            this.f1029v = jSONObject.optBoolean("enable_snapshot_log");
            this.f1030w = jSONObject.optInt("snapshot_log_delay_second", 4);
            this.f1031x = jSONObject.optInt("snapshot_compress_quality", 0);
            this.f1032y = jSONObject.optInt("viewability_check_initial_delay", 0);
            this.f1033z = jSONObject.optInt("viewability_check_interval", PointerIconCompat.TYPE_DEFAULT);
            JSONObject optJSONObject = jSONObject.optJSONObject("ad_choices_icon");
            JSONObject optJSONObject2 = jSONObject.optJSONObject("native_ui_config");
            this.f996H = optJSONObject2 == null ? null : new C0872p(optJSONObject2);
            if (optJSONObject != null) {
                this.f993E = C0864a.m2664a(optJSONObject);
            }
            this.f994F = C0712u.m2300a(jSONObject, "ad_choices_link_url");
            this.f995G = C0712u.m2300a(jSONObject, "request_id");
            this.f1024q = C0709s.m2287a(jSONObject.optString("invalidation_behavior"));
            this.f1025r = C0712u.m2300a(jSONObject, "invalidation_report_url");
            try {
                jSONArray = new JSONArray(jSONObject.optString("detection_strings"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            this.f1026s = C0710t.m2288a(jSONArray);
            this.f989A = C0712u.m2300a(jSONObject, "video_url");
            this.f990B = C0712u.m2300a(jSONObject, "video_mpd");
            if (jSONObject.has("video_autoplay_enabled")) {
                this.f991C = jSONObject.optBoolean("video_autoplay_enabled") ? C0699k.ON : C0699k.OFF;
            } else {
                this.f991C = C0699k.UNKNOWN;
            }
            this.f992D = C0712u.m2300a(jSONObject, "video_report_url");
            try {
                JSONArray optJSONArray = jSONObject.optJSONArray("carousel");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    int length = optJSONArray.length();
                    List arrayList = new ArrayList(length);
                    while (i < length) {
                        ab c0508r = new C0508r();
                        c0508r.m1405a(this.f1009b, optJSONArray.getJSONObject(i), str, i, length);
                        arrayList.add(new C0869n(this.f1009b, c0508r, null));
                        i++;
                    }
                    this.f997I = arrayList;
                }
            } catch (Throwable e2) {
                Log.e(f988a, "Unable to parse carousel data.", e2);
            }
            this.f1002N = true;
            this.f1003O = m1402G();
        }
    }

    private Map<String, String> m1410c(Map<String, String> map) {
        Map<String, String> hashMap = new HashMap();
        if (map.containsKey(Promotion.ACTION_VIEW)) {
            hashMap.put(Promotion.ACTION_VIEW, map.get(Promotion.ACTION_VIEW));
        }
        if (map.containsKey("snapshot")) {
            hashMap.put("snapshot", map.get("snapshot"));
        }
        return hashMap;
    }

    public String m1411A() {
        return this.f992D;
    }

    public List<C0869n> m1412B() {
        return !m1425d() ? null : this.f997I;
    }

    public String m1413C() {
        return this.f1000L;
    }

    public C0709s m1414D() {
        return this.f1024q;
    }

    public String m1415E() {
        return this.f1025r;
    }

    public Collection<String> m1416F() {
        return this.f1026s;
    }

    public void m1417a(int i) {
        if (m1425d() && i == 0 && this.f1006R > 0 && this.f1007S != null) {
            C0706q.m2279a(C0705p.m2274a(this.f1006R, this.f1007S, this.f995G));
            this.f1006R = 0;
            this.f1007S = null;
        }
    }

    public void m1418a(Context context, ac acVar, C0578f c0578f, Map<String, Object> map) {
        this.f1009b = context;
        this.f1010c = acVar;
        this.f1008T = c0578f;
        JSONObject jSONObject = (JSONObject) map.get("data");
        m1407a(jSONObject, C0712u.m2300a(jSONObject, "ct"));
        if (C0710t.m2289a(context, (C0507a) this)) {
            acVar.m1170a(this, C0439c.f737b);
            return;
        }
        if (acVar != null) {
            acVar.m1169a(this);
        }
        C0705p.f1723a = this.f995G;
    }

    public void m1419a(View view, List<View> list) {
    }

    public void m1420a(ac acVar) {
        this.f1010c = acVar;
    }

    public void m1421a(Map<String, String> map) {
        if (m1425d() && !this.f1004P) {
            if (this.f1010c != null) {
                this.f1010c.m1171b(this);
            }
            Map hashMap = new HashMap();
            if (map != null) {
                hashMap.putAll(map);
            }
            if (!TextUtils.isEmpty(m1413C())) {
                if (this.f1001M) {
                    hashMap.put("cardind", String.valueOf(this.f998J));
                    hashMap.put("cardcnt", String.valueOf(this.f999K));
                }
                if (this.f1008T != null) {
                    this.f1008T.m1790b(m1413C(), hashMap);
                }
            } else if (this.f1008T != null) {
                this.f1008T.m1787a(this.f1020m);
            }
            if (m1428g() || m1427f()) {
                m1406a((Map) map, hashMap);
            }
            this.f1004P = true;
        }
    }

    public void m1422b() {
    }

    public void m1423b(Map<String, String> map) {
        if (!m1425d()) {
            return;
        }
        if (C0649j.m2052b(this.f1009b) && C0701n.m2271b((Map) map)) {
            Log.e(f988a, "Click happened on lockscreen ad");
            return;
        }
        Map hashMap = new HashMap();
        if (map != null) {
            hashMap.putAll(map);
        }
        if (TextUtils.isEmpty(this.f1000L) && this.f1008T != null) {
            this.f1008T.m1788a(this.f1022o, hashMap);
        }
        C0712u.m2307a(this.f1009b, "Click logged");
        if (this.f1010c != null) {
            this.f1010c.m1172c(this);
        }
        if (this.f1001M) {
            hashMap.put("cardind", String.valueOf(this.f998J));
            hashMap.put("cardcnt", String.valueOf(this.f999K));
        }
        C0449a a = C0450b.m1111a(this.f1009b, this.f1000L, this.f1011d, hashMap);
        if (a != null) {
            try {
                this.f1006R = System.currentTimeMillis();
                this.f1007S = a.m1108a();
                a.m1110b();
            } catch (Throwable e) {
                Log.e(f988a, "Error executing action", e);
            }
        }
    }

    public void m1424c() {
    }

    public boolean m1425d() {
        return this.f1002N && this.f1003O;
    }

    public boolean m1426e() {
        return m1425d() && this.f1027t;
    }

    public boolean m1427f() {
        return m1425d() && this.f1029v;
    }

    public boolean m1428g() {
        return m1425d() && this.f1028u;
    }

    public boolean m1429h() {
        return true;
    }

    public int m1430i() {
        return (this.f1031x < 0 || this.f1031x > 100) ? 0 : this.f1031x;
    }

    public int m1431j() {
        return this.f1032y;
    }

    public int m1432k() {
        return this.f1033z;
    }

    public C0864a m1433l() {
        return !m1425d() ? null : this.f1017j;
    }

    public C0864a m1434m() {
        return !m1425d() ? null : this.f1018k;
    }

    public C0872p m1435n() {
        return !m1425d() ? null : this.f996H;
    }

    public String m1436o() {
        if (!m1425d()) {
            return null;
        }
        m1403H();
        return this.f1012e;
    }

    public String m1437p() {
        if (!m1425d()) {
            return null;
        }
        m1403H();
        return this.f1013f;
    }

    public String m1438q() {
        if (!m1425d()) {
            return null;
        }
        m1403H();
        return this.f1014g;
    }

    public String m1439r() {
        if (!m1425d()) {
            return null;
        }
        m1403H();
        return this.f1015h;
    }

    public String m1440s() {
        if (!m1425d()) {
            return null;
        }
        m1403H();
        return this.f1016i;
    }

    public C0866c m1441t() {
        if (!m1425d()) {
            return null;
        }
        m1403H();
        return this.f1019l;
    }

    public C0864a m1442u() {
        return !m1425d() ? null : this.f993E;
    }

    public String m1443v() {
        return !m1425d() ? null : this.f994F;
    }

    public String m1444w() {
        return !m1425d() ? null : "AdChoices";
    }

    public String m1445x() {
        return !m1425d() ? null : this.f989A;
    }

    public String m1446y() {
        return !m1425d() ? null : this.f990B;
    }

    public C0699k m1447z() {
        return !m1425d() ? C0699k.UNKNOWN : this.f991C;
    }
}
