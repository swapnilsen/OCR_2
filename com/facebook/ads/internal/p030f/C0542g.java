package com.facebook.ads.internal.p030f;

import android.database.sqlite.SQLiteDatabase;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* renamed from: com.facebook.ads.internal.f.g */
public abstract class C0542g {
    protected final C0548d f1187j;

    protected C0542g(C0548d c0548d) {
        this.f1187j = c0548d;
    }

    public static String m1670a(String str, C0541b[] c0541bArr) {
        StringBuilder stringBuilder = new StringBuilder("SELECT ");
        for (int i = 0; i < c0541bArr.length - 1; i++) {
            stringBuilder.append(c0541bArr[i].f1185b);
            stringBuilder.append(", ");
        }
        stringBuilder.append(c0541bArr[c0541bArr.length - 1].f1185b);
        stringBuilder.append(" FROM ");
        stringBuilder.append(str);
        return stringBuilder.toString();
    }

    public static String m1671a(String str, C0541b[] c0541bArr, C0541b c0541b) {
        StringBuilder stringBuilder = new StringBuilder(C0542g.m1670a(str, c0541bArr));
        stringBuilder.append(" WHERE ");
        stringBuilder.append(c0541b.f1185b);
        stringBuilder.append(" = ?");
        return stringBuilder.toString();
    }

    private String m1672c() {
        C0541b[] b = m1676b();
        if (b.length < 1) {
            return null;
        }
        String str = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING;
        for (int i = 0; i < b.length - 1; i++) {
            str = str + b[i].m1669a() + ", ";
        }
        return str + b[b.length - 1].m1669a();
    }

    public abstract String m1673a();

    public void m1674a(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE " + m1673a() + " (" + m1672c() + ")");
    }

    public void m1675b(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + m1673a());
    }

    public abstract C0541b[] m1676b();

    public void m1677d() {
    }

    protected SQLiteDatabase m1678e() {
        return this.f1187j.m1693a();
    }
}
