package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.C$Gson$Preconditions;
import com.google.gson.internal.Streams;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.lang.reflect.Type;

public final class TreeTypeAdapter<T> extends TypeAdapter<T> {
    private final JsonSerializer<T> f4884a;
    private final JsonDeserializer<T> f4885b;
    private final Gson f4886c;
    private final TypeToken<T> f4887d;
    private final TypeAdapterFactory f4888e;
    private final C1575a f4889f;
    private TypeAdapter<T> f4890g;

    /* renamed from: com.google.gson.internal.bind.TreeTypeAdapter.a */
    private final class C1575a implements JsonDeserializationContext, JsonSerializationContext {
        final /* synthetic */ TreeTypeAdapter f4878a;

        private C1575a(TreeTypeAdapter treeTypeAdapter) {
            this.f4878a = treeTypeAdapter;
        }

        public JsonElement serialize(Object obj) {
            return this.f4878a.f4886c.toJsonTree(obj);
        }

        public JsonElement serialize(Object obj, Type type) {
            return this.f4878a.f4886c.toJsonTree(obj, type);
        }

        public <R> R deserialize(JsonElement jsonElement, Type type) {
            return this.f4878a.f4886c.fromJson(jsonElement, type);
        }
    }

    /* renamed from: com.google.gson.internal.bind.TreeTypeAdapter.b */
    private static final class C1576b implements TypeAdapterFactory {
        private final TypeToken<?> f4879a;
        private final boolean f4880b;
        private final Class<?> f4881c;
        private final JsonSerializer<?> f4882d;
        private final JsonDeserializer<?> f4883e;

        C1576b(Object obj, TypeToken<?> typeToken, boolean z, Class<?> cls) {
            this.f4882d = obj instanceof JsonSerializer ? (JsonSerializer) obj : null;
            if (obj instanceof JsonDeserializer) {
                obj = (JsonDeserializer) obj;
            } else {
                obj = null;
            }
            this.f4883e = obj;
            boolean z2 = (this.f4882d == null && this.f4883e == null) ? false : true;
            C$Gson$Preconditions.checkArgument(z2);
            this.f4879a = typeToken;
            this.f4880b = z;
            this.f4881c = cls;
        }

        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
            boolean isAssignableFrom = this.f4879a != null ? this.f4879a.equals(typeToken) || (this.f4880b && this.f4879a.getType() == typeToken.getRawType()) : this.f4881c.isAssignableFrom(typeToken.getRawType());
            return isAssignableFrom ? new TreeTypeAdapter(this.f4882d, this.f4883e, gson, typeToken, this) : null;
        }
    }

    public TreeTypeAdapter(JsonSerializer<T> jsonSerializer, JsonDeserializer<T> jsonDeserializer, Gson gson, TypeToken<T> typeToken, TypeAdapterFactory typeAdapterFactory) {
        this.f4889f = new C1575a();
        this.f4884a = jsonSerializer;
        this.f4885b = jsonDeserializer;
        this.f4886c = gson;
        this.f4887d = typeToken;
        this.f4888e = typeAdapterFactory;
    }

    public T read(JsonReader jsonReader) {
        if (this.f4885b == null) {
            return m5447a().read(jsonReader);
        }
        JsonElement parse = Streams.parse(jsonReader);
        if (parse.isJsonNull()) {
            return null;
        }
        return this.f4885b.deserialize(parse, this.f4887d.getType(), this.f4889f);
    }

    public void write(JsonWriter jsonWriter, T t) {
        if (this.f4884a == null) {
            m5447a().write(jsonWriter, t);
        } else if (t == null) {
            jsonWriter.nullValue();
        } else {
            Streams.write(this.f4884a.serialize(t, this.f4887d.getType(), this.f4889f), jsonWriter);
        }
    }

    private TypeAdapter<T> m5447a() {
        TypeAdapter<T> typeAdapter = this.f4890g;
        if (typeAdapter != null) {
            return typeAdapter;
        }
        typeAdapter = this.f4886c.getDelegateAdapter(this.f4888e, this.f4887d);
        this.f4890g = typeAdapter;
        return typeAdapter;
    }

    public static TypeAdapterFactory newFactory(TypeToken<?> typeToken, Object obj) {
        return new C1576b(obj, typeToken, false, null);
    }

    public static TypeAdapterFactory newFactoryWithMatchRawType(TypeToken<?> typeToken, Object obj) {
        return new C1576b(obj, typeToken, typeToken.getType() == typeToken.getRawType(), null);
    }

    public static TypeAdapterFactory newTypeHierarchyFactory(Class<?> cls, Object obj) {
        return new C1576b(obj, null, false, cls);
    }
}
