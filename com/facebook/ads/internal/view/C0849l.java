package com.facebook.ads.internal.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import com.facebook.ads.AudienceNetworkActivity;
import com.facebook.ads.internal.p021m.C0690e;
import com.facebook.ads.internal.p025h.C0580g;
import com.facebook.ads.internal.view.C0504c.C0417a;
import com.facebook.ads.internal.view.p038c.p039a.C0739b;
import com.facebook.ads.internal.view.p038c.p039a.C0740c;
import com.facebook.ads.internal.view.p038c.p039a.C0741d;
import com.facebook.ads.internal.view.p038c.p039a.C0742e;
import com.facebook.ads.internal.view.p038c.p039a.C0743f;
import com.facebook.ads.internal.view.p038c.p039a.C0744g;
import com.facebook.ads.internal.view.p038c.p039a.C0745h;
import com.facebook.ads.internal.view.p038c.p039a.C0746i;
import com.facebook.ads.internal.view.p038c.p039a.C0747j;
import com.facebook.ads.internal.view.p038c.p039a.C0748k;
import com.facebook.ads.internal.view.p038c.p039a.C0752p;
import com.facebook.ads.internal.view.p038c.p042b.C0771b;
import com.google.ads.mediation.facebook.FacebookAdapter;

/* renamed from: com.facebook.ads.internal.view.l */
public class C0849l implements C0504c {
    private final C0742e f2108a;
    private final C0748k f2109b;
    private final C0746i f2110c;
    private final C0740c f2111d;
    private final AudienceNetworkActivity f2112e;
    private final C0827j f2113f;
    private final C0417a f2114g;
    private C0690e f2115h;
    private int f2116i;

    /* renamed from: com.facebook.ads.internal.view.l.1 */
    class C08451 extends C0742e {
        final /* synthetic */ C0849l f2104a;

        C08451(C0849l c0849l) {
            this.f2104a = c0849l;
        }

        public void m2616a(C0741d c0741d) {
            this.f2104a.f2112e.finish();
        }
    }

    /* renamed from: com.facebook.ads.internal.view.l.2 */
    class C08462 extends C0748k {
        final /* synthetic */ C0849l f2105a;

        C08462(C0849l c0849l) {
            this.f2105a = c0849l;
        }

        public void m2618a(C0747j c0747j) {
            this.f2105a.f2114g.m983a("videoInterstitalEvent", c0747j);
        }
    }

    /* renamed from: com.facebook.ads.internal.view.l.3 */
    class C08473 extends C0746i {
        final /* synthetic */ C0849l f2106a;

        C08473(C0849l c0849l) {
            this.f2106a = c0849l;
        }

        public void m2620a(C0745h c0745h) {
            this.f2106a.f2114g.m983a("videoInterstitalEvent", c0745h);
        }
    }

    /* renamed from: com.facebook.ads.internal.view.l.4 */
    class C08484 extends C0740c {
        final /* synthetic */ C0849l f2107a;

        C08484(C0849l c0849l) {
            this.f2107a = c0849l;
        }

        public void m2622a(C0739b c0739b) {
            this.f2107a.f2114g.m983a("videoInterstitalEvent", c0739b);
        }
    }

    public C0849l(AudienceNetworkActivity audienceNetworkActivity, C0417a c0417a) {
        this.f2108a = new C08451(this);
        this.f2109b = new C08462(this);
        this.f2110c = new C08473(this);
        this.f2111d = new C08484(this);
        this.f2112e = audienceNetworkActivity;
        this.f2113f = new C0827j(audienceNetworkActivity);
        this.f2113f.m2548a(new C0771b(audienceNetworkActivity));
        this.f2113f.getEventBus().m1846a(this.f2109b);
        this.f2113f.getEventBus().m1846a(this.f2110c);
        this.f2113f.getEventBus().m1846a(this.f2111d);
        this.f2113f.getEventBus().m1846a(this.f2108a);
        this.f2114g = c0417a;
        this.f2113f.setIsFullScreen(true);
        this.f2113f.setVolume(1.0f);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(15);
        this.f2113f.setLayoutParams(layoutParams);
        c0417a.m981a(this.f2113f);
    }

    public void m2625a(Intent intent, Bundle bundle, AudienceNetworkActivity audienceNetworkActivity) {
        boolean booleanExtra = intent.getBooleanExtra(FacebookAdapter.KEY_AUTOPLAY, false);
        String stringExtra = intent.getStringExtra("videoURL");
        String stringExtra2 = intent.getStringExtra("videoMPD");
        Bundle bundleExtra = intent.getBundleExtra("videoLogger");
        String stringExtra3 = intent.getStringExtra("clientToken");
        String stringExtra4 = intent.getStringExtra("videoReportURL");
        this.f2116i = intent.getIntExtra("videoSeekTime", 0);
        this.f2113f.setAutoplay(booleanExtra);
        this.f2115h = new C0690e(audienceNetworkActivity, C0580g.m1799a(audienceNetworkActivity.getApplicationContext()), this.f2113f, stringExtra4, stringExtra3, bundleExtra);
        this.f2113f.setVideoMPD(stringExtra2);
        this.f2113f.setVideoURI(stringExtra);
        if (this.f2116i > 0) {
            this.f2113f.m2546a(this.f2116i);
        }
        this.f2113f.m2553d();
    }

    public void m2626a(Bundle bundle) {
    }

    public void m2627a(View view) {
        this.f2113f.setControlsAnchorView(view);
    }

    public void m2628a(C0417a c0417a) {
    }

    public void m2629i() {
        this.f2114g.m983a("videoInterstitalEvent", new C0743f());
        this.f2113f.m2554e();
    }

    public void m2630j() {
        this.f2114g.m983a("videoInterstitalEvent", new C0744g());
        this.f2113f.m2553d();
    }

    public void m2631k() {
        this.f2114g.m983a("videoInterstitalEvent", new C0752p(this.f2116i, this.f2113f.getCurrentPosition()));
        this.f2115h.m2236b(this.f2113f.getCurrentPosition());
        this.f2113f.m2556g();
    }
}
