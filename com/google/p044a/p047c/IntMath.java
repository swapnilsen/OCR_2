package com.google.p044a.p047c;

import android.support.v4.view.PointerIconCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v7.appcompat.C0268R;
import com.google.android.gms.plus.model.people.Person.RelationshipStatus;
import com.google.android.gms.plus.model.people.Person.Urls.Type;
import com.google.firebase.messaging.SendException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.math.RoundingMode;
import net.nend.android.NendIconError;
import p000a.p001a.p002a.p003a.p004a.p006b.AbstractSpiCall;

/* renamed from: com.google.a.c.a */
public final class IntMath {
    static final byte[] f2252a;
    static final int[] f2253b;
    static final int[] f2254c;
    static int[] f2255d;
    private static final int[] f2256e;

    /* renamed from: com.google.a.c.a.1 */
    static /* synthetic */ class IntMath {
        static final /* synthetic */ int[] f2251a;

        static {
            f2251a = new int[RoundingMode.values().length];
            try {
                f2251a[RoundingMode.UNNECESSARY.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f2251a[RoundingMode.DOWN.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f2251a[RoundingMode.FLOOR.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f2251a[RoundingMode.UP.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f2251a[RoundingMode.CEILING.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f2251a[RoundingMode.HALF_DOWN.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f2251a[RoundingMode.HALF_UP.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f2251a[RoundingMode.HALF_EVEN.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
        }
    }

    public static boolean m2810a(int i) {
        int i2 = 1;
        int i3 = i > 0 ? 1 : 0;
        if (((i - 1) & i) != 0) {
            i2 = 0;
        }
        return i2 & i3;
    }

    static int m2807a(int i, int i2) {
        return (((i - i2) ^ -1) ^ -1) >>> 31;
    }

    public static int m2809a(int i, RoundingMode roundingMode) {
        MathPreconditions.m2811a("x", i);
        switch (IntMath.f2251a[roundingMode.ordinal()]) {
            case NendIconError.ERROR_ICONVIEW /*1*/:
                MathPreconditions.m2812a(IntMath.m2810a(i));
                break;
            case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
            case SendException.ERROR_TTL_EXCEEDED /*3*/:
                break;
            case SendException.ERROR_TOO_MANY_MESSAGES /*4*/:
            case Type.OTHER_PROFILE /*5*/:
                return 32 - Integer.numberOfLeadingZeros(i - 1);
            case Type.CONTRIBUTOR /*6*/:
            case Type.WEBSITE /*7*/:
            case RelationshipStatus.IN_CIVIL_UNION /*8*/:
                int numberOfLeadingZeros = Integer.numberOfLeadingZeros(i);
                return (31 - numberOfLeadingZeros) + IntMath.m2807a(-1257966797 >>> numberOfLeadingZeros, i);
            default:
                throw new AssertionError();
        }
        return 31 - Integer.numberOfLeadingZeros(i);
    }

    static {
        f2252a = new byte[]{(byte) 9, (byte) 9, (byte) 9, (byte) 8, (byte) 8, (byte) 8, (byte) 7, (byte) 7, (byte) 7, (byte) 6, (byte) 6, (byte) 6, (byte) 6, (byte) 5, (byte) 5, (byte) 5, (byte) 4, (byte) 4, (byte) 4, (byte) 3, (byte) 3, (byte) 3, (byte) 3, (byte) 2, (byte) 2, (byte) 2, (byte) 1, (byte) 1, (byte) 1, (byte) 0, (byte) 0, (byte) 0, (byte) 0};
        f2253b = new int[]{1, 10, 100, PointerIconCompat.TYPE_DEFAULT, AbstractSpiCall.DEFAULT_TIMEOUT, 100000, 1000000, 10000000, 100000000, 1000000000};
        f2254c = new int[]{3, 31, 316, 3162, 31622, 316227, 3162277, 31622776, 316227766, ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED};
        f2256e = new int[]{1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800, 39916800, 479001600};
        f2255d = new int[]{ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, AccessibilityNodeInfoCompat.ACTION_CUT, 2345, 477, 193, C0268R.styleable.AppCompatTheme_ratingBarStyleSmall, 75, 58, 49, 43, 39, 37, 35, 34, 34, 33};
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int m2808a(int r7, int r8, java.math.RoundingMode r9) {
        /*
        r0 = 1;
        r1 = 0;
        com.google.p044a.p045a.Preconditions.m2774a(r9);
        if (r8 != 0) goto L_0x000f;
    L_0x0007:
        r0 = new java.lang.ArithmeticException;
        r1 = "/ by zero";
        r0.<init>(r1);
        throw r0;
    L_0x000f:
        r2 = r7 / r8;
        r3 = r8 * r2;
        r3 = r7 - r3;
        if (r3 != 0) goto L_0x0018;
    L_0x0017:
        return r2;
    L_0x0018:
        r4 = r7 ^ r8;
        r4 = r4 >> 31;
        r5 = r4 | 1;
        r4 = com.google.p044a.p047c.IntMath.IntMath.f2251a;
        r6 = r9.ordinal();
        r4 = r4[r6];
        switch(r4) {
            case 1: goto L_0x002f;
            case 2: goto L_0x0034;
            case 3: goto L_0x0041;
            case 4: goto L_0x0035;
            case 5: goto L_0x003d;
            case 6: goto L_0x0045;
            case 7: goto L_0x0045;
            case 8: goto L_0x0045;
            default: goto L_0x0029;
        };
    L_0x0029:
        r0 = new java.lang.AssertionError;
        r0.<init>();
        throw r0;
    L_0x002f:
        if (r3 != 0) goto L_0x003b;
    L_0x0031:
        com.google.p044a.p047c.MathPreconditions.m2812a(r0);
    L_0x0034:
        r0 = r1;
    L_0x0035:
        if (r0 == 0) goto L_0x006d;
    L_0x0037:
        r0 = r2 + r5;
    L_0x0039:
        r2 = r0;
        goto L_0x0017;
    L_0x003b:
        r0 = r1;
        goto L_0x0031;
    L_0x003d:
        if (r5 > 0) goto L_0x0035;
    L_0x003f:
        r0 = r1;
        goto L_0x0035;
    L_0x0041:
        if (r5 < 0) goto L_0x0035;
    L_0x0043:
        r0 = r1;
        goto L_0x0035;
    L_0x0045:
        r3 = java.lang.Math.abs(r3);
        r4 = java.lang.Math.abs(r8);
        r4 = r4 - r3;
        r3 = r3 - r4;
        if (r3 != 0) goto L_0x0069;
    L_0x0051:
        r3 = java.math.RoundingMode.HALF_UP;
        if (r9 == r3) goto L_0x0062;
    L_0x0055:
        r3 = java.math.RoundingMode.HALF_EVEN;
        if (r9 != r3) goto L_0x0065;
    L_0x0059:
        r4 = r0;
    L_0x005a:
        r3 = r2 & 1;
        if (r3 == 0) goto L_0x0067;
    L_0x005e:
        r3 = r0;
    L_0x005f:
        r3 = r3 & r4;
        if (r3 == 0) goto L_0x0063;
    L_0x0062:
        r1 = r0;
    L_0x0063:
        r0 = r1;
        goto L_0x0035;
    L_0x0065:
        r4 = r1;
        goto L_0x005a;
    L_0x0067:
        r3 = r1;
        goto L_0x005f;
    L_0x0069:
        if (r3 > 0) goto L_0x0035;
    L_0x006b:
        r0 = r1;
        goto L_0x0035;
    L_0x006d:
        r0 = r2;
        goto L_0x0039;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.a.c.a.a(int, int, java.math.RoundingMode):int");
    }
}
