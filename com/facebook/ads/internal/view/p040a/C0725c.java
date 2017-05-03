package com.facebook.ads.internal.view.p040a;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.ads.internal.p021m.af;
import com.facebook.ads.internal.p021m.ah;

@TargetApi(19)
/* renamed from: com.facebook.ads.internal.view.a.c */
public class C0725c extends LinearLayout {
    private TextView f1782a;
    private TextView f1783b;
    private Drawable f1784c;

    public C0725c(Context context) {
        super(context);
        m2341a();
    }

    private void m2341a() {
        float f = getResources().getDisplayMetrics().density;
        setOrientation(1);
        this.f1782a = new TextView(getContext());
        LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        this.f1782a.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        this.f1782a.setTextSize(2, 20.0f);
        this.f1782a.setEllipsize(TruncateAt.END);
        this.f1782a.setSingleLine(true);
        this.f1782a.setVisibility(8);
        addView(this.f1782a, layoutParams);
        this.f1783b = new TextView(getContext());
        layoutParams = new LinearLayout.LayoutParams(-1, -2);
        this.f1783b.setAlpha(0.5f);
        this.f1783b.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        this.f1783b.setTextSize(2, 15.0f);
        this.f1783b.setCompoundDrawablePadding((int) (f * 5.0f));
        this.f1783b.setEllipsize(TruncateAt.END);
        this.f1783b.setSingleLine(true);
        this.f1783b.setVisibility(8);
        addView(this.f1783b, layoutParams);
    }

    private Drawable getPadlockDrawable() {
        if (this.f1784c == null) {
            this.f1784c = ah.m2154b(getContext(), af.BROWSER_PADLOCK);
        }
        return this.f1784c;
    }

    public void setSubtitle(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f1783b.setText(null);
            this.f1783b.setVisibility(8);
            return;
        }
        Uri parse = Uri.parse(str);
        this.f1783b.setText(parse.getHost());
        this.f1783b.setCompoundDrawablesRelativeWithIntrinsicBounds("https".equals(parse.getScheme()) ? getPadlockDrawable() : null, null, null, null);
        this.f1783b.setVisibility(0);
    }

    public void setTitle(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f1782a.setText(null);
            this.f1782a.setVisibility(8);
            return;
        }
        this.f1782a.setText(str);
        this.f1782a.setVisibility(0);
    }
}
