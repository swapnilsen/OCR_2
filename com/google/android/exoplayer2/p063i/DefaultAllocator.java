package com.google.android.exoplayer2.p063i;

import com.google.android.exoplayer2.p050j.Assertions;
import java.util.Arrays;

/* renamed from: com.google.android.exoplayer2.i.i */
public final class DefaultAllocator implements Allocator {
    private final boolean f3717a;
    private final int f3718b;
    private final byte[] f3719c;
    private final Allocation[] f3720d;
    private int f3721e;
    private int f3722f;
    private int f3723g;
    private Allocation[] f3724h;

    public DefaultAllocator(boolean z, int i) {
        this(z, i, 0);
    }

    public DefaultAllocator(boolean z, int i, int i2) {
        boolean z2;
        int i3 = 0;
        Assertions.m4404a(i > 0);
        if (i2 >= 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.m4404a(z2);
        this.f3717a = z;
        this.f3718b = i;
        this.f3723g = i2;
        this.f3724h = new Allocation[(i2 + 100)];
        if (i2 > 0) {
            this.f3719c = new byte[(i2 * i)];
            while (i3 < i2) {
                this.f3724h[i3] = new Allocation(this.f3719c, i3 * i);
                i3++;
            }
        } else {
            this.f3719c = null;
        }
        this.f3720d = new Allocation[1];
    }

    public synchronized void m4349d() {
        if (this.f3717a) {
            m4344a(0);
        }
    }

    public synchronized void m4344a(int i) {
        Object obj = i < this.f3721e ? 1 : null;
        this.f3721e = i;
        if (obj != null) {
            m4347b();
        }
    }

    public synchronized Allocation m4343a() {
        Allocation allocation;
        this.f3722f++;
        if (this.f3723g > 0) {
            Allocation[] allocationArr = this.f3724h;
            int i = this.f3723g - 1;
            this.f3723g = i;
            allocation = allocationArr[i];
            this.f3724h[this.f3723g] = null;
        } else {
            allocation = new Allocation(new byte[this.f3718b], 0);
        }
        return allocation;
    }

    public synchronized void m4345a(Allocation allocation) {
        this.f3720d[0] = allocation;
        m4346a(this.f3720d);
    }

    public synchronized void m4346a(Allocation[] allocationArr) {
        if (this.f3723g + allocationArr.length >= this.f3724h.length) {
            this.f3724h = (Allocation[]) Arrays.copyOf(this.f3724h, Math.max(this.f3724h.length * 2, this.f3723g + allocationArr.length));
        }
        for (Allocation allocation : allocationArr) {
            boolean z;
            if (allocation.f3694a == this.f3719c || allocation.f3694a.length == this.f3718b) {
                z = true;
            } else {
                z = false;
            }
            Assertions.m4404a(z);
            Allocation[] allocationArr2 = this.f3724h;
            int i = this.f3723g;
            this.f3723g = i + 1;
            allocationArr2[i] = allocation;
        }
        this.f3722f -= allocationArr.length;
        notifyAll();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void m4347b() {
        /*
        r7 = this;
        r1 = 0;
        monitor-enter(r7);
        r0 = r7.f3721e;	 Catch:{ all -> 0x005e }
        r2 = r7.f3718b;	 Catch:{ all -> 0x005e }
        r0 = com.google.android.exoplayer2.p050j.Util.m4507a(r0, r2);	 Catch:{ all -> 0x005e }
        r2 = 0;
        r3 = r7.f3722f;	 Catch:{ all -> 0x005e }
        r0 = r0 - r3;
        r3 = java.lang.Math.max(r2, r0);	 Catch:{ all -> 0x005e }
        r0 = r7.f3723g;	 Catch:{ all -> 0x005e }
        if (r3 < r0) goto L_0x0018;
    L_0x0016:
        monitor-exit(r7);
        return;
    L_0x0018:
        r0 = r7.f3719c;	 Catch:{ all -> 0x005e }
        if (r0 == 0) goto L_0x0061;
    L_0x001c:
        r0 = r7.f3723g;	 Catch:{ all -> 0x005e }
        r0 = r0 + -1;
    L_0x0020:
        if (r1 > r0) goto L_0x004b;
    L_0x0022:
        r2 = r7.f3724h;	 Catch:{ all -> 0x005e }
        r4 = r2[r1];	 Catch:{ all -> 0x005e }
        r2 = r4.f3694a;	 Catch:{ all -> 0x005e }
        r5 = r7.f3719c;	 Catch:{ all -> 0x005e }
        if (r2 != r5) goto L_0x002f;
    L_0x002c:
        r1 = r1 + 1;
        goto L_0x0020;
    L_0x002f:
        r2 = r7.f3724h;	 Catch:{ all -> 0x005e }
        r5 = r2[r0];	 Catch:{ all -> 0x005e }
        r2 = r5.f3694a;	 Catch:{ all -> 0x005e }
        r6 = r7.f3719c;	 Catch:{ all -> 0x005e }
        if (r2 == r6) goto L_0x003c;
    L_0x0039:
        r0 = r0 + -1;
        goto L_0x0020;
    L_0x003c:
        r6 = r7.f3724h;	 Catch:{ all -> 0x005e }
        r2 = r1 + 1;
        r6[r1] = r5;	 Catch:{ all -> 0x005e }
        r5 = r7.f3724h;	 Catch:{ all -> 0x005e }
        r1 = r0 + -1;
        r5[r0] = r4;	 Catch:{ all -> 0x005e }
        r0 = r1;
        r1 = r2;
        goto L_0x0020;
    L_0x004b:
        r0 = java.lang.Math.max(r3, r1);	 Catch:{ all -> 0x005e }
        r1 = r7.f3723g;	 Catch:{ all -> 0x005e }
        if (r0 >= r1) goto L_0x0016;
    L_0x0053:
        r1 = r7.f3724h;	 Catch:{ all -> 0x005e }
        r2 = r7.f3723g;	 Catch:{ all -> 0x005e }
        r3 = 0;
        java.util.Arrays.fill(r1, r0, r2, r3);	 Catch:{ all -> 0x005e }
        r7.f3723g = r0;	 Catch:{ all -> 0x005e }
        goto L_0x0016;
    L_0x005e:
        r0 = move-exception;
        monitor-exit(r7);
        throw r0;
    L_0x0061:
        r0 = r3;
        goto L_0x0053;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.i.i.b():void");
    }

    public synchronized int m4350e() {
        return this.f3722f * this.f3718b;
    }

    public int m4348c() {
        return this.f3718b;
    }
}
