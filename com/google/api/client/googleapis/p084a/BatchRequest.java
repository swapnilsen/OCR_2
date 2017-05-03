package com.google.api.client.googleapis.p084a;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.p082b.Preconditions;
import com.google.api.client.p082b.ac;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.google.api.client.googleapis.a.b */
public final class BatchRequest {
    List<BatchRequest<?, ?>> f4230a;
    private GenericUrl f4231b;
    private final HttpRequestFactory f4232c;
    private ac f4233d;

    /* renamed from: com.google.api.client.googleapis.a.b.a */
    static class BatchRequest<T, E> {
        final BatchCallback<T, E> f4226a;
        final Class<T> f4227b;
        final Class<E> f4228c;
        final HttpRequest f4229d;

        BatchRequest(BatchCallback<T, E> batchCallback, Class<T> cls, Class<E> cls2, HttpRequest httpRequest) {
            this.f4226a = batchCallback;
            this.f4227b = cls;
            this.f4228c = cls2;
            this.f4229d = httpRequest;
        }
    }

    public BatchRequest(HttpTransport httpTransport, HttpRequestInitializer httpRequestInitializer) {
        this.f4231b = new GenericUrl("https://www.googleapis.com/batch");
        this.f4230a = new ArrayList();
        this.f4233d = ac.f4123a;
        this.f4232c = httpRequestInitializer == null ? httpTransport.createRequestFactory() : httpTransport.createRequestFactory(httpRequestInitializer);
    }

    public BatchRequest m4977a(GenericUrl genericUrl) {
        this.f4231b = genericUrl;
        return this;
    }

    public <T, E> BatchRequest m4978a(HttpRequest httpRequest, Class<T> cls, Class<E> cls2, BatchCallback<T, E> batchCallback) {
        Preconditions.m4968a((Object) httpRequest);
        Preconditions.m4968a((Object) batchCallback);
        Preconditions.m4968a((Object) cls);
        Preconditions.m4968a((Object) cls2);
        this.f4230a.add(new BatchRequest(batchCallback, cls, cls2, httpRequest));
        return this;
    }
}
