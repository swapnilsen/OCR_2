package android.support.v7.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;

public class DividerItemDecoration extends ItemDecoration {
    private static final int[] ATTRS;
    public static final int HORIZONTAL = 0;
    public static final int VERTICAL = 1;
    private final Rect mBounds;
    private Drawable mDivider;
    private int mOrientation;

    static {
        int[] iArr = new int[VERTICAL];
        iArr[HORIZONTAL] = 16843284;
        ATTRS = iArr;
    }

    public DividerItemDecoration(Context context, int i) {
        this.mBounds = new Rect();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(ATTRS);
        this.mDivider = obtainStyledAttributes.getDrawable(HORIZONTAL);
        obtainStyledAttributes.recycle();
        setOrientation(i);
    }

    public void setOrientation(int i) {
        if (i == 0 || i == VERTICAL) {
            this.mOrientation = i;
            return;
        }
        throw new IllegalArgumentException("Invalid orientation. It should be either HORIZONTAL or VERTICAL");
    }

    public void setDrawable(@NonNull Drawable drawable) {
        if (drawable == null) {
            throw new IllegalArgumentException("Drawable cannot be null.");
        }
        this.mDivider = drawable;
    }

    public void onDraw(Canvas canvas, RecyclerView recyclerView, State state) {
        if (recyclerView.getLayoutManager() != null) {
            if (this.mOrientation == VERTICAL) {
                drawVertical(canvas, recyclerView);
            } else {
                drawHorizontal(canvas, recyclerView);
            }
        }
    }

    @SuppressLint({"NewApi"})
    private void drawVertical(Canvas canvas, RecyclerView recyclerView) {
        int paddingLeft;
        int width;
        int i = HORIZONTAL;
        canvas.save();
        if (recyclerView.getClipToPadding()) {
            paddingLeft = recyclerView.getPaddingLeft();
            width = recyclerView.getWidth() - recyclerView.getPaddingRight();
            canvas.clipRect(paddingLeft, recyclerView.getPaddingTop(), width, recyclerView.getHeight() - recyclerView.getPaddingBottom());
        } else {
            width = recyclerView.getWidth();
            paddingLeft = HORIZONTAL;
        }
        int childCount = recyclerView.getChildCount();
        while (i < childCount) {
            View childAt = recyclerView.getChildAt(i);
            recyclerView.getDecoratedBoundsWithMargins(childAt, this.mBounds);
            int round = Math.round(ViewCompat.getTranslationY(childAt)) + this.mBounds.bottom;
            this.mDivider.setBounds(paddingLeft, round - this.mDivider.getIntrinsicHeight(), width, round);
            this.mDivider.draw(canvas);
            i += VERTICAL;
        }
        canvas.restore();
    }

    @SuppressLint({"NewApi"})
    private void drawHorizontal(Canvas canvas, RecyclerView recyclerView) {
        int paddingTop;
        int height;
        int i = HORIZONTAL;
        canvas.save();
        if (recyclerView.getClipToPadding()) {
            paddingTop = recyclerView.getPaddingTop();
            height = recyclerView.getHeight() - recyclerView.getPaddingBottom();
            canvas.clipRect(recyclerView.getPaddingLeft(), paddingTop, recyclerView.getWidth() - recyclerView.getPaddingRight(), height);
        } else {
            height = recyclerView.getHeight();
            paddingTop = HORIZONTAL;
        }
        int childCount = recyclerView.getChildCount();
        while (i < childCount) {
            View childAt = recyclerView.getChildAt(i);
            recyclerView.getLayoutManager().getDecoratedBoundsWithMargins(childAt, this.mBounds);
            int round = Math.round(ViewCompat.getTranslationX(childAt)) + this.mBounds.right;
            this.mDivider.setBounds(round - this.mDivider.getIntrinsicWidth(), paddingTop, round, height);
            this.mDivider.draw(canvas);
            i += VERTICAL;
        }
        canvas.restore();
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, State state) {
        if (this.mOrientation == VERTICAL) {
            rect.set(HORIZONTAL, HORIZONTAL, HORIZONTAL, this.mDivider.getIntrinsicHeight());
        } else {
            rect.set(HORIZONTAL, HORIZONTAL, this.mDivider.getIntrinsicWidth(), HORIZONTAL);
        }
    }
}
