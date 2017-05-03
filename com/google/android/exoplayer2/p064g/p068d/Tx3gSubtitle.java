package com.google.android.exoplayer2.p064g.p068d;

import com.google.android.exoplayer2.p050j.Assertions;
import com.google.android.exoplayer2.p064g.Cue;
import com.google.android.exoplayer2.p064g.Subtitle;
import java.util.Collections;
import java.util.List;

/* renamed from: com.google.android.exoplayer2.g.d.b */
final class Tx3gSubtitle implements Subtitle {
    public static final Tx3gSubtitle f3495a;
    private final List<Cue> f3496b;

    static {
        f3495a = new Tx3gSubtitle();
    }

    public Tx3gSubtitle(Cue cue) {
        this.f3496b = Collections.singletonList(cue);
    }

    private Tx3gSubtitle() {
        this.f3496b = Collections.emptyList();
    }

    public int m4097a(long j) {
        return j < 0 ? 0 : -1;
    }

    public int m4099b() {
        return 1;
    }

    public long m4098a(int i) {
        Assertions.m4404a(i == 0);
        return 0;
    }

    public List<Cue> m4100b(long j) {
        return j >= 0 ? this.f3496b : Collections.emptyList();
    }
}
