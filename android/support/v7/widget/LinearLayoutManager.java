package android.support.v7.widget;

import android.content.Context;
import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.media.TransportMediator;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.support.v4.view.accessibility.AccessibilityRecordCompat;
import android.support.v7.appcompat.C0268R;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.LayoutManager.LayoutPrefetchRegistry;
import android.support.v7.widget.RecyclerView.LayoutManager.Properties;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.Recycler;
import android.support.v7.widget.RecyclerView.SmoothScroller;
import android.support.v7.widget.RecyclerView.SmoothScroller.ScrollVectorProvider;
import android.support.v7.widget.RecyclerView.State;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.support.v7.widget.helper.ItemTouchHelper.ViewDropHandler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.List;

public class LinearLayoutManager extends LayoutManager implements ScrollVectorProvider, ViewDropHandler {
    static final boolean DEBUG = false;
    public static final int HORIZONTAL = 0;
    public static final int INVALID_OFFSET = Integer.MIN_VALUE;
    private static final float MAX_SCROLL_FACTOR = 0.33333334f;
    private static final String TAG = "LinearLayoutManager";
    public static final int VERTICAL = 1;
    final AnchorInfo mAnchorInfo;
    private int mInitialPrefetchItemCount;
    private boolean mLastStackFromEnd;
    private final LayoutChunkResult mLayoutChunkResult;
    private LayoutState mLayoutState;
    int mOrientation;
    OrientationHelper mOrientationHelper;
    SavedState mPendingSavedState;
    int mPendingScrollPosition;
    int mPendingScrollPositionOffset;
    private boolean mRecycleChildrenOnDetach;
    private boolean mReverseLayout;
    boolean mShouldReverseLayout;
    private boolean mSmoothScrollbarEnabled;
    private boolean mStackFromEnd;

    class AnchorInfo {
        int mCoordinate;
        boolean mLayoutFromEnd;
        int mPosition;
        boolean mValid;

        AnchorInfo() {
            reset();
        }

        void reset() {
            this.mPosition = -1;
            this.mCoordinate = LinearLayoutManager.INVALID_OFFSET;
            this.mLayoutFromEnd = LinearLayoutManager.DEBUG;
            this.mValid = LinearLayoutManager.DEBUG;
        }

        void assignCoordinateFromPadding() {
            int endAfterPadding;
            if (this.mLayoutFromEnd) {
                endAfterPadding = LinearLayoutManager.this.mOrientationHelper.getEndAfterPadding();
            } else {
                endAfterPadding = LinearLayoutManager.this.mOrientationHelper.getStartAfterPadding();
            }
            this.mCoordinate = endAfterPadding;
        }

        public String toString() {
            return "AnchorInfo{mPosition=" + this.mPosition + ", mCoordinate=" + this.mCoordinate + ", mLayoutFromEnd=" + this.mLayoutFromEnd + ", mValid=" + this.mValid + '}';
        }

        boolean isViewValidAsAnchor(View view, State state) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            return (layoutParams.isItemRemoved() || layoutParams.getViewLayoutPosition() < 0 || layoutParams.getViewLayoutPosition() >= state.getItemCount()) ? LinearLayoutManager.DEBUG : true;
        }

        public void assignFromViewAndKeepVisibleRect(View view) {
            int totalSpaceChange = LinearLayoutManager.this.mOrientationHelper.getTotalSpaceChange();
            if (totalSpaceChange >= 0) {
                assignFromView(view);
                return;
            }
            this.mPosition = LinearLayoutManager.this.getPosition(view);
            int decoratedMeasurement;
            if (this.mLayoutFromEnd) {
                totalSpaceChange = (LinearLayoutManager.this.mOrientationHelper.getEndAfterPadding() - totalSpaceChange) - LinearLayoutManager.this.mOrientationHelper.getDecoratedEnd(view);
                this.mCoordinate = LinearLayoutManager.this.mOrientationHelper.getEndAfterPadding() - totalSpaceChange;
                if (totalSpaceChange > 0) {
                    decoratedMeasurement = this.mCoordinate - LinearLayoutManager.this.mOrientationHelper.getDecoratedMeasurement(view);
                    int startAfterPadding = LinearLayoutManager.this.mOrientationHelper.getStartAfterPadding();
                    decoratedMeasurement -= startAfterPadding + Math.min(LinearLayoutManager.this.mOrientationHelper.getDecoratedStart(view) - startAfterPadding, LinearLayoutManager.HORIZONTAL);
                    if (decoratedMeasurement < 0) {
                        this.mCoordinate = Math.min(totalSpaceChange, -decoratedMeasurement) + this.mCoordinate;
                        return;
                    }
                    return;
                }
                return;
            }
            decoratedMeasurement = LinearLayoutManager.this.mOrientationHelper.getDecoratedStart(view);
            startAfterPadding = decoratedMeasurement - LinearLayoutManager.this.mOrientationHelper.getStartAfterPadding();
            this.mCoordinate = decoratedMeasurement;
            if (startAfterPadding > 0) {
                totalSpaceChange = (LinearLayoutManager.this.mOrientationHelper.getEndAfterPadding() - Math.min(LinearLayoutManager.HORIZONTAL, (LinearLayoutManager.this.mOrientationHelper.getEndAfterPadding() - totalSpaceChange) - LinearLayoutManager.this.mOrientationHelper.getDecoratedEnd(view))) - (decoratedMeasurement + LinearLayoutManager.this.mOrientationHelper.getDecoratedMeasurement(view));
                if (totalSpaceChange < 0) {
                    this.mCoordinate -= Math.min(startAfterPadding, -totalSpaceChange);
                }
            }
        }

        public void assignFromView(View view) {
            if (this.mLayoutFromEnd) {
                this.mCoordinate = LinearLayoutManager.this.mOrientationHelper.getDecoratedEnd(view) + LinearLayoutManager.this.mOrientationHelper.getTotalSpaceChange();
            } else {
                this.mCoordinate = LinearLayoutManager.this.mOrientationHelper.getDecoratedStart(view);
            }
            this.mPosition = LinearLayoutManager.this.getPosition(view);
        }
    }

    protected static class LayoutChunkResult {
        public int mConsumed;
        public boolean mFinished;
        public boolean mFocusable;
        public boolean mIgnoreConsumed;

        protected LayoutChunkResult() {
        }

        void resetInternal() {
            this.mConsumed = LinearLayoutManager.HORIZONTAL;
            this.mFinished = LinearLayoutManager.DEBUG;
            this.mIgnoreConsumed = LinearLayoutManager.DEBUG;
            this.mFocusable = LinearLayoutManager.DEBUG;
        }
    }

    static class LayoutState {
        static final int INVALID_LAYOUT = Integer.MIN_VALUE;
        static final int ITEM_DIRECTION_HEAD = -1;
        static final int ITEM_DIRECTION_TAIL = 1;
        static final int LAYOUT_END = 1;
        static final int LAYOUT_START = -1;
        static final int SCROLLING_OFFSET_NaN = Integer.MIN_VALUE;
        static final String TAG = "LLM#LayoutState";
        int mAvailable;
        int mCurrentPosition;
        int mExtra;
        boolean mInfinite;
        boolean mIsPreLayout;
        int mItemDirection;
        int mLastScrollDelta;
        int mLayoutDirection;
        int mOffset;
        boolean mRecycle;
        List<ViewHolder> mScrapList;
        int mScrollingOffset;

        LayoutState() {
            this.mRecycle = true;
            this.mExtra = LinearLayoutManager.HORIZONTAL;
            this.mIsPreLayout = LinearLayoutManager.DEBUG;
            this.mScrapList = null;
        }

        boolean hasMore(State state) {
            return (this.mCurrentPosition < 0 || this.mCurrentPosition >= state.getItemCount()) ? LinearLayoutManager.DEBUG : true;
        }

        View next(Recycler recycler) {
            if (this.mScrapList != null) {
                return nextViewFromScrapList();
            }
            View viewForPosition = recycler.getViewForPosition(this.mCurrentPosition);
            this.mCurrentPosition += this.mItemDirection;
            return viewForPosition;
        }

        private View nextViewFromScrapList() {
            int size = this.mScrapList.size();
            for (int i = LinearLayoutManager.HORIZONTAL; i < size; i += LAYOUT_END) {
                View view = ((ViewHolder) this.mScrapList.get(i)).itemView;
                LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                if (!layoutParams.isItemRemoved() && this.mCurrentPosition == layoutParams.getViewLayoutPosition()) {
                    assignPositionFromScrapList(view);
                    return view;
                }
            }
            return null;
        }

        public void assignPositionFromScrapList() {
            assignPositionFromScrapList(null);
        }

        public void assignPositionFromScrapList(View view) {
            View nextViewInLimitedList = nextViewInLimitedList(view);
            if (nextViewInLimitedList == null) {
                this.mCurrentPosition = LAYOUT_START;
            } else {
                this.mCurrentPosition = ((LayoutParams) nextViewInLimitedList.getLayoutParams()).getViewLayoutPosition();
            }
        }

        public View nextViewInLimitedList(View view) {
            int size = this.mScrapList.size();
            View view2 = null;
            int i = ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            int i2 = LinearLayoutManager.HORIZONTAL;
            while (i2 < size) {
                int i3;
                View view3;
                View view4 = ((ViewHolder) this.mScrapList.get(i2)).itemView;
                LayoutParams layoutParams = (LayoutParams) view4.getLayoutParams();
                if (view4 != view) {
                    if (layoutParams.isItemRemoved()) {
                        i3 = i;
                        view3 = view2;
                    } else {
                        i3 = (layoutParams.getViewLayoutPosition() - this.mCurrentPosition) * this.mItemDirection;
                        if (i3 < 0) {
                            i3 = i;
                            view3 = view2;
                        } else if (i3 < i) {
                            if (i3 == 0) {
                                return view4;
                            }
                            view3 = view4;
                        }
                    }
                    i2 += LAYOUT_END;
                    view2 = view3;
                    i = i3;
                }
                i3 = i;
                view3 = view2;
                i2 += LAYOUT_END;
                view2 = view3;
                i = i3;
            }
            return view2;
        }

        void log() {
            Log.d(TAG, "avail:" + this.mAvailable + ", ind:" + this.mCurrentPosition + ", dir:" + this.mItemDirection + ", offset:" + this.mOffset + ", layoutDir:" + this.mLayoutDirection);
        }
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public static class SavedState implements Parcelable {
        public static final Creator<SavedState> CREATOR;
        boolean mAnchorLayoutFromEnd;
        int mAnchorOffset;
        int mAnchorPosition;

        /* renamed from: android.support.v7.widget.LinearLayoutManager.SavedState.1 */
        static class C03161 implements Creator<SavedState> {
            C03161() {
            }

            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        }

        SavedState(Parcel parcel) {
            boolean z = true;
            this.mAnchorPosition = parcel.readInt();
            this.mAnchorOffset = parcel.readInt();
            if (parcel.readInt() != LinearLayoutManager.VERTICAL) {
                z = LinearLayoutManager.DEBUG;
            }
            this.mAnchorLayoutFromEnd = z;
        }

        public SavedState(SavedState savedState) {
            this.mAnchorPosition = savedState.mAnchorPosition;
            this.mAnchorOffset = savedState.mAnchorOffset;
            this.mAnchorLayoutFromEnd = savedState.mAnchorLayoutFromEnd;
        }

        boolean hasValidAnchor() {
            return this.mAnchorPosition >= 0 ? true : LinearLayoutManager.DEBUG;
        }

        void invalidateAnchor() {
            this.mAnchorPosition = -1;
        }

        public int describeContents() {
            return LinearLayoutManager.HORIZONTAL;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.mAnchorPosition);
            parcel.writeInt(this.mAnchorOffset);
            parcel.writeInt(this.mAnchorLayoutFromEnd ? LinearLayoutManager.VERTICAL : LinearLayoutManager.HORIZONTAL);
        }

        static {
            CREATOR = new C03161();
        }
    }

    public LinearLayoutManager(Context context) {
        this(context, VERTICAL, DEBUG);
    }

    public LinearLayoutManager(Context context, int i, boolean z) {
        this.mReverseLayout = DEBUG;
        this.mShouldReverseLayout = DEBUG;
        this.mStackFromEnd = DEBUG;
        this.mSmoothScrollbarEnabled = true;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = INVALID_OFFSET;
        this.mPendingSavedState = null;
        this.mAnchorInfo = new AnchorInfo();
        this.mLayoutChunkResult = new LayoutChunkResult();
        this.mInitialPrefetchItemCount = 2;
        setOrientation(i);
        setReverseLayout(z);
        setAutoMeasureEnabled(true);
    }

    public LinearLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        this.mReverseLayout = DEBUG;
        this.mShouldReverseLayout = DEBUG;
        this.mStackFromEnd = DEBUG;
        this.mSmoothScrollbarEnabled = true;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = INVALID_OFFSET;
        this.mPendingSavedState = null;
        this.mAnchorInfo = new AnchorInfo();
        this.mLayoutChunkResult = new LayoutChunkResult();
        this.mInitialPrefetchItemCount = 2;
        Properties properties = LayoutManager.getProperties(context, attributeSet, i, i2);
        setOrientation(properties.orientation);
        setReverseLayout(properties.reverseLayout);
        setStackFromEnd(properties.stackFromEnd);
        setAutoMeasureEnabled(true);
    }

    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    public boolean getRecycleChildrenOnDetach() {
        return this.mRecycleChildrenOnDetach;
    }

    public void setRecycleChildrenOnDetach(boolean z) {
        this.mRecycleChildrenOnDetach = z;
    }

    public void onDetachedFromWindow(RecyclerView recyclerView, Recycler recycler) {
        super.onDetachedFromWindow(recyclerView, recycler);
        if (this.mRecycleChildrenOnDetach) {
            removeAndRecycleAllViews(recycler);
            recycler.clear();
        }
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (getChildCount() > 0) {
            AccessibilityRecordCompat asRecord = AccessibilityEventCompat.asRecord(accessibilityEvent);
            asRecord.setFromIndex(findFirstVisibleItemPosition());
            asRecord.setToIndex(findLastVisibleItemPosition());
        }
    }

    public Parcelable onSaveInstanceState() {
        if (this.mPendingSavedState != null) {
            return new SavedState(this.mPendingSavedState);
        }
        Parcelable savedState = new SavedState();
        if (getChildCount() > 0) {
            ensureLayoutState();
            boolean z = this.mLastStackFromEnd ^ this.mShouldReverseLayout;
            savedState.mAnchorLayoutFromEnd = z;
            View childClosestToEnd;
            if (z) {
                childClosestToEnd = getChildClosestToEnd();
                savedState.mAnchorOffset = this.mOrientationHelper.getEndAfterPadding() - this.mOrientationHelper.getDecoratedEnd(childClosestToEnd);
                savedState.mAnchorPosition = getPosition(childClosestToEnd);
                return savedState;
            }
            childClosestToEnd = getChildClosestToStart();
            savedState.mAnchorPosition = getPosition(childClosestToEnd);
            savedState.mAnchorOffset = this.mOrientationHelper.getDecoratedStart(childClosestToEnd) - this.mOrientationHelper.getStartAfterPadding();
            return savedState;
        }
        savedState.invalidateAnchor();
        return savedState;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.mPendingSavedState = (SavedState) parcelable;
            requestLayout();
        }
    }

    public boolean canScrollHorizontally() {
        return this.mOrientation == 0 ? true : DEBUG;
    }

    public boolean canScrollVertically() {
        return this.mOrientation == VERTICAL ? true : DEBUG;
    }

    public void setStackFromEnd(boolean z) {
        assertNotInLayoutOrScroll(null);
        if (this.mStackFromEnd != z) {
            this.mStackFromEnd = z;
            requestLayout();
        }
    }

    public boolean getStackFromEnd() {
        return this.mStackFromEnd;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public void setOrientation(int i) {
        if (i == 0 || i == VERTICAL) {
            assertNotInLayoutOrScroll(null);
            if (i != this.mOrientation) {
                this.mOrientation = i;
                this.mOrientationHelper = null;
                requestLayout();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("invalid orientation:" + i);
    }

    private void resolveShouldLayoutReverse() {
        boolean z = true;
        if (this.mOrientation == VERTICAL || !isLayoutRTL()) {
            this.mShouldReverseLayout = this.mReverseLayout;
            return;
        }
        if (this.mReverseLayout) {
            z = DEBUG;
        }
        this.mShouldReverseLayout = z;
    }

    public boolean getReverseLayout() {
        return this.mReverseLayout;
    }

    public void setReverseLayout(boolean z) {
        assertNotInLayoutOrScroll(null);
        if (z != this.mReverseLayout) {
            this.mReverseLayout = z;
            requestLayout();
        }
    }

    public View findViewByPosition(int i) {
        int childCount = getChildCount();
        if (childCount == 0) {
            return null;
        }
        int position = i - getPosition(getChildAt(HORIZONTAL));
        if (position >= 0 && position < childCount) {
            View childAt = getChildAt(position);
            if (getPosition(childAt) == i) {
                return childAt;
            }
        }
        return super.findViewByPosition(i);
    }

    protected int getExtraLayoutSpace(State state) {
        if (state.hasTargetScrollPosition()) {
            return this.mOrientationHelper.getTotalSpace();
        }
        return HORIZONTAL;
    }

    public void smoothScrollToPosition(RecyclerView recyclerView, State state, int i) {
        SmoothScroller linearSmoothScroller = new LinearSmoothScroller(recyclerView.getContext());
        linearSmoothScroller.setTargetPosition(i);
        startSmoothScroll(linearSmoothScroller);
    }

    public PointF computeScrollVectorForPosition(int i) {
        int i2 = VERTICAL;
        boolean z = DEBUG;
        if (getChildCount() == 0) {
            return null;
        }
        if (i < getPosition(getChildAt(HORIZONTAL))) {
            z = VERTICAL;
        }
        if (z != this.mShouldReverseLayout) {
            i2 = -1;
        }
        if (this.mOrientation == 0) {
            return new PointF((float) i2, 0.0f);
        }
        return new PointF(0.0f, (float) i2);
    }

    public void onLayoutChildren(Recycler recycler, State state) {
        int i = -1;
        if (!(this.mPendingSavedState == null && this.mPendingScrollPosition == -1) && state.getItemCount() == 0) {
            removeAndRecycleAllViews(recycler);
            return;
        }
        int i2;
        int endAfterPadding;
        if (this.mPendingSavedState != null && this.mPendingSavedState.hasValidAnchor()) {
            this.mPendingScrollPosition = this.mPendingSavedState.mAnchorPosition;
        }
        ensureLayoutState();
        this.mLayoutState.mRecycle = DEBUG;
        resolveShouldLayoutReverse();
        if (!(this.mAnchorInfo.mValid && this.mPendingScrollPosition == -1 && this.mPendingSavedState == null)) {
            this.mAnchorInfo.reset();
            this.mAnchorInfo.mLayoutFromEnd = this.mShouldReverseLayout ^ this.mStackFromEnd;
            updateAnchorInfoForLayout(recycler, state, this.mAnchorInfo);
            this.mAnchorInfo.mValid = true;
        }
        int extraLayoutSpace = getExtraLayoutSpace(state);
        if (this.mLayoutState.mLastScrollDelta >= 0) {
            i2 = HORIZONTAL;
        } else {
            i2 = extraLayoutSpace;
            extraLayoutSpace = HORIZONTAL;
        }
        i2 += this.mOrientationHelper.getStartAfterPadding();
        extraLayoutSpace += this.mOrientationHelper.getEndPadding();
        if (!(!state.isPreLayout() || this.mPendingScrollPosition == -1 || this.mPendingScrollPositionOffset == INVALID_OFFSET)) {
            View findViewByPosition = findViewByPosition(this.mPendingScrollPosition);
            if (findViewByPosition != null) {
                if (this.mShouldReverseLayout) {
                    endAfterPadding = (this.mOrientationHelper.getEndAfterPadding() - this.mOrientationHelper.getDecoratedEnd(findViewByPosition)) - this.mPendingScrollPositionOffset;
                } else {
                    endAfterPadding = this.mPendingScrollPositionOffset - (this.mOrientationHelper.getDecoratedStart(findViewByPosition) - this.mOrientationHelper.getStartAfterPadding());
                }
                if (endAfterPadding > 0) {
                    i2 += endAfterPadding;
                } else {
                    extraLayoutSpace -= endAfterPadding;
                }
            }
        }
        if (this.mAnchorInfo.mLayoutFromEnd) {
            if (this.mShouldReverseLayout) {
                i = VERTICAL;
            }
        } else if (!this.mShouldReverseLayout) {
            i = VERTICAL;
        }
        onAnchorReady(recycler, state, this.mAnchorInfo, i);
        detachAndScrapAttachedViews(recycler);
        this.mLayoutState.mInfinite = resolveIsInfinite();
        this.mLayoutState.mIsPreLayout = state.isPreLayout();
        if (this.mAnchorInfo.mLayoutFromEnd) {
            updateLayoutStateToFillStart(this.mAnchorInfo);
            this.mLayoutState.mExtra = i2;
            fill(recycler, this.mLayoutState, state, DEBUG);
            i2 = this.mLayoutState.mOffset;
            endAfterPadding = this.mLayoutState.mCurrentPosition;
            if (this.mLayoutState.mAvailable > 0) {
                extraLayoutSpace += this.mLayoutState.mAvailable;
            }
            updateLayoutStateToFillEnd(this.mAnchorInfo);
            this.mLayoutState.mExtra = extraLayoutSpace;
            LayoutState layoutState = this.mLayoutState;
            layoutState.mCurrentPosition += this.mLayoutState.mItemDirection;
            fill(recycler, this.mLayoutState, state, DEBUG);
            i = this.mLayoutState.mOffset;
            if (this.mLayoutState.mAvailable > 0) {
                extraLayoutSpace = this.mLayoutState.mAvailable;
                updateLayoutStateToFillStart(endAfterPadding, i2);
                this.mLayoutState.mExtra = extraLayoutSpace;
                fill(recycler, this.mLayoutState, state, DEBUG);
                extraLayoutSpace = this.mLayoutState.mOffset;
            } else {
                extraLayoutSpace = i2;
            }
            i2 = extraLayoutSpace;
            extraLayoutSpace = i;
        } else {
            updateLayoutStateToFillEnd(this.mAnchorInfo);
            this.mLayoutState.mExtra = extraLayoutSpace;
            fill(recycler, this.mLayoutState, state, DEBUG);
            extraLayoutSpace = this.mLayoutState.mOffset;
            i = this.mLayoutState.mCurrentPosition;
            if (this.mLayoutState.mAvailable > 0) {
                i2 += this.mLayoutState.mAvailable;
            }
            updateLayoutStateToFillStart(this.mAnchorInfo);
            this.mLayoutState.mExtra = i2;
            LayoutState layoutState2 = this.mLayoutState;
            layoutState2.mCurrentPosition += this.mLayoutState.mItemDirection;
            fill(recycler, this.mLayoutState, state, DEBUG);
            i2 = this.mLayoutState.mOffset;
            if (this.mLayoutState.mAvailable > 0) {
                endAfterPadding = this.mLayoutState.mAvailable;
                updateLayoutStateToFillEnd(i, extraLayoutSpace);
                this.mLayoutState.mExtra = endAfterPadding;
                fill(recycler, this.mLayoutState, state, DEBUG);
                extraLayoutSpace = this.mLayoutState.mOffset;
            }
        }
        if (getChildCount() > 0) {
            int fixLayoutStartGap;
            if ((this.mShouldReverseLayout ^ this.mStackFromEnd) != 0) {
                i = fixLayoutEndGap(extraLayoutSpace, recycler, state, true);
                i2 += i;
                extraLayoutSpace += i;
                fixLayoutStartGap = fixLayoutStartGap(i2, recycler, state, DEBUG);
                i2 += fixLayoutStartGap;
                extraLayoutSpace += fixLayoutStartGap;
            } else {
                i = fixLayoutStartGap(i2, recycler, state, true);
                i2 += i;
                extraLayoutSpace += i;
                fixLayoutStartGap = fixLayoutEndGap(extraLayoutSpace, recycler, state, DEBUG);
                i2 += fixLayoutStartGap;
                extraLayoutSpace += fixLayoutStartGap;
            }
        }
        layoutForPredictiveAnimations(recycler, state, i2, extraLayoutSpace);
        if (state.isPreLayout()) {
            this.mAnchorInfo.reset();
        } else {
            this.mOrientationHelper.onLayoutComplete();
        }
        this.mLastStackFromEnd = this.mStackFromEnd;
    }

    public void onLayoutCompleted(State state) {
        super.onLayoutCompleted(state);
        this.mPendingSavedState = null;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = INVALID_OFFSET;
        this.mAnchorInfo.reset();
    }

    void onAnchorReady(Recycler recycler, State state, AnchorInfo anchorInfo, int i) {
    }

    private void layoutForPredictiveAnimations(Recycler recycler, State state, int i, int i2) {
        if (state.willRunPredictiveAnimations() && getChildCount() != 0 && !state.isPreLayout() && supportsPredictiveItemAnimations()) {
            int i3 = HORIZONTAL;
            int i4 = HORIZONTAL;
            List scrapList = recycler.getScrapList();
            int size = scrapList.size();
            int position = getPosition(getChildAt(HORIZONTAL));
            int i5 = HORIZONTAL;
            while (i5 < size) {
                int i6;
                int i7;
                ViewHolder viewHolder = (ViewHolder) scrapList.get(i5);
                if (viewHolder.isRemoved()) {
                    i6 = i4;
                    i7 = i3;
                } else {
                    if (((viewHolder.getLayoutPosition() < position ? true : DEBUG) != this.mShouldReverseLayout ? -1 : VERTICAL) == -1) {
                        i7 = this.mOrientationHelper.getDecoratedMeasurement(viewHolder.itemView) + i3;
                        i6 = i4;
                    } else {
                        i6 = this.mOrientationHelper.getDecoratedMeasurement(viewHolder.itemView) + i4;
                        i7 = i3;
                    }
                }
                i5 += VERTICAL;
                i3 = i7;
                i4 = i6;
            }
            this.mLayoutState.mScrapList = scrapList;
            if (i3 > 0) {
                updateLayoutStateToFillStart(getPosition(getChildClosestToStart()), i);
                this.mLayoutState.mExtra = i3;
                this.mLayoutState.mAvailable = HORIZONTAL;
                this.mLayoutState.assignPositionFromScrapList();
                fill(recycler, this.mLayoutState, state, DEBUG);
            }
            if (i4 > 0) {
                updateLayoutStateToFillEnd(getPosition(getChildClosestToEnd()), i2);
                this.mLayoutState.mExtra = i4;
                this.mLayoutState.mAvailable = HORIZONTAL;
                this.mLayoutState.assignPositionFromScrapList();
                fill(recycler, this.mLayoutState, state, DEBUG);
            }
            this.mLayoutState.mScrapList = null;
        }
    }

    private void updateAnchorInfoForLayout(Recycler recycler, State state, AnchorInfo anchorInfo) {
        if (!updateAnchorFromPendingData(state, anchorInfo) && !updateAnchorFromChildren(recycler, state, anchorInfo)) {
            anchorInfo.assignCoordinateFromPadding();
            anchorInfo.mPosition = this.mStackFromEnd ? state.getItemCount() - 1 : HORIZONTAL;
        }
    }

    private boolean updateAnchorFromChildren(Recycler recycler, State state, AnchorInfo anchorInfo) {
        boolean z = DEBUG;
        if (getChildCount() == 0) {
            return DEBUG;
        }
        View focusedChild = getFocusedChild();
        if (focusedChild != null && anchorInfo.isViewValidAsAnchor(focusedChild, state)) {
            anchorInfo.assignFromViewAndKeepVisibleRect(focusedChild);
            return true;
        } else if (this.mLastStackFromEnd != this.mStackFromEnd) {
            return DEBUG;
        } else {
            if (anchorInfo.mLayoutFromEnd) {
                focusedChild = findReferenceChildClosestToEnd(recycler, state);
            } else {
                focusedChild = findReferenceChildClosestToStart(recycler, state);
            }
            if (focusedChild == null) {
                return DEBUG;
            }
            anchorInfo.assignFromView(focusedChild);
            if (!state.isPreLayout() && supportsPredictiveItemAnimations()) {
                if (this.mOrientationHelper.getDecoratedStart(focusedChild) >= this.mOrientationHelper.getEndAfterPadding() || this.mOrientationHelper.getDecoratedEnd(focusedChild) < this.mOrientationHelper.getStartAfterPadding()) {
                    z = true;
                }
                if (z) {
                    int endAfterPadding;
                    if (anchorInfo.mLayoutFromEnd) {
                        endAfterPadding = this.mOrientationHelper.getEndAfterPadding();
                    } else {
                        endAfterPadding = this.mOrientationHelper.getStartAfterPadding();
                    }
                    anchorInfo.mCoordinate = endAfterPadding;
                }
            }
            return true;
        }
    }

    private boolean updateAnchorFromPendingData(State state, AnchorInfo anchorInfo) {
        boolean z = DEBUG;
        if (state.isPreLayout() || this.mPendingScrollPosition == -1) {
            return DEBUG;
        }
        if (this.mPendingScrollPosition < 0 || this.mPendingScrollPosition >= state.getItemCount()) {
            this.mPendingScrollPosition = -1;
            this.mPendingScrollPositionOffset = INVALID_OFFSET;
            return DEBUG;
        }
        anchorInfo.mPosition = this.mPendingScrollPosition;
        if (this.mPendingSavedState != null && this.mPendingSavedState.hasValidAnchor()) {
            anchorInfo.mLayoutFromEnd = this.mPendingSavedState.mAnchorLayoutFromEnd;
            if (anchorInfo.mLayoutFromEnd) {
                anchorInfo.mCoordinate = this.mOrientationHelper.getEndAfterPadding() - this.mPendingSavedState.mAnchorOffset;
                return true;
            }
            anchorInfo.mCoordinate = this.mOrientationHelper.getStartAfterPadding() + this.mPendingSavedState.mAnchorOffset;
            return true;
        } else if (this.mPendingScrollPositionOffset == INVALID_OFFSET) {
            View findViewByPosition = findViewByPosition(this.mPendingScrollPosition);
            if (findViewByPosition == null) {
                if (getChildCount() > 0) {
                    boolean z2;
                    if (this.mPendingScrollPosition < getPosition(getChildAt(HORIZONTAL))) {
                        z2 = true;
                    } else {
                        z2 = DEBUG;
                    }
                    if (z2 == this.mShouldReverseLayout) {
                        z = true;
                    }
                    anchorInfo.mLayoutFromEnd = z;
                }
                anchorInfo.assignCoordinateFromPadding();
                return true;
            } else if (this.mOrientationHelper.getDecoratedMeasurement(findViewByPosition) > this.mOrientationHelper.getTotalSpace()) {
                anchorInfo.assignCoordinateFromPadding();
                return true;
            } else if (this.mOrientationHelper.getDecoratedStart(findViewByPosition) - this.mOrientationHelper.getStartAfterPadding() < 0) {
                anchorInfo.mCoordinate = this.mOrientationHelper.getStartAfterPadding();
                anchorInfo.mLayoutFromEnd = DEBUG;
                return true;
            } else if (this.mOrientationHelper.getEndAfterPadding() - this.mOrientationHelper.getDecoratedEnd(findViewByPosition) < 0) {
                anchorInfo.mCoordinate = this.mOrientationHelper.getEndAfterPadding();
                anchorInfo.mLayoutFromEnd = true;
                return true;
            } else {
                int decoratedEnd;
                if (anchorInfo.mLayoutFromEnd) {
                    decoratedEnd = this.mOrientationHelper.getDecoratedEnd(findViewByPosition) + this.mOrientationHelper.getTotalSpaceChange();
                } else {
                    decoratedEnd = this.mOrientationHelper.getDecoratedStart(findViewByPosition);
                }
                anchorInfo.mCoordinate = decoratedEnd;
                return true;
            }
        } else {
            anchorInfo.mLayoutFromEnd = this.mShouldReverseLayout;
            if (this.mShouldReverseLayout) {
                anchorInfo.mCoordinate = this.mOrientationHelper.getEndAfterPadding() - this.mPendingScrollPositionOffset;
                return true;
            }
            anchorInfo.mCoordinate = this.mOrientationHelper.getStartAfterPadding() + this.mPendingScrollPositionOffset;
            return true;
        }
    }

    private int fixLayoutEndGap(int i, Recycler recycler, State state, boolean z) {
        int endAfterPadding = this.mOrientationHelper.getEndAfterPadding() - i;
        if (endAfterPadding <= 0) {
            return HORIZONTAL;
        }
        endAfterPadding = -scrollBy(-endAfterPadding, recycler, state);
        int i2 = i + endAfterPadding;
        if (!z) {
            return endAfterPadding;
        }
        i2 = this.mOrientationHelper.getEndAfterPadding() - i2;
        if (i2 <= 0) {
            return endAfterPadding;
        }
        this.mOrientationHelper.offsetChildren(i2);
        return endAfterPadding + i2;
    }

    private int fixLayoutStartGap(int i, Recycler recycler, State state, boolean z) {
        int startAfterPadding = i - this.mOrientationHelper.getStartAfterPadding();
        if (startAfterPadding <= 0) {
            return HORIZONTAL;
        }
        startAfterPadding = -scrollBy(startAfterPadding, recycler, state);
        int i2 = i + startAfterPadding;
        if (!z) {
            return startAfterPadding;
        }
        i2 -= this.mOrientationHelper.getStartAfterPadding();
        if (i2 <= 0) {
            return startAfterPadding;
        }
        this.mOrientationHelper.offsetChildren(-i2);
        return startAfterPadding - i2;
    }

    private void updateLayoutStateToFillEnd(AnchorInfo anchorInfo) {
        updateLayoutStateToFillEnd(anchorInfo.mPosition, anchorInfo.mCoordinate);
    }

    private void updateLayoutStateToFillEnd(int i, int i2) {
        this.mLayoutState.mAvailable = this.mOrientationHelper.getEndAfterPadding() - i2;
        this.mLayoutState.mItemDirection = this.mShouldReverseLayout ? -1 : VERTICAL;
        this.mLayoutState.mCurrentPosition = i;
        this.mLayoutState.mLayoutDirection = VERTICAL;
        this.mLayoutState.mOffset = i2;
        this.mLayoutState.mScrollingOffset = INVALID_OFFSET;
    }

    private void updateLayoutStateToFillStart(AnchorInfo anchorInfo) {
        updateLayoutStateToFillStart(anchorInfo.mPosition, anchorInfo.mCoordinate);
    }

    private void updateLayoutStateToFillStart(int i, int i2) {
        this.mLayoutState.mAvailable = i2 - this.mOrientationHelper.getStartAfterPadding();
        this.mLayoutState.mCurrentPosition = i;
        this.mLayoutState.mItemDirection = this.mShouldReverseLayout ? VERTICAL : -1;
        this.mLayoutState.mLayoutDirection = -1;
        this.mLayoutState.mOffset = i2;
        this.mLayoutState.mScrollingOffset = INVALID_OFFSET;
    }

    protected boolean isLayoutRTL() {
        return getLayoutDirection() == VERTICAL ? true : DEBUG;
    }

    void ensureLayoutState() {
        if (this.mLayoutState == null) {
            this.mLayoutState = createLayoutState();
        }
        if (this.mOrientationHelper == null) {
            this.mOrientationHelper = OrientationHelper.createOrientationHelper(this, this.mOrientation);
        }
    }

    LayoutState createLayoutState() {
        return new LayoutState();
    }

    public void scrollToPosition(int i) {
        this.mPendingScrollPosition = i;
        this.mPendingScrollPositionOffset = INVALID_OFFSET;
        if (this.mPendingSavedState != null) {
            this.mPendingSavedState.invalidateAnchor();
        }
        requestLayout();
    }

    public void scrollToPositionWithOffset(int i, int i2) {
        this.mPendingScrollPosition = i;
        this.mPendingScrollPositionOffset = i2;
        if (this.mPendingSavedState != null) {
            this.mPendingSavedState.invalidateAnchor();
        }
        requestLayout();
    }

    public int scrollHorizontallyBy(int i, Recycler recycler, State state) {
        if (this.mOrientation == VERTICAL) {
            return HORIZONTAL;
        }
        return scrollBy(i, recycler, state);
    }

    public int scrollVerticallyBy(int i, Recycler recycler, State state) {
        if (this.mOrientation == 0) {
            return HORIZONTAL;
        }
        return scrollBy(i, recycler, state);
    }

    public int computeHorizontalScrollOffset(State state) {
        return computeScrollOffset(state);
    }

    public int computeVerticalScrollOffset(State state) {
        return computeScrollOffset(state);
    }

    public int computeHorizontalScrollExtent(State state) {
        return computeScrollExtent(state);
    }

    public int computeVerticalScrollExtent(State state) {
        return computeScrollExtent(state);
    }

    public int computeHorizontalScrollRange(State state) {
        return computeScrollRange(state);
    }

    public int computeVerticalScrollRange(State state) {
        return computeScrollRange(state);
    }

    private int computeScrollOffset(State state) {
        boolean z = DEBUG;
        if (getChildCount() == 0) {
            return HORIZONTAL;
        }
        ensureLayoutState();
        OrientationHelper orientationHelper = this.mOrientationHelper;
        View findFirstVisibleChildClosestToStart = findFirstVisibleChildClosestToStart(!this.mSmoothScrollbarEnabled ? true : DEBUG, true);
        if (!this.mSmoothScrollbarEnabled) {
            z = true;
        }
        return ScrollbarHelper.computeScrollOffset(state, orientationHelper, findFirstVisibleChildClosestToStart, findFirstVisibleChildClosestToEnd(z, true), this, this.mSmoothScrollbarEnabled, this.mShouldReverseLayout);
    }

    private int computeScrollExtent(State state) {
        boolean z = DEBUG;
        if (getChildCount() == 0) {
            return HORIZONTAL;
        }
        ensureLayoutState();
        OrientationHelper orientationHelper = this.mOrientationHelper;
        View findFirstVisibleChildClosestToStart = findFirstVisibleChildClosestToStart(!this.mSmoothScrollbarEnabled ? true : DEBUG, true);
        if (!this.mSmoothScrollbarEnabled) {
            z = true;
        }
        return ScrollbarHelper.computeScrollExtent(state, orientationHelper, findFirstVisibleChildClosestToStart, findFirstVisibleChildClosestToEnd(z, true), this, this.mSmoothScrollbarEnabled);
    }

    private int computeScrollRange(State state) {
        boolean z = DEBUG;
        if (getChildCount() == 0) {
            return HORIZONTAL;
        }
        ensureLayoutState();
        OrientationHelper orientationHelper = this.mOrientationHelper;
        View findFirstVisibleChildClosestToStart = findFirstVisibleChildClosestToStart(!this.mSmoothScrollbarEnabled ? true : DEBUG, true);
        if (!this.mSmoothScrollbarEnabled) {
            z = true;
        }
        return ScrollbarHelper.computeScrollRange(state, orientationHelper, findFirstVisibleChildClosestToStart, findFirstVisibleChildClosestToEnd(z, true), this, this.mSmoothScrollbarEnabled);
    }

    public void setSmoothScrollbarEnabled(boolean z) {
        this.mSmoothScrollbarEnabled = z;
    }

    public boolean isSmoothScrollbarEnabled() {
        return this.mSmoothScrollbarEnabled;
    }

    private void updateLayoutState(int i, int i2, boolean z, State state) {
        int i3 = -1;
        int i4 = VERTICAL;
        this.mLayoutState.mInfinite = resolveIsInfinite();
        this.mLayoutState.mExtra = getExtraLayoutSpace(state);
        this.mLayoutState.mLayoutDirection = i;
        View childClosestToEnd;
        LayoutState layoutState;
        if (i == VERTICAL) {
            LayoutState layoutState2 = this.mLayoutState;
            layoutState2.mExtra += this.mOrientationHelper.getEndPadding();
            childClosestToEnd = getChildClosestToEnd();
            layoutState = this.mLayoutState;
            if (!this.mShouldReverseLayout) {
                i3 = VERTICAL;
            }
            layoutState.mItemDirection = i3;
            this.mLayoutState.mCurrentPosition = getPosition(childClosestToEnd) + this.mLayoutState.mItemDirection;
            this.mLayoutState.mOffset = this.mOrientationHelper.getDecoratedEnd(childClosestToEnd);
            i3 = this.mOrientationHelper.getDecoratedEnd(childClosestToEnd) - this.mOrientationHelper.getEndAfterPadding();
        } else {
            childClosestToEnd = getChildClosestToStart();
            layoutState = this.mLayoutState;
            layoutState.mExtra += this.mOrientationHelper.getStartAfterPadding();
            layoutState = this.mLayoutState;
            if (!this.mShouldReverseLayout) {
                i4 = -1;
            }
            layoutState.mItemDirection = i4;
            this.mLayoutState.mCurrentPosition = getPosition(childClosestToEnd) + this.mLayoutState.mItemDirection;
            this.mLayoutState.mOffset = this.mOrientationHelper.getDecoratedStart(childClosestToEnd);
            i3 = (-this.mOrientationHelper.getDecoratedStart(childClosestToEnd)) + this.mOrientationHelper.getStartAfterPadding();
        }
        this.mLayoutState.mAvailable = i2;
        if (z) {
            LayoutState layoutState3 = this.mLayoutState;
            layoutState3.mAvailable -= i3;
        }
        this.mLayoutState.mScrollingOffset = i3;
    }

    boolean resolveIsInfinite() {
        return (this.mOrientationHelper.getMode() == 0 && this.mOrientationHelper.getEnd() == 0) ? true : DEBUG;
    }

    void collectPrefetchPositionsForLayoutState(State state, LayoutState layoutState, LayoutPrefetchRegistry layoutPrefetchRegistry) {
        int i = layoutState.mCurrentPosition;
        if (i >= 0 && i < state.getItemCount()) {
            layoutPrefetchRegistry.addPosition(i, Math.max(HORIZONTAL, layoutState.mScrollingOffset));
        }
    }

    public void collectInitialPrefetchPositions(int i, LayoutPrefetchRegistry layoutPrefetchRegistry) {
        int i2;
        boolean z;
        if (this.mPendingSavedState == null || !this.mPendingSavedState.hasValidAnchor()) {
            resolveShouldLayoutReverse();
            boolean z2 = this.mShouldReverseLayout;
            if (this.mPendingScrollPosition == -1) {
                i2 = z2 ? i - 1 : HORIZONTAL;
                z = z2;
            } else {
                i2 = this.mPendingScrollPosition;
                z = z2;
            }
        } else {
            z = this.mPendingSavedState.mAnchorLayoutFromEnd;
            i2 = this.mPendingSavedState.mAnchorPosition;
        }
        int i3 = z ? -1 : VERTICAL;
        for (int i4 = HORIZONTAL; i4 < this.mInitialPrefetchItemCount && i2 >= 0 && i2 < i; i4 += VERTICAL) {
            layoutPrefetchRegistry.addPosition(i2, HORIZONTAL);
            i2 += i3;
        }
    }

    public void setInitialPrefetchItemCount(int i) {
        this.mInitialPrefetchItemCount = i;
    }

    public int getInitialPrefetchItemCount() {
        return this.mInitialPrefetchItemCount;
    }

    @Deprecated
    public int getInitialItemPrefetchCount() {
        return getInitialPrefetchItemCount();
    }

    public void collectAdjacentPrefetchPositions(int i, int i2, State state, LayoutPrefetchRegistry layoutPrefetchRegistry) {
        if (this.mOrientation != 0) {
            i = i2;
        }
        if (getChildCount() != 0 && i != 0) {
            updateLayoutState(i > 0 ? VERTICAL : -1, Math.abs(i), true, state);
            collectPrefetchPositionsForLayoutState(state, this.mLayoutState, layoutPrefetchRegistry);
        }
    }

    int scrollBy(int i, Recycler recycler, State state) {
        if (getChildCount() == 0 || i == 0) {
            return HORIZONTAL;
        }
        this.mLayoutState.mRecycle = true;
        ensureLayoutState();
        int i2 = i > 0 ? VERTICAL : -1;
        int abs = Math.abs(i);
        updateLayoutState(i2, abs, true, state);
        int fill = this.mLayoutState.mScrollingOffset + fill(recycler, this.mLayoutState, state, DEBUG);
        if (fill < 0) {
            return HORIZONTAL;
        }
        if (abs > fill) {
            i = i2 * fill;
        }
        this.mOrientationHelper.offsetChildren(-i);
        this.mLayoutState.mLastScrollDelta = i;
        return i;
    }

    public void assertNotInLayoutOrScroll(String str) {
        if (this.mPendingSavedState == null) {
            super.assertNotInLayoutOrScroll(str);
        }
    }

    private void recycleChildren(Recycler recycler, int i, int i2) {
        if (i != i2) {
            if (i2 > i) {
                for (int i3 = i2 - 1; i3 >= i; i3--) {
                    removeAndRecycleViewAt(i3, recycler);
                }
                return;
            }
            while (i > i2) {
                removeAndRecycleViewAt(i, recycler);
                i--;
            }
        }
    }

    private void recycleViewsFromStart(Recycler recycler, int i) {
        if (i >= 0) {
            int childCount = getChildCount();
            int i2;
            if (this.mShouldReverseLayout) {
                for (i2 = childCount - 1; i2 >= 0; i2--) {
                    View childAt = getChildAt(i2);
                    if (this.mOrientationHelper.getDecoratedEnd(childAt) > i || this.mOrientationHelper.getTransformedEndWithDecoration(childAt) > i) {
                        recycleChildren(recycler, childCount - 1, i2);
                        return;
                    }
                }
                return;
            }
            for (i2 = HORIZONTAL; i2 < childCount; i2 += VERTICAL) {
                View childAt2 = getChildAt(i2);
                if (this.mOrientationHelper.getDecoratedEnd(childAt2) > i || this.mOrientationHelper.getTransformedEndWithDecoration(childAt2) > i) {
                    recycleChildren(recycler, HORIZONTAL, i2);
                    return;
                }
            }
        }
    }

    private void recycleViewsFromEnd(Recycler recycler, int i) {
        int childCount = getChildCount();
        if (i >= 0) {
            int end = this.mOrientationHelper.getEnd() - i;
            int i2;
            if (this.mShouldReverseLayout) {
                for (i2 = HORIZONTAL; i2 < childCount; i2 += VERTICAL) {
                    View childAt = getChildAt(i2);
                    if (this.mOrientationHelper.getDecoratedStart(childAt) < end || this.mOrientationHelper.getTransformedStartWithDecoration(childAt) < end) {
                        recycleChildren(recycler, HORIZONTAL, i2);
                        return;
                    }
                }
                return;
            }
            for (i2 = childCount - 1; i2 >= 0; i2--) {
                View childAt2 = getChildAt(i2);
                if (this.mOrientationHelper.getDecoratedStart(childAt2) < end || this.mOrientationHelper.getTransformedStartWithDecoration(childAt2) < end) {
                    recycleChildren(recycler, childCount - 1, i2);
                    return;
                }
            }
        }
    }

    private void recycleByLayoutState(Recycler recycler, LayoutState layoutState) {
        if (layoutState.mRecycle && !layoutState.mInfinite) {
            if (layoutState.mLayoutDirection == -1) {
                recycleViewsFromEnd(recycler, layoutState.mScrollingOffset);
            } else {
                recycleViewsFromStart(recycler, layoutState.mScrollingOffset);
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    int fill(android.support.v7.widget.RecyclerView.Recycler r8, android.support.v7.widget.LinearLayoutManager.LayoutState r9, android.support.v7.widget.RecyclerView.State r10, boolean r11) {
        /*
        r7 = this;
        r6 = -2147483648; // 0xffffffff80000000 float:-0.0 double:NaN;
        r1 = r9.mAvailable;
        r0 = r9.mScrollingOffset;
        if (r0 == r6) goto L_0x0016;
    L_0x0008:
        r0 = r9.mAvailable;
        if (r0 >= 0) goto L_0x0013;
    L_0x000c:
        r0 = r9.mScrollingOffset;
        r2 = r9.mAvailable;
        r0 = r0 + r2;
        r9.mScrollingOffset = r0;
    L_0x0013:
        r7.recycleByLayoutState(r8, r9);
    L_0x0016:
        r0 = r9.mAvailable;
        r2 = r9.mExtra;
        r0 = r0 + r2;
        r2 = r7.mLayoutChunkResult;
    L_0x001d:
        r3 = r9.mInfinite;
        if (r3 != 0) goto L_0x0023;
    L_0x0021:
        if (r0 <= 0) goto L_0x0033;
    L_0x0023:
        r3 = r9.hasMore(r10);
        if (r3 == 0) goto L_0x0033;
    L_0x0029:
        r2.resetInternal();
        r7.layoutChunk(r8, r10, r9, r2);
        r3 = r2.mFinished;
        if (r3 == 0) goto L_0x0038;
    L_0x0033:
        r0 = r9.mAvailable;
        r0 = r1 - r0;
        return r0;
    L_0x0038:
        r3 = r9.mOffset;
        r4 = r2.mConsumed;
        r5 = r9.mLayoutDirection;
        r4 = r4 * r5;
        r3 = r3 + r4;
        r9.mOffset = r3;
        r3 = r2.mIgnoreConsumed;
        if (r3 == 0) goto L_0x0052;
    L_0x0046:
        r3 = r7.mLayoutState;
        r3 = r3.mScrapList;
        if (r3 != 0) goto L_0x0052;
    L_0x004c:
        r3 = r10.isPreLayout();
        if (r3 != 0) goto L_0x005c;
    L_0x0052:
        r3 = r9.mAvailable;
        r4 = r2.mConsumed;
        r3 = r3 - r4;
        r9.mAvailable = r3;
        r3 = r2.mConsumed;
        r0 = r0 - r3;
    L_0x005c:
        r3 = r9.mScrollingOffset;
        if (r3 == r6) goto L_0x0075;
    L_0x0060:
        r3 = r9.mScrollingOffset;
        r4 = r2.mConsumed;
        r3 = r3 + r4;
        r9.mScrollingOffset = r3;
        r3 = r9.mAvailable;
        if (r3 >= 0) goto L_0x0072;
    L_0x006b:
        r3 = r9.mScrollingOffset;
        r4 = r9.mAvailable;
        r3 = r3 + r4;
        r9.mScrollingOffset = r3;
    L_0x0072:
        r7.recycleByLayoutState(r8, r9);
    L_0x0075:
        if (r11 == 0) goto L_0x001d;
    L_0x0077:
        r3 = r2.mFocusable;
        if (r3 == 0) goto L_0x001d;
    L_0x007b:
        goto L_0x0033;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.LinearLayoutManager.fill(android.support.v7.widget.RecyclerView$Recycler, android.support.v7.widget.LinearLayoutManager$LayoutState, android.support.v7.widget.RecyclerView$State, boolean):int");
    }

    void layoutChunk(Recycler recycler, State state, LayoutState layoutState, LayoutChunkResult layoutChunkResult) {
        View next = layoutState.next(recycler);
        if (next == null) {
            layoutChunkResult.mFinished = true;
            return;
        }
        int decoratedMeasurementInOther;
        int i;
        int i2;
        int i3;
        LayoutParams layoutParams = (LayoutParams) next.getLayoutParams();
        if (layoutState.mScrapList == null) {
            if (this.mShouldReverseLayout == (layoutState.mLayoutDirection == -1 ? true : HORIZONTAL)) {
                addView(next);
            } else {
                addView(next, HORIZONTAL);
            }
        } else {
            boolean z;
            boolean z2 = this.mShouldReverseLayout;
            if (layoutState.mLayoutDirection == -1) {
                z = true;
            } else {
                z = HORIZONTAL;
            }
            if (z2 == z) {
                addDisappearingView(next);
            } else {
                addDisappearingView(next, HORIZONTAL);
            }
        }
        measureChildWithMargins(next, HORIZONTAL, HORIZONTAL);
        layoutChunkResult.mConsumed = this.mOrientationHelper.getDecoratedMeasurement(next);
        if (this.mOrientation == VERTICAL) {
            int width;
            if (isLayoutRTL()) {
                width = getWidth() - getPaddingRight();
                decoratedMeasurementInOther = width - this.mOrientationHelper.getDecoratedMeasurementInOther(next);
            } else {
                decoratedMeasurementInOther = getPaddingLeft();
                width = this.mOrientationHelper.getDecoratedMeasurementInOther(next) + decoratedMeasurementInOther;
            }
            if (layoutState.mLayoutDirection == -1) {
                i = layoutState.mOffset;
                i2 = layoutState.mOffset - layoutChunkResult.mConsumed;
                i3 = width;
            } else {
                i2 = layoutState.mOffset;
                i = layoutChunkResult.mConsumed + layoutState.mOffset;
                i3 = width;
            }
        } else {
            i2 = getPaddingTop();
            i = i2 + this.mOrientationHelper.getDecoratedMeasurementInOther(next);
            if (layoutState.mLayoutDirection == -1) {
                decoratedMeasurementInOther = layoutState.mOffset - layoutChunkResult.mConsumed;
                i3 = layoutState.mOffset;
            } else {
                decoratedMeasurementInOther = layoutState.mOffset;
                i3 = layoutState.mOffset + layoutChunkResult.mConsumed;
            }
        }
        layoutDecoratedWithMargins(next, decoratedMeasurementInOther, i2, i3, i);
        if (layoutParams.isItemRemoved() || layoutParams.isItemChanged()) {
            layoutChunkResult.mIgnoreConsumed = true;
        }
        layoutChunkResult.mFocusable = next.hasFocusable();
    }

    boolean shouldMeasureTwice() {
        return (getHeightMode() == 1073741824 || getWidthMode() == 1073741824 || !hasFlexibleChildInBothOrientations()) ? DEBUG : true;
    }

    int convertFocusDirectionToLayoutDirection(int i) {
        int i2 = INVALID_OFFSET;
        int i3 = VERTICAL;
        switch (i) {
            case VERTICAL /*1*/:
                if (this.mOrientation == VERTICAL || !isLayoutRTL()) {
                    return -1;
                }
                return VERTICAL;
            case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                if (this.mOrientation == VERTICAL) {
                    return VERTICAL;
                }
                if (isLayoutRTL()) {
                    return -1;
                }
                return VERTICAL;
            case CommonStatusCodes.API_NOT_CONNECTED /*17*/:
                if (this.mOrientation != 0) {
                    return INVALID_OFFSET;
                }
                return -1;
            case C0268R.styleable.AppCompatTheme_actionModeCopyDrawable /*33*/:
                if (this.mOrientation != VERTICAL) {
                    return INVALID_OFFSET;
                }
                return -1;
            case C0268R.styleable.AppCompatTheme_textAppearanceSearchResultTitle /*66*/:
                if (this.mOrientation != 0) {
                    i3 = INVALID_OFFSET;
                }
                return i3;
            case TransportMediator.KEYCODE_MEDIA_RECORD /*130*/:
                if (this.mOrientation == VERTICAL) {
                    i2 = VERTICAL;
                }
                return i2;
            default:
                return INVALID_OFFSET;
        }
    }

    private View getChildClosestToStart() {
        return getChildAt(this.mShouldReverseLayout ? getChildCount() - 1 : HORIZONTAL);
    }

    private View getChildClosestToEnd() {
        return getChildAt(this.mShouldReverseLayout ? HORIZONTAL : getChildCount() - 1);
    }

    private View findFirstVisibleChildClosestToStart(boolean z, boolean z2) {
        if (this.mShouldReverseLayout) {
            return findOneVisibleChild(getChildCount() - 1, -1, z, z2);
        }
        return findOneVisibleChild(HORIZONTAL, getChildCount(), z, z2);
    }

    private View findFirstVisibleChildClosestToEnd(boolean z, boolean z2) {
        if (this.mShouldReverseLayout) {
            return findOneVisibleChild(HORIZONTAL, getChildCount(), z, z2);
        }
        return findOneVisibleChild(getChildCount() - 1, -1, z, z2);
    }

    private View findReferenceChildClosestToEnd(Recycler recycler, State state) {
        if (this.mShouldReverseLayout) {
            return findFirstReferenceChild(recycler, state);
        }
        return findLastReferenceChild(recycler, state);
    }

    private View findReferenceChildClosestToStart(Recycler recycler, State state) {
        if (this.mShouldReverseLayout) {
            return findLastReferenceChild(recycler, state);
        }
        return findFirstReferenceChild(recycler, state);
    }

    private View findFirstReferenceChild(Recycler recycler, State state) {
        return findReferenceChild(recycler, state, HORIZONTAL, getChildCount(), state.getItemCount());
    }

    private View findLastReferenceChild(Recycler recycler, State state) {
        return findReferenceChild(recycler, state, getChildCount() - 1, -1, state.getItemCount());
    }

    View findReferenceChild(Recycler recycler, State state, int i, int i2, int i3) {
        View view = null;
        ensureLayoutState();
        int startAfterPadding = this.mOrientationHelper.getStartAfterPadding();
        int endAfterPadding = this.mOrientationHelper.getEndAfterPadding();
        int i4 = i2 > i ? VERTICAL : -1;
        View view2 = null;
        while (i != i2) {
            View view3;
            View childAt = getChildAt(i);
            int position = getPosition(childAt);
            if (position >= 0 && position < i3) {
                if (((LayoutParams) childAt.getLayoutParams()).isItemRemoved()) {
                    if (view2 == null) {
                        view3 = view;
                        i += i4;
                        view = view3;
                        view2 = childAt;
                    }
                } else if (this.mOrientationHelper.getDecoratedStart(childAt) < endAfterPadding && this.mOrientationHelper.getDecoratedEnd(childAt) >= startAfterPadding) {
                    return childAt;
                } else {
                    if (view == null) {
                        view3 = childAt;
                        childAt = view2;
                        i += i4;
                        view = view3;
                        view2 = childAt;
                    }
                }
            }
            view3 = view;
            childAt = view2;
            i += i4;
            view = view3;
            view2 = childAt;
        }
        if (view == null) {
            view = view2;
        }
        return view;
    }

    private View findPartiallyOrCompletelyInvisibleChildClosestToEnd(Recycler recycler, State state) {
        if (this.mShouldReverseLayout) {
            return findFirstPartiallyOrCompletelyInvisibleChild(recycler, state);
        }
        return findLastPartiallyOrCompletelyInvisibleChild(recycler, state);
    }

    private View findPartiallyOrCompletelyInvisibleChildClosestToStart(Recycler recycler, State state) {
        if (this.mShouldReverseLayout) {
            return findLastPartiallyOrCompletelyInvisibleChild(recycler, state);
        }
        return findFirstPartiallyOrCompletelyInvisibleChild(recycler, state);
    }

    private View findFirstPartiallyOrCompletelyInvisibleChild(Recycler recycler, State state) {
        return findOnePartiallyOrCompletelyInvisibleChild(HORIZONTAL, getChildCount());
    }

    private View findLastPartiallyOrCompletelyInvisibleChild(Recycler recycler, State state) {
        return findOnePartiallyOrCompletelyInvisibleChild(getChildCount() - 1, -1);
    }

    public int findFirstVisibleItemPosition() {
        View findOneVisibleChild = findOneVisibleChild(HORIZONTAL, getChildCount(), DEBUG, true);
        return findOneVisibleChild == null ? -1 : getPosition(findOneVisibleChild);
    }

    public int findFirstCompletelyVisibleItemPosition() {
        View findOneVisibleChild = findOneVisibleChild(HORIZONTAL, getChildCount(), true, DEBUG);
        return findOneVisibleChild == null ? -1 : getPosition(findOneVisibleChild);
    }

    public int findLastVisibleItemPosition() {
        View findOneVisibleChild = findOneVisibleChild(getChildCount() - 1, -1, DEBUG, true);
        if (findOneVisibleChild == null) {
            return -1;
        }
        return getPosition(findOneVisibleChild);
    }

    public int findLastCompletelyVisibleItemPosition() {
        View findOneVisibleChild = findOneVisibleChild(getChildCount() - 1, -1, true, DEBUG);
        if (findOneVisibleChild == null) {
            return -1;
        }
        return getPosition(findOneVisibleChild);
    }

    View findOneVisibleChild(int i, int i2, boolean z, boolean z2) {
        int i3;
        int i4 = 320;
        ensureLayoutState();
        if (z) {
            i3 = 24579;
        } else {
            i3 = 320;
        }
        if (!z2) {
            i4 = HORIZONTAL;
        }
        if (this.mOrientation == 0) {
            return this.mHorizontalBoundCheck.findOneViewWithinBoundFlags(i, i2, i3, i4);
        }
        return this.mVerticalBoundCheck.findOneViewWithinBoundFlags(i, i2, i3, i4);
    }

    View findOnePartiallyOrCompletelyInvisibleChild(int i, int i2) {
        ensureLayoutState();
        Object obj = i2 > i ? VERTICAL : i2 < i ? -1 : null;
        if (obj == null) {
            return getChildAt(i);
        }
        int i3;
        int i4;
        if (this.mOrientationHelper.getDecoratedStart(getChildAt(i)) < this.mOrientationHelper.getStartAfterPadding()) {
            i3 = 16644;
            i4 = 16388;
        } else {
            i3 = 4161;
            i4 = FragmentTransaction.TRANSIT_FRAGMENT_OPEN;
        }
        if (this.mOrientation == 0) {
            return this.mHorizontalBoundCheck.findOneViewWithinBoundFlags(i, i2, i3, i4);
        }
        return this.mVerticalBoundCheck.findOneViewWithinBoundFlags(i, i2, i3, i4);
    }

    public View onFocusSearchFailed(View view, int i, Recycler recycler, State state) {
        resolveShouldLayoutReverse();
        if (getChildCount() == 0) {
            return null;
        }
        int convertFocusDirectionToLayoutDirection = convertFocusDirectionToLayoutDirection(i);
        if (convertFocusDirectionToLayoutDirection == INVALID_OFFSET) {
            return null;
        }
        View findPartiallyOrCompletelyInvisibleChildClosestToStart;
        View childClosestToStart;
        ensureLayoutState();
        ensureLayoutState();
        updateLayoutState(convertFocusDirectionToLayoutDirection, (int) (MAX_SCROLL_FACTOR * ((float) this.mOrientationHelper.getTotalSpace())), DEBUG, state);
        this.mLayoutState.mScrollingOffset = INVALID_OFFSET;
        this.mLayoutState.mRecycle = DEBUG;
        fill(recycler, this.mLayoutState, state, true);
        if (convertFocusDirectionToLayoutDirection == -1) {
            findPartiallyOrCompletelyInvisibleChildClosestToStart = findPartiallyOrCompletelyInvisibleChildClosestToStart(recycler, state);
        } else {
            findPartiallyOrCompletelyInvisibleChildClosestToStart = findPartiallyOrCompletelyInvisibleChildClosestToEnd(recycler, state);
        }
        if (convertFocusDirectionToLayoutDirection == -1) {
            childClosestToStart = getChildClosestToStart();
        } else {
            childClosestToStart = getChildClosestToEnd();
        }
        if (!childClosestToStart.hasFocusable()) {
            return findPartiallyOrCompletelyInvisibleChildClosestToStart;
        }
        if (findPartiallyOrCompletelyInvisibleChildClosestToStart == null) {
            return null;
        }
        return childClosestToStart;
    }

    private void logChildren() {
        Log.d(TAG, "internal representation of views on the screen");
        for (int i = HORIZONTAL; i < getChildCount(); i += VERTICAL) {
            View childAt = getChildAt(i);
            Log.d(TAG, "item " + getPosition(childAt) + ", coord:" + this.mOrientationHelper.getDecoratedStart(childAt));
        }
        Log.d(TAG, "==============");
    }

    void validateChildOrder() {
        boolean z = true;
        Log.d(TAG, "validating child count " + getChildCount());
        if (getChildCount() >= VERTICAL) {
            int position = getPosition(getChildAt(HORIZONTAL));
            int decoratedStart = this.mOrientationHelper.getDecoratedStart(getChildAt(HORIZONTAL));
            int i;
            View childAt;
            int position2;
            int decoratedStart2;
            StringBuilder append;
            if (this.mShouldReverseLayout) {
                i = VERTICAL;
                while (i < getChildCount()) {
                    childAt = getChildAt(i);
                    position2 = getPosition(childAt);
                    decoratedStart2 = this.mOrientationHelper.getDecoratedStart(childAt);
                    if (position2 < position) {
                        logChildren();
                        append = new StringBuilder().append("detected invalid position. loc invalid? ");
                        if (decoratedStart2 >= decoratedStart) {
                            z = DEBUG;
                        }
                        throw new RuntimeException(append.append(z).toString());
                    } else if (decoratedStart2 > decoratedStart) {
                        logChildren();
                        throw new RuntimeException("detected invalid location");
                    } else {
                        i += VERTICAL;
                    }
                }
                return;
            }
            i = VERTICAL;
            while (i < getChildCount()) {
                childAt = getChildAt(i);
                position2 = getPosition(childAt);
                decoratedStart2 = this.mOrientationHelper.getDecoratedStart(childAt);
                if (position2 < position) {
                    logChildren();
                    append = new StringBuilder().append("detected invalid position. loc invalid? ");
                    if (decoratedStart2 >= decoratedStart) {
                        z = DEBUG;
                    }
                    throw new RuntimeException(append.append(z).toString());
                } else if (decoratedStart2 < decoratedStart) {
                    logChildren();
                    throw new RuntimeException("detected invalid location");
                } else {
                    i += VERTICAL;
                }
            }
        }
    }

    public boolean supportsPredictiveItemAnimations() {
        return (this.mPendingSavedState == null && this.mLastStackFromEnd == this.mStackFromEnd) ? true : DEBUG;
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public void prepareForDrop(View view, View view2, int i, int i2) {
        assertNotInLayoutOrScroll("Cannot drop a view during a scroll or layout calculation");
        ensureLayoutState();
        resolveShouldLayoutReverse();
        int position = getPosition(view);
        int position2 = getPosition(view2);
        if (position < position2) {
            Object obj = VERTICAL;
        } else {
            position = -1;
        }
        if (this.mShouldReverseLayout) {
            if (obj == VERTICAL) {
                scrollToPositionWithOffset(position2, this.mOrientationHelper.getEndAfterPadding() - (this.mOrientationHelper.getDecoratedStart(view2) + this.mOrientationHelper.getDecoratedMeasurement(view)));
            } else {
                scrollToPositionWithOffset(position2, this.mOrientationHelper.getEndAfterPadding() - this.mOrientationHelper.getDecoratedEnd(view2));
            }
        } else if (obj == -1) {
            scrollToPositionWithOffset(position2, this.mOrientationHelper.getDecoratedStart(view2));
        } else {
            scrollToPositionWithOffset(position2, this.mOrientationHelper.getDecoratedEnd(view2) - this.mOrientationHelper.getDecoratedMeasurement(view));
        }
    }
}
