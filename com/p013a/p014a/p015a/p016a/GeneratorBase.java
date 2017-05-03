package com.p013a.p014a.p015a.p016a;

import com.p013a.p014a.p015a.JsonGenerationException;
import com.p013a.p014a.p015a.JsonGenerator;
import com.p013a.p014a.p015a.ObjectCodec;
import com.p013a.p014a.p015a.p018c.JsonWriteContext;
import com.p013a.p014a.p015a.p020e.DefaultPrettyPrinter;

/* renamed from: com.a.a.a.a.a */
public abstract class GeneratorBase extends JsonGenerator {
    protected ObjectCodec f352b;
    protected int f353c;
    protected boolean f354d;
    protected JsonWriteContext f355e;
    protected boolean f356f;

    protected abstract void m476e(String str);

    protected abstract void m479i();

    protected GeneratorBase(int i, ObjectCodec objectCodec) {
        this.f353c = i;
        this.f355e = JsonWriteContext.m657g();
        this.f352b = objectCodec;
        this.f354d = m474a(JsonGenerator.JsonGenerator.WRITE_NUMBERS_AS_STRINGS);
    }

    public final boolean m474a(JsonGenerator.JsonGenerator jsonGenerator) {
        return (this.f353c & jsonGenerator.m842c()) != 0;
    }

    public JsonGenerator m475b() {
        return m453a() != null ? this : m451a(new DefaultPrettyPrinter());
    }

    public final JsonWriteContext m478h() {
        return this.f355e;
    }

    public void close() {
        this.f356f = true;
    }

    protected void m477f(String str) {
        throw new JsonGenerationException(str);
    }

    protected void m480j() {
        throw new RuntimeException("Internal error: should never end up through this code path");
    }
}
