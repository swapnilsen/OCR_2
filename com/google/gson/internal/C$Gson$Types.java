package com.google.gson.internal;

import com.google.gson.internal.$Gson$Types$.Gson.Types;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Properties;

/* renamed from: com.google.gson.internal.$Gson$Types */
public final class C$Gson$Types {
    static final Type[] f4701a;

    /* renamed from: com.google.gson.internal.$Gson.Types.a */
    private static final class Types implements Serializable, GenericArrayType {
        private final Type f4695a;

        public Types(Type type) {
            this.f4695a = C$Gson$Types.canonicalize(type);
        }

        public Type getGenericComponentType() {
            return this.f4695a;
        }

        public boolean equals(Object obj) {
            return (obj instanceof GenericArrayType) && C$Gson$Types.equals(this, (GenericArrayType) obj);
        }

        public int hashCode() {
            return this.f4695a.hashCode();
        }

        public String toString() {
            return C$Gson$Types.typeToString(this.f4695a) + "[]";
        }
    }

    /* renamed from: com.google.gson.internal.$Gson.Types.b */
    private static final class Types implements Serializable, ParameterizedType {
        private final Type f4696a;
        private final Type f4697b;
        private final Type[] f4698c;

        public Types(Type type, Type type2, Type... typeArr) {
            int i = 0;
            if (type2 instanceof Class) {
                boolean z;
                Class cls = (Class) type2;
                int i2 = (Modifier.isStatic(cls.getModifiers()) || cls.getEnclosingClass() == null) ? 1 : 0;
                if (type == null && i2 == 0) {
                    z = false;
                } else {
                    z = true;
                }
                C$Gson$Preconditions.checkArgument(z);
            }
            this.f4696a = type == null ? null : C$Gson$Types.canonicalize(type);
            this.f4697b = C$Gson$Types.canonicalize(type2);
            this.f4698c = (Type[]) typeArr.clone();
            while (i < this.f4698c.length) {
                C$Gson$Preconditions.checkNotNull(this.f4698c[i]);
                C$Gson$Types.m5337a(this.f4698c[i]);
                this.f4698c[i] = C$Gson$Types.canonicalize(this.f4698c[i]);
                i++;
            }
        }

        public Type[] getActualTypeArguments() {
            return (Type[]) this.f4698c.clone();
        }

        public Type getRawType() {
            return this.f4697b;
        }

        public Type getOwnerType() {
            return this.f4696a;
        }

        public boolean equals(Object obj) {
            return (obj instanceof ParameterizedType) && C$Gson$Types.equals(this, (ParameterizedType) obj);
        }

        public int hashCode() {
            return (Arrays.hashCode(this.f4698c) ^ this.f4697b.hashCode()) ^ C$Gson$Types.m5332a(this.f4696a);
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder((this.f4698c.length + 1) * 30);
            stringBuilder.append(C$Gson$Types.typeToString(this.f4697b));
            if (this.f4698c.length == 0) {
                return stringBuilder.toString();
            }
            stringBuilder.append("<").append(C$Gson$Types.typeToString(this.f4698c[0]));
            for (int i = 1; i < this.f4698c.length; i++) {
                stringBuilder.append(", ").append(C$Gson$Types.typeToString(this.f4698c[i]));
            }
            return stringBuilder.append(">").toString();
        }
    }

    /* renamed from: com.google.gson.internal.$Gson.Types.c */
    private static final class Types implements Serializable, WildcardType {
        private final Type f4699a;
        private final Type f4700b;

        public Types(Type[] typeArr, Type[] typeArr2) {
            boolean z;
            boolean z2 = true;
            C$Gson$Preconditions.checkArgument(typeArr2.length <= 1);
            if (typeArr.length == 1) {
                z = true;
            } else {
                z = false;
            }
            C$Gson$Preconditions.checkArgument(z);
            if (typeArr2.length == 1) {
                C$Gson$Preconditions.checkNotNull(typeArr2[0]);
                C$Gson$Types.m5337a(typeArr2[0]);
                if (typeArr[0] != Object.class) {
                    z2 = false;
                }
                C$Gson$Preconditions.checkArgument(z2);
                this.f4700b = C$Gson$Types.canonicalize(typeArr2[0]);
                this.f4699a = Object.class;
                return;
            }
            C$Gson$Preconditions.checkNotNull(typeArr[0]);
            C$Gson$Types.m5337a(typeArr[0]);
            this.f4700b = null;
            this.f4699a = C$Gson$Types.canonicalize(typeArr[0]);
        }

        public Type[] getUpperBounds() {
            return new Type[]{this.f4699a};
        }

        public Type[] getLowerBounds() {
            if (this.f4700b == null) {
                return C$Gson$Types.a;
            }
            return new Type[]{this.f4700b};
        }

        public boolean equals(Object obj) {
            return (obj instanceof WildcardType) && C$Gson$Types.equals(this, (WildcardType) obj);
        }

        public int hashCode() {
            return (this.f4700b != null ? this.f4700b.hashCode() + 31 : 1) ^ (this.f4699a.hashCode() + 31);
        }

        public String toString() {
            if (this.f4700b != null) {
                return "? super " + C$Gson$Types.typeToString(this.f4700b);
            }
            if (this.f4699a == Object.class) {
                return "?";
            }
            return "? extends " + C$Gson$Types.typeToString(this.f4699a);
        }
    }

    static {
        a = new Type[0];
    }

    private C$Gson$Types() {
        throw new UnsupportedOperationException();
    }

    public static ParameterizedType newParameterizedTypeWithOwner(Type type, Type type2, Type... typeArr) {
        return new Types(type, type2, typeArr);
    }

    public static GenericArrayType arrayOf(Type type) {
        return new Types(type);
    }

    public static WildcardType subtypeOf(Type type) {
        return new Types(new Type[]{type}, a);
    }

    public static WildcardType supertypeOf(Type type) {
        return new Types(new Type[]{Object.class}, new Type[]{type});
    }

    public static Type canonicalize(Type type) {
        if (type instanceof Class) {
            Types types;
            Class cls = (Class) type;
            if (cls.isArray()) {
                types = new Types(C$Gson$Types.canonicalize(cls.getComponentType()));
            } else {
                Object obj = cls;
            }
            return types;
        } else if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            return new Types(parameterizedType.getOwnerType(), parameterizedType.getRawType(), parameterizedType.getActualTypeArguments());
        } else if (type instanceof GenericArrayType) {
            return new Types(((GenericArrayType) type).getGenericComponentType());
        } else {
            if (!(type instanceof WildcardType)) {
                return type;
            }
            WildcardType wildcardType = (WildcardType) type;
            return new Types(wildcardType.getUpperBounds(), wildcardType.getLowerBounds());
        }
    }

    public static Class<?> getRawType(Type type) {
        if (type instanceof Class) {
            return (Class) type;
        }
        if (type instanceof ParameterizedType) {
            Type rawType = ((ParameterizedType) type).getRawType();
            C$Gson$Preconditions.checkArgument(rawType instanceof Class);
            return (Class) rawType;
        } else if (type instanceof GenericArrayType) {
            return Array.newInstance(C$Gson$Types.getRawType(((GenericArrayType) type).getGenericComponentType()), 0).getClass();
        } else {
            if (type instanceof TypeVariable) {
                return Object.class;
            }
            if (type instanceof WildcardType) {
                return C$Gson$Types.getRawType(((WildcardType) type).getUpperBounds()[0]);
            }
            throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + type + "> is of type " + (type == null ? "null" : type.getClass().getName()));
        }
    }

    static boolean m5338a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static boolean equals(Type type, Type type2) {
        boolean z = true;
        if (type == type2) {
            return true;
        }
        if (type instanceof Class) {
            return type.equals(type2);
        }
        if (type instanceof ParameterizedType) {
            if (!(type2 instanceof ParameterizedType)) {
                return false;
            }
            ParameterizedType parameterizedType = (ParameterizedType) type;
            ParameterizedType parameterizedType2 = (ParameterizedType) type2;
            if (!(C$Gson$Types.m5338a(parameterizedType.getOwnerType(), parameterizedType2.getOwnerType()) && parameterizedType.getRawType().equals(parameterizedType2.getRawType()) && Arrays.equals(parameterizedType.getActualTypeArguments(), parameterizedType2.getActualTypeArguments()))) {
                z = false;
            }
            return z;
        } else if (type instanceof GenericArrayType) {
            if (!(type2 instanceof GenericArrayType)) {
                return false;
            }
            return C$Gson$Types.equals(((GenericArrayType) type).getGenericComponentType(), ((GenericArrayType) type2).getGenericComponentType());
        } else if (type instanceof WildcardType) {
            if (!(type2 instanceof WildcardType)) {
                return false;
            }
            WildcardType wildcardType = (WildcardType) type;
            WildcardType wildcardType2 = (WildcardType) type2;
            if (!(Arrays.equals(wildcardType.getUpperBounds(), wildcardType2.getUpperBounds()) && Arrays.equals(wildcardType.getLowerBounds(), wildcardType2.getLowerBounds()))) {
                z = false;
            }
            return z;
        } else if (!(type instanceof TypeVariable) || !(type2 instanceof TypeVariable)) {
            return false;
        } else {
            TypeVariable typeVariable = (TypeVariable) type;
            TypeVariable typeVariable2 = (TypeVariable) type2;
            if (!(typeVariable.getGenericDeclaration() == typeVariable2.getGenericDeclaration() && typeVariable.getName().equals(typeVariable2.getName()))) {
                z = false;
            }
            return z;
        }
    }

    static int m5332a(Object obj) {
        return obj != null ? obj.hashCode() : 0;
    }

    public static String typeToString(Type type) {
        return type instanceof Class ? ((Class) type).getName() : type.toString();
    }

    static Type m5335a(Type type, Class<?> cls, Class<?> cls2) {
        if (cls2 == cls) {
            return type;
        }
        if (cls2.isInterface()) {
            Class[] interfaces = cls.getInterfaces();
            int length = interfaces.length;
            for (int i = 0; i < length; i++) {
                if (interfaces[i] == cls2) {
                    return cls.getGenericInterfaces()[i];
                }
                if (cls2.isAssignableFrom(interfaces[i])) {
                    return C$Gson$Types.m5335a(cls.getGenericInterfaces()[i], interfaces[i], (Class) cls2);
                }
            }
        }
        if (!cls.isInterface()) {
            while (cls != Object.class) {
                Class<?> superclass = cls.getSuperclass();
                if (superclass == cls2) {
                    return cls.getGenericSuperclass();
                }
                if (cls2.isAssignableFrom(superclass)) {
                    return C$Gson$Types.m5335a(cls.getGenericSuperclass(), (Class) superclass, (Class) cls2);
                }
                cls = superclass;
            }
        }
        return cls2;
    }

    static Type m5339b(Type type, Class<?> cls, Class<?> cls2) {
        C$Gson$Preconditions.checkArgument(cls2.isAssignableFrom(cls));
        return C$Gson$Types.resolve(type, cls, C$Gson$Types.m5335a(type, (Class) cls, (Class) cls2));
    }

    public static Type getArrayComponentType(Type type) {
        if (type instanceof GenericArrayType) {
            return ((GenericArrayType) type).getGenericComponentType();
        }
        return ((Class) type).getComponentType();
    }

    public static Type getCollectionElementType(Type type, Class<?> cls) {
        Type b = C$Gson$Types.m5339b(type, cls, Collection.class);
        if (b instanceof WildcardType) {
            b = ((WildcardType) b).getUpperBounds()[0];
        }
        if (b instanceof ParameterizedType) {
            return ((ParameterizedType) b).getActualTypeArguments()[0];
        }
        return Object.class;
    }

    public static Type[] getMapKeyAndValueTypes(Type type, Class<?> cls) {
        if (type == Properties.class) {
            return new Type[]{String.class, String.class};
        }
        Type b = C$Gson$Types.m5339b(type, cls, Map.class);
        if (b instanceof ParameterizedType) {
            return ((ParameterizedType) b).getActualTypeArguments();
        }
        return new Type[]{Object.class, Object.class};
    }

    public static Type resolve(Type type, Class<?> cls, Type type2) {
        Type type3 = type2;
        while (type3 instanceof TypeVariable) {
            type3 = (TypeVariable) type3;
            type2 = C$Gson$Types.m5336a(type, (Class) cls, (TypeVariable) type3);
            if (type2 == type3) {
                return type2;
            }
            type3 = type2;
        }
        Type componentType;
        Type resolve;
        if ((type3 instanceof Class) && ((Class) type3).isArray()) {
            Class cls2 = (Class) type3;
            componentType = cls2.getComponentType();
            resolve = C$Gson$Types.resolve(type, cls, componentType);
            if (componentType != resolve) {
                return C$Gson$Types.arrayOf(resolve);
            }
            return cls2;
        } else if (type3 instanceof GenericArrayType) {
            GenericArrayType genericArrayType = (GenericArrayType) type3;
            componentType = genericArrayType.getGenericComponentType();
            resolve = C$Gson$Types.resolve(type, cls, componentType);
            if (componentType != resolve) {
                return C$Gson$Types.arrayOf(resolve);
            }
            return genericArrayType;
        } else if (type3 instanceof ParameterizedType) {
            int i;
            ParameterizedType parameterizedType = (ParameterizedType) type3;
            componentType = parameterizedType.getOwnerType();
            Type resolve2 = C$Gson$Types.resolve(type, cls, componentType);
            if (resolve2 != componentType) {
                i = 1;
            } else {
                i = 0;
            }
            r4 = parameterizedType.getActualTypeArguments();
            int length = r4.length;
            int i2 = i;
            r1 = r4;
            for (int i3 = 0; i3 < length; i3++) {
                Type resolve3 = C$Gson$Types.resolve(type, cls, r1[i3]);
                if (resolve3 != r1[i3]) {
                    if (i2 == 0) {
                        r1 = (Type[]) r1.clone();
                        i2 = 1;
                    }
                    r1[i3] = resolve3;
                }
            }
            if (i2 != 0) {
                return C$Gson$Types.newParameterizedTypeWithOwner(resolve2, parameterizedType.getRawType(), r1);
            }
            return parameterizedType;
        } else if (!(type3 instanceof WildcardType)) {
            return type3;
        } else {
            WildcardType wildcardType = (WildcardType) type3;
            r1 = wildcardType.getLowerBounds();
            r4 = wildcardType.getUpperBounds();
            if (r1.length == 1) {
                resolve = C$Gson$Types.resolve(type, cls, r1[0]);
                if (resolve != r1[0]) {
                    return C$Gson$Types.supertypeOf(resolve);
                }
                return wildcardType;
            } else if (r4.length != 1) {
                return wildcardType;
            } else {
                componentType = C$Gson$Types.resolve(type, cls, r4[0]);
                if (componentType != r4[0]) {
                    return C$Gson$Types.subtypeOf(componentType);
                }
                return wildcardType;
            }
        }
    }

    static Type m5336a(Type type, Class<?> cls, TypeVariable<?> typeVariable) {
        Class a = C$Gson$Types.m5334a((TypeVariable) typeVariable);
        if (a == null) {
            return typeVariable;
        }
        Type a2 = C$Gson$Types.m5335a(type, (Class) cls, a);
        if (!(a2 instanceof ParameterizedType)) {
            return typeVariable;
        }
        return ((ParameterizedType) a2).getActualTypeArguments()[C$Gson$Types.m5333a(a.getTypeParameters(), (Object) typeVariable)];
    }

    private static int m5333a(Object[] objArr, Object obj) {
        for (int i = 0; i < objArr.length; i++) {
            if (obj.equals(objArr[i])) {
                return i;
            }
        }
        throw new NoSuchElementException();
    }

    private static Class<?> m5334a(TypeVariable<?> typeVariable) {
        GenericDeclaration genericDeclaration = typeVariable.getGenericDeclaration();
        return genericDeclaration instanceof Class ? (Class) genericDeclaration : null;
    }

    static void m5337a(Type type) {
        boolean z = ((type instanceof Class) && ((Class) type).isPrimitive()) ? false : true;
        C$Gson$Preconditions.checkArgument(z);
    }
}
