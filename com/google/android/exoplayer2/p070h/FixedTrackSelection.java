package com.google.android.exoplayer2.p070h;

import com.google.android.exoplayer2.p062f.TrackGroup;

/* renamed from: com.google.android.exoplayer2.h.d */
public final class FixedTrackSelection extends BaseTrackSelection {
    private final int f3646d;
    private final Object f3647e;

    public FixedTrackSelection(TrackGroup trackGroup, int i) {
        this(trackGroup, i, 0, null);
    }

    public FixedTrackSelection(TrackGroup trackGroup, int i, int i2, Object obj) {
        super(trackGroup, i);
        this.f3646d = i2;
        this.f3647e = obj;
    }
}
