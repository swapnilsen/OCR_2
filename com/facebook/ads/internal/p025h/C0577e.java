package com.facebook.ads.internal.p025h;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.WorkerThread;
import android.text.TextUtils;
import com.facebook.ads.internal.C0649j;
import com.facebook.ads.internal.p021m.ak;
import com.facebook.ads.internal.p027l.C0661c;
import com.facebook.ads.internal.p033j.p034a.C0599a;
import com.facebook.ads.internal.p033j.p034a.C0612n;
import com.facebook.ads.internal.p033j.p034a.C0614p;
import com.google.api.client.http.HttpStatusCodes;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.internal.h.e */
public class C0577e {
    private static final String f1348a;
    private static final String f1349b;
    private final C0576a f1350c;
    private final ThreadPoolExecutor f1351d;
    private final ConnectivityManager f1352e;
    private final C0599a f1353f;
    private final Handler f1354g;
    private final long f1355h;
    private final long f1356i;
    private final Runnable f1357j;
    private volatile boolean f1358k;
    private int f1359l;
    private long f1360m;

    /* renamed from: com.facebook.ads.internal.h.e.1 */
    class C05751 implements Runnable {
        final /* synthetic */ C0577e f1347a;

        /* renamed from: com.facebook.ads.internal.h.e.1.1 */
        class C05741 extends AsyncTask<Void, Void, Void> {
            final /* synthetic */ C05751 f1346a;

            C05741(C05751 c05751) {
                this.f1346a = c05751;
            }

            protected Void m1773a(Void... voidArr) {
                C0577e.m1781b(this.f1346a.f1347a);
                if (this.f1346a.f1347a.f1360m > 0) {
                    try {
                        Thread.sleep(this.f1346a.f1347a.f1360m);
                    } catch (InterruptedException e) {
                    }
                }
                this.f1346a.f1347a.m1782b();
                return null;
            }

            protected /* synthetic */ Object doInBackground(Object[] objArr) {
                return m1773a((Void[]) objArr);
            }
        }

        C05751(C0577e c0577e) {
            this.f1347a = c0577e;
        }

        public void run() {
            this.f1347a.f1358k = false;
            if (this.f1347a.f1351d.getQueue().isEmpty()) {
                new C05741(this).executeOnExecutor(this.f1347a.f1351d, new Void[0]);
            }
        }
    }

    /* renamed from: com.facebook.ads.internal.h.e.a */
    interface C0576a {
        JSONObject m1774a();

        boolean m1775a(JSONArray jSONArray);

        void m1776b();
    }

    static {
        f1348a = C0577e.class.getSimpleName();
        f1349b = C0661c.m2121b();
    }

    public C0577e(Context context, C0576a c0576a) {
        this.f1357j = new C05751(this);
        this.f1350c = c0576a;
        this.f1351d = new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
        this.f1352e = (ConnectivityManager) context.getSystemService("connectivity");
        this.f1353f = ak.m2167b(context);
        this.f1354g = new Handler(Looper.getMainLooper());
        this.f1355h = C0649j.m2055e(context);
        this.f1356i = C0649j.m2056f(context);
    }

    private void m1778a() {
        if (this.f1359l >= 3) {
            m1784c();
            m1786a(false);
            return;
        }
        if (this.f1359l == 1) {
            this.f1360m = 2000;
        } else {
            this.f1360m *= 2;
        }
        m1786a(true);
    }

    private void m1779a(long j) {
        this.f1354g.postDelayed(this.f1357j, j);
    }

    static /* synthetic */ int m1781b(C0577e c0577e) {
        int i = c0577e.f1359l + 1;
        c0577e.f1359l = i;
        return i;
    }

    @WorkerThread
    private void m1782b() {
        try {
            NetworkInfo activeNetworkInfo = this.f1352e.getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnectedOrConnecting()) {
                m1779a(this.f1356i);
                return;
            }
            JSONObject a = this.f1350c.m1774a();
            if (a == null) {
                m1784c();
                return;
            }
            C0614p c0614p = new C0614p();
            c0614p.m1931a("payload", a.toString());
            C0612n b = this.f1353f.m1890b(f1349b, c0614p);
            Object e = b != null ? b.m1925e() : null;
            if (TextUtils.isEmpty(e)) {
                m1778a();
            } else if (b.m1921a() != HttpStatusCodes.STATUS_CODE_OK) {
                m1778a();
            } else if (this.f1350c.m1775a(new JSONArray(e))) {
                m1784c();
            } else {
                m1778a();
            }
        } catch (Exception e2) {
            m1778a();
        }
    }

    private void m1784c() {
        this.f1359l = 0;
        this.f1360m = 0;
        if (this.f1351d.getQueue().size() == 0) {
            this.f1350c.m1776b();
        }
    }

    public void m1786a(boolean z) {
        if (z || !this.f1358k) {
            this.f1358k = true;
            this.f1354g.removeCallbacks(this.f1357j);
            m1779a(z ? this.f1355h : this.f1356i);
        }
    }
}
