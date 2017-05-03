package com.facebook.ads.internal.view.p038c.p042b;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.view.View;
import com.facebook.ads.internal.view.C0827j;
import com.facebook.ads.internal.view.p038c.p039a.C0739b;
import com.facebook.ads.internal.view.p038c.p039a.C0740c;
import com.facebook.ads.internal.view.p038c.p039a.C0750n;
import com.facebook.ads.internal.view.p038c.p039a.C0751o;

/* renamed from: com.facebook.ads.internal.view.c.b.n */
public class C0807n extends View implements C0764l {
    private final Paint f1926a;
    private final Rect f1927b;
    private float f1928c;
    private final C0751o f1929d;
    private final C0740c f1930e;
    @Nullable
    private C0827j f1931f;

    /* renamed from: com.facebook.ads.internal.view.c.b.n.1 */
    class C08051 extends C0751o {
        final /* synthetic */ C0807n f1924a;

        C08051(C0807n c0807n) {
            this.f1924a = c0807n;
        }

        public void m2461a(C0750n c0750n) {
            if (this.f1924a.f1931f != null) {
                int duration = this.f1924a.f1931f.getDuration();
                if (duration > 0) {
                    this.f1924a.f1928c = ((float) this.f1924a.f1931f.getCurrentPosition()) / ((float) duration);
                } else {
                    this.f1924a.f1928c = 0.0f;
                }
                this.f1924a.postInvalidate();
            }
        }
    }

    /* renamed from: com.facebook.ads.internal.view.c.b.n.2 */
    class C08062 extends C0740c {
        final /* synthetic */ C0807n f1925a;

        C08062(C0807n c0807n) {
            this.f1925a = c0807n;
        }

        public void m2463a(C0739b c0739b) {
            if (this.f1925a.f1931f != null) {
                this.f1925a.f1928c = 0.0f;
                this.f1925a.postInvalidate();
            }
        }
    }

    public C0807n(Context context) {
        super(context);
        this.f1929d = new C08051(this);
        this.f1930e = new C08062(this);
        this.f1926a = new Paint();
        this.f1926a.setStyle(Style.FILL);
        this.f1926a.setColor(-9528840);
        this.f1927b = new Rect();
    }

    public void m2466a(C0827j c0827j) {
        this.f1931f = c0827j;
        c0827j.getEventBus().m1846a(this.f1929d);
        c0827j.getEventBus().m1846a(this.f1930e);
    }

    public void draw(Canvas canvas) {
        this.f1927b.set(0, 0, (int) (((float) getWidth()) * this.f1928c), getHeight());
        canvas.drawRect(this.f1927b, this.f1926a);
        super.draw(canvas);
    }
}
