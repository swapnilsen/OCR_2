package com.google.android.exoplayer2.p052c.p058f;

import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.exoplayer2.p048a.Ac3Util;
import com.google.android.exoplayer2.p050j.ParsableByteArray;
import com.google.android.exoplayer2.p050j.Util;
import com.google.android.exoplayer2.p052c.Extractor;
import com.google.android.exoplayer2.p052c.ExtractorInput;
import com.google.android.exoplayer2.p052c.ExtractorOutput;
import com.google.android.exoplayer2.p052c.ExtractorsFactory;
import com.google.android.exoplayer2.p052c.PositionHolder;
import com.google.android.exoplayer2.p052c.SeekMap.SeekMap;
import com.google.android.exoplayer2.p052c.p058f.ElementaryStreamReader.ElementaryStreamReader;

/* renamed from: com.google.android.exoplayer2.c.f.a */
public final class Ac3Extractor implements Extractor {
    public static final ExtractorsFactory f3006a;
    private static final int f3007b;
    private final long f3008c;
    private final ParsableByteArray f3009d;
    private Ac3Reader f3010e;
    private boolean f3011f;

    /* renamed from: com.google.android.exoplayer2.c.f.a.1 */
    static class Ac3Extractor implements ExtractorsFactory {
        Ac3Extractor() {
        }

        public Extractor[] m3545a() {
            return new Extractor[]{new Ac3Extractor()};
        }
    }

    static {
        f3006a = new Ac3Extractor();
        f3007b = Util.m4524e("ID3");
    }

    public Ac3Extractor() {
        this(0);
    }

    public Ac3Extractor(long j) {
        this.f3008c = j;
        this.f3009d = new ParsableByteArray(2786);
    }

    public boolean m3549a(ExtractorInput extractorInput) {
        int s;
        ParsableByteArray parsableByteArray = new ParsableByteArray(10);
        int i = 0;
        while (true) {
            extractorInput.m3240c(parsableByteArray.f3831a, 0, 10);
            parsableByteArray.m4455c(0);
            if (parsableByteArray.m4465k() != f3007b) {
                break;
            }
            parsableByteArray.m4457d(3);
            s = parsableByteArray.m4473s();
            i += s + 10;
            extractorInput.m3239c(s);
        }
        extractorInput.m3232a();
        extractorInput.m3239c(i);
        s = 0;
        int i2 = i;
        while (true) {
            extractorInput.m3240c(parsableByteArray.f3831a, 0, 5);
            parsableByteArray.m4455c(0);
            if (parsableByteArray.m4462h() != 2935) {
                extractorInput.m3232a();
                i2++;
                if (i2 - i >= AccessibilityNodeInfoCompat.ACTION_SCROLL_BACKWARD) {
                    return false;
                }
                extractorInput.m3239c(i2);
                s = 0;
            } else {
                s++;
                if (s >= 4) {
                    return true;
                }
                int a = Ac3Util.m2879a(parsableByteArray.f3831a);
                if (a == -1) {
                    return false;
                }
                extractorInput.m3239c(a - 5);
            }
        }
    }

    public void m3548a(ExtractorOutput extractorOutput) {
        this.f3010e = new Ac3Reader();
        this.f3010e.m3561a(extractorOutput, new ElementaryStreamReader(0, 1));
        extractorOutput.m3726a();
        extractorOutput.m3727a(new SeekMap(-9223372036854775807L));
    }

    public void m3547a(long j) {
        this.f3011f = false;
        this.f3010e.m3559a();
    }

    public void m3550c() {
    }

    public int m3546a(ExtractorInput extractorInput, PositionHolder positionHolder) {
        int a = extractorInput.m3231a(this.f3009d.f3831a, 0, 2786);
        if (a == -1) {
            return -1;
        }
        this.f3009d.m4455c(0);
        this.f3009d.m4453b(a);
        if (!this.f3011f) {
            this.f3010e.m3560a(this.f3008c, true);
            this.f3011f = true;
        }
        this.f3010e.m3562a(this.f3009d);
        return 0;
    }
}
