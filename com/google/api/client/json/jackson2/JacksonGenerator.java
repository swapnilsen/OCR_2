package com.google.api.client.json.jackson2;

import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.JsonGenerator;
import java.math.BigDecimal;
import java.math.BigInteger;

/* renamed from: com.google.api.client.json.jackson2.a */
final class JacksonGenerator extends JsonGenerator {
    private final com.p013a.p014a.p015a.JsonGenerator f4479a;
    private final JacksonFactory f4480b;

    public /* synthetic */ JsonFactory getFactory() {
        return m5058a();
    }

    public JacksonFactory m5058a() {
        return this.f4480b;
    }

    JacksonGenerator(JacksonFactory jacksonFactory, com.p013a.p014a.p015a.JsonGenerator jsonGenerator) {
        this.f4480b = jacksonFactory;
        this.f4479a = jsonGenerator;
    }

    public void flush() {
        this.f4479a.flush();
    }

    public void close() {
        this.f4479a.close();
    }

    public void writeBoolean(boolean z) {
        this.f4479a.m461a(z);
    }

    public void writeEndArray() {
        this.f4479a.m469d();
    }

    public void writeEndObject() {
        this.f4479a.m472f();
    }

    public void writeFieldName(String str) {
        this.f4479a.m458a(str);
    }

    public void writeNull() {
        this.f4479a.m473g();
    }

    public void writeNumber(int i) {
        this.f4479a.m464b(i);
    }

    public void writeNumber(long j) {
        this.f4479a.m457a(j);
    }

    public void writeNumber(BigInteger bigInteger) {
        this.f4479a.m460a(bigInteger);
    }

    public void writeNumber(double d) {
        this.f4479a.m455a(d);
    }

    public void writeNumber(float f) {
        this.f4479a.m456a(f);
    }

    public void writeNumber(BigDecimal bigDecimal) {
        this.f4479a.m459a(bigDecimal);
    }

    public void writeNumber(String str) {
        this.f4479a.m470d(str);
    }

    public void writeStartArray() {
        this.f4479a.m467c();
    }

    public void writeStartObject() {
        this.f4479a.m471e();
    }

    public void writeString(String str) {
        this.f4479a.m466b(str);
    }

    public void enablePrettyPrint() {
        this.f4479a.m463b();
    }
}
