package com.google.android.exoplayer2.p052c.p058f;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.p048a.Ac3Util;
import com.google.android.exoplayer2.p050j.ParsableBitArray;
import com.google.android.exoplayer2.p050j.ParsableByteArray;
import com.google.android.exoplayer2.p052c.ExtractorOutput;
import com.google.android.exoplayer2.p052c.TrackOutput;
import com.google.android.exoplayer2.p052c.p058f.ElementaryStreamReader.ElementaryStreamReader;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import net.nend.android.NendAdIconLayout;
import net.nend.android.NendIconError;

/* renamed from: com.google.android.exoplayer2.c.f.b */
final class Ac3Reader extends ElementaryStreamReader {
    private final ParsableBitArray f3012a;
    private final ParsableByteArray f3013b;
    private final String f3014c;
    private TrackOutput f3015d;
    private int f3016e;
    private int f3017f;
    private boolean f3018g;
    private long f3019h;
    private Format f3020i;
    private int f3021j;
    private boolean f3022k;
    private long f3023l;

    public Ac3Reader() {
        this(null);
    }

    public Ac3Reader(String str) {
        this.f3012a = new ParsableBitArray(new byte[8]);
        this.f3013b = new ParsableByteArray(this.f3012a.f3827a);
        this.f3016e = 0;
        this.f3014c = str;
    }

    public void m3559a() {
        this.f3016e = 0;
        this.f3017f = 0;
        this.f3018g = false;
    }

    public void m3561a(ExtractorOutput extractorOutput, ElementaryStreamReader elementaryStreamReader) {
        this.f3015d = extractorOutput.m3725a(elementaryStreamReader.m3594a());
    }

    public void m3560a(long j, boolean z) {
        this.f3023l = j;
    }

    public void m3562a(ParsableByteArray parsableByteArray) {
        while (parsableByteArray.m4452b() > 0) {
            switch (this.f3016e) {
                case NendAdIconLayout.HORIZONTAL /*0*/:
                    if (!m3557b(parsableByteArray)) {
                        break;
                    }
                    this.f3016e = 1;
                    this.f3013b.f3831a[0] = (byte) 11;
                    this.f3013b.f3831a[1] = (byte) 119;
                    this.f3017f = 2;
                    break;
                case NendIconError.ERROR_ICONVIEW /*1*/:
                    if (!m3556a(parsableByteArray, this.f3013b.f3831a, 8)) {
                        break;
                    }
                    m3558c();
                    this.f3013b.m4455c(0);
                    this.f3015d.m3427a(this.f3013b, 8);
                    this.f3016e = 2;
                    break;
                case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                    int min = Math.min(parsableByteArray.m4452b(), this.f3021j - this.f3017f);
                    this.f3015d.m3427a(parsableByteArray, min);
                    this.f3017f = min + this.f3017f;
                    if (this.f3017f != this.f3021j) {
                        break;
                    }
                    this.f3015d.m3425a(this.f3023l, 1, this.f3021j, 0, null);
                    this.f3023l += this.f3019h;
                    this.f3016e = 0;
                    break;
                default:
                    break;
            }
        }
    }

    public void m3563b() {
    }

    private boolean m3556a(ParsableByteArray parsableByteArray, byte[] bArr, int i) {
        int min = Math.min(parsableByteArray.m4452b(), i - this.f3017f);
        parsableByteArray.m4451a(bArr, this.f3017f, min);
        this.f3017f = min + this.f3017f;
        return this.f3017f == i;
    }

    private boolean m3557b(ParsableByteArray parsableByteArray) {
        while (parsableByteArray.m4452b() > 0) {
            if (this.f3018g) {
                int g = parsableByteArray.m4461g();
                if (g == 119) {
                    this.f3018g = false;
                    return true;
                }
                this.f3018g = g == 11;
            } else {
                this.f3018g = parsableByteArray.m4461g() == 11;
            }
        }
        return false;
    }

    private void m3558c() {
        int b;
        if (this.f3020i == null) {
            Format b2;
            this.f3012a.m4443b(40);
            this.f3022k = this.f3012a.m4445c(5) == 16;
            this.f3012a.m4442a(this.f3012a.m4441a() - 45);
            if (this.f3022k) {
                b2 = Ac3Util.m2883b(this.f3012a, null, this.f3014c, null);
            } else {
                b2 = Ac3Util.m2880a(this.f3012a, null, this.f3014c, null);
            }
            this.f3020i = b2;
            this.f3015d.m3426a(this.f3020i);
        }
        if (this.f3022k) {
            b = Ac3Util.m2882b(this.f3012a.f3827a);
        } else {
            b = Ac3Util.m2879a(this.f3012a.f3827a);
        }
        this.f3021j = b;
        if (this.f3022k) {
            b = Ac3Util.m2885c(this.f3012a.f3827a);
        } else {
            b = Ac3Util.m2876a();
        }
        this.f3019h = (long) ((int) ((((long) b) * 1000000) / ((long) this.f3020i.f2336q)));
    }
}
