package com.google.android.exoplayer2.p064g.p066b;

import com.google.android.exoplayer2.p050j.Assertions;
import com.google.android.exoplayer2.p050j.Util;
import com.google.android.exoplayer2.p064g.Cue;
import com.google.android.exoplayer2.p064g.Subtitle;
import java.util.Collections;
import java.util.List;

/* renamed from: com.google.android.exoplayer2.g.b.b */
final class SubripSubtitle implements Subtitle {
    private final Cue[] f3442a;
    private final long[] f3443b;

    public SubripSubtitle(Cue[] cueArr, long[] jArr) {
        this.f3442a = cueArr;
        this.f3443b = jArr;
    }

    public int m4033a(long j) {
        int b = Util.m4520b(this.f3443b, j, false, false);
        return b < this.f3443b.length ? b : -1;
    }

    public int m4035b() {
        return this.f3443b.length;
    }

    public long m4034a(int i) {
        boolean z;
        boolean z2 = true;
        if (i >= 0) {
            z = true;
        } else {
            z = false;
        }
        Assertions.m4404a(z);
        if (i >= this.f3443b.length) {
            z2 = false;
        }
        Assertions.m4404a(z2);
        return this.f3443b[i];
    }

    public List<Cue> m4036b(long j) {
        int a = Util.m4509a(this.f3443b, j, true, false);
        if (a == -1 || this.f3442a[a] == null) {
            return Collections.emptyList();
        }
        return Collections.singletonList(this.f3442a[a]);
    }
}
