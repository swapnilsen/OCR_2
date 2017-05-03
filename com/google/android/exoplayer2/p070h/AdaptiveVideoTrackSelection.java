package com.google.android.exoplayer2.p070h;

import com.google.android.exoplayer2.p062f.TrackGroup;
import com.google.android.exoplayer2.p063i.BandwidthMeter;
import com.google.android.exoplayer2.p070h.TrackSelection.TrackSelection;
import p000a.p001a.p002a.p003a.p004a.p006b.AbstractSpiCall;

/* renamed from: com.google.android.exoplayer2.h.a */
public class AdaptiveVideoTrackSelection extends BaseTrackSelection {
    private final BandwidthMeter f3619d;
    private final int f3620e;
    private final long f3621f;
    private final long f3622g;
    private final long f3623h;
    private final float f3624i;
    private int f3625j;
    private int f3626k;

    /* renamed from: com.google.android.exoplayer2.h.a.a */
    public static final class AdaptiveVideoTrackSelection implements TrackSelection {
        private final BandwidthMeter f3607a;
        private final int f3608b;
        private final int f3609c;
        private final int f3610d;
        private final int f3611e;
        private final float f3612f;

        public /* synthetic */ TrackSelection m4240b(TrackGroup trackGroup, int[] iArr) {
            return m4239a(trackGroup, iArr);
        }

        public AdaptiveVideoTrackSelection(BandwidthMeter bandwidthMeter) {
            this(bandwidthMeter, 800000, AbstractSpiCall.DEFAULT_TIMEOUT, 25000, 25000, 0.75f);
        }

        public AdaptiveVideoTrackSelection(BandwidthMeter bandwidthMeter, int i, int i2, int i3, int i4, float f) {
            this.f3607a = bandwidthMeter;
            this.f3608b = i;
            this.f3609c = i2;
            this.f3610d = i3;
            this.f3611e = i4;
            this.f3612f = f;
        }

        public AdaptiveVideoTrackSelection m4239a(TrackGroup trackGroup, int... iArr) {
            return new AdaptiveVideoTrackSelection(trackGroup, iArr, this.f3607a, this.f3608b, (long) this.f3609c, (long) this.f3610d, (long) this.f3611e, this.f3612f);
        }
    }

    public AdaptiveVideoTrackSelection(TrackGroup trackGroup, int[] iArr, BandwidthMeter bandwidthMeter, int i, long j, long j2, long j3, float f) {
        super(trackGroup, iArr);
        this.f3619d = bandwidthMeter;
        this.f3620e = i;
        this.f3621f = j * 1000;
        this.f3622g = j2 * 1000;
        this.f3623h = j3 * 1000;
        this.f3624i = f;
        this.f3625j = m4250a(Long.MIN_VALUE);
        this.f3626k = 1;
    }

    private int m4250a(long j) {
        int i = 0;
        long a = this.f3619d.m4338a();
        a = a == -1 ? (long) this.f3620e : (long) (((float) a) * this.f3624i);
        int i2 = 0;
        while (i < this.b) {
            if (j == Long.MIN_VALUE || !m4247a(i, j)) {
                if (((long) m4245a(i).f2321b) <= a) {
                    return i;
                }
                i2 = i;
            }
            i++;
        }
        return i2;
    }
}
