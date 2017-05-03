package p000a.p001a.p002a.p003a.p004a.p006b;

import android.os.SystemClock;
import android.util.Log;

/* renamed from: a.a.a.a.a.b.t */
public class TimingMetric {
    private final String f90a;
    private final String f91b;
    private final boolean f92c;
    private long f93d;
    private long f94e;

    public TimingMetric(String str, String str2) {
        this.f90a = str;
        this.f91b = str2;
        this.f92c = !Log.isLoggable(str2, 2);
    }

    public synchronized void m142a() {
        if (!this.f92c) {
            this.f93d = SystemClock.elapsedRealtime();
            this.f94e = 0;
        }
    }

    public synchronized void m143b() {
        if (!this.f92c) {
            if (this.f94e == 0) {
                this.f94e = SystemClock.elapsedRealtime() - this.f93d;
                m141c();
            }
        }
    }

    private void m141c() {
        Log.v(this.f91b, this.f90a + ": " + this.f94e + "ms");
    }
}
