package com.facebook.ads.internal.p033j.p034a;

import android.os.Build.VERSION;
import android.support.v4.view.PointerIconCompat;
import android.util.Log;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import javax.net.ssl.HttpsURLConnection;
import p000a.p001a.p002a.p003a.p004a.p009d.EventsFilesManager;

/* renamed from: com.facebook.ads.internal.j.a.a */
public class C0599a {
    private static int[] f1393f;
    private static final String f1394g;
    protected final C0596q f1395a;
    protected final C0602d f1396b;
    protected C0604r f1397c;
    protected int f1398d;
    protected int f1399e;
    private int f1400h;
    private Map<String, String> f1401i;
    private boolean f1402j;
    private Set<String> f1403k;
    private Set<String> f1404l;

    /* renamed from: com.facebook.ads.internal.j.a.a.1 */
    class C05981 extends C0597f {
        final /* synthetic */ C0599a f1392a;

        C05981(C0599a c0599a) {
            this.f1392a = c0599a;
        }
    }

    static {
        f1393f = new int[20];
        f1394g = C0599a.class.getSimpleName();
        C0599a.m1874c();
        if (VERSION.SDK_INT > 8) {
            C0599a.m1873a();
        }
    }

    public C0599a() {
        this.f1396b = new C0603e();
        this.f1397c = new C0605g();
        this.f1398d = 2000;
        this.f1399e = EventsFilesManager.MAX_BYTE_SIZE_PER_FILE;
        this.f1400h = 3;
        this.f1401i = new TreeMap();
        this.f1395a = new C05981(this);
    }

    public static void m1873a() {
        if (CookieHandler.getDefault() == null) {
            CookieHandler.setDefault(new CookieManager());
        }
    }

    private static void m1874c() {
        if (VERSION.SDK_INT < 8) {
            System.setProperty("http.keepAlive", "false");
        }
    }

    private void m1875c(HttpURLConnection httpURLConnection) {
        for (String str : this.f1401i.keySet()) {
            httpURLConnection.setRequestProperty(str, (String) this.f1401i.get(str));
        }
    }

    protected int m1876a(int i) {
        return f1393f[i + 2] * PointerIconCompat.TYPE_DEFAULT;
    }

    protected int m1877a(HttpURLConnection httpURLConnection, byte[] bArr) {
        OutputStream outputStream = null;
        try {
            outputStream = this.f1395a.m1859a(httpURLConnection);
            if (outputStream != null) {
                this.f1395a.m1861a(outputStream, bArr);
            }
            int responseCode = httpURLConnection.getResponseCode();
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (Exception e) {
                }
            }
            return responseCode;
        } catch (Throwable th) {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (Exception e2) {
                }
            }
        }
    }

    public C0599a m1878a(String str, String str2) {
        this.f1401i.put(str, str2);
        return this;
    }

    public C0612n m1879a(C0607l c0607l) {
        int i = 0;
        long currentTimeMillis = System.currentTimeMillis();
        while (i < this.f1400h) {
            try {
                m1895c(m1876a(i));
                if (this.f1397c.m1904a()) {
                    this.f1397c.m1902a((i + 1) + "of" + this.f1400h + ", trying " + c0607l.m1913a());
                }
                currentTimeMillis = System.currentTimeMillis();
                C0612n a = m1880a(c0607l.m1913a(), c0607l.m1914b(), c0607l.m1915c(), c0607l.m1916d());
                if (a != null) {
                    return a;
                }
                i++;
            } catch (C0611m e) {
                if (m1888a((Throwable) e, currentTimeMillis) && i < this.f1400h - 1) {
                    continue;
                } else if (!this.f1395a.m1863a(e) || i >= this.f1400h - 1) {
                    throw e;
                } else {
                    try {
                        Thread.sleep((long) this.f1398d);
                    } catch (InterruptedException e2) {
                        throw e;
                    }
                }
            }
        }
        return null;
    }

    protected C0612n m1880a(String str, C0609j c0609j, String str2, byte[] bArr) {
        Throwable e;
        C0612n a;
        HttpURLConnection httpURLConnection;
        Exception exception;
        C0612n c0612n = null;
        Object obj = 1;
        C0612n c0612n2 = null;
        HttpURLConnection a2;
        try {
            this.f1402j = false;
            a2 = m1883a(str);
            try {
                m1886a(a2, c0609j, str2);
                m1875c(a2);
                if (this.f1397c.m1904a()) {
                    this.f1397c.m1903a(a2, bArr);
                }
                a2.connect();
                this.f1402j = true;
                Object obj2 = (this.f1404l == null || this.f1404l.isEmpty()) ? null : 1;
                if (this.f1403k == null || this.f1403k.isEmpty()) {
                    obj = null;
                }
                if ((a2 instanceof HttpsURLConnection) && !(obj2 == null && r1 == null)) {
                    try {
                        C0613o.m1927a((HttpsURLConnection) a2, this.f1404l, this.f1403k);
                    } catch (Throwable e2) {
                        Log.e(f1394g, "Unable to validate SSL certificates.", e2);
                    } catch (Throwable th) {
                        e2 = th;
                        if (this.f1397c.m1904a()) {
                            this.f1397c.m1901a(c0612n);
                        }
                        if (a2 != null) {
                            a2.disconnect();
                        }
                        throw e2;
                    }
                }
                if (a2.getDoOutput() && bArr != null) {
                    m1877a(a2, bArr);
                }
                a = a2.getDoInput() ? m1882a(a2) : new C0612n(a2, null);
                if (this.f1397c.m1904a()) {
                    this.f1397c.m1901a(a);
                }
                if (a2 == null) {
                    return a;
                }
                a2.disconnect();
                return a;
            } catch (Exception e3) {
                httpURLConnection = a2;
                exception = e3;
                try {
                    a = m1891b(httpURLConnection);
                    if (a != null) {
                        try {
                            if (a.m1921a() > 0) {
                                if (this.f1397c.m1904a()) {
                                    this.f1397c.m1901a(a);
                                }
                                if (httpURLConnection != null) {
                                    return a;
                                }
                                httpURLConnection.disconnect();
                                return a;
                            }
                        } catch (Throwable th2) {
                            c0612n = a;
                            e2 = th2;
                            a2 = httpURLConnection;
                            if (this.f1397c.m1904a()) {
                                this.f1397c.m1901a(c0612n);
                            }
                            if (a2 != null) {
                                a2.disconnect();
                            }
                            throw e2;
                        }
                    }
                    throw new C0611m(exception, a);
                } catch (Exception e4) {
                    exception.printStackTrace();
                    if (null != null) {
                        if (c0612n2.m1921a() > 0) {
                            if (this.f1397c.m1904a()) {
                                this.f1397c.m1901a(null);
                            }
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                            return null;
                        }
                    }
                    throw new C0611m(exception, c0612n2);
                } catch (Throwable th3) {
                    e2 = th3;
                    a2 = httpURLConnection;
                    if (this.f1397c.m1904a()) {
                        this.f1397c.m1901a(c0612n);
                    }
                    if (a2 != null) {
                        a2.disconnect();
                    }
                    throw e2;
                }
            } catch (Throwable th4) {
                e2 = th4;
                if (this.f1397c.m1904a()) {
                    this.f1397c.m1901a(c0612n);
                }
                if (a2 != null) {
                    a2.disconnect();
                }
                throw e2;
            }
        } catch (Exception e32) {
            exception = e32;
            httpURLConnection = null;
            a = m1891b(httpURLConnection);
            if (a != null) {
                if (a.m1921a() > 0) {
                    if (this.f1397c.m1904a()) {
                        this.f1397c.m1901a(a);
                    }
                    if (httpURLConnection != null) {
                        return a;
                    }
                    httpURLConnection.disconnect();
                    return a;
                }
            }
            throw new C0611m(exception, a);
        } catch (Throwable th5) {
            e2 = th5;
            a2 = null;
            if (this.f1397c.m1904a()) {
                this.f1397c.m1901a(c0612n);
            }
            if (a2 != null) {
                a2.disconnect();
            }
            throw e2;
        }
    }

    public C0612n m1881a(String str, C0614p c0614p) {
        return m1889b(new C0608i(str, c0614p));
    }

    protected C0612n m1882a(HttpURLConnection httpURLConnection) {
        InputStream b;
        Throwable th;
        byte[] bArr = null;
        try {
            b = this.f1395a.m1865b(httpURLConnection);
            if (b != null) {
                try {
                    bArr = this.f1395a.m1864a(b);
                } catch (Throwable th2) {
                    th = th2;
                    if (b != null) {
                        try {
                            b.close();
                        } catch (Exception e) {
                        }
                    }
                    throw th;
                }
            }
            C0612n c0612n = new C0612n(httpURLConnection, bArr);
            if (b != null) {
                try {
                    b.close();
                } catch (Exception e2) {
                }
            }
            return c0612n;
        } catch (Throwable th3) {
            th = th3;
            b = null;
            if (b != null) {
                b.close();
            }
            throw th;
        }
    }

    protected HttpURLConnection m1883a(String str) {
        try {
            URL url = new URL(str);
            return this.f1395a.m1860a(str);
        } catch (Throwable e) {
            throw new IllegalArgumentException(str + " is not a valid URL", e);
        }
    }

    protected void m1884a(C0607l c0607l, C0600b c0600b) {
        this.f1396b.m1899a(this, c0600b).m1898a(c0607l);
    }

    public void m1885a(String str, C0614p c0614p, C0600b c0600b) {
        m1884a(new C0610k(str, c0614p), c0600b);
    }

    protected void m1886a(HttpURLConnection httpURLConnection, C0609j c0609j, String str) {
        httpURLConnection.setConnectTimeout(this.f1398d);
        httpURLConnection.setReadTimeout(this.f1399e);
        this.f1395a.m1862a(httpURLConnection, c0609j, str);
    }

    public void m1887a(Set<String> set) {
        this.f1404l = set;
    }

    protected boolean m1888a(Throwable th, long j) {
        long currentTimeMillis = (System.currentTimeMillis() - j) + 10;
        if (this.f1397c.m1904a()) {
            this.f1397c.m1902a("ELAPSED TIME = " + currentTimeMillis + ", CT = " + this.f1398d + ", RT = " + this.f1399e);
        }
        return this.f1402j ? currentTimeMillis >= ((long) this.f1399e) : currentTimeMillis >= ((long) this.f1398d);
    }

    public C0612n m1889b(C0607l c0607l) {
        C0612n c0612n = null;
        try {
            c0612n = m1880a(c0607l.m1913a(), c0607l.m1914b(), c0607l.m1915c(), c0607l.m1916d());
        } catch (C0611m e) {
            this.f1395a.m1863a(e);
        } catch (Exception e2) {
            this.f1395a.m1863a(new C0611m(e2, c0612n));
        }
        return c0612n;
    }

    public C0612n m1890b(String str, C0614p c0614p) {
        return m1889b(new C0610k(str, c0614p));
    }

    protected C0612n m1891b(HttpURLConnection httpURLConnection) {
        Throwable th;
        byte[] bArr = null;
        InputStream errorStream;
        try {
            errorStream = httpURLConnection.getErrorStream();
            if (errorStream != null) {
                try {
                    bArr = this.f1395a.m1864a(errorStream);
                } catch (Throwable th2) {
                    th = th2;
                    if (errorStream != null) {
                        try {
                            errorStream.close();
                        } catch (Exception e) {
                        }
                    }
                    throw th;
                }
            }
            C0612n c0612n = new C0612n(httpURLConnection, bArr);
            if (errorStream != null) {
                try {
                    errorStream.close();
                } catch (Exception e2) {
                }
            }
            return c0612n;
        } catch (Throwable th3) {
            th = th3;
            errorStream = null;
            if (errorStream != null) {
                errorStream.close();
            }
            throw th;
        }
    }

    public C0614p m1892b() {
        return new C0614p();
    }

    public void m1893b(int i) {
        if (i < 1 || i > 18) {
            throw new IllegalArgumentException("Maximum retries must be between 1 and 18");
        }
        this.f1400h = i;
    }

    public void m1894b(Set<String> set) {
        this.f1403k = set;
    }

    public void m1895c(int i) {
        this.f1398d = i;
    }
}
