package com.google.api.client.googleapis;

import android.support.v7.widget.RecyclerView.ItemAnimator;
import com.google.api.client.http.EmptyContent;
import com.google.api.client.http.HttpExecuteInterceptor;
import com.google.api.client.http.HttpMethods;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.UrlEncodedContent;

/* renamed from: com.google.api.client.googleapis.b */
public final class MethodOverride implements HttpExecuteInterceptor, HttpRequestInitializer {
    private final boolean f4268a;

    public MethodOverride() {
        this(false);
    }

    MethodOverride(boolean z) {
        this.f4268a = z;
    }

    public void initialize(HttpRequest httpRequest) {
        httpRequest.setInterceptor(this);
    }

    public void intercept(HttpRequest httpRequest) {
        if (m4994a(httpRequest)) {
            Object requestMethod = httpRequest.getRequestMethod();
            httpRequest.setRequestMethod(HttpMethods.POST);
            httpRequest.getHeaders().set("X-HTTP-Method-Override", requestMethod);
            if (requestMethod.equals(HttpMethods.GET)) {
                httpRequest.setContent(new UrlEncodedContent(httpRequest.getUrl().clone()));
                httpRequest.getUrl().clear();
            } else if (httpRequest.getContent() == null) {
                httpRequest.setContent(new EmptyContent());
            }
        }
    }

    private boolean m4994a(HttpRequest httpRequest) {
        String requestMethod = httpRequest.getRequestMethod();
        if (requestMethod.equals(HttpMethods.POST)) {
            return false;
        }
        if (requestMethod.equals(HttpMethods.GET)) {
            if (httpRequest.getUrl().build().length() > ItemAnimator.FLAG_MOVED) {
                return true;
            }
        } else if (this.f4268a) {
            return true;
        }
        if (httpRequest.getTransport().supportsMethod(requestMethod)) {
            return false;
        }
        return true;
    }
}
