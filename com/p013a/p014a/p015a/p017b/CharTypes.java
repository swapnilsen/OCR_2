package com.p013a.p014a.p015a.p017b;

import android.support.v4.media.TransportMediator;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v7.appcompat.C0268R;
import java.util.Arrays;

/* renamed from: com.a.a.a.b.b */
public final class CharTypes {
    static final int[] f413a;
    static final int[] f414b;
    static final int[] f415c;
    static final int[] f416d;
    static final int[] f417e;
    static final int[] f418f;
    static final int[] f419g;
    private static final char[] f420h;
    private static final byte[] f421i;

    static {
        int i;
        f420h = "0123456789ABCDEF".toCharArray();
        int length = f420h.length;
        f421i = new byte[length];
        for (i = 0; i < length; i++) {
            f421i[i] = (byte) f420h[i];
        }
        int[] iArr = new int[AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY];
        for (i = 0; i < 32; i++) {
            iArr[i] = -1;
        }
        iArr[34] = 1;
        iArr[92] = 1;
        f413a = iArr;
        Object obj = new int[f413a.length];
        System.arraycopy(f413a, 0, obj, 0, f413a.length);
        for (length = AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS; length < AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY; length++) {
            i = (length & 224) == 192 ? 2 : (length & 240) == 224 ? 3 : (length & 248) == 240 ? 4 : -1;
            obj[length] = i;
        }
        f414b = obj;
        iArr = new int[AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY];
        Arrays.fill(iArr, -1);
        for (i = 33; i < AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY; i++) {
            if (Character.isJavaIdentifierPart((char) i)) {
                iArr[i] = 0;
            }
        }
        iArr[64] = 0;
        iArr[35] = 0;
        iArr[42] = 0;
        iArr[45] = 0;
        iArr[43] = 0;
        f415c = iArr;
        Object obj2 = new int[AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY];
        System.arraycopy(f415c, 0, obj2, 0, f415c.length);
        Arrays.fill(obj2, AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS, AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS, 0);
        f416d = obj2;
        f417e = new int[AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY];
        System.arraycopy(f414b, AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS, f417e, AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS, AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS);
        Arrays.fill(f417e, 0, 32, -1);
        f417e[9] = 0;
        f417e[10] = 10;
        f417e[13] = 13;
        f417e[42] = 42;
        iArr = new int[AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS];
        for (i = 0; i < 32; i++) {
            iArr[i] = -1;
        }
        iArr[34] = 34;
        iArr[92] = 92;
        iArr[8] = 98;
        iArr[9] = 116;
        iArr[12] = C0268R.styleable.AppCompatTheme_buttonStyle;
        iArr[10] = C0268R.styleable.AppCompatTheme_ratingBarStyleSmall;
        iArr[13] = C0268R.styleable.AppCompatTheme_listMenuViewStyle;
        f418f = iArr;
        f419g = new int[AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS];
        Arrays.fill(f419g, -1);
        for (i = 0; i < 10; i++) {
            f419g[i + 48] = i;
        }
        for (i = 0; i < 6; i++) {
            f419g[i + 97] = i + 10;
            f419g[i + 65] = i + 10;
        }
    }

    public static int[] m556a() {
        return f413a;
    }

    public static int[] m557b() {
        return f414b;
    }

    public static int[] m558c() {
        return f415c;
    }

    public static int[] m559d() {
        return f416d;
    }

    public static int[] m560e() {
        return f417e;
    }

    public static int[] m561f() {
        return f418f;
    }

    public static int m554a(int i) {
        return i > TransportMediator.KEYCODE_MEDIA_PAUSE ? -1 : f419g[i];
    }

    public static void m555a(StringBuilder stringBuilder, String str) {
        int[] iArr = f418f;
        char length = iArr.length;
        int length2 = str.length();
        for (int i = 0; i < length2; i++) {
            char charAt = str.charAt(i);
            if (charAt >= length || iArr[charAt] == 0) {
                stringBuilder.append(charAt);
            } else {
                stringBuilder.append('\\');
                int i2 = iArr[charAt];
                if (i2 < 0) {
                    stringBuilder.append('u');
                    stringBuilder.append('0');
                    stringBuilder.append('0');
                    i2 = -(i2 + 1);
                    stringBuilder.append(f420h[i2 >> 4]);
                    stringBuilder.append(f420h[i2 & 15]);
                } else {
                    stringBuilder.append((char) i2);
                }
            }
        }
    }

    public static char[] m562g() {
        return (char[]) f420h.clone();
    }

    public static byte[] m563h() {
        return (byte[]) f421i.clone();
    }
}
