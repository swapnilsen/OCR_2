package com.google.gson.internal;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Set;

public final class LinkedTreeMap<K, V> extends AbstractMap<K, V> implements Serializable {
    static final /* synthetic */ boolean f4787f;
    private static final Comparator<Comparable> f4788g;
    Comparator<? super K> f4789a;
    C1555d<K, V> f4790b;
    int f4791c;
    int f4792d;
    final C1555d<K, V> f4793e;
    private C1552a f4794h;
    private C1554b f4795i;

    /* renamed from: com.google.gson.internal.LinkedTreeMap.1 */
    static class C15491 implements Comparator<Comparable> {
        C15491() {
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m5374a((Comparable) obj, (Comparable) obj2);
        }

        public int m5374a(Comparable comparable, Comparable comparable2) {
            return comparable.compareTo(comparable2);
        }
    }

    /* renamed from: com.google.gson.internal.LinkedTreeMap.c */
    private abstract class C1550c<T> implements Iterator<T> {
        C1555d<K, V> f4771b;
        C1555d<K, V> f4772c;
        int f4773d;
        final /* synthetic */ LinkedTreeMap f4774e;

        C1550c(LinkedTreeMap linkedTreeMap) {
            this.f4774e = linkedTreeMap;
            this.f4771b = this.f4774e.f4793e.f4782d;
            this.f4772c = null;
            this.f4773d = this.f4774e.f4792d;
        }

        public final boolean hasNext() {
            return this.f4771b != this.f4774e.f4793e;
        }

        final C1555d<K, V> m5375b() {
            C1555d<K, V> c1555d = this.f4771b;
            if (c1555d == this.f4774e.f4793e) {
                throw new NoSuchElementException();
            } else if (this.f4774e.f4792d != this.f4773d) {
                throw new ConcurrentModificationException();
            } else {
                this.f4771b = c1555d.f4782d;
                this.f4772c = c1555d;
                return c1555d;
            }
        }

        public final void remove() {
            if (this.f4772c == null) {
                throw new IllegalStateException();
            }
            this.f4774e.m5387a(this.f4772c, true);
            this.f4772c = null;
            this.f4773d = this.f4774e.f4792d;
        }
    }

    /* renamed from: com.google.gson.internal.LinkedTreeMap.a */
    class C1552a extends AbstractSet<Entry<K, V>> {
        final /* synthetic */ LinkedTreeMap f4776a;

        /* renamed from: com.google.gson.internal.LinkedTreeMap.a.1 */
        class C15511 extends C1550c<Entry<K, V>> {
            final /* synthetic */ C1552a f4775a;

            C15511(C1552a c1552a) {
                this.f4775a = c1552a;
                super(c1552a.f4776a);
            }

            public /* synthetic */ Object next() {
                return m5376a();
            }

            public Entry<K, V> m5376a() {
                return m5375b();
            }
        }

        C1552a(LinkedTreeMap linkedTreeMap) {
            this.f4776a = linkedTreeMap;
        }

        public int size() {
            return this.f4776a.f4791c;
        }

        public Iterator<Entry<K, V>> iterator() {
            return new C15511(this);
        }

        public boolean contains(Object obj) {
            return (obj instanceof Entry) && this.f4776a.m5386a((Entry) obj) != null;
        }

        public boolean remove(Object obj) {
            if (!(obj instanceof Entry)) {
                return false;
            }
            C1555d a = this.f4776a.m5386a((Entry) obj);
            if (a == null) {
                return false;
            }
            this.f4776a.m5387a(a, true);
            return true;
        }

        public void clear() {
            this.f4776a.clear();
        }
    }

    /* renamed from: com.google.gson.internal.LinkedTreeMap.b */
    final class C1554b extends AbstractSet<K> {
        final /* synthetic */ LinkedTreeMap f4778a;

        /* renamed from: com.google.gson.internal.LinkedTreeMap.b.1 */
        class C15531 extends C1550c<K> {
            final /* synthetic */ C1554b f4777a;

            C15531(C1554b c1554b) {
                this.f4777a = c1554b;
                super(c1554b.f4778a);
            }

            public K next() {
                return m5375b().f4784f;
            }
        }

        C1554b(LinkedTreeMap linkedTreeMap) {
            this.f4778a = linkedTreeMap;
        }

        public int size() {
            return this.f4778a.f4791c;
        }

        public Iterator<K> iterator() {
            return new C15531(this);
        }

        public boolean contains(Object obj) {
            return this.f4778a.containsKey(obj);
        }

        public boolean remove(Object obj) {
            return this.f4778a.m5388b(obj) != null;
        }

        public void clear() {
            this.f4778a.clear();
        }
    }

    /* renamed from: com.google.gson.internal.LinkedTreeMap.d */
    static final class C1555d<K, V> implements Entry<K, V> {
        C1555d<K, V> f4779a;
        C1555d<K, V> f4780b;
        C1555d<K, V> f4781c;
        C1555d<K, V> f4782d;
        C1555d<K, V> f4783e;
        final K f4784f;
        V f4785g;
        int f4786h;

        C1555d() {
            this.f4784f = null;
            this.f4783e = this;
            this.f4782d = this;
        }

        C1555d(C1555d<K, V> c1555d, K k, C1555d<K, V> c1555d2, C1555d<K, V> c1555d3) {
            this.f4779a = c1555d;
            this.f4784f = k;
            this.f4786h = 1;
            this.f4782d = c1555d2;
            this.f4783e = c1555d3;
            c1555d3.f4782d = this;
            c1555d2.f4783e = this;
        }

        public K getKey() {
            return this.f4784f;
        }

        public V getValue() {
            return this.f4785g;
        }

        public V setValue(V v) {
            V v2 = this.f4785g;
            this.f4785g = v;
            return v2;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof Entry)) {
                return false;
            }
            Entry entry = (Entry) obj;
            if (this.f4784f == null) {
                if (entry.getKey() != null) {
                    return false;
                }
            } else if (!this.f4784f.equals(entry.getKey())) {
                return false;
            }
            if (this.f4785g == null) {
                if (entry.getValue() != null) {
                    return false;
                }
            } else if (!this.f4785g.equals(entry.getValue())) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            int i = 0;
            int hashCode = this.f4784f == null ? 0 : this.f4784f.hashCode();
            if (this.f4785g != null) {
                i = this.f4785g.hashCode();
            }
            return hashCode ^ i;
        }

        public String toString() {
            return this.f4784f + "=" + this.f4785g;
        }

        public C1555d<K, V> m5377a() {
            C1555d<K, V> c1555d;
            for (C1555d<K, V> c1555d2 = this.f4780b; c1555d2 != null; c1555d2 = c1555d2.f4780b) {
                c1555d = c1555d2;
            }
            return c1555d;
        }

        public C1555d<K, V> m5378b() {
            C1555d<K, V> c1555d;
            for (C1555d<K, V> c1555d2 = this.f4781c; c1555d2 != null; c1555d2 = c1555d2.f4781c) {
                c1555d = c1555d2;
            }
            return c1555d;
        }
    }

    static {
        f4787f = !LinkedTreeMap.class.desiredAssertionStatus();
        f4788g = new C15491();
    }

    public LinkedTreeMap() {
        this(f4788g);
    }

    public LinkedTreeMap(Comparator<? super K> comparator) {
        this.f4791c = 0;
        this.f4792d = 0;
        this.f4793e = new C1555d();
        if (comparator == null) {
            comparator = f4788g;
        }
        this.f4789a = comparator;
    }

    public int size() {
        return this.f4791c;
    }

    public V get(Object obj) {
        C1555d a = m5384a(obj);
        return a != null ? a.f4785g : null;
    }

    public boolean containsKey(Object obj) {
        return m5384a(obj) != null;
    }

    public V put(K k, V v) {
        if (k == null) {
            throw new NullPointerException("key == null");
        }
        C1555d a = m5385a((Object) k, true);
        V v2 = a.f4785g;
        a.f4785g = v;
        return v2;
    }

    public void clear() {
        this.f4790b = null;
        this.f4791c = 0;
        this.f4792d++;
        C1555d c1555d = this.f4793e;
        c1555d.f4783e = c1555d;
        c1555d.f4782d = c1555d;
    }

    public V remove(Object obj) {
        C1555d b = m5388b(obj);
        return b != null ? b.f4785g : null;
    }

    C1555d<K, V> m5385a(K k, boolean z) {
        int i;
        Comparator comparator = this.f4789a;
        C1555d<K, V> c1555d = this.f4790b;
        if (c1555d != null) {
            int compareTo;
            Comparable comparable = comparator == f4788g ? (Comparable) k : null;
            while (true) {
                if (comparable != null) {
                    compareTo = comparable.compareTo(c1555d.f4784f);
                } else {
                    compareTo = comparator.compare(k, c1555d.f4784f);
                }
                if (compareTo == 0) {
                    return c1555d;
                }
                C1555d<K, V> c1555d2 = compareTo < 0 ? c1555d.f4780b : c1555d.f4781c;
                if (c1555d2 == null) {
                    break;
                }
                c1555d = c1555d2;
            }
            int i2 = compareTo;
            C1555d c1555d3 = c1555d;
            i = i2;
        } else {
            C1555d<K, V> c1555d4 = c1555d;
            i = 0;
        }
        if (!z) {
            return null;
        }
        C1555d<K, V> c1555d5;
        C1555d c1555d6 = this.f4793e;
        if (c1555d3 != null) {
            c1555d5 = new C1555d(c1555d3, k, c1555d6, c1555d6.f4783e);
            if (i < 0) {
                c1555d3.f4780b = c1555d5;
            } else {
                c1555d3.f4781c = c1555d5;
            }
            m5383b(c1555d3, true);
        } else if (comparator != f4788g || (k instanceof Comparable)) {
            c1555d5 = new C1555d(c1555d3, k, c1555d6, c1555d6.f4783e);
            this.f4790b = c1555d5;
        } else {
            throw new ClassCastException(k.getClass().getName() + " is not Comparable");
        }
        this.f4791c++;
        this.f4792d++;
        return c1555d5;
    }

    C1555d<K, V> m5384a(Object obj) {
        C1555d<K, V> c1555d = null;
        if (obj != null) {
            try {
                c1555d = m5385a(obj, false);
            } catch (ClassCastException e) {
            }
        }
        return c1555d;
    }

    C1555d<K, V> m5386a(Entry<?, ?> entry) {
        C1555d<K, V> a = m5384a(entry.getKey());
        Object obj = (a == null || !m5381a(a.f4785g, entry.getValue())) ? null : 1;
        return obj != null ? a : null;
    }

    private boolean m5381a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    void m5387a(C1555d<K, V> c1555d, boolean z) {
        int i = 0;
        if (z) {
            c1555d.f4783e.f4782d = c1555d.f4782d;
            c1555d.f4782d.f4783e = c1555d.f4783e;
        }
        C1555d c1555d2 = c1555d.f4780b;
        C1555d c1555d3 = c1555d.f4781c;
        C1555d c1555d4 = c1555d.f4779a;
        if (c1555d2 == null || c1555d3 == null) {
            if (c1555d2 != null) {
                m5380a((C1555d) c1555d, c1555d2);
                c1555d.f4780b = null;
            } else if (c1555d3 != null) {
                m5380a((C1555d) c1555d, c1555d3);
                c1555d.f4781c = null;
            } else {
                m5380a((C1555d) c1555d, null);
            }
            m5383b(c1555d4, false);
            this.f4791c--;
            this.f4792d++;
            return;
        }
        int i2;
        c1555d2 = c1555d2.f4786h > c1555d3.f4786h ? c1555d2.m5378b() : c1555d3.m5377a();
        m5387a(c1555d2, false);
        c1555d4 = c1555d.f4780b;
        if (c1555d4 != null) {
            i2 = c1555d4.f4786h;
            c1555d2.f4780b = c1555d4;
            c1555d4.f4779a = c1555d2;
            c1555d.f4780b = null;
        } else {
            i2 = 0;
        }
        c1555d4 = c1555d.f4781c;
        if (c1555d4 != null) {
            i = c1555d4.f4786h;
            c1555d2.f4781c = c1555d4;
            c1555d4.f4779a = c1555d2;
            c1555d.f4781c = null;
        }
        c1555d2.f4786h = Math.max(i2, i) + 1;
        m5380a((C1555d) c1555d, c1555d2);
    }

    C1555d<K, V> m5388b(Object obj) {
        C1555d a = m5384a(obj);
        if (a != null) {
            m5387a(a, true);
        }
        return a;
    }

    private void m5380a(C1555d<K, V> c1555d, C1555d<K, V> c1555d2) {
        C1555d c1555d3 = c1555d.f4779a;
        c1555d.f4779a = null;
        if (c1555d2 != null) {
            c1555d2.f4779a = c1555d3;
        }
        if (c1555d3 == null) {
            this.f4790b = c1555d2;
        } else if (c1555d3.f4780b == c1555d) {
            c1555d3.f4780b = c1555d2;
        } else if (f4787f || c1555d3.f4781c == c1555d) {
            c1555d3.f4781c = c1555d2;
        } else {
            throw new AssertionError();
        }
    }

    private void m5383b(C1555d<K, V> c1555d, boolean z) {
        C1555d c1555d2;
        while (c1555d2 != null) {
            int i;
            C1555d c1555d3 = c1555d2.f4780b;
            C1555d c1555d4 = c1555d2.f4781c;
            int i2 = c1555d3 != null ? c1555d3.f4786h : 0;
            if (c1555d4 != null) {
                i = c1555d4.f4786h;
            } else {
                i = 0;
            }
            int i3 = i2 - i;
            C1555d c1555d5;
            if (i3 == -2) {
                c1555d3 = c1555d4.f4780b;
                c1555d5 = c1555d4.f4781c;
                if (c1555d5 != null) {
                    i2 = c1555d5.f4786h;
                } else {
                    i2 = 0;
                }
                if (c1555d3 != null) {
                    i = c1555d3.f4786h;
                } else {
                    i = 0;
                }
                i -= i2;
                if (i == -1 || (i == 0 && !z)) {
                    m5379a(c1555d2);
                } else if (f4787f || i == 1) {
                    m5382b(c1555d4);
                    m5379a(c1555d2);
                } else {
                    throw new AssertionError();
                }
                if (z) {
                    return;
                }
            } else if (i3 == 2) {
                c1555d4 = c1555d3.f4780b;
                c1555d5 = c1555d3.f4781c;
                i2 = c1555d5 != null ? c1555d5.f4786h : 0;
                if (c1555d4 != null) {
                    i = c1555d4.f4786h;
                } else {
                    i = 0;
                }
                i -= i2;
                if (i == 1 || (i == 0 && !z)) {
                    m5382b(c1555d2);
                } else if (f4787f || i == -1) {
                    m5379a(c1555d3);
                    m5382b(c1555d2);
                } else {
                    throw new AssertionError();
                }
                if (z) {
                    return;
                }
            } else if (i3 == 0) {
                c1555d2.f4786h = i2 + 1;
                if (z) {
                    return;
                }
            } else if (f4787f || i3 == -1 || i3 == 1) {
                c1555d2.f4786h = Math.max(i2, i) + 1;
                if (!z) {
                    return;
                }
            } else {
                throw new AssertionError();
            }
            c1555d2 = c1555d2.f4779a;
        }
    }

    private void m5379a(C1555d<K, V> c1555d) {
        int i;
        int i2 = 0;
        C1555d c1555d2 = c1555d.f4780b;
        C1555d c1555d3 = c1555d.f4781c;
        C1555d c1555d4 = c1555d3.f4780b;
        C1555d c1555d5 = c1555d3.f4781c;
        c1555d.f4781c = c1555d4;
        if (c1555d4 != null) {
            c1555d4.f4779a = c1555d;
        }
        m5380a((C1555d) c1555d, c1555d3);
        c1555d3.f4780b = c1555d;
        c1555d.f4779a = c1555d3;
        if (c1555d2 != null) {
            i = c1555d2.f4786h;
        } else {
            i = 0;
        }
        c1555d.f4786h = Math.max(i, c1555d4 != null ? c1555d4.f4786h : 0) + 1;
        int i3 = c1555d.f4786h;
        if (c1555d5 != null) {
            i2 = c1555d5.f4786h;
        }
        c1555d3.f4786h = Math.max(i3, i2) + 1;
    }

    private void m5382b(C1555d<K, V> c1555d) {
        int i;
        int i2 = 0;
        C1555d c1555d2 = c1555d.f4780b;
        C1555d c1555d3 = c1555d.f4781c;
        C1555d c1555d4 = c1555d2.f4780b;
        C1555d c1555d5 = c1555d2.f4781c;
        c1555d.f4780b = c1555d5;
        if (c1555d5 != null) {
            c1555d5.f4779a = c1555d;
        }
        m5380a((C1555d) c1555d, c1555d2);
        c1555d2.f4781c = c1555d;
        c1555d.f4779a = c1555d2;
        if (c1555d3 != null) {
            i = c1555d3.f4786h;
        } else {
            i = 0;
        }
        c1555d.f4786h = Math.max(i, c1555d5 != null ? c1555d5.f4786h : 0) + 1;
        int i3 = c1555d.f4786h;
        if (c1555d4 != null) {
            i2 = c1555d4.f4786h;
        }
        c1555d2.f4786h = Math.max(i3, i2) + 1;
    }

    public Set<Entry<K, V>> entrySet() {
        Set set = this.f4794h;
        if (set != null) {
            return set;
        }
        Set<Entry<K, V>> c1552a = new C1552a(this);
        this.f4794h = c1552a;
        return c1552a;
    }

    public Set<K> keySet() {
        Set set = this.f4795i;
        if (set != null) {
            return set;
        }
        Set<K> c1554b = new C1554b(this);
        this.f4795i = c1554b;
        return c1554b;
    }
}
