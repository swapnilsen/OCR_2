package com.facebook.ads.internal.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

/* renamed from: com.facebook.ads.internal.view.n */
public class C0851n extends View {
    private C0850m f2117a;

    public C0851n(Context context, C0850m c0850m) {
        super(context);
        this.f2117a = c0850m;
        setLayoutParams(new LayoutParams(0, 0));
    }

    public void onWindowVisibilityChanged(int i) {
        if (this.f2117a != null) {
            this.f2117a.m2632a(i);
        }
    }
}
