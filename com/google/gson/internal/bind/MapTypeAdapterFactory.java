package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.C$Gson$Types;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.JsonReaderInternalAccess;
import com.google.gson.internal.ObjectConstructor;
import com.google.gson.internal.Streams;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class MapTypeAdapterFactory implements TypeAdapterFactory {
    final boolean f4856a;
    private final ConstructorConstructor f4857b;

    /* renamed from: com.google.gson.internal.bind.MapTypeAdapterFactory.a */
    private final class C1567a<K, V> extends TypeAdapter<Map<K, V>> {
        final /* synthetic */ MapTypeAdapterFactory f4852a;
        private final TypeAdapter<K> f4853b;
        private final TypeAdapter<V> f4854c;
        private final ObjectConstructor<? extends Map<K, V>> f4855d;

        public /* synthetic */ Object read(JsonReader jsonReader) {
            return m5433a(jsonReader);
        }

        public /* synthetic */ void write(JsonWriter jsonWriter, Object obj) {
            m5434a(jsonWriter, (Map) obj);
        }

        public C1567a(MapTypeAdapterFactory mapTypeAdapterFactory, Gson gson, Type type, TypeAdapter<K> typeAdapter, Type type2, TypeAdapter<V> typeAdapter2, ObjectConstructor<? extends Map<K, V>> objectConstructor) {
            this.f4852a = mapTypeAdapterFactory;
            this.f4853b = new TypeAdapterRuntimeTypeWrapper(gson, typeAdapter, type);
            this.f4854c = new TypeAdapterRuntimeTypeWrapper(gson, typeAdapter2, type2);
            this.f4855d = objectConstructor;
        }

        public Map<K, V> m5433a(JsonReader jsonReader) {
            JsonToken peek = jsonReader.peek();
            if (peek == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            Map<K, V> map = (Map) this.f4855d.construct();
            Object read;
            if (peek == JsonToken.BEGIN_ARRAY) {
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    jsonReader.beginArray();
                    read = this.f4853b.read(jsonReader);
                    if (map.put(read, this.f4854c.read(jsonReader)) != null) {
                        throw new JsonSyntaxException("duplicate key: " + read);
                    }
                    jsonReader.endArray();
                }
                jsonReader.endArray();
                return map;
            }
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                JsonReaderInternalAccess.INSTANCE.promoteNameToValue(jsonReader);
                read = this.f4853b.read(jsonReader);
                if (map.put(read, this.f4854c.read(jsonReader)) != null) {
                    throw new JsonSyntaxException("duplicate key: " + read);
                }
            }
            jsonReader.endObject();
            return map;
        }

        public void m5434a(JsonWriter jsonWriter, Map<K, V> map) {
            int i = 0;
            if (map == null) {
                jsonWriter.nullValue();
            } else if (this.f4852a.f4856a) {
                List arrayList = new ArrayList(map.size());
                List arrayList2 = new ArrayList(map.size());
                int i2 = 0;
                for (Entry entry : map.entrySet()) {
                    int i3;
                    JsonElement toJsonTree = this.f4853b.toJsonTree(entry.getKey());
                    arrayList.add(toJsonTree);
                    arrayList2.add(entry.getValue());
                    if (toJsonTree.isJsonArray() || toJsonTree.isJsonObject()) {
                        i3 = 1;
                    } else {
                        i3 = 0;
                    }
                    i2 = i3 | i2;
                }
                if (i2 != 0) {
                    jsonWriter.beginArray();
                    while (i < arrayList.size()) {
                        jsonWriter.beginArray();
                        Streams.write((JsonElement) arrayList.get(i), jsonWriter);
                        this.f4854c.write(jsonWriter, arrayList2.get(i));
                        jsonWriter.endArray();
                        i++;
                    }
                    jsonWriter.endArray();
                    return;
                }
                jsonWriter.beginObject();
                while (i < arrayList.size()) {
                    jsonWriter.name(m5432a((JsonElement) arrayList.get(i)));
                    this.f4854c.write(jsonWriter, arrayList2.get(i));
                    i++;
                }
                jsonWriter.endObject();
            } else {
                jsonWriter.beginObject();
                for (Entry entry2 : map.entrySet()) {
                    jsonWriter.name(String.valueOf(entry2.getKey()));
                    this.f4854c.write(jsonWriter, entry2.getValue());
                }
                jsonWriter.endObject();
            }
        }

        private String m5432a(JsonElement jsonElement) {
            if (jsonElement.isJsonPrimitive()) {
                JsonPrimitive asJsonPrimitive = jsonElement.getAsJsonPrimitive();
                if (asJsonPrimitive.isNumber()) {
                    return String.valueOf(asJsonPrimitive.getAsNumber());
                }
                if (asJsonPrimitive.isBoolean()) {
                    return Boolean.toString(asJsonPrimitive.getAsBoolean());
                }
                if (asJsonPrimitive.isString()) {
                    return asJsonPrimitive.getAsString();
                }
                throw new AssertionError();
            } else if (jsonElement.isJsonNull()) {
                return "null";
            } else {
                throw new AssertionError();
            }
        }
    }

    public MapTypeAdapterFactory(ConstructorConstructor constructorConstructor, boolean z) {
        this.f4857b = constructorConstructor;
        this.f4856a = z;
    }

    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
        Type type = typeToken.getType();
        if (!Map.class.isAssignableFrom(typeToken.getRawType())) {
            return null;
        }
        Type[] mapKeyAndValueTypes = C$Gson$Types.getMapKeyAndValueTypes(type, C$Gson$Types.getRawType(type));
        TypeAdapter a = m5435a(gson, mapKeyAndValueTypes[0]);
        TypeAdapter adapter = gson.getAdapter(TypeToken.get(mapKeyAndValueTypes[1]));
        ObjectConstructor objectConstructor = this.f4857b.get(typeToken);
        return new C1567a(this, gson, mapKeyAndValueTypes[0], a, mapKeyAndValueTypes[1], adapter, objectConstructor);
    }

    private TypeAdapter<?> m5435a(Gson gson, Type type) {
        if (type == Boolean.TYPE || type == Boolean.class) {
            return TypeAdapters.BOOLEAN_AS_STRING;
        }
        return gson.getAdapter(TypeToken.get(type));
    }
}
