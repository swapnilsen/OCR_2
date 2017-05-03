package com.facebook.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.ads.internal.p021m.C0667a;
import com.facebook.ads.internal.p021m.C0712u;
import com.facebook.ads.internal.p021m.C0712u.C0711a;
import com.facebook.ads.internal.p021m.ag;
import java.util.Collection;
import java.util.HashSet;
import java.util.UUID;

/* renamed from: com.facebook.ads.e */
public class C0441e {
    static volatile boolean f745a;
    private static final String f746b;
    private static final Collection<String> f747c;
    private static final Collection<String> f748d;
    private static String f749e;
    private static boolean f750f;
    private static boolean f751g;
    private static String f752h;
    private static boolean f753i;
    private static String f754j;

    static {
        f746b = C0441e.class.getSimpleName();
        f747c = new HashSet();
        f748d = new HashSet();
        f748d.add("sdk");
        f748d.add("google_sdk");
        f748d.add("vbox86p");
        f748d.add("vbox86tp");
        f745a = false;
    }

    public static String m1052a() {
        return f749e;
    }

    private static void m1053a(String str) {
        if (!f745a) {
            f745a = true;
            Log.d(f746b, "Test mode device hash: " + str);
            Log.d(f746b, "When testing your app with Facebook's ad units you must specify the device hashed ID to ensure the delivery of test ads, add the following code before loading an ad: AdSettings.addTestDevice(\"" + str + "\");");
        }
    }

    public static void m1054a(boolean z) {
        f753i = z;
    }

    public static boolean m1055a(Context context) {
        if (C0667a.f1562a || f748d.contains(Build.PRODUCT)) {
            return true;
        }
        if (f754j == null) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("FBAdPrefs", 0);
            f754j = sharedPreferences.getString("deviceIdHash", null);
            if (TextUtils.isEmpty(f754j)) {
                C0711a a = C0712u.m2294a(context.getContentResolver());
                if (!TextUtils.isEmpty(a.f1738b)) {
                    f754j = ag.m2150a(a.f1738b);
                } else if (TextUtils.isEmpty(a.f1737a)) {
                    f754j = ag.m2150a(UUID.randomUUID().toString());
                } else {
                    f754j = ag.m2150a(a.f1737a);
                }
                sharedPreferences.edit().putString("deviceIdHash", f754j).apply();
            }
        }
        if (f747c.contains(f754j)) {
            return true;
        }
        C0441e.m1053a(f754j);
        return false;
    }

    public static boolean m1056b() {
        return f750f;
    }

    public static boolean m1057c() {
        return f751g;
    }

    public static String m1058d() {
        return f752h;
    }

    public static boolean m1059e() {
        return f753i;
    }
}
