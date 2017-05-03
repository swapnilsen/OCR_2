package com.google.api.client.googleapis.p087c;

import com.google.api.client.googleapis.MethodOverride;
import com.google.api.client.googleapis.p084a.BatchCallback;
import com.google.api.client.googleapis.p084a.BatchRequest;
import com.google.api.client.googleapis.p086b.MediaHttpDownloader;
import com.google.api.client.googleapis.p086b.MediaHttpUploader;
import com.google.api.client.http.EmptyContent;
import com.google.api.client.http.GZipEncoding;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpContent;
import com.google.api.client.http.HttpHeaders;
import com.google.api.client.http.HttpMethods;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpResponseException;
import com.google.api.client.http.HttpResponseInterceptor;
import com.google.api.client.http.UriTemplate;
import com.google.api.client.p082b.GenericData;
import com.google.api.client.p082b.Preconditions;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* renamed from: com.google.api.client.googleapis.c.b */
public abstract class AbstractGoogleClientRequest<T> extends GenericData {
    public static final String USER_AGENT_SUFFIX = "Google-API-Java-Client";
    private final AbstractGoogleClient f4287c;
    private final String f4288d;
    private final String f4289e;
    private final HttpContent f4290f;
    private HttpHeaders f4291g;
    private HttpHeaders f4292h;
    private int f4293i;
    private String f4294j;
    private boolean f4295k;
    private Class<T> f4296l;
    private MediaHttpUploader f4297m;
    private MediaHttpDownloader f4298n;

    /* renamed from: com.google.api.client.googleapis.c.b.1 */
    class AbstractGoogleClientRequest implements HttpResponseInterceptor {
        final /* synthetic */ HttpResponseInterceptor f4302a;
        final /* synthetic */ HttpRequest f4303b;
        final /* synthetic */ AbstractGoogleClientRequest f4304c;

        AbstractGoogleClientRequest(AbstractGoogleClientRequest abstractGoogleClientRequest, HttpResponseInterceptor httpResponseInterceptor, HttpRequest httpRequest) {
            this.f4304c = abstractGoogleClientRequest;
            this.f4302a = httpResponseInterceptor;
            this.f4303b = httpRequest;
        }

        public void interceptResponse(HttpResponse httpResponse) {
            if (this.f4302a != null) {
                this.f4302a.interceptResponse(httpResponse);
            }
            if (!httpResponse.isSuccessStatusCode() && this.f4303b.getThrowExceptionOnExecuteError()) {
                throw this.f4304c.m5000a(httpResponse);
            }
        }
    }

    protected AbstractGoogleClientRequest(AbstractGoogleClient abstractGoogleClient, String str, String str2, HttpContent httpContent, Class<T> cls) {
        this.f4291g = new HttpHeaders();
        this.f4293i = -1;
        this.f4296l = (Class) Preconditions.m4968a((Object) cls);
        this.f4287c = (AbstractGoogleClient) Preconditions.m4968a((Object) abstractGoogleClient);
        this.f4288d = (String) Preconditions.m4968a((Object) str);
        this.f4289e = (String) Preconditions.m4968a((Object) str2);
        this.f4290f = httpContent;
        String applicationName = abstractGoogleClient.getApplicationName();
        if (applicationName != null) {
            this.f4291g.setUserAgent(applicationName + " " + USER_AGENT_SUFFIX);
        } else {
            this.f4291g.setUserAgent(USER_AGENT_SUFFIX);
        }
    }

    public final boolean getDisableGZipContent() {
        return this.f4295k;
    }

    public AbstractGoogleClientRequest<T> setDisableGZipContent(boolean z) {
        this.f4295k = z;
        return this;
    }

    public final String getRequestMethod() {
        return this.f4288d;
    }

    public final String getUriTemplate() {
        return this.f4289e;
    }

    public final HttpContent getHttpContent() {
        return this.f4290f;
    }

    public AbstractGoogleClient getAbstractGoogleClient() {
        return this.f4287c;
    }

    public final HttpHeaders getRequestHeaders() {
        return this.f4291g;
    }

    public AbstractGoogleClientRequest<T> setRequestHeaders(HttpHeaders httpHeaders) {
        this.f4291g = httpHeaders;
        return this;
    }

    public final HttpHeaders getLastResponseHeaders() {
        return this.f4292h;
    }

    public final int getLastStatusCode() {
        return this.f4293i;
    }

    public final String getLastStatusMessage() {
        return this.f4294j;
    }

    public final Class<T> getResponseClass() {
        return this.f4296l;
    }

    public final MediaHttpUploader getMediaHttpUploader() {
        return this.f4297m;
    }

    public final MediaHttpDownloader getMediaHttpDownloader() {
        return this.f4298n;
    }

    public GenericUrl buildHttpRequestUrl() {
        return new GenericUrl(UriTemplate.expand(this.f4287c.getBaseUrl(), this.f4289e, this, true));
    }

    public HttpRequest buildHttpRequest() {
        return m4998a(false);
    }

    private HttpRequest m4998a(boolean z) {
        boolean z2 = false;
        Preconditions.m4971a(this.f4297m == null);
        if (!z || this.f4288d.equals(HttpMethods.GET)) {
            z2 = true;
        }
        Preconditions.m4971a(z2);
        HttpRequest buildRequest = getAbstractGoogleClient().getRequestFactory().buildRequest(z ? HttpMethods.HEAD : this.f4288d, buildHttpRequestUrl(), this.f4290f);
        new MethodOverride().intercept(buildRequest);
        buildRequest.setParser(getAbstractGoogleClient().getObjectParser());
        if (this.f4290f == null && (this.f4288d.equals(HttpMethods.POST) || this.f4288d.equals(HttpMethods.PUT) || this.f4288d.equals(HttpMethods.PATCH))) {
            buildRequest.setContent(new EmptyContent());
        }
        buildRequest.getHeaders().putAll(this.f4291g);
        if (!this.f4295k) {
            buildRequest.setEncoding(new GZipEncoding());
        }
        buildRequest.setResponseInterceptor(new AbstractGoogleClientRequest(this, buildRequest.getResponseInterceptor(), buildRequest));
        return buildRequest;
    }

    public HttpResponse executeUnparsed() {
        return m4999b(false);
    }

    private HttpResponse m4999b(boolean z) {
        HttpResponse execute;
        if (this.f4297m == null) {
            execute = m4998a(z).execute();
        } else {
            GenericUrl buildHttpRequestUrl = buildHttpRequestUrl();
            boolean throwExceptionOnExecuteError = getAbstractGoogleClient().getRequestFactory().buildRequest(this.f4288d, buildHttpRequestUrl, this.f4290f).getThrowExceptionOnExecuteError();
            execute = this.f4297m.m4989a(this.f4291g).m4990a(this.f4295k).m4991a(buildHttpRequestUrl);
            execute.getRequest().setParser(getAbstractGoogleClient().getObjectParser());
            if (throwExceptionOnExecuteError && !execute.isSuccessStatusCode()) {
                throw m5000a(execute);
            }
        }
        this.f4292h = execute.getHeaders();
        this.f4293i = execute.getStatusCode();
        this.f4294j = execute.getStatusMessage();
        return execute;
    }

    protected IOException m5000a(HttpResponse httpResponse) {
        return new HttpResponseException(httpResponse);
    }

    public T execute() {
        return executeUnparsed().parseAs(this.f4296l);
    }

    public InputStream executeAsInputStream() {
        return executeUnparsed().getContent();
    }

    public void executeAndDownloadTo(OutputStream outputStream) {
        executeUnparsed().download(outputStream);
    }

    public final <E> void queue(BatchRequest batchRequest, Class<E> cls, BatchCallback<T, E> batchCallback) {
        Preconditions.m4972a(this.f4297m == null, (Object) "Batching media requests is not supported");
        batchRequest.m4978a(buildHttpRequest(), getResponseClass(), cls, batchCallback);
    }

    public AbstractGoogleClientRequest<T> set(String str, Object obj) {
        return (AbstractGoogleClientRequest) super.set(str, obj);
    }
}
