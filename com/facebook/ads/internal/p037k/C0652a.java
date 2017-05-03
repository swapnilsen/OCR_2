package com.facebook.ads.internal.p037k;

import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.support.v4.view.PointerIconCompat;
import android.util.DisplayMetrics;
import android.view.View;
import com.facebook.ads.internal.C0649j;
import com.facebook.ads.internal.p021m.C0467m;
import com.facebook.ads.internal.p021m.C0701n;
import com.facebook.ads.internal.p021m.C0712u;
import com.facebook.ads.internal.p021m.ac;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.internal.k.a */
public class C0652a {
    private static final String f1483a;
    private final View f1484b;
    private final int f1485c;
    private final int f1486d;
    private final C0650a f1487e;
    private final Handler f1488f;
    private final Runnable f1489g;
    private final boolean f1490h;
    private int f1491i;
    private int f1492j;
    private boolean f1493k;
    private C0653b f1494l;
    private Map<String, Integer> f1495m;
    private long f1496n;
    private int f1497o;

    /* renamed from: com.facebook.ads.internal.k.a.a */
    public static abstract class C0650a {
        public abstract void m2068a();

        public void m2069b() {
        }
    }

    /* renamed from: com.facebook.ads.internal.k.a.b */
    private static final class C0651b extends C0467m<C0652a> {
        public C0651b(C0652a c0652a) {
            super(c0652a);
        }

        public void run() {
            int i = 0;
            C0652a c0652a = (C0652a) m1183a();
            if (c0652a != null) {
                View a = c0652a.f1484b;
                C0650a b = c0652a.f1487e;
                if (a != null && b != null) {
                    C0653b a2 = C0652a.m2073a(a, c0652a.f1485c);
                    if (a2.m2093a()) {
                        c0652a.f1497o = c0652a.f1497o + 1;
                    } else {
                        c0652a.f1497o = 0;
                    }
                    int i2 = c0652a.f1497o > c0652a.f1486d ? 1 : 0;
                    int i3 = (c0652a.f1494l == null || !c0652a.f1494l.m2093a()) ? 0 : 1;
                    if (!(i2 == 0 && a2.m2093a())) {
                        c0652a.f1494l = a2;
                    }
                    String valueOf = String.valueOf(a2.m2094b());
                    synchronized (c0652a) {
                        if (c0652a.f1495m.containsKey(valueOf)) {
                            i = ((Integer) c0652a.f1495m.get(valueOf)).intValue();
                        }
                        c0652a.f1495m.put(valueOf, Integer.valueOf(i + 1));
                    }
                    if (i2 != 0 && i3 == 0) {
                        c0652a.f1496n = System.currentTimeMillis();
                        b.m2068a();
                        if (!c0652a.f1490h) {
                            return;
                        }
                    } else if (i2 == 0 && i3 != 0) {
                        b.m2069b();
                    }
                    if (!c0652a.f1493k) {
                        c0652a.f1488f.postDelayed(c0652a.f1489g, (long) c0652a.f1492j);
                    }
                }
            }
        }
    }

    static {
        f1483a = C0652a.class.getSimpleName();
    }

    public C0652a(View view, int i, int i2, boolean z, C0650a c0650a) {
        this.f1488f = new Handler();
        this.f1489g = new C0651b(this);
        this.f1491i = 0;
        this.f1492j = PointerIconCompat.TYPE_DEFAULT;
        this.f1493k = true;
        this.f1494l = new C0653b(C0654c.UNKNOWN);
        this.f1495m = new HashMap();
        this.f1496n = 0;
        this.f1497o = 0;
        this.f1484b = view;
        this.f1485c = i;
        this.f1487e = c0650a;
        this.f1490h = z;
        if (i2 < 0) {
            i2 = 0;
        }
        this.f1486d = i2;
    }

    public C0652a(View view, int i, C0650a c0650a) {
        this(view, i, 0, false, c0650a);
    }

    public static C0653b m2073a(View view, int i) {
        if (view == null) {
            C0652a.m2075a(view, false, "adView is null.");
            return new C0653b(C0654c.AD_IS_NULL);
        } else if (view.getParent() == null) {
            C0652a.m2075a(view, false, "adView has no parent.");
            return new C0653b(C0654c.INVALID_PARENT);
        } else if (view.getWindowVisibility() != 0) {
            C0652a.m2075a(view, false, "adView window is not set to VISIBLE.");
            return new C0653b(C0654c.INVALID_WINDOW);
        } else if (view.getVisibility() != 0) {
            C0652a.m2075a(view, false, "adView is not set to VISIBLE.");
            return new C0653b(C0654c.AD_IS_NOT_VISIBLE);
        } else if (view.getMeasuredWidth() <= 0 || view.getMeasuredHeight() <= 0) {
            C0652a.m2075a(view, false, "adView has invisible dimensions (w=" + view.getMeasuredWidth() + ", h=" + view.getMeasuredHeight());
            return new C0653b(C0654c.INVALID_DIMENSIONS);
        } else if (view.getAlpha() < 0.9f) {
            C0652a.m2075a(view, false, "adView is too transparent.");
            return new C0653b(C0654c.AD_IS_TRANSPARENT);
        } else {
            int width = view.getWidth();
            int height = view.getHeight();
            int[] iArr = new int[2];
            try {
                view.getLocationOnScreen(iArr);
                Context context = view.getContext();
                DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
                Rect rect = new Rect(0, 0, displayMetrics.widthPixels, displayMetrics.heightPixels);
                float f = 0.0f;
                if (rect.intersect(iArr[0], iArr[1], iArr[0] + width, iArr[1] + height)) {
                    f = (((float) (rect.width() * rect.height())) * 1.0f) / ((float) (width * height));
                }
                boolean j = C0649j.m2060j(context);
                int k = C0649j.m2061k(context);
                if (j) {
                    f *= 100.0f;
                    if (f < ((float) k)) {
                        C0652a.m2075a(view, false, String.format("adView visible area is too small [%.2f%% visible, current threshold %d%%]", new Object[]{Float.valueOf(f), Integer.valueOf(k)}));
                        return new C0653b(C0654c.AD_INSUFFICIENT_VISIBLE_AREA, f);
                    }
                } else if (iArr[0] < 0 || displayMetrics.widthPixels - iArr[0] < width) {
                    C0652a.m2075a(view, false, "adView is not fully on screen horizontally.");
                    return new C0653b(C0654c.AD_OFFSCREEN_HORIZONTALLY, f);
                } else {
                    width = (int) ((((double) height) * (100.0d - ((double) i))) / 100.0d);
                    if (iArr[1] < 0 && Math.abs(iArr[1]) > width) {
                        C0652a.m2075a(view, false, "adView is not visible from the top.");
                        return new C0653b(C0654c.AD_OFFSCREEN_TOP, f);
                    } else if ((height + iArr[1]) - displayMetrics.heightPixels > width) {
                        C0652a.m2075a(view, false, "adView is not visible from the bottom.");
                        return new C0653b(C0654c.AD_OFFSCREEN_BOTTOM, f);
                    }
                }
                if (ac.m2141b(context)) {
                    Map a = C0701n.m2268a(context);
                    if (C0701n.m2269a(a)) {
                        C0652a.m2075a(view, false, "Keyguard is obstructing view.");
                        return new C0653b(C0654c.AD_IS_OBSTRUCTED_BY_KEYGUARD, f);
                    } else if (C0649j.m2052b(context) && C0701n.m2271b(a)) {
                        C0652a.m2075a(view, false, "Ad is on top of the Lockscreen.");
                        return new C0653b(C0654c.AD_IN_LOCKSCREEN, f, a);
                    } else {
                        C0652a.m2075a(view, true, "adView is visible.");
                        return new C0653b(C0654c.IS_VIEWABLE, f, a);
                    }
                }
                C0652a.m2075a(view, false, "Screen is not interactive.");
                return new C0653b(C0654c.SCREEN_NOT_INTERACTIVE, f);
            } catch (NullPointerException e) {
                C0652a.m2075a(view, false, "Cannot get location on screen.");
                return new C0653b(C0654c.INVALID_DIMENSIONS);
            }
        }
    }

    private static void m2075a(View view, boolean z, String str) {
    }

    public void m2088a() {
        this.f1488f.postDelayed(this.f1489g, (long) this.f1491i);
        this.f1493k = false;
        this.f1497o = 0;
    }

    public void m2089a(int i) {
        this.f1491i = i;
    }

    public void m2090a(Map<String, String> map) {
        map.put("vrc", String.valueOf(this.f1494l.m2094b()));
        map.put("vp", String.valueOf(this.f1494l.m2095c()));
        map.put("vh", new JSONObject(this.f1495m).toString());
        map.put("vt", C0712u.m2297a(this.f1496n));
        map.putAll(this.f1494l.m2096d());
    }

    public void m2091b() {
        this.f1488f.removeCallbacks(this.f1489g);
        this.f1493k = true;
        this.f1497o = 0;
    }

    public void m2092b(int i) {
        this.f1492j = i;
    }
}
