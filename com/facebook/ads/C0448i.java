package com.facebook.ads;

import android.content.Context;
import android.view.View;
import com.facebook.ads.internal.C0443c;
import com.facebook.ads.internal.C0521b;
import com.facebook.ads.internal.C0536d;
import com.facebook.ads.internal.C0539e;
import com.facebook.ads.internal.p021m.C0712u;
import com.facebook.ads.internal.p024b.C0471a;
import com.facebook.ads.internal.p027l.C0656a;

/* renamed from: com.facebook.ads.i */
public class C0448i implements C0432a {
    private static final C0539e f773a;
    private final Context f774b;
    private final String f775c;
    private C0521b f776d;
    private boolean f777e;
    private boolean f778f;
    private C0853k f779g;
    private C0446h f780h;

    /* renamed from: com.facebook.ads.i.1 */
    class C04471 extends C0443c {
        final /* synthetic */ C0448i f772a;

        C04471(C0448i c0448i) {
            this.f772a = c0448i;
        }

        public void m1090a() {
            if (this.f772a.f779g != null) {
                this.f772a.f779g.m1051b(this.f772a);
            }
        }

        public void m1091a(View view) {
        }

        public void m1092a(C0471a c0471a) {
            this.f772a.f777e = true;
            if (this.f772a.f779g != null) {
                this.f772a.f779g.m1049a(this.f772a);
            }
        }

        public void m1093a(C0536d c0536d) {
            if (this.f772a.f779g != null) {
                this.f772a.f779g.m1050a(this.f772a, c0536d.m1661b());
            }
        }

        public void m1094b() {
            if (this.f772a.f780h != null) {
                this.f772a.f780h.m1089a(this.f772a);
            }
            if ((this.f772a.f779g instanceof C0446h) && this.f772a.f779g != this.f772a.f780h) {
                ((C0446h) this.f772a.f779g).m1089a(this.f772a);
            }
        }

        public void m1095c() {
            if (this.f772a.f779g != null) {
                this.f772a.f779g.m2633c(this.f772a);
            }
        }

        public void m1096d() {
            this.f772a.f778f = false;
            if (this.f772a.f776d != null) {
                this.f772a.f776d.m1605d();
                this.f772a.f776d = null;
            }
            if (this.f772a.f779g != null) {
                this.f772a.f779g.m2634d(this.f772a);
            }
        }
    }

    static {
        f773a = C0539e.ADS;
    }

    public C0448i(Context context, String str) {
        this.f774b = context;
        this.f775c = str;
    }

    public void m1103a() {
        this.f777e = false;
        if (this.f778f) {
            throw new IllegalStateException("InterstitialAd cannot be loaded while being displayed. Make sure your adapter calls adapterListener.onInterstitialDismissed().");
        }
        if (this.f776d != null) {
            this.f776d.m1605d();
            this.f776d = null;
        }
        C0442f c0442f = C0442f.f756b;
        this.f776d = new C0521b(this.f774b, this.f775c, C0712u.m2293a(C0442f.f756b), C0656a.INTERSTITIAL, c0442f, f773a, 1, true);
        this.f776d.m1600a(new C04471(this));
        this.f776d.m1603b();
    }

    public void m1104a(C0853k c0853k) {
        this.f779g = c0853k;
    }

    public void m1105b() {
        if (this.f776d != null) {
            this.f776d.m1605d();
            this.f776d = null;
        }
    }

    public boolean m1106c() {
        return this.f777e;
    }

    public boolean m1107d() {
        if (this.f777e) {
            this.f776d.m1604c();
            this.f778f = true;
            this.f777e = false;
            return true;
        } else if (this.f779g == null) {
            return false;
        } else {
            this.f779g.m1050a(this, C0439c.f740e);
            return false;
        }
    }
}
