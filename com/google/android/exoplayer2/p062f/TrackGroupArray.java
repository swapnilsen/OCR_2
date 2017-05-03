package com.google.android.exoplayer2.p062f;

import java.util.Arrays;

/* renamed from: com.google.android.exoplayer2.f.i */
public final class TrackGroupArray {
    public final int f3405a;
    private final TrackGroup[] f3406b;
    private int f3407c;

    public TrackGroupArray(TrackGroup... trackGroupArr) {
        this.f3406b = trackGroupArr;
        this.f3405a = trackGroupArr.length;
    }

    public TrackGroup m3958a(int i) {
        return this.f3406b[i];
    }

    public int m3957a(TrackGroup trackGroup) {
        for (int i = 0; i < this.f3405a; i++) {
            if (this.f3406b[i] == trackGroup) {
                return i;
            }
        }
        return -1;
    }

    public int hashCode() {
        if (this.f3407c == 0) {
            this.f3407c = Arrays.hashCode(this.f3406b);
        }
        return this.f3407c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        TrackGroupArray trackGroupArray = (TrackGroupArray) obj;
        if (this.f3405a == trackGroupArray.f3405a && Arrays.equals(this.f3406b, trackGroupArray.f3406b)) {
            return true;
        }
        return false;
    }
}
