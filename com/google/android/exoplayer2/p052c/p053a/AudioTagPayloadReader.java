package com.google.android.exoplayer2.p052c.p053a;

import android.util.Pair;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.p050j.CodecSpecificDataUtil;
import com.google.android.exoplayer2.p050j.ParsableByteArray;
import com.google.android.exoplayer2.p052c.TrackOutput;
import com.google.android.exoplayer2.p052c.p053a.TagPayloadReader.TagPayloadReader;
import java.util.Collections;

/* renamed from: com.google.android.exoplayer2.c.a.a */
final class AudioTagPayloadReader extends TagPayloadReader {
    private static final int[] f2526b;
    private boolean f2527c;
    private boolean f2528d;

    static {
        f2526b = new int[]{5500, 11000, 22000, 44000};
    }

    public AudioTagPayloadReader(TrackOutput trackOutput) {
        super(trackOutput);
    }

    protected boolean m3120a(ParsableByteArray parsableByteArray) {
        if (this.f2527c) {
            parsableByteArray.m4457d(1);
        } else {
            int g = parsableByteArray.m4461g();
            int i = (g >> 4) & 15;
            g = (g >> 2) & 3;
            if (g < 0 || g >= f2526b.length) {
                throw new TagPayloadReader("Invalid sample rate index: " + g);
            } else if (i != 10) {
                throw new TagPayloadReader("Audio format not supported: " + i);
            } else {
                this.f2527c = true;
            }
        }
        return true;
    }

    protected void m3119a(ParsableByteArray parsableByteArray, long j) {
        int g = parsableByteArray.m4461g();
        if (g == 0 && !this.f2528d) {
            Object obj = new byte[parsableByteArray.m4452b()];
            parsableByteArray.m4451a(obj, 0, obj.length);
            Pair a = CodecSpecificDataUtil.m4408a(obj);
            this.a.m3426a(Format.m2862a(null, "audio/mp4a-latm", null, -1, -1, ((Integer) a.second).intValue(), ((Integer) a.first).intValue(), Collections.singletonList(obj), null, 0, null));
            this.f2528d = true;
        } else if (g == 1) {
            int b = parsableByteArray.m4452b();
            this.a.m3427a(parsableByteArray, b);
            this.a.m3425a(j, 1, b, 0, null);
        }
    }
}
