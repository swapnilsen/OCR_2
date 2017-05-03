package com.facebook.ads.internal.p033j.p035b.p036a;

import android.text.TextUtils;
import com.facebook.ads.internal.p033j.p035b.C0647m;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* renamed from: com.facebook.ads.internal.j.b.a.f */
public class C0624f implements C0618c {
    private String m1963b(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        return (lastIndexOf == -1 || lastIndexOf <= str.lastIndexOf(47) || (lastIndexOf + 2) + 4 <= str.length()) ? FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING : str.substring(lastIndexOf + 1, str.length());
    }

    public String m1964a(String str) {
        Object b = m1963b(str);
        String d = C0647m.m2047d(str);
        return TextUtils.isEmpty(b) ? d : d + "." + b;
    }
}
