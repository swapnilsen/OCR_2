package com.facebook.ads.internal.view.hscroll;

import android.content.Context;
import android.graphics.PointF;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSmoothScroller;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.Recycler;
import android.support.v7.widget.RecyclerView.State;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.MeasureSpec;

public class HScrollLinearLayoutManager extends LinearLayoutManager {
    private final C0835c f2061a;
    private final C0830a f2062b;
    private final Context f2063c;
    private int[] f2064d;
    private int f2065e;
    private float f2066f;
    private C0829a f2067g;
    private int f2068h;

    /* renamed from: com.facebook.ads.internal.view.hscroll.HScrollLinearLayoutManager.a */
    private class C0829a extends LinearSmoothScroller {
        final /* synthetic */ HScrollLinearLayoutManager f2060a;

        public C0829a(HScrollLinearLayoutManager hScrollLinearLayoutManager, Context context) {
            this.f2060a = hScrollLinearLayoutManager;
            super(context);
        }

        public int calculateDxToMakeVisible(View view, int i) {
            LayoutManager layoutManager = getLayoutManager();
            if (!layoutManager.canScrollHorizontally()) {
                return 0;
            }
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            return calculateDtToFit(layoutManager.getDecoratedLeft(view) - layoutParams.leftMargin, layoutManager.getDecoratedRight(view) + layoutParams.rightMargin, layoutManager.getPaddingLeft(), layoutManager.getWidth() - layoutManager.getPaddingRight(), i) + this.f2060a.f2065e;
        }

        protected float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
            return this.f2060a.f2066f / ((float) displayMetrics.densityDpi);
        }

        public PointF computeScrollVectorForPosition(int i) {
            return this.f2060a.computeScrollVectorForPosition(i);
        }

        protected int getHorizontalSnapPreference() {
            return -1;
        }
    }

    public HScrollLinearLayoutManager(Context context, C0835c c0835c, C0830a c0830a) {
        super(context);
        this.f2065e = 0;
        this.f2066f = 50.0f;
        this.f2063c = context;
        this.f2061a = c0835c;
        this.f2062b = c0830a;
        this.f2068h = -1;
        this.f2067g = new C0829a(this, this.f2063c);
    }

    public void m2564a(double d) {
        if (d <= 0.0d) {
            d = 1.0d;
        }
        this.f2066f = (float) (50.0d / d);
        this.f2067g = new C0829a(this, this.f2063c);
    }

    void m2565a(int i) {
        this.f2068h = i;
    }

    public void m2566b(int i) {
        this.f2065e = i;
    }

    public void onMeasure(Recycler recycler, State state, int i, int i2) {
        int mode = MeasureSpec.getMode(i);
        int mode2 = MeasureSpec.getMode(i2);
        if ((mode == 1073741824 && getOrientation() == 1) || (mode2 == 1073741824 && getOrientation() == 0)) {
            super.onMeasure(recycler, state, i, i2);
            return;
        }
        int[] a;
        int size = MeasureSpec.getSize(i);
        int size2 = MeasureSpec.getSize(i2);
        if (this.f2062b.m2569b(this.f2068h)) {
            a = this.f2062b.m2568a(this.f2068h);
        } else {
            a = new int[]{0, 0};
            if (state.getItemCount() >= 1) {
                for (int i3 = 0; i3 < 1; i3++) {
                    this.f2064d = this.f2061a.m2580a(recycler, i3, MeasureSpec.makeMeasureSpec(0, 0), MeasureSpec.makeMeasureSpec(0, 0));
                    if (getOrientation() == 0) {
                        a[0] = a[0] + this.f2064d[0];
                        if (i3 == 0) {
                            a[1] = (this.f2064d[1] + getPaddingTop()) + getPaddingBottom();
                        }
                    } else {
                        a[1] = a[1] + this.f2064d[1];
                        if (i3 == 0) {
                            a[0] = (this.f2064d[0] + getPaddingLeft()) + getPaddingRight();
                        }
                    }
                }
                if (this.f2068h != -1) {
                    this.f2062b.m2567a(this.f2068h, a);
                }
            }
        }
        if (mode == 1073741824) {
            a[0] = size;
        }
        if (mode2 == 1073741824) {
            a[1] = size2;
        }
        setMeasuredDimension(a[0], a[1]);
    }

    public void scrollToPosition(int i) {
        super.scrollToPositionWithOffset(i, this.f2065e);
    }

    public void smoothScrollToPosition(RecyclerView recyclerView, State state, int i) {
        this.f2067g.setTargetPosition(i);
        startSmoothScroll(this.f2067g);
    }
}
