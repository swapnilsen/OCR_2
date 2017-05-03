package com.google.gson.internal.bind;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import java.io.Reader;
import java.util.Iterator;
import java.util.Map.Entry;

public final class JsonTreeReader extends JsonReader {
    private static final Reader f4830b;
    private static final Object f4831c;
    private Object[] f4832d;
    private int f4833e;
    private String[] f4834f;
    private int[] f4835g;

    /* renamed from: com.google.gson.internal.bind.JsonTreeReader.1 */
    static class C15651 extends Reader {
        C15651() {
        }

        public int read(char[] cArr, int i, int i2) {
            throw new AssertionError();
        }

        public void close() {
            throw new AssertionError();
        }
    }

    static {
        f4830b = new C15651();
        f4831c = new Object();
    }

    public JsonTreeReader(JsonElement jsonElement) {
        super(f4830b);
        this.f4832d = new Object[32];
        this.f4833e = 0;
        this.f4834f = new String[32];
        this.f4835g = new int[32];
        m5416a((Object) jsonElement);
    }

    public void beginArray() {
        m5415a(JsonToken.BEGIN_ARRAY);
        m5416a(((JsonArray) m5417b()).iterator());
        this.f4835g[this.f4833e - 1] = 0;
    }

    public void endArray() {
        m5415a(JsonToken.END_ARRAY);
        m5418c();
        m5418c();
        if (this.f4833e > 0) {
            int[] iArr = this.f4835g;
            int i = this.f4833e - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    public void beginObject() {
        m5415a(JsonToken.BEGIN_OBJECT);
        m5416a(((JsonObject) m5417b()).entrySet().iterator());
    }

    public void endObject() {
        m5415a(JsonToken.END_OBJECT);
        m5418c();
        m5418c();
        if (this.f4833e > 0) {
            int[] iArr = this.f4835g;
            int i = this.f4833e - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    public boolean hasNext() {
        JsonToken peek = peek();
        return (peek == JsonToken.END_OBJECT || peek == JsonToken.END_ARRAY) ? false : true;
    }

    public JsonToken peek() {
        if (this.f4833e == 0) {
            return JsonToken.END_DOCUMENT;
        }
        Object b = m5417b();
        if (b instanceof Iterator) {
            boolean z = this.f4832d[this.f4833e - 2] instanceof JsonObject;
            Iterator it = (Iterator) b;
            if (!it.hasNext()) {
                return z ? JsonToken.END_OBJECT : JsonToken.END_ARRAY;
            } else {
                if (z) {
                    return JsonToken.NAME;
                }
                m5416a(it.next());
                return peek();
            }
        } else if (b instanceof JsonObject) {
            return JsonToken.BEGIN_OBJECT;
        } else {
            if (b instanceof JsonArray) {
                return JsonToken.BEGIN_ARRAY;
            }
            if (b instanceof JsonPrimitive) {
                JsonPrimitive jsonPrimitive = (JsonPrimitive) b;
                if (jsonPrimitive.isString()) {
                    return JsonToken.STRING;
                }
                if (jsonPrimitive.isBoolean()) {
                    return JsonToken.BOOLEAN;
                }
                if (jsonPrimitive.isNumber()) {
                    return JsonToken.NUMBER;
                }
                throw new AssertionError();
            } else if (b instanceof JsonNull) {
                return JsonToken.NULL;
            } else {
                if (b == f4831c) {
                    throw new IllegalStateException("JsonReader is closed");
                }
                throw new AssertionError();
            }
        }
    }

    private Object m5417b() {
        return this.f4832d[this.f4833e - 1];
    }

    private Object m5418c() {
        Object[] objArr = this.f4832d;
        int i = this.f4833e - 1;
        this.f4833e = i;
        Object obj = objArr[i];
        this.f4832d[this.f4833e] = null;
        return obj;
    }

    private void m5415a(JsonToken jsonToken) {
        if (peek() != jsonToken) {
            throw new IllegalStateException("Expected " + jsonToken + " but was " + peek() + m5419d());
        }
    }

    public String nextName() {
        m5415a(JsonToken.NAME);
        Entry entry = (Entry) ((Iterator) m5417b()).next();
        String str = (String) entry.getKey();
        this.f4834f[this.f4833e - 1] = str;
        m5416a(entry.getValue());
        return str;
    }

    public String nextString() {
        JsonToken peek = peek();
        if (peek == JsonToken.STRING || peek == JsonToken.NUMBER) {
            String asString = ((JsonPrimitive) m5418c()).getAsString();
            if (this.f4833e > 0) {
                int[] iArr = this.f4835g;
                int i = this.f4833e - 1;
                iArr[i] = iArr[i] + 1;
            }
            return asString;
        }
        throw new IllegalStateException("Expected " + JsonToken.STRING + " but was " + peek + m5419d());
    }

    public boolean nextBoolean() {
        m5415a(JsonToken.BOOLEAN);
        boolean asBoolean = ((JsonPrimitive) m5418c()).getAsBoolean();
        if (this.f4833e > 0) {
            int[] iArr = this.f4835g;
            int i = this.f4833e - 1;
            iArr[i] = iArr[i] + 1;
        }
        return asBoolean;
    }

    public void nextNull() {
        m5415a(JsonToken.NULL);
        m5418c();
        if (this.f4833e > 0) {
            int[] iArr = this.f4835g;
            int i = this.f4833e - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    public double nextDouble() {
        JsonToken peek = peek();
        if (peek == JsonToken.NUMBER || peek == JsonToken.STRING) {
            double asDouble = ((JsonPrimitive) m5417b()).getAsDouble();
            if (isLenient() || !(Double.isNaN(asDouble) || Double.isInfinite(asDouble))) {
                m5418c();
                if (this.f4833e > 0) {
                    int[] iArr = this.f4835g;
                    int i = this.f4833e - 1;
                    iArr[i] = iArr[i] + 1;
                }
                return asDouble;
            }
            throw new NumberFormatException("JSON forbids NaN and infinities: " + asDouble);
        }
        throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + peek + m5419d());
    }

    public long nextLong() {
        JsonToken peek = peek();
        if (peek == JsonToken.NUMBER || peek == JsonToken.STRING) {
            long asLong = ((JsonPrimitive) m5417b()).getAsLong();
            m5418c();
            if (this.f4833e > 0) {
                int[] iArr = this.f4835g;
                int i = this.f4833e - 1;
                iArr[i] = iArr[i] + 1;
            }
            return asLong;
        }
        throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + peek + m5419d());
    }

    public int nextInt() {
        JsonToken peek = peek();
        if (peek == JsonToken.NUMBER || peek == JsonToken.STRING) {
            int asInt = ((JsonPrimitive) m5417b()).getAsInt();
            m5418c();
            if (this.f4833e > 0) {
                int[] iArr = this.f4835g;
                int i = this.f4833e - 1;
                iArr[i] = iArr[i] + 1;
            }
            return asInt;
        }
        throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + peek + m5419d());
    }

    public void close() {
        this.f4832d = new Object[]{f4831c};
        this.f4833e = 1;
    }

    public void skipValue() {
        if (peek() == JsonToken.NAME) {
            nextName();
            this.f4834f[this.f4833e - 2] = "null";
        } else {
            m5418c();
            this.f4834f[this.f4833e - 1] = "null";
        }
        int[] iArr = this.f4835g;
        int i = this.f4833e - 1;
        iArr[i] = iArr[i] + 1;
    }

    public String toString() {
        return getClass().getSimpleName();
    }

    public void promoteNameToValue() {
        m5415a(JsonToken.NAME);
        Entry entry = (Entry) ((Iterator) m5417b()).next();
        m5416a(entry.getValue());
        m5416a(new JsonPrimitive((String) entry.getKey()));
    }

    private void m5416a(Object obj) {
        if (this.f4833e == this.f4832d.length) {
            Object obj2 = new Object[(this.f4833e * 2)];
            Object obj3 = new int[(this.f4833e * 2)];
            Object obj4 = new String[(this.f4833e * 2)];
            System.arraycopy(this.f4832d, 0, obj2, 0, this.f4833e);
            System.arraycopy(this.f4835g, 0, obj3, 0, this.f4833e);
            System.arraycopy(this.f4834f, 0, obj4, 0, this.f4833e);
            this.f4832d = obj2;
            this.f4835g = obj3;
            this.f4834f = obj4;
        }
        Object[] objArr = this.f4832d;
        int i = this.f4833e;
        this.f4833e = i + 1;
        objArr[i] = obj;
    }

    public String getPath() {
        StringBuilder append = new StringBuilder().append('$');
        int i = 0;
        while (i < this.f4833e) {
            if (this.f4832d[i] instanceof JsonArray) {
                i++;
                if (this.f4832d[i] instanceof Iterator) {
                    append.append('[').append(this.f4835g[i]).append(']');
                }
            } else if (this.f4832d[i] instanceof JsonObject) {
                i++;
                if (this.f4832d[i] instanceof Iterator) {
                    append.append('.');
                    if (this.f4834f[i] != null) {
                        append.append(this.f4834f[i]);
                    }
                }
            }
            i++;
        }
        return append.toString();
    }

    private String m5419d() {
        return " at path " + getPath();
    }
}
