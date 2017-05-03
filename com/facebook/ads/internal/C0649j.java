package com.facebook.ads.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.support.annotation.Nullable;
import com.facebook.ads.internal.p021m.C0712u;
import com.google.api.client.http.HttpStatusCodes;
import java.util.Iterator;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.internal.j */
public class C0649j {
    private static C0649j f1481a;
    private final SharedPreferences f1482b;

    public C0649j(Context context) {
        this.f1482b = context.getApplicationContext().getSharedPreferences("com.facebook.ads.FEATURE_CONFIG", 0);
    }

    public static boolean m2051a(Context context) {
        return VERSION.SDK_INT >= 14 && C0712u.m2310a("com.google.android.exoplayer2", "ExoPlayer") && C0649j.m2062l(context).m2067a("adnw_enable_exoplayer", false);
    }

    public static boolean m2052b(Context context) {
        return C0649j.m2062l(context).m2067a("adnw_block_lockscreen", false);
    }

    public static boolean m2053c(Context context) {
        return VERSION.SDK_INT >= 19 && C0649j.m2062l(context).m2067a("adnw_enable_iab", false);
    }

    public static boolean m2054d(Context context) {
        return C0649j.m2062l(context).m2067a("adnw_debug_logging", false);
    }

    public static long m2055e(Context context) {
        return C0649j.m2062l(context).m2064a("unified_logging_immediate_delay_ms", 500);
    }

    public static long m2056f(Context context) {
        return ((long) C0649j.m2062l(context).m2063a("unified_logging_dispatch_interval_seconds", (int) HttpStatusCodes.STATUS_CODE_MULTIPLE_CHOICES)) * 1000;
    }

    public static boolean m2057g(Context context) {
        return C0649j.m2062l(context).m2065a("video_and_endcard_autorotate", "autorotate_disabled").equals("autorotate_enabled");
    }

    public static int m2058h(Context context) {
        return C0649j.m2062l(context).m2063a("minimum_elapsed_time_after_impression", -1);
    }

    public static int m2059i(Context context) {
        return C0649j.m2062l(context).m2063a("ad_viewability_tap_margin", 0);
    }

    public static boolean m2060j(Context context) {
        return C0649j.m2062l(context).m2067a("visible_area_check_enabled", false);
    }

    public static int m2061k(Context context) {
        return C0649j.m2062l(context).m2063a("visible_area_percentage", 50);
    }

    private static C0649j m2062l(Context context) {
        if (f1481a == null) {
            synchronized (C0649j.class) {
                if (f1481a == null) {
                    f1481a = new C0649j(context);
                }
            }
        }
        return f1481a;
    }

    public int m2063a(String str, int i) {
        String string = this.f1482b.getString(str, String.valueOf(i));
        return (string == null || string.equals("null")) ? i : Integer.valueOf(string).intValue();
    }

    public long m2064a(String str, long j) {
        String string = this.f1482b.getString(str, String.valueOf(j));
        return (string == null || string.equals("null")) ? j : Long.valueOf(string).longValue();
    }

    @Nullable
    public String m2065a(String str, String str2) {
        String string = this.f1482b.getString(str, str2);
        return (string == null || string.equals("null")) ? str2 : string;
    }

    public void m2066a(@Nullable String str) {
        if (str != null && !str.isEmpty() && !str.equals("[]")) {
            Editor edit = this.f1482b.edit();
            JSONObject jSONObject = new JSONObject(str);
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str2 = (String) keys.next();
                edit.putString(str2, jSONObject.getString(str2));
            }
            edit.commit();
        }
    }

    public boolean m2067a(String str, boolean z) {
        String string = this.f1482b.getString(str, String.valueOf(z));
        return (string == null || string.equals("null")) ? z : Boolean.valueOf(string).booleanValue();
    }
}
