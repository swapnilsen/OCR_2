package com.facebook.ads.internal.p021m;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings.System;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import com.facebook.ads.internal.p025h.C0578f;
import com.facebook.ads.internal.p028c.C0522a;
import com.facebook.ads.internal.p028c.C0523b;
import com.facebook.ads.internal.p028c.C0525c;
import com.facebook.ads.internal.p028c.C0525c.C0524a;
import com.google.api.client.http.ExponentialBackOffPolicy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.facebook.ads.internal.m.j */
public class C0689j {
    private final String f1642a;
    private boolean f1643b;
    private final Context f1644c;
    private final C0578f f1645d;
    private final C0697a f1646e;
    private final String f1647f;
    private final C0522a f1648g;
    private int f1649h;
    private int f1650i;
    private final C0677d f1651j;

    /* renamed from: com.facebook.ads.internal.m.j.1 */
    class C06951 extends C0523b {
        final /* synthetic */ String f1686e;
        final /* synthetic */ C0578f f1687f;
        final /* synthetic */ C0689j f1688g;

        C06951(C0689j c0689j, double d, double d2, double d3, boolean z, String str, C0578f c0578f) {
            this.f1688g = c0689j;
            this.f1686e = str;
            this.f1687f = c0578f;
            super(d, d2, d3, z);
        }

        protected void m2261a(boolean z, boolean z2, C0525c c0525c) {
            if (this.f1688g.m2232a(C0698b.MRC) == null) {
                return;
            }
            if (this.f1686e.isEmpty()) {
                this.f1687f.m1788a(this.f1688g.m2232a(C0698b.MRC), this.f1688g.m2221a());
            } else {
                this.f1687f.m1792d(this.f1686e, this.f1688g.m2228b(C0698b.MRC));
            }
        }
    }

    /* renamed from: com.facebook.ads.internal.m.j.2 */
    class C06962 extends C0523b {
        final /* synthetic */ String f1689e;
        final /* synthetic */ C0578f f1690f;
        final /* synthetic */ C0689j f1691g;

        C06962(C0689j c0689j, double d, double d2, double d3, boolean z, String str, C0578f c0578f) {
            this.f1691g = c0689j;
            this.f1689e = str;
            this.f1690f = c0578f;
            super(d, d2, d3, z);
        }

        protected void m2262a(boolean z, boolean z2, C0525c c0525c) {
            if (this.f1689e.isEmpty()) {
                String a = this.f1691g.m2232a(C0698b.VIEWABLE_IMPRESSION);
                if (a != null) {
                    this.f1690f.m1788a(a, this.f1691g.m2221a());
                    return;
                }
                return;
            }
            this.f1690f.m1792d(this.f1689e, this.f1691g.m2228b(C0698b.VIEWABLE_IMPRESSION));
        }
    }

    /* renamed from: com.facebook.ads.internal.m.j.a */
    public interface C0697a {
        boolean m2263a();

        boolean m2264b();

        boolean m2265c();

        int getCurrentPosition();

        boolean getGlobalVisibleRect(Rect rect);

        long getInitialBufferTime();

        int getMeasuredHeight();

        int getMeasuredWidth();

        float getVolume();
    }

    /* renamed from: com.facebook.ads.internal.m.j.b */
    protected enum C0698b {
        PLAY(0),
        SKIP(1),
        TIME(2),
        MRC(3),
        PAUSE(4),
        RESUME(5),
        MUTE(6),
        UNMUTE(7),
        VIEWABLE_IMPRESSION(10);
        
        public final int f1702j;

        private C0698b(int i) {
            this.f1702j = i;
        }
    }

    public C0689j(Context context, C0578f c0578f, C0697a c0697a, String str, String str2) {
        this(context, c0578f, c0697a, str, str2, null);
    }

    public C0689j(Context context, C0578f c0578f, C0697a c0697a, String str, String str2, @Nullable Bundle bundle) {
        this.f1643b = true;
        this.f1649h = 0;
        this.f1650i = 0;
        this.f1644c = context;
        this.f1645d = c0578f;
        this.f1646e = c0697a;
        this.f1647f = str;
        this.f1642a = str2;
        List arrayList = new ArrayList();
        arrayList.add(new C06951(this, ExponentialBackOffPolicy.DEFAULT_RANDOMIZATION_FACTOR, -1.0d, 2.0d, true, str2, c0578f));
        arrayList.add(new C06962(this, 1.0E-7d, -1.0d, 0.001d, false, str2, c0578f));
        if (bundle != null) {
            this.f1648g = new C0522a(context, (View) c0697a, arrayList, bundle.getBundle("adQualityManager"));
            this.f1649h = bundle.getInt("lastProgressTimeMS");
            this.f1650i = bundle.getInt("lastBoundaryTimeMS");
        } else {
            this.f1648g = new C0522a(context, (View) c0697a, arrayList);
        }
        this.f1651j = new C0677d(new Handler(), this);
    }

    private Map<String, String> m2221a() {
        return m2230c(this.f1646e.getCurrentPosition());
    }

    private Map<String, String> m2222a(C0698b c0698b, int i) {
        Map<String, String> c = m2230c(i);
        c.put("action", String.valueOf(c0698b.f1702j));
        return c;
    }

    private void m2225a(int i, boolean z) {
        if (((double) i) > 0.0d && i >= this.f1649h) {
            if (i > this.f1649h) {
                this.f1648g.m1610a((double) (((float) (i - this.f1649h)) / 1000.0f), (double) m2238d());
                this.f1649h = i;
                if (i - this.f1650i >= 5000) {
                    if (!this.f1642a.isEmpty()) {
                        this.f1645d.m1792d(this.f1642a, m2222a(C0698b.TIME, i));
                    } else if (m2232a(C0698b.TIME) != null) {
                        this.f1645d.m1788a(m2232a(C0698b.TIME), m2230c(i));
                    }
                    this.f1650i = this.f1649h;
                    this.f1648g.m1609a();
                    return;
                }
            }
            if (!z) {
                return;
            }
            Map a;
            if (!this.f1642a.isEmpty()) {
                a = m2222a(C0698b.TIME, i);
                a.put("time", String.valueOf(((float) i) / 1000.0f));
                this.f1645d.m1792d(this.f1642a, a);
            } else if (m2232a(C0698b.TIME) != null) {
                a = m2230c(i);
                a.put("time", String.valueOf(((float) i) / 1000.0f));
                this.f1645d.m1788a(m2232a(C0698b.TIME), a);
            }
        }
    }

    private void m2226a(Map<String, String> map) {
        map.put("exoplayer", String.valueOf(this.f1646e.m2264b()));
        map.put("prep", Long.toString(this.f1646e.getInitialBufferTime()));
    }

    private void m2227a(Map<String, String> map, int i) {
        map.put("ptime", String.valueOf(((float) this.f1650i) / 1000.0f));
        map.put("time", String.valueOf(((float) i) / 1000.0f));
    }

    private Map<String, String> m2228b(C0698b c0698b) {
        return m2222a(c0698b, this.f1646e.getCurrentPosition());
    }

    private void m2229b(Map<String, String> map) {
        C0525c b = this.f1648g.m1611b();
        C0524a b2 = b.m1623b();
        map.put("vwa", String.valueOf(b2.m1616c()));
        map.put("vwm", String.valueOf(b2.m1615b()));
        map.put("vwmax", String.valueOf(b2.m1617d()));
        map.put("vtime_ms", String.valueOf(b2.m1619f() * 1000.0d));
        map.put("mcvt_ms", String.valueOf(b2.m1620g() * 1000.0d));
        C0524a c = b.m1625c();
        map.put("vla", String.valueOf(c.m1616c()));
        map.put("vlm", String.valueOf(c.m1615b()));
        map.put("vlmax", String.valueOf(c.m1617d()));
        map.put("atime_ms", String.valueOf(c.m1619f() * 1000.0d));
        map.put("mcat_ms", String.valueOf(c.m1620g() * 1000.0d));
    }

    private Map<String, String> m2230c(int i) {
        Map hashMap = new HashMap();
        C0700l.m2267a(hashMap, this.f1646e.m2263a(), !this.f1646e.m2265c());
        m2226a(hashMap);
        m2229b(hashMap);
        m2227a(hashMap, i);
        m2231c(hashMap);
        return hashMap;
    }

    private void m2231c(Map<String, String> map) {
        Rect rect = new Rect();
        this.f1646e.getGlobalVisibleRect(rect);
        map.put("pt", String.valueOf(rect.top));
        map.put("pl", String.valueOf(rect.left));
        map.put("ph", String.valueOf(this.f1646e.getMeasuredHeight()));
        map.put("pw", String.valueOf(this.f1646e.getMeasuredWidth()));
        WindowManager windowManager = (WindowManager) this.f1644c.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        map.put("vph", String.valueOf(displayMetrics.heightPixels));
        map.put("vpw", String.valueOf(displayMetrics.widthPixels));
    }

    protected String m2232a(C0698b c0698b) {
        return this.f1647f + "&action=" + c0698b.f1702j;
    }

    public void m2233a(int i) {
        m2225a(i, false);
    }

    public void m2234a(int i, int i2) {
        m2225a(i, true);
        this.f1650i = i2;
        this.f1649h = i2;
        this.f1648g.m1609a();
    }

    public void m2235b() {
        this.f1644c.getContentResolver().registerContentObserver(System.CONTENT_URI, true, this.f1651j);
    }

    public void m2236b(int i) {
        m2225a(i, true);
        this.f1650i = 0;
        this.f1649h = 0;
        this.f1648g.m1609a();
    }

    public void m2237c() {
        this.f1644c.getContentResolver().unregisterContentObserver(this.f1651j);
    }

    protected float m2238d() {
        return C0700l.m2266a(this.f1644c) * this.f1646e.getVolume();
    }

    public void m2239e() {
        if (((double) m2238d()) < 0.05d) {
            if (this.f1643b) {
                m2240f();
                this.f1643b = false;
            }
        } else if (!this.f1643b) {
            m2241g();
            this.f1643b = true;
        }
    }

    public void m2240f() {
        if (this.f1642a.isEmpty()) {
            this.f1645d.m1788a(m2232a(C0698b.MUTE), m2221a());
        } else {
            this.f1645d.m1792d(this.f1642a, m2228b(C0698b.MUTE));
        }
    }

    public void m2241g() {
        if (this.f1642a.isEmpty()) {
            this.f1645d.m1788a(m2232a(C0698b.UNMUTE), m2221a());
        } else {
            this.f1645d.m1792d(this.f1642a, m2228b(C0698b.UNMUTE));
        }
    }

    public void m2242h() {
        if (this.f1642a.isEmpty()) {
            this.f1645d.m1788a(m2232a(C0698b.SKIP), m2221a());
        } else {
            this.f1645d.m1792d(this.f1642a, m2228b(C0698b.SKIP));
        }
    }

    public void m2243i() {
        if (this.f1642a.isEmpty()) {
            this.f1645d.m1788a(m2232a(C0698b.PAUSE), m2221a());
        } else {
            this.f1645d.m1792d(this.f1642a, m2228b(C0698b.PAUSE));
        }
    }

    public void m2244j() {
        if (this.f1642a.isEmpty()) {
            this.f1645d.m1788a(m2232a(C0698b.RESUME), m2221a());
        } else {
            this.f1645d.m1792d(this.f1642a, m2228b(C0698b.RESUME));
        }
    }

    public int m2245k() {
        return this.f1649h;
    }
}
