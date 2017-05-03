package com.facebook.ads.internal.view.hscroll;

import android.util.SparseArray;

/* renamed from: com.facebook.ads.internal.view.hscroll.a */
public class C0830a {
    private final SparseArray<int[]> f2069a;

    public void m2567a(int i, int[] iArr) {
        this.f2069a.put(i, iArr);
    }

    public int[] m2568a(int i) {
        return (int[]) this.f2069a.get(i);
    }

    public boolean m2569b(int i) {
        return this.f2069a.indexOfKey(i) >= 0;
    }
}
