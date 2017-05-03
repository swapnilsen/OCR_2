package com.p013a.p014a.p015a;

import com.p013a.p014a.p015a.p017b.CharacterEscapes;
import java.io.Closeable;
import java.io.Flushable;
import java.math.BigDecimal;
import java.math.BigInteger;

/* renamed from: com.a.a.a.d */
public abstract class JsonGenerator implements Closeable, Flushable {
    protected PrettyPrinter f351a;

    /* renamed from: com.a.a.a.d.a */
    public enum JsonGenerator {
        AUTO_CLOSE_TARGET(true),
        AUTO_CLOSE_JSON_CONTENT(true),
        QUOTE_FIELD_NAMES(true),
        QUOTE_NON_NUMERIC_NUMBERS(true),
        WRITE_NUMBERS_AS_STRINGS(false),
        FLUSH_PASSED_TO_STREAM(true),
        ESCAPE_NON_ASCII(false);
        
        private final boolean f557h;
        private final int f558i;

        public static int m840a() {
            int i = 0;
            for (JsonGenerator jsonGenerator : JsonGenerator.values()) {
                if (jsonGenerator.m841b()) {
                    i |= jsonGenerator.m842c();
                }
            }
            return i;
        }

        private JsonGenerator(boolean z) {
            this.f558i = 1 << ordinal();
            this.f557h = z;
        }

        public boolean m841b() {
            return this.f557h;
        }

        public int m842c() {
            return this.f558i;
        }
    }

    public abstract void m454a(char c);

    public abstract void m455a(double d);

    public abstract void m456a(float f);

    public abstract void m457a(long j);

    public abstract void m458a(String str);

    public abstract void m459a(BigDecimal bigDecimal);

    public abstract void m460a(BigInteger bigInteger);

    public abstract void m461a(boolean z);

    public abstract void m462a(char[] cArr, int i, int i2);

    public abstract JsonGenerator m463b();

    public abstract void m464b(int i);

    public abstract void m466b(String str);

    public abstract void m467c();

    public abstract void m468c(String str);

    public abstract void close();

    public abstract void m469d();

    public abstract void m470d(String str);

    public abstract void m471e();

    public abstract void m472f();

    public abstract void flush();

    public abstract void m473g();

    protected JsonGenerator() {
    }

    public JsonGenerator m452a(SerializableString serializableString) {
        throw new UnsupportedOperationException();
    }

    public JsonGenerator m451a(PrettyPrinter prettyPrinter) {
        this.f351a = prettyPrinter;
        return this;
    }

    public PrettyPrinter m453a() {
        return this.f351a;
    }

    public JsonGenerator m449a(int i) {
        return this;
    }

    public JsonGenerator m450a(CharacterEscapes characterEscapes) {
        return this;
    }

    public void m465b(SerializableString serializableString) {
        m468c(serializableString.m602a());
    }
}
