package com.facebook.ads.internal.view.p038c.p042b;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.support.v4.view.ViewCompat;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import com.facebook.ads.internal.view.C0827j;
import com.facebook.ads.internal.view.p038c.p039a.C0739b;
import com.facebook.ads.internal.view.p038c.p039a.C0740c;
import com.facebook.ads.internal.view.p038c.p039a.C0745h;
import com.facebook.ads.internal.view.p038c.p039a.C0746i;
import com.facebook.ads.internal.view.p038c.p039a.C0747j;
import com.facebook.ads.internal.view.p038c.p039a.C0748k;
import com.facebook.ads.internal.view.p038c.p043c.C0816d;

/* renamed from: com.facebook.ads.internal.view.c.b.j */
public class C0802j extends C0765m {
    private final C0804k f1912b;
    private final C0746i f1913c;
    private final C0748k f1914d;
    private final C0740c f1915e;
    private final Paint f1916f;
    private final RectF f1917g;

    /* renamed from: com.facebook.ads.internal.view.c.b.j.1 */
    class C07981 extends C0746i {
        final /* synthetic */ C0802j f1907a;

        C07981(C0802j c0802j) {
            this.f1907a = c0802j;
        }

        public void m2454a(C0745h c0745h) {
            this.f1907a.f1912b.setChecked(true);
        }
    }

    /* renamed from: com.facebook.ads.internal.view.c.b.j.2 */
    class C07992 extends C0748k {
        final /* synthetic */ C0802j f1908a;

        C07992(C0802j c0802j) {
            this.f1908a = c0802j;
        }

        public void m2456a(C0747j c0747j) {
            this.f1908a.f1912b.setChecked(false);
        }
    }

    /* renamed from: com.facebook.ads.internal.view.c.b.j.3 */
    class C08003 extends C0740c {
        final /* synthetic */ C0802j f1909a;

        C08003(C0802j c0802j) {
            this.f1909a = c0802j;
        }

        public void m2458a(C0739b c0739b) {
            this.f1909a.f1912b.setChecked(true);
        }
    }

    /* renamed from: com.facebook.ads.internal.view.c.b.j.4 */
    class C08014 implements OnTouchListener {
        final /* synthetic */ C0827j f1910a;
        final /* synthetic */ C0802j f1911b;

        C08014(C0802j c0802j, C0827j c0827j) {
            this.f1911b = c0802j;
            this.f1910a = c0827j;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                return true;
            }
            if (motionEvent.getAction() != 1) {
                return false;
            }
            if (this.f1910a.getState() == C0816d.PREPARED) {
                this.f1910a.m2553d();
                return true;
            } else if (this.f1910a.getState() == C0816d.IDLE) {
                this.f1910a.m2553d();
                return true;
            } else if (this.f1910a.getState() == C0816d.PAUSED) {
                this.f1910a.m2553d();
                return true;
            } else if (this.f1910a.getState() == C0816d.STARTED) {
                this.f1910a.m2554e();
                return true;
            } else if (this.f1910a.getState() != C0816d.PLAYBACK_COMPLETED) {
                return false;
            } else {
                this.f1910a.m2553d();
                return true;
            }
        }
    }

    public C0802j(Context context) {
        super(context);
        this.f1913c = new C07981(this);
        this.f1914d = new C07992(this);
        this.f1915e = new C08003(this);
        this.f1912b = new C0804k(context);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (displayMetrics.density * 50.0f), (int) (displayMetrics.density * 50.0f));
        layoutParams.addRule(13);
        this.f1912b.setLayoutParams(layoutParams);
        this.f1912b.setChecked(true);
        this.f1916f = new Paint();
        this.f1916f.setStyle(Style.FILL);
        this.f1916f.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.f1916f.setAlpha(119);
        this.f1917g = new RectF();
        setBackgroundColor(0);
        addView(this.f1912b);
        setGravity(17);
        layoutParams = new RelativeLayout.LayoutParams((int) (((double) displayMetrics.density) * 75.0d), (int) (((double) displayMetrics.density) * 75.0d));
        layoutParams.addRule(13);
        setLayoutParams(layoutParams);
    }

    protected void a_(C0827j c0827j) {
        c0827j.getEventBus().m1846a(this.f1913c);
        c0827j.getEventBus().m1846a(this.f1914d);
        c0827j.getEventBus().m1846a(this.f1915e);
        this.f1912b.setOnTouchListener(new C08014(this, c0827j));
        super.a_(c0827j);
    }

    protected void onDraw(Canvas canvas) {
        float f = getContext().getResources().getDisplayMetrics().density;
        this.f1917g.set(0.0f, 0.0f, (float) getWidth(), (float) getHeight());
        canvas.drawRoundRect(this.f1917g, 5.0f * f, f * 5.0f, this.f1916f);
        super.onDraw(canvas);
    }
}
