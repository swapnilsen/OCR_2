package com.facebook.ads.internal.view.hscroll;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

/* renamed from: com.facebook.ads.internal.view.hscroll.d */
public class C0832d extends RecyclerView implements OnTouchListener {
    protected int f2070a;
    protected int f2071b;
    private int f2072c;
    private boolean f2073d;
    private boolean f2074e;
    private LinearLayoutManager f2075f;
    private C0833a f2076g;

    /* renamed from: com.facebook.ads.internal.view.hscroll.d.a */
    public interface C0833a {
        int m2575a(int i);
    }

    private int m2571a(int i) {
        int i2 = this.f2072c - i;
        int a = this.f2076g.m2575a(i2);
        return i2 > this.f2071b ? m2572a(this.f2070a, a) : i2 < (-this.f2071b) ? m2573b(this.f2070a, a) : this.f2070a;
    }

    private int m2572a(int i, int i2) {
        return Math.min(i + i2, getItemCount() - 1);
    }

    private int m2573b(int i, int i2) {
        return Math.max(i - i2, 0);
    }

    private int getItemCount() {
        return getAdapter() == null ? 0 : getAdapter().getItemCount();
    }

    protected void m2574a(int i, boolean z) {
        if (getAdapter() != null) {
            this.f2070a = i;
            if (z) {
                smoothScrollToPosition(i);
            } else {
                scrollToPosition(i);
            }
        }
    }

    public int getCurrentPosition() {
        return this.f2070a;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        int rawX = (int) motionEvent.getRawX();
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 1 || actionMasked == 6 || actionMasked == 3 || actionMasked == 4) {
            if (this.f2074e) {
                m2574a(m2571a(rawX), true);
            }
            this.f2073d = true;
            this.f2074e = false;
            return true;
        } else if (actionMasked != 0 && actionMasked != 5 && (!this.f2073d || actionMasked != 2)) {
            return false;
        } else {
            this.f2072c = rawX;
            if (this.f2073d) {
                this.f2073d = false;
            }
            this.f2074e = true;
            return false;
        }
    }

    public void setLayoutManager(LayoutManager layoutManager) {
        if (layoutManager instanceof LinearLayoutManager) {
            super.setLayoutManager(layoutManager);
            this.f2075f = (LinearLayoutManager) layoutManager;
            return;
        }
        throw new IllegalArgumentException("SnapRecyclerView only supports LinearLayoutManager");
    }

    public void setSnapDelegate(C0833a c0833a) {
        this.f2076g = c0833a;
    }
}
