package com.google.api.client.googleapis.p087c.p088a;

import com.google.api.client.googleapis.json.GoogleJsonErrorContainer;
import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.client.googleapis.p084a.BatchRequest;
import com.google.api.client.googleapis.p084a.p085a.JsonBatchCallback;
import com.google.api.client.googleapis.p087c.AbstractGoogleClientRequest;
import com.google.api.client.http.HttpContent;
import com.google.api.client.http.HttpHeaders;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.json.JsonHttpContent;
import java.io.IOException;

/* renamed from: com.google.api.client.googleapis.c.a.b */
public abstract class AbstractGoogleJsonClientRequest<T> extends AbstractGoogleClientRequest<T> {
    private final Object f4299c;

    protected /* synthetic */ IOException m5001a(HttpResponse httpResponse) {
        return m5002b(httpResponse);
    }

    protected AbstractGoogleJsonClientRequest(AbstractGoogleJsonClient abstractGoogleJsonClient, String str, String str2, Object obj, Class<T> cls) {
        HttpContent httpContent;
        String str3 = null;
        if (obj == null) {
            httpContent = null;
        } else {
            JsonHttpContent jsonHttpContent = new JsonHttpContent(abstractGoogleJsonClient.getJsonFactory(), obj);
            if (!abstractGoogleJsonClient.getObjectParser().getWrapperKeys().isEmpty()) {
                str3 = "data";
            }
            httpContent = jsonHttpContent.setWrapperKey(str3);
        }
        super(abstractGoogleJsonClient, str, str2, httpContent, cls);
        this.f4299c = obj;
    }

    public AbstractGoogleJsonClient getAbstractGoogleClient() {
        return (AbstractGoogleJsonClient) super.getAbstractGoogleClient();
    }

    public AbstractGoogleJsonClientRequest<T> setDisableGZipContent(boolean z) {
        return (AbstractGoogleJsonClientRequest) super.setDisableGZipContent(z);
    }

    public AbstractGoogleJsonClientRequest<T> setRequestHeaders(HttpHeaders httpHeaders) {
        return (AbstractGoogleJsonClientRequest) super.setRequestHeaders(httpHeaders);
    }

    public final void queue(BatchRequest batchRequest, JsonBatchCallback<T> jsonBatchCallback) {
        super.queue(batchRequest, GoogleJsonErrorContainer.class, jsonBatchCallback);
    }

    protected GoogleJsonResponseException m5002b(HttpResponse httpResponse) {
        return GoogleJsonResponseException.from(getAbstractGoogleClient().getJsonFactory(), httpResponse);
    }

    public Object getJsonContent() {
        return this.f4299c;
    }

    public AbstractGoogleJsonClientRequest<T> set(String str, Object obj) {
        return (AbstractGoogleJsonClientRequest) super.set(str, obj);
    }
}
