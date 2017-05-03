package com.google.android.exoplayer2.p052c;

import android.support.v4.view.PointerIconCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v7.appcompat.C0268R;

/* renamed from: com.google.android.exoplayer2.c.k */
public final class MpegAudioHeader {
    private static final String[] f3252h;
    private static final int[] f3253i;
    private static final int[] f3254j;
    private static final int[] f3255k;
    private static final int[] f3256l;
    private static final int[] f3257m;
    private static final int[] f3258n;
    public int f3259a;
    public String f3260b;
    public int f3261c;
    public int f3262d;
    public int f3263e;
    public int f3264f;
    public int f3265g;

    static {
        f3252h = new String[]{"audio/mpeg-L1", "audio/mpeg-L2", "audio/mpeg"};
        f3253i = new int[]{44100, 48000, 32000};
        f3254j = new int[]{32, 64, 96, AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS, 160, 192, 224, AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY, 288, 320, 352, 384, 416, 448};
        f3255k = new int[]{32, 48, 56, 64, 80, 96, C0268R.styleable.AppCompatTheme_spinnerStyle, AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS, 144, 160, 176, 192, 224, AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY};
        f3256l = new int[]{32, 48, 56, 64, 80, 96, C0268R.styleable.AppCompatTheme_spinnerStyle, AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS, 160, 192, 224, AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY, 320, 384};
        f3257m = new int[]{32, 40, 48, 56, 64, 80, 96, C0268R.styleable.AppCompatTheme_spinnerStyle, AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS, 160, 192, 224, AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY, 320};
        f3258n = new int[]{8, 16, 24, 32, 40, 48, 56, 64, 80, 96, C0268R.styleable.AppCompatTheme_spinnerStyle, AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS, 144, 160};
    }

    public static int m3731a(int i) {
        if ((i & -2097152) != -2097152) {
            return -1;
        }
        int i2 = (i >>> 19) & 3;
        if (i2 == 1) {
            return -1;
        }
        int i3 = (i >>> 17) & 3;
        if (i3 == 0) {
            return -1;
        }
        int i4 = (i >>> 12) & 15;
        if (i4 == 0 || i4 == 15) {
            return -1;
        }
        int i5 = (i >>> 10) & 3;
        if (i5 == 3) {
            return -1;
        }
        int i6 = f3253i[i5];
        if (i2 == 2) {
            i5 = i6 / 2;
        } else if (i2 == 0) {
            i5 = i6 / 4;
        } else {
            i5 = i6;
        }
        int i7 = (i >>> 9) & 1;
        if (i3 == 3) {
            return ((((i2 == 3 ? f3254j[i4 - 1] : f3255k[i4 - 1]) * 12000) / i5) + i7) * 4;
        }
        if (i2 == 3) {
            i4 = i3 == 2 ? f3256l[i4 - 1] : f3257m[i4 - 1];
        } else {
            i4 = f3258n[i4 - 1];
        }
        if (i2 == 3) {
            return ((144000 * i4) / i5) + i7;
        }
        return (((i3 == 1 ? 72000 : 144000) * i4) / i5) + i7;
    }

    public static boolean m3733a(int i, MpegAudioHeader mpegAudioHeader) {
        int i2 = 2;
        if ((i & -2097152) != -2097152) {
            return false;
        }
        int i3 = (i >>> 19) & 3;
        if (i3 == 1) {
            return false;
        }
        int i4 = (i >>> 17) & 3;
        if (i4 == 0) {
            return false;
        }
        int i5 = (i >>> 12) & 15;
        if (i5 == 0 || i5 == 15) {
            return false;
        }
        int i6 = (i >>> 10) & 3;
        if (i6 == 3) {
            return false;
        }
        int i7;
        int i8;
        int i9 = f3253i[i6];
        if (i3 == 2) {
            i9 /= 2;
        } else if (i3 == 0) {
            i9 /= 4;
        }
        i6 = (i >>> 9) & 1;
        if (i4 == 3) {
            i7 = i3 == 3 ? f3254j[i5 - 1] : f3255k[i5 - 1];
            i6 = (((i7 * 12000) / i9) + i6) * 4;
            i8 = 384;
        } else if (i3 == 3) {
            i7 = i4 == 2 ? f3256l[i5 - 1] : f3257m[i5 - 1];
            i8 = 1152;
            i6 += (144000 * i7) / i9;
        } else {
            i5 = f3258n[i5 - 1];
            i8 = i4 == 1 ? 576 : 1152;
            i6 += ((i4 == 1 ? 72000 : 144000) * i5) / i9;
            i7 = i5;
        }
        String str = f3252h[3 - i4];
        if (((i >> 6) & 3) == 3) {
            i2 = 1;
        }
        mpegAudioHeader.m3732a(i3, str, i6, i9, i2, i7 * PointerIconCompat.TYPE_DEFAULT, i8);
        return true;
    }

    private void m3732a(int i, String str, int i2, int i3, int i4, int i5, int i6) {
        this.f3259a = i;
        this.f3260b = str;
        this.f3261c = i2;
        this.f3262d = i3;
        this.f3263e = i4;
        this.f3264f = i5;
        this.f3265g = i6;
    }
}
