package com.google.api.client.http;

import com.google.api.client.p082b.Preconditions;
import com.google.api.client.p082b.ae;
import java.io.OutputStream;

public final class HttpEncodingStreamingContent implements ae {
    private final ae f4336a;
    private final HttpEncoding f4337b;

    public HttpEncodingStreamingContent(ae aeVar, HttpEncoding httpEncoding) {
        this.f4336a = (ae) Preconditions.m4968a((Object) aeVar);
        this.f4337b = (HttpEncoding) Preconditions.m4968a((Object) httpEncoding);
    }

    public void writeTo(OutputStream outputStream) {
        this.f4337b.encode(this.f4336a, outputStream);
    }

    public ae getContent() {
        return this.f4336a;
    }

    public HttpEncoding getEncoding() {
        return this.f4337b;
    }
}
