package com.google.api.client.http;

import com.google.api.client.p082b.BackOff;
import com.google.api.client.p082b.BackOffUtils;
import com.google.api.client.p082b.Preconditions;
import com.google.api.client.p082b.ac;

public class HttpBackOffUnsuccessfulResponseHandler implements HttpUnsuccessfulResponseHandler {
    private final BackOff f4333a;
    private BackOffRequired f4334b;
    private ac f4335c;

    public interface BackOffRequired {
        public static final BackOffRequired ALWAYS;
        public static final BackOffRequired ON_SERVER_ERROR;

        /* renamed from: com.google.api.client.http.HttpBackOffUnsuccessfulResponseHandler.BackOffRequired.1 */
        static class C14751 implements BackOffRequired {
            C14751() {
            }

            public boolean isRequired(HttpResponse httpResponse) {
                return true;
            }
        }

        /* renamed from: com.google.api.client.http.HttpBackOffUnsuccessfulResponseHandler.BackOffRequired.2 */
        static class C14762 implements BackOffRequired {
            C14762() {
            }

            public boolean isRequired(HttpResponse httpResponse) {
                return httpResponse.getStatusCode() / 100 == 5;
            }
        }

        boolean isRequired(HttpResponse httpResponse);

        static {
            ALWAYS = new C14751();
            ON_SERVER_ERROR = new C14762();
        }
    }

    public HttpBackOffUnsuccessfulResponseHandler(BackOff backOff) {
        this.f4334b = BackOffRequired.ON_SERVER_ERROR;
        this.f4335c = ac.f4123a;
        this.f4333a = (BackOff) Preconditions.m4968a((Object) backOff);
    }

    public final BackOff getBackOff() {
        return this.f4333a;
    }

    public final BackOffRequired getBackOffRequired() {
        return this.f4334b;
    }

    public HttpBackOffUnsuccessfulResponseHandler setBackOffRequired(BackOffRequired backOffRequired) {
        this.f4334b = (BackOffRequired) Preconditions.m4968a((Object) backOffRequired);
        return this;
    }

    public final ac getSleeper() {
        return this.f4335c;
    }

    public HttpBackOffUnsuccessfulResponseHandler setSleeper(ac acVar) {
        this.f4335c = (ac) Preconditions.m4968a((Object) acVar);
        return this;
    }

    public final boolean handleResponse(HttpRequest httpRequest, HttpResponse httpResponse, boolean z) {
        boolean z2 = false;
        if (z && this.f4334b.isRequired(httpResponse)) {
            try {
                z2 = BackOffUtils.m4883a(this.f4335c, this.f4333a);
            } catch (InterruptedException e) {
            }
        }
        return z2;
    }
}
