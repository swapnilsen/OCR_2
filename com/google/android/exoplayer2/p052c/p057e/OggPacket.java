package com.google.android.exoplayer2.p052c.p057e;

import android.support.v4.view.MotionEventCompat;
import com.google.android.exoplayer2.p050j.Assertions;
import com.google.android.exoplayer2.p050j.ParsableByteArray;
import com.google.android.exoplayer2.p052c.ExtractorInput;

/* renamed from: com.google.android.exoplayer2.c.e.d */
final class OggPacket {
    private final OggPageHeader f2948a;
    private final ParsableByteArray f2949b;
    private int f2950c;
    private int f2951d;
    private boolean f2952e;

    OggPacket() {
        this.f2948a = new OggPageHeader();
        this.f2949b = new ParsableByteArray(new byte[65025], 0);
        this.f2950c = -1;
    }

    public void m3504a() {
        this.f2948a.m3507a();
        this.f2949b.m4447a();
        this.f2950c = -1;
        this.f2952e = false;
    }

    public boolean m3505a(ExtractorInput extractorInput) {
        Assertions.m4406b(extractorInput != null);
        if (this.f2952e) {
            this.f2952e = false;
            this.f2949b.m4447a();
        }
        while (!this.f2952e) {
            int i;
            int i2;
            if (this.f2950c < 0) {
                if (!this.f2948a.m3508a(extractorInput, true)) {
                    return false;
                }
                i = this.f2948a.f2961h;
                if ((this.f2948a.f2955b & 1) == 1 && this.f2949b.m4454c() == 0) {
                    i += m3503a(0);
                    i2 = this.f2951d + 0;
                } else {
                    i2 = 0;
                }
                extractorInput.m3235b(i);
                this.f2950c = i2;
            }
            i = m3503a(this.f2950c);
            i2 = this.f2950c + this.f2951d;
            if (i > 0) {
                boolean z;
                extractorInput.m3236b(this.f2949b.f3831a, this.f2949b.m4454c(), i);
                this.f2949b.m4453b(i + this.f2949b.m4454c());
                if (this.f2948a.f2963j[i2 - 1] != 255) {
                    z = true;
                } else {
                    z = false;
                }
                this.f2952e = z;
            }
            if (i2 == this.f2948a.f2960g) {
                i = -1;
            } else {
                i = i2;
            }
            this.f2950c = i;
        }
        return true;
    }

    public ParsableByteArray m3506b() {
        return this.f2949b;
    }

    private int m3503a(int i) {
        int i2 = 0;
        this.f2951d = 0;
        while (this.f2951d + i < this.f2948a.f2960g) {
            int[] iArr = this.f2948a.f2963j;
            int i3 = this.f2951d;
            this.f2951d = i3 + 1;
            int i4 = iArr[i3 + i];
            i2 += i4;
            if (i4 != MotionEventCompat.ACTION_MASK) {
                break;
            }
        }
        return i2;
    }
}
