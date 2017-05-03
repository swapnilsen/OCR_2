package com.google.android.exoplayer2.p052c.p057e;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.p050j.ParsableByteArray;
import com.google.android.exoplayer2.p052c.Extractor;
import com.google.android.exoplayer2.p052c.ExtractorInput;
import com.google.android.exoplayer2.p052c.ExtractorOutput;
import com.google.android.exoplayer2.p052c.ExtractorsFactory;
import com.google.android.exoplayer2.p052c.PositionHolder;
import com.google.android.exoplayer2.p052c.TrackOutput;

/* renamed from: com.google.android.exoplayer2.c.e.c */
public class OggExtractor implements Extractor {
    public static final ExtractorsFactory f2946a;
    private StreamReader f2947b;

    /* renamed from: com.google.android.exoplayer2.c.e.c.1 */
    static class OggExtractor implements ExtractorsFactory {
        OggExtractor() {
        }

        public Extractor[] m3496a() {
            return new Extractor[]{new OggExtractor()};
        }
    }

    static {
        f2946a = new OggExtractor();
    }

    public boolean m3501a(ExtractorInput extractorInput) {
        try {
            OggPageHeader oggPageHeader = new OggPageHeader();
            if (!oggPageHeader.m3508a(extractorInput, true) || (oggPageHeader.f2955b & 2) != 2) {
                return false;
            }
            int min = Math.min(oggPageHeader.f2962i, 8);
            ParsableByteArray parsableByteArray = new ParsableByteArray(min);
            extractorInput.m3240c(parsableByteArray.f3831a, 0, min);
            if (FlacReader.m3490a(OggExtractor.m3497a(parsableByteArray))) {
                this.f2947b = new FlacReader();
            } else if (VorbisReader.m3524a(OggExtractor.m3497a(parsableByteArray))) {
                this.f2947b = new VorbisReader();
            } else if (!OpusReader.m3511a(OggExtractor.m3497a(parsableByteArray))) {
                return false;
            } else {
                this.f2947b = new OpusReader();
            }
            return true;
        } catch (ParserException e) {
            return false;
        }
    }

    public void m3500a(ExtractorOutput extractorOutput) {
        TrackOutput a = extractorOutput.m3725a(0);
        extractorOutput.m3726a();
        this.f2947b.m3482a(extractorOutput, a);
    }

    public void m3499a(long j) {
        this.f2947b.m3481a(j);
    }

    public void m3502c() {
    }

    public int m3498a(ExtractorInput extractorInput, PositionHolder positionHolder) {
        return this.f2947b.m3480a(extractorInput, positionHolder);
    }

    private static ParsableByteArray m3497a(ParsableByteArray parsableByteArray) {
        parsableByteArray.m4455c(0);
        return parsableByteArray;
    }
}
