package com.google.api.client.p082b;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.google.api.client.b.b */
public final class ArrayValueMap {
    private final Map<String, ArrayValueMap> f4131a;
    private final Map<Field, ArrayValueMap> f4132b;
    private final Object f4133c;

    /* renamed from: com.google.api.client.b.b.a */
    static class ArrayValueMap {
        final Class<?> f4129a;
        final ArrayList<Object> f4130b;

        ArrayValueMap(Class<?> cls) {
            this.f4130b = new ArrayList();
            this.f4129a = cls;
        }

        Object m4876a() {
            return ai.m4865a(this.f4130b, this.f4129a);
        }

        void m4877a(Class<?> cls, Object obj) {
            Preconditions.m4971a(cls == this.f4129a);
            this.f4130b.add(obj);
        }
    }

    public ArrayValueMap(Object obj) {
        this.f4131a = ArrayMap.m4827a();
        this.f4132b = ArrayMap.m4827a();
        this.f4133c = obj;
    }

    public void m4878a() {
        for (Entry entry : this.f4131a.entrySet()) {
            ((Map) this.f4133c).put(entry.getKey(), ((ArrayValueMap) entry.getValue()).m4876a());
        }
        for (Entry entry2 : this.f4132b.entrySet()) {
            FieldInfo.m4944a((Field) entry2.getKey(), this.f4133c, ((ArrayValueMap) entry2.getValue()).m4876a());
        }
    }

    public void m4879a(Field field, Class<?> cls, Object obj) {
        ArrayValueMap arrayValueMap = (ArrayValueMap) this.f4132b.get(field);
        if (arrayValueMap == null) {
            arrayValueMap = new ArrayValueMap(cls);
            this.f4132b.put(field, arrayValueMap);
        }
        arrayValueMap.m4877a(cls, obj);
    }
}
