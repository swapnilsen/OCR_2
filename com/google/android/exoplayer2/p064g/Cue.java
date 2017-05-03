package com.google.android.exoplayer2.p064g;

import android.text.Layout.Alignment;

/* renamed from: com.google.android.exoplayer2.g.b */
public class Cue {
    public final CharSequence f3444a;
    public final Alignment f3445b;
    public final float f3446c;
    public final int f3447d;
    public final int f3448e;
    public final float f3449f;
    public final int f3450g;
    public final float f3451h;

    public Cue(CharSequence charSequence) {
        this(charSequence, null, Float.MIN_VALUE, RtlSpacingHelper.UNDEFINED, RtlSpacingHelper.UNDEFINED, Float.MIN_VALUE, RtlSpacingHelper.UNDEFINED, Float.MIN_VALUE);
    }

    public Cue(CharSequence charSequence, Alignment alignment, float f, int i, int i2, float f2, int i3, float f3) {
        this.f3444a = charSequence;
        this.f3445b = alignment;
        this.f3446c = f;
        this.f3447d = i;
        this.f3448e = i2;
        this.f3449f = f2;
        this.f3450g = i3;
        this.f3451h = f3;
    }
}
