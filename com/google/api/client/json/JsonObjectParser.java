package com.google.api.client.json;

import com.google.api.client.p082b.ObjectParser;
import com.google.api.client.p082b.Preconditions;
import com.google.api.client.p082b.ab;
import java.io.InputStream;
import java.io.Reader;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class JsonObjectParser implements ObjectParser {
    private final JsonFactory f4459a;
    private final Set<String> f4460b;

    public static class Builder {
        final JsonFactory f4457a;
        Collection<String> f4458b;

        public Builder(JsonFactory jsonFactory) {
            this.f4458b = ab.m4849a();
            this.f4457a = (JsonFactory) Preconditions.m4968a((Object) jsonFactory);
        }

        public JsonObjectParser build() {
            return new JsonObjectParser(this);
        }

        public final JsonFactory getJsonFactory() {
            return this.f4457a;
        }

        public final Collection<String> getWrapperKeys() {
            return this.f4458b;
        }

        public Builder setWrapperKeys(Collection<String> collection) {
            this.f4458b = collection;
            return this;
        }
    }

    public JsonObjectParser(JsonFactory jsonFactory) {
        this(new Builder(jsonFactory));
    }

    protected JsonObjectParser(Builder builder) {
        this.f4459a = builder.f4457a;
        this.f4460b = new HashSet(builder.f4458b);
    }

    public <T> T parseAndClose(InputStream inputStream, Charset charset, Class<T> cls) {
        return parseAndClose(inputStream, charset, (Type) cls);
    }

    public Object parseAndClose(InputStream inputStream, Charset charset, Type type) {
        JsonParser createJsonParser = this.f4459a.createJsonParser(inputStream, charset);
        m5048a(createJsonParser);
        return createJsonParser.parse(type, true);
    }

    public <T> T parseAndClose(Reader reader, Class<T> cls) {
        return parseAndClose(reader, (Type) cls);
    }

    public Object parseAndClose(Reader reader, Type type) {
        JsonParser createJsonParser = this.f4459a.createJsonParser(reader);
        m5048a(createJsonParser);
        return createJsonParser.parse(type, true);
    }

    public final JsonFactory getJsonFactory() {
        return this.f4459a;
    }

    public Set<String> getWrapperKeys() {
        return Collections.unmodifiableSet(this.f4460b);
    }

    private void m5048a(JsonParser jsonParser) {
        boolean z = true;
        if (!this.f4460b.isEmpty()) {
            try {
                if (jsonParser.skipToKey(this.f4460b) == null || jsonParser.getCurrentToken() == JsonToken.END_OBJECT) {
                    z = false;
                }
                Preconditions.m4973a(z, "wrapper key(s) not found: %s", this.f4460b);
            } catch (Throwable th) {
                jsonParser.close();
            }
        }
    }
}
