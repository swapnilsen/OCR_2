package com.google.gson.internal;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.Since;
import com.google.gson.annotations.Until;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Excluder implements TypeAdapterFactory, Cloneable {
    public static final Excluder DEFAULT;
    private double f4732a;
    private int f4733b;
    private boolean f4734c;
    private boolean f4735d;
    private List<ExclusionStrategy> f4736e;
    private List<ExclusionStrategy> f4737f;

    /* renamed from: com.google.gson.internal.Excluder.1 */
    class C15391 extends TypeAdapter<T> {
        final /* synthetic */ boolean f4726a;
        final /* synthetic */ boolean f4727b;
        final /* synthetic */ Gson f4728c;
        final /* synthetic */ TypeToken f4729d;
        final /* synthetic */ Excluder f4730e;
        private TypeAdapter<T> f4731f;

        C15391(Excluder excluder, boolean z, boolean z2, Gson gson, TypeToken typeToken) {
            this.f4730e = excluder;
            this.f4726a = z;
            this.f4727b = z2;
            this.f4728c = gson;
            this.f4729d = typeToken;
        }

        public T read(JsonReader jsonReader) {
            if (!this.f4726a) {
                return m5343a().read(jsonReader);
            }
            jsonReader.skipValue();
            return null;
        }

        public void write(JsonWriter jsonWriter, T t) {
            if (this.f4727b) {
                jsonWriter.nullValue();
            } else {
                m5343a().write(jsonWriter, t);
            }
        }

        private TypeAdapter<T> m5343a() {
            TypeAdapter<T> typeAdapter = this.f4731f;
            if (typeAdapter != null) {
                return typeAdapter;
            }
            typeAdapter = this.f4728c.getDelegateAdapter(this.f4730e, this.f4729d);
            this.f4731f = typeAdapter;
            return typeAdapter;
        }
    }

    public Excluder() {
        this.f4732a = -1.0d;
        this.f4733b = 136;
        this.f4734c = true;
        this.f4736e = Collections.emptyList();
        this.f4737f = Collections.emptyList();
    }

    protected /* synthetic */ Object clone() {
        return m5350a();
    }

    static {
        DEFAULT = new Excluder();
    }

    protected Excluder m5350a() {
        try {
            return (Excluder) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public Excluder withVersion(double d) {
        Excluder a = m5350a();
        a.f4732a = d;
        return a;
    }

    public Excluder withModifiers(int... iArr) {
        int i = 0;
        Excluder a = m5350a();
        a.f4733b = 0;
        int length = iArr.length;
        while (i < length) {
            a.f4733b = iArr[i] | a.f4733b;
            i++;
        }
        return a;
    }

    public Excluder disableInnerClassSerialization() {
        Excluder a = m5350a();
        a.f4734c = false;
        return a;
    }

    public Excluder excludeFieldsWithoutExposeAnnotation() {
        Excluder a = m5350a();
        a.f4735d = true;
        return a;
    }

    public Excluder withExclusionStrategy(ExclusionStrategy exclusionStrategy, boolean z, boolean z2) {
        Excluder a = m5350a();
        if (z) {
            a.f4736e = new ArrayList(this.f4736e);
            a.f4736e.add(exclusionStrategy);
        }
        if (z2) {
            a.f4737f = new ArrayList(this.f4737f);
            a.f4737f.add(exclusionStrategy);
        }
        return a;
    }

    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
        Class rawType = typeToken.getRawType();
        boolean excludeClass = excludeClass(rawType, true);
        boolean excludeClass2 = excludeClass(rawType, false);
        if (excludeClass || excludeClass2) {
            return new C15391(this, excludeClass2, excludeClass, gson, typeToken);
        }
        return null;
    }

    public boolean excludeField(Field field, boolean z) {
        if ((this.f4733b & field.getModifiers()) != 0) {
            return true;
        }
        if (this.f4732a != -1.0d && !m5345a((Since) field.getAnnotation(Since.class), (Until) field.getAnnotation(Until.class))) {
            return true;
        }
        if (field.isSynthetic()) {
            return true;
        }
        if (this.f4735d) {
            Expose expose = (Expose) field.getAnnotation(Expose.class);
            if (expose == null || (z ? !expose.serialize() : !expose.deserialize())) {
                return true;
            }
        }
        if (!this.f4734c && m5348b(field.getType())) {
            return true;
        }
        if (m5347a(field.getType())) {
            return true;
        }
        List<ExclusionStrategy> list = z ? this.f4736e : this.f4737f;
        if (!list.isEmpty()) {
            FieldAttributes fieldAttributes = new FieldAttributes(field);
            for (ExclusionStrategy shouldSkipField : list) {
                if (shouldSkipField.shouldSkipField(fieldAttributes)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean excludeClass(Class<?> cls, boolean z) {
        if (this.f4732a != -1.0d && !m5345a((Since) cls.getAnnotation(Since.class), (Until) cls.getAnnotation(Until.class))) {
            return true;
        }
        if (!this.f4734c && m5348b(cls)) {
            return true;
        }
        if (m5347a((Class) cls)) {
            return true;
        }
        for (ExclusionStrategy shouldSkipClass : z ? this.f4736e : this.f4737f) {
            if (shouldSkipClass.shouldSkipClass(cls)) {
                return true;
            }
        }
        return false;
    }

    private boolean m5347a(Class<?> cls) {
        return !Enum.class.isAssignableFrom(cls) && (cls.isAnonymousClass() || cls.isLocalClass());
    }

    private boolean m5348b(Class<?> cls) {
        return cls.isMemberClass() && !m5349c(cls);
    }

    private boolean m5349c(Class<?> cls) {
        return (cls.getModifiers() & 8) != 0;
    }

    private boolean m5345a(Since since, Until until) {
        return m5344a(since) && m5346a(until);
    }

    private boolean m5344a(Since since) {
        if (since == null || since.value() <= this.f4732a) {
            return true;
        }
        return false;
    }

    private boolean m5346a(Until until) {
        if (until == null || until.value() > this.f4732a) {
            return true;
        }
        return false;
    }
}
