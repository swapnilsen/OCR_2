package com.facebook.ads.internal.p030f;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.AsyncTask;
import android.os.Looper;
import android.support.annotation.WorkerThread;
import com.facebook.ads.internal.p021m.C0712u;
import com.facebook.ads.internal.p025h.C0570d;
import com.facebook.ads.internal.p030f.C0545f.C0550a;

/* renamed from: com.facebook.ads.internal.f.d */
public class C0548d {
    private final Context f1205a;
    private final C0551h f1206b;
    private final C0543c f1207c;
    private SQLiteOpenHelper f1208d;

    /* renamed from: com.facebook.ads.internal.f.d.1 */
    class C05441 extends AsyncTask<Void, Void, T> {
        final /* synthetic */ C0545f f1198a;
        final /* synthetic */ C0540a f1199b;
        final /* synthetic */ C0548d f1200c;
        private C0550a f1201d;

        C05441(C0548d c0548d, C0545f c0545f, C0540a c0540a) {
            this.f1200c = c0548d;
            this.f1198a = c0545f;
            this.f1199b = c0540a;
        }

        protected T m1684a(Void... voidArr) {
            T t = null;
            try {
                t = this.f1198a.m1686b();
                this.f1201d = this.f1198a.m1687c();
                return t;
            } catch (SQLiteException e) {
                this.f1201d = C0550a.UNKNOWN;
                return t;
            }
        }

        protected /* synthetic */ Object doInBackground(Object[] objArr) {
            return m1684a((Void[]) objArr);
        }

        protected void onPostExecute(T t) {
            if (this.f1201d == null) {
                this.f1199b.m1668a(t);
            } else {
                this.f1199b.m1667a(this.f1201d.m1702a(), this.f1201d.m1703b());
            }
            this.f1199b.m1666a();
        }
    }

    /* renamed from: com.facebook.ads.internal.f.d.2 */
    class C05472 extends C0546i<String> {
        final /* synthetic */ C0570d f1203a;
        final /* synthetic */ C0548d f1204b;

        C05472(C0548d c0548d, C0570d c0570d) {
            this.f1204b = c0548d;
            this.f1203a = c0570d;
        }

        public String m1688a() {
            try {
                SQLiteDatabase a = this.f1204b.m1693a();
                a.beginTransaction();
                String a2 = this.f1203a.m1758d() != null ? this.f1204b.f1207c.m1680a(this.f1204b.f1206b.m1705a(this.f1203a.m1758d()), this.f1203a.m1755a().f1373c, this.f1203a.m1756b(), this.f1203a.m1759e(), this.f1203a.m1760f(), this.f1203a.m1761g(), this.f1203a.m1762h()) : null;
                a.setTransactionSuccessful();
                a.endTransaction();
                return a2;
            } catch (Exception e) {
                m1685a(C0550a.DATABASE_INSERT);
                return null;
            }
        }

        public /* synthetic */ Object m1689b() {
            return m1688a();
        }
    }

    public C0548d(Context context) {
        this.f1205a = context;
        this.f1206b = new C0551h(this);
        this.f1207c = new C0543c(this);
    }

    private synchronized SQLiteDatabase m1692g() {
        if (this.f1208d == null) {
            this.f1208d = new C0549e(this.f1205a, this);
        }
        return this.f1208d.getWritableDatabase();
    }

    public SQLiteDatabase m1693a() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            return m1692g();
        }
        throw new IllegalStateException("Cannot call getDatabase from the UI thread!");
    }

    public <T> AsyncTask m1694a(C0545f<T> c0545f, C0540a<T> c0540a) {
        return C0712u.m2292a(new C05441(this, c0545f, c0540a), new Void[0]);
    }

    public AsyncTask m1695a(C0570d c0570d, C0540a<String> c0540a) {
        return m1694a(new C05472(this, c0570d), (C0540a) c0540a);
    }

    @WorkerThread
    public boolean m1696a(String str) {
        return this.f1207c.m1681a(str);
    }

    public void m1697b() {
        for (C0542g d : m1698c()) {
            d.m1677d();
        }
        if (this.f1208d != null) {
            this.f1208d.close();
            this.f1208d = null;
        }
    }

    public C0542g[] m1698c() {
        return new C0542g[]{this.f1206b, this.f1207c};
    }

    @WorkerThread
    public Cursor m1699d() {
        return this.f1207c.m1683c();
    }

    @WorkerThread
    public Cursor m1700e() {
        return this.f1206b.m1707c();
    }

    @WorkerThread
    public void m1701f() {
        this.f1206b.m1708f();
    }
}
