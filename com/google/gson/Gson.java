package com.google.gson;

import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.Primitives;
import com.google.gson.internal.Streams;
import com.google.gson.internal.bind.ArrayTypeAdapter;
import com.google.gson.internal.bind.CollectionTypeAdapterFactory;
import com.google.gson.internal.bind.DateTypeAdapter;
import com.google.gson.internal.bind.JsonAdapterAnnotationTypeAdapterFactory;
import com.google.gson.internal.bind.JsonTreeReader;
import com.google.gson.internal.bind.JsonTreeWriter;
import com.google.gson.internal.bind.MapTypeAdapterFactory;
import com.google.gson.internal.bind.ObjectTypeAdapter;
import com.google.gson.internal.bind.ReflectiveTypeAdapterFactory;
import com.google.gson.internal.bind.SqlDateTypeAdapter;
import com.google.gson.internal.bind.TimeTypeAdapter;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;

public final class Gson {
    private static final TypeToken<?> f4656a;
    private final ThreadLocal<Map<TypeToken<?>, C1526a<?>>> f4657b;
    private final Map<TypeToken<?>, TypeAdapter<?>> f4658c;
    private final List<TypeAdapterFactory> f4659d;
    private final ConstructorConstructor f4660e;
    private final Excluder f4661f;
    private final FieldNamingStrategy f4662g;
    private final boolean f4663h;
    private final boolean f4664i;
    private final boolean f4665j;
    private final boolean f4666k;
    private final boolean f4667l;
    private final JsonAdapterAnnotationTypeAdapterFactory f4668m;

    /* renamed from: com.google.gson.Gson.1 */
    static class C15201 extends TypeToken<Object> {
        C15201() {
        }
    }

    /* renamed from: com.google.gson.Gson.2 */
    class C15212 extends TypeAdapter<Number> {
        final /* synthetic */ Gson f4651a;

        C15212(Gson gson) {
            this.f4651a = gson;
        }

        public /* synthetic */ Object read(JsonReader jsonReader) {
            return m5304a(jsonReader);
        }

        public /* synthetic */ void write(JsonWriter jsonWriter, Object obj) {
            m5305a(jsonWriter, (Number) obj);
        }

        public Double m5304a(JsonReader jsonReader) {
            if (jsonReader.peek() != JsonToken.NULL) {
                return Double.valueOf(jsonReader.nextDouble());
            }
            jsonReader.nextNull();
            return null;
        }

        public void m5305a(JsonWriter jsonWriter, Number number) {
            if (number == null) {
                jsonWriter.nullValue();
                return;
            }
            Gson.m5318a(number.doubleValue());
            jsonWriter.value(number);
        }
    }

    /* renamed from: com.google.gson.Gson.3 */
    class C15223 extends TypeAdapter<Number> {
        final /* synthetic */ Gson f4652a;

        C15223(Gson gson) {
            this.f4652a = gson;
        }

        public /* synthetic */ Object read(JsonReader jsonReader) {
            return m5306a(jsonReader);
        }

        public /* synthetic */ void write(JsonWriter jsonWriter, Object obj) {
            m5307a(jsonWriter, (Number) obj);
        }

        public Float m5306a(JsonReader jsonReader) {
            if (jsonReader.peek() != JsonToken.NULL) {
                return Float.valueOf((float) jsonReader.nextDouble());
            }
            jsonReader.nextNull();
            return null;
        }

        public void m5307a(JsonWriter jsonWriter, Number number) {
            if (number == null) {
                jsonWriter.nullValue();
                return;
            }
            Gson.m5318a((double) number.floatValue());
            jsonWriter.value(number);
        }
    }

    /* renamed from: com.google.gson.Gson.4 */
    static class C15234 extends TypeAdapter<Number> {
        C15234() {
        }

        public /* synthetic */ Object read(JsonReader jsonReader) {
            return m5308a(jsonReader);
        }

        public /* synthetic */ void write(JsonWriter jsonWriter, Object obj) {
            m5309a(jsonWriter, (Number) obj);
        }

        public Number m5308a(JsonReader jsonReader) {
            if (jsonReader.peek() != JsonToken.NULL) {
                return Long.valueOf(jsonReader.nextLong());
            }
            jsonReader.nextNull();
            return null;
        }

        public void m5309a(JsonWriter jsonWriter, Number number) {
            if (number == null) {
                jsonWriter.nullValue();
            } else {
                jsonWriter.value(number.toString());
            }
        }
    }

    /* renamed from: com.google.gson.Gson.5 */
    static class C15245 extends TypeAdapter<AtomicLong> {
        final /* synthetic */ TypeAdapter f4653a;

        C15245(TypeAdapter typeAdapter) {
            this.f4653a = typeAdapter;
        }

        public /* synthetic */ Object read(JsonReader jsonReader) {
            return m5310a(jsonReader);
        }

        public /* synthetic */ void write(JsonWriter jsonWriter, Object obj) {
            m5311a(jsonWriter, (AtomicLong) obj);
        }

        public void m5311a(JsonWriter jsonWriter, AtomicLong atomicLong) {
            this.f4653a.write(jsonWriter, Long.valueOf(atomicLong.get()));
        }

        public AtomicLong m5310a(JsonReader jsonReader) {
            return new AtomicLong(((Number) this.f4653a.read(jsonReader)).longValue());
        }
    }

    /* renamed from: com.google.gson.Gson.6 */
    static class C15256 extends TypeAdapter<AtomicLongArray> {
        final /* synthetic */ TypeAdapter f4654a;

        C15256(TypeAdapter typeAdapter) {
            this.f4654a = typeAdapter;
        }

        public /* synthetic */ Object read(JsonReader jsonReader) {
            return m5312a(jsonReader);
        }

        public /* synthetic */ void write(JsonWriter jsonWriter, Object obj) {
            m5313a(jsonWriter, (AtomicLongArray) obj);
        }

        public void m5313a(JsonWriter jsonWriter, AtomicLongArray atomicLongArray) {
            jsonWriter.beginArray();
            int length = atomicLongArray.length();
            for (int i = 0; i < length; i++) {
                this.f4654a.write(jsonWriter, Long.valueOf(atomicLongArray.get(i)));
            }
            jsonWriter.endArray();
        }

        public AtomicLongArray m5312a(JsonReader jsonReader) {
            List arrayList = new ArrayList();
            jsonReader.beginArray();
            while (jsonReader.hasNext()) {
                arrayList.add(Long.valueOf(((Number) this.f4654a.read(jsonReader)).longValue()));
            }
            jsonReader.endArray();
            int size = arrayList.size();
            AtomicLongArray atomicLongArray = new AtomicLongArray(size);
            for (int i = 0; i < size; i++) {
                atomicLongArray.set(i, ((Long) arrayList.get(i)).longValue());
            }
            return atomicLongArray;
        }
    }

    /* renamed from: com.google.gson.Gson.a */
    static class C1526a<T> extends TypeAdapter<T> {
        private TypeAdapter<T> f4655a;

        C1526a() {
        }

        public void m5314a(TypeAdapter<T> typeAdapter) {
            if (this.f4655a != null) {
                throw new AssertionError();
            }
            this.f4655a = typeAdapter;
        }

        public T read(JsonReader jsonReader) {
            if (this.f4655a != null) {
                return this.f4655a.read(jsonReader);
            }
            throw new IllegalStateException();
        }

        public void write(JsonWriter jsonWriter, T t) {
            if (this.f4655a == null) {
                throw new IllegalStateException();
            }
            this.f4655a.write(jsonWriter, t);
        }
    }

    static {
        f4656a = new C15201();
    }

    public Gson() {
        this(Excluder.DEFAULT, FieldNamingPolicy.IDENTITY, Collections.emptyMap(), false, false, false, true, false, false, false, LongSerializationPolicy.DEFAULT, Collections.emptyList());
    }

    Gson(Excluder excluder, FieldNamingStrategy fieldNamingStrategy, Map<Type, InstanceCreator<?>> map, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, LongSerializationPolicy longSerializationPolicy, List<TypeAdapterFactory> list) {
        this.f4657b = new ThreadLocal();
        this.f4658c = new ConcurrentHashMap();
        this.f4660e = new ConstructorConstructor(map);
        this.f4661f = excluder;
        this.f4662g = fieldNamingStrategy;
        this.f4663h = z;
        this.f4665j = z3;
        this.f4664i = z4;
        this.f4666k = z5;
        this.f4667l = z6;
        List arrayList = new ArrayList();
        arrayList.add(TypeAdapters.JSON_ELEMENT_FACTORY);
        arrayList.add(ObjectTypeAdapter.FACTORY);
        arrayList.add(excluder);
        arrayList.addAll(list);
        arrayList.add(TypeAdapters.STRING_FACTORY);
        arrayList.add(TypeAdapters.INTEGER_FACTORY);
        arrayList.add(TypeAdapters.BOOLEAN_FACTORY);
        arrayList.add(TypeAdapters.BYTE_FACTORY);
        arrayList.add(TypeAdapters.SHORT_FACTORY);
        TypeAdapter a = m5315a(longSerializationPolicy);
        arrayList.add(TypeAdapters.newFactory(Long.TYPE, Long.class, a));
        arrayList.add(TypeAdapters.newFactory(Double.TYPE, Double.class, m5317a(z7)));
        arrayList.add(TypeAdapters.newFactory(Float.TYPE, Float.class, m5321b(z7)));
        arrayList.add(TypeAdapters.NUMBER_FACTORY);
        arrayList.add(TypeAdapters.ATOMIC_INTEGER_FACTORY);
        arrayList.add(TypeAdapters.ATOMIC_BOOLEAN_FACTORY);
        arrayList.add(TypeAdapters.newFactory(AtomicLong.class, m5316a(a)));
        arrayList.add(TypeAdapters.newFactory(AtomicLongArray.class, m5320b(a)));
        arrayList.add(TypeAdapters.ATOMIC_INTEGER_ARRAY_FACTORY);
        arrayList.add(TypeAdapters.CHARACTER_FACTORY);
        arrayList.add(TypeAdapters.STRING_BUILDER_FACTORY);
        arrayList.add(TypeAdapters.STRING_BUFFER_FACTORY);
        arrayList.add(TypeAdapters.newFactory(BigDecimal.class, TypeAdapters.BIG_DECIMAL));
        arrayList.add(TypeAdapters.newFactory(BigInteger.class, TypeAdapters.BIG_INTEGER));
        arrayList.add(TypeAdapters.URL_FACTORY);
        arrayList.add(TypeAdapters.URI_FACTORY);
        arrayList.add(TypeAdapters.UUID_FACTORY);
        arrayList.add(TypeAdapters.CURRENCY_FACTORY);
        arrayList.add(TypeAdapters.LOCALE_FACTORY);
        arrayList.add(TypeAdapters.INET_ADDRESS_FACTORY);
        arrayList.add(TypeAdapters.BIT_SET_FACTORY);
        arrayList.add(DateTypeAdapter.FACTORY);
        arrayList.add(TypeAdapters.CALENDAR_FACTORY);
        arrayList.add(TimeTypeAdapter.FACTORY);
        arrayList.add(SqlDateTypeAdapter.FACTORY);
        arrayList.add(TypeAdapters.TIMESTAMP_FACTORY);
        arrayList.add(ArrayTypeAdapter.FACTORY);
        arrayList.add(TypeAdapters.CLASS_FACTORY);
        arrayList.add(new CollectionTypeAdapterFactory(this.f4660e));
        arrayList.add(new MapTypeAdapterFactory(this.f4660e, z2));
        this.f4668m = new JsonAdapterAnnotationTypeAdapterFactory(this.f4660e);
        arrayList.add(this.f4668m);
        arrayList.add(TypeAdapters.ENUM_FACTORY);
        arrayList.add(new ReflectiveTypeAdapterFactory(this.f4660e, fieldNamingStrategy, excluder, this.f4668m));
        this.f4659d = Collections.unmodifiableList(arrayList);
    }

    public Excluder excluder() {
        return this.f4661f;
    }

    public FieldNamingStrategy fieldNamingStrategy() {
        return this.f4662g;
    }

    public boolean serializeNulls() {
        return this.f4663h;
    }

    public boolean htmlSafe() {
        return this.f4664i;
    }

    private TypeAdapter<Number> m5317a(boolean z) {
        if (z) {
            return TypeAdapters.DOUBLE;
        }
        return new C15212(this);
    }

    private TypeAdapter<Number> m5321b(boolean z) {
        if (z) {
            return TypeAdapters.FLOAT;
        }
        return new C15223(this);
    }

    static void m5318a(double d) {
        if (Double.isNaN(d) || Double.isInfinite(d)) {
            throw new IllegalArgumentException(d + " is not a valid double value as per JSON specification. To override this" + " behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
        }
    }

    private static TypeAdapter<Number> m5315a(LongSerializationPolicy longSerializationPolicy) {
        if (longSerializationPolicy == LongSerializationPolicy.DEFAULT) {
            return TypeAdapters.LONG;
        }
        return new C15234();
    }

    private static TypeAdapter<AtomicLong> m5316a(TypeAdapter<Number> typeAdapter) {
        return new C15245(typeAdapter).nullSafe();
    }

    private static TypeAdapter<AtomicLongArray> m5320b(TypeAdapter<Number> typeAdapter) {
        return new C15256(typeAdapter).nullSafe();
    }

    public <T> TypeAdapter<T> getAdapter(TypeToken<T> typeToken) {
        Object obj;
        Map map = this.f4658c;
        if (typeToken == null) {
            obj = f4656a;
        } else {
            TypeToken<T> typeToken2 = typeToken;
        }
        TypeAdapter<T> typeAdapter = (TypeAdapter) map.get(obj);
        if (typeAdapter == null) {
            Map map2;
            Map map3 = (Map) this.f4657b.get();
            Object obj2 = null;
            if (map3 == null) {
                HashMap hashMap = new HashMap();
                this.f4657b.set(hashMap);
                map2 = hashMap;
                obj2 = 1;
            } else {
                map2 = map3;
            }
            C1526a c1526a = (C1526a) map2.get(typeToken);
            if (c1526a == null) {
                try {
                    C1526a c1526a2 = new C1526a();
                    map2.put(typeToken, c1526a2);
                    for (TypeAdapterFactory create : this.f4659d) {
                        typeAdapter = create.create(this, typeToken);
                        if (typeAdapter != null) {
                            c1526a2.m5314a(typeAdapter);
                            this.f4658c.put(typeToken, typeAdapter);
                            map2.remove(typeToken);
                            if (obj2 != null) {
                                this.f4657b.remove();
                            }
                        }
                    }
                    throw new IllegalArgumentException("GSON cannot handle " + typeToken);
                } catch (Throwable th) {
                    map2.remove(typeToken);
                    if (obj2 != null) {
                        this.f4657b.remove();
                    }
                }
            }
        }
        return typeAdapter;
    }

    public <T> TypeAdapter<T> getDelegateAdapter(TypeAdapterFactory typeAdapterFactory, TypeToken<T> typeToken) {
        if (!this.f4659d.contains(typeAdapterFactory)) {
            typeAdapterFactory = this.f4668m;
        }
        Object obj = null;
        for (TypeAdapterFactory typeAdapterFactory2 : this.f4659d) {
            if (obj != null) {
                TypeAdapter<T> create = typeAdapterFactory2.create(this, typeToken);
                if (create != null) {
                    return create;
                }
            } else if (typeAdapterFactory2 == typeAdapterFactory) {
                obj = 1;
            }
        }
        throw new IllegalArgumentException("GSON cannot serialize " + typeToken);
    }

    public <T> TypeAdapter<T> getAdapter(Class<T> cls) {
        return getAdapter(TypeToken.get((Class) cls));
    }

    public JsonElement toJsonTree(Object obj) {
        if (obj == null) {
            return JsonNull.INSTANCE;
        }
        return toJsonTree(obj, obj.getClass());
    }

    public JsonElement toJsonTree(Object obj, Type type) {
        JsonWriter jsonTreeWriter = new JsonTreeWriter();
        toJson(obj, type, jsonTreeWriter);
        return jsonTreeWriter.get();
    }

    public String toJson(Object obj) {
        if (obj == null) {
            return toJson(JsonNull.INSTANCE);
        }
        return toJson(obj, obj.getClass());
    }

    public String toJson(Object obj, Type type) {
        Appendable stringWriter = new StringWriter();
        toJson(obj, type, stringWriter);
        return stringWriter.toString();
    }

    public void toJson(Object obj, Appendable appendable) {
        if (obj != null) {
            toJson(obj, obj.getClass(), appendable);
        } else {
            toJson(JsonNull.INSTANCE, appendable);
        }
    }

    public void toJson(Object obj, Type type, Appendable appendable) {
        try {
            toJson(obj, type, newJsonWriter(Streams.writerForAppendable(appendable)));
        } catch (Throwable e) {
            throw new JsonIOException(e);
        }
    }

    public void toJson(Object obj, Type type, JsonWriter jsonWriter) {
        TypeAdapter adapter = getAdapter(TypeToken.get(type));
        boolean isLenient = jsonWriter.isLenient();
        jsonWriter.setLenient(true);
        boolean isHtmlSafe = jsonWriter.isHtmlSafe();
        jsonWriter.setHtmlSafe(this.f4664i);
        boolean serializeNulls = jsonWriter.getSerializeNulls();
        jsonWriter.setSerializeNulls(this.f4663h);
        try {
            adapter.write(jsonWriter, obj);
            jsonWriter.setLenient(isLenient);
            jsonWriter.setHtmlSafe(isHtmlSafe);
            jsonWriter.setSerializeNulls(serializeNulls);
        } catch (Throwable e) {
            throw new JsonIOException(e);
        } catch (Throwable th) {
            jsonWriter.setLenient(isLenient);
            jsonWriter.setHtmlSafe(isHtmlSafe);
            jsonWriter.setSerializeNulls(serializeNulls);
        }
    }

    public String toJson(JsonElement jsonElement) {
        Appendable stringWriter = new StringWriter();
        toJson(jsonElement, stringWriter);
        return stringWriter.toString();
    }

    public void toJson(JsonElement jsonElement, Appendable appendable) {
        try {
            toJson(jsonElement, newJsonWriter(Streams.writerForAppendable(appendable)));
        } catch (Throwable e) {
            throw new JsonIOException(e);
        }
    }

    public JsonWriter newJsonWriter(Writer writer) {
        if (this.f4665j) {
            writer.write(")]}'\n");
        }
        JsonWriter jsonWriter = new JsonWriter(writer);
        if (this.f4666k) {
            jsonWriter.setIndent("  ");
        }
        jsonWriter.setSerializeNulls(this.f4663h);
        return jsonWriter;
    }

    public JsonReader newJsonReader(Reader reader) {
        JsonReader jsonReader = new JsonReader(reader);
        jsonReader.setLenient(this.f4667l);
        return jsonReader;
    }

    public void toJson(JsonElement jsonElement, JsonWriter jsonWriter) {
        boolean isLenient = jsonWriter.isLenient();
        jsonWriter.setLenient(true);
        boolean isHtmlSafe = jsonWriter.isHtmlSafe();
        jsonWriter.setHtmlSafe(this.f4664i);
        boolean serializeNulls = jsonWriter.getSerializeNulls();
        jsonWriter.setSerializeNulls(this.f4663h);
        try {
            Streams.write(jsonElement, jsonWriter);
            jsonWriter.setLenient(isLenient);
            jsonWriter.setHtmlSafe(isHtmlSafe);
            jsonWriter.setSerializeNulls(serializeNulls);
        } catch (Throwable e) {
            throw new JsonIOException(e);
        } catch (Throwable th) {
            jsonWriter.setLenient(isLenient);
            jsonWriter.setHtmlSafe(isHtmlSafe);
            jsonWriter.setSerializeNulls(serializeNulls);
        }
    }

    public <T> T fromJson(String str, Class<T> cls) {
        return Primitives.wrap(cls).cast(fromJson(str, (Type) cls));
    }

    public <T> T fromJson(String str, Type type) {
        if (str == null) {
            return null;
        }
        return fromJson(new StringReader(str), type);
    }

    public <T> T fromJson(Reader reader, Class<T> cls) {
        JsonReader newJsonReader = newJsonReader(reader);
        Object fromJson = fromJson(newJsonReader, (Type) cls);
        m5319a(fromJson, newJsonReader);
        return Primitives.wrap(cls).cast(fromJson);
    }

    public <T> T fromJson(Reader reader, Type type) {
        JsonReader newJsonReader = newJsonReader(reader);
        T fromJson = fromJson(newJsonReader, type);
        m5319a(fromJson, newJsonReader);
        return fromJson;
    }

    private static void m5319a(Object obj, JsonReader jsonReader) {
        if (obj != null) {
            try {
                if (jsonReader.peek() != JsonToken.END_DOCUMENT) {
                    throw new JsonIOException("JSON document was not fully consumed.");
                }
            } catch (Throwable e) {
                throw new JsonSyntaxException(e);
            } catch (Throwable e2) {
                throw new JsonIOException(e2);
            }
        }
    }

    public <T> T fromJson(JsonReader jsonReader, Type type) {
        boolean z = true;
        boolean isLenient = jsonReader.isLenient();
        jsonReader.setLenient(true);
        try {
            jsonReader.peek();
            z = false;
            T read = getAdapter(TypeToken.get(type)).read(jsonReader);
            jsonReader.setLenient(isLenient);
            return read;
        } catch (Throwable e) {
            if (z) {
                jsonReader.setLenient(isLenient);
                return null;
            }
            throw new JsonSyntaxException(e);
        } catch (Throwable e2) {
            throw new JsonSyntaxException(e2);
        } catch (Throwable e22) {
            throw new JsonSyntaxException(e22);
        } catch (Throwable th) {
            jsonReader.setLenient(isLenient);
        }
    }

    public <T> T fromJson(JsonElement jsonElement, Class<T> cls) {
        return Primitives.wrap(cls).cast(fromJson(jsonElement, (Type) cls));
    }

    public <T> T fromJson(JsonElement jsonElement, Type type) {
        if (jsonElement == null) {
            return null;
        }
        return fromJson(new JsonTreeReader(jsonElement), type);
    }

    public String toString() {
        return "{serializeNulls:" + this.f4663h + "factories:" + this.f4659d + ",instanceCreators:" + this.f4660e + "}";
    }
}
