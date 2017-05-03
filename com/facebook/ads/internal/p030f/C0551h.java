package com.facebook.ads.internal.p030f;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.support.annotation.WorkerThread;
import android.text.TextUtils;
import java.util.UUID;

/* renamed from: com.facebook.ads.internal.f.h */
public class C0551h extends C0542g {
    public static final C0541b f1218a;
    public static final C0541b f1219b;
    public static final C0541b[] f1220c;
    private static final String f1221d;
    private static final String f1222e;
    private static final String f1223f;
    private static final String f1224g;

    static {
        f1218a = new C0541b(0, "token_id", "TEXT PRIMARY KEY");
        f1219b = new C0541b(1, "token", "TEXT");
        f1220c = new C0541b[]{f1218a, f1219b};
        f1221d = C0551h.class.getSimpleName();
        f1222e = C0542g.m1670a("tokens", f1220c);
        f1223f = C0542g.m1671a("tokens", f1220c, f1219b);
        f1224g = "DELETE FROM tokens WHERE NOT EXISTS (SELECT 1 FROM events WHERE tokens." + f1218a.f1185b + " = " + "events" + "." + C0543c.f1189b.f1185b + ")";
    }

    public C0551h(C0548d c0548d) {
        super(c0548d);
    }

    public String m1704a() {
        return "tokens";
    }

    @WorkerThread
    String m1705a(String str) {
        Throwable th;
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Invalid token.");
        }
        Cursor rawQuery;
        try {
            rawQuery = m1678e().rawQuery(f1223f, new String[]{str});
            try {
                String string = rawQuery.moveToNext() ? rawQuery.getString(f1218a.f1184a) : null;
                if (TextUtils.isEmpty(string)) {
                    string = UUID.randomUUID().toString();
                    ContentValues contentValues = new ContentValues(2);
                    contentValues.put(f1218a.f1185b, string);
                    contentValues.put(f1219b.f1185b, str);
                    m1678e().insertOrThrow("tokens", null, contentValues);
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                } else if (rawQuery != null) {
                    rawQuery.close();
                }
                return string;
            } catch (Throwable th2) {
                th = th2;
                if (rawQuery != null) {
                    rawQuery.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            rawQuery = null;
            if (rawQuery != null) {
                rawQuery.close();
            }
            throw th;
        }
    }

    public C0541b[] m1706b() {
        return f1220c;
    }

    @WorkerThread
    Cursor m1707c() {
        return m1678e().rawQuery(f1222e, null);
    }

    @WorkerThread
    public void m1708f() {
        try {
            m1678e().execSQL(f1224g);
        } catch (SQLException e) {
        }
    }
}
