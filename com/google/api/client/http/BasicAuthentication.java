package com.google.api.client.http;

import com.google.api.client.p082b.Preconditions;

public final class BasicAuthentication implements HttpExecuteInterceptor, HttpRequestInitializer {
    private final String f4315a;
    private final String f4316b;

    public BasicAuthentication(String str, String str2) {
        this.f4315a = (String) Preconditions.m4968a((Object) str);
        this.f4316b = (String) Preconditions.m4968a((Object) str2);
    }

    public void initialize(HttpRequest httpRequest) {
        httpRequest.setInterceptor(this);
    }

    public void intercept(HttpRequest httpRequest) {
        httpRequest.getHeaders().setBasicAuthentication(this.f4315a, this.f4316b);
    }

    public String getUsername() {
        return this.f4315a;
    }

    public String getPassword() {
        return this.f4316b;
    }
}
