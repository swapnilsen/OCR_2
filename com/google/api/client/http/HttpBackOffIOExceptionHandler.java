package com.google.api.client.http;

import com.google.api.client.p082b.BackOff;
import com.google.api.client.p082b.BackOffUtils;
import com.google.api.client.p082b.Preconditions;
import com.google.api.client.p082b.ac;

public class HttpBackOffIOExceptionHandler implements HttpIOExceptionHandler {
    private final BackOff f4331a;
    private ac f4332b;

    public HttpBackOffIOExceptionHandler(BackOff backOff) {
        this.f4332b = ac.f4123a;
        this.f4331a = (BackOff) Preconditions.m4968a((Object) backOff);
    }

    public final BackOff getBackOff() {
        return this.f4331a;
    }

    public final ac getSleeper() {
        return this.f4332b;
    }

    public HttpBackOffIOExceptionHandler setSleeper(ac acVar) {
        this.f4332b = (ac) Preconditions.m4968a((Object) acVar);
        return this;
    }

    public boolean handleIOException(HttpRequest httpRequest, boolean z) {
        boolean z2 = false;
        if (z) {
            try {
                z2 = BackOffUtils.m4883a(this.f4332b, this.f4331a);
            } catch (InterruptedException e) {
            }
        }
        return z2;
    }
}
