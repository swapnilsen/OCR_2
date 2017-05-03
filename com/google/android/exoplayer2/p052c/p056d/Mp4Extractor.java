package com.google.android.exoplayer2.p052c.p056d;

import android.support.v4.media.session.PlaybackStateCompat;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.p050j.Assertions;
import com.google.android.exoplayer2.p050j.NalUnitUtil;
import com.google.android.exoplayer2.p050j.ParsableByteArray;
import com.google.android.exoplayer2.p050j.Util;
import com.google.android.exoplayer2.p052c.Extractor;
import com.google.android.exoplayer2.p052c.ExtractorInput;
import com.google.android.exoplayer2.p052c.ExtractorOutput;
import com.google.android.exoplayer2.p052c.ExtractorsFactory;
import com.google.android.exoplayer2.p052c.GaplessInfoHolder;
import com.google.android.exoplayer2.p052c.PositionHolder;
import com.google.android.exoplayer2.p052c.SeekMap;
import com.google.android.exoplayer2.p052c.TrackOutput;
import com.google.android.exoplayer2.p052c.p056d.Atom.Atom;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import net.nend.android.NendAdIconLayout;
import net.nend.android.NendIconError;

/* renamed from: com.google.android.exoplayer2.c.d.f */
public final class Mp4Extractor implements Extractor, SeekMap {
    public static final ExtractorsFactory f2837a;
    private static final int f2838b;
    private final ParsableByteArray f2839c;
    private final ParsableByteArray f2840d;
    private final ParsableByteArray f2841e;
    private final Stack<Atom> f2842f;
    private int f2843g;
    private int f2844h;
    private long f2845i;
    private int f2846j;
    private ParsableByteArray f2847k;
    private int f2848l;
    private int f2849m;
    private ExtractorOutput f2850n;
    private Mp4Extractor[] f2851o;
    private long f2852p;
    private boolean f2853q;

    /* renamed from: com.google.android.exoplayer2.c.d.f.1 */
    static class Mp4Extractor implements ExtractorsFactory {
        Mp4Extractor() {
        }

        public Extractor[] m3391a() {
            return new Extractor[]{new Mp4Extractor()};
        }
    }

    /* renamed from: com.google.android.exoplayer2.c.d.f.a */
    private static final class Mp4Extractor {
        public final Track f2833a;
        public final TrackSampleTable f2834b;
        public final TrackOutput f2835c;
        public int f2836d;

        public Mp4Extractor(Track track, TrackSampleTable trackSampleTable, TrackOutput trackOutput) {
            this.f2833a = track;
            this.f2834b = trackSampleTable;
            this.f2835c = trackOutput;
        }
    }

    static {
        f2837a = new Mp4Extractor();
        f2838b = Util.m4524e("qt  ");
    }

    public Mp4Extractor() {
        this.f2841e = new ParsableByteArray(16);
        this.f2842f = new Stack();
        this.f2839c = new ParsableByteArray(NalUnitUtil.f3823a);
        this.f2840d = new ParsableByteArray(4);
        m3400d();
    }

    public boolean m3406a(ExtractorInput extractorInput) {
        return Sniffer.m3415b(extractorInput);
    }

    public void m3404a(ExtractorOutput extractorOutput) {
        this.f2850n = extractorOutput;
    }

    public void m3403a(long j) {
        this.f2842f.clear();
        this.f2846j = 0;
        this.f2848l = 0;
        this.f2849m = 0;
        this.f2843g = 0;
    }

    public void m3409c() {
    }

    public int m3402a(ExtractorInput extractorInput, PositionHolder positionHolder) {
        while (true) {
            switch (this.f2843g) {
                case NendAdIconLayout.HORIZONTAL /*0*/:
                    if (extractorInput.m3238c() != 0) {
                        this.f2843g = 3;
                        break;
                    }
                    m3400d();
                    break;
                case NendIconError.ERROR_ICONVIEW /*1*/:
                    if (m3396b(extractorInput)) {
                        break;
                    }
                    return -1;
                case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                    if (!m3397b(extractorInput, positionHolder)) {
                        break;
                    }
                    return 1;
                default:
                    return m3398c(extractorInput, positionHolder);
            }
        }
    }

    public boolean m3405a() {
        return true;
    }

    public long m3407b() {
        return this.f2852p;
    }

    public long m3408b(long j) {
        long j2 = Long.MAX_VALUE;
        Mp4Extractor[] mp4ExtractorArr = this.f2851o;
        int length = mp4ExtractorArr.length;
        int i = 0;
        while (i < length) {
            Mp4Extractor mp4Extractor = mp4ExtractorArr[i];
            TrackSampleTable trackSampleTable = mp4Extractor.f2834b;
            int a = trackSampleTable.m3422a(j);
            if (a == -1) {
                a = trackSampleTable.m3423b(j);
            }
            mp4Extractor.f2836d = a;
            long j3 = trackSampleTable.f2889b[a];
            if (j3 >= j2) {
                j3 = j2;
            }
            i++;
            j2 = j3;
        }
        return j2;
    }

    private void m3400d() {
        this.f2843g = 1;
        this.f2846j = 0;
    }

    private boolean m3396b(ExtractorInput extractorInput) {
        if (this.f2846j == 0) {
            if (!extractorInput.m3233a(this.f2841e.f3831a, 0, 8, true)) {
                return false;
            }
            this.f2846j = 8;
            this.f2841e.m4455c(0);
            this.f2845i = this.f2841e.m4466l();
            this.f2844h = this.f2841e.m4468n();
        }
        if (this.f2845i == 1) {
            extractorInput.m3236b(this.f2841e.f3831a, 8, 8);
            this.f2846j += 8;
            this.f2845i = this.f2841e.m4476v();
        }
        if (Mp4Extractor.m3395b(this.f2844h)) {
            long c = (extractorInput.m3238c() + this.f2845i) - ((long) this.f2846j);
            this.f2842f.add(new Atom(this.f2844h, c));
            if (this.f2845i == ((long) this.f2846j)) {
                m3399c(c);
            } else {
                m3400d();
            }
        } else if (Mp4Extractor.m3393a(this.f2844h)) {
            boolean z;
            if (this.f2846j == 8) {
                z = true;
            } else {
                z = false;
            }
            Assertions.m4406b(z);
            if (this.f2845i <= 2147483647L) {
                z = true;
            } else {
                z = false;
            }
            Assertions.m4406b(z);
            this.f2847k = new ParsableByteArray((int) this.f2845i);
            System.arraycopy(this.f2841e.f3831a, 0, this.f2847k.f3831a, 0, 8);
            this.f2843g = 2;
        } else {
            this.f2847k = null;
            this.f2843g = 2;
        }
        return true;
    }

    private boolean m3397b(ExtractorInput extractorInput, PositionHolder positionHolder) {
        boolean z;
        long j = this.f2845i - ((long) this.f2846j);
        long c = extractorInput.m3238c() + j;
        if (this.f2847k != null) {
            extractorInput.m3236b(this.f2847k.f3831a, this.f2846j, (int) j);
            if (this.f2844h == Atom.f2734a) {
                this.f2853q = Mp4Extractor.m3394a(this.f2847k);
                z = false;
            } else if (this.f2842f.isEmpty()) {
                z = false;
            } else {
                ((Atom) this.f2842f.peek()).m3314a(new Atom(this.f2844h, this.f2847k));
                z = false;
            }
        } else if (j < PlaybackStateCompat.ACTION_SET_REPEAT_MODE) {
            extractorInput.m3235b((int) j);
            z = false;
        } else {
            positionHolder.f3266a = j + extractorInput.m3238c();
            z = true;
        }
        m3399c(c);
        if (!z || this.f2843g == 3) {
            return false;
        }
        return true;
    }

    private void m3399c(long j) {
        while (!this.f2842f.isEmpty() && ((Atom) this.f2842f.peek()).aN == j) {
            Atom atom = (Atom) this.f2842f.pop();
            if (atom.aM == Atom.f2708A) {
                m3392a(atom);
                this.f2842f.clear();
                this.f2843g = 3;
            } else if (!this.f2842f.isEmpty()) {
                ((Atom) this.f2842f.peek()).m3313a(atom);
            }
        }
        if (this.f2843g != 3) {
            m3400d();
        }
    }

    private static boolean m3394a(ParsableByteArray parsableByteArray) {
        parsableByteArray.m4455c(8);
        if (parsableByteArray.m4468n() == f2838b) {
            return true;
        }
        parsableByteArray.m4457d(4);
        while (parsableByteArray.m4452b() > 0) {
            if (parsableByteArray.m4468n() == f2838b) {
                return true;
            }
        }
        return false;
    }

    private void m3392a(Atom atom) {
        List arrayList = new ArrayList();
        GaplessInfoHolder gaplessInfoHolder = new GaplessInfoHolder();
        Atom d = atom.m3315d(Atom.az);
        if (d != null) {
            AtomParsers.m3338a(d, this.f2853q, gaplessInfoHolder);
        }
        int i = 0;
        long j = Long.MAX_VALUE;
        long j2 = -9223372036854775807L;
        while (i < atom.aP.size()) {
            long j3;
            long j4;
            Atom atom2 = (Atom) atom.aP.get(i);
            if (atom2.aM != Atom.f2710C) {
                j3 = j;
                j4 = j2;
            } else {
                Track a = AtomParsers.m3336a(atom2, atom.m3315d(Atom.f2709B), -9223372036854775807L, null, this.f2853q);
                if (a == null) {
                    j3 = j;
                    j4 = j2;
                } else {
                    TrackSampleTable a2 = AtomParsers.m3337a(a, atom2.m3316e(Atom.f2711D).m3316e(Atom.f2712E).m3316e(Atom.f2713F), gaplessInfoHolder);
                    if (a2.f2888a == 0) {
                        j3 = j;
                        j4 = j2;
                    } else {
                        Mp4Extractor mp4Extractor = new Mp4Extractor(a, a2, this.f2850n.m3725a(i));
                        Format a3 = a.f2860f.m2871a(a2.f2891d + 30);
                        if (a.f2856b == 1 && gaplessInfoHolder.m3728a()) {
                            a3 = a3.m2872a(gaplessInfoHolder.f3250a, gaplessInfoHolder.f3251b);
                        }
                        mp4Extractor.f2835c.m3426a(a3);
                        j2 = Math.max(j2, a.f2859e);
                        arrayList.add(mp4Extractor);
                        j3 = a2.f2889b[0];
                        if (j3 < j) {
                            j4 = j2;
                        } else {
                            j3 = j;
                            j4 = j2;
                        }
                    }
                }
            }
            i++;
            j = j3;
            j2 = j4;
        }
        this.f2852p = j2;
        this.f2851o = (Mp4Extractor[]) arrayList.toArray(new Mp4Extractor[arrayList.size()]);
        this.f2850n.m3726a();
        this.f2850n.m3727a((SeekMap) this);
    }

    private int m3398c(ExtractorInput extractorInput, PositionHolder positionHolder) {
        int e = m3401e();
        if (e == -1) {
            return -1;
        }
        Mp4Extractor mp4Extractor = this.f2851o[e];
        TrackOutput trackOutput = mp4Extractor.f2835c;
        int i = mp4Extractor.f2836d;
        long j = mp4Extractor.f2834b.f2889b[i];
        e = mp4Extractor.f2834b.f2890c[i];
        if (mp4Extractor.f2833a.f2861g == 1) {
            j += 8;
            e -= 8;
        }
        long c = (j - extractorInput.m3238c()) + ((long) this.f2848l);
        if (c < 0 || c >= PlaybackStateCompat.ACTION_SET_REPEAT_MODE) {
            positionHolder.f3266a = j;
            return 1;
        }
        int a;
        extractorInput.m3235b((int) c);
        int i2;
        if (mp4Extractor.f2833a.f2865k != 0) {
            byte[] bArr = this.f2840d.f3831a;
            bArr[0] = (byte) 0;
            bArr[1] = (byte) 0;
            bArr[2] = (byte) 0;
            i2 = mp4Extractor.f2833a.f2865k;
            int i3 = 4 - mp4Extractor.f2833a.f2865k;
            while (this.f2848l < e) {
                if (this.f2849m == 0) {
                    extractorInput.m3236b(this.f2840d.f3831a, i3, i2);
                    this.f2840d.m4455c(0);
                    this.f2849m = this.f2840d.m4474t();
                    this.f2839c.m4455c(0);
                    trackOutput.m3427a(this.f2839c, 4);
                    this.f2848l += 4;
                    e += i3;
                } else {
                    a = trackOutput.m3424a(extractorInput, this.f2849m, false);
                    this.f2848l += a;
                    this.f2849m -= a;
                }
            }
            a = e;
        } else {
            while (this.f2848l < e) {
                i2 = trackOutput.m3424a(extractorInput, e - this.f2848l, false);
                this.f2848l += i2;
                this.f2849m -= i2;
            }
            a = e;
        }
        trackOutput.m3425a(mp4Extractor.f2834b.f2892e[i], mp4Extractor.f2834b.f2893f[i], a, 0, null);
        mp4Extractor.f2836d++;
        this.f2848l = 0;
        this.f2849m = 0;
        return 0;
    }

    private int m3401e() {
        int i = -1;
        long j = Long.MAX_VALUE;
        for (int i2 = 0; i2 < this.f2851o.length; i2++) {
            Mp4Extractor mp4Extractor = this.f2851o[i2];
            int i3 = mp4Extractor.f2836d;
            if (i3 != mp4Extractor.f2834b.f2888a) {
                long j2 = mp4Extractor.f2834b.f2889b[i3];
                if (j2 < j) {
                    j = j2;
                    i = i2;
                }
            }
        }
        return i;
    }

    private static boolean m3393a(int i) {
        return i == Atom.f2724Q || i == Atom.f2709B || i == Atom.f2725R || i == Atom.f2726S || i == Atom.al || i == Atom.am || i == Atom.an || i == Atom.f2723P || i == Atom.ao || i == Atom.ap || i == Atom.aq || i == Atom.ar || i == Atom.as || i == Atom.f2721N || i == Atom.f2734a || i == Atom.az;
    }

    private static boolean m3395b(int i) {
        return i == Atom.f2708A || i == Atom.f2710C || i == Atom.f2711D || i == Atom.f2712E || i == Atom.f2713F || i == Atom.f2722O;
    }
}
