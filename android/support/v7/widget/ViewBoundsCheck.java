package android.support.v7.widget;

import android.support.v7.appcompat.C0268R;
import android.view.View;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

class ViewBoundsCheck {
    static final int CVE_PVE_POS = 12;
    static final int CVE_PVS_POS = 8;
    static final int CVS_PVE_POS = 4;
    static final int CVS_PVS_POS = 0;
    static final int EQ = 2;
    static final int FLAG_CVE_EQ_PVE = 8192;
    static final int FLAG_CVE_EQ_PVS = 512;
    static final int FLAG_CVE_GT_PVE = 4096;
    static final int FLAG_CVE_GT_PVS = 256;
    static final int FLAG_CVE_LT_PVE = 16384;
    static final int FLAG_CVE_LT_PVS = 1024;
    static final int FLAG_CVS_EQ_PVE = 32;
    static final int FLAG_CVS_EQ_PVS = 2;
    static final int FLAG_CVS_GT_PVE = 16;
    static final int FLAG_CVS_GT_PVS = 1;
    static final int FLAG_CVS_LT_PVE = 64;
    static final int FLAG_CVS_LT_PVS = 4;
    static final int GT = 1;
    static final int LT = 4;
    static final int MASK = 7;
    BoundFlags mBoundFlags;
    final Callback mCallback;

    interface Callback {
        View getChildAt(int i);

        int getChildCount();

        int getChildEnd(View view);

        int getChildStart(View view);

        View getParent();

        int getParentEnd();

        int getParentStart();
    }

    static class BoundFlags {
        int mBoundFlags;
        int mChildEnd;
        int mChildStart;
        int mRvEnd;
        int mRvStart;

        BoundFlags() {
            this.mBoundFlags = ViewBoundsCheck.CVS_PVS_POS;
        }

        void setBounds(int i, int i2, int i3, int i4) {
            this.mRvStart = i;
            this.mRvEnd = i2;
            this.mChildStart = i3;
            this.mChildEnd = i4;
        }

        void setFlags(int i, int i2) {
            this.mBoundFlags = (this.mBoundFlags & (i2 ^ -1)) | (i & i2);
        }

        void addFlags(int i) {
            this.mBoundFlags |= i;
        }

        void resetFlags() {
            this.mBoundFlags = ViewBoundsCheck.CVS_PVS_POS;
        }

        int compare(int i, int i2) {
            if (i > i2) {
                return ViewBoundsCheck.GT;
            }
            if (i == i2) {
                return ViewBoundsCheck.FLAG_CVS_EQ_PVS;
            }
            return ViewBoundsCheck.LT;
        }

        boolean boundsMatch() {
            if ((this.mBoundFlags & ViewBoundsCheck.MASK) != 0 && (this.mBoundFlags & (compare(this.mChildStart, this.mRvStart) << ViewBoundsCheck.CVS_PVS_POS)) == 0) {
                return false;
            }
            if ((this.mBoundFlags & C0268R.styleable.AppCompatTheme_spinnerStyle) != 0 && (this.mBoundFlags & (compare(this.mChildStart, this.mRvEnd) << ViewBoundsCheck.LT)) == 0) {
                return false;
            }
            if ((this.mBoundFlags & 1792) != 0 && (this.mBoundFlags & (compare(this.mChildEnd, this.mRvStart) << ViewBoundsCheck.CVE_PVS_POS)) == 0) {
                return false;
            }
            if ((this.mBoundFlags & 28672) == 0 || (this.mBoundFlags & (compare(this.mChildEnd, this.mRvEnd) << ViewBoundsCheck.CVE_PVE_POS)) != 0) {
                return true;
            }
            return false;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ViewBounds {
    }

    ViewBoundsCheck(Callback callback) {
        this.mCallback = callback;
        this.mBoundFlags = new BoundFlags();
    }

    View findOneViewWithinBoundFlags(int i, int i2, int i3, int i4) {
        int parentStart = this.mCallback.getParentStart();
        int parentEnd = this.mCallback.getParentEnd();
        int i5 = i2 > i ? GT : -1;
        View view = null;
        while (i != i2) {
            View childAt = this.mCallback.getChildAt(i);
            this.mBoundFlags.setBounds(parentStart, parentEnd, this.mCallback.getChildStart(childAt), this.mCallback.getChildEnd(childAt));
            if (i3 != 0) {
                this.mBoundFlags.resetFlags();
                this.mBoundFlags.addFlags(i3);
                if (this.mBoundFlags.boundsMatch()) {
                    return childAt;
                }
            }
            if (i4 != 0) {
                this.mBoundFlags.resetFlags();
                this.mBoundFlags.addFlags(i4);
                if (this.mBoundFlags.boundsMatch()) {
                    i += i5;
                    view = childAt;
                }
            }
            childAt = view;
            i += i5;
            view = childAt;
        }
        return view;
    }

    boolean isViewWithinBoundFlags(View view, int i) {
        this.mBoundFlags.setBounds(this.mCallback.getParentStart(), this.mCallback.getParentEnd(), this.mCallback.getChildStart(view), this.mCallback.getChildEnd(view));
        if (i == 0) {
            return false;
        }
        this.mBoundFlags.resetFlags();
        this.mBoundFlags.addFlags(i);
        return this.mBoundFlags.boundsMatch();
    }
}
