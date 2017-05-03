package com.facebook.ads.internal.p025h;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.view.PointerIconCompat;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.ads.internal.C0649j;
import com.facebook.ads.internal.p021m.C0712u;
import com.facebook.ads.internal.p021m.C0717y;
import com.facebook.ads.internal.p021m.ab;
import com.facebook.ads.internal.p021m.al;
import com.facebook.ads.internal.p025h.C0577e.C0576a;
import com.facebook.ads.internal.p029e.C0537a;
import com.facebook.ads.internal.p030f.C0540a;
import com.facebook.ads.internal.p030f.C0543c;
import com.facebook.ads.internal.p030f.C0548d;
import com.facebook.ads.internal.p030f.C0551h;
import com.facebook.ads.internal.p031g.C0562g;
import com.google.ads.mediation.facebook.FacebookAdapter;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.internal.h.g */
public class C0580g implements C0576a, C0578f {
    private static final String f1363a;
    private static C0580g f1364b;
    private static double f1365c;
    private static String f1366d;
    private final C0577e f1367e;
    private final C0548d f1368f;
    private final Context f1369g;

    /* renamed from: com.facebook.ads.internal.h.g.1 */
    class C05791 extends C0540a<String> {
        final /* synthetic */ C0570d f1361a;
        final /* synthetic */ C0580g f1362b;

        C05791(C0580g c0580g, C0570d c0570d) {
            this.f1362b = c0580g;
            this.f1361a = c0570d;
        }

        public void m1795a(int i, String str) {
            super.m1667a(i, str);
            if (!(this.f1361a instanceof C0573c)) {
                this.f1362b.m1811b(str);
            }
        }

        public void m1797a(String str) {
            super.m1668a(str);
            this.f1362b.f1367e.m1786a(this.f1361a.m1763i());
        }
    }

    static {
        f1363a = C0580g.class.getSimpleName();
    }

    protected C0580g(Context context) {
        this.f1368f = new C0548d(context);
        this.f1367e = new C0577e(context, this);
        this.f1367e.m1786a(false);
        this.f1369g = context;
        C0537a.m1662a(context).m1663a();
    }

    public static C0580g m1799a(Context context) {
        if (f1364b == null) {
            Context applicationContext = context.getApplicationContext();
            synchronized (applicationContext) {
                if (f1364b == null) {
                    f1364b = new C0580g(applicationContext);
                    C0562g.m1743a();
                    f1365c = C0562g.m1744b();
                    f1366d = C0562g.m1745c();
                }
            }
        }
        return f1364b;
    }

    private JSONObject m1800a(Cursor cursor) {
        JSONObject jSONObject = new JSONObject();
        while (cursor.moveToNext()) {
            jSONObject.put(cursor.getString(C0551h.f1218a.f1184a), cursor.getString(C0551h.f1219b.f1184a));
        }
        return jSONObject;
    }

    private void m1801a(C0570d c0570d) {
        this.f1368f.m1695a(c0570d, new C05791(this, c0570d));
    }

    private JSONArray m1802b(Cursor cursor) {
        JSONArray jSONArray = new JSONArray();
        while (cursor.moveToNext()) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(FacebookAdapter.KEY_ID, cursor.getString(C0543c.f1188a.f1184a));
            jSONObject.put("token_id", cursor.getString(C0543c.f1189b.f1184a));
            jSONObject.put("type", cursor.getString(C0543c.f1191d.f1184a));
            jSONObject.put("time", C0712u.m2296a(cursor.getDouble(C0543c.f1192e.f1184a)));
            jSONObject.put("session_time", C0712u.m2296a(cursor.getDouble(C0543c.f1193f.f1184a)));
            jSONObject.put("session_id", cursor.getString(C0543c.f1194g.f1184a));
            String string = cursor.getString(C0543c.f1195h.f1184a);
            jSONObject.put("data", string != null ? new JSONObject(string) : new JSONObject());
            jSONArray.put(jSONObject);
        }
        return jSONArray;
    }

    public JSONObject m1803a() {
        Cursor e;
        Cursor cursor;
        Throwable th;
        Cursor d;
        try {
            e = this.f1368f.m1700e();
            try {
                d = this.f1368f.m1699d();
            } catch (JSONException e2) {
                cursor = null;
                d = e;
                if (d != null) {
                    d.close();
                }
                if (cursor != null) {
                    cursor.close();
                }
                return null;
            } catch (Throwable th2) {
                th = th2;
                d = null;
                if (e != null) {
                    e.close();
                }
                if (d != null) {
                    d.close();
                }
                throw th;
            }
            try {
                JSONObject jSONObject;
                if (e.getCount() <= 0 || d.getCount() <= 0) {
                    jSONObject = null;
                } else {
                    jSONObject = new JSONObject();
                    jSONObject.put("tokens", m1800a(e));
                    jSONObject.put("events", m1802b(d));
                }
                if (C0649j.m2054d(this.f1369g)) {
                    JSONArray a = ab.m2133a(this.f1369g);
                    if (a != null && a.length() > 0) {
                        if (jSONObject == null) {
                            jSONObject = new JSONObject();
                        }
                        jSONObject.put("debug", a);
                    }
                }
                if (e != null) {
                    e.close();
                }
                if (d == null) {
                    return jSONObject;
                }
                d.close();
                return jSONObject;
            } catch (JSONException e3) {
                cursor = d;
                d = e;
                if (d != null) {
                    d.close();
                }
                if (cursor != null) {
                    cursor.close();
                }
                return null;
            } catch (Throwable th3) {
                th = th3;
                if (e != null) {
                    e.close();
                }
                if (d != null) {
                    d.close();
                }
                throw th;
            }
        } catch (JSONException e4) {
            cursor = null;
            d = null;
            if (d != null) {
                d.close();
            }
            if (cursor != null) {
                cursor.close();
            }
            return null;
        } catch (Throwable th4) {
            th = th4;
            d = null;
            e = null;
            if (e != null) {
                e.close();
            }
            if (d != null) {
                d.close();
            }
            throw th;
        }
    }

    public void m1804a(String str) {
        new al().execute(new String[]{str});
    }

    public void m1805a(String str, C0717y c0717y) {
        m1801a(new C0571a(str, f1365c, f1366d, c0717y));
    }

    public void m1806a(String str, Map<String, String> map) {
        new al(map).execute(new String[]{str});
    }

    public void m1807a(String str, Map<String, String> map, String str2, C0581h c0581h) {
        m1801a(new C0585l(this.f1369g, str, f1365c, f1366d, map, str2, c0581h));
    }

    public void m1808a(String str, Map<String, String> map, Map<String, String> map2) {
        new al(map, map2).execute(new String[]{str});
    }

    public boolean m1809a(JSONArray jSONArray) {
        boolean d = C0649j.m2054d(this.f1369g);
        Object obj = null;
        boolean z = true;
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                String string = jSONObject.getString(FacebookAdapter.KEY_ID);
                int i2 = jSONObject.getInt("code");
                if (i2 == 1) {
                    if (d && jSONObject.optInt("dbtype", 0) == 1) {
                        obj = 1;
                    } else {
                        this.f1368f.m1696a(string);
                    }
                } else if (i2 >= PointerIconCompat.TYPE_DEFAULT && i2 < 2000) {
                    z = false;
                } else if (i2 >= 2000 && i2 < 3000) {
                    if (d && jSONObject.optInt("dbtype", 0) == 1) {
                        int i3 = 1;
                    } else {
                        this.f1368f.m1696a(string);
                    }
                }
            } catch (JSONException e) {
            }
        }
        if (obj != null) {
            ab.m2136b(this.f1369g);
        }
        return z;
    }

    public void m1810b() {
        this.f1368f.m1701f();
        this.f1368f.m1697b();
    }

    public void m1811b(String str) {
        Log.e(f1363a, "AdEventManager error: " + str);
    }

    public void m1812b(String str, Map<String, String> map) {
        if (!TextUtils.isEmpty(str)) {
            m1801a(new C0582i(this.f1369g, str, f1365c, f1366d, map));
        }
    }

    public void m1813c(String str, Map<String, String> map) {
        if (!TextUtils.isEmpty(str)) {
            m1801a(new C0584k(this.f1369g, str, f1365c, f1366d, map));
        }
    }

    public void m1814d(String str, Map<String, String> map) {
        if (!TextUtils.isEmpty(str)) {
            m1801a(new C0588o(this.f1369g, str, f1365c, f1366d, map));
        }
    }

    public void m1815e(String str, Map<String, String> map) {
        if (!TextUtils.isEmpty(str)) {
            m1801a(new C0586m(str, f1365c, f1366d, map));
        }
    }

    public void m1816f(String str, Map<String, String> map) {
        if (!TextUtils.isEmpty(str)) {
            m1801a(new C0572b(this.f1369g, str, f1365c, f1366d, map));
        }
    }

    public void m1817g(String str, Map<String, String> map) {
        if (!TextUtils.isEmpty(str)) {
            m1801a(new C0583j(this.f1369g, str, f1365c, f1366d, map));
        }
    }

    public void m1818h(String str, Map<String, String> map) {
        if (!TextUtils.isEmpty(str)) {
            m1801a(new C0587n(this.f1369g, str, f1365c, f1366d, map));
        }
    }
}
