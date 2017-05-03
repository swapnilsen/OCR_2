package com.facebook.ads.internal.view.p038c.p042b;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.facebook.ads.internal.view.C0827j;

/* renamed from: com.facebook.ads.internal.view.c.b.m */
public abstract class C0765m extends RelativeLayout implements C0764l {
    static final /* synthetic */ boolean f1833a;
    private C0827j f1834b;

    static {
        f1833a = !C0765m.class.desiredAssertionStatus();
    }

    public C0765m(Context context) {
        super(context);
    }

    public C0765m(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setLayoutParams(new LayoutParams(-1, -1));
    }

    public void m2392a(C0827j c0827j) {
        this.f1834b = c0827j;
        a_(c0827j);
    }

    protected void a_(C0827j c0827j) {
    }

    protected C0827j getVideoView() {
        if (f1833a || this.f1834b != null) {
            return this.f1834b;
        }
        throw new AssertionError();
    }
}
