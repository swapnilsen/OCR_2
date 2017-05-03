package com.facebook.ads.internal.view.p040a;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.support.v4.view.MotionEventCompat;
import android.util.AttributeSet;
import android.widget.ProgressBar;

@TargetApi(19)
/* renamed from: com.facebook.ads.internal.view.a.b */
public class C0724b extends ProgressBar {
    private static final int f1778a;
    private static final int f1779b;
    private Rect f1780c;
    private Paint f1781d;

    static {
        f1778a = Color.argb(26, 0, 0, 0);
        f1779b = Color.rgb(88, 144, MotionEventCompat.ACTION_MASK);
    }

    public C0724b(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m2339a();
    }

    private void m2339a() {
        setIndeterminate(false);
        setMax(100);
        setProgressDrawable(m2340b());
        this.f1780c = new Rect();
        this.f1781d = new Paint();
        this.f1781d.setStyle(Style.FILL);
        this.f1781d.setColor(f1778a);
    }

    private Drawable m2340b() {
        ColorDrawable colorDrawable = new ColorDrawable(0);
        ClipDrawable clipDrawable = new ClipDrawable(new ColorDrawable(f1779b), 3, 1);
        return new LayerDrawable(new Drawable[]{colorDrawable, clipDrawable});
    }

    protected synchronized void onDraw(Canvas canvas) {
        canvas.drawRect(this.f1780c, this.f1781d);
        super.onDraw(canvas);
    }

    protected synchronized void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.f1780c.set(0, 0, getMeasuredWidth(), 2);
    }

    public synchronized void setProgress(int i) {
        super.setProgress(i == 100 ? 0 : Math.max(i, 5));
    }
}
