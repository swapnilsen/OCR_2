package com.facebook.ads.internal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;

/* renamed from: com.facebook.ads.internal.i */
public class C0595i extends View {
    private Paint f1386a;
    private Paint f1387b;
    private Paint f1388c;
    private int f1389d;
    private boolean f1390e;

    public C0595i(Context context) {
        this(context, 60, true);
    }

    public C0595i(Context context, int i, boolean z) {
        super(context);
        this.f1389d = i;
        this.f1390e = z;
        if (z) {
            this.f1386a = new Paint();
            this.f1386a.setColor(-3355444);
            this.f1386a.setStyle(Style.STROKE);
            this.f1386a.setStrokeWidth(3.0f);
            this.f1386a.setAntiAlias(true);
            this.f1387b = new Paint();
            this.f1387b.setColor(-1287371708);
            this.f1387b.setStyle(Style.FILL);
            this.f1387b.setAntiAlias(true);
            this.f1388c = new Paint();
            this.f1388c.setColor(-1);
            this.f1388c.setStyle(Style.STROKE);
            this.f1388c.setStrokeWidth(6.0f);
            this.f1388c.setAntiAlias(true);
        }
        m1858a();
    }

    private void m1858a() {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (((float) this.f1389d) * displayMetrics.density), (int) (displayMetrics.density * ((float) this.f1389d)));
        layoutParams.addRule(10);
        layoutParams.addRule(11);
        setLayoutParams(layoutParams);
    }

    protected void onDraw(Canvas canvas) {
        if (this.f1390e) {
            if (canvas.isHardwareAccelerated() && VERSION.SDK_INT < 17) {
                setLayerType(1, null);
            }
            int min = Math.min(canvas.getWidth(), canvas.getHeight());
            int i = min / 2;
            int i2 = min / 2;
            int i3 = (i * 2) / 3;
            canvas.drawCircle((float) i, (float) i2, (float) i3, this.f1386a);
            canvas.drawCircle((float) i, (float) i2, (float) (i3 - 2), this.f1387b);
            int i4 = min / 3;
            int i5 = min / 3;
            canvas.drawLine((float) i4, (float) i5, (float) (i4 * 2), (float) (i5 * 2), this.f1388c);
            canvas.drawLine((float) (i4 * 2), (float) i5, (float) i4, (float) (i5 * 2), this.f1388c);
        }
        super.onDraw(canvas);
    }
}
