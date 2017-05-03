package com.google.android.exoplayer2.p064g.p069e;

import android.text.Layout.Alignment;
import com.google.android.exoplayer2.p050j.Util;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* renamed from: com.google.android.exoplayer2.g.e.d */
final class WebvttCssStyle {
    private String f3507a;
    private String f3508b;
    private List<String> f3509c;
    private String f3510d;
    private String f3511e;
    private int f3512f;
    private boolean f3513g;
    private int f3514h;
    private boolean f3515i;
    private int f3516j;
    private int f3517k;
    private int f3518l;
    private int f3519m;
    private int f3520n;
    private float f3521o;
    private Alignment f3522p;

    public WebvttCssStyle() {
        m4126a();
    }

    public void m4126a() {
        this.f3507a = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING;
        this.f3508b = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING;
        this.f3509c = Collections.emptyList();
        this.f3510d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING;
        this.f3511e = null;
        this.f3513g = false;
        this.f3515i = false;
        this.f3516j = -1;
        this.f3517k = -1;
        this.f3518l = -1;
        this.f3519m = -1;
        this.f3520n = -1;
        this.f3522p = null;
    }

    public void m4127a(String str) {
        this.f3507a = str;
    }

    public void m4132b(String str) {
        this.f3508b = str;
    }

    public void m4128a(String[] strArr) {
        this.f3509c = Arrays.asList(strArr);
    }

    public void m4134c(String str) {
        this.f3510d = str;
    }

    public int m4123a(String str, String str2, String[] strArr, String str3) {
        if (!this.f3507a.isEmpty() || !this.f3508b.isEmpty() || !this.f3509c.isEmpty() || !this.f3510d.isEmpty()) {
            int a = WebvttCssStyle.m4122a(WebvttCssStyle.m4122a(WebvttCssStyle.m4122a(0, this.f3507a, str, 1073741824), this.f3508b, str2, 2), this.f3510d, str3, 4);
            if (a == -1 || !Arrays.asList(strArr).containsAll(this.f3509c)) {
                return 0;
            }
            return (this.f3509c.size() * 4) + a;
        } else if (str2.isEmpty()) {
            return 1;
        } else {
            return 0;
        }
    }

    public int m4129b() {
        int i = 0;
        if (this.f3518l == -1 && this.f3519m == -1) {
            return -1;
        }
        int i2 = this.f3518l == 1 ? 1 : 0;
        if (this.f3519m == 1) {
            i = 2;
        }
        return i2 | i;
    }

    public boolean m4135c() {
        return this.f3516j == 1;
    }

    public boolean m4137d() {
        return this.f3517k == 1;
    }

    public WebvttCssStyle m4125a(boolean z) {
        this.f3517k = z ? 1 : 0;
        return this;
    }

    public WebvttCssStyle m4131b(boolean z) {
        this.f3518l = z ? 1 : 0;
        return this;
    }

    public WebvttCssStyle m4133c(boolean z) {
        this.f3519m = z ? 1 : 0;
        return this;
    }

    public String m4138e() {
        return this.f3511e;
    }

    public WebvttCssStyle m4136d(String str) {
        this.f3511e = Util.m4523d(str);
        return this;
    }

    public int m4139f() {
        if (this.f3513g) {
            return this.f3512f;
        }
        throw new IllegalStateException("Font color not defined");
    }

    public WebvttCssStyle m4124a(int i) {
        this.f3512f = i;
        this.f3513g = true;
        return this;
    }

    public boolean m4140g() {
        return this.f3513g;
    }

    public int m4141h() {
        if (this.f3515i) {
            return this.f3514h;
        }
        throw new IllegalStateException("Background color not defined.");
    }

    public WebvttCssStyle m4130b(int i) {
        this.f3514h = i;
        this.f3515i = true;
        return this;
    }

    public boolean m4142i() {
        return this.f3515i;
    }

    public Alignment m4143j() {
        return this.f3522p;
    }

    public int m4144k() {
        return this.f3520n;
    }

    public float m4145l() {
        return this.f3521o;
    }

    private static int m4122a(int i, String str, String str2, int i2) {
        if (str.isEmpty() || i == -1) {
            return i;
        }
        if (str.equals(str2)) {
            return i + i2;
        }
        return -1;
    }
}
