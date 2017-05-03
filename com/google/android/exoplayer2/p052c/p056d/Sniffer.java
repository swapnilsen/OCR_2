package com.google.android.exoplayer2.p052c.p056d;

import android.support.v4.media.session.PlaybackStateCompat;
import com.google.android.exoplayer2.p050j.ParsableByteArray;
import com.google.android.exoplayer2.p050j.Util;
import com.google.android.exoplayer2.p052c.ExtractorInput;

/* renamed from: com.google.android.exoplayer2.c.d.h */
final class Sniffer {
    private static final int[] f2854a;

    static {
        f2854a = new int[]{Util.m4524e("isom"), Util.m4524e("iso2"), Util.m4524e("iso3"), Util.m4524e("iso4"), Util.m4524e("iso5"), Util.m4524e("iso6"), Util.m4524e("avc1"), Util.m4524e("hvc1"), Util.m4524e("hev1"), Util.m4524e("mp41"), Util.m4524e("mp42"), Util.m4524e("3g2a"), Util.m4524e("3g2b"), Util.m4524e("3gr6"), Util.m4524e("3gs6"), Util.m4524e("3ge6"), Util.m4524e("3gg6"), Util.m4524e("M4V "), Util.m4524e("M4A "), Util.m4524e("f4v "), Util.m4524e("kddi"), Util.m4524e("M4VP"), Util.m4524e("qt  "), Util.m4524e("MSNV")};
    }

    public static boolean m3413a(ExtractorInput extractorInput) {
        return Sniffer.m3414a(extractorInput, true);
    }

    public static boolean m3415b(ExtractorInput extractorInput) {
        return Sniffer.m3414a(extractorInput, false);
    }

    private static boolean m3414a(ExtractorInput extractorInput, boolean z) {
        long d = extractorInput.m3241d();
        if (d == -1 || d > PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM) {
            d = PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
        }
        int i = (int) d;
        ParsableByteArray parsableByteArray = new ParsableByteArray(64);
        Object obj = null;
        boolean z2 = false;
        int i2 = 0;
        while (i2 < i) {
            int i3 = 8;
            parsableByteArray.m4448a(8);
            extractorInput.m3240c(parsableByteArray.f3831a, 0, 8);
            long l = parsableByteArray.m4466l();
            int n = parsableByteArray.m4468n();
            if (l == 1) {
                i3 = 16;
                extractorInput.m3240c(parsableByteArray.f3831a, 8, 8);
                parsableByteArray.m4453b(16);
                l = parsableByteArray.m4476v();
            }
            if (l >= ((long) i3)) {
                i2 += i3;
                if (n != Atom.f2708A) {
                    if (n != Atom.f2717J && n != Atom.f2719L) {
                        if ((((long) i2) + l) - ((long) i3) >= ((long) i)) {
                            break;
                        }
                        int i4 = (int) (l - ((long) i3));
                        int i5 = i2 + i4;
                        if (n == Atom.f2734a) {
                            if (i4 < 8) {
                                return false;
                            }
                            parsableByteArray.m4448a(i4);
                            extractorInput.m3240c(parsableByteArray.f3831a, 0, i4);
                            i3 = i4 / 4;
                            for (i4 = 0; i4 < i3; i4++) {
                                if (i4 == 1) {
                                    parsableByteArray.m4457d(4);
                                } else if (Sniffer.m3412a(parsableByteArray.m4468n())) {
                                    obj = 1;
                                    break;
                                }
                            }
                            if (obj == null) {
                                return false;
                            }
                        } else if (i4 != 0) {
                            extractorInput.m3239c(i4);
                        }
                        i2 = i5;
                    } else {
                        z2 = true;
                        break;
                    }
                }
            } else {
                return false;
            }
        }
        if (obj == null || z != r1) {
            return false;
        }
        return true;
    }

    private static boolean m3412a(int i) {
        if ((i >>> 8) == Util.m4524e("3gp")) {
            return true;
        }
        for (int i2 : f2854a) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }
}
