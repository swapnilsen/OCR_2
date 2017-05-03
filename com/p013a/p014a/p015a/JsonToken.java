package com.p013a.p014a.p015a;

/* renamed from: com.a.a.a.j */
public enum JsonToken {
    NOT_AVAILABLE(null),
    START_OBJECT("{"),
    END_OBJECT("}"),
    START_ARRAY("["),
    END_ARRAY("]"),
    FIELD_NAME(null),
    VALUE_EMBEDDED_OBJECT(null),
    VALUE_STRING(null),
    VALUE_NUMBER_INT(null),
    VALUE_NUMBER_FLOAT(null),
    VALUE_TRUE("true"),
    VALUE_FALSE("false"),
    VALUE_NULL("null");
    
    final String f685n;
    final char[] f686o;
    final byte[] f687p;

    private JsonToken(String str) {
        if (str == null) {
            this.f685n = null;
            this.f686o = null;
            this.f687p = null;
            return;
        }
        this.f685n = str;
        this.f686o = str.toCharArray();
        int length = this.f686o.length;
        this.f687p = new byte[length];
        for (int i = 0; i < length; i++) {
            this.f687p[i] = (byte) this.f686o[i];
        }
    }

    public String m980a() {
        return this.f685n;
    }
}
