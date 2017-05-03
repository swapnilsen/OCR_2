package com.facebook.ads.internal.p024b;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.ads.internal.p021m.al;
import com.facebook.ads.internal.p025h.C0580g;
import com.facebook.ads.internal.p037k.C0652a;
import com.facebook.ads.internal.view.C0729a;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.facebook.ads.internal.b.v */
public class C0516v extends C0472f {
    private static final String f1077c;
    private final C0729a f1078d;
    private final Context f1079e;
    private C0514u f1080f;
    private boolean f1081g;

    /* renamed from: com.facebook.ads.internal.b.v.1 */
    class C05151 implements Runnable {
        final /* synthetic */ C0516v f1076a;

        C05151(C0516v c0516v) {
            this.f1076a = c0516v;
        }

        public void run() {
            if (this.f1076a.f1078d.m2349e()) {
                Log.w(C0516v.f1077c, "Webview already destroyed, cannot activate");
            } else {
                this.f1076a.f1078d.loadUrl("javascript:" + this.f1076a.f1080f.m1504b());
            }
        }
    }

    static {
        f1077c = C0516v.class.getSimpleName();
    }

    public C0516v(Context context, C0729a c0729a, C0652a c0652a, C0476h c0476h) {
        super(context, c0476h, c0652a);
        this.f1079e = context.getApplicationContext();
        this.f1078d = c0729a;
    }

    private void m1514b(Map<String, String> map) {
        if (this.f1080f != null) {
            if (TextUtils.isEmpty(this.f1080f.m1498C())) {
                if (!TextUtils.isEmpty(this.f1080f.m1505c())) {
                    new al(map).execute(new String[]{r0});
                    return;
                }
                return;
            }
            if (map != null) {
                map.remove("evt");
            }
            C0580g.m1799a(this.f1079e).m1812b(this.f1080f.m1498C(), map);
        }
    }

    public void m1516a(C0514u c0514u) {
        this.f1080f = c0514u;
    }

    protected void m1517a(Map<String, String> map) {
        if (this.f1080f != null) {
            if (!(this.f1078d == null || TextUtils.isEmpty(this.f1080f.m1506d()))) {
                if (this.f1078d.m2349e()) {
                    Log.w(f1077c, "Webview already destroyed, cannot send impression");
                } else {
                    this.f1078d.loadUrl("javascript:" + this.f1080f.m1506d());
                }
            }
            map.put("evt", "native_imp");
            m1514b((Map) map);
        }
    }

    public synchronized void m1518b() {
        if (!(this.f1081g || this.f1080f == null)) {
            this.f1081g = true;
            if (!(this.f1078d == null || TextUtils.isEmpty(this.f1080f.m1504b()))) {
                this.f1078d.post(new C05151(this));
            }
        }
    }

    public void m1519c() {
        Map hashMap = new HashMap();
        hashMap.put("evt", "interstitial_displayed");
        this.b.m2090a(hashMap);
        m1514b(hashMap);
    }
}
