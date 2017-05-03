package com.facebook.ads.internal.p033j.p034a;

import android.os.AsyncTask;

/* renamed from: com.facebook.ads.internal.j.a.h */
public class C0606h extends AsyncTask<C0607l, Void, C0612n> implements C0601c {
    private C0599a f1405a;
    private C0600b f1406b;
    private Exception f1407c;

    public C0606h(C0599a c0599a, C0600b c0600b) {
        this.f1405a = c0599a;
        this.f1406b = c0600b;
    }

    protected C0612n m1910a(C0607l... c0607lArr) {
        if (c0607lArr != null) {
            try {
                if (c0607lArr.length > 0) {
                    return this.f1405a.m1879a(c0607lArr[0]);
                }
            } catch (Exception e) {
                this.f1407c = e;
                cancel(true);
                return null;
            }
        }
        throw new IllegalArgumentException("DoHttpRequestTask takes exactly one argument of type HttpRequest");
    }

    public void m1911a(C0607l c0607l) {
        super.execute(new C0607l[]{c0607l});
    }

    protected void m1912a(C0612n c0612n) {
        this.f1406b.m1896a(c0612n);
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return m1910a((C0607l[]) objArr);
    }

    protected void onCancelled() {
        this.f1406b.m1897a(this.f1407c);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        m1912a((C0612n) obj);
    }
}
