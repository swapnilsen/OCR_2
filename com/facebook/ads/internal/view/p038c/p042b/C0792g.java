package com.facebook.ads.internal.view.p038c.p042b;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.support.v4.view.PointerIconCompat;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.facebook.ads.internal.p025h.C0492s;
import com.facebook.ads.internal.view.C0827j;
import com.facebook.ads.internal.view.p038c.p039a.C0750n;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.facebook.ads.internal.view.c.b.g */
public class C0792g extends C0765m {
    private final C0791a f1887b;
    private final int f1888c;
    private final String f1889d;
    private final String f1890e;
    private final AtomicBoolean f1891f;
    private final C0492s<C0750n> f1892g;

    /* renamed from: com.facebook.ads.internal.view.c.b.g.1 */
    class C07891 extends C0492s<C0750n> {
        final /* synthetic */ C0792g f1881a;

        C07891(C0792g c0792g) {
            this.f1881a = c0792g;
        }

        public Class<C0750n> m2432a() {
            return C0750n.class;
        }

        public void m2434a(C0750n c0750n) {
            if (!this.f1881a.f1891f.get()) {
                int b = this.f1881a.f1888c - (this.f1881a.getVideoView().getCurrentPosition() / PointerIconCompat.TYPE_DEFAULT);
                if (b > 0) {
                    this.f1881a.f1887b.setText(this.f1881a.f1889d + ' ' + b);
                    return;
                }
                this.f1881a.f1887b.setText(this.f1881a.f1890e);
                this.f1881a.f1891f.set(true);
            }
        }
    }

    /* renamed from: com.facebook.ads.internal.view.c.b.g.2 */
    class C07902 implements OnClickListener {
        final /* synthetic */ C0827j f1882a;
        final /* synthetic */ C0792g f1883b;

        C07902(C0792g c0792g, C0827j c0827j) {
            this.f1883b = c0792g;
            this.f1882a = c0827j;
        }

        public void onClick(View view) {
            if (this.f1883b.f1891f.get()) {
                this.f1882a.m2555f();
            } else {
                Log.i("SkipPlugin", "User clicked skip before the ads is allowed to skip.");
            }
        }
    }

    /* renamed from: com.facebook.ads.internal.view.c.b.g.a */
    private static class C0791a extends TextView {
        private final Paint f1884a;
        private final Paint f1885b;
        private final RectF f1886c;

        public C0791a(Context context) {
            super(context);
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            setBackgroundColor(0);
            setTextColor(-3355444);
            setPadding((int) (displayMetrics.density * 9.0f), (int) (displayMetrics.density * 5.0f), (int) (displayMetrics.density * 9.0f), (int) (displayMetrics.density * 5.0f));
            setTextSize(18.0f);
            this.f1884a = new Paint();
            this.f1884a.setStyle(Style.STROKE);
            this.f1884a.setColor(-10066330);
            this.f1884a.setStrokeWidth(1.0f);
            this.f1884a.setAntiAlias(true);
            this.f1885b = new Paint();
            this.f1885b.setStyle(Style.FILL);
            this.f1885b.setColor(-1895825408);
            this.f1886c = new RectF();
        }

        protected void onDraw(Canvas canvas) {
            if (getText().length() != 0) {
                int width = getWidth();
                int height = getHeight();
                this.f1886c.set((float) null, (float) null, (float) width, (float) height);
                canvas.drawRoundRect(this.f1886c, 6.0f, 6.0f, this.f1885b);
                this.f1886c.set((float) 2, (float) 2, (float) (width - 2), (float) (height - 2));
                canvas.drawRoundRect(this.f1886c, 6.0f, 6.0f, this.f1884a);
                super.onDraw(canvas);
            }
        }
    }

    public C0792g(Context context, int i, String str, String str2) {
        super(context);
        this.f1892g = new C07891(this);
        this.f1888c = i;
        this.f1889d = str;
        this.f1890e = str2;
        this.f1891f = new AtomicBoolean(false);
        this.f1887b = new C0791a(context);
        this.f1887b.setText(this.f1889d + ' ' + i);
        addView(this.f1887b, new LayoutParams(-2, -2));
    }

    public void a_(C0827j c0827j) {
        c0827j.getEventBus().m1846a(this.f1892g);
        this.f1887b.setOnClickListener(new C07902(this, c0827j));
    }
}
