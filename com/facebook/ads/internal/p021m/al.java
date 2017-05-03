package com.facebook.ads.internal.p021m;

import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.ads.internal.p033j.p034a.C0599a;
import com.facebook.ads.internal.p033j.p034a.C0612n;
import com.facebook.ads.internal.p033j.p034a.C0614p;
import com.google.api.client.http.HttpStatusCodes;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* renamed from: com.facebook.ads.internal.m.al */
public class al extends AsyncTask<String, Void, am> {
    private static final String f1611a;
    private static final Set<String> f1612b;
    private Map<String, String> f1613c;
    private Map<String, String> f1614d;
    private C0612n f1615e;
    private C0425a f1616f;

    /* renamed from: com.facebook.ads.internal.m.al.a */
    public interface C0425a {
        void m1001a();

        void m1002a(am amVar);
    }

    static {
        f1611a = al.class.getSimpleName();
        f1612b = new HashSet();
        f1612b.add("#");
        f1612b.add("null");
    }

    public al() {
        this(null, null);
    }

    public al(Map<String, String> map) {
        this(map, null);
    }

    public al(Map<String, String> map, Map<String, String> map2) {
        Map map3 = null;
        this.f1613c = map != null ? new HashMap(map) : null;
        if (map2 != null) {
            map3 = new HashMap(map2);
        }
        this.f1614d = map3;
    }

    private String m2172a(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return str;
        }
        return str + (str.contains("?") ? "&" : "?") + str2 + "=" + URLEncoder.encode(str3);
    }

    private boolean m2173a(String str) {
        C0599a b = ak.m2166b();
        try {
            if (this.f1614d == null || this.f1614d.size() == 0) {
                this.f1615e = b.m1881a(str, null);
            } else {
                C0614p c0614p = new C0614p();
                c0614p.m1928a(this.f1614d);
                this.f1615e = b.m1890b(str, c0614p);
            }
            return this.f1615e != null && this.f1615e.m1921a() == HttpStatusCodes.STATUS_CODE_OK;
        } catch (Throwable e) {
            Log.e(f1611a, "Error opening url: " + str, e);
            return false;
        }
    }

    private String m2174b(String str) {
        try {
            str = m2172a(str, "analog", C0712u.m2299a(C0675b.m2179a()));
        } catch (Exception e) {
        }
        return str;
    }

    protected am m2175a(String... strArr) {
        Object obj = strArr[0];
        if (TextUtils.isEmpty(obj) || f1612b.contains(obj)) {
            return null;
        }
        String b = m2174b(obj);
        if (!(this.f1613c == null || this.f1613c.isEmpty())) {
            String str = b;
            for (Entry entry : this.f1613c.entrySet()) {
                str = m2172a(str, (String) entry.getKey(), (String) entry.getValue());
            }
            b = str;
        }
        int i = 1;
        while (true) {
            int i2 = i + 1;
            if (i > 2) {
                return null;
            }
            if (m2173a(b)) {
                return new am(this.f1615e);
            }
            i = i2;
        }
    }

    public void m2176a(C0425a c0425a) {
        this.f1616f = c0425a;
    }

    protected void m2177a(am amVar) {
        if (this.f1616f != null) {
            this.f1616f.m1002a(amVar);
        }
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return m2175a((String[]) objArr);
    }

    protected void onCancelled() {
        if (this.f1616f != null) {
            this.f1616f.m1001a();
        }
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        m2177a((am) obj);
    }
}
