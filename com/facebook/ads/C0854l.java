package com.facebook.ads;

import android.graphics.Color;
import android.os.Build.VERSION;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import com.facebook.ads.internal.p021m.ad;
import com.facebook.ads.internal.p024b.C0488m;
import com.facebook.ads.internal.p025h.C0578f;
import com.facebook.ads.internal.p025h.C0580g;
import com.facebook.ads.internal.view.C0818d;
import com.facebook.ads.internal.view.C0828h;
import com.facebook.ads.internal.view.hscroll.C0834b;

/* renamed from: com.facebook.ads.l */
public class C0854l extends RelativeLayout {
    private static final String f2118a;
    private static final int f2119b;
    @Nullable
    private C0855m f2120c;
    private final C0818d f2121d;
    private final C0828h f2122e;
    private final C0834b f2123f;
    private boolean f2124g;
    @Deprecated
    private boolean f2125h;

    static {
        f2118a = C0854l.class.getSimpleName();
        f2119b = Color.argb(51, 145, 150, 165);
    }

    private boolean m2635a(C0869n c0869n) {
        return VERSION.SDK_INT >= 14 && !TextUtils.isEmpty(c0869n.m2730r());
    }

    private boolean m2636b(C0869n c0869n) {
        if (c0869n.m2734v() == null) {
            return false;
        }
        for (C0869n f : c0869n.m2734v()) {
            if (f.m2718f() == null) {
                return false;
            }
        }
        return true;
    }

    public void m2637a() {
        this.f2122e.m2556g();
    }

    protected C0578f getAdEventManager() {
        return C0580g.m1799a(getContext());
    }

    @Deprecated
    public void setAutoplay(boolean z) {
        this.f2125h = z;
        this.f2122e.setAutoplay(z);
    }

    @Deprecated
    public void setAutoplayOnMobile(boolean z) {
        this.f2122e.setIsAutoplayOnMobile(z);
    }

    public void setListener(C0855m c0855m) {
        this.f2120c = c0855m;
        this.f2122e.setListener(c0855m);
    }

    public void setNativeAd(C0869n c0869n) {
        c0869n.m2711a(this);
        c0869n.m2713a(this.f2125h);
        if (this.f2124g) {
            this.f2121d.m2507a(null, null);
            this.f2124g = false;
        }
        String a = c0869n.m2718f() != null ? c0869n.m2718f().m2665a() : null;
        if (m2636b(c0869n)) {
            this.f2121d.setVisibility(8);
            this.f2122e.setVisibility(8);
            this.f2123f.setVisibility(0);
            bringChildToFront(this.f2123f);
            this.f2123f.setCurrentPosition(0);
            this.f2123f.setAdapter(new C0488m(this.f2123f, c0869n.m2734v()));
        } else if (m2635a(c0869n)) {
            String r = c0869n.m2730r();
            String s = c0869n.m2731s();
            this.f2122e.setImage(null);
            this.f2121d.setVisibility(8);
            this.f2122e.setVisibility(0);
            this.f2123f.setVisibility(8);
            bringChildToFront(this.f2122e);
            this.f2124g = true;
            this.f2122e.setAutoplay(this.f2125h);
            this.f2122e.setIsAutoPlayFromServer(c0869n.m2733u());
            if (a != null) {
                this.f2122e.setImage(a);
            }
            this.f2122e.m2560a(c0869n.m2732t(), c0869n.m2735w());
            this.f2122e.setVideoMPD(s);
            this.f2122e.setVideoURI(r);
        } else if (a != null) {
            this.f2121d.setVisibility(0);
            this.f2122e.setVisibility(8);
            this.f2123f.setVisibility(8);
            bringChildToFront(this.f2121d);
            this.f2124g = true;
            new ad(this.f2121d).m2145a(a);
        }
    }
}
