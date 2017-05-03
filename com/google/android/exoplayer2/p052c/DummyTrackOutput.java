package com.google.android.exoplayer2.p052c;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.p050j.ParsableByteArray;
import java.io.EOFException;

/* renamed from: com.google.android.exoplayer2.c.e */
public final class DummyTrackOutput implements TrackOutput {
    public void m3543a(Format format) {
    }

    public int m3541a(ExtractorInput extractorInput, int i, boolean z) {
        int a = extractorInput.m3230a(i);
        if (a != -1) {
            return a;
        }
        if (z) {
            return -1;
        }
        throw new EOFException();
    }

    public void m3544a(ParsableByteArray parsableByteArray, int i) {
        parsableByteArray.m4457d(i);
    }

    public void m3542a(long j, int i, int i2, int i3, byte[] bArr) {
    }
}
