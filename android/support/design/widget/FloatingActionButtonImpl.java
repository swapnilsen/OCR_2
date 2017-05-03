package android.support.design.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.Nullable;
import android.support.design.C0003R;
import android.support.v4.content.ContextCompat;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.animation.Interpolator;

abstract class FloatingActionButtonImpl {
    static final Interpolator ANIM_INTERPOLATOR;
    static final int ANIM_STATE_HIDING = 1;
    static final int ANIM_STATE_NONE = 0;
    static final int ANIM_STATE_SHOWING = 2;
    static final int[] EMPTY_STATE_SET;
    static final int[] ENABLED_STATE_SET;
    static final int[] FOCUSED_ENABLED_STATE_SET;
    static final long PRESSED_ANIM_DELAY = 100;
    static final long PRESSED_ANIM_DURATION = 100;
    static final int[] PRESSED_ENABLED_STATE_SET;
    static final int SHOW_HIDE_ANIM_DURATION = 200;
    int mAnimState;
    final Creator mAnimatorCreator;
    CircularBorderDrawable mBorderDrawable;
    Drawable mContentBackground;
    float mElevation;
    private OnPreDrawListener mPreDrawListener;
    float mPressedTranslationZ;
    Drawable mRippleDrawable;
    final ShadowViewDelegate mShadowViewDelegate;
    Drawable mShapeDrawable;
    private final Rect mTmpRect;
    final VisibilityAwareImageButton mView;

    interface InternalVisibilityChangedListener {
        void onHidden();

        void onShown();
    }

    /* renamed from: android.support.design.widget.FloatingActionButtonImpl.1 */
    class C00421 implements OnPreDrawListener {
        C00421() {
        }

        public boolean onPreDraw() {
            FloatingActionButtonImpl.this.onPreDraw();
            return true;
        }
    }

    abstract float getElevation();

    abstract void getPadding(Rect rect);

    abstract void hide(@Nullable InternalVisibilityChangedListener internalVisibilityChangedListener, boolean z);

    abstract void jumpDrawableToCurrentState();

    abstract void onCompatShadowChanged();

    abstract void onDrawableStateChanged(int[] iArr);

    abstract void onElevationsChanged(float f, float f2);

    abstract void setBackgroundDrawable(ColorStateList colorStateList, Mode mode, int i, int i2);

    abstract void setBackgroundTintList(ColorStateList colorStateList);

    abstract void setBackgroundTintMode(Mode mode);

    abstract void setRippleColor(int i);

    abstract void show(@Nullable InternalVisibilityChangedListener internalVisibilityChangedListener, boolean z);

    static {
        ANIM_INTERPOLATOR = AnimationUtils.FAST_OUT_LINEAR_IN_INTERPOLATOR;
        PRESSED_ENABLED_STATE_SET = new int[]{16842919, 16842910};
        FOCUSED_ENABLED_STATE_SET = new int[]{16842908, 16842910};
        int[] iArr = new int[ANIM_STATE_HIDING];
        iArr[ANIM_STATE_NONE] = 16842910;
        ENABLED_STATE_SET = iArr;
        EMPTY_STATE_SET = new int[ANIM_STATE_NONE];
    }

    FloatingActionButtonImpl(VisibilityAwareImageButton visibilityAwareImageButton, ShadowViewDelegate shadowViewDelegate, Creator creator) {
        this.mAnimState = ANIM_STATE_NONE;
        this.mTmpRect = new Rect();
        this.mView = visibilityAwareImageButton;
        this.mShadowViewDelegate = shadowViewDelegate;
        this.mAnimatorCreator = creator;
    }

    final void setElevation(float f) {
        if (this.mElevation != f) {
            this.mElevation = f;
            onElevationsChanged(f, this.mPressedTranslationZ);
        }
    }

    final void setPressedTranslationZ(float f) {
        if (this.mPressedTranslationZ != f) {
            this.mPressedTranslationZ = f;
            onElevationsChanged(this.mElevation, f);
        }
    }

    final Drawable getContentBackground() {
        return this.mContentBackground;
    }

    final void updatePadding() {
        Rect rect = this.mTmpRect;
        getPadding(rect);
        onPaddingUpdated(rect);
        this.mShadowViewDelegate.setShadowPadding(rect.left, rect.top, rect.right, rect.bottom);
    }

    void onPaddingUpdated(Rect rect) {
    }

    void onAttachedToWindow() {
        if (requirePreDrawListener()) {
            ensurePreDrawListener();
            this.mView.getViewTreeObserver().addOnPreDrawListener(this.mPreDrawListener);
        }
    }

    void onDetachedFromWindow() {
        if (this.mPreDrawListener != null) {
            this.mView.getViewTreeObserver().removeOnPreDrawListener(this.mPreDrawListener);
            this.mPreDrawListener = null;
        }
    }

    boolean requirePreDrawListener() {
        return false;
    }

    CircularBorderDrawable createBorderDrawable(int i, ColorStateList colorStateList) {
        Context context = this.mView.getContext();
        CircularBorderDrawable newCircularDrawable = newCircularDrawable();
        newCircularDrawable.setGradientColors(ContextCompat.getColor(context, C0003R.color.design_fab_stroke_top_outer_color), ContextCompat.getColor(context, C0003R.color.design_fab_stroke_top_inner_color), ContextCompat.getColor(context, C0003R.color.design_fab_stroke_end_inner_color), ContextCompat.getColor(context, C0003R.color.design_fab_stroke_end_outer_color));
        newCircularDrawable.setBorderWidth((float) i);
        newCircularDrawable.setBorderTint(colorStateList);
        return newCircularDrawable;
    }

    CircularBorderDrawable newCircularDrawable() {
        return new CircularBorderDrawable();
    }

    void onPreDraw() {
    }

    private void ensurePreDrawListener() {
        if (this.mPreDrawListener == null) {
            this.mPreDrawListener = new C00421();
        }
    }

    GradientDrawable createShapeDrawable() {
        GradientDrawable newGradientDrawableForShape = newGradientDrawableForShape();
        newGradientDrawableForShape.setShape(ANIM_STATE_HIDING);
        newGradientDrawableForShape.setColor(-1);
        return newGradientDrawableForShape;
    }

    GradientDrawable newGradientDrawableForShape() {
        return new GradientDrawable();
    }

    boolean isOrWillBeShown() {
        if (this.mView.getVisibility() != 0) {
            if (this.mAnimState == ANIM_STATE_SHOWING) {
                return true;
            }
            return false;
        } else if (this.mAnimState == ANIM_STATE_HIDING) {
            return false;
        } else {
            return true;
        }
    }

    boolean isOrWillBeHidden() {
        if (this.mView.getVisibility() == 0) {
            if (this.mAnimState == ANIM_STATE_HIDING) {
                return true;
            }
            return false;
        } else if (this.mAnimState == ANIM_STATE_SHOWING) {
            return false;
        } else {
            return true;
        }
    }
}
