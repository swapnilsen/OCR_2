package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.Adapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/* renamed from: com.google.gson.internal.bind.a */
final class TypeAdapterRuntimeTypeWrapper<T> extends TypeAdapter<T> {
    private final Gson f4910a;
    private final TypeAdapter<T> f4911b;
    private final Type f4912c;

    TypeAdapterRuntimeTypeWrapper(Gson gson, TypeAdapter<T> typeAdapter, Type type) {
        this.f4910a = gson;
        this.f4911b = typeAdapter;
        this.f4912c = type;
    }

    public T read(JsonReader jsonReader) {
        return this.f4911b.read(jsonReader);
    }

    public void write(JsonWriter jsonWriter, T t) {
        TypeAdapter typeAdapter = this.f4911b;
        Type a = m5508a(this.f4912c, t);
        if (a != this.f4912c) {
            typeAdapter = this.f4910a.getAdapter(TypeToken.get(a));
            if ((typeAdapter instanceof Adapter) && !(this.f4911b instanceof Adapter)) {
                typeAdapter = this.f4911b;
            }
        }
        typeAdapter.write(jsonWriter, t);
    }

    private Type m5508a(Type type, Object obj) {
        if (obj == null) {
            return type;
        }
        if (type == Object.class || (type instanceof TypeVariable) || (type instanceof Class)) {
            return obj.getClass();
        }
        return type;
    }
}
