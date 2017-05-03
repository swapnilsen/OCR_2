package com.google.api.services.vision.v1;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class VisionScopes {
    public static final String CLOUD_PLATFORM = "https://www.googleapis.com/auth/cloud-platform";

    public static Set<String> all() {
        Set hashSet = new HashSet();
        hashSet.add(CLOUD_PLATFORM);
        return Collections.unmodifiableSet(hashSet);
    }

    private VisionScopes() {
    }
}
