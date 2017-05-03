package com.google.api.client.p082b;

import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Set;

/* renamed from: com.google.api.client.b.a */
public class ArrayMap<K, V> extends AbstractMap<K, V> implements Cloneable {
    int f4121a;
    private Object[] f4122b;

    /* renamed from: com.google.api.client.b.a.a */
    final class ArrayMap implements Entry<K, V> {
        final /* synthetic */ ArrayMap f4105a;
        private int f4106b;

        ArrayMap(ArrayMap arrayMap, int i) {
            this.f4105a = arrayMap;
            this.f4106b = i;
        }

        public K getKey() {
            return this.f4105a.m4834a(this.f4106b);
        }

        public V getValue() {
            return this.f4105a.m4838b(this.f4106b);
        }

        public V setValue(V v) {
            return this.f4105a.m4835a(this.f4106b, v);
        }

        public int hashCode() {
            return getKey().hashCode() ^ getValue().hashCode();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Entry)) {
                return false;
            }
            Entry entry = (Entry) obj;
            if (Objects.m4967a(getKey(), entry.getKey()) && Objects.m4967a(getValue(), entry.getValue())) {
                return true;
            }
            return false;
        }
    }

    /* renamed from: com.google.api.client.b.a.b */
    final class ArrayMap implements Iterator<Entry<K, V>> {
        final /* synthetic */ ArrayMap f4107a;
        private boolean f4108b;
        private int f4109c;

        ArrayMap(ArrayMap arrayMap) {
            this.f4107a = arrayMap;
        }

        public /* synthetic */ Object next() {
            return m4808a();
        }

        public boolean hasNext() {
            return this.f4109c < this.f4107a.f4121a;
        }

        public Entry<K, V> m4808a() {
            int i = this.f4109c;
            if (i == this.f4107a.f4121a) {
                throw new NoSuchElementException();
            }
            this.f4109c++;
            return new ArrayMap(this.f4107a, i);
        }

        public void remove() {
            int i = this.f4109c - 1;
            if (this.f4108b || i < 0) {
                throw new IllegalArgumentException();
            }
            this.f4107a.m4839c(i);
            this.f4108b = true;
        }
    }

    /* renamed from: com.google.api.client.b.a.c */
    final class ArrayMap extends AbstractSet<Entry<K, V>> {
        final /* synthetic */ ArrayMap f4110a;

        ArrayMap(ArrayMap arrayMap) {
            this.f4110a = arrayMap;
        }

        public Iterator<Entry<K, V>> iterator() {
            return new ArrayMap(this.f4110a);
        }

        public int size() {
            return this.f4110a.f4121a;
        }
    }

    public /* synthetic */ Object clone() {
        return m4837b();
    }

    public static <K, V> ArrayMap<K, V> m4827a() {
        return new ArrayMap();
    }

    public final int size() {
        return this.f4121a;
    }

    public final K m4834a(int i) {
        if (i < 0 || i >= this.f4121a) {
            return null;
        }
        return this.f4122b[i << 1];
    }

    public final V m4838b(int i) {
        if (i < 0 || i >= this.f4121a) {
            return null;
        }
        return m4831f((i << 1) + 1);
    }

    public final V m4836a(int i, K k, V v) {
        if (i < 0) {
            throw new IndexOutOfBoundsException();
        }
        int i2 = i + 1;
        m4840d(i2);
        int i3 = i << 1;
        V f = m4831f(i3 + 1);
        m4829b(i3, k, v);
        if (i2 > this.f4121a) {
            this.f4121a = i2;
        }
        return f;
    }

    public final V m4835a(int i, V v) {
        int i2 = this.f4121a;
        if (i < 0 || i >= i2) {
            throw new IndexOutOfBoundsException();
        }
        i2 = (i << 1) + 1;
        V f = m4831f(i2);
        this.f4122b[i2] = v;
        return f;
    }

    public final V m4839c(int i) {
        return m4832g(i << 1);
    }

    public final boolean containsKey(Object obj) {
        return -2 != m4828b(obj);
    }

    public final int m4833a(K k) {
        return m4828b((Object) k) >> 1;
    }

    public final V get(Object obj) {
        return m4831f(m4828b(obj) + 1);
    }

    public final V put(K k, V v) {
        int a = m4833a((Object) k);
        if (a == -1) {
            a = this.f4121a;
        }
        return m4836a(a, k, v);
    }

    public final V remove(Object obj) {
        return m4832g(m4828b(obj));
    }

    public final void m4840d(int i) {
        if (i < 0) {
            throw new IndexOutOfBoundsException();
        }
        Object[] objArr = this.f4122b;
        int i2 = i << 1;
        int length = objArr == null ? 0 : objArr.length;
        if (i2 > length) {
            length = ((length / 2) * 3) + 1;
            if (length % 2 != 0) {
                length++;
            }
            if (length >= i2) {
                i2 = length;
            }
            m4830e(i2);
        }
    }

    private void m4830e(int i) {
        if (i == 0) {
            this.f4122b = null;
            return;
        }
        int i2 = this.f4121a;
        Object obj = this.f4122b;
        if (i2 == 0 || i != obj.length) {
            Object obj2 = new Object[i];
            this.f4122b = obj2;
            if (i2 != 0) {
                System.arraycopy(obj, 0, obj2, 0, i2 << 1);
            }
        }
    }

    private void m4829b(int i, K k, V v) {
        Object[] objArr = this.f4122b;
        objArr[i] = k;
        objArr[i + 1] = v;
    }

    private V m4831f(int i) {
        if (i < 0) {
            return null;
        }
        return this.f4122b[i];
    }

    private int m4828b(Object obj) {
        int i = this.f4121a << 1;
        Object[] objArr = this.f4122b;
        for (int i2 = 0; i2 < i; i2 += 2) {
            Object obj2 = objArr[i2];
            if (obj == null) {
                if (obj2 == null) {
                    return i2;
                }
            } else if (obj.equals(obj2)) {
                return i2;
            }
        }
        return -2;
    }

    private V m4832g(int i) {
        int i2 = this.f4121a << 1;
        if (i < 0 || i >= i2) {
            return null;
        }
        V f = m4831f(i + 1);
        Object obj = this.f4122b;
        int i3 = (i2 - i) - 2;
        if (i3 != 0) {
            System.arraycopy(obj, i + 2, obj, i, i3);
        }
        this.f4121a--;
        m4829b(i2 - 2, null, null);
        return f;
    }

    public void clear() {
        this.f4121a = 0;
        this.f4122b = null;
    }

    public final boolean containsValue(Object obj) {
        int i = this.f4121a << 1;
        Object[] objArr = this.f4122b;
        for (int i2 = 1; i2 < i; i2 += 2) {
            Object obj2 = objArr[i2];
            if (obj == null) {
                if (obj2 == null) {
                    return true;
                }
            } else if (obj.equals(obj2)) {
                return true;
            }
        }
        return false;
    }

    public final Set<Entry<K, V>> entrySet() {
        return new ArrayMap(this);
    }

    public ArrayMap<K, V> m4837b() {
        try {
            ArrayMap<K, V> arrayMap = (ArrayMap) super.clone();
            Object obj = this.f4122b;
            if (obj == null) {
                return arrayMap;
            }
            int length = obj.length;
            Object obj2 = new Object[length];
            arrayMap.f4122b = obj2;
            System.arraycopy(obj, 0, obj2, 0, length);
            return arrayMap;
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}
