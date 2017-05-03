package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.HashMap;
import java.util.Map;

public class zzbf {
    private static String zzbGv;
    static Map<String, String> zzbGw;

    static {
        zzbGw = new HashMap();
    }

    static void zzN(Context context, String str) {
        zzdd.zzd(context, "gtm_install_referrer", "referrer", str);
        zzP(context, str);
    }

    public static String zzO(Context context, String str) {
        if (zzbGv == null) {
            synchronized (zzbf.class) {
                if (zzbGv == null) {
                    SharedPreferences sharedPreferences = context.getSharedPreferences("gtm_install_referrer", 0);
                    if (sharedPreferences != null) {
                        zzbGv = sharedPreferences.getString("referrer", FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING);
                    } else {
                        zzbGv = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING;
                    }
                }
            }
        }
        return zzaj(zzbGv, str);
    }

    public static void zzP(Context context, String str) {
        String zzaj = zzaj(str, "conv");
        if (zzaj != null && zzaj.length() > 0) {
            zzbGw.put(zzaj, str);
            zzdd.zzd(context, "gtm_click_referrers", zzaj, str);
        }
    }

    public static String zzaj(String str, String str2) {
        if (str2 == null) {
            return str.length() > 0 ? str : null;
        } else {
            String str3 = "http://hostname/?";
            String valueOf = String.valueOf(str);
            return Uri.parse(valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3)).getQueryParameter(str2);
        }
    }

    public static void zzhk(String str) {
        synchronized (zzbf.class) {
            zzbGv = str;
        }
    }

    public static String zzr(Context context, String str, String str2) {
        String str3 = (String) zzbGw.get(str);
        if (str3 == null) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("gtm_click_referrers", 0);
            str3 = sharedPreferences != null ? sharedPreferences.getString(str, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING) : FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING;
            zzbGw.put(str, str3);
        }
        return zzaj(str3, str2);
    }
}
