package com.google.android.exoplayer2.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.exoplayer2.p050j.Util;
import com.google.android.exoplayer2.p064g.CaptionStyleCompat;
import com.google.android.exoplayer2.p064g.Cue;

/* renamed from: com.google.android.exoplayer2.ui.a */
final class SubtitlePainter {
    private int f4008A;
    private int f4009B;
    private int f4010C;
    private StaticLayout f4011D;
    private int f4012E;
    private int f4013F;
    private int f4014G;
    private final RectF f4015a;
    private final float f4016b;
    private final float f4017c;
    private final float f4018d;
    private final float f4019e;
    private final float f4020f;
    private final float f4021g;
    private final TextPaint f4022h;
    private final Paint f4023i;
    private CharSequence f4024j;
    private Alignment f4025k;
    private float f4026l;
    private int f4027m;
    private int f4028n;
    private float f4029o;
    private int f4030p;
    private float f4031q;
    private boolean f4032r;
    private int f4033s;
    private int f4034t;
    private int f4035u;
    private int f4036v;
    private int f4037w;
    private float f4038x;
    private float f4039y;
    private int f4040z;

    public SubtitlePainter(Context context) {
        this.f4015a = new RectF();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, new int[]{16843287, 16843288}, 0, 0);
        this.f4021g = (float) obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.f4020f = obtainStyledAttributes.getFloat(1, 1.0f);
        obtainStyledAttributes.recycle();
        int round = Math.round((((float) context.getResources().getDisplayMetrics().densityDpi) * 2.0f) / 160.0f);
        this.f4016b = (float) round;
        this.f4017c = (float) round;
        this.f4018d = (float) round;
        this.f4019e = (float) round;
        this.f4022h = new TextPaint();
        this.f4022h.setAntiAlias(true);
        this.f4022h.setSubpixelText(true);
        this.f4023i = new Paint();
        this.f4023i.setAntiAlias(true);
        this.f4023i.setStyle(Style.FILL);
    }

    public void m4707a(Cue cue, boolean z, CaptionStyleCompat captionStyleCompat, float f, float f2, Canvas canvas, int i, int i2, int i3, int i4) {
        CharSequence charSequence = cue.f3444a;
        if (!TextUtils.isEmpty(charSequence)) {
            if (!z) {
                charSequence = charSequence.toString();
            }
            if (SubtitlePainter.m4706a(this.f4024j, charSequence) && Util.m4517a(this.f4025k, cue.f3445b) && this.f4026l == cue.f3446c && this.f4027m == cue.f3447d && Util.m4517a(Integer.valueOf(this.f4028n), Integer.valueOf(cue.f3448e)) && this.f4029o == cue.f3449f && Util.m4517a(Integer.valueOf(this.f4030p), Integer.valueOf(cue.f3450g)) && this.f4031q == cue.f3451h && this.f4032r == z && this.f4033s == captionStyleCompat.f3432b && this.f4034t == captionStyleCompat.f3433c && this.f4035u == captionStyleCompat.f3434d && this.f4037w == captionStyleCompat.f3435e && this.f4036v == captionStyleCompat.f3436f && Util.m4517a(this.f4022h.getTypeface(), captionStyleCompat.f3437g) && this.f4038x == f && this.f4039y == f2 && this.f4040z == i && this.f4008A == i2 && this.f4009B == i3 && this.f4010C == i4) {
                m4705a(canvas);
                return;
            }
            this.f4024j = charSequence;
            this.f4025k = cue.f3445b;
            this.f4026l = cue.f3446c;
            this.f4027m = cue.f3447d;
            this.f4028n = cue.f3448e;
            this.f4029o = cue.f3449f;
            this.f4030p = cue.f3450g;
            this.f4031q = cue.f3451h;
            this.f4032r = z;
            this.f4033s = captionStyleCompat.f3432b;
            this.f4034t = captionStyleCompat.f3433c;
            this.f4035u = captionStyleCompat.f3434d;
            this.f4037w = captionStyleCompat.f3435e;
            this.f4036v = captionStyleCompat.f3436f;
            this.f4022h.setTypeface(captionStyleCompat.f3437g);
            this.f4038x = f;
            this.f4039y = f2;
            this.f4040z = i;
            this.f4008A = i2;
            this.f4009B = i3;
            this.f4010C = i4;
            int i5 = this.f4009B - this.f4040z;
            int i6 = this.f4010C - this.f4008A;
            this.f4022h.setTextSize(f);
            int i7 = (int) ((0.125f * f) + 0.5f);
            int i8 = i5 - (i7 * 2);
            if (this.f4031q != Float.MIN_VALUE) {
                i8 = (int) (((float) i8) * this.f4031q);
            }
            if (i8 <= 0) {
                Log.w("SubtitlePainter", "Skipped drawing subtitle cue (insufficient space)");
                return;
            }
            Alignment alignment = this.f4025k == null ? Alignment.ALIGN_CENTER : this.f4025k;
            this.f4011D = new StaticLayout(charSequence, this.f4022h, i8, alignment, this.f4020f, this.f4021g, true);
            int height = this.f4011D.getHeight();
            int lineCount = this.f4011D.getLineCount();
            int i9 = 0;
            int i10 = 0;
            while (i10 < lineCount) {
                int max = Math.max((int) Math.ceil((double) this.f4011D.getLineWidth(i10)), i9);
                i10++;
                i9 = max;
            }
            if (this.f4031q == Float.MIN_VALUE || i9 >= i8) {
                i8 = i9;
            }
            i8 += i7 * 2;
            if (this.f4029o != Float.MIN_VALUE) {
                i9 = Math.round(((float) i5) * this.f4029o) + this.f4040z;
                if (this.f4030p == 2) {
                    i9 -= i8;
                } else if (this.f4030p == 1) {
                    i9 = ((i9 * 2) - i8) / 2;
                }
                i10 = Math.max(i9, this.f4040z);
                i9 = Math.min(i10 + i8, this.f4009B);
                i5 = i10;
            } else {
                i10 = (i5 - i8) / 2;
                i9 = i10 + i8;
                i5 = i10;
            }
            if (this.f4026l != Float.MIN_VALUE) {
                if (this.f4027m == 0) {
                    i10 = Math.round(((float) i6) * this.f4026l) + this.f4008A;
                } else {
                    i10 = this.f4011D.getLineBottom(0) - this.f4011D.getLineTop(0);
                    if (this.f4026l >= 0.0f) {
                        i10 = Math.round(((float) i10) * this.f4026l) + this.f4008A;
                    } else {
                        i10 = Math.round(((float) i10) * this.f4026l) + this.f4010C;
                    }
                }
                if (this.f4028n == 2) {
                    i10 -= height;
                } else if (this.f4028n == 1) {
                    i10 = ((i10 * 2) - height) / 2;
                }
                if (i10 + height > this.f4010C) {
                    i10 = this.f4010C - height;
                } else if (i10 < this.f4008A) {
                    i10 = this.f4008A;
                }
                i6 = i10;
            } else {
                i6 = (this.f4010C - height) - ((int) (((float) i6) * f2));
            }
            this.f4011D = new StaticLayout(charSequence, this.f4022h, i9 - i5, alignment, this.f4020f, this.f4021g, true);
            this.f4012E = i5;
            this.f4013F = i6;
            this.f4014G = i7;
            m4705a(canvas);
        }
    }

    private void m4705a(Canvas canvas) {
        StaticLayout staticLayout = this.f4011D;
        if (staticLayout != null) {
            int lineCount;
            int i;
            int save = canvas.save();
            canvas.translate((float) this.f4012E, (float) this.f4013F);
            if (Color.alpha(this.f4035u) > 0) {
                this.f4023i.setColor(this.f4035u);
                canvas.drawRect((float) (-this.f4014G), 0.0f, (float) (staticLayout.getWidth() + this.f4014G), (float) staticLayout.getHeight(), this.f4023i);
            }
            if (Color.alpha(this.f4034t) > 0) {
                this.f4023i.setColor(this.f4034t);
                float lineTop = (float) staticLayout.getLineTop(0);
                lineCount = staticLayout.getLineCount();
                float f = lineTop;
                for (i = 0; i < lineCount; i++) {
                    this.f4015a.left = staticLayout.getLineLeft(i) - ((float) this.f4014G);
                    this.f4015a.right = staticLayout.getLineRight(i) + ((float) this.f4014G);
                    this.f4015a.top = f;
                    this.f4015a.bottom = (float) staticLayout.getLineBottom(i);
                    f = this.f4015a.bottom;
                    canvas.drawRoundRect(this.f4015a, this.f4016b, this.f4016b, this.f4023i);
                }
            }
            if (this.f4037w == 1) {
                this.f4022h.setStrokeJoin(Join.ROUND);
                this.f4022h.setStrokeWidth(this.f4017c);
                this.f4022h.setColor(this.f4036v);
                this.f4022h.setStyle(Style.FILL_AND_STROKE);
                staticLayout.draw(canvas);
            } else if (this.f4037w == 2) {
                this.f4022h.setShadowLayer(this.f4018d, this.f4019e, this.f4019e, this.f4036v);
            } else if (this.f4037w == 3 || this.f4037w == 4) {
                lineCount = this.f4037w == 3 ? 1 : 0;
                int i2 = lineCount != 0 ? -1 : this.f4036v;
                if (lineCount != 0) {
                    i = this.f4036v;
                } else {
                    i = -1;
                }
                float f2 = this.f4018d / 2.0f;
                this.f4022h.setColor(this.f4033s);
                this.f4022h.setStyle(Style.FILL);
                this.f4022h.setShadowLayer(this.f4018d, -f2, -f2, i2);
                staticLayout.draw(canvas);
                this.f4022h.setShadowLayer(this.f4018d, f2, f2, i);
            }
            this.f4022h.setColor(this.f4033s);
            this.f4022h.setStyle(Style.FILL);
            staticLayout.draw(canvas);
            this.f4022h.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
            canvas.restoreToCount(save);
        }
    }

    private static boolean m4706a(CharSequence charSequence, CharSequence charSequence2) {
        return charSequence == charSequence2 || (charSequence != null && charSequence.equals(charSequence2));
    }
}
