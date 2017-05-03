package com.google.android.exoplayer2.p050j;

import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.util.Pair;
import p000a.p001a.p002a.p003a.p004a.p009d.EventsFilesManager;

/* renamed from: com.google.android.exoplayer2.j.b */
public final class CodecSpecificDataUtil {
    private static final byte[] f3792a;
    private static final int[] f3793b;
    private static final int[] f3794c;

    static {
        f3792a = new byte[]{(byte) 0, (byte) 0, (byte) 0, (byte) 1};
        f3793b = new int[]{96000, 88200, 64000, 48000, 44100, 32000, 24000, 22050, 16000, 12000, 11025, EventsFilesManager.MAX_BYTE_SIZE_PER_FILE, 7350};
        f3794c = new int[]{0, 1, 2, 3, 4, 5, 6, 8, -1, -1, -1, 7, 8, -1, 8, -1};
    }

    public static Pair<Integer, Integer> m4408a(byte[] bArr) {
        int c;
        boolean z;
        boolean z2 = true;
        ParsableBitArray parsableBitArray = new ParsableBitArray(bArr);
        int c2 = parsableBitArray.m4445c(5);
        int c3 = parsableBitArray.m4445c(4);
        if (c3 == 15) {
            c = parsableBitArray.m4445c(24);
        } else {
            if (c3 < 13) {
                z = true;
            } else {
                z = false;
            }
            Assertions.m4404a(z);
            c = f3793b[c3];
        }
        c3 = parsableBitArray.m4445c(4);
        if (c2 == 5 || c2 == 29) {
            c2 = parsableBitArray.m4445c(4);
            if (c2 == 15) {
                c = parsableBitArray.m4445c(24);
            } else {
                if (c2 < 13) {
                    z = true;
                } else {
                    z = false;
                }
                Assertions.m4404a(z);
                c = f3793b[c2];
            }
            if (parsableBitArray.m4445c(5) == 22) {
                c3 = c;
                c = parsableBitArray.m4445c(4);
                c = f3794c[c];
                if (c == -1) {
                    z2 = false;
                }
                Assertions.m4404a(z2);
                return Pair.create(Integer.valueOf(c3), Integer.valueOf(c));
            }
        }
        int i = c3;
        c3 = c;
        c = i;
        c = f3794c[c];
        if (c == -1) {
            z2 = false;
        }
        Assertions.m4404a(z2);
        return Pair.create(Integer.valueOf(c3), Integer.valueOf(c));
    }

    public static byte[] m4409a(int i, int i2, int i3) {
        return new byte[]{(byte) (((i << 3) & 248) | ((i2 >> 1) & 7)), (byte) (((i2 << 7) & AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS) | ((i3 << 3) & 120))};
    }

    public static byte[] m4410a(byte[] bArr, int i, int i2) {
        Object obj = new byte[(f3792a.length + i2)];
        System.arraycopy(f3792a, 0, obj, 0, f3792a.length);
        System.arraycopy(bArr, i, obj, f3792a.length, i2);
        return obj;
    }
}
