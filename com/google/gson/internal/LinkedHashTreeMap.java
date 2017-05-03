package com.google.gson.internal;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Set;

public final class LinkedHashTreeMap<K, V> extends AbstractMap<K, V> implements Serializable {
    static final /* synthetic */ boolean f4761g;
    private static final Comparator<Comparable> f4762h;
    Comparator<? super K> f4763a;
    C1548f<K, V>[] f4764b;
    final C1548f<K, V> f4765c;
    int f4766d;
    int f4767e;
    int f4768f;
    private C1545c f4769i;
    private C1547d f4770j;

    /* renamed from: com.google.gson.internal.LinkedHashTreeMap.1 */
    static class C15401 implements Comparator<Comparable> {
        C15401() {
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m5351a((Comparable) obj, (Comparable) obj2);
        }

        public int m5351a(Comparable comparable, Comparable comparable2) {
            return comparable.compareTo(comparable2);
        }
    }

    /* renamed from: com.google.gson.internal.LinkedHashTreeMap.a */
    static final class C1541a<K, V> {
        private C1548f<K, V> f4739a;
        private int f4740b;
        private int f4741c;
        private int f4742d;

        C1541a() {
        }

        void m5353a(int i) {
            this.f4740b = ((Integer.highestOneBit(i) * 2) - 1) - i;
            this.f4742d = 0;
            this.f4741c = 0;
            this.f4739a = null;
        }

        void m5354a(C1548f<K, V> c1548f) {
            c1548f.f4754c = null;
            c1548f.f4752a = null;
            c1548f.f4753b = null;
            c1548f.f4760i = 1;
            if (this.f4740b > 0 && (this.f4742d & 1) == 0) {
                this.f4742d++;
                this.f4740b--;
                this.f4741c++;
            }
            c1548f.f4752a = this.f4739a;
            this.f4739a = c1548f;
            this.f4742d++;
            if (this.f4740b > 0 && (this.f4742d & 1) == 0) {
                this.f4742d++;
                this.f4740b--;
                this.f4741c++;
            }
            for (int i = 4; (this.f4742d & (i - 1)) == i - 1; i *= 2) {
                C1548f c1548f2;
                C1548f c1548f3;
                if (this.f4741c == 0) {
                    c1548f2 = this.f4739a;
                    c1548f3 = c1548f2.f4752a;
                    C1548f c1548f4 = c1548f3.f4752a;
                    c1548f3.f4752a = c1548f4.f4752a;
                    this.f4739a = c1548f3;
                    c1548f3.f4753b = c1548f4;
                    c1548f3.f4754c = c1548f2;
                    c1548f3.f4760i = c1548f2.f4760i + 1;
                    c1548f4.f4752a = c1548f3;
                    c1548f2.f4752a = c1548f3;
                } else if (this.f4741c == 1) {
                    c1548f2 = this.f4739a;
                    c1548f3 = c1548f2.f4752a;
                    this.f4739a = c1548f3;
                    c1548f3.f4754c = c1548f2;
                    c1548f3.f4760i = c1548f2.f4760i + 1;
                    c1548f2.f4752a = c1548f3;
                    this.f4741c = 0;
                } else if (this.f4741c == 2) {
                    this.f4741c = 0;
                }
            }
        }

        C1548f<K, V> m5352a() {
            C1548f<K, V> c1548f = this.f4739a;
            if (c1548f.f4752a == null) {
                return c1548f;
            }
            throw new IllegalStateException();
        }
    }

    /* renamed from: com.google.gson.internal.LinkedHashTreeMap.b */
    static class C1542b<K, V> {
        private C1548f<K, V> f4743a;

        C1542b() {
        }

        void m5356a(C1548f<K, V> c1548f) {
            C1548f c1548f2 = null;
            while (c1548f != null) {
                c1548f.f4752a = c1548f2;
                C1548f<K, V> c1548f3 = c1548f;
                c1548f = c1548f.f4753b;
            }
            this.f4743a = c1548f2;
        }

        public C1548f<K, V> m5355a() {
            C1548f<K, V> c1548f = this.f4743a;
            if (c1548f == null) {
                return null;
            }
            C1548f c1548f2 = c1548f.f4752a;
            c1548f.f4752a = null;
            for (C1548f c1548f3 = c1548f.f4754c; c1548f3 != null; c1548f3 = c1548f3.f4753b) {
                c1548f3.f4752a = c1548f2;
                c1548f2 = c1548f3;
            }
            this.f4743a = c1548f2;
            return c1548f;
        }
    }

    /* renamed from: com.google.gson.internal.LinkedHashTreeMap.e */
    private abstract class C1543e<T> implements Iterator<T> {
        C1548f<K, V> f4744b;
        C1548f<K, V> f4745c;
        int f4746d;
        final /* synthetic */ LinkedHashTreeMap f4747e;

        C1543e(LinkedHashTreeMap linkedHashTreeMap) {
            this.f4747e = linkedHashTreeMap;
            this.f4744b = this.f4747e.f4765c.f4755d;
            this.f4745c = null;
            this.f4746d = this.f4747e.f4767e;
        }

        public final boolean hasNext() {
            return this.f4744b != this.f4747e.f4765c;
        }

        final C1548f<K, V> m5357b() {
            C1548f<K, V> c1548f = this.f4744b;
            if (c1548f == this.f4747e.f4765c) {
                throw new NoSuchElementException();
            } else if (this.f4747e.f4767e != this.f4746d) {
                throw new ConcurrentModificationException();
            } else {
                this.f4744b = c1548f.f4755d;
                this.f4745c = c1548f;
                return c1548f;
            }
        }

        public final void remove() {
            if (this.f4745c == null) {
                throw new IllegalStateException();
            }
            this.f4747e.m5372a(this.f4745c, true);
            this.f4745c = null;
            this.f4746d = this.f4747e.f4767e;
        }
    }

    /* renamed from: com.google.gson.internal.LinkedHashTreeMap.c */
    final class C1545c extends AbstractSet<Entry<K, V>> {
        final /* synthetic */ LinkedHashTreeMap f4749a;

        /* renamed from: com.google.gson.internal.LinkedHashTreeMap.c.1 */
        class C15441 extends C1543e<Entry<K, V>> {
            final /* synthetic */ C1545c f4748a;

            C15441(C1545c c1545c) {
                this.f4748a = c1545c;
                super(c1545c.f4749a);
            }

            public /* synthetic */ Object next() {
                return m5358a();
            }

            public Entry<K, V> m5358a() {
                return m5357b();
            }
        }

        C1545c(LinkedHashTreeMap linkedHashTreeMap) {
            this.f4749a = linkedHashTreeMap;
        }

        public int size() {
            return this.f4749a.f4766d;
        }

        public Iterator<Entry<K, V>> iterator() {
            return new C15441(this);
        }

        public boolean contains(Object obj) {
            return (obj instanceof Entry) && this.f4749a.m5371a((Entry) obj) != null;
        }

        public boolean remove(Object obj) {
            if (!(obj instanceof Entry)) {
                return false;
            }
            C1548f a = this.f4749a.m5371a((Entry) obj);
            if (a == null) {
                return false;
            }
            this.f4749a.m5372a(a, true);
            return true;
        }

        public void clear() {
            this.f4749a.clear();
        }
    }

    /* renamed from: com.google.gson.internal.LinkedHashTreeMap.d */
    final class C1547d extends AbstractSet<K> {
        final /* synthetic */ LinkedHashTreeMap f4751a;

        /* renamed from: com.google.gson.internal.LinkedHashTreeMap.d.1 */
        class C15461 extends C1543e<K> {
            final /* synthetic */ C1547d f4750a;

            C15461(C1547d c1547d) {
                this.f4750a = c1547d;
                super(c1547d.f4751a);
            }

            public K next() {
                return m5357b().f4757f;
            }
        }

        C1547d(LinkedHashTreeMap linkedHashTreeMap) {
            this.f4751a = linkedHashTreeMap;
        }

        public int size() {
            return this.f4751a.f4766d;
        }

        public Iterator<K> iterator() {
            return new C15461(this);
        }

        public boolean contains(Object obj) {
            return this.f4751a.containsKey(obj);
        }

        public boolean remove(Object obj) {
            return this.f4751a.m5373b(obj) != null;
        }

        public void clear() {
            this.f4751a.clear();
        }
    }

    /* renamed from: com.google.gson.internal.LinkedHashTreeMap.f */
    static final class C1548f<K, V> implements Entry<K, V> {
        C1548f<K, V> f4752a;
        C1548f<K, V> f4753b;
        C1548f<K, V> f4754c;
        C1548f<K, V> f4755d;
        C1548f<K, V> f4756e;
        final K f4757f;
        final int f4758g;
        V f4759h;
        int f4760i;

        C1548f() {
            this.f4757f = null;
            this.f4758g = -1;
            this.f4756e = this;
            this.f4755d = this;
        }

        C1548f(C1548f<K, V> c1548f, K k, int i, C1548f<K, V> c1548f2, C1548f<K, V> c1548f3) {
            this.f4752a = c1548f;
            this.f4757f = k;
            this.f4758g = i;
            this.f4760i = 1;
            this.f4755d = c1548f2;
            this.f4756e = c1548f3;
            c1548f3.f4755d = this;
            c1548f2.f4756e = this;
        }

        public K getKey() {
            return this.f4757f;
        }

        public V getValue() {
            return this.f4759h;
        }

        public V setValue(V v) {
            V v2 = this.f4759h;
            this.f4759h = v;
            return v2;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof Entry)) {
                return false;
            }
            Entry entry = (Entry) obj;
            if (this.f4757f == null) {
                if (entry.getKey() != null) {
                    return false;
                }
            } else if (!this.f4757f.equals(entry.getKey())) {
                return false;
            }
            if (this.f4759h == null) {
                if (entry.getValue() != null) {
                    return false;
                }
            } else if (!this.f4759h.equals(entry.getValue())) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            int i = 0;
            int hashCode = this.f4757f == null ? 0 : this.f4757f.hashCode();
            if (this.f4759h != null) {
                i = this.f4759h.hashCode();
            }
            return hashCode ^ i;
        }

        public String toString() {
            return this.f4757f + "=" + this.f4759h;
        }

        public C1548f<K, V> m5359a() {
            C1548f<K, V> c1548f;
            for (C1548f<K, V> c1548f2 = this.f4753b; c1548f2 != null; c1548f2 = c1548f2.f4753b) {
                c1548f = c1548f2;
            }
            return c1548f;
        }

        public C1548f<K, V> m5360b() {
            C1548f<K, V> c1548f;
            for (C1548f<K, V> c1548f2 = this.f4754c; c1548f2 != null; c1548f2 = c1548f2.f4754c) {
                c1548f = c1548f2;
            }
            return c1548f;
        }
    }

    static {
        f4761g = !LinkedHashTreeMap.class.desiredAssertionStatus();
        f4762h = new C15401();
    }

    public LinkedHashTreeMap() {
        this(f4762h);
    }

    public LinkedHashTreeMap(Comparator<? super K> comparator) {
        this.f4766d = 0;
        this.f4767e = 0;
        if (comparator == null) {
            comparator = f4762h;
        }
        this.f4763a = comparator;
        this.f4765c = new C1548f();
        this.f4764b = new C1548f[16];
        this.f4768f = (this.f4764b.length / 2) + (this.f4764b.length / 4);
    }

    public int size() {
        return this.f4766d;
    }

    public V get(Object obj) {
        C1548f a = m5369a(obj);
        return a != null ? a.f4759h : null;
    }

    public boolean containsKey(Object obj) {
        return m5369a(obj) != null;
    }

    public V put(K k, V v) {
        if (k == null) {
            throw new NullPointerException("key == null");
        }
        C1548f a = m5370a((Object) k, true);
        V v2 = a.f4759h;
        a.f4759h = v;
        return v2;
    }

    public void clear() {
        Arrays.fill(this.f4764b, null);
        this.f4766d = 0;
        this.f4767e++;
        C1548f c1548f = this.f4765c;
        C1548f c1548f2 = c1548f.f4755d;
        while (c1548f2 != c1548f) {
            C1548f c1548f3 = c1548f2.f4755d;
            c1548f2.f4756e = null;
            c1548f2.f4755d = null;
            c1548f2 = c1548f3;
        }
        c1548f.f4756e = c1548f;
        c1548f.f4755d = c1548f;
    }

    public V remove(Object obj) {
        C1548f b = m5373b(obj);
        return b != null ? b.f4759h : null;
    }

    C1548f<K, V> m5370a(K k, boolean z) {
        int i;
        Comparator comparator = this.f4763a;
        C1548f[] c1548fArr = this.f4764b;
        int a = m5361a(k.hashCode());
        int length = a & (c1548fArr.length - 1);
        C1548f c1548f = c1548fArr[length];
        if (c1548f != null) {
            int compareTo;
            Comparable comparable = comparator == f4762h ? (Comparable) k : null;
            while (true) {
                if (comparable != null) {
                    compareTo = comparable.compareTo(c1548f.f4757f);
                } else {
                    compareTo = comparator.compare(k, c1548f.f4757f);
                }
                if (compareTo == 0) {
                    return c1548f;
                }
                C1548f c1548f2 = compareTo < 0 ? c1548f.f4753b : c1548f.f4754c;
                if (c1548f2 == null) {
                    break;
                }
                c1548f = c1548f2;
            }
            i = compareTo;
        } else {
            i = 0;
        }
        if (!z) {
            return null;
        }
        C1548f<K, V> c1548f3;
        C1548f c1548f4 = this.f4765c;
        if (c1548f != null) {
            c1548f3 = new C1548f(c1548f, k, a, c1548f4, c1548f4.f4756e);
            if (i < 0) {
                c1548f.f4753b = c1548f3;
            } else {
                c1548f.f4754c = c1548f3;
            }
            m5368b(c1548f, true);
        } else if (comparator != f4762h || (k instanceof Comparable)) {
            c1548f3 = new C1548f(c1548f, k, a, c1548f4, c1548f4.f4756e);
            c1548fArr[length] = c1548f3;
        } else {
            throw new ClassCastException(k.getClass().getName() + " is not Comparable");
        }
        int i2 = this.f4766d;
        this.f4766d = i2 + 1;
        if (i2 > this.f4768f) {
            m5362a();
        }
        this.f4767e++;
        return c1548f3;
    }

    C1548f<K, V> m5369a(Object obj) {
        C1548f<K, V> c1548f = null;
        if (obj != null) {
            try {
                c1548f = m5370a(obj, false);
            } catch (ClassCastException e) {
            }
        }
        return c1548f;
    }

    C1548f<K, V> m5371a(Entry<?, ?> entry) {
        C1548f<K, V> a = m5369a(entry.getKey());
        Object obj = (a == null || !m5365a(a.f4759h, entry.getValue())) ? null : 1;
        return obj != null ? a : null;
    }

    private boolean m5365a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    private static int m5361a(int i) {
        int i2 = ((i >>> 20) ^ (i >>> 12)) ^ i;
        return (i2 >>> 4) ^ ((i2 >>> 7) ^ i2);
    }

    void m5372a(C1548f<K, V> c1548f, boolean z) {
        int i = 0;
        if (z) {
            c1548f.f4756e.f4755d = c1548f.f4755d;
            c1548f.f4755d.f4756e = c1548f.f4756e;
            c1548f.f4756e = null;
            c1548f.f4755d = null;
        }
        C1548f c1548f2 = c1548f.f4753b;
        C1548f c1548f3 = c1548f.f4754c;
        C1548f c1548f4 = c1548f.f4752a;
        if (c1548f2 == null || c1548f3 == null) {
            if (c1548f2 != null) {
                m5364a((C1548f) c1548f, c1548f2);
                c1548f.f4753b = null;
            } else if (c1548f3 != null) {
                m5364a((C1548f) c1548f, c1548f3);
                c1548f.f4754c = null;
            } else {
                m5364a((C1548f) c1548f, null);
            }
            m5368b(c1548f4, false);
            this.f4766d--;
            this.f4767e++;
            return;
        }
        int i2;
        c1548f2 = c1548f2.f4760i > c1548f3.f4760i ? c1548f2.m5360b() : c1548f3.m5359a();
        m5372a(c1548f2, false);
        c1548f4 = c1548f.f4753b;
        if (c1548f4 != null) {
            i2 = c1548f4.f4760i;
            c1548f2.f4753b = c1548f4;
            c1548f4.f4752a = c1548f2;
            c1548f.f4753b = null;
        } else {
            i2 = 0;
        }
        c1548f4 = c1548f.f4754c;
        if (c1548f4 != null) {
            i = c1548f4.f4760i;
            c1548f2.f4754c = c1548f4;
            c1548f4.f4752a = c1548f2;
            c1548f.f4754c = null;
        }
        c1548f2.f4760i = Math.max(i2, i) + 1;
        m5364a((C1548f) c1548f, c1548f2);
    }

    C1548f<K, V> m5373b(Object obj) {
        C1548f a = m5369a(obj);
        if (a != null) {
            m5372a(a, true);
        }
        return a;
    }

    private void m5364a(C1548f<K, V> c1548f, C1548f<K, V> c1548f2) {
        C1548f c1548f3 = c1548f.f4752a;
        c1548f.f4752a = null;
        if (c1548f2 != null) {
            c1548f2.f4752a = c1548f3;
        }
        if (c1548f3 == null) {
            this.f4764b[c1548f.f4758g & (this.f4764b.length - 1)] = c1548f2;
        } else if (c1548f3.f4753b == c1548f) {
            c1548f3.f4753b = c1548f2;
        } else if (f4761g || c1548f3.f4754c == c1548f) {
            c1548f3.f4754c = c1548f2;
        } else {
            throw new AssertionError();
        }
    }

    private void m5368b(C1548f<K, V> c1548f, boolean z) {
        C1548f c1548f2;
        while (c1548f2 != null) {
            int i;
            C1548f c1548f3 = c1548f2.f4753b;
            C1548f c1548f4 = c1548f2.f4754c;
            int i2 = c1548f3 != null ? c1548f3.f4760i : 0;
            if (c1548f4 != null) {
                i = c1548f4.f4760i;
            } else {
                i = 0;
            }
            int i3 = i2 - i;
            C1548f c1548f5;
            if (i3 == -2) {
                c1548f3 = c1548f4.f4753b;
                c1548f5 = c1548f4.f4754c;
                if (c1548f5 != null) {
                    i2 = c1548f5.f4760i;
                } else {
                    i2 = 0;
                }
                if (c1548f3 != null) {
                    i = c1548f3.f4760i;
                } else {
                    i = 0;
                }
                i -= i2;
                if (i == -1 || (i == 0 && !z)) {
                    m5363a(c1548f2);
                } else if (f4761g || i == 1) {
                    m5367b(c1548f4);
                    m5363a(c1548f2);
                } else {
                    throw new AssertionError();
                }
                if (z) {
                    return;
                }
            } else if (i3 == 2) {
                c1548f4 = c1548f3.f4753b;
                c1548f5 = c1548f3.f4754c;
                i2 = c1548f5 != null ? c1548f5.f4760i : 0;
                if (c1548f4 != null) {
                    i = c1548f4.f4760i;
                } else {
                    i = 0;
                }
                i -= i2;
                if (i == 1 || (i == 0 && !z)) {
                    m5367b(c1548f2);
                } else if (f4761g || i == -1) {
                    m5363a(c1548f3);
                    m5367b(c1548f2);
                } else {
                    throw new AssertionError();
                }
                if (z) {
                    return;
                }
            } else if (i3 == 0) {
                c1548f2.f4760i = i2 + 1;
                if (z) {
                    return;
                }
            } else if (f4761g || i3 == -1 || i3 == 1) {
                c1548f2.f4760i = Math.max(i2, i) + 1;
                if (!z) {
                    return;
                }
            } else {
                throw new AssertionError();
            }
            c1548f2 = c1548f2.f4752a;
        }
    }

    private void m5363a(C1548f<K, V> c1548f) {
        int i;
        int i2 = 0;
        C1548f c1548f2 = c1548f.f4753b;
        C1548f c1548f3 = c1548f.f4754c;
        C1548f c1548f4 = c1548f3.f4753b;
        C1548f c1548f5 = c1548f3.f4754c;
        c1548f.f4754c = c1548f4;
        if (c1548f4 != null) {
            c1548f4.f4752a = c1548f;
        }
        m5364a((C1548f) c1548f, c1548f3);
        c1548f3.f4753b = c1548f;
        c1548f.f4752a = c1548f3;
        if (c1548f2 != null) {
            i = c1548f2.f4760i;
        } else {
            i = 0;
        }
        c1548f.f4760i = Math.max(i, c1548f4 != null ? c1548f4.f4760i : 0) + 1;
        int i3 = c1548f.f4760i;
        if (c1548f5 != null) {
            i2 = c1548f5.f4760i;
        }
        c1548f3.f4760i = Math.max(i3, i2) + 1;
    }

    private void m5367b(C1548f<K, V> c1548f) {
        int i;
        int i2 = 0;
        C1548f c1548f2 = c1548f.f4753b;
        C1548f c1548f3 = c1548f.f4754c;
        C1548f c1548f4 = c1548f2.f4753b;
        C1548f c1548f5 = c1548f2.f4754c;
        c1548f.f4753b = c1548f5;
        if (c1548f5 != null) {
            c1548f5.f4752a = c1548f;
        }
        m5364a((C1548f) c1548f, c1548f2);
        c1548f2.f4754c = c1548f;
        c1548f.f4752a = c1548f2;
        if (c1548f3 != null) {
            i = c1548f3.f4760i;
        } else {
            i = 0;
        }
        c1548f.f4760i = Math.max(i, c1548f5 != null ? c1548f5.f4760i : 0) + 1;
        int i3 = c1548f.f4760i;
        if (c1548f4 != null) {
            i2 = c1548f4.f4760i;
        }
        c1548f2.f4760i = Math.max(i3, i2) + 1;
    }

    public Set<Entry<K, V>> entrySet() {
        Set set = this.f4769i;
        if (set != null) {
            return set;
        }
        Set<Entry<K, V>> c1545c = new C1545c(this);
        this.f4769i = c1545c;
        return c1545c;
    }

    public Set<K> keySet() {
        Set set = this.f4770j;
        if (set != null) {
            return set;
        }
        Set<K> c1547d = new C1547d(this);
        this.f4770j = c1547d;
        return c1547d;
    }

    private void m5362a() {
        this.f4764b = m5366a(this.f4764b);
        this.f4768f = (this.f4764b.length / 2) + (this.f4764b.length / 4);
    }

    static <K, V> C1548f<K, V>[] m5366a(C1548f<K, V>[] c1548fArr) {
        int length = c1548fArr.length;
        C1548f<K, V>[] c1548fArr2 = new C1548f[(length * 2)];
        C1542b c1542b = new C1542b();
        C1541a c1541a = new C1541a();
        C1541a c1541a2 = new C1541a();
        for (int i = 0; i < length; i++) {
            C1548f c1548f = c1548fArr[i];
            if (c1548f != null) {
                C1548f a;
                C1548f a2;
                c1542b.m5356a(c1548f);
                int i2 = 0;
                int i3 = 0;
                while (true) {
                    C1548f a3 = c1542b.m5355a();
                    if (a3 == null) {
                        break;
                    } else if ((a3.f4758g & length) == 0) {
                        i3++;
                    } else {
                        i2++;
                    }
                }
                c1541a.m5353a(i3);
                c1541a2.m5353a(i2);
                c1542b.m5356a(c1548f);
                while (true) {
                    c1548f = c1542b.m5355a();
                    if (c1548f == null) {
                        break;
                    } else if ((c1548f.f4758g & length) == 0) {
                        c1541a.m5354a(c1548f);
                    } else {
                        c1541a2.m5354a(c1548f);
                    }
                }
                if (i3 > 0) {
                    a = c1541a.m5352a();
                } else {
                    a = null;
                }
                c1548fArr2[i] = a;
                i3 = i + length;
                if (i2 > 0) {
                    a2 = c1541a2.m5352a();
                } else {
                    a2 = null;
                }
                c1548fArr2[i3] = a2;
            }
        }
        return c1548fArr2;
    }
}
