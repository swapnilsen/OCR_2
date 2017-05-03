package com.google.android.exoplayer2.p062f;

import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.p050j.Assertions;

/* renamed from: com.google.android.exoplayer2.f.g */
public final class SinglePeriodTimeline extends Timeline {
    private static final Object f3395a;
    private final long f3396b;
    private final long f3397c;
    private final long f3398d;
    private final long f3399e;
    private final boolean f3400f;
    private final boolean f3401g;

    static {
        f3395a = new Object();
    }

    public SinglePeriodTimeline(long j, boolean z) {
        this(j, j, 0, 0, z, false);
    }

    public SinglePeriodTimeline(long j, long j2, long j3, long j4, boolean z, boolean z2) {
        this.f3396b = j;
        this.f3397c = j2;
        this.f3398d = j3;
        this.f3399e = j4;
        this.f3400f = z;
        this.f3401g = z2;
    }

    public int m3950a() {
        return 1;
    }

    public Timeline.Timeline m3953a(int i, Timeline.Timeline timeline, boolean z) {
        Assertions.m4401a(i, 0, 1);
        return timeline.m4657a(z ? f3395a : null, -9223372036854775807L, -9223372036854775807L, this.f3400f, this.f3401g, this.f3399e, this.f3397c, 0, 0, this.f3398d);
    }

    public int m3954b() {
        return 1;
    }

    public Timeline.Timeline m3952a(int i, Timeline.Timeline timeline, boolean z) {
        Assertions.m4401a(i, 0, 1);
        Object obj = z ? f3395a : null;
        return timeline.m4653a(obj, obj, 0, this.f3396b, -this.f3398d);
    }

    public int m3951a(Object obj) {
        return f3395a.equals(obj) ? 0 : -1;
    }
}
