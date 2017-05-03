package com.google.android.exoplayer2.p064g;

import com.google.android.exoplayer2.p051b.DecoderInputBuffer;

/* renamed from: com.google.android.exoplayer2.g.i */
public final class SubtitleInputBuffer extends DecoderInputBuffer implements Comparable<SubtitleInputBuffer> {
    public long f3558d;

    public /* synthetic */ int compareTo(Object obj) {
        return m4194a((SubtitleInputBuffer) obj);
    }

    public SubtitleInputBuffer() {
        super(1);
    }

    public int m4194a(SubtitleInputBuffer subtitleInputBuffer) {
        long j = this.c - subtitleInputBuffer.c;
        if (j == 0) {
            return 0;
        }
        return j > 0 ? 1 : -1;
    }
}
