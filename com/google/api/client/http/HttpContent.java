package com.google.api.client.http;

import com.google.api.client.p082b.ae;
import java.io.OutputStream;

public interface HttpContent extends ae {
    long getLength();

    String getType();

    boolean retrySupported();

    void writeTo(OutputStream outputStream);
}
