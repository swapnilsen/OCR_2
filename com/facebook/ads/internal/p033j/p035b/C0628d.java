package com.facebook.ads.internal.p033j.p035b;

import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: com.facebook.ads.internal.j.b.d */
class C0628d {
    private static final Pattern f1433d;
    private static final Pattern f1434e;
    public final String f1435a;
    public final long f1436b;
    public final boolean f1437c;

    static {
        f1433d = Pattern.compile("[R,r]ange:[ ]?bytes=(\\d*)-");
        f1434e = Pattern.compile("GET /(.*) HTTP");
    }

    public C0628d(String str) {
        C0644j.m2038a(str);
        long a = m1969a(str);
        this.f1436b = Math.max(0, a);
        this.f1437c = a >= 0;
        this.f1435a = m1971b(str);
    }

    private long m1969a(String str) {
        Matcher matcher = f1433d.matcher(str);
        return matcher.find() ? Long.parseLong(matcher.group(1)) : -1;
    }

    public static C0628d m1970a(InputStream inputStream) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
        StringBuilder stringBuilder = new StringBuilder();
        while (true) {
            Object readLine = bufferedReader.readLine();
            if (TextUtils.isEmpty(readLine)) {
                return new C0628d(stringBuilder.toString());
            }
            stringBuilder.append(readLine).append('\n');
        }
    }

    private String m1971b(String str) {
        Matcher matcher = f1434e.matcher(str);
        if (matcher.find()) {
            return matcher.group(1);
        }
        throw new IllegalArgumentException("Invalid request `" + str + "`: url not found!");
    }

    public String toString() {
        return "GetRequest{rangeOffset=" + this.f1436b + ", partial=" + this.f1437c + ", uri='" + this.f1435a + '\'' + '}';
    }
}
