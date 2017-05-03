package com.facebook.ads.internal.p025h;

import android.support.annotation.Nullable;
import java.lang.ref.WeakReference;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/* renamed from: com.facebook.ads.internal.h.r */
public class C0591r<T extends C0492s, E extends C0590q> {
    private final Map<Class<E>, List<WeakReference<T>>> f1376a;
    private final Queue<E> f1377b;

    public C0591r() {
        this.f1376a = new HashMap();
        this.f1377b = new ArrayDeque();
    }

    private void m1843a(List<WeakReference<T>> list) {
        if (list != null) {
            int i = 0;
            for (int i2 = 0; i2 < list.size(); i2++) {
                WeakReference weakReference = (WeakReference) list.get(i2);
                if (weakReference.get() != null) {
                    int i3 = i + 1;
                    list.set(i, weakReference);
                    i = i3;
                }
            }
            for (int size = list.size() - 1; size >= i; size--) {
                list.remove(size);
            }
        }
    }

    private void m1844b(E e) {
        if (this.f1376a != null) {
            List list = (List) this.f1376a.get(e.getClass());
            if (list != null) {
                m1843a(list);
                if (!list.isEmpty()) {
                    for (WeakReference weakReference : new ArrayList(list)) {
                        C0492s c0492s = (C0492s) weakReference.get();
                        if (c0492s != null && c0492s.m1324b(e)) {
                            c0492s.m1323a(e);
                        }
                    }
                }
            }
        }
    }

    public synchronized void m1845a(E e) {
        if (this.f1377b.isEmpty()) {
            this.f1377b.add(e);
            while (!this.f1377b.isEmpty()) {
                m1844b((C0590q) this.f1377b.peek());
                this.f1377b.remove();
            }
        } else {
            this.f1377b.add(e);
        }
    }

    public synchronized boolean m1846a(T t) {
        boolean z;
        if (t == null) {
            z = false;
        } else {
            Class a = t.m1322a();
            if (this.f1376a.get(a) == null) {
                this.f1376a.put(a, new ArrayList());
            }
            List list = (List) this.f1376a.get(a);
            m1843a(list);
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (((WeakReference) list.get(i)).get() == t) {
                    z = false;
                    break;
                }
            }
            z = list.add(new WeakReference(t));
        }
        return z;
    }

    public synchronized boolean m1847b(@Nullable T t) {
        boolean z;
        if (t == null) {
            z = false;
        } else {
            List list = (List) this.f1376a.get(t.m1322a());
            if (list == null) {
                z = false;
            } else {
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    if (((WeakReference) list.get(i)).get() == t) {
                        ((WeakReference) list.get(i)).clear();
                        z = true;
                        break;
                    }
                }
                z = false;
            }
        }
        return z;
    }
}
