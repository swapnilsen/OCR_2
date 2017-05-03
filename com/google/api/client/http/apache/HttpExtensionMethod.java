package com.google.api.client.http.apache;

import com.google.api.client.p082b.Preconditions;
import java.net.URI;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;

/* renamed from: com.google.api.client.http.apache.d */
final class HttpExtensionMethod extends HttpEntityEnclosingRequestBase {
    private final String f4435a;

    public HttpExtensionMethod(String str, String str2) {
        this.f4435a = (String) Preconditions.m4968a((Object) str);
        setURI(URI.create(str2));
    }

    public String getMethod() {
        return this.f4435a;
    }
}
