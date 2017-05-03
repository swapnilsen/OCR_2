package com.google.android.exoplayer2.p052c.p055c;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.p050j.ParsableByteArray;
import com.google.android.exoplayer2.p050j.Util;
import com.google.android.exoplayer2.p052c.Extractor;
import com.google.android.exoplayer2.p052c.ExtractorInput;
import com.google.android.exoplayer2.p052c.ExtractorOutput;
import com.google.android.exoplayer2.p052c.ExtractorsFactory;
import com.google.android.exoplayer2.p052c.GaplessInfoHolder;
import com.google.android.exoplayer2.p052c.MpegAudioHeader;
import com.google.android.exoplayer2.p052c.PositionHolder;
import com.google.android.exoplayer2.p052c.SeekMap;
import com.google.android.exoplayer2.p052c.TrackOutput;
import java.io.EOFException;

/* renamed from: com.google.android.exoplayer2.c.c.c */
public final class Mp3Extractor implements Extractor {
    public static final ExtractorsFactory f2662a;
    private static final int f2663b;
    private static final int f2664c;
    private static final int f2665d;
    private final long f2666e;
    private final ParsableByteArray f2667f;
    private final MpegAudioHeader f2668g;
    private final GaplessInfoHolder f2669h;
    private ExtractorOutput f2670i;
    private TrackOutput f2671j;
    private int f2672k;
    private Mp3Extractor f2673l;
    private long f2674m;
    private long f2675n;
    private int f2676o;

    /* renamed from: com.google.android.exoplayer2.c.c.c.a */
    interface Mp3Extractor extends SeekMap {
        long m3262a(long j);
    }

    /* renamed from: com.google.android.exoplayer2.c.c.c.1 */
    static class Mp3Extractor implements ExtractorsFactory {
        Mp3Extractor() {
        }

        public Extractor[] m3275a() {
            return new Extractor[]{new Mp3Extractor()};
        }
    }

    static {
        f2662a = new Mp3Extractor();
        f2663b = Util.m4524e("Xing");
        f2664c = Util.m4524e("Info");
        f2665d = Util.m4524e("VBRI");
    }

    public Mp3Extractor() {
        this(-9223372036854775807L);
    }

    public Mp3Extractor(long j) {
        this.f2666e = j;
        this.f2667f = new ParsableByteArray(4);
        this.f2668g = new MpegAudioHeader();
        this.f2669h = new GaplessInfoHolder();
        this.f2674m = -9223372036854775807L;
    }

    public boolean m3282a(ExtractorInput extractorInput) {
        return m3276a(extractorInput, true);
    }

    public void m3281a(ExtractorOutput extractorOutput) {
        this.f2670i = extractorOutput;
        this.f2671j = this.f2670i.m3725a(0);
        this.f2670i.m3726a();
    }

    public void m3280a(long j) {
        this.f2672k = 0;
        this.f2674m = -9223372036854775807L;
        this.f2675n = 0;
        this.f2676o = 0;
    }

    public void m3283c() {
    }

    public int m3279a(ExtractorInput extractorInput, PositionHolder positionHolder) {
        if (this.f2672k == 0) {
            try {
                m3276a(extractorInput, false);
            } catch (EOFException e) {
                return -1;
            }
        }
        if (this.f2673l == null) {
            this.f2673l = m3278c(extractorInput);
            this.f2670i.m3727a(this.f2673l);
            TrackOutput trackOutput = this.f2671j;
            r16.m3426a(Format.m2860a(null, this.f2668g.f3260b, null, -1, (int) CodedOutputStream.DEFAULT_BUFFER_SIZE, this.f2668g.f3263e, this.f2668g.f3262d, -1, this.f2669h.f3250a, this.f2669h.f3251b, null, null, 0, null));
        }
        return m3277b(extractorInput);
    }

    private int m3277b(ExtractorInput extractorInput) {
        int n;
        if (this.f2676o == 0) {
            extractorInput.m3232a();
            if (!extractorInput.m3237b(this.f2667f.f3831a, 0, 4, true)) {
                return -1;
            }
            this.f2667f.m4455c(0);
            n = this.f2667f.m4468n();
            if ((n & -128000) != (this.f2672k & -128000) || MpegAudioHeader.m3731a(n) == -1) {
                extractorInput.m3235b(1);
                this.f2672k = 0;
                return 0;
            }
            MpegAudioHeader.m3733a(n, this.f2668g);
            if (this.f2674m == -9223372036854775807L) {
                this.f2674m = this.f2673l.m3262a(extractorInput.m3238c());
                if (this.f2666e != -9223372036854775807L) {
                    long a = this.f2673l.m3262a(0);
                    this.f2674m = (this.f2666e - a) + this.f2674m;
                }
            }
            this.f2676o = this.f2668g.f3261c;
        }
        n = this.f2671j.m3424a(extractorInput, this.f2676o, true);
        if (n == -1) {
            return -1;
        }
        this.f2676o -= n;
        if (this.f2676o > 0) {
            return 0;
        }
        this.f2671j.m3425a(((this.f2675n * 1000000) / ((long) this.f2668g.f3262d)) + this.f2674m, 1, this.f2668g.f3261c, 0, null);
        this.f2675n += (long) this.f2668g.f3265g;
        this.f2676o = 0;
        return 0;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m3276a(com.google.android.exoplayer2.p052c.ExtractorInput r13, boolean r14) {
        /*
        r12 = this;
        r11 = 4;
        r10 = -128000; // 0xfffffffffffe0c00 float:NaN double:NaN;
        r7 = 1;
        r2 = 0;
        if (r14 == 0) goto L_0x0042;
    L_0x0008:
        r0 = 4096; // 0x1000 float:5.74E-42 double:2.0237E-320;
    L_0x000a:
        r13.m3232a();
        r4 = r13.m3238c();
        r8 = 0;
        r1 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1));
        if (r1 != 0) goto L_0x009b;
    L_0x0017:
        r1 = r12.f2669h;
        com.google.android.exoplayer2.p052c.p055c.Id3Util.m3268a(r13, r1);
        r4 = r13.m3234b();
        r1 = (int) r4;
        if (r14 != 0) goto L_0x0026;
    L_0x0023:
        r13.m3235b(r1);
    L_0x0026:
        r3 = r1;
        r4 = r2;
        r5 = r2;
        r1 = r2;
    L_0x002a:
        r6 = r12.f2667f;
        r8 = r6.f3831a;
        if (r5 <= 0) goto L_0x0045;
    L_0x0030:
        r6 = r7;
    L_0x0031:
        r6 = r13.m3237b(r8, r2, r11, r6);
        if (r6 != 0) goto L_0x0047;
    L_0x0037:
        if (r14 == 0) goto L_0x0097;
    L_0x0039:
        r0 = r3 + r1;
        r13.m3235b(r0);
    L_0x003e:
        r12.f2672k = r4;
        r2 = r7;
    L_0x0041:
        return r2;
    L_0x0042:
        r0 = 131072; // 0x20000 float:1.83671E-40 double:6.47582E-319;
        goto L_0x000a;
    L_0x0045:
        r6 = r2;
        goto L_0x0031;
    L_0x0047:
        r6 = r12.f2667f;
        r6.m4455c(r2);
        r6 = r12.f2667f;
        r6 = r6.m4468n();
        if (r4 == 0) goto L_0x005a;
    L_0x0054:
        r8 = r6 & r10;
        r9 = r4 & r10;
        if (r8 != r9) goto L_0x0061;
    L_0x005a:
        r8 = com.google.android.exoplayer2.p052c.MpegAudioHeader.m3731a(r6);
        r9 = -1;
        if (r8 != r9) goto L_0x0084;
    L_0x0061:
        r4 = r1 + 1;
        if (r1 != r0) goto L_0x006f;
    L_0x0065:
        if (r14 != 0) goto L_0x0041;
    L_0x0067:
        r0 = new com.google.android.exoplayer2.k;
        r1 = "Searched too many bytes.";
        r0.<init>(r1);
        throw r0;
    L_0x006f:
        if (r14 == 0) goto L_0x007d;
    L_0x0071:
        r13.m3232a();
        r1 = r3 + r4;
        r13.m3239c(r1);
        r1 = r4;
        r5 = r2;
        r4 = r2;
        goto L_0x002a;
    L_0x007d:
        r13.m3235b(r7);
        r1 = r4;
        r5 = r2;
        r4 = r2;
        goto L_0x002a;
    L_0x0084:
        r5 = r5 + 1;
        if (r5 != r7) goto L_0x0094;
    L_0x0088:
        r4 = r12.f2668g;
        com.google.android.exoplayer2.p052c.MpegAudioHeader.m3733a(r6, r4);
        r4 = r6;
    L_0x008e:
        r6 = r8 + -4;
        r13.m3239c(r6);
        goto L_0x002a;
    L_0x0094:
        if (r5 != r11) goto L_0x008e;
    L_0x0096:
        goto L_0x0037;
    L_0x0097:
        r13.m3232a();
        goto L_0x003e;
    L_0x009b:
        r1 = r2;
        r3 = r2;
        r4 = r2;
        r5 = r2;
        goto L_0x002a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.c.c.c.a(com.google.android.exoplayer2.c.g, boolean):boolean");
    }

    private Mp3Extractor m3278c(ExtractorInput extractorInput) {
        int n;
        Mp3Extractor a;
        int i = 21;
        ParsableByteArray parsableByteArray = new ParsableByteArray(this.f2668g.f3261c);
        extractorInput.m3240c(parsableByteArray.f3831a, 0, this.f2668g.f3261c);
        long c = extractorInput.m3238c();
        long d = extractorInput.m3241d();
        if ((this.f2668g.f3259a & 1) != 0) {
            if (this.f2668g.f3263e != 1) {
                i = 36;
            }
        } else if (this.f2668g.f3263e == 1) {
            i = 13;
        }
        if (parsableByteArray.m4454c() >= i + 4) {
            parsableByteArray.m4455c(i);
            n = parsableByteArray.m4468n();
        } else {
            n = 0;
        }
        if (n == f2663b || n == f2664c) {
            a = XingSeeker.m3290a(this.f2668g, parsableByteArray, c, d);
            if (!(a == null || this.f2669h.m3728a())) {
                extractorInput.m3232a();
                extractorInput.m3239c(i + 141);
                extractorInput.m3240c(this.f2667f.f3831a, 0, 3);
                this.f2667f.m4455c(0);
                this.f2669h.m3729a(this.f2667f.m4465k());
            }
            extractorInput.m3235b(this.f2668g.f3261c);
        } else {
            if (parsableByteArray.m4454c() >= 40) {
                parsableByteArray.m4455c(36);
                if (parsableByteArray.m4468n() == f2665d) {
                    a = VbriSeeker.m3284a(this.f2668g, parsableByteArray, c, d);
                    extractorInput.m3235b(this.f2668g.f3261c);
                }
            }
            a = null;
        }
        if (a != null) {
            return a;
        }
        extractorInput.m3232a();
        extractorInput.m3240c(this.f2667f.f3831a, 0, 4);
        this.f2667f.m4455c(0);
        MpegAudioHeader.m3733a(this.f2667f.m4468n(), this.f2668g);
        return new ConstantBitrateSeeker(extractorInput.m3238c(), this.f2668g.f3264f, d);
    }
}
