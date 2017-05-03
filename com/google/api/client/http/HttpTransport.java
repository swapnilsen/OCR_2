package com.google.api.client.http;

import java.util.Arrays;
import java.util.logging.Logger;

public abstract class HttpTransport {
    static final Logger f4399a;
    private static final String[] f4400b;

    protected abstract LowLevelHttpRequest m5025a(String str, String str2);

    static {
        f4399a = Logger.getLogger(HttpTransport.class.getName());
        f4400b = new String[]{HttpMethods.DELETE, HttpMethods.GET, HttpMethods.POST, HttpMethods.PUT};
        Arrays.sort(f4400b);
    }

    public final HttpRequestFactory createRequestFactory() {
        return createRequestFactory(null);
    }

    public final HttpRequestFactory createRequestFactory(HttpRequestInitializer httpRequestInitializer) {
        return new HttpRequestFactory(this, httpRequestInitializer);
    }

    HttpRequest m5024a() {
        return new HttpRequest(this, null);
    }

    public boolean supportsMethod(String str) {
        return Arrays.binarySearch(f4400b, str) >= 0;
    }

    public void shutdown() {
    }
}
