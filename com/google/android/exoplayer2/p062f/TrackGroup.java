package com.google.android.exoplayer2.p062f;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.p050j.Assertions;
import java.util.Arrays;

/* renamed from: com.google.android.exoplayer2.f.h */
public final class TrackGroup {
    public final int f3402a;
    private final Format[] f3403b;
    private int f3404c;

    public TrackGroup(Format... formatArr) {
        Assertions.m4406b(formatArr.length > 0);
        this.f3403b = formatArr;
        this.f3402a = formatArr.length;
    }

    public Format m3956a(int i) {
        return this.f3403b[i];
    }

    public int m3955a(Format format) {
        for (int i = 0; i < this.f3403b.length; i++) {
            if (format == this.f3403b[i]) {
                return i;
            }
        }
        return -1;
    }

    public int hashCode() {
        if (this.f3404c == 0) {
            this.f3404c = Arrays.hashCode(this.f3403b) + 527;
        }
        return this.f3404c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        TrackGroup trackGroup = (TrackGroup) obj;
        if (this.f3402a == trackGroup.f3402a && Arrays.equals(this.f3403b, trackGroup.f3403b)) {
            return true;
        }
        return false;
    }
}
