package com.facebook.ads.internal.view;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import com.facebook.ads.AudienceNetworkActivity;
import com.facebook.ads.AudienceNetworkActivity.C0420a;
import com.facebook.ads.internal.p021m.C0713v;
import com.facebook.ads.internal.p021m.C0717y.C0716a;
import com.facebook.ads.internal.p025h.C0580g;
import com.facebook.ads.internal.view.C0504c.C0417a;
import com.facebook.ads.internal.view.p040a.C0723a;
import com.facebook.ads.internal.view.p040a.C0723a.C0722a;
import com.facebook.ads.internal.view.p040a.C0724b;
import com.facebook.ads.internal.view.p040a.C0730d;
import com.facebook.ads.internal.view.p040a.C0730d.C0728a;

@TargetApi(19)
/* renamed from: com.facebook.ads.internal.view.e */
public class C0822e implements C0504c {
    private static final String f2002a;
    private final AudienceNetworkActivity f2003b;
    private final C0723a f2004c;
    private final C0730d f2005d;
    private final C0724b f2006e;
    private final C0420a f2007f;
    private String f2008g;
    private String f2009h;
    private long f2010i;
    private boolean f2011j;
    private long f2012k;
    private boolean f2013l;

    /* renamed from: com.facebook.ads.internal.view.e.1 */
    class C08191 implements C0420a {
        final /* synthetic */ C0822e f1998a;

        C08191(C0822e c0822e) {
            this.f1998a = c0822e;
        }

        public boolean m2508a() {
            if (!this.f1998a.f2005d.canGoBack()) {
                return false;
            }
            this.f1998a.f2005d.goBack();
            return true;
        }
    }

    /* renamed from: com.facebook.ads.internal.view.e.2 */
    class C08202 implements C0722a {
        final /* synthetic */ AudienceNetworkActivity f1999a;
        final /* synthetic */ C0822e f2000b;

        C08202(C0822e c0822e, AudienceNetworkActivity audienceNetworkActivity) {
            this.f2000b = c0822e;
            this.f1999a = audienceNetworkActivity;
        }

        public void m2509a() {
            this.f1999a.finish();
        }
    }

    /* renamed from: com.facebook.ads.internal.view.e.3 */
    class C08213 implements C0728a {
        final /* synthetic */ C0822e f2001a;

        C08213(C0822e c0822e) {
            this.f2001a = c0822e;
        }

        public void m2510a(int i) {
            if (this.f2001a.f2011j) {
                this.f2001a.f2006e.setProgress(i);
            }
        }

        public void m2511a(String str) {
            this.f2001a.f2011j = true;
            this.f2001a.f2004c.setUrl(str);
        }

        public void m2512b(String str) {
            this.f2001a.f2004c.setTitle(str);
        }

        public void m2513c(String str) {
            this.f2001a.f2006e.setProgress(100);
            this.f2001a.f2011j = false;
        }
    }

    static {
        f2002a = C0822e.class.getSimpleName();
    }

    public C0822e(AudienceNetworkActivity audienceNetworkActivity, C0417a c0417a) {
        this.f2007f = new C08191(this);
        this.f2011j = true;
        this.f2012k = -1;
        this.f2013l = true;
        this.f2003b = audienceNetworkActivity;
        int i = (int) (2.0f * audienceNetworkActivity.getResources().getDisplayMetrics().density);
        this.f2004c = new C0723a(audienceNetworkActivity);
        this.f2004c.setId(View.generateViewId());
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(10);
        this.f2004c.setLayoutParams(layoutParams);
        this.f2004c.setListener(new C08202(this, audienceNetworkActivity));
        c0417a.m981a(this.f2004c);
        this.f2005d = new C0730d(audienceNetworkActivity);
        layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(3, this.f2004c.getId());
        layoutParams.addRule(12);
        this.f2005d.setLayoutParams(layoutParams);
        this.f2005d.setListener(new C08213(this));
        c0417a.m981a(this.f2005d);
        this.f2006e = new C0724b(audienceNetworkActivity, null, 16842872);
        layoutParams = new RelativeLayout.LayoutParams(-1, i);
        layoutParams.addRule(3, this.f2004c.getId());
        this.f2006e.setLayoutParams(layoutParams);
        this.f2006e.setProgress(0);
        c0417a.m981a(this.f2006e);
        audienceNetworkActivity.m1031a(this.f2007f);
    }

    public void m2519a(Intent intent, Bundle bundle, AudienceNetworkActivity audienceNetworkActivity) {
        if (this.f2012k < 0) {
            this.f2012k = System.currentTimeMillis();
        }
        if (bundle == null) {
            this.f2008g = intent.getStringExtra("browserURL");
            this.f2009h = intent.getStringExtra("clientToken");
            this.f2010i = intent.getLongExtra("handlerTime", -1);
        } else {
            this.f2008g = bundle.getString("browserURL");
            this.f2009h = bundle.getString("clientToken");
            this.f2010i = bundle.getLong("handlerTime", -1);
        }
        String str = this.f2008g != null ? this.f2008g : "about:blank";
        this.f2004c.setUrl(str);
        this.f2005d.loadUrl(str);
    }

    public void m2520a(Bundle bundle) {
        bundle.putString("browserURL", this.f2008g);
    }

    public void m2521a(C0417a c0417a) {
    }

    public void m2522i() {
        this.f2005d.onPause();
        if (this.f2013l) {
            this.f2013l = false;
            C0580g.m1799a(this.f2003b).m1805a(this.f2009h, new C0716a(this.f2005d.getFirstUrl()).m2321a(this.f2010i).m2323b(this.f2012k).m2324c(this.f2005d.getResponseEndMs()).m2325d(this.f2005d.getDomContentLoadedMs()).m2326e(this.f2005d.getScrollReadyMs()).m2327f(this.f2005d.getLoadFinishMs()).m2328g(System.currentTimeMillis()).m2322a());
        }
    }

    public void m2523j() {
        this.f2005d.onResume();
    }

    public void m2524k() {
        this.f2003b.m1032b(this.f2007f);
        C0713v.m2315a(this.f2005d);
        this.f2005d.destroy();
    }
}
