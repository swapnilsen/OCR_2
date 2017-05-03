package com.google.api.client.p082b;

import com.google.api.client.p082b.DataMap.DataMap;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* renamed from: com.google.api.client.b.o */
public class GenericData extends AbstractMap<String, Object> implements Cloneable {
    Map<String, Object> f4205a;
    final ClassInfo f4206b;

    /* renamed from: com.google.api.client.b.o.a */
    final class GenericData implements Iterator<Entry<String, Object>> {
        final /* synthetic */ GenericData f4197a;
        private boolean f4198b;
        private final Iterator<Entry<String, Object>> f4199c;
        private final Iterator<Entry<String, Object>> f4200d;

        public /* synthetic */ Object next() {
            return m4954a();
        }

        GenericData(GenericData genericData, DataMap dataMap) {
            this.f4197a = genericData;
            this.f4199c = dataMap.m4911a();
            this.f4200d = genericData.f4205a.entrySet().iterator();
        }

        public boolean hasNext() {
            return this.f4199c.hasNext() || this.f4200d.hasNext();
        }

        public Entry<String, Object> m4954a() {
            if (!this.f4198b) {
                if (this.f4199c.hasNext()) {
                    return (Entry) this.f4199c.next();
                }
                this.f4198b = true;
            }
            return (Entry) this.f4200d.next();
        }

        public void remove() {
            if (this.f4198b) {
                this.f4200d.remove();
            }
            this.f4199c.remove();
        }
    }

    /* renamed from: com.google.api.client.b.o.b */
    final class GenericData extends AbstractSet<Entry<String, Object>> {
        final /* synthetic */ GenericData f4201a;
        private final DataMap f4202b;

        GenericData(GenericData genericData) {
            this.f4201a = genericData;
            this.f4202b = new DataMap(genericData, genericData.f4206b.m4894a()).m4912a();
        }

        public Iterator<Entry<String, Object>> iterator() {
            return new GenericData(this.f4201a, this.f4202b);
        }

        public int size() {
            return this.f4201a.f4205a.size() + this.f4202b.size();
        }

        public void clear() {
            this.f4201a.f4205a.clear();
            this.f4202b.clear();
        }
    }

    /* renamed from: com.google.api.client.b.o.c */
    public enum GenericData {
        IGNORE_CASE
    }

    public GenericData() {
        this(EnumSet.noneOf(GenericData.class));
    }

    public GenericData(EnumSet<GenericData> enumSet) {
        this.f4205a = ArrayMap.m4827a();
        this.f4206b = ClassInfo.m4892a(getClass(), enumSet.contains(GenericData.IGNORE_CASE));
    }

    public final Object get(Object obj) {
        if (!(obj instanceof String)) {
            return null;
        }
        obj = (String) obj;
        FieldInfo a = this.f4206b.m4893a((String) obj);
        if (a != null) {
            return a.m4945a((Object) this);
        }
        if (this.f4206b.m4894a()) {
            obj = obj.toLowerCase();
        }
        return this.f4205a.get(obj);
    }

    public final Object put(String str, Object obj) {
        FieldInfo a = this.f4206b.m4893a(str);
        if (a != null) {
            Object a2 = a.m4945a((Object) this);
            a.m4947a((Object) this, obj);
            return a2;
        }
        if (this.f4206b.m4894a()) {
            str = str.toLowerCase();
        }
        return this.f4205a.put(str, obj);
    }

    public GenericData set(String str, Object obj) {
        FieldInfo a = this.f4206b.m4893a(str);
        if (a != null) {
            a.m4947a((Object) this, obj);
        } else {
            if (this.f4206b.m4894a()) {
                str = str.toLowerCase();
            }
            this.f4205a.put(str, obj);
        }
        return this;
    }

    public final void putAll(Map<? extends String, ?> map) {
        for (Entry entry : map.entrySet()) {
            set((String) entry.getKey(), entry.getValue());
        }
    }

    public final Object remove(Object obj) {
        if (!(obj instanceof String)) {
            return null;
        }
        obj = (String) obj;
        if (this.f4206b.m4893a((String) obj) != null) {
            throw new UnsupportedOperationException();
        }
        if (this.f4206b.m4894a()) {
            obj = obj.toLowerCase();
        }
        return this.f4205a.remove(obj);
    }

    public Set<Entry<String, Object>> entrySet() {
        return new GenericData(this);
    }

    public GenericData clone() {
        try {
            Object obj = (GenericData) super.clone();
            Data.m4901a((Object) this, obj);
            obj.f4205a = (Map) Data.m4907c(this.f4205a);
            return obj;
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    public final Map<String, Object> getUnknownKeys() {
        return this.f4205a;
    }

    public final void setUnknownKeys(Map<String, Object> map) {
        this.f4205a = map;
    }

    public final ClassInfo getClassInfo() {
        return this.f4206b;
    }
}
