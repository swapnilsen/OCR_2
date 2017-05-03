package android.support.v4.app;

import android.annotation.TargetApi;
import android.graphics.Rect;
import android.support.annotation.RequiresApi;
import android.transition.Transition;
import android.transition.Transition.EpicenterCallback;
import android.transition.Transition.TransitionListener;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

@TargetApi(21)
@RequiresApi(21)
class FragmentTransitionCompat21 {

    /* renamed from: android.support.v4.app.FragmentTransitionCompat21.1 */
    static class C00981 extends EpicenterCallback {
        final /* synthetic */ Rect val$epicenter;

        C00981(Rect rect) {
            this.val$epicenter = rect;
        }

        public Rect onGetEpicenter(Transition transition) {
            return this.val$epicenter;
        }
    }

    /* renamed from: android.support.v4.app.FragmentTransitionCompat21.2 */
    static class C00992 implements TransitionListener {
        final /* synthetic */ ArrayList val$exitingViews;
        final /* synthetic */ View val$fragmentView;

        C00992(View view, ArrayList arrayList) {
            this.val$fragmentView = view;
            this.val$exitingViews = arrayList;
        }

        public void onTransitionStart(Transition transition) {
        }

        public void onTransitionEnd(Transition transition) {
            transition.removeListener(this);
            this.val$fragmentView.setVisibility(8);
            int size = this.val$exitingViews.size();
            for (int i = 0; i < size; i++) {
                ((View) this.val$exitingViews.get(i)).setVisibility(0);
            }
        }

        public void onTransitionCancel(Transition transition) {
        }

        public void onTransitionPause(Transition transition) {
        }

        public void onTransitionResume(Transition transition) {
        }
    }

    /* renamed from: android.support.v4.app.FragmentTransitionCompat21.3 */
    static class C01003 implements Runnable {
        final /* synthetic */ ArrayList val$inNames;
        final /* synthetic */ int val$numSharedElements;
        final /* synthetic */ ArrayList val$outNames;
        final /* synthetic */ ArrayList val$sharedElementsIn;
        final /* synthetic */ ArrayList val$sharedElementsOut;

        C01003(int i, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, ArrayList arrayList4) {
            this.val$numSharedElements = i;
            this.val$sharedElementsIn = arrayList;
            this.val$inNames = arrayList2;
            this.val$sharedElementsOut = arrayList3;
            this.val$outNames = arrayList4;
        }

        public void run() {
            for (int i = 0; i < this.val$numSharedElements; i++) {
                ((View) this.val$sharedElementsIn.get(i)).setTransitionName((String) this.val$inNames.get(i));
                ((View) this.val$sharedElementsOut.get(i)).setTransitionName((String) this.val$outNames.get(i));
            }
        }
    }

    /* renamed from: android.support.v4.app.FragmentTransitionCompat21.4 */
    static class C01014 implements Runnable {
        final /* synthetic */ Map val$nameOverrides;
        final /* synthetic */ ArrayList val$sharedElementsIn;

        C01014(ArrayList arrayList, Map map) {
            this.val$sharedElementsIn = arrayList;
            this.val$nameOverrides = map;
        }

        public void run() {
            int size = this.val$sharedElementsIn.size();
            for (int i = 0; i < size; i++) {
                View view = (View) this.val$sharedElementsIn.get(i);
                String transitionName = view.getTransitionName();
                if (transitionName != null) {
                    view.setTransitionName(FragmentTransitionCompat21.findKeyForValue(this.val$nameOverrides, transitionName));
                }
            }
        }
    }

    /* renamed from: android.support.v4.app.FragmentTransitionCompat21.5 */
    static class C01025 implements TransitionListener {
        final /* synthetic */ Object val$enterTransition;
        final /* synthetic */ ArrayList val$enteringViews;
        final /* synthetic */ Object val$exitTransition;
        final /* synthetic */ ArrayList val$exitingViews;
        final /* synthetic */ Object val$sharedElementTransition;
        final /* synthetic */ ArrayList val$sharedElementsIn;

        C01025(Object obj, ArrayList arrayList, Object obj2, ArrayList arrayList2, Object obj3, ArrayList arrayList3) {
            this.val$enterTransition = obj;
            this.val$enteringViews = arrayList;
            this.val$exitTransition = obj2;
            this.val$exitingViews = arrayList2;
            this.val$sharedElementTransition = obj3;
            this.val$sharedElementsIn = arrayList3;
        }

        public void onTransitionStart(Transition transition) {
            if (this.val$enterTransition != null) {
                FragmentTransitionCompat21.replaceTargets(this.val$enterTransition, this.val$enteringViews, null);
            }
            if (this.val$exitTransition != null) {
                FragmentTransitionCompat21.replaceTargets(this.val$exitTransition, this.val$exitingViews, null);
            }
            if (this.val$sharedElementTransition != null) {
                FragmentTransitionCompat21.replaceTargets(this.val$sharedElementTransition, this.val$sharedElementsIn, null);
            }
        }

        public void onTransitionEnd(Transition transition) {
        }

        public void onTransitionCancel(Transition transition) {
        }

        public void onTransitionPause(Transition transition) {
        }

        public void onTransitionResume(Transition transition) {
        }
    }

    /* renamed from: android.support.v4.app.FragmentTransitionCompat21.6 */
    static class C01036 extends EpicenterCallback {
        final /* synthetic */ Rect val$epicenter;

        C01036(Rect rect) {
            this.val$epicenter = rect;
        }

        public Rect onGetEpicenter(Transition transition) {
            if (this.val$epicenter == null || this.val$epicenter.isEmpty()) {
                return null;
            }
            return this.val$epicenter;
        }
    }

    /* renamed from: android.support.v4.app.FragmentTransitionCompat21.7 */
    static class C01047 implements Runnable {
        final /* synthetic */ Map val$nameOverrides;
        final /* synthetic */ ArrayList val$sharedElementsIn;

        C01047(ArrayList arrayList, Map map) {
            this.val$sharedElementsIn = arrayList;
            this.val$nameOverrides = map;
        }

        public void run() {
            int size = this.val$sharedElementsIn.size();
            for (int i = 0; i < size; i++) {
                View view = (View) this.val$sharedElementsIn.get(i);
                view.setTransitionName((String) this.val$nameOverrides.get(view.getTransitionName()));
            }
        }
    }

    FragmentTransitionCompat21() {
    }

    public static Object cloneTransition(Object obj) {
        if (obj != null) {
            return ((Transition) obj).clone();
        }
        return null;
    }

    public static Object wrapTransitionInSet(Object obj) {
        if (obj == null) {
            return null;
        }
        Object transitionSet = new TransitionSet();
        transitionSet.addTransition((Transition) obj);
        return transitionSet;
    }

    public static void setSharedElementTargets(Object obj, View view, ArrayList<View> arrayList) {
        TransitionSet transitionSet = (TransitionSet) obj;
        List targets = transitionSet.getTargets();
        targets.clear();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            bfsAddViewChildren(targets, (View) arrayList.get(i));
        }
        targets.add(view);
        arrayList.add(view);
        addTargets(transitionSet, arrayList);
    }

    private static void bfsAddViewChildren(List<View> list, View view) {
        int size = list.size();
        if (!containedBeforeIndex(list, view, size)) {
            list.add(view);
            for (int i = size; i < list.size(); i++) {
                View view2 = (View) list.get(i);
                if (view2 instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view2;
                    int childCount = viewGroup.getChildCount();
                    for (int i2 = 0; i2 < childCount; i2++) {
                        View childAt = viewGroup.getChildAt(i2);
                        if (!containedBeforeIndex(list, childAt, size)) {
                            list.add(childAt);
                        }
                    }
                }
            }
        }
    }

    private static boolean containedBeforeIndex(List<View> list, View view, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (list.get(i2) == view) {
                return true;
            }
        }
        return false;
    }

    public static void setEpicenter(Object obj, View view) {
        if (view != null) {
            Transition transition = (Transition) obj;
            Rect rect = new Rect();
            getBoundsOnScreen(view, rect);
            transition.setEpicenterCallback(new C00981(rect));
        }
    }

    public static void getBoundsOnScreen(View view, Rect rect) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        rect.set(iArr[0], iArr[1], iArr[0] + view.getWidth(), iArr[1] + view.getHeight());
    }

    public static void addTargets(Object obj, ArrayList<View> arrayList) {
        int i = 0;
        Transition transition = (Transition) obj;
        if (transition != null) {
            int transitionCount;
            if (transition instanceof TransitionSet) {
                TransitionSet transitionSet = (TransitionSet) transition;
                transitionCount = transitionSet.getTransitionCount();
                while (i < transitionCount) {
                    addTargets(transitionSet.getTransitionAt(i), arrayList);
                    i++;
                }
            } else if (!hasSimpleTarget(transition) && isNullOrEmpty(transition.getTargets())) {
                int size = arrayList.size();
                for (transitionCount = 0; transitionCount < size; transitionCount++) {
                    transition.addTarget((View) arrayList.get(transitionCount));
                }
            }
        }
    }

    private static boolean hasSimpleTarget(Transition transition) {
        return (isNullOrEmpty(transition.getTargetIds()) && isNullOrEmpty(transition.getTargetNames()) && isNullOrEmpty(transition.getTargetTypes())) ? false : true;
    }

    private static boolean isNullOrEmpty(List list) {
        return list == null || list.isEmpty();
    }

    public static Object mergeTransitionsTogether(Object obj, Object obj2, Object obj3) {
        TransitionSet transitionSet = new TransitionSet();
        if (obj != null) {
            transitionSet.addTransition((Transition) obj);
        }
        if (obj2 != null) {
            transitionSet.addTransition((Transition) obj2);
        }
        if (obj3 != null) {
            transitionSet.addTransition((Transition) obj3);
        }
        return transitionSet;
    }

    public static void scheduleHideFragmentView(Object obj, View view, ArrayList<View> arrayList) {
        ((Transition) obj).addListener(new C00992(view, arrayList));
    }

    public static Object mergeTransitionsInSequence(Object obj, Object obj2, Object obj3) {
        Transition transition = null;
        Transition transition2 = (Transition) obj;
        Transition transition3 = (Transition) obj2;
        Transition transition4 = (Transition) obj3;
        if (transition2 != null && transition3 != null) {
            transition = new TransitionSet().addTransition(transition2).addTransition(transition3).setOrdering(1);
        } else if (transition2 != null) {
            transition = transition2;
        } else if (transition3 != null) {
            transition = transition3;
        }
        if (transition4 == null) {
            return transition;
        }
        TransitionSet transitionSet = new TransitionSet();
        if (transition != null) {
            transitionSet.addTransition(transition);
        }
        transitionSet.addTransition(transition4);
        return transitionSet;
    }

    public static void beginDelayedTransition(ViewGroup viewGroup, Object obj) {
        TransitionManager.beginDelayedTransition(viewGroup, (Transition) obj);
    }

    public static ArrayList<String> prepareSetNameOverridesOptimized(ArrayList<View> arrayList) {
        ArrayList<String> arrayList2 = new ArrayList();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            View view = (View) arrayList.get(i);
            arrayList2.add(view.getTransitionName());
            view.setTransitionName(null);
        }
        return arrayList2;
    }

    public static void setNameOverridesOptimized(View view, ArrayList<View> arrayList, ArrayList<View> arrayList2, ArrayList<String> arrayList3, Map<String, String> map) {
        int size = arrayList2.size();
        ArrayList arrayList4 = new ArrayList();
        for (int i = 0; i < size; i++) {
            View view2 = (View) arrayList.get(i);
            String transitionName = view2.getTransitionName();
            arrayList4.add(transitionName);
            if (transitionName != null) {
                view2.setTransitionName(null);
                String str = (String) map.get(transitionName);
                for (int i2 = 0; i2 < size; i2++) {
                    if (str.equals(arrayList3.get(i2))) {
                        ((View) arrayList2.get(i2)).setTransitionName(transitionName);
                        break;
                    }
                }
            }
        }
        OneShotPreDrawListener.add(view, new C01003(size, arrayList2, arrayList3, arrayList, arrayList4));
    }

    public static void captureTransitioningViews(ArrayList<View> arrayList, View view) {
        if (view.getVisibility() != 0) {
            return;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (viewGroup.isTransitionGroup()) {
                arrayList.add(viewGroup);
                return;
            }
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                captureTransitioningViews(arrayList, viewGroup.getChildAt(i));
            }
            return;
        }
        arrayList.add(view);
    }

    public static void findNamedViews(Map<String, View> map, View view) {
        if (view.getVisibility() == 0) {
            String transitionName = view.getTransitionName();
            if (transitionName != null) {
                map.put(transitionName, view);
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    findNamedViews(map, viewGroup.getChildAt(i));
                }
            }
        }
    }

    public static void setNameOverridesUnoptimized(View view, ArrayList<View> arrayList, Map<String, String> map) {
        OneShotPreDrawListener.add(view, new C01014(arrayList, map));
    }

    private static String findKeyForValue(Map<String, String> map, String str) {
        for (Entry entry : map.entrySet()) {
            if (str.equals(entry.getValue())) {
                return (String) entry.getKey();
            }
        }
        return null;
    }

    public static void scheduleRemoveTargets(Object obj, Object obj2, ArrayList<View> arrayList, Object obj3, ArrayList<View> arrayList2, Object obj4, ArrayList<View> arrayList3) {
        ((Transition) obj).addListener(new C01025(obj2, arrayList, obj3, arrayList2, obj4, arrayList3));
    }

    public static void swapSharedElementTargets(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        TransitionSet transitionSet = (TransitionSet) obj;
        if (transitionSet != null) {
            transitionSet.getTargets().clear();
            transitionSet.getTargets().addAll(arrayList2);
            replaceTargets(transitionSet, arrayList, arrayList2);
        }
    }

    public static void replaceTargets(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        int i = 0;
        Transition transition = (Transition) obj;
        int transitionCount;
        if (transition instanceof TransitionSet) {
            TransitionSet transitionSet = (TransitionSet) transition;
            transitionCount = transitionSet.getTransitionCount();
            while (i < transitionCount) {
                replaceTargets(transitionSet.getTransitionAt(i), arrayList, arrayList2);
                i++;
            }
        } else if (!hasSimpleTarget(transition)) {
            List targets = transition.getTargets();
            if (targets != null && targets.size() == arrayList.size() && targets.containsAll(arrayList)) {
                transitionCount = arrayList2 == null ? 0 : arrayList2.size();
                for (int i2 = 0; i2 < transitionCount; i2++) {
                    transition.addTarget((View) arrayList2.get(i2));
                }
                for (transitionCount = arrayList.size() - 1; transitionCount >= 0; transitionCount--) {
                    transition.removeTarget((View) arrayList.get(transitionCount));
                }
            }
        }
    }

    public static void addTarget(Object obj, View view) {
        if (obj != null) {
            ((Transition) obj).addTarget(view);
        }
    }

    public static void removeTarget(Object obj, View view) {
        if (obj != null) {
            ((Transition) obj).removeTarget(view);
        }
    }

    public static void setEpicenter(Object obj, Rect rect) {
        if (obj != null) {
            ((Transition) obj).setEpicenterCallback(new C01036(rect));
        }
    }

    public static void scheduleNameReset(ViewGroup viewGroup, ArrayList<View> arrayList, Map<String, String> map) {
        OneShotPreDrawListener.add(viewGroup, new C01047(arrayList, map));
    }
}
