package com.google.api.services.vision.v1;

import com.google.api.client.googleapis.p087c.p088a.AbstractGoogleJsonClientRequest;
import com.google.api.client.googleapis.p087c.p088a.CommonGoogleJsonClientRequestInitializer;

public class VisionRequestInitializer extends CommonGoogleJsonClientRequestInitializer {
    public VisionRequestInitializer(String str) {
        super(str);
    }

    public VisionRequestInitializer(String str, String str2) {
        super(str, str2);
    }

    public final void initializeJsonRequest(AbstractGoogleJsonClientRequest<?> abstractGoogleJsonClientRequest) {
        super.initializeJsonRequest(abstractGoogleJsonClientRequest);
        m5062a((VisionRequest) abstractGoogleJsonClientRequest);
    }

    protected void m5062a(VisionRequest<?> visionRequest) {
    }
}
