package com.google.android.exoplayer2.p052c.p058f;

import com.google.android.exoplayer2.p050j.Assertions;
import java.util.Arrays;

/* renamed from: com.google.android.exoplayer2.c.f.m */
final class NalUnitTargetBuffer {
    public byte[] f3171a;
    public int f3172b;
    private final int f3173c;
    private boolean f3174d;
    private boolean f3175e;

    public NalUnitTargetBuffer(int i, int i2) {
        this.f3173c = i;
        this.f3171a = new byte[(i2 + 3)];
        this.f3171a[2] = (byte) 1;
    }

    public void m3655a() {
        this.f3174d = false;
        this.f3175e = false;
    }

    public boolean m3658b() {
        return this.f3175e;
    }

    public void m3656a(int i) {
        boolean z = true;
        Assertions.m4406b(!this.f3174d);
        if (i != this.f3173c) {
            z = false;
        }
        this.f3174d = z;
        if (this.f3174d) {
            this.f3172b = 3;
            this.f3175e = false;
        }
    }

    public void m3657a(byte[] bArr, int i, int i2) {
        if (this.f3174d) {
            int i3 = i2 - i;
            if (this.f3171a.length < this.f3172b + i3) {
                this.f3171a = Arrays.copyOf(this.f3171a, (this.f3172b + i3) * 2);
            }
            System.arraycopy(bArr, i, this.f3171a, this.f3172b, i3);
            this.f3172b = i3 + this.f3172b;
        }
    }

    public boolean m3659b(int i) {
        if (!this.f3174d) {
            return false;
        }
        this.f3172b -= i;
        this.f3174d = false;
        this.f3175e = true;
        return true;
    }
}
