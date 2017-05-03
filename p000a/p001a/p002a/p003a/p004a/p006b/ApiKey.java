package p000a.p001a.p002a.p003a.p004a.p006b;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.text.TextUtils;
import p000a.p001a.p002a.p003a.Fabric;

/* renamed from: a.a.a.a.a.b.g */
public class ApiKey {
    public String m32a(Context context) {
        Object b = m33b(context);
        if (TextUtils.isEmpty(b)) {
            b = m34c(context);
        }
        if (TextUtils.isEmpty(b)) {
            m35d(context);
        }
        return b;
    }

    protected String m33b(Context context) {
        String str = null;
        try {
            Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS).metaData;
            if (bundle != null) {
                str = bundle.getString("io.fabric.ApiKey");
                if (str == null) {
                    Fabric.m397h().m359a("Fabric", "Falling back to Crashlytics key lookup from Manifest");
                    str = bundle.getString("com.crashlytics.ApiKey");
                }
            }
        } catch (Exception e) {
            Fabric.m397h().m359a("Fabric", "Caught non-fatal exception while retrieving apiKey: " + e);
        }
        return str;
    }

    protected String m34c(Context context) {
        int a = CommonUtils.m39a(context, "io.fabric.ApiKey", "string");
        if (a == 0) {
            Fabric.m397h().m359a("Fabric", "Falling back to Crashlytics key lookup from Strings");
            a = CommonUtils.m39a(context, "com.crashlytics.ApiKey", "string");
        }
        if (a != 0) {
            return context.getResources().getString(a);
        }
        return null;
    }

    protected void m35d(Context context) {
        if (Fabric.m398i() || CommonUtils.m76i(context)) {
            throw new IllegalArgumentException(m31a());
        }
        Fabric.m397h().m366e("Fabric", m31a());
    }

    protected String m31a() {
        return "Fabric could not be initialized, API key missing from AndroidManifest.xml. Add the following tag to your Application element \n\t<meta-data android:name=\"io.fabric.ApiKey\" android:value=\"YOUR_API_KEY\"/>";
    }
}
