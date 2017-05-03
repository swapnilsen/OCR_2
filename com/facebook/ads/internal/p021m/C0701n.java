package com.facebook.ads.internal.p021m;

import android.app.Activity;
import android.app.KeyguardManager;
import android.content.Context;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.util.Log;
import android.view.Window;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.facebook.ads.internal.m.n */
public class C0701n {
    private static final String f1708a;

    static {
        f1708a = C0701n.class.getSimpleName();
    }

    private C0701n() {
    }

    public static Map<String, String> m2268a(Context context) {
        Map<String, String> hashMap = new HashMap();
        try {
            hashMap.put("kgr", String.valueOf(C0701n.m2270b(context)));
            if (context == null || !(context instanceof Activity)) {
                Log.v(f1708a, "Invalid Activity context in window interactive check, assuming interactive.");
                return hashMap;
            }
            Window window = ((Activity) context).getWindow();
            if (window != null) {
                int i = window.getAttributes().flags;
                hashMap.put("wt", Integer.toString(window.getAttributes().type));
                hashMap.put("wfdkg", (AccessibilityEventCompat.TYPE_WINDOWS_CHANGED & i) > 0 ? "1" : "0");
                hashMap.put("wfswl", (AccessibilityNodeInfoCompat.ACTION_COLLAPSE & i) > 0 ? "1" : "0");
            } else {
                Log.v(f1708a, "Invalid window in window interactive check, assuming interactive.");
            }
            return hashMap;
        } catch (Exception e) {
            Log.e(f1708a, "Exception in window info check", e);
            ab.m2132a(e, context);
        }
    }

    public static boolean m2269a(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            Log.v(f1708a, "Invalid Window info in window interactive check, assuming not obstructed by Keyguard.");
            return false;
        }
        String str = (String) map.get("wfdkg");
        String str2 = (String) map.get("wfswl");
        if (str != null && str.equals("1")) {
            return false;
        }
        if (str2 != null && str2.equals("1")) {
            return false;
        }
        str = (String) map.get("kgr");
        boolean z = str != null && str.equals("true");
        return z;
    }

    public static boolean m2270b(Context context) {
        KeyguardManager keyguardManager = (KeyguardManager) context.getSystemService("keyguard");
        return keyguardManager != null && keyguardManager.inKeyguardRestrictedInputMode();
    }

    public static boolean m2271b(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            Log.v(f1708a, "Invalid Window info in window interactive check, assuming is not a Lockscreen.");
            return false;
        }
        String str = (String) map.get("wfdkg");
        String str2 = (String) map.get("wfswl");
        String str3 = (String) map.get("kgr");
        return str != null && str.equals("1") && str2 != null && str2.equals("1") && str3 != null && str3.equals("true");
    }

    public static boolean m2272c(Context context) {
        return !C0701n.m2269a(C0701n.m2268a(context));
    }
}
