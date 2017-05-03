package com.google.api.client.http;

import java.io.OutputStream;

public class EmptyContent implements HttpContent {
    public long getLength() {
        return 0;
    }

    public String getType() {
        return null;
    }

    public void writeTo(OutputStream outputStream) {
        outputStream.flush();
    }

    public boolean retrySupported() {
        return true;
    }
}
