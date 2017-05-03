package com.p013a.p014a.p015a.p020e;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

/* renamed from: com.a.a.a.e.d */
public final class InternCache extends LinkedHashMap<String, String> {
    public static final InternCache f642a;

    static {
        f642a = new InternCache();
    }

    private InternCache() {
        super(100, 0.8f, true);
    }

    protected boolean removeEldestEntry(Entry<String, String> entry) {
        return size() > 100;
    }

    public synchronized String m950a(String str) {
        String str2;
        str2 = (String) get(str);
        if (str2 == null) {
            str2 = str.intern();
            put(str2, str2);
        }
        return str2;
    }
}
