package com.google.gson.internal;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class Primitives {
    private static final Map<Class<?>, Class<?>> f4796a;
    private static final Map<Class<?>, Class<?>> f4797b;

    private Primitives() {
        throw new UnsupportedOperationException();
    }

    static {
        Map hashMap = new HashMap(16);
        Map hashMap2 = new HashMap(16);
        m5389a(hashMap, hashMap2, Boolean.TYPE, Boolean.class);
        m5389a(hashMap, hashMap2, Byte.TYPE, Byte.class);
        m5389a(hashMap, hashMap2, Character.TYPE, Character.class);
        m5389a(hashMap, hashMap2, Double.TYPE, Double.class);
        m5389a(hashMap, hashMap2, Float.TYPE, Float.class);
        m5389a(hashMap, hashMap2, Integer.TYPE, Integer.class);
        m5389a(hashMap, hashMap2, Long.TYPE, Long.class);
        m5389a(hashMap, hashMap2, Short.TYPE, Short.class);
        m5389a(hashMap, hashMap2, Void.TYPE, Void.class);
        f4796a = Collections.unmodifiableMap(hashMap);
        f4797b = Collections.unmodifiableMap(hashMap2);
    }

    private static void m5389a(Map<Class<?>, Class<?>> map, Map<Class<?>, Class<?>> map2, Class<?> cls, Class<?> cls2) {
        map.put(cls, cls2);
        map2.put(cls2, cls);
    }

    public static boolean isPrimitive(Type type) {
        return f4796a.containsKey(type);
    }

    public static boolean isWrapperType(Type type) {
        return f4797b.containsKey(C$Gson$Preconditions.checkNotNull(type));
    }

    public static <T> Class<T> wrap(Class<T> cls) {
        Class<T> cls2 = (Class) f4796a.get(C$Gson$Preconditions.checkNotNull(cls));
        return cls2 == null ? cls : cls2;
    }

    public static <T> Class<T> unwrap(Class<T> cls) {
        Class<T> cls2 = (Class) f4797b.get(C$Gson$Preconditions.checkNotNull(cls));
        return cls2 == null ? cls : cls2;
    }
}
