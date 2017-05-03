package com.google.gson.internal.bind;

import com.google.gson.FieldNamingStrategy;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.internal.C$Gson$Types;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.ObjectConstructor;
import com.google.gson.internal.Primitives;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class ReflectiveTypeAdapterFactory implements TypeAdapterFactory {
    private final ConstructorConstructor f4872a;
    private final FieldNamingStrategy f4873b;
    private final Excluder f4874c;
    private final JsonAdapterAnnotationTypeAdapterFactory f4875d;

    /* renamed from: com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.a */
    static abstract class C1570a {
        final String f4860h;
        final boolean f4861i;
        final boolean f4862j;

        abstract void m5436a(JsonReader jsonReader, Object obj);

        abstract void m5437a(JsonWriter jsonWriter, Object obj);

        abstract boolean m5438a(Object obj);

        protected C1570a(String str, boolean z, boolean z2) {
            this.f4860h = str;
            this.f4861i = z;
            this.f4862j = z2;
        }
    }

    /* renamed from: com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.1 */
    class C15711 extends C1570a {
        final /* synthetic */ Field f4863a;
        final /* synthetic */ boolean f4864b;
        final /* synthetic */ TypeAdapter f4865c;
        final /* synthetic */ Gson f4866d;
        final /* synthetic */ TypeToken f4867e;
        final /* synthetic */ boolean f4868f;
        final /* synthetic */ ReflectiveTypeAdapterFactory f4869g;

        C15711(ReflectiveTypeAdapterFactory reflectiveTypeAdapterFactory, String str, boolean z, boolean z2, Field field, boolean z3, TypeAdapter typeAdapter, Gson gson, TypeToken typeToken, boolean z4) {
            this.f4869g = reflectiveTypeAdapterFactory;
            this.f4863a = field;
            this.f4864b = z3;
            this.f4865c = typeAdapter;
            this.f4866d = gson;
            this.f4867e = typeToken;
            this.f4868f = z4;
            super(str, z, z2);
        }

        void m5440a(JsonWriter jsonWriter, Object obj) {
            TypeAdapter typeAdapter;
            Object obj2 = this.f4863a.get(obj);
            if (this.f4864b) {
                typeAdapter = this.f4865c;
            } else {
                typeAdapter = new TypeAdapterRuntimeTypeWrapper(this.f4866d, this.f4865c, this.f4867e.getType());
            }
            typeAdapter.write(jsonWriter, obj2);
        }

        void m5439a(JsonReader jsonReader, Object obj) {
            Object read = this.f4865c.read(jsonReader);
            if (read != null || !this.f4868f) {
                this.f4863a.set(obj, read);
            }
        }

        public boolean m5441a(Object obj) {
            if (this.i && this.f4863a.get(obj) != obj) {
                return true;
            }
            return false;
        }
    }

    public static final class Adapter<T> extends TypeAdapter<T> {
        private final ObjectConstructor<T> f4870a;
        private final Map<String, C1570a> f4871b;

        Adapter(ObjectConstructor<T> objectConstructor, Map<String, C1570a> map) {
            this.f4870a = objectConstructor;
            this.f4871b = map;
        }

        public T read(JsonReader jsonReader) {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            T construct = this.f4870a.construct();
            try {
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    C1570a c1570a = (C1570a) this.f4871b.get(jsonReader.nextName());
                    if (c1570a == null || !c1570a.f4862j) {
                        jsonReader.skipValue();
                    } else {
                        c1570a.m5436a(jsonReader, (Object) construct);
                    }
                }
                jsonReader.endObject();
                return construct;
            } catch (Throwable e) {
                throw new JsonSyntaxException(e);
            } catch (IllegalAccessException e2) {
                throw new AssertionError(e2);
            }
        }

        public void write(JsonWriter jsonWriter, T t) {
            if (t == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            try {
                for (C1570a c1570a : this.f4871b.values()) {
                    if (c1570a.m5438a(t)) {
                        jsonWriter.name(c1570a.f4860h);
                        c1570a.m5437a(jsonWriter, (Object) t);
                    }
                }
                jsonWriter.endObject();
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            }
        }
    }

    public ReflectiveTypeAdapterFactory(ConstructorConstructor constructorConstructor, FieldNamingStrategy fieldNamingStrategy, Excluder excluder, JsonAdapterAnnotationTypeAdapterFactory jsonAdapterAnnotationTypeAdapterFactory) {
        this.f4872a = constructorConstructor;
        this.f4873b = fieldNamingStrategy;
        this.f4874c = excluder;
        this.f4875d = jsonAdapterAnnotationTypeAdapterFactory;
    }

    public boolean excludeField(Field field, boolean z) {
        return m5445a(field, z, this.f4874c);
    }

    static boolean m5445a(Field field, boolean z, Excluder excluder) {
        return (excluder.excludeClass(field.getType(), z) || excluder.excludeField(field, z)) ? false : true;
    }

    private List<String> m5443a(Field field) {
        SerializedName serializedName = (SerializedName) field.getAnnotation(SerializedName.class);
        if (serializedName == null) {
            return Collections.singletonList(this.f4873b.translateName(field));
        }
        String value = serializedName.value();
        String[] alternate = serializedName.alternate();
        if (alternate.length == 0) {
            return Collections.singletonList(value);
        }
        List<String> arrayList = new ArrayList(alternate.length + 1);
        arrayList.add(value);
        for (Object add : alternate) {
            arrayList.add(add);
        }
        return arrayList;
    }

    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
        Class rawType = typeToken.getRawType();
        if (Object.class.isAssignableFrom(rawType)) {
            return new Adapter(this.f4872a.get(typeToken), m5444a(gson, (TypeToken) typeToken, rawType));
        }
        return null;
    }

    private C1570a m5442a(Gson gson, Field field, String str, TypeToken<?> typeToken, boolean z, boolean z2) {
        boolean isPrimitive = Primitives.isPrimitive(typeToken.getRawType());
        JsonAdapter jsonAdapter = (JsonAdapter) field.getAnnotation(JsonAdapter.class);
        TypeAdapter typeAdapter = null;
        if (jsonAdapter != null) {
            typeAdapter = this.f4875d.m5395a(this.f4872a, gson, typeToken, jsonAdapter);
        }
        boolean z3 = typeAdapter != null;
        if (typeAdapter == null) {
            typeAdapter = gson.getAdapter((TypeToken) typeToken);
        }
        return new C15711(this, str, z, z2, field, z3, typeAdapter, gson, typeToken, isPrimitive);
    }

    private Map<String, C1570a> m5444a(Gson gson, TypeToken<?> typeToken, Class<?> cls) {
        Map<String, C1570a> linkedHashMap = new LinkedHashMap();
        if (cls.isInterface()) {
            return linkedHashMap;
        }
        Type type = typeToken.getType();
        while (cls != Object.class) {
            for (Field field : cls.getDeclaredFields()) {
                boolean excludeField = excludeField(field, true);
                boolean excludeField2 = excludeField(field, false);
                if (excludeField || excludeField2) {
                    field.setAccessible(true);
                    Type resolve = C$Gson$Types.resolve(typeToken.getType(), cls, field.getGenericType());
                    List a = m5443a(field);
                    C1570a c1570a = null;
                    int i = 0;
                    while (i < a.size()) {
                        String str = (String) a.get(i);
                        if (i != 0) {
                            excludeField = false;
                        }
                        C1570a c1570a2 = (C1570a) linkedHashMap.put(str, m5442a(gson, field, str, TypeToken.get(resolve), excludeField, excludeField2));
                        if (c1570a != null) {
                            c1570a2 = c1570a;
                        }
                        i++;
                        c1570a = c1570a2;
                    }
                    if (c1570a != null) {
                        throw new IllegalArgumentException(type + " declares multiple JSON fields named " + c1570a.f4860h);
                    }
                }
            }
            typeToken = TypeToken.get(C$Gson$Types.resolve(typeToken.getType(), cls, cls.getGenericSuperclass()));
            cls = typeToken.getRawType();
        }
        return linkedHashMap;
    }
}
