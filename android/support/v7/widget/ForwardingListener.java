package android.support.v7.widget;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.support.annotation.RequiresApi;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.view.menu.ShowableListMenu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.google.firebase.messaging.SendException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import net.nend.android.NendAdIconLayout;
import net.nend.android.NendIconError;

@RestrictTo({Scope.LIBRARY_GROUP})
public abstract class ForwardingListener implements OnTouchListener {
    private int mActivePointerId;
    private Runnable mDisallowIntercept;
    private boolean mForwarding;
    private final int mLongPressTimeout;
    private final float mScaledTouchSlop;
    final View mSrc;
    private final int mTapTimeout;
    private final int[] mTmpLocation;
    private Runnable mTriggerLongPress;

    /* renamed from: android.support.v7.widget.ForwardingListener.1 */
    class C03131 implements OnAttachStateChangeListener {
        C03131() {
        }

        public void onViewAttachedToWindow(View view) {
        }

        public void onViewDetachedFromWindow(View view) {
            ForwardingListener.this.onDetachedFromWindow();
        }
    }

    /* renamed from: android.support.v7.widget.ForwardingListener.2 */
    class C03142 implements OnGlobalLayoutListener {
        boolean mIsAttached;

        C03142() {
            this.mIsAttached = ViewCompat.isAttachedToWindow(ForwardingListener.this.mSrc);
        }

        public void onGlobalLayout() {
            boolean z = this.mIsAttached;
            this.mIsAttached = ViewCompat.isAttachedToWindow(ForwardingListener.this.mSrc);
            if (z && !this.mIsAttached) {
                ForwardingListener.this.onDetachedFromWindow();
            }
        }
    }

    private class DisallowIntercept implements Runnable {
        DisallowIntercept() {
        }

        public void run() {
            ViewParent parent = ForwardingListener.this.mSrc.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }
    }

    private class TriggerLongPress implements Runnable {
        TriggerLongPress() {
        }

        public void run() {
            ForwardingListener.this.onLongPress();
        }
    }

    public abstract ShowableListMenu getPopup();

    public ForwardingListener(View view) {
        this.mTmpLocation = new int[2];
        this.mSrc = view;
        view.setLongClickable(true);
        if (VERSION.SDK_INT >= 12) {
            addDetachListenerApi12(view);
        } else {
            addDetachListenerBase(view);
        }
        this.mScaledTouchSlop = (float) ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        this.mTapTimeout = ViewConfiguration.getTapTimeout();
        this.mLongPressTimeout = (this.mTapTimeout + ViewConfiguration.getLongPressTimeout()) / 2;
    }

    @TargetApi(12)
    @RequiresApi(12)
    private void addDetachListenerApi12(View view) {
        view.addOnAttachStateChangeListener(new C03131());
    }

    private void addDetachListenerBase(View view) {
        view.getViewTreeObserver().addOnGlobalLayoutListener(new C03142());
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z;
        boolean z2 = this.mForwarding;
        if (!z2) {
            boolean z3 = onTouchObserved(motionEvent) && onForwardingStarted();
            if (z3) {
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                this.mSrc.onTouchEvent(obtain);
                obtain.recycle();
            }
            z = z3;
        } else if (onTouchForwarded(motionEvent) || !onForwardingStopped()) {
            z = true;
        } else {
            z = false;
        }
        this.mForwarding = z;
        if (z || z2) {
            return true;
        }
        return false;
    }

    private void onDetachedFromWindow() {
        this.mForwarding = false;
        this.mActivePointerId = -1;
        if (this.mDisallowIntercept != null) {
            this.mSrc.removeCallbacks(this.mDisallowIntercept);
        }
    }

    protected boolean onForwardingStarted() {
        ShowableListMenu popup = getPopup();
        if (!(popup == null || popup.isShowing())) {
            popup.show();
        }
        return true;
    }

    protected boolean onForwardingStopped() {
        ShowableListMenu popup = getPopup();
        if (popup != null && popup.isShowing()) {
            popup.dismiss();
        }
        return true;
    }

    private boolean onTouchObserved(MotionEvent motionEvent) {
        View view = this.mSrc;
        if (!view.isEnabled()) {
            return false;
        }
        switch (MotionEventCompat.getActionMasked(motionEvent)) {
            case NendAdIconLayout.HORIZONTAL /*0*/:
                this.mActivePointerId = motionEvent.getPointerId(0);
                if (this.mDisallowIntercept == null) {
                    this.mDisallowIntercept = new DisallowIntercept();
                }
                view.postDelayed(this.mDisallowIntercept, (long) this.mTapTimeout);
                if (this.mTriggerLongPress == null) {
                    this.mTriggerLongPress = new TriggerLongPress();
                }
                view.postDelayed(this.mTriggerLongPress, (long) this.mLongPressTimeout);
                return false;
            case NendIconError.ERROR_ICONVIEW /*1*/:
            case SendException.ERROR_TTL_EXCEEDED /*3*/:
                clearCallbacks();
                return false;
            case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                if (findPointerIndex < 0 || pointInView(view, motionEvent.getX(findPointerIndex), motionEvent.getY(findPointerIndex), this.mScaledTouchSlop)) {
                    return false;
                }
                clearCallbacks();
                view.getParent().requestDisallowInterceptTouchEvent(true);
                return true;
            default:
                return false;
        }
    }

    private void clearCallbacks() {
        if (this.mTriggerLongPress != null) {
            this.mSrc.removeCallbacks(this.mTriggerLongPress);
        }
        if (this.mDisallowIntercept != null) {
            this.mSrc.removeCallbacks(this.mDisallowIntercept);
        }
    }

    void onLongPress() {
        clearCallbacks();
        View view = this.mSrc;
        if (view.isEnabled() && !view.isLongClickable() && onForwardingStarted()) {
            view.getParent().requestDisallowInterceptTouchEvent(true);
            long uptimeMillis = SystemClock.uptimeMillis();
            MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
            view.onTouchEvent(obtain);
            obtain.recycle();
            this.mForwarding = true;
        }
    }

    private boolean onTouchForwarded(MotionEvent motionEvent) {
        View view = this.mSrc;
        ShowableListMenu popup = getPopup();
        if (popup == null || !popup.isShowing()) {
            return false;
        }
        DropDownListView dropDownListView = (DropDownListView) popup.getListView();
        if (dropDownListView == null || !dropDownListView.isShown()) {
            return false;
        }
        boolean z;
        MotionEvent obtainNoHistory = MotionEvent.obtainNoHistory(motionEvent);
        toGlobalMotionEvent(view, obtainNoHistory);
        toLocalMotionEvent(dropDownListView, obtainNoHistory);
        boolean onForwardedEvent = dropDownListView.onForwardedEvent(obtainNoHistory, this.mActivePointerId);
        obtainNoHistory.recycle();
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        if (actionMasked == 1 || actionMasked == 3) {
            z = false;
        } else {
            z = true;
        }
        if (onForwardedEvent && r0) {
            z = true;
        } else {
            z = false;
        }
        return z;
    }

    private static boolean pointInView(View view, float f, float f2, float f3) {
        return f >= (-f3) && f2 >= (-f3) && f < ((float) (view.getRight() - view.getLeft())) + f3 && f2 < ((float) (view.getBottom() - view.getTop())) + f3;
    }

    private boolean toLocalMotionEvent(View view, MotionEvent motionEvent) {
        int[] iArr = this.mTmpLocation;
        view.getLocationOnScreen(iArr);
        motionEvent.offsetLocation((float) (-iArr[0]), (float) (-iArr[1]));
        return true;
    }

    private boolean toGlobalMotionEvent(View view, MotionEvent motionEvent) {
        int[] iArr = this.mTmpLocation;
        view.getLocationOnScreen(iArr);
        motionEvent.offsetLocation((float) iArr[0], (float) iArr[1]);
        return true;
    }
}
