package com.google.api.client.http;

public interface HttpIOExceptionHandler {
    boolean handleIOException(HttpRequest httpRequest, boolean z);
}
