package com.p013a.p014a.p015a;

import android.support.v4.view.MotionEventCompat;
import java.io.Closeable;
import java.math.BigDecimal;
import java.math.BigInteger;

/* renamed from: com.a.a.a.g */
public abstract class JsonParser implements Closeable {
    protected int f357a;

    /* renamed from: com.a.a.a.g.a */
    public enum JsonParser {
        AUTO_CLOSE_SOURCE(true),
        ALLOW_COMMENTS(false),
        ALLOW_UNQUOTED_FIELD_NAMES(false),
        ALLOW_SINGLE_QUOTES(false),
        ALLOW_UNQUOTED_CONTROL_CHARS(false),
        ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER(false),
        ALLOW_NUMERIC_LEADING_ZEROS(false),
        ALLOW_NON_NUMERIC_NUMBERS(false);
        
        private final boolean f670i;

        public static int m977a() {
            int i = 0;
            for (JsonParser jsonParser : JsonParser.values()) {
                if (jsonParser.m978b()) {
                    i |= jsonParser.m979c();
                }
            }
            return i;
        }

        private JsonParser(boolean z) {
            this.f670i = z;
        }

        public boolean m978b() {
            return this.f670i;
        }

        public int m979c() {
            return 1 << ordinal();
        }
    }

    public abstract JsonToken m482a();

    public abstract JsonParser m484b();

    public abstract JsonToken m485c();

    public abstract void close();

    public abstract String m486d();

    public abstract JsonLocation m487e();

    public abstract String m488f();

    public abstract int m491i();

    public abstract long m492j();

    public abstract BigInteger m493k();

    public abstract float m494l();

    public abstract double m495m();

    public abstract BigDecimal m496n();

    protected JsonParser() {
    }

    public boolean m483a(JsonParser jsonParser) {
        return (this.f357a & jsonParser.m979c()) != 0;
    }

    public byte m489g() {
        int i = m491i();
        if (i >= -128 && i <= MotionEventCompat.ACTION_MASK) {
            return (byte) i;
        }
        throw m481a("Numeric value (" + m488f() + ") out of range of Java byte");
    }

    public short m490h() {
        int i = m491i();
        if (i >= -32768 && i <= 32767) {
            return (short) i;
        }
        throw m481a("Numeric value (" + m488f() + ") out of range of Java short");
    }

    protected JsonParseException m481a(String str) {
        return new JsonParseException(str, m487e());
    }
}
