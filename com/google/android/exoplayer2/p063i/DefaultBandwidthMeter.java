package com.google.android.exoplayer2.p063i;

import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.media.session.PlaybackStateCompat;
import com.google.android.exoplayer2.p050j.Assertions;
import com.google.android.exoplayer2.p050j.SlidingPercentile;
import com.google.android.exoplayer2.p063i.BandwidthMeter.BandwidthMeter;

/* renamed from: com.google.android.exoplayer2.i.j */
public final class DefaultBandwidthMeter implements BandwidthMeter, TransferListener<Object> {
    private final Handler f3729a;
    private final BandwidthMeter f3730b;
    private final SlidingPercentile f3731c;
    private int f3732d;
    private long f3733e;
    private long f3734f;
    private long f3735g;
    private long f3736h;
    private long f3737i;

    /* renamed from: com.google.android.exoplayer2.i.j.1 */
    class DefaultBandwidthMeter implements Runnable {
        final /* synthetic */ int f3725a;
        final /* synthetic */ long f3726b;
        final /* synthetic */ long f3727c;
        final /* synthetic */ DefaultBandwidthMeter f3728d;

        DefaultBandwidthMeter(DefaultBandwidthMeter defaultBandwidthMeter, int i, long j, long j2) {
            this.f3728d = defaultBandwidthMeter;
            this.f3725a = i;
            this.f3726b = j;
            this.f3727c = j2;
        }

        public void run() {
            this.f3728d.f3730b.m4337a(this.f3725a, this.f3726b, this.f3727c);
        }
    }

    public DefaultBandwidthMeter() {
        this(null, null);
    }

    public DefaultBandwidthMeter(Handler handler, BandwidthMeter bandwidthMeter) {
        this(handler, bandwidthMeter, 2000);
    }

    public DefaultBandwidthMeter(Handler handler, BandwidthMeter bandwidthMeter, int i) {
        this.f3729a = handler;
        this.f3730b = bandwidthMeter;
        this.f3731c = new SlidingPercentile(i);
        this.f3737i = -1;
    }

    public synchronized long m4356a() {
        return this.f3737i;
    }

    public synchronized void m4359a(Object obj, DataSpec dataSpec) {
        if (this.f3732d == 0) {
            this.f3733e = SystemClock.elapsedRealtime();
        }
        this.f3732d++;
    }

    public synchronized void m4358a(Object obj, int i) {
        this.f3734f += (long) i;
    }

    public synchronized void m4357a(Object obj) {
        Assertions.m4406b(this.f3732d > 0);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        int i = (int) (elapsedRealtime - this.f3733e);
        this.f3735g += (long) i;
        this.f3736h += this.f3734f;
        if (i > 0) {
            this.f3731c.m4496a((int) Math.sqrt((double) this.f3734f), (float) ((this.f3734f * 8000) / ((long) i)));
            if (this.f3735g >= 2000 || this.f3736h >= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED) {
                float a = this.f3731c.m4495a(0.5f);
                this.f3737i = Float.isNaN(a) ? -1 : (long) a;
            }
        }
        m4355a(i, this.f3734f, this.f3737i);
        int i2 = this.f3732d - 1;
        this.f3732d = i2;
        if (i2 > 0) {
            this.f3733e = elapsedRealtime;
        }
        this.f3734f = 0;
    }

    private void m4355a(int i, long j, long j2) {
        if (this.f3729a != null && this.f3730b != null) {
            this.f3729a.post(new DefaultBandwidthMeter(this, i, j, j2));
        }
    }
}
