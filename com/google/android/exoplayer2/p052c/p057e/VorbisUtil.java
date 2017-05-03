package com.google.android.exoplayer2.p052c.p057e;

import android.support.v7.appcompat.C0268R;
import android.util.Log;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.p050j.ParsableByteArray;
import java.util.Arrays;
import net.nend.android.NendAdIconLayout;
import net.nend.android.NendIconError;

/* renamed from: com.google.android.exoplayer2.c.e.k */
final class VorbisUtil {

    /* renamed from: com.google.android.exoplayer2.c.e.k.a */
    public static final class VorbisUtil {
        public final int f2984a;
        public final int f2985b;
        public final long[] f2986c;
        public final int f2987d;
        public final boolean f2988e;

        public VorbisUtil(int i, int i2, long[] jArr, int i3, boolean z) {
            this.f2984a = i;
            this.f2985b = i2;
            this.f2986c = jArr;
            this.f2987d = i3;
            this.f2988e = z;
        }
    }

    /* renamed from: com.google.android.exoplayer2.c.e.k.b */
    public static final class VorbisUtil {
        public final String f2989a;
        public final String[] f2990b;
        public final int f2991c;

        public VorbisUtil(String str, String[] strArr, int i) {
            this.f2989a = str;
            this.f2990b = strArr;
            this.f2991c = i;
        }
    }

    /* renamed from: com.google.android.exoplayer2.c.e.k.c */
    public static final class VorbisUtil {
        public final boolean f2992a;
        public final int f2993b;
        public final int f2994c;
        public final int f2995d;

        public VorbisUtil(boolean z, int i, int i2, int i3) {
            this.f2992a = z;
            this.f2993b = i;
            this.f2994c = i2;
            this.f2995d = i3;
        }
    }

    /* renamed from: com.google.android.exoplayer2.c.e.k.d */
    public static final class VorbisUtil {
        public final long f2996a;
        public final int f2997b;
        public final long f2998c;
        public final int f2999d;
        public final int f3000e;
        public final int f3001f;
        public final int f3002g;
        public final int f3003h;
        public final boolean f3004i;
        public final byte[] f3005j;

        public VorbisUtil(long j, int i, long j2, int i2, int i3, int i4, int i5, int i6, boolean z, byte[] bArr) {
            this.f2996a = j;
            this.f2997b = i;
            this.f2998c = j2;
            this.f2999d = i2;
            this.f3000e = i3;
            this.f3001f = i4;
            this.f3002g = i5;
            this.f3003h = i6;
            this.f3004i = z;
            this.f3005j = bArr;
        }
    }

    public static int m3530a(int i) {
        int i2 = 0;
        while (i > 0) {
            i2++;
            i >>>= 1;
        }
        return i2;
    }

    public static VorbisUtil m3532a(ParsableByteArray parsableByteArray) {
        VorbisUtil.m3534a(1, parsableByteArray, false);
        long m = parsableByteArray.m4467m();
        int g = parsableByteArray.m4461g();
        long m2 = parsableByteArray.m4467m();
        int o = parsableByteArray.m4469o();
        int o2 = parsableByteArray.m4469o();
        int o3 = parsableByteArray.m4469o();
        int g2 = parsableByteArray.m4461g();
        return new VorbisUtil(m, g, m2, o, o2, o3, (int) Math.pow(2.0d, (double) (g2 & 15)), (int) Math.pow(2.0d, (double) ((g2 & 240) >> 4)), (parsableByteArray.m4461g() & 1) > 0, Arrays.copyOf(parsableByteArray.f3831a, parsableByteArray.m4454c()));
    }

    public static VorbisUtil m3537b(ParsableByteArray parsableByteArray) {
        int i = 0;
        VorbisUtil.m3534a(3, parsableByteArray, false);
        String e = parsableByteArray.m4459e((int) parsableByteArray.m4467m());
        int length = e.length() + 11;
        long m = parsableByteArray.m4467m();
        String[] strArr = new String[((int) m)];
        length += 4;
        while (((long) i) < m) {
            length += 4;
            strArr[i] = parsableByteArray.m4459e((int) parsableByteArray.m4467m());
            length += strArr[i].length();
            i++;
        }
        if ((parsableByteArray.m4461g() & 1) != 0) {
            return new VorbisUtil(e, strArr, length + 1);
        }
        throw new ParserException("framing bit expected to be set");
    }

    public static boolean m3534a(int i, ParsableByteArray parsableByteArray, boolean z) {
        if (parsableByteArray.m4452b() < 7) {
            if (z) {
                return false;
            }
            throw new ParserException("too short header: " + parsableByteArray.m4452b());
        } else if (parsableByteArray.m4461g() != i) {
            if (z) {
                return false;
            }
            throw new ParserException("expected header type " + Integer.toHexString(i));
        } else if (parsableByteArray.m4461g() == 118 && parsableByteArray.m4461g() == C0268R.styleable.AppCompatTheme_seekBarStyle && parsableByteArray.m4461g() == C0268R.styleable.AppCompatTheme_listMenuViewStyle && parsableByteArray.m4461g() == 98 && parsableByteArray.m4461g() == C0268R.styleable.AppCompatTheme_checkedTextViewStyle && parsableByteArray.m4461g() == 115) {
            return true;
        } else {
            if (z) {
                return false;
            }
            throw new ParserException("expected characters 'vorbis'");
        }
    }

    public static VorbisUtil[] m3536a(ParsableByteArray parsableByteArray, int i) {
        int i2;
        int i3 = 0;
        VorbisUtil.m3534a(5, parsableByteArray, false);
        int g = parsableByteArray.m4461g() + 1;
        VorbisBitArray vorbisBitArray = new VorbisBitArray(parsableByteArray.f3831a);
        vorbisBitArray.m3520b(parsableByteArray.m4456d() * 8);
        for (i2 = 0; i2 < g; i2++) {
            VorbisUtil.m3540d(vorbisBitArray);
        }
        i2 = vorbisBitArray.m3517a(6) + 1;
        while (i3 < i2) {
            if (vorbisBitArray.m3517a(16) != 0) {
                throw new ParserException("placeholder of time domain transforms not zeroed out");
            }
            i3++;
        }
        VorbisUtil.m3539c(vorbisBitArray);
        VorbisUtil.m3538b(vorbisBitArray);
        VorbisUtil.m3533a(i, vorbisBitArray);
        VorbisUtil[] a = VorbisUtil.m3535a(vorbisBitArray);
        if (vorbisBitArray.m3518a()) {
            return a;
        }
        throw new ParserException("framing bit after modes not set as expected");
    }

    private static VorbisUtil[] m3535a(VorbisBitArray vorbisBitArray) {
        int a = vorbisBitArray.m3517a(6) + 1;
        VorbisUtil[] vorbisUtilArr = new VorbisUtil[a];
        for (int i = 0; i < a; i++) {
            vorbisUtilArr[i] = new VorbisUtil(vorbisBitArray.m3518a(), vorbisBitArray.m3517a(16), vorbisBitArray.m3517a(16), vorbisBitArray.m3517a(8));
        }
        return vorbisUtilArr;
    }

    private static void m3533a(int i, VorbisBitArray vorbisBitArray) {
        int a = vorbisBitArray.m3517a(6) + 1;
        for (int i2 = 0; i2 < a; i2++) {
            int a2 = vorbisBitArray.m3517a(16);
            switch (a2) {
                case NendAdIconLayout.HORIZONTAL /*0*/:
                    int i3;
                    if (vorbisBitArray.m3518a()) {
                        a2 = vorbisBitArray.m3517a(4) + 1;
                    } else {
                        a2 = 1;
                    }
                    if (vorbisBitArray.m3518a()) {
                        int a3 = vorbisBitArray.m3517a(8) + 1;
                        for (i3 = 0; i3 < a3; i3++) {
                            vorbisBitArray.m3520b(VorbisUtil.m3530a(i - 1));
                            vorbisBitArray.m3520b(VorbisUtil.m3530a(i - 1));
                        }
                    }
                    if (vorbisBitArray.m3517a(2) == 0) {
                        if (a2 > 1) {
                            for (i3 = 0; i3 < i; i3++) {
                                vorbisBitArray.m3520b(4);
                            }
                        }
                        for (i3 = 0; i3 < a2; i3++) {
                            vorbisBitArray.m3520b(8);
                            vorbisBitArray.m3520b(8);
                            vorbisBitArray.m3520b(8);
                        }
                        break;
                    }
                    throw new ParserException("to reserved bits must be zero after mapping coupling steps");
                default:
                    Log.e("VorbisUtil", "mapping type other than 0 not supported: " + a2);
                    break;
            }
        }
    }

    private static void m3538b(VorbisBitArray vorbisBitArray) {
        int a = vorbisBitArray.m3517a(6) + 1;
        for (int i = 0; i < a; i++) {
            if (vorbisBitArray.m3517a(16) > 2) {
                throw new ParserException("residueType greater than 2 is not decodable");
            }
            int i2;
            vorbisBitArray.m3520b(24);
            vorbisBitArray.m3520b(24);
            vorbisBitArray.m3520b(24);
            int a2 = vorbisBitArray.m3517a(6) + 1;
            vorbisBitArray.m3520b(8);
            int[] iArr = new int[a2];
            for (i2 = 0; i2 < a2; i2++) {
                int a3;
                int a4 = vorbisBitArray.m3517a(3);
                if (vorbisBitArray.m3518a()) {
                    a3 = vorbisBitArray.m3517a(5);
                } else {
                    a3 = 0;
                }
                iArr[i2] = (a3 * 8) + a4;
            }
            for (i2 = 0; i2 < a2; i2++) {
                for (a3 = 0; a3 < 8; a3++) {
                    if ((iArr[i2] & (1 << a3)) != 0) {
                        vorbisBitArray.m3520b(8);
                    }
                }
            }
        }
    }

    private static void m3539c(VorbisBitArray vorbisBitArray) {
        int a = vorbisBitArray.m3517a(6) + 1;
        for (int i = 0; i < a; i++) {
            int a2 = vorbisBitArray.m3517a(16);
            int a3;
            switch (a2) {
                case NendAdIconLayout.HORIZONTAL /*0*/:
                    vorbisBitArray.m3520b(8);
                    vorbisBitArray.m3520b(16);
                    vorbisBitArray.m3520b(16);
                    vorbisBitArray.m3520b(6);
                    vorbisBitArray.m3520b(8);
                    a3 = vorbisBitArray.m3517a(4) + 1;
                    for (a2 = 0; a2 < a3; a2++) {
                        vorbisBitArray.m3520b(8);
                    }
                    break;
                case NendIconError.ERROR_ICONVIEW /*1*/:
                    int a4;
                    int a5 = vorbisBitArray.m3517a(5);
                    a2 = -1;
                    int[] iArr = new int[a5];
                    for (a3 = 0; a3 < a5; a3++) {
                        iArr[a3] = vorbisBitArray.m3517a(4);
                        if (iArr[a3] > a2) {
                            a2 = iArr[a3];
                        }
                    }
                    int[] iArr2 = new int[(a2 + 1)];
                    for (a2 = 0; a2 < iArr2.length; a2++) {
                        iArr2[a2] = vorbisBitArray.m3517a(3) + 1;
                        a4 = vorbisBitArray.m3517a(2);
                        if (a4 > 0) {
                            vorbisBitArray.m3520b(8);
                        }
                        for (a3 = 0; a3 < (1 << a4); a3++) {
                            vorbisBitArray.m3520b(8);
                        }
                    }
                    vorbisBitArray.m3520b(2);
                    int a6 = vorbisBitArray.m3517a(4);
                    a2 = 0;
                    a4 = 0;
                    for (a3 = 0; a3 < a5; a3++) {
                        a4 += iArr2[iArr[a3]];
                        while (a2 < a4) {
                            vorbisBitArray.m3520b(a6);
                            a2++;
                        }
                    }
                    break;
                default:
                    throw new ParserException("floor type greater than 1 not decodable: " + a2);
            }
        }
    }

    private static VorbisUtil m3540d(VorbisBitArray vorbisBitArray) {
        int i = 0;
        if (vorbisBitArray.m3517a(24) != 5653314) {
            throw new ParserException("expected code book to start with [0x56, 0x43, 0x42] at " + vorbisBitArray.m3519b());
        }
        int i2;
        int a = vorbisBitArray.m3517a(16);
        int a2 = vorbisBitArray.m3517a(24);
        long[] jArr = new long[a2];
        boolean a3 = vorbisBitArray.m3518a();
        if (a3) {
            int a4 = vorbisBitArray.m3517a(5) + 1;
            i2 = 0;
            while (i2 < jArr.length) {
                int a5 = vorbisBitArray.m3517a(VorbisUtil.m3530a(a2 - i2));
                int i3 = 0;
                while (i3 < a5 && i2 < jArr.length) {
                    jArr[i2] = (long) a4;
                    i3++;
                    i2++;
                }
                a4++;
            }
        } else {
            boolean a6 = vorbisBitArray.m3518a();
            while (i < jArr.length) {
                if (!a6) {
                    jArr[i] = (long) (vorbisBitArray.m3517a(5) + 1);
                } else if (vorbisBitArray.m3518a()) {
                    jArr[i] = (long) (vorbisBitArray.m3517a(5) + 1);
                } else {
                    jArr[i] = 0;
                }
                i++;
            }
        }
        i2 = vorbisBitArray.m3517a(4);
        if (i2 > 2) {
            throw new ParserException("lookup type greater than 2 not decodable: " + i2);
        }
        if (i2 == 1 || i2 == 2) {
            long j;
            vorbisBitArray.m3520b(32);
            vorbisBitArray.m3520b(32);
            i = vorbisBitArray.m3517a(4) + 1;
            vorbisBitArray.m3520b(1);
            if (i2 != 1) {
                j = (long) (a2 * a);
            } else if (a != 0) {
                j = VorbisUtil.m3531a((long) a2, (long) a);
            } else {
                j = 0;
            }
            vorbisBitArray.m3520b((int) (j * ((long) i)));
        }
        return new VorbisUtil(a, a2, jArr, i2, a3);
    }

    private static long m3531a(long j, long j2) {
        return (long) Math.floor(Math.pow((double) j, 1.0d / ((double) j2)));
    }
}
