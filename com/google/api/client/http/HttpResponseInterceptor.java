package com.google.api.client.http;

public interface HttpResponseInterceptor {
    void interceptResponse(HttpResponse httpResponse);
}
