package com.facebook.ads.internal.p033j.p035b;

import android.content.Context;
import android.os.Environment;
import android.util.Log;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.io.File;

/* renamed from: com.facebook.ads.internal.j.b.o */
final class C0648o {
    public static File m2048a(Context context) {
        return new File(C0648o.m2049a(context, true), "video-cache");
    }

    private static File m2049a(Context context, boolean z) {
        File file = null;
        Object externalStorageState;
        try {
            externalStorageState = Environment.getExternalStorageState();
        } catch (NullPointerException e) {
            externalStorageState = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING;
        }
        if (z && "mounted".equals(r1)) {
            file = C0648o.m2050b(context);
        }
        if (file == null) {
            file = context.getCacheDir();
        }
        if (file != null) {
            return file;
        }
        String str = "/data/data/" + context.getPackageName() + "/cache/";
        Log.w("ProxyCache", "Can't define system cache directory! '" + str + "%s' will be used.");
        return new File(str);
    }

    private static File m2050b(Context context) {
        File file = new File(new File(new File(new File(Environment.getExternalStorageDirectory(), "Android"), "data"), context.getPackageName()), "cache");
        if (file.exists() || file.mkdirs()) {
            return file;
        }
        Log.w("ProxyCache", "Unable to create external cache directory");
        return null;
    }
}
