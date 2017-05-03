package android.support.design.widget;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import java.util.ArrayList;

class ValueAnimatorCompatImplGingerbread extends Impl {
    private static final int DEFAULT_DURATION = 200;
    private static final int HANDLER_DELAY = 10;
    private static final Handler sHandler;
    private float mAnimatedFraction;
    private long mDuration;
    private final float[] mFloatValues;
    private final int[] mIntValues;
    private Interpolator mInterpolator;
    private boolean mIsRunning;
    private ArrayList<AnimatorListenerProxy> mListeners;
    private final Runnable mRunnable;
    private long mStartTime;
    private ArrayList<AnimatorUpdateListenerProxy> mUpdateListeners;

    /* renamed from: android.support.design.widget.ValueAnimatorCompatImplGingerbread.1 */
    class C00601 implements Runnable {
        C00601() {
        }

        public void run() {
            ValueAnimatorCompatImplGingerbread.this.update();
        }
    }

    ValueAnimatorCompatImplGingerbread() {
        this.mIntValues = new int[2];
        this.mFloatValues = new float[2];
        this.mDuration = 200;
        this.mRunnable = new C00601();
    }

    static {
        sHandler = new Handler(Looper.getMainLooper());
    }

    public void start() {
        if (!this.mIsRunning) {
            if (this.mInterpolator == null) {
                this.mInterpolator = new AccelerateDecelerateInterpolator();
            }
            this.mIsRunning = true;
            this.mAnimatedFraction = 0.0f;
            startInternal();
        }
    }

    final void startInternal() {
        this.mStartTime = SystemClock.uptimeMillis();
        dispatchAnimationUpdate();
        dispatchAnimationStart();
        sHandler.postDelayed(this.mRunnable, 10);
    }

    public boolean isRunning() {
        return this.mIsRunning;
    }

    public void setInterpolator(Interpolator interpolator) {
        this.mInterpolator = interpolator;
    }

    public void addListener(AnimatorListenerProxy animatorListenerProxy) {
        if (this.mListeners == null) {
            this.mListeners = new ArrayList();
        }
        this.mListeners.add(animatorListenerProxy);
    }

    public void addUpdateListener(AnimatorUpdateListenerProxy animatorUpdateListenerProxy) {
        if (this.mUpdateListeners == null) {
            this.mUpdateListeners = new ArrayList();
        }
        this.mUpdateListeners.add(animatorUpdateListenerProxy);
    }

    public void setIntValues(int i, int i2) {
        this.mIntValues[0] = i;
        this.mIntValues[1] = i2;
    }

    public int getAnimatedIntValue() {
        return AnimationUtils.lerp(this.mIntValues[0], this.mIntValues[1], getAnimatedFraction());
    }

    public void setFloatValues(float f, float f2) {
        this.mFloatValues[0] = f;
        this.mFloatValues[1] = f2;
    }

    public float getAnimatedFloatValue() {
        return AnimationUtils.lerp(this.mFloatValues[0], this.mFloatValues[1], getAnimatedFraction());
    }

    public void setDuration(long j) {
        this.mDuration = j;
    }

    public void cancel() {
        this.mIsRunning = false;
        sHandler.removeCallbacks(this.mRunnable);
        dispatchAnimationCancel();
        dispatchAnimationEnd();
    }

    public float getAnimatedFraction() {
        return this.mAnimatedFraction;
    }

    public void end() {
        if (this.mIsRunning) {
            this.mIsRunning = false;
            sHandler.removeCallbacks(this.mRunnable);
            this.mAnimatedFraction = 1.0f;
            dispatchAnimationUpdate();
            dispatchAnimationEnd();
        }
    }

    public long getDuration() {
        return this.mDuration;
    }

    final void update() {
        if (this.mIsRunning) {
            float constrain = MathUtils.constrain(((float) (SystemClock.uptimeMillis() - this.mStartTime)) / ((float) this.mDuration), 0.0f, 1.0f);
            if (this.mInterpolator != null) {
                constrain = this.mInterpolator.getInterpolation(constrain);
            }
            this.mAnimatedFraction = constrain;
            dispatchAnimationUpdate();
            if (SystemClock.uptimeMillis() >= this.mStartTime + this.mDuration) {
                this.mIsRunning = false;
                dispatchAnimationEnd();
            }
        }
        if (this.mIsRunning) {
            sHandler.postDelayed(this.mRunnable, 10);
        }
    }

    private void dispatchAnimationUpdate() {
        if (this.mUpdateListeners != null) {
            int size = this.mUpdateListeners.size();
            for (int i = 0; i < size; i++) {
                ((AnimatorUpdateListenerProxy) this.mUpdateListeners.get(i)).onAnimationUpdate();
            }
        }
    }

    private void dispatchAnimationStart() {
        if (this.mListeners != null) {
            int size = this.mListeners.size();
            for (int i = 0; i < size; i++) {
                ((AnimatorListenerProxy) this.mListeners.get(i)).onAnimationStart();
            }
        }
    }

    private void dispatchAnimationCancel() {
        if (this.mListeners != null) {
            int size = this.mListeners.size();
            for (int i = 0; i < size; i++) {
                ((AnimatorListenerProxy) this.mListeners.get(i)).onAnimationCancel();
            }
        }
    }

    private void dispatchAnimationEnd() {
        if (this.mListeners != null) {
            int size = this.mListeners.size();
            for (int i = 0; i < size; i++) {
                ((AnimatorListenerProxy) this.mListeners.get(i)).onAnimationEnd();
            }
        }
    }
}
