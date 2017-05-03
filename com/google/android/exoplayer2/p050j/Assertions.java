package com.google.android.exoplayer2.p050j;

import android.text.TextUtils;

/* renamed from: com.google.android.exoplayer2.j.a */
public final class Assertions {
    public static void m4404a(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }

    public static void m4405a(boolean z, Object obj) {
        if (!z) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    public static int m4401a(int i, int i2, int i3) {
        if (i >= i2 && i < i3) {
            return i;
        }
        throw new IndexOutOfBoundsException();
    }

    public static void m4406b(boolean z) {
        if (!z) {
            throw new IllegalStateException();
        }
    }

    public static void m4407b(boolean z, Object obj) {
        if (!z) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    public static <T> T m4402a(T t) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException();
    }

    public static String m4403a(String str) {
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        throw new IllegalArgumentException();
    }
}
