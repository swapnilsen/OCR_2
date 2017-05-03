package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.InputDeviceCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.C0268R;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.plus.model.people.Person.Urls.Type;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class LinearLayoutCompat extends ViewGroup {
    public static final int HORIZONTAL = 0;
    private static final int INDEX_BOTTOM = 2;
    private static final int INDEX_CENTER_VERTICAL = 0;
    private static final int INDEX_FILL = 3;
    private static final int INDEX_TOP = 1;
    public static final int SHOW_DIVIDER_BEGINNING = 1;
    public static final int SHOW_DIVIDER_END = 4;
    public static final int SHOW_DIVIDER_MIDDLE = 2;
    public static final int SHOW_DIVIDER_NONE = 0;
    public static final int VERTICAL = 1;
    private static final int VERTICAL_GRAVITY_COUNT = 4;
    private boolean mBaselineAligned;
    private int mBaselineAlignedChildIndex;
    private int mBaselineChildTop;
    private Drawable mDivider;
    private int mDividerHeight;
    private int mDividerPadding;
    private int mDividerWidth;
    private int mGravity;
    private int[] mMaxAscent;
    private int[] mMaxDescent;
    private int mOrientation;
    private int mShowDividers;
    private int mTotalLength;
    private boolean mUseLargestChild;
    private float mWeightSum;

    public static class LayoutParams extends MarginLayoutParams {
        public int gravity;
        public float weight;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.gravity = -1;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0268R.styleable.LinearLayoutCompat_Layout);
            this.weight = obtainStyledAttributes.getFloat(C0268R.styleable.LinearLayoutCompat_Layout_android_layout_weight, 0.0f);
            this.gravity = obtainStyledAttributes.getInt(C0268R.styleable.LinearLayoutCompat_Layout_android_layout_gravity, -1);
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.gravity = -1;
            this.weight = 0.0f;
        }

        public LayoutParams(int i, int i2, float f) {
            super(i, i2);
            this.gravity = -1;
            this.weight = f;
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.gravity = -1;
        }

        public LayoutParams(MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.gravity = -1;
        }

        public LayoutParams(LayoutParams layoutParams) {
            super(layoutParams);
            this.gravity = -1;
            this.weight = layoutParams.weight;
            this.gravity = layoutParams.gravity;
        }
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface DividerMode {
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface OrientationMode {
    }

    public LinearLayoutCompat(Context context) {
        this(context, null);
    }

    public LinearLayoutCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, SHOW_DIVIDER_NONE);
    }

    public LinearLayoutCompat(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mBaselineAligned = true;
        this.mBaselineAlignedChildIndex = -1;
        this.mBaselineChildTop = SHOW_DIVIDER_NONE;
        this.mGravity = 8388659;
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet, C0268R.styleable.LinearLayoutCompat, i, SHOW_DIVIDER_NONE);
        int i2 = obtainStyledAttributes.getInt(C0268R.styleable.LinearLayoutCompat_android_orientation, -1);
        if (i2 >= 0) {
            setOrientation(i2);
        }
        i2 = obtainStyledAttributes.getInt(C0268R.styleable.LinearLayoutCompat_android_gravity, -1);
        if (i2 >= 0) {
            setGravity(i2);
        }
        boolean z = obtainStyledAttributes.getBoolean(C0268R.styleable.LinearLayoutCompat_android_baselineAligned, true);
        if (!z) {
            setBaselineAligned(z);
        }
        this.mWeightSum = obtainStyledAttributes.getFloat(C0268R.styleable.LinearLayoutCompat_android_weightSum, -1.0f);
        this.mBaselineAlignedChildIndex = obtainStyledAttributes.getInt(C0268R.styleable.LinearLayoutCompat_android_baselineAlignedChildIndex, -1);
        this.mUseLargestChild = obtainStyledAttributes.getBoolean(C0268R.styleable.LinearLayoutCompat_measureWithLargestChild, false);
        setDividerDrawable(obtainStyledAttributes.getDrawable(C0268R.styleable.LinearLayoutCompat_divider));
        this.mShowDividers = obtainStyledAttributes.getInt(C0268R.styleable.LinearLayoutCompat_showDividers, SHOW_DIVIDER_NONE);
        this.mDividerPadding = obtainStyledAttributes.getDimensionPixelSize(C0268R.styleable.LinearLayoutCompat_dividerPadding, SHOW_DIVIDER_NONE);
        obtainStyledAttributes.recycle();
    }

    public void setShowDividers(int i) {
        if (i != this.mShowDividers) {
            requestLayout();
        }
        this.mShowDividers = i;
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public int getShowDividers() {
        return this.mShowDividers;
    }

    public Drawable getDividerDrawable() {
        return this.mDivider;
    }

    public void setDividerDrawable(Drawable drawable) {
        boolean z = false;
        if (drawable != this.mDivider) {
            this.mDivider = drawable;
            if (drawable != null) {
                this.mDividerWidth = drawable.getIntrinsicWidth();
                this.mDividerHeight = drawable.getIntrinsicHeight();
            } else {
                this.mDividerWidth = SHOW_DIVIDER_NONE;
                this.mDividerHeight = SHOW_DIVIDER_NONE;
            }
            if (drawable == null) {
                z = true;
            }
            setWillNotDraw(z);
            requestLayout();
        }
    }

    public void setDividerPadding(int i) {
        this.mDividerPadding = i;
    }

    public int getDividerPadding() {
        return this.mDividerPadding;
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public int getDividerWidth() {
        return this.mDividerWidth;
    }

    protected void onDraw(Canvas canvas) {
        if (this.mDivider != null) {
            if (this.mOrientation == VERTICAL) {
                drawDividersVertical(canvas);
            } else {
                drawDividersHorizontal(canvas);
            }
        }
    }

    void drawDividersVertical(Canvas canvas) {
        int virtualChildCount = getVirtualChildCount();
        int i = SHOW_DIVIDER_NONE;
        while (i < virtualChildCount) {
            View virtualChildAt = getVirtualChildAt(i);
            if (!(virtualChildAt == null || virtualChildAt.getVisibility() == 8 || !hasDividerBeforeChildAt(i))) {
                drawHorizontalDivider(canvas, (virtualChildAt.getTop() - ((LayoutParams) virtualChildAt.getLayoutParams()).topMargin) - this.mDividerHeight);
            }
            i += VERTICAL;
        }
        if (hasDividerBeforeChildAt(virtualChildCount)) {
            int height;
            View virtualChildAt2 = getVirtualChildAt(virtualChildCount - 1);
            if (virtualChildAt2 == null) {
                height = (getHeight() - getPaddingBottom()) - this.mDividerHeight;
            } else {
                LayoutParams layoutParams = (LayoutParams) virtualChildAt2.getLayoutParams();
                height = layoutParams.bottomMargin + virtualChildAt2.getBottom();
            }
            drawHorizontalDivider(canvas, height);
        }
    }

    void drawDividersHorizontal(Canvas canvas) {
        int virtualChildCount = getVirtualChildCount();
        boolean isLayoutRtl = ViewUtils.isLayoutRtl(this);
        int i = SHOW_DIVIDER_NONE;
        while (i < virtualChildCount) {
            LayoutParams layoutParams;
            int right;
            View virtualChildAt = getVirtualChildAt(i);
            if (!(virtualChildAt == null || virtualChildAt.getVisibility() == 8 || !hasDividerBeforeChildAt(i))) {
                layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                if (isLayoutRtl) {
                    right = layoutParams.rightMargin + virtualChildAt.getRight();
                } else {
                    right = (virtualChildAt.getLeft() - layoutParams.leftMargin) - this.mDividerWidth;
                }
                drawVerticalDivider(canvas, right);
            }
            i += VERTICAL;
        }
        if (hasDividerBeforeChildAt(virtualChildCount)) {
            View virtualChildAt2 = getVirtualChildAt(virtualChildCount - 1);
            if (virtualChildAt2 != null) {
                layoutParams = (LayoutParams) virtualChildAt2.getLayoutParams();
                if (isLayoutRtl) {
                    right = (virtualChildAt2.getLeft() - layoutParams.leftMargin) - this.mDividerWidth;
                } else {
                    right = layoutParams.rightMargin + virtualChildAt2.getRight();
                }
            } else if (isLayoutRtl) {
                right = getPaddingLeft();
            } else {
                right = (getWidth() - getPaddingRight()) - this.mDividerWidth;
            }
            drawVerticalDivider(canvas, right);
        }
    }

    void drawHorizontalDivider(Canvas canvas, int i) {
        this.mDivider.setBounds(getPaddingLeft() + this.mDividerPadding, i, (getWidth() - getPaddingRight()) - this.mDividerPadding, this.mDividerHeight + i);
        this.mDivider.draw(canvas);
    }

    void drawVerticalDivider(Canvas canvas, int i) {
        this.mDivider.setBounds(i, getPaddingTop() + this.mDividerPadding, this.mDividerWidth + i, (getHeight() - getPaddingBottom()) - this.mDividerPadding);
        this.mDivider.draw(canvas);
    }

    public boolean isBaselineAligned() {
        return this.mBaselineAligned;
    }

    public void setBaselineAligned(boolean z) {
        this.mBaselineAligned = z;
    }

    public boolean isMeasureWithLargestChildEnabled() {
        return this.mUseLargestChild;
    }

    public void setMeasureWithLargestChildEnabled(boolean z) {
        this.mUseLargestChild = z;
    }

    public int getBaseline() {
        if (this.mBaselineAlignedChildIndex < 0) {
            return super.getBaseline();
        }
        if (getChildCount() <= this.mBaselineAlignedChildIndex) {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
        }
        View childAt = getChildAt(this.mBaselineAlignedChildIndex);
        int baseline = childAt.getBaseline();
        if (baseline != -1) {
            int i;
            int i2 = this.mBaselineChildTop;
            if (this.mOrientation == VERTICAL) {
                i = this.mGravity & C0268R.styleable.AppCompatTheme_spinnerStyle;
                if (i != 48) {
                    switch (i) {
                        case CommonStatusCodes.CANCELED /*16*/:
                            i = i2 + (((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.mTotalLength) / SHOW_DIVIDER_MIDDLE);
                            break;
                        case C0268R.styleable.AppCompatTheme_panelMenuListWidth /*80*/:
                            i = ((getBottom() - getTop()) - getPaddingBottom()) - this.mTotalLength;
                            break;
                    }
                }
            }
            i = i2;
            return (((LayoutParams) childAt.getLayoutParams()).topMargin + i) + baseline;
        } else if (this.mBaselineAlignedChildIndex == 0) {
            return -1;
        } else {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
        }
    }

    public int getBaselineAlignedChildIndex() {
        return this.mBaselineAlignedChildIndex;
    }

    public void setBaselineAlignedChildIndex(int i) {
        if (i < 0 || i >= getChildCount()) {
            throw new IllegalArgumentException("base aligned child index out of range (0, " + getChildCount() + ")");
        }
        this.mBaselineAlignedChildIndex = i;
    }

    View getVirtualChildAt(int i) {
        return getChildAt(i);
    }

    int getVirtualChildCount() {
        return getChildCount();
    }

    public float getWeightSum() {
        return this.mWeightSum;
    }

    public void setWeightSum(float f) {
        this.mWeightSum = Math.max(0.0f, f);
    }

    protected void onMeasure(int i, int i2) {
        if (this.mOrientation == VERTICAL) {
            measureVertical(i, i2);
        } else {
            measureHorizontal(i, i2);
        }
    }

    protected boolean hasDividerBeforeChildAt(int i) {
        if (i == 0) {
            if ((this.mShowDividers & VERTICAL) != 0) {
                return true;
            }
            return false;
        } else if (i == getChildCount()) {
            if ((this.mShowDividers & VERTICAL_GRAVITY_COUNT) == 0) {
                return false;
            }
            return true;
        } else if ((this.mShowDividers & SHOW_DIVIDER_MIDDLE) == 0) {
            return false;
        } else {
            for (int i2 = i - 1; i2 >= 0; i2--) {
                if (getChildAt(i2).getVisibility() != 8) {
                    return true;
                }
            }
            return false;
        }
    }

    void measureVertical(int i, int i2) {
        int i3;
        Object obj;
        int i4;
        int i5;
        int i6;
        View virtualChildAt;
        this.mTotalLength = SHOW_DIVIDER_NONE;
        int i7 = SHOW_DIVIDER_NONE;
        int i8 = SHOW_DIVIDER_NONE;
        int i9 = SHOW_DIVIDER_NONE;
        int i10 = SHOW_DIVIDER_NONE;
        Object obj2 = VERTICAL;
        float f = 0.0f;
        int virtualChildCount = getVirtualChildCount();
        int mode = MeasureSpec.getMode(i);
        int mode2 = MeasureSpec.getMode(i2);
        Object obj3 = null;
        Object obj4 = null;
        int i11 = this.mBaselineAlignedChildIndex;
        boolean z = this.mUseLargestChild;
        int i12 = RtlSpacingHelper.UNDEFINED;
        int i13 = SHOW_DIVIDER_NONE;
        while (i13 < virtualChildCount) {
            Object obj5;
            View virtualChildAt2 = getVirtualChildAt(i13);
            if (virtualChildAt2 == null) {
                this.mTotalLength += measureNullChild(i13);
                i3 = i12;
                obj5 = obj4;
                obj = obj2;
                i4 = i8;
                i5 = i7;
            } else if (virtualChildAt2.getVisibility() == 8) {
                i13 += getChildrenSkipCount(virtualChildAt2, i13);
                i3 = i12;
                obj5 = obj4;
                obj = obj2;
                i4 = i8;
                i5 = i7;
            } else {
                if (hasDividerBeforeChildAt(i13)) {
                    this.mTotalLength += this.mDividerHeight;
                }
                LayoutParams layoutParams = (LayoutParams) virtualChildAt2.getLayoutParams();
                float f2 = f + layoutParams.weight;
                if (mode2 == 1073741824 && layoutParams.height == 0 && layoutParams.weight > 0.0f) {
                    i3 = this.mTotalLength;
                    this.mTotalLength = Math.max(i3, (layoutParams.topMargin + i3) + layoutParams.bottomMargin);
                    obj4 = VERTICAL;
                } else {
                    i3 = RtlSpacingHelper.UNDEFINED;
                    if (layoutParams.height == 0 && layoutParams.weight > 0.0f) {
                        i3 = SHOW_DIVIDER_NONE;
                        layoutParams.height = -2;
                    }
                    int i14 = i3;
                    measureChildBeforeLayout(virtualChildAt2, i13, i, SHOW_DIVIDER_NONE, i2, f2 == 0.0f ? this.mTotalLength : SHOW_DIVIDER_NONE);
                    if (i14 != Integer.MIN_VALUE) {
                        layoutParams.height = i14;
                    }
                    i3 = virtualChildAt2.getMeasuredHeight();
                    int i15 = this.mTotalLength;
                    this.mTotalLength = Math.max(i15, (((i15 + i3) + layoutParams.topMargin) + layoutParams.bottomMargin) + getNextLocationOffset(virtualChildAt2));
                    if (z) {
                        i12 = Math.max(i3, i12);
                    }
                }
                if (i11 >= 0 && i11 == i13 + VERTICAL) {
                    this.mBaselineChildTop = this.mTotalLength;
                }
                if (i13 >= i11 || layoutParams.weight <= 0.0f) {
                    Object obj6;
                    Object obj7 = null;
                    if (mode == 1073741824 || layoutParams.width != -1) {
                        obj6 = obj3;
                    } else {
                        obj6 = VERTICAL;
                        obj7 = VERTICAL;
                    }
                    i4 = layoutParams.rightMargin + layoutParams.leftMargin;
                    i5 = virtualChildAt2.getMeasuredWidth() + i4;
                    i7 = Math.max(i7, i5);
                    int combineMeasuredStates = ViewUtils.combineMeasuredStates(i8, ViewCompat.getMeasuredState(virtualChildAt2));
                    obj = (obj2 == null || layoutParams.width != -1) ? null : VERTICAL;
                    if (layoutParams.weight > 0.0f) {
                        if (obj7 != null) {
                            i3 = i4;
                        } else {
                            i3 = i5;
                        }
                        i3 = Math.max(i10, i3);
                        i4 = i9;
                    } else {
                        if (obj7 == null) {
                            i4 = i5;
                        }
                        i4 = Math.max(i9, i4);
                        i3 = i10;
                    }
                    i13 += getChildrenSkipCount(virtualChildAt2, i13);
                    obj5 = obj4;
                    i10 = i3;
                    i9 = i4;
                    i5 = i7;
                    i3 = i12;
                    i4 = combineMeasuredStates;
                    obj3 = obj6;
                    f = f2;
                } else {
                    throw new RuntimeException("A child of LinearLayout with index less than mBaselineAlignedChildIndex has weight > 0, which won't work.  Either remove the weight, or don't set mBaselineAlignedChildIndex.");
                }
            }
            i13 += VERTICAL;
            i12 = i3;
            obj4 = obj5;
            obj2 = obj;
            i8 = i4;
            i7 = i5;
        }
        if (this.mTotalLength > 0 && hasDividerBeforeChildAt(virtualChildCount)) {
            this.mTotalLength += this.mDividerHeight;
        }
        if (z && (mode2 == Integer.MIN_VALUE || mode2 == 0)) {
            this.mTotalLength = SHOW_DIVIDER_NONE;
            i6 = SHOW_DIVIDER_NONE;
            while (i6 < virtualChildCount) {
                virtualChildAt = getVirtualChildAt(i6);
                if (virtualChildAt == null) {
                    this.mTotalLength += measureNullChild(i6);
                    i3 = i6;
                } else if (virtualChildAt.getVisibility() == 8) {
                    i3 = getChildrenSkipCount(virtualChildAt, i6) + i6;
                } else {
                    LayoutParams layoutParams2 = (LayoutParams) virtualChildAt.getLayoutParams();
                    int i16 = this.mTotalLength;
                    this.mTotalLength = Math.max(i16, (layoutParams2.bottomMargin + ((i16 + i12) + layoutParams2.topMargin)) + getNextLocationOffset(virtualChildAt));
                    i3 = i6;
                }
                i6 = i3 + VERTICAL;
            }
        }
        this.mTotalLength += getPaddingTop() + getPaddingBottom();
        int resolveSizeAndState = ViewCompat.resolveSizeAndState(Math.max(this.mTotalLength, getSuggestedMinimumHeight()), i2, SHOW_DIVIDER_NONE);
        i6 = (ViewCompat.MEASURED_SIZE_MASK & resolveSizeAndState) - this.mTotalLength;
        int i17;
        if (obj4 != null || (i6 != 0 && f > 0.0f)) {
            if (this.mWeightSum > 0.0f) {
                f = this.mWeightSum;
            }
            this.mTotalLength = SHOW_DIVIDER_NONE;
            i12 = SHOW_DIVIDER_NONE;
            float f3 = f;
            Object obj8 = obj2;
            i17 = i9;
            i16 = i8;
            i10 = i7;
            i15 = i6;
            while (i12 < virtualChildCount) {
                View virtualChildAt3 = getVirtualChildAt(i12);
                if (virtualChildAt3.getVisibility() == 8) {
                    i3 = i17;
                    i6 = i16;
                    i4 = i10;
                    obj = obj8;
                } else {
                    float f4;
                    float f5;
                    layoutParams2 = (LayoutParams) virtualChildAt3.getLayoutParams();
                    float f6 = layoutParams2.weight;
                    if (f6 > 0.0f) {
                        i6 = (int) ((((float) i15) * f6) / f3);
                        f3 -= f6;
                        i15 -= i6;
                        i4 = getChildMeasureSpec(i, ((getPaddingLeft() + getPaddingRight()) + layoutParams2.leftMargin) + layoutParams2.rightMargin, layoutParams2.width);
                        if (layoutParams2.height == 0 && mode2 == 1073741824) {
                            if (i6 <= 0) {
                                i6 = SHOW_DIVIDER_NONE;
                            }
                            virtualChildAt3.measure(i4, MeasureSpec.makeMeasureSpec(i6, 1073741824));
                        } else {
                            i6 += virtualChildAt3.getMeasuredHeight();
                            if (i6 < 0) {
                                i6 = SHOW_DIVIDER_NONE;
                            }
                            virtualChildAt3.measure(i4, MeasureSpec.makeMeasureSpec(i6, 1073741824));
                        }
                        f4 = f3;
                        i13 = i15;
                        i15 = ViewUtils.combineMeasuredStates(i16, ViewCompat.getMeasuredState(virtualChildAt3) & InputDeviceCompat.SOURCE_ANY);
                        f5 = f4;
                    } else {
                        f5 = f3;
                        i13 = i15;
                        i15 = i16;
                    }
                    i16 = layoutParams2.leftMargin + layoutParams2.rightMargin;
                    i4 = virtualChildAt3.getMeasuredWidth() + i16;
                    i10 = Math.max(i10, i4);
                    Object obj9 = (mode == 1073741824 || layoutParams2.width != -1) ? null : VERTICAL;
                    if (obj9 == null) {
                        i16 = i4;
                    }
                    i4 = Math.max(i17, i16);
                    obj = (obj8 == null || layoutParams2.width != -1) ? null : VERTICAL;
                    i5 = this.mTotalLength;
                    this.mTotalLength = Math.max(i5, (layoutParams2.bottomMargin + ((virtualChildAt3.getMeasuredHeight() + i5) + layoutParams2.topMargin)) + getNextLocationOffset(virtualChildAt3));
                    i3 = i4;
                    i4 = i10;
                    f4 = f5;
                    i6 = i15;
                    i15 = i13;
                    f3 = f4;
                }
                i12 += VERTICAL;
                i17 = i3;
                i10 = i4;
                obj8 = obj;
                i16 = i6;
            }
            this.mTotalLength += getPaddingTop() + getPaddingBottom();
            obj2 = obj8;
            i3 = i17;
            i8 = i16;
            i6 = i10;
        } else {
            i17 = Math.max(i9, i10);
            if (z && mode2 != 1073741824) {
                for (i6 = SHOW_DIVIDER_NONE; i6 < virtualChildCount; i6 += VERTICAL) {
                    virtualChildAt = getVirtualChildAt(i6);
                    if (!(virtualChildAt == null || virtualChildAt.getVisibility() == 8 || ((LayoutParams) virtualChildAt.getLayoutParams()).weight <= 0.0f)) {
                        virtualChildAt.measure(MeasureSpec.makeMeasureSpec(virtualChildAt.getMeasuredWidth(), 1073741824), MeasureSpec.makeMeasureSpec(i12, 1073741824));
                    }
                }
            }
            i3 = i17;
            i6 = i7;
        }
        if (obj2 != null || mode == 1073741824) {
            i3 = i6;
        }
        setMeasuredDimension(ViewCompat.resolveSizeAndState(Math.max(i3 + (getPaddingLeft() + getPaddingRight()), getSuggestedMinimumWidth()), i, i8), resolveSizeAndState);
        if (obj3 != null) {
            forceUniformWidth(virtualChildCount, i2);
        }
    }

    private void forceUniformWidth(int i, int i2) {
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        for (int i3 = SHOW_DIVIDER_NONE; i3 < i; i3 += VERTICAL) {
            View virtualChildAt = getVirtualChildAt(i3);
            if (virtualChildAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                if (layoutParams.width == -1) {
                    int i4 = layoutParams.height;
                    layoutParams.height = virtualChildAt.getMeasuredHeight();
                    measureChildWithMargins(virtualChildAt, makeMeasureSpec, SHOW_DIVIDER_NONE, i2, SHOW_DIVIDER_NONE);
                    layoutParams.height = i4;
                }
            }
        }
    }

    void measureHorizontal(int i, int i2) {
        Object obj;
        int i3;
        Object obj2;
        int i4;
        int i5;
        LayoutParams layoutParams;
        this.mTotalLength = SHOW_DIVIDER_NONE;
        int i6 = SHOW_DIVIDER_NONE;
        int i7 = SHOW_DIVIDER_NONE;
        int i8 = SHOW_DIVIDER_NONE;
        int i9 = SHOW_DIVIDER_NONE;
        Object obj3 = VERTICAL;
        float f = 0.0f;
        int virtualChildCount = getVirtualChildCount();
        int mode = MeasureSpec.getMode(i);
        int mode2 = MeasureSpec.getMode(i2);
        Object obj4 = null;
        Object obj5 = null;
        if (this.mMaxAscent == null || this.mMaxDescent == null) {
            this.mMaxAscent = new int[VERTICAL_GRAVITY_COUNT];
            this.mMaxDescent = new int[VERTICAL_GRAVITY_COUNT];
        }
        int[] iArr = this.mMaxAscent;
        int[] iArr2 = this.mMaxDescent;
        iArr[INDEX_FILL] = -1;
        iArr[SHOW_DIVIDER_MIDDLE] = -1;
        iArr[VERTICAL] = -1;
        iArr[SHOW_DIVIDER_NONE] = -1;
        iArr2[INDEX_FILL] = -1;
        iArr2[SHOW_DIVIDER_MIDDLE] = -1;
        iArr2[VERTICAL] = -1;
        iArr2[SHOW_DIVIDER_NONE] = -1;
        boolean z = this.mBaselineAligned;
        boolean z2 = this.mUseLargestChild;
        if (mode == 1073741824) {
            obj = VERTICAL;
        } else {
            obj = SHOW_DIVIDER_NONE;
        }
        int i10 = RtlSpacingHelper.UNDEFINED;
        int i11 = SHOW_DIVIDER_NONE;
        while (i11 < virtualChildCount) {
            Object obj6;
            int i12;
            View virtualChildAt = getVirtualChildAt(i11);
            if (virtualChildAt == null) {
                this.mTotalLength += measureNullChild(i11);
                i3 = i10;
                obj2 = obj5;
                obj6 = obj3;
                i12 = i7;
                i4 = i6;
            } else if (virtualChildAt.getVisibility() == 8) {
                i11 += getChildrenSkipCount(virtualChildAt, i11);
                i3 = i10;
                obj2 = obj5;
                obj6 = obj3;
                i12 = i7;
                i4 = i6;
            } else {
                Object obj7;
                if (hasDividerBeforeChildAt(i11)) {
                    this.mTotalLength += this.mDividerWidth;
                }
                LayoutParams layoutParams2 = (LayoutParams) virtualChildAt.getLayoutParams();
                float f2 = f + layoutParams2.weight;
                if (mode == 1073741824 && layoutParams2.width == 0 && layoutParams2.weight > 0.0f) {
                    if (obj != null) {
                        this.mTotalLength += layoutParams2.leftMargin + layoutParams2.rightMargin;
                    } else {
                        i3 = this.mTotalLength;
                        this.mTotalLength = Math.max(i3, (layoutParams2.leftMargin + i3) + layoutParams2.rightMargin);
                    }
                    if (z) {
                        i3 = MeasureSpec.makeMeasureSpec(SHOW_DIVIDER_NONE, SHOW_DIVIDER_NONE);
                        virtualChildAt.measure(i3, i3);
                    } else {
                        obj5 = VERTICAL;
                    }
                } else {
                    i3 = RtlSpacingHelper.UNDEFINED;
                    if (layoutParams2.width == 0 && layoutParams2.weight > 0.0f) {
                        i3 = SHOW_DIVIDER_NONE;
                        layoutParams2.width = -2;
                    }
                    int i13 = i3;
                    measureChildBeforeLayout(virtualChildAt, i11, i, f2 == 0.0f ? this.mTotalLength : SHOW_DIVIDER_NONE, i2, SHOW_DIVIDER_NONE);
                    if (i13 != Integer.MIN_VALUE) {
                        layoutParams2.width = i13;
                    }
                    i3 = virtualChildAt.getMeasuredWidth();
                    if (obj != null) {
                        this.mTotalLength += ((layoutParams2.leftMargin + i3) + layoutParams2.rightMargin) + getNextLocationOffset(virtualChildAt);
                    } else {
                        int i14 = this.mTotalLength;
                        this.mTotalLength = Math.max(i14, (((i14 + i3) + layoutParams2.leftMargin) + layoutParams2.rightMargin) + getNextLocationOffset(virtualChildAt));
                    }
                    if (z2) {
                        i10 = Math.max(i3, i10);
                    }
                }
                Object obj8 = null;
                if (mode2 == 1073741824 || layoutParams2.height != -1) {
                    obj7 = obj4;
                } else {
                    obj7 = VERTICAL;
                    obj8 = VERTICAL;
                }
                i12 = layoutParams2.bottomMargin + layoutParams2.topMargin;
                i4 = virtualChildAt.getMeasuredHeight() + i12;
                int combineMeasuredStates = ViewUtils.combineMeasuredStates(i7, ViewCompat.getMeasuredState(virtualChildAt));
                if (z) {
                    i7 = virtualChildAt.getBaseline();
                    if (i7 != -1) {
                        int i15 = ((((layoutParams2.gravity < 0 ? this.mGravity : layoutParams2.gravity) & C0268R.styleable.AppCompatTheme_spinnerStyle) >> VERTICAL_GRAVITY_COUNT) & -2) >> VERTICAL;
                        iArr[i15] = Math.max(iArr[i15], i7);
                        iArr2[i15] = Math.max(iArr2[i15], i4 - i7);
                    }
                }
                i7 = Math.max(i6, i4);
                obj6 = (obj3 == null || layoutParams2.height != -1) ? null : VERTICAL;
                if (layoutParams2.weight > 0.0f) {
                    if (obj8 != null) {
                        i3 = i12;
                    } else {
                        i3 = i4;
                    }
                    i3 = Math.max(i9, i3);
                    i12 = i8;
                } else {
                    if (obj8 == null) {
                        i12 = i4;
                    }
                    i12 = Math.max(i8, i12);
                    i3 = i9;
                }
                i11 += getChildrenSkipCount(virtualChildAt, i11);
                obj2 = obj5;
                i9 = i3;
                i8 = i12;
                i4 = i7;
                i3 = i10;
                i12 = combineMeasuredStates;
                obj4 = obj7;
                f = f2;
            }
            i11 += VERTICAL;
            i10 = i3;
            obj5 = obj2;
            obj3 = obj6;
            i7 = i12;
            i6 = i4;
        }
        if (this.mTotalLength > 0 && hasDividerBeforeChildAt(virtualChildCount)) {
            this.mTotalLength += this.mDividerWidth;
        }
        if (iArr[VERTICAL] == -1 && iArr[SHOW_DIVIDER_NONE] == -1 && iArr[SHOW_DIVIDER_MIDDLE] == -1 && iArr[INDEX_FILL] == -1) {
            i11 = i6;
        } else {
            i11 = Math.max(i6, Math.max(iArr[INDEX_FILL], Math.max(iArr[SHOW_DIVIDER_NONE], Math.max(iArr[VERTICAL], iArr[SHOW_DIVIDER_MIDDLE]))) + Math.max(iArr2[INDEX_FILL], Math.max(iArr2[SHOW_DIVIDER_NONE], Math.max(iArr2[VERTICAL], iArr2[SHOW_DIVIDER_MIDDLE]))));
        }
        if (z2 && (mode == Integer.MIN_VALUE || mode == 0)) {
            this.mTotalLength = SHOW_DIVIDER_NONE;
            i5 = SHOW_DIVIDER_NONE;
            while (i5 < virtualChildCount) {
                View virtualChildAt2 = getVirtualChildAt(i5);
                if (virtualChildAt2 == null) {
                    this.mTotalLength += measureNullChild(i5);
                    i3 = i5;
                } else if (virtualChildAt2.getVisibility() == 8) {
                    i3 = getChildrenSkipCount(virtualChildAt2, i5) + i5;
                } else {
                    layoutParams = (LayoutParams) virtualChildAt2.getLayoutParams();
                    if (obj != null) {
                        this.mTotalLength = ((layoutParams.rightMargin + (layoutParams.leftMargin + i10)) + getNextLocationOffset(virtualChildAt2)) + this.mTotalLength;
                        i3 = i5;
                    } else {
                        i12 = this.mTotalLength;
                        this.mTotalLength = Math.max(i12, (layoutParams.rightMargin + ((i12 + i10) + layoutParams.leftMargin)) + getNextLocationOffset(virtualChildAt2));
                        i3 = i5;
                    }
                }
                i5 = i3 + VERTICAL;
            }
        }
        this.mTotalLength += getPaddingLeft() + getPaddingRight();
        int resolveSizeAndState = ViewCompat.resolveSizeAndState(Math.max(this.mTotalLength, getSuggestedMinimumWidth()), i, SHOW_DIVIDER_NONE);
        i5 = (ViewCompat.MEASURED_SIZE_MASK & resolveSizeAndState) - this.mTotalLength;
        int i16;
        if (obj5 != null || (i5 != 0 && f > 0.0f)) {
            if (this.mWeightSum > 0.0f) {
                f = this.mWeightSum;
            }
            iArr[INDEX_FILL] = -1;
            iArr[SHOW_DIVIDER_MIDDLE] = -1;
            iArr[VERTICAL] = -1;
            iArr[SHOW_DIVIDER_NONE] = -1;
            iArr2[INDEX_FILL] = -1;
            iArr2[SHOW_DIVIDER_MIDDLE] = -1;
            iArr2[VERTICAL] = -1;
            iArr2[SHOW_DIVIDER_NONE] = -1;
            this.mTotalLength = SHOW_DIVIDER_NONE;
            i10 = SHOW_DIVIDER_NONE;
            float f3 = f;
            Object obj9 = obj3;
            i16 = i8;
            i15 = i7;
            i14 = i5;
            i8 = -1;
            while (i10 < virtualChildCount) {
                float f4;
                Object obj10;
                View virtualChildAt3 = getVirtualChildAt(i10);
                if (virtualChildAt3 == null) {
                    f4 = f3;
                    i5 = i14;
                    i12 = i8;
                    i14 = i16;
                    obj10 = obj9;
                } else if (virtualChildAt3.getVisibility() == 8) {
                    f4 = f3;
                    i5 = i14;
                    i12 = i8;
                    i14 = i16;
                    obj10 = obj9;
                } else {
                    float f5;
                    layoutParams = (LayoutParams) virtualChildAt3.getLayoutParams();
                    float f6 = layoutParams.weight;
                    if (f6 > 0.0f) {
                        i5 = (int) ((((float) i14) * f6) / f3);
                        f3 -= f6;
                        i12 = i14 - i5;
                        i14 = getChildMeasureSpec(i2, ((getPaddingTop() + getPaddingBottom()) + layoutParams.topMargin) + layoutParams.bottomMargin, layoutParams.height);
                        if (layoutParams.width == 0 && mode == 1073741824) {
                            if (i5 <= 0) {
                                i5 = SHOW_DIVIDER_NONE;
                            }
                            virtualChildAt3.measure(MeasureSpec.makeMeasureSpec(i5, 1073741824), i14);
                        } else {
                            i5 += virtualChildAt3.getMeasuredWidth();
                            if (i5 < 0) {
                                i5 = SHOW_DIVIDER_NONE;
                            }
                            virtualChildAt3.measure(MeasureSpec.makeMeasureSpec(i5, 1073741824), i14);
                        }
                        i9 = ViewUtils.combineMeasuredStates(i15, ViewCompat.getMeasuredState(virtualChildAt3) & ViewCompat.MEASURED_STATE_MASK);
                        f5 = f3;
                    } else {
                        i12 = i14;
                        i9 = i15;
                        f5 = f3;
                    }
                    if (obj != null) {
                        this.mTotalLength += ((virtualChildAt3.getMeasuredWidth() + layoutParams.leftMargin) + layoutParams.rightMargin) + getNextLocationOffset(virtualChildAt3);
                    } else {
                        i5 = this.mTotalLength;
                        this.mTotalLength = Math.max(i5, (((virtualChildAt3.getMeasuredWidth() + i5) + layoutParams.leftMargin) + layoutParams.rightMargin) + getNextLocationOffset(virtualChildAt3));
                    }
                    obj2 = (mode2 == 1073741824 || layoutParams.height != -1) ? null : VERTICAL;
                    i11 = layoutParams.topMargin + layoutParams.bottomMargin;
                    i14 = virtualChildAt3.getMeasuredHeight() + i11;
                    i8 = Math.max(i8, i14);
                    if (obj2 != null) {
                        i5 = i11;
                    } else {
                        i5 = i14;
                    }
                    i11 = Math.max(i16, i5);
                    obj2 = (obj9 == null || layoutParams.height != -1) ? null : VERTICAL;
                    if (z) {
                        i4 = virtualChildAt3.getBaseline();
                        if (i4 != -1) {
                            i3 = ((((layoutParams.gravity < 0 ? this.mGravity : layoutParams.gravity) & C0268R.styleable.AppCompatTheme_spinnerStyle) >> VERTICAL_GRAVITY_COUNT) & -2) >> VERTICAL;
                            iArr[i3] = Math.max(iArr[i3], i4);
                            iArr2[i3] = Math.max(iArr2[i3], i14 - i4);
                        }
                    }
                    f4 = f5;
                    i14 = i11;
                    obj10 = obj2;
                    i15 = i9;
                    i5 = i12;
                    i12 = i8;
                }
                i10 += VERTICAL;
                i16 = i14;
                i8 = i12;
                obj9 = obj10;
                i14 = i5;
                f3 = f4;
            }
            this.mTotalLength += getPaddingLeft() + getPaddingRight();
            if (!(iArr[VERTICAL] == -1 && iArr[SHOW_DIVIDER_NONE] == -1 && iArr[SHOW_DIVIDER_MIDDLE] == -1 && iArr[INDEX_FILL] == -1)) {
                i8 = Math.max(i8, Math.max(iArr[INDEX_FILL], Math.max(iArr[SHOW_DIVIDER_NONE], Math.max(iArr[VERTICAL], iArr[SHOW_DIVIDER_MIDDLE]))) + Math.max(iArr2[INDEX_FILL], Math.max(iArr2[SHOW_DIVIDER_NONE], Math.max(iArr2[VERTICAL], iArr2[SHOW_DIVIDER_MIDDLE]))));
            }
            obj3 = obj9;
            i3 = i16;
            i7 = i15;
            i5 = i8;
        } else {
            i16 = Math.max(i8, i9);
            if (z2 && mode != 1073741824) {
                for (i5 = SHOW_DIVIDER_NONE; i5 < virtualChildCount; i5 += VERTICAL) {
                    View virtualChildAt4 = getVirtualChildAt(i5);
                    if (!(virtualChildAt4 == null || virtualChildAt4.getVisibility() == 8 || ((LayoutParams) virtualChildAt4.getLayoutParams()).weight <= 0.0f)) {
                        virtualChildAt4.measure(MeasureSpec.makeMeasureSpec(i10, 1073741824), MeasureSpec.makeMeasureSpec(virtualChildAt4.getMeasuredHeight(), 1073741824));
                    }
                }
            }
            i3 = i16;
            i5 = i11;
        }
        if (obj3 != null || mode2 == 1073741824) {
            i3 = i5;
        }
        setMeasuredDimension((ViewCompat.MEASURED_STATE_MASK & i7) | resolveSizeAndState, ViewCompat.resolveSizeAndState(Math.max(i3 + (getPaddingTop() + getPaddingBottom()), getSuggestedMinimumHeight()), i2, i7 << 16));
        if (obj4 != null) {
            forceUniformHeight(virtualChildCount, i);
        }
    }

    private void forceUniformHeight(int i, int i2) {
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
        for (int i3 = SHOW_DIVIDER_NONE; i3 < i; i3 += VERTICAL) {
            View virtualChildAt = getVirtualChildAt(i3);
            if (virtualChildAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                if (layoutParams.height == -1) {
                    int i4 = layoutParams.width;
                    layoutParams.width = virtualChildAt.getMeasuredWidth();
                    measureChildWithMargins(virtualChildAt, i2, SHOW_DIVIDER_NONE, makeMeasureSpec, SHOW_DIVIDER_NONE);
                    layoutParams.width = i4;
                }
            }
        }
    }

    int getChildrenSkipCount(View view, int i) {
        return SHOW_DIVIDER_NONE;
    }

    int measureNullChild(int i) {
        return SHOW_DIVIDER_NONE;
    }

    void measureChildBeforeLayout(View view, int i, int i2, int i3, int i4, int i5) {
        measureChildWithMargins(view, i2, i3, i4, i5);
    }

    int getLocationOffset(View view) {
        return SHOW_DIVIDER_NONE;
    }

    int getNextLocationOffset(View view) {
        return SHOW_DIVIDER_NONE;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.mOrientation == VERTICAL) {
            layoutVertical(i, i2, i3, i4);
        } else {
            layoutHorizontal(i, i2, i3, i4);
        }
    }

    void layoutVertical(int i, int i2, int i3, int i4) {
        int paddingLeft = getPaddingLeft();
        int i5 = i3 - i;
        int paddingRight = i5 - getPaddingRight();
        int paddingRight2 = (i5 - paddingLeft) - getPaddingRight();
        int virtualChildCount = getVirtualChildCount();
        int i6 = this.mGravity & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        switch (this.mGravity & C0268R.styleable.AppCompatTheme_spinnerStyle) {
            case CommonStatusCodes.CANCELED /*16*/:
                i5 = getPaddingTop() + (((i4 - i2) - this.mTotalLength) / SHOW_DIVIDER_MIDDLE);
                break;
            case C0268R.styleable.AppCompatTheme_panelMenuListWidth /*80*/:
                i5 = ((getPaddingTop() + i4) - i2) - this.mTotalLength;
                break;
            default:
                i5 = getPaddingTop();
                break;
        }
        int i7 = SHOW_DIVIDER_NONE;
        int i8 = i5;
        while (i7 < virtualChildCount) {
            View virtualChildAt = getVirtualChildAt(i7);
            if (virtualChildAt == null) {
                i8 += measureNullChild(i7);
                i5 = i7;
            } else if (virtualChildAt.getVisibility() != 8) {
                int i9;
                int measuredWidth = virtualChildAt.getMeasuredWidth();
                int measuredHeight = virtualChildAt.getMeasuredHeight();
                LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                i5 = layoutParams.gravity;
                if (i5 < 0) {
                    i5 = i6;
                }
                switch (GravityCompat.getAbsoluteGravity(i5, ViewCompat.getLayoutDirection(this)) & 7) {
                    case VERTICAL /*1*/:
                        i9 = ((((paddingRight2 - measuredWidth) / SHOW_DIVIDER_MIDDLE) + paddingLeft) + layoutParams.leftMargin) - layoutParams.rightMargin;
                        break;
                    case Type.OTHER_PROFILE /*5*/:
                        i9 = (paddingRight - measuredWidth) - layoutParams.rightMargin;
                        break;
                    default:
                        i9 = paddingLeft + layoutParams.leftMargin;
                        break;
                }
                if (hasDividerBeforeChildAt(i7)) {
                    i5 = this.mDividerHeight + i8;
                } else {
                    i5 = i8;
                }
                int i10 = i5 + layoutParams.topMargin;
                setChildFrame(virtualChildAt, i9, i10 + getLocationOffset(virtualChildAt), measuredWidth, measuredHeight);
                i8 = i10 + ((layoutParams.bottomMargin + measuredHeight) + getNextLocationOffset(virtualChildAt));
                i5 = getChildrenSkipCount(virtualChildAt, i7) + i7;
            } else {
                i5 = i7;
            }
            i7 = i5 + VERTICAL;
        }
    }

    void layoutHorizontal(int i, int i2, int i3, int i4) {
        int paddingLeft;
        int i5;
        int i6;
        boolean isLayoutRtl = ViewUtils.isLayoutRtl(this);
        int paddingTop = getPaddingTop();
        int i7 = i4 - i2;
        int paddingBottom = i7 - getPaddingBottom();
        int paddingBottom2 = (i7 - paddingTop) - getPaddingBottom();
        int virtualChildCount = getVirtualChildCount();
        i7 = this.mGravity & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        int i8 = this.mGravity & C0268R.styleable.AppCompatTheme_spinnerStyle;
        boolean z = this.mBaselineAligned;
        int[] iArr = this.mMaxAscent;
        int[] iArr2 = this.mMaxDescent;
        switch (GravityCompat.getAbsoluteGravity(i7, ViewCompat.getLayoutDirection(this))) {
            case VERTICAL /*1*/:
                paddingLeft = getPaddingLeft() + (((i3 - i) - this.mTotalLength) / SHOW_DIVIDER_MIDDLE);
                break;
            case Type.OTHER_PROFILE /*5*/:
                paddingLeft = ((getPaddingLeft() + i3) - i) - this.mTotalLength;
                break;
            default:
                paddingLeft = getPaddingLeft();
                break;
        }
        if (isLayoutRtl) {
            i5 = -1;
            i6 = virtualChildCount - 1;
        } else {
            i5 = VERTICAL;
            i6 = SHOW_DIVIDER_NONE;
        }
        int i9 = SHOW_DIVIDER_NONE;
        while (i9 < virtualChildCount) {
            int i10 = i6 + (i5 * i9);
            View virtualChildAt = getVirtualChildAt(i10);
            if (virtualChildAt == null) {
                paddingLeft += measureNullChild(i10);
                i7 = i9;
            } else if (virtualChildAt.getVisibility() != 8) {
                int i11;
                int measuredWidth = virtualChildAt.getMeasuredWidth();
                int measuredHeight = virtualChildAt.getMeasuredHeight();
                LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                if (!z || layoutParams.height == -1) {
                    i7 = -1;
                } else {
                    i7 = virtualChildAt.getBaseline();
                }
                int i12 = layoutParams.gravity;
                if (i12 < 0) {
                    i12 = i8;
                }
                switch (i12 & C0268R.styleable.AppCompatTheme_spinnerStyle) {
                    case CommonStatusCodes.CANCELED /*16*/:
                        i11 = ((((paddingBottom2 - measuredHeight) / SHOW_DIVIDER_MIDDLE) + paddingTop) + layoutParams.topMargin) - layoutParams.bottomMargin;
                        break;
                    case C0268R.styleable.AppCompatTheme_spinnerDropDownItemStyle /*48*/:
                        i11 = paddingTop + layoutParams.topMargin;
                        if (i7 != -1) {
                            i11 += iArr[VERTICAL] - i7;
                            break;
                        }
                        break;
                    case C0268R.styleable.AppCompatTheme_panelMenuListWidth /*80*/:
                        i11 = (paddingBottom - measuredHeight) - layoutParams.bottomMargin;
                        if (i7 != -1) {
                            i11 -= iArr2[SHOW_DIVIDER_MIDDLE] - (virtualChildAt.getMeasuredHeight() - i7);
                            break;
                        }
                        break;
                    default:
                        i11 = paddingTop;
                        break;
                }
                if (hasDividerBeforeChildAt(i10)) {
                    i7 = this.mDividerWidth + paddingLeft;
                } else {
                    i7 = paddingLeft;
                }
                paddingLeft = i7 + layoutParams.leftMargin;
                setChildFrame(virtualChildAt, paddingLeft + getLocationOffset(virtualChildAt), i11, measuredWidth, measuredHeight);
                paddingLeft += (layoutParams.rightMargin + measuredWidth) + getNextLocationOffset(virtualChildAt);
                i7 = getChildrenSkipCount(virtualChildAt, i10) + i9;
            } else {
                i7 = i9;
            }
            i9 = i7 + VERTICAL;
        }
    }

    private void setChildFrame(View view, int i, int i2, int i3, int i4) {
        view.layout(i, i2, i + i3, i2 + i4);
    }

    public void setOrientation(int i) {
        if (this.mOrientation != i) {
            this.mOrientation = i;
            requestLayout();
        }
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public void setGravity(int i) {
        if (this.mGravity != i) {
            int i2;
            if ((GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK & i) == 0) {
                i2 = GravityCompat.START | i;
            } else {
                i2 = i;
            }
            if ((i2 & C0268R.styleable.AppCompatTheme_spinnerStyle) == 0) {
                i2 |= 48;
            }
            this.mGravity = i2;
            requestLayout();
        }
    }

    public int getGravity() {
        return this.mGravity;
    }

    public void setHorizontalGravity(int i) {
        int i2 = i & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        if ((this.mGravity & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK) != i2) {
            this.mGravity = i2 | (this.mGravity & -8388616);
            requestLayout();
        }
    }

    public void setVerticalGravity(int i) {
        int i2 = i & C0268R.styleable.AppCompatTheme_spinnerStyle;
        if ((this.mGravity & C0268R.styleable.AppCompatTheme_spinnerStyle) != i2) {
            this.mGravity = i2 | (this.mGravity & -113);
            requestLayout();
        }
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    protected LayoutParams generateDefaultLayoutParams() {
        if (this.mOrientation == 0) {
            return new LayoutParams(-2, -2);
        }
        if (this.mOrientation == VERTICAL) {
            return new LayoutParams(-1, -2);
        }
        return null;
    }

    protected LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (VERSION.SDK_INT >= 14) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName(LinearLayoutCompat.class.getName());
        }
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (VERSION.SDK_INT >= 14) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName(LinearLayoutCompat.class.getName());
        }
    }
}
