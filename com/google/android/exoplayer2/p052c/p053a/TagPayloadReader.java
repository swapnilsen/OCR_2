package com.google.android.exoplayer2.p052c.p053a;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.p050j.ParsableByteArray;
import com.google.android.exoplayer2.p052c.TrackOutput;

/* renamed from: com.google.android.exoplayer2.c.a.d */
abstract class TagPayloadReader {
    protected final TrackOutput f2525a;

    /* renamed from: com.google.android.exoplayer2.c.a.d.a */
    public static final class TagPayloadReader extends ParserException {
        public TagPayloadReader(String str) {
            super(str);
        }
    }

    protected abstract void m3116a(ParsableByteArray parsableByteArray, long j);

    protected abstract boolean m3117a(ParsableByteArray parsableByteArray);

    protected TagPayloadReader(TrackOutput trackOutput) {
        this.f2525a = trackOutput;
    }

    public final void m3118b(ParsableByteArray parsableByteArray, long j) {
        if (m3117a(parsableByteArray)) {
            m3116a(parsableByteArray, j);
        }
    }
}
