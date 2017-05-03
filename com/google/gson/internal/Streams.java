package com.google.gson.internal;

import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonNull;
import com.google.gson.JsonSyntaxException;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.Writer;

public final class Streams {

    /* renamed from: com.google.gson.internal.Streams.a */
    private static final class C1557a extends Writer {
        private final Appendable f4799a;
        private final C1556a f4800b;

        /* renamed from: com.google.gson.internal.Streams.a.a */
        static class C1556a implements CharSequence {
            char[] f4798a;

            C1556a() {
            }

            public int length() {
                return this.f4798a.length;
            }

            public char charAt(int i) {
                return this.f4798a[i];
            }

            public CharSequence subSequence(int i, int i2) {
                return new String(this.f4798a, i, i2 - i);
            }
        }

        C1557a(Appendable appendable) {
            this.f4800b = new C1556a();
            this.f4799a = appendable;
        }

        public void write(char[] cArr, int i, int i2) {
            this.f4800b.f4798a = cArr;
            this.f4799a.append(this.f4800b, i, i + i2);
        }

        public void write(int i) {
            this.f4799a.append((char) i);
        }

        public void flush() {
        }

        public void close() {
        }
    }

    private Streams() {
        throw new UnsupportedOperationException();
    }

    public static JsonElement parse(JsonReader jsonReader) {
        Object obj = 1;
        try {
            jsonReader.peek();
            obj = null;
            return (JsonElement) TypeAdapters.JSON_ELEMENT.read(jsonReader);
        } catch (Throwable e) {
            if (obj != null) {
                return JsonNull.INSTANCE;
            }
            throw new JsonSyntaxException(e);
        } catch (Throwable e2) {
            throw new JsonSyntaxException(e2);
        } catch (Throwable e22) {
            throw new JsonIOException(e22);
        } catch (Throwable e222) {
            throw new JsonSyntaxException(e222);
        }
    }

    public static void write(JsonElement jsonElement, JsonWriter jsonWriter) {
        TypeAdapters.JSON_ELEMENT.write(jsonWriter, jsonElement);
    }

    public static Writer writerForAppendable(Appendable appendable) {
        return appendable instanceof Writer ? (Writer) appendable : new C1557a(appendable);
    }
}
