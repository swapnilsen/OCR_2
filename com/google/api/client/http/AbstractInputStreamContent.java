package com.google.api.client.http;

import com.google.api.client.p082b.IOUtils;
import java.io.InputStream;
import java.io.OutputStream;

public abstract class AbstractInputStreamContent implements HttpContent {
    private String f4313a;
    private boolean f4314b;

    public abstract InputStream getInputStream();

    public AbstractInputStreamContent(String str) {
        this.f4314b = true;
        setType(str);
    }

    public void writeTo(OutputStream outputStream) {
        IOUtils.m4957a(getInputStream(), outputStream, this.f4314b);
        outputStream.flush();
    }

    public String getType() {
        return this.f4313a;
    }

    public final boolean getCloseInputStream() {
        return this.f4314b;
    }

    public AbstractInputStreamContent setType(String str) {
        this.f4313a = str;
        return this;
    }

    public AbstractInputStreamContent setCloseInputStream(boolean z) {
        this.f4314b = z;
        return this;
    }
}
