package com.google.gson.internal.bind;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public final class JsonTreeWriter extends JsonWriter {
    private static final Writer f4847a;
    private static final JsonPrimitive f4848b;
    private final List<JsonElement> f4849c;
    private String f4850d;
    private JsonElement f4851e;

    /* renamed from: com.google.gson.internal.bind.JsonTreeWriter.1 */
    static class C15661 extends Writer {
        C15661() {
        }

        public void write(char[] cArr, int i, int i2) {
            throw new AssertionError();
        }

        public void flush() {
            throw new AssertionError();
        }

        public void close() {
            throw new AssertionError();
        }
    }

    static {
        f4847a = new C15661();
        f4848b = new JsonPrimitive("closed");
    }

    public JsonTreeWriter() {
        super(f4847a);
        this.f4849c = new ArrayList();
        this.f4851e = JsonNull.INSTANCE;
    }

    public JsonElement get() {
        if (this.f4849c.isEmpty()) {
            return this.f4851e;
        }
        throw new IllegalStateException("Expected one JSON element but was " + this.f4849c);
    }

    private JsonElement m5430a() {
        return (JsonElement) this.f4849c.get(this.f4849c.size() - 1);
    }

    private void m5431a(JsonElement jsonElement) {
        if (this.f4850d != null) {
            if (!jsonElement.isJsonNull() || getSerializeNulls()) {
                ((JsonObject) m5430a()).add(this.f4850d, jsonElement);
            }
            this.f4850d = null;
        } else if (this.f4849c.isEmpty()) {
            this.f4851e = jsonElement;
        } else {
            JsonElement a = m5430a();
            if (a instanceof JsonArray) {
                ((JsonArray) a).add(jsonElement);
                return;
            }
            throw new IllegalStateException();
        }
    }

    public JsonWriter beginArray() {
        JsonElement jsonArray = new JsonArray();
        m5431a(jsonArray);
        this.f4849c.add(jsonArray);
        return this;
    }

    public JsonWriter endArray() {
        if (this.f4849c.isEmpty() || this.f4850d != null) {
            throw new IllegalStateException();
        } else if (m5430a() instanceof JsonArray) {
            this.f4849c.remove(this.f4849c.size() - 1);
            return this;
        } else {
            throw new IllegalStateException();
        }
    }

    public JsonWriter beginObject() {
        JsonElement jsonObject = new JsonObject();
        m5431a(jsonObject);
        this.f4849c.add(jsonObject);
        return this;
    }

    public JsonWriter endObject() {
        if (this.f4849c.isEmpty() || this.f4850d != null) {
            throw new IllegalStateException();
        } else if (m5430a() instanceof JsonObject) {
            this.f4849c.remove(this.f4849c.size() - 1);
            return this;
        } else {
            throw new IllegalStateException();
        }
    }

    public JsonWriter name(String str) {
        if (this.f4849c.isEmpty() || this.f4850d != null) {
            throw new IllegalStateException();
        } else if (m5430a() instanceof JsonObject) {
            this.f4850d = str;
            return this;
        } else {
            throw new IllegalStateException();
        }
    }

    public JsonWriter value(String str) {
        if (str == null) {
            return nullValue();
        }
        m5431a(new JsonPrimitive(str));
        return this;
    }

    public JsonWriter nullValue() {
        m5431a(JsonNull.INSTANCE);
        return this;
    }

    public JsonWriter value(boolean z) {
        m5431a(new JsonPrimitive(Boolean.valueOf(z)));
        return this;
    }

    public JsonWriter value(Boolean bool) {
        if (bool == null) {
            return nullValue();
        }
        m5431a(new JsonPrimitive(bool));
        return this;
    }

    public JsonWriter value(double d) {
        if (isLenient() || !(Double.isNaN(d) || Double.isInfinite(d))) {
            m5431a(new JsonPrimitive(Double.valueOf(d)));
            return this;
        }
        throw new IllegalArgumentException("JSON forbids NaN and infinities: " + d);
    }

    public JsonWriter value(long j) {
        m5431a(new JsonPrimitive(Long.valueOf(j)));
        return this;
    }

    public JsonWriter value(Number number) {
        if (number == null) {
            return nullValue();
        }
        if (!isLenient()) {
            double doubleValue = number.doubleValue();
            if (Double.isNaN(doubleValue) || Double.isInfinite(doubleValue)) {
                throw new IllegalArgumentException("JSON forbids NaN and infinities: " + number);
            }
        }
        m5431a(new JsonPrimitive(number));
        return this;
    }

    public void flush() {
    }

    public void close() {
        if (this.f4849c.isEmpty()) {
            this.f4849c.add(f4848b);
            return;
        }
        throw new IOException("Incomplete document");
    }
}
