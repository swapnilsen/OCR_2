package com.google.api.client.http;

import com.google.api.client.p082b.Charsets;
import com.google.api.client.p082b.IOUtils;
import com.google.api.client.p082b.Preconditions;
import com.google.api.client.p082b.af;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class HttpResponse {
    LowLevelHttpResponse f4383a;
    private InputStream f4384b;
    private final String f4385c;
    private final String f4386d;
    private final HttpMediaType f4387e;
    private final int f4388f;
    private final String f4389g;
    private final HttpRequest f4390h;
    private int f4391i;
    private boolean f4392j;
    private boolean f4393k;

    HttpResponse(HttpRequest httpRequest, LowLevelHttpResponse lowLevelHttpResponse) {
        StringBuilder stringBuilder;
        String statusLine;
        StringBuilder stringBuilder2;
        HttpMediaType httpMediaType = null;
        this.f4390h = httpRequest;
        this.f4391i = httpRequest.getContentLoggingLimit();
        this.f4392j = httpRequest.isLoggingEnabled();
        this.f4383a = lowLevelHttpResponse;
        this.f4385c = lowLevelHttpResponse.getContentEncoding();
        int statusCode = lowLevelHttpResponse.getStatusCode();
        if (statusCode < 0) {
            statusCode = 0;
        }
        this.f4388f = statusCode;
        String reasonPhrase = lowLevelHttpResponse.getReasonPhrase();
        this.f4389g = reasonPhrase;
        Logger logger = HttpTransport.f4399a;
        Object obj = (this.f4392j && logger.isLoggable(Level.CONFIG)) ? 1 : null;
        if (obj != null) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("-------------- RESPONSE --------------").append(af.f4124a);
            statusLine = lowLevelHttpResponse.getStatusLine();
            if (statusLine != null) {
                stringBuilder.append(statusLine);
            } else {
                stringBuilder.append(this.f4388f);
                if (reasonPhrase != null) {
                    stringBuilder.append(' ').append(reasonPhrase);
                }
            }
            stringBuilder.append(af.f4124a);
        } else {
            stringBuilder = null;
        }
        HttpHeaders responseHeaders = httpRequest.getResponseHeaders();
        if (obj != null) {
            stringBuilder2 = stringBuilder;
        } else {
            stringBuilder2 = null;
        }
        responseHeaders.fromHttpResponse(lowLevelHttpResponse, stringBuilder2);
        statusLine = lowLevelHttpResponse.getContentType();
        if (statusLine == null) {
            statusLine = httpRequest.getResponseHeaders().getContentType();
        }
        this.f4386d = statusLine;
        if (statusLine != null) {
            httpMediaType = new HttpMediaType(statusLine);
        }
        this.f4387e = httpMediaType;
        if (obj != null) {
            logger.config(stringBuilder.toString());
        }
    }

    public int getContentLoggingLimit() {
        return this.f4391i;
    }

    public HttpResponse setContentLoggingLimit(int i) {
        Preconditions.m4972a(i >= 0, (Object) "The content logging limit must be non-negative.");
        this.f4391i = i;
        return this;
    }

    public boolean isLoggingEnabled() {
        return this.f4392j;
    }

    public HttpResponse setLoggingEnabled(boolean z) {
        this.f4392j = z;
        return this;
    }

    public String getContentEncoding() {
        return this.f4385c;
    }

    public String getContentType() {
        return this.f4386d;
    }

    public HttpMediaType getMediaType() {
        return this.f4387e;
    }

    public HttpHeaders getHeaders() {
        return this.f4390h.getResponseHeaders();
    }

    public boolean isSuccessStatusCode() {
        return HttpStatusCodes.isSuccess(this.f4388f);
    }

    public int getStatusCode() {
        return this.f4388f;
    }

    public String getStatusMessage() {
        return this.f4389g;
    }

    public HttpTransport getTransport() {
        return this.f4390h.getTransport();
    }

    public HttpRequest getRequest() {
        return this.f4390h;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.io.InputStream getContent() {
        /*
        r6 = this;
        r0 = r6.f4393k;
        if (r0 != 0) goto L_0x003b;
    L_0x0004:
        r0 = r6.f4383a;
        r0 = r0.getContent();
        if (r0 == 0) goto L_0x0038;
    L_0x000c:
        r1 = r6.f4385c;	 Catch:{ EOFException -> 0x003e, all -> 0x0043 }
        if (r1 == 0) goto L_0x001e;
    L_0x0010:
        r2 = "gzip";
        r1 = r1.contains(r2);	 Catch:{ EOFException -> 0x003e, all -> 0x0043 }
        if (r1 == 0) goto L_0x001e;
    L_0x0018:
        r1 = new java.util.zip.GZIPInputStream;	 Catch:{ EOFException -> 0x003e, all -> 0x0043 }
        r1.<init>(r0);	 Catch:{ EOFException -> 0x003e, all -> 0x0043 }
        r0 = r1;
    L_0x001e:
        r2 = com.google.api.client.http.HttpTransport.f4399a;	 Catch:{ EOFException -> 0x003e, all -> 0x004b }
        r1 = r6.f4392j;	 Catch:{ EOFException -> 0x003e, all -> 0x004b }
        if (r1 == 0) goto L_0x0036;
    L_0x0024:
        r1 = java.util.logging.Level.CONFIG;	 Catch:{ EOFException -> 0x003e, all -> 0x004b }
        r1 = r2.isLoggable(r1);	 Catch:{ EOFException -> 0x003e, all -> 0x004b }
        if (r1 == 0) goto L_0x0036;
    L_0x002c:
        r1 = new com.google.api.client.b.s;	 Catch:{ EOFException -> 0x003e, all -> 0x004b }
        r3 = java.util.logging.Level.CONFIG;	 Catch:{ EOFException -> 0x003e, all -> 0x004b }
        r4 = r6.f4391i;	 Catch:{ EOFException -> 0x003e, all -> 0x004b }
        r1.<init>(r0, r2, r3, r4);	 Catch:{ EOFException -> 0x003e, all -> 0x004b }
        r0 = r1;
    L_0x0036:
        r6.f4384b = r0;	 Catch:{ EOFException -> 0x003e, all -> 0x004b }
    L_0x0038:
        r0 = 1;
        r6.f4393k = r0;
    L_0x003b:
        r0 = r6.f4384b;
        return r0;
    L_0x003e:
        r1 = move-exception;
        r0.close();
        goto L_0x0038;
    L_0x0043:
        r1 = move-exception;
        r5 = r1;
        r1 = r0;
        r0 = r5;
    L_0x0047:
        r1.close();
        throw r0;
    L_0x004b:
        r1 = move-exception;
        r5 = r1;
        r1 = r0;
        r0 = r5;
        goto L_0x0047;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.api.client.http.HttpResponse.getContent():java.io.InputStream");
    }

    public void download(OutputStream outputStream) {
        IOUtils.m4956a(getContent(), outputStream);
    }

    public void ignore() {
        InputStream content = getContent();
        if (content != null) {
            content.close();
        }
    }

    public void disconnect() {
        ignore();
        this.f4383a.disconnect();
    }

    public <T> T parseAs(Class<T> cls) {
        if (m5023a()) {
            return this.f4390h.getParser().parseAndClose(getContent(), getContentCharset(), (Class) cls);
        }
        return null;
    }

    private boolean m5023a() {
        int statusCode = getStatusCode();
        if (!getRequest().getRequestMethod().equals(HttpMethods.HEAD) && statusCode / 100 != 1 && statusCode != HttpStatusCodes.STATUS_CODE_NO_CONTENT && statusCode != HttpStatusCodes.STATUS_CODE_NOT_MODIFIED) {
            return true;
        }
        ignore();
        return false;
    }

    public Object parseAs(Type type) {
        if (m5023a()) {
            return this.f4390h.getParser().parseAndClose(getContent(), getContentCharset(), type);
        }
        return null;
    }

    public String parseAsString() {
        InputStream content = getContent();
        if (content == null) {
            return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING;
        }
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        IOUtils.m4956a(content, byteArrayOutputStream);
        return byteArrayOutputStream.toString(getContentCharset().name());
    }

    public Charset getContentCharset() {
        return (this.f4387e == null || this.f4387e.getCharsetParameter() == null) ? Charsets.f4140b : this.f4387e.getCharsetParameter();
    }
}
