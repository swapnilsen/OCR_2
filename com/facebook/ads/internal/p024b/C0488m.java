package com.facebook.ads.internal.p024b;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView.ScaleType;
import com.facebook.ads.C0869n;
import com.facebook.ads.internal.p021m.ad;
import com.facebook.ads.internal.p021m.ae;
import com.facebook.ads.internal.view.C0823f;
import com.facebook.ads.internal.view.C0844k;
import com.facebook.ads.internal.view.hscroll.C0834b;
import java.util.List;

/* renamed from: com.facebook.ads.internal.b.m */
public class C0488m extends Adapter<C0823f> {
    private static final int f911a;
    private final List<C0869n> f912b;
    private final int f913c;
    private final int f914d;

    /* renamed from: com.facebook.ads.internal.b.m.1 */
    class C04871 implements ae {
        final /* synthetic */ C0823f f909a;
        final /* synthetic */ C0488m f910b;

        C04871(C0488m c0488m, C0823f c0823f) {
            this.f910b = c0488m;
            this.f909a = c0823f;
        }

        public void m1302a() {
            this.f909a.f2014a.setBackgroundColor(C0488m.f911a);
        }
    }

    static {
        f911a = Color.argb(51, 0, 0, 0);
    }

    public C0488m(C0834b c0834b, List<C0869n> list) {
        float f = c0834b.getContext().getResources().getDisplayMetrics().density;
        this.f912b = list;
        this.f913c = Math.round(f * 1.0f);
        this.f914d = c0834b.getChildSpacing();
    }

    public C0823f m1304a(ViewGroup viewGroup, int i) {
        C0844k c0844k = new C0844k(viewGroup.getContext());
        c0844k.setScaleType(ScaleType.CENTER_CROP);
        return new C0823f(c0844k);
    }

    public void m1305a(C0823f c0823f, int i) {
        LayoutParams marginLayoutParams = new MarginLayoutParams(-2, -1);
        marginLayoutParams.setMargins(i == 0 ? this.f914d * 2 : this.f914d, 0, i >= this.f912b.size() + -1 ? this.f914d * 2 : this.f914d, 0);
        c0823f.f2014a.setBackgroundColor(0);
        c0823f.f2014a.setImageDrawable(null);
        c0823f.f2014a.setLayoutParams(marginLayoutParams);
        c0823f.f2014a.setPadding(this.f913c, this.f913c, this.f913c, this.f913c);
        C0869n c0869n = (C0869n) this.f912b.get(i);
        c0869n.m2706a(c0823f.f2014a);
        if (c0869n.m2718f() != null) {
            ad adVar = new ad(c0823f.f2014a);
            adVar.m2143a(new C04871(this, c0823f));
            adVar.m2145a(r0.m2665a());
        }
    }

    public int getItemCount() {
        return this.f912b.size();
    }

    public /* synthetic */ void onBindViewHolder(ViewHolder viewHolder, int i) {
        m1305a((C0823f) viewHolder, i);
    }

    public /* synthetic */ ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return m1304a(viewGroup, i);
    }
}
