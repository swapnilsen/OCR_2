package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.annotation.TargetApi;
import android.support.annotation.RequiresApi;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.v4.util.ArrayMap;
import android.support.v4.util.LongSparseArray;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@TargetApi(14)
@RequiresApi(14)
abstract class TransitionPort implements Cloneable {
    static final boolean DBG = false;
    private static final String LOG_TAG = "Transition";
    private static ThreadLocal<ArrayMap<Animator, AnimationInfo>> sRunningAnimators;
    ArrayList<Animator> mAnimators;
    boolean mCanRemoveViews;
    ArrayList<Animator> mCurrentAnimators;
    long mDuration;
    private TransitionValuesMaps mEndValues;
    private boolean mEnded;
    TimeInterpolator mInterpolator;
    ArrayList<TransitionListener> mListeners;
    private String mName;
    int mNumInstances;
    TransitionSetPort mParent;
    boolean mPaused;
    ViewGroup mSceneRoot;
    long mStartDelay;
    private TransitionValuesMaps mStartValues;
    ArrayList<View> mTargetChildExcludes;
    ArrayList<View> mTargetExcludes;
    ArrayList<Integer> mTargetIdChildExcludes;
    ArrayList<Integer> mTargetIdExcludes;
    ArrayList<Integer> mTargetIds;
    ArrayList<Class> mTargetTypeChildExcludes;
    ArrayList<Class> mTargetTypeExcludes;
    ArrayList<View> mTargets;

    public interface TransitionListener {
        void onTransitionCancel(TransitionPort transitionPort);

        void onTransitionEnd(TransitionPort transitionPort);

        void onTransitionPause(TransitionPort transitionPort);

        void onTransitionResume(TransitionPort transitionPort);

        void onTransitionStart(TransitionPort transitionPort);
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public static class TransitionListenerAdapter implements TransitionListener {
        public void onTransitionStart(TransitionPort transitionPort) {
        }

        public void onTransitionEnd(TransitionPort transitionPort) {
        }

        public void onTransitionCancel(TransitionPort transitionPort) {
        }

        public void onTransitionPause(TransitionPort transitionPort) {
        }

        public void onTransitionResume(TransitionPort transitionPort) {
        }
    }

    /* renamed from: android.support.transition.TransitionPort.1 */
    class C00801 extends AnimatorListenerAdapter {
        final /* synthetic */ ArrayMap val$runningAnimators;

        C00801(ArrayMap arrayMap) {
            this.val$runningAnimators = arrayMap;
        }

        public void onAnimationStart(Animator animator) {
            TransitionPort.this.mCurrentAnimators.add(animator);
        }

        public void onAnimationEnd(Animator animator) {
            this.val$runningAnimators.remove(animator);
            TransitionPort.this.mCurrentAnimators.remove(animator);
        }
    }

    /* renamed from: android.support.transition.TransitionPort.2 */
    class C00812 extends AnimatorListenerAdapter {
        C00812() {
        }

        public void onAnimationEnd(Animator animator) {
            TransitionPort.this.end();
            animator.removeListener(this);
        }
    }

    private static class AnimationInfo {
        String name;
        TransitionValues values;
        View view;
        WindowIdPort windowId;

        AnimationInfo(View view, String str, WindowIdPort windowIdPort, TransitionValues transitionValues) {
            this.view = view;
            this.name = str;
            this.values = transitionValues;
            this.windowId = windowIdPort;
        }
    }

    private static class ArrayListManager {
        private ArrayListManager() {
        }

        static <T> ArrayList<T> add(ArrayList<T> arrayList, T t) {
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            if (!arrayList.contains(t)) {
                arrayList.add(t);
            }
            return arrayList;
        }

        static <T> ArrayList<T> remove(ArrayList<T> arrayList, T t) {
            if (arrayList == null) {
                return arrayList;
            }
            arrayList.remove(t);
            if (arrayList.isEmpty()) {
                return null;
            }
            return arrayList;
        }
    }

    public abstract void captureEndValues(TransitionValues transitionValues);

    public abstract void captureStartValues(TransitionValues transitionValues);

    static {
        sRunningAnimators = new ThreadLocal();
    }

    public TransitionPort() {
        this.mStartDelay = -1;
        this.mDuration = -1;
        this.mInterpolator = null;
        this.mTargetIds = new ArrayList();
        this.mTargets = new ArrayList();
        this.mTargetIdExcludes = null;
        this.mTargetExcludes = null;
        this.mTargetTypeExcludes = null;
        this.mTargetIdChildExcludes = null;
        this.mTargetChildExcludes = null;
        this.mTargetTypeChildExcludes = null;
        this.mParent = null;
        this.mSceneRoot = null;
        this.mCanRemoveViews = DBG;
        this.mNumInstances = 0;
        this.mPaused = DBG;
        this.mListeners = null;
        this.mAnimators = new ArrayList();
        this.mName = getClass().getName();
        this.mStartValues = new TransitionValuesMaps();
        this.mEndValues = new TransitionValuesMaps();
        this.mCurrentAnimators = new ArrayList();
        this.mEnded = DBG;
    }

    private static ArrayMap<Animator, AnimationInfo> getRunningAnimators() {
        ArrayMap<Animator, AnimationInfo> arrayMap = (ArrayMap) sRunningAnimators.get();
        if (arrayMap != null) {
            return arrayMap;
        }
        arrayMap = new ArrayMap();
        sRunningAnimators.set(arrayMap);
        return arrayMap;
    }

    public long getDuration() {
        return this.mDuration;
    }

    public TransitionPort setDuration(long j) {
        this.mDuration = j;
        return this;
    }

    public long getStartDelay() {
        return this.mStartDelay;
    }

    public TransitionPort setStartDelay(long j) {
        this.mStartDelay = j;
        return this;
    }

    public TimeInterpolator getInterpolator() {
        return this.mInterpolator;
    }

    public TransitionPort setInterpolator(TimeInterpolator timeInterpolator) {
        this.mInterpolator = timeInterpolator;
        return this;
    }

    public String[] getTransitionProperties() {
        return null;
    }

    public Animator createAnimator(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return null;
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    protected void createAnimators(ViewGroup viewGroup, TransitionValuesMaps transitionValuesMaps, TransitionValuesMaps transitionValuesMaps2) {
        int i;
        int i2;
        ArrayMap arrayMap = new ArrayMap(transitionValuesMaps2.viewValues);
        SparseArray sparseArray = new SparseArray(transitionValuesMaps2.idValues.size());
        for (i = 0; i < transitionValuesMaps2.idValues.size(); i++) {
            sparseArray.put(transitionValuesMaps2.idValues.keyAt(i), transitionValuesMaps2.idValues.valueAt(i));
        }
        LongSparseArray longSparseArray = new LongSparseArray(transitionValuesMaps2.itemIdValues.size());
        for (i = 0; i < transitionValuesMaps2.itemIdValues.size(); i++) {
            longSparseArray.put(transitionValuesMaps2.itemIdValues.keyAt(i), transitionValuesMaps2.itemIdValues.valueAt(i));
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (View view : transitionValuesMaps.viewValues.keySet()) {
            Object obj = null;
            if (view.getParent() instanceof ListView) {
                obj = 1;
            }
            if (obj == null) {
                Object obj2;
                int id = view.getId();
                if (transitionValuesMaps.viewValues.get(view) != null) {
                    obj2 = (TransitionValues) transitionValuesMaps.viewValues.get(view);
                } else {
                    TransitionValues transitionValues = (TransitionValues) transitionValuesMaps.idValues.get(id);
                }
                if (transitionValuesMaps2.viewValues.get(view) != null) {
                    obj = (TransitionValues) transitionValuesMaps2.viewValues.get(view);
                    arrayMap.remove(view);
                } else if (id != -1) {
                    TransitionValues transitionValues2 = (TransitionValues) transitionValuesMaps2.idValues.get(id);
                    View view2 = null;
                    for (View view3 : arrayMap.keySet()) {
                        View view32;
                        if (view32.getId() != id) {
                            view32 = view2;
                        }
                        view2 = view32;
                    }
                    if (view2 != null) {
                        arrayMap.remove(view2);
                    }
                } else {
                    obj = null;
                }
                sparseArray.remove(id);
                if (isValidTarget(view, (long) id)) {
                    arrayList.add(obj2);
                    arrayList2.add(obj);
                }
            } else {
                ListView listView = (ListView) view.getParent();
                if (listView.getAdapter().hasStableIds()) {
                    long itemIdAtPosition = listView.getItemIdAtPosition(listView.getPositionForView(view));
                    TransitionValues transitionValues3 = (TransitionValues) transitionValuesMaps.itemIdValues.get(itemIdAtPosition);
                    longSparseArray.remove(itemIdAtPosition);
                    arrayList.add(transitionValues3);
                    arrayList2.add(null);
                }
            }
        }
        int size = transitionValuesMaps.itemIdValues.size();
        for (i2 = 0; i2 < size; i2++) {
            long keyAt = transitionValuesMaps.itemIdValues.keyAt(i2);
            if (isValidTarget(null, keyAt)) {
                transitionValues3 = (TransitionValues) transitionValuesMaps.itemIdValues.get(keyAt);
                transitionValues2 = (TransitionValues) transitionValuesMaps2.itemIdValues.get(keyAt);
                longSparseArray.remove(keyAt);
                arrayList.add(transitionValues3);
                arrayList2.add(transitionValues2);
            }
        }
        for (View view4 : arrayMap.keySet()) {
            size = view4.getId();
            if (isValidTarget(view4, (long) size)) {
                if (transitionValuesMaps.viewValues.get(view4) != null) {
                    obj = (TransitionValues) transitionValuesMaps.viewValues.get(view4);
                } else {
                    transitionValues2 = (TransitionValues) transitionValuesMaps.idValues.get(size);
                }
                transitionValues3 = (TransitionValues) arrayMap.get(view4);
                sparseArray.remove(size);
                arrayList.add(obj);
                arrayList2.add(transitionValues3);
            }
        }
        size = sparseArray.size();
        for (i2 = 0; i2 < size; i2++) {
            int keyAt2 = sparseArray.keyAt(i2);
            if (isValidTarget(null, (long) keyAt2)) {
                transitionValues3 = (TransitionValues) transitionValuesMaps.idValues.get(keyAt2);
                transitionValues2 = (TransitionValues) sparseArray.get(keyAt2);
                arrayList.add(transitionValues3);
                arrayList2.add(transitionValues2);
            }
        }
        size = longSparseArray.size();
        for (i2 = 0; i2 < size; i2++) {
            long keyAt3 = longSparseArray.keyAt(i2);
            transitionValues2 = (TransitionValues) longSparseArray.get(keyAt3);
            arrayList.add((TransitionValues) transitionValuesMaps.itemIdValues.get(keyAt3));
            arrayList2.add(transitionValues2);
        }
        ArrayMap runningAnimators = getRunningAnimators();
        for (i2 = 0; i2 < arrayList.size(); i2++) {
            transitionValues3 = (TransitionValues) arrayList.get(i2);
            transitionValues2 = (TransitionValues) arrayList2.get(i2);
            if (!(transitionValues3 == null && transitionValues2 == null) && (transitionValues3 == null || !transitionValues3.equals(transitionValues2))) {
                Object createAnimator = createAnimator(viewGroup, transitionValues3, transitionValues2);
                if (createAnimator != null) {
                    View view5;
                    if (transitionValues2 != null) {
                        View view6 = transitionValues2.view;
                        String[] transitionProperties = getTransitionProperties();
                        if (view6 == null || transitionProperties == null || transitionProperties.length <= 0) {
                            transitionValues3 = null;
                            obj = createAnimator;
                        } else {
                            transitionValues = new TransitionValues();
                            transitionValues.view = view6;
                            transitionValues3 = (TransitionValues) transitionValuesMaps2.viewValues.get(view6);
                            if (transitionValues3 != null) {
                                for (keyAt2 = 0; keyAt2 < transitionProperties.length; keyAt2++) {
                                    transitionValues.values.put(transitionProperties[keyAt2], transitionValues3.values.get(transitionProperties[keyAt2]));
                                }
                            }
                            int size2 = runningAnimators.size();
                            for (keyAt2 = 0; keyAt2 < size2; keyAt2++) {
                                AnimationInfo animationInfo = (AnimationInfo) runningAnimators.get((Animator) runningAnimators.keyAt(keyAt2));
                                if (animationInfo.values != null && animationInfo.view == view6 && (((animationInfo.name == null && getName() == null) || animationInfo.name.equals(getName())) && animationInfo.values.equals(transitionValues))) {
                                    obj = null;
                                    transitionValues3 = transitionValues;
                                    break;
                                }
                            }
                            transitionValues3 = transitionValues;
                            obj = createAnimator;
                        }
                        createAnimator = obj;
                        view5 = view6;
                    } else {
                        view5 = transitionValues3.view;
                        transitionValues3 = null;
                    }
                    if (createAnimator != null) {
                        runningAnimators.put(createAnimator, new AnimationInfo(view5, getName(), WindowIdPort.getWindowId(viewGroup), transitionValues3));
                        this.mAnimators.add(createAnimator);
                    }
                }
            }
        }
    }

    boolean isValidTarget(View view, long j) {
        if (this.mTargetIdExcludes != null && this.mTargetIdExcludes.contains(Integer.valueOf((int) j))) {
            return DBG;
        }
        if (this.mTargetExcludes != null && this.mTargetExcludes.contains(view)) {
            return DBG;
        }
        int i;
        if (!(this.mTargetTypeExcludes == null || view == null)) {
            int size = this.mTargetTypeExcludes.size();
            for (i = 0; i < size; i++) {
                if (((Class) this.mTargetTypeExcludes.get(i)).isInstance(view)) {
                    return DBG;
                }
            }
        }
        if (this.mTargetIds.size() == 0 && this.mTargets.size() == 0) {
            return true;
        }
        if (this.mTargetIds.size() > 0) {
            for (i = 0; i < this.mTargetIds.size(); i++) {
                if (((long) ((Integer) this.mTargetIds.get(i)).intValue()) == j) {
                    return true;
                }
            }
        }
        if (view == null || this.mTargets.size() <= 0) {
            return DBG;
        }
        for (int i2 = 0; i2 < this.mTargets.size(); i2++) {
            if (this.mTargets.get(i2) == view) {
                return true;
            }
        }
        return DBG;
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    protected void runAnimators() {
        start();
        ArrayMap runningAnimators = getRunningAnimators();
        Iterator it = this.mAnimators.iterator();
        while (it.hasNext()) {
            Animator animator = (Animator) it.next();
            if (runningAnimators.containsKey(animator)) {
                start();
                runAnimator(animator, runningAnimators);
            }
        }
        this.mAnimators.clear();
        end();
    }

    private void runAnimator(Animator animator, ArrayMap<Animator, AnimationInfo> arrayMap) {
        if (animator != null) {
            animator.addListener(new C00801(arrayMap));
            animate(animator);
        }
    }

    public TransitionPort addTarget(int i) {
        if (i > 0) {
            this.mTargetIds.add(Integer.valueOf(i));
        }
        return this;
    }

    public TransitionPort removeTarget(int i) {
        if (i > 0) {
            this.mTargetIds.remove(Integer.valueOf(i));
        }
        return this;
    }

    public TransitionPort excludeTarget(int i, boolean z) {
        this.mTargetIdExcludes = excludeId(this.mTargetIdExcludes, i, z);
        return this;
    }

    public TransitionPort excludeChildren(int i, boolean z) {
        this.mTargetIdChildExcludes = excludeId(this.mTargetIdChildExcludes, i, z);
        return this;
    }

    private ArrayList<Integer> excludeId(ArrayList<Integer> arrayList, int i, boolean z) {
        if (i <= 0) {
            return arrayList;
        }
        if (z) {
            return ArrayListManager.add(arrayList, Integer.valueOf(i));
        }
        return ArrayListManager.remove(arrayList, Integer.valueOf(i));
    }

    public TransitionPort excludeTarget(View view, boolean z) {
        this.mTargetExcludes = excludeView(this.mTargetExcludes, view, z);
        return this;
    }

    public TransitionPort excludeChildren(View view, boolean z) {
        this.mTargetChildExcludes = excludeView(this.mTargetChildExcludes, view, z);
        return this;
    }

    private ArrayList<View> excludeView(ArrayList<View> arrayList, View view, boolean z) {
        if (view == null) {
            return arrayList;
        }
        if (z) {
            return ArrayListManager.add(arrayList, view);
        }
        return ArrayListManager.remove(arrayList, view);
    }

    public TransitionPort excludeTarget(Class cls, boolean z) {
        this.mTargetTypeExcludes = excludeType(this.mTargetTypeExcludes, cls, z);
        return this;
    }

    public TransitionPort excludeChildren(Class cls, boolean z) {
        this.mTargetTypeChildExcludes = excludeType(this.mTargetTypeChildExcludes, cls, z);
        return this;
    }

    private ArrayList<Class> excludeType(ArrayList<Class> arrayList, Class cls, boolean z) {
        if (cls == null) {
            return arrayList;
        }
        if (z) {
            return ArrayListManager.add(arrayList, cls);
        }
        return ArrayListManager.remove(arrayList, cls);
    }

    public TransitionPort addTarget(View view) {
        this.mTargets.add(view);
        return this;
    }

    public TransitionPort removeTarget(View view) {
        if (view != null) {
            this.mTargets.remove(view);
        }
        return this;
    }

    public List<Integer> getTargetIds() {
        return this.mTargetIds;
    }

    public List<View> getTargets() {
        return this.mTargets;
    }

    void captureValues(ViewGroup viewGroup, boolean z) {
        int i = 0;
        clearValues(z);
        if (this.mTargetIds.size() > 0 || this.mTargets.size() > 0) {
            if (this.mTargetIds.size() > 0) {
                for (int i2 = 0; i2 < this.mTargetIds.size(); i2++) {
                    int intValue = ((Integer) this.mTargetIds.get(i2)).intValue();
                    View findViewById = viewGroup.findViewById(intValue);
                    if (findViewById != null) {
                        TransitionValues transitionValues = new TransitionValues();
                        transitionValues.view = findViewById;
                        if (z) {
                            captureStartValues(transitionValues);
                        } else {
                            captureEndValues(transitionValues);
                        }
                        if (z) {
                            this.mStartValues.viewValues.put(findViewById, transitionValues);
                            if (intValue >= 0) {
                                this.mStartValues.idValues.put(intValue, transitionValues);
                            }
                        } else {
                            this.mEndValues.viewValues.put(findViewById, transitionValues);
                            if (intValue >= 0) {
                                this.mEndValues.idValues.put(intValue, transitionValues);
                            }
                        }
                    }
                }
            }
            if (this.mTargets.size() > 0) {
                while (i < this.mTargets.size()) {
                    View view = (View) this.mTargets.get(i);
                    if (view != null) {
                        TransitionValues transitionValues2 = new TransitionValues();
                        transitionValues2.view = view;
                        if (z) {
                            captureStartValues(transitionValues2);
                        } else {
                            captureEndValues(transitionValues2);
                        }
                        if (z) {
                            this.mStartValues.viewValues.put(view, transitionValues2);
                        } else {
                            this.mEndValues.viewValues.put(view, transitionValues2);
                        }
                    }
                    i++;
                }
                return;
            }
            return;
        }
        captureHierarchy(viewGroup, z);
    }

    void clearValues(boolean z) {
        if (z) {
            this.mStartValues.viewValues.clear();
            this.mStartValues.idValues.clear();
            this.mStartValues.itemIdValues.clear();
            return;
        }
        this.mEndValues.viewValues.clear();
        this.mEndValues.idValues.clear();
        this.mEndValues.itemIdValues.clear();
    }

    private void captureHierarchy(View view, boolean z) {
        if (view != null) {
            Object obj;
            if (view.getParent() instanceof ListView) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj == null || ((ListView) view.getParent()).getAdapter().hasStableIds()) {
                int id;
                long j;
                if (obj == null) {
                    id = view.getId();
                    j = -1;
                } else {
                    ListView listView = (ListView) view.getParent();
                    long itemIdAtPosition = listView.getItemIdAtPosition(listView.getPositionForView(view));
                    id = -1;
                }
                if (this.mTargetIdExcludes != null && this.mTargetIdExcludes.contains(Integer.valueOf(id))) {
                    return;
                }
                if (this.mTargetExcludes == null || !this.mTargetExcludes.contains(view)) {
                    if (!(this.mTargetTypeExcludes == null || view == null)) {
                        int size = this.mTargetTypeExcludes.size();
                        int i = 0;
                        while (i < size) {
                            if (!((Class) this.mTargetTypeExcludes.get(i)).isInstance(view)) {
                                i++;
                            } else {
                                return;
                            }
                        }
                    }
                    TransitionValues transitionValues = new TransitionValues();
                    transitionValues.view = view;
                    if (z) {
                        captureStartValues(transitionValues);
                    } else {
                        captureEndValues(transitionValues);
                    }
                    if (z) {
                        if (obj == null) {
                            this.mStartValues.viewValues.put(view, transitionValues);
                            if (id >= 0) {
                                this.mStartValues.idValues.put(id, transitionValues);
                            }
                        } else {
                            this.mStartValues.itemIdValues.put(j, transitionValues);
                        }
                    } else if (obj == null) {
                        this.mEndValues.viewValues.put(view, transitionValues);
                        if (id >= 0) {
                            this.mEndValues.idValues.put(id, transitionValues);
                        }
                    } else {
                        this.mEndValues.itemIdValues.put(j, transitionValues);
                    }
                    if (!(view instanceof ViewGroup)) {
                        return;
                    }
                    if (this.mTargetIdChildExcludes != null && this.mTargetIdChildExcludes.contains(Integer.valueOf(id))) {
                        return;
                    }
                    if (this.mTargetChildExcludes == null || !this.mTargetChildExcludes.contains(view)) {
                        if (!(this.mTargetTypeChildExcludes == null || view == null)) {
                            int size2 = this.mTargetTypeChildExcludes.size();
                            id = 0;
                            while (id < size2) {
                                if (!((Class) this.mTargetTypeChildExcludes.get(id)).isInstance(view)) {
                                    id++;
                                } else {
                                    return;
                                }
                            }
                        }
                        ViewGroup viewGroup = (ViewGroup) view;
                        for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                            captureHierarchy(viewGroup.getChildAt(i2), z);
                        }
                    }
                }
            }
        }
    }

    public TransitionValues getTransitionValues(View view, boolean z) {
        if (this.mParent != null) {
            return this.mParent.getTransitionValues(view, z);
        }
        TransitionValuesMaps transitionValuesMaps = z ? this.mStartValues : this.mEndValues;
        TransitionValues transitionValues = (TransitionValues) transitionValuesMaps.viewValues.get(view);
        if (transitionValues != null) {
            return transitionValues;
        }
        int id = view.getId();
        if (id >= 0) {
            transitionValues = (TransitionValues) transitionValuesMaps.idValues.get(id);
        }
        if (transitionValues != null || !(view.getParent() instanceof ListView)) {
            return transitionValues;
        }
        ListView listView = (ListView) view.getParent();
        return (TransitionValues) transitionValuesMaps.itemIdValues.get(listView.getItemIdAtPosition(listView.getPositionForView(view)));
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public void pause(View view) {
        if (!this.mEnded) {
            ArrayMap runningAnimators = getRunningAnimators();
            int size = runningAnimators.size();
            WindowIdPort windowId = WindowIdPort.getWindowId(view);
            for (int i = size - 1; i >= 0; i--) {
                AnimationInfo animationInfo = (AnimationInfo) runningAnimators.valueAt(i);
                if (animationInfo.view != null && windowId.equals(animationInfo.windowId)) {
                    ((Animator) runningAnimators.keyAt(i)).cancel();
                }
            }
            if (this.mListeners != null && this.mListeners.size() > 0) {
                ArrayList arrayList = (ArrayList) this.mListeners.clone();
                int size2 = arrayList.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    ((TransitionListener) arrayList.get(i2)).onTransitionPause(this);
                }
            }
            this.mPaused = true;
        }
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public void resume(View view) {
        if (this.mPaused) {
            if (!this.mEnded) {
                ArrayMap runningAnimators = getRunningAnimators();
                int size = runningAnimators.size();
                WindowIdPort windowId = WindowIdPort.getWindowId(view);
                for (int i = size - 1; i >= 0; i--) {
                    AnimationInfo animationInfo = (AnimationInfo) runningAnimators.valueAt(i);
                    if (animationInfo.view != null && windowId.equals(animationInfo.windowId)) {
                        ((Animator) runningAnimators.keyAt(i)).end();
                    }
                }
                if (this.mListeners != null && this.mListeners.size() > 0) {
                    ArrayList arrayList = (ArrayList) this.mListeners.clone();
                    int size2 = arrayList.size();
                    for (int i2 = 0; i2 < size2; i2++) {
                        ((TransitionListener) arrayList.get(i2)).onTransitionResume(this);
                    }
                }
            }
            this.mPaused = DBG;
        }
    }

    void playTransition(ViewGroup viewGroup) {
        ArrayMap runningAnimators = getRunningAnimators();
        for (int size = runningAnimators.size() - 1; size >= 0; size--) {
            Animator animator = (Animator) runningAnimators.keyAt(size);
            if (animator != null) {
                AnimationInfo animationInfo = (AnimationInfo) runningAnimators.get(animator);
                if (!(animationInfo == null || animationInfo.view == null || animationInfo.view.getContext() != viewGroup.getContext())) {
                    TransitionValues transitionValues;
                    Object obj;
                    TransitionValues transitionValues2 = animationInfo.values;
                    View view = animationInfo.view;
                    TransitionValues transitionValues3 = this.mEndValues.viewValues != null ? (TransitionValues) this.mEndValues.viewValues.get(view) : null;
                    if (transitionValues3 == null) {
                        transitionValues = (TransitionValues) this.mEndValues.idValues.get(view.getId());
                    } else {
                        transitionValues = transitionValues3;
                    }
                    if (!(transitionValues2 == null || transitionValues == null)) {
                        for (String str : transitionValues2.values.keySet()) {
                            Object obj2 = transitionValues2.values.get(str);
                            obj = transitionValues.values.get(str);
                            if (obj2 != null && obj != null && !obj2.equals(obj)) {
                                obj = 1;
                                break;
                            }
                        }
                    }
                    obj = null;
                    if (obj != null) {
                        if (animator.isRunning() || animator.isStarted()) {
                            animator.cancel();
                        } else {
                            runningAnimators.remove(animator);
                        }
                    }
                }
            }
        }
        createAnimators(viewGroup, this.mStartValues, this.mEndValues);
        runAnimators();
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    protected void animate(Animator animator) {
        if (animator == null) {
            end();
            return;
        }
        if (getDuration() >= 0) {
            animator.setDuration(getDuration());
        }
        if (getStartDelay() >= 0) {
            animator.setStartDelay(getStartDelay());
        }
        if (getInterpolator() != null) {
            animator.setInterpolator(getInterpolator());
        }
        animator.addListener(new C00812());
        animator.start();
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    protected void start() {
        if (this.mNumInstances == 0) {
            if (this.mListeners != null && this.mListeners.size() > 0) {
                ArrayList arrayList = (ArrayList) this.mListeners.clone();
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    ((TransitionListener) arrayList.get(i)).onTransitionStart(this);
                }
            }
            this.mEnded = DBG;
        }
        this.mNumInstances++;
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    protected void end() {
        int i = 0;
        this.mNumInstances--;
        if (this.mNumInstances == 0) {
            View view;
            if (this.mListeners != null && this.mListeners.size() > 0) {
                ArrayList arrayList = (ArrayList) this.mListeners.clone();
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ((TransitionListener) arrayList.get(i2)).onTransitionEnd(this);
                }
            }
            for (int i3 = 0; i3 < this.mStartValues.itemIdValues.size(); i3++) {
                view = ((TransitionValues) this.mStartValues.itemIdValues.valueAt(i3)).view;
            }
            while (i < this.mEndValues.itemIdValues.size()) {
                view = ((TransitionValues) this.mEndValues.itemIdValues.valueAt(i)).view;
                i++;
            }
            this.mEnded = true;
        }
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    protected void cancel() {
        for (int size = this.mCurrentAnimators.size() - 1; size >= 0; size--) {
            ((Animator) this.mCurrentAnimators.get(size)).cancel();
        }
        if (this.mListeners != null && this.mListeners.size() > 0) {
            ArrayList arrayList = (ArrayList) this.mListeners.clone();
            int size2 = arrayList.size();
            for (int i = 0; i < size2; i++) {
                ((TransitionListener) arrayList.get(i)).onTransitionCancel(this);
            }
        }
    }

    public TransitionPort addListener(TransitionListener transitionListener) {
        if (this.mListeners == null) {
            this.mListeners = new ArrayList();
        }
        this.mListeners.add(transitionListener);
        return this;
    }

    public TransitionPort removeListener(TransitionListener transitionListener) {
        if (this.mListeners != null) {
            this.mListeners.remove(transitionListener);
            if (this.mListeners.size() == 0) {
                this.mListeners = null;
            }
        }
        return this;
    }

    TransitionPort setSceneRoot(ViewGroup viewGroup) {
        this.mSceneRoot = viewGroup;
        return this;
    }

    void setCanRemoveViews(boolean z) {
        this.mCanRemoveViews = z;
    }

    public String toString() {
        return toString(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING);
    }

    public TransitionPort clone() {
        try {
            TransitionPort transitionPort = (TransitionPort) super.clone();
            try {
                transitionPort.mAnimators = new ArrayList();
                transitionPort.mStartValues = new TransitionValuesMaps();
                transitionPort.mEndValues = new TransitionValuesMaps();
                return transitionPort;
            } catch (CloneNotSupportedException e) {
                return transitionPort;
            }
        } catch (CloneNotSupportedException e2) {
            return null;
        }
    }

    public String getName() {
        return this.mName;
    }

    String toString(String str) {
        int i = 0;
        String str2 = str + getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + ": ";
        if (this.mDuration != -1) {
            str2 = str2 + "dur(" + this.mDuration + ") ";
        }
        if (this.mStartDelay != -1) {
            str2 = str2 + "dly(" + this.mStartDelay + ") ";
        }
        if (this.mInterpolator != null) {
            str2 = str2 + "interp(" + this.mInterpolator + ") ";
        }
        if (this.mTargetIds.size() <= 0 && this.mTargets.size() <= 0) {
            return str2;
        }
        String str3;
        str2 = str2 + "tgts(";
        if (this.mTargetIds.size() > 0) {
            str3 = str2;
            for (int i2 = 0; i2 < this.mTargetIds.size(); i2++) {
                if (i2 > 0) {
                    str3 = str3 + ", ";
                }
                str3 = str3 + this.mTargetIds.get(i2);
            }
        } else {
            str3 = str2;
        }
        if (this.mTargets.size() > 0) {
            while (i < this.mTargets.size()) {
                if (i > 0) {
                    str3 = str3 + ", ";
                }
                str3 = str3 + this.mTargets.get(i);
                i++;
            }
        }
        return str3 + ")";
    }
}
