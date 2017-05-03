package com.google.android.exoplayer2.p052c.p056d;

import com.google.android.exoplayer2.Format;

/* renamed from: com.google.android.exoplayer2.c.d.i */
public final class Track {
    public final int f2855a;
    public final int f2856b;
    public final long f2857c;
    public final long f2858d;
    public final long f2859e;
    public final Format f2860f;
    public final int f2861g;
    public final TrackEncryptionBox[] f2862h;
    public final long[] f2863i;
    public final long[] f2864j;
    public final int f2865k;

    public Track(int i, int i2, long j, long j2, long j3, Format format, int i3, TrackEncryptionBox[] trackEncryptionBoxArr, int i4, long[] jArr, long[] jArr2) {
        this.f2855a = i;
        this.f2856b = i2;
        this.f2857c = j;
        this.f2858d = j2;
        this.f2859e = j3;
        this.f2860f = format;
        this.f2861g = i3;
        this.f2862h = trackEncryptionBoxArr;
        this.f2865k = i4;
        this.f2863i = jArr;
        this.f2864j = jArr2;
    }
}
