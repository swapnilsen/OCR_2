package com.google.api.client.http.javanet;

import java.net.HttpURLConnection;
import java.net.URL;

public interface ConnectionFactory {
    HttpURLConnection openConnection(URL url);
}
