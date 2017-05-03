package com.google.api.client.http;

import com.google.api.client.p082b.Preconditions;
import java.io.InputStream;

public final class InputStreamContent extends AbstractInputStreamContent {
    private long f4401a;
    private boolean f4402b;
    private final InputStream f4403c;

    public InputStreamContent(String str, InputStream inputStream) {
        super(str);
        this.f4401a = -1;
        this.f4403c = (InputStream) Preconditions.m4968a((Object) inputStream);
    }

    public long getLength() {
        return this.f4401a;
    }

    public boolean retrySupported() {
        return this.f4402b;
    }

    public InputStreamContent setRetrySupported(boolean z) {
        this.f4402b = z;
        return this;
    }

    public InputStream getInputStream() {
        return this.f4403c;
    }

    public InputStreamContent setType(String str) {
        return (InputStreamContent) super.setType(str);
    }

    public InputStreamContent setCloseInputStream(boolean z) {
        return (InputStreamContent) super.setCloseInputStream(z);
    }

    public InputStreamContent setLength(long j) {
        this.f4401a = j;
        return this;
    }
}
