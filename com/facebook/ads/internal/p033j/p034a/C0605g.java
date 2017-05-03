package com.facebook.ads.internal.p033j.p034a;

import java.net.HttpURLConnection;
import java.util.List;
import java.util.Map;

/* renamed from: com.facebook.ads.internal.j.a.g */
public class C0605g implements C0604r {
    private void m1905a(Map<String, List<String>> map) {
        if (map != null) {
            for (String str : map.keySet()) {
                for (String str2 : (List) map.get(str)) {
                    m1907a(str + ":" + str2);
                }
            }
        }
    }

    public void m1906a(C0612n c0612n) {
        if (c0612n != null) {
            m1907a("=== HTTP Response ===");
            m1907a("Receive url: " + c0612n.m1922b());
            m1907a("Status: " + c0612n.m1921a());
            m1905a(c0612n.m1923c());
            m1907a("Content:\n" + c0612n.m1925e());
        }
    }

    public void m1907a(String str) {
        System.out.println(str);
    }

    public void m1908a(HttpURLConnection httpURLConnection, Object obj) {
        m1907a("=== HTTP Request ===");
        m1907a(httpURLConnection.getRequestMethod() + " " + httpURLConnection.getURL().toString());
        if (obj instanceof String) {
            m1907a("Content: " + ((String) obj));
        }
        m1905a(httpURLConnection.getRequestProperties());
    }

    public boolean m1909a() {
        return false;
    }
}
