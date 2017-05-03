package com.google.android.exoplayer2.p052c.p057e;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.p050j.ParsableByteArray;
import com.google.android.exoplayer2.p052c.ExtractorInput;
import com.google.android.exoplayer2.p052c.ExtractorOutput;
import com.google.android.exoplayer2.p052c.PositionHolder;
import com.google.android.exoplayer2.p052c.SeekMap;
import com.google.android.exoplayer2.p052c.TrackOutput;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import net.nend.android.NendAdIconLayout;
import net.nend.android.NendIconError;

/* renamed from: com.google.android.exoplayer2.c.e.h */
abstract class StreamReader {
    private OggPacket f2931a;
    private TrackOutput f2932b;
    private ExtractorOutput f2933c;
    private OggSeeker f2934d;
    private long f2935e;
    private long f2936f;
    private long f2937g;
    private int f2938h;
    private int f2939i;
    private StreamReader f2940j;
    private long f2941k;
    private boolean f2942l;
    private boolean f2943m;

    /* renamed from: com.google.android.exoplayer2.c.e.h.a */
    static class StreamReader {
        Format f2968a;
        OggSeeker f2969b;

        StreamReader() {
        }
    }

    /* renamed from: com.google.android.exoplayer2.c.e.h.b */
    private static final class StreamReader implements OggSeeker {
        private StreamReader() {
        }

        public long m3515a(ExtractorInput extractorInput) {
            return -1;
        }

        public long a_() {
            return 0;
        }

        public SeekMap m3516d() {
            return new SeekMap.SeekMap(-9223372036854775807L);
        }
    }

    protected abstract boolean m3484a(ParsableByteArray parsableByteArray, long j, StreamReader streamReader);

    protected abstract long m3486b(ParsableByteArray parsableByteArray);

    StreamReader() {
    }

    void m3482a(ExtractorOutput extractorOutput, TrackOutput trackOutput) {
        this.f2933c = extractorOutput;
        this.f2932b = trackOutput;
        this.f2931a = new OggPacket();
        m3483a(true);
    }

    protected void m3483a(boolean z) {
        if (z) {
            this.f2940j = new StreamReader();
            this.f2936f = 0;
            this.f2938h = 0;
        } else {
            this.f2938h = 1;
        }
        this.f2935e = -1;
        this.f2937g = 0;
    }

    final void m3481a(long j) {
        this.f2931a.m3504a();
        if (j == 0) {
            m3483a(!this.f2942l);
        } else if (this.f2938h != 0) {
            this.f2935e = this.f2934d.a_();
            this.f2938h = 2;
        }
    }

    final int m3480a(ExtractorInput extractorInput, PositionHolder positionHolder) {
        switch (this.f2938h) {
            case NendAdIconLayout.HORIZONTAL /*0*/:
                return m3478a(extractorInput);
            case NendIconError.ERROR_ICONVIEW /*1*/:
                extractorInput.m3235b((int) this.f2936f);
                this.f2938h = 2;
                return 0;
            case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                return m3479b(extractorInput, positionHolder);
            default:
                throw new IllegalStateException();
        }
    }

    private int m3478a(ExtractorInput extractorInput) {
        boolean z = true;
        while (z) {
            if (this.f2931a.m3505a(extractorInput)) {
                this.f2941k = extractorInput.m3238c() - this.f2936f;
                z = m3484a(this.f2931a.m3506b(), this.f2936f, this.f2940j);
                if (z) {
                    this.f2936f = extractorInput.m3238c();
                }
            } else {
                this.f2938h = 3;
                return -1;
            }
        }
        this.f2939i = this.f2940j.f2968a.f2336q;
        if (!this.f2943m) {
            this.f2932b.m3426a(this.f2940j.f2968a);
            this.f2943m = true;
        }
        if (this.f2940j.f2969b != null) {
            this.f2934d = this.f2940j.f2969b;
        } else if (extractorInput.m3241d() == -1) {
            this.f2934d = new StreamReader();
        } else {
            this.f2934d = new DefaultOggSeeker(this.f2936f, extractorInput.m3241d(), this);
        }
        this.f2940j = null;
        this.f2938h = 2;
        return 0;
    }

    private int m3479b(ExtractorInput extractorInput, PositionHolder positionHolder) {
        long a = this.f2934d.m3453a(extractorInput);
        if (a >= 0) {
            positionHolder.f3266a = a;
            return 1;
        }
        if (a < -1) {
            m3488d((-a) - 2);
        }
        if (!this.f2942l) {
            this.f2933c.m3727a(this.f2934d.m3454d());
            this.f2942l = true;
        }
        if (this.f2941k > 0 || this.f2931a.m3505a(extractorInput)) {
            this.f2941k = 0;
            ParsableByteArray b = this.f2931a.m3506b();
            long b2 = m3486b(b);
            if (b2 >= 0 && this.f2937g + b2 >= this.f2935e) {
                long b3 = m3485b(this.f2937g);
                this.f2932b.m3427a(b, b.m4454c());
                this.f2932b.m3425a(b3, 1, b.m4454c(), 0, null);
                this.f2935e = -1;
            }
            this.f2937g += b2;
            return 0;
        }
        this.f2938h = 3;
        return -1;
    }

    protected long m3485b(long j) {
        return (1000000 * j) / ((long) this.f2939i);
    }

    protected long m3487c(long j) {
        return (((long) this.f2939i) * j) / 1000000;
    }

    protected void m3488d(long j) {
        this.f2937g = j;
    }
}
