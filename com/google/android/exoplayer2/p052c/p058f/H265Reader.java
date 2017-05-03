package com.google.android.exoplayer2.p052c.p058f;

import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.util.Log;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.p050j.NalUnitUtil;
import com.google.android.exoplayer2.p050j.ParsableByteArray;
import com.google.android.exoplayer2.p050j.ParsableNalUnitBitArray;
import com.google.android.exoplayer2.p052c.ExtractorOutput;
import com.google.android.exoplayer2.p052c.TrackOutput;
import com.google.android.exoplayer2.p052c.p058f.ElementaryStreamReader.ElementaryStreamReader;
import java.util.Collections;

/* renamed from: com.google.android.exoplayer2.c.f.j */
final class H265Reader extends ElementaryStreamReader {
    private TrackOutput f3141a;
    private SeiReader f3142b;
    private boolean f3143c;
    private final boolean[] f3144d;
    private final NalUnitTargetBuffer f3145e;
    private final NalUnitTargetBuffer f3146f;
    private final NalUnitTargetBuffer f3147g;
    private final NalUnitTargetBuffer f3148h;
    private final NalUnitTargetBuffer f3149i;
    private final H265Reader f3150j;
    private long f3151k;
    private long f3152l;
    private final ParsableByteArray f3153m;

    /* renamed from: com.google.android.exoplayer2.c.f.j.a */
    private static final class H265Reader {
        private final TrackOutput f3128a;
        private long f3129b;
        private boolean f3130c;
        private int f3131d;
        private long f3132e;
        private boolean f3133f;
        private boolean f3134g;
        private boolean f3135h;
        private boolean f3136i;
        private boolean f3137j;
        private long f3138k;
        private long f3139l;
        private boolean f3140m;

        public H265Reader(TrackOutput trackOutput) {
            this.f3128a = trackOutput;
        }

        public void m3627a() {
            this.f3133f = false;
            this.f3134g = false;
            this.f3135h = false;
            this.f3136i = false;
            this.f3137j = false;
        }

        public void m3629a(long j, int i, int i2, long j2) {
            boolean z;
            boolean z2 = false;
            this.f3134g = false;
            this.f3135h = false;
            this.f3132e = j2;
            this.f3131d = 0;
            this.f3129b = j;
            if (i2 >= 32) {
                if (!this.f3137j && this.f3136i) {
                    m3626a(i);
                    this.f3136i = false;
                }
                if (i2 <= 34) {
                    this.f3135h = !this.f3137j;
                    this.f3137j = true;
                }
            }
            if (i2 < 16 || i2 > 21) {
                z = false;
            } else {
                z = true;
            }
            this.f3130c = z;
            if (this.f3130c || i2 <= 9) {
                z2 = true;
            }
            this.f3133f = z2;
        }

        public void m3630a(byte[] bArr, int i, int i2) {
            if (this.f3133f) {
                int i3 = (i + 2) - this.f3131d;
                if (i3 < i2) {
                    this.f3134g = (bArr[i3] & AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS) != 0;
                    this.f3133f = false;
                    return;
                }
                this.f3131d += i2 - i;
            }
        }

        public void m3628a(long j, int i) {
            if (this.f3137j && this.f3134g) {
                this.f3140m = this.f3130c;
                this.f3137j = false;
            } else if (this.f3135h || this.f3134g) {
                if (this.f3136i) {
                    m3626a(((int) (j - this.f3129b)) + i);
                }
                this.f3138k = this.f3129b;
                this.f3139l = this.f3132e;
                this.f3136i = true;
                this.f3140m = this.f3130c;
            }
        }

        private void m3626a(int i) {
            this.f3128a.m3425a(this.f3139l, this.f3140m ? 1 : 0, (int) (this.f3129b - this.f3138k), i, null);
        }
    }

    public H265Reader() {
        this.f3144d = new boolean[3];
        this.f3145e = new NalUnitTargetBuffer(32, AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS);
        this.f3146f = new NalUnitTargetBuffer(33, AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS);
        this.f3147g = new NalUnitTargetBuffer(34, AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS);
        this.f3148h = new NalUnitTargetBuffer(39, AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS);
        this.f3149i = new NalUnitTargetBuffer(40, AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS);
        this.f3150j = new H265Reader(this.f3141a);
        this.f3153m = new ParsableByteArray();
    }

    public void m3637a() {
        NalUnitUtil.m4435a(this.f3144d);
        this.f3145e.m3655a();
        this.f3146f.m3655a();
        this.f3147g.m3655a();
        this.f3148h.m3655a();
        this.f3149i.m3655a();
        this.f3150j.m3627a();
        this.f3151k = 0;
    }

    public void m3639a(ExtractorOutput extractorOutput, ElementaryStreamReader elementaryStreamReader) {
        this.f3141a = extractorOutput.m3725a(elementaryStreamReader.m3594a());
        this.f3142b = new SeiReader(extractorOutput.m3725a(elementaryStreamReader.m3594a()));
    }

    public void m3638a(long j, boolean z) {
        this.f3152l = j;
    }

    public void m3640a(ParsableByteArray parsableByteArray) {
        while (parsableByteArray.m4452b() > 0) {
            int d = parsableByteArray.m4456d();
            int c = parsableByteArray.m4454c();
            byte[] bArr = parsableByteArray.f3831a;
            this.f3151k += (long) parsableByteArray.m4452b();
            this.f3141a.m3427a(parsableByteArray, parsableByteArray.m4452b());
            while (d < c) {
                int a = NalUnitUtil.m4431a(bArr, d, c, this.f3144d);
                if (a == c) {
                    m3634a(bArr, d, c);
                    return;
                }
                int c2 = NalUnitUtil.m4438c(bArr, a);
                int i = a - d;
                if (i > 0) {
                    m3634a(bArr, d, a);
                }
                int i2 = c - a;
                long j = this.f3151k - ((long) i2);
                m3635b(j, i2, i < 0 ? -i : 0, this.f3152l);
                m3632a(j, i2, c2, this.f3152l);
                d = a + 3;
            }
        }
    }

    public void m3641b() {
    }

    private void m3632a(long j, int i, int i2, long j2) {
        if (this.f3143c) {
            this.f3150j.m3629a(j, i, i2, j2);
        } else {
            this.f3145e.m3656a(i2);
            this.f3146f.m3656a(i2);
            this.f3147g.m3656a(i2);
        }
        this.f3148h.m3656a(i2);
        this.f3149i.m3656a(i2);
    }

    private void m3634a(byte[] bArr, int i, int i2) {
        if (this.f3143c) {
            this.f3150j.m3630a(bArr, i, i2);
        } else {
            this.f3145e.m3657a(bArr, i, i2);
            this.f3146f.m3657a(bArr, i, i2);
            this.f3147g.m3657a(bArr, i, i2);
        }
        this.f3148h.m3657a(bArr, i, i2);
        this.f3149i.m3657a(bArr, i, i2);
    }

    private void m3635b(long j, int i, int i2, long j2) {
        if (this.f3143c) {
            this.f3150j.m3628a(j, i);
        } else {
            this.f3145e.m3659b(i2);
            this.f3146f.m3659b(i2);
            this.f3147g.m3659b(i2);
            if (this.f3145e.m3658b() && this.f3146f.m3658b() && this.f3147g.m3658b()) {
                this.f3141a.m3426a(H265Reader.m3631a(this.f3145e, this.f3146f, this.f3147g));
                this.f3143c = true;
            }
        }
        if (this.f3148h.m3659b(i2)) {
            this.f3153m.m4450a(this.f3148h.f3171a, NalUnitUtil.m4430a(this.f3148h.f3171a, this.f3148h.f3172b));
            this.f3153m.m4457d(5);
            this.f3142b.m3670a(j2, this.f3153m);
        }
        if (this.f3149i.m3659b(i2)) {
            this.f3153m.m4450a(this.f3149i.f3171a, NalUnitUtil.m4430a(this.f3149i.f3171a, this.f3149i.f3172b));
            this.f3153m.m4457d(5);
            this.f3142b.m3670a(j2, this.f3153m);
        }
    }

    private static Format m3631a(NalUnitTargetBuffer nalUnitTargetBuffer, NalUnitTargetBuffer nalUnitTargetBuffer2, NalUnitTargetBuffer nalUnitTargetBuffer3) {
        int i;
        float f;
        Object obj = new byte[((nalUnitTargetBuffer.f3172b + nalUnitTargetBuffer2.f3172b) + nalUnitTargetBuffer3.f3172b)];
        System.arraycopy(nalUnitTargetBuffer.f3171a, 0, obj, 0, nalUnitTargetBuffer.f3172b);
        System.arraycopy(nalUnitTargetBuffer2.f3171a, 0, obj, nalUnitTargetBuffer.f3172b, nalUnitTargetBuffer2.f3172b);
        System.arraycopy(nalUnitTargetBuffer3.f3171a, 0, obj, nalUnitTargetBuffer.f3172b + nalUnitTargetBuffer2.f3172b, nalUnitTargetBuffer3.f3172b);
        ParsableNalUnitBitArray parsableNalUnitBitArray = new ParsableNalUnitBitArray(nalUnitTargetBuffer2.f3171a, 0, nalUnitTargetBuffer2.f3172b);
        parsableNalUnitBitArray.m4483a(44);
        int c = parsableNalUnitBitArray.m4489c(3);
        parsableNalUnitBitArray.m4483a(1);
        parsableNalUnitBitArray.m4483a(88);
        parsableNalUnitBitArray.m4483a(8);
        int i2 = 0;
        for (i = 0; i < c; i++) {
            if (parsableNalUnitBitArray.m4485a()) {
                i2 += 89;
            }
            if (parsableNalUnitBitArray.m4485a()) {
                i2 += 8;
            }
        }
        parsableNalUnitBitArray.m4483a(i2);
        if (c > 0) {
            parsableNalUnitBitArray.m4483a((8 - c) * 2);
        }
        parsableNalUnitBitArray.m4488c();
        int c2 = parsableNalUnitBitArray.m4488c();
        if (c2 == 3) {
            parsableNalUnitBitArray.m4483a(1);
        }
        int c3 = parsableNalUnitBitArray.m4488c();
        int c4 = parsableNalUnitBitArray.m4488c();
        if (parsableNalUnitBitArray.m4485a()) {
            int c5 = parsableNalUnitBitArray.m4488c();
            int c6 = parsableNalUnitBitArray.m4488c();
            int c7 = parsableNalUnitBitArray.m4488c();
            int c8 = parsableNalUnitBitArray.m4488c();
            i = (c2 == 1 || c2 == 2) ? 2 : 1;
            c3 -= i * (c5 + c6);
            c4 -= (c2 == 1 ? 2 : 1) * (c7 + c8);
        }
        parsableNalUnitBitArray.m4488c();
        parsableNalUnitBitArray.m4488c();
        i = parsableNalUnitBitArray.m4488c();
        i2 = parsableNalUnitBitArray.m4485a() ? 0 : c;
        while (i2 <= c) {
            parsableNalUnitBitArray.m4488c();
            parsableNalUnitBitArray.m4488c();
            parsableNalUnitBitArray.m4488c();
            i2++;
        }
        parsableNalUnitBitArray.m4488c();
        parsableNalUnitBitArray.m4488c();
        parsableNalUnitBitArray.m4488c();
        parsableNalUnitBitArray.m4488c();
        parsableNalUnitBitArray.m4488c();
        parsableNalUnitBitArray.m4488c();
        if (parsableNalUnitBitArray.m4485a() && parsableNalUnitBitArray.m4485a()) {
            H265Reader.m3633a(parsableNalUnitBitArray);
        }
        parsableNalUnitBitArray.m4483a(2);
        if (parsableNalUnitBitArray.m4485a()) {
            parsableNalUnitBitArray.m4483a(8);
            parsableNalUnitBitArray.m4488c();
            parsableNalUnitBitArray.m4488c();
            parsableNalUnitBitArray.m4483a(1);
        }
        H265Reader.m3636b(parsableNalUnitBitArray);
        if (parsableNalUnitBitArray.m4485a()) {
            for (i2 = 0; i2 < parsableNalUnitBitArray.m4488c(); i2++) {
                parsableNalUnitBitArray.m4483a((i + 4) + 1);
            }
        }
        parsableNalUnitBitArray.m4483a(2);
        float f2 = 1.0f;
        if (parsableNalUnitBitArray.m4485a() && parsableNalUnitBitArray.m4485a()) {
            c = parsableNalUnitBitArray.m4489c(8);
            if (c == MotionEventCompat.ACTION_MASK) {
                c = parsableNalUnitBitArray.m4489c(16);
                i = parsableNalUnitBitArray.m4489c(16);
                if (!(c == 0 || i == 0)) {
                    f2 = ((float) c) / ((float) i);
                }
                f = f2;
            } else if (c < NalUnitUtil.f3824b.length) {
                f = NalUnitUtil.f3824b[c];
            } else {
                Log.w("H265Reader", "Unexpected aspect_ratio_idc value: " + c);
            }
            return Format.m2858a(null, "video/hevc", null, -1, -1, c3, c4, -1.0f, Collections.singletonList(obj), -1, f, null);
        }
        f = 1.0f;
        return Format.m2858a(null, "video/hevc", null, -1, -1, c3, c4, -1.0f, Collections.singletonList(obj), -1, f, null);
    }

    private static void m3633a(ParsableNalUnitBitArray parsableNalUnitBitArray) {
        int i = 0;
        while (i < 4) {
            for (int i2 = 0; i2 < 6; i2 = (i == 3 ? 3 : 1) + i2) {
                if (parsableNalUnitBitArray.m4485a()) {
                    int min = Math.min(64, 1 << ((i << 1) + 4));
                    if (i > 1) {
                        parsableNalUnitBitArray.m4490d();
                    }
                    for (int i3 = 0; i3 < min; i3++) {
                        parsableNalUnitBitArray.m4490d();
                    }
                } else {
                    parsableNalUnitBitArray.m4488c();
                }
            }
            i++;
        }
    }

    private static void m3636b(ParsableNalUnitBitArray parsableNalUnitBitArray) {
        int c = parsableNalUnitBitArray.m4488c();
        int i = 0;
        int i2 = 0;
        boolean z = false;
        while (i < c) {
            boolean a;
            if (i != 0) {
                a = parsableNalUnitBitArray.m4485a();
            } else {
                a = z;
            }
            int i3;
            if (a) {
                parsableNalUnitBitArray.m4483a(1);
                parsableNalUnitBitArray.m4488c();
                for (i3 = 0; i3 <= i2; i3++) {
                    if (parsableNalUnitBitArray.m4485a()) {
                        parsableNalUnitBitArray.m4483a(1);
                    }
                }
            } else {
                int c2 = parsableNalUnitBitArray.m4488c();
                int c3 = parsableNalUnitBitArray.m4488c();
                i2 = c2 + c3;
                for (i3 = 0; i3 < c2; i3++) {
                    parsableNalUnitBitArray.m4488c();
                    parsableNalUnitBitArray.m4483a(1);
                }
                for (i3 = 0; i3 < c3; i3++) {
                    parsableNalUnitBitArray.m4488c();
                    parsableNalUnitBitArray.m4483a(1);
                }
            }
            i++;
            z = a;
        }
    }
}
