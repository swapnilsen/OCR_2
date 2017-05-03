package com.google.gson.internal;

import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public abstract class UnsafeAllocator {

    /* renamed from: com.google.gson.internal.UnsafeAllocator.1 */
    static class C15581 extends UnsafeAllocator {
        final /* synthetic */ Method f4801a;
        final /* synthetic */ Object f4802b;

        C15581(Method method, Object obj) {
            this.f4801a = method;
            this.f4802b = obj;
        }

        public <T> T newInstance(Class<T> cls) {
            UnsafeAllocator.m5391b(cls);
            return this.f4801a.invoke(this.f4802b, new Object[]{cls});
        }
    }

    /* renamed from: com.google.gson.internal.UnsafeAllocator.2 */
    static class C15592 extends UnsafeAllocator {
        final /* synthetic */ Method f4803a;
        final /* synthetic */ int f4804b;

        C15592(Method method, int i) {
            this.f4803a = method;
            this.f4804b = i;
        }

        public <T> T newInstance(Class<T> cls) {
            UnsafeAllocator.m5391b(cls);
            return this.f4803a.invoke(null, new Object[]{cls, Integer.valueOf(this.f4804b)});
        }
    }

    /* renamed from: com.google.gson.internal.UnsafeAllocator.3 */
    static class C15603 extends UnsafeAllocator {
        final /* synthetic */ Method f4805a;

        C15603(Method method) {
            this.f4805a = method;
        }

        public <T> T newInstance(Class<T> cls) {
            UnsafeAllocator.m5391b(cls);
            return this.f4805a.invoke(null, new Object[]{cls, Object.class});
        }
    }

    /* renamed from: com.google.gson.internal.UnsafeAllocator.4 */
    static class C15614 extends UnsafeAllocator {
        C15614() {
        }

        public <T> T newInstance(Class<T> cls) {
            throw new UnsupportedOperationException("Cannot allocate " + cls);
        }
    }

    public abstract <T> T newInstance(Class<T> cls);

    public static UnsafeAllocator create() {
        try {
            Class cls = Class.forName("sun.misc.Unsafe");
            Field declaredField = cls.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            return new C15581(cls.getMethod("allocateInstance", new Class[]{Class.class}), declaredField.get(null));
        } catch (Exception e) {
            try {
                Method declaredMethod = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", new Class[]{Class.class});
                declaredMethod.setAccessible(true);
                int intValue = ((Integer) declaredMethod.invoke(null, new Object[]{Object.class})).intValue();
                Method declaredMethod2 = ObjectStreamClass.class.getDeclaredMethod("newInstance", new Class[]{Class.class, Integer.TYPE});
                declaredMethod2.setAccessible(true);
                return new C15592(declaredMethod2, intValue);
            } catch (Exception e2) {
                try {
                    Method declaredMethod3 = ObjectInputStream.class.getDeclaredMethod("newInstance", new Class[]{Class.class, Class.class});
                    declaredMethod3.setAccessible(true);
                    return new C15603(declaredMethod3);
                } catch (Exception e3) {
                    return new C15614();
                }
            }
        }
    }

    private static void m5391b(Class<?> cls) {
        int modifiers = cls.getModifiers();
        if (Modifier.isInterface(modifiers)) {
            throw new UnsupportedOperationException("Interface can't be instantiated! Interface name: " + cls.getName());
        } else if (Modifier.isAbstract(modifiers)) {
            throw new UnsupportedOperationException("Abstract class can't be instantiated! Class name: " + cls.getName());
        }
    }
}
