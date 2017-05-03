package android.support.design.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.TargetApi;
import android.support.annotation.RequiresApi;
import android.view.animation.Interpolator;

@TargetApi(12)
@RequiresApi(12)
class ValueAnimatorCompatImplHoneycombMr1 extends Impl {
    private final ValueAnimator mValueAnimator;

    /* renamed from: android.support.design.widget.ValueAnimatorCompatImplHoneycombMr1.1 */
    class C00611 implements AnimatorUpdateListener {
        final /* synthetic */ AnimatorUpdateListenerProxy val$updateListener;

        C00611(AnimatorUpdateListenerProxy animatorUpdateListenerProxy) {
            this.val$updateListener = animatorUpdateListenerProxy;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.val$updateListener.onAnimationUpdate();
        }
    }

    /* renamed from: android.support.design.widget.ValueAnimatorCompatImplHoneycombMr1.2 */
    class C00622 extends AnimatorListenerAdapter {
        final /* synthetic */ AnimatorListenerProxy val$listener;

        C00622(AnimatorListenerProxy animatorListenerProxy) {
            this.val$listener = animatorListenerProxy;
        }

        public void onAnimationStart(Animator animator) {
            this.val$listener.onAnimationStart();
        }

        public void onAnimationEnd(Animator animator) {
            this.val$listener.onAnimationEnd();
        }

        public void onAnimationCancel(Animator animator) {
            this.val$listener.onAnimationCancel();
        }
    }

    ValueAnimatorCompatImplHoneycombMr1() {
        this.mValueAnimator = new ValueAnimator();
    }

    public void start() {
        this.mValueAnimator.start();
    }

    public boolean isRunning() {
        return this.mValueAnimator.isRunning();
    }

    public void setInterpolator(Interpolator interpolator) {
        this.mValueAnimator.setInterpolator(interpolator);
    }

    public void addUpdateListener(AnimatorUpdateListenerProxy animatorUpdateListenerProxy) {
        this.mValueAnimator.addUpdateListener(new C00611(animatorUpdateListenerProxy));
    }

    public void addListener(AnimatorListenerProxy animatorListenerProxy) {
        this.mValueAnimator.addListener(new C00622(animatorListenerProxy));
    }

    public void setIntValues(int i, int i2) {
        this.mValueAnimator.setIntValues(new int[]{i, i2});
    }

    public int getAnimatedIntValue() {
        return ((Integer) this.mValueAnimator.getAnimatedValue()).intValue();
    }

    public void setFloatValues(float f, float f2) {
        this.mValueAnimator.setFloatValues(new float[]{f, f2});
    }

    public float getAnimatedFloatValue() {
        return ((Float) this.mValueAnimator.getAnimatedValue()).floatValue();
    }

    public void setDuration(long j) {
        this.mValueAnimator.setDuration(j);
    }

    public void cancel() {
        this.mValueAnimator.cancel();
    }

    public float getAnimatedFraction() {
        return this.mValueAnimator.getAnimatedFraction();
    }

    public void end() {
        this.mValueAnimator.end();
    }

    public long getDuration() {
        return this.mValueAnimator.getDuration();
    }
}
