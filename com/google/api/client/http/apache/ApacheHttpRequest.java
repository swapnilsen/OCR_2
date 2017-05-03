package com.google.api.client.http.apache;

import com.google.api.client.http.LowLevelHttpRequest;
import com.google.api.client.http.LowLevelHttpResponse;
import com.google.api.client.p082b.Preconditions;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

/* renamed from: com.google.api.client.http.apache.a */
final class ApacheHttpRequest extends LowLevelHttpRequest {
    private final HttpClient f4428a;
    private final HttpRequestBase f4429b;

    ApacheHttpRequest(HttpClient httpClient, HttpRequestBase httpRequestBase) {
        this.f4428a = httpClient;
        this.f4429b = httpRequestBase;
    }

    public void addHeader(String str, String str2) {
        this.f4429b.addHeader(str, str2);
    }

    public void setTimeout(int i, int i2) {
        HttpParams params = this.f4429b.getParams();
        ConnManagerParams.setTimeout(params, (long) i);
        HttpConnectionParams.setConnectionTimeout(params, i);
        HttpConnectionParams.setSoTimeout(params, i2);
    }

    public LowLevelHttpResponse execute() {
        if (getStreamingContent() != null) {
            Preconditions.m4973a(this.f4429b instanceof HttpEntityEnclosingRequest, "Apache HTTP client does not support %s requests with content.", this.f4429b.getRequestLine().getMethod());
            HttpEntity contentEntity = new ContentEntity(getContentLength(), getStreamingContent());
            contentEntity.setContentEncoding(getContentEncoding());
            contentEntity.setContentType(getContentType());
            ((HttpEntityEnclosingRequest) this.f4429b).setEntity(contentEntity);
        }
        return new ApacheHttpResponse(this.f4429b, this.f4428a.execute(this.f4429b));
    }
}
