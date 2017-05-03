package com.google.firebase.iid;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* renamed from: com.google.firebase.iid.e */
public class C1499e {
    private static final Object f4568a;
    private final C1507h f4569b;

    static {
        f4568a = new Object();
    }

    C1499e(C1507h c1507h) {
        this.f4569b = c1507h;
    }

    @Nullable
    String m5160a() {
        String str = null;
        synchronized (f4568a) {
            String string = this.f4569b.m5207a().getString("topic_operaion_queue", null);
            if (string != null) {
                String[] split = string.split(",");
                if (split.length > 1 && !TextUtils.isEmpty(split[1])) {
                    str = split[1];
                }
            }
        }
        return str;
    }

    void m5161a(String str) {
        synchronized (f4568a) {
            String string = this.f4569b.m5207a().getString("topic_operaion_queue", FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING);
            String valueOf = String.valueOf(",");
            this.f4569b.m5207a().edit().putString("topic_operaion_queue", new StringBuilder((String.valueOf(string).length() + String.valueOf(valueOf).length()) + String.valueOf(str).length()).append(string).append(valueOf).append(str).toString()).apply();
        }
    }

    boolean m5162b(String str) {
        boolean z;
        synchronized (f4568a) {
            String string = this.f4569b.m5207a().getString("topic_operaion_queue", FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING);
            String valueOf = String.valueOf(",");
            String valueOf2 = String.valueOf(str);
            if (string.startsWith(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf))) {
                valueOf = String.valueOf(",");
                valueOf2 = String.valueOf(str);
                this.f4569b.m5207a().edit().putString("topic_operaion_queue", string.substring((valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf)).length())).apply();
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }
}
