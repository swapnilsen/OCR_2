package com.google.android.exoplayer2.p052c.p057e;

import android.support.v4.view.MotionEventCompat;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.p050j.ParsableByteArray;
import com.google.android.exoplayer2.p050j.Util;
import com.google.android.exoplayer2.p052c.ExtractorInput;
import java.io.EOFException;

/* renamed from: com.google.android.exoplayer2.c.e.e */
final class OggPageHeader {
    private static final int f2953k;
    public int f2954a;
    public int f2955b;
    public long f2956c;
    public long f2957d;
    public long f2958e;
    public long f2959f;
    public int f2960g;
    public int f2961h;
    public int f2962i;
    public final int[] f2963j;
    private final ParsableByteArray f2964l;

    OggPageHeader() {
        this.f2963j = new int[MotionEventCompat.ACTION_MASK];
        this.f2964l = new ParsableByteArray((int) MotionEventCompat.ACTION_MASK);
    }

    static {
        f2953k = Util.m4524e("OggS");
    }

    public void m3507a() {
        this.f2954a = 0;
        this.f2955b = 0;
        this.f2956c = 0;
        this.f2957d = 0;
        this.f2958e = 0;
        this.f2959f = 0;
        this.f2960g = 0;
        this.f2961h = 0;
        this.f2962i = 0;
    }

    public boolean m3508a(ExtractorInput extractorInput, boolean z) {
        int i = 0;
        this.f2964l.m4447a();
        m3507a();
        int i2 = (extractorInput.m3241d() == -1 || extractorInput.m3241d() - extractorInput.m3234b() >= 27) ? true : 0;
        if (i2 == 0 || !extractorInput.m3237b(this.f2964l.f3831a, 0, 27, true)) {
            if (z) {
                return false;
            }
            throw new EOFException();
        } else if (this.f2964l.m4466l() == ((long) f2953k)) {
            this.f2954a = this.f2964l.m4461g();
            if (this.f2954a == 0) {
                this.f2955b = this.f2964l.m4461g();
                this.f2956c = this.f2964l.m4471q();
                this.f2957d = this.f2964l.m4467m();
                this.f2958e = this.f2964l.m4467m();
                this.f2959f = this.f2964l.m4467m();
                this.f2960g = this.f2964l.m4461g();
                this.f2961h = this.f2960g + 27;
                this.f2964l.m4447a();
                extractorInput.m3240c(this.f2964l.f3831a, 0, this.f2960g);
                while (i < this.f2960g) {
                    this.f2963j[i] = this.f2964l.m4461g();
                    this.f2962i += this.f2963j[i];
                    i++;
                }
                return true;
            } else if (z) {
                return false;
            } else {
                throw new ParserException("unsupported bit stream revision");
            }
        } else if (z) {
            return false;
        } else {
            throw new ParserException("expected OggS capture pattern at begin of page");
        }
    }
}
