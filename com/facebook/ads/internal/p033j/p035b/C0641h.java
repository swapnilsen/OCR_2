package com.facebook.ads.internal.p033j.p035b;

import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.text.TextUtils;
import android.util.Log;
import com.google.api.client.http.HttpStatusCodes;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import p000a.p001a.p002a.p003a.p004a.p006b.AbstractSpiCall;

/* renamed from: com.facebook.ads.internal.j.b.h */
public class C0641h implements C0640n {
    public final String f1475a;
    private HttpURLConnection f1476b;
    private InputStream f1477c;
    private volatile int f1478d;
    private volatile String f1479e;

    public C0641h(C0641h c0641h) {
        this.f1478d = RtlSpacingHelper.UNDEFINED;
        this.f1475a = c0641h.f1475a;
        this.f1479e = c0641h.f1479e;
        this.f1478d = c0641h.f1478d;
    }

    public C0641h(String str) {
        this(str, C0647m.m2041a(str));
    }

    public C0641h(String str, String str2) {
        this.f1478d = RtlSpacingHelper.UNDEFINED;
        this.f1475a = (String) C0644j.m2038a(str);
        this.f1479e = str2;
    }

    private int m2030a(HttpURLConnection httpURLConnection, int i, int i2) {
        int contentLength = httpURLConnection.getContentLength();
        return i2 == HttpStatusCodes.STATUS_CODE_OK ? contentLength : i2 == 206 ? contentLength + i : this.f1478d;
    }

    private HttpURLConnection m2031a(int i, int i2) {
        HttpURLConnection httpURLConnection;
        String str = this.f1475a;
        int i3 = 0;
        Object obj;
        do {
            Log.d("ProxyCache", "Open connection " + (i > 0 ? " with offset " + i : FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING) + " to " + str);
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            if (i > 0) {
                httpURLConnection.setRequestProperty("Range", "bytes=" + i + "-");
            }
            if (i2 > 0) {
                httpURLConnection.setConnectTimeout(i2);
                httpURLConnection.setReadTimeout(i2);
            }
            int responseCode = httpURLConnection.getResponseCode();
            obj = (responseCode == HttpStatusCodes.STATUS_CODE_MOVED_PERMANENTLY || responseCode == HttpStatusCodes.STATUS_CODE_FOUND || responseCode == HttpStatusCodes.STATUS_CODE_SEE_OTHER) ? 1 : null;
            if (obj != null) {
                str = httpURLConnection.getHeaderField("Location");
                i3++;
                httpURLConnection.disconnect();
            }
            if (i3 > 5) {
                throw new C0642l("Too many redirects: " + i3);
            }
        } while (obj != null);
        return httpURLConnection;
    }

    private void m2032d() {
        Throwable e;
        Closeable closeable = null;
        Log.d("ProxyCache", "Read content info from " + this.f1475a);
        HttpURLConnection a;
        try {
            a = m2031a(0, AbstractSpiCall.DEFAULT_TIMEOUT);
            try {
                this.f1478d = a.getContentLength();
                this.f1479e = a.getContentType();
                closeable = a.getInputStream();
                Log.i("ProxyCache", "Content info for `" + this.f1475a + "`: mime: " + this.f1479e + ", content-length: " + this.f1478d);
                C0647m.m2043a(closeable);
                if (a != null) {
                    a.disconnect();
                }
            } catch (IOException e2) {
                e = e2;
                try {
                    Log.e("ProxyCache", "Error fetching info from " + this.f1475a, e);
                    C0647m.m2043a(closeable);
                    if (a != null) {
                        a.disconnect();
                    }
                } catch (Throwable th) {
                    e = th;
                    C0647m.m2043a(closeable);
                    if (a != null) {
                        a.disconnect();
                    }
                    throw e;
                }
            }
        } catch (IOException e3) {
            e = e3;
            a = null;
            Log.e("ProxyCache", "Error fetching info from " + this.f1475a, e);
            C0647m.m2043a(closeable);
            if (a != null) {
                a.disconnect();
            }
        } catch (Throwable th2) {
            e = th2;
            a = null;
            C0647m.m2043a(closeable);
            if (a != null) {
                a.disconnect();
            }
            throw e;
        }
    }

    public synchronized int m2033a() {
        if (this.f1478d == RtlSpacingHelper.UNDEFINED) {
            m2032d();
        }
        return this.f1478d;
    }

    public int m2034a(byte[] bArr) {
        if (this.f1477c == null) {
            throw new C0642l("Error reading data from " + this.f1475a + ": connection is absent!");
        }
        try {
            return this.f1477c.read(bArr, 0, bArr.length);
        } catch (Throwable e) {
            throw new C0643i("Reading source " + this.f1475a + " is interrupted", e);
        } catch (Throwable e2) {
            throw new C0642l("Error reading data from " + this.f1475a, e2);
        }
    }

    public void m2035a(int i) {
        try {
            this.f1476b = m2031a(i, -1);
            this.f1479e = this.f1476b.getContentType();
            this.f1477c = new BufferedInputStream(this.f1476b.getInputStream(), AccessibilityNodeInfoCompat.ACTION_SCROLL_BACKWARD);
            this.f1478d = m2030a(this.f1476b, i, this.f1476b.getResponseCode());
        } catch (Throwable e) {
            throw new C0642l("Error opening connection for " + this.f1475a + " with offset " + i, e);
        }
    }

    public void m2036b() {
        if (this.f1476b != null) {
            try {
                this.f1476b.disconnect();
            } catch (Throwable e) {
                throw new C0642l("Error disconnecting HttpUrlConnection", e);
            }
        }
    }

    public synchronized String m2037c() {
        if (TextUtils.isEmpty(this.f1479e)) {
            m2032d();
        }
        return this.f1479e;
    }

    public String toString() {
        return "HttpUrlSource{url='" + this.f1475a + "}";
    }
}
