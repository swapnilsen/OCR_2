package com.google.android.exoplayer2.p050j;

import android.os.SystemClock;

/* renamed from: com.google.android.exoplayer2.j.p */
public final class StandaloneMediaClock implements MediaClock {
    private boolean f3851a;
    private long f3852b;
    private long f3853c;

    public void m4498a() {
        if (!this.f3851a) {
            this.f3851a = true;
            this.f3853c = m4497b(this.f3852b);
        }
    }

    public void m4500b() {
        if (this.f3851a) {
            this.f3852b = m4497b(this.f3853c);
            this.f3851a = false;
        }
    }

    public void m4499a(long j) {
        this.f3852b = j;
        this.f3853c = m4497b(j);
    }

    public long m4501t() {
        return this.f3851a ? m4497b(this.f3853c) : this.f3852b;
    }

    private long m4497b(long j) {
        return (SystemClock.elapsedRealtime() * 1000) - j;
    }
}
