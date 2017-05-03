package com.google.api.client.http.json;

import com.google.api.client.http.AbstractHttpContent;
import com.google.api.client.http.HttpMediaType;
import com.google.api.client.json.Json;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.JsonGenerator;
import com.google.api.client.p082b.Preconditions;
import java.io.OutputStream;

public class JsonHttpContent extends AbstractHttpContent {
    private final Object f4454a;
    private final JsonFactory f4455b;
    private String f4456c;

    public JsonHttpContent(JsonFactory jsonFactory, Object obj) {
        super(Json.MEDIA_TYPE);
        this.f4455b = (JsonFactory) Preconditions.m4968a((Object) jsonFactory);
        this.f4454a = Preconditions.m4968a(obj);
    }

    public void writeTo(OutputStream outputStream) {
        JsonGenerator createJsonGenerator = this.f4455b.createJsonGenerator(outputStream, m5003a());
        if (this.f4456c != null) {
            createJsonGenerator.writeStartObject();
            createJsonGenerator.writeFieldName(this.f4456c);
        }
        createJsonGenerator.serialize(this.f4454a);
        if (this.f4456c != null) {
            createJsonGenerator.writeEndObject();
        }
        createJsonGenerator.flush();
    }

    public JsonHttpContent setMediaType(HttpMediaType httpMediaType) {
        super.setMediaType(httpMediaType);
        return this;
    }

    public final Object getData() {
        return this.f4454a;
    }

    public final JsonFactory getJsonFactory() {
        return this.f4455b;
    }

    public final String getWrapperKey() {
        return this.f4456c;
    }

    public JsonHttpContent setWrapperKey(String str) {
        this.f4456c = str;
        return this;
    }
}
