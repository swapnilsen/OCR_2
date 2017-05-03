package com.facebook.ads.internal.view.p038c.p042b;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.net.Uri;
import android.support.v4.view.ViewCompat;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.facebook.ads.internal.p021m.C0712u;
import com.facebook.ads.internal.view.C0827j;
import com.facebook.ads.internal.view.p038c.p039a.C0738a;

/* renamed from: com.facebook.ads.internal.view.c.b.e */
public class C0785e extends C0765m {
    private final Context f1870b;
    private final String f1871c;
    private final TextView f1872d;
    private final String f1873e;
    private final Paint f1874f;
    private final RectF f1875g;

    /* renamed from: com.facebook.ads.internal.view.c.b.e.1 */
    class C07841 implements OnClickListener {
        final /* synthetic */ C0827j f1868a;
        final /* synthetic */ C0785e f1869b;

        C07841(C0785e c0785e, C0827j c0827j) {
            this.f1869b = c0785e;
            this.f1868a = c0827j;
        }

        public void onClick(View view) {
            try {
                this.f1868a.getEventBus().m1845a(new C0738a(Uri.parse(this.f1869b.f1871c)));
                C0712u.m2306a(this.f1869b.f1870b, Uri.parse(this.f1869b.f1871c), this.f1869b.f1873e);
            } catch (Throwable e) {
                Log.e("LearnMorePlugin", "Error while opening " + this.f1869b.f1871c, e);
            }
        }
    }

    public C0785e(Context context, String str, String str2, String str3) {
        super(context);
        this.f1870b = context;
        this.f1871c = str;
        this.f1873e = str2;
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        this.f1872d = new TextView(getContext());
        this.f1872d.setTextColor(-3355444);
        this.f1872d.setTextSize(16.0f);
        this.f1872d.setPadding((int) (displayMetrics.density * 6.0f), (int) (displayMetrics.density * 4.0f), (int) (displayMetrics.density * 6.0f), (int) (displayMetrics.density * 4.0f));
        this.f1874f = new Paint();
        this.f1874f.setStyle(Style.FILL);
        this.f1874f.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.f1874f.setAlpha(178);
        this.f1875g = new RectF();
        setBackgroundColor(0);
        this.f1872d.setText(str3);
        addView(this.f1872d, new LayoutParams(-2, -2));
    }

    protected void a_(C0827j c0827j) {
        this.f1872d.setOnClickListener(new C07841(this, c0827j));
    }

    protected void onDraw(Canvas canvas) {
        this.f1875g.set(0.0f, 0.0f, (float) getWidth(), (float) getHeight());
        canvas.drawRoundRect(this.f1875g, 0.0f, 0.0f, this.f1874f);
        super.onDraw(canvas);
    }
}
