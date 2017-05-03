package com.google.api.client.http;

import com.google.api.client.p082b.ae;

public abstract class LowLevelHttpRequest {
    private long f4338a;
    private String f4339b;
    private String f4340c;
    private ae f4341d;

    public abstract void addHeader(String str, String str2);

    public abstract LowLevelHttpResponse execute();

    public LowLevelHttpRequest() {
        this.f4338a = -1;
    }

    public final void setContentLength(long j) {
        this.f4338a = j;
    }

    public final long getContentLength() {
        return this.f4338a;
    }

    public final void setContentEncoding(String str) {
        this.f4339b = str;
    }

    public final String getContentEncoding() {
        return this.f4339b;
    }

    public final void setContentType(String str) {
        this.f4340c = str;
    }

    public final String getContentType() {
        return this.f4340c;
    }

    public final void setStreamingContent(ae aeVar) {
        this.f4341d = aeVar;
    }

    public final ae getStreamingContent() {
        return this.f4341d;
    }

    public void setTimeout(int i, int i2) {
    }
}
