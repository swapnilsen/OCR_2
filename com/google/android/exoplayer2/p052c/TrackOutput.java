package com.google.android.exoplayer2.p052c;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.p050j.ParsableByteArray;

/* renamed from: com.google.android.exoplayer2.c.o */
public interface TrackOutput {
    int m3424a(ExtractorInput extractorInput, int i, boolean z);

    void m3425a(long j, int i, int i2, int i3, byte[] bArr);

    void m3426a(Format format);

    void m3427a(ParsableByteArray parsableByteArray, int i);
}
