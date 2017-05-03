package com.google.android.exoplayer2.p063i;

import android.net.Uri;
import com.google.android.exoplayer2.p050j.Assertions;
import java.util.Arrays;

/* renamed from: com.google.android.exoplayer2.i.h */
public final class DataSpec {
    public final Uri f3710a;
    public final byte[] f3711b;
    public final long f3712c;
    public final long f3713d;
    public final long f3714e;
    public final String f3715f;
    public final int f3716g;

    public DataSpec(Uri uri, long j, long j2, String str) {
        this(uri, j, j, j2, str, 0);
    }

    public DataSpec(Uri uri, long j, long j2, long j3, String str, int i) {
        this(uri, null, j, j2, j3, str, i);
    }

    public DataSpec(Uri uri, byte[] bArr, long j, long j2, long j3, String str, int i) {
        Assertions.m4404a(j >= 0);
        Assertions.m4404a(j2 >= 0);
        boolean z = j3 > 0 || j3 == -1;
        Assertions.m4404a(z);
        this.f3710a = uri;
        this.f3711b = bArr;
        this.f3712c = j;
        this.f3713d = j2;
        this.f3714e = j3;
        this.f3715f = str;
        this.f3716g = i;
    }

    public String toString() {
        return "DataSpec[" + this.f3710a + ", " + Arrays.toString(this.f3711b) + ", " + this.f3712c + ", " + this.f3713d + ", " + this.f3714e + ", " + this.f3715f + ", " + this.f3716g + "]";
    }
}
