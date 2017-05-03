package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.support.annotation.RequiresApi;
import android.support.transition.TransitionPort.TransitionListenerAdapter;
import android.support.v4.view.ViewCompat;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

@TargetApi(14)
@RequiresApi(14)
class FadePort extends VisibilityPort {
    private static boolean DBG = false;
    public static final int IN = 1;
    private static final String LOG_TAG = "Fade";
    public static final int OUT = 2;
    private static final String PROPNAME_SCREEN_X = "android:fade:screenX";
    private static final String PROPNAME_SCREEN_Y = "android:fade:screenY";
    private int mFadingMode;

    /* renamed from: android.support.transition.FadePort.1 */
    class C00751 extends TransitionListenerAdapter {
        boolean mCanceled;
        float mPausedAlpha;
        final /* synthetic */ View val$endView;

        C00751(View view) {
            this.val$endView = view;
            this.mCanceled = false;
        }

        public void onTransitionCancel(TransitionPort transitionPort) {
            this.val$endView.setAlpha(1.0f);
            this.mCanceled = true;
        }

        public void onTransitionEnd(TransitionPort transitionPort) {
            if (!this.mCanceled) {
                this.val$endView.setAlpha(1.0f);
            }
        }

        public void onTransitionPause(TransitionPort transitionPort) {
            this.mPausedAlpha = this.val$endView.getAlpha();
            this.val$endView.setAlpha(1.0f);
        }

        public void onTransitionResume(TransitionPort transitionPort) {
            this.val$endView.setAlpha(this.mPausedAlpha);
        }
    }

    /* renamed from: android.support.transition.FadePort.2 */
    class C00762 extends AnimatorListenerAdapter {
        final /* synthetic */ View val$finalOverlayView;
        final /* synthetic */ ViewGroup val$finalSceneRoot;
        final /* synthetic */ View val$finalView;
        final /* synthetic */ View val$finalViewToKeep;
        final /* synthetic */ int val$finalVisibility;

        C00762(View view, View view2, int i, View view3, ViewGroup viewGroup) {
            this.val$finalView = view;
            this.val$finalViewToKeep = view2;
            this.val$finalVisibility = i;
            this.val$finalOverlayView = view3;
            this.val$finalSceneRoot = viewGroup;
        }

        public void onAnimationEnd(Animator animator) {
            this.val$finalView.setAlpha(1.0f);
            if (this.val$finalViewToKeep != null) {
                this.val$finalViewToKeep.setVisibility(this.val$finalVisibility);
            }
            if (this.val$finalOverlayView != null) {
                ViewGroupOverlay.createFrom(this.val$finalSceneRoot).remove(this.val$finalOverlayView);
            }
        }
    }

    /* renamed from: android.support.transition.FadePort.3 */
    class C00773 extends AnimatorListenerAdapter {
        boolean mCanceled;
        float mPausedAlpha;
        final /* synthetic */ View val$finalOverlayView;
        final /* synthetic */ ViewGroup val$finalSceneRoot;
        final /* synthetic */ View val$finalView;
        final /* synthetic */ View val$finalViewToKeep;
        final /* synthetic */ int val$finalVisibility;

        C00773(View view, View view2, int i, View view3, ViewGroup viewGroup) {
            this.val$finalView = view;
            this.val$finalViewToKeep = view2;
            this.val$finalVisibility = i;
            this.val$finalOverlayView = view3;
            this.val$finalSceneRoot = viewGroup;
            this.mCanceled = false;
            this.mPausedAlpha = -1.0f;
        }

        public void onAnimationCancel(Animator animator) {
            this.mCanceled = true;
            if (this.mPausedAlpha >= 0.0f) {
                this.val$finalView.setAlpha(this.mPausedAlpha);
            }
        }

        public void onAnimationEnd(Animator animator) {
            if (!this.mCanceled) {
                this.val$finalView.setAlpha(1.0f);
            }
            if (!(this.val$finalViewToKeep == null || this.mCanceled)) {
                this.val$finalViewToKeep.setVisibility(this.val$finalVisibility);
            }
            if (this.val$finalOverlayView != null) {
                ViewGroupOverlay.createFrom(this.val$finalSceneRoot).add(this.val$finalOverlayView);
            }
        }
    }

    static {
        DBG = false;
    }

    public FadePort() {
        this(3);
    }

    public FadePort(int i) {
        this.mFadingMode = i;
    }

    private Animator createAnimation(View view, float f, float f2, AnimatorListenerAdapter animatorListenerAdapter) {
        Animator animator = null;
        if (f != f2) {
            float[] fArr = new float[OUT];
            fArr[0] = f;
            fArr[IN] = f2;
            animator = ObjectAnimator.ofFloat(view, "alpha", fArr);
            if (DBG) {
                Log.d(LOG_TAG, "Created animator " + animator);
            }
            if (animatorListenerAdapter != null) {
                animator.addListener(animatorListenerAdapter);
            }
        } else if (animatorListenerAdapter != null) {
            animatorListenerAdapter.onAnimationEnd(null);
        }
        return animator;
    }

    private void captureValues(TransitionValues transitionValues) {
        int[] iArr = new int[OUT];
        transitionValues.view.getLocationOnScreen(iArr);
        transitionValues.values.put(PROPNAME_SCREEN_X, Integer.valueOf(iArr[0]));
        transitionValues.values.put(PROPNAME_SCREEN_Y, Integer.valueOf(iArr[IN]));
    }

    public void captureStartValues(TransitionValues transitionValues) {
        super.captureStartValues(transitionValues);
        captureValues(transitionValues);
    }

    public Animator onAppear(ViewGroup viewGroup, TransitionValues transitionValues, int i, TransitionValues transitionValues2, int i2) {
        if ((this.mFadingMode & IN) != IN || transitionValues2 == null) {
            return null;
        }
        View view = transitionValues2.view;
        if (DBG) {
            Log.d(LOG_TAG, "Fade.onAppear: startView, startVis, endView, endVis = " + (transitionValues != null ? transitionValues.view : null) + ", " + i + ", " + view + ", " + i2);
        }
        view.setAlpha(0.0f);
        addListener(new C00751(view));
        return createAnimation(view, 0.0f, 1.0f, null);
    }

    public Animator onDisappear(ViewGroup viewGroup, TransitionValues transitionValues, int i, TransitionValues transitionValues2, int i2) {
        if ((this.mFadingMode & OUT) != OUT) {
            return null;
        }
        View view;
        View view2;
        View view3;
        int id;
        View view4 = transitionValues != null ? transitionValues.view : null;
        if (transitionValues2 != null) {
            view = transitionValues2.view;
        } else {
            view = null;
        }
        if (DBG) {
            Log.d(LOG_TAG, "Fade.onDisappear: startView, startVis, endView, endVis = " + view4 + ", " + i + ", " + view + ", " + i2);
        }
        if (view == null || view.getParent() == null) {
            if (view != null) {
                view2 = null;
                view3 = view;
                view4 = view;
            } else {
                if (view4 != null) {
                    if (view4.getParent() == null) {
                        view2 = null;
                        view3 = view4;
                    } else if ((view4.getParent() instanceof View) && view4.getParent().getParent() == null) {
                        id = ((View) view4.getParent()).getId();
                        if (id == -1 || viewGroup.findViewById(id) == null || !this.mCanRemoveViews) {
                            Object obj = null;
                            view4 = null;
                        } else {
                            view = view4;
                        }
                        view2 = null;
                        view3 = view;
                    }
                }
                view2 = null;
                view3 = null;
                view4 = null;
            }
        } else if (i2 == 4) {
            view2 = view;
            view3 = null;
            view4 = view;
        } else if (view4 == view) {
            view2 = view;
            view3 = null;
            view4 = view;
        } else {
            view2 = null;
            view3 = view4;
        }
        if (view3 != null) {
            int intValue = ((Integer) transitionValues.values.get(PROPNAME_SCREEN_X)).intValue();
            id = ((Integer) transitionValues.values.get(PROPNAME_SCREEN_Y)).intValue();
            int[] iArr = new int[OUT];
            viewGroup.getLocationOnScreen(iArr);
            ViewCompat.offsetLeftAndRight(view3, (intValue - iArr[0]) - view3.getLeft());
            ViewCompat.offsetTopAndBottom(view3, (id - iArr[IN]) - view3.getTop());
            ViewGroupOverlay.createFrom(viewGroup).add(view3);
            return createAnimation(view4, 1.0f, 0.0f, new C00762(view4, view2, i2, view3, viewGroup));
        } else if (view2 == null) {
            return null;
        } else {
            view2.setVisibility(0);
            return createAnimation(view4, 1.0f, 0.0f, new C00773(view4, view2, i2, view3, viewGroup));
        }
    }
}
