package com.facebook.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v4.view.PointerIconCompat;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.facebook.ads.C0871o.C0870a;
import com.facebook.ads.internal.C0443c;
import com.facebook.ads.internal.C0521b;
import com.facebook.ads.internal.C0536d;
import com.facebook.ads.internal.C0539e;
import com.facebook.ads.internal.C0565g;
import com.facebook.ads.internal.C0649j;
import com.facebook.ads.internal.p021m.C0693h;
import com.facebook.ads.internal.p021m.C0699k;
import com.facebook.ads.internal.p021m.C0705p;
import com.facebook.ads.internal.p021m.C0705p.C0704b;
import com.facebook.ads.internal.p021m.C0706q;
import com.facebook.ads.internal.p021m.C0712u;
import com.facebook.ads.internal.p021m.ad;
import com.facebook.ads.internal.p024b.C0471a;
import com.facebook.ads.internal.p024b.C0476h;
import com.facebook.ads.internal.p024b.aa;
import com.facebook.ads.internal.p024b.ab;
import com.facebook.ads.internal.p024b.ac;
import com.facebook.ads.internal.p026d.C0509a;
import com.facebook.ads.internal.p026d.C0532b;
import com.facebook.ads.internal.p027l.C0656a;
import com.facebook.ads.internal.p031g.C0558e;
import com.facebook.ads.internal.p037k.C0652a;
import com.facebook.ads.internal.p037k.C0652a.C0650a;
import com.facebook.ads.internal.view.C0827j;
import com.facebook.ads.internal.view.C0850m;
import com.facebook.ads.internal.view.C0851n;
import com.facebook.ads.internal.view.hscroll.C0834b;
import com.google.android.gms.plus.PlusShare;
import com.google.firebase.analytics.FirebaseAnalytics.Param;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.WeakHashMap;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.n */
public class C0869n implements C0432a {
    private static final C0539e f2159b;
    private static final String f2160c;
    private static WeakHashMap<View, WeakReference<C0869n>> f2161d;
    private long f2162A;
    private String f2163B;
    private boolean f2164C;
    @Nullable
    protected ab f2165a;
    private final Context f2166e;
    private final String f2167f;
    private final String f2168g;
    private final C0532b f2169h;
    private C0440d f2170i;
    private C0446h f2171j;
    private C0521b f2172k;
    private volatile boolean f2173l;
    private C0558e f2174m;
    private View f2175n;
    private final List<View> f2176o;
    private OnTouchListener f2177p;
    private C0652a f2178q;
    private final C0693h f2179r;
    @Nullable
    private aa f2180s;
    private C0867d f2181t;
    private C0868e f2182u;
    private C0851n f2183v;
    private C0870a f2184w;
    private boolean f2185x;
    private C0854l f2186y;
    @Deprecated
    private boolean f2187z;

    /* renamed from: com.facebook.ads.n.1 */
    class C08581 extends C0443c {
        final /* synthetic */ EnumSet f2129a;
        final /* synthetic */ C0869n f2130b;

        /* renamed from: com.facebook.ads.n.1.1 */
        class C08561 implements C0509a {
            final /* synthetic */ ab f2126a;
            final /* synthetic */ C08581 f2127b;

            C08561(C08581 c08581, ab abVar) {
                this.f2127b = c08581;
                this.f2126a = abVar;
            }

            public void m2646a() {
                this.f2127b.f2130b.f2165a = this.f2126a;
                this.f2127b.f2130b.m2678E();
                this.f2127b.f2130b.m2679F();
                if (this.f2127b.f2130b.f2170i != null) {
                    this.f2127b.f2130b.f2170i.m1049a(this.f2127b.f2130b);
                }
            }
        }

        /* renamed from: com.facebook.ads.n.1.2 */
        class C08572 implements ac {
            final /* synthetic */ C08581 f2128a;

            C08572(C08581 c08581) {
                this.f2128a = c08581;
            }

            public void m2647a(ab abVar) {
            }

            public void m2648a(ab abVar, C0439c c0439c) {
            }

            public void m2649b(ab abVar) {
            }

            public void m2650c(ab abVar) {
                if (this.f2128a.f2130b.f2170i != null) {
                    this.f2128a.f2130b.f2170i.m1051b(this.f2128a.f2130b);
                }
            }
        }

        C08581(C0869n c0869n, EnumSet enumSet) {
            this.f2130b = c0869n;
            this.f2129a = enumSet;
        }

        public void m2651a() {
            if (this.f2130b.f2170i != null) {
                this.f2130b.f2170i.m1051b(this.f2130b);
            }
        }

        public void m2652a(C0471a c0471a) {
            if (this.f2130b.f2172k != null) {
                this.f2130b.f2172k.m1604c();
            }
        }

        public void m2653a(ab abVar) {
            C0706q.m2279a(C0705p.m2275a(C0704b.LOADING_AD, C0656a.NATIVE, System.currentTimeMillis() - this.f2130b.f2162A, null));
            if (abVar != null) {
                if (this.f2129a.contains(C0865b.ICON) && abVar.m1217l() != null) {
                    this.f2130b.f2169h.m1646a(abVar.m1217l().m2665a());
                }
                if (this.f2129a.contains(C0865b.IMAGE)) {
                    if (abVar.m1218m() != null) {
                        this.f2130b.f2169h.m1646a(abVar.m1218m().m2665a());
                    }
                    if (abVar.m1199B() != null) {
                        for (C0869n c0869n : abVar.m1199B()) {
                            if (c0869n.m2718f() != null) {
                                this.f2130b.f2169h.m1646a(c0869n.m2718f().m2665a());
                            }
                        }
                    }
                }
                if (this.f2129a.contains(C0865b.VIDEO) && !TextUtils.isEmpty(abVar.m1229x())) {
                    this.f2130b.f2169h.m1647b(abVar.m1229x());
                }
                this.f2130b.f2169h.m1645a(new C08561(this, abVar));
                if (this.f2130b.f2170i != null && abVar.m1199B() != null) {
                    ac c08572 = new C08572(this);
                    for (C0869n c0869n2 : abVar.m1199B()) {
                        c0869n2.m2710a(c08572);
                    }
                }
            }
        }

        public void m2654a(C0536d c0536d) {
            if (this.f2130b.f2170i != null) {
                this.f2130b.f2170i.m1050a(this.f2130b, c0536d.m1661b());
            }
        }

        public void m2655b() {
            throw new IllegalStateException("Native ads manager their own impressions.");
        }
    }

    /* renamed from: com.facebook.ads.n.2 */
    class C08592 implements C0850m {
        final /* synthetic */ C0869n f2131a;

        C08592(C0869n c0869n) {
            this.f2131a = c0869n;
        }

        public void m2656a(int i) {
            if (this.f2131a.f2165a != null) {
                this.f2131a.f2165a.m1202a(i);
            }
        }
    }

    /* renamed from: com.facebook.ads.n.3 */
    class C08603 extends C0650a {
        final /* synthetic */ C0869n f2132a;

        C08603(C0869n c0869n) {
            this.f2132a = c0869n;
        }

        public void m2657a() {
            this.f2132a.f2179r.m2253a();
            this.f2132a.f2178q.m2091b();
            if (this.f2132a.f2180s != null) {
                this.f2132a.f2180s.m1191a(this.f2132a.f2175n);
                this.f2132a.f2180s.m1192a(this.f2132a.f2184w);
                this.f2132a.f2180s.m1195a(this.f2132a.f2185x);
                this.f2132a.f2180s.m1196b(this.f2132a.f2186y != null);
                this.f2132a.f2180s.m1197c(this.f2132a.m2676C());
                this.f2132a.f2180s.m1186a();
            } else if (this.f2132a.f2178q != null) {
                this.f2132a.f2178q.m2091b();
                this.f2132a.f2178q = null;
            }
        }
    }

    /* renamed from: com.facebook.ads.n.4 */
    class C08614 extends C0476h {
        final /* synthetic */ C0869n f2133a;

        C08614(C0869n c0869n) {
            this.f2133a = c0869n;
        }

        public boolean m2658a() {
            return true;
        }
    }

    /* renamed from: com.facebook.ads.n.f */
    private class C0862f extends C0476h {
        final /* synthetic */ C0869n f2134b;

        private C0862f(C0869n c0869n) {
            this.f2134b = c0869n;
        }

        public boolean m2659a() {
            return false;
        }

        public void m2660d() {
            if (this.f2134b.f2171j != null) {
                this.f2134b.f2171j.m1089a(this.f2134b);
            }
            if ((this.f2134b.f2170i instanceof C0446h) && this.f2134b.f2170i != this.f2134b.f2171j) {
                ((C0446h) this.f2134b.f2170i).m1089a(this.f2134b);
            }
        }

        public void m2661e() {
        }
    }

    /* renamed from: com.facebook.ads.n.5 */
    class C08635 extends C0862f {
        final /* synthetic */ C0869n f2135a;

        C08635(C0869n c0869n) {
            this.f2135a = c0869n;
            super(null);
        }

        public boolean m2662b() {
            return true;
        }

        public String m2663c() {
            return this.f2135a.f2163B;
        }
    }

    /* renamed from: com.facebook.ads.n.a */
    public static class C0864a {
        private final String f2136a;
        private final int f2137b;
        private final int f2138c;

        public C0864a(String str, int i, int i2) {
            this.f2136a = str;
            this.f2137b = i;
            this.f2138c = i2;
        }

        public static C0864a m2664a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            String optString = jSONObject.optString(PlusShare.KEY_CALL_TO_ACTION_URL);
            return optString != null ? new C0864a(optString, jSONObject.optInt("width", 0), jSONObject.optInt("height", 0)) : null;
        }

        public String m2665a() {
            return this.f2136a;
        }

        public int m2666b() {
            return this.f2137b;
        }

        public int m2667c() {
            return this.f2138c;
        }
    }

    /* renamed from: com.facebook.ads.n.b */
    public enum C0865b {
        NONE(0),
        ICON(1),
        IMAGE(2),
        VIDEO(3);
        
        public static final EnumSet<C0865b> f2143e;
        private final long f2145f;

        static {
            f2143e = EnumSet.allOf(C0865b.class);
        }

        private C0865b(long j) {
            this.f2145f = j;
        }
    }

    /* renamed from: com.facebook.ads.n.c */
    public static class C0866c {
        private final double f2146a;
        private final double f2147b;

        public C0866c(double d, double d2) {
            this.f2146a = d;
            this.f2147b = d2;
        }

        public static C0866c m2668a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            double optDouble = jSONObject.optDouble(Param.VALUE, 0.0d);
            double optDouble2 = jSONObject.optDouble("scale", 0.0d);
            return (optDouble == 0.0d || optDouble2 == 0.0d) ? null : new C0866c(optDouble, optDouble2);
        }

        public double m2669a() {
            return this.f2146a;
        }

        public double m2670b() {
            return this.f2147b;
        }
    }

    /* renamed from: com.facebook.ads.n.d */
    private class C0867d implements OnClickListener, OnTouchListener {
        final /* synthetic */ C0869n f2148a;
        private int f2149b;
        private int f2150c;
        private int f2151d;
        private int f2152e;
        private float f2153f;
        private float f2154g;
        private int f2155h;
        private int f2156i;

        private C0867d(C0869n c0869n) {
            this.f2148a = c0869n;
        }

        private Map<String, String> m2671a() {
            Map<String, String> hashMap = new HashMap();
            hashMap.put("clickX", String.valueOf(this.f2149b));
            hashMap.put("clickY", String.valueOf(this.f2150c));
            hashMap.put("width", String.valueOf(this.f2151d));
            hashMap.put("height", String.valueOf(this.f2152e));
            hashMap.put("adPositionX", String.valueOf(this.f2153f));
            hashMap.put("adPositionY", String.valueOf(this.f2154g));
            hashMap.put("visibleWidth", String.valueOf(this.f2156i));
            hashMap.put("visibleHeight", String.valueOf(this.f2155h));
            return hashMap;
        }

        public void onClick(View view) {
            if (!this.f2148a.f2179r.m2258d()) {
                Log.e("FBAudienceNetworkLog", "No touch data recorded, please ensure touch events reach the ad View by returning false if you intercept the event.");
            }
            int h = C0649j.m2058h(this.f2148a.f2166e);
            if (h < 0 || this.f2148a.f2179r.m2257c() >= ((long) h)) {
                if ((view instanceof C0438b) || !this.f2148a.f2179r.m2255a(C0649j.m2059i(this.f2148a.f2166e))) {
                    Map a = TextUtils.isEmpty(this.f2148a.m2735w()) ? m2671a() : this.f2148a.f2179r.m2259e();
                    Map hashMap = new HashMap();
                    hashMap.put("touch", C0712u.m2299a(a));
                    if (this.f2148a.f2184w != null) {
                        hashMap.put("nti", String.valueOf(this.f2148a.f2184w.m2737a()));
                    }
                    if (this.f2148a.f2185x) {
                        hashMap.put("nhs", String.valueOf(this.f2148a.f2185x));
                    }
                    this.f2148a.f2178q.m2090a(hashMap);
                    this.f2148a.f2165a.m1207b(hashMap);
                    return;
                }
                Log.e("FBAudienceNetworkLog", "Clicks are too close to the border of the view.");
            } else if (this.f2148a.f2179r.m2256b()) {
                Log.e("FBAudienceNetworkLog", "Clicks happened too fast.");
            } else {
                Log.e("FBAudienceNetworkLog", "Ad cannot be clicked before it is viewed.");
            }
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            this.f2148a.f2179r.m2254a(motionEvent, this.f2148a.f2175n, view);
            if (motionEvent.getAction() == 0 && this.f2148a.f2175n != null && TextUtils.isEmpty(this.f2148a.m2735w())) {
                this.f2151d = this.f2148a.f2175n.getWidth();
                this.f2152e = this.f2148a.f2175n.getHeight();
                int[] iArr = new int[2];
                this.f2148a.f2175n.getLocationInWindow(iArr);
                this.f2153f = (float) iArr[0];
                this.f2154g = (float) iArr[1];
                Rect rect = new Rect();
                this.f2148a.f2175n.getGlobalVisibleRect(rect);
                this.f2156i = rect.width();
                this.f2155h = rect.height();
                int[] iArr2 = new int[2];
                view.getLocationInWindow(iArr2);
                this.f2149b = (((int) motionEvent.getX()) + iArr2[0]) - iArr[0];
                this.f2150c = (iArr2[1] + ((int) motionEvent.getY())) - iArr[1];
            }
            return this.f2148a.f2177p != null && this.f2148a.f2177p.onTouch(view, motionEvent);
        }
    }

    /* renamed from: com.facebook.ads.n.e */
    private class C0868e extends BroadcastReceiver {
        final /* synthetic */ C0869n f2157a;
        private boolean f2158b;

        private C0868e(C0869n c0869n) {
            this.f2157a = c0869n;
        }

        public void m2672a() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.facebook.ads.native.impression:" + this.f2157a.f2168g);
            intentFilter.addAction("com.facebook.ads.native.click:" + this.f2157a.f2168g);
            LocalBroadcastManager.getInstance(this.f2157a.f2166e).registerReceiver(this, intentFilter);
            this.f2158b = true;
        }

        public void m2673b() {
            if (this.f2158b) {
                try {
                    LocalBroadcastManager.getInstance(this.f2157a.f2166e).unregisterReceiver(this);
                } catch (Exception e) {
                }
            }
        }

        public void onReceive(Context context, Intent intent) {
            Object obj = intent.getAction().split(":")[0];
            if ("com.facebook.ads.native.impression".equals(obj) && this.f2157a.f2180s != null) {
                this.f2157a.f2180s.m1186a();
            } else if ("com.facebook.ads.native.click".equals(obj) && this.f2157a.f2165a != null) {
                Map hashMap = new HashMap();
                hashMap.put("mil", String.valueOf(true));
                this.f2157a.f2165a.m1207b(hashMap);
            }
        }
    }

    static {
        f2159b = C0539e.ADS;
        f2160c = C0869n.class.getSimpleName();
        f2161d = new WeakHashMap();
    }

    public C0869n(Context context, ab abVar, C0558e c0558e) {
        this(context, null);
        this.f2174m = c0558e;
        this.f2173l = true;
        this.f2165a = abVar;
    }

    public C0869n(Context context, String str) {
        this.f2168g = UUID.randomUUID().toString();
        this.f2176o = new ArrayList();
        this.f2179r = new C0693h();
        this.f2164C = false;
        this.f2166e = context;
        this.f2167f = str;
        this.f2169h = new C0532b(context);
    }

    private int m2674A() {
        return this.f2174m != null ? this.f2174m.m1729g() : this.f2165a != null ? this.f2165a.m1215j() : (this.f2172k == null || this.f2172k.m1599a() == null) ? 0 : this.f2172k.m1599a().m1729g();
    }

    private int m2675B() {
        return this.f2174m != null ? this.f2174m.m1730h() : this.f2165a != null ? this.f2165a.m1216k() : (this.f2172k == null || this.f2172k.m1599a() == null) ? PointerIconCompat.TYPE_DEFAULT : this.f2172k.m1599a().m1730h();
    }

    private boolean m2676C() {
        return m2733u() == C0699k.UNKNOWN ? this.f2187z : m2733u() == C0699k.ON;
    }

    private void m2677D() {
        for (View view : this.f2176o) {
            view.setOnClickListener(null);
            view.setOnTouchListener(null);
        }
        this.f2176o.clear();
    }

    private void m2678E() {
        if (this.f2165a != null && this.f2165a.m1210e()) {
            this.f2182u = new C0868e();
            this.f2182u.m2672a();
            this.f2180s = new aa(this.f2166e, new C08614(this), this.f2178q, this.f2165a);
        }
    }

    private void m2679F() {
        if (this.f2164C) {
            this.f2180s = new aa(this.f2166e, new C08635(this), this.f2178q, this.f2165a);
        }
    }

    public static void m2682a(C0864a c0864a, ImageView imageView) {
        if (c0864a != null && imageView != null) {
            new ad(imageView).m2145a(c0864a.m2665a());
        }
    }

    private void m2683a(List<View> list, View view) {
        if (!(view instanceof C0827j) && !(view instanceof C0438b) && !(view instanceof C0834b)) {
            list.add(view);
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i = 0; i < viewGroup.getChildCount(); i++) {
                    m2683a((List) list, viewGroup.getChildAt(i));
                }
            }
        }
    }

    private void m2685b(View view) {
        this.f2176o.add(view);
        view.setOnClickListener(this.f2181t);
        view.setOnTouchListener(this.f2181t);
    }

    private int m2703y() {
        return this.f2174m != null ? this.f2174m.m1727e() : (this.f2172k == null || this.f2172k.m1599a() == null) ? 1 : this.f2172k.m1599a().m1727e();
    }

    private int m2704z() {
        return this.f2174m != null ? this.f2174m.m1728f() : (this.f2172k == null || this.f2172k.m1599a() == null) ? 0 : this.f2172k.m1599a().m1728f();
    }

    ab m2705a() {
        return this.f2165a;
    }

    public void m2706a(View view) {
        List arrayList = new ArrayList();
        m2683a(arrayList, view);
        m2707a(view, arrayList);
    }

    public void m2707a(View view, List<View> list) {
        if (view == null) {
            throw new IllegalArgumentException("Must provide a View");
        } else if (list == null || list.size() == 0) {
            throw new IllegalArgumentException("Invalid set of clickable views");
        } else if (m2716d()) {
            if (this.f2175n != null) {
                Log.w(f2160c, "Native Ad was already registered with a View. Auto unregistering and proceeding.");
                m2736x();
            }
            if (f2161d.containsKey(view)) {
                Log.w(f2160c, "View already registered with a NativeAd. Auto unregistering and proceeding.");
                ((C0869n) ((WeakReference) f2161d.get(view)).get()).m2736x();
            }
            this.f2181t = new C0867d();
            this.f2175n = view;
            if (view instanceof ViewGroup) {
                this.f2183v = new C0851n(view.getContext(), new C08592(this));
                ((ViewGroup) view).addView(this.f2183v);
            }
            for (View b : list) {
                m2685b(b);
            }
            this.f2165a.m1204a(view, list);
            this.f2178q = new C0652a(this.f2175n, m2703y(), m2704z(), true, new C08603(this));
            this.f2178q.m2089a(m2674A());
            this.f2178q.m2092b(m2675B());
            this.f2178q.m2088a();
            this.f2180s = new aa(this.f2166e, new C0862f(), this.f2178q, this.f2165a);
            this.f2180s.m1193a((List) list);
            f2161d.put(view, new WeakReference(this));
        } else {
            Log.e(f2160c, "Ad not loaded");
        }
    }

    public void m2708a(C0440d c0440d) {
        this.f2170i = c0440d;
    }

    @Deprecated
    public void m2709a(C0446h c0446h) {
        this.f2171j = c0446h;
    }

    protected void m2710a(ac acVar) {
        this.f2165a.m1205a(acVar);
    }

    void m2711a(C0854l c0854l) {
        this.f2186y = c0854l;
    }

    public void m2712a(EnumSet<C0865b> enumSet) {
        if (this.f2173l) {
            throw new IllegalStateException("loadAd cannot be called more than once");
        }
        this.f2162A = System.currentTimeMillis();
        this.f2173l = true;
        this.f2172k = new C0521b(this.f2166e, this.f2167f, C0565g.NATIVE_UNKNOWN, C0656a.NATIVE, null, f2159b, 1, true);
        this.f2172k.m1600a(new C08581(this, enumSet));
        this.f2172k.m1603b();
    }

    @Deprecated
    public void m2713a(boolean z) {
        this.f2187z = z;
    }

    public void m2714b() {
        m2712a(EnumSet.of(C0865b.NONE));
    }

    public void m2715c() {
        if (this.f2182u != null) {
            this.f2182u.m2673b();
            this.f2182u = null;
        }
        if (this.f2172k != null) {
            this.f2172k.m1605d();
            this.f2172k = null;
        }
        if (this.f2186y != null) {
            this.f2186y.m2637a();
            this.f2186y = null;
        }
    }

    public boolean m2716d() {
        return this.f2165a != null && this.f2165a.m1209d();
    }

    public C0864a m2717e() {
        return !m2716d() ? null : this.f2165a.m1217l();
    }

    public C0864a m2718f() {
        return !m2716d() ? null : this.f2165a.m1218m();
    }

    public C0872p m2719g() {
        return !m2716d() ? null : this.f2165a.m1219n();
    }

    public String m2720h() {
        return !m2716d() ? null : this.f2165a.m1220o();
    }

    public String m2721i() {
        return !m2716d() ? null : this.f2165a.m1221p();
    }

    public String m2722j() {
        return !m2716d() ? null : this.f2165a.m1222q();
    }

    public String m2723k() {
        return !m2716d() ? null : this.f2165a.m1223r();
    }

    public String m2724l() {
        return !m2716d() ? null : this.f2165a.m1224s();
    }

    @Deprecated
    public C0866c m2725m() {
        return !m2716d() ? null : this.f2165a.m1225t();
    }

    public String m2726n() {
        return !m2716d() ? null : this.f2168g;
    }

    public C0864a m2727o() {
        return !m2716d() ? null : this.f2165a.m1226u();
    }

    public String m2728p() {
        return !m2716d() ? null : this.f2165a.m1227v();
    }

    String m2729q() {
        return !m2716d() ? null : this.f2165a.m1228w();
    }

    String m2730r() {
        return (!m2716d() || TextUtils.isEmpty(this.f2165a.m1229x())) ? null : this.f2169h.m1648c(this.f2165a.m1229x());
    }

    String m2731s() {
        return !m2716d() ? null : this.f2165a.m1230y();
    }

    String m2732t() {
        return !m2716d() ? null : this.f2165a.m1198A();
    }

    C0699k m2733u() {
        return !m2716d() ? C0699k.UNKNOWN : this.f2165a.m1231z();
    }

    List<C0869n> m2734v() {
        return !m2716d() ? null : this.f2165a.m1199B();
    }

    @Nullable
    String m2735w() {
        return !m2716d() ? null : this.f2165a.m1200C();
    }

    public void m2736x() {
        if (this.f2175n != null) {
            if (f2161d.containsKey(this.f2175n) && ((WeakReference) f2161d.get(this.f2175n)).get() == this) {
                if ((this.f2175n instanceof ViewGroup) && this.f2183v != null) {
                    ((ViewGroup) this.f2175n).removeView(this.f2183v);
                    this.f2183v = null;
                }
                if (this.f2165a != null) {
                    this.f2165a.m1208c();
                }
                f2161d.remove(this.f2175n);
                m2677D();
                this.f2175n = null;
                if (this.f2178q != null) {
                    this.f2178q.m2091b();
                    this.f2178q = null;
                }
                this.f2180s = null;
                return;
            }
            throw new IllegalStateException("View not registered with this NativeAd");
        }
    }
}
