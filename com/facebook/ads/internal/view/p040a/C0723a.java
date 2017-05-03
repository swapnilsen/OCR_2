package com.facebook.ads.internal.view.p040a;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.net.Uri;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import com.facebook.ads.internal.p021m.af;
import com.facebook.ads.internal.p021m.ah;
import java.util.List;
import net.nend.android.NendAdIconLayout;
import net.nend.android.NendIconError;

@TargetApi(19)
/* renamed from: com.facebook.ads.internal.view.a.a */
public class C0723a extends LinearLayout {
    private static final int f1769a;
    private static final Uri f1770b;
    private static final OnTouchListener f1771c;
    private static final int f1772d;
    private ImageView f1773e;
    private C0725c f1774f;
    private ImageView f1775g;
    private C0722a f1776h;
    private String f1777i;

    /* renamed from: com.facebook.ads.internal.view.a.a.1 */
    static class C07191 implements OnTouchListener {
        C07191() {
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            switch (motionEvent.getAction()) {
                case NendAdIconLayout.HORIZONTAL /*0*/:
                    view.setBackgroundColor(C0723a.f1772d);
                    break;
                case NendIconError.ERROR_ICONVIEW /*1*/:
                    view.setBackgroundColor(0);
                    break;
            }
            return false;
        }
    }

    /* renamed from: com.facebook.ads.internal.view.a.a.2 */
    class C07202 implements OnClickListener {
        final /* synthetic */ C0723a f1767a;

        C07202(C0723a c0723a) {
            this.f1767a = c0723a;
        }

        public void onClick(View view) {
            if (this.f1767a.f1776h != null) {
                this.f1767a.f1776h.m2334a();
            }
        }
    }

    /* renamed from: com.facebook.ads.internal.view.a.a.3 */
    class C07213 implements OnClickListener {
        final /* synthetic */ C0723a f1768a;

        C07213(C0723a c0723a) {
            this.f1768a = c0723a;
        }

        public void onClick(View view) {
            if (!TextUtils.isEmpty(this.f1768a.f1777i) && !"about:blank".equals(this.f1768a.f1777i)) {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(this.f1768a.f1777i));
                intent.addFlags(268435456);
                this.f1768a.getContext().startActivity(intent);
            }
        }
    }

    /* renamed from: com.facebook.ads.internal.view.a.a.a */
    public interface C0722a {
        void m2334a();
    }

    static {
        f1769a = Color.rgb(224, 224, 224);
        f1770b = Uri.parse("http://www.facebook.com");
        f1771c = new C07191();
        f1772d = Color.argb(34, 0, 0, 0);
    }

    public C0723a(Context context) {
        super(context);
        m2337a(context);
    }

    private void m2337a(Context context) {
        float f = getResources().getDisplayMetrics().density;
        int i = (int) (50.0f * f);
        int i2 = (int) (f * 4.0f);
        setBackgroundColor(-1);
        setGravity(16);
        this.f1773e = new ImageView(context);
        LayoutParams layoutParams = new LinearLayout.LayoutParams(i, i);
        this.f1773e.setScaleType(ScaleType.CENTER);
        this.f1773e.setImageBitmap(ah.m2153a(context, af.BROWSER_CLOSE));
        this.f1773e.setOnTouchListener(f1771c);
        this.f1773e.setOnClickListener(new C07202(this));
        addView(this.f1773e, layoutParams);
        this.f1774f = new C0725c(context);
        layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        this.f1774f.setPadding(0, i2, 0, i2);
        addView(this.f1774f, layoutParams);
        this.f1775g = new ImageView(context);
        LayoutParams layoutParams2 = new LinearLayout.LayoutParams(i, i);
        this.f1775g.setScaleType(ScaleType.CENTER);
        this.f1775g.setOnTouchListener(f1771c);
        this.f1775g.setOnClickListener(new C07213(this));
        addView(this.f1775g, layoutParams2);
        setupDefaultNativeBrowser(context);
    }

    private void setupDefaultNativeBrowser(Context context) {
        Bitmap bitmap;
        List queryIntentActivities = context.getPackageManager().queryIntentActivities(new Intent("android.intent.action.VIEW", f1770b), AccessibilityNodeInfoCompat.ACTION_CUT);
        if (queryIntentActivities.size() == 0) {
            this.f1775g.setVisibility(8);
            bitmap = null;
        } else {
            bitmap = (queryIntentActivities.size() == 1 && "com.android.chrome".equals(((ResolveInfo) queryIntentActivities.get(0)).activityInfo.packageName)) ? ah.m2153a(context, af.BROWSER_LAUNCH_CHROME) : ah.m2153a(context, af.BROWSER_LAUNCH_NATIVE);
        }
        this.f1775g.setImageBitmap(bitmap);
    }

    public void setListener(C0722a c0722a) {
        this.f1776h = c0722a;
    }

    public void setTitle(String str) {
        this.f1774f.setTitle(str);
    }

    public void setUrl(String str) {
        this.f1777i = str;
        if (TextUtils.isEmpty(str) || "about:blank".equals(str)) {
            this.f1774f.setSubtitle(null);
            this.f1775g.setEnabled(false);
            this.f1775g.setColorFilter(new PorterDuffColorFilter(f1769a, Mode.SRC_IN));
            return;
        }
        this.f1774f.setSubtitle(str);
        this.f1775g.setEnabled(true);
        this.f1775g.setColorFilter(null);
    }
}
