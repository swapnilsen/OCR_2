package com.google.api.client.http;

import com.google.api.client.p082b.ae;
import java.io.OutputStream;

public interface HttpEncoding {
    void encode(ae aeVar, OutputStream outputStream);

    String getName();
}
