package com.google.gson.reflect;

import com.google.gson.internal.C$Gson$Preconditions;
import com.google.gson.internal.C$Gson$Types;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.HashMap;
import java.util.Map;

public class TypeToken<T> {
    final Class<? super T> f4648a;
    final Type f4649b;
    final int f4650c;

    protected TypeToken() {
        this.f4649b = m5299a(getClass());
        this.f4648a = C$Gson$Types.getRawType(this.f4649b);
        this.f4650c = this.f4649b.hashCode();
    }

    TypeToken(Type type) {
        this.f4649b = C$Gson$Types.canonicalize((Type) C$Gson$Preconditions.checkNotNull(type));
        this.f4648a = C$Gson$Types.getRawType(this.f4649b);
        this.f4650c = this.f4649b.hashCode();
    }

    static Type m5299a(Class<?> cls) {
        Type genericSuperclass = cls.getGenericSuperclass();
        if (!(genericSuperclass instanceof Class)) {
            return C$Gson$Types.canonicalize(((ParameterizedType) genericSuperclass).getActualTypeArguments()[0]);
        }
        throw new RuntimeException("Missing type parameter.");
    }

    public final Class<? super T> getRawType() {
        return this.f4648a;
    }

    public final Type getType() {
        return this.f4649b;
    }

    @Deprecated
    public boolean isAssignableFrom(Class<?> cls) {
        return isAssignableFrom((Type) cls);
    }

    @Deprecated
    public boolean isAssignableFrom(Type type) {
        if (type == null) {
            return false;
        }
        if (this.f4649b.equals(type)) {
            return true;
        }
        if (this.f4649b instanceof Class) {
            return this.f4648a.isAssignableFrom(C$Gson$Types.getRawType(type));
        }
        if (this.f4649b instanceof ParameterizedType) {
            return m5302a(type, (ParameterizedType) this.f4649b, new HashMap());
        }
        if (this.f4649b instanceof GenericArrayType) {
            boolean z = this.f4648a.isAssignableFrom(C$Gson$Types.getRawType(type)) && m5301a(type, (GenericArrayType) this.f4649b);
            return z;
        }
        throw m5298a(this.f4649b, Class.class, ParameterizedType.class, GenericArrayType.class);
    }

    @Deprecated
    public boolean isAssignableFrom(TypeToken<?> typeToken) {
        return isAssignableFrom(typeToken.getType());
    }

    private static boolean m5301a(Type type, GenericArrayType genericArrayType) {
        Type genericComponentType = genericArrayType.getGenericComponentType();
        if (!(genericComponentType instanceof ParameterizedType)) {
            return true;
        }
        if (type instanceof GenericArrayType) {
            type = ((GenericArrayType) type).getGenericComponentType();
        } else if (type instanceof Class) {
            type = (Class) type;
            while (type.isArray()) {
                type = type.getComponentType();
            }
        }
        return m5302a(type, (ParameterizedType) genericComponentType, new HashMap());
    }

    private static boolean m5302a(Type type, ParameterizedType parameterizedType, Map<String, Type> map) {
        int i = 0;
        if (type == null) {
            return false;
        }
        if (parameterizedType.equals(type)) {
            return true;
        }
        int i2;
        Class rawType = C$Gson$Types.getRawType(type);
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType2 = (ParameterizedType) type;
        } else {
            type = null;
        }
        if (parameterizedType2 != null) {
            Type[] actualTypeArguments = parameterizedType2.getActualTypeArguments();
            TypeVariable[] typeParameters = rawType.getTypeParameters();
            for (i2 = 0; i2 < actualTypeArguments.length; i2++) {
                Object obj = actualTypeArguments[i2];
                TypeVariable typeVariable = typeParameters[i2];
                while (obj instanceof TypeVariable) {
                    Type type2 = (Type) map.get(((TypeVariable) obj).getName());
                }
                map.put(typeVariable.getName(), obj);
            }
            if (m5300a(parameterizedType2, parameterizedType, (Map) map)) {
                return true;
            }
        }
        Type[] genericInterfaces = rawType.getGenericInterfaces();
        i2 = genericInterfaces.length;
        while (i < i2) {
            if (m5302a(genericInterfaces[i], parameterizedType, new HashMap(map))) {
                return true;
            }
            i++;
        }
        return m5302a(rawType.getGenericSuperclass(), parameterizedType, new HashMap(map));
    }

    private static boolean m5300a(ParameterizedType parameterizedType, ParameterizedType parameterizedType2, Map<String, Type> map) {
        if (!parameterizedType.getRawType().equals(parameterizedType2.getRawType())) {
            return false;
        }
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        Type[] actualTypeArguments2 = parameterizedType2.getActualTypeArguments();
        for (int i = 0; i < actualTypeArguments.length; i++) {
            if (!m5303a(actualTypeArguments[i], actualTypeArguments2[i], (Map) map)) {
                return false;
            }
        }
        return true;
    }

    private static AssertionError m5298a(Type type, Class<?>... clsArr) {
        StringBuilder stringBuilder = new StringBuilder("Unexpected type. Expected one of: ");
        for (Class name : clsArr) {
            stringBuilder.append(name.getName()).append(", ");
        }
        stringBuilder.append("but got: ").append(type.getClass().getName()).append(", for type token: ").append(type.toString()).append('.');
        return new AssertionError(stringBuilder.toString());
    }

    private static boolean m5303a(Type type, Type type2, Map<String, Type> map) {
        return type2.equals(type) || ((type instanceof TypeVariable) && type2.equals(map.get(((TypeVariable) type).getName())));
    }

    public final int hashCode() {
        return this.f4650c;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof TypeToken) && C$Gson$Types.equals(this.f4649b, ((TypeToken) obj).f4649b);
    }

    public final String toString() {
        return C$Gson$Types.typeToString(this.f4649b);
    }

    public static TypeToken<?> get(Type type) {
        return new TypeToken(type);
    }

    public static <T> TypeToken<T> get(Class<T> cls) {
        return new TypeToken(cls);
    }
}
