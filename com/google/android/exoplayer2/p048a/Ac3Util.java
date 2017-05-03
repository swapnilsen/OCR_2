package com.google.android.exoplayer2.p048a;

import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v7.appcompat.C0268R;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.p050j.ParsableBitArray;
import com.google.android.exoplayer2.p050j.ParsableByteArray;
import com.google.android.gms.ads.AdRequest;
import java.nio.ByteBuffer;

/* renamed from: com.google.android.exoplayer2.a.a */
public final class Ac3Util {
    private static final int[] f2345a;
    private static final int[] f2346b;
    private static final int[] f2347c;
    private static final int[] f2348d;
    private static final int[] f2349e;
    private static final int[] f2350f;

    static {
        f2345a = new int[]{1, 2, 3, 6};
        f2346b = new int[]{48000, 44100, 32000};
        f2347c = new int[]{24000, 22050, 16000};
        f2348d = new int[]{2, 1, 2, 3, 3, 4, 4, 5};
        f2349e = new int[]{32, 40, 48, 56, 64, 80, 96, C0268R.styleable.AppCompatTheme_spinnerStyle, AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS, 160, 192, 224, AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY, 320, 384, 448, AdRequest.MAX_CONTENT_URL_LENGTH, 576, 640};
        f2350f = new int[]{69, 87, C0268R.styleable.AppCompatTheme_checkboxStyle, 121, 139, 174, 208, 243, 278, 348, 417, 487, 557, 696, 835, 975, 1114, 1253, 1393};
    }

    public static Format m2881a(ParsableByteArray parsableByteArray, String str, String str2, DrmInitData drmInitData) {
        int i = f2346b[(parsableByteArray.m4461g() & 192) >> 6];
        int g = parsableByteArray.m4461g();
        int i2 = f2348d[(g & 56) >> 3];
        if ((g & 4) != 0) {
            i2++;
        }
        return Format.m2862a(str, "audio/ac3", null, -1, -1, i2, i, null, drmInitData, 0, str2);
    }

    public static Format m2884b(ParsableByteArray parsableByteArray, String str, String str2, DrmInitData drmInitData) {
        parsableByteArray.m4457d(2);
        int i = f2346b[(parsableByteArray.m4461g() & 192) >> 6];
        int g = parsableByteArray.m4461g();
        int i2 = f2348d[(g & 14) >> 1];
        if ((g & 1) != 0) {
            i2++;
        }
        return Format.m2862a(str, "audio/eac3", null, -1, -1, i2, i, null, drmInitData, 0, str2);
    }

    public static Format m2880a(ParsableBitArray parsableBitArray, String str, String str2, DrmInitData drmInitData) {
        int i = 1;
        parsableBitArray.m4443b(32);
        int c = parsableBitArray.m4445c(2);
        parsableBitArray.m4443b(14);
        int c2 = parsableBitArray.m4445c(3);
        if (!((c2 & 1) == 0 || c2 == 1)) {
            parsableBitArray.m4443b(2);
        }
        if ((c2 & 4) != 0) {
            parsableBitArray.m4443b(2);
        }
        if (c2 == 2) {
            parsableBitArray.m4443b(2);
        }
        boolean b = parsableBitArray.m4444b();
        String str3 = "audio/ac3";
        c2 = f2348d[c2];
        if (!b) {
            i = 0;
        }
        return Format.m2862a(str, str3, null, -1, -1, c2 + i, f2346b[c], null, drmInitData, 0, str2);
    }

    public static Format m2883b(ParsableBitArray parsableBitArray, String str, String str2, DrmInitData drmInitData) {
        int i;
        parsableBitArray.m4443b(32);
        int c = parsableBitArray.m4445c(2);
        if (c == 3) {
            i = f2347c[parsableBitArray.m4445c(2)];
        } else {
            parsableBitArray.m4443b(2);
            i = f2346b[c];
        }
        c = parsableBitArray.m4445c(3);
        boolean b = parsableBitArray.m4444b();
        String str3 = "audio/eac3";
        int i2 = f2348d[c];
        if (b) {
            c = 1;
        } else {
            c = 0;
        }
        return Format.m2862a(str, str3, null, -1, -1, i2 + c, i, null, drmInitData, 0, str2);
    }

    public static int m2879a(byte[] bArr) {
        if (bArr.length < 5) {
            return -1;
        }
        return Ac3Util.m2877a((bArr[4] & 192) >> 6, bArr[4] & 63);
    }

    public static int m2882b(byte[] bArr) {
        return ((((bArr[2] & 7) << 8) + (bArr[3] & MotionEventCompat.ACTION_MASK)) + 1) * 2;
    }

    public static int m2876a() {
        return 1536;
    }

    public static int m2885c(byte[] bArr) {
        return (((bArr[4] & 192) >> 6) == 3 ? 6 : f2345a[(bArr[4] & 48) >> 4]) * AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY;
    }

    public static int m2878a(ByteBuffer byteBuffer) {
        int i;
        if (((byteBuffer.get(byteBuffer.position() + 4) & 192) >> 6) == 3) {
            i = 6;
        } else {
            i = f2345a[(byteBuffer.get(byteBuffer.position() + 4) & 48) >> 4];
        }
        return i * AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY;
    }

    private static int m2877a(int i, int i2) {
        int i3 = i2 / 2;
        if (i < 0 || i >= f2346b.length || i2 < 0 || i3 >= f2350f.length) {
            return -1;
        }
        int i4 = f2346b[i];
        if (i4 == 44100) {
            return (f2350f[i3] + (i2 % 2)) * 2;
        }
        i3 = f2349e[i3];
        if (i4 == 32000) {
            return i3 * 6;
        }
        return i3 * 4;
    }
}
