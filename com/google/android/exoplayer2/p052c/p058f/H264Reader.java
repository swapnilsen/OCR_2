package com.google.android.exoplayer2.p052c.p058f;

import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.util.SparseArray;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.p050j.NalUnitUtil.NalUnitUtil;
import com.google.android.exoplayer2.p050j.ParsableByteArray;
import com.google.android.exoplayer2.p050j.ParsableNalUnitBitArray;
import com.google.android.exoplayer2.p052c.ExtractorOutput;
import com.google.android.exoplayer2.p052c.TrackOutput;
import com.google.android.exoplayer2.p052c.p058f.ElementaryStreamReader.ElementaryStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* renamed from: com.google.android.exoplayer2.c.f.i */
final class H264Reader extends ElementaryStreamReader {
    private final boolean f3115a;
    private final boolean f3116b;
    private final NalUnitTargetBuffer f3117c;
    private final NalUnitTargetBuffer f3118d;
    private final NalUnitTargetBuffer f3119e;
    private long f3120f;
    private final boolean[] f3121g;
    private TrackOutput f3122h;
    private SeiReader f3123i;
    private H264Reader f3124j;
    private boolean f3125k;
    private long f3126l;
    private final ParsableByteArray f3127m;

    /* renamed from: com.google.android.exoplayer2.c.f.i.a */
    private static final class H264Reader {
        private final TrackOutput f3097a;
        private final boolean f3098b;
        private final boolean f3099c;
        private final SparseArray<NalUnitUtil> f3100d;
        private final SparseArray<NalUnitUtil> f3101e;
        private final ParsableNalUnitBitArray f3102f;
        private byte[] f3103g;
        private int f3104h;
        private int f3105i;
        private long f3106j;
        private boolean f3107k;
        private long f3108l;
        private H264Reader f3109m;
        private H264Reader f3110n;
        private boolean f3111o;
        private long f3112p;
        private long f3113q;
        private boolean f3114r;

        /* renamed from: com.google.android.exoplayer2.c.f.i.a.a */
        private static final class H264Reader {
            private boolean f3081a;
            private boolean f3082b;
            private NalUnitUtil f3083c;
            private int f3084d;
            private int f3085e;
            private int f3086f;
            private int f3087g;
            private boolean f3088h;
            private boolean f3089i;
            private boolean f3090j;
            private boolean f3091k;
            private int f3092l;
            private int f3093m;
            private int f3094n;
            private int f3095o;
            private int f3096p;

            private H264Reader() {
            }

            public void m3606a() {
                this.f3082b = false;
                this.f3081a = false;
            }

            public void m3607a(int i) {
                this.f3085e = i;
                this.f3082b = true;
            }

            public void m3608a(NalUnitUtil nalUnitUtil, int i, int i2, int i3, int i4, boolean z, boolean z2, boolean z3, boolean z4, int i5, int i6, int i7, int i8, int i9) {
                this.f3083c = nalUnitUtil;
                this.f3084d = i;
                this.f3085e = i2;
                this.f3086f = i3;
                this.f3087g = i4;
                this.f3088h = z;
                this.f3089i = z2;
                this.f3090j = z3;
                this.f3091k = z4;
                this.f3092l = i5;
                this.f3093m = i6;
                this.f3094n = i7;
                this.f3095o = i8;
                this.f3096p = i9;
                this.f3081a = true;
                this.f3082b = true;
            }

            public boolean m3609b() {
                return this.f3082b && (this.f3085e == 7 || this.f3085e == 2);
            }

            private boolean m3604a(H264Reader h264Reader) {
                if (this.f3081a) {
                    if (!h264Reader.f3081a || this.f3086f != h264Reader.f3086f || this.f3087g != h264Reader.f3087g || this.f3088h != h264Reader.f3088h) {
                        return true;
                    }
                    if (this.f3089i && h264Reader.f3089i && this.f3090j != h264Reader.f3090j) {
                        return true;
                    }
                    if (this.f3084d != h264Reader.f3084d && (this.f3084d == 0 || h264Reader.f3084d == 0)) {
                        return true;
                    }
                    if (this.f3083c.f3820h == 0 && h264Reader.f3083c.f3820h == 0 && (this.f3093m != h264Reader.f3093m || this.f3094n != h264Reader.f3094n)) {
                        return true;
                    }
                    if ((this.f3083c.f3820h == 1 && h264Reader.f3083c.f3820h == 1 && (this.f3095o != h264Reader.f3095o || this.f3096p != h264Reader.f3096p)) || this.f3091k != h264Reader.f3091k) {
                        return true;
                    }
                    if (this.f3091k && h264Reader.f3091k && this.f3092l != h264Reader.f3092l) {
                        return true;
                    }
                }
                return false;
            }
        }

        public H264Reader(TrackOutput trackOutput, boolean z, boolean z2) {
            this.f3097a = trackOutput;
            this.f3098b = z;
            this.f3099c = z2;
            this.f3100d = new SparseArray();
            this.f3101e = new SparseArray();
            this.f3109m = new H264Reader();
            this.f3110n = new H264Reader();
            this.f3103g = new byte[AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS];
            this.f3102f = new ParsableNalUnitBitArray(this.f3103g, 0, 0);
            m3617b();
        }

        public boolean m3616a() {
            return this.f3099c;
        }

        public void m3614a(NalUnitUtil nalUnitUtil) {
            this.f3100d.append(nalUnitUtil.f3813a, nalUnitUtil);
        }

        public void m3613a(NalUnitUtil nalUnitUtil) {
            this.f3101e.append(nalUnitUtil.f3810a, nalUnitUtil);
        }

        public void m3617b() {
            this.f3107k = false;
            this.f3111o = false;
            this.f3110n.m3606a();
        }

        public void m3612a(long j, int i, long j2) {
            this.f3105i = i;
            this.f3108l = j2;
            this.f3106j = j;
            if (!(this.f3098b && this.f3105i == 1)) {
                if (!this.f3099c) {
                    return;
                }
                if (!(this.f3105i == 5 || this.f3105i == 1 || this.f3105i == 2)) {
                    return;
                }
            }
            H264Reader h264Reader = this.f3109m;
            this.f3109m = this.f3110n;
            this.f3110n = h264Reader;
            this.f3110n.m3606a();
            this.f3104h = 0;
            this.f3107k = true;
        }

        public void m3615a(byte[] bArr, int i, int i2) {
            if (this.f3107k) {
                int i3 = i2 - i;
                if (this.f3103g.length < this.f3104h + i3) {
                    this.f3103g = Arrays.copyOf(this.f3103g, (this.f3104h + i3) * 2);
                }
                System.arraycopy(bArr, i, this.f3103g, this.f3104h, i3);
                this.f3104h = i3 + this.f3104h;
                this.f3102f.m4484a(this.f3103g, 0, this.f3104h);
                if (this.f3102f.m4487b(8)) {
                    this.f3102f.m4483a(1);
                    int c = this.f3102f.m4489c(2);
                    this.f3102f.m4483a(5);
                    if (this.f3102f.m4486b()) {
                        this.f3102f.m4488c();
                        if (this.f3102f.m4486b()) {
                            int c2 = this.f3102f.m4488c();
                            if (!this.f3099c) {
                                this.f3107k = false;
                                this.f3110n.m3607a(c2);
                            } else if (this.f3102f.m4486b()) {
                                int c3 = this.f3102f.m4488c();
                                if (this.f3101e.indexOfKey(c3) < 0) {
                                    this.f3107k = false;
                                    return;
                                }
                                NalUnitUtil nalUnitUtil = (NalUnitUtil) this.f3101e.get(c3);
                                NalUnitUtil nalUnitUtil2 = (NalUnitUtil) this.f3100d.get(nalUnitUtil.f3811b);
                                if (nalUnitUtil2.f3817e) {
                                    if (this.f3102f.m4487b(2)) {
                                        this.f3102f.m4483a(2);
                                    } else {
                                        return;
                                    }
                                }
                                if (this.f3102f.m4487b(nalUnitUtil2.f3819g)) {
                                    boolean z = false;
                                    boolean z2 = false;
                                    boolean z3 = false;
                                    int c4 = this.f3102f.m4489c(nalUnitUtil2.f3819g);
                                    if (!nalUnitUtil2.f3818f) {
                                        if (this.f3102f.m4487b(1)) {
                                            z = this.f3102f.m4485a();
                                            if (z) {
                                                if (this.f3102f.m4487b(1)) {
                                                    z3 = this.f3102f.m4485a();
                                                    z2 = true;
                                                } else {
                                                    return;
                                                }
                                            }
                                        }
                                        return;
                                    }
                                    boolean z4 = this.f3105i == 5;
                                    int i4 = 0;
                                    if (z4) {
                                        if (this.f3102f.m4486b()) {
                                            i4 = this.f3102f.m4488c();
                                        } else {
                                            return;
                                        }
                                    }
                                    int i5 = 0;
                                    int i6 = 0;
                                    int i7 = 0;
                                    int i8 = 0;
                                    if (nalUnitUtil2.f3820h == 0) {
                                        if (this.f3102f.m4487b(nalUnitUtil2.f3821i)) {
                                            i5 = this.f3102f.m4489c(nalUnitUtil2.f3821i);
                                            if (nalUnitUtil.f3812c && !z) {
                                                if (this.f3102f.m4486b()) {
                                                    i6 = this.f3102f.m4490d();
                                                } else {
                                                    return;
                                                }
                                            }
                                        }
                                        return;
                                    }
                                    int i9 = nalUnitUtil2.f3820h;
                                    if (r0 == 1 && !nalUnitUtil2.f3822j) {
                                        if (this.f3102f.m4486b()) {
                                            i7 = this.f3102f.m4490d();
                                            if (nalUnitUtil.f3812c && !z) {
                                                if (this.f3102f.m4486b()) {
                                                    i8 = this.f3102f.m4490d();
                                                } else {
                                                    return;
                                                }
                                            }
                                        }
                                        return;
                                    }
                                    this.f3110n.m3608a(nalUnitUtil2, c, c2, c4, c3, z, z2, z3, z4, i4, i5, i6, i7, i8);
                                    this.f3107k = false;
                                }
                            }
                        }
                    }
                }
            }
        }

        public void m3611a(long j, int i) {
            int i2 = 0;
            if (this.f3105i == 9 || (this.f3099c && this.f3110n.m3604a(this.f3109m))) {
                if (this.f3111o) {
                    m3610a(((int) (j - this.f3106j)) + i);
                }
                this.f3112p = this.f3106j;
                this.f3113q = this.f3108l;
                this.f3114r = false;
                this.f3111o = true;
            }
            boolean z = this.f3114r;
            if (this.f3105i == 5 || (this.f3098b && this.f3105i == 1 && this.f3110n.m3609b())) {
                i2 = 1;
            }
            this.f3114r = i2 | z;
        }

        private void m3610a(int i) {
            this.f3097a.m3425a(this.f3113q, this.f3114r ? 1 : 0, (int) (this.f3106j - this.f3112p), i, null);
        }
    }

    public H264Reader(boolean z, boolean z2) {
        this.f3121g = new boolean[3];
        this.f3115a = z;
        this.f3116b = z2;
        this.f3117c = new NalUnitTargetBuffer(7, AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS);
        this.f3118d = new NalUnitTargetBuffer(8, AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS);
        this.f3119e = new NalUnitTargetBuffer(6, AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS);
        this.f3127m = new ParsableByteArray();
    }

    public void m3621a() {
        com.google.android.exoplayer2.p050j.NalUnitUtil.m4435a(this.f3121g);
        this.f3117c.m3655a();
        this.f3118d.m3655a();
        this.f3119e.m3655a();
        this.f3124j.m3617b();
        this.f3120f = 0;
    }

    public void m3623a(ExtractorOutput extractorOutput, ElementaryStreamReader elementaryStreamReader) {
        this.f3122h = extractorOutput.m3725a(elementaryStreamReader.m3594a());
        this.f3124j = new H264Reader(this.f3122h, this.f3115a, this.f3116b);
        this.f3123i = new SeiReader(extractorOutput.m3725a(elementaryStreamReader.m3594a()));
    }

    public void m3622a(long j, boolean z) {
        this.f3126l = j;
    }

    public void m3624a(ParsableByteArray parsableByteArray) {
        int d = parsableByteArray.m4456d();
        int c = parsableByteArray.m4454c();
        byte[] bArr = parsableByteArray.f3831a;
        this.f3120f += (long) parsableByteArray.m4452b();
        this.f3122h.m3427a(parsableByteArray, parsableByteArray.m4452b());
        while (true) {
            int a = com.google.android.exoplayer2.p050j.NalUnitUtil.m4431a(bArr, d, c, this.f3121g);
            if (a == c) {
                m3620a(bArr, d, c);
                return;
            }
            int b = com.google.android.exoplayer2.p050j.NalUnitUtil.m4436b(bArr, a);
            int i = a - d;
            if (i > 0) {
                m3620a(bArr, d, a);
            }
            int i2 = c - a;
            long j = this.f3120f - ((long) i2);
            m3618a(j, i2, i < 0 ? -i : 0, this.f3126l);
            m3619a(j, b, this.f3126l);
            d = a + 3;
        }
    }

    public void m3625b() {
    }

    private void m3619a(long j, int i, long j2) {
        if (!this.f3125k || this.f3124j.m3616a()) {
            this.f3117c.m3656a(i);
            this.f3118d.m3656a(i);
        }
        this.f3119e.m3656a(i);
        this.f3124j.m3612a(j, i, j2);
    }

    private void m3620a(byte[] bArr, int i, int i2) {
        if (!this.f3125k || this.f3124j.m3616a()) {
            this.f3117c.m3657a(bArr, i, i2);
            this.f3118d.m3657a(bArr, i, i2);
        }
        this.f3119e.m3657a(bArr, i, i2);
        this.f3124j.m3615a(bArr, i, i2);
    }

    private void m3618a(long j, int i, int i2, long j2) {
        if (!this.f3125k || this.f3124j.m3616a()) {
            this.f3117c.m3659b(i2);
            this.f3118d.m3659b(i2);
            if (this.f3125k) {
                if (this.f3117c.m3658b()) {
                    this.f3124j.m3614a(com.google.android.exoplayer2.p050j.NalUnitUtil.m4432a(this.f3117c.f3171a, 3, this.f3117c.f3172b));
                    this.f3117c.m3655a();
                } else if (this.f3118d.m3658b()) {
                    this.f3124j.m3613a(com.google.android.exoplayer2.p050j.NalUnitUtil.m4437b(this.f3118d.f3171a, 3, this.f3118d.f3172b));
                    this.f3118d.m3655a();
                }
            } else if (this.f3117c.m3658b() && this.f3118d.m3658b()) {
                List arrayList = new ArrayList();
                arrayList.add(Arrays.copyOf(this.f3117c.f3171a, this.f3117c.f3172b));
                arrayList.add(Arrays.copyOf(this.f3118d.f3171a, this.f3118d.f3172b));
                NalUnitUtil a = com.google.android.exoplayer2.p050j.NalUnitUtil.m4432a(this.f3117c.f3171a, 3, this.f3117c.f3172b);
                NalUnitUtil b = com.google.android.exoplayer2.p050j.NalUnitUtil.m4437b(this.f3118d.f3171a, 3, this.f3118d.f3172b);
                TrackOutput trackOutput = this.f3122h;
                r17.m3426a(Format.m2858a(null, "video/avc", null, -1, -1, a.f3814b, a.f3815c, -1.0f, arrayList, -1, a.f3816d, null));
                this.f3125k = true;
                this.f3124j.m3614a(a);
                this.f3124j.m3613a(b);
                this.f3117c.m3655a();
                this.f3118d.m3655a();
            }
        }
        if (this.f3119e.m3659b(i2)) {
            this.f3127m.m4450a(this.f3119e.f3171a, com.google.android.exoplayer2.p050j.NalUnitUtil.m4430a(this.f3119e.f3171a, this.f3119e.f3172b));
            this.f3127m.m4455c(4);
            this.f3123i.m3670a(j2, this.f3127m);
        }
        this.f3124j.m3611a(j, i);
    }
}
