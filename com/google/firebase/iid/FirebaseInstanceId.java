package com.google.firebase.iid;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.support.annotation.Keep;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import android.support.v4.util.ArrayMap;
import android.support.v4.view.MotionEventCompat;
import android.support.v7.appcompat.C0268R;
import android.util.Base64;
import android.util.Log;
import com.google.firebase.C1488a;
import com.google.firebase.iid.C1507h.C1506a;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.io.IOException;
import java.security.KeyPair;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

public class FirebaseInstanceId {
    private static Map<String, FirebaseInstanceId> f4526a;
    private static C1499e f4527b;
    private final C1488a f4528c;
    private final C1498d f4529d;
    private final String f4530e;

    static {
        f4526a = new ArrayMap();
    }

    private FirebaseInstanceId(C1488a c1488a, C1498d c1498d) {
        this.f4528c = c1488a;
        this.f4529d = c1498d;
        this.f4530e = m5110b();
        if (this.f4530e == null) {
            throw new IllegalStateException("IID failing to initialize, FirebaseApp is missing project ID");
        }
        FirebaseInstanceIdService.m5129a(this.f4528c.m5080a(), this);
    }

    static int m5098a(Context context) {
        return m5099a(context, context.getPackageName());
    }

    static int m5099a(Context context, String str) {
        int i = 0;
        try {
            return context.getPackageManager().getPackageInfo(str, 0).versionCode;
        } catch (NameNotFoundException e) {
            String valueOf = String.valueOf(e);
            Log.w("FirebaseInstanceId", new StringBuilder(String.valueOf(valueOf).length() + 23).append("Failed to find package ").append(valueOf).toString());
            return i;
        }
    }

    public static FirebaseInstanceId m5100a() {
        return getInstance(C1488a.m5076d());
    }

    static String m5101a(KeyPair keyPair) {
        try {
            byte[] digest = MessageDigest.getInstance("SHA1").digest(keyPair.getPublic().getEncoded());
            digest[0] = (byte) (((digest[0] & 15) + C0268R.styleable.AppCompatTheme_spinnerStyle) & MotionEventCompat.ACTION_MASK);
            return Base64.encodeToString(digest, 0, 8, 11);
        } catch (NoSuchAlgorithmException e) {
            Log.w("FirebaseInstanceId", "Unexpected error, device missing required alghorithms");
            return null;
        }
    }

    static String m5102a(byte[] bArr) {
        return Base64.encodeToString(bArr, 11);
    }

    static void m5103a(Context context, C1507h c1507h) {
        c1507h.m5214c();
        Intent intent = new Intent();
        intent.putExtra("CMD", "RST");
        C1505g.m5191a().m5197a(context, intent);
    }

    private void m5104a(Bundle bundle) {
        bundle.putString("gmp_app_id", this.f4528c.m5082c().m5086b());
    }

    static String m5105b(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (NameNotFoundException e) {
            String valueOf = String.valueOf(e);
            Log.w("FirebaseInstanceId", new StringBuilder(String.valueOf(valueOf).length() + 38).append("Never happens: can't find own package ").append(valueOf).toString());
            return null;
        }
    }

    static void m5106c(Context context) {
        Intent intent = new Intent();
        intent.putExtra("CMD", "SYNC");
        C1505g.m5191a().m5197a(context, intent);
    }

    @Keep
    public static synchronized FirebaseInstanceId getInstance(@NonNull C1488a c1488a) {
        FirebaseInstanceId firebaseInstanceId;
        synchronized (FirebaseInstanceId.class) {
            firebaseInstanceId = (FirebaseInstanceId) f4526a.get(c1488a.m5082c().m5086b());
            if (firebaseInstanceId == null) {
                C1498d a = C1498d.m5152a(c1488a.m5080a(), null);
                if (f4527b == null) {
                    f4527b = new C1499e(a.m5157c());
                }
                firebaseInstanceId = new FirebaseInstanceId(c1488a, a);
                f4526a.put(c1488a.m5082c().m5086b(), firebaseInstanceId);
            }
        }
        return firebaseInstanceId;
    }

    @WorkerThread
    public String m5107a(String str, String str2) {
        Bundle bundle = new Bundle();
        m5104a(bundle);
        return this.f4529d.m5155b(str, str2, bundle);
    }

    public String m5108a(String str, String str2, Bundle bundle) {
        m5104a(bundle);
        return this.f4529d.m5158c(str, str2, bundle);
    }

    public void m5109a(String str) {
        f4527b.m5161a(str);
        FirebaseInstanceIdService.m5128a(this.f4528c.m5080a());
    }

    String m5110b() {
        String c = this.f4528c.m5082c().m5087c();
        if (c != null) {
            return c;
        }
        c = this.f4528c.m5082c().m5086b();
        if (!c.startsWith("1:")) {
            return c;
        }
        String[] split = c.split(":");
        if (split.length < 2) {
            return null;
        }
        c = split[1];
        return c.isEmpty() ? null : c;
    }

    void m5111b(String str) {
        C1506a e = m5115e();
        if (e == null || e.m5202b(C1498d.f4562e)) {
            throw new IOException("token not available");
        }
        Bundle bundle = new Bundle();
        String str2 = "gcm.topic";
        String valueOf = String.valueOf("/topics/");
        String valueOf2 = String.valueOf(str);
        bundle.putString(str2, valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf));
        String str3 = e.f4598a;
        str2 = String.valueOf("/topics/");
        valueOf2 = String.valueOf(str);
        m5108a(str3, valueOf2.length() != 0 ? str2.concat(valueOf2) : new String(str2), bundle);
    }

    public String m5112c() {
        return m5101a(this.f4529d.m5153a());
    }

    void m5113c(String str) {
        C1506a e = m5115e();
        if (e == null || e.m5202b(C1498d.f4562e)) {
            throw new IOException("token not available");
        }
        Bundle bundle = new Bundle();
        String str2 = "gcm.topic";
        String valueOf = String.valueOf("/topics/");
        String valueOf2 = String.valueOf(str);
        bundle.putString(str2, valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf));
        C1498d c1498d = this.f4529d;
        String str3 = e.f4598a;
        valueOf = String.valueOf("/topics/");
        valueOf2 = String.valueOf(str);
        c1498d.m5154a(str3, valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf), bundle);
    }

    @Nullable
    public String m5114d() {
        C1506a e = m5115e();
        if (e == null || e.m5202b(C1498d.f4562e)) {
            FirebaseInstanceIdService.m5128a(this.f4528c.m5080a());
        }
        return e != null ? e.f4598a : null;
    }

    @Nullable
    C1506a m5115e() {
        return this.f4529d.m5157c().m5208a(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING, this.f4530e, "*");
    }

    String m5116f() {
        return m5107a(this.f4530e, "*");
    }

    C1499e m5117g() {
        return f4527b;
    }
}
