package com.facebook.ads.internal.p031g;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import com.facebook.ads.internal.C0592h;
import com.facebook.ads.internal.C0592h.C0569c;
import com.facebook.ads.internal.p021m.C0705p;
import com.facebook.ads.internal.p021m.C0706q;
import com.facebook.ads.internal.p021m.C0712u;
import com.facebook.ads.internal.p021m.C0712u.C0711a;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* renamed from: com.facebook.ads.internal.g.i */
public class C0564i {
    public static final String f1299a;
    public static String f1300b;
    public static String f1301c;
    public static String f1302d;
    public static String f1303e;
    public static String f1304f;
    public static int f1305g;
    public static String f1306h;
    public static String f1307i;
    public static int f1308j;
    public static String f1309k;
    public static int f1310l;
    public static String f1311m;
    public static String f1312n;
    public static String f1313o;
    public static boolean f1314p;
    public static String f1315q;
    private static boolean f1316r;

    static {
        f1316r = false;
        f1299a = VERSION.RELEASE;
        f1300b = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING;
        f1301c = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING;
        f1302d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING;
        f1303e = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING;
        f1304f = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING;
        f1305g = 0;
        f1306h = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING;
        f1307i = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING;
        f1308j = 0;
        f1309k = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING;
        f1310l = 0;
        f1311m = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING;
        f1312n = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING;
        f1313o = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING;
        f1314p = false;
        f1315q = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING;
    }

    public static synchronized void m1746a(Context context) {
        synchronized (C0564i.class) {
            if (!f1316r) {
                f1316r = true;
                C0564i.m1748c(context);
            }
            C0564i.m1749d(context);
        }
    }

    public static void m1747b(Context context) {
        if (f1316r) {
            try {
                C0711a a;
                C0592h a2;
                SharedPreferences sharedPreferences = context.getSharedPreferences("SDKIDFA", 0);
                if (sharedPreferences.contains("attributionId")) {
                    f1312n = sharedPreferences.getString("attributionId", FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING);
                }
                if (sharedPreferences.contains("advertisingId")) {
                    f1313o = sharedPreferences.getString("advertisingId", FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING);
                    f1314p = sharedPreferences.getBoolean("limitAdTracking", f1314p);
                    f1315q = C0569c.SHARED_PREFS.name();
                }
                try {
                    a = C0712u.m2294a(context.getContentResolver());
                } catch (Throwable e) {
                    C0706q.m2279a(C0705p.m2276a(e, "Error retrieving attribution id from fb4a"));
                    a = null;
                }
                if (a != null) {
                    String str = a.f1737a;
                    if (str != null) {
                        f1312n = str;
                    }
                }
                try {
                    a2 = C0592h.m1849a(context, a);
                } catch (Throwable e2) {
                    C0706q.m2279a(C0705p.m2276a(e2, "Error retrieving advertising id from Google Play Services"));
                    a2 = null;
                }
                if (a2 != null) {
                    String a3 = a2.m1852a();
                    Boolean valueOf = Boolean.valueOf(a2.m1853b());
                    if (a3 != null) {
                        f1313o = a3;
                        f1314p = valueOf.booleanValue();
                        f1315q = a2.m1854c().name();
                    }
                }
                Editor edit = sharedPreferences.edit();
                edit.putString("attributionId", f1312n);
                edit.putString("advertisingId", f1313o);
                edit.putBoolean("limitAdTracking", f1314p);
                edit.apply();
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    private static void m1748c(Context context) {
        String networkOperatorName;
        PackageManager packageManager = context.getPackageManager();
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
            f1302d = packageInfo.packageName;
            f1304f = packageInfo.versionName;
            f1305g = packageInfo.versionCode;
        } catch (NameNotFoundException e) {
        }
        try {
            if (f1302d != null && f1302d.length() >= 0) {
                String installerPackageName = packageManager.getInstallerPackageName(f1302d);
                if (installerPackageName != null && installerPackageName.length() > 0) {
                    f1306h = installerPackageName;
                }
            }
        } catch (Exception e2) {
        }
        try {
            CharSequence applicationLabel = packageManager.getApplicationLabel(packageManager.getApplicationInfo(context.getPackageName(), 0));
            if (applicationLabel != null && applicationLabel.length() > 0) {
                f1303e = applicationLabel.toString();
            }
        } catch (NameNotFoundException e3) {
        }
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager != null) {
            networkOperatorName = telephonyManager.getNetworkOperatorName();
            if (networkOperatorName != null && networkOperatorName.length() > 0) {
                f1307i = networkOperatorName;
            }
        }
        networkOperatorName = Build.MANUFACTURER;
        if (networkOperatorName != null && networkOperatorName.length() > 0) {
            f1300b = networkOperatorName;
        }
        networkOperatorName = Build.MODEL;
        if (networkOperatorName != null && networkOperatorName.length() > 0) {
            f1301c = Build.MODEL;
        }
    }

    private static void m1749d(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting()) {
                f1308j = activeNetworkInfo.getType();
                f1309k = activeNetworkInfo.getTypeName();
                f1310l = activeNetworkInfo.getSubtype();
                f1311m = activeNetworkInfo.getSubtypeName();
            }
        } catch (Exception e) {
        }
    }
}
