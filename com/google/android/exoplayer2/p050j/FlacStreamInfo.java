package com.google.android.exoplayer2.p050j;

/* renamed from: com.google.android.exoplayer2.j.e */
public final class FlacStreamInfo {
    public final int f3800a;
    public final int f3801b;
    public final int f3802c;
    public final int f3803d;
    public final int f3804e;
    public final int f3805f;
    public final int f3806g;
    public final long f3807h;

    public FlacStreamInfo(byte[] bArr, int i) {
        ParsableBitArray parsableBitArray = new ParsableBitArray(bArr);
        parsableBitArray.m4442a(i * 8);
        this.f3800a = parsableBitArray.m4445c(16);
        this.f3801b = parsableBitArray.m4445c(16);
        this.f3802c = parsableBitArray.m4445c(24);
        this.f3803d = parsableBitArray.m4445c(24);
        this.f3804e = parsableBitArray.m4445c(20);
        this.f3805f = parsableBitArray.m4445c(3) + 1;
        this.f3806g = parsableBitArray.m4445c(5) + 1;
        this.f3807h = (long) parsableBitArray.m4445c(36);
    }

    public int m4419a() {
        return this.f3806g * this.f3804e;
    }

    public long m4420b() {
        return (this.f3807h * 1000000) / ((long) this.f3804e);
    }
}
