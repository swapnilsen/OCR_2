package com.facebook.ads.internal.view.p038c.p042b;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.support.v4.view.PointerIconCompat;
import android.view.View;
import com.facebook.ads.internal.view.C0827j;
import com.facebook.ads.internal.view.p038c.p039a.C0739b;
import com.facebook.ads.internal.view.p038c.p039a.C0740c;
import com.facebook.ads.internal.view.p038c.p039a.C0750n;
import com.facebook.ads.internal.view.p038c.p039a.C0751o;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.facebook.ads.internal.view.c.b.h */
public class C0795h extends View implements C0764l {
    private final Paint f1895a;
    private final Paint f1896b;
    private final Paint f1897c;
    private final RectF f1898d;
    private C0827j f1899e;
    private int f1900f;
    private final AtomicInteger f1901g;
    private final C0751o f1902h;
    private final C0740c f1903i;

    /* renamed from: com.facebook.ads.internal.view.c.b.h.1 */
    class C07931 extends C0751o {
        final /* synthetic */ C0795h f1893a;

        C07931(C0795h c0795h) {
            this.f1893a = c0795h;
        }

        public void m2441a(C0750n c0750n) {
            this.f1893a.f1901g.set((this.f1893a.f1900f * PointerIconCompat.TYPE_DEFAULT) - this.f1893a.f1899e.getCurrentPosition());
            this.f1893a.postInvalidate();
        }
    }

    /* renamed from: com.facebook.ads.internal.view.c.b.h.2 */
    class C07942 extends C0740c {
        final /* synthetic */ C0795h f1894a;

        C07942(C0795h c0795h) {
            this.f1894a = c0795h;
        }

        public void m2443a(C0739b c0739b) {
            this.f1894a.f1900f = 0;
        }
    }

    public C0795h(Context context, int i, int i2) {
        super(context);
        this.f1901g = new AtomicInteger(0);
        this.f1902h = new C07931(this);
        this.f1903i = new C07942(this);
        float f = getResources().getDisplayMetrics().density;
        this.f1900f = i;
        this.f1895a = new Paint();
        this.f1895a.setStyle(Style.FILL);
        this.f1895a.setColor(i2);
        this.f1896b = new Paint();
        this.f1896b.setColor(-3355444);
        this.f1896b.setStyle(Style.FILL);
        this.f1896b.setStrokeWidth(1.0f * f);
        this.f1896b.setAntiAlias(true);
        this.f1897c = new Paint();
        this.f1897c.setColor(-10066330);
        this.f1897c.setStyle(Style.STROKE);
        this.f1897c.setStrokeWidth(f * 2.0f);
        this.f1897c.setAntiAlias(true);
        this.f1898d = new RectF();
    }

    public void m2448a(C0827j c0827j) {
        this.f1899e = c0827j;
        this.f1899e.getEventBus().m1846a(this.f1902h);
        this.f1899e.getEventBus().m1846a(this.f1903i);
    }

    public boolean m2449a() {
        return this.f1899e == null ? false : this.f1900f <= 0 || this.f1901g.get() < 0;
    }

    public int getSkipSeconds() {
        return this.f1900f;
    }

    protected void onDraw(Canvas canvas) {
        int min = Math.min((getWidth() - getPaddingLeft()) - getPaddingRight(), (getHeight() - getPaddingTop()) - getPaddingBottom());
        int i = min / 2;
        canvas.drawCircle((float) (getPaddingLeft() + i), (float) ((min / 2) + getPaddingTop()), (float) i, this.f1896b);
        if (this.f1901g.get() <= 0) {
            int i2 = min / 3;
            int i3 = min / 3;
            canvas.drawLine((float) (getPaddingLeft() + i2), (float) (getPaddingTop() + i3), (float) ((i2 * 2) + getPaddingLeft()), (float) ((i3 * 2) + getPaddingTop()), this.f1897c);
            canvas.drawLine((float) ((i2 * 2) + getPaddingLeft()), (float) (getPaddingTop() + i3), (float) (getPaddingLeft() + i2), (float) ((i3 * 2) + getPaddingTop()), this.f1897c);
        } else {
            this.f1898d.set((float) getPaddingLeft(), (float) getPaddingTop(), (float) (getWidth() - getPaddingRight()), (float) (getHeight() - getPaddingBottom()));
            canvas.drawArc(this.f1898d, -90.0f, ((float) (-(this.f1901g.get() * 360))) / ((float) (this.f1900f * PointerIconCompat.TYPE_DEFAULT)), true, this.f1895a);
        }
        super.onDraw(canvas);
    }
}
