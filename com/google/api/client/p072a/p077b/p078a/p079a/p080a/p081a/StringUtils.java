package com.google.api.client.p072a.p077b.p078a.p079a.p080a.p081a;

import java.io.UnsupportedEncodingException;

/* renamed from: com.google.api.client.a.b.a.a.a.a.c */
public class StringUtils {
    public static byte[] m4806a(String str) {
        return StringUtils.m4807a(str, "UTF-8");
    }

    public static byte[] m4807a(String str, String str2) {
        if (str == null) {
            return null;
        }
        try {
            return str.getBytes(str2);
        } catch (UnsupportedEncodingException e) {
            throw StringUtils.m4803a(str2, e);
        }
    }

    private static IllegalStateException m4803a(String str, UnsupportedEncodingException unsupportedEncodingException) {
        return new IllegalStateException(str + ": " + unsupportedEncodingException);
    }

    public static String m4805a(byte[] bArr, String str) {
        if (bArr == null) {
            return null;
        }
        try {
            return new String(bArr, str);
        } catch (UnsupportedEncodingException e) {
            throw StringUtils.m4803a(str, e);
        }
    }

    public static String m4804a(byte[] bArr) {
        return StringUtils.m4805a(bArr, "UTF-8");
    }
}
