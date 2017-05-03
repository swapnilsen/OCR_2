package com.google.android.exoplayer2.p052c.p056d;

import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewCompat;
import com.google.android.exoplayer2.p050j.ParsableByteArray;
import com.google.android.exoplayer2.p050j.Util;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* renamed from: com.google.android.exoplayer2.c.d.a */
abstract class Atom {
    public static final int f2708A;
    public static final int f2709B;
    public static final int f2710C;
    public static final int f2711D;
    public static final int f2712E;
    public static final int f2713F;
    public static final int f2714G;
    public static final int f2715H;
    public static final int f2716I;
    public static final int f2717J;
    public static final int f2718K;
    public static final int f2719L;
    public static final int f2720M;
    public static final int f2721N;
    public static final int f2722O;
    public static final int f2723P;
    public static final int f2724Q;
    public static final int f2725R;
    public static final int f2726S;
    public static final int f2727T;
    public static final int f2728U;
    public static final int f2729V;
    public static final int f2730W;
    public static final int f2731X;
    public static final int f2732Y;
    public static final int f2733Z;
    public static final int f2734a;
    public static final int aA;
    public static final int aB;
    public static final int aC;
    public static final int aD;
    public static final int aE;
    public static final int aF;
    public static final int aG;
    public static final int aH;
    public static final int aI;
    public static final int aJ;
    public static final int aK;
    public static final int aL;
    public static final int aa;
    public static final int ab;
    public static final int ac;
    public static final int ad;
    public static final int ae;
    public static final int af;
    public static final int ag;
    public static final int ah;
    public static final int ai;
    public static final int aj;
    public static final int ak;
    public static final int al;
    public static final int am;
    public static final int an;
    public static final int ao;
    public static final int ap;
    public static final int aq;
    public static final int ar;
    public static final int as;
    public static final int at;
    public static final int au;
    public static final int av;
    public static final int aw;
    public static final int ax;
    public static final int ay;
    public static final int az;
    public static final int f2735b;
    public static final int f2736c;
    public static final int f2737d;
    public static final int f2738e;
    public static final int f2739f;
    public static final int f2740g;
    public static final int f2741h;
    public static final int f2742i;
    public static final int f2743j;
    public static final int f2744k;
    public static final int f2745l;
    public static final int f2746m;
    public static final int f2747n;
    public static final int f2748o;
    public static final int f2749p;
    public static final int f2750q;
    public static final int f2751r;
    public static final int f2752s;
    public static final int f2753t;
    public static final int f2754u;
    public static final int f2755v;
    public static final int f2756w;
    public static final int f2757x;
    public static final int f2758y;
    public static final int f2759z;
    public final int aM;

    /* renamed from: com.google.android.exoplayer2.c.d.a.a */
    static final class Atom extends Atom {
        public final long aN;
        public final List<Atom> aO;
        public final List<Atom> aP;

        public Atom(int i, long j) {
            super(i);
            this.aN = j;
            this.aO = new ArrayList();
            this.aP = new ArrayList();
        }

        public void m3314a(Atom atom) {
            this.aO.add(atom);
        }

        public void m3313a(Atom atom) {
            this.aP.add(atom);
        }

        public Atom m3315d(int i) {
            int size = this.aO.size();
            for (int i2 = 0; i2 < size; i2++) {
                Atom atom = (Atom) this.aO.get(i2);
                if (atom.aM == i) {
                    return atom;
                }
            }
            return null;
        }

        public Atom m3316e(int i) {
            int size = this.aP.size();
            for (int i2 = 0; i2 < size; i2++) {
                Atom atom = (Atom) this.aP.get(i2);
                if (atom.aM == i) {
                    return atom;
                }
            }
            return null;
        }

        public String toString() {
            return Atom.m3312c(this.aM) + " leaves: " + Arrays.toString(this.aO.toArray()) + " containers: " + Arrays.toString(this.aP.toArray());
        }
    }

    /* renamed from: com.google.android.exoplayer2.c.d.a.b */
    static final class Atom extends Atom {
        public final ParsableByteArray aN;

        public Atom(int i, ParsableByteArray parsableByteArray) {
            super(i);
            this.aN = parsableByteArray;
        }
    }

    static {
        f2734a = Util.m4524e("ftyp");
        f2735b = Util.m4524e("avc1");
        f2736c = Util.m4524e("avc3");
        f2737d = Util.m4524e("hvc1");
        f2738e = Util.m4524e("hev1");
        f2739f = Util.m4524e("s263");
        f2740g = Util.m4524e("d263");
        f2741h = Util.m4524e("mdat");
        f2742i = Util.m4524e("mp4a");
        f2743j = Util.m4524e("wave");
        f2744k = Util.m4524e("lpcm");
        f2745l = Util.m4524e("sowt");
        f2746m = Util.m4524e("ac-3");
        f2747n = Util.m4524e("dac3");
        f2748o = Util.m4524e("ec-3");
        f2749p = Util.m4524e("dec3");
        f2750q = Util.m4524e("dtsc");
        f2751r = Util.m4524e("dtsh");
        f2752s = Util.m4524e("dtsl");
        f2753t = Util.m4524e("dtse");
        f2754u = Util.m4524e("ddts");
        f2755v = Util.m4524e("tfdt");
        f2756w = Util.m4524e("tfhd");
        f2757x = Util.m4524e("trex");
        f2758y = Util.m4524e("trun");
        f2759z = Util.m4524e("sidx");
        f2708A = Util.m4524e("moov");
        f2709B = Util.m4524e("mvhd");
        f2710C = Util.m4524e("trak");
        f2711D = Util.m4524e("mdia");
        f2712E = Util.m4524e("minf");
        f2713F = Util.m4524e("stbl");
        f2714G = Util.m4524e("avcC");
        f2715H = Util.m4524e("hvcC");
        f2716I = Util.m4524e("esds");
        f2717J = Util.m4524e("moof");
        f2718K = Util.m4524e("traf");
        f2719L = Util.m4524e("mvex");
        f2720M = Util.m4524e("mehd");
        f2721N = Util.m4524e("tkhd");
        f2722O = Util.m4524e("edts");
        f2723P = Util.m4524e("elst");
        f2724Q = Util.m4524e("mdhd");
        f2725R = Util.m4524e("hdlr");
        f2726S = Util.m4524e("stsd");
        f2727T = Util.m4524e("pssh");
        f2728U = Util.m4524e("sinf");
        f2729V = Util.m4524e("schm");
        f2730W = Util.m4524e("schi");
        f2731X = Util.m4524e("tenc");
        f2732Y = Util.m4524e("encv");
        f2733Z = Util.m4524e("enca");
        aa = Util.m4524e("frma");
        ab = Util.m4524e("saiz");
        ac = Util.m4524e("saio");
        ad = Util.m4524e("sbgp");
        ae = Util.m4524e("sgpd");
        af = Util.m4524e("uuid");
        ag = Util.m4524e("senc");
        ah = Util.m4524e("pasp");
        ai = Util.m4524e("TTML");
        aj = Util.m4524e("vmhd");
        ak = Util.m4524e("mp4v");
        al = Util.m4524e("stts");
        am = Util.m4524e("stss");
        an = Util.m4524e("ctts");
        ao = Util.m4524e("stsc");
        ap = Util.m4524e("stsz");
        aq = Util.m4524e("stz2");
        ar = Util.m4524e("stco");
        as = Util.m4524e("co64");
        at = Util.m4524e("tx3g");
        au = Util.m4524e("wvtt");
        av = Util.m4524e("stpp");
        aw = Util.m4524e("c608");
        ax = Util.m4524e("samr");
        ay = Util.m4524e("sawb");
        az = Util.m4524e("udta");
        aA = Util.m4524e("meta");
        aB = Util.m4524e("ilst");
        aC = Util.m4524e("mean");
        aD = Util.m4524e("name");
        aE = Util.m4524e("data");
        aF = Util.m4524e("st3d");
        aG = Util.m4524e("sv3d");
        aH = Util.m4524e("proj");
        aI = Util.m4524e("vp08");
        aJ = Util.m4524e("vp09");
        aK = Util.m4524e("vpcC");
        aL = Util.m4524e("----");
    }

    public Atom(int i) {
        this.aM = i;
    }

    public String toString() {
        return Atom.m3312c(this.aM);
    }

    public static int m3310a(int i) {
        return (i >> 24) & MotionEventCompat.ACTION_MASK;
    }

    public static int m3311b(int i) {
        return ViewCompat.MEASURED_SIZE_MASK & i;
    }

    public static String m3312c(int i) {
        return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING + ((char) (i >> 24)) + ((char) ((i >> 16) & MotionEventCompat.ACTION_MASK)) + ((char) ((i >> 8) & MotionEventCompat.ACTION_MASK)) + ((char) (i & MotionEventCompat.ACTION_MASK));
    }
}
