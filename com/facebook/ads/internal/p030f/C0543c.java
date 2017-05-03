package com.facebook.ads.internal.p030f;

import android.content.ContentValues;
import android.database.Cursor;
import android.support.annotation.WorkerThread;
import java.util.Map;
import java.util.UUID;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.internal.f.c */
public class C0543c extends C0542g {
    public static final C0541b f1188a;
    public static final C0541b f1189b;
    public static final C0541b f1190c;
    public static final C0541b f1191d;
    public static final C0541b f1192e;
    public static final C0541b f1193f;
    public static final C0541b f1194g;
    public static final C0541b f1195h;
    public static final C0541b[] f1196i;
    private static final String f1197k;

    static {
        f1188a = new C0541b(0, "event_id", "TEXT PRIMARY KEY");
        f1189b = new C0541b(1, "token_id", "TEXT REFERENCES tokens ON UPDATE CASCADE ON DELETE RESTRICT");
        f1190c = new C0541b(2, "priority", "INTEGER");
        f1191d = new C0541b(3, "type", "TEXT");
        f1192e = new C0541b(4, "time", "REAL");
        f1193f = new C0541b(5, "session_time", "REAL");
        f1194g = new C0541b(6, "session_id", "TEXT");
        f1195h = new C0541b(7, "data", "TEXT");
        f1196i = new C0541b[]{f1188a, f1189b, f1190c, f1191d, f1192e, f1193f, f1194g, f1195h};
        f1197k = C0542g.m1670a("events", f1196i);
    }

    public C0543c(C0548d c0548d) {
        super(c0548d);
    }

    public String m1679a() {
        return "events";
    }

    @WorkerThread
    String m1680a(String str, int i, String str2, double d, double d2, String str3, Map<String, String> map) {
        String uuid = UUID.randomUUID().toString();
        ContentValues contentValues = new ContentValues(7);
        contentValues.put(f1188a.f1185b, uuid);
        contentValues.put(f1189b.f1185b, str);
        contentValues.put(f1190c.f1185b, Integer.valueOf(i));
        contentValues.put(f1191d.f1185b, str2);
        contentValues.put(f1192e.f1185b, Double.valueOf(d));
        contentValues.put(f1193f.f1185b, Double.valueOf(d2));
        contentValues.put(f1194g.f1185b, str3);
        contentValues.put(f1195h.f1185b, map != null ? new JSONObject(map).toString() : null);
        m1678e().insertOrThrow("events", null, contentValues);
        return uuid;
    }

    public boolean m1681a(String str) {
        return m1678e().delete("events", new StringBuilder().append(f1188a.f1185b).append(" = ?").toString(), new String[]{str}) > 0;
    }

    public C0541b[] m1682b() {
        return f1196i;
    }

    @WorkerThread
    Cursor m1683c() {
        return m1678e().rawQuery(f1197k, null);
    }
}
