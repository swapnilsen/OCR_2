package com.google.api.client.http.javanet;

import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;

public class DefaultConnectionFactory implements ConnectionFactory {
    private final Proxy f4437a;

    public DefaultConnectionFactory() {
        this(null);
    }

    public DefaultConnectionFactory(Proxy proxy) {
        this.f4437a = proxy;
    }

    public HttpURLConnection openConnection(URL url) {
        return (HttpURLConnection) (this.f4437a == null ? url.openConnection() : url.openConnection(this.f4437a));
    }
}
