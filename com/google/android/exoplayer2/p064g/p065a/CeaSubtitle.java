package com.google.android.exoplayer2.p064g.p065a;

import com.google.android.exoplayer2.p064g.Cue;
import com.google.android.exoplayer2.p064g.Subtitle;
import java.util.Collections;
import java.util.List;

/* renamed from: com.google.android.exoplayer2.g.a.d */
final class CeaSubtitle implements Subtitle {
    private final List<Cue> f3430a;

    public CeaSubtitle(Cue cue) {
        if (cue == null) {
            this.f3430a = Collections.emptyList();
        } else {
            this.f3430a = Collections.singletonList(cue);
        }
    }

    public int m4013a(long j) {
        return 0;
    }

    public int m4015b() {
        return 1;
    }

    public long m4014a(int i) {
        return 0;
    }

    public List<Cue> m4016b(long j) {
        return this.f3430a;
    }
}
