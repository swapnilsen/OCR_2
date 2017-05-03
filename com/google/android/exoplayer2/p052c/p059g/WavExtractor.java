package com.google.android.exoplayer2.p052c.p059g;

import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.p052c.Extractor;
import com.google.android.exoplayer2.p052c.ExtractorInput;
import com.google.android.exoplayer2.p052c.ExtractorOutput;
import com.google.android.exoplayer2.p052c.ExtractorsFactory;
import com.google.android.exoplayer2.p052c.PositionHolder;
import com.google.android.exoplayer2.p052c.SeekMap;
import com.google.android.exoplayer2.p052c.TrackOutput;

/* renamed from: com.google.android.exoplayer2.c.g.a */
public final class WavExtractor implements Extractor, SeekMap {
    public static final ExtractorsFactory f3233a;
    private ExtractorOutput f3234b;
    private TrackOutput f3235c;
    private WavHeader f3236d;
    private int f3237e;
    private int f3238f;

    /* renamed from: com.google.android.exoplayer2.c.g.a.1 */
    static class WavExtractor implements ExtractorsFactory {
        WavExtractor() {
        }

        public Extractor[] m3703a() {
            return new Extractor[]{new WavExtractor()};
        }
    }

    static {
        f3233a = new WavExtractor();
    }

    public boolean m3708a(ExtractorInput extractorInput) {
        return WavHeaderReader.m3723a(extractorInput) != null;
    }

    public void m3706a(ExtractorOutput extractorOutput) {
        this.f3234b = extractorOutput;
        this.f3235c = extractorOutput.m3725a(0);
        this.f3236d = null;
        extractorOutput.m3726a();
    }

    public void m3705a(long j) {
        this.f3238f = 0;
    }

    public void m3711c() {
    }

    public int m3704a(ExtractorInput extractorInput, PositionHolder positionHolder) {
        if (this.f3236d == null) {
            this.f3236d = WavHeaderReader.m3723a(extractorInput);
            if (this.f3236d == null) {
                throw new ParserException("Unsupported or unrecognized wav header.");
            }
            this.f3235c.m3426a(Format.m2861a(null, "audio/raw", null, this.f3236d.m3717c(), (int) AccessibilityNodeInfoCompat.ACTION_PASTE, this.f3236d.m3719e(), this.f3236d.m3718d(), this.f3236d.m3721g(), null, null, 0, null));
            this.f3237e = this.f3236d.m3715b();
        }
        if (!this.f3236d.m3720f()) {
            WavHeaderReader.m3724a(extractorInput, this.f3236d);
            this.f3234b.m3727a((SeekMap) this);
        }
        int a = this.f3235c.m3424a(extractorInput, AccessibilityNodeInfoCompat.ACTION_PASTE - this.f3238f, true);
        if (a != -1) {
            this.f3238f += a;
        }
        int i = this.f3238f / this.f3237e;
        if (i > 0) {
            long b = this.f3236d.m3716b(extractorInput.m3238c() - ((long) this.f3238f));
            int i2 = i * this.f3237e;
            this.f3238f -= i2;
            this.f3235c.m3425a(b, 1, i2, this.f3238f, null);
        }
        return a == -1 ? -1 : 0;
    }

    public long m3709b() {
        return this.f3236d.m3712a();
    }

    public boolean m3707a() {
        return true;
    }

    public long m3710b(long j) {
        return this.f3236d.m3713a(j);
    }
}
