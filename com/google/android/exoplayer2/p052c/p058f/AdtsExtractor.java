package com.google.android.exoplayer2.p052c.p058f;

import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.exoplayer2.p050j.ParsableBitArray;
import com.google.android.exoplayer2.p050j.ParsableByteArray;
import com.google.android.exoplayer2.p050j.Util;
import com.google.android.exoplayer2.p052c.Extractor;
import com.google.android.exoplayer2.p052c.ExtractorInput;
import com.google.android.exoplayer2.p052c.ExtractorOutput;
import com.google.android.exoplayer2.p052c.ExtractorsFactory;
import com.google.android.exoplayer2.p052c.PositionHolder;
import com.google.android.exoplayer2.p052c.SeekMap.SeekMap;
import com.google.android.exoplayer2.p052c.p058f.ElementaryStreamReader.ElementaryStreamReader;
import com.google.api.client.http.HttpStatusCodes;

/* renamed from: com.google.android.exoplayer2.c.f.c */
public final class AdtsExtractor implements Extractor {
    public static final ExtractorsFactory f3024a;
    private static final int f3025b;
    private final long f3026c;
    private final ParsableByteArray f3027d;
    private AdtsReader f3028e;
    private boolean f3029f;

    /* renamed from: com.google.android.exoplayer2.c.f.c.1 */
    static class AdtsExtractor implements ExtractorsFactory {
        AdtsExtractor() {
        }

        public Extractor[] m3564a() {
            return new Extractor[]{new AdtsExtractor()};
        }
    }

    static {
        f3024a = new AdtsExtractor();
        f3025b = Util.m4524e("ID3");
    }

    public AdtsExtractor() {
        this(0);
    }

    public AdtsExtractor(long j) {
        this.f3026c = j;
        this.f3027d = new ParsableByteArray((int) HttpStatusCodes.STATUS_CODE_OK);
    }

    public boolean m3568a(ExtractorInput extractorInput) {
        int s;
        ParsableByteArray parsableByteArray = new ParsableByteArray(10);
        ParsableBitArray parsableBitArray = new ParsableBitArray(parsableByteArray.f3831a);
        int i = 0;
        while (true) {
            extractorInput.m3240c(parsableByteArray.f3831a, 0, 10);
            parsableByteArray.m4455c(0);
            if (parsableByteArray.m4465k() != f3025b) {
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
        int i2 = 0;
        int i3 = i;
        while (true) {
            extractorInput.m3240c(parsableByteArray.f3831a, 0, 2);
            parsableByteArray.m4455c(0);
            if ((parsableByteArray.m4462h() & 65526) != 65520) {
                extractorInput.m3232a();
                i3++;
                if (i3 - i >= AccessibilityNodeInfoCompat.ACTION_SCROLL_BACKWARD) {
                    return false;
                }
                extractorInput.m3239c(i3);
                s = 0;
                i2 = 0;
            } else {
                s++;
                if (s >= 4 && i2 > 188) {
                    return true;
                }
                extractorInput.m3240c(parsableByteArray.f3831a, 0, 4);
                parsableBitArray.m4442a(14);
                int c = parsableBitArray.m4445c(13);
                if (c <= 6) {
                    return false;
                }
                extractorInput.m3239c(c - 6);
                i2 += c;
            }
        }
    }

    public void m3567a(ExtractorOutput extractorOutput) {
        this.f3028e = new AdtsReader(true);
        this.f3028e.m3581a(extractorOutput, new ElementaryStreamReader(0, 1));
        extractorOutput.m3726a();
        extractorOutput.m3727a(new SeekMap(-9223372036854775807L));
    }

    public void m3566a(long j) {
        this.f3029f = false;
        this.f3028e.m3579a();
    }

    public void m3569c() {
    }

    public int m3565a(ExtractorInput extractorInput, PositionHolder positionHolder) {
        int a = extractorInput.m3231a(this.f3027d.f3831a, 0, HttpStatusCodes.STATUS_CODE_OK);
        if (a == -1) {
            return -1;
        }
        this.f3027d.m4455c(0);
        this.f3027d.m4453b(a);
        if (!this.f3029f) {
            this.f3028e.m3580a(this.f3026c, true);
            this.f3029f = true;
        }
        this.f3028e.m3582a(this.f3027d);
        return 0;
    }
}
