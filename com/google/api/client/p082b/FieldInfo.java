package com.google.api.client.p082b;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.WeakHashMap;

/* renamed from: com.google.api.client.b.n */
public class FieldInfo {
    private static final Map<Field, FieldInfo> f4193a;
    private final boolean f4194b;
    private final Field f4195c;
    private final String f4196d;

    static {
        f4193a = new WeakHashMap();
    }

    public static FieldInfo m4941a(Enum<?> enumR) {
        boolean z = true;
        try {
            FieldInfo a = FieldInfo.m4942a(enumR.getClass().getField(enumR.name()));
            if (a == null) {
                z = false;
            }
            Preconditions.m4973a(z, "enum constant missing @Value or @NullValue annotation: %s", enumR);
            return a;
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public static FieldInfo m4942a(Field field) {
        FieldInfo fieldInfo = null;
        if (field != null) {
            synchronized (f4193a) {
                FieldInfo fieldInfo2 = (FieldInfo) f4193a.get(field);
                boolean isEnumConstant = field.isEnumConstant();
                if (fieldInfo2 != null || (!isEnumConstant && Modifier.isStatic(field.getModifiers()))) {
                    fieldInfo = fieldInfo2;
                } else {
                    String a;
                    String name;
                    if (isEnumConstant) {
                        aj ajVar = (aj) field.getAnnotation(aj.class);
                        if (ajVar != null) {
                            a = ajVar.m4875a();
                        } else if (((NullValue) field.getAnnotation(NullValue.class)) != null) {
                            a = null;
                        }
                    } else {
                        Key key = (Key) field.getAnnotation(Key.class);
                        if (key == null) {
                        } else {
                            a = key.m4958a();
                            field.setAccessible(true);
                        }
                    }
                    if ("##default".equals(a)) {
                        name = field.getName();
                    } else {
                        name = a;
                    }
                    fieldInfo2 = new FieldInfo(field, name);
                    f4193a.put(field, fieldInfo2);
                    fieldInfo = fieldInfo2;
                }
            }
        }
        return fieldInfo;
    }

    FieldInfo(Field field, String str) {
        this.f4195c = field;
        this.f4196d = str == null ? null : str.intern();
        this.f4194b = Data.m4903a(m4949c());
    }

    public Field m4946a() {
        return this.f4195c;
    }

    public String m4948b() {
        return this.f4196d;
    }

    public Class<?> m4949c() {
        return this.f4195c.getType();
    }

    public Type m4950d() {
        return this.f4195c.getGenericType();
    }

    public boolean m4951e() {
        return Modifier.isFinal(this.f4195c.getModifiers());
    }

    public boolean m4952f() {
        return this.f4194b;
    }

    public Object m4945a(Object obj) {
        return FieldInfo.m4943a(this.f4195c, obj);
    }

    public void m4947a(Object obj, Object obj2) {
        FieldInfo.m4944a(this.f4195c, obj, obj2);
    }

    public <T extends Enum<T>> T m4953g() {
        return Enum.valueOf(this.f4195c.getDeclaringClass(), this.f4195c.getName());
    }

    public static Object m4943a(Field field, Object obj) {
        try {
            return field.get(obj);
        } catch (Throwable e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static void m4944a(Field field, Object obj, Object obj2) {
        if (Modifier.isFinal(field.getModifiers())) {
            Object a = FieldInfo.m4943a(field, obj);
            if (obj2 == null) {
                if (a == null) {
                    return;
                }
            } else if (obj2.equals(a)) {
                return;
            }
            throw new IllegalArgumentException("expected final value <" + a + "> but was <" + obj2 + "> on " + field.getName() + " field in " + obj.getClass().getName());
        }
        try {
            field.set(obj, obj2);
        } catch (Throwable e) {
            throw new IllegalArgumentException(e);
        } catch (Throwable e2) {
            throw new IllegalArgumentException(e2);
        }
    }
}
