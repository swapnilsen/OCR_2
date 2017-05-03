package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.C$Gson$Types;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.ObjectConstructor;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.lang.reflect.Type;
import java.util.Collection;

public final class CollectionTypeAdapterFactory implements TypeAdapterFactory {
    private final ConstructorConstructor f4810a;

    /* renamed from: com.google.gson.internal.bind.CollectionTypeAdapterFactory.a */
    private static final class C1563a<E> extends TypeAdapter<Collection<E>> {
        private final TypeAdapter<E> f4808a;
        private final ObjectConstructor<? extends Collection<E>> f4809b;

        public /* synthetic */ Object read(JsonReader jsonReader) {
            return m5392a(jsonReader);
        }

        public /* synthetic */ void write(JsonWriter jsonWriter, Object obj) {
            m5393a(jsonWriter, (Collection) obj);
        }

        public C1563a(Gson gson, Type type, TypeAdapter<E> typeAdapter, ObjectConstructor<? extends Collection<E>> objectConstructor) {
            this.f4808a = new TypeAdapterRuntimeTypeWrapper(gson, typeAdapter, type);
            this.f4809b = objectConstructor;
        }

        public Collection<E> m5392a(JsonReader jsonReader) {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            Collection<E> collection = (Collection) this.f4809b.construct();
            jsonReader.beginArray();
            while (jsonReader.hasNext()) {
                collection.add(this.f4808a.read(jsonReader));
            }
            jsonReader.endArray();
            return collection;
        }

        public void m5393a(JsonWriter jsonWriter, Collection<E> collection) {
            if (collection == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginArray();
            for (E write : collection) {
                this.f4808a.write(jsonWriter, write);
            }
            jsonWriter.endArray();
        }
    }

    public CollectionTypeAdapterFactory(ConstructorConstructor constructorConstructor) {
        this.f4810a = constructorConstructor;
    }

    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
        Type type = typeToken.getType();
        Class rawType = typeToken.getRawType();
        if (!Collection.class.isAssignableFrom(rawType)) {
            return null;
        }
        Type collectionElementType = C$Gson$Types.getCollectionElementType(type, rawType);
        return new C1563a(gson, collectionElementType, gson.getAdapter(TypeToken.get(collectionElementType)), this.f4810a.get(typeToken));
    }
}
