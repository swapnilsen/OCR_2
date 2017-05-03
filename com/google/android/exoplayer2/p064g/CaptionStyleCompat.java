package com.google.android.exoplayer2.p064g;

import android.annotation.TargetApi;
import android.graphics.Typeface;
import android.support.v4.view.ViewCompat;
import android.view.accessibility.CaptioningManager.CaptionStyle;
import com.google.android.exoplayer2.p050j.Util;

/* renamed from: com.google.android.exoplayer2.g.a */
public final class CaptionStyleCompat {
    public static final CaptionStyleCompat f3431a;
    public final int f3432b;
    public final int f3433c;
    public final int f3434d;
    public final int f3435e;
    public final int f3436f;
    public final Typeface f3437g;

    static {
        f3431a = new CaptionStyleCompat(-1, ViewCompat.MEASURED_STATE_MASK, 0, 0, -1, null);
    }

    @TargetApi(19)
    public static CaptionStyleCompat m4017a(CaptionStyle captionStyle) {
        if (Util.f3855a >= 21) {
            return CaptionStyleCompat.m4019c(captionStyle);
        }
        return CaptionStyleCompat.m4018b(captionStyle);
    }

    public CaptionStyleCompat(int i, int i2, int i3, int i4, int i5, Typeface typeface) {
        this.f3432b = i;
        this.f3433c = i2;
        this.f3434d = i3;
        this.f3435e = i4;
        this.f3436f = i5;
        this.f3437g = typeface;
    }

    @TargetApi(19)
    private static CaptionStyleCompat m4018b(CaptionStyle captionStyle) {
        return new CaptionStyleCompat(captionStyle.foregroundColor, captionStyle.backgroundColor, 0, captionStyle.edgeType, captionStyle.edgeColor, captionStyle.getTypeface());
    }

    @TargetApi(21)
    private static CaptionStyleCompat m4019c(CaptionStyle captionStyle) {
        return new CaptionStyleCompat(captionStyle.hasForegroundColor() ? captionStyle.foregroundColor : f3431a.f3432b, captionStyle.hasBackgroundColor() ? captionStyle.backgroundColor : f3431a.f3433c, captionStyle.hasWindowColor() ? captionStyle.windowColor : f3431a.f3434d, captionStyle.hasEdgeType() ? captionStyle.edgeType : f3431a.f3435e, captionStyle.hasEdgeColor() ? captionStyle.edgeColor : f3431a.f3436f, captionStyle.getTypeface());
    }
}
