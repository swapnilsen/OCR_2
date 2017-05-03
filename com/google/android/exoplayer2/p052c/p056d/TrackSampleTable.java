package com.google.android.exoplayer2.p052c.p056d;

import com.google.android.exoplayer2.p050j.Assertions;
import com.google.android.exoplayer2.p050j.Util;

/* renamed from: com.google.android.exoplayer2.c.d.l */
final class TrackSampleTable {
    public final int f2888a;
    public final long[] f2889b;
    public final int[] f2890c;
    public final int f2891d;
    public final long[] f2892e;
    public final int[] f2893f;

    public TrackSampleTable(long[] jArr, int[] iArr, int i, long[] jArr2, int[] iArr2) {
        boolean z;
        boolean z2 = true;
        Assertions.m4404a(iArr.length == jArr2.length);
        if (jArr.length == jArr2.length) {
            z = true;
        } else {
            z = false;
        }
        Assertions.m4404a(z);
        if (iArr2.length != jArr2.length) {
            z2 = false;
        }
        Assertions.m4404a(z2);
        this.f2889b = jArr;
        this.f2890c = iArr;
        this.f2891d = i;
        this.f2892e = jArr2;
        this.f2893f = iArr2;
        this.f2888a = jArr.length;
    }

    public int m3422a(long j) {
        for (int a = Util.m4509a(this.f2892e, j, true, false); a >= 0; a--) {
            if ((this.f2893f[a] & 1) != 0) {
                return a;
            }
        }
        return -1;
    }

    public int m3423b(long j) {
        for (int b = Util.m4520b(this.f2892e, j, true, false); b < this.f2892e.length; b++) {
            if ((this.f2893f[b] & 1) != 0) {
                return b;
            }
        }
        return -1;
    }
}
