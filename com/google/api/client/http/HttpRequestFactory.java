package com.google.api.client.http;

public final class HttpRequestFactory {
    private final HttpTransport f4381a;
    private final HttpRequestInitializer f4382b;

    HttpRequestFactory(HttpTransport httpTransport, HttpRequestInitializer httpRequestInitializer) {
        this.f4381a = httpTransport;
        this.f4382b = httpRequestInitializer;
    }

    public HttpTransport getTransport() {
        return this.f4381a;
    }

    public HttpRequestInitializer getInitializer() {
        return this.f4382b;
    }

    public HttpRequest buildRequest(String str, GenericUrl genericUrl, HttpContent httpContent) {
        HttpRequest a = this.f4381a.m5024a();
        if (this.f4382b != null) {
            this.f4382b.initialize(a);
        }
        a.setRequestMethod(str);
        if (genericUrl != null) {
            a.setUrl(genericUrl);
        }
        if (httpContent != null) {
            a.setContent(httpContent);
        }
        return a;
    }

    public HttpRequest buildDeleteRequest(GenericUrl genericUrl) {
        return buildRequest(HttpMethods.DELETE, genericUrl, null);
    }

    public HttpRequest buildGetRequest(GenericUrl genericUrl) {
        return buildRequest(HttpMethods.GET, genericUrl, null);
    }

    public HttpRequest buildPostRequest(GenericUrl genericUrl, HttpContent httpContent) {
        return buildRequest(HttpMethods.POST, genericUrl, httpContent);
    }

    public HttpRequest buildPutRequest(GenericUrl genericUrl, HttpContent httpContent) {
        return buildRequest(HttpMethods.PUT, genericUrl, httpContent);
    }

    public HttpRequest buildPatchRequest(GenericUrl genericUrl, HttpContent httpContent) {
        return buildRequest(HttpMethods.PATCH, genericUrl, httpContent);
    }

    public HttpRequest buildHeadRequest(GenericUrl genericUrl) {
        return buildRequest(HttpMethods.HEAD, genericUrl, null);
    }
}
