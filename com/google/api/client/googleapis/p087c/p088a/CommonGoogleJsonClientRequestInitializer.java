package com.google.api.client.googleapis.p087c.p088a;

import com.google.api.client.googleapis.p087c.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.p087c.CommonGoogleClientRequestInitializer;

/* renamed from: com.google.api.client.googleapis.c.a.c */
public class CommonGoogleJsonClientRequestInitializer extends CommonGoogleClientRequestInitializer {
    public CommonGoogleJsonClientRequestInitializer(String str) {
        super(str);
    }

    public CommonGoogleJsonClientRequestInitializer(String str, String str2) {
        super(str, str2);
    }

    public final void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) {
        super.initialize(abstractGoogleClientRequest);
        initializeJsonRequest((AbstractGoogleJsonClientRequest) abstractGoogleClientRequest);
    }

    protected void initializeJsonRequest(AbstractGoogleJsonClientRequest<?> abstractGoogleJsonClientRequest) {
    }
}
