package android.support.design.widget;

import android.util.StateSet;
import java.util.ArrayList;

final class StateListAnimator {
    private final AnimatorListener mAnimationListener;
    private Tuple mLastMatch;
    ValueAnimatorCompat mRunningAnimator;
    private final ArrayList<Tuple> mTuples;

    /* renamed from: android.support.design.widget.StateListAnimator.1 */
    class C00471 extends AnimatorListenerAdapter {
        C00471() {
        }

        public void onAnimationEnd(ValueAnimatorCompat valueAnimatorCompat) {
            if (StateListAnimator.this.mRunningAnimator == valueAnimatorCompat) {
                StateListAnimator.this.mRunningAnimator = null;
            }
        }
    }

    static class Tuple {
        final ValueAnimatorCompat mAnimator;
        final int[] mSpecs;

        Tuple(int[] iArr, ValueAnimatorCompat valueAnimatorCompat) {
            this.mSpecs = iArr;
            this.mAnimator = valueAnimatorCompat;
        }
    }

    StateListAnimator() {
        this.mTuples = new ArrayList();
        this.mLastMatch = null;
        this.mRunningAnimator = null;
        this.mAnimationListener = new C00471();
    }

    public void addState(int[] iArr, ValueAnimatorCompat valueAnimatorCompat) {
        Tuple tuple = new Tuple(iArr, valueAnimatorCompat);
        valueAnimatorCompat.addListener(this.mAnimationListener);
        this.mTuples.add(tuple);
    }

    void setState(int[] iArr) {
        Tuple tuple;
        int size = this.mTuples.size();
        for (int i = 0; i < size; i++) {
            tuple = (Tuple) this.mTuples.get(i);
            if (StateSet.stateSetMatches(tuple.mSpecs, iArr)) {
                break;
            }
        }
        tuple = null;
        if (tuple != this.mLastMatch) {
            if (this.mLastMatch != null) {
                cancel();
            }
            this.mLastMatch = tuple;
            if (tuple != null) {
                start(tuple);
            }
        }
    }

    private void start(Tuple tuple) {
        this.mRunningAnimator = tuple.mAnimator;
        this.mRunningAnimator.start();
    }

    private void cancel() {
        if (this.mRunningAnimator != null) {
            this.mRunningAnimator.cancel();
            this.mRunningAnimator = null;
        }
    }

    public void jumpToCurrentState() {
        if (this.mRunningAnimator != null) {
            this.mRunningAnimator.end();
            this.mRunningAnimator = null;
        }
    }
}
