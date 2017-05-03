package com.google.api.client.json.gson;

import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.JsonGenerator;
import com.google.gson.stream.JsonWriter;
import java.math.BigDecimal;
import java.math.BigInteger;

/* renamed from: com.google.api.client.json.gson.a */
class GsonGenerator extends JsonGenerator {
    private final JsonWriter f4467a;
    private final GsonFactory f4468b;

    /* renamed from: com.google.api.client.json.gson.a.a */
    static final class GsonGenerator extends Number {
        private final String f4466a;

        GsonGenerator(String str) {
            this.f4466a = str;
        }

        public double doubleValue() {
            return 0.0d;
        }

        public float floatValue() {
            return 0.0f;
        }

        public int intValue() {
            return 0;
        }

        public long longValue() {
            return 0;
        }

        public String toString() {
            return this.f4466a;
        }
    }

    GsonGenerator(GsonFactory gsonFactory, JsonWriter jsonWriter) {
        this.f4468b = gsonFactory;
        this.f4467a = jsonWriter;
        jsonWriter.setLenient(true);
    }

    public void flush() {
        this.f4467a.flush();
    }

    public void close() {
        this.f4467a.close();
    }

    public JsonFactory getFactory() {
        return this.f4468b;
    }

    public void writeBoolean(boolean z) {
        this.f4467a.value(z);
    }

    public void writeEndArray() {
        this.f4467a.endArray();
    }

    public void writeEndObject() {
        this.f4467a.endObject();
    }

    public void writeFieldName(String str) {
        this.f4467a.name(str);
    }

    public void writeNull() {
        this.f4467a.nullValue();
    }

    public void writeNumber(int i) {
        this.f4467a.value((long) i);
    }

    public void writeNumber(long j) {
        this.f4467a.value(j);
    }

    public void writeNumber(BigInteger bigInteger) {
        this.f4467a.value((Number) bigInteger);
    }

    public void writeNumber(double d) {
        this.f4467a.value(d);
    }

    public void writeNumber(float f) {
        this.f4467a.value((double) f);
    }

    public void writeNumber(BigDecimal bigDecimal) {
        this.f4467a.value((Number) bigDecimal);
    }

    public void writeNumber(String str) {
        this.f4467a.value(new GsonGenerator(str));
    }

    public void writeStartArray() {
        this.f4467a.beginArray();
    }

    public void writeStartObject() {
        this.f4467a.beginObject();
    }

    public void writeString(String str) {
        this.f4467a.value(str);
    }

    public void enablePrettyPrint() {
        this.f4467a.setIndent("  ");
    }
}
