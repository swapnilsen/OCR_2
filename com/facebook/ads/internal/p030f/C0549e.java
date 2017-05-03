package com.facebook.ads.internal.p030f;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* renamed from: com.facebook.ads.internal.f.e */
public class C0549e extends SQLiteOpenHelper {
    private final C0548d f1209a;

    public C0549e(Context context, C0548d c0548d) {
        super(context, "ads.db", null, 3);
        if (c0548d == null) {
            throw new IllegalArgumentException("AdDatabaseHelper can not be null");
        }
        this.f1209a = c0548d;
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        for (C0542g a : this.f1209a.m1698c()) {
            a.m1674a(sQLiteDatabase);
        }
    }

    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        for (C0542g c0542g : this.f1209a.m1698c()) {
            c0542g.m1675b(sQLiteDatabase);
            c0542g.m1674a(sQLiteDatabase);
        }
    }

    public void onOpen(SQLiteDatabase sQLiteDatabase) {
        super.onOpen(sQLiteDatabase);
        if (!sQLiteDatabase.isReadOnly()) {
            sQLiteDatabase.execSQL("PRAGMA foreign_keys = ON;");
        }
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i == 2 && i2 == 3) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS 'crashes'");
        }
    }
}
