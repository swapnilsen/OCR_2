package com.facebook.ads.internal.p021m;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.Set;

/* renamed from: com.facebook.ads.internal.m.i */
public class C0694i {
    public static String m2260a(Set<String> set, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String append : set) {
            stringBuilder.append(append);
            stringBuilder.append(str);
        }
        return stringBuilder.length() > 0 ? stringBuilder.substring(0, stringBuilder.length() - 1) : FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING;
    }
}
