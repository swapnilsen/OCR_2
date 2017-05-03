package com.google.api.client.googleapis;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* renamed from: com.google.api.client.googleapis.a */
public final class GoogleUtils {
    public static final Integer f4234a;
    public static final Integer f4235b;
    public static final Integer f4236c;
    public static final String f4237d;

    static {
        f4234a = Integer.valueOf(1);
        f4235b = Integer.valueOf(22);
        f4236c = Integer.valueOf(0);
        f4237d = (f4234a + "." + f4235b + "." + f4236c + FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING).toString();
    }
}
