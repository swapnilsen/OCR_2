package p000a.p001a.p002a.p003a;

import android.util.Log;

/* renamed from: a.a.a.a.b */
public class DefaultLogger implements Logger {
    private int f293a;

    public DefaultLogger(int i) {
        this.f293a = i;
    }

    public DefaultLogger() {
        this.f293a = 4;
    }

    public boolean m372a(String str, int i) {
        return this.f293a <= i;
    }

    public void m371a(String str, String str2, Throwable th) {
        if (m372a(str, 3)) {
            Log.d(str, str2, th);
        }
    }

    public void m374b(String str, String str2, Throwable th) {
        if (m372a(str, 2)) {
            Log.v(str, str2, th);
        }
    }

    public void m376c(String str, String str2, Throwable th) {
        if (m372a(str, 4)) {
            Log.i(str, str2, th);
        }
    }

    public void m378d(String str, String str2, Throwable th) {
        if (m372a(str, 5)) {
            Log.w(str, str2, th);
        }
    }

    public void m380e(String str, String str2, Throwable th) {
        if (m372a(str, 6)) {
            Log.e(str, str2, th);
        }
    }

    public void m370a(String str, String str2) {
        m371a(str, str2, null);
    }

    public void m373b(String str, String str2) {
        m374b(str, str2, null);
    }

    public void m375c(String str, String str2) {
        m376c(str, str2, null);
    }

    public void m377d(String str, String str2) {
        m378d(str, str2, null);
    }

    public void m379e(String str, String str2) {
        m380e(str, str2, null);
    }

    public void m368a(int i, String str, String str2) {
        m369a(i, str, str2, false);
    }

    public void m369a(int i, String str, String str2, boolean z) {
        if (z || m372a(str, i)) {
            Log.println(i, str, str2);
        }
    }
}
