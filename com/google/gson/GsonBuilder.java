package com.google.gson;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.gson.internal.C$Gson$Preconditions;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.bind.TreeTypeAdapter;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class GsonBuilder {
    private Excluder f4669a;
    private LongSerializationPolicy f4670b;
    private FieldNamingStrategy f4671c;
    private final Map<Type, InstanceCreator<?>> f4672d;
    private final List<TypeAdapterFactory> f4673e;
    private final List<TypeAdapterFactory> f4674f;
    private boolean f4675g;
    private String f4676h;
    private int f4677i;
    private int f4678j;
    private boolean f4679k;
    private boolean f4680l;
    private boolean f4681m;
    private boolean f4682n;
    private boolean f4683o;
    private boolean f4684p;

    public GsonBuilder() {
        this.f4669a = Excluder.DEFAULT;
        this.f4670b = LongSerializationPolicy.DEFAULT;
        this.f4671c = FieldNamingPolicy.IDENTITY;
        this.f4672d = new HashMap();
        this.f4673e = new ArrayList();
        this.f4674f = new ArrayList();
        this.f4675g = false;
        this.f4677i = 2;
        this.f4678j = 2;
        this.f4679k = false;
        this.f4680l = false;
        this.f4681m = true;
        this.f4682n = false;
        this.f4683o = false;
        this.f4684p = false;
    }

    public GsonBuilder setVersion(double d) {
        this.f4669a = this.f4669a.withVersion(d);
        return this;
    }

    public GsonBuilder excludeFieldsWithModifiers(int... iArr) {
        this.f4669a = this.f4669a.withModifiers(iArr);
        return this;
    }

    public GsonBuilder generateNonExecutableJson() {
        this.f4683o = true;
        return this;
    }

    public GsonBuilder excludeFieldsWithoutExposeAnnotation() {
        this.f4669a = this.f4669a.excludeFieldsWithoutExposeAnnotation();
        return this;
    }

    public GsonBuilder serializeNulls() {
        this.f4675g = true;
        return this;
    }

    public GsonBuilder enableComplexMapKeySerialization() {
        this.f4679k = true;
        return this;
    }

    public GsonBuilder disableInnerClassSerialization() {
        this.f4669a = this.f4669a.disableInnerClassSerialization();
        return this;
    }

    public GsonBuilder setLongSerializationPolicy(LongSerializationPolicy longSerializationPolicy) {
        this.f4670b = longSerializationPolicy;
        return this;
    }

    public GsonBuilder setFieldNamingPolicy(FieldNamingPolicy fieldNamingPolicy) {
        this.f4671c = fieldNamingPolicy;
        return this;
    }

    public GsonBuilder setFieldNamingStrategy(FieldNamingStrategy fieldNamingStrategy) {
        this.f4671c = fieldNamingStrategy;
        return this;
    }

    public GsonBuilder setExclusionStrategies(ExclusionStrategy... exclusionStrategyArr) {
        for (ExclusionStrategy withExclusionStrategy : exclusionStrategyArr) {
            this.f4669a = this.f4669a.withExclusionStrategy(withExclusionStrategy, true, true);
        }
        return this;
    }

    public GsonBuilder addSerializationExclusionStrategy(ExclusionStrategy exclusionStrategy) {
        this.f4669a = this.f4669a.withExclusionStrategy(exclusionStrategy, true, false);
        return this;
    }

    public GsonBuilder addDeserializationExclusionStrategy(ExclusionStrategy exclusionStrategy) {
        this.f4669a = this.f4669a.withExclusionStrategy(exclusionStrategy, false, true);
        return this;
    }

    public GsonBuilder setPrettyPrinting() {
        this.f4682n = true;
        return this;
    }

    public GsonBuilder setLenient() {
        this.f4684p = true;
        return this;
    }

    public GsonBuilder disableHtmlEscaping() {
        this.f4681m = false;
        return this;
    }

    public GsonBuilder setDateFormat(String str) {
        this.f4676h = str;
        return this;
    }

    public GsonBuilder setDateFormat(int i) {
        this.f4677i = i;
        this.f4676h = null;
        return this;
    }

    public GsonBuilder setDateFormat(int i, int i2) {
        this.f4677i = i;
        this.f4678j = i2;
        this.f4676h = null;
        return this;
    }

    public GsonBuilder registerTypeAdapter(Type type, Object obj) {
        boolean z = (obj instanceof JsonSerializer) || (obj instanceof JsonDeserializer) || (obj instanceof InstanceCreator) || (obj instanceof TypeAdapter);
        C$Gson$Preconditions.checkArgument(z);
        if (obj instanceof InstanceCreator) {
            this.f4672d.put(type, (InstanceCreator) obj);
        }
        if ((obj instanceof JsonSerializer) || (obj instanceof JsonDeserializer)) {
            this.f4673e.add(TreeTypeAdapter.newFactoryWithMatchRawType(TypeToken.get(type), obj));
        }
        if (obj instanceof TypeAdapter) {
            this.f4673e.add(TypeAdapters.newFactory(TypeToken.get(type), (TypeAdapter) obj));
        }
        return this;
    }

    public GsonBuilder registerTypeAdapterFactory(TypeAdapterFactory typeAdapterFactory) {
        this.f4673e.add(typeAdapterFactory);
        return this;
    }

    public GsonBuilder registerTypeHierarchyAdapter(Class<?> cls, Object obj) {
        boolean z = (obj instanceof JsonSerializer) || (obj instanceof JsonDeserializer) || (obj instanceof TypeAdapter);
        C$Gson$Preconditions.checkArgument(z);
        if ((obj instanceof JsonDeserializer) || (obj instanceof JsonSerializer)) {
            this.f4674f.add(0, TreeTypeAdapter.newTypeHierarchyFactory(cls, obj));
        }
        if (obj instanceof TypeAdapter) {
            this.f4673e.add(TypeAdapters.newTypeHierarchyFactory(cls, (TypeAdapter) obj));
        }
        return this;
    }

    public GsonBuilder serializeSpecialFloatingPointValues() {
        this.f4680l = true;
        return this;
    }

    public Gson create() {
        List arrayList = new ArrayList();
        arrayList.addAll(this.f4673e);
        Collections.reverse(arrayList);
        arrayList.addAll(this.f4674f);
        m5322a(this.f4676h, this.f4677i, this.f4678j, arrayList);
        return new Gson(this.f4669a, this.f4671c, this.f4672d, this.f4675g, this.f4679k, this.f4683o, this.f4681m, this.f4682n, this.f4684p, this.f4680l, this.f4670b, arrayList);
    }

    private void m5322a(String str, int i, int i2, List<TypeAdapterFactory> list) {
        Object defaultDateTypeAdapter;
        if (str != null && !FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING.equals(str.trim())) {
            defaultDateTypeAdapter = new DefaultDateTypeAdapter(str);
        } else if (i != 2 && i2 != 2) {
            defaultDateTypeAdapter = new DefaultDateTypeAdapter(i, i2);
        } else {
            return;
        }
        list.add(TreeTypeAdapter.newFactory(TypeToken.get(Date.class), defaultDateTypeAdapter));
        list.add(TreeTypeAdapter.newFactory(TypeToken.get(Timestamp.class), defaultDateTypeAdapter));
        list.add(TreeTypeAdapter.newFactory(TypeToken.get(java.sql.Date.class), defaultDateTypeAdapter));
    }
}
