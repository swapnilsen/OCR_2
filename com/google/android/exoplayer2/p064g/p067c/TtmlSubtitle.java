package com.google.android.exoplayer2.p064g.p067c;

import com.google.android.exoplayer2.p050j.Util;
import com.google.android.exoplayer2.p064g.Cue;
import com.google.android.exoplayer2.p064g.Subtitle;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.android.exoplayer2.g.c.f */
final class TtmlSubtitle implements Subtitle {
    private final TtmlNode f3490a;
    private final long[] f3491b;
    private final Map<String, TtmlStyle> f3492c;
    private final Map<String, TtmlRegion> f3493d;

    public TtmlSubtitle(TtmlNode ttmlNode, Map<String, TtmlStyle> map, Map<String, TtmlRegion> map2) {
        this.f3490a = ttmlNode;
        this.f3493d = map2;
        this.f3492c = map != null ? Collections.unmodifiableMap(map) : Collections.emptyMap();
        this.f3491b = ttmlNode.m4062b();
    }

    public int m4092a(long j) {
        int b = Util.m4520b(this.f3491b, j, false, false);
        return b < this.f3491b.length ? b : -1;
    }

    public int m4094b() {
        return this.f3491b.length;
    }

    public long m4093a(int i) {
        return this.f3491b[i];
    }

    public List<Cue> m4095b(long j) {
        return this.f3490a.m4059a(j, this.f3492c, this.f3493d);
    }
}
