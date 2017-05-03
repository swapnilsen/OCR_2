package com.google.android.exoplayer2.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.CaptioningManager;
import com.google.android.exoplayer2.p064g.CaptionStyleCompat;
import com.google.android.exoplayer2.p064g.Cue;
import com.google.android.exoplayer2.p064g.TextRenderer.TextRenderer;
import java.util.ArrayList;
import java.util.List;

public final class SubtitleView extends View implements TextRenderer {
    private final List<SubtitlePainter> f4001a;
    private List<Cue> f4002b;
    private int f4003c;
    private float f4004d;
    private boolean f4005e;
    private CaptionStyleCompat f4006f;
    private float f4007g;

    public SubtitleView(Context context) {
        this(context, null);
    }

    public SubtitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4001a = new ArrayList();
        this.f4003c = 0;
        this.f4004d = 0.0533f;
        this.f4005e = true;
        this.f4006f = CaptionStyleCompat.f3431a;
        this.f4007g = 0.08f;
    }

    public void m4704a(List<Cue> list) {
        setCues(list);
    }

    public void setCues(List<Cue> list) {
        if (this.f4002b != list) {
            this.f4002b = list;
            int size = list == null ? 0 : list.size();
            while (this.f4001a.size() < size) {
                this.f4001a.add(new SubtitlePainter(getContext()));
            }
            invalidate();
        }
    }

    public void setFractionalTextSize(float f) {
        m4703a(f, false);
    }

    public void m4703a(float f, boolean z) {
        m4702a(z ? 1 : 0, f);
    }

    private void m4702a(int i, float f) {
        if (this.f4003c != i || this.f4004d != f) {
            this.f4003c = i;
            this.f4004d = f;
            invalidate();
        }
    }

    public void setApplyEmbeddedStyles(boolean z) {
        if (this.f4005e != z) {
            this.f4005e = z;
            invalidate();
        }
    }

    public void setStyle(CaptionStyleCompat captionStyleCompat) {
        if (this.f4006f != captionStyleCompat) {
            this.f4006f = captionStyleCompat;
            invalidate();
        }
    }

    public void setBottomPaddingFraction(float f) {
        if (this.f4007g != f) {
            this.f4007g = f;
            invalidate();
        }
    }

    public void dispatchDraw(Canvas canvas) {
        int i;
        if (this.f4002b == null) {
            i = 0;
        } else {
            i = this.f4002b.size();
        }
        int top = getTop();
        int bottom = getBottom();
        int left = getLeft() + getPaddingLeft();
        int paddingTop = top + getPaddingTop();
        int right = getRight() + getPaddingRight();
        int paddingBottom = bottom - getPaddingBottom();
        if (paddingBottom > paddingTop && right > left) {
            float f;
            if (this.f4003c == 2) {
                f = this.f4004d;
            } else {
                f = this.f4004d * ((float) (this.f4003c == 0 ? paddingBottom - paddingTop : bottom - top));
            }
            if (f > 0.0f) {
                for (int i2 = 0; i2 < i; i2++) {
                    ((SubtitlePainter) this.f4001a.get(i2)).m4707a((Cue) this.f4002b.get(i2), this.f4005e, this.f4006f, f, this.f4007g, canvas, left, paddingTop, right, paddingBottom);
                }
            }
        }
    }

    @TargetApi(19)
    private float getUserCaptionFontScaleV19() {
        return ((CaptioningManager) getContext().getSystemService("captioning")).getFontScale();
    }

    @TargetApi(19)
    private CaptionStyleCompat getUserCaptionStyleV19() {
        return CaptionStyleCompat.m4017a(((CaptioningManager) getContext().getSystemService("captioning")).getUserStyle());
    }
}
