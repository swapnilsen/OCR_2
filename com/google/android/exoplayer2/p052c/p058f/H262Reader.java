package com.google.android.exoplayer2.p052c.p058f;

import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.util.Pair;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.p050j.NalUnitUtil;
import com.google.android.exoplayer2.p050j.ParsableByteArray;
import com.google.android.exoplayer2.p052c.ExtractorOutput;
import com.google.android.exoplayer2.p052c.TrackOutput;
import com.google.android.exoplayer2.p052c.p058f.ElementaryStreamReader.ElementaryStreamReader;
import com.google.firebase.messaging.SendException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.Arrays;
import java.util.Collections;

/* renamed from: com.google.android.exoplayer2.c.f.h */
final class H262Reader extends ElementaryStreamReader {
    private static final double[] f3068b;
    private TrackOutput f3069a;
    private boolean f3070c;
    private long f3071d;
    private final boolean[] f3072e;
    private final H262Reader f3073f;
    private boolean f3074g;
    private long f3075h;
    private long f3076i;
    private boolean f3077j;
    private boolean f3078k;
    private long f3079l;
    private long f3080m;

    /* renamed from: com.google.android.exoplayer2.c.f.h.a */
    private static final class H262Reader {
        public int f3064a;
        public int f3065b;
        public byte[] f3066c;
        private boolean f3067d;

        public H262Reader(int i) {
            this.f3066c = new byte[i];
        }

        public void m3595a() {
            this.f3067d = false;
            this.f3064a = 0;
            this.f3065b = 0;
        }

        public boolean m3597a(int i, int i2) {
            if (this.f3067d) {
                if (this.f3065b == 0 && i == 181) {
                    this.f3065b = this.f3064a;
                } else {
                    this.f3064a -= i2;
                    this.f3067d = false;
                    return true;
                }
            } else if (i == 179) {
                this.f3067d = true;
            }
            return false;
        }

        public void m3596a(byte[] bArr, int i, int i2) {
            if (this.f3067d) {
                int i3 = i2 - i;
                if (this.f3066c.length < this.f3064a + i3) {
                    this.f3066c = Arrays.copyOf(this.f3066c, (this.f3064a + i3) * 2);
                }
                System.arraycopy(bArr, i, this.f3066c, this.f3064a, i3);
                this.f3064a = i3 + this.f3064a;
            }
        }
    }

    static {
        f3068b = new double[]{23.976023976023978d, 24.0d, 25.0d, 29.97002997002997d, 30.0d, 50.0d, 59.94005994005994d, 60.0d};
    }

    public H262Reader() {
        this.f3072e = new boolean[4];
        this.f3073f = new H262Reader(AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS);
    }

    public void m3599a() {
        NalUnitUtil.m4435a(this.f3072e);
        this.f3073f.m3595a();
        this.f3077j = false;
        this.f3074g = false;
        this.f3075h = 0;
    }

    public void m3601a(ExtractorOutput extractorOutput, ElementaryStreamReader elementaryStreamReader) {
        this.f3069a = extractorOutput.m3725a(elementaryStreamReader.m3594a());
    }

    public void m3600a(long j, boolean z) {
        this.f3077j = j != -9223372036854775807L;
        if (this.f3077j) {
            this.f3076i = j;
        }
    }

    public void m3602a(ParsableByteArray parsableByteArray) {
        int d = parsableByteArray.m4456d();
        int c = parsableByteArray.m4454c();
        byte[] bArr = parsableByteArray.f3831a;
        this.f3075h += (long) parsableByteArray.m4452b();
        this.f3069a.m3427a(parsableByteArray, parsableByteArray.m4452b());
        int i = d;
        while (true) {
            int a = NalUnitUtil.m4431a(bArr, d, c, this.f3072e);
            if (a == c) {
                break;
            }
            int i2 = parsableByteArray.f3831a[a + 3] & MotionEventCompat.ACTION_MASK;
            if (!this.f3070c) {
                d = a - i;
                if (d > 0) {
                    this.f3073f.m3596a(bArr, i, a);
                }
                if (this.f3073f.m3597a(i2, d < 0 ? -d : 0)) {
                    Pair a2 = H262Reader.m3598a(this.f3073f);
                    this.f3069a.m3426a((Format) a2.first);
                    this.f3071d = ((Long) a2.second).longValue();
                    this.f3070c = true;
                }
            }
            if (this.f3070c && (i2 == 184 || i2 == 0)) {
                int i3 = c - a;
                if (this.f3074g) {
                    this.f3069a.m3425a(this.f3080m, this.f3078k ? 1 : 0, ((int) (this.f3075h - this.f3079l)) - i3, i3, null);
                    this.f3078k = false;
                }
                if (i2 == 184) {
                    this.f3074g = false;
                    this.f3078k = true;
                } else {
                    this.f3080m = this.f3077j ? this.f3076i : this.f3080m + this.f3071d;
                    this.f3079l = this.f3075h - ((long) i3);
                    this.f3077j = false;
                    this.f3074g = true;
                }
            }
            d = a + 3;
            i = a;
        }
        if (!this.f3070c) {
            this.f3073f.m3596a(bArr, i, c);
        }
    }

    public void m3603b() {
    }

    private static Pair<Format, Long> m3598a(H262Reader h262Reader) {
        Object copyOf = Arrays.copyOf(h262Reader.f3066c, h262Reader.f3064a);
        int i = copyOf[5] & MotionEventCompat.ACTION_MASK;
        int i2 = i >> 4;
        i2 |= (copyOf[4] & MotionEventCompat.ACTION_MASK) << 4;
        int i3 = ((i & 15) << 8) | (copyOf[6] & MotionEventCompat.ACTION_MASK);
        float f = 1.0f;
        switch ((copyOf[7] & 240) >> 4) {
            case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                f = ((float) (i3 * 4)) / ((float) (i2 * 3));
                break;
            case SendException.ERROR_TTL_EXCEEDED /*3*/:
                f = ((float) (i3 * 16)) / ((float) (i2 * 9));
                break;
            case SendException.ERROR_TOO_MANY_MESSAGES /*4*/:
                f = ((float) (i3 * 121)) / ((float) (i2 * 100));
                break;
        }
        Format a = Format.m2858a(null, "video/mpeg2", null, -1, -1, i2, i3, -1.0f, Collections.singletonList(copyOf), -1, f, null);
        long j = 0;
        int i4 = (copyOf[7] & 15) - 1;
        if (i4 >= 0 && i4 < f3068b.length) {
            double d = f3068b[i4];
            i4 = h262Reader.f3065b;
            int i5 = (copyOf[i4 + 9] & 96) >> 5;
            i4 = copyOf[i4 + 9] & 31;
            if (i5 != i4) {
                d *= (((double) i5) + 1.0d) / ((double) (i4 + 1));
            }
            j = (long) (1000000.0d / d);
        }
        return Pair.create(a, Long.valueOf(j));
    }
}
