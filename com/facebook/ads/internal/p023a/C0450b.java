package com.facebook.ads.internal.p023a;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.Iterator;
import java.util.Map;
import net.nend.android.NendAdIconLayout;
import net.nend.android.NendIconError;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.internal.a.b */
public class C0450b {
    private static final String f781a;

    static {
        f781a = C0450b.class.getSimpleName();
    }

    public static C0449a m1111a(Context context, String str, Uri uri, Map<String, String> map) {
        String authority = uri.getAuthority();
        String queryParameter = uri.getQueryParameter("video_url");
        if (!TextUtils.isEmpty(uri.getQueryParameter("data"))) {
            try {
                JSONObject jSONObject = new JSONObject(uri.getQueryParameter("data"));
                Iterator keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String str2 = (String) keys.next();
                    map.put(str2, jSONObject.getString(str2));
                }
            } catch (Throwable e) {
                Log.w(f781a, "Unable to parse json data in AdActionFactory.", e);
            }
        }
        Object obj = -1;
        switch (authority.hashCode()) {
            case -1458789996:
                if (authority.equals("passthrough")) {
                    obj = 2;
                    break;
                }
                break;
            case 109770977:
                if (authority.equals("store")) {
                    obj = null;
                    break;
                }
                break;
            case 1546100943:
                if (authority.equals("open_link")) {
                    obj = 1;
                    break;
                }
                break;
        }
        switch (obj) {
            case NendAdIconLayout.HORIZONTAL /*0*/:
                return queryParameter != null ? null : new C0451c(context, str, uri, map);
            case NendIconError.ERROR_ICONVIEW /*1*/:
                return new C0452d(context, str, uri, map);
            case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                return new C0453e(context, str, uri, map);
            default:
                return new C0454f(context, str, uri);
        }
    }

    public static boolean m1112a(String str) {
        return "store".equalsIgnoreCase(str) || "open_link".equalsIgnoreCase(str);
    }
}
