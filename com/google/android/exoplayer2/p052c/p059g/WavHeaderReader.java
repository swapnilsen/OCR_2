package com.google.android.exoplayer2.p052c.p059g;

import android.util.Log;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.p050j.Assertions;
import com.google.android.exoplayer2.p050j.ParsableByteArray;
import com.google.android.exoplayer2.p050j.Util;
import com.google.android.exoplayer2.p052c.ExtractorInput;

/* renamed from: com.google.android.exoplayer2.c.g.c */
final class WavHeaderReader {

    /* renamed from: com.google.android.exoplayer2.c.g.c.a */
    private static final class WavHeaderReader {
        public final int f3247a;
        public final long f3248b;

        private WavHeaderReader(int i, long j) {
            this.f3247a = i;
            this.f3248b = j;
        }

        public static WavHeaderReader m3722a(ExtractorInput extractorInput, ParsableByteArray parsableByteArray) {
            extractorInput.m3240c(parsableByteArray.f3831a, 0, 8);
            parsableByteArray.m4455c(0);
            return new WavHeaderReader(parsableByteArray.m4468n(), parsableByteArray.m4467m());
        }
    }

    public static WavHeader m3723a(ExtractorInput extractorInput) {
        Assertions.m4402a((Object) extractorInput);
        ParsableByteArray parsableByteArray = new ParsableByteArray(16);
        if (WavHeaderReader.m3722a(extractorInput, parsableByteArray).f3247a != Util.m4524e("RIFF")) {
            return null;
        }
        extractorInput.m3240c(parsableByteArray.f3831a, 0, 4);
        parsableByteArray.m4455c(0);
        int n = parsableByteArray.m4468n();
        if (n != Util.m4524e("WAVE")) {
            Log.e("WavHeaderReader", "Unsupported RIFF format: " + n);
            return null;
        }
        WavHeaderReader a = WavHeaderReader.m3722a(extractorInput, parsableByteArray);
        while (a.f3247a != Util.m4524e("fmt ")) {
            extractorInput.m3239c((int) a.f3248b);
            a = WavHeaderReader.m3722a(extractorInput, parsableByteArray);
        }
        Assertions.m4406b(a.f3248b >= 16);
        extractorInput.m3240c(parsableByteArray.f3831a, 0, 16);
        parsableByteArray.m4455c(0);
        int i = parsableByteArray.m4463i();
        int i2 = parsableByteArray.m4463i();
        int u = parsableByteArray.m4475u();
        int u2 = parsableByteArray.m4475u();
        int i3 = parsableByteArray.m4463i();
        int i4 = parsableByteArray.m4463i();
        int i5 = (i2 * i4) / 8;
        if (i3 != i5) {
            throw new ParserException("Expected block alignment: " + i5 + "; got: " + i3);
        }
        i5 = Util.m4506a(i4);
        if (i5 == 0) {
            Log.e("WavHeaderReader", "Unsupported WAV bit depth: " + i4);
            return null;
        } else if (i == 1 || i == 65534) {
            extractorInput.m3239c(((int) a.f3248b) - 16);
            return new WavHeader(i2, u, u2, i3, i4, i5);
        } else {
            Log.e("WavHeaderReader", "Unsupported WAV format type: " + i);
            return null;
        }
    }

    public static void m3724a(ExtractorInput extractorInput, WavHeader wavHeader) {
        Assertions.m4402a((Object) extractorInput);
        Assertions.m4402a((Object) wavHeader);
        extractorInput.m3232a();
        ParsableByteArray parsableByteArray = new ParsableByteArray(8);
        WavHeaderReader a = WavHeaderReader.m3722a(extractorInput, parsableByteArray);
        while (a.f3247a != Util.m4524e("data")) {
            Log.w("WavHeaderReader", "Ignoring unknown WAV chunk: " + a.f3247a);
            long j = 8 + a.f3248b;
            if (a.f3247a == Util.m4524e("RIFF")) {
                j = 12;
            }
            if (j > 2147483647L) {
                throw new ParserException("Chunk is too large (~2GB+) to skip; id: " + a.f3247a);
            }
            extractorInput.m3235b((int) j);
            a = WavHeaderReader.m3722a(extractorInput, parsableByteArray);
        }
        extractorInput.m3235b(8);
        wavHeader.m3714a(extractorInput.m3238c(), a.f3248b);
    }
}
