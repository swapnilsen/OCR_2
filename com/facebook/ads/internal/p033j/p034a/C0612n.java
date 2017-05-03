package com.facebook.ads.internal.p033j.p034a;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.List;
import java.util.Map;

/* renamed from: com.facebook.ads.internal.j.a.n */
public class C0612n {
    private int f1418a;
    private String f1419b;
    private Map<String, List<String>> f1420c;
    private byte[] f1421d;

    public C0612n(HttpURLConnection httpURLConnection, byte[] bArr) {
        try {
            this.f1418a = httpURLConnection.getResponseCode();
            this.f1419b = httpURLConnection.getURL().toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.f1420c = httpURLConnection.getHeaderFields();
        this.f1421d = bArr;
    }

    public int m1921a() {
        return this.f1418a;
    }

    public String m1922b() {
        return this.f1419b;
    }

    public Map<String, List<String>> m1923c() {
        return this.f1420c;
    }

    public byte[] m1924d() {
        return this.f1421d;
    }

    public String m1925e() {
        return this.f1421d != null ? new String(this.f1421d) : null;
    }
}
