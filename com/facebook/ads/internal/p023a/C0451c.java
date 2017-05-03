package com.facebook.ads.internal.p023a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.ads.internal.p021m.C0705p.C0703a;
import com.facebook.ads.internal.p021m.C0710t;
import com.facebook.ads.internal.p021m.C0712u;
import com.facebook.ads.internal.p021m.C0714w;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
import p000a.p001a.p002a.p003a.p004a.p006b.AbstractSpiCall;

/* renamed from: com.facebook.ads.internal.a.c */
public class C0451c extends C0449a {
    private static final String f782a;
    private final Context f783b;
    private final String f784c;
    private final Uri f785d;
    private final Map<String, String> f786e;

    static {
        f782a = C0451c.class.getSimpleName();
    }

    public C0451c(Context context, String str, Uri uri, Map<String, String> map) {
        this.f783b = context;
        this.f784c = str;
        this.f785d = uri;
        this.f786e = map;
    }

    private Intent m1113a(C0714w c0714w) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addFlags(268435456);
        if (!(TextUtils.isEmpty(c0714w.m2318a()) || TextUtils.isEmpty(c0714w.m2319b()))) {
            intent.setComponent(new ComponentName(c0714w.m2318a(), c0714w.m2319b()));
        }
        if (!TextUtils.isEmpty(c0714w.m2320c())) {
            intent.setData(Uri.parse(c0714w.m2320c()));
        }
        return intent;
    }

    private Intent m1114b(C0714w c0714w) {
        if (TextUtils.isEmpty(c0714w.m2318a())) {
            return null;
        }
        if (!C0710t.m2290a(this.f783b, c0714w.m2318a())) {
            return null;
        }
        CharSequence c = c0714w.m2320c();
        if (!TextUtils.isEmpty(c) && (c.startsWith("tel:") || c.startsWith("telprompt:"))) {
            return new Intent("android.intent.action.CALL", Uri.parse(c));
        }
        PackageManager packageManager = this.f783b.getPackageManager();
        if (TextUtils.isEmpty(c0714w.m2319b()) && TextUtils.isEmpty(c)) {
            return packageManager.getLaunchIntentForPackage(c0714w.m2318a());
        }
        Intent a = m1113a(c0714w);
        List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(a, AccessibilityNodeInfoCompat.ACTION_CUT);
        if (a.getComponent() == null) {
            for (ResolveInfo resolveInfo : queryIntentActivities) {
                if (resolveInfo.activityInfo.packageName.equals(c0714w.m2318a())) {
                    a.setComponent(new ComponentName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name));
                    break;
                }
            }
        }
        return (queryIntentActivities.isEmpty() || a.getComponent() == null) ? null : a;
    }

    private List<C0714w> m1115f() {
        Object queryParameter = this.f785d.getQueryParameter("appsite_data");
        if (TextUtils.isEmpty(queryParameter) || "[]".equals(queryParameter)) {
            return null;
        }
        List<C0714w> arrayList = new ArrayList();
        try {
            JSONArray optJSONArray = new JSONObject(queryParameter).optJSONArray(AbstractSpiCall.ANDROID_CLIENT_TYPE);
            if (optJSONArray == null) {
                return arrayList;
            }
            for (int i = 0; i < optJSONArray.length(); i++) {
                C0714w a = C0714w.m2317a(optJSONArray.optJSONObject(i));
                if (a != null) {
                    arrayList.add(a);
                }
            }
            return arrayList;
        } catch (Throwable e) {
            Log.w(f782a, "Error parsing appsite_data", e);
            return arrayList;
        }
    }

    public C0703a m1116a() {
        return C0703a.OPEN_STORE;
    }

    public void m1117b() {
        m1109a(this.f783b, this.f784c, this.f785d, this.f786e);
        List<Intent> d = m1119d();
        if (d != null) {
            for (Intent startActivity : d) {
                try {
                    this.f783b.startActivity(startActivity);
                    return;
                } catch (Throwable e) {
                    Log.d(f782a, "Failed to open app intent, falling back", e);
                }
            }
        }
        m1120e();
    }

    protected Uri m1118c() {
        Object queryParameter = this.f785d.getQueryParameter("store_url");
        if (!TextUtils.isEmpty(queryParameter)) {
            return Uri.parse(queryParameter);
        }
        String queryParameter2 = this.f785d.getQueryParameter("store_id");
        return Uri.parse(String.format("market://details?id=%s", new Object[]{queryParameter2}));
    }

    protected List<Intent> m1119d() {
        List<C0714w> f = m1115f();
        List<Intent> arrayList = new ArrayList();
        if (f != null) {
            for (C0714w b : f) {
                Intent b2 = m1114b(b);
                if (b2 != null) {
                    arrayList.add(b2);
                }
            }
        }
        return arrayList;
    }

    public void m1120e() {
        try {
            C0712u.m2306a(this.f783b, m1118c(), this.f784c);
        } catch (Throwable e) {
            Log.d(f782a, "Failed to open market url: " + this.f785d.toString(), e);
            String queryParameter = this.f785d.getQueryParameter("store_url_web_fallback");
            if (queryParameter != null && queryParameter.length() > 0) {
                try {
                    C0712u.m2306a(this.f783b, Uri.parse(queryParameter), this.f784c);
                } catch (Throwable e2) {
                    Log.d(f782a, "Failed to open fallback url: " + queryParameter, e2);
                }
            }
        }
    }
}
