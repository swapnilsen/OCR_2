package com.google.android.exoplayer2.p052c.p056d;

import android.support.v4.media.TransportMediator;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v7.appcompat.C0268R;
import android.util.Log;
import android.util.Pair;
import com.google.ads.AdSize;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.p048a.Ac3Util;
import com.google.android.exoplayer2.p050j.Assertions;
import com.google.android.exoplayer2.p050j.CodecSpecificDataUtil;
import com.google.android.exoplayer2.p050j.ParsableByteArray;
import com.google.android.exoplayer2.p050j.Util;
import com.google.android.exoplayer2.p052c.GaplessInfoHolder;
import com.google.android.exoplayer2.p052c.p056d.Atom.Atom;
import com.google.android.exoplayer2.p052c.p056d.FixedSampleSizeRechunker.FixedSampleSizeRechunker;
import com.google.android.exoplayer2.p071k.AvcConfig;
import com.google.android.exoplayer2.p071k.HevcConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import net.nend.android.NendAdIconLayout;
import net.nend.android.NendIconError;

/* renamed from: com.google.android.exoplayer2.c.d.b */
final class AtomParsers {
    private static final int f2784a;
    private static final int f2785b;
    private static final int f2786c;
    private static final int f2787d;
    private static final int f2788e;
    private static final int f2789f;
    private static final int f2790g;

    /* renamed from: com.google.android.exoplayer2.c.d.b.a */
    private static final class AtomParsers {
        public final int f2760a;
        public int f2761b;
        public int f2762c;
        public long f2763d;
        private final boolean f2764e;
        private final ParsableByteArray f2765f;
        private final ParsableByteArray f2766g;
        private int f2767h;
        private int f2768i;

        public AtomParsers(ParsableByteArray parsableByteArray, ParsableByteArray parsableByteArray2, boolean z) {
            boolean z2 = true;
            this.f2766g = parsableByteArray;
            this.f2765f = parsableByteArray2;
            this.f2764e = z;
            parsableByteArray2.m4455c(12);
            this.f2760a = parsableByteArray2.m4474t();
            parsableByteArray.m4455c(12);
            this.f2768i = parsableByteArray.m4474t();
            if (parsableByteArray.m4468n() != 1) {
                z2 = false;
            }
            Assertions.m4407b(z2, "first_chunk must be 1");
            this.f2761b = -1;
        }

        public boolean m3317a() {
            int i = this.f2761b + 1;
            this.f2761b = i;
            if (i == this.f2760a) {
                return false;
            }
            long v;
            if (this.f2764e) {
                v = this.f2765f.m4476v();
            } else {
                v = this.f2765f.m4466l();
            }
            this.f2763d = v;
            if (this.f2761b == this.f2767h) {
                this.f2762c = this.f2766g.m4474t();
                this.f2766g.m4457d(4);
                i = this.f2768i - 1;
                this.f2768i = i;
                this.f2767h = i > 0 ? this.f2766g.m4474t() - 1 : -1;
            }
            return true;
        }
    }

    /* renamed from: com.google.android.exoplayer2.c.d.b.b */
    private interface AtomParsers {
        int m3318a();

        int m3319b();

        boolean m3320c();
    }

    /* renamed from: com.google.android.exoplayer2.c.d.b.c */
    private static final class AtomParsers {
        public final TrackEncryptionBox[] f2769a;
        public Format f2770b;
        public int f2771c;
        public int f2772d;

        public AtomParsers(int i) {
            this.f2769a = new TrackEncryptionBox[i];
            this.f2772d = 0;
        }
    }

    /* renamed from: com.google.android.exoplayer2.c.d.b.d */
    static final class AtomParsers implements AtomParsers {
        private final int f2773a;
        private final int f2774b;
        private final ParsableByteArray f2775c;

        public AtomParsers(Atom atom) {
            this.f2775c = atom.aN;
            this.f2775c.m4455c(12);
            this.f2773a = this.f2775c.m4474t();
            this.f2774b = this.f2775c.m4474t();
        }

        public int m3321a() {
            return this.f2774b;
        }

        public int m3322b() {
            return this.f2773a == 0 ? this.f2775c.m4474t() : this.f2773a;
        }

        public boolean m3323c() {
            return this.f2773a != 0;
        }
    }

    /* renamed from: com.google.android.exoplayer2.c.d.b.e */
    static final class AtomParsers implements AtomParsers {
        private final ParsableByteArray f2776a;
        private final int f2777b;
        private final int f2778c;
        private int f2779d;
        private int f2780e;

        public AtomParsers(Atom atom) {
            this.f2776a = atom.aN;
            this.f2776a.m4455c(12);
            this.f2778c = this.f2776a.m4474t() & MotionEventCompat.ACTION_MASK;
            this.f2777b = this.f2776a.m4474t();
        }

        public int m3324a() {
            return this.f2777b;
        }

        public int m3325b() {
            if (this.f2778c == 8) {
                return this.f2776a.m4461g();
            }
            if (this.f2778c == 16) {
                return this.f2776a.m4462h();
            }
            int i = this.f2779d;
            this.f2779d = i + 1;
            if (i % 2 != 0) {
                return this.f2780e & 15;
            }
            this.f2780e = this.f2776a.m4461g();
            return (this.f2780e & 240) >> 4;
        }

        public boolean m3326c() {
            return false;
        }
    }

    /* renamed from: com.google.android.exoplayer2.c.d.b.f */
    private static final class AtomParsers {
        private final int f2781a;
        private final long f2782b;
        private final int f2783c;

        public AtomParsers(int i, long j, int i2) {
            this.f2781a = i;
            this.f2782b = j;
            this.f2783c = i2;
        }
    }

    static {
        f2784a = Util.m4524e("vide");
        f2785b = Util.m4524e("soun");
        f2786c = Util.m4524e("text");
        f2787d = Util.m4524e("sbtl");
        f2788e = Util.m4524e("subt");
        f2789f = Util.m4524e("clcp");
        f2790g = Util.m4524e("cenc");
    }

    public static Track m3336a(Atom atom, Atom atom2, long j, DrmInitData drmInitData, boolean z) {
        Atom e = atom.m3316e(Atom.f2711D);
        int c = AtomParsers.m3346c(e.m3315d(Atom.f2725R).aN);
        if (c == -1) {
            return null;
        }
        long a;
        long j2;
        AtomParsers b = AtomParsers.m3344b(atom.m3315d(Atom.f2721N).aN);
        if (j == -9223372036854775807L) {
            a = b.f2782b;
        } else {
            a = j;
        }
        long a2 = AtomParsers.m3333a(atom2.aN);
        if (a == -9223372036854775807L) {
            j2 = -9223372036854775807L;
        } else {
            j2 = Util.m4510a(a, 1000000, a2);
        }
        Atom e2 = e.m3316e(Atom.f2712E).m3316e(Atom.f2713F);
        Pair d = AtomParsers.m3348d(e.m3315d(Atom.f2724Q).aN);
        AtomParsers a3 = AtomParsers.m3335a(e2.m3315d(Atom.f2726S).aN, b.f2781a, b.f2783c, (String) d.second, drmInitData, z);
        Pair a4 = AtomParsers.m3334a(atom.m3316e(Atom.f2722O));
        if (a3.f2770b == null) {
            return null;
        }
        return new Track(b.f2781a, c, ((Long) d.first).longValue(), a2, j2, a3.f2770b, a3.f2772d, a3.f2769a, a3.f2771c, (long[]) a4.first, (long[]) a4.second);
    }

    public static TrackSampleTable m3337a(Track track, Atom atom, GaplessInfoHolder gaplessInfoHolder) {
        AtomParsers atomParsers;
        Atom d = atom.m3315d(Atom.ap);
        if (d != null) {
            atomParsers = new AtomParsers(d);
        } else {
            d = atom.m3315d(Atom.aq);
            if (d == null) {
                throw new ParserException("Track has no sample table size information");
            }
            atomParsers = new AtomParsers(d);
        }
        int a = atomParsers.m3318a();
        if (a == 0) {
            return new TrackSampleTable(new long[0], new int[0], 0, new long[0], new int[0]);
        }
        int t;
        int i;
        int i2;
        Object obj;
        int i3;
        long j;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        long[] jArr;
        int i9;
        Object obj2;
        Object obj3;
        long j2;
        boolean z = false;
        d = atom.m3315d(Atom.ar);
        if (d == null) {
            z = true;
            d = atom.m3315d(Atom.as);
        }
        ParsableByteArray parsableByteArray = d.aN;
        ParsableByteArray parsableByteArray2 = atom.m3315d(Atom.ao).aN;
        ParsableByteArray parsableByteArray3 = atom.m3315d(Atom.al).aN;
        d = atom.m3315d(Atom.am);
        ParsableByteArray parsableByteArray4 = d != null ? d.aN : null;
        Atom d2 = atom.m3315d(Atom.an);
        ParsableByteArray parsableByteArray5 = d2 != null ? d2.aN : null;
        AtomParsers atomParsers2 = new AtomParsers(parsableByteArray2, parsableByteArray, z);
        parsableByteArray3.m4455c(12);
        int t2 = parsableByteArray3.m4474t() - 1;
        int t3 = parsableByteArray3.m4474t();
        int t4 = parsableByteArray3.m4474t();
        int i10 = 0;
        if (parsableByteArray5 != null) {
            parsableByteArray5.m4455c(12);
            i10 = parsableByteArray5.m4474t();
        }
        if (parsableByteArray4 != null) {
            parsableByteArray4.m4455c(12);
            t = parsableByteArray4.m4474t();
            if (t > 0) {
                i = t;
                t = parsableByteArray4.m4474t() - 1;
                parsableByteArray = parsableByteArray4;
                i2 = i;
            } else {
                i = t;
                t = -1;
                parsableByteArray = null;
                i2 = i;
            }
        } else {
            t = -1;
            parsableByteArray = parsableByteArray4;
            i2 = 0;
        }
        Object obj4 = (atomParsers.m3320c() && "audio/raw".equals(track.f2860f.f2324e) && t2 == 0 && i10 == 0 && i2 == 0) ? 1 : null;
        if (obj4 == null) {
            obj = new long[a];
            Object obj5 = new int[a];
            long[] jArr2 = new long[a];
            Object obj6 = new int[a];
            long j3 = 0;
            int i11 = 0;
            i3 = t3;
            int i12 = 0;
            int i13 = i2;
            i2 = 0;
            i = t;
            t = i10;
            j = 0;
            i4 = 0;
            i5 = 0;
            i6 = t4;
            i7 = t2;
            t4 = i;
            while (i11 < a) {
                long j4 = j3;
                i8 = i5;
                while (i8 == 0) {
                    Assertions.m4406b(atomParsers2.m3317a());
                    j4 = atomParsers2.f2763d;
                    i8 = atomParsers2.f2762c;
                }
                if (parsableByteArray5 != null) {
                    while (i12 == 0 && t > 0) {
                        i12 = parsableByteArray5.m4474t();
                        i2 = parsableByteArray5.m4468n();
                        t--;
                    }
                    i12--;
                }
                obj[i11] = j4;
                obj5[i11] = atomParsers.m3319b();
                if (obj5[i11] > i4) {
                    i4 = obj5[i11];
                }
                jArr2[i11] = ((long) i2) + j;
                obj6[i11] = parsableByteArray == null ? 1 : 0;
                if (i11 == t4) {
                    obj6[i11] = 1;
                    i5 = i13 - 1;
                    if (i5 > 0) {
                        t4 = parsableByteArray.m4474t() - 1;
                        i13 = i5;
                    } else {
                        i13 = i5;
                    }
                }
                long j5 = ((long) i6) + j;
                i5 = i3 - 1;
                if (i5 != 0 || i7 <= 0) {
                    i = i6;
                    i6 = i5;
                    i5 = i;
                } else {
                    i6 = parsableByteArray3.m4474t();
                    i5 = parsableByteArray3.m4474t();
                    i7--;
                }
                j4 += (long) obj5[i11];
                i10 = i8 - 1;
                i11++;
                j3 = j4;
                i3 = i6;
                i6 = i5;
                i5 = i10;
                j = j5;
            }
            Assertions.m4404a(i12 == 0);
            while (t > 0) {
                Assertions.m4404a(parsableByteArray5.m4474t() == 0);
                parsableByteArray5.m4468n();
                t--;
            }
            if (!(i13 == 0 && i3 == 0 && i5 == 0 && i7 == 0)) {
                Log.w("AtomParsers", "Inconsistent stbl box for track " + track.f2855a + ": remainingSynchronizationSamples " + i13 + ", remainingSamplesAtTimestampDelta " + i3 + ", remainingSamplesInChunk " + i5 + ", remainingTimestampDeltaChanges " + i7);
            }
            obj4 = obj6;
            jArr = jArr2;
            i9 = i4;
            obj2 = obj5;
            obj3 = obj;
            j2 = j;
        } else {
            long[] jArr3 = new long[atomParsers2.f2760a];
            int[] iArr = new int[atomParsers2.f2760a];
            while (atomParsers2.m3317a()) {
                jArr3[atomParsers2.f2761b] = atomParsers2.f2763d;
                iArr[atomParsers2.f2761b] = atomParsers2.f2762c;
            }
            FixedSampleSizeRechunker a2 = FixedSampleSizeRechunker.m3351a(atomParsers.m3319b(), jArr3, iArr, (long) t4);
            obj3 = a2.f2795a;
            obj2 = a2.f2796b;
            i9 = a2.f2797c;
            jArr = a2.f2798d;
            obj4 = a2.f2799e;
            j2 = 0;
        }
        if (track.f2863i == null || gaplessInfoHolder.m3728a()) {
            Util.m4515a(jArr, 1000000, track.f2857c);
            return new TrackSampleTable(obj3, obj2, i9, jArr, obj4);
        }
        long a3;
        if (track.f2863i.length == 1 && track.f2856b == 1 && jArr.length >= 2) {
            long j6 = track.f2864j[0];
            a3 = Util.m4510a(track.f2863i[0], track.f2857c, track.f2858d) + j6;
            if (jArr[0] <= j6 && j6 < jArr[1] && jArr[jArr.length - 1] < a3 && a3 <= j2) {
                j2 -= a3;
                j6 = Util.m4510a(j6 - jArr[0], (long) track.f2860f.f2336q, track.f2857c);
                a3 = Util.m4510a(j2, (long) track.f2860f.f2336q, track.f2857c);
                if (!(j6 == 0 && a3 == 0) && j6 <= 2147483647L && a3 <= 2147483647L) {
                    gaplessInfoHolder.f3250a = (int) j6;
                    gaplessInfoHolder.f3251b = (int) a3;
                    Util.m4515a(jArr, 1000000, track.f2857c);
                    return new TrackSampleTable(obj3, obj2, i9, jArr, obj4);
                }
            }
        }
        int i14;
        if (track.f2863i.length == 1 && track.f2863i[0] == 0) {
            for (i14 = 0; i14 < jArr.length; i14++) {
                jArr[i14] = Util.m4510a(jArr[i14] - track.f2864j[0], 1000000, track.f2857c);
            }
            return new TrackSampleTable(obj3, obj2, i9, jArr, obj4);
        }
        long j7;
        Object obj7;
        Object obj8;
        i14 = 0;
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        while (i14 < track.f2863i.length) {
            j7 = track.f2864j[i14];
            if (j7 != -1) {
                a3 = Util.m4510a(track.f2863i[i14], track.f2857c, track.f2858d);
                i7 = Util.m4520b(jArr, j7, true, true);
                i5 = Util.m4520b(jArr, a3 + j7, true, false);
                i6 = i17 + (i5 - i7);
                if (i16 != i7) {
                    i4 = 1;
                } else {
                    i4 = 0;
                }
                i4 |= i15;
            } else {
                i4 = i15;
                i5 = i16;
                i6 = i17;
            }
            i14++;
            i15 = i4;
            i16 = i5;
            i17 = i6;
        }
        t2 = i15 | (i17 != a ? 1 : 0);
        if (t2 != 0) {
            obj7 = new long[i17];
        } else {
            obj7 = obj3;
        }
        if (t2 != 0) {
            obj8 = new int[i17];
        } else {
            obj8 = obj2;
        }
        if (t2 != 0) {
            i6 = 0;
        } else {
            i6 = i9;
        }
        if (t2 != 0) {
            obj = new int[i17];
        } else {
            obj = obj4;
        }
        long[] jArr4 = new long[i17];
        i14 = 0;
        i15 = 0;
        j7 = 0;
        i9 = i6;
        while (i14 < track.f2863i.length) {
            j5 = track.f2864j[i14];
            a3 = track.f2863i[i14];
            if (j5 != -1) {
                j = j5 + Util.m4510a(a3, track.f2857c, track.f2858d);
                i6 = Util.m4520b(jArr, j5, true, true);
                i3 = Util.m4520b(jArr, j, true, false);
                if (t2 != 0) {
                    i7 = i3 - i6;
                    System.arraycopy(obj3, i6, obj7, i15, i7);
                    System.arraycopy(obj2, i6, obj8, i15, i7);
                    System.arraycopy(obj4, i6, obj, i15, i7);
                }
                i17 = i15;
                for (i8 = i6; i8 < i3; i8++) {
                    jArr4[i17] = Util.m4510a(jArr[i8] - j5, 1000000, track.f2857c) + Util.m4510a(j7, 1000000, track.f2858d);
                    if (t2 != 0 && obj8[i17] > i9) {
                        i9 = obj2[i8];
                    }
                    i17++;
                }
                i6 = i9;
                i9 = i17;
            } else {
                i6 = i9;
                i9 = i15;
            }
            i14++;
            i15 = i9;
            j7 = a3 + j7;
            i9 = i6;
        }
        i2 = 0;
        for (i14 = 0; i14 < obj.length && i2 == 0; i14++) {
            i2 |= (obj[i14] & 1) != 0 ? 1 : 0;
        }
        if (i2 != 0) {
            return new TrackSampleTable(obj7, obj8, i9, jArr4, obj);
        }
        throw new ParserException("The edited sample sequence does not contain a sync sample.");
    }

    public static void m3338a(Atom atom, boolean z, GaplessInfoHolder gaplessInfoHolder) {
        if (!z) {
            ParsableByteArray parsableByteArray = atom.aN;
            parsableByteArray.m4455c(8);
            while (parsableByteArray.m4452b() >= 8) {
                int n = parsableByteArray.m4468n();
                if (parsableByteArray.m4468n() == Atom.aA) {
                    parsableByteArray.m4455c(parsableByteArray.m4456d() - 8);
                    parsableByteArray.m4453b(n + parsableByteArray.m4456d());
                    AtomParsers.m3341a(parsableByteArray, gaplessInfoHolder);
                    return;
                }
                parsableByteArray.m4457d(n - 8);
            }
        }
    }

    private static void m3341a(ParsableByteArray parsableByteArray, GaplessInfoHolder gaplessInfoHolder) {
        parsableByteArray.m4457d(12);
        ParsableByteArray parsableByteArray2 = new ParsableByteArray();
        while (parsableByteArray.m4452b() >= 8) {
            int n = parsableByteArray.m4468n() - 8;
            if (parsableByteArray.m4468n() == Atom.aB) {
                parsableByteArray2.m4450a(parsableByteArray.f3831a, parsableByteArray.m4456d() + n);
                parsableByteArray2.m4455c(parsableByteArray.m4456d());
                AtomParsers.m3345b(parsableByteArray2, gaplessInfoHolder);
                if (gaplessInfoHolder.m3728a()) {
                    return;
                }
            }
            parsableByteArray.m4457d(n);
        }
    }

    private static void m3345b(ParsableByteArray parsableByteArray, GaplessInfoHolder gaplessInfoHolder) {
        while (parsableByteArray.m4452b() > 0) {
            int d = parsableByteArray.m4456d() + parsableByteArray.m4468n();
            if (parsableByteArray.m4468n() == Atom.aL) {
                String str = null;
                String str2 = null;
                Object obj = null;
                while (parsableByteArray.m4456d() < d) {
                    int n = parsableByteArray.m4468n() - 12;
                    int n2 = parsableByteArray.m4468n();
                    parsableByteArray.m4457d(4);
                    if (n2 == Atom.aC) {
                        obj = parsableByteArray.m4459e(n);
                    } else if (n2 == Atom.aD) {
                        str2 = parsableByteArray.m4459e(n);
                    } else if (n2 == Atom.aE) {
                        parsableByteArray.m4457d(4);
                        str = parsableByteArray.m4459e(n - 4);
                    } else {
                        parsableByteArray.m4457d(n);
                    }
                }
                if (!(str2 == null || str == null || !"com.apple.iTunes".equals(r2))) {
                    gaplessInfoHolder.m3730a(str2, str);
                    return;
                }
            }
            parsableByteArray.m4455c(d);
        }
    }

    private static long m3333a(ParsableByteArray parsableByteArray) {
        int i = 8;
        parsableByteArray.m4455c(8);
        if (Atom.m3310a(parsableByteArray.m4468n()) != 0) {
            i = 16;
        }
        parsableByteArray.m4457d(i);
        return parsableByteArray.m4466l();
    }

    private static AtomParsers m3344b(ParsableByteArray parsableByteArray) {
        long j;
        int i = 8;
        parsableByteArray.m4455c(8);
        int a = Atom.m3310a(parsableByteArray.m4468n());
        parsableByteArray.m4457d(a == 0 ? 8 : 16);
        int n = parsableByteArray.m4468n();
        parsableByteArray.m4457d(4);
        Object obj = 1;
        int d = parsableByteArray.m4456d();
        if (a == 0) {
            i = 4;
        }
        for (int i2 = 0; i2 < i; i2++) {
            if (parsableByteArray.f3831a[d + i2] != -1) {
                obj = null;
                break;
            }
        }
        if (obj != null) {
            parsableByteArray.m4457d(i);
            j = -9223372036854775807L;
        } else {
            j = a == 0 ? parsableByteArray.m4466l() : parsableByteArray.m4476v();
            if (j == 0) {
                j = -9223372036854775807L;
            }
        }
        parsableByteArray.m4457d(16);
        int n2 = parsableByteArray.m4468n();
        int n3 = parsableByteArray.m4468n();
        parsableByteArray.m4457d(4);
        int n4 = parsableByteArray.m4468n();
        int n5 = parsableByteArray.m4468n();
        n2 = (n2 == 0 && n3 == AccessibilityNodeInfoCompat.ACTION_CUT && n4 == (-65536) && n5 == 0) ? 90 : (n2 == 0 && n3 == (-65536) && n4 == AccessibilityNodeInfoCompat.ACTION_CUT && n5 == 0) ? 270 : (n2 == (-65536) && n3 == 0 && n4 == 0 && n5 == (-65536)) ? 180 : 0;
        return new AtomParsers(n, j, n2);
    }

    private static int m3346c(ParsableByteArray parsableByteArray) {
        parsableByteArray.m4455c(16);
        int n = parsableByteArray.m4468n();
        if (n == f2785b) {
            return 1;
        }
        if (n == f2784a) {
            return 2;
        }
        if (n == f2786c || n == f2787d || n == f2788e || n == f2789f) {
            return 3;
        }
        return -1;
    }

    private static Pair<Long, String> m3348d(ParsableByteArray parsableByteArray) {
        int i = 8;
        parsableByteArray.m4455c(8);
        int a = Atom.m3310a(parsableByteArray.m4468n());
        parsableByteArray.m4457d(a == 0 ? 8 : 16);
        long l = parsableByteArray.m4466l();
        if (a == 0) {
            i = 4;
        }
        parsableByteArray.m4457d(i);
        int h = parsableByteArray.m4462h();
        return Pair.create(Long.valueOf(l), FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING + ((char) (((h >> 10) & 31) + 96)) + ((char) (((h >> 5) & 31) + 96)) + ((char) ((h & 31) + 96)));
    }

    private static AtomParsers m3335a(ParsableByteArray parsableByteArray, int i, int i2, String str, DrmInitData drmInitData, boolean z) {
        parsableByteArray.m4455c(12);
        int n = parsableByteArray.m4468n();
        AtomParsers atomParsers = new AtomParsers(n);
        for (int i3 = 0; i3 < n; i3++) {
            int d = parsableByteArray.m4456d();
            int n2 = parsableByteArray.m4468n();
            Assertions.m4405a(n2 > 0, "childAtomSize should be positive");
            int n3 = parsableByteArray.m4468n();
            if (n3 == Atom.f2735b || n3 == Atom.f2736c || n3 == Atom.f2732Y || n3 == Atom.ak || n3 == Atom.f2737d || n3 == Atom.f2738e || n3 == Atom.f2739f || n3 == Atom.aI || n3 == Atom.aJ) {
                AtomParsers.m3339a(parsableByteArray, n3, d, n2, i, i2, drmInitData, atomParsers, i3);
            } else if (n3 == Atom.f2742i || n3 == Atom.f2733Z || n3 == Atom.f2746m || n3 == Atom.f2748o || n3 == Atom.f2750q || n3 == Atom.f2753t || n3 == Atom.f2751r || n3 == Atom.f2752s || n3 == Atom.ax || n3 == Atom.ay || n3 == Atom.f2744k || n3 == Atom.f2745l) {
                AtomParsers.m3340a(parsableByteArray, n3, d, n2, i, str, z, drmInitData, atomParsers, i3);
            } else if (n3 == Atom.ai) {
                atomParsers.f2770b = Format.m2863a(Integer.toString(i), "application/ttml+xml", null, -1, 0, str, drmInitData);
            } else if (n3 == Atom.at) {
                atomParsers.f2770b = Format.m2863a(Integer.toString(i), "application/x-quicktime-tx3g", null, -1, 0, str, drmInitData);
            } else if (n3 == Atom.au) {
                atomParsers.f2770b = Format.m2863a(Integer.toString(i), "application/x-mp4vtt", null, -1, 0, str, drmInitData);
            } else if (n3 == Atom.av) {
                atomParsers.f2770b = Format.m2864a(Integer.toString(i), "application/ttml+xml", null, -1, 0, str, drmInitData, 0);
            } else if (n3 == Atom.aw) {
                atomParsers.f2770b = Format.m2863a(Integer.toString(i), "application/cea-608", null, -1, 0, str, drmInitData);
                atomParsers.f2772d = 1;
            }
            parsableByteArray.m4455c(d + n2);
        }
        return atomParsers;
    }

    private static void m3339a(ParsableByteArray parsableByteArray, int i, int i2, int i3, int i4, int i5, DrmInitData drmInitData, AtomParsers atomParsers, int i6) {
        parsableByteArray.m4455c(i2 + 8);
        parsableByteArray.m4457d(24);
        int h = parsableByteArray.m4462h();
        int h2 = parsableByteArray.m4462h();
        Object obj = null;
        float f = 1.0f;
        parsableByteArray.m4457d(50);
        int d = parsableByteArray.m4456d();
        if (i == Atom.f2732Y) {
            i = AtomParsers.m3332a(parsableByteArray, i2, i3, atomParsers, i6);
            parsableByteArray.m4455c(d);
        }
        List list = null;
        String str = null;
        byte[] bArr = null;
        int i7 = -1;
        int i8 = d;
        while (i8 - i2 < i3) {
            parsableByteArray.m4455c(i8);
            int d2 = parsableByteArray.m4456d();
            int n = parsableByteArray.m4468n();
            if (n != 0 || parsableByteArray.m4456d() - i2 != i3) {
                Object obj2;
                Assertions.m4405a(n > 0, "childAtomSize should be positive");
                d = parsableByteArray.m4468n();
                if (d == Atom.f2714G) {
                    Assertions.m4406b(str == null);
                    str = "video/avc";
                    parsableByteArray.m4455c(d2 + 8);
                    AvcConfig a = AvcConfig.m4532a(parsableByteArray);
                    list = a.f3864a;
                    atomParsers.f2771c = a.f3865b;
                    if (obj == null) {
                        f = a.f3868e;
                    }
                    obj2 = obj;
                } else if (d == Atom.f2715H) {
                    Assertions.m4406b(str == null);
                    str = "video/hevc";
                    parsableByteArray.m4455c(d2 + 8);
                    HevcConfig a2 = HevcConfig.m4534a(parsableByteArray);
                    list = a2.f3869a;
                    atomParsers.f2771c = a2.f3870b;
                    obj2 = obj;
                } else if (d == Atom.aK) {
                    Assertions.m4406b(str == null);
                    str = i == Atom.aI ? "video/x-vnd.on2.vp8" : "video/x-vnd.on2.vp9";
                    obj2 = obj;
                } else if (d == Atom.f2740g) {
                    Assertions.m4406b(str == null);
                    str = "video/3gpp";
                    obj2 = obj;
                } else if (d == Atom.f2716I) {
                    Assertions.m4406b(str == null);
                    Pair b = AtomParsers.m3342b(parsableByteArray, d2);
                    String str2 = (String) b.first;
                    list = Collections.singletonList(b.second);
                    str = str2;
                    obj2 = obj;
                } else if (d == Atom.ah) {
                    f = AtomParsers.m3330a(parsableByteArray, d2);
                    obj2 = 1;
                } else if (d == Atom.aG) {
                    bArr = AtomParsers.m3349d(parsableByteArray, d2, n);
                    obj2 = obj;
                } else {
                    if (d == Atom.aF) {
                        d = parsableByteArray.m4461g();
                        parsableByteArray.m4457d(3);
                        if (d == 0) {
                            switch (parsableByteArray.m4461g()) {
                                case NendAdIconLayout.HORIZONTAL /*0*/:
                                    i7 = 0;
                                    obj2 = obj;
                                    continue;
                                case NendIconError.ERROR_ICONVIEW /*1*/:
                                    i7 = 1;
                                    obj2 = obj;
                                    continue;
                                case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                                    i7 = 2;
                                    obj2 = obj;
                                    continue;
                            }
                        }
                    }
                    obj2 = obj;
                }
                i8 += n;
                obj = obj2;
            } else if (str == null) {
                atomParsers.f2770b = Format.m2859a(Integer.toString(i4), str, null, -1, -1, h, h2, -1.0f, list, i5, f, bArr, i7, drmInitData);
            }
        }
        if (str == null) {
            atomParsers.f2770b = Format.m2859a(Integer.toString(i4), str, null, -1, -1, h, h2, -1.0f, list, i5, f, bArr, i7, drmInitData);
        }
    }

    private static Pair<long[], long[]> m3334a(Atom atom) {
        if (atom != null) {
            Atom d = atom.m3315d(Atom.f2723P);
            if (d != null) {
                ParsableByteArray parsableByteArray = d.aN;
                parsableByteArray.m4455c(8);
                int a = Atom.m3310a(parsableByteArray.m4468n());
                int t = parsableByteArray.m4474t();
                Object obj = new long[t];
                Object obj2 = new long[t];
                for (int i = 0; i < t; i++) {
                    obj[i] = a == 1 ? parsableByteArray.m4476v() : parsableByteArray.m4466l();
                    obj2[i] = a == 1 ? parsableByteArray.m4470p() : (long) parsableByteArray.m4468n();
                    if (parsableByteArray.m4464j() != (short) 1) {
                        throw new IllegalArgumentException("Unsupported media rate.");
                    }
                    parsableByteArray.m4457d(2);
                }
                return Pair.create(obj, obj2);
            }
        }
        return Pair.create(null, null);
    }

    private static float m3330a(ParsableByteArray parsableByteArray, int i) {
        parsableByteArray.m4455c(i + 8);
        return ((float) parsableByteArray.m4474t()) / ((float) parsableByteArray.m4474t());
    }

    private static void m3340a(ParsableByteArray parsableByteArray, int i, int i2, int i3, int i4, String str, boolean z, DrmInitData drmInitData, AtomParsers atomParsers, int i5) {
        int h;
        int i6;
        int h2;
        parsableByteArray.m4455c(i2 + 8);
        if (z) {
            parsableByteArray.m4457d(8);
            h = parsableByteArray.m4462h();
            parsableByteArray.m4457d(6);
            i6 = h;
        } else {
            parsableByteArray.m4457d(16);
            i6 = 0;
        }
        if (i6 == 0 || i6 == 1) {
            h2 = parsableByteArray.m4462h();
            parsableByteArray.m4457d(6);
            h = parsableByteArray.m4472r();
            if (i6 == 1) {
                parsableByteArray.m4457d(16);
            }
        } else if (i6 == 2) {
            parsableByteArray.m4457d(16);
            h = (int) Math.round(parsableByteArray.m4477w());
            h2 = parsableByteArray.m4474t();
            parsableByteArray.m4457d(20);
        } else {
            return;
        }
        int d = parsableByteArray.m4456d();
        if (i == Atom.f2733Z) {
            i = AtomParsers.m3332a(parsableByteArray, i2, i3, atomParsers, i5);
            parsableByteArray.m4455c(d);
        }
        String str2 = null;
        if (i == Atom.f2746m) {
            str2 = "audio/ac3";
        } else if (i == Atom.f2748o) {
            str2 = "audio/eac3";
        } else if (i == Atom.f2750q) {
            str2 = "audio/vnd.dts";
        } else if (i == Atom.f2751r || i == Atom.f2752s) {
            str2 = "audio/vnd.dts.hd";
        } else if (i == Atom.f2753t) {
            str2 = "audio/vnd.dts.hd;profile=lbr";
        } else if (i == Atom.ax) {
            str2 = "audio/3gpp";
        } else if (i == Atom.ay) {
            str2 = "audio/amr-wb";
        } else if (i == Atom.f2744k || i == Atom.f2745l) {
            str2 = "audio/raw";
        }
        Object obj = null;
        int i7 = h;
        int i8 = h2;
        String str3 = str2;
        while (d - i2 < i3) {
            parsableByteArray.m4455c(d);
            int n = parsableByteArray.m4468n();
            Assertions.m4405a(n > 0, "childAtomSize should be positive");
            h = parsableByteArray.m4468n();
            if (h == Atom.f2716I || (z && h == Atom.f2743j)) {
                Object obj2;
                if (h == Atom.f2716I) {
                    h = d;
                } else {
                    h = AtomParsers.m3331a(parsableByteArray, d, n);
                }
                if (h != -1) {
                    Pair b = AtomParsers.m3342b(parsableByteArray, h);
                    str3 = (String) b.first;
                    obj2 = (byte[]) b.second;
                    if ("audio/mp4a-latm".equals(str3)) {
                        Pair a = CodecSpecificDataUtil.m4408a(obj2);
                        i7 = ((Integer) a.first).intValue();
                        i8 = ((Integer) a.second).intValue();
                    }
                } else {
                    obj2 = obj;
                }
                obj = obj2;
            } else if (h == Atom.f2747n) {
                parsableByteArray.m4455c(d + 8);
                atomParsers.f2770b = Ac3Util.m2881a(parsableByteArray, Integer.toString(i4), str, drmInitData);
            } else if (h == Atom.f2749p) {
                parsableByteArray.m4455c(d + 8);
                atomParsers.f2770b = Ac3Util.m2884b(parsableByteArray, Integer.toString(i4), str, drmInitData);
            } else if (h == Atom.f2754u) {
                atomParsers.f2770b = Format.m2862a(Integer.toString(i4), str3, null, -1, -1, i8, i7, null, drmInitData, 0, str);
            }
            d += n;
        }
        if (atomParsers.f2770b == null && str3 != null) {
            List list;
            int i9 = "audio/raw".equals(str3) ? 2 : -1;
            String num = Integer.toString(i4);
            if (obj == null) {
                list = null;
            } else {
                list = Collections.singletonList(obj);
            }
            atomParsers.f2770b = Format.m2861a(num, str3, null, -1, -1, i8, i7, i9, list, drmInitData, 0, str);
        }
    }

    private static int m3331a(ParsableByteArray parsableByteArray, int i, int i2) {
        int d = parsableByteArray.m4456d();
        while (d - i < i2) {
            parsableByteArray.m4455c(d);
            int n = parsableByteArray.m4468n();
            Assertions.m4405a(n > 0, "childAtomSize should be positive");
            if (parsableByteArray.m4468n() == Atom.f2716I) {
                return d;
            }
            d += n;
        }
        return -1;
    }

    private static Pair<String, byte[]> m3342b(ParsableByteArray parsableByteArray, int i) {
        Object obj = null;
        parsableByteArray.m4455c((i + 8) + 4);
        parsableByteArray.m4457d(1);
        AtomParsers.m3350e(parsableByteArray);
        parsableByteArray.m4457d(2);
        int g = parsableByteArray.m4461g();
        if ((g & AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS) != 0) {
            parsableByteArray.m4457d(2);
        }
        if ((g & 64) != 0) {
            parsableByteArray.m4457d(parsableByteArray.m4462h());
        }
        if ((g & 32) != 0) {
            parsableByteArray.m4457d(2);
        }
        parsableByteArray.m4457d(1);
        AtomParsers.m3350e(parsableByteArray);
        switch (parsableByteArray.m4461g()) {
            case AdSize.LANDSCAPE_AD_HEIGHT /*32*/:
                obj = "video/mp4v-es";
                break;
            case C0268R.styleable.AppCompatTheme_actionModeCopyDrawable /*33*/:
                obj = "video/avc";
                break;
            case C0268R.styleable.AppCompatTheme_actionModeSelectAllDrawable /*35*/:
                obj = "video/hevc";
                break;
            case C0268R.styleable.AppCompatTheme_editTextBackground /*64*/:
            case C0268R.styleable.AppCompatTheme_buttonStyle /*102*/:
            case C0268R.styleable.AppCompatTheme_buttonStyleSmall /*103*/:
            case C0268R.styleable.AppCompatTheme_checkboxStyle /*104*/:
                obj = "audio/mp4a-latm";
                break;
            case C0268R.styleable.AppCompatTheme_radioButtonStyle /*107*/:
                return Pair.create("audio/mpeg", null);
            case 165:
                obj = "audio/ac3";
                break;
            case 166:
                obj = "audio/eac3";
                break;
            case 169:
            case 172:
                return Pair.create("audio/vnd.dts", null);
            case 170:
            case 171:
                return Pair.create("audio/vnd.dts.hd", null);
        }
        parsableByteArray.m4457d(12);
        parsableByteArray.m4457d(1);
        g = AtomParsers.m3350e(parsableByteArray);
        Object obj2 = new byte[g];
        parsableByteArray.m4451a(obj2, 0, g);
        return Pair.create(obj, obj2);
    }

    private static int m3332a(ParsableByteArray parsableByteArray, int i, int i2, AtomParsers atomParsers, int i3) {
        int d = parsableByteArray.m4456d();
        while (d - i < i2) {
            parsableByteArray.m4455c(d);
            int n = parsableByteArray.m4468n();
            Assertions.m4405a(n > 0, "childAtomSize should be positive");
            if (parsableByteArray.m4468n() == Atom.f2728U) {
                Pair b = AtomParsers.m3343b(parsableByteArray, d, n);
                if (b != null) {
                    atomParsers.f2769a[i3] = (TrackEncryptionBox) b.second;
                    return ((Integer) b.first).intValue();
                }
            }
            d += n;
        }
        return 0;
    }

    private static Pair<Integer, TrackEncryptionBox> m3343b(ParsableByteArray parsableByteArray, int i, int i2) {
        boolean z = true;
        Object obj = null;
        boolean z2 = false;
        int i3 = i + 8;
        Object obj2 = null;
        while (i3 - i < i2) {
            parsableByteArray.m4455c(i3);
            int n = parsableByteArray.m4468n();
            int n2 = parsableByteArray.m4468n();
            if (n2 == Atom.aa) {
                obj2 = Integer.valueOf(parsableByteArray.m4468n());
            } else if (n2 == Atom.f2729V) {
                parsableByteArray.m4457d(4);
                z2 = parsableByteArray.m4468n() == f2790g;
            } else if (n2 == Atom.f2730W) {
                obj = AtomParsers.m3347c(parsableByteArray, i3, n);
            }
            i3 += n;
        }
        if (!z2) {
            return null;
        }
        if (obj2 != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.m4405a(z2, "frma atom is mandatory");
        if (obj == null) {
            z = false;
        }
        Assertions.m4405a(z, "schi->tenc atom is mandatory");
        return Pair.create(obj2, obj);
    }

    private static TrackEncryptionBox m3347c(ParsableByteArray parsableByteArray, int i, int i2) {
        boolean z = true;
        int i3 = i + 8;
        while (i3 - i < i2) {
            parsableByteArray.m4455c(i3);
            int n = parsableByteArray.m4468n();
            if (parsableByteArray.m4468n() == Atom.f2731X) {
                parsableByteArray.m4457d(6);
                if (parsableByteArray.m4461g() != 1) {
                    z = false;
                }
                i3 = parsableByteArray.m4461g();
                byte[] bArr = new byte[16];
                parsableByteArray.m4451a(bArr, 0, bArr.length);
                return new TrackEncryptionBox(z, i3, bArr);
            }
            i3 += n;
        }
        return null;
    }

    private static byte[] m3349d(ParsableByteArray parsableByteArray, int i, int i2) {
        int i3 = i + 8;
        while (i3 - i < i2) {
            parsableByteArray.m4455c(i3);
            int n = parsableByteArray.m4468n();
            if (parsableByteArray.m4468n() == Atom.aH) {
                return Arrays.copyOfRange(parsableByteArray.f3831a, i3, n + i3);
            }
            i3 += n;
        }
        return null;
    }

    private static int m3350e(ParsableByteArray parsableByteArray) {
        int g = parsableByteArray.m4461g();
        int i = g & TransportMediator.KEYCODE_MEDIA_PAUSE;
        while ((g & AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS) == AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS) {
            g = parsableByteArray.m4461g();
            i = (i << 7) | (g & TransportMediator.KEYCODE_MEDIA_PAUSE);
        }
        return i;
    }
}
