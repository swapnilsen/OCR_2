package com.p013a.p014a.p015a;

import java.io.Serializable;

/* renamed from: com.a.a.a.e */
public class JsonLocation implements Serializable {
    public static final JsonLocation f655a;
    final long f656b;
    final long f657c;
    final int f658d;
    final int f659e;
    final Object f660f;

    static {
        f655a = new JsonLocation("N/A", -1, -1, -1, -1);
    }

    public JsonLocation(Object obj, long j, int i, int i2) {
        this(obj, -1, j, i, i2);
    }

    public JsonLocation(Object obj, long j, long j2, int i, int i2) {
        this.f660f = obj;
        this.f656b = j;
        this.f657c = j2;
        this.f658d = i;
        this.f659e = i2;
    }

    public long m976a() {
        return this.f656b;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(80);
        stringBuilder.append("[Source: ");
        if (this.f660f == null) {
            stringBuilder.append("UNKNOWN");
        } else {
            stringBuilder.append(this.f660f.toString());
        }
        stringBuilder.append("; line: ");
        stringBuilder.append(this.f658d);
        stringBuilder.append(", column: ");
        stringBuilder.append(this.f659e);
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    public int hashCode() {
        return ((((this.f660f == null ? 1 : this.f660f.hashCode()) ^ this.f658d) + this.f659e) ^ ((int) this.f657c)) + ((int) this.f656b);
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof JsonLocation)) {
            return false;
        }
        JsonLocation jsonLocation = (JsonLocation) obj;
        if (this.f660f == null) {
            if (jsonLocation.f660f != null) {
                return false;
            }
        } else if (!this.f660f.equals(jsonLocation.f660f)) {
            return false;
        }
        if (!(this.f658d == jsonLocation.f658d && this.f659e == jsonLocation.f659e && this.f657c == jsonLocation.f657c && m976a() == jsonLocation.m976a())) {
            z = false;
        }
        return z;
    }
}
