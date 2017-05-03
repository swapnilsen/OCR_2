package com.google.api.client.googleapis.p087c;

/* renamed from: com.google.api.client.googleapis.c.c */
public class CommonGoogleClientRequestInitializer implements GoogleClientRequestInitializer {
    private final String f4300a;
    private final String f4301b;

    public CommonGoogleClientRequestInitializer() {
        this(null);
    }

    public CommonGoogleClientRequestInitializer(String str) {
        this(str, null);
    }

    public CommonGoogleClientRequestInitializer(String str, String str2) {
        this.f4300a = str;
        this.f4301b = str2;
    }

    public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) {
        if (this.f4300a != null) {
            abstractGoogleClientRequest.put("key", (Object) this.f4300a);
        }
        if (this.f4301b != null) {
            abstractGoogleClientRequest.put("userIp", (Object) this.f4301b);
        }
    }

    public final String getKey() {
        return this.f4300a;
    }

    public final String getUserIp() {
        return this.f4301b;
    }
}
