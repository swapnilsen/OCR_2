package android.support.v7.widget;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.OnFlingListener;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.support.v7.widget.RecyclerView.SmoothScroller;
import android.support.v7.widget.RecyclerView.SmoothScroller.Action;
import android.support.v7.widget.RecyclerView.SmoothScroller.ScrollVectorProvider;
import android.support.v7.widget.RecyclerView.State;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;

public abstract class SnapHelper extends OnFlingListener {
    static final float MILLISECONDS_PER_INCH = 100.0f;
    private Scroller mGravityScroller;
    RecyclerView mRecyclerView;
    private final OnScrollListener mScrollListener;

    /* renamed from: android.support.v7.widget.SnapHelper.1 */
    class C03471 extends OnScrollListener {
        boolean mScrolled;

        C03471() {
            this.mScrolled = false;
        }

        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            if (i == 0 && this.mScrolled) {
                this.mScrolled = false;
                SnapHelper.this.snapToTargetExistingView();
            }
        }

        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            if (i != 0 || i2 != 0) {
                this.mScrolled = true;
            }
        }
    }

    /* renamed from: android.support.v7.widget.SnapHelper.2 */
    class C03482 extends LinearSmoothScroller {
        C03482(Context context) {
            super(context);
        }

        protected void onTargetFound(View view, State state, Action action) {
            int[] calculateDistanceToFinalSnap = SnapHelper.this.calculateDistanceToFinalSnap(SnapHelper.this.mRecyclerView.getLayoutManager(), view);
            int i = calculateDistanceToFinalSnap[0];
            int i2 = calculateDistanceToFinalSnap[1];
            int calculateTimeForDeceleration = calculateTimeForDeceleration(Math.max(Math.abs(i), Math.abs(i2)));
            if (calculateTimeForDeceleration > 0) {
                action.update(i, i2, calculateTimeForDeceleration, this.mDecelerateInterpolator);
            }
        }

        protected float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
            return SnapHelper.MILLISECONDS_PER_INCH / ((float) displayMetrics.densityDpi);
        }
    }

    @Nullable
    public abstract int[] calculateDistanceToFinalSnap(@NonNull LayoutManager layoutManager, @NonNull View view);

    @Nullable
    public abstract View findSnapView(LayoutManager layoutManager);

    public abstract int findTargetSnapPosition(LayoutManager layoutManager, int i, int i2);

    public SnapHelper() {
        this.mScrollListener = new C03471();
    }

    public boolean onFling(int i, int i2) {
        LayoutManager layoutManager = this.mRecyclerView.getLayoutManager();
        if (layoutManager == null || this.mRecyclerView.getAdapter() == null) {
            return false;
        }
        int minFlingVelocity = this.mRecyclerView.getMinFlingVelocity();
        if ((Math.abs(i2) > minFlingVelocity || Math.abs(i) > minFlingVelocity) && snapFromFling(layoutManager, i, i2)) {
            return true;
        }
        return false;
    }

    public void attachToRecyclerView(@Nullable RecyclerView recyclerView) {
        if (this.mRecyclerView != recyclerView) {
            if (this.mRecyclerView != null) {
                destroyCallbacks();
            }
            this.mRecyclerView = recyclerView;
            if (this.mRecyclerView != null) {
                setupCallbacks();
                this.mGravityScroller = new Scroller(this.mRecyclerView.getContext(), new DecelerateInterpolator());
                snapToTargetExistingView();
            }
        }
    }

    private void setupCallbacks() {
        if (this.mRecyclerView.getOnFlingListener() != null) {
            throw new IllegalStateException("An instance of OnFlingListener already set.");
        }
        this.mRecyclerView.addOnScrollListener(this.mScrollListener);
        this.mRecyclerView.setOnFlingListener(this);
    }

    private void destroyCallbacks() {
        this.mRecyclerView.removeOnScrollListener(this.mScrollListener);
        this.mRecyclerView.setOnFlingListener(null);
    }

    public int[] calculateScrollDistance(int i, int i2) {
        r9 = new int[2];
        this.mGravityScroller.fling(0, 0, i, i2, RtlSpacingHelper.UNDEFINED, ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, RtlSpacingHelper.UNDEFINED, ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        r9[0] = this.mGravityScroller.getFinalX();
        r9[1] = this.mGravityScroller.getFinalY();
        return r9;
    }

    private boolean snapFromFling(@NonNull LayoutManager layoutManager, int i, int i2) {
        if (!(layoutManager instanceof ScrollVectorProvider)) {
            return false;
        }
        SmoothScroller createSnapScroller = createSnapScroller(layoutManager);
        if (createSnapScroller == null) {
            return false;
        }
        int findTargetSnapPosition = findTargetSnapPosition(layoutManager, i, i2);
        if (findTargetSnapPosition == -1) {
            return false;
        }
        createSnapScroller.setTargetPosition(findTargetSnapPosition);
        layoutManager.startSmoothScroll(createSnapScroller);
        return true;
    }

    void snapToTargetExistingView() {
        if (this.mRecyclerView != null) {
            LayoutManager layoutManager = this.mRecyclerView.getLayoutManager();
            if (layoutManager != null) {
                View findSnapView = findSnapView(layoutManager);
                if (findSnapView != null) {
                    int[] calculateDistanceToFinalSnap = calculateDistanceToFinalSnap(layoutManager, findSnapView);
                    if (calculateDistanceToFinalSnap[0] != 0 || calculateDistanceToFinalSnap[1] != 0) {
                        this.mRecyclerView.smoothScrollBy(calculateDistanceToFinalSnap[0], calculateDistanceToFinalSnap[1]);
                    }
                }
            }
        }
    }

    @Nullable
    protected LinearSmoothScroller createSnapScroller(LayoutManager layoutManager) {
        if (layoutManager instanceof ScrollVectorProvider) {
            return new C03482(this.mRecyclerView.getContext());
        }
        return null;
    }
}
