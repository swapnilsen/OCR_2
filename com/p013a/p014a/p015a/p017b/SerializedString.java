package com.p013a.p014a.p015a.p017b;

import com.p013a.p014a.p015a.SerializableString;
import java.io.Serializable;

/* renamed from: com.a.a.a.b.k */
public class SerializedString implements SerializableString, Serializable {
    protected final String f456a;
    protected byte[] f457b;

    public SerializedString(String str) {
        if (str == null) {
            throw new IllegalStateException("Null String illegal for SerializedString");
        }
        this.f456a = str;
    }

    public final String m604a() {
        return this.f456a;
    }

    public final byte[] m605b() {
        byte[] bArr = this.f457b;
        if (bArr != null) {
            return bArr;
        }
        bArr = JsonStringEncoder.m583a().m585a(this.f456a);
        this.f457b = bArr;
        return bArr;
    }

    public final String toString() {
        return this.f456a;
    }

    public final int hashCode() {
        return this.f456a.hashCode();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        return this.f456a.equals(((SerializedString) obj).f456a);
    }
}
