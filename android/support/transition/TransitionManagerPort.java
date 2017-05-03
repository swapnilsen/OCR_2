package android.support.transition;

import android.annotation.TargetApi;
import android.support.annotation.RequiresApi;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.transition.TransitionPort.TransitionListenerAdapter;
import android.support.v4.util.ArrayMap;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnPreDrawListener;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

@TargetApi(14)
@RequiresApi(14)
class TransitionManagerPort {
    private static final String[] EMPTY_STRINGS;
    private static String LOG_TAG;
    private static TransitionPort sDefaultTransition;
    static ArrayList<ViewGroup> sPendingTransitions;
    private static ThreadLocal<WeakReference<ArrayMap<ViewGroup, ArrayList<TransitionPort>>>> sRunningTransitions;
    ArrayMap<String, ArrayMap<ScenePort, TransitionPort>> mNameSceneTransitions;
    ArrayMap<ScenePort, ArrayMap<String, TransitionPort>> mSceneNameTransitions;
    ArrayMap<ScenePort, ArrayMap<ScenePort, TransitionPort>> mScenePairTransitions;
    ArrayMap<ScenePort, TransitionPort> mSceneTransitions;

    private static class MultiListener implements OnAttachStateChangeListener, OnPreDrawListener {
        ViewGroup mSceneRoot;
        TransitionPort mTransition;

        /* renamed from: android.support.transition.TransitionManagerPort.MultiListener.1 */
        class C00791 extends TransitionListenerAdapter {
            final /* synthetic */ ArrayMap val$runningTransitions;

            C00791(ArrayMap arrayMap) {
                this.val$runningTransitions = arrayMap;
            }

            public void onTransitionEnd(TransitionPort transitionPort) {
                ((ArrayList) this.val$runningTransitions.get(MultiListener.this.mSceneRoot)).remove(transitionPort);
            }
        }

        MultiListener(TransitionPort transitionPort, ViewGroup viewGroup) {
            this.mTransition = transitionPort;
            this.mSceneRoot = viewGroup;
        }

        private void removeListeners() {
            this.mSceneRoot.getViewTreeObserver().removeOnPreDrawListener(this);
            this.mSceneRoot.removeOnAttachStateChangeListener(this);
        }

        public void onViewAttachedToWindow(View view) {
        }

        public void onViewDetachedFromWindow(View view) {
            removeListeners();
            TransitionManagerPort.sPendingTransitions.remove(this.mSceneRoot);
            ArrayList arrayList = (ArrayList) TransitionManagerPort.getRunningTransitions().get(this.mSceneRoot);
            if (arrayList != null && arrayList.size() > 0) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((TransitionPort) it.next()).resume(this.mSceneRoot);
                }
            }
            this.mTransition.clearValues(true);
        }

        public boolean onPreDraw() {
            ArrayList arrayList;
            removeListeners();
            TransitionManagerPort.sPendingTransitions.remove(this.mSceneRoot);
            ArrayMap runningTransitions = TransitionManagerPort.getRunningTransitions();
            ArrayList arrayList2 = (ArrayList) runningTransitions.get(this.mSceneRoot);
            if (arrayList2 == null) {
                arrayList2 = new ArrayList();
                runningTransitions.put(this.mSceneRoot, arrayList2);
                arrayList = arrayList2;
                arrayList2 = null;
            } else if (arrayList2.size() > 0) {
                ArrayList arrayList3 = new ArrayList(arrayList2);
                arrayList = arrayList2;
                arrayList2 = arrayList3;
            } else {
                arrayList = arrayList2;
                arrayList2 = null;
            }
            arrayList.add(this.mTransition);
            this.mTransition.addListener(new C00791(runningTransitions));
            this.mTransition.captureValues(this.mSceneRoot, false);
            if (arrayList2 != null) {
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    ((TransitionPort) it.next()).resume(this.mSceneRoot);
                }
            }
            this.mTransition.playTransition(this.mSceneRoot);
            return true;
        }
    }

    TransitionManagerPort() {
        this.mSceneTransitions = new ArrayMap();
        this.mScenePairTransitions = new ArrayMap();
        this.mSceneNameTransitions = new ArrayMap();
        this.mNameSceneTransitions = new ArrayMap();
    }

    static {
        EMPTY_STRINGS = new String[0];
        LOG_TAG = "TransitionManager";
        sDefaultTransition = new AutoTransitionPort();
        sRunningTransitions = new ThreadLocal();
        sPendingTransitions = new ArrayList();
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public static TransitionPort getDefaultTransition() {
        return sDefaultTransition;
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public void setDefaultTransition(TransitionPort transitionPort) {
        sDefaultTransition = transitionPort;
    }

    private static void changeScene(ScenePort scenePort, TransitionPort transitionPort) {
        View sceneRoot = scenePort.getSceneRoot();
        TransitionPort transitionPort2 = null;
        if (transitionPort != null) {
            transitionPort2 = transitionPort.clone();
            transitionPort2.setSceneRoot(sceneRoot);
        }
        ScenePort currentScene = ScenePort.getCurrentScene(sceneRoot);
        if (currentScene != null && currentScene.isCreatedFromLayoutResource()) {
            transitionPort2.setCanRemoveViews(true);
        }
        sceneChangeSetup(sceneRoot, transitionPort2);
        scenePort.enter();
        sceneChangeRunTransition(sceneRoot, transitionPort2);
    }

    static ArrayMap<ViewGroup, ArrayList<TransitionPort>> getRunningTransitions() {
        WeakReference weakReference = (WeakReference) sRunningTransitions.get();
        if (weakReference == null || weakReference.get() == null) {
            weakReference = new WeakReference(new ArrayMap());
            sRunningTransitions.set(weakReference);
        }
        return (ArrayMap) weakReference.get();
    }

    private static void sceneChangeRunTransition(ViewGroup viewGroup, TransitionPort transitionPort) {
        if (transitionPort != null && viewGroup != null) {
            Object multiListener = new MultiListener(transitionPort, viewGroup);
            viewGroup.addOnAttachStateChangeListener(multiListener);
            viewGroup.getViewTreeObserver().addOnPreDrawListener(multiListener);
        }
    }

    private static void sceneChangeSetup(ViewGroup viewGroup, TransitionPort transitionPort) {
        ArrayList arrayList = (ArrayList) getRunningTransitions().get(viewGroup);
        if (arrayList != null && arrayList.size() > 0) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((TransitionPort) it.next()).pause(viewGroup);
            }
        }
        if (transitionPort != null) {
            transitionPort.captureValues(viewGroup, true);
        }
        ScenePort currentScene = ScenePort.getCurrentScene(viewGroup);
        if (currentScene != null) {
            currentScene.exit();
        }
    }

    public static void go(ScenePort scenePort) {
        changeScene(scenePort, sDefaultTransition);
    }

    public static void go(ScenePort scenePort, TransitionPort transitionPort) {
        changeScene(scenePort, transitionPort);
    }

    public static void beginDelayedTransition(ViewGroup viewGroup) {
        beginDelayedTransition(viewGroup, null);
    }

    public static void beginDelayedTransition(ViewGroup viewGroup, TransitionPort transitionPort) {
        if (!sPendingTransitions.contains(viewGroup) && ViewCompat.isLaidOut(viewGroup)) {
            sPendingTransitions.add(viewGroup);
            if (transitionPort == null) {
                transitionPort = sDefaultTransition;
            }
            TransitionPort clone = transitionPort.clone();
            sceneChangeSetup(viewGroup, clone);
            ScenePort.setCurrentScene(viewGroup, null);
            sceneChangeRunTransition(viewGroup, clone);
        }
    }

    public void setTransition(ScenePort scenePort, TransitionPort transitionPort) {
        this.mSceneTransitions.put(scenePort, transitionPort);
    }

    public void setTransition(ScenePort scenePort, ScenePort scenePort2, TransitionPort transitionPort) {
        ArrayMap arrayMap = (ArrayMap) this.mScenePairTransitions.get(scenePort2);
        if (arrayMap == null) {
            arrayMap = new ArrayMap();
            this.mScenePairTransitions.put(scenePort2, arrayMap);
        }
        arrayMap.put(scenePort, transitionPort);
    }

    private TransitionPort getTransition(ScenePort scenePort) {
        TransitionPort transitionPort;
        View sceneRoot = scenePort.getSceneRoot();
        if (sceneRoot != null) {
            ScenePort currentScene = ScenePort.getCurrentScene(sceneRoot);
            if (currentScene != null) {
                ArrayMap arrayMap = (ArrayMap) this.mScenePairTransitions.get(scenePort);
                if (arrayMap != null) {
                    transitionPort = (TransitionPort) arrayMap.get(currentScene);
                    if (transitionPort != null) {
                        return transitionPort;
                    }
                }
            }
        }
        transitionPort = (TransitionPort) this.mSceneTransitions.get(scenePort);
        return transitionPort == null ? sDefaultTransition : transitionPort;
    }

    public TransitionPort getNamedTransition(String str, ScenePort scenePort) {
        ArrayMap arrayMap = (ArrayMap) this.mNameSceneTransitions.get(str);
        if (arrayMap != null) {
            return (TransitionPort) arrayMap.get(scenePort);
        }
        return null;
    }

    public TransitionPort getNamedTransition(ScenePort scenePort, String str) {
        ArrayMap arrayMap = (ArrayMap) this.mSceneNameTransitions.get(scenePort);
        if (arrayMap != null) {
            return (TransitionPort) arrayMap.get(str);
        }
        return null;
    }

    public String[] getTargetSceneNames(ScenePort scenePort) {
        ArrayMap arrayMap = (ArrayMap) this.mSceneNameTransitions.get(scenePort);
        if (arrayMap == null) {
            return EMPTY_STRINGS;
        }
        int size = arrayMap.size();
        String[] strArr = new String[size];
        for (int i = 0; i < size; i++) {
            strArr[i] = (String) arrayMap.keyAt(i);
        }
        return strArr;
    }

    public void setTransition(ScenePort scenePort, String str, TransitionPort transitionPort) {
        ArrayMap arrayMap = (ArrayMap) this.mSceneNameTransitions.get(scenePort);
        if (arrayMap == null) {
            arrayMap = new ArrayMap();
            this.mSceneNameTransitions.put(scenePort, arrayMap);
        }
        arrayMap.put(str, transitionPort);
    }

    public void setTransition(String str, ScenePort scenePort, TransitionPort transitionPort) {
        ArrayMap arrayMap = (ArrayMap) this.mNameSceneTransitions.get(str);
        if (arrayMap == null) {
            arrayMap = new ArrayMap();
            this.mNameSceneTransitions.put(str, arrayMap);
        }
        arrayMap.put(scenePort, transitionPort);
    }

    public void transitionTo(ScenePort scenePort) {
        changeScene(scenePort, getTransition(scenePort));
    }
}
