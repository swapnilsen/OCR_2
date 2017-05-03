package com.google.api.client.p082b;

import java.io.InputStream;
import java.lang.reflect.Type;
import java.nio.charset.Charset;

/* renamed from: com.google.api.client.b.x */
public interface ObjectParser {
    <T> T parseAndClose(InputStream inputStream, Charset charset, Class<T> cls);

    Object parseAndClose(InputStream inputStream, Charset charset, Type type);
}
