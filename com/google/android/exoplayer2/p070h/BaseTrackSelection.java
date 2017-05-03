package com.google.android.exoplayer2.p070h;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.p050j.Assertions;
import com.google.android.exoplayer2.p062f.TrackGroup;
import java.util.Arrays;
import java.util.Comparator;

/* renamed from: com.google.android.exoplayer2.h.b */
public abstract class BaseTrackSelection implements TrackSelection {
    protected final TrackGroup f3613a;
    protected final int f3614b;
    protected final int[] f3615c;
    private final Format[] f3616d;
    private final long[] f3617e;
    private int f3618f;

    /* renamed from: com.google.android.exoplayer2.h.b.a */
    private static final class BaseTrackSelection implements Comparator<Format> {
        private BaseTrackSelection() {
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m4251a((Format) obj, (Format) obj2);
        }

        public int m4251a(Format format, Format format2) {
            return format2.f2321b - format.f2321b;
        }
    }

    public BaseTrackSelection(TrackGroup trackGroup, int... iArr) {
        int i = 0;
        Assertions.m4406b(iArr.length > 0);
        this.f3613a = (TrackGroup) Assertions.m4402a((Object) trackGroup);
        this.f3614b = iArr.length;
        this.f3616d = new Format[this.f3614b];
        for (int i2 = 0; i2 < iArr.length; i2++) {
            this.f3616d[i2] = trackGroup.m3956a(iArr[i2]);
        }
        Arrays.sort(this.f3616d, new BaseTrackSelection());
        this.f3615c = new int[this.f3614b];
        while (i < this.f3614b) {
            this.f3615c[i] = trackGroup.m3955a(this.f3616d[i]);
            i++;
        }
        this.f3617e = new long[this.f3614b];
    }

    public final TrackGroup m4246a() {
        return this.f3613a;
    }

    public final int m4248b() {
        return this.f3615c.length;
    }

    public final Format m4245a(int i) {
        return this.f3616d[i];
    }

    public final int m4249b(int i) {
        return this.f3615c[i];
    }

    protected final boolean m4247a(int i, long j) {
        return this.f3617e[i] > j;
    }

    public int hashCode() {
        if (this.f3618f == 0) {
            this.f3618f = (System.identityHashCode(this.f3613a) * 31) + Arrays.hashCode(this.f3615c);
        }
        return this.f3618f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        BaseTrackSelection baseTrackSelection = (BaseTrackSelection) obj;
        if (this.f3613a == baseTrackSelection.f3613a && Arrays.equals(this.f3615c, baseTrackSelection.f3615c)) {
            return true;
        }
        return false;
    }
}
