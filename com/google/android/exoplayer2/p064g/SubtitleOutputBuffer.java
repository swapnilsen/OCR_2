package com.google.android.exoplayer2.p064g;

import com.google.android.exoplayer2.p051b.OutputBuffer;
import java.util.List;

/* renamed from: com.google.android.exoplayer2.g.j */
public abstract class SubtitleOutputBuffer extends OutputBuffer implements Subtitle {
    private Subtitle f3427c;
    private long f3428d;

    public abstract void m4011d();

    public void m4008a(long j, Subtitle subtitle, long j2) {
        this.a = j;
        this.f3427c = subtitle;
        if (j2 == Long.MAX_VALUE) {
            j2 = this.a;
        }
        this.f3428d = j2;
    }

    public int m4009b() {
        return this.f3427c.m4003b();
    }

    public long m4006a(int i) {
        return this.f3427c.m4002a(i) + this.f3428d;
    }

    public int m4005a(long j) {
        return this.f3427c.m4001a(j - this.f3428d);
    }

    public List<Cue> m4010b(long j) {
        return this.f3427c.m4004b(j - this.f3428d);
    }

    public void m4007a() {
        super.m3073a();
        this.f3427c = null;
    }
}
