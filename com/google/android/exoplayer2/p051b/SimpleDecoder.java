package com.google.android.exoplayer2.p051b;

import com.google.android.exoplayer2.p050j.Assertions;
import java.util.LinkedList;

/* renamed from: com.google.android.exoplayer2.b.g */
public abstract class SimpleDecoder<I extends DecoderInputBuffer, O extends OutputBuffer, E extends Exception> implements Decoder<I, O, E> {
    private final Thread f2508a;
    private final Object f2509b;
    private final LinkedList<I> f2510c;
    private final LinkedList<O> f2511d;
    private final I[] f2512e;
    private final O[] f2513f;
    private int f2514g;
    private int f2515h;
    private I f2516i;
    private E f2517j;
    private boolean f2518k;
    private boolean f2519l;
    private int f2520m;

    /* renamed from: com.google.android.exoplayer2.b.g.1 */
    class SimpleDecoder extends Thread {
        final /* synthetic */ SimpleDecoder f2507a;

        SimpleDecoder(SimpleDecoder simpleDecoder) {
            this.f2507a = simpleDecoder;
        }

        public void run() {
            this.f2507a.m3098k();
        }
    }

    protected abstract E m3101a(I i, O o, boolean z);

    protected abstract I m3112g();

    protected abstract O m3113h();

    public /* synthetic */ Object m3102a() {
        return m3110e();
    }

    public /* synthetic */ Object m3107b() {
        return m3111f();
    }

    protected SimpleDecoder(I[] iArr, O[] oArr) {
        int i = 0;
        this.f2509b = new Object();
        this.f2510c = new LinkedList();
        this.f2511d = new LinkedList();
        this.f2512e = iArr;
        this.f2514g = iArr.length;
        for (int i2 = 0; i2 < this.f2514g; i2++) {
            this.f2512e[i2] = m3112g();
        }
        this.f2513f = oArr;
        this.f2515h = oArr.length;
        while (i < this.f2515h) {
            this.f2513f[i] = m3113h();
            i++;
        }
        this.f2508a = new SimpleDecoder(this);
        this.f2508a.start();
    }

    protected final void m3103a(int i) {
        boolean z;
        int i2 = 0;
        if (this.f2514g == this.f2512e.length) {
            z = true;
        } else {
            z = false;
        }
        Assertions.m4406b(z);
        DecoderInputBuffer[] decoderInputBufferArr = this.f2512e;
        int length = decoderInputBufferArr.length;
        while (i2 < length) {
            decoderInputBufferArr[i2].m3092e(i);
            i2++;
        }
    }

    public final I m3110e() {
        I i;
        synchronized (this.f2509b) {
            DecoderInputBuffer decoderInputBuffer;
            m3096i();
            Assertions.m4406b(this.f2516i == null);
            if (this.f2514g == 0) {
                decoderInputBuffer = null;
            } else {
                DecoderInputBuffer[] decoderInputBufferArr = this.f2512e;
                int i2 = this.f2514g - 1;
                this.f2514g = i2;
                decoderInputBuffer = decoderInputBufferArr[i2];
            }
            this.f2516i = decoderInputBuffer;
            i = this.f2516i;
        }
        return i;
    }

    public final void m3104a(I i) {
        synchronized (this.f2509b) {
            m3096i();
            Assertions.m4404a(i == this.f2516i);
            this.f2510c.addLast(i);
            m3097j();
            this.f2516i = null;
        }
    }

    public final O m3111f() {
        O o;
        synchronized (this.f2509b) {
            m3096i();
            if (this.f2511d.isEmpty()) {
                o = null;
            } else {
                OutputBuffer outputBuffer = (OutputBuffer) this.f2511d.removeFirst();
            }
        }
        return o;
    }

    protected void m3105a(O o) {
        synchronized (this.f2509b) {
            m3095b((OutputBuffer) o);
            m3097j();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m3108c() {
        /*
        r2 = this;
        r1 = r2.f2509b;
        monitor-enter(r1);
        r0 = 1;
        r2.f2518k = r0;	 Catch:{ all -> 0x0029 }
        r0 = 0;
        r2.f2520m = r0;	 Catch:{ all -> 0x0029 }
        r0 = r2.f2516i;	 Catch:{ all -> 0x0029 }
        if (r0 == 0) goto L_0x0015;
    L_0x000d:
        r0 = r2.f2516i;	 Catch:{ all -> 0x0029 }
        r2.m3094b(r0);	 Catch:{ all -> 0x0029 }
        r0 = 0;
        r2.f2516i = r0;	 Catch:{ all -> 0x0029 }
    L_0x0015:
        r0 = r2.f2510c;	 Catch:{ all -> 0x0029 }
        r0 = r0.isEmpty();	 Catch:{ all -> 0x0029 }
        if (r0 != 0) goto L_0x002c;
    L_0x001d:
        r0 = r2.f2510c;	 Catch:{ all -> 0x0029 }
        r0 = r0.removeFirst();	 Catch:{ all -> 0x0029 }
        r0 = (com.google.android.exoplayer2.p051b.DecoderInputBuffer) r0;	 Catch:{ all -> 0x0029 }
        r2.m3094b(r0);	 Catch:{ all -> 0x0029 }
        goto L_0x0015;
    L_0x0029:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0029 }
        throw r0;
    L_0x002c:
        r0 = r2.f2511d;	 Catch:{ all -> 0x0029 }
        r0 = r0.isEmpty();	 Catch:{ all -> 0x0029 }
        if (r0 != 0) goto L_0x0040;
    L_0x0034:
        r0 = r2.f2511d;	 Catch:{ all -> 0x0029 }
        r0 = r0.removeFirst();	 Catch:{ all -> 0x0029 }
        r0 = (com.google.android.exoplayer2.p051b.OutputBuffer) r0;	 Catch:{ all -> 0x0029 }
        r2.m3095b(r0);	 Catch:{ all -> 0x0029 }
        goto L_0x002c;
    L_0x0040:
        monitor-exit(r1);	 Catch:{ all -> 0x0029 }
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.b.g.c():void");
    }

    public void m3109d() {
        synchronized (this.f2509b) {
            this.f2519l = true;
            this.f2509b.notify();
        }
        try {
            this.f2508a.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void m3096i() {
        if (this.f2517j != null) {
            throw this.f2517j;
        }
    }

    private void m3097j() {
        if (m3100m()) {
            this.f2509b.notify();
        }
    }

    private void m3098k() {
        do {
            try {
            } catch (Throwable e) {
                throw new IllegalStateException(e);
            }
        } while (m3099l());
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m3099l() {
        /*
        r6 = this;
        r1 = 0;
        r2 = r6.f2509b;
        monitor-enter(r2);
    L_0x0004:
        r0 = r6.f2519l;	 Catch:{ all -> 0x0014 }
        if (r0 != 0) goto L_0x0017;
    L_0x0008:
        r0 = r6.m3100m();	 Catch:{ all -> 0x0014 }
        if (r0 != 0) goto L_0x0017;
    L_0x000e:
        r0 = r6.f2509b;	 Catch:{ all -> 0x0014 }
        r0.wait();	 Catch:{ all -> 0x0014 }
        goto L_0x0004;
    L_0x0014:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x0014 }
        throw r0;
    L_0x0017:
        r0 = r6.f2519l;	 Catch:{ all -> 0x0014 }
        if (r0 == 0) goto L_0x001e;
    L_0x001b:
        monitor-exit(r2);	 Catch:{ all -> 0x0014 }
        r0 = r1;
    L_0x001d:
        return r0;
    L_0x001e:
        r0 = r6.f2510c;	 Catch:{ all -> 0x0014 }
        r0 = r0.removeFirst();	 Catch:{ all -> 0x0014 }
        r0 = (com.google.android.exoplayer2.p051b.DecoderInputBuffer) r0;	 Catch:{ all -> 0x0014 }
        r3 = r6.f2513f;	 Catch:{ all -> 0x0014 }
        r4 = r6.f2515h;	 Catch:{ all -> 0x0014 }
        r4 = r4 + -1;
        r6.f2515h = r4;	 Catch:{ all -> 0x0014 }
        r3 = r3[r4];	 Catch:{ all -> 0x0014 }
        r4 = r6.f2518k;	 Catch:{ all -> 0x0014 }
        r5 = 0;
        r6.f2518k = r5;	 Catch:{ all -> 0x0014 }
        monitor-exit(r2);	 Catch:{ all -> 0x0014 }
        r2 = r0.m3076c();
        if (r2 == 0) goto L_0x0050;
    L_0x003c:
        r1 = 4;
        r3.m3074b(r1);
    L_0x0040:
        r1 = r6.f2509b;
        monitor-enter(r1);
        r2 = r6.f2518k;	 Catch:{ all -> 0x007e }
        if (r2 == 0) goto L_0x006e;
    L_0x0047:
        r6.m3095b(r3);	 Catch:{ all -> 0x007e }
    L_0x004a:
        r6.m3094b(r0);	 Catch:{ all -> 0x007e }
        monitor-exit(r1);	 Catch:{ all -> 0x007e }
        r0 = 1;
        goto L_0x001d;
    L_0x0050:
        r2 = r0.b_();
        if (r2 == 0) goto L_0x005b;
    L_0x0056:
        r2 = -2147483648; // 0xffffffff80000000 float:-0.0 double:NaN;
        r3.m3074b(r2);
    L_0x005b:
        r2 = r6.m3101a(r0, r3, r4);
        r6.f2517j = r2;
        r2 = r6.f2517j;
        if (r2 == 0) goto L_0x0040;
    L_0x0065:
        r2 = r6.f2509b;
        monitor-enter(r2);
        monitor-exit(r2);	 Catch:{ all -> 0x006b }
        r0 = r1;
        goto L_0x001d;
    L_0x006b:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x006b }
        throw r0;
    L_0x006e:
        r2 = r3.b_();	 Catch:{ all -> 0x007e }
        if (r2 == 0) goto L_0x0081;
    L_0x0074:
        r2 = r6.f2520m;	 Catch:{ all -> 0x007e }
        r2 = r2 + 1;
        r6.f2520m = r2;	 Catch:{ all -> 0x007e }
        r6.m3095b(r3);	 Catch:{ all -> 0x007e }
        goto L_0x004a;
    L_0x007e:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x007e }
        throw r0;
    L_0x0081:
        r2 = r6.f2520m;	 Catch:{ all -> 0x007e }
        r3.f2506b = r2;	 Catch:{ all -> 0x007e }
        r2 = 0;
        r6.f2520m = r2;	 Catch:{ all -> 0x007e }
        r2 = r6.f2511d;	 Catch:{ all -> 0x007e }
        r2.addLast(r3);	 Catch:{ all -> 0x007e }
        goto L_0x004a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.b.g.l():boolean");
    }

    private boolean m3100m() {
        return !this.f2510c.isEmpty() && this.f2515h > 0;
    }

    private void m3094b(I i) {
        i.m3089a();
        DecoderInputBuffer[] decoderInputBufferArr = this.f2512e;
        int i2 = this.f2514g;
        this.f2514g = i2 + 1;
        decoderInputBufferArr[i2] = i;
    }

    private void m3095b(O o) {
        o.m3073a();
        OutputBuffer[] outputBufferArr = this.f2513f;
        int i = this.f2515h;
        this.f2515h = i + 1;
        outputBufferArr[i] = o;
    }
}
