package com.facebook.ads;

import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v4.view.ViewCompat;
import com.facebook.ads.internal.p021m.C0705p;
import com.facebook.ads.internal.p021m.C0706q;
import com.google.ads.mediation.facebook.FacebookAdapter;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.p */
public class C0872p {
    private Typeface f2195a;
    private int f2196b;
    private int f2197c;
    private int f2198d;
    private int f2199e;
    private int f2200f;
    private int f2201g;
    private boolean f2202h;
    private boolean f2203i;

    public C0872p() {
        this.f2195a = Typeface.DEFAULT;
        this.f2196b = -1;
        this.f2197c = ViewCompat.MEASURED_STATE_MASK;
        this.f2198d = -11643291;
        this.f2199e = 0;
        this.f2200f = -12420889;
        this.f2201g = -12420889;
        this.f2202h = C0441e.m1056b();
        this.f2203i = C0441e.m1057c();
    }

    public C0872p(JSONObject jSONObject) {
        int i = 0;
        this.f2195a = Typeface.DEFAULT;
        this.f2196b = -1;
        this.f2197c = ViewCompat.MEASURED_STATE_MASK;
        this.f2198d = -11643291;
        this.f2199e = 0;
        this.f2200f = -12420889;
        this.f2201g = -12420889;
        this.f2202h = C0441e.m1056b();
        this.f2203i = C0441e.m1057c();
        try {
            int parseColor = jSONObject.getBoolean("background_transparent") ? 0 : Color.parseColor(jSONObject.getString(FacebookAdapter.KEY_BACKGROUND_COLOR));
            int parseColor2 = Color.parseColor(jSONObject.getString(FacebookAdapter.KEY_TITLE_TEXT_COLOR));
            int parseColor3 = Color.parseColor(jSONObject.getString(FacebookAdapter.KEY_DESCRIPTION_TEXT_COLOR));
            int parseColor4 = jSONObject.getBoolean("button_transparent") ? 0 : Color.parseColor(jSONObject.getString(FacebookAdapter.KEY_BUTTON_COLOR));
            if (!jSONObject.getBoolean("button_border_transparent")) {
                i = Color.parseColor(jSONObject.getString(FacebookAdapter.KEY_BUTTON_BORDER_COLOR));
            }
            int parseColor5 = Color.parseColor(jSONObject.getString(FacebookAdapter.KEY_BUTTON_TEXT_COLOR));
            Typeface create = Typeface.create(jSONObject.getString("android_typeface"), 0);
            this.f2196b = parseColor;
            this.f2197c = parseColor2;
            this.f2198d = parseColor3;
            this.f2199e = parseColor4;
            this.f2201g = i;
            this.f2200f = parseColor5;
            this.f2195a = create;
        } catch (Throwable e) {
            C0706q.m2279a(C0705p.m2276a(e, "Error retrieving native ui configuration data"));
        }
    }

    public Typeface m2738a() {
        return this.f2195a;
    }

    public int m2739b() {
        return this.f2196b;
    }

    public int m2740c() {
        return this.f2197c;
    }

    public int m2741d() {
        return this.f2198d;
    }

    public int m2742e() {
        return this.f2199e;
    }

    public int m2743f() {
        return this.f2200f;
    }

    public int m2744g() {
        return this.f2201g;
    }

    public int m2745h() {
        return 16;
    }

    public int m2746i() {
        return 10;
    }

    public boolean m2747j() {
        return this.f2202h;
    }
}
