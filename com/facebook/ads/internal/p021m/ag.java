package com.facebook.ads.internal.p021m;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.MessageDigest;

/* renamed from: com.facebook.ads.internal.m.ag */
public class ag {
    @Nullable
    public static final String m2148a(Context context, String str) {
        try {
            return ag.m2152b(context.getPackageManager().getApplicationInfo(str, 0).sourceDir);
        } catch (Exception e) {
            return null;
        }
    }

    @Nullable
    public static final String m2149a(File file) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            byte[] bArr = new byte[AccessibilityNodeInfoCompat.ACTION_NEXT_HTML_ELEMENT];
            InputStream fileInputStream = new FileInputStream(file);
            int read;
            do {
                read = fileInputStream.read(bArr);
                if (read > 0) {
                    instance.update(bArr, 0, read);
                }
            } while (read != -1);
            fileInputStream.close();
            return ag.m2151a(instance.digest());
        } catch (Exception e) {
            return null;
        }
    }

    @Nullable
    public static String m2150a(String str) {
        try {
            return ag.m2151a(MessageDigest.getInstance("MD5").digest(str.getBytes("utf-8")));
        } catch (Exception e) {
            return null;
        }
    }

    private static final String m2151a(byte[] bArr) {
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : bArr) {
            stringBuilder.append(Integer.toString((b & MotionEventCompat.ACTION_MASK) + AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY, 16).substring(1));
        }
        return stringBuilder.toString();
    }

    @Nullable
    public static final String m2152b(String str) {
        return ag.m2149a(new File(str));
    }
}
