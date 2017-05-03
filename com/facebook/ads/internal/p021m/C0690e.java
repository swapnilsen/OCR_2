package com.facebook.ads.internal.p021m;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import com.facebook.ads.internal.p021m.C0690e;
import com.facebook.ads.internal.p025h.C0492s;
import com.facebook.ads.internal.p025h.C0578f;
import com.facebook.ads.internal.view.C0827j;
import com.facebook.ads.internal.view.p038c.p039a.C0678t;
import com.facebook.ads.internal.view.p038c.p039a.C0681m;
import com.facebook.ads.internal.view.p038c.p039a.C0739b;
import com.facebook.ads.internal.view.p038c.p039a.C0745h;
import com.facebook.ads.internal.view.p038c.p039a.C0747j;
import com.facebook.ads.internal.view.p038c.p039a.C0749l;
import com.facebook.ads.internal.view.p038c.p039a.C0750n;
import com.facebook.ads.internal.view.p038c.p039a.C0752p;
import com.facebook.ads.internal.view.p038c.p039a.C0753q;
import com.facebook.ads.internal.view.p038c.p039a.C0755s;
import com.facebook.ads.internal.view.p038c.p039a.C0756u;
import com.facebook.ads.internal.view.p038c.p039a.C0757v;
import com.google.api.client.http.HttpStatusCodes;

/* renamed from: com.facebook.ads.internal.m.e */
public class C0690e extends C0689j {
    public int f1652a;
    private final C0678t f1653b;
    private final C0492s<C0753q> f1654c;
    private final C0492s<C0745h> f1655d;
    private final C0492s<C0747j> f1656e;
    private final C0492s<C0750n> f1657f;
    private final C0492s<C0739b> f1658g;
    private final C0492s<C0752p> f1659h;
    private final C0492s<C0756u> f1660i;
    private final C0492s<C0757v> f1661j;
    private final C0681m f1662k;
    private final C0827j f1663l;
    private boolean f1664m;

    /* renamed from: com.facebook.ads.internal.m.e.1 */
    class C06791 extends C0678t {
        static final /* synthetic */ boolean f1629a;
        final /* synthetic */ C0690e f1630b;

        static {
            f1629a = !C0690e.class.desiredAssertionStatus();
        }

        C06791(C0690e c0690e) {
            this.f1630b = c0690e;
        }

        public void m2196a(C0755s c0755s) {
            if (!f1629a && this.f1630b == null) {
                throw new AssertionError();
            } else if (this.f1630b != null) {
                this.f1630b.m2239e();
            }
        }
    }

    /* renamed from: com.facebook.ads.internal.m.e.2 */
    class C06802 extends C0492s<C0757v> {
        final /* synthetic */ C0690e f1631a;

        C06802(C0690e c0690e) {
            this.f1631a = c0690e;
        }

        public Class<C0757v> m2197a() {
            return C0757v.class;
        }

        public void m2199a(C0757v c0757v) {
            this.f1631a.m2237c();
        }
    }

    /* renamed from: com.facebook.ads.internal.m.e.3 */
    class C06823 extends C0681m {
        final /* synthetic */ C0690e f1632a;

        C06823(C0690e c0690e) {
            this.f1632a = c0690e;
        }

        public void m2202a(C0749l c0749l) {
            this.f1632a.f1652a = this.f1632a.f1663l.getDuration();
        }
    }

    /* renamed from: com.facebook.ads.internal.m.e.4 */
    class C06834 extends C0492s<C0753q> {
        static final /* synthetic */ boolean f1633a;
        final /* synthetic */ C0690e f1634b;

        static {
            f1633a = !C0690e.class.desiredAssertionStatus();
        }

        C06834(C0690e c0690e) {
            this.f1634b = c0690e;
        }

        public Class<C0753q> m2203a() {
            return C0753q.class;
        }

        public void m2205a(C0753q c0753q) {
            if (!f1633a && this.f1634b == null) {
                throw new AssertionError();
            } else if (this.f1634b != null) {
                this.f1634b.m2242h();
            }
        }
    }

    /* renamed from: com.facebook.ads.internal.m.e.5 */
    class C06845 extends C0492s<C0745h> {
        static final /* synthetic */ boolean f1635a;
        final /* synthetic */ C0690e f1636b;

        static {
            f1635a = !C0690e.class.desiredAssertionStatus();
        }

        C06845(C0690e c0690e) {
            this.f1636b = c0690e;
        }

        public Class<C0745h> m2206a() {
            return C0745h.class;
        }

        public void m2208a(C0745h c0745h) {
            if (!f1635a && this.f1636b == null) {
                throw new AssertionError();
            } else if (this.f1636b != null) {
                this.f1636b.m2243i();
            }
        }
    }

    /* renamed from: com.facebook.ads.internal.m.e.6 */
    class C06856 extends C0492s<C0747j> {
        static final /* synthetic */ boolean f1637a;
        final /* synthetic */ C0690e f1638b;

        static {
            f1637a = !C0690e.class.desiredAssertionStatus();
        }

        C06856(C0690e c0690e) {
            this.f1638b = c0690e;
        }

        public Class<C0747j> m2209a() {
            return C0747j.class;
        }

        public void m2211a(C0747j c0747j) {
            if (!f1637a && this.f1638b == null) {
                throw new AssertionError();
            } else if (this.f1638b != null) {
                if (this.f1638b.f1664m) {
                    this.f1638b.m2244j();
                } else {
                    this.f1638b.f1664m = true;
                }
            }
        }
    }

    /* renamed from: com.facebook.ads.internal.m.e.7 */
    class C06867 extends C0492s<C0750n> {
        final /* synthetic */ C0690e f1639a;

        C06867(C0690e c0690e) {
            this.f1639a = c0690e;
        }

        public Class<C0750n> m2212a() {
            return C0750n.class;
        }

        public void m2214a(C0750n c0750n) {
            if (this.f1639a.f1652a <= 0 || this.f1639a.f1663l.getCurrentPosition() != this.f1639a.f1663l.getDuration() || this.f1639a.f1663l.getDuration() <= this.f1639a.f1652a) {
                this.f1639a.m2233a(this.f1639a.f1663l.getCurrentPosition());
            }
        }
    }

    /* renamed from: com.facebook.ads.internal.m.e.8 */
    class C06878 extends C0492s<C0739b> {
        final /* synthetic */ C0690e f1640a;

        C06878(C0690e c0690e) {
            this.f1640a = c0690e;
        }

        public Class<C0739b> m2215a() {
            return C0739b.class;
        }

        public void m2217a(C0739b c0739b) {
            int currentPosition = this.f1640a.f1663l.getCurrentPosition();
            if (this.f1640a.f1652a > 0 && currentPosition == this.f1640a.f1663l.getDuration() && this.f1640a.f1663l.getDuration() > this.f1640a.f1652a) {
                return;
            }
            if (!(currentPosition == 0 && this.f1640a.f1663l.m2551b()) && this.f1640a.f1663l.getDuration() >= currentPosition + HttpStatusCodes.STATUS_CODE_SERVER_ERROR) {
                this.f1640a.m2236b(currentPosition);
            } else {
                this.f1640a.m2236b(this.f1640a.f1663l.getDuration());
            }
        }
    }

    /* renamed from: com.facebook.ads.internal.m.e.9 */
    class C06889 extends C0492s<C0752p> {
        final /* synthetic */ C0690e f1641a;

        C06889(C0690e c0690e) {
            this.f1641a = c0690e;
        }

        public Class<C0752p> m2218a() {
            return C0752p.class;
        }

        public void m2220a(C0752p c0752p) {
            this.f1641a.m2234a(c0752p.m2377a(), c0752p.m2378b());
        }
    }

    public C0690e(Context context, C0578f c0578f, C0827j c0827j, String str, String str2) {
        super(context, c0578f, c0827j, str, str2);
        this.f1653b = new C06791(this);
        this.f1654c = new C06834(this);
        this.f1655d = new C06845(this);
        this.f1656e = new C06856(this);
        this.f1657f = new C06867(this);
        this.f1658g = new C06878(this);
        this.f1659h = new C06889(this);
        this.f1660i = new C0492s<C0756u>() {
            final /* synthetic */ C0690e f1628a;

            {
                this.f1628a = r1;
            }

            public Class<C0756u> m2191a() {
                return C0756u.class;
            }

            public void m2193a(C0756u c0756u) {
                this.f1628a.m2235b();
            }
        };
        this.f1661j = new C06802(this);
        this.f1662k = new C06823(this);
        this.f1664m = false;
        this.f1663l = c0827j;
        c0827j.getEventBus().m1846a(this.f1653b);
        c0827j.getEventBus().m1846a(this.f1657f);
        c0827j.getEventBus().m1846a(this.f1654c);
        c0827j.getEventBus().m1846a(this.f1656e);
        c0827j.getEventBus().m1846a(this.f1655d);
        c0827j.getEventBus().m1846a(this.f1658g);
        c0827j.getEventBus().m1846a(this.f1659h);
        c0827j.getEventBus().m1846a(this.f1660i);
        c0827j.getEventBus().m1846a(this.f1661j);
        c0827j.getEventBus().m1846a(this.f1662k);
    }

    public C0690e(Context context, C0578f c0578f, C0827j c0827j, String str, String str2, @Nullable Bundle bundle) {
        super(context, c0578f, c0827j, str, str2, bundle);
        this.f1653b = new C06791(this);
        this.f1654c = new C06834(this);
        this.f1655d = new C06845(this);
        this.f1656e = new C06856(this);
        this.f1657f = new C06867(this);
        this.f1658g = new C06878(this);
        this.f1659h = new C06889(this);
        this.f1660i = new C0492s<C0756u>() {
            final /* synthetic */ C0690e f1628a;

            {
                this.f1628a = r1;
            }

            public Class<C0756u> m2191a() {
                return C0756u.class;
            }

            public void m2193a(C0756u c0756u) {
                this.f1628a.m2235b();
            }
        };
        this.f1661j = new C06802(this);
        this.f1662k = new C06823(this);
        this.f1664m = false;
        this.f1663l = c0827j;
        c0827j.getEventBus().m1846a(this.f1653b);
        c0827j.getEventBus().m1846a(this.f1657f);
        c0827j.getEventBus().m1846a(this.f1654c);
        c0827j.getEventBus().m1846a(this.f1656e);
        c0827j.getEventBus().m1846a(this.f1655d);
        c0827j.getEventBus().m1846a(this.f1658g);
        c0827j.getEventBus().m1846a(this.f1660i);
        c0827j.getEventBus().m1846a(this.f1661j);
    }

    public void m2249a() {
        this.f1663l.getEventBus().m1847b(this.f1653b);
        this.f1663l.getEventBus().m1847b(this.f1657f);
        this.f1663l.getEventBus().m1847b(this.f1654c);
        this.f1663l.getEventBus().m1847b(this.f1656e);
        this.f1663l.getEventBus().m1847b(this.f1655d);
        this.f1663l.getEventBus().m1847b(this.f1658g);
        this.f1663l.getEventBus().m1847b(this.f1660i);
        this.f1663l.getEventBus().m1847b(this.f1661j);
        this.f1663l.getEventBus().m1847b(this.f1662k);
    }
}
