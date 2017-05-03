package com.p013a.p014a.p015a.p018c;

import com.p013a.p014a.p015a.JsonStreamContext;

/* renamed from: com.a.a.a.c.d */
public class JsonWriteContext extends JsonStreamContext {
    protected final JsonWriteContext f507c;
    protected String f508d;
    protected JsonWriteContext f509e;

    protected JsonWriteContext(int i, JsonWriteContext jsonWriteContext) {
        this.f509e = null;
        this.a = i;
        this.f507c = jsonWriteContext;
        this.b = -1;
    }

    public static JsonWriteContext m657g() {
        return new JsonWriteContext(0, null);
    }

    private JsonWriteContext m656a(int i) {
        this.a = i;
        this.b = -1;
        this.f508d = null;
        return this;
    }

    public final JsonWriteContext m660h() {
        JsonWriteContext jsonWriteContext = this.f509e;
        if (jsonWriteContext != null) {
            return jsonWriteContext.m656a(1);
        }
        jsonWriteContext = new JsonWriteContext(1, this);
        this.f509e = jsonWriteContext;
        return jsonWriteContext;
    }

    public final JsonWriteContext m661i() {
        JsonWriteContext jsonWriteContext = this.f509e;
        if (jsonWriteContext != null) {
            return jsonWriteContext.m656a(2);
        }
        jsonWriteContext = new JsonWriteContext(2, this);
        this.f509e = jsonWriteContext;
        return jsonWriteContext;
    }

    public final JsonWriteContext m662j() {
        return this.f507c;
    }

    public final int m658a(String str) {
        if (this.a != 2 || this.f508d != null) {
            return 4;
        }
        this.f508d = str;
        return this.b < 0 ? 0 : 1;
    }

    public final int m663k() {
        if (this.a == 2) {
            if (this.f508d == null) {
                return 5;
            }
            this.f508d = null;
            this.b++;
            return 2;
        } else if (this.a == 1) {
            int i = this.b;
            this.b++;
            if (i >= 0) {
                return 1;
            }
            return 0;
        } else {
            this.b++;
            if (this.b != 0) {
                return 3;
            }
            return 0;
        }
    }

    protected final void m659a(StringBuilder stringBuilder) {
        if (this.a == 2) {
            stringBuilder.append('{');
            if (this.f508d != null) {
                stringBuilder.append('\"');
                stringBuilder.append(this.f508d);
                stringBuilder.append('\"');
            } else {
                stringBuilder.append('?');
            }
            stringBuilder.append('}');
        } else if (this.a == 1) {
            stringBuilder.append('[');
            stringBuilder.append(m646f());
            stringBuilder.append(']');
        } else {
            stringBuilder.append("/");
        }
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder(64);
        m659a(stringBuilder);
        return stringBuilder.toString();
    }
}
