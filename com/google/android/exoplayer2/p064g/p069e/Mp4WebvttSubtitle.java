package com.google.android.exoplayer2.p064g.p069e;

import com.google.android.exoplayer2.p050j.Assertions;
import com.google.android.exoplayer2.p064g.Cue;
import com.google.android.exoplayer2.p064g.Subtitle;
import java.util.Collections;
import java.util.List;

/* renamed from: com.google.android.exoplayer2.g.e.c */
final class Mp4WebvttSubtitle implements Subtitle {
    private final List<Cue> f3506a;

    public Mp4WebvttSubtitle(List<Cue> list) {
        this.f3506a = Collections.unmodifiableList(list);
    }

    public int m4118a(long j) {
        return j < 0 ? 0 : -1;
    }

    public int m4120b() {
        return 1;
    }

    public long m4119a(int i) {
        Assertions.m4404a(i == 0);
        return 0;
    }

    public List<Cue> m4121b(long j) {
        return j >= 0 ? this.f3506a : Collections.emptyList();
    }
}
