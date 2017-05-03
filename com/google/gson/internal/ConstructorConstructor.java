package com.google.gson.internal;

import com.google.gson.InstanceCreator;
import com.google.gson.JsonIOException;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

public final class ConstructorConstructor {
    private final Map<Type, InstanceCreator<?>> f4725a;

    /* renamed from: com.google.gson.internal.ConstructorConstructor.10 */
    class AnonymousClass10 implements ObjectConstructor<T> {
        final /* synthetic */ Type f4702a;
        final /* synthetic */ ConstructorConstructor f4703b;

        AnonymousClass10(ConstructorConstructor constructorConstructor, Type type) {
            this.f4703b = constructorConstructor;
            this.f4702a = type;
        }

        public T construct() {
            if (this.f4702a instanceof ParameterizedType) {
                Type type = ((ParameterizedType) this.f4702a).getActualTypeArguments()[0];
                if (type instanceof Class) {
                    return EnumSet.noneOf((Class) type);
                }
                throw new JsonIOException("Invalid EnumSet type: " + this.f4702a.toString());
            }
            throw new JsonIOException("Invalid EnumSet type: " + this.f4702a.toString());
        }
    }

    /* renamed from: com.google.gson.internal.ConstructorConstructor.1 */
    class C15301 implements ObjectConstructor<T> {
        final /* synthetic */ InstanceCreator f4708a;
        final /* synthetic */ Type f4709b;
        final /* synthetic */ ConstructorConstructor f4710c;

        C15301(ConstructorConstructor constructorConstructor, InstanceCreator instanceCreator, Type type) {
            this.f4710c = constructorConstructor;
            this.f4708a = instanceCreator;
            this.f4709b = type;
        }

        public T construct() {
            return this.f4708a.createInstance(this.f4709b);
        }
    }

    /* renamed from: com.google.gson.internal.ConstructorConstructor.2 */
    class C15312 implements ObjectConstructor<T> {
        final /* synthetic */ ConstructorConstructor f4711a;

        C15312(ConstructorConstructor constructorConstructor) {
            this.f4711a = constructorConstructor;
        }

        public T construct() {
            return new ConcurrentHashMap();
        }
    }

    /* renamed from: com.google.gson.internal.ConstructorConstructor.3 */
    class C15323 implements ObjectConstructor<T> {
        final /* synthetic */ ConstructorConstructor f4712a;

        C15323(ConstructorConstructor constructorConstructor) {
            this.f4712a = constructorConstructor;
        }

        public T construct() {
            return new TreeMap();
        }
    }

    /* renamed from: com.google.gson.internal.ConstructorConstructor.4 */
    class C15334 implements ObjectConstructor<T> {
        final /* synthetic */ ConstructorConstructor f4713a;

        C15334(ConstructorConstructor constructorConstructor) {
            this.f4713a = constructorConstructor;
        }

        public T construct() {
            return new LinkedHashMap();
        }
    }

    /* renamed from: com.google.gson.internal.ConstructorConstructor.5 */
    class C15345 implements ObjectConstructor<T> {
        final /* synthetic */ ConstructorConstructor f4714a;

        C15345(ConstructorConstructor constructorConstructor) {
            this.f4714a = constructorConstructor;
        }

        public T construct() {
            return new LinkedTreeMap();
        }
    }

    /* renamed from: com.google.gson.internal.ConstructorConstructor.6 */
    class C15356 implements ObjectConstructor<T> {
        final /* synthetic */ Class f4715a;
        final /* synthetic */ Type f4716b;
        final /* synthetic */ ConstructorConstructor f4717c;
        private final UnsafeAllocator f4718d;

        C15356(ConstructorConstructor constructorConstructor, Class cls, Type type) {
            this.f4717c = constructorConstructor;
            this.f4715a = cls;
            this.f4716b = type;
            this.f4718d = UnsafeAllocator.create();
        }

        public T construct() {
            try {
                return this.f4718d.newInstance(this.f4715a);
            } catch (Throwable e) {
                throw new RuntimeException("Unable to invoke no-args constructor for " + this.f4716b + ". " + "Register an InstanceCreator with Gson for this type may fix this problem.", e);
            }
        }
    }

    /* renamed from: com.google.gson.internal.ConstructorConstructor.7 */
    class C15367 implements ObjectConstructor<T> {
        final /* synthetic */ InstanceCreator f4719a;
        final /* synthetic */ Type f4720b;
        final /* synthetic */ ConstructorConstructor f4721c;

        C15367(ConstructorConstructor constructorConstructor, InstanceCreator instanceCreator, Type type) {
            this.f4721c = constructorConstructor;
            this.f4719a = instanceCreator;
            this.f4720b = type;
        }

        public T construct() {
            return this.f4719a.createInstance(this.f4720b);
        }
    }

    /* renamed from: com.google.gson.internal.ConstructorConstructor.8 */
    class C15378 implements ObjectConstructor<T> {
        final /* synthetic */ Constructor f4722a;
        final /* synthetic */ ConstructorConstructor f4723b;

        C15378(ConstructorConstructor constructorConstructor, Constructor constructor) {
            this.f4723b = constructorConstructor;
            this.f4722a = constructor;
        }

        public T construct() {
            try {
                return this.f4722a.newInstance(null);
            } catch (Throwable e) {
                throw new RuntimeException("Failed to invoke " + this.f4722a + " with no args", e);
            } catch (InvocationTargetException e2) {
                throw new RuntimeException("Failed to invoke " + this.f4722a + " with no args", e2.getTargetException());
            } catch (IllegalAccessException e3) {
                throw new AssertionError(e3);
            }
        }
    }

    /* renamed from: com.google.gson.internal.ConstructorConstructor.9 */
    class C15389 implements ObjectConstructor<T> {
        final /* synthetic */ ConstructorConstructor f4724a;

        C15389(ConstructorConstructor constructorConstructor) {
            this.f4724a = constructorConstructor;
        }

        public T construct() {
            return new TreeSet();
        }
    }

    public ConstructorConstructor(Map<Type, InstanceCreator<?>> map) {
        this.f4725a = map;
    }

    public <T> ObjectConstructor<T> get(TypeToken<T> typeToken) {
        Type type = typeToken.getType();
        Class rawType = typeToken.getRawType();
        InstanceCreator instanceCreator = (InstanceCreator) this.f4725a.get(type);
        if (instanceCreator != null) {
            return new C15301(this, instanceCreator, type);
        }
        instanceCreator = (InstanceCreator) this.f4725a.get(rawType);
        if (instanceCreator != null) {
            return new C15367(this, instanceCreator, type);
        }
        ObjectConstructor<T> a = m5340a(rawType);
        if (a != null) {
            return a;
        }
        a = m5341a(type, rawType);
        return a == null ? m5342b(type, rawType) : a;
    }

    private <T> ObjectConstructor<T> m5340a(Class<? super T> cls) {
        try {
            Constructor declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
            if (!declaredConstructor.isAccessible()) {
                declaredConstructor.setAccessible(true);
            }
            return new C15378(this, declaredConstructor);
        } catch (NoSuchMethodException e) {
            return null;
        }
    }

    private <T> ObjectConstructor<T> m5341a(Type type, Class<? super T> cls) {
        if (Collection.class.isAssignableFrom(cls)) {
            if (SortedSet.class.isAssignableFrom(cls)) {
                return new C15389(this);
            }
            if (EnumSet.class.isAssignableFrom(cls)) {
                return new AnonymousClass10(this, type);
            }
            if (Set.class.isAssignableFrom(cls)) {
                return new ObjectConstructor<T>() {
                    final /* synthetic */ ConstructorConstructor f4704a;

                    {
                        this.f4704a = r1;
                    }

                    public T construct() {
                        return new LinkedHashSet();
                    }
                };
            }
            if (Queue.class.isAssignableFrom(cls)) {
                return new ObjectConstructor<T>() {
                    final /* synthetic */ ConstructorConstructor f4705a;

                    {
                        this.f4705a = r1;
                    }

                    public T construct() {
                        return new ArrayDeque();
                    }
                };
            }
            return new ObjectConstructor<T>() {
                final /* synthetic */ ConstructorConstructor f4706a;

                {
                    this.f4706a = r1;
                }

                public T construct() {
                    return new ArrayList();
                }
            };
        } else if (!Map.class.isAssignableFrom(cls)) {
            return null;
        } else {
            if (ConcurrentNavigableMap.class.isAssignableFrom(cls)) {
                return new ObjectConstructor<T>() {
                    final /* synthetic */ ConstructorConstructor f4707a;

                    {
                        this.f4707a = r1;
                    }

                    public T construct() {
                        return new ConcurrentSkipListMap();
                    }
                };
            }
            if (ConcurrentMap.class.isAssignableFrom(cls)) {
                return new C15312(this);
            }
            if (SortedMap.class.isAssignableFrom(cls)) {
                return new C15323(this);
            }
            if (!(type instanceof ParameterizedType) || String.class.isAssignableFrom(TypeToken.get(((ParameterizedType) type).getActualTypeArguments()[0]).getRawType())) {
                return new C15345(this);
            }
            return new C15334(this);
        }
    }

    private <T> ObjectConstructor<T> m5342b(Type type, Class<? super T> cls) {
        return new C15356(this, cls, type);
    }

    public String toString() {
        return this.f4725a.toString();
    }
}
