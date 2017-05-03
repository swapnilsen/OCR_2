package com.facebook.ads.internal.p033j.p034a;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* renamed from: com.facebook.ads.internal.j.a.p */
public class C0614p implements Map<String, String> {
    private Map<String, String> f1422a;

    public C0614p() {
        this.f1422a = new HashMap();
    }

    public C0614p m1928a(Map<? extends String, ? extends String> map) {
        putAll(map);
        return this;
    }

    public String m1929a() {
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : this.f1422a.keySet()) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append("&");
            }
            stringBuilder.append(str);
            String str2 = (String) this.f1422a.get(str2);
            if (str2 != null) {
                stringBuilder.append("=");
                try {
                    stringBuilder.append(URLEncoder.encode(str2, "UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        }
        return stringBuilder.toString();
    }

    public String m1930a(Object obj) {
        return (String) this.f1422a.get(obj);
    }

    public String m1931a(String str, String str2) {
        return (String) this.f1422a.put(str, str2);
    }

    public String m1932b(Object obj) {
        return (String) this.f1422a.remove(obj);
    }

    public byte[] m1933b() {
        byte[] bArr = null;
        try {
            bArr = m1929a().getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return bArr;
    }

    public void clear() {
        this.f1422a.clear();
    }

    public boolean containsKey(Object obj) {
        return this.f1422a.containsKey(obj);
    }

    public boolean containsValue(Object obj) {
        return this.f1422a.containsValue(obj);
    }

    public Set<Entry<String, String>> entrySet() {
        return this.f1422a.entrySet();
    }

    public /* synthetic */ Object get(Object obj) {
        return m1930a(obj);
    }

    public boolean isEmpty() {
        return this.f1422a.isEmpty();
    }

    public Set<String> keySet() {
        return this.f1422a.keySet();
    }

    public /* synthetic */ Object put(Object obj, Object obj2) {
        return m1931a((String) obj, (String) obj2);
    }

    public void putAll(Map<? extends String, ? extends String> map) {
        this.f1422a.putAll(map);
    }

    public /* synthetic */ Object remove(Object obj) {
        return m1932b(obj);
    }

    public int size() {
        return this.f1422a.size();
    }

    public Collection<String> values() {
        return this.f1422a.values();
    }
}
