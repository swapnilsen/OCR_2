package com.facebook.ads;

import android.content.Context;
import android.content.res.Configuration;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.RelativeLayout;
import com.facebook.ads.internal.C0443c;
import com.facebook.ads.internal.C0521b;
import com.facebook.ads.internal.C0536d;
import com.facebook.ads.internal.C0539e;
import com.facebook.ads.internal.p021m.C0712u;
import com.facebook.ads.internal.p024b.C0471a;
import com.facebook.ads.internal.p027l.C0656a;
import com.facebook.ads.internal.view.C0737b;

/* renamed from: com.facebook.ads.g */
public class C0445g extends RelativeLayout implements C0432a {
    private static final C0539e f763a;
    private final DisplayMetrics f764b;
    private final C0442f f765c;
    private final String f766d;
    private C0521b f767e;
    private C0440d f768f;
    private C0446h f769g;
    private View f770h;
    private volatile boolean f771i;

    /* renamed from: com.facebook.ads.g.1 */
    class C04441 extends C0443c {
        final /* synthetic */ C0445g f762a;

        C04441(C0445g c0445g) {
            this.f762a = c0445g;
        }

        public void m1075a() {
            if (this.f762a.f768f != null) {
                this.f762a.f768f.m1051b(this.f762a);
            }
        }

        public void m1076a(View view) {
            if (view == null) {
                throw new IllegalStateException("Cannot present null view");
            }
            this.f762a.f770h = view;
            this.f762a.removeAllViews();
            this.f762a.addView(this.f762a.f770h);
            if (this.f762a.f770h instanceof C0737b) {
                C0712u.m2308a(this.f762a.f764b, this.f762a.f770h, this.f762a.f765c);
            }
            if (this.f762a.f768f != null) {
                this.f762a.f768f.m1049a(this.f762a);
            }
        }

        public void m1077a(C0471a c0471a) {
            if (this.f762a.f767e != null) {
                this.f762a.f767e.m1604c();
            }
        }

        public void m1078a(C0536d c0536d) {
            if (this.f762a.f768f != null) {
                this.f762a.f768f.m1050a(this.f762a, c0536d.m1661b());
            }
        }

        public void m1079b() {
            if (this.f762a.f769g != null) {
                this.f762a.f769g.m1089a(this.f762a);
            }
            if ((this.f762a.f768f instanceof C0446h) && this.f762a.f768f != this.f762a.f769g) {
                ((C0446h) this.f762a.f768f).m1089a(this.f762a);
            }
        }
    }

    static {
        f763a = C0539e.ADS;
    }

    public C0445g(Context context, String str, C0442f c0442f) {
        super(context);
        if (c0442f == null || c0442f == C0442f.f756b) {
            throw new IllegalArgumentException("adSize");
        }
        this.f764b = getContext().getResources().getDisplayMetrics();
        this.f765c = c0442f;
        this.f766d = str;
        this.f767e = new C0521b(context, str, C0712u.m2293a(c0442f), C0656a.BANNER, c0442f, f763a, 1, false);
        this.f767e.m1600a(new C04441(this));
    }

    public void m1087a() {
        if (!this.f771i) {
            this.f767e.m1603b();
            this.f771i = true;
        } else if (this.f767e != null) {
            this.f767e.m1608g();
        }
    }

    public void m1088b() {
        if (this.f767e != null) {
            this.f767e.m1605d();
            this.f767e = null;
        }
        removeAllViews();
        this.f770h = null;
    }

    public String getPlacementId() {
        return this.f766d;
    }

    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.f770h != null) {
            C0712u.m2308a(this.f764b, this.f770h, this.f765c);
        }
    }

    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (this.f767e != null) {
            if (i == 0) {
                this.f767e.m1607f();
            } else if (i == 8) {
                this.f767e.m1606e();
            }
        }
    }

    public void setAdListener(C0440d c0440d) {
        this.f768f = c0440d;
    }

    @Deprecated
    public void setImpressionListener(C0446h c0446h) {
        this.f769g = c0446h;
    }
}
