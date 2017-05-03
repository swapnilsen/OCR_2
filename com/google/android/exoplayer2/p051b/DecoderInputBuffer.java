package com.google.android.exoplayer2.p051b;

import java.nio.ByteBuffer;

/* renamed from: com.google.android.exoplayer2.b.e */
public class DecoderInputBuffer extends Buffer {
    public final CryptoInfo f2501a;
    public ByteBuffer f2502b;
    public long f2503c;
    private final int f2504d;

    public DecoderInputBuffer(int i) {
        this.f2501a = new CryptoInfo();
        this.f2504d = i;
    }

    public void m3092e(int i) {
        if (this.f2502b == null) {
            this.f2502b = m3088f(i);
            return;
        }
        int capacity = this.f2502b.capacity();
        int position = this.f2502b.position();
        int i2 = position + i;
        if (capacity < i2) {
            ByteBuffer f = m3088f(i2);
            if (position > 0) {
                this.f2502b.position(0);
                this.f2502b.limit(position);
                f.put(this.f2502b);
            }
            this.f2502b = f;
        }
    }

    public final boolean m3090d() {
        return m3077d(1073741824);
    }

    public final void m3091e() {
        this.f2502b.flip();
    }

    public void m3089a() {
        super.m3073a();
        if (this.f2502b != null) {
            this.f2502b.clear();
        }
    }

    private ByteBuffer m3088f(int i) {
        if (this.f2504d == 1) {
            return ByteBuffer.allocate(i);
        }
        if (this.f2504d == 2) {
            return ByteBuffer.allocateDirect(i);
        }
        throw new IllegalStateException("Buffer too small (" + (this.f2502b == null ? 0 : this.f2502b.capacity()) + " < " + i + ")");
    }
}
