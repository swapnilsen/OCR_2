package com.facebook.ads.internal.p033j.p034a;

import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/* renamed from: com.facebook.ads.internal.j.a.f */
public abstract class C0597f implements C0596q {
    private final C0604r f1391a;

    public C0597f() {
        this(new C0605g());
    }

    public C0597f(C0604r c0604r) {
        this.f1391a = c0604r;
    }

    public OutputStream m1866a(HttpURLConnection httpURLConnection) {
        return httpURLConnection.getOutputStream();
    }

    public HttpURLConnection m1867a(String str) {
        return (HttpURLConnection) new URL(str).openConnection();
    }

    public void m1868a(OutputStream outputStream, byte[] bArr) {
        outputStream.write(bArr);
    }

    public void m1869a(HttpURLConnection httpURLConnection, C0609j c0609j, String str) {
        httpURLConnection.setRequestMethod(c0609j.m1919c());
        httpURLConnection.setDoOutput(c0609j.m1918b());
        httpURLConnection.setDoInput(c0609j.m1917a());
        if (str != null) {
            httpURLConnection.setRequestProperty("Content-Type", str);
        }
        httpURLConnection.setRequestProperty("Accept-Charset", "UTF-8");
    }

    public boolean m1870a(C0611m c0611m) {
        C0612n a = c0611m.m1920a();
        if (this.f1391a.m1904a()) {
            this.f1391a.m1902a("BasicRequestHandler.onError got");
            c0611m.printStackTrace();
        }
        return a != null && a.m1921a() > 0;
    }

    public byte[] m1871a(InputStream inputStream) {
        byte[] bArr = new byte[AccessibilityNodeInfoCompat.ACTION_COPY];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                byteArrayOutputStream.flush();
                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    public InputStream m1872b(HttpURLConnection httpURLConnection) {
        return httpURLConnection.getInputStream();
    }
}
