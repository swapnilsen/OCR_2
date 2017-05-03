package com.google.api.client.googleapis.p086b;

import com.google.api.client.http.HttpIOExceptionHandler;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpUnsuccessfulResponseHandler;
import com.google.api.client.p082b.Preconditions;
import java.util.logging.Level;
import java.util.logging.Logger;

/* renamed from: com.google.api.client.googleapis.b.d */
class MediaUploadErrorHandler implements HttpIOExceptionHandler, HttpUnsuccessfulResponseHandler {
    static final Logger f4264a;
    private final MediaHttpUploader f4265b;
    private final HttpIOExceptionHandler f4266c;
    private final HttpUnsuccessfulResponseHandler f4267d;

    static {
        f4264a = Logger.getLogger(MediaUploadErrorHandler.class.getName());
    }

    public MediaUploadErrorHandler(MediaHttpUploader mediaHttpUploader, HttpRequest httpRequest) {
        this.f4265b = (MediaHttpUploader) Preconditions.m4968a((Object) mediaHttpUploader);
        this.f4266c = httpRequest.getIOExceptionHandler();
        this.f4267d = httpRequest.getUnsuccessfulResponseHandler();
        httpRequest.setIOExceptionHandler(this);
        httpRequest.setUnsuccessfulResponseHandler(this);
    }

    public boolean handleIOException(HttpRequest httpRequest, boolean z) {
        boolean z2 = this.f4266c != null && this.f4266c.handleIOException(httpRequest, z);
        if (z2) {
            try {
                this.f4265b.m4992a();
            } catch (Throwable e) {
                f4264a.log(Level.WARNING, "exception thrown while calling server callback", e);
            }
        }
        return z2;
    }

    public boolean handleResponse(HttpRequest httpRequest, HttpResponse httpResponse, boolean z) {
        boolean z2 = this.f4267d != null && this.f4267d.handleResponse(httpRequest, httpResponse, z);
        if (z2 && z && httpResponse.getStatusCode() / 100 == 5) {
            try {
                this.f4265b.m4992a();
            } catch (Throwable e) {
                f4264a.log(Level.WARNING, "exception thrown while calling server callback", e);
            }
        }
        return z2;
    }
}
