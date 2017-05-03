package com.google.firebase.iid;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import com.google.firebase.iid.C1507h.C1506a;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.io.IOException;
import java.security.KeyPair;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.firebase.iid.d */
public class C1498d {
    static Map<String, C1498d> f4561a;
    static String f4562e;
    private static C1507h f4563f;
    private static C1504f f4564g;
    Context f4565b;
    KeyPair f4566c;
    String f4567d;

    static {
        f4561a = new HashMap();
    }

    protected C1498d(Context context, String str, Bundle bundle) {
        this.f4567d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING;
        this.f4565b = context.getApplicationContext();
        this.f4567d = str;
    }

    public static synchronized C1498d m5152a(Context context, Bundle bundle) {
        C1498d c1498d;
        synchronized (C1498d.class) {
            String string = bundle == null ? FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING : bundle.getString("subtype");
            String str = string == null ? FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING : string;
            Context applicationContext = context.getApplicationContext();
            if (f4563f == null) {
                f4563f = new C1507h(applicationContext);
                f4564g = new C1504f(applicationContext);
            }
            f4562e = Integer.toString(FirebaseInstanceId.m5098a(applicationContext));
            c1498d = (C1498d) f4561a.get(str);
            if (c1498d == null) {
                c1498d = new C1498d(applicationContext, str, bundle);
                f4561a.put(str, c1498d);
            }
        }
        return c1498d;
    }

    KeyPair m5153a() {
        if (this.f4566c == null) {
            this.f4566c = f4563f.m5216d(this.f4567d);
        }
        if (this.f4566c == null) {
            this.f4566c = f4563f.m5209a(this.f4567d);
        }
        return this.f4566c;
    }

    public void m5154a(String str, String str2, Bundle bundle) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            throw new IOException("MAIN_THREAD");
        }
        f4563f.m5212b(this.f4567d, str, str2);
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putString("delete", "1");
        m5158c(str, str2, bundle);
    }

    public String m5155b(String str, String str2, Bundle bundle) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            throw new IOException("MAIN_THREAD");
        }
        if (bundle == null) {
            bundle = new Bundle();
        }
        Object obj = 1;
        if (bundle.getString("ttl") != null || "jwt".equals(bundle.getString("type"))) {
            obj = null;
        } else {
            C1506a a = f4563f.m5208a(this.f4567d, str, str2);
            if (!(a == null || a.m5202b(f4562e))) {
                return a.f4598a;
            }
        }
        String c = m5158c(str, str2, bundle);
        if (c == null || r0 == null) {
            return c;
        }
        f4563f.m5210a(this.f4567d, str, str2, c, f4562e);
        return c;
    }

    public void m5156b() {
        f4563f.m5211b(this.f4567d);
        this.f4566c = null;
    }

    public C1507h m5157c() {
        return f4563f;
    }

    public String m5158c(String str, String str2, Bundle bundle) {
        if (str2 != null) {
            bundle.putString("scope", str2);
        }
        bundle.putString("sender", str);
        if (!FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING.equals(this.f4567d)) {
            str = this.f4567d;
        }
        bundle.putString("subtype", str);
        bundle.putString("X-subtype", str);
        return f4564g.m5185b(f4564g.m5179a(bundle, m5153a()));
    }

    public C1504f m5159d() {
        return f4564g;
    }
}
