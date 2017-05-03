package com.google.android.exoplayer2.p052c.p055c;

import android.support.v4.media.TransportMediator;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.util.Pair;
import com.google.android.exoplayer2.p050j.ParsableByteArray;
import com.google.android.exoplayer2.p050j.Util;
import com.google.android.exoplayer2.p052c.ExtractorInput;
import com.google.android.exoplayer2.p052c.GaplessInfoHolder;
import java.nio.charset.Charset;

/* renamed from: com.google.android.exoplayer2.c.c.b */
final class Id3Util {
    private static final int f2660a;
    private static final Charset[] f2661b;

    static {
        f2660a = Util.m4524e("ID3");
        f2661b = new Charset[]{Charset.forName("ISO-8859-1"), Charset.forName("UTF-16LE"), Charset.forName("UTF-16BE"), Charset.forName("UTF-8")};
    }

    public static void m3268a(ExtractorInput extractorInput, GaplessInfoHolder gaplessInfoHolder) {
        ParsableByteArray parsableByteArray = new ParsableByteArray(10);
        int i = 0;
        while (true) {
            extractorInput.m3240c(parsableByteArray.f3831a, 0, 10);
            parsableByteArray.m4455c(0);
            if (parsableByteArray.m4465k() != f2660a) {
                extractorInput.m3232a();
                extractorInput.m3239c(i);
                return;
            }
            int g = parsableByteArray.m4461g();
            int g2 = parsableByteArray.m4461g();
            int g3 = parsableByteArray.m4461g();
            int s = parsableByteArray.m4473s();
            if (gaplessInfoHolder.m3728a() || !Id3Util.m3271a(g, g2, g3, s)) {
                extractorInput.m3239c(s);
            } else {
                byte[] bArr = new byte[s];
                extractorInput.m3240c(bArr, 0, s);
                Id3Util.m3269a(new ParsableByteArray(bArr), g, g3, gaplessInfoHolder);
            }
            i += s + 10;
        }
    }

    private static boolean m3271a(int i, int i2, int i3, int i4) {
        return i2 != MotionEventCompat.ACTION_MASK && i >= 2 && i <= 4 && i4 <= 3145728 && ((i != 2 || ((i3 & 63) == 0 && (i3 & 64) == 0)) && ((i != 3 || (i3 & 31) == 0) && (i != 4 || (i3 & 15) == 0)));
    }

    private static void m3269a(ParsableByteArray parsableByteArray, int i, int i2, GaplessInfoHolder gaplessInfoHolder) {
        Id3Util.m3272a(parsableByteArray, i, i2);
        parsableByteArray.m4455c(0);
        int s;
        if (i != 3 || (i2 & 64) == 0) {
            if (i == 4 && (i2 & 64) != 0) {
                if (parsableByteArray.m4452b() >= 4) {
                    s = parsableByteArray.m4473s();
                    if (s >= 6 && s <= parsableByteArray.m4452b() + 4) {
                        parsableByteArray.m4455c(s);
                    } else {
                        return;
                    }
                }
                return;
            }
        } else if (parsableByteArray.m4452b() >= 4) {
            s = parsableByteArray.m4474t();
            if (s <= parsableByteArray.m4452b()) {
                if (s >= 6) {
                    parsableByteArray.m4457d(2);
                    int t = parsableByteArray.m4474t();
                    parsableByteArray.m4455c(4);
                    parsableByteArray.m4453b(parsableByteArray.m4454c() - t);
                    if (parsableByteArray.m4452b() < s) {
                        return;
                    }
                }
                parsableByteArray.m4457d(s);
            } else {
                return;
            }
        } else {
            return;
        }
        while (true) {
            Pair a = Id3Util.m3267a(i, parsableByteArray);
            if (a == null) {
                return;
            }
            if (((String) a.first).length() > 3 && gaplessInfoHolder.m3730a(((String) a.first).substring(3), (String) a.second)) {
                return;
            }
        }
    }

    private static Pair<String, String> m3267a(int i, ParsableByteArray parsableByteArray) {
        int h;
        while (true) {
            int k;
            if (i == 2) {
                if (parsableByteArray.m4452b() < 6) {
                    return null;
                }
                String a = parsableByteArray.m4446a(3, Charset.forName("US-ASCII"));
                if (a.equals("\u0000\u0000\u0000")) {
                    return null;
                }
                k = parsableByteArray.m4465k();
                if (k == 0 || k > parsableByteArray.m4452b()) {
                    return null;
                }
                if (a.equals("COM")) {
                    break;
                }
                parsableByteArray.m4457d(k);
            } else if (parsableByteArray.m4452b() < 10) {
                return null;
            } else {
                String a2 = parsableByteArray.m4446a(4, Charset.forName("US-ASCII"));
                if (a2.equals("\u0000\u0000\u0000\u0000")) {
                    return null;
                }
                k = i == 4 ? parsableByteArray.m4473s() : parsableByteArray.m4474t();
                if (k == 0 || k > parsableByteArray.m4452b() - 2) {
                    return null;
                }
                h = parsableByteArray.m4462h();
                if ((i != 4 || (h & 12) == 0) && (i != 3 || (h & 192) == 0)) {
                    h = 0;
                } else {
                    h = 1;
                }
                if (h == 0 && a2.equals("COMM")) {
                    break;
                }
                parsableByteArray.m4457d(k);
            }
        }
        h = parsableByteArray.m4461g();
        if (h < 0 || h >= f2661b.length) {
            return null;
        }
        Pair<String, String> create;
        String[] split = parsableByteArray.m4446a(k - 1, f2661b[h]).split("\u0000");
        if (split.length == 2) {
            create = Pair.create(split[0], split[1]);
        } else {
            create = null;
        }
        return create;
    }

    private static boolean m3272a(ParsableByteArray parsableByteArray, int i, int i2) {
        if (i != 4) {
            if ((i2 & AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS) != 0) {
                Object obj = parsableByteArray.f3831a;
                int length = obj.length;
                int i3 = false;
                while (i3 + 1 < length) {
                    if ((obj[i3] & MotionEventCompat.ACTION_MASK) == MotionEventCompat.ACTION_MASK && obj[i3 + 1] == null) {
                        System.arraycopy(obj, i3 + 2, obj, i3 + 1, (length - i3) - 2);
                        length--;
                    }
                    i3++;
                }
                parsableByteArray.m4453b(length);
            }
        } else if (Id3Util.m3273a(parsableByteArray, false)) {
            Id3Util.m3274b(parsableByteArray, false);
        } else if (!Id3Util.m3273a(parsableByteArray, true)) {
            return false;
        } else {
            Id3Util.m3274b(parsableByteArray, true);
        }
        return true;
    }

    private static boolean m3273a(ParsableByteArray parsableByteArray, boolean z) {
        parsableByteArray.m4455c(0);
        while (parsableByteArray.m4452b() >= 10) {
            if (parsableByteArray.m4468n() == 0) {
                return true;
            }
            long l = parsableByteArray.m4466l();
            if (!z) {
                if ((8421504 & l) != 0) {
                    return false;
                }
                l = (((l >> 24) & 127) << 21) | (((l & 127) | (((l >> 8) & 127) << 7)) | (((l >> 16) & 127) << 14));
            }
            if (l > ((long) (parsableByteArray.m4452b() - 2))) {
                return false;
            }
            if ((parsableByteArray.m4462h() & 1) != 0 && parsableByteArray.m4452b() < 4) {
                return false;
            }
            parsableByteArray.m4457d((int) l);
        }
        return true;
    }

    private static void m3274b(ParsableByteArray parsableByteArray, boolean z) {
        parsableByteArray.m4455c(0);
        byte[] bArr = parsableByteArray.f3831a;
        while (parsableByteArray.m4452b() >= 10 && parsableByteArray.m4468n() != 0) {
            int d;
            int i;
            int t = z ? parsableByteArray.m4474t() : parsableByteArray.m4473s();
            int h = parsableByteArray.m4462h();
            if ((h & 1) != 0) {
                d = parsableByteArray.m4456d();
                System.arraycopy(bArr, d + 4, bArr, d, parsableByteArray.m4452b() - 4);
                d = t - 4;
                i = h & -2;
                parsableByteArray.m4453b(parsableByteArray.m4454c() - 4);
            } else {
                i = h;
                d = t;
            }
            if ((i & 2) != 0) {
                t = parsableByteArray.m4456d() + 1;
                int i2 = 0;
                int i3 = t;
                while (i2 + 1 < d) {
                    if ((bArr[t - 1] & MotionEventCompat.ACTION_MASK) == MotionEventCompat.ACTION_MASK && bArr[t] == null) {
                        t++;
                        d--;
                    }
                    int i4 = i3 + 1;
                    int i5 = t + 1;
                    bArr[i3] = bArr[t];
                    i2++;
                    i3 = i4;
                    t = i5;
                }
                parsableByteArray.m4453b(parsableByteArray.m4454c() - (t - i3));
                System.arraycopy(bArr, t, bArr, i3, parsableByteArray.m4452b() - t);
                t = i & -3;
            } else {
                t = i;
            }
            if (t != h || z) {
                i = parsableByteArray.m4456d() - 6;
                Id3Util.m3270a(bArr, i, d);
                bArr[i + 4] = (byte) (t >> 8);
                bArr[i + 5] = (byte) (t & MotionEventCompat.ACTION_MASK);
            }
            parsableByteArray.m4457d(d);
        }
    }

    private static void m3270a(byte[] bArr, int i, int i2) {
        bArr[i] = (byte) ((i2 >> 21) & TransportMediator.KEYCODE_MEDIA_PAUSE);
        bArr[i + 1] = (byte) ((i2 >> 14) & TransportMediator.KEYCODE_MEDIA_PAUSE);
        bArr[i + 2] = (byte) ((i2 >> 7) & TransportMediator.KEYCODE_MEDIA_PAUSE);
        bArr[i + 3] = (byte) (i2 & TransportMediator.KEYCODE_MEDIA_PAUSE);
    }
}
