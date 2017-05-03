package com.google.api.client.p082b;

import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Set;

/* renamed from: com.google.api.client.b.k */
final class DataMap extends AbstractMap<String, Object> {
    final Object f4172a;
    final ClassInfo f4173b;

    /* renamed from: com.google.api.client.b.k.a */
    final class DataMap implements Entry<String, Object> {
        final /* synthetic */ DataMap f4161a;
        private Object f4162b;
        private final FieldInfo f4163c;

        public /* synthetic */ Object getKey() {
            return m4909a();
        }

        DataMap(DataMap dataMap, FieldInfo fieldInfo, Object obj) {
            this.f4161a = dataMap;
            this.f4163c = fieldInfo;
            this.f4162b = Preconditions.m4968a(obj);
        }

        public String m4909a() {
            String b = this.f4163c.m4948b();
            if (this.f4161a.f4173b.m4894a()) {
                return b.toLowerCase();
            }
            return b;
        }

        public Object getValue() {
            return this.f4162b;
        }

        public Object setValue(Object obj) {
            Object obj2 = this.f4162b;
            this.f4162b = Preconditions.m4968a(obj);
            this.f4163c.m4947a(this.f4161a.f4172a, obj);
            return obj2;
        }

        public int hashCode() {
            return m4909a().hashCode() ^ getValue().hashCode();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Entry)) {
                return false;
            }
            Entry entry = (Entry) obj;
            if (m4909a().equals(entry.getKey()) && getValue().equals(entry.getValue())) {
                return true;
            }
            return false;
        }
    }

    /* renamed from: com.google.api.client.b.k.b */
    final class DataMap implements Iterator<Entry<String, Object>> {
        final /* synthetic */ DataMap f4164a;
        private int f4165b;
        private FieldInfo f4166c;
        private Object f4167d;
        private boolean f4168e;
        private boolean f4169f;
        private FieldInfo f4170g;

        DataMap(DataMap dataMap) {
            this.f4164a = dataMap;
            this.f4165b = -1;
        }

        public /* synthetic */ Object next() {
            return m4910a();
        }

        public boolean hasNext() {
            if (!this.f4169f) {
                this.f4169f = true;
                this.f4167d = null;
                while (this.f4167d == null) {
                    int i = this.f4165b + 1;
                    this.f4165b = i;
                    if (i >= this.f4164a.f4173b.f4144a.size()) {
                        break;
                    }
                    this.f4166c = this.f4164a.f4173b.m4893a((String) this.f4164a.f4173b.f4144a.get(this.f4165b));
                    this.f4167d = this.f4166c.m4945a(this.f4164a.f4172a);
                }
            }
            return this.f4167d != null;
        }

        public Entry<String, Object> m4910a() {
            if (hasNext()) {
                this.f4170g = this.f4166c;
                Object obj = this.f4167d;
                this.f4169f = false;
                this.f4168e = false;
                this.f4166c = null;
                this.f4167d = null;
                return new DataMap(this.f4164a, this.f4170g, obj);
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            boolean z = (this.f4170g == null || this.f4168e) ? false : true;
            Preconditions.m4974b(z);
            this.f4168e = true;
            this.f4170g.m4947a(this.f4164a.f4172a, null);
        }
    }

    /* renamed from: com.google.api.client.b.k.c */
    final class DataMap extends AbstractSet<Entry<String, Object>> {
        final /* synthetic */ DataMap f4171a;

        DataMap(DataMap dataMap) {
            this.f4171a = dataMap;
        }

        public /* synthetic */ Iterator iterator() {
            return m4911a();
        }

        public DataMap m4911a() {
            return new DataMap(this.f4171a);
        }

        public int size() {
            int i = 0;
            for (String a : this.f4171a.f4173b.f4144a) {
                int i2;
                if (this.f4171a.f4173b.m4893a(a).m4945a(this.f4171a.f4172a) != null) {
                    i2 = i + 1;
                } else {
                    i2 = i;
                }
                i = i2;
            }
            return i;
        }

        public void clear() {
            for (String a : this.f4171a.f4173b.f4144a) {
                this.f4171a.f4173b.m4893a(a).m4947a(this.f4171a.f4172a, null);
            }
        }

        public boolean isEmpty() {
            for (String a : this.f4171a.f4173b.f4144a) {
                if (this.f4171a.f4173b.m4893a(a).m4945a(this.f4171a.f4172a) != null) {
                    return false;
                }
            }
            return true;
        }
    }

    public /* synthetic */ Set entrySet() {
        return m4912a();
    }

    public /* synthetic */ Object put(Object obj, Object obj2) {
        return m4913a((String) obj, obj2);
    }

    DataMap(Object obj, boolean z) {
        this.f4172a = obj;
        this.f4173b = ClassInfo.m4892a(obj.getClass(), z);
        Preconditions.m4971a(!this.f4173b.m4896b());
    }

    public DataMap m4912a() {
        return new DataMap(this);
    }

    public boolean containsKey(Object obj) {
        return get(obj) != null;
    }

    public Object get(Object obj) {
        if (!(obj instanceof String)) {
            return null;
        }
        FieldInfo a = this.f4173b.m4893a((String) obj);
        if (a != null) {
            return a.m4945a(this.f4172a);
        }
        return null;
    }

    public Object m4913a(String str, Object obj) {
        Object a = this.f4173b.m4893a(str);
        Preconditions.m4969a(a, "no field of key " + str);
        Object a2 = a.m4945a(this.f4172a);
        a.m4947a(this.f4172a, Preconditions.m4968a(obj));
        return a2;
    }
}
