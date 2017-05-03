package com.google.api.client.json;

import com.google.api.client.p082b.Charsets;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.Charset;

public abstract class JsonFactory {
    public abstract JsonGenerator createJsonGenerator(OutputStream outputStream, Charset charset);

    public abstract JsonGenerator createJsonGenerator(Writer writer);

    public abstract JsonParser createJsonParser(InputStream inputStream);

    public abstract JsonParser createJsonParser(InputStream inputStream, Charset charset);

    public abstract JsonParser createJsonParser(Reader reader);

    public abstract JsonParser createJsonParser(String str);

    public final JsonObjectParser createJsonObjectParser() {
        return new JsonObjectParser(this);
    }

    public final String toString(Object obj) {
        return m5045a(obj, false);
    }

    public final String toPrettyString(Object obj) {
        return m5045a(obj, true);
    }

    public final byte[] toByteArray(Object obj) {
        return m5046b(obj, false).toByteArray();
    }

    private String m5045a(Object obj, boolean z) {
        return m5046b(obj, z).toString("UTF-8");
    }

    private ByteArrayOutputStream m5046b(Object obj, boolean z) {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        JsonGenerator createJsonGenerator = createJsonGenerator(byteArrayOutputStream, Charsets.f4139a);
        if (z) {
            createJsonGenerator.enablePrettyPrint();
        }
        createJsonGenerator.serialize(obj);
        createJsonGenerator.flush();
        return byteArrayOutputStream;
    }

    public final <T> T fromString(String str, Class<T> cls) {
        return createJsonParser(str).parse((Class) cls);
    }

    public final <T> T fromInputStream(InputStream inputStream, Class<T> cls) {
        return createJsonParser(inputStream).parseAndClose((Class) cls);
    }

    public final <T> T fromInputStream(InputStream inputStream, Charset charset, Class<T> cls) {
        return createJsonParser(inputStream, charset).parseAndClose((Class) cls);
    }

    public final <T> T fromReader(Reader reader, Class<T> cls) {
        return createJsonParser(reader).parseAndClose((Class) cls);
    }
}
