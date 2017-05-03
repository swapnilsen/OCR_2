package com.google.android.exoplayer2.p052c.p058f;

import android.support.v4.view.MotionEventCompat;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.p050j.ParsableByteArray;
import com.google.android.exoplayer2.p052c.TrackOutput;
import com.google.android.exoplayer2.p064g.p065a.Cea608Decoder;

/* renamed from: com.google.android.exoplayer2.c.f.o */
final class SeiReader {
    private final TrackOutput f3192a;

    public SeiReader(TrackOutput trackOutput) {
        this.f3192a = trackOutput;
        trackOutput.m3426a(Format.m2863a(null, "application/cea-608", null, -1, 0, null, null));
    }

    public void m3670a(long j, ParsableByteArray parsableByteArray) {
        while (parsableByteArray.m4452b() > 1) {
            int g;
            int i = 0;
            do {
                g = parsableByteArray.m4461g();
                i += g;
            } while (g == MotionEventCompat.ACTION_MASK);
            g = 0;
            while (true) {
                int g2 = parsableByteArray.m4461g();
                int i2 = g + g2;
                if (g2 != MotionEventCompat.ACTION_MASK) {
                    break;
                }
                g = i2;
            }
            if (Cea608Decoder.m3981a(i, i2, parsableByteArray)) {
                parsableByteArray.m4457d(8);
                int g3 = parsableByteArray.m4461g() & 31;
                parsableByteArray.m4457d(1);
                int i3 = 0;
                for (i = 0; i < g3; i++) {
                    if ((parsableByteArray.m4460f() & 7) != 4) {
                        parsableByteArray.m4457d(3);
                    } else {
                        i3 += 3;
                        this.f3192a.m3427a(parsableByteArray, 3);
                    }
                }
                this.f3192a.m3425a(j, 1, i3, 0, null);
                parsableByteArray.m4457d(i2 - ((g3 * 3) + 10));
            } else {
                parsableByteArray.m4457d(i2);
            }
        }
    }
}
