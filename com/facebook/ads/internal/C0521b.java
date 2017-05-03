package com.facebook.ads.internal;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.view.PointerIconCompat;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.facebook.ads.C0439c;
import com.facebook.ads.C0441e;
import com.facebook.ads.C0442f;
import com.facebook.ads.internal.b.AnonymousClass11;
import com.facebook.ads.internal.b.AnonymousClass12;
import com.facebook.ads.internal.p021m.C0467m;
import com.facebook.ads.internal.p021m.C0705p;
import com.facebook.ads.internal.p021m.C0706q;
import com.facebook.ads.internal.p021m.C0712u;
import com.facebook.ads.internal.p021m.aj;
import com.facebook.ads.internal.p021m.al;
import com.facebook.ads.internal.p024b.C0456c;
import com.facebook.ads.internal.p024b.C0459e;
import com.facebook.ads.internal.p024b.C0471a;
import com.facebook.ads.internal.p024b.C0473b;
import com.facebook.ads.internal.p024b.C0474d;
import com.facebook.ads.internal.p024b.C0481z;
import com.facebook.ads.internal.p024b.C0484j;
import com.facebook.ads.internal.p024b.C0497x;
import com.facebook.ads.internal.p024b.ab;
import com.facebook.ads.internal.p024b.ac;
import com.facebook.ads.internal.p024b.ad;
import com.facebook.ads.internal.p024b.ae;
import com.facebook.ads.internal.p025h.C0578f;
import com.facebook.ads.internal.p025h.C0580g;
import com.facebook.ads.internal.p027l.C0656a;
import com.facebook.ads.internal.p027l.C0660b;
import com.facebook.ads.internal.p027l.C0660b.C0520a;
import com.facebook.ads.internal.p027l.C0665f;
import com.facebook.ads.internal.p029e.C0537a;
import com.facebook.ads.internal.p031g.C0553a;
import com.facebook.ads.internal.p031g.C0557d;
import com.facebook.ads.internal.p031g.C0558e;
import com.facebook.ads.internal.p031g.C0561f;
import com.facebook.ads.internal.p031g.C0563h;
import com.facebook.ads.internal.p037k.C0652a;
import com.facebook.ads.p022a.C0431a;
import com.google.android.gms.plus.model.people.Person.Urls.Type;
import com.google.firebase.messaging.SendException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.nend.android.NendIconError;

/* renamed from: com.facebook.ads.internal.b */
public class C0521b implements C0520a {
    private static final String f1097b;
    private static final Handler f1098h;
    private static boolean f1099i;
    protected C0443c f1100a;
    private final Context f1101c;
    private final String f1102d;
    private final C0656a f1103e;
    private final C0660b f1104f;
    private final Handler f1105g;
    private final Runnable f1106j;
    private final Runnable f1107k;
    private volatile boolean f1108l;
    private boolean f1109m;
    private volatile boolean f1110n;
    private C0471a f1111o;
    private C0471a f1112p;
    private View f1113q;
    private C0557d f1114r;
    private C0561f f1115s;
    private C0565g f1116t;
    private C0539e f1117u;
    private C0442f f1118v;
    private int f1119w;
    private final C0470c f1120x;
    private boolean f1121y;
    private final C0578f f1122z;

    /* renamed from: com.facebook.ads.internal.b.11 */
    class AnonymousClass11 implements Runnable {
        final /* synthetic */ C0473b f820a;
        final /* synthetic */ C0521b f821b;

        AnonymousClass11(C0521b c0521b, C0473b c0473b) {
            this.f821b = c0521b;
            this.f820a = c0473b;
        }

        public void run() {
            this.f821b.m1564a(this.f820a);
            this.f821b.m1589l();
        }
    }

    /* renamed from: com.facebook.ads.internal.b.12 */
    class AnonymousClass12 implements C0456c {
        final /* synthetic */ Runnable f822a;
        final /* synthetic */ C0521b f823b;

        AnonymousClass12(C0521b c0521b, Runnable runnable) {
            this.f823b = c0521b;
            this.f822a = runnable;
        }

        public void m1153a(C0473b c0473b) {
            this.f823b.f1100a.m1067b();
        }

        public void m1154a(C0473b c0473b, View view) {
            if (c0473b == this.f823b.f1111o) {
                this.f823b.f1105g.removeCallbacks(this.f822a);
                C0471a g = this.f823b.f1112p;
                this.f823b.f1112p = c0473b;
                this.f823b.f1113q = view;
                if (this.f823b.f1110n) {
                    this.f823b.f1100a.m1063a(view);
                    this.f823b.m1564a(g);
                    this.f823b.m1594n();
                    return;
                }
                this.f823b.f1100a.m1064a((C0471a) c0473b);
            }
        }

        public void m1155a(C0473b c0473b, C0439c c0439c) {
            if (c0473b == this.f823b.f1111o) {
                this.f823b.f1105g.removeCallbacks(this.f822a);
                this.f823b.m1564a((C0471a) c0473b);
                this.f823b.m1589l();
            }
        }

        public void m1156b(C0473b c0473b) {
            this.f823b.f1100a.m1062a();
        }
    }

    /* renamed from: com.facebook.ads.internal.b.1 */
    class C04571 implements Runnable {
        final /* synthetic */ C0665f f824a;
        final /* synthetic */ C0521b f825b;

        C04571(C0521b c0521b, C0665f c0665f) {
            this.f825b = c0521b;
            this.f824a = c0665f;
        }

        public void run() {
            C0557d b = this.f824a.m2128b();
            if (b == null || b.m1718a() == null) {
                throw new IllegalStateException("invalid placement in response");
            }
            this.f825b.f1114r = b;
            this.f825b.m1589l();
        }
    }

    /* renamed from: com.facebook.ads.internal.b.2 */
    class C04582 implements Runnable {
        final /* synthetic */ C0474d f826a;
        final /* synthetic */ C0521b f827b;

        C04582(C0521b c0521b, C0474d c0474d) {
            this.f827b = c0521b;
            this.f826a = c0474d;
        }

        public void run() {
            this.f827b.m1564a(this.f826a);
            this.f827b.m1589l();
        }
    }

    /* renamed from: com.facebook.ads.internal.b.3 */
    class C04603 implements C0459e {
        final /* synthetic */ Runnable f828a;
        final /* synthetic */ C0521b f829b;

        C04603(C0521b c0521b, Runnable runnable) {
            this.f829b = c0521b;
            this.f828a = runnable;
        }

        public void m1163a(C0474d c0474d) {
            if (c0474d == this.f829b.f1111o) {
                this.f829b.f1105g.removeCallbacks(this.f828a);
                this.f829b.f1112p = c0474d;
                this.f829b.f1100a.m1064a((C0471a) c0474d);
                this.f829b.m1594n();
            }
        }

        public void m1164a(C0474d c0474d, C0439c c0439c) {
            if (c0474d == this.f829b.f1111o) {
                this.f829b.f1105g.removeCallbacks(this.f828a);
                this.f829b.m1564a((C0471a) c0474d);
                this.f829b.m1589l();
                this.f829b.f1100a.m1066a(new C0536d(c0439c.m1047a(), c0439c.m1048b()));
            }
        }

        public void m1165a(C0474d c0474d, String str, boolean z) {
            this.f829b.f1100a.m1062a();
            Object obj = !TextUtils.isEmpty(str) ? 1 : null;
            if (z && obj != null) {
                Intent intent = new Intent("android.intent.action.VIEW");
                if (!(this.f829b.f1115s.f1285d instanceof Activity)) {
                    intent.addFlags(268435456);
                }
                intent.setData(Uri.parse(str));
                this.f829b.f1115s.f1285d.startActivity(intent);
            }
        }

        public void m1166b(C0474d c0474d) {
            this.f829b.f1100a.m1067b();
        }

        public void m1167c(C0474d c0474d) {
            this.f829b.f1100a.m1068c();
        }

        public void m1168d(C0474d c0474d) {
            this.f829b.f1100a.m1069d();
        }
    }

    /* renamed from: com.facebook.ads.internal.b.4 */
    class C04614 implements Runnable {
        final /* synthetic */ ab f830a;
        final /* synthetic */ long f831b;
        final /* synthetic */ C0553a f832c;
        final /* synthetic */ C0521b f833d;

        C04614(C0521b c0521b, ab abVar, long j, C0553a c0553a) {
            this.f833d = c0521b;
            this.f830a = abVar;
            this.f831b = j;
            this.f832c = c0553a;
        }

        public void run() {
            this.f833d.m1564a(this.f830a);
            if (this.f830a instanceof C0481z) {
                C0712u.m2307a(this.f833d.f1101c, aj.m2160a(((C0481z) this.f830a).m1248D()) + " Failed. Ad request timed out");
            }
            Map a = this.f833d.m1562a(this.f831b);
            a.put("error", "-1");
            a.put(NotificationCompatApi24.CATEGORY_MESSAGE, "timeout");
            this.f833d.m1572a(this.f832c.m1712a(C0563h.REQUEST), a);
            this.f833d.m1589l();
        }
    }

    /* renamed from: com.facebook.ads.internal.b.5 */
    class C04625 implements ac {
        boolean f834a;
        boolean f835b;
        boolean f836c;
        final /* synthetic */ Runnable f837d;
        final /* synthetic */ long f838e;
        final /* synthetic */ C0553a f839f;
        final /* synthetic */ C0521b f840g;

        C04625(C0521b c0521b, Runnable runnable, long j, C0553a c0553a) {
            this.f840g = c0521b;
            this.f837d = runnable;
            this.f838e = j;
            this.f839f = c0553a;
            this.f834a = false;
            this.f835b = false;
            this.f836c = false;
        }

        public void m1173a(ab abVar) {
            if (abVar == this.f840g.f1111o) {
                this.f840g.f1105g.removeCallbacks(this.f837d);
                this.f840g.f1112p = abVar;
                this.f840g.f1100a.m1064a((C0471a) abVar);
                if (!this.f834a) {
                    this.f834a = true;
                    this.f840g.m1572a(this.f839f.m1712a(C0563h.REQUEST), this.f840g.m1562a(this.f838e));
                }
            }
        }

        public void m1174a(ab abVar, C0439c c0439c) {
            if (abVar == this.f840g.f1111o) {
                this.f840g.f1105g.removeCallbacks(this.f837d);
                this.f840g.m1564a((C0471a) abVar);
                if (!this.f834a) {
                    this.f834a = true;
                    Map a = this.f840g.m1562a(this.f838e);
                    a.put("error", String.valueOf(c0439c.m1047a()));
                    a.put(NotificationCompatApi24.CATEGORY_MESSAGE, String.valueOf(c0439c.m1048b()));
                    this.f840g.m1572a(this.f839f.m1712a(C0563h.REQUEST), a);
                }
                this.f840g.m1589l();
            }
        }

        public void m1175b(ab abVar) {
            if (!this.f835b) {
                this.f835b = true;
                this.f840g.m1572a(this.f839f.m1712a(C0563h.IMPRESSION), null);
            }
        }

        public void m1176c(ab abVar) {
            if (!this.f836c) {
                this.f836c = true;
                this.f840g.m1572a(this.f839f.m1712a(C0563h.CLICK), null);
            }
            if (this.f840g.f1100a != null) {
                this.f840g.f1100a.m1062a();
            }
        }
    }

    /* renamed from: com.facebook.ads.internal.b.6 */
    class C04636 implements Runnable {
        final /* synthetic */ C0536d f841a;
        final /* synthetic */ C0521b f842b;

        C04636(C0521b c0521b, C0536d c0536d) {
            this.f842b = c0521b;
            this.f841a = c0536d;
        }

        public void run() {
            this.f842b.f1100a.m1066a(this.f841a);
            if (!this.f842b.f1109m && !this.f842b.f1108l) {
                switch (this.f841a.m1660a().m1129a()) {
                    case PointerIconCompat.TYPE_DEFAULT /*1000*/:
                    case PointerIconCompat.TYPE_HAND /*1002*/:
                        switch (C04647.f843a[this.f842b.m1586j().ordinal()]) {
                            case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                                this.f842b.f1105g.postDelayed(this.f842b.f1106j, 30000);
                                this.f842b.f1108l = true;
                            default:
                        }
                    default:
                }
            }
        }
    }

    /* renamed from: com.facebook.ads.internal.b.7 */
    static /* synthetic */ class C04647 {
        static final /* synthetic */ int[] f843a;

        static {
            f843a = new int[C0656a.values().length];
            try {
                f843a[C0656a.INTERSTITIAL.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f843a[C0656a.BANNER.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f843a[C0656a.NATIVE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f843a[C0656a.INSTREAM.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f843a[C0656a.REWARDED_VIDEO.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    /* renamed from: com.facebook.ads.internal.b.8 */
    class C04658 implements Runnable {
        final /* synthetic */ C0521b f844a;

        C04658(C0521b c0521b) {
            this.f844a = c0521b;
        }

        public void run() {
            try {
                this.f844a.m1591m();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: com.facebook.ads.internal.b.9 */
    class C04669 implements C0431a {
        final /* synthetic */ C0521b f845a;

        C04669(C0521b c0521b) {
            this.f845a = c0521b;
        }

        public void m1177a(C0497x c0497x) {
            this.f845a.f1112p = c0497x;
            this.f845a.f1100a.m1064a((C0471a) c0497x);
        }

        public void m1178a(C0497x c0497x, View view) {
            this.f845a.f1100a.m1063a(view);
        }

        public void m1179a(C0497x c0497x, C0439c c0439c) {
            this.f845a.f1100a.m1066a(new C0536d(c0439c.m1047a(), c0439c.m1048b()));
        }

        public void m1180b(C0497x c0497x) {
            this.f845a.f1100a.m1062a();
        }

        public void m1181c(C0497x c0497x) {
            this.f845a.f1100a.m1067b();
        }

        public void m1182d(C0497x c0497x) {
            this.f845a.f1100a.m1070e();
        }
    }

    /* renamed from: com.facebook.ads.internal.b.a */
    private static final class C0468a extends C0467m<C0521b> {
        public C0468a(C0521b c0521b) {
            super(c0521b);
        }

        public void run() {
            C0521b c0521b = (C0521b) m1183a();
            if (c0521b != null) {
                c0521b.f1108l = false;
                c0521b.m1588k();
            }
        }
    }

    /* renamed from: com.facebook.ads.internal.b.b */
    private static final class C0469b extends C0467m<C0521b> {
        public C0469b(C0521b c0521b) {
            super(c0521b);
        }

        public void run() {
            C0521b c0521b = (C0521b) m1183a();
            if (c0521b != null) {
                c0521b.m1594n();
            }
        }
    }

    /* renamed from: com.facebook.ads.internal.b.c */
    private class C0470c extends BroadcastReceiver {
        final /* synthetic */ C0521b f847a;

        private C0470c(C0521b c0521b) {
            this.f847a = c0521b;
        }

        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if ("android.intent.action.SCREEN_OFF".equals(action)) {
                this.f847a.m1596o();
            } else if ("android.intent.action.SCREEN_ON".equals(action)) {
                this.f847a.m1594n();
            }
        }
    }

    static {
        f1097b = C0521b.class.getSimpleName();
        f1098h = new Handler(Looper.getMainLooper());
        f1099i = false;
    }

    public C0521b(Context context, String str, C0565g c0565g, C0656a c0656a, C0442f c0442f, C0539e c0539e, int i, boolean z) {
        this.f1105g = new Handler();
        this.f1101c = context;
        this.f1102d = str;
        this.f1116t = c0565g;
        this.f1103e = c0656a;
        this.f1118v = c0442f;
        this.f1117u = c0539e;
        this.f1119w = i;
        this.f1120x = new C0470c();
        this.f1104f = new C0660b(context);
        this.f1104f.m2119a((C0520a) this);
        this.f1106j = new C0468a(this);
        this.f1107k = new C0469b(this);
        this.f1109m = z;
        m1581h();
        try {
            CookieManager.getInstance();
            if (VERSION.SDK_INT < 21) {
                CookieSyncManager.createInstance(context);
            }
        } catch (Exception e) {
            Log.w(f1097b, "Failed to initialize CookieManager.");
        }
        C0537a.m1662a(context).m1663a();
        this.f1122z = C0580g.m1799a(context);
    }

    private Map<String, String> m1562a(long j) {
        Map<String, String> hashMap = new HashMap();
        hashMap.put("delay", String.valueOf(System.currentTimeMillis() - j));
        return hashMap;
    }

    private void m1564a(C0471a c0471a) {
        if (c0471a != null) {
            c0471a.m1185b();
        }
    }

    private void m1565a(ab abVar, C0557d c0557d, C0553a c0553a, Map<String, Object> map) {
        long currentTimeMillis = System.currentTimeMillis();
        Runnable c04614 = new C04614(this, abVar, currentTimeMillis, c0553a);
        this.f1105g.postDelayed(c04614, (long) c0557d.m1718a().m1731i());
        abVar.m1203a(this.f1101c, new C04625(this, c04614, currentTimeMillis, c0553a), this.f1122z, map);
    }

    private void m1566a(ad adVar, C0557d c0557d, Map<String, Object> map) {
        adVar.m1233a(this.f1101c, new ae() {
            final /* synthetic */ C0521b f819a;

            {
                this.f819a = r1;
            }

            public void m1141a() {
                this.f819a.f1100a.m1072g();
            }

            public void m1142a(ad adVar) {
                this.f819a.f1112p = adVar;
                this.f819a.f1100a.m1064a((C0471a) adVar);
            }

            public void m1143a(ad adVar, C0439c c0439c) {
                this.f819a.f1100a.m1066a(new C0536d(C0455a.INTERNAL_ERROR, null));
                this.f819a.m1564a((C0471a) adVar);
                this.f819a.m1589l();
            }

            public void m1144b(ad adVar) {
                this.f819a.f1100a.m1062a();
            }

            public void m1145c(ad adVar) {
                this.f819a.f1100a.m1067b();
            }

            public void m1146d(ad adVar) {
                this.f819a.f1100a.m1071f();
            }

            public void m1147e(ad adVar) {
                this.f819a.f1100a.m1073h();
            }

            public void m1148f(ad adVar) {
                this.f819a.f1100a.m1074i();
            }
        }, map);
    }

    private void m1567a(C0473b c0473b, C0557d c0557d, Map<String, Object> map) {
        Runnable anonymousClass11 = new AnonymousClass11(this, c0473b);
        this.f1105g.postDelayed(anonymousClass11, (long) c0557d.m1718a().m1731i());
        c0473b.m1237a(this.f1101c, this.f1118v, new AnonymousClass12(this, anonymousClass11), map);
    }

    private void m1568a(C0474d c0474d, C0557d c0557d, Map<String, Object> map) {
        Runnable c04582 = new C04582(this, c0474d);
        this.f1105g.postDelayed(c04582, (long) c0557d.m1718a().m1731i());
        c0474d.m1239a(this.f1101c, new C04603(this, c04582), map, this.f1122z);
    }

    private void m1569a(C0497x c0497x, C0557d c0557d, Map<String, Object> map) {
        c0497x.m1338a(this.f1101c, new C04669(this), map, this.f1122z);
    }

    private void m1572a(List<String> list, Map<String, String> map) {
        if (list != null && !list.isEmpty()) {
            for (String str : list) {
                new al(map).execute(new String[]{str});
            }
        }
    }

    private void m1581h() {
        if (!this.f1109m) {
            IntentFilter intentFilter = new IntentFilter("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            this.f1101c.registerReceiver(this.f1120x, intentFilter);
            this.f1121y = true;
        }
    }

    private void m1583i() {
        if (this.f1121y) {
            try {
                this.f1101c.unregisterReceiver(this.f1120x);
                this.f1121y = false;
            } catch (Throwable e) {
                C0706q.m2279a(C0705p.m2276a(e, "Error unregistering screen state receiever"));
            }
        }
    }

    private C0656a m1586j() {
        return this.f1103e != null ? this.f1103e : this.f1118v == null ? C0656a.NATIVE : this.f1118v == C0442f.f756b ? C0656a.INTERSTITIAL : C0656a.BANNER;
    }

    private void m1588k() {
        this.f1115s = new C0561f(this.f1101c, this.f1102d, this.f1118v, this.f1116t, this.f1117u, this.f1119w, C0441e.m1055a(this.f1101c));
        this.f1104f.m2118a(this.f1115s);
    }

    private synchronized void m1589l() {
        f1098h.post(new C04658(this));
    }

    private void m1591m() {
        this.f1111o = null;
        C0557d c0557d = this.f1114r;
        C0553a c = c0557d.m1721c();
        if (c == null) {
            this.f1100a.m1066a(C0455a.NO_FILL.m1130a(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING));
            m1594n();
            return;
        }
        String a = c.m1711a();
        C0471a a2 = C0484j.m1296a(a, c0557d.m1718a().m1723a());
        if (a2 == null) {
            Log.e(f1097b, "Adapter does not exist: " + a);
            m1589l();
        } else if (m1586j() != a2.m1184a()) {
            this.f1100a.m1066a(C0455a.INTERNAL_ERROR.m1130a(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING));
        } else {
            this.f1111o = a2;
            Map hashMap = new HashMap();
            C0558e a3 = c0557d.m1718a();
            hashMap.put("data", c.m1713b());
            hashMap.put("definition", a3);
            if (this.f1115s == null) {
                this.f1100a.m1066a(C0455a.UNKNOWN_ERROR.m1130a("environment is empty"));
                return;
            }
            switch (C04647.f843a[a2.m1184a().ordinal()]) {
                case NendIconError.ERROR_ICONVIEW /*1*/:
                    m1568a((C0474d) a2, c0557d, hashMap);
                case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                    m1567a((C0473b) a2, c0557d, hashMap);
                case SendException.ERROR_TTL_EXCEEDED /*3*/:
                    m1565a((ab) a2, c0557d, c, hashMap);
                case SendException.ERROR_TOO_MANY_MESSAGES /*4*/:
                    m1569a((C0497x) a2, c0557d, hashMap);
                case Type.OTHER_PROFILE /*5*/:
                    hashMap.put("placement_id", this.f1102d);
                    m1566a((ad) a2, c0557d, hashMap);
                default:
                    Log.e(f1097b, "attempt unexpected adapter type");
            }
        }
    }

    private void m1594n() {
        if (!this.f1109m && !this.f1108l) {
            switch (C04647.f843a[m1586j().ordinal()]) {
                case NendIconError.ERROR_ICONVIEW /*1*/:
                    if (!com.facebook.ads.internal.p021m.ac.m2138a(this.f1101c)) {
                        this.f1105g.postDelayed(this.f1107k, 1000);
                        break;
                    }
                    break;
                case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                    boolean a = C0652a.m2073a(this.f1113q, this.f1114r == null ? 1 : this.f1114r.m1718a().m1727e()).m2093a();
                    if (!(this.f1113q == null || a)) {
                        this.f1105g.postDelayed(this.f1107k, 1000);
                        return;
                    }
                default:
                    return;
            }
            long b = this.f1114r == null ? 30000 : this.f1114r.m1718a().m1724b();
            if (b > 0) {
                this.f1105g.postDelayed(this.f1106j, b);
                this.f1108l = true;
            }
        }
    }

    private void m1596o() {
        if (this.f1108l) {
            this.f1105g.removeCallbacks(this.f1106j);
            this.f1108l = false;
        }
    }

    private Handler m1597p() {
        return !C0521b.m1598q() ? this.f1105g : f1098h;
    }

    private static synchronized boolean m1598q() {
        boolean z;
        synchronized (C0521b.class) {
            z = f1099i;
        }
        return z;
    }

    public C0558e m1599a() {
        return this.f1114r == null ? null : this.f1114r.m1718a();
    }

    public void m1600a(C0443c c0443c) {
        this.f1100a = c0443c;
    }

    public synchronized void m1601a(C0536d c0536d) {
        m1597p().post(new C04636(this, c0536d));
    }

    public synchronized void m1602a(C0665f c0665f) {
        m1597p().post(new C04571(this, c0665f));
    }

    public void m1603b() {
        m1588k();
    }

    public void m1604c() {
        if (this.f1112p == null) {
            throw new IllegalStateException("no adapter ready to start");
        } else if (this.f1110n) {
            throw new IllegalStateException("ad already started");
        } else {
            this.f1110n = true;
            switch (C04647.f843a[this.f1112p.m1184a().ordinal()]) {
                case NendIconError.ERROR_ICONVIEW /*1*/:
                    ((C0474d) this.f1112p).m1240c();
                case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                    if (this.f1113q != null) {
                        this.f1100a.m1063a(this.f1113q);
                        m1594n();
                    }
                case SendException.ERROR_TTL_EXCEEDED /*3*/:
                    ab abVar = (ab) this.f1112p;
                    if (abVar.m1209d()) {
                        this.f1100a.m1065a(abVar);
                        return;
                    }
                    throw new IllegalStateException("ad is not ready or already displayed");
                case SendException.ERROR_TOO_MANY_MESSAGES /*4*/:
                    ((C0497x) this.f1112p).m1339f();
                case Type.OTHER_PROFILE /*5*/:
                    ((ad) this.f1112p).m1234d();
                default:
                    Log.e(f1097b, "start unexpected adapter type");
            }
        }
    }

    public void m1605d() {
        m1583i();
        if (this.f1110n) {
            m1596o();
            m1564a(this.f1112p);
            this.f1113q = null;
            this.f1110n = false;
        }
    }

    public void m1606e() {
        if (this.f1110n) {
            m1596o();
        }
    }

    public void m1607f() {
        if (this.f1110n) {
            m1594n();
        }
    }

    public void m1608g() {
        m1596o();
        m1588k();
    }
}
