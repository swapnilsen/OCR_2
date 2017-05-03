package com.facebook.ads.internal.p024b;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.C0268R;
import android.text.TextUtils.TruncateAt;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.ads.AudienceNetworkActivity;
import com.facebook.ads.AudienceNetworkActivity.C0420a;
import com.facebook.ads.internal.p021m.ad;
import com.facebook.ads.internal.p024b.C0501p.C0500a;
import com.facebook.ads.internal.view.C0504c;
import com.facebook.ads.internal.view.C0504c.C0417a;
import com.facebook.ads.internal.view.p038c.p039a.C0754r;
import com.facebook.ads.internal.view.p038c.p042b.C0764l;
import com.facebook.ads.internal.view.p038c.p042b.C0766a.C0763a;
import com.facebook.ads.internal.view.p038c.p042b.C0783d;
import com.facebook.ads.internal.view.p038c.p042b.C0783d.C0782a;
import com.facebook.ads.internal.view.p038c.p042b.C0788f;
import com.facebook.ads.internal.view.p038c.p042b.C0795h;
import com.facebook.ads.internal.view.p038c.p042b.C0797i;
import com.facebook.ads.internal.view.p038c.p042b.C0802j;
import com.facebook.ads.internal.view.p038c.p042b.C0807n;
import com.facebook.ads.internal.view.p041b.C0736a;
import com.google.ads.mediation.facebook.FacebookAdapter;
import com.google.android.gms.plus.PlusShare;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.internal.b.q */
public class C0505q extends C0498o implements OnTouchListener, C0504c {
    static final /* synthetic */ boolean f963h;
    final int f964e;
    final int f965f;
    final int f966g;
    @Nullable
    private C0417a f967i;
    @Nullable
    private Activity f968j;
    private C0420a f969k;
    private final OnTouchListener f970l;
    private C0500a f971m;
    private C0736a f972n;
    private TextView f973o;
    private TextView f974p;
    private ImageView f975q;
    private C0763a f976r;
    private C0807n f977s;
    private ViewGroup f978t;
    private C0783d f979u;
    private C0795h f980v;
    private int f981w;
    private int f982x;
    private int f983y;
    private boolean f984z;

    /* renamed from: com.facebook.ads.internal.b.q.1 */
    class C05021 implements C0420a {
        final /* synthetic */ C0505q f961a;

        C05021(C0505q c0505q) {
            this.f961a = c0505q;
        }

        public boolean m1371a() {
            if (this.f961a.f980v == null || !this.f961a.f980v.m2449a()) {
                return false;
            }
            if (!(this.f961a.f980v.getSkipSeconds() == 0 || this.f961a.a == null)) {
                this.f961a.a.m2555f();
            }
            if (this.f961a.a != null) {
                this.f961a.a.m2556g();
            }
            this.f961a.f968j.finish();
            return true;
        }
    }

    /* renamed from: com.facebook.ads.internal.b.q.2 */
    class C05032 implements OnTouchListener {
        final /* synthetic */ C0505q f962a;

        C05032(C0505q c0505q) {
            this.f962a = c0505q;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 1) {
                if (this.f962a.f980v == null) {
                    this.f962a.f968j.finish();
                } else if (this.f962a.f980v.m2449a()) {
                    if (!(this.f962a.f980v.getSkipSeconds() == 0 || this.f962a.a == null)) {
                        this.f962a.a.m2555f();
                    }
                    if (this.f962a.a != null) {
                        this.f962a.a.m2556g();
                    }
                    this.f962a.f968j.finish();
                }
            }
            return true;
        }
    }

    static {
        f963h = !C0505q.class.desiredAssertionStatus();
    }

    public C0505q() {
        this.f964e = 64;
        this.f965f = 64;
        this.f966g = 16;
        this.f969k = new C05021(this);
        this.f970l = new C05032(this);
        this.f971m = C0500a.UNSPECIFIED;
        this.f981w = -1;
        this.f982x = -10525069;
        this.f983y = -12286980;
        this.f984z = false;
    }

    private void m1379a(int i) {
        View linearLayout;
        float f = this.c.getResources().getDisplayMetrics().density;
        LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (56.0f * f), (int) (56.0f * f));
        layoutParams.addRule(10);
        layoutParams.addRule(11);
        int i2 = (int) (16.0f * f);
        this.f980v.setPadding(i2, i2, i2, i2);
        this.f980v.setLayoutParams(layoutParams);
        C0782a c0782a = m1393h() ? C0782a.FADE_OUT_ON_PLAY : C0782a.VISIBLE;
        int id = this.a.getId();
        LayoutParams layoutParams2;
        if (i == 1 && (m1384m() || m1385n())) {
            Drawable gradientDrawable = new GradientDrawable(Orientation.TOP_BOTTOM, new int[]{0, -15658735});
            gradientDrawable.setCornerRadius(0.0f);
            layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams2.addRule(10);
            this.a.setLayoutParams(layoutParams2);
            m1380a(this.a);
            m1380a(this.f980v);
            m1380a(this.f976r);
            LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, (int) (((float) (((((this.f972n != null ? 64 : 0) + 60) + 16) + 16) + 16)) * f));
            layoutParams3.addRule(12);
            View relativeLayout = new RelativeLayout(this.c);
            relativeLayout.setBackground(gradientDrawable);
            relativeLayout.setLayoutParams(layoutParams3);
            relativeLayout.setPadding(i2, 0, i2, (int) (((float) (((this.f972n != null ? 64 : 0) + 16) + 16)) * f));
            this.f978t = relativeLayout;
            if (!this.f984z) {
                this.f979u.m2421a(relativeLayout, c0782a);
            }
            m1380a(relativeLayout);
            if (this.f977s != null) {
                layoutParams = new RelativeLayout.LayoutParams(-1, (int) (6.0f * f));
                layoutParams.addRule(12);
                layoutParams.topMargin = (int) (-6.0f * f);
                this.f977s.setLayoutParams(layoutParams);
                m1380a(this.f977s);
            }
            if (this.f972n != null) {
                layoutParams = new RelativeLayout.LayoutParams(-1, (int) (64.0f * f));
                layoutParams.bottomMargin = (int) (16.0f * f);
                layoutParams.leftMargin = (int) (16.0f * f);
                layoutParams.rightMargin = (int) (16.0f * f);
                layoutParams.addRule(14);
                layoutParams.addRule(12);
                this.f972n.setLayoutParams(layoutParams);
                m1380a(this.f972n);
            }
            if (this.f975q != null) {
                layoutParams = new RelativeLayout.LayoutParams((int) (60.0f * f), (int) (60.0f * f));
                layoutParams.addRule(12);
                layoutParams.addRule(9);
                this.f975q.setLayoutParams(layoutParams);
                m1381a(relativeLayout, this.f975q);
            }
            if (this.f973o != null) {
                layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams.bottomMargin = (int) (36.0f * f);
                layoutParams.addRule(12);
                layoutParams.addRule(9);
                this.f973o.setPadding((int) (72.0f * f), 0, 0, 0);
                this.f973o.setLayoutParams(layoutParams);
                this.f973o.setTextSize(18.0f);
                this.f973o.setTextColor(-1);
                this.f973o.setEllipsize(TruncateAt.END);
                this.f973o.setMaxLines(1);
                m1381a(relativeLayout, this.f973o);
            }
            if (this.f974p != null) {
                layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams.addRule(12);
                layoutParams.addRule(9);
                layoutParams.bottomMargin = (int) (4.0f * f);
                this.f974p.setPadding((int) (f * 72.0f), 0, 0, 0);
                this.f974p.setLayoutParams(layoutParams);
                this.f974p.setMaxLines(1);
                this.f974p.setEllipsize(TruncateAt.END);
                this.f974p.setTextColor(-1);
                m1381a(relativeLayout, this.f974p);
            }
            ((ViewGroup) this.a.getParent()).setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        } else if (i == 1) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(10);
            this.a.setLayoutParams(layoutParams);
            m1380a(this.a);
            m1380a(this.f980v);
            m1380a(this.f976r);
            linearLayout = new LinearLayout(this.c);
            this.f978t = linearLayout;
            linearLayout.setGravity(C0268R.styleable.AppCompatTheme_spinnerStyle);
            linearLayout.setOrientation(1);
            r2 = new RelativeLayout.LayoutParams(-1, -1);
            r2.leftMargin = (int) (33.0f * f);
            r2.rightMargin = (int) (33.0f * f);
            r2.topMargin = (int) (8.0f * f);
            if (this.f972n == null) {
                r2.bottomMargin = (int) (16.0f * f);
            } else {
                r2.bottomMargin = (int) (80.0f * f);
            }
            r2.addRule(3, id);
            linearLayout.setLayoutParams(r2);
            m1380a(linearLayout);
            if (this.f972n != null) {
                r2 = new RelativeLayout.LayoutParams(-1, (int) (64.0f * f));
                r2.bottomMargin = (int) (16.0f * f);
                r2.leftMargin = (int) (33.0f * f);
                r2.rightMargin = (int) (33.0f * f);
                r2.addRule(14);
                r2.addRule(12);
                this.f972n.setLayoutParams(r2);
                m1380a(this.f972n);
            }
            if (this.f973o != null) {
                r2 = new LinearLayout.LayoutParams(-2, -2);
                r2.weight = 2.0f;
                r2.gravity = 17;
                this.f973o.setGravity(17);
                this.f973o.setLayoutParams(r2);
                this.f973o.setTextSize(24.0f);
                this.f973o.setTextColor(this.f982x);
                this.f973o.setEllipsize(TruncateAt.END);
                this.f973o.setMaxLines(2);
                m1381a(linearLayout, this.f973o);
            }
            if (this.f975q != null) {
                r2 = new LinearLayout.LayoutParams((int) (64.0f * f), (int) (64.0f * f));
                r2.weight = 0.0f;
                r2.gravity = 17;
                this.f975q.setLayoutParams(r2);
                m1381a(linearLayout, this.f975q);
            }
            if (this.f974p != null) {
                r2 = new LinearLayout.LayoutParams(-1, -2);
                r2.weight = 2.0f;
                r2.gravity = 16;
                this.f974p.setGravity(16);
                this.f974p.setLayoutParams(r2);
                this.f974p.setTextColor(this.f982x);
                m1381a(linearLayout, this.f974p);
            }
            if (this.f977s != null) {
                layoutParams = new RelativeLayout.LayoutParams(-1, (int) (6.0f * f));
                layoutParams.addRule(3, id);
                this.f977s.setLayoutParams(layoutParams);
                m1380a(this.f977s);
            }
            ((ViewGroup) this.a.getParent()).setBackgroundColor(this.f981w);
        } else if (!m1386o() || m1385n()) {
            Drawable gradientDrawable2 = new GradientDrawable(Orientation.TOP_BOTTOM, new int[]{0, -15658735});
            gradientDrawable2.setCornerRadius(0.0f);
            this.a.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            m1380a(this.a);
            m1380a(this.f980v);
            m1380a(this.f976r);
            LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, (int) (124.0f * f));
            layoutParams4.addRule(12);
            View relativeLayout2 = new RelativeLayout(this.c);
            relativeLayout2.setBackground(gradientDrawable2);
            relativeLayout2.setLayoutParams(layoutParams4);
            relativeLayout2.setPadding(i2, 0, i2, i2);
            this.f978t = relativeLayout2;
            if (!this.f984z) {
                this.f979u.m2421a(relativeLayout2, c0782a);
            }
            m1380a(relativeLayout2);
            if (this.f972n != null) {
                layoutParams = new RelativeLayout.LayoutParams((int) (110.0f * f), (int) (56.0f * f));
                layoutParams.rightMargin = (int) (16.0f * f);
                layoutParams.bottomMargin = (int) (16.0f * f);
                layoutParams.addRule(12);
                layoutParams.addRule(11);
                this.f972n.setLayoutParams(layoutParams);
                m1380a(this.f972n);
            }
            if (this.f975q != null) {
                layoutParams = new RelativeLayout.LayoutParams((int) (64.0f * f), (int) (64.0f * f));
                layoutParams.addRule(12);
                layoutParams.addRule(9);
                layoutParams.bottomMargin = (int) (8.0f * f);
                this.f975q.setLayoutParams(layoutParams);
                m1381a(relativeLayout2, this.f975q);
            }
            if (this.f973o != null) {
                layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams2.bottomMargin = (int) (48.0f * f);
                layoutParams2.addRule(12);
                layoutParams2.addRule(9);
                this.f973o.setPadding((int) (80.0f * f), 0, this.f972n != null ? (int) (126.0f * f) : 0, 0);
                this.f973o.setLayoutParams(layoutParams2);
                this.f973o.setEllipsize(TruncateAt.END);
                this.f973o.setMaxLines(1);
                this.f973o.setTextColor(-1);
                m1381a(relativeLayout2, this.f973o);
            }
            if (this.f974p != null) {
                layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams2.addRule(12);
                layoutParams2.addRule(9);
                this.f974p.setPadding((int) (80.0f * f), 0, this.f972n != null ? (int) (126.0f * f) : 0, 0);
                this.f974p.setLayoutParams(layoutParams2);
                this.f974p.setMaxLines(2);
                this.f974p.setEllipsize(TruncateAt.END);
                this.f974p.setTextColor(-1);
                m1381a(relativeLayout2, this.f974p);
            }
            if (this.f977s != null) {
                layoutParams = new RelativeLayout.LayoutParams(-1, (int) (6.0f * f));
                layoutParams.addRule(12);
                this.f977s.setLayoutParams(layoutParams);
                m1380a(this.f977s);
            }
            ((ViewGroup) this.a.getParent()).setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        } else {
            layoutParams = new RelativeLayout.LayoutParams(-2, -1);
            layoutParams.addRule(9);
            this.a.setLayoutParams(layoutParams);
            m1380a(this.a);
            m1380a(this.f980v);
            m1380a(this.f976r);
            linearLayout = new LinearLayout(this.c);
            this.f978t = linearLayout;
            linearLayout.setGravity(C0268R.styleable.AppCompatTheme_spinnerStyle);
            linearLayout.setOrientation(1);
            r2 = new RelativeLayout.LayoutParams(-1, -1);
            r2.leftMargin = (int) (16.0f * f);
            r2.rightMargin = (int) (16.0f * f);
            r2.topMargin = (int) (8.0f * f);
            r2.bottomMargin = (int) (80.0f * f);
            r2.addRule(1, id);
            linearLayout.setLayoutParams(r2);
            m1380a(linearLayout);
            if (this.f977s != null) {
                r2 = new RelativeLayout.LayoutParams(-1, (int) (6.0f * f));
                r2.addRule(5, id);
                r2.addRule(7, id);
                r2.addRule(3, id);
                r2.topMargin = (int) (-6.0f * f);
                this.f977s.setLayoutParams(r2);
                m1380a(this.f977s);
            }
            if (this.f973o != null) {
                r2 = new LinearLayout.LayoutParams(-2, -2);
                r2.weight = 2.0f;
                r2.gravity = 17;
                this.f973o.setGravity(17);
                this.f973o.setLayoutParams(r2);
                this.f973o.setTextSize(24.0f);
                this.f973o.setTextColor(this.f982x);
                m1381a(linearLayout, this.f973o);
            }
            if (this.f975q != null) {
                r2 = new LinearLayout.LayoutParams((int) (64.0f * f), (int) (64.0f * f));
                r2.weight = 0.0f;
                r2.gravity = 17;
                this.f975q.setLayoutParams(r2);
                m1381a(linearLayout, this.f975q);
            }
            if (this.f974p != null) {
                r2 = new LinearLayout.LayoutParams(-1, -2);
                r2.weight = 2.0f;
                r2.gravity = 16;
                this.f974p.setGravity(17);
                this.f974p.setLayoutParams(r2);
                this.f974p.setTextColor(this.f982x);
                m1381a(linearLayout, this.f974p);
            }
            if (this.f972n != null) {
                layoutParams = new RelativeLayout.LayoutParams(-1, (int) (64.0f * f));
                layoutParams.bottomMargin = (int) (16.0f * f);
                layoutParams.leftMargin = (int) (16.0f * f);
                layoutParams.rightMargin = (int) (16.0f * f);
                layoutParams.addRule(14);
                layoutParams.addRule(12);
                layoutParams.addRule(1, id);
                this.f972n.setLayoutParams(layoutParams);
                m1380a(this.f972n);
            }
            ((ViewGroup) this.a.getParent()).setBackgroundColor(this.f981w);
        }
        linearLayout = this.a.getRootView();
        if (linearLayout != null) {
            linearLayout.setOnTouchListener(this);
        }
    }

    private void m1380a(View view) {
        if (this.f967i != null) {
            this.f967i.m981a(view);
        }
    }

    private void m1381a(@Nullable ViewGroup viewGroup, @Nullable View view) {
        if (viewGroup != null) {
            viewGroup.addView(view);
        }
    }

    private void m1383b(View view) {
        if (view != null) {
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(view);
            }
        }
    }

    private boolean m1384m() {
        return ((double) (this.a.getVideoHeight() > 0 ? ((float) this.a.getVideoWidth()) / ((float) this.a.getVideoHeight()) : -1.0f)) <= 0.9d;
    }

    private boolean m1385n() {
        if (this.a.getVideoHeight() <= 0) {
            return false;
        }
        Rect rect = new Rect();
        float f = this.c.getResources().getDisplayMetrics().density;
        this.f968j.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        if (rect.width() > rect.height()) {
            return ((float) (rect.width() - ((rect.height() * this.a.getVideoWidth()) / this.a.getVideoHeight()))) - (f * 192.0f) < 0.0f;
        } else {
            return ((((float) (rect.height() - ((rect.width() * this.a.getVideoHeight()) / this.a.getVideoWidth()))) - (64.0f * f)) - (64.0f * f)) - (f * 40.0f) < 0.0f;
        }
    }

    private boolean m1386o() {
        float videoWidth = this.a.getVideoHeight() > 0 ? ((float) this.a.getVideoWidth()) / ((float) this.a.getVideoHeight()) : -1.0f;
        return ((double) videoWidth) > 0.9d && ((double) videoWidth) < 1.1d;
    }

    private void m1387p() {
        m1383b(this.a);
        m1383b(this.f972n);
        m1383b(this.f973o);
        m1383b(this.f974p);
        m1383b(this.f975q);
        m1383b(this.f976r);
        m1383b(this.f977s);
        m1383b(this.f978t);
        m1383b(this.f980v);
    }

    @TargetApi(17)
    public void m1388a(Intent intent, Bundle bundle, AudienceNetworkActivity audienceNetworkActivity) {
        this.f968j = audienceNetworkActivity;
        if (f963h || this.f967i != null) {
            audienceNetworkActivity.m1031a(this.f969k);
            m1387p();
            m1379a(this.f968j.getResources().getConfiguration().orientation);
            if (m1393h()) {
                m1351f();
                return;
            } else {
                m1352g();
                return;
            }
        }
        throw new AssertionError();
    }

    public void m1389a(Configuration configuration) {
        m1387p();
        m1379a(configuration.orientation);
    }

    public void m1390a(Bundle bundle) {
    }

    public void m1391a(C0417a c0417a) {
        this.f967i = c0417a;
    }

    @TargetApi(17)
    protected void m1392c() {
        C0764l c0788f;
        String optString = this.b.getJSONObject("context").optString("orientation");
        if (!optString.isEmpty()) {
            this.f971m = C0500a.m1359a(Integer.parseInt(optString));
        }
        if (this.b.has("layout") && !this.b.isNull("layout")) {
            JSONObject jSONObject = this.b.getJSONObject("layout");
            this.f981w = (int) jSONObject.optLong("bgColor", (long) this.f981w);
            this.f982x = (int) jSONObject.optLong("textColor", (long) this.f982x);
            this.f983y = (int) jSONObject.optLong("accentColor", (long) this.f983y);
            this.f984z = jSONObject.optBoolean("persistentAdDetails", this.f984z);
        }
        JSONObject jSONObject2 = this.b.getJSONObject("text");
        this.a.setId(View.generateViewId());
        int e = m1350e();
        Context context = this.c;
        if (e < 0) {
            e = 0;
        }
        this.f980v = new C0795h(context, e, this.f983y);
        this.f980v.setOnTouchListener(this.f970l);
        this.a.m2548a(this.f980v);
        if (this.b.has("cta") && !this.b.isNull("cta")) {
            JSONObject jSONObject3 = this.b.getJSONObject("cta");
            this.f972n = new C0736a(this.c, jSONObject3.getString(PlusShare.KEY_CALL_TO_ACTION_URL), jSONObject3.getString("text"), this.f983y, this.a);
        }
        if (this.b.has("icon") && !this.b.isNull("icon")) {
            jSONObject = this.b.getJSONObject("icon");
            this.f975q = new ImageView(this.c);
            new ad(this.f975q).m2145a(jSONObject.getString(PlusShare.KEY_CALL_TO_ACTION_URL));
        }
        if (this.b.has("image") && !this.b.isNull("image")) {
            jSONObject = this.b.getJSONObject("image");
            c0788f = new C0788f(this.c);
            this.a.m2548a(c0788f);
            c0788f.setImage(jSONObject.getString(PlusShare.KEY_CALL_TO_ACTION_URL));
        }
        CharSequence optString2 = jSONObject2.optString(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE);
        if (!optString2.isEmpty()) {
            this.f973o = new TextView(this.c);
            this.f973o.setText(optString2);
            this.f973o.setTypeface(Typeface.defaultFromStyle(1));
        }
        optString2 = jSONObject2.optString(FacebookAdapter.KEY_SUBTITLE_ASSET);
        if (!optString2.isEmpty()) {
            this.f974p = new TextView(this.c);
            this.f974p.setText(optString2);
            this.f974p.setTextSize(16.0f);
        }
        this.f977s = new C0807n(this.c);
        this.a.m2548a(this.f977s);
        this.f976r = new C0763a(this.c, "AdChoices", "http://m.facebook.com/ads/ad_choices", new float[]{0.0f, 0.0f, 8.0f, 0.0f}, this.b.getString("ct"));
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(10);
        layoutParams.addRule(9);
        this.f976r.setLayoutParams(layoutParams);
        this.a.m2548a(new C0797i(this.c));
        c0788f = new C0802j(this.c);
        this.a.m2548a(c0788f);
        C0782a c0782a = m1393h() ? C0782a.FADE_OUT_ON_PLAY : C0782a.VISIBLE;
        this.a.m2548a(new C0783d(c0788f, c0782a));
        this.f979u = new C0783d(new RelativeLayout(this.c), c0782a);
        this.a.m2548a(this.f979u);
    }

    protected boolean m1393h() {
        if (f963h || this.b != null) {
            try {
                return this.b.getJSONObject("video").getBoolean(FacebookAdapter.KEY_AUTOPLAY);
            } catch (Throwable e) {
                Log.w(String.valueOf(C0505q.class), "Invalid JSON", e);
                return true;
            }
        }
        throw new AssertionError();
    }

    public void m1394i() {
    }

    public void m1395j() {
    }

    public void m1396k() {
        if (this.a != null) {
            this.a.m2556g();
        }
        C0501p.m1363a((C0504c) this);
    }

    public C0500a m1397l() {
        return this.f971m;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.a != null) {
            this.a.getEventBus().m1845a(new C0754r(view, motionEvent));
        }
        return true;
    }
}
