package com.google.api.client.p082b;

import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.google.api.client.b.j */
public class Data {
    public static final Boolean f4148a;
    public static final String f4149b;
    public static final Character f4150c;
    public static final Byte f4151d;
    public static final Short f4152e;
    public static final Integer f4153f;
    public static final Float f4154g;
    public static final Long f4155h;
    public static final Double f4156i;
    public static final BigInteger f4157j;
    public static final BigDecimal f4158k;
    public static final DateTime f4159l;
    private static final ConcurrentHashMap<Class<?>, Object> f4160m;

    static {
        f4148a = new Boolean(true);
        f4149b = new String();
        f4150c = new Character('\u0000');
        f4151d = new Byte((byte) 0);
        f4152e = new Short((short) 0);
        f4153f = new Integer(0);
        f4154g = new Float(0.0f);
        f4155h = new Long(0);
        f4156i = new Double(0.0d);
        f4157j = new BigInteger("0");
        f4158k = new BigDecimal("0");
        f4159l = new DateTime(0);
        f4160m = new ConcurrentHashMap();
        f4160m.put(Boolean.class, f4148a);
        f4160m.put(String.class, f4149b);
        f4160m.put(Character.class, f4150c);
        f4160m.put(Byte.class, f4151d);
        f4160m.put(Short.class, f4152e);
        f4160m.put(Integer.class, f4153f);
        f4160m.put(Float.class, f4154g);
        f4160m.put(Long.class, f4155h);
        f4160m.put(Double.class, f4156i);
        f4160m.put(BigInteger.class, f4157j);
        f4160m.put(BigDecimal.class, f4158k);
        f4160m.put(DateTime.class, f4159l);
    }

    public static <T> T m4898a(Class<?> cls) {
        int i = 0;
        T t = f4160m.get(cls);
        if (t == null) {
            synchronized (f4160m) {
                t = f4160m.get(cls);
                if (t == null) {
                    if (cls.isArray()) {
                        Class cls2 = cls;
                        do {
                            cls2 = cls2.getComponentType();
                            i++;
                        } while (cls2.isArray());
                        t = Array.newInstance(cls2, new int[i]);
                    } else if (cls.isEnum()) {
                        Object a = ClassInfo.m4891a((Class) cls).m4893a(null);
                        Preconditions.m4970a(a, "enum missing constant with @NullValue annotation: %s", cls);
                        t = a.m4953g();
                    } else {
                        t = ai.m4864a((Class) cls);
                    }
                    f4160m.put(cls, t);
                }
            }
        }
        return t;
    }

    public static boolean m4902a(Object obj) {
        return obj != null && obj == f4160m.get(obj.getClass());
    }

    public static Map<String, Object> m4906b(Object obj) {
        if (obj == null || Data.m4902a(obj)) {
            return Collections.emptyMap();
        }
        if (obj instanceof Map) {
            return (Map) obj;
        }
        return new DataMap(obj, false);
    }

    public static <T> T m4907c(T t) {
        if (t == null || Data.m4903a(t.getClass())) {
            return t;
        }
        if (t instanceof GenericData) {
            return ((GenericData) t).clone();
        }
        Object newInstance;
        Class cls = t.getClass();
        if (cls.isArray()) {
            newInstance = Array.newInstance(cls.getComponentType(), Array.getLength(t));
        } else if (t instanceof ArrayMap) {
            newInstance = ((ArrayMap) t).m4837b();
        } else if ("java.util.Arrays$ArrayList".equals(cls.getName())) {
            newInstance = ((List) t).toArray();
            Data.m4901a(newInstance, newInstance);
            return Arrays.asList(newInstance);
        } else {
            newInstance = ai.m4864a(cls);
        }
        Data.m4901a((Object) t, newInstance);
        return newInstance;
    }

    public static void m4901a(Object obj, Object obj2) {
        boolean z = true;
        int i = 0;
        Class cls = obj.getClass();
        Preconditions.m4971a(cls == obj2.getClass());
        int i2;
        Object a;
        if (cls.isArray()) {
            if (Array.getLength(obj) != Array.getLength(obj2)) {
                z = false;
            }
            Preconditions.m4971a(z);
            for (Object a2 : ai.m4863a(obj)) {
                i2 = i + 1;
                Array.set(obj2, i, Data.m4907c(a2));
                i = i2;
            }
        } else if (Collection.class.isAssignableFrom(cls)) {
            Collection<Object> collection = (Collection) obj;
            if (ArrayList.class.isAssignableFrom(cls)) {
                ((ArrayList) obj2).ensureCapacity(collection.size());
            }
            Collection collection2 = (Collection) obj2;
            for (Object c : collection) {
                collection2.add(Data.m4907c(c));
            }
        } else {
            boolean isAssignableFrom = GenericData.class.isAssignableFrom(cls);
            if (isAssignableFrom || !Map.class.isAssignableFrom(cls)) {
                ClassInfo a3 = isAssignableFrom ? ((GenericData) obj).f4206b : ClassInfo.m4891a(cls);
                for (String a4 : a3.f4144a) {
                    FieldInfo a5 = a3.m4893a(a4);
                    if (!(a5.m4951e() || (isAssignableFrom && a5.m4952f()))) {
                        a2 = a5.m4945a(obj);
                        if (a2 != null) {
                            a5.m4947a(obj2, Data.m4907c(a2));
                        }
                    }
                }
            } else if (ArrayMap.class.isAssignableFrom(cls)) {
                ArrayMap arrayMap = (ArrayMap) obj2;
                ArrayMap arrayMap2 = (ArrayMap) obj;
                i2 = arrayMap2.size();
                while (i < i2) {
                    arrayMap.m4835a(i, Data.m4907c(arrayMap2.m4838b(i)));
                    i++;
                }
            } else {
                Map map = (Map) obj2;
                for (Entry entry : ((Map) obj).entrySet()) {
                    map.put(entry.getKey(), Data.m4907c(entry.getValue()));
                }
            }
        }
    }

    public static boolean m4903a(Type type) {
        Type a;
        if (type instanceof WildcardType) {
            a = ai.m4868a((WildcardType) type);
        } else {
            a = type;
        }
        if (!(a instanceof Class)) {
            return false;
        }
        Class cls = (Class) a;
        boolean z = cls.isPrimitive() || cls == Character.class || cls == String.class || cls == Integer.class || cls == Long.class || cls == Short.class || cls == Byte.class || cls == Float.class || cls == Double.class || cls == BigInteger.class || cls == BigDecimal.class || cls == DateTime.class || cls == Boolean.class;
        return z;
    }

    public static boolean m4908d(Object obj) {
        return obj == null || Data.m4903a(obj.getClass());
    }

    public static Object m4899a(Type type, String str) {
        Class cls = type instanceof Class ? (Class) type : null;
        if (type == null || cls != null) {
            if (cls == Void.class) {
                return null;
            }
            if (str == null || cls == null || cls.isAssignableFrom(String.class)) {
                return str;
            }
            if (cls == Character.class || cls == Character.TYPE) {
                if (str.length() == 1) {
                    return Character.valueOf(str.charAt(0));
                }
                throw new IllegalArgumentException("expected type Character/char but got " + cls);
            } else if (cls == Boolean.class || cls == Boolean.TYPE) {
                return Boolean.valueOf(str);
            } else {
                if (cls == Byte.class || cls == Byte.TYPE) {
                    return Byte.valueOf(str);
                }
                if (cls == Short.class || cls == Short.TYPE) {
                    return Short.valueOf(str);
                }
                if (cls == Integer.class || cls == Integer.TYPE) {
                    return Integer.valueOf(str);
                }
                if (cls == Long.class || cls == Long.TYPE) {
                    return Long.valueOf(str);
                }
                if (cls == Float.class || cls == Float.TYPE) {
                    return Float.valueOf(str);
                }
                if (cls == Double.class || cls == Double.TYPE) {
                    return Double.valueOf(str);
                }
                if (cls == DateTime.class) {
                    return DateTime.m4914a(str);
                }
                if (cls == BigInteger.class) {
                    return new BigInteger(str);
                }
                if (cls == BigDecimal.class) {
                    return new BigDecimal(str);
                }
                if (cls.isEnum()) {
                    return ClassInfo.m4891a(cls).m4893a(str).m4953g();
                }
            }
        }
        throw new IllegalArgumentException("expected primitive class, but got: " + type);
    }

    public static Collection<Object> m4904b(Type type) {
        Type a;
        Object rawType;
        if (type instanceof WildcardType) {
            a = ai.m4868a((WildcardType) type);
        } else {
            a = type;
        }
        if (a instanceof ParameterizedType) {
            rawType = ((ParameterizedType) a).getRawType();
        } else {
            Type type2 = a;
        }
        Class cls = rawType instanceof Class ? (Class) rawType : null;
        if (rawType == null || (rawType instanceof GenericArrayType) || (cls != null && (cls.isArray() || cls.isAssignableFrom(ArrayList.class)))) {
            return new ArrayList();
        }
        if (cls == null) {
            throw new IllegalArgumentException("unable to create new instance of type: " + rawType);
        } else if (cls.isAssignableFrom(HashSet.class)) {
            return new HashSet();
        } else {
            if (cls.isAssignableFrom(TreeSet.class)) {
                return new TreeSet();
            }
            return (Collection) ai.m4864a(cls);
        }
    }

    public static Map<String, Object> m4905b(Class<?> cls) {
        if (cls == null || cls.isAssignableFrom(ArrayMap.class)) {
            return ArrayMap.m4827a();
        }
        if (cls.isAssignableFrom(TreeMap.class)) {
            return new TreeMap();
        }
        return (Map) ai.m4864a((Class) cls);
    }

    public static Type m4900a(List<Type> list, Type type) {
        Type a;
        if (type instanceof WildcardType) {
            a = ai.m4868a((WildcardType) type);
        } else {
            a = type;
        }
        while (a instanceof TypeVariable) {
            Type a2 = ai.m4869a((List) list, (TypeVariable) a);
            if (a2 == null) {
                a2 = a;
            }
            if (a2 instanceof TypeVariable) {
                a = ((TypeVariable) a2).getBounds()[0];
            } else {
                a = a2;
            }
        }
        return a;
    }
}
