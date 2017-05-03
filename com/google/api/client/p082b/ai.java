package com.google.api.client.p082b;

import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

/* compiled from: Types */
/* renamed from: com.google.api.client.b.ai */
public class ai {

    /* renamed from: com.google.api.client.b.ai.1 */
    static class Types implements Iterable<T> {
        final /* synthetic */ Object f4128a;

        /* renamed from: com.google.api.client.b.ai.1.1 */
        class Types implements Iterator<T> {
            final int f4125a;
            int f4126b;
            final /* synthetic */ Types f4127c;

            Types(Types types) {
                this.f4127c = types;
                this.f4125a = Array.getLength(this.f4127c.f4128a);
                this.f4126b = 0;
            }

            public boolean hasNext() {
                return this.f4126b < this.f4125a;
            }

            public T next() {
                if (hasNext()) {
                    Object obj = this.f4127c.f4128a;
                    int i = this.f4126b;
                    this.f4126b = i + 1;
                    return Array.get(obj, i);
                }
                throw new NoSuchElementException();
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }
        }

        Types(Object obj) {
            this.f4128a = obj;
        }

        public Iterator<T> iterator() {
            return new Types(this);
        }
    }

    public static ParameterizedType m4866a(Type type, Class<?> cls) {
        if ((type instanceof Class) || (type instanceof ParameterizedType)) {
            Type type2 = type;
            while (type2 != null && type2 != Object.class) {
                Class cls2;
                if (type2 instanceof Class) {
                    cls2 = (Class) type2;
                } else {
                    ParameterizedType parameterizedType = (ParameterizedType) type2;
                    Class<?> a = ai.m4860a(parameterizedType);
                    if (a == cls) {
                        return parameterizedType;
                    }
                    if (cls.isInterface()) {
                        for (Type type3 : a.getGenericInterfaces()) {
                            if (cls.isAssignableFrom(type3 instanceof Class ? (Class) type3 : ai.m4860a((ParameterizedType) type3))) {
                                type2 = type3;
                                break;
                            }
                        }
                    }
                    Class<?> cls3 = a;
                }
                type2 = cls2.getGenericSuperclass();
            }
        }
        return null;
    }

    public static boolean m4870a(Class<?> cls, Class<?> cls2) {
        return cls.isAssignableFrom(cls2) || cls2.isAssignableFrom(cls);
    }

    public static <T> T m4864a(Class<T> cls) {
        try {
            return cls.newInstance();
        } catch (Exception e) {
            throw ai.m4862a(e, (Class) cls);
        } catch (Exception e2) {
            throw ai.m4862a(e2, (Class) cls);
        }
    }

    private static IllegalArgumentException m4862a(Exception exception, Class<?> cls) {
        StringBuilder append = new StringBuilder("unable to create new instance of class ").append(cls.getName());
        ArrayList arrayList = new ArrayList();
        if (cls.isArray()) {
            arrayList.add("because it is an array");
        } else if (cls.isPrimitive()) {
            arrayList.add("because it is primitive");
        } else if (cls == Void.class) {
            arrayList.add("because it is void");
        } else {
            if (Modifier.isInterface(cls.getModifiers())) {
                arrayList.add("because it is an interface");
            } else if (Modifier.isAbstract(cls.getModifiers())) {
                arrayList.add("because it is abstract");
            }
            if (!(cls.getEnclosingClass() == null || Modifier.isStatic(cls.getModifiers()))) {
                arrayList.add("because it is not static");
            }
            if (Modifier.isPublic(cls.getModifiers())) {
                try {
                    cls.getConstructor(new Class[0]);
                } catch (NoSuchMethodException e) {
                    arrayList.add("because it has no accessible default constructor");
                }
            } else {
                arrayList.add("possibly because it is not public");
            }
        }
        Iterator it = arrayList.iterator();
        Object obj = null;
        while (it.hasNext()) {
            String str = (String) it.next();
            if (obj != null) {
                append.append(" and");
            } else {
                obj = 1;
            }
            append.append(" ").append(str);
        }
        return new IllegalArgumentException(append.toString(), exception);
    }

    public static boolean m4871a(Type type) {
        return (type instanceof GenericArrayType) || ((type instanceof Class) && ((Class) type).isArray());
    }

    public static Type m4872b(Type type) {
        return type instanceof GenericArrayType ? ((GenericArrayType) type).getGenericComponentType() : ((Class) type).getComponentType();
    }

    public static Class<?> m4860a(ParameterizedType parameterizedType) {
        return (Class) parameterizedType.getRawType();
    }

    public static Type m4868a(WildcardType wildcardType) {
        Type[] lowerBounds = wildcardType.getLowerBounds();
        if (lowerBounds.length != 0) {
            return lowerBounds[0];
        }
        return wildcardType.getUpperBounds()[0];
    }

    public static Type m4869a(List<Type> list, TypeVariable<?> typeVariable) {
        GenericDeclaration genericDeclaration = typeVariable.getGenericDeclaration();
        if (genericDeclaration instanceof Class) {
            Class cls = (Class) genericDeclaration;
            int size = list.size();
            ParameterizedType parameterizedType = null;
            while (parameterizedType == null) {
                size--;
                if (size < 0) {
                    break;
                }
                parameterizedType = ai.m4866a((Type) list.get(size), cls);
            }
            if (parameterizedType != null) {
                TypeVariable[] typeParameters = genericDeclaration.getTypeParameters();
                int i = 0;
                while (i < typeParameters.length && !typeParameters[i].equals(typeVariable)) {
                    i++;
                }
                Type type = parameterizedType.getActualTypeArguments()[i];
                if (!(type instanceof TypeVariable)) {
                    return type;
                }
                Type a = ai.m4869a((List) list, (TypeVariable) type);
                if (a != null) {
                    return a;
                }
                return type;
            }
        }
        return null;
    }

    public static Class<?> m4861a(List<Type> list, Type type) {
        Type a;
        if (type instanceof TypeVariable) {
            a = ai.m4869a((List) list, (TypeVariable) type);
        } else {
            a = type;
        }
        if (a instanceof GenericArrayType) {
            return Array.newInstance(ai.m4861a((List) list, ai.m4872b(a)), 0).getClass();
        }
        if (a instanceof Class) {
            return (Class) a;
        }
        if (a instanceof ParameterizedType) {
            return ai.m4860a((ParameterizedType) a);
        }
        boolean z;
        if (a == null) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.m4973a(z, "wildcard type is not supported: %s", a);
        return Object.class;
    }

    public static Type m4873c(Type type) {
        return ai.m4867a(type, Iterable.class, 0);
    }

    public static Type m4874d(Type type) {
        return ai.m4867a(type, Map.class, 1);
    }

    private static Type m4867a(Type type, Class<?> cls, int i) {
        ParameterizedType a = ai.m4866a(type, (Class) cls);
        if (a == null) {
            return null;
        }
        Type type2 = a.getActualTypeArguments()[i];
        if (!(type2 instanceof TypeVariable)) {
            return type2;
        }
        Type a2 = ai.m4869a(Arrays.asList(new Type[]{type}), (TypeVariable) type2);
        if (a2 != null) {
            return a2;
        }
        return type2;
    }

    public static <T> Iterable<T> m4863a(Object obj) {
        if (obj instanceof Iterable) {
            return (Iterable) obj;
        }
        Class cls = obj.getClass();
        Preconditions.m4973a(cls.isArray(), "not an array or Iterable: %s", cls);
        if (cls.getComponentType().isPrimitive()) {
            return new Types(obj);
        }
        return Arrays.asList((Object[]) obj);
    }

    public static Object m4865a(Collection<?> collection, Class<?> cls) {
        if (!cls.isPrimitive()) {
            return collection.toArray((Object[]) Array.newInstance(cls, collection.size()));
        }
        Object newInstance = Array.newInstance(cls, collection.size());
        int i = 0;
        for (Object obj : collection) {
            int i2 = i + 1;
            Array.set(newInstance, i, obj);
            i = i2;
        }
        return newInstance;
    }
}
