package com.facebook.ads.internal.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.helper.ItemTouchHelper.Callback;
import android.text.TextUtils;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.facebook.ads.AudienceNetworkActivity;
import com.facebook.ads.internal.C0655k;
import com.facebook.ads.internal.p021m.C0690e;
import com.facebook.ads.internal.p021m.C0693h;
import com.facebook.ads.internal.p021m.C0712u;
import com.facebook.ads.internal.p021m.al;
import com.facebook.ads.internal.p025h.C0492s;
import com.facebook.ads.internal.p025h.C0580g;
import com.facebook.ads.internal.p037k.C0652a;
import com.facebook.ads.internal.p037k.C0652a.C0650a;
import com.facebook.ads.internal.view.C0504c.C0417a;
import com.facebook.ads.internal.view.p038c.p039a.C0739b;
import com.facebook.ads.internal.view.p038c.p039a.C0741d;
import com.facebook.ads.internal.view.p038c.p039a.C0749l;
import com.facebook.ads.internal.view.p038c.p039a.C0754r;
import com.facebook.ads.internal.view.p038c.p042b.C0764l;
import com.facebook.ads.internal.view.p038c.p042b.C0773c;
import com.facebook.ads.internal.view.p038c.p042b.C0797i;
import com.facebook.ads.internal.view.p038c.p043c.C0816d;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.facebook.ads.internal.view.i */
public class C0841i implements C0504c {
    private C0652a f2088a;
    private C0827j f2089b;
    private C0690e f2090c;
    private C0693h f2091d;
    private C0417a f2092e;
    private String f2093f;
    private C0492s<C0739b> f2094g;
    private C0492s<C0741d> f2095h;
    private C0492s<C0749l> f2096i;
    private C0492s<C0754r> f2097j;
    private String f2098k;
    private final Context f2099l;
    private String f2100m;
    private String f2101n;

    /* renamed from: com.facebook.ads.internal.view.i.1 */
    class C08361 extends C0492s<C0754r> {
        final /* synthetic */ C0841i f2083a;

        C08361(C0841i c0841i) {
            this.f2083a = c0841i;
        }

        public Class<C0754r> m2582a() {
            return C0754r.class;
        }

        public void m2584a(C0754r c0754r) {
            this.f2083a.f2091d.m2254a(c0754r.m2380b(), this.f2083a.f2089b, c0754r.m2379a());
        }
    }

    /* renamed from: com.facebook.ads.internal.view.i.2 */
    class C08372 extends C0492s<C0739b> {
        final /* synthetic */ C0841i f2084a;

        C08372(C0841i c0841i) {
            this.f2084a = c0841i;
        }

        public Class<C0739b> m2585a() {
            return C0739b.class;
        }

        public void m2587a(C0739b c0739b) {
            if (this.f2084a.f2092e != null) {
                this.f2084a.f2092e.m983a(C0655k.REWARDED_VIDEO_COMPLETE.m2098a(), c0739b);
            }
            this.f2084a.m2610f();
        }
    }

    /* renamed from: com.facebook.ads.internal.view.i.3 */
    class C08383 extends C0492s<C0741d> {
        final /* synthetic */ C0841i f2085a;

        C08383(C0841i c0841i) {
            this.f2085a = c0841i;
        }

        public Class<C0741d> m2588a() {
            return C0741d.class;
        }

        public void m2590a(C0741d c0741d) {
            if (this.f2085a.f2092e != null) {
                this.f2085a.f2092e.m982a(C0655k.REWARDED_VIDEO_ERROR.m2098a());
            }
            this.f2085a.m2610f();
        }
    }

    /* renamed from: com.facebook.ads.internal.view.i.4 */
    class C08394 extends C0492s<C0749l> {
        final /* synthetic */ C0841i f2086a;

        C08394(C0841i c0841i) {
            this.f2086a = c0841i;
        }

        public Class<C0749l> m2591a() {
            return C0749l.class;
        }

        public void m2593a(C0749l c0749l) {
            if (this.f2086a.f2088a != null) {
                this.f2086a.f2088a.m2088a();
            }
        }
    }

    /* renamed from: com.facebook.ads.internal.view.i.5 */
    class C08405 extends C0650a {
        final /* synthetic */ C0841i f2087a;

        C08405(C0841i c0841i) {
            this.f2087a = c0841i;
        }

        public void m2594a() {
            if (!this.f2087a.f2091d.m2256b()) {
                this.f2087a.f2091d.m2253a();
                Map hashMap = new HashMap();
                if (TextUtils.isEmpty(this.f2087a.f2098k)) {
                    new al(hashMap).execute(new String[]{this.f2087a.m2602a()});
                } else {
                    this.f2087a.f2088a.m2090a(hashMap);
                    hashMap.put("touch", C0712u.m2299a(this.f2087a.m2606b()));
                    C0580g.m1799a(this.f2087a.f2099l).m1790b(this.f2087a.f2098k, hashMap);
                }
                if (this.f2087a.f2092e != null) {
                    this.f2087a.f2092e.m982a(C0655k.REWARDED_VIDEO_IMPRESSION.m2098a());
                }
            }
        }
    }

    public C0841i(Context context, C0417a c0417a) {
        this.f2099l = context;
        this.f2092e = c0417a;
        m2601h();
    }

    private void m2601h() {
        LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.f2089b = new C0827j(this.f2099l);
        this.f2089b.m2557h();
        this.f2089b.setAutoplay(true);
        this.f2089b.setIsFullScreen(true);
        this.f2089b.setLayoutParams(layoutParams);
        this.f2089b.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        this.f2097j = new C08361(this);
        this.f2094g = new C08372(this);
        this.f2095h = new C08383(this);
        this.f2096i = new C08394(this);
        this.f2089b.getEventBus().m1846a(this.f2094g);
        this.f2089b.getEventBus().m1846a(this.f2095h);
        this.f2089b.getEventBus().m1846a(this.f2096i);
        this.f2089b.getEventBus().m1846a(this.f2097j);
        this.f2089b.m2548a(new C0797i(this.f2099l));
        C0764l c0773c = new C0773c(this.f2099l, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING);
        LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(12);
        layoutParams2.addRule(11);
        c0773c.setLayoutParams(layoutParams2);
        c0773c.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        c0773c.setCountdownTextColor(-1);
        this.f2089b.m2548a(c0773c);
        this.f2088a = new C0652a(this.f2089b, 1, new C08405(this));
        this.f2088a.m2089a((int) Callback.DEFAULT_SWIPE_ANIMATION_DURATION);
        this.f2091d = new C0693h();
        this.f2092e.m981a(this.f2089b);
    }

    public String m2602a() {
        return this.f2093f;
    }

    public void m2603a(Intent intent, Bundle bundle, AudienceNetworkActivity audienceNetworkActivity) {
        String stringExtra = intent.getStringExtra("videoURL");
        this.f2093f = intent.getStringExtra("impressionReportURL");
        this.f2098k = intent.getStringExtra("clientToken");
        this.f2101n = intent.getStringExtra("closeReportURL");
        String stringExtra2 = intent.getStringExtra("videoReportURL");
        this.f2100m = intent.getStringExtra("contextSwitchBehavior");
        this.f2090c = new C0690e(this.f2099l, C0580g.m1799a(this.f2099l), this.f2089b, stringExtra2, this.f2098k);
        if (!TextUtils.isEmpty(stringExtra)) {
            this.f2089b.setVideoURI(stringExtra);
        }
        this.f2089b.m2553d();
    }

    public void m2604a(Bundle bundle) {
    }

    public void m2605a(C0417a c0417a) {
    }

    public Map<String, String> m2606b() {
        return this.f2091d.m2259e();
    }

    public void m2607c() {
        this.f2089b.m2546a(1);
        this.f2089b.m2553d();
    }

    public void m2608d() {
        this.f2089b.m2554e();
    }

    public boolean m2609e() {
        return this.f2089b.getState() == C0816d.PAUSED;
    }

    public void m2610f() {
        this.f2089b.m2556g();
        if (this.f2088a != null) {
            this.f2088a.m2091b();
        }
    }

    public void m2611g() {
        this.f2089b.m2546a(this.f2089b.getCurrentPosition());
        this.f2089b.m2553d();
    }

    public void m2612i() {
        m2608d();
    }

    public void m2613j() {
        if (!m2609e()) {
            return;
        }
        if (this.f2100m.equals("restart")) {
            m2607c();
        } else if (this.f2100m.equals("resume")) {
            m2611g();
        } else if (this.f2100m.equals("skip")) {
            this.f2092e.m983a(C0655k.REWARDED_VIDEO_COMPLETE_WITHOUT_REWARD.m2098a(), new C0739b());
            m2610f();
        } else if (this.f2100m.equals("endvideo")) {
            this.f2092e.m982a(C0655k.REWARDED_VIDEO_END_ACTIVITY.m2098a());
            Map hashMap = new HashMap();
            if (!TextUtils.isEmpty(this.f2098k)) {
                this.f2088a.m2090a(hashMap);
                hashMap.put("touch", C0712u.m2299a(m2606b()));
                C0580g.m1799a(this.f2099l).m1794f(this.f2098k, hashMap);
            } else if (this.f2101n != null) {
                new al(hashMap).execute(new String[]{this.f2101n});
            }
            m2610f();
        }
    }

    public void m2614k() {
        m2610f();
    }
}
