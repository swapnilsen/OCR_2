package com.google.android.exoplayer2.p050j;

/* renamed from: com.google.android.exoplayer2.j.d */
public final class ConditionVariable {
    private boolean f3799a;

    public synchronized boolean m4416a() {
        boolean z = true;
        synchronized (this) {
            if (this.f3799a) {
                z = false;
            } else {
                this.f3799a = true;
                notifyAll();
            }
        }
        return z;
    }

    public synchronized boolean m4417b() {
        boolean z;
        z = this.f3799a;
        this.f3799a = false;
        return z;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void m4418c() {
        /*
        r1 = this;
        monitor-enter(r1);
    L_0x0001:
        r0 = r1.f3799a;	 Catch:{ all -> 0x0009 }
        if (r0 != 0) goto L_0x000c;
    L_0x0005:
        r1.wait();	 Catch:{ all -> 0x0009 }
        goto L_0x0001;
    L_0x0009:
        r0 = move-exception;
        monitor-exit(r1);
        throw r0;
    L_0x000c:
        monitor-exit(r1);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.j.d.c():void");
    }
}
