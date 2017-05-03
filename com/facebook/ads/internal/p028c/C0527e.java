package com.facebook.ads.internal.p028c;

import android.app.Activity;
import android.app.KeyguardManager;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.PowerManager;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Vector;

/* renamed from: com.facebook.ads.internal.c.e */
public class C0527e {
    public static double m1630a(View view, Context context) {
        if (!C0527e.m1634a(context) || !C0527e.m1637d(view)) {
            return 0.0d;
        }
        Rect rect = new Rect();
        if (!view.getGlobalVisibleRect(rect)) {
            return 0.0d;
        }
        Vector a = C0527e.m1633a(view);
        int a2 = C0527e.m1631a(a);
        a.add(rect);
        return (((double) (C0527e.m1631a(a) - a2)) * 1.0d) / ((double) (view.getMeasuredHeight() * view.getMeasuredWidth()));
    }

    private static int m1631a(Vector<Rect> vector) {
        int i;
        int i2;
        int size = vector.size();
        int[] iArr = new int[(size * 2)];
        int[] iArr2 = new int[(size * 2)];
        boolean[][] zArr = (boolean[][]) Array.newInstance(Boolean.TYPE, new int[]{size * 2, size * 2});
        int i3 = 0;
        int i4 = 0;
        for (i = 0; i < size; i++) {
            Rect rect = (Rect) vector.elementAt(i);
            int i5 = i4 + 1;
            iArr[i4] = rect.left;
            int i6 = i3 + 1;
            iArr2[i3] = rect.bottom;
            i4 = i5 + 1;
            iArr[i5] = rect.right;
            i3 = i6 + 1;
            iArr2[i6] = rect.top;
        }
        Arrays.sort(iArr);
        Arrays.sort(iArr2);
        for (i3 = 0; i3 < size; i3++) {
            rect = (Rect) vector.elementAt(i3);
            i = C0527e.m1632a(iArr, rect.left);
            i4 = C0527e.m1632a(iArr, rect.right);
            i5 = C0527e.m1632a(iArr2, rect.top);
            i6 = C0527e.m1632a(iArr2, rect.bottom);
            for (i++; i <= i4; i++) {
                for (i2 = i5 + 1; i2 <= i6; i2++) {
                    zArr[i][i2] = true;
                }
            }
        }
        i4 = 0;
        i2 = 0;
        while (i4 < size * 2) {
            i3 = i2;
            for (i = 0; i < size * 2; i++) {
                i3 += zArr[i4][i] ? (iArr[i4] - iArr[i4 - 1]) * (iArr2[i] - iArr2[i - 1]) : 0;
            }
            i4++;
            i2 = i3;
        }
        return i2;
    }

    private static int m1632a(int[] iArr, int i) {
        int i2 = 0;
        int length = iArr.length;
        while (i2 < length) {
            int i3 = ((length - i2) / 2) + i2;
            if (iArr[i3] == i) {
                return i3;
            }
            if (iArr[i3] > i) {
                length = i2;
            } else {
                int i4 = length;
                length = i3 + 1;
                i3 = i4;
            }
            i2 = length;
            length = i3;
        }
        return -1;
    }

    private static Vector<Rect> m1633a(View view) {
        Vector<Rect> vector = new Vector();
        if (!(view.getParent() instanceof ViewGroup)) {
            return vector;
        }
        View view2 = (ViewGroup) view.getParent();
        for (int indexOfChild = view2.indexOfChild(view) + 1; indexOfChild < view2.getChildCount(); indexOfChild++) {
            vector.addAll(C0527e.m1635b(view2.getChildAt(indexOfChild)));
        }
        vector.addAll(C0527e.m1633a(view2));
        return vector;
    }

    private static boolean m1634a(Context context) {
        if (context == null) {
            return true;
        }
        try {
            if (!((PowerManager) context.getSystemService("power")).isScreenOn()) {
                return false;
            }
            boolean z;
            if (context instanceof Activity) {
                Window window = ((Activity) context).getWindow();
                if (window != null) {
                    int i = window.getAttributes().flags;
                    boolean z2 = ((AccessibilityEventCompat.TYPE_WINDOWS_CHANGED & i) == 0 && (i & AccessibilityNodeInfoCompat.ACTION_COLLAPSE) == 0) ? false : true;
                    z = z2;
                    return ((KeyguardManager) context.getSystemService("keyguard")).inKeyguardRestrictedInputMode() || z;
                }
            }
            z = false;
            if (((KeyguardManager) context.getSystemService("keyguard")).inKeyguardRestrictedInputMode()) {
            }
        } catch (Exception e) {
            return false;
        }
    }

    private static Vector<Rect> m1635b(View view) {
        Vector<Rect> vector = new Vector();
        if (!view.isShown() || (VERSION.SDK_INT >= 11 && view.getAlpha() <= 0.0f)) {
            return vector;
        }
        if ((view instanceof ViewGroup) && C0527e.m1636c(view)) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                vector.addAll(C0527e.m1635b(viewGroup.getChildAt(i)));
            }
            return vector;
        }
        Rect rect = new Rect();
        if (view.getGlobalVisibleRect(rect)) {
            vector.add(rect);
        }
        return vector;
    }

    private static boolean m1636c(View view) {
        return view.getBackground() == null || (VERSION.SDK_INT >= 19 && view.getBackground().getAlpha() <= 0);
    }

    private static boolean m1637d(View view) {
        return (view != null && view.isShown() && view.getWindowVisibility() == 0 && view.getVisibility() == 0 && view.getMeasuredWidth() > 0 && view.getMeasuredHeight() > 0) ? VERSION.SDK_INT < 11 || view.getAlpha() >= 0.9f : false;
    }
}
