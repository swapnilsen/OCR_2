package android.support.design.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Region.Op;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.support.annotation.FloatRange;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.annotation.VisibleForTesting;
import android.support.design.C0003R;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.os.ParcelableCompat;
import android.support.v4.os.ParcelableCompatCreatorCallbacks;
import android.support.v4.util.Pools.Pool;
import android.support.v4.util.Pools.SynchronizedPool;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.NestedScrollingParent;
import android.support.v4.view.NestedScrollingParentHelper;
import android.support.v4.view.OnApplyWindowInsetsListener;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.WindowInsetsCompat;
import android.support.v7.appcompat.C0268R;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewGroup.OnHierarchyChangeListener;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.plus.model.people.Person.Urls.Type;
import com.google.firebase.messaging.SendException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoordinatorLayout extends ViewGroup implements NestedScrollingParent {
    static final Class<?>[] CONSTRUCTOR_PARAMS;
    static final int EVENT_NESTED_SCROLL = 1;
    static final int EVENT_PRE_DRAW = 0;
    static final int EVENT_VIEW_REMOVED = 2;
    static final String TAG = "CoordinatorLayout";
    static final Comparator<View> TOP_SORTED_CHILDREN_COMPARATOR;
    private static final int TYPE_ON_INTERCEPT = 0;
    private static final int TYPE_ON_TOUCH = 1;
    static final String WIDGET_PACKAGE_NAME;
    static final ThreadLocal<Map<String, Constructor<Behavior>>> sConstructors;
    private static final Pool<Rect> sRectPool;
    private OnApplyWindowInsetsListener mApplyWindowInsetsListener;
    private View mBehaviorTouchView;
    private final DirectedAcyclicGraph<View> mChildDag;
    private final List<View> mDependencySortedChildren;
    private boolean mDisallowInterceptReset;
    private boolean mDrawStatusBarBackground;
    private boolean mIsAttachedToWindow;
    private int[] mKeylines;
    private WindowInsetsCompat mLastInsets;
    private boolean mNeedsPreDrawListener;
    private View mNestedScrollingDirectChild;
    private final NestedScrollingParentHelper mNestedScrollingParentHelper;
    private View mNestedScrollingTarget;
    OnHierarchyChangeListener mOnHierarchyChangeListener;
    private OnPreDrawListener mOnPreDrawListener;
    private Paint mScrimPaint;
    private Drawable mStatusBarBackground;
    private final List<View> mTempDependenciesList;
    private final int[] mTempIntPair;
    private final List<View> mTempList1;

    public static abstract class Behavior<V extends View> {
        public Behavior(Context context, AttributeSet attributeSet) {
        }

        public void onAttachedToLayoutParams(@NonNull LayoutParams layoutParams) {
        }

        public void onDetachedFromLayoutParams() {
        }

        public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
            return false;
        }

        public boolean onTouchEvent(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
            return false;
        }

        @ColorInt
        public int getScrimColor(CoordinatorLayout coordinatorLayout, V v) {
            return ViewCompat.MEASURED_STATE_MASK;
        }

        @FloatRange(from = 0.0d, to = 1.0d)
        public float getScrimOpacity(CoordinatorLayout coordinatorLayout, V v) {
            return 0.0f;
        }

        public boolean blocksInteractionBelow(CoordinatorLayout coordinatorLayout, V v) {
            return getScrimOpacity(coordinatorLayout, v) > 0.0f;
        }

        public boolean layoutDependsOn(CoordinatorLayout coordinatorLayout, V v, View view) {
            return false;
        }

        public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, V v, View view) {
            return false;
        }

        public void onDependentViewRemoved(CoordinatorLayout coordinatorLayout, V v, View view) {
        }

        @Deprecated
        public boolean isDirty(CoordinatorLayout coordinatorLayout, V v) {
            return false;
        }

        public boolean onMeasureChild(CoordinatorLayout coordinatorLayout, V v, int i, int i2, int i3, int i4) {
            return false;
        }

        public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, V v, int i) {
            return false;
        }

        public static void setTag(View view, Object obj) {
            ((LayoutParams) view.getLayoutParams()).mBehaviorTag = obj;
        }

        public static Object getTag(View view) {
            return ((LayoutParams) view.getLayoutParams()).mBehaviorTag;
        }

        public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i) {
            return false;
        }

        public void onNestedScrollAccepted(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i) {
        }

        public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view) {
        }

        public void onNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int i3, int i4) {
        }

        public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int[] iArr) {
        }

        public boolean onNestedFling(CoordinatorLayout coordinatorLayout, V v, View view, float f, float f2, boolean z) {
            return false;
        }

        public boolean onNestedPreFling(CoordinatorLayout coordinatorLayout, V v, View view, float f, float f2) {
            return false;
        }

        @NonNull
        public WindowInsetsCompat onApplyWindowInsets(CoordinatorLayout coordinatorLayout, V v, WindowInsetsCompat windowInsetsCompat) {
            return windowInsetsCompat;
        }

        public boolean onRequestChildRectangleOnScreen(CoordinatorLayout coordinatorLayout, V v, Rect rect, boolean z) {
            return false;
        }

        public void onRestoreInstanceState(CoordinatorLayout coordinatorLayout, V v, Parcelable parcelable) {
        }

        public Parcelable onSaveInstanceState(CoordinatorLayout coordinatorLayout, V v) {
            return BaseSavedState.EMPTY_STATE;
        }

        public boolean getInsetDodgeRect(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull Rect rect) {
            return false;
        }
    }

    /* renamed from: android.support.design.widget.CoordinatorLayout.1 */
    class C00351 implements OnApplyWindowInsetsListener {
        C00351() {
        }

        public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            return CoordinatorLayout.this.setWindowInsets(windowInsetsCompat);
        }
    }

    @Retention(RetentionPolicy.RUNTIME)
    public @interface DefaultBehavior {
        Class<? extends Behavior> value();
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface DispatchChangeEvent {
    }

    private class HierarchyChangeListener implements OnHierarchyChangeListener {
        HierarchyChangeListener() {
        }

        public void onChildViewAdded(View view, View view2) {
            if (CoordinatorLayout.this.mOnHierarchyChangeListener != null) {
                CoordinatorLayout.this.mOnHierarchyChangeListener.onChildViewAdded(view, view2);
            }
        }

        public void onChildViewRemoved(View view, View view2) {
            CoordinatorLayout.this.onChildViewsChanged(CoordinatorLayout.EVENT_VIEW_REMOVED);
            if (CoordinatorLayout.this.mOnHierarchyChangeListener != null) {
                CoordinatorLayout.this.mOnHierarchyChangeListener.onChildViewRemoved(view, view2);
            }
        }
    }

    public static class LayoutParams extends MarginLayoutParams {
        public int anchorGravity;
        public int dodgeInsetEdges;
        public int gravity;
        public int insetEdge;
        public int keyline;
        View mAnchorDirectChild;
        int mAnchorId;
        View mAnchorView;
        Behavior mBehavior;
        boolean mBehaviorResolved;
        Object mBehaviorTag;
        private boolean mDidAcceptNestedScroll;
        private boolean mDidBlockInteraction;
        private boolean mDidChangeAfterNestedScroll;
        int mInsetOffsetX;
        int mInsetOffsetY;
        final Rect mLastChildRect;

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.mBehaviorResolved = false;
            this.gravity = CoordinatorLayout.TYPE_ON_INTERCEPT;
            this.anchorGravity = CoordinatorLayout.TYPE_ON_INTERCEPT;
            this.keyline = -1;
            this.mAnchorId = -1;
            this.insetEdge = CoordinatorLayout.TYPE_ON_INTERCEPT;
            this.dodgeInsetEdges = CoordinatorLayout.TYPE_ON_INTERCEPT;
            this.mLastChildRect = new Rect();
        }

        LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.mBehaviorResolved = false;
            this.gravity = CoordinatorLayout.TYPE_ON_INTERCEPT;
            this.anchorGravity = CoordinatorLayout.TYPE_ON_INTERCEPT;
            this.keyline = -1;
            this.mAnchorId = -1;
            this.insetEdge = CoordinatorLayout.TYPE_ON_INTERCEPT;
            this.dodgeInsetEdges = CoordinatorLayout.TYPE_ON_INTERCEPT;
            this.mLastChildRect = new Rect();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0003R.styleable.CoordinatorLayout_Layout);
            this.gravity = obtainStyledAttributes.getInteger(C0003R.styleable.CoordinatorLayout_Layout_android_layout_gravity, CoordinatorLayout.TYPE_ON_INTERCEPT);
            this.mAnchorId = obtainStyledAttributes.getResourceId(C0003R.styleable.CoordinatorLayout_Layout_layout_anchor, -1);
            this.anchorGravity = obtainStyledAttributes.getInteger(C0003R.styleable.CoordinatorLayout_Layout_layout_anchorGravity, CoordinatorLayout.TYPE_ON_INTERCEPT);
            this.keyline = obtainStyledAttributes.getInteger(C0003R.styleable.CoordinatorLayout_Layout_layout_keyline, -1);
            this.insetEdge = obtainStyledAttributes.getInt(C0003R.styleable.CoordinatorLayout_Layout_layout_insetEdge, CoordinatorLayout.TYPE_ON_INTERCEPT);
            this.dodgeInsetEdges = obtainStyledAttributes.getInt(C0003R.styleable.CoordinatorLayout_Layout_layout_dodgeInsetEdges, CoordinatorLayout.TYPE_ON_INTERCEPT);
            this.mBehaviorResolved = obtainStyledAttributes.hasValue(C0003R.styleable.CoordinatorLayout_Layout_layout_behavior);
            if (this.mBehaviorResolved) {
                this.mBehavior = CoordinatorLayout.parseBehavior(context, attributeSet, obtainStyledAttributes.getString(C0003R.styleable.CoordinatorLayout_Layout_layout_behavior));
            }
            obtainStyledAttributes.recycle();
            if (this.mBehavior != null) {
                this.mBehavior.onAttachedToLayoutParams(this);
            }
        }

        public LayoutParams(LayoutParams layoutParams) {
            super(layoutParams);
            this.mBehaviorResolved = false;
            this.gravity = CoordinatorLayout.TYPE_ON_INTERCEPT;
            this.anchorGravity = CoordinatorLayout.TYPE_ON_INTERCEPT;
            this.keyline = -1;
            this.mAnchorId = -1;
            this.insetEdge = CoordinatorLayout.TYPE_ON_INTERCEPT;
            this.dodgeInsetEdges = CoordinatorLayout.TYPE_ON_INTERCEPT;
            this.mLastChildRect = new Rect();
        }

        public LayoutParams(MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.mBehaviorResolved = false;
            this.gravity = CoordinatorLayout.TYPE_ON_INTERCEPT;
            this.anchorGravity = CoordinatorLayout.TYPE_ON_INTERCEPT;
            this.keyline = -1;
            this.mAnchorId = -1;
            this.insetEdge = CoordinatorLayout.TYPE_ON_INTERCEPT;
            this.dodgeInsetEdges = CoordinatorLayout.TYPE_ON_INTERCEPT;
            this.mLastChildRect = new Rect();
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.mBehaviorResolved = false;
            this.gravity = CoordinatorLayout.TYPE_ON_INTERCEPT;
            this.anchorGravity = CoordinatorLayout.TYPE_ON_INTERCEPT;
            this.keyline = -1;
            this.mAnchorId = -1;
            this.insetEdge = CoordinatorLayout.TYPE_ON_INTERCEPT;
            this.dodgeInsetEdges = CoordinatorLayout.TYPE_ON_INTERCEPT;
            this.mLastChildRect = new Rect();
        }

        @IdRes
        public int getAnchorId() {
            return this.mAnchorId;
        }

        public void setAnchorId(@IdRes int i) {
            invalidateAnchor();
            this.mAnchorId = i;
        }

        @Nullable
        public Behavior getBehavior() {
            return this.mBehavior;
        }

        public void setBehavior(@Nullable Behavior behavior) {
            if (this.mBehavior != behavior) {
                if (this.mBehavior != null) {
                    this.mBehavior.onDetachedFromLayoutParams();
                }
                this.mBehavior = behavior;
                this.mBehaviorTag = null;
                this.mBehaviorResolved = true;
                if (behavior != null) {
                    behavior.onAttachedToLayoutParams(this);
                }
            }
        }

        void setLastChildRect(Rect rect) {
            this.mLastChildRect.set(rect);
        }

        Rect getLastChildRect() {
            return this.mLastChildRect;
        }

        boolean checkAnchorChanged() {
            return this.mAnchorView == null && this.mAnchorId != -1;
        }

        boolean didBlockInteraction() {
            if (this.mBehavior == null) {
                this.mDidBlockInteraction = false;
            }
            return this.mDidBlockInteraction;
        }

        boolean isBlockingInteractionBelow(CoordinatorLayout coordinatorLayout, View view) {
            if (this.mDidBlockInteraction) {
                return true;
            }
            boolean blocksInteractionBelow = (this.mBehavior != null ? this.mBehavior.blocksInteractionBelow(coordinatorLayout, view) : CoordinatorLayout.TYPE_ON_INTERCEPT) | this.mDidBlockInteraction;
            this.mDidBlockInteraction = blocksInteractionBelow;
            return blocksInteractionBelow;
        }

        void resetTouchBehaviorTracking() {
            this.mDidBlockInteraction = false;
        }

        void resetNestedScroll() {
            this.mDidAcceptNestedScroll = false;
        }

        void acceptNestedScroll(boolean z) {
            this.mDidAcceptNestedScroll = z;
        }

        boolean isNestedScrollAccepted() {
            return this.mDidAcceptNestedScroll;
        }

        boolean getChangedAfterNestedScroll() {
            return this.mDidChangeAfterNestedScroll;
        }

        void setChangedAfterNestedScroll(boolean z) {
            this.mDidChangeAfterNestedScroll = z;
        }

        void resetChangedAfterNestedScroll() {
            this.mDidChangeAfterNestedScroll = false;
        }

        boolean dependsOn(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return view2 == this.mAnchorDirectChild || shouldDodge(view2, ViewCompat.getLayoutDirection(coordinatorLayout)) || (this.mBehavior != null && this.mBehavior.layoutDependsOn(coordinatorLayout, view, view2));
        }

        void invalidateAnchor() {
            this.mAnchorDirectChild = null;
            this.mAnchorView = null;
        }

        View findAnchorView(CoordinatorLayout coordinatorLayout, View view) {
            if (this.mAnchorId == -1) {
                this.mAnchorDirectChild = null;
                this.mAnchorView = null;
                return null;
            }
            if (this.mAnchorView == null || !verifyAnchorView(view, coordinatorLayout)) {
                resolveAnchorView(view, coordinatorLayout);
            }
            return this.mAnchorView;
        }

        private void resolveAnchorView(View view, CoordinatorLayout coordinatorLayout) {
            this.mAnchorView = coordinatorLayout.findViewById(this.mAnchorId);
            if (this.mAnchorView != null) {
                if (this.mAnchorView != coordinatorLayout) {
                    View view2 = this.mAnchorView;
                    View parent = this.mAnchorView.getParent();
                    while (parent != coordinatorLayout && parent != null) {
                        if (parent != view) {
                            if (parent instanceof View) {
                                view2 = parent;
                            }
                            parent = parent.getParent();
                        } else if (coordinatorLayout.isInEditMode()) {
                            this.mAnchorDirectChild = null;
                            this.mAnchorView = null;
                            return;
                        } else {
                            throw new IllegalStateException("Anchor must not be a descendant of the anchored view");
                        }
                    }
                    this.mAnchorDirectChild = view2;
                } else if (coordinatorLayout.isInEditMode()) {
                    this.mAnchorDirectChild = null;
                    this.mAnchorView = null;
                } else {
                    throw new IllegalStateException("View can not be anchored to the the parent CoordinatorLayout");
                }
            } else if (coordinatorLayout.isInEditMode()) {
                this.mAnchorDirectChild = null;
                this.mAnchorView = null;
            } else {
                throw new IllegalStateException("Could not find CoordinatorLayout descendant view with id " + coordinatorLayout.getResources().getResourceName(this.mAnchorId) + " to anchor view " + view);
            }
        }

        private boolean verifyAnchorView(View view, CoordinatorLayout coordinatorLayout) {
            if (this.mAnchorView.getId() != this.mAnchorId) {
                return false;
            }
            View view2 = this.mAnchorView;
            View parent = this.mAnchorView.getParent();
            while (parent != coordinatorLayout) {
                if (parent == null || parent == view) {
                    this.mAnchorDirectChild = null;
                    this.mAnchorView = null;
                    return false;
                }
                if (parent instanceof View) {
                    view2 = parent;
                }
                parent = parent.getParent();
            }
            this.mAnchorDirectChild = view2;
            return true;
        }

        private boolean shouldDodge(View view, int i) {
            int absoluteGravity = GravityCompat.getAbsoluteGravity(((LayoutParams) view.getLayoutParams()).insetEdge, i);
            return absoluteGravity != 0 && (GravityCompat.getAbsoluteGravity(this.dodgeInsetEdges, i) & absoluteGravity) == absoluteGravity;
        }
    }

    class OnPreDrawListener implements android.view.ViewTreeObserver.OnPreDrawListener {
        OnPreDrawListener() {
        }

        public boolean onPreDraw() {
            CoordinatorLayout.this.onChildViewsChanged(CoordinatorLayout.TYPE_ON_INTERCEPT);
            return true;
        }
    }

    protected static class SavedState extends AbsSavedState {
        public static final Creator<SavedState> CREATOR;
        SparseArray<Parcelable> behaviorStates;

        /* renamed from: android.support.design.widget.CoordinatorLayout.SavedState.1 */
        static class C00361 implements ParcelableCompatCreatorCallbacks<SavedState> {
            C00361() {
            }

            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            int readInt = parcel.readInt();
            int[] iArr = new int[readInt];
            parcel.readIntArray(iArr);
            Parcelable[] readParcelableArray = parcel.readParcelableArray(classLoader);
            this.behaviorStates = new SparseArray(readInt);
            for (int i = CoordinatorLayout.TYPE_ON_INTERCEPT; i < readInt; i += CoordinatorLayout.TYPE_ON_TOUCH) {
                this.behaviorStates.append(iArr[i], readParcelableArray[i]);
            }
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            int i2 = CoordinatorLayout.TYPE_ON_INTERCEPT;
            super.writeToParcel(parcel, i);
            int size = this.behaviorStates != null ? this.behaviorStates.size() : CoordinatorLayout.TYPE_ON_INTERCEPT;
            parcel.writeInt(size);
            int[] iArr = new int[size];
            Parcelable[] parcelableArr = new Parcelable[size];
            while (i2 < size) {
                iArr[i2] = this.behaviorStates.keyAt(i2);
                parcelableArr[i2] = (Parcelable) this.behaviorStates.valueAt(i2);
                i2 += CoordinatorLayout.TYPE_ON_TOUCH;
            }
            parcel.writeIntArray(iArr);
            parcel.writeParcelableArray(parcelableArr, i);
        }

        static {
            CREATOR = ParcelableCompat.newCreator(new C00361());
        }
    }

    static class ViewElevationComparator implements Comparator<View> {
        ViewElevationComparator() {
        }

        public int compare(View view, View view2) {
            float z = ViewCompat.getZ(view);
            float z2 = ViewCompat.getZ(view2);
            if (z > z2) {
                return -1;
            }
            if (z < z2) {
                return CoordinatorLayout.TYPE_ON_TOUCH;
            }
            return CoordinatorLayout.TYPE_ON_INTERCEPT;
        }
    }

    static {
        Package packageR = CoordinatorLayout.class.getPackage();
        WIDGET_PACKAGE_NAME = packageR != null ? packageR.getName() : null;
        if (VERSION.SDK_INT >= 21) {
            TOP_SORTED_CHILDREN_COMPARATOR = new ViewElevationComparator();
        } else {
            TOP_SORTED_CHILDREN_COMPARATOR = null;
        }
        Class[] clsArr = new Class[EVENT_VIEW_REMOVED];
        clsArr[TYPE_ON_INTERCEPT] = Context.class;
        clsArr[TYPE_ON_TOUCH] = AttributeSet.class;
        CONSTRUCTOR_PARAMS = clsArr;
        sConstructors = new ThreadLocal();
        sRectPool = new SynchronizedPool(12);
    }

    @NonNull
    private static Rect acquireTempRect() {
        Rect rect = (Rect) sRectPool.acquire();
        if (rect == null) {
            return new Rect();
        }
        return rect;
    }

    private static void releaseTempRect(@NonNull Rect rect) {
        rect.setEmpty();
        sRectPool.release(rect);
    }

    public CoordinatorLayout(Context context) {
        this(context, null);
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, TYPE_ON_INTERCEPT);
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet, int i) {
        int i2 = TYPE_ON_INTERCEPT;
        super(context, attributeSet, i);
        this.mDependencySortedChildren = new ArrayList();
        this.mChildDag = new DirectedAcyclicGraph();
        this.mTempList1 = new ArrayList();
        this.mTempDependenciesList = new ArrayList();
        this.mTempIntPair = new int[EVENT_VIEW_REMOVED];
        this.mNestedScrollingParentHelper = new NestedScrollingParentHelper(this);
        ThemeUtils.checkAppCompatTheme(context);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0003R.styleable.CoordinatorLayout, i, C0003R.style.Widget_Design_CoordinatorLayout);
        int resourceId = obtainStyledAttributes.getResourceId(C0003R.styleable.CoordinatorLayout_keylines, TYPE_ON_INTERCEPT);
        if (resourceId != 0) {
            Resources resources = context.getResources();
            this.mKeylines = resources.getIntArray(resourceId);
            float f = resources.getDisplayMetrics().density;
            int length = this.mKeylines.length;
            while (i2 < length) {
                int[] iArr = this.mKeylines;
                iArr[i2] = (int) (((float) iArr[i2]) * f);
                i2 += TYPE_ON_TOUCH;
            }
        }
        this.mStatusBarBackground = obtainStyledAttributes.getDrawable(C0003R.styleable.CoordinatorLayout_statusBarBackground);
        obtainStyledAttributes.recycle();
        setupForInsets();
        super.setOnHierarchyChangeListener(new HierarchyChangeListener());
    }

    public void setOnHierarchyChangeListener(OnHierarchyChangeListener onHierarchyChangeListener) {
        this.mOnHierarchyChangeListener = onHierarchyChangeListener;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        resetTouchBehaviors();
        if (this.mNeedsPreDrawListener) {
            if (this.mOnPreDrawListener == null) {
                this.mOnPreDrawListener = new OnPreDrawListener();
            }
            getViewTreeObserver().addOnPreDrawListener(this.mOnPreDrawListener);
        }
        if (this.mLastInsets == null && ViewCompat.getFitsSystemWindows(this)) {
            ViewCompat.requestApplyInsets(this);
        }
        this.mIsAttachedToWindow = true;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        resetTouchBehaviors();
        if (this.mNeedsPreDrawListener && this.mOnPreDrawListener != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.mOnPreDrawListener);
        }
        if (this.mNestedScrollingTarget != null) {
            onStopNestedScroll(this.mNestedScrollingTarget);
        }
        this.mIsAttachedToWindow = false;
    }

    public void setStatusBarBackground(@Nullable Drawable drawable) {
        Drawable drawable2 = null;
        if (this.mStatusBarBackground != drawable) {
            if (this.mStatusBarBackground != null) {
                this.mStatusBarBackground.setCallback(null);
            }
            if (drawable != null) {
                drawable2 = drawable.mutate();
            }
            this.mStatusBarBackground = drawable2;
            if (this.mStatusBarBackground != null) {
                if (this.mStatusBarBackground.isStateful()) {
                    this.mStatusBarBackground.setState(getDrawableState());
                }
                DrawableCompat.setLayoutDirection(this.mStatusBarBackground, ViewCompat.getLayoutDirection(this));
                this.mStatusBarBackground.setVisible(getVisibility() == 0, false);
                this.mStatusBarBackground.setCallback(this);
            }
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    @Nullable
    public Drawable getStatusBarBackground() {
        return this.mStatusBarBackground;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        int i = TYPE_ON_INTERCEPT;
        Drawable drawable = this.mStatusBarBackground;
        if (drawable != null && drawable.isStateful()) {
            i = TYPE_ON_INTERCEPT | drawable.setState(drawableState);
        }
        if (i != 0) {
            invalidate();
        }
    }

    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.mStatusBarBackground;
    }

    public void setVisibility(int i) {
        boolean z;
        super.setVisibility(i);
        if (i == 0) {
            z = true;
        } else {
            z = false;
        }
        if (this.mStatusBarBackground != null && this.mStatusBarBackground.isVisible() != z) {
            this.mStatusBarBackground.setVisible(z, false);
        }
    }

    public void setStatusBarBackgroundResource(@DrawableRes int i) {
        setStatusBarBackground(i != 0 ? ContextCompat.getDrawable(getContext(), i) : null);
    }

    public void setStatusBarBackgroundColor(@ColorInt int i) {
        setStatusBarBackground(new ColorDrawable(i));
    }

    final WindowInsetsCompat setWindowInsets(WindowInsetsCompat windowInsetsCompat) {
        boolean z = true;
        if (ViewUtils.objectEquals(this.mLastInsets, windowInsetsCompat)) {
            return windowInsetsCompat;
        }
        this.mLastInsets = windowInsetsCompat;
        boolean z2 = windowInsetsCompat != null && windowInsetsCompat.getSystemWindowInsetTop() > 0;
        this.mDrawStatusBarBackground = z2;
        if (this.mDrawStatusBarBackground || getBackground() != null) {
            z = false;
        }
        setWillNotDraw(z);
        windowInsetsCompat = dispatchApplyWindowInsetsToBehaviors(windowInsetsCompat);
        requestLayout();
        return windowInsetsCompat;
    }

    final WindowInsetsCompat getLastWindowInsets() {
        return this.mLastInsets;
    }

    private void resetTouchBehaviors() {
        if (this.mBehaviorTouchView != null) {
            Behavior behavior = ((LayoutParams) this.mBehaviorTouchView.getLayoutParams()).getBehavior();
            if (behavior != null) {
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, TYPE_ON_INTERCEPT);
                behavior.onTouchEvent(this, this.mBehaviorTouchView, obtain);
                obtain.recycle();
            }
            this.mBehaviorTouchView = null;
        }
        int childCount = getChildCount();
        for (int i = TYPE_ON_INTERCEPT; i < childCount; i += TYPE_ON_TOUCH) {
            ((LayoutParams) getChildAt(i).getLayoutParams()).resetTouchBehaviorTracking();
        }
        this.mDisallowInterceptReset = false;
    }

    private void getTopSortedChildren(List<View> list) {
        list.clear();
        boolean isChildrenDrawingOrderEnabled = isChildrenDrawingOrderEnabled();
        int childCount = getChildCount();
        for (int i = childCount - 1; i >= 0; i--) {
            int childDrawingOrder;
            if (isChildrenDrawingOrderEnabled) {
                childDrawingOrder = getChildDrawingOrder(childCount, i);
            } else {
                childDrawingOrder = i;
            }
            list.add(getChildAt(childDrawingOrder));
        }
        if (TOP_SORTED_CHILDREN_COMPARATOR != null) {
            Collections.sort(list, TOP_SORTED_CHILDREN_COMPARATOR);
        }
    }

    private boolean performIntercept(MotionEvent motionEvent, int i) {
        boolean z;
        boolean z2 = false;
        Object obj = null;
        MotionEvent motionEvent2 = null;
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        List list = this.mTempList1;
        getTopSortedChildren(list);
        int size = list.size();
        int i2 = TYPE_ON_INTERCEPT;
        while (i2 < size) {
            Object obj2;
            MotionEvent motionEvent3;
            View view = (View) list.get(i2);
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Behavior behavior = layoutParams.getBehavior();
            if ((!z2 && obj == null) || actionMasked == 0) {
                if (!(z2 || behavior == null)) {
                    switch (i) {
                        case TYPE_ON_INTERCEPT /*0*/:
                            z2 = behavior.onInterceptTouchEvent(this, view, motionEvent);
                            break;
                        case TYPE_ON_TOUCH /*1*/:
                            z2 = behavior.onTouchEvent(this, view, motionEvent);
                            break;
                    }
                    if (z2) {
                        this.mBehaviorTouchView = view;
                    }
                }
                z = z2;
                boolean didBlockInteraction = layoutParams.didBlockInteraction();
                boolean isBlockingInteractionBelow = layoutParams.isBlockingInteractionBelow(this, view);
                Object obj3 = (!isBlockingInteractionBelow || didBlockInteraction) ? null : TYPE_ON_TOUCH;
                if (isBlockingInteractionBelow && obj3 == null) {
                    list.clear();
                    return z;
                }
                MotionEvent motionEvent4 = motionEvent2;
                obj2 = obj3;
                motionEvent3 = motionEvent4;
            } else if (behavior != null) {
                if (motionEvent2 == null) {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    motionEvent3 = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, TYPE_ON_INTERCEPT);
                } else {
                    motionEvent3 = motionEvent2;
                }
                switch (i) {
                    case TYPE_ON_INTERCEPT /*0*/:
                        behavior.onInterceptTouchEvent(this, view, motionEvent3);
                        break;
                    case TYPE_ON_TOUCH /*1*/:
                        behavior.onTouchEvent(this, view, motionEvent3);
                        break;
                }
                obj2 = obj;
                z = z2;
            } else {
                motionEvent3 = motionEvent2;
                z = z2;
                obj2 = obj;
            }
            i2 += TYPE_ON_TOUCH;
            obj = obj2;
            z2 = z;
            motionEvent2 = motionEvent3;
        }
        z = z2;
        list.clear();
        return z;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        MotionEvent motionEvent2 = null;
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        if (actionMasked == 0) {
            resetTouchBehaviors();
        }
        boolean performIntercept = performIntercept(motionEvent, TYPE_ON_INTERCEPT);
        if (motionEvent2 != null) {
            motionEvent2.recycle();
        }
        if (actionMasked == TYPE_ON_TOUCH || actionMasked == 3) {
            resetTouchBehaviors();
        }
        return performIntercept;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        MotionEvent obtain;
        MotionEvent motionEvent2 = null;
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        boolean z2;
        if (this.mBehaviorTouchView == null) {
            boolean performIntercept = performIntercept(motionEvent, TYPE_ON_TOUCH);
            if (performIntercept) {
                z2 = performIntercept;
            } else {
                z2 = performIntercept;
                z = TYPE_ON_INTERCEPT;
                if (this.mBehaviorTouchView == null) {
                    z |= super.onTouchEvent(motionEvent);
                } else if (z2) {
                    if (TYPE_ON_INTERCEPT != null) {
                        long uptimeMillis = SystemClock.uptimeMillis();
                        obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, TYPE_ON_INTERCEPT);
                    } else {
                        obtain = null;
                    }
                    super.onTouchEvent(obtain);
                    motionEvent2 = obtain;
                }
                if (!z || actionMasked == 0) {
                    if (motionEvent2 != null) {
                        motionEvent2.recycle();
                    }
                    if (actionMasked == TYPE_ON_TOUCH || actionMasked == 3) {
                        resetTouchBehaviors();
                    }
                    return z;
                }
                if (motionEvent2 != null) {
                    motionEvent2.recycle();
                }
                resetTouchBehaviors();
                return z;
            }
        }
        z2 = TYPE_ON_INTERCEPT;
        Behavior behavior = ((LayoutParams) this.mBehaviorTouchView.getLayoutParams()).getBehavior();
        z = behavior != null ? behavior.onTouchEvent(this, this.mBehaviorTouchView, motionEvent) : TYPE_ON_INTERCEPT;
        if (this.mBehaviorTouchView == null) {
            z |= super.onTouchEvent(motionEvent);
        } else if (z2) {
            if (TYPE_ON_INTERCEPT != null) {
                obtain = null;
            } else {
                long uptimeMillis2 = SystemClock.uptimeMillis();
                obtain = MotionEvent.obtain(uptimeMillis2, uptimeMillis2, 3, 0.0f, 0.0f, TYPE_ON_INTERCEPT);
            }
            super.onTouchEvent(obtain);
            motionEvent2 = obtain;
        }
        if (z) {
        }
        if (motionEvent2 != null) {
            motionEvent2.recycle();
        }
        resetTouchBehaviors();
        return z;
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        if (z && !this.mDisallowInterceptReset) {
            resetTouchBehaviors();
            this.mDisallowInterceptReset = true;
        }
    }

    private int getKeyline(int i) {
        if (this.mKeylines == null) {
            Log.e(TAG, "No keylines defined for " + this + " - attempted index lookup " + i);
            return TYPE_ON_INTERCEPT;
        } else if (i >= 0 && i < this.mKeylines.length) {
            return this.mKeylines[i];
        } else {
            Log.e(TAG, "Keyline index " + i + " out of range for " + this);
            return TYPE_ON_INTERCEPT;
        }
    }

    static Behavior parseBehavior(Context context, AttributeSet attributeSet, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith(".")) {
            str = context.getPackageName() + str;
        } else if (str.indexOf(46) < 0 && !TextUtils.isEmpty(WIDGET_PACKAGE_NAME)) {
            str = WIDGET_PACKAGE_NAME + '.' + str;
        }
        try {
            Map map;
            Map map2 = (Map) sConstructors.get();
            if (map2 == null) {
                HashMap hashMap = new HashMap();
                sConstructors.set(hashMap);
                map = hashMap;
            } else {
                map = map2;
            }
            Constructor constructor = (Constructor) map.get(str);
            if (constructor == null) {
                constructor = Class.forName(str, true, context.getClassLoader()).getConstructor(CONSTRUCTOR_PARAMS);
                constructor.setAccessible(true);
                map.put(str, constructor);
            }
            Object[] objArr = new Object[EVENT_VIEW_REMOVED];
            objArr[TYPE_ON_INTERCEPT] = context;
            objArr[TYPE_ON_TOUCH] = attributeSet;
            return (Behavior) constructor.newInstance(objArr);
        } catch (Throwable e) {
            throw new RuntimeException("Could not inflate Behavior subclass " + str, e);
        }
    }

    LayoutParams getResolvedLayoutParams(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (!layoutParams.mBehaviorResolved) {
            DefaultBehavior defaultBehavior = null;
            for (Class cls = view.getClass(); cls != null; cls = cls.getSuperclass()) {
                defaultBehavior = (DefaultBehavior) cls.getAnnotation(DefaultBehavior.class);
                if (defaultBehavior != null) {
                    break;
                }
            }
            DefaultBehavior defaultBehavior2 = defaultBehavior;
            if (defaultBehavior2 != null) {
                try {
                    layoutParams.setBehavior((Behavior) defaultBehavior2.value().newInstance());
                } catch (Throwable e) {
                    Log.e(TAG, "Default behavior class " + defaultBehavior2.value().getName() + " could not be instantiated. Did you forget a default constructor?", e);
                }
            }
            layoutParams.mBehaviorResolved = true;
        }
        return layoutParams;
    }

    private void prepareChildren() {
        this.mDependencySortedChildren.clear();
        this.mChildDag.clear();
        int childCount = getChildCount();
        for (int i = TYPE_ON_INTERCEPT; i < childCount; i += TYPE_ON_TOUCH) {
            View childAt = getChildAt(i);
            getResolvedLayoutParams(childAt).findAnchorView(this, childAt);
            this.mChildDag.addNode(childAt);
            for (int i2 = TYPE_ON_INTERCEPT; i2 < childCount; i2 += TYPE_ON_TOUCH) {
                if (i2 != i) {
                    View childAt2 = getChildAt(i2);
                    if (getResolvedLayoutParams(childAt2).dependsOn(this, childAt2, childAt)) {
                        if (!this.mChildDag.contains(childAt2)) {
                            this.mChildDag.addNode(childAt2);
                        }
                        this.mChildDag.addEdge(childAt, childAt2);
                    }
                }
            }
        }
        this.mDependencySortedChildren.addAll(this.mChildDag.getSortedList());
        Collections.reverse(this.mDependencySortedChildren);
    }

    void getDescendantRect(View view, Rect rect) {
        ViewGroupUtils.getDescendantRect(this, view, rect);
    }

    protected int getSuggestedMinimumWidth() {
        return Math.max(super.getSuggestedMinimumWidth(), getPaddingLeft() + getPaddingRight());
    }

    protected int getSuggestedMinimumHeight() {
        return Math.max(super.getSuggestedMinimumHeight(), getPaddingTop() + getPaddingBottom());
    }

    public void onMeasureChild(View view, int i, int i2, int i3, int i4) {
        measureChildWithMargins(view, i, i2, i3, i4);
    }

    protected void onMeasure(int i, int i2) {
        prepareChildren();
        ensurePreDrawListener();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int layoutDirection = ViewCompat.getLayoutDirection(this);
        Object obj;
        if (layoutDirection == TYPE_ON_TOUCH) {
            obj = TYPE_ON_TOUCH;
        } else {
            obj = TYPE_ON_INTERCEPT;
        }
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        int mode2 = MeasureSpec.getMode(i2);
        int size2 = MeasureSpec.getSize(i2);
        int i3 = paddingLeft + paddingRight;
        int i4 = paddingTop + paddingBottom;
        int suggestedMinimumWidth = getSuggestedMinimumWidth();
        int suggestedMinimumHeight = getSuggestedMinimumHeight();
        int i5 = TYPE_ON_INTERCEPT;
        Object obj2 = (this.mLastInsets == null || !ViewCompat.getFitsSystemWindows(this)) ? TYPE_ON_INTERCEPT : TYPE_ON_TOUCH;
        int size3 = this.mDependencySortedChildren.size();
        int i6 = TYPE_ON_INTERCEPT;
        while (i6 < size3) {
            int i7;
            View view = (View) this.mDependencySortedChildren.get(i6);
            if (view.getVisibility() == 8) {
                i7 = i5;
                paddingTop = suggestedMinimumHeight;
                paddingBottom = suggestedMinimumWidth;
            } else {
                int i8;
                int i9;
                LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                int i10 = TYPE_ON_INTERCEPT;
                if (layoutParams.keyline >= 0 && mode != 0) {
                    i7 = getKeyline(layoutParams.keyline);
                    paddingTop = GravityCompat.getAbsoluteGravity(resolveKeylineGravity(layoutParams.gravity), layoutDirection) & 7;
                    if ((paddingTop == 3 && r9 == null) || (paddingTop == 5 && r9 != null)) {
                        i10 = Math.max(TYPE_ON_INTERCEPT, (size - paddingRight) - i7);
                    } else if ((paddingTop == 5 && r9 == null) || (paddingTop == 3 && r9 != null)) {
                        i10 = Math.max(TYPE_ON_INTERCEPT, i7 - paddingLeft);
                    }
                }
                if (obj2 == null || ViewCompat.getFitsSystemWindows(view)) {
                    i8 = i2;
                    i9 = i;
                } else {
                    paddingTop = this.mLastInsets.getSystemWindowInsetTop() + this.mLastInsets.getSystemWindowInsetBottom();
                    i9 = MeasureSpec.makeMeasureSpec(size - (this.mLastInsets.getSystemWindowInsetLeft() + this.mLastInsets.getSystemWindowInsetRight()), mode);
                    i8 = MeasureSpec.makeMeasureSpec(size2 - paddingTop, mode2);
                }
                Behavior behavior = layoutParams.getBehavior();
                if (behavior == null || !behavior.onMeasureChild(this, view, i9, i10, i8, TYPE_ON_INTERCEPT)) {
                    onMeasureChild(view, i9, i10, i8, TYPE_ON_INTERCEPT);
                }
                i9 = Math.max(suggestedMinimumWidth, ((view.getMeasuredWidth() + i3) + layoutParams.leftMargin) + layoutParams.rightMargin);
                paddingTop = Math.max(suggestedMinimumHeight, ((view.getMeasuredHeight() + i4) + layoutParams.topMargin) + layoutParams.bottomMargin);
                i7 = ViewCompat.combineMeasuredStates(i5, ViewCompat.getMeasuredState(view));
                paddingBottom = i9;
            }
            i6 += TYPE_ON_TOUCH;
            i5 = i7;
            suggestedMinimumHeight = paddingTop;
            suggestedMinimumWidth = paddingBottom;
        }
        setMeasuredDimension(ViewCompat.resolveSizeAndState(suggestedMinimumWidth, i, ViewCompat.MEASURED_STATE_MASK & i5), ViewCompat.resolveSizeAndState(suggestedMinimumHeight, i2, i5 << 16));
    }

    private WindowInsetsCompat dispatchApplyWindowInsetsToBehaviors(WindowInsetsCompat windowInsetsCompat) {
        if (windowInsetsCompat.isConsumed()) {
            return windowInsetsCompat;
        }
        WindowInsetsCompat onApplyWindowInsets;
        int childCount = getChildCount();
        int i = TYPE_ON_INTERCEPT;
        WindowInsetsCompat windowInsetsCompat2 = windowInsetsCompat;
        while (i < childCount) {
            View childAt = getChildAt(i);
            if (ViewCompat.getFitsSystemWindows(childAt)) {
                Behavior behavior = ((LayoutParams) childAt.getLayoutParams()).getBehavior();
                if (behavior != null) {
                    onApplyWindowInsets = behavior.onApplyWindowInsets(this, childAt, windowInsetsCompat2);
                    if (onApplyWindowInsets.isConsumed()) {
                        break;
                    }
                    i += TYPE_ON_TOUCH;
                    windowInsetsCompat2 = onApplyWindowInsets;
                }
            }
            onApplyWindowInsets = windowInsetsCompat2;
            i += TYPE_ON_TOUCH;
            windowInsetsCompat2 = onApplyWindowInsets;
        }
        onApplyWindowInsets = windowInsetsCompat2;
        return onApplyWindowInsets;
    }

    public void onLayoutChild(View view, int i) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (layoutParams.checkAnchorChanged()) {
            throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
        } else if (layoutParams.mAnchorView != null) {
            layoutChildWithAnchor(view, layoutParams.mAnchorView, i);
        } else if (layoutParams.keyline >= 0) {
            layoutChildWithKeyline(view, layoutParams.keyline, i);
        } else {
            layoutChild(view, i);
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int layoutDirection = ViewCompat.getLayoutDirection(this);
        int size = this.mDependencySortedChildren.size();
        for (int i5 = TYPE_ON_INTERCEPT; i5 < size; i5 += TYPE_ON_TOUCH) {
            View view = (View) this.mDependencySortedChildren.get(i5);
            if (view.getVisibility() != 8) {
                Behavior behavior = ((LayoutParams) view.getLayoutParams()).getBehavior();
                if (behavior == null || !behavior.onLayoutChild(this, view, layoutDirection)) {
                    onLayoutChild(view, layoutDirection);
                }
            }
        }
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mDrawStatusBarBackground && this.mStatusBarBackground != null) {
            int systemWindowInsetTop = this.mLastInsets != null ? this.mLastInsets.getSystemWindowInsetTop() : TYPE_ON_INTERCEPT;
            if (systemWindowInsetTop > 0) {
                this.mStatusBarBackground.setBounds(TYPE_ON_INTERCEPT, TYPE_ON_INTERCEPT, getWidth(), systemWindowInsetTop);
                this.mStatusBarBackground.draw(canvas);
            }
        }
    }

    public void setFitsSystemWindows(boolean z) {
        super.setFitsSystemWindows(z);
        setupForInsets();
    }

    void recordLastChildRect(View view, Rect rect) {
        ((LayoutParams) view.getLayoutParams()).setLastChildRect(rect);
    }

    void getLastChildRect(View view, Rect rect) {
        rect.set(((LayoutParams) view.getLayoutParams()).getLastChildRect());
    }

    void getChildRect(View view, boolean z, Rect rect) {
        if (view.isLayoutRequested() || view.getVisibility() == 8) {
            rect.setEmpty();
        } else if (z) {
            getDescendantRect(view, rect);
        } else {
            rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
    }

    private void getDesiredAnchoredChildRectWithoutConstraints(View view, int i, Rect rect, Rect rect2, LayoutParams layoutParams, int i2, int i3) {
        int absoluteGravity = GravityCompat.getAbsoluteGravity(resolveAnchoredChildGravity(layoutParams.gravity), i);
        int absoluteGravity2 = GravityCompat.getAbsoluteGravity(resolveGravity(layoutParams.anchorGravity), i);
        int i4 = absoluteGravity & 7;
        int i5 = absoluteGravity & C0268R.styleable.AppCompatTheme_spinnerStyle;
        int i6 = absoluteGravity2 & C0268R.styleable.AppCompatTheme_spinnerStyle;
        switch (absoluteGravity2 & 7) {
            case TYPE_ON_TOUCH /*1*/:
                absoluteGravity2 = (rect.width() / EVENT_VIEW_REMOVED) + rect.left;
                break;
            case Type.OTHER_PROFILE /*5*/:
                absoluteGravity2 = rect.right;
                break;
            default:
                absoluteGravity2 = rect.left;
                break;
        }
        switch (i6) {
            case CommonStatusCodes.CANCELED /*16*/:
                absoluteGravity = rect.top + (rect.height() / EVENT_VIEW_REMOVED);
                break;
            case C0268R.styleable.AppCompatTheme_panelMenuListWidth /*80*/:
                absoluteGravity = rect.bottom;
                break;
            default:
                absoluteGravity = rect.top;
                break;
        }
        switch (i4) {
            case TYPE_ON_TOUCH /*1*/:
                absoluteGravity2 -= i2 / EVENT_VIEW_REMOVED;
                break;
            case Type.OTHER_PROFILE /*5*/:
                break;
            default:
                absoluteGravity2 -= i2;
                break;
        }
        switch (i5) {
            case CommonStatusCodes.CANCELED /*16*/:
                absoluteGravity -= i3 / EVENT_VIEW_REMOVED;
                break;
            case C0268R.styleable.AppCompatTheme_panelMenuListWidth /*80*/:
                break;
            default:
                absoluteGravity -= i3;
                break;
        }
        rect2.set(absoluteGravity2, absoluteGravity, absoluteGravity2 + i2, absoluteGravity + i3);
    }

    private void constrainChildRect(LayoutParams layoutParams, Rect rect, int i, int i2) {
        int width = getWidth();
        int height = getHeight();
        width = Math.max(getPaddingLeft() + layoutParams.leftMargin, Math.min(rect.left, ((width - getPaddingRight()) - i) - layoutParams.rightMargin));
        height = Math.max(getPaddingTop() + layoutParams.topMargin, Math.min(rect.top, ((height - getPaddingBottom()) - i2) - layoutParams.bottomMargin));
        rect.set(width, height, width + i, height + i2);
    }

    void getDesiredAnchoredChildRect(View view, int i, Rect rect, Rect rect2) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        getDesiredAnchoredChildRectWithoutConstraints(view, i, rect, rect2, layoutParams, measuredWidth, measuredHeight);
        constrainChildRect(layoutParams, rect2, measuredWidth, measuredHeight);
    }

    private void layoutChildWithAnchor(View view, View view2, int i) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        Rect acquireTempRect = acquireTempRect();
        Rect acquireTempRect2 = acquireTempRect();
        try {
            getDescendantRect(view2, acquireTempRect);
            getDesiredAnchoredChildRect(view, i, acquireTempRect, acquireTempRect2);
            view.layout(acquireTempRect2.left, acquireTempRect2.top, acquireTempRect2.right, acquireTempRect2.bottom);
        } finally {
            releaseTempRect(acquireTempRect);
            releaseTempRect(acquireTempRect2);
        }
    }

    private void layoutChildWithKeyline(View view, int i, int i2) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int absoluteGravity = GravityCompat.getAbsoluteGravity(resolveKeylineGravity(layoutParams.gravity), i2);
        int i3 = absoluteGravity & 7;
        int i4 = absoluteGravity & C0268R.styleable.AppCompatTheme_spinnerStyle;
        int width = getWidth();
        int height = getHeight();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        if (i2 == TYPE_ON_TOUCH) {
            i = width - i;
        }
        int keyline = getKeyline(i) - measuredWidth;
        absoluteGravity = TYPE_ON_INTERCEPT;
        switch (i3) {
            case TYPE_ON_TOUCH /*1*/:
                keyline += measuredWidth / EVENT_VIEW_REMOVED;
                break;
            case Type.OTHER_PROFILE /*5*/:
                keyline += measuredWidth;
                break;
        }
        switch (i4) {
            case CommonStatusCodes.CANCELED /*16*/:
                absoluteGravity = TYPE_ON_INTERCEPT + (measuredHeight / EVENT_VIEW_REMOVED);
                break;
            case C0268R.styleable.AppCompatTheme_panelMenuListWidth /*80*/:
                absoluteGravity = TYPE_ON_INTERCEPT + measuredHeight;
                break;
        }
        keyline = Math.max(getPaddingLeft() + layoutParams.leftMargin, Math.min(keyline, ((width - getPaddingRight()) - measuredWidth) - layoutParams.rightMargin));
        int max = Math.max(getPaddingTop() + layoutParams.topMargin, Math.min(absoluteGravity, ((height - getPaddingBottom()) - measuredHeight) - layoutParams.bottomMargin));
        view.layout(keyline, max, keyline + measuredWidth, max + measuredHeight);
    }

    private void layoutChild(View view, int i) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        Rect acquireTempRect = acquireTempRect();
        acquireTempRect.set(getPaddingLeft() + layoutParams.leftMargin, getPaddingTop() + layoutParams.topMargin, (getWidth() - getPaddingRight()) - layoutParams.rightMargin, (getHeight() - getPaddingBottom()) - layoutParams.bottomMargin);
        if (!(this.mLastInsets == null || !ViewCompat.getFitsSystemWindows(this) || ViewCompat.getFitsSystemWindows(view))) {
            acquireTempRect.left += this.mLastInsets.getSystemWindowInsetLeft();
            acquireTempRect.top += this.mLastInsets.getSystemWindowInsetTop();
            acquireTempRect.right -= this.mLastInsets.getSystemWindowInsetRight();
            acquireTempRect.bottom -= this.mLastInsets.getSystemWindowInsetBottom();
        }
        Rect acquireTempRect2 = acquireTempRect();
        GravityCompat.apply(resolveGravity(layoutParams.gravity), view.getMeasuredWidth(), view.getMeasuredHeight(), acquireTempRect, acquireTempRect2, i);
        view.layout(acquireTempRect2.left, acquireTempRect2.top, acquireTempRect2.right, acquireTempRect2.bottom);
        releaseTempRect(acquireTempRect);
        releaseTempRect(acquireTempRect2);
    }

    private static int resolveGravity(int i) {
        int i2;
        if ((i & 7) == 0) {
            i2 = GravityCompat.START | i;
        } else {
            i2 = i;
        }
        if ((i2 & C0268R.styleable.AppCompatTheme_spinnerStyle) == 0) {
            return i2 | 48;
        }
        return i2;
    }

    private static int resolveKeylineGravity(int i) {
        return i == 0 ? 8388661 : i;
    }

    private static int resolveAnchoredChildGravity(int i) {
        return i == 0 ? 17 : i;
    }

    protected boolean drawChild(Canvas canvas, View view, long j) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (layoutParams.mBehavior != null) {
            float scrimOpacity = layoutParams.mBehavior.getScrimOpacity(this, view);
            if (scrimOpacity > 0.0f) {
                if (this.mScrimPaint == null) {
                    this.mScrimPaint = new Paint();
                }
                this.mScrimPaint.setColor(layoutParams.mBehavior.getScrimColor(this, view));
                this.mScrimPaint.setAlpha(MathUtils.constrain(Math.round(scrimOpacity * 255.0f), (int) TYPE_ON_INTERCEPT, (int) MotionEventCompat.ACTION_MASK));
                int save = canvas.save();
                if (view.isOpaque()) {
                    canvas.clipRect((float) view.getLeft(), (float) view.getTop(), (float) view.getRight(), (float) view.getBottom(), Op.DIFFERENCE);
                }
                canvas.drawRect((float) getPaddingLeft(), (float) getPaddingTop(), (float) (getWidth() - getPaddingRight()), (float) (getHeight() - getPaddingBottom()), this.mScrimPaint);
                canvas.restoreToCount(save);
            }
        }
        return super.drawChild(canvas, view, j);
    }

    final void onChildViewsChanged(int i) {
        int layoutDirection = ViewCompat.getLayoutDirection(this);
        int size = this.mDependencySortedChildren.size();
        Rect acquireTempRect = acquireTempRect();
        Rect acquireTempRect2 = acquireTempRect();
        Rect acquireTempRect3 = acquireTempRect();
        for (int i2 = TYPE_ON_INTERCEPT; i2 < size; i2 += TYPE_ON_TOUCH) {
            View view = (View) this.mDependencySortedChildren.get(i2);
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (i != 0 || view.getVisibility() != 8) {
                int i3;
                for (i3 = TYPE_ON_INTERCEPT; i3 < i2; i3 += TYPE_ON_TOUCH) {
                    if (layoutParams.mAnchorDirectChild == ((View) this.mDependencySortedChildren.get(i3))) {
                        offsetChildToAnchor(view, layoutDirection);
                    }
                }
                getChildRect(view, true, acquireTempRect2);
                if (!(layoutParams.insetEdge == 0 || acquireTempRect2.isEmpty())) {
                    int absoluteGravity = GravityCompat.getAbsoluteGravity(layoutParams.insetEdge, layoutDirection);
                    switch (absoluteGravity & C0268R.styleable.AppCompatTheme_spinnerStyle) {
                        case C0268R.styleable.AppCompatTheme_spinnerDropDownItemStyle /*48*/:
                            acquireTempRect.top = Math.max(acquireTempRect.top, acquireTempRect2.bottom);
                            break;
                        case C0268R.styleable.AppCompatTheme_panelMenuListWidth /*80*/:
                            acquireTempRect.bottom = Math.max(acquireTempRect.bottom, getHeight() - acquireTempRect2.top);
                            break;
                    }
                    switch (absoluteGravity & 7) {
                        case SendException.ERROR_TTL_EXCEEDED /*3*/:
                            acquireTempRect.left = Math.max(acquireTempRect.left, acquireTempRect2.right);
                            break;
                        case Type.OTHER_PROFILE /*5*/:
                            acquireTempRect.right = Math.max(acquireTempRect.right, getWidth() - acquireTempRect2.left);
                            break;
                    }
                }
                if (layoutParams.dodgeInsetEdges != 0 && view.getVisibility() == 0) {
                    offsetChildByInset(view, acquireTempRect, layoutDirection);
                }
                if (i != EVENT_VIEW_REMOVED) {
                    getLastChildRect(view, acquireTempRect3);
                    if (!acquireTempRect3.equals(acquireTempRect2)) {
                        recordLastChildRect(view, acquireTempRect2);
                    }
                }
                for (i3 = i2 + TYPE_ON_TOUCH; i3 < size; i3 += TYPE_ON_TOUCH) {
                    View view2 = (View) this.mDependencySortedChildren.get(i3);
                    LayoutParams layoutParams2 = (LayoutParams) view2.getLayoutParams();
                    Behavior behavior = layoutParams2.getBehavior();
                    if (behavior != null && behavior.layoutDependsOn(this, view2, view)) {
                        if (i == 0 && layoutParams2.getChangedAfterNestedScroll()) {
                            layoutParams2.resetChangedAfterNestedScroll();
                        } else {
                            boolean z;
                            switch (i) {
                                case EVENT_VIEW_REMOVED /*2*/:
                                    behavior.onDependentViewRemoved(this, view2, view);
                                    z = true;
                                    break;
                                default:
                                    z = behavior.onDependentViewChanged(this, view2, view);
                                    break;
                            }
                            if (i == TYPE_ON_TOUCH) {
                                layoutParams2.setChangedAfterNestedScroll(z);
                            }
                        }
                    }
                }
            }
        }
        releaseTempRect(acquireTempRect);
        releaseTempRect(acquireTempRect2);
        releaseTempRect(acquireTempRect3);
    }

    private void offsetChildByInset(View view, Rect rect, int i) {
        if (ViewCompat.isLaidOut(view) && view.getWidth() > 0 && view.getHeight() > 0) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Behavior behavior = layoutParams.getBehavior();
            Rect acquireTempRect = acquireTempRect();
            Rect acquireTempRect2 = acquireTempRect();
            acquireTempRect2.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            if (behavior == null || !behavior.getInsetDodgeRect(this, view, acquireTempRect)) {
                acquireTempRect.set(acquireTempRect2);
            } else if (!acquireTempRect2.contains(acquireTempRect)) {
                throw new IllegalArgumentException("Rect should be within the child's bounds. Rect:" + acquireTempRect.toShortString() + " | Bounds:" + acquireTempRect2.toShortString());
            }
            releaseTempRect(acquireTempRect2);
            if (acquireTempRect.isEmpty()) {
                releaseTempRect(acquireTempRect);
                return;
            }
            int i2;
            int height;
            int width;
            int absoluteGravity = GravityCompat.getAbsoluteGravity(layoutParams.dodgeInsetEdges, i);
            if ((absoluteGravity & 48) == 48) {
                i2 = (acquireTempRect.top - layoutParams.topMargin) - layoutParams.mInsetOffsetY;
                if (i2 < rect.top) {
                    setInsetOffsetY(view, rect.top - i2);
                    i2 = TYPE_ON_TOUCH;
                    if ((absoluteGravity & 80) == 80) {
                        height = ((getHeight() - acquireTempRect.bottom) - layoutParams.bottomMargin) + layoutParams.mInsetOffsetY;
                        if (height < rect.bottom) {
                            setInsetOffsetY(view, height - rect.bottom);
                            i2 = TYPE_ON_TOUCH;
                        }
                    }
                    if (i2 == 0) {
                        setInsetOffsetY(view, TYPE_ON_INTERCEPT);
                    }
                    if ((absoluteGravity & 3) == 3) {
                        i2 = (acquireTempRect.left - layoutParams.leftMargin) - layoutParams.mInsetOffsetX;
                        if (i2 < rect.left) {
                            setInsetOffsetX(view, rect.left - i2);
                            i2 = TYPE_ON_TOUCH;
                            if ((absoluteGravity & 5) == 5) {
                                width = layoutParams.mInsetOffsetX + ((getWidth() - acquireTempRect.right) - layoutParams.rightMargin);
                                if (width < rect.right) {
                                    setInsetOffsetX(view, width - rect.right);
                                    width = TYPE_ON_TOUCH;
                                    if (width == 0) {
                                        setInsetOffsetX(view, TYPE_ON_INTERCEPT);
                                    }
                                    releaseTempRect(acquireTempRect);
                                }
                            }
                            width = i2;
                            if (width == 0) {
                                setInsetOffsetX(view, TYPE_ON_INTERCEPT);
                            }
                            releaseTempRect(acquireTempRect);
                        }
                    }
                    i2 = TYPE_ON_INTERCEPT;
                    if ((absoluteGravity & 5) == 5) {
                        width = layoutParams.mInsetOffsetX + ((getWidth() - acquireTempRect.right) - layoutParams.rightMargin);
                        if (width < rect.right) {
                            setInsetOffsetX(view, width - rect.right);
                            width = TYPE_ON_TOUCH;
                            if (width == 0) {
                                setInsetOffsetX(view, TYPE_ON_INTERCEPT);
                            }
                            releaseTempRect(acquireTempRect);
                        }
                    }
                    width = i2;
                    if (width == 0) {
                        setInsetOffsetX(view, TYPE_ON_INTERCEPT);
                    }
                    releaseTempRect(acquireTempRect);
                }
            }
            i2 = TYPE_ON_INTERCEPT;
            if ((absoluteGravity & 80) == 80) {
                height = ((getHeight() - acquireTempRect.bottom) - layoutParams.bottomMargin) + layoutParams.mInsetOffsetY;
                if (height < rect.bottom) {
                    setInsetOffsetY(view, height - rect.bottom);
                    i2 = TYPE_ON_TOUCH;
                }
            }
            if (i2 == 0) {
                setInsetOffsetY(view, TYPE_ON_INTERCEPT);
            }
            if ((absoluteGravity & 3) == 3) {
                i2 = (acquireTempRect.left - layoutParams.leftMargin) - layoutParams.mInsetOffsetX;
                if (i2 < rect.left) {
                    setInsetOffsetX(view, rect.left - i2);
                    i2 = TYPE_ON_TOUCH;
                    if ((absoluteGravity & 5) == 5) {
                        width = layoutParams.mInsetOffsetX + ((getWidth() - acquireTempRect.right) - layoutParams.rightMargin);
                        if (width < rect.right) {
                            setInsetOffsetX(view, width - rect.right);
                            width = TYPE_ON_TOUCH;
                            if (width == 0) {
                                setInsetOffsetX(view, TYPE_ON_INTERCEPT);
                            }
                            releaseTempRect(acquireTempRect);
                        }
                    }
                    width = i2;
                    if (width == 0) {
                        setInsetOffsetX(view, TYPE_ON_INTERCEPT);
                    }
                    releaseTempRect(acquireTempRect);
                }
            }
            i2 = TYPE_ON_INTERCEPT;
            if ((absoluteGravity & 5) == 5) {
                width = layoutParams.mInsetOffsetX + ((getWidth() - acquireTempRect.right) - layoutParams.rightMargin);
                if (width < rect.right) {
                    setInsetOffsetX(view, width - rect.right);
                    width = TYPE_ON_TOUCH;
                    if (width == 0) {
                        setInsetOffsetX(view, TYPE_ON_INTERCEPT);
                    }
                    releaseTempRect(acquireTempRect);
                }
            }
            width = i2;
            if (width == 0) {
                setInsetOffsetX(view, TYPE_ON_INTERCEPT);
            }
            releaseTempRect(acquireTempRect);
        }
    }

    private void setInsetOffsetX(View view, int i) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (layoutParams.mInsetOffsetX != i) {
            ViewCompat.offsetLeftAndRight(view, i - layoutParams.mInsetOffsetX);
            layoutParams.mInsetOffsetX = i;
        }
    }

    private void setInsetOffsetY(View view, int i) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (layoutParams.mInsetOffsetY != i) {
            ViewCompat.offsetTopAndBottom(view, i - layoutParams.mInsetOffsetY);
            layoutParams.mInsetOffsetY = i;
        }
    }

    public void dispatchDependentViewsChanged(View view) {
        List incomingEdges = this.mChildDag.getIncomingEdges(view);
        if (incomingEdges != null && !incomingEdges.isEmpty()) {
            for (int i = TYPE_ON_INTERCEPT; i < incomingEdges.size(); i += TYPE_ON_TOUCH) {
                View view2 = (View) incomingEdges.get(i);
                Behavior behavior = ((LayoutParams) view2.getLayoutParams()).getBehavior();
                if (behavior != null) {
                    behavior.onDependentViewChanged(this, view2, view);
                }
            }
        }
    }

    @NonNull
    public List<View> getDependencies(@NonNull View view) {
        Collection outgoingEdges = this.mChildDag.getOutgoingEdges(view);
        this.mTempDependenciesList.clear();
        if (outgoingEdges != null) {
            this.mTempDependenciesList.addAll(outgoingEdges);
        }
        return this.mTempDependenciesList;
    }

    @NonNull
    public List<View> getDependents(@NonNull View view) {
        Collection incomingEdges = this.mChildDag.getIncomingEdges(view);
        this.mTempDependenciesList.clear();
        if (incomingEdges != null) {
            this.mTempDependenciesList.addAll(incomingEdges);
        }
        return this.mTempDependenciesList;
    }

    @VisibleForTesting
    final List<View> getDependencySortedChildren() {
        prepareChildren();
        return Collections.unmodifiableList(this.mDependencySortedChildren);
    }

    void ensurePreDrawListener() {
        boolean z = false;
        int childCount = getChildCount();
        for (int i = TYPE_ON_INTERCEPT; i < childCount; i += TYPE_ON_TOUCH) {
            if (hasDependencies(getChildAt(i))) {
                z = true;
                break;
            }
        }
        if (z == this.mNeedsPreDrawListener) {
            return;
        }
        if (z) {
            addPreDrawListener();
        } else {
            removePreDrawListener();
        }
    }

    private boolean hasDependencies(View view) {
        return this.mChildDag.hasOutgoingEdges(view);
    }

    void addPreDrawListener() {
        if (this.mIsAttachedToWindow) {
            if (this.mOnPreDrawListener == null) {
                this.mOnPreDrawListener = new OnPreDrawListener();
            }
            getViewTreeObserver().addOnPreDrawListener(this.mOnPreDrawListener);
        }
        this.mNeedsPreDrawListener = true;
    }

    void removePreDrawListener() {
        if (this.mIsAttachedToWindow && this.mOnPreDrawListener != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.mOnPreDrawListener);
        }
        this.mNeedsPreDrawListener = false;
    }

    void offsetChildToAnchor(View view, int i) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (layoutParams.mAnchorView != null) {
            Rect acquireTempRect = acquireTempRect();
            Rect acquireTempRect2 = acquireTempRect();
            Rect acquireTempRect3 = acquireTempRect();
            getDescendantRect(layoutParams.mAnchorView, acquireTempRect);
            getChildRect(view, false, acquireTempRect2);
            int measuredWidth = view.getMeasuredWidth();
            int measuredHeight = view.getMeasuredHeight();
            getDesiredAnchoredChildRectWithoutConstraints(view, i, acquireTempRect, acquireTempRect3, layoutParams, measuredWidth, measuredHeight);
            boolean z = (acquireTempRect3.left == acquireTempRect2.left && acquireTempRect3.top == acquireTempRect2.top) ? false : true;
            constrainChildRect(layoutParams, acquireTempRect3, measuredWidth, measuredHeight);
            int i2 = acquireTempRect3.left - acquireTempRect2.left;
            int i3 = acquireTempRect3.top - acquireTempRect2.top;
            if (i2 != 0) {
                ViewCompat.offsetLeftAndRight(view, i2);
            }
            if (i3 != 0) {
                ViewCompat.offsetTopAndBottom(view, i3);
            }
            if (z) {
                Behavior behavior = layoutParams.getBehavior();
                if (behavior != null) {
                    behavior.onDependentViewChanged(this, view, layoutParams.mAnchorView);
                }
            }
            releaseTempRect(acquireTempRect);
            releaseTempRect(acquireTempRect2);
            releaseTempRect(acquireTempRect3);
        }
    }

    public boolean isPointInChildBounds(View view, int i, int i2) {
        Rect acquireTempRect = acquireTempRect();
        getDescendantRect(view, acquireTempRect);
        try {
            boolean contains = acquireTempRect.contains(i, i2);
            return contains;
        } finally {
            releaseTempRect(acquireTempRect);
        }
    }

    public boolean doViewsOverlap(View view, View view2) {
        boolean z = true;
        if (view.getVisibility() != 0 || view2.getVisibility() != 0) {
            return false;
        }
        boolean z2;
        Rect acquireTempRect = acquireTempRect();
        getChildRect(view, view.getParent() != this, acquireTempRect);
        Rect acquireTempRect2 = acquireTempRect();
        if (view2.getParent() != this) {
            z2 = true;
        } else {
            z2 = false;
        }
        getChildRect(view2, z2, acquireTempRect2);
        try {
            if (acquireTempRect.left > acquireTempRect2.right || acquireTempRect.top > acquireTempRect2.bottom || acquireTempRect.right < acquireTempRect2.left || acquireTempRect.bottom < acquireTempRect2.top) {
                z = false;
            }
            releaseTempRect(acquireTempRect);
            releaseTempRect(acquireTempRect2);
            return z;
        } catch (Throwable th) {
            releaseTempRect(acquireTempRect);
            releaseTempRect(acquireTempRect2);
        }
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    protected LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LayoutParams) {
            return new LayoutParams((LayoutParams) layoutParams);
        }
        if (layoutParams instanceof MarginLayoutParams) {
            return new LayoutParams((MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    protected LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    public boolean onStartNestedScroll(View view, View view2, int i) {
        int childCount = getChildCount();
        int i2 = TYPE_ON_INTERCEPT;
        boolean z = false;
        while (i2 < childCount) {
            boolean z2;
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 8) {
                z2 = z;
            } else {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                Behavior behavior = layoutParams.getBehavior();
                if (behavior != null) {
                    boolean onStartNestedScroll = behavior.onStartNestedScroll(this, childAt, view, view2, i);
                    z2 = z | onStartNestedScroll;
                    layoutParams.acceptNestedScroll(onStartNestedScroll);
                } else {
                    layoutParams.acceptNestedScroll(false);
                    z2 = z;
                }
            }
            i2 += TYPE_ON_TOUCH;
            z = z2;
        }
        return z;
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.mNestedScrollingParentHelper.onNestedScrollAccepted(view, view2, i);
        this.mNestedScrollingDirectChild = view;
        this.mNestedScrollingTarget = view2;
        int childCount = getChildCount();
        for (int i2 = TYPE_ON_INTERCEPT; i2 < childCount; i2 += TYPE_ON_TOUCH) {
            View childAt = getChildAt(i2);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (layoutParams.isNestedScrollAccepted()) {
                Behavior behavior = layoutParams.getBehavior();
                if (behavior != null) {
                    behavior.onNestedScrollAccepted(this, childAt, view, view2, i);
                }
            }
        }
    }

    public void onStopNestedScroll(View view) {
        this.mNestedScrollingParentHelper.onStopNestedScroll(view);
        int childCount = getChildCount();
        for (int i = TYPE_ON_INTERCEPT; i < childCount; i += TYPE_ON_TOUCH) {
            View childAt = getChildAt(i);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (layoutParams.isNestedScrollAccepted()) {
                Behavior behavior = layoutParams.getBehavior();
                if (behavior != null) {
                    behavior.onStopNestedScroll(this, childAt, view);
                }
                layoutParams.resetNestedScroll();
                layoutParams.resetChangedAfterNestedScroll();
            }
        }
        this.mNestedScrollingDirectChild = null;
        this.mNestedScrollingTarget = null;
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        Object obj = null;
        int i5 = TYPE_ON_INTERCEPT;
        while (i5 < childCount) {
            Object obj2;
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() == 8) {
                obj2 = obj;
            } else {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.isNestedScrollAccepted()) {
                    Behavior behavior = layoutParams.getBehavior();
                    if (behavior != null) {
                        behavior.onNestedScroll(this, childAt, view, i, i2, i3, i4);
                        obj2 = TYPE_ON_TOUCH;
                    } else {
                        obj2 = obj;
                    }
                } else {
                    obj2 = obj;
                }
            }
            i5 += TYPE_ON_TOUCH;
            obj = obj2;
        }
        if (obj != null) {
            onChildViewsChanged(TYPE_ON_TOUCH);
        }
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        int i3 = TYPE_ON_INTERCEPT;
        int i4 = TYPE_ON_INTERCEPT;
        Object obj = null;
        int childCount = getChildCount();
        int i5 = TYPE_ON_INTERCEPT;
        while (i5 < childCount) {
            Object obj2;
            int i6;
            int i7;
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() == 8) {
                obj2 = obj;
                i6 = i3;
                i7 = i4;
            } else {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.isNestedScrollAccepted()) {
                    Behavior behavior = layoutParams.getBehavior();
                    if (behavior != null) {
                        int max;
                        int[] iArr2 = this.mTempIntPair;
                        this.mTempIntPair[TYPE_ON_TOUCH] = TYPE_ON_INTERCEPT;
                        iArr2[TYPE_ON_INTERCEPT] = TYPE_ON_INTERCEPT;
                        behavior.onNestedPreScroll(this, childAt, view, i, i2, this.mTempIntPair);
                        if (i > 0) {
                            i6 = Math.max(i3, this.mTempIntPair[TYPE_ON_INTERCEPT]);
                        } else {
                            i6 = Math.min(i3, this.mTempIntPair[TYPE_ON_INTERCEPT]);
                        }
                        if (i2 > 0) {
                            max = Math.max(i4, this.mTempIntPair[TYPE_ON_TOUCH]);
                        } else {
                            max = Math.min(i4, this.mTempIntPair[TYPE_ON_TOUCH]);
                        }
                        i7 = max;
                        max = TYPE_ON_TOUCH;
                    } else {
                        obj2 = obj;
                        i6 = i3;
                        i7 = i4;
                    }
                } else {
                    obj2 = obj;
                    i6 = i3;
                    i7 = i4;
                }
            }
            i5 += TYPE_ON_TOUCH;
            i4 = i7;
            i3 = i6;
            obj = obj2;
        }
        iArr[TYPE_ON_INTERCEPT] = i3;
        iArr[TYPE_ON_TOUCH] = i4;
        if (obj != null) {
            onChildViewsChanged(TYPE_ON_TOUCH);
        }
    }

    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        int childCount = getChildCount();
        int i = TYPE_ON_INTERCEPT;
        boolean z2 = false;
        while (i < childCount) {
            boolean z3;
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 8) {
                z3 = z2;
            } else {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.isNestedScrollAccepted()) {
                    Behavior behavior = layoutParams.getBehavior();
                    if (behavior != null) {
                        z3 = behavior.onNestedFling(this, childAt, view, f, f2, z) | z2;
                    } else {
                        z3 = z2;
                    }
                } else {
                    z3 = z2;
                }
            }
            i += TYPE_ON_TOUCH;
            z2 = z3;
        }
        if (z2) {
            onChildViewsChanged(TYPE_ON_TOUCH);
        }
        return z2;
    }

    public boolean onNestedPreFling(View view, float f, float f2) {
        int childCount = getChildCount();
        int i = TYPE_ON_INTERCEPT;
        boolean z = false;
        while (i < childCount) {
            boolean z2;
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 8) {
                z2 = z;
            } else {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.isNestedScrollAccepted()) {
                    Behavior behavior = layoutParams.getBehavior();
                    if (behavior != null) {
                        z2 = behavior.onNestedPreFling(this, childAt, view, f, f2) | z;
                    } else {
                        z2 = z;
                    }
                } else {
                    z2 = z;
                }
            }
            i += TYPE_ON_TOUCH;
            z = z2;
        }
        return z;
    }

    public int getNestedScrollAxes() {
        return this.mNestedScrollingParentHelper.getNestedScrollAxes();
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            SparseArray sparseArray = savedState.behaviorStates;
            int childCount = getChildCount();
            for (int i = TYPE_ON_INTERCEPT; i < childCount; i += TYPE_ON_TOUCH) {
                View childAt = getChildAt(i);
                int id = childAt.getId();
                Behavior behavior = getResolvedLayoutParams(childAt).getBehavior();
                if (!(id == -1 || behavior == null)) {
                    Parcelable parcelable2 = (Parcelable) sparseArray.get(id);
                    if (parcelable2 != null) {
                        behavior.onRestoreInstanceState(this, childAt, parcelable2);
                    }
                }
            }
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        SparseArray sparseArray = new SparseArray();
        int childCount = getChildCount();
        for (int i = TYPE_ON_INTERCEPT; i < childCount; i += TYPE_ON_TOUCH) {
            View childAt = getChildAt(i);
            int id = childAt.getId();
            Behavior behavior = ((LayoutParams) childAt.getLayoutParams()).getBehavior();
            if (!(id == -1 || behavior == null)) {
                Parcelable onSaveInstanceState = behavior.onSaveInstanceState(this, childAt);
                if (onSaveInstanceState != null) {
                    sparseArray.append(id, onSaveInstanceState);
                }
            }
        }
        savedState.behaviorStates = sparseArray;
        return savedState;
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        Behavior behavior = ((LayoutParams) view.getLayoutParams()).getBehavior();
        if (behavior == null || !behavior.onRequestChildRectangleOnScreen(this, view, rect, z)) {
            return super.requestChildRectangleOnScreen(view, rect, z);
        }
        return true;
    }

    private void setupForInsets() {
        if (VERSION.SDK_INT >= 21) {
            if (ViewCompat.getFitsSystemWindows(this)) {
                if (this.mApplyWindowInsetsListener == null) {
                    this.mApplyWindowInsetsListener = new C00351();
                }
                ViewCompat.setOnApplyWindowInsetsListener(this, this.mApplyWindowInsetsListener);
                setSystemUiVisibility(1280);
                return;
            }
            ViewCompat.setOnApplyWindowInsetsListener(this, null);
        }
    }
}
