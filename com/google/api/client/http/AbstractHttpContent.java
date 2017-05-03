package com.google.api.client.http;

import com.google.api.client.p082b.Charsets;
import com.google.api.client.p082b.IOUtils;
import java.nio.charset.Charset;

public abstract class AbstractHttpContent implements HttpContent {
    private HttpMediaType f4311a;
    private long f4312b;

    protected AbstractHttpContent(String str) {
        this(str == null ? null : new HttpMediaType(str));
    }

    protected AbstractHttpContent(HttpMediaType httpMediaType) {
        this.f4312b = -1;
        this.f4311a = httpMediaType;
    }

    public long getLength() {
        if (this.f4312b == -1) {
            this.f4312b = m5004b();
        }
        return this.f4312b;
    }

    public final HttpMediaType getMediaType() {
        return this.f4311a;
    }

    public AbstractHttpContent setMediaType(HttpMediaType httpMediaType) {
        this.f4311a = httpMediaType;
        return this;
    }

    protected final Charset m5003a() {
        return (this.f4311a == null || this.f4311a.getCharsetParameter() == null) ? Charsets.f4139a : this.f4311a.getCharsetParameter();
    }

    public String getType() {
        return this.f4311a == null ? null : this.f4311a.build();
    }

    protected long m5004b() {
        return computeLength(this);
    }

    public boolean retrySupported() {
        return true;
    }

    public static long computeLength(HttpContent httpContent) {
        if (httpContent.retrySupported()) {
            return IOUtils.m4955a(httpContent);
        }
        return -1;
    }
}
