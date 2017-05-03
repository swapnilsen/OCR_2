package com.google.android.exoplayer2.p052c.p056d;

import android.support.v4.view.PointerIconCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v7.widget.RecyclerView.ItemAnimator;
import android.util.Log;
import android.util.Pair;
import android.util.SparseArray;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmInitData.SchemeData;
import com.google.android.exoplayer2.p050j.Assertions;
import com.google.android.exoplayer2.p050j.NalUnitUtil;
import com.google.android.exoplayer2.p050j.ParsableByteArray;
import com.google.android.exoplayer2.p050j.Util;
import com.google.android.exoplayer2.p052c.ChunkIndex;
import com.google.android.exoplayer2.p052c.Extractor;
import com.google.android.exoplayer2.p052c.ExtractorInput;
import com.google.android.exoplayer2.p052c.ExtractorOutput;
import com.google.android.exoplayer2.p052c.ExtractorsFactory;
import com.google.android.exoplayer2.p052c.PositionHolder;
import com.google.android.exoplayer2.p052c.SeekMap.SeekMap;
import com.google.android.exoplayer2.p052c.TimestampAdjuster;
import com.google.android.exoplayer2.p052c.TrackOutput;
import com.google.android.exoplayer2.p052c.p056d.Atom.Atom;
import com.google.android.gms.ads.AdRequest;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.UUID;
import net.nend.android.NendAdIconLayout;
import net.nend.android.NendIconError;

/* renamed from: com.google.android.exoplayer2.c.d.e */
public final class FragmentedMp4Extractor implements Extractor {
    public static final ExtractorsFactory f2807a;
    private static final int f2808b;
    private static final byte[] f2809c;
    private final int f2810d;
    private final Track f2811e;
    private final SparseArray<FragmentedMp4Extractor> f2812f;
    private final ParsableByteArray f2813g;
    private final ParsableByteArray f2814h;
    private final ParsableByteArray f2815i;
    private final TimestampAdjuster f2816j;
    private final ParsableByteArray f2817k;
    private final byte[] f2818l;
    private final Stack<Atom> f2819m;
    private int f2820n;
    private int f2821o;
    private long f2822p;
    private int f2823q;
    private ParsableByteArray f2824r;
    private long f2825s;
    private long f2826t;
    private FragmentedMp4Extractor f2827u;
    private int f2828v;
    private int f2829w;
    private int f2830x;
    private ExtractorOutput f2831y;
    private boolean f2832z;

    /* renamed from: com.google.android.exoplayer2.c.d.e.1 */
    static class FragmentedMp4Extractor implements ExtractorsFactory {
        FragmentedMp4Extractor() {
        }

        public Extractor[] m3352a() {
            return new Extractor[]{new FragmentedMp4Extractor()};
        }
    }

    /* renamed from: com.google.android.exoplayer2.c.d.e.a */
    private static final class FragmentedMp4Extractor {
        public final TrackFragment f2800a;
        public final TrackOutput f2801b;
        public Track f2802c;
        public DefaultSampleValues f2803d;
        public int f2804e;
        public int f2805f;
        public int f2806g;

        public FragmentedMp4Extractor(TrackOutput trackOutput) {
            this.f2800a = new TrackFragment();
            this.f2801b = trackOutput;
        }

        public void m3354a(Track track, DefaultSampleValues defaultSampleValues) {
            this.f2802c = (Track) Assertions.m4402a((Object) track);
            this.f2803d = (DefaultSampleValues) Assertions.m4402a((Object) defaultSampleValues);
            this.f2801b.m3426a(track.f2860f);
            m3353a();
        }

        public void m3353a() {
            this.f2800a.m3416a();
            this.f2804e = 0;
            this.f2806g = 0;
            this.f2805f = 0;
        }

        public void m3355a(DrmInitData drmInitData) {
            this.f2801b.m3426a(this.f2802c.f2860f.m2874a(drmInitData));
        }
    }

    static {
        f2807a = new FragmentedMp4Extractor();
        f2808b = Util.m4524e("seig");
        f2809c = new byte[]{(byte) -94, (byte) 57, (byte) 79, (byte) 82, (byte) 90, (byte) -101, (byte) 79, (byte) 20, (byte) -94, (byte) 68, (byte) 108, (byte) 66, (byte) 124, (byte) 100, (byte) -115, (byte) -12};
    }

    public FragmentedMp4Extractor() {
        this(0, null);
    }

    public FragmentedMp4Extractor(int i, TimestampAdjuster timestampAdjuster) {
        this(i, null, timestampAdjuster);
    }

    public FragmentedMp4Extractor(int i, Track track, TimestampAdjuster timestampAdjuster) {
        this.f2811e = track;
        this.f2810d = (track != null ? 4 : 0) | i;
        this.f2816j = timestampAdjuster;
        this.f2817k = new ParsableByteArray(16);
        this.f2813g = new ParsableByteArray(NalUnitUtil.f3823a);
        this.f2814h = new ParsableByteArray(4);
        this.f2815i = new ParsableByteArray(1);
        this.f2818l = new byte[16];
        this.f2819m = new Stack();
        this.f2812f = new SparseArray();
        this.f2826t = -9223372036854775807L;
        m3363a();
    }

    public boolean m3389a(ExtractorInput extractorInput) {
        return Sniffer.m3413a(extractorInput);
    }

    public void m3388a(ExtractorOutput extractorOutput) {
        this.f2831y = extractorOutput;
        if (this.f2811e != null) {
            FragmentedMp4Extractor fragmentedMp4Extractor = new FragmentedMp4Extractor(extractorOutput.m3725a(0));
            fragmentedMp4Extractor.m3354a(this.f2811e, new DefaultSampleValues(0, 0, 0, 0));
            this.f2812f.put(0, fragmentedMp4Extractor);
            this.f2831y.m3726a();
        }
    }

    public void m3387a(long j) {
        int size = this.f2812f.size();
        for (int i = 0; i < size; i++) {
            ((FragmentedMp4Extractor) this.f2812f.valueAt(i)).m3353a();
        }
        this.f2819m.clear();
        m3363a();
    }

    public void m3390c() {
    }

    public int m3386a(ExtractorInput extractorInput, PositionHolder positionHolder) {
        while (true) {
            switch (this.f2820n) {
                case NendAdIconLayout.HORIZONTAL /*0*/:
                    if (m3380b(extractorInput)) {
                        break;
                    }
                    return -1;
                case NendIconError.ERROR_ICONVIEW /*1*/:
                    m3383c(extractorInput);
                    break;
                case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                    m3384d(extractorInput);
                    break;
                default:
                    if (!m3385e(extractorInput)) {
                        break;
                    }
                    return 0;
            }
        }
    }

    private void m3363a() {
        this.f2820n = 0;
        this.f2823q = 0;
    }

    private boolean m3380b(ExtractorInput extractorInput) {
        if (this.f2823q == 0) {
            if (!extractorInput.m3233a(this.f2817k.f3831a, 0, 8, true)) {
                return false;
            }
            this.f2823q = 8;
            this.f2817k.m4455c(0);
            this.f2822p = this.f2817k.m4466l();
            this.f2821o = this.f2817k.m4468n();
        }
        if (this.f2822p == 1) {
            extractorInput.m3236b(this.f2817k.f3831a, 8, 8);
            this.f2823q += 8;
            this.f2822p = this.f2817k.m4476v();
        }
        long c = extractorInput.m3238c() - ((long) this.f2823q);
        if (this.f2821o == Atom.f2717J) {
            int size = this.f2812f.size();
            for (int i = 0; i < size; i++) {
                TrackFragment trackFragment = ((FragmentedMp4Extractor) this.f2812f.valueAt(i)).f2800a;
                trackFragment.f2870b = c;
                trackFragment.f2872d = c;
                trackFragment.f2871c = c;
            }
        }
        if (this.f2821o == Atom.f2741h) {
            this.f2827u = null;
            this.f2825s = this.f2822p + c;
            if (!this.f2832z) {
                this.f2831y.m3727a(new SeekMap(this.f2826t));
                this.f2832z = true;
            }
            this.f2820n = 2;
            return true;
        }
        if (FragmentedMp4Extractor.m3379b(this.f2821o)) {
            long c2 = (extractorInput.m3238c() + this.f2822p) - 8;
            this.f2819m.add(new Atom(this.f2821o, c2));
            if (this.f2822p == ((long) this.f2823q)) {
                m3375b(c2);
            } else {
                m3363a();
            }
        } else if (FragmentedMp4Extractor.m3373a(this.f2821o)) {
            if (this.f2823q != 8) {
                throw new ParserException("Leaf atom defines extended atom size (unsupported).");
            } else if (this.f2822p > 2147483647L) {
                throw new ParserException("Leaf atom with length > 2147483647 (unsupported).");
            } else {
                this.f2824r = new ParsableByteArray((int) this.f2822p);
                System.arraycopy(this.f2817k.f3831a, 0, this.f2824r.f3831a, 0, 8);
                this.f2820n = 1;
            }
        } else if (this.f2822p > 2147483647L) {
            throw new ParserException("Skipping atom with length > 2147483647 (unsupported).");
        } else {
            this.f2824r = null;
            this.f2820n = 1;
        }
        return true;
    }

    private void m3383c(ExtractorInput extractorInput) {
        int i = ((int) this.f2822p) - this.f2823q;
        if (this.f2824r != null) {
            extractorInput.m3236b(this.f2824r.f3831a, 8, i);
            m3367a(new Atom(this.f2821o, this.f2824r), extractorInput.m3238c());
        } else {
            extractorInput.m3235b(i);
        }
        m3375b(extractorInput.m3238c());
    }

    private void m3375b(long j) {
        while (!this.f2819m.isEmpty() && ((Atom) this.f2819m.peek()).aN == j) {
            m3364a((Atom) this.f2819m.pop());
        }
        m3363a();
    }

    private void m3367a(Atom atom, long j) {
        if (!this.f2819m.isEmpty()) {
            ((Atom) this.f2819m.peek()).m3314a(atom);
        } else if (atom.aM == Atom.f2759z) {
            this.f2831y.m3727a(FragmentedMp4Extractor.m3359a(atom.aN, j));
            this.f2832z = true;
        }
    }

    private void m3364a(Atom atom) {
        if (atom.aM == Atom.f2708A) {
            m3376b(atom);
        } else if (atom.aM == Atom.f2717J) {
            m3382c(atom);
        } else if (!this.f2819m.isEmpty()) {
            ((Atom) this.f2819m.peek()).m3313a(atom);
        }
    }

    private void m3376b(Atom atom) {
        int i;
        Track a;
        boolean z = true;
        int i2 = 0;
        Assertions.m4407b(this.f2811e == null, "Unexpected moov box.");
        DrmInitData a2 = FragmentedMp4Extractor.m3362a(atom.aO);
        Atom e = atom.m3316e(Atom.f2719L);
        SparseArray sparseArray = new SparseArray();
        long j = -9223372036854775807L;
        int size = e.aO.size();
        for (i = 0; i < size; i++) {
            Atom atom2 = (Atom) e.aO.get(i);
            if (atom2.aM == Atom.f2757x) {
                Pair a3 = FragmentedMp4Extractor.m3358a(atom2.aN);
                sparseArray.put(((Integer) a3.first).intValue(), a3.second);
            } else if (atom2.aM == Atom.f2720M) {
                j = FragmentedMp4Extractor.m3374b(atom2.aN);
            }
        }
        SparseArray sparseArray2 = new SparseArray();
        int size2 = atom.aP.size();
        for (int i3 = 0; i3 < size2; i3++) {
            Atom atom3 = (Atom) atom.aP.get(i3);
            if (atom3.aM == Atom.f2710C) {
                a = AtomParsers.m3336a(atom3, atom.m3315d(Atom.f2709B), j, a2, false);
                if (a != null) {
                    sparseArray2.put(a.f2855a, a);
                }
            }
        }
        int size3 = sparseArray2.size();
        if (this.f2812f.size() == 0) {
            for (i = 0; i < size3; i++) {
                a = (Track) sparseArray2.valueAt(i);
                this.f2812f.put(a.f2855a, new FragmentedMp4Extractor(this.f2831y.m3725a(i)));
                this.f2826t = Math.max(this.f2826t, a.f2859e);
            }
            this.f2831y.m3726a();
        } else {
            if (this.f2812f.size() != size3) {
                z = false;
            }
            Assertions.m4406b(z);
        }
        while (i2 < size3) {
            a = (Track) sparseArray2.valueAt(i2);
            ((FragmentedMp4Extractor) this.f2812f.get(a.f2855a)).m3354a(a, (DefaultSampleValues) sparseArray.get(a.f2855a));
            i2++;
        }
    }

    private void m3382c(Atom atom) {
        FragmentedMp4Extractor.m3365a(atom, this.f2812f, this.f2810d, this.f2818l);
        DrmInitData a = FragmentedMp4Extractor.m3362a(atom.aO);
        if (a != null) {
            int size = this.f2812f.size();
            for (int i = 0; i < size; i++) {
                ((FragmentedMp4Extractor) this.f2812f.valueAt(i)).m3355a(a);
            }
        }
    }

    private static Pair<Integer, DefaultSampleValues> m3358a(ParsableByteArray parsableByteArray) {
        parsableByteArray.m4455c(12);
        return Pair.create(Integer.valueOf(parsableByteArray.m4468n()), new DefaultSampleValues(parsableByteArray.m4474t() - 1, parsableByteArray.m4474t(), parsableByteArray.m4474t(), parsableByteArray.m4468n()));
    }

    private static long m3374b(ParsableByteArray parsableByteArray) {
        parsableByteArray.m4455c(8);
        return Atom.m3310a(parsableByteArray.m4468n()) == 0 ? parsableByteArray.m4466l() : parsableByteArray.m4476v();
    }

    private static void m3365a(Atom atom, SparseArray<FragmentedMp4Extractor> sparseArray, int i, byte[] bArr) {
        int size = atom.aP.size();
        for (int i2 = 0; i2 < size; i2++) {
            Atom atom2 = (Atom) atom.aP.get(i2);
            if (atom2.aM == Atom.f2718K) {
                FragmentedMp4Extractor.m3377b(atom2, sparseArray, i, bArr);
            }
        }
    }

    private static void m3377b(Atom atom, SparseArray<FragmentedMp4Extractor> sparseArray, int i, byte[] bArr) {
        FragmentedMp4Extractor a = FragmentedMp4Extractor.m3361a(atom.m3315d(Atom.f2756w).aN, (SparseArray) sparseArray, i);
        if (a != null) {
            TrackFragment trackFragment = a.f2800a;
            long j = trackFragment.f2887s;
            a.m3353a();
            if (atom.m3315d(Atom.f2755v) != null && (i & 2) == 0) {
                j = FragmentedMp4Extractor.m3381c(atom.m3315d(Atom.f2755v).aN);
            }
            FragmentedMp4Extractor.m3366a(atom, a, j, i);
            Atom d = atom.m3315d(Atom.ab);
            if (d != null) {
                FragmentedMp4Extractor.m3368a(a.f2802c.f2862h[trackFragment.f2869a.f2791a], d.aN, trackFragment);
            }
            d = atom.m3315d(Atom.ac);
            if (d != null) {
                FragmentedMp4Extractor.m3370a(d.aN, trackFragment);
            }
            d = atom.m3315d(Atom.ag);
            if (d != null) {
                FragmentedMp4Extractor.m3378b(d.aN, trackFragment);
            }
            d = atom.m3315d(Atom.ad);
            Atom d2 = atom.m3315d(Atom.ae);
            if (!(d == null || d2 == null)) {
                FragmentedMp4Extractor.m3372a(d.aN, d2.aN, trackFragment);
            }
            int size = atom.aO.size();
            for (int i2 = 0; i2 < size; i2++) {
                d = (Atom) atom.aO.get(i2);
                if (d.aM == Atom.af) {
                    FragmentedMp4Extractor.m3371a(d.aN, trackFragment, bArr);
                }
            }
        }
    }

    private static void m3366a(Atom atom, FragmentedMp4Extractor fragmentedMp4Extractor, long j, int i) {
        List list = atom.aO;
        int size = list.size();
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i2 < size) {
            int t;
            Atom atom2 = (Atom) list.get(i2);
            if (atom2.aM == Atom.f2758y) {
                ParsableByteArray parsableByteArray = atom2.aN;
                parsableByteArray.m4455c(12);
                t = parsableByteArray.m4474t();
                if (t > 0) {
                    t += i3;
                    i3 = i4 + 1;
                    i2++;
                    i4 = i3;
                    i3 = t;
                }
            }
            t = i3;
            i3 = i4;
            i2++;
            i4 = i3;
            i3 = t;
        }
        fragmentedMp4Extractor.f2806g = 0;
        fragmentedMp4Extractor.f2805f = 0;
        fragmentedMp4Extractor.f2804e = 0;
        fragmentedMp4Extractor.f2800a.m3418a(i4, i3);
        int i5 = 0;
        i3 = 0;
        for (int i6 = 0; i6 < size; i6++) {
            atom2 = (Atom) list.get(i6);
            if (atom2.aM == Atom.f2758y) {
                int i7 = i3 + 1;
                i5 = FragmentedMp4Extractor.m3357a(fragmentedMp4Extractor, i3, j, i, atom2.aN, i5);
                i3 = i7;
            }
        }
    }

    private static void m3368a(TrackEncryptionBox trackEncryptionBox, ParsableByteArray parsableByteArray, TrackFragment trackFragment) {
        boolean z = true;
        int i = trackEncryptionBox.f2867b;
        parsableByteArray.m4455c(8);
        if ((Atom.m3311b(parsableByteArray.m4468n()) & 1) == 1) {
            parsableByteArray.m4457d(8);
        }
        int g = parsableByteArray.m4461g();
        int t = parsableByteArray.m4474t();
        if (t != trackFragment.f2874f) {
            throw new ParserException("Length mismatch: " + t + ", " + trackFragment.f2874f);
        }
        if (g == 0) {
            boolean[] zArr = trackFragment.f2882n;
            int i2 = 0;
            g = 0;
            while (i2 < t) {
                boolean z2;
                int g2 = parsableByteArray.m4461g();
                int i3 = g + g2;
                if (g2 > i) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                zArr[i2] = z2;
                i2++;
                g = i3;
            }
        } else {
            if (g <= i) {
                z = false;
            }
            g = (g * t) + 0;
            Arrays.fill(trackFragment.f2882n, 0, t, z);
        }
        trackFragment.m3417a(g);
    }

    private static void m3370a(ParsableByteArray parsableByteArray, TrackFragment trackFragment) {
        parsableByteArray.m4455c(8);
        int n = parsableByteArray.m4468n();
        if ((Atom.m3311b(n) & 1) == 1) {
            parsableByteArray.m4457d(8);
        }
        int t = parsableByteArray.m4474t();
        if (t != 1) {
            throw new ParserException("Unexpected saio entry count: " + t);
        }
        n = Atom.m3310a(n);
        trackFragment.f2872d = (n == 0 ? parsableByteArray.m4466l() : parsableByteArray.m4476v()) + trackFragment.f2872d;
    }

    private static FragmentedMp4Extractor m3361a(ParsableByteArray parsableByteArray, SparseArray<FragmentedMp4Extractor> sparseArray, int i) {
        parsableByteArray.m4455c(8);
        int b = Atom.m3311b(parsableByteArray.m4468n());
        int n = parsableByteArray.m4468n();
        if ((i & 4) != 0) {
            n = 0;
        }
        FragmentedMp4Extractor fragmentedMp4Extractor = (FragmentedMp4Extractor) sparseArray.get(n);
        if (fragmentedMp4Extractor == null) {
            return null;
        }
        if ((b & 1) != 0) {
            long v = parsableByteArray.m4476v();
            fragmentedMp4Extractor.f2800a.f2871c = v;
            fragmentedMp4Extractor.f2800a.f2872d = v;
        }
        DefaultSampleValues defaultSampleValues = fragmentedMp4Extractor.f2803d;
        fragmentedMp4Extractor.f2800a.f2869a = new DefaultSampleValues((b & 2) != 0 ? parsableByteArray.m4474t() - 1 : defaultSampleValues.f2791a, (b & 8) != 0 ? parsableByteArray.m4474t() : defaultSampleValues.f2792b, (b & 16) != 0 ? parsableByteArray.m4474t() : defaultSampleValues.f2793c, (b & 32) != 0 ? parsableByteArray.m4474t() : defaultSampleValues.f2794d);
        return fragmentedMp4Extractor;
    }

    private static long m3381c(ParsableByteArray parsableByteArray) {
        parsableByteArray.m4455c(8);
        return Atom.m3310a(parsableByteArray.m4468n()) == 1 ? parsableByteArray.m4476v() : parsableByteArray.m4466l();
    }

    private static int m3357a(FragmentedMp4Extractor fragmentedMp4Extractor, int i, long j, int i2, ParsableByteArray parsableByteArray, int i3) {
        Object obj;
        long a;
        parsableByteArray.m4455c(8);
        int b = Atom.m3311b(parsableByteArray.m4468n());
        Track track = fragmentedMp4Extractor.f2802c;
        TrackFragment trackFragment = fragmentedMp4Extractor.f2800a;
        DefaultSampleValues defaultSampleValues = trackFragment.f2869a;
        trackFragment.f2876h[i] = parsableByteArray.m4474t();
        trackFragment.f2875g[i] = trackFragment.f2871c;
        if ((b & 1) != 0) {
            long[] jArr = trackFragment.f2875g;
            jArr[i] = jArr[i] + ((long) parsableByteArray.m4468n());
        }
        Object obj2 = (b & 4) != 0 ? 1 : null;
        int i4 = defaultSampleValues.f2794d;
        if (obj2 != null) {
            i4 = parsableByteArray.m4474t();
        }
        Object obj3 = (b & AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY) != 0 ? 1 : null;
        Object obj4 = (b & AdRequest.MAX_CONTENT_URL_LENGTH) != 0 ? 1 : null;
        Object obj5 = (b & AccessibilityNodeInfoCompat.ACTION_NEXT_HTML_ELEMENT) != 0 ? 1 : null;
        if ((b & ItemAnimator.FLAG_MOVED) != 0) {
            obj = 1;
        } else {
            obj = null;
        }
        if (track.f2863i != null && track.f2863i.length == 1 && track.f2863i[0] == 0) {
            a = Util.m4510a(track.f2864j[0], 1000, track.f2857c);
        } else {
            a = 0;
        }
        int[] iArr = trackFragment.f2877i;
        int[] iArr2 = trackFragment.f2878j;
        long[] jArr2 = trackFragment.f2879k;
        boolean[] zArr = trackFragment.f2880l;
        Object obj6 = (track.f2856b != 2 || (i2 & 1) == 0) ? null : 1;
        int i5 = i3 + trackFragment.f2876h[i];
        long j2 = track.f2857c;
        if (i > 0) {
            j = trackFragment.f2887s;
        }
        long j3 = j;
        while (i3 < i5) {
            int t = obj3 != null ? parsableByteArray.m4474t() : defaultSampleValues.f2792b;
            int t2 = obj4 != null ? parsableByteArray.m4474t() : defaultSampleValues.f2793c;
            int n = (i3 != 0 || obj2 == null) ? obj5 != null ? parsableByteArray.m4468n() : defaultSampleValues.f2794d : i4;
            if (obj != null) {
                iArr2[i3] = (int) (((long) (parsableByteArray.m4468n() * PointerIconCompat.TYPE_DEFAULT)) / j2);
            } else {
                iArr2[i3] = 0;
            }
            jArr2[i3] = Util.m4510a(j3, 1000, j2) - a;
            iArr[i3] = t2;
            boolean z = ((n >> 16) & 1) == 0 && (obj6 == null || i3 == 0);
            zArr[i3] = z;
            j3 += (long) t;
            i3++;
        }
        trackFragment.f2887s = j3;
        return i5;
    }

    private static void m3371a(ParsableByteArray parsableByteArray, TrackFragment trackFragment, byte[] bArr) {
        parsableByteArray.m4455c(8);
        parsableByteArray.m4451a(bArr, 0, 16);
        if (Arrays.equals(bArr, f2809c)) {
            FragmentedMp4Extractor.m3369a(parsableByteArray, 16, trackFragment);
        }
    }

    private static void m3378b(ParsableByteArray parsableByteArray, TrackFragment trackFragment) {
        FragmentedMp4Extractor.m3369a(parsableByteArray, 0, trackFragment);
    }

    private static void m3369a(ParsableByteArray parsableByteArray, int i, TrackFragment trackFragment) {
        parsableByteArray.m4455c(i + 8);
        int b = Atom.m3311b(parsableByteArray.m4468n());
        if ((b & 1) != 0) {
            throw new ParserException("Overriding TrackEncryptionBox parameters is unsupported.");
        }
        boolean z;
        if ((b & 2) != 0) {
            z = true;
        } else {
            z = false;
        }
        int t = parsableByteArray.m4474t();
        if (t != trackFragment.f2874f) {
            throw new ParserException("Length mismatch: " + t + ", " + trackFragment.f2874f);
        }
        Arrays.fill(trackFragment.f2882n, 0, t, z);
        trackFragment.m3417a(parsableByteArray.m4452b());
        trackFragment.m3420a(parsableByteArray);
    }

    private static void m3372a(ParsableByteArray parsableByteArray, ParsableByteArray parsableByteArray2, TrackFragment trackFragment) {
        parsableByteArray.m4455c(8);
        int n = parsableByteArray.m4468n();
        if (parsableByteArray.m4468n() == f2808b) {
            if (Atom.m3310a(n) == 1) {
                parsableByteArray.m4457d(4);
            }
            if (parsableByteArray.m4468n() != 1) {
                throw new ParserException("Entry count in sbgp != 1 (unsupported).");
            }
            parsableByteArray2.m4455c(8);
            n = parsableByteArray2.m4468n();
            if (parsableByteArray2.m4468n() == f2808b) {
                n = Atom.m3310a(n);
                if (n == 1) {
                    if (parsableByteArray2.m4466l() == 0) {
                        throw new ParserException("Variable length decription in sgpd found (unsupported)");
                    }
                } else if (n >= 2) {
                    parsableByteArray2.m4457d(4);
                }
                if (parsableByteArray2.m4466l() != 1) {
                    throw new ParserException("Entry count in sgpd != 1 (unsupported).");
                }
                parsableByteArray2.m4457d(2);
                boolean z = parsableByteArray2.m4461g() == 1;
                if (z) {
                    int g = parsableByteArray2.m4461g();
                    byte[] bArr = new byte[16];
                    parsableByteArray2.m4451a(bArr, 0, bArr.length);
                    trackFragment.f2881m = true;
                    trackFragment.f2883o = new TrackEncryptionBox(z, g, bArr);
                }
            }
        }
    }

    private static ChunkIndex m3359a(ParsableByteArray parsableByteArray, long j) {
        long l;
        long l2;
        parsableByteArray.m4455c(8);
        int a = Atom.m3310a(parsableByteArray.m4468n());
        parsableByteArray.m4457d(4);
        long l3 = parsableByteArray.m4466l();
        if (a == 0) {
            l = parsableByteArray.m4466l() + j;
            l2 = parsableByteArray.m4466l();
        } else {
            l = parsableByteArray.m4476v() + j;
            l2 = parsableByteArray.m4476v();
        }
        parsableByteArray.m4457d(2);
        int h = parsableByteArray.m4462h();
        int[] iArr = new int[h];
        long[] jArr = new long[h];
        long[] jArr2 = new long[h];
        long[] jArr3 = new long[h];
        long j2 = l;
        int i = 0;
        long j3 = l2;
        l2 = Util.m4510a(l2, 1000000, l3);
        while (i < h) {
            int n = parsableByteArray.m4468n();
            if ((RtlSpacingHelper.UNDEFINED & n) != 0) {
                throw new ParserException("Unhandled indirect reference");
            }
            long l4 = parsableByteArray.m4466l();
            iArr[i] = n & ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            jArr[i] = j2;
            jArr3[i] = l2;
            l2 = j3 + l4;
            l4 = Util.m4510a(l2, 1000000, l3);
            jArr2[i] = l4 - jArr3[i];
            parsableByteArray.m4457d(4);
            j2 += (long) iArr[i];
            i++;
            j3 = l2;
            l2 = l4;
        }
        return new ChunkIndex(iArr, jArr, jArr2, jArr3);
    }

    private void m3384d(ExtractorInput extractorInput) {
        FragmentedMp4Extractor fragmentedMp4Extractor = null;
        long j = Long.MAX_VALUE;
        int size = this.f2812f.size();
        int i = 0;
        while (i < size) {
            FragmentedMp4Extractor fragmentedMp4Extractor2;
            long j2;
            TrackFragment trackFragment = ((FragmentedMp4Extractor) this.f2812f.valueAt(i)).f2800a;
            long j3;
            if (!trackFragment.f2886r || trackFragment.f2872d >= j) {
                j3 = j;
                fragmentedMp4Extractor2 = fragmentedMp4Extractor;
                j2 = j3;
            } else {
                j3 = trackFragment.f2872d;
                fragmentedMp4Extractor2 = (FragmentedMp4Extractor) this.f2812f.valueAt(i);
                j2 = j3;
            }
            i++;
            fragmentedMp4Extractor = fragmentedMp4Extractor2;
            j = j2;
        }
        if (fragmentedMp4Extractor == null) {
            this.f2820n = 3;
            return;
        }
        int c = (int) (j - extractorInput.m3238c());
        if (c < 0) {
            throw new ParserException("Offset to encryption data was negative.");
        }
        extractorInput.m3235b(c);
        fragmentedMp4Extractor.f2800a.m3419a(extractorInput);
    }

    private boolean m3385e(ExtractorInput extractorInput) {
        int c;
        long j;
        int i;
        byte[] bArr;
        if (this.f2820n == 3) {
            if (this.f2827u == null) {
                FragmentedMp4Extractor a = FragmentedMp4Extractor.m3360a(this.f2812f);
                if (a == null) {
                    c = (int) (this.f2825s - extractorInput.m3238c());
                    if (c < 0) {
                        throw new ParserException("Offset to end of mdat was negative.");
                    }
                    extractorInput.m3235b(c);
                    m3363a();
                    return false;
                }
                j = a.f2800a.f2875g[a.f2806g];
                c = (int) (j - extractorInput.m3238c());
                if (c < 0) {
                    if (j == a.f2800a.f2870b) {
                        Log.w("FragmentedMp4Extractor", "Offset to sample data was missing.");
                        c = 0;
                    } else {
                        throw new ParserException("Offset to sample data was negative.");
                    }
                }
                extractorInput.m3235b(c);
                this.f2827u = a;
            }
            this.f2828v = this.f2827u.f2800a.f2877i[this.f2827u.f2804e];
            if (this.f2827u.f2800a.f2881m) {
                this.f2829w = m3356a(this.f2827u);
                this.f2828v += this.f2829w;
            } else {
                this.f2829w = 0;
            }
            if (this.f2827u.f2802c.f2861g == 1) {
                this.f2828v -= 8;
                extractorInput.m3235b(8);
            }
            this.f2820n = 4;
            this.f2830x = 0;
        }
        TrackFragment trackFragment = this.f2827u.f2800a;
        Track track = this.f2827u.f2802c;
        TrackOutput trackOutput = this.f2827u.f2801b;
        int i2 = this.f2827u.f2804e;
        if (track.f2865k != 0) {
            byte[] bArr2 = this.f2814h.f3831a;
            bArr2[0] = (byte) 0;
            bArr2[1] = (byte) 0;
            bArr2[2] = (byte) 0;
            c = track.f2865k;
            i = 4 - track.f2865k;
            while (this.f2829w < this.f2828v) {
                if (this.f2830x == 0) {
                    extractorInput.m3236b(this.f2814h.f3831a, i, c);
                    this.f2814h.m4455c(0);
                    this.f2830x = this.f2814h.m4474t();
                    this.f2813g.m4455c(0);
                    trackOutput.m3427a(this.f2813g, 4);
                    this.f2829w += 4;
                    this.f2828v += i;
                } else {
                    int a2 = trackOutput.m3424a(extractorInput, this.f2830x, false);
                    this.f2829w += a2;
                    this.f2830x -= a2;
                }
            }
        } else {
            while (this.f2829w < this.f2828v) {
                this.f2829w = trackOutput.m3424a(extractorInput, this.f2828v - this.f2829w, false) + this.f2829w;
            }
        }
        long b = 1000 * trackFragment.m3421b(i2);
        i = (trackFragment.f2881m ? 1073741824 : 0) | (trackFragment.f2880l[i2] ? 1 : 0);
        c = trackFragment.f2869a.f2791a;
        if (trackFragment.f2881m) {
            bArr = trackFragment.f2883o != null ? trackFragment.f2883o.f2868c : track.f2862h[c].f2868c;
        } else {
            bArr = null;
        }
        if (this.f2816j != null) {
            j = this.f2816j.m3741b(b);
        } else {
            j = b;
        }
        trackOutput.m3425a(j, i, this.f2828v, 0, bArr);
        FragmentedMp4Extractor fragmentedMp4Extractor = this.f2827u;
        fragmentedMp4Extractor.f2804e++;
        fragmentedMp4Extractor = this.f2827u;
        fragmentedMp4Extractor.f2805f++;
        if (this.f2827u.f2805f == trackFragment.f2876h[this.f2827u.f2806g]) {
            fragmentedMp4Extractor = this.f2827u;
            fragmentedMp4Extractor.f2806g++;
            this.f2827u.f2805f = 0;
            this.f2827u = null;
        }
        this.f2820n = 3;
        return true;
    }

    private static FragmentedMp4Extractor m3360a(SparseArray<FragmentedMp4Extractor> sparseArray) {
        FragmentedMp4Extractor fragmentedMp4Extractor = null;
        long j = Long.MAX_VALUE;
        int size = sparseArray.size();
        int i = 0;
        while (i < size) {
            FragmentedMp4Extractor fragmentedMp4Extractor2;
            long j2;
            FragmentedMp4Extractor fragmentedMp4Extractor3 = (FragmentedMp4Extractor) sparseArray.valueAt(i);
            long j3;
            if (fragmentedMp4Extractor3.f2806g == fragmentedMp4Extractor3.f2800a.f2873e) {
                j3 = j;
                fragmentedMp4Extractor2 = fragmentedMp4Extractor;
                j2 = j3;
            } else {
                long j4 = fragmentedMp4Extractor3.f2800a.f2875g[fragmentedMp4Extractor3.f2806g];
                if (j4 < j) {
                    fragmentedMp4Extractor2 = fragmentedMp4Extractor3;
                    j2 = j4;
                } else {
                    j3 = j;
                    fragmentedMp4Extractor2 = fragmentedMp4Extractor;
                    j2 = j3;
                }
            }
            i++;
            fragmentedMp4Extractor = fragmentedMp4Extractor2;
            j = j2;
        }
        return fragmentedMp4Extractor;
    }

    private int m3356a(FragmentedMp4Extractor fragmentedMp4Extractor) {
        int i;
        TrackFragment trackFragment = fragmentedMp4Extractor.f2800a;
        ParsableByteArray parsableByteArray = trackFragment.f2885q;
        int i2 = (trackFragment.f2883o != null ? trackFragment.f2883o : fragmentedMp4Extractor.f2802c.f2862h[trackFragment.f2869a.f2791a]).f2867b;
        boolean z = trackFragment.f2882n[fragmentedMp4Extractor.f2804e];
        byte[] bArr = this.f2815i.f3831a;
        if (z) {
            i = AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS;
        } else {
            i = 0;
        }
        bArr[0] = (byte) (i | i2);
        this.f2815i.m4455c(0);
        TrackOutput trackOutput = fragmentedMp4Extractor.f2801b;
        trackOutput.m3427a(this.f2815i, 1);
        trackOutput.m3427a(parsableByteArray, i2);
        if (!z) {
            return i2 + 1;
        }
        int h = parsableByteArray.m4462h();
        parsableByteArray.m4457d(-2);
        h = (h * 6) + 2;
        trackOutput.m3427a(parsableByteArray, h);
        return (i2 + 1) + h;
    }

    private static DrmInitData m3362a(List<Atom> list) {
        int size = list.size();
        List list2 = null;
        for (int i = 0; i < size; i++) {
            Atom atom = (Atom) list.get(i);
            if (atom.aM == Atom.f2727T) {
                if (list2 == null) {
                    list2 = new ArrayList();
                }
                byte[] bArr = atom.aN.f3831a;
                UUID a = PsshAtomUtil.m3410a(bArr);
                if (a == null) {
                    Log.w("FragmentedMp4Extractor", "Skipped pssh atom (failed to extract uuid)");
                } else {
                    list2.add(new SchemeData(a, "video/mp4", bArr));
                }
            }
        }
        return list2 == null ? null : new DrmInitData(list2);
    }

    private static boolean m3373a(int i) {
        return i == Atom.f2725R || i == Atom.f2724Q || i == Atom.f2709B || i == Atom.f2759z || i == Atom.f2726S || i == Atom.f2755v || i == Atom.f2756w || i == Atom.f2721N || i == Atom.f2757x || i == Atom.f2758y || i == Atom.f2727T || i == Atom.ab || i == Atom.ac || i == Atom.ag || i == Atom.af || i == Atom.ad || i == Atom.ae || i == Atom.f2723P || i == Atom.f2720M;
    }

    private static boolean m3379b(int i) {
        return i == Atom.f2708A || i == Atom.f2710C || i == Atom.f2711D || i == Atom.f2712E || i == Atom.f2713F || i == Atom.f2717J || i == Atom.f2718K || i == Atom.f2719L || i == Atom.f2722O;
    }
}
