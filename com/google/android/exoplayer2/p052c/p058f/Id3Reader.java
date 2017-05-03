package com.google.android.exoplayer2.p052c.p058f;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.p050j.ParsableByteArray;
import com.google.android.exoplayer2.p052c.ExtractorOutput;
import com.google.android.exoplayer2.p052c.TrackOutput;
import com.google.android.exoplayer2.p052c.p058f.ElementaryStreamReader.ElementaryStreamReader;

/* renamed from: com.google.android.exoplayer2.c.f.k */
final class Id3Reader extends ElementaryStreamReader {
    private final ParsableByteArray f3154a;
    private TrackOutput f3155b;
    private boolean f3156c;
    private long f3157d;
    private int f3158e;
    private int f3159f;

    public Id3Reader() {
        this.f3154a = new ParsableByteArray(10);
    }

    public void m3642a() {
        this.f3156c = false;
    }

    public void m3644a(ExtractorOutput extractorOutput, ElementaryStreamReader elementaryStreamReader) {
        this.f3155b = extractorOutput.m3725a(elementaryStreamReader.m3594a());
        this.f3155b.m3426a(Format.m2865a(null, "application/id3", null, -1, null));
    }

    public void m3643a(long j, boolean z) {
        if (z) {
            this.f3156c = true;
            this.f3157d = j;
            this.f3158e = 0;
            this.f3159f = 0;
        }
    }

    public void m3645a(ParsableByteArray parsableByteArray) {
        if (this.f3156c) {
            int b = parsableByteArray.m4452b();
            if (this.f3159f < 10) {
                int min = Math.min(b, 10 - this.f3159f);
                System.arraycopy(parsableByteArray.f3831a, parsableByteArray.m4456d(), this.f3154a.f3831a, this.f3159f, min);
                if (min + this.f3159f == 10) {
                    this.f3154a.m4455c(6);
                    this.f3158e = this.f3154a.m4473s() + 10;
                }
            }
            b = Math.min(b, this.f3158e - this.f3159f);
            this.f3155b.m3427a(parsableByteArray, b);
            this.f3159f = b + this.f3159f;
        }
    }

    public void m3646b() {
        if (this.f3156c && this.f3158e != 0 && this.f3159f == this.f3158e) {
            this.f3155b.m3425a(this.f3157d, 1, this.f3158e, 0, null);
            this.f3156c = false;
        }
    }
}
