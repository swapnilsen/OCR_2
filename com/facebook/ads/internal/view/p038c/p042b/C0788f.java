package com.facebook.ads.internal.view.p038c.p042b;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout.LayoutParams;
import com.facebook.ads.internal.p021m.ad;
import com.facebook.ads.internal.p025h.C0492s;
import com.facebook.ads.internal.view.C0827j;
import com.facebook.ads.internal.view.p038c.p039a.C0739b;
import com.facebook.ads.internal.view.p038c.p039a.C0747j;

/* renamed from: com.facebook.ads.internal.view.c.b.f */
public class C0788f extends C0765m implements OnLayoutChangeListener {
    private final ImageView f1878b;
    private final C0492s<C0747j> f1879c;
    private final C0492s<C0739b> f1880d;

    /* renamed from: com.facebook.ads.internal.view.c.b.f.1 */
    class C07861 extends C0492s<C0747j> {
        final /* synthetic */ C0788f f1876a;

        C07861(C0788f c0788f) {
            this.f1876a = c0788f;
        }

        public Class<C0747j> m2426a() {
            return C0747j.class;
        }

        public void m2428a(C0747j c0747j) {
            this.f1876a.setVisibility(8);
        }
    }

    /* renamed from: com.facebook.ads.internal.view.c.b.f.2 */
    class C07872 extends C0492s<C0739b> {
        final /* synthetic */ C0788f f1877a;

        C07872(C0788f c0788f) {
            this.f1877a = c0788f;
        }

        public Class<C0739b> m2429a() {
            return C0739b.class;
        }

        public void m2431a(C0739b c0739b) {
            this.f1877a.setVisibility(0);
        }
    }

    public C0788f(Context context) {
        super(context);
        this.f1879c = new C07861(this);
        this.f1880d = new C07872(this);
        this.f1878b = new ImageView(context);
        this.f1878b.setScaleType(ScaleType.FIT_CENTER);
        this.f1878b.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
    }

    protected void a_(C0827j c0827j) {
        c0827j.getEventBus().m1846a(this.f1879c);
        c0827j.getEventBus().m1846a(this.f1880d);
        c0827j.addOnLayoutChangeListener(this);
        super.a_(c0827j);
    }

    public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        LayoutParams layoutParams = (LayoutParams) getLayoutParams();
        int i9 = i4 - i2;
        int i10 = i3 - i;
        if (layoutParams.height != i9 || layoutParams.width != i10 || layoutParams.topMargin != i2 || layoutParams.leftMargin != i) {
            ViewGroup.LayoutParams layoutParams2 = new LayoutParams(i10, i9);
            layoutParams2.topMargin = i2;
            layoutParams2.leftMargin = i;
            this.f1878b.setLayoutParams(new LayoutParams(i10, i9));
            if (this.f1878b.getParent() == null) {
                addView(this.f1878b);
            }
            setLayoutParams(layoutParams2);
        }
    }

    public void setImage(@Nullable String str) {
        if (str == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        new ad(this.f1878b).m2145a(str);
    }
}
