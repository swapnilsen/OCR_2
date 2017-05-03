package com.facebook.ads.internal.p028c;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.facebook.ads.internal.c.a */
public final class C0522a {
    private final View f1123a;
    private final List<C0526d> f1124b;
    private final Context f1125c;
    private C0525c f1126d;

    public C0522a(Context context, View view, List<C0523b> list) {
        this.f1125c = context;
        this.f1123a = view;
        this.f1124b = new ArrayList(list.size());
        for (C0523b c0526d : list) {
            this.f1124b.add(new C0526d(c0526d));
        }
        this.f1126d = new C0525c();
    }

    public C0522a(Context context, View view, List<C0523b> list, Bundle bundle) {
        this.f1125c = context;
        this.f1123a = view;
        this.f1124b = new ArrayList(list.size());
        ArrayList parcelableArrayList = bundle.getParcelableArrayList("TESTS");
        for (int i = 0; i < list.size(); i++) {
            this.f1124b.add(new C0526d((C0523b) list.get(i), (Bundle) parcelableArrayList.get(i)));
        }
        this.f1126d = (C0525c) bundle.getSerializable("STATISTICS");
    }

    public void m1609a() {
        this.f1126d.m1621a();
    }

    public void m1610a(double d, double d2) {
        if (d2 >= 0.0d) {
            this.f1126d.m1624b(d, d2);
        }
        double a = C0527e.m1630a(this.f1123a, this.f1125c);
        this.f1126d.m1622a(d, a);
        for (C0526d a2 : this.f1124b) {
            a2.m1629a(d, a);
        }
    }

    public C0525c m1611b() {
        return this.f1126d;
    }
}
