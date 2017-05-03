package com.google.api.client.http.apache;

import com.google.api.client.http.LowLevelHttpResponse;
import java.io.InputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpRequestBase;

/* renamed from: com.google.api.client.http.apache.b */
final class ApacheHttpResponse extends LowLevelHttpResponse {
    private final HttpRequestBase f4430a;
    private final HttpResponse f4431b;
    private final Header[] f4432c;

    ApacheHttpResponse(HttpRequestBase httpRequestBase, HttpResponse httpResponse) {
        this.f4430a = httpRequestBase;
        this.f4431b = httpResponse;
        this.f4432c = httpResponse.getAllHeaders();
    }

    public int getStatusCode() {
        StatusLine statusLine = this.f4431b.getStatusLine();
        return statusLine == null ? 0 : statusLine.getStatusCode();
    }

    public InputStream getContent() {
        HttpEntity entity = this.f4431b.getEntity();
        return entity == null ? null : entity.getContent();
    }

    public String getContentEncoding() {
        HttpEntity entity = this.f4431b.getEntity();
        if (entity != null) {
            Header contentEncoding = entity.getContentEncoding();
            if (contentEncoding != null) {
                return contentEncoding.getValue();
            }
        }
        return null;
    }

    public long getContentLength() {
        HttpEntity entity = this.f4431b.getEntity();
        return entity == null ? -1 : entity.getContentLength();
    }

    public String getContentType() {
        HttpEntity entity = this.f4431b.getEntity();
        if (entity != null) {
            Header contentType = entity.getContentType();
            if (contentType != null) {
                return contentType.getValue();
            }
        }
        return null;
    }

    public String getReasonPhrase() {
        StatusLine statusLine = this.f4431b.getStatusLine();
        return statusLine == null ? null : statusLine.getReasonPhrase();
    }

    public String getStatusLine() {
        StatusLine statusLine = this.f4431b.getStatusLine();
        return statusLine == null ? null : statusLine.toString();
    }

    public int getHeaderCount() {
        return this.f4432c.length;
    }

    public String getHeaderName(int i) {
        return this.f4432c[i].getName();
    }

    public String getHeaderValue(int i) {
        return this.f4432c[i].getValue();
    }

    public void disconnect() {
        this.f4430a.abort();
    }
}
