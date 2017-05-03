package com.facebook.ads.internal.p033j.p035b;

import android.text.TextUtils;
import android.util.Log;
import android.webkit.MimeTypeMap;
import java.io.Closeable;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;

/* renamed from: com.facebook.ads.internal.j.b.m */
public class C0647m {
    static String m2041a(String str) {
        MimeTypeMap singleton = MimeTypeMap.getSingleton();
        Object fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(str);
        return TextUtils.isEmpty(fileExtensionFromUrl) ? null : singleton.getMimeTypeFromExtension(fileExtensionFromUrl);
    }

    private static String m2042a(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        int length = bArr.length;
        for (int i = 0; i < length; i++) {
            stringBuffer.append(String.format("%02x", new Object[]{Byte.valueOf(bArr[i])}));
        }
        return stringBuffer.toString();
    }

    static void m2043a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable e) {
                Log.e("ProxyCache", "Error closing resource", e);
            }
        }
    }

    static void m2044a(byte[] bArr, long j, int i) {
        boolean z = true;
        C0644j.m2039a((Object) bArr, "Buffer must be not null!");
        C0644j.m2040a(j >= 0, "Data offset must be positive!");
        if (i < 0 || i > bArr.length) {
            z = false;
        }
        C0644j.m2040a(z, "Length must be in range [0..buffer.length]");
    }

    static String m2045b(String str) {
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (Throwable e) {
            throw new RuntimeException("Error encoding url", e);
        }
    }

    static String m2046c(String str) {
        try {
            return URLDecoder.decode(str, "utf-8");
        } catch (Throwable e) {
            throw new RuntimeException("Error decoding url", e);
        }
    }

    public static String m2047d(String str) {
        try {
            return C0647m.m2042a(MessageDigest.getInstance("MD5").digest(str.getBytes()));
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }
}
