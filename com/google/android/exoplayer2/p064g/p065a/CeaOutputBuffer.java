package com.google.android.exoplayer2.p064g.p065a;

import com.google.android.exoplayer2.p064g.SubtitleOutputBuffer;

/* renamed from: com.google.android.exoplayer2.g.a.c */
public final class CeaOutputBuffer extends SubtitleOutputBuffer {
    private final CeaDecoder f3429c;

    public CeaOutputBuffer(CeaDecoder ceaDecoder) {
        this.f3429c = ceaDecoder;
    }

    public final void m4012d() {
        this.f3429c.m3968a((SubtitleOutputBuffer) this);
    }
}
