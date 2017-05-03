package com.facebook.ads.internal.p024b;

import android.content.Context;
import com.facebook.ads.internal.p021m.C0712u;
import com.facebook.ads.internal.p037k.C0652a;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.facebook.ads.internal.b.f */
public abstract class C0472f {
    protected final C0476h f848a;
    protected final C0652a f849b;
    private final Context f850c;
    private boolean f851d;

    public C0472f(Context context, C0476h c0476h, C0652a c0652a) {
        this.f850c = context;
        this.f848a = c0476h;
        this.f849b = c0652a;
    }

    public final void m1186a() {
        if (!this.f851d) {
            if (this.f848a != null) {
                this.f848a.m1246d();
            }
            Map hashMap = new HashMap();
            if (this.f849b != null) {
                this.f849b.m2090a(hashMap);
            }
            m1187a(hashMap);
            this.f851d = true;
            C0712u.m2307a(this.f850c, "Impression logged");
            if (this.f848a != null) {
                this.f848a.m1247e();
            }
        }
    }

    protected abstract void m1187a(Map<String, String> map);
}
