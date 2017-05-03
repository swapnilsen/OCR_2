package com.facebook.ads.internal.view.p038c.p042b;

import android.content.Context;
import android.graphics.PorterDuff.Mode;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ViewGroup.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.facebook.ads.internal.p025h.C0492s;
import com.facebook.ads.internal.view.C0827j;
import com.facebook.ads.internal.view.p038c.p039a.C0749l;

/* renamed from: com.facebook.ads.internal.view.c.b.i */
public class C0797i extends C0765m {
    private final ProgressBar f1905b;
    private final C0492s<C0749l> f1906c;

    /* renamed from: com.facebook.ads.internal.view.c.b.i.1 */
    class C07961 extends C0492s<C0749l> {
        final /* synthetic */ C0797i f1904a;

        C07961(C0797i c0797i) {
            this.f1904a = c0797i;
        }

        public Class<C0749l> m2450a() {
            return C0749l.class;
        }

        public void m2452a(C0749l c0749l) {
            this.f1904a.setVisibility(8);
        }
    }

    public C0797i(Context context) {
        this(context, null);
    }

    public C0797i(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public C0797i(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1906c = new C07961(this);
        int applyDimension = (int) TypedValue.applyDimension(1, 40.0f, getResources().getDisplayMetrics());
        this.f1905b = new ProgressBar(getContext());
        this.f1905b.setIndeterminate(true);
        this.f1905b.getIndeterminateDrawable().setColorFilter(-1, Mode.SRC_IN);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(applyDimension, applyDimension);
        layoutParams.addRule(13);
        addView(this.f1905b, layoutParams);
    }

    protected void a_(C0827j c0827j) {
        setVisibility(0);
        c0827j.getEventBus().m1846a(this.f1906c);
    }
}
