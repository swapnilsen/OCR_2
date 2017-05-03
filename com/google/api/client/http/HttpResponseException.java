package com.google.api.client.http;

import com.google.api.client.p082b.Preconditions;
import com.google.api.client.p082b.af;
import java.io.IOException;

public class HttpResponseException extends IOException {
    private final int f4306a;
    private final String f4307b;
    private final transient HttpHeaders f4308c;
    private final String f4309d;

    public static class Builder {
        int f4394a;
        String f4395b;
        HttpHeaders f4396c;
        String f4397d;
        String f4398e;

        public Builder(int i, String str, HttpHeaders httpHeaders) {
            setStatusCode(i);
            setStatusMessage(str);
            setHeaders(httpHeaders);
        }

        public Builder(HttpResponse httpResponse) {
            this(httpResponse.getStatusCode(), httpResponse.getStatusMessage(), httpResponse.getHeaders());
            try {
                this.f4397d = httpResponse.parseAsString();
                if (this.f4397d.length() == 0) {
                    this.f4397d = null;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            StringBuilder computeMessageBuffer = HttpResponseException.computeMessageBuffer(httpResponse);
            if (this.f4397d != null) {
                computeMessageBuffer.append(af.f4124a).append(this.f4397d);
            }
            this.f4398e = computeMessageBuffer.toString();
        }

        public final String getMessage() {
            return this.f4398e;
        }

        public Builder setMessage(String str) {
            this.f4398e = str;
            return this;
        }

        public final int getStatusCode() {
            return this.f4394a;
        }

        public Builder setStatusCode(int i) {
            Preconditions.m4971a(i >= 0);
            this.f4394a = i;
            return this;
        }

        public final String getStatusMessage() {
            return this.f4395b;
        }

        public Builder setStatusMessage(String str) {
            this.f4395b = str;
            return this;
        }

        public HttpHeaders getHeaders() {
            return this.f4396c;
        }

        public Builder setHeaders(HttpHeaders httpHeaders) {
            this.f4396c = (HttpHeaders) Preconditions.m4968a((Object) httpHeaders);
            return this;
        }

        public final String getContent() {
            return this.f4397d;
        }

        public Builder setContent(String str) {
            this.f4397d = str;
            return this;
        }

        public HttpResponseException build() {
            return new HttpResponseException(this);
        }
    }

    public HttpResponseException(HttpResponse httpResponse) {
        this(new Builder(httpResponse));
    }

    protected HttpResponseException(Builder builder) {
        super(builder.f4398e);
        this.f4306a = builder.f4394a;
        this.f4307b = builder.f4395b;
        this.f4308c = builder.f4396c;
        this.f4309d = builder.f4397d;
    }

    public final boolean isSuccessStatusCode() {
        return HttpStatusCodes.isSuccess(this.f4306a);
    }

    public final int getStatusCode() {
        return this.f4306a;
    }

    public final String getStatusMessage() {
        return this.f4307b;
    }

    public HttpHeaders getHeaders() {
        return this.f4308c;
    }

    public final String getContent() {
        return this.f4309d;
    }

    public static StringBuilder computeMessageBuffer(HttpResponse httpResponse) {
        StringBuilder stringBuilder = new StringBuilder();
        int statusCode = httpResponse.getStatusCode();
        if (statusCode != 0) {
            stringBuilder.append(statusCode);
        }
        String statusMessage = httpResponse.getStatusMessage();
        if (statusMessage != null) {
            if (statusCode != 0) {
                stringBuilder.append(' ');
            }
            stringBuilder.append(statusMessage);
        }
        return stringBuilder;
    }
}
