package com.facebook.ads.internal.view;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.widget.ImageView;
import android.widget.LinearLayout;

/* renamed from: com.facebook.ads.internal.view.d */
public class C0818d extends LinearLayout {
    private Bitmap f1983a;
    private Bitmap f1984b;
    private ImageView f1985c;
    private ImageView f1986d;
    private ImageView f1987e;
    private Bitmap f1988f;
    private Bitmap f1989g;
    private int f1990h;
    private int f1991i;
    private int f1992j;
    private int f1993k;
    private int f1994l;
    private int f1995m;
    private double f1996n;
    private double f1997o;

    private int m2501a(double d) {
        return (int) Math.round(((double) getWidth()) / d);
    }

    private void m2502a() {
        if (getHeight() > 0 && getWidth() > 0) {
            this.f1997o = ((double) getMeasuredWidth()) / ((double) getMeasuredHeight());
            this.f1996n = ((double) this.f1983a.getWidth()) / ((double) this.f1983a.getHeight());
            if (this.f1996n > this.f1997o) {
                m2504b();
            } else {
                m2505c();
            }
        }
    }

    private int m2503b(double d) {
        return (int) Math.round(((double) getHeight()) * d);
    }

    private void m2504b() {
        this.f1992j = m2501a(this.f1996n);
        this.f1993k = getWidth();
        this.f1990h = (int) Math.ceil((double) (((float) (getHeight() - this.f1992j)) / 2.0f));
        if (this.f1984b != null) {
            Matrix matrix = new Matrix();
            matrix.preScale(1.0f, -1.0f);
            this.f1991i = (int) Math.floor((double) (((float) (getHeight() - this.f1992j)) / 2.0f));
            float height = ((float) this.f1983a.getHeight()) / ((float) this.f1992j);
            int min = Math.min(Math.round(((float) this.f1990h) * height), this.f1984b.getHeight());
            if (min > 0) {
                this.f1988f = Bitmap.createBitmap(this.f1984b, 0, 0, this.f1984b.getWidth(), min, matrix, true);
                this.f1985c.setImageBitmap(this.f1988f);
            }
            min = Math.min(Math.round(((float) this.f1991i) * height), this.f1984b.getHeight());
            if (min > 0) {
                this.f1989g = Bitmap.createBitmap(this.f1984b, 0, this.f1984b.getHeight() - min, this.f1984b.getWidth(), min, matrix, true);
                this.f1987e.setImageBitmap(this.f1989g);
            }
        }
    }

    private void m2505c() {
        this.f1993k = m2503b(this.f1996n);
        this.f1992j = getHeight();
        this.f1994l = (int) Math.ceil((double) (((float) (getWidth() - this.f1993k)) / 2.0f));
        if (this.f1984b != null) {
            Matrix matrix = new Matrix();
            matrix.preScale(-1.0f, 1.0f);
            this.f1995m = (int) Math.floor((double) (((float) (getWidth() - this.f1993k)) / 2.0f));
            float width = ((float) this.f1983a.getWidth()) / ((float) this.f1993k);
            int min = Math.min(Math.round(((float) this.f1994l) * width), this.f1984b.getWidth());
            if (min > 0) {
                this.f1988f = Bitmap.createBitmap(this.f1984b, 0, 0, min, this.f1984b.getHeight(), matrix, true);
                this.f1985c.setImageBitmap(this.f1988f);
            }
            int min2 = Math.min(Math.round(((float) this.f1995m) * width), this.f1984b.getWidth());
            if (min2 > 0) {
                this.f1989g = Bitmap.createBitmap(this.f1984b, this.f1984b.getWidth() - min2, 0, min2, this.f1984b.getHeight(), matrix, true);
                this.f1987e.setImageBitmap(this.f1989g);
            }
        }
    }

    private boolean m2506d() {
        return ((this.f1990h + this.f1992j) + this.f1991i == getMeasuredHeight() && (this.f1994l + this.f1993k) + this.f1995m == getMeasuredWidth()) ? false : true;
    }

    public void m2507a(Bitmap bitmap, Bitmap bitmap2) {
        if (bitmap2 == null) {
            this.f1985c.setImageDrawable(null);
            this.f1987e.setImageDrawable(null);
        }
        if (bitmap == null) {
            this.f1986d.setImageDrawable(null);
            return;
        }
        this.f1986d.setImageBitmap(Bitmap.createBitmap(bitmap));
        this.f1983a = bitmap;
        this.f1984b = bitmap2;
        m2502a();
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.f1983a == null) {
            super.onLayout(z, i, i2, i3, i4);
            return;
        }
        m2501a(this.f1996n);
        m2503b(this.f1996n);
        if (this.f1988f == null || m2506d()) {
            m2502a();
        }
        if (this.f1996n > this.f1997o) {
            this.f1985c.layout(i, i2, i3, this.f1990h);
            this.f1986d.layout(i, this.f1990h + i2, i3, this.f1990h + this.f1992j);
            this.f1987e.layout(i, (this.f1990h + i2) + this.f1992j, i3, i4);
            return;
        }
        this.f1985c.layout(i, i2, this.f1994l, i4);
        this.f1986d.layout(this.f1994l + i, i2, this.f1994l + this.f1993k, i4);
        this.f1987e.layout((this.f1994l + i) + this.f1993k, i2, i3, i4);
    }
}
