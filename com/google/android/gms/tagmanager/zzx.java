package com.google.android.gms.tagmanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.google.android.gms.common.util.zze;
import com.google.android.gms.common.util.zzi;
import com.google.firebase.analytics.FirebaseAnalytics.Param;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

class zzx implements zzc {
    private static final String zzbFL;
    private final Context mContext;
    private final Executor zzbFM;
    private zza zzbFN;
    private int zzbFO;
    private zze zzuP;

    /* renamed from: com.google.android.gms.tagmanager.zzx.1 */
    class C14631 implements Runnable {
        final /* synthetic */ List zzbFP;
        final /* synthetic */ long zzbFQ;
        final /* synthetic */ zzx zzbFR;

        C14631(zzx com_google_android_gms_tagmanager_zzx, List list, long j) {
            this.zzbFR = com_google_android_gms_tagmanager_zzx;
            this.zzbFP = list;
            this.zzbFQ = j;
        }

        public void run() {
            this.zzbFR.zzb(this.zzbFP, this.zzbFQ);
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.zzx.2 */
    class C14642 implements Runnable {
        final /* synthetic */ zzx zzbFR;
        final /* synthetic */ com.google.android.gms.tagmanager.DataLayer.zzc.zza zzbFS;

        C14642(zzx com_google_android_gms_tagmanager_zzx, com.google.android.gms.tagmanager.DataLayer.zzc.zza com_google_android_gms_tagmanager_DataLayer_zzc_zza) {
            this.zzbFR = com_google_android_gms_tagmanager_zzx;
            this.zzbFS = com_google_android_gms_tagmanager_DataLayer_zzc_zza;
        }

        public void run() {
            this.zzbFS.zzM(this.zzbFR.zzQA());
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.zzx.3 */
    class C14653 implements Runnable {
        final /* synthetic */ zzx zzbFR;
        final /* synthetic */ String zzbFT;

        C14653(zzx com_google_android_gms_tagmanager_zzx, String str) {
            this.zzbFR = com_google_android_gms_tagmanager_zzx;
            this.zzbFT = str;
        }

        public void run() {
            this.zzbFR.zzhd(this.zzbFT);
        }
    }

    class zza extends SQLiteOpenHelper {
        final /* synthetic */ zzx zzbFR;

        zza(zzx com_google_android_gms_tagmanager_zzx, Context context, String str) {
            this.zzbFR = com_google_android_gms_tagmanager_zzx;
            super(context, str, null, 1);
        }

        private boolean zza(String str, SQLiteDatabase sQLiteDatabase) {
            Cursor cursor;
            String str2;
            String valueOf;
            Throwable th;
            Cursor cursor2 = null;
            try {
                Cursor query = sQLiteDatabase.query("SQLITE_MASTER", new String[]{"name"}, "name=?", new String[]{str}, null, null, null);
                try {
                    boolean moveToFirst = query.moveToFirst();
                    if (query == null) {
                        return moveToFirst;
                    }
                    query.close();
                    return moveToFirst;
                } catch (SQLiteException e) {
                    cursor = query;
                    try {
                        str2 = "Error querying for table ";
                        valueOf = String.valueOf(str);
                        zzbo.zzbh(valueOf.length() == 0 ? new String(str2) : str2.concat(valueOf));
                        if (cursor != null) {
                            cursor.close();
                        }
                        return false;
                    } catch (Throwable th2) {
                        cursor2 = cursor;
                        th = th2;
                        if (cursor2 != null) {
                            cursor2.close();
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    cursor2 = query;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    throw th;
                }
            } catch (SQLiteException e2) {
                cursor = null;
                str2 = "Error querying for table ";
                valueOf = String.valueOf(str);
                if (valueOf.length() == 0) {
                }
                zzbo.zzbh(valueOf.length() == 0 ? new String(str2) : str2.concat(valueOf));
                if (cursor != null) {
                    cursor.close();
                }
                return false;
            } catch (Throwable th4) {
                th = th4;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
        }

        private void zzc(SQLiteDatabase sQLiteDatabase) {
            Cursor rawQuery = sQLiteDatabase.rawQuery("SELECT * FROM datalayer WHERE 0", null);
            Set hashSet = new HashSet();
            try {
                String[] columnNames = rawQuery.getColumnNames();
                for (Object add : columnNames) {
                    hashSet.add(add);
                }
                if (!hashSet.remove("key") || !hashSet.remove(Param.VALUE) || !hashSet.remove("ID") || !hashSet.remove("expires")) {
                    throw new SQLiteException("Database column missing");
                } else if (!hashSet.isEmpty()) {
                    throw new SQLiteException("Database has extra columns");
                }
            } finally {
                rawQuery.close();
            }
        }

        public SQLiteDatabase getWritableDatabase() {
            SQLiteDatabase sQLiteDatabase = null;
            try {
                sQLiteDatabase = super.getWritableDatabase();
            } catch (SQLiteException e) {
                this.zzbFR.mContext.getDatabasePath("google_tagmanager.db").delete();
            }
            return sQLiteDatabase == null ? super.getWritableDatabase() : sQLiteDatabase;
        }

        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            zzan.zzca(sQLiteDatabase.getPath());
        }

        public void onOpen(SQLiteDatabase sQLiteDatabase) {
            if (VERSION.SDK_INT < 15) {
                Cursor rawQuery = sQLiteDatabase.rawQuery("PRAGMA journal_mode=memory", null);
                try {
                    rawQuery.moveToFirst();
                } finally {
                    rawQuery.close();
                }
            }
            if (zza("datalayer", sQLiteDatabase)) {
                zzc(sQLiteDatabase);
            } else {
                sQLiteDatabase.execSQL(zzx.zzbFL);
            }
        }

        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }
    }

    private static class zzb {
        final String zzAX;
        final byte[] zzbFU;

        zzb(String str, byte[] bArr) {
            this.zzAX = str;
            this.zzbFU = bArr;
        }

        public String toString() {
            String str = this.zzAX;
            return new StringBuilder(String.valueOf(str).length() + 54).append("KeyAndSerialized: key = ").append(str).append(" serialized hash = ").append(Arrays.hashCode(this.zzbFU)).toString();
        }
    }

    static {
        zzbFL = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' STRING NOT NULL, '%s' BLOB NOT NULL, '%s' INTEGER NOT NULL);", new Object[]{"datalayer", "ID", "key", Param.VALUE, "expires"});
    }

    public zzx(Context context) {
        this(context, zzi.zzzc(), "google_tagmanager.db", 2000, Executors.newSingleThreadExecutor());
    }

    zzx(Context context, zze com_google_android_gms_common_util_zze, String str, int i, Executor executor) {
        this.mContext = context;
        this.zzuP = com_google_android_gms_common_util_zze;
        this.zzbFO = i;
        this.zzbFM = executor;
        this.zzbFN = new zza(this, this.mContext, str);
    }

    private byte[] zzJ(Object obj) {
        Throwable th;
        byte[] bArr = null;
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream;
        try {
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            try {
                objectOutputStream.writeObject(obj);
                bArr = byteArrayOutputStream.toByteArray();
                try {
                    objectOutputStream.close();
                    byteArrayOutputStream.close();
                } catch (IOException e) {
                }
            } catch (IOException e2) {
                if (objectOutputStream != null) {
                    try {
                        objectOutputStream.close();
                    } catch (IOException e3) {
                    }
                }
                byteArrayOutputStream.close();
                return bArr;
            } catch (Throwable th2) {
                th = th2;
                if (objectOutputStream != null) {
                    try {
                        objectOutputStream.close();
                    } catch (IOException e4) {
                        throw th;
                    }
                }
                byteArrayOutputStream.close();
                throw th;
            }
        } catch (IOException e5) {
            objectOutputStream = bArr;
            if (objectOutputStream != null) {
                objectOutputStream.close();
            }
            byteArrayOutputStream.close();
            return bArr;
        } catch (Throwable th3) {
            Throwable th4 = th3;
            objectOutputStream = bArr;
            th = th4;
            if (objectOutputStream != null) {
                objectOutputStream.close();
            }
            byteArrayOutputStream.close();
            throw th;
        }
        return bArr;
    }

    private Object zzL(byte[] bArr) {
        ObjectInputStream objectInputStream;
        Object readObject;
        Throwable th;
        ObjectInputStream objectInputStream2 = null;
        InputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        try {
            objectInputStream = new ObjectInputStream(byteArrayInputStream);
            try {
                readObject = objectInputStream.readObject();
                try {
                    objectInputStream.close();
                    byteArrayInputStream.close();
                } catch (IOException e) {
                }
            } catch (IOException e2) {
                if (objectInputStream != null) {
                    try {
                        objectInputStream.close();
                    } catch (IOException e3) {
                    }
                }
                byteArrayInputStream.close();
                return readObject;
            } catch (ClassNotFoundException e4) {
                if (objectInputStream != null) {
                    try {
                        objectInputStream.close();
                    } catch (IOException e5) {
                    }
                }
                byteArrayInputStream.close();
                return readObject;
            } catch (Throwable th2) {
                th = th2;
                if (objectInputStream != null) {
                    try {
                        objectInputStream.close();
                    } catch (IOException e6) {
                        throw th;
                    }
                }
                byteArrayInputStream.close();
                throw th;
            }
        } catch (IOException e7) {
            objectInputStream = objectInputStream2;
            if (objectInputStream != null) {
                objectInputStream.close();
            }
            byteArrayInputStream.close();
            return readObject;
        } catch (ClassNotFoundException e8) {
            objectInputStream = objectInputStream2;
            if (objectInputStream != null) {
                objectInputStream.close();
            }
            byteArrayInputStream.close();
            return readObject;
        } catch (Throwable th3) {
            Throwable th4 = th3;
            objectInputStream = objectInputStream2;
            th = th4;
            if (objectInputStream != null) {
                objectInputStream.close();
            }
            byteArrayInputStream.close();
            throw th;
        }
        return readObject;
    }

    private List<zza> zzN(List<zzb> list) {
        List<zza> arrayList = new ArrayList();
        for (zzb com_google_android_gms_tagmanager_zzx_zzb : list) {
            arrayList.add(new zza(com_google_android_gms_tagmanager_zzx_zzb.zzAX, zzL(com_google_android_gms_tagmanager_zzx_zzb.zzbFU)));
        }
        return arrayList;
    }

    private List<zzb> zzO(List<zza> list) {
        List<zzb> arrayList = new ArrayList();
        for (zza com_google_android_gms_tagmanager_DataLayer_zza : list) {
            arrayList.add(new zzb(com_google_android_gms_tagmanager_DataLayer_zza.zzAX, zzJ(com_google_android_gms_tagmanager_DataLayer_zza.mValue)));
        }
        return arrayList;
    }

    private List<zza> zzQA() {
        try {
            zzaz(this.zzuP.currentTimeMillis());
            List<zza> zzN = zzN(zzQB());
            return zzN;
        } finally {
            zzQD();
        }
    }

    private List<zzb> zzQB() {
        SQLiteDatabase zzhe = zzhe("Error opening database for loadSerialized.");
        List<zzb> arrayList = new ArrayList();
        if (zzhe == null) {
            return arrayList;
        }
        Cursor query = zzhe.query("datalayer", new String[]{"key", Param.VALUE}, null, null, null, null, "ID", null);
        while (query.moveToNext()) {
            try {
                arrayList.add(new zzb(query.getString(0), query.getBlob(1)));
            } finally {
                query.close();
            }
        }
        return arrayList;
    }

    private int zzQC() {
        Cursor cursor = null;
        int i = 0;
        SQLiteDatabase zzhe = zzhe("Error opening database for getNumStoredEntries.");
        if (zzhe != null) {
            try {
                cursor = zzhe.rawQuery("SELECT COUNT(*) from datalayer", null);
                if (cursor.moveToFirst()) {
                    i = (int) cursor.getLong(0);
                }
                if (cursor != null) {
                    cursor.close();
                }
            } catch (SQLiteException e) {
                zzbo.zzbh("Error getting numStoredEntries");
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Throwable th) {
                if (cursor != null) {
                    cursor.close();
                }
            }
        }
        return i;
    }

    private void zzQD() {
        try {
            this.zzbFN.close();
        } catch (SQLiteException e) {
        }
    }

    private void zzaz(long j) {
        SQLiteDatabase zzhe = zzhe("Error opening database for deleteOlderThan.");
        if (zzhe != null) {
            try {
                zzbo.m4712v("Deleted " + zzhe.delete("datalayer", "expires <= ?", new String[]{Long.toString(j)}) + " expired items");
            } catch (SQLiteException e) {
                zzbo.zzbh("Error deleting old entries.");
            }
        }
    }

    private synchronized void zzb(List<zzb> list, long j) {
        try {
            long currentTimeMillis = this.zzuP.currentTimeMillis();
            zzaz(currentTimeMillis);
            zznA(list.size());
            zzc(list, currentTimeMillis + j);
            zzQD();
        } catch (Throwable th) {
            zzQD();
        }
    }

    private void zzc(List<zzb> list, long j) {
        SQLiteDatabase zzhe = zzhe("Error opening database for writeEntryToDatabase.");
        if (zzhe != null) {
            for (zzb com_google_android_gms_tagmanager_zzx_zzb : list) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("expires", Long.valueOf(j));
                contentValues.put("key", com_google_android_gms_tagmanager_zzx_zzb.zzAX);
                contentValues.put(Param.VALUE, com_google_android_gms_tagmanager_zzx_zzb.zzbFU);
                zzhe.insert("datalayer", null, contentValues);
            }
        }
    }

    private void zzg(String[] strArr) {
        if (strArr != null && strArr.length != 0) {
            SQLiteDatabase zzhe = zzhe("Error opening database for deleteEntries.");
            if (zzhe != null) {
                try {
                    zzhe.delete("datalayer", String.format("%s in (%s)", new Object[]{"ID", TextUtils.join(",", Collections.nCopies(strArr.length, "?"))}), strArr);
                } catch (SQLiteException e) {
                    String str = "Error deleting entries ";
                    String valueOf = String.valueOf(Arrays.toString(strArr));
                    zzbo.zzbh(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
                }
            }
        }
    }

    private void zzhd(String str) {
        SQLiteDatabase zzhe = zzhe("Error opening database for clearKeysWithPrefix.");
        if (zzhe != null) {
            try {
                zzbo.m4712v("Cleared " + zzhe.delete("datalayer", "key = ? OR key LIKE ?", new String[]{str, String.valueOf(str).concat(".%")}) + " items");
            } catch (SQLiteException e) {
                String valueOf = String.valueOf(e);
                zzbo.zzbh(new StringBuilder((String.valueOf(str).length() + 44) + String.valueOf(valueOf).length()).append("Error deleting entries with key prefix: ").append(str).append(" (").append(valueOf).append(").").toString());
            } finally {
                zzQD();
            }
        }
    }

    private SQLiteDatabase zzhe(String str) {
        try {
            return this.zzbFN.getWritableDatabase();
        } catch (SQLiteException e) {
            zzbo.zzbh(str);
            return null;
        }
    }

    private void zznA(int i) {
        int zzQC = (zzQC() - this.zzbFO) + i;
        if (zzQC > 0) {
            List zznB = zznB(zzQC);
            zzbo.zzbg("DataLayer store full, deleting " + zznB.size() + " entries to make room.");
            zzg((String[]) zznB.toArray(new String[0]));
        }
    }

    private List<String> zznB(int i) {
        Cursor query;
        SQLiteException e;
        String str;
        String valueOf;
        Throwable th;
        List<String> arrayList = new ArrayList();
        if (i <= 0) {
            zzbo.zzbh("Invalid maxEntries specified. Skipping.");
            return arrayList;
        }
        SQLiteDatabase zzhe = zzhe("Error opening database for peekEntryIds.");
        if (zzhe == null) {
            return arrayList;
        }
        try {
            query = zzhe.query("datalayer", new String[]{"ID"}, null, null, null, null, String.format("%s ASC", new Object[]{"ID"}), Integer.toString(i));
            try {
                if (query.moveToFirst()) {
                    do {
                        arrayList.add(String.valueOf(query.getLong(0)));
                    } while (query.moveToNext());
                }
                if (query != null) {
                    query.close();
                }
            } catch (SQLiteException e2) {
                e = e2;
                try {
                    str = "Error in peekEntries fetching entryIds: ";
                    valueOf = String.valueOf(e.getMessage());
                    zzbo.zzbh(valueOf.length() == 0 ? str.concat(valueOf) : new String(str));
                    if (query != null) {
                        query.close();
                    }
                    return arrayList;
                } catch (Throwable th2) {
                    th = th2;
                    if (query != null) {
                        query.close();
                    }
                    throw th;
                }
            }
        } catch (SQLiteException e3) {
            e = e3;
            query = null;
            str = "Error in peekEntries fetching entryIds: ";
            valueOf = String.valueOf(e.getMessage());
            if (valueOf.length() == 0) {
            }
            zzbo.zzbh(valueOf.length() == 0 ? str.concat(valueOf) : new String(str));
            if (query != null) {
                query.close();
            }
            return arrayList;
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
        return arrayList;
    }

    public void zza(com.google.android.gms.tagmanager.DataLayer.zzc.zza com_google_android_gms_tagmanager_DataLayer_zzc_zza) {
        this.zzbFM.execute(new C14642(this, com_google_android_gms_tagmanager_DataLayer_zzc_zza));
    }

    public void zza(List<zza> list, long j) {
        this.zzbFM.execute(new C14631(this, zzO(list), j));
    }

    public void zzhc(String str) {
        this.zzbFM.execute(new C14653(this, str));
    }
}
