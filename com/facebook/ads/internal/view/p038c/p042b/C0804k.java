package com.facebook.ads.internal.view.p038c.p042b;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Build.VERSION;
import android.widget.Button;

/* renamed from: com.facebook.ads.internal.view.c.b.k */
public class C0804k extends Button {
    private final Path f1919a;
    private final Path f1920b;
    private final Paint f1921c;
    private final Path f1922d;
    private boolean f1923e;

    /* renamed from: com.facebook.ads.internal.view.c.b.k.1 */
    class C08031 extends Paint {
        final /* synthetic */ C0804k f1918a;

        C08031(C0804k c0804k) {
            this.f1918a = c0804k;
            setStyle(Style.FILL_AND_STROKE);
            setStrokeCap(Cap.ROUND);
            setStrokeWidth(3.0f);
            setAntiAlias(true);
            setColor(-1);
        }
    }

    public C0804k(Context context) {
        super(context);
        this.f1923e = false;
        this.f1919a = new Path();
        this.f1920b = new Path();
        this.f1922d = new Path();
        this.f1921c = new C08031(this);
        setClickable(true);
        setBackgroundColor(0);
    }

    protected void onDraw(Canvas canvas) {
        if (canvas.isHardwareAccelerated() && VERSION.SDK_INT < 17) {
            setLayerType(1, null);
        }
        float max = ((float) Math.max(canvas.getWidth(), canvas.getHeight())) / 100.0f;
        if (this.f1923e) {
            this.f1922d.rewind();
            this.f1922d.moveTo(26.5f * max, 15.5f * max);
            this.f1922d.lineTo(26.5f * max, 84.5f * max);
            this.f1922d.lineTo(82.5f * max, 50.5f * max);
            this.f1922d.lineTo(26.5f * max, max * 15.5f);
            this.f1922d.close();
            canvas.drawPath(this.f1922d, this.f1921c);
        } else {
            this.f1919a.rewind();
            this.f1919a.moveTo(29.0f * max, 21.0f * max);
            this.f1919a.lineTo(29.0f * max, 79.0f * max);
            this.f1919a.lineTo(45.0f * max, 79.0f * max);
            this.f1919a.lineTo(45.0f * max, 21.0f * max);
            this.f1919a.lineTo(29.0f * max, 21.0f * max);
            this.f1919a.close();
            this.f1920b.rewind();
            this.f1920b.moveTo(55.0f * max, 21.0f * max);
            this.f1920b.lineTo(55.0f * max, 79.0f * max);
            this.f1920b.lineTo(71.0f * max, 79.0f * max);
            this.f1920b.lineTo(71.0f * max, 21.0f * max);
            this.f1920b.lineTo(55.0f * max, max * 21.0f);
            this.f1920b.close();
            canvas.drawPath(this.f1919a, this.f1921c);
            canvas.drawPath(this.f1920b, this.f1921c);
        }
        super.onDraw(canvas);
    }

    public void setChecked(boolean z) {
        this.f1923e = z;
        refreshDrawableState();
        invalidate();
    }
}
