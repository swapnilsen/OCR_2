package android.support.design.widget;

import android.support.annotation.NonNull;
import android.view.animation.Interpolator;

class ValueAnimatorCompat {
    private final Impl mImpl;

    interface AnimatorUpdateListener {
        void onAnimationUpdate(ValueAnimatorCompat valueAnimatorCompat);
    }

    interface AnimatorListener {
        void onAnimationCancel(ValueAnimatorCompat valueAnimatorCompat);

        void onAnimationEnd(ValueAnimatorCompat valueAnimatorCompat);

        void onAnimationStart(ValueAnimatorCompat valueAnimatorCompat);
    }

    static class AnimatorListenerAdapter implements AnimatorListener {
        AnimatorListenerAdapter() {
        }

        public void onAnimationStart(ValueAnimatorCompat valueAnimatorCompat) {
        }

        public void onAnimationEnd(ValueAnimatorCompat valueAnimatorCompat) {
        }

        public void onAnimationCancel(ValueAnimatorCompat valueAnimatorCompat) {
        }
    }

    /* renamed from: android.support.design.widget.ValueAnimatorCompat.1 */
    class C00581 implements AnimatorUpdateListenerProxy {
        final /* synthetic */ AnimatorUpdateListener val$updateListener;

        C00581(AnimatorUpdateListener animatorUpdateListener) {
            this.val$updateListener = animatorUpdateListener;
        }

        public void onAnimationUpdate() {
            this.val$updateListener.onAnimationUpdate(ValueAnimatorCompat.this);
        }
    }

    /* renamed from: android.support.design.widget.ValueAnimatorCompat.2 */
    class C00592 implements AnimatorListenerProxy {
        final /* synthetic */ AnimatorListener val$listener;

        C00592(AnimatorListener animatorListener) {
            this.val$listener = animatorListener;
        }

        public void onAnimationStart() {
            this.val$listener.onAnimationStart(ValueAnimatorCompat.this);
        }

        public void onAnimationEnd() {
            this.val$listener.onAnimationEnd(ValueAnimatorCompat.this);
        }

        public void onAnimationCancel() {
            this.val$listener.onAnimationCancel(ValueAnimatorCompat.this);
        }
    }

    interface Creator {
        @NonNull
        ValueAnimatorCompat createAnimator();
    }

    static abstract class Impl {

        interface AnimatorUpdateListenerProxy {
            void onAnimationUpdate();
        }

        interface AnimatorListenerProxy {
            void onAnimationCancel();

            void onAnimationEnd();

            void onAnimationStart();
        }

        abstract void addListener(AnimatorListenerProxy animatorListenerProxy);

        abstract void addUpdateListener(AnimatorUpdateListenerProxy animatorUpdateListenerProxy);

        abstract void cancel();

        abstract void end();

        abstract float getAnimatedFloatValue();

        abstract float getAnimatedFraction();

        abstract int getAnimatedIntValue();

        abstract long getDuration();

        abstract boolean isRunning();

        abstract void setDuration(long j);

        abstract void setFloatValues(float f, float f2);

        abstract void setIntValues(int i, int i2);

        abstract void setInterpolator(Interpolator interpolator);

        abstract void start();

        Impl() {
        }
    }

    ValueAnimatorCompat(Impl impl) {
        this.mImpl = impl;
    }

    public void start() {
        this.mImpl.start();
    }

    public boolean isRunning() {
        return this.mImpl.isRunning();
    }

    public void setInterpolator(Interpolator interpolator) {
        this.mImpl.setInterpolator(interpolator);
    }

    public void addUpdateListener(AnimatorUpdateListener animatorUpdateListener) {
        if (animatorUpdateListener != null) {
            this.mImpl.addUpdateListener(new C00581(animatorUpdateListener));
        } else {
            this.mImpl.addUpdateListener(null);
        }
    }

    public void addListener(AnimatorListener animatorListener) {
        if (animatorListener != null) {
            this.mImpl.addListener(new C00592(animatorListener));
        } else {
            this.mImpl.addListener(null);
        }
    }

    public void setIntValues(int i, int i2) {
        this.mImpl.setIntValues(i, i2);
    }

    public int getAnimatedIntValue() {
        return this.mImpl.getAnimatedIntValue();
    }

    public void setFloatValues(float f, float f2) {
        this.mImpl.setFloatValues(f, f2);
    }

    public float getAnimatedFloatValue() {
        return this.mImpl.getAnimatedFloatValue();
    }

    public void setDuration(long j) {
        this.mImpl.setDuration(j);
    }

    public void cancel() {
        this.mImpl.cancel();
    }

    public float getAnimatedFraction() {
        return this.mImpl.getAnimatedFraction();
    }

    public void end() {
        this.mImpl.end();
    }

    public long getDuration() {
        return this.mImpl.getDuration();
    }
}
