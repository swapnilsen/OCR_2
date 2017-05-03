package com.facebook.ads;

import android.support.v7.widget.helper.ItemTouchHelper.Callback;
import java.io.Serializable;

/* renamed from: com.facebook.ads.f */
public class C0442f implements Serializable {
    @Deprecated
    public static final C0442f f755a;
    public static final C0442f f756b;
    public static final C0442f f757c;
    public static final C0442f f758d;
    public static final C0442f f759e;
    private final int f760f;
    private final int f761g;

    static {
        f755a = new C0442f(320, 50);
        f756b = new C0442f(0, 0);
        f757c = new C0442f(-1, 50);
        f758d = new C0442f(-1, 90);
        f759e = new C0442f(-1, Callback.DEFAULT_SWIPE_ANIMATION_DURATION);
    }

    public C0442f(int i, int i2) {
        this.f760f = i;
        this.f761g = i2;
    }

    public int m1060a() {
        return this.f760f;
    }

    public int m1061b() {
        return this.f761g;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C0442f c0442f = (C0442f) obj;
        return this.f760f != c0442f.f760f ? false : this.f761g == c0442f.f761g;
    }

    public int hashCode() {
        return (this.f760f * 31) + this.f761g;
    }
}
