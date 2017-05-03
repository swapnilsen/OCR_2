package com.google.api.client.p082b;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeSet;
import java.util.WeakHashMap;

/* renamed from: com.google.api.client.b.i */
public final class ClassInfo {
    private static final Map<Class<?>, ClassInfo> f4142b;
    private static final Map<Class<?>, ClassInfo> f4143c;
    final List<String> f4144a;
    private final Class<?> f4145d;
    private final boolean f4146e;
    private final IdentityHashMap<String, FieldInfo> f4147f;

    /* renamed from: com.google.api.client.b.i.1 */
    class ClassInfo implements Comparator<String> {
        final /* synthetic */ ClassInfo f4141a;

        ClassInfo(ClassInfo classInfo) {
            this.f4141a = classInfo;
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m4890a((String) obj, (String) obj2);
        }

        public int m4890a(String str, String str2) {
            if (str == str2) {
                return 0;
            }
            if (str == null) {
                return -1;
            }
            return str2 == null ? 1 : str.compareTo(str2);
        }
    }

    static {
        f4142b = new WeakHashMap();
        f4143c = new WeakHashMap();
    }

    public static ClassInfo m4891a(Class<?> cls) {
        return ClassInfo.m4892a(cls, false);
    }

    public static ClassInfo m4892a(Class<?> cls, boolean z) {
        if (cls == null) {
            return null;
        }
        ClassInfo classInfo;
        Map map = z ? f4143c : f4142b;
        synchronized (map) {
            classInfo = (ClassInfo) map.get(cls);
            if (classInfo == null) {
                classInfo = new ClassInfo(cls, z);
                map.put(cls, classInfo);
            }
        }
        return classInfo;
    }

    public final boolean m4894a() {
        return this.f4146e;
    }

    public FieldInfo m4893a(String str) {
        if (str != null) {
            if (this.f4146e) {
                str = str.toLowerCase();
            }
            str = str.intern();
        }
        return (FieldInfo) this.f4147f.get(str);
    }

    public Field m4895b(String str) {
        FieldInfo a = m4893a(str);
        return a == null ? null : a.m4946a();
    }

    public boolean m4896b() {
        return this.f4145d.isEnum();
    }

    private ClassInfo(Class<?> cls, boolean z) {
        this.f4147f = new IdentityHashMap();
        this.f4145d = cls;
        this.f4146e = z;
        boolean z2 = (z && cls.isEnum()) ? false : true;
        Preconditions.m4972a(z2, "cannot ignore case on an enum: " + cls);
        Collection treeSet = new TreeSet(new ClassInfo(this));
        for (Field field : cls.getDeclaredFields()) {
            FieldInfo a = FieldInfo.m4942a(field);
            if (a != null) {
                Object intern;
                String b = a.m4948b();
                if (z) {
                    intern = b.toLowerCase().intern();
                } else {
                    String str = b;
                }
                FieldInfo fieldInfo = (FieldInfo) this.f4147f.get(intern);
                boolean z3 = fieldInfo == null;
                String str2 = "two fields have the same %sname <%s>: %s and %s";
                Object[] objArr = new Object[4];
                objArr[0] = z ? "case-insensitive " : FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING;
                objArr[1] = intern;
                objArr[2] = field;
                objArr[3] = fieldInfo == null ? null : fieldInfo.m4946a();
                Preconditions.m4973a(z3, str2, objArr);
                this.f4147f.put(intern, a);
                treeSet.add(intern);
            }
        }
        Class superclass = cls.getSuperclass();
        if (superclass != null) {
            ClassInfo a2 = ClassInfo.m4892a(superclass, z);
            treeSet.addAll(a2.f4144a);
            for (Entry entry : a2.f4147f.entrySet()) {
                str = (String) entry.getKey();
                if (!this.f4147f.containsKey(str)) {
                    this.f4147f.put(str, entry.getValue());
                }
            }
        }
        this.f4144a = treeSet.isEmpty() ? Collections.emptyList() : Collections.unmodifiableList(new ArrayList(treeSet));
    }

    public Collection<FieldInfo> m4897c() {
        return Collections.unmodifiableCollection(this.f4147f.values());
    }
}
