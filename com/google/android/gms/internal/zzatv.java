package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.annotation.WorkerThread;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.gms.common.util.zze;

public class zzatv extends zzauh {
    private final zza zzbsx;
    private boolean zzbsy;

    @TargetApi(11)
    private class zza extends SQLiteOpenHelper {
        final /* synthetic */ zzatv zzbsz;

        zza(zzatv com_google_android_gms_internal_zzatv, Context context, String str) {
            this.zzbsz = com_google_android_gms_internal_zzatv;
            super(context, str, null, 1);
        }

        @WorkerThread
        public SQLiteDatabase getWritableDatabase() {
            try {
                return super.getWritableDatabase();
            } catch (SQLiteException e) {
                if (VERSION.SDK_INT < 11 || !(e instanceof SQLiteDatabaseLockedException)) {
                    this.zzbsz.zzKl().zzLY().log("Opening the local database failed, dropping and recreating it");
                    String zzow = this.zzbsz.zzow();
                    if (!this.zzbsz.getContext().getDatabasePath(zzow).delete()) {
                        this.zzbsz.zzKl().zzLY().zzj("Failed to delete corrupted local db file", zzow);
                    }
                    try {
                        return super.getWritableDatabase();
                    } catch (SQLiteException e2) {
                        this.zzbsz.zzKl().zzLY().zzj("Failed to open local database. Events will bypass local storage", e2);
                        return null;
                    }
                }
                throw e2;
            }
        }

        @WorkerThread
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            zzatj.zza(this.zzbsz.zzKl(), sQLiteDatabase);
        }

        @WorkerThread
        public void onOpen(SQLiteDatabase sQLiteDatabase) {
            if (VERSION.SDK_INT < 15) {
                Cursor rawQuery = sQLiteDatabase.rawQuery("PRAGMA journal_mode=memory", null);
                try {
                    rawQuery.moveToFirst();
                } finally {
                    rawQuery.close();
                }
            }
            zzatj.zza(this.zzbsz.zzKl(), sQLiteDatabase, "messages", "create table if not exists messages ( type INTEGER NOT NULL, entry BLOB NOT NULL)", "type,entry", null);
        }

        @WorkerThread
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }
    }

    zzatv(zzaue com_google_android_gms_internal_zzaue) {
        super(com_google_android_gms_internal_zzaue);
        this.zzbsx = new zza(this, getContext(), zzow());
    }

    @WorkerThread
    @TargetApi(11)
    private boolean zza(int i, byte[] bArr) {
        zzJW();
        zzmR();
        if (this.zzbsy) {
            return false;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("type", Integer.valueOf(i));
        contentValues.put("entry", bArr);
        zzKn().zzLp();
        int i2 = 0;
        int i3 = 5;
        while (i2 < 5) {
            SQLiteDatabase sQLiteDatabase = null;
            try {
                sQLiteDatabase = getWritableDatabase();
                if (sQLiteDatabase == null) {
                    this.zzbsy = true;
                    if (sQLiteDatabase != null) {
                        sQLiteDatabase.close();
                    }
                    return false;
                }
                sQLiteDatabase.beginTransaction();
                long j = 0;
                Cursor rawQuery = sQLiteDatabase.rawQuery("select count(1) from messages", null);
                if (rawQuery != null && rawQuery.moveToFirst()) {
                    j = rawQuery.getLong(0);
                }
                if (j >= 100000) {
                    zzKl().zzLY().log("Data loss, local db full");
                    j = (100000 - j) + 1;
                    long delete = (long) sQLiteDatabase.delete("messages", "rowid in (select rowid from messages order by rowid asc limit ?)", new String[]{Long.toString(j)});
                    if (delete != j) {
                        zzKl().zzLY().zzd("Different delete count than expected in local db. expected, received, difference", Long.valueOf(j), Long.valueOf(delete), Long.valueOf(j - delete));
                    }
                }
                sQLiteDatabase.insertOrThrow("messages", null, contentValues);
                sQLiteDatabase.setTransactionSuccessful();
                sQLiteDatabase.endTransaction();
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.close();
                }
                return true;
            } catch (SQLiteFullException e) {
                zzKl().zzLY().zzj("Error writing entry to local database", e);
                this.zzbsy = true;
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.close();
                }
                i2++;
            } catch (SQLiteException e2) {
                if (VERSION.SDK_INT < 11 || !(e2 instanceof SQLiteDatabaseLockedException)) {
                    if (sQLiteDatabase != null) {
                        if (sQLiteDatabase.inTransaction()) {
                            sQLiteDatabase.endTransaction();
                        }
                    }
                    zzKl().zzLY().zzj("Error writing entry to local database", e2);
                    this.zzbsy = true;
                } else {
                    SystemClock.sleep((long) i3);
                    i3 += 20;
                }
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.close();
                }
                i2++;
            } catch (Throwable th) {
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.close();
                }
            }
        }
        zzKl().zzMa().log("Failed to write entry to local database");
        return false;
    }

    public /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    @WorkerThread
    SQLiteDatabase getWritableDatabase() {
        int i = VERSION.SDK_INT;
        if (this.zzbsy) {
            return null;
        }
        SQLiteDatabase writableDatabase = this.zzbsx.getWritableDatabase();
        if (writableDatabase != null) {
            return writableDatabase;
        }
        this.zzbsy = true;
        return null;
    }

    public /* bridge */ /* synthetic */ void zzJV() {
        super.zzJV();
    }

    public /* bridge */ /* synthetic */ void zzJW() {
        super.zzJW();
    }

    public /* bridge */ /* synthetic */ void zzJX() {
        super.zzJX();
    }

    public /* bridge */ /* synthetic */ zzatb zzJY() {
        return super.zzJY();
    }

    public /* bridge */ /* synthetic */ zzatf zzJZ() {
        return super.zzJZ();
    }

    public /* bridge */ /* synthetic */ zzauj zzKa() {
        return super.zzKa();
    }

    public /* bridge */ /* synthetic */ zzatu zzKb() {
        return super.zzKb();
    }

    public /* bridge */ /* synthetic */ zzatl zzKc() {
        return super.zzKc();
    }

    public /* bridge */ /* synthetic */ zzaul zzKd() {
        return super.zzKd();
    }

    public /* bridge */ /* synthetic */ zzauk zzKe() {
        return super.zzKe();
    }

    public /* bridge */ /* synthetic */ zzatv zzKf() {
        return super.zzKf();
    }

    public /* bridge */ /* synthetic */ zzatj zzKg() {
        return super.zzKg();
    }

    public /* bridge */ /* synthetic */ zzaut zzKh() {
        return super.zzKh();
    }

    public /* bridge */ /* synthetic */ zzauc zzKi() {
        return super.zzKi();
    }

    public /* bridge */ /* synthetic */ zzaun zzKj() {
        return super.zzKj();
    }

    public /* bridge */ /* synthetic */ zzaud zzKk() {
        return super.zzKk();
    }

    public /* bridge */ /* synthetic */ zzatx zzKl() {
        return super.zzKl();
    }

    public /* bridge */ /* synthetic */ zzaua zzKm() {
        return super.zzKm();
    }

    public /* bridge */ /* synthetic */ zzati zzKn() {
        return super.zzKn();
    }

    boolean zzLM() {
        return getContext().getDatabasePath(zzow()).exists();
    }

    public boolean zza(zzatq com_google_android_gms_internal_zzatq) {
        int i = VERSION.SDK_INT;
        Parcel obtain = Parcel.obtain();
        com_google_android_gms_internal_zzatq.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        if (marshall.length <= AccessibilityNodeInfoCompat.ACTION_SET_SELECTION) {
            return zza(0, marshall);
        }
        zzKl().zzMa().log("Event is too long for local database. Sending event directly to service");
        return false;
    }

    public boolean zza(zzauq com_google_android_gms_internal_zzauq) {
        int i = VERSION.SDK_INT;
        Parcel obtain = Parcel.obtain();
        com_google_android_gms_internal_zzauq.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        if (marshall.length <= AccessibilityNodeInfoCompat.ACTION_SET_SELECTION) {
            return zza(1, marshall);
        }
        zzKl().zzMa().log("User property too long for local database. Sending directly to service");
        return false;
    }

    public boolean zzc(zzatg com_google_android_gms_internal_zzatg) {
        int i = VERSION.SDK_INT;
        byte[] zza = zzKh().zza((Parcelable) com_google_android_gms_internal_zzatg);
        if (zza.length <= AccessibilityNodeInfoCompat.ACTION_SET_SELECTION) {
            return zza(2, zza);
        }
        zzKl().zzMa().log("Conditional user property too long for local database. Sending directly to service");
        return false;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @android.annotation.TargetApi(11)
    public java.util.List<com.google.android.gms.common.internal.safeparcel.zza> zzlD(int r14) {
        /*
        r13 = this;
        r13.zzmR();
        r13.zzJW();
        r0 = android.os.Build.VERSION.SDK_INT;
        r0 = r13.zzbsy;
        if (r0 == 0) goto L_0x000e;
    L_0x000c:
        r0 = 0;
    L_0x000d:
        return r0;
    L_0x000e:
        r10 = new java.util.ArrayList;
        r10.<init>();
        r0 = r13.zzLM();
        if (r0 != 0) goto L_0x001b;
    L_0x0019:
        r0 = r10;
        goto L_0x000d;
    L_0x001b:
        r9 = 5;
        r0 = 0;
        r11 = r0;
    L_0x001e:
        r0 = 5;
        if (r11 >= r0) goto L_0x01c3;
    L_0x0021:
        r1 = 0;
        r0 = r13.getWritableDatabase();	 Catch:{ SQLiteFullException -> 0x01d9, SQLiteException -> 0x01d6 }
        if (r0 != 0) goto L_0x0032;
    L_0x0028:
        r1 = 1;
        r13.zzbsy = r1;	 Catch:{ SQLiteFullException -> 0x00a7, SQLiteException -> 0x00e9, all -> 0x011b }
        if (r0 == 0) goto L_0x0030;
    L_0x002d:
        r0.close();
    L_0x0030:
        r0 = 0;
        goto L_0x000d;
    L_0x0032:
        r0.beginTransaction();	 Catch:{ SQLiteFullException -> 0x00a7, SQLiteException -> 0x00e9, all -> 0x011b }
        r1 = "messages";
        r2 = 3;
        r2 = new java.lang.String[r2];	 Catch:{ SQLiteFullException -> 0x00a7, SQLiteException -> 0x00e9, all -> 0x011b }
        r3 = 0;
        r4 = "rowid";
        r2[r3] = r4;	 Catch:{ SQLiteFullException -> 0x00a7, SQLiteException -> 0x00e9, all -> 0x011b }
        r3 = 1;
        r4 = "type";
        r2[r3] = r4;	 Catch:{ SQLiteFullException -> 0x00a7, SQLiteException -> 0x00e9, all -> 0x011b }
        r3 = 2;
        r4 = "entry";
        r2[r3] = r4;	 Catch:{ SQLiteFullException -> 0x00a7, SQLiteException -> 0x00e9, all -> 0x011b }
        r3 = 0;
        r4 = 0;
        r5 = 0;
        r6 = 0;
        r7 = "rowid asc";
        r8 = java.lang.Integer.toString(r14);	 Catch:{ SQLiteFullException -> 0x00a7, SQLiteException -> 0x00e9, all -> 0x011b }
        r6 = r0.query(r1, r2, r3, r4, r5, r6, r7, r8);	 Catch:{ SQLiteFullException -> 0x00a7, SQLiteException -> 0x00e9, all -> 0x011b }
        r2 = -1;
    L_0x0059:
        r1 = r6.moveToNext();	 Catch:{ SQLiteFullException -> 0x00a7, SQLiteException -> 0x00e9, all -> 0x011b }
        if (r1 == 0) goto L_0x016f;
    L_0x005f:
        r1 = 0;
        r4 = r6.getLong(r1);	 Catch:{ SQLiteFullException -> 0x00a7, SQLiteException -> 0x00e9, all -> 0x011b }
        r1 = 1;
        r1 = r6.getInt(r1);	 Catch:{ SQLiteFullException -> 0x00a7, SQLiteException -> 0x00e9, all -> 0x011b }
        r2 = 2;
        r3 = r6.getBlob(r2);	 Catch:{ SQLiteFullException -> 0x00a7, SQLiteException -> 0x00e9, all -> 0x011b }
        if (r1 != 0) goto L_0x00c7;
    L_0x0070:
        r2 = android.os.Parcel.obtain();	 Catch:{ SQLiteFullException -> 0x00a7, SQLiteException -> 0x00e9, all -> 0x011b }
        r1 = 0;
        r7 = r3.length;	 Catch:{ zza -> 0x008f }
        r2.unmarshall(r3, r1, r7);	 Catch:{ zza -> 0x008f }
        r1 = 0;
        r2.setDataPosition(r1);	 Catch:{ zza -> 0x008f }
        r1 = com.google.android.gms.internal.zzatq.CREATOR;	 Catch:{ zza -> 0x008f }
        r1 = r1.createFromParcel(r2);	 Catch:{ zza -> 0x008f }
        r1 = (com.google.android.gms.internal.zzatq) r1;	 Catch:{ zza -> 0x008f }
        r2.recycle();	 Catch:{ SQLiteFullException -> 0x00a7, SQLiteException -> 0x00e9, all -> 0x011b }
        if (r1 == 0) goto L_0x008d;
    L_0x008a:
        r10.add(r1);	 Catch:{ SQLiteFullException -> 0x00a7, SQLiteException -> 0x00e9, all -> 0x011b }
    L_0x008d:
        r2 = r4;
        goto L_0x0059;
    L_0x008f:
        r1 = move-exception;
        r1 = r13.zzKl();	 Catch:{ all -> 0x00a2 }
        r1 = r1.zzLY();	 Catch:{ all -> 0x00a2 }
        r3 = "Failed to load event from local database";
        r1.log(r3);	 Catch:{ all -> 0x00a2 }
        r2.recycle();	 Catch:{ SQLiteFullException -> 0x00a7, SQLiteException -> 0x00e9, all -> 0x011b }
        r2 = r4;
        goto L_0x0059;
    L_0x00a2:
        r1 = move-exception;
        r2.recycle();	 Catch:{ SQLiteFullException -> 0x00a7, SQLiteException -> 0x00e9, all -> 0x011b }
        throw r1;	 Catch:{ SQLiteFullException -> 0x00a7, SQLiteException -> 0x00e9, all -> 0x011b }
    L_0x00a7:
        r1 = move-exception;
        r12 = r1;
        r1 = r0;
        r0 = r12;
    L_0x00ab:
        r2 = r13.zzKl();	 Catch:{ all -> 0x01d3 }
        r2 = r2.zzLY();	 Catch:{ all -> 0x01d3 }
        r3 = "Error reading entries from local database";
        r2.zzj(r3, r0);	 Catch:{ all -> 0x01d3 }
        r0 = 1;
        r13.zzbsy = r0;	 Catch:{ all -> 0x01d3 }
        if (r1 == 0) goto L_0x01dc;
    L_0x00bd:
        r1.close();
        r0 = r9;
    L_0x00c1:
        r1 = r11 + 1;
        r11 = r1;
        r9 = r0;
        goto L_0x001e;
    L_0x00c7:
        r2 = 1;
        if (r1 != r2) goto L_0x0125;
    L_0x00ca:
        r7 = android.os.Parcel.obtain();	 Catch:{ SQLiteFullException -> 0x00a7, SQLiteException -> 0x00e9, all -> 0x011b }
        r2 = 0;
        r1 = 0;
        r8 = r3.length;	 Catch:{ zza -> 0x0103 }
        r7.unmarshall(r3, r1, r8);	 Catch:{ zza -> 0x0103 }
        r1 = 0;
        r7.setDataPosition(r1);	 Catch:{ zza -> 0x0103 }
        r1 = com.google.android.gms.internal.zzauq.CREATOR;	 Catch:{ zza -> 0x0103 }
        r1 = r1.createFromParcel(r7);	 Catch:{ zza -> 0x0103 }
        r1 = (com.google.android.gms.internal.zzauq) r1;	 Catch:{ zza -> 0x0103 }
        r7.recycle();	 Catch:{ SQLiteFullException -> 0x00a7, SQLiteException -> 0x00e9, all -> 0x011b }
    L_0x00e3:
        if (r1 == 0) goto L_0x008d;
    L_0x00e5:
        r10.add(r1);	 Catch:{ SQLiteFullException -> 0x00a7, SQLiteException -> 0x00e9, all -> 0x011b }
        goto L_0x008d;
    L_0x00e9:
        r1 = move-exception;
        r12 = r1;
        r1 = r0;
        r0 = r12;
    L_0x00ed:
        r2 = android.os.Build.VERSION.SDK_INT;	 Catch:{ all -> 0x01d3 }
        r3 = 11;
        if (r2 < r3) goto L_0x01a5;
    L_0x00f3:
        r2 = r0 instanceof android.database.sqlite.SQLiteDatabaseLockedException;	 Catch:{ all -> 0x01d3 }
        if (r2 == 0) goto L_0x01a5;
    L_0x00f7:
        r2 = (long) r9;	 Catch:{ all -> 0x01d3 }
        android.os.SystemClock.sleep(r2);	 Catch:{ all -> 0x01d3 }
        r0 = r9 + 20;
    L_0x00fd:
        if (r1 == 0) goto L_0x00c1;
    L_0x00ff:
        r1.close();
        goto L_0x00c1;
    L_0x0103:
        r1 = move-exception;
        r1 = r13.zzKl();	 Catch:{ all -> 0x0116 }
        r1 = r1.zzLY();	 Catch:{ all -> 0x0116 }
        r3 = "Failed to load user property from local database";
        r1.log(r3);	 Catch:{ all -> 0x0116 }
        r7.recycle();	 Catch:{ SQLiteFullException -> 0x00a7, SQLiteException -> 0x00e9, all -> 0x011b }
        r1 = r2;
        goto L_0x00e3;
    L_0x0116:
        r1 = move-exception;
        r7.recycle();	 Catch:{ SQLiteFullException -> 0x00a7, SQLiteException -> 0x00e9, all -> 0x011b }
        throw r1;	 Catch:{ SQLiteFullException -> 0x00a7, SQLiteException -> 0x00e9, all -> 0x011b }
    L_0x011b:
        r1 = move-exception;
        r12 = r1;
        r1 = r0;
        r0 = r12;
    L_0x011f:
        if (r1 == 0) goto L_0x0124;
    L_0x0121:
        r1.close();
    L_0x0124:
        throw r0;
    L_0x0125:
        r2 = 2;
        if (r1 != r2) goto L_0x0160;
    L_0x0128:
        r7 = android.os.Parcel.obtain();	 Catch:{ SQLiteFullException -> 0x00a7, SQLiteException -> 0x00e9, all -> 0x011b }
        r2 = 0;
        r1 = 0;
        r8 = r3.length;	 Catch:{ zza -> 0x0148 }
        r7.unmarshall(r3, r1, r8);	 Catch:{ zza -> 0x0148 }
        r1 = 0;
        r7.setDataPosition(r1);	 Catch:{ zza -> 0x0148 }
        r1 = com.google.android.gms.internal.zzatg.CREATOR;	 Catch:{ zza -> 0x0148 }
        r1 = r1.createFromParcel(r7);	 Catch:{ zza -> 0x0148 }
        r1 = (com.google.android.gms.internal.zzatg) r1;	 Catch:{ zza -> 0x0148 }
        r7.recycle();	 Catch:{ SQLiteFullException -> 0x00a7, SQLiteException -> 0x00e9, all -> 0x011b }
    L_0x0141:
        if (r1 == 0) goto L_0x008d;
    L_0x0143:
        r10.add(r1);	 Catch:{ SQLiteFullException -> 0x00a7, SQLiteException -> 0x00e9, all -> 0x011b }
        goto L_0x008d;
    L_0x0148:
        r1 = move-exception;
        r1 = r13.zzKl();	 Catch:{ all -> 0x015b }
        r1 = r1.zzLY();	 Catch:{ all -> 0x015b }
        r3 = "Failed to load user property from local database";
        r1.log(r3);	 Catch:{ all -> 0x015b }
        r7.recycle();	 Catch:{ SQLiteFullException -> 0x00a7, SQLiteException -> 0x00e9, all -> 0x011b }
        r1 = r2;
        goto L_0x0141;
    L_0x015b:
        r1 = move-exception;
        r7.recycle();	 Catch:{ SQLiteFullException -> 0x00a7, SQLiteException -> 0x00e9, all -> 0x011b }
        throw r1;	 Catch:{ SQLiteFullException -> 0x00a7, SQLiteException -> 0x00e9, all -> 0x011b }
    L_0x0160:
        r1 = r13.zzKl();	 Catch:{ SQLiteFullException -> 0x00a7, SQLiteException -> 0x00e9, all -> 0x011b }
        r1 = r1.zzLY();	 Catch:{ SQLiteFullException -> 0x00a7, SQLiteException -> 0x00e9, all -> 0x011b }
        r2 = "Unknown record type in local database";
        r1.log(r2);	 Catch:{ SQLiteFullException -> 0x00a7, SQLiteException -> 0x00e9, all -> 0x011b }
        goto L_0x008d;
    L_0x016f:
        r6.close();	 Catch:{ SQLiteFullException -> 0x00a7, SQLiteException -> 0x00e9, all -> 0x011b }
        r1 = "messages";
        r4 = "rowid <= ?";
        r5 = 1;
        r5 = new java.lang.String[r5];	 Catch:{ SQLiteFullException -> 0x00a7, SQLiteException -> 0x00e9, all -> 0x011b }
        r6 = 0;
        r2 = java.lang.Long.toString(r2);	 Catch:{ SQLiteFullException -> 0x00a7, SQLiteException -> 0x00e9, all -> 0x011b }
        r5[r6] = r2;	 Catch:{ SQLiteFullException -> 0x00a7, SQLiteException -> 0x00e9, all -> 0x011b }
        r1 = r0.delete(r1, r4, r5);	 Catch:{ SQLiteFullException -> 0x00a7, SQLiteException -> 0x00e9, all -> 0x011b }
        r2 = r10.size();	 Catch:{ SQLiteFullException -> 0x00a7, SQLiteException -> 0x00e9, all -> 0x011b }
        if (r1 >= r2) goto L_0x0197;
    L_0x018a:
        r1 = r13.zzKl();	 Catch:{ SQLiteFullException -> 0x00a7, SQLiteException -> 0x00e9, all -> 0x011b }
        r1 = r1.zzLY();	 Catch:{ SQLiteFullException -> 0x00a7, SQLiteException -> 0x00e9, all -> 0x011b }
        r2 = "Fewer entries removed from local database than expected";
        r1.log(r2);	 Catch:{ SQLiteFullException -> 0x00a7, SQLiteException -> 0x00e9, all -> 0x011b }
    L_0x0197:
        r0.setTransactionSuccessful();	 Catch:{ SQLiteFullException -> 0x00a7, SQLiteException -> 0x00e9, all -> 0x011b }
        r0.endTransaction();	 Catch:{ SQLiteFullException -> 0x00a7, SQLiteException -> 0x00e9, all -> 0x011b }
        if (r0 == 0) goto L_0x01a2;
    L_0x019f:
        r0.close();
    L_0x01a2:
        r0 = r10;
        goto L_0x000d;
    L_0x01a5:
        if (r1 == 0) goto L_0x01b0;
    L_0x01a7:
        r2 = r1.inTransaction();	 Catch:{ all -> 0x01d3 }
        if (r2 == 0) goto L_0x01b0;
    L_0x01ad:
        r1.endTransaction();	 Catch:{ all -> 0x01d3 }
    L_0x01b0:
        r2 = r13.zzKl();	 Catch:{ all -> 0x01d3 }
        r2 = r2.zzLY();	 Catch:{ all -> 0x01d3 }
        r3 = "Error reading entries from local database";
        r2.zzj(r3, r0);	 Catch:{ all -> 0x01d3 }
        r0 = 1;
        r13.zzbsy = r0;	 Catch:{ all -> 0x01d3 }
        r0 = r9;
        goto L_0x00fd;
    L_0x01c3:
        r0 = r13.zzKl();
        r0 = r0.zzMa();
        r1 = "Failed to read events from database in reasonable time";
        r0.log(r1);
        r0 = 0;
        goto L_0x000d;
    L_0x01d3:
        r0 = move-exception;
        goto L_0x011f;
    L_0x01d6:
        r0 = move-exception;
        goto L_0x00ed;
    L_0x01d9:
        r0 = move-exception;
        goto L_0x00ab;
    L_0x01dc:
        r0 = r9;
        goto L_0x00c1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzatv.zzlD(int):java.util.List<com.google.android.gms.common.internal.safeparcel.zza>");
    }

    public /* bridge */ /* synthetic */ void zzmR() {
        super.zzmR();
    }

    protected void zzmS() {
    }

    public /* bridge */ /* synthetic */ zze zznR() {
        return super.zznR();
    }

    String zzow() {
        return zzKn().zzLf();
    }
}
