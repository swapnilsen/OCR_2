package com.google.api.client.json.jackson2;

import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.JsonParser;
import com.google.api.client.json.JsonToken;
import java.math.BigDecimal;
import java.math.BigInteger;

/* renamed from: com.google.api.client.json.jackson2.b */
final class JacksonParser extends JsonParser {
    private final com.p013a.p014a.p015a.JsonParser f4481a;
    private final JacksonFactory f4482b;

    public /* synthetic */ JsonFactory getFactory() {
        return m5059a();
    }

    public JacksonFactory m5059a() {
        return this.f4482b;
    }

    JacksonParser(JacksonFactory jacksonFactory, com.p013a.p014a.p015a.JsonParser jsonParser) {
        this.f4482b = jacksonFactory;
        this.f4481a = jsonParser;
    }

    public void close() {
        this.f4481a.close();
    }

    public JsonToken nextToken() {
        return JacksonFactory.m5057a(this.f4481a.m482a());
    }

    public String getCurrentName() {
        return this.f4481a.m486d();
    }

    public JsonToken getCurrentToken() {
        return JacksonFactory.m5057a(this.f4481a.m485c());
    }

    public JsonParser skipChildren() {
        this.f4481a.m484b();
        return this;
    }

    public String getText() {
        return this.f4481a.m488f();
    }

    public byte getByteValue() {
        return this.f4481a.m489g();
    }

    public float getFloatValue() {
        return this.f4481a.m494l();
    }

    public int getIntValue() {
        return this.f4481a.m491i();
    }

    public short getShortValue() {
        return this.f4481a.m490h();
    }

    public BigInteger getBigIntegerValue() {
        return this.f4481a.m493k();
    }

    public BigDecimal getDecimalValue() {
        return this.f4481a.m496n();
    }

    public double getDoubleValue() {
        return this.f4481a.m495m();
    }

    public long getLongValue() {
        return this.f4481a.m492j();
    }
}
