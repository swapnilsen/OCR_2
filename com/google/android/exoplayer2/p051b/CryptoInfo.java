package com.google.android.exoplayer2.p051b;

import android.annotation.TargetApi;
import com.google.android.exoplayer2.p050j.Util;

/* renamed from: com.google.android.exoplayer2.b.b */
public final class CryptoInfo {
    public byte[] f2487a;
    public byte[] f2488b;
    public int f2489c;
    public int[] f2490d;
    public int[] f2491e;
    public int f2492f;
    private final android.media.MediaCodec.CryptoInfo f2493g;

    public CryptoInfo() {
        this.f2493g = Util.f3855a >= 16 ? m3078b() : null;
    }

    public void m3081a(int i, int[] iArr, int[] iArr2, byte[] bArr, byte[] bArr2, int i2) {
        this.f2492f = i;
        this.f2490d = iArr;
        this.f2491e = iArr2;
        this.f2488b = bArr;
        this.f2487a = bArr2;
        this.f2489c = i2;
        if (Util.f3855a >= 16) {
            m3079c();
        }
    }

    @TargetApi(16)
    public android.media.MediaCodec.CryptoInfo m3080a() {
        return this.f2493g;
    }

    @TargetApi(16)
    private android.media.MediaCodec.CryptoInfo m3078b() {
        return new android.media.MediaCodec.CryptoInfo();
    }

    @TargetApi(16)
    private void m3079c() {
        this.f2493g.set(this.f2492f, this.f2490d, this.f2491e, this.f2488b, this.f2487a, this.f2489c);
    }
}
