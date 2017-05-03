package com.facebook.ads.internal.view.hscroll;

import android.support.v7.widget.RecyclerView.Adapter;
import android.view.View.MeasureSpec;
import com.facebook.ads.internal.view.hscroll.C0832d.C0833a;

/* renamed from: com.facebook.ads.internal.view.hscroll.b */
public class C0834b extends C0832d implements C0833a {
    private HScrollLinearLayoutManager f2077c;
    private C0831a f2078d;
    private int f2079e;
    private int f2080f;
    private int f2081g;
    private int f2082h;

    /* renamed from: com.facebook.ads.internal.view.hscroll.b.a */
    public interface C0831a {
        void m2570a(int i, int i2);
    }

    private void m2576a(int i, int i2) {
        if (i != this.f2079e || i2 != this.f2080f) {
            this.f2079e = i;
            this.f2080f = i2;
            if (this.f2078d != null) {
                this.f2078d.m2570a(this.f2079e, this.f2080f);
            }
        }
    }

    private int m2577b(int i) {
        int i2 = this.f2082h * 2;
        int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - i2;
        int itemCount = getAdapter().getItemCount();
        int i3 = 0;
        int i4 = ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        while (i4 > i) {
            i3++;
            if (i3 >= itemCount) {
                return i;
            }
            i4 = (int) (((float) (measuredWidth - (i3 * i2))) / (((float) i3) + 0.333f));
        }
        return i4;
    }

    public int m2578a(int i) {
        int abs = Math.abs(i);
        return abs <= this.b ? 0 : this.f2081g == 0 ? 1 : (abs / this.f2081g) + 1;
    }

    protected void m2579a(int i, boolean z) {
        super.m2574a(i, z);
        m2576a(i, 0);
    }

    public int getChildSpacing() {
        return this.f2082h;
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int round = Math.round(((float) getMeasuredWidth()) / 1.91f);
        switch (MeasureSpec.getMode(i2)) {
            case RtlSpacingHelper.UNDEFINED /*-2147483648*/:
                round = Math.min(MeasureSpec.getSize(i2), round);
                break;
            case 1073741824:
                round = MeasureSpec.getSize(i2);
                break;
        }
        int paddingTop = getPaddingTop() + getPaddingBottom();
        round = m2577b(round - paddingTop);
        setMeasuredDimension(getMeasuredWidth(), paddingTop + round);
        setChildWidth(round + (this.f2082h * 2));
    }

    public void setAdapter(Adapter adapter) {
        this.f2077c.m2565a(adapter == null ? -1 : adapter.hashCode());
        super.setAdapter(adapter);
    }

    public void setChildSpacing(int i) {
        this.f2082h = i;
    }

    public void setChildWidth(int i) {
        this.f2081g = i;
        int measuredWidth = getMeasuredWidth();
        this.f2077c.m2566b((((measuredWidth - getPaddingLeft()) - getPaddingRight()) - this.f2081g) / 2);
        this.f2077c.m2564a(((double) this.f2081g) / ((double) measuredWidth));
    }

    public void setCurrentPosition(int i) {
        m2579a(i, false);
    }

    public void setOnPageChangedListener(C0831a c0831a) {
        this.f2078d = c0831a;
    }
}
