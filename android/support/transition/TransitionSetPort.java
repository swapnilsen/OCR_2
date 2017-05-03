package android.support.transition;

import android.animation.TimeInterpolator;
import android.annotation.TargetApi;
import android.support.annotation.RequiresApi;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.transition.TransitionPort.TransitionListener;
import android.support.transition.TransitionPort.TransitionListenerAdapter;
import android.util.AndroidRuntimeException;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Iterator;
import net.nend.android.NendAdIconLayout;

@TargetApi(14)
@RequiresApi(14)
class TransitionSetPort extends TransitionPort {
    public static final int ORDERING_SEQUENTIAL = 1;
    public static final int ORDERING_TOGETHER = 0;
    int mCurrentListeners;
    private boolean mPlayTogether;
    boolean mStarted;
    ArrayList<TransitionPort> mTransitions;

    /* renamed from: android.support.transition.TransitionSetPort.1 */
    class C00821 extends TransitionListenerAdapter {
        final /* synthetic */ TransitionPort val$nextTransition;

        C00821(TransitionPort transitionPort) {
            this.val$nextTransition = transitionPort;
        }

        public void onTransitionEnd(TransitionPort transitionPort) {
            this.val$nextTransition.runAnimators();
            transitionPort.removeListener(this);
        }
    }

    static class TransitionSetListener extends TransitionListenerAdapter {
        TransitionSetPort mTransitionSet;

        TransitionSetListener(TransitionSetPort transitionSetPort) {
            this.mTransitionSet = transitionSetPort;
        }

        public void onTransitionStart(TransitionPort transitionPort) {
            if (!this.mTransitionSet.mStarted) {
                this.mTransitionSet.start();
                this.mTransitionSet.mStarted = true;
            }
        }

        public void onTransitionEnd(TransitionPort transitionPort) {
            TransitionSetPort transitionSetPort = this.mTransitionSet;
            transitionSetPort.mCurrentListeners--;
            if (this.mTransitionSet.mCurrentListeners == 0) {
                this.mTransitionSet.mStarted = false;
                this.mTransitionSet.end();
            }
            transitionPort.removeListener(this);
        }
    }

    public TransitionSetPort() {
        this.mTransitions = new ArrayList();
        this.mStarted = false;
        this.mPlayTogether = true;
    }

    public int getOrdering() {
        return this.mPlayTogether ? 0 : ORDERING_SEQUENTIAL;
    }

    public TransitionSetPort setOrdering(int i) {
        switch (i) {
            case NendAdIconLayout.HORIZONTAL /*0*/:
                this.mPlayTogether = true;
                break;
            case ORDERING_SEQUENTIAL /*1*/:
                this.mPlayTogether = false;
                break;
            default:
                throw new AndroidRuntimeException("Invalid parameter for TransitionSet ordering: " + i);
        }
        return this;
    }

    public TransitionSetPort addTransition(TransitionPort transitionPort) {
        if (transitionPort != null) {
            this.mTransitions.add(transitionPort);
            transitionPort.mParent = this;
            if (this.mDuration >= 0) {
                transitionPort.setDuration(this.mDuration);
            }
        }
        return this;
    }

    public TransitionSetPort setDuration(long j) {
        super.setDuration(j);
        if (this.mDuration >= 0) {
            int size = this.mTransitions.size();
            for (int i = 0; i < size; i += ORDERING_SEQUENTIAL) {
                ((TransitionPort) this.mTransitions.get(i)).setDuration(j);
            }
        }
        return this;
    }

    public TransitionSetPort setStartDelay(long j) {
        return (TransitionSetPort) super.setStartDelay(j);
    }

    public TransitionSetPort setInterpolator(TimeInterpolator timeInterpolator) {
        return (TransitionSetPort) super.setInterpolator(timeInterpolator);
    }

    public TransitionSetPort addTarget(View view) {
        return (TransitionSetPort) super.addTarget(view);
    }

    public TransitionSetPort addTarget(int i) {
        return (TransitionSetPort) super.addTarget(i);
    }

    public TransitionSetPort addListener(TransitionListener transitionListener) {
        return (TransitionSetPort) super.addListener(transitionListener);
    }

    public TransitionSetPort removeTarget(int i) {
        return (TransitionSetPort) super.removeTarget(i);
    }

    public TransitionSetPort removeTarget(View view) {
        return (TransitionSetPort) super.removeTarget(view);
    }

    public TransitionSetPort removeListener(TransitionListener transitionListener) {
        return (TransitionSetPort) super.removeListener(transitionListener);
    }

    public TransitionSetPort removeTransition(TransitionPort transitionPort) {
        this.mTransitions.remove(transitionPort);
        transitionPort.mParent = null;
        return this;
    }

    private void setupStartEndListeners() {
        TransitionListener transitionSetListener = new TransitionSetListener(this);
        Iterator it = this.mTransitions.iterator();
        while (it.hasNext()) {
            ((TransitionPort) it.next()).addListener(transitionSetListener);
        }
        this.mCurrentListeners = this.mTransitions.size();
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    protected void createAnimators(ViewGroup viewGroup, TransitionValuesMaps transitionValuesMaps, TransitionValuesMaps transitionValuesMaps2) {
        Iterator it = this.mTransitions.iterator();
        while (it.hasNext()) {
            ((TransitionPort) it.next()).createAnimators(viewGroup, transitionValuesMaps, transitionValuesMaps2);
        }
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    protected void runAnimators() {
        if (this.mTransitions.isEmpty()) {
            start();
            end();
            return;
        }
        setupStartEndListeners();
        if (this.mPlayTogether) {
            Iterator it = this.mTransitions.iterator();
            while (it.hasNext()) {
                ((TransitionPort) it.next()).runAnimators();
            }
            return;
        }
        for (int i = ORDERING_SEQUENTIAL; i < this.mTransitions.size(); i += ORDERING_SEQUENTIAL) {
            ((TransitionPort) this.mTransitions.get(i - 1)).addListener(new C00821((TransitionPort) this.mTransitions.get(i)));
        }
        TransitionPort transitionPort = (TransitionPort) this.mTransitions.get(0);
        if (transitionPort != null) {
            transitionPort.runAnimators();
        }
    }

    public void captureStartValues(TransitionValues transitionValues) {
        int id = transitionValues.view.getId();
        if (isValidTarget(transitionValues.view, (long) id)) {
            Iterator it = this.mTransitions.iterator();
            while (it.hasNext()) {
                TransitionPort transitionPort = (TransitionPort) it.next();
                if (transitionPort.isValidTarget(transitionValues.view, (long) id)) {
                    transitionPort.captureStartValues(transitionValues);
                }
            }
        }
    }

    public void captureEndValues(TransitionValues transitionValues) {
        int id = transitionValues.view.getId();
        if (isValidTarget(transitionValues.view, (long) id)) {
            Iterator it = this.mTransitions.iterator();
            while (it.hasNext()) {
                TransitionPort transitionPort = (TransitionPort) it.next();
                if (transitionPort.isValidTarget(transitionValues.view, (long) id)) {
                    transitionPort.captureEndValues(transitionValues);
                }
            }
        }
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public void pause(View view) {
        super.pause(view);
        int size = this.mTransitions.size();
        for (int i = 0; i < size; i += ORDERING_SEQUENTIAL) {
            ((TransitionPort) this.mTransitions.get(i)).pause(view);
        }
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public void resume(View view) {
        super.resume(view);
        int size = this.mTransitions.size();
        for (int i = 0; i < size; i += ORDERING_SEQUENTIAL) {
            ((TransitionPort) this.mTransitions.get(i)).resume(view);
        }
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    protected void cancel() {
        super.cancel();
        int size = this.mTransitions.size();
        for (int i = 0; i < size; i += ORDERING_SEQUENTIAL) {
            ((TransitionPort) this.mTransitions.get(i)).cancel();
        }
    }

    TransitionSetPort setSceneRoot(ViewGroup viewGroup) {
        super.setSceneRoot(viewGroup);
        int size = this.mTransitions.size();
        for (int i = 0; i < size; i += ORDERING_SEQUENTIAL) {
            ((TransitionPort) this.mTransitions.get(i)).setSceneRoot(viewGroup);
        }
        return this;
    }

    void setCanRemoveViews(boolean z) {
        super.setCanRemoveViews(z);
        int size = this.mTransitions.size();
        for (int i = 0; i < size; i += ORDERING_SEQUENTIAL) {
            ((TransitionPort) this.mTransitions.get(i)).setCanRemoveViews(z);
        }
    }

    String toString(String str) {
        String transitionPort = super.toString(str);
        int i = 0;
        while (i < this.mTransitions.size()) {
            String str2 = transitionPort + "\n" + ((TransitionPort) this.mTransitions.get(i)).toString(str + "  ");
            i += ORDERING_SEQUENTIAL;
            transitionPort = str2;
        }
        return transitionPort;
    }

    public TransitionSetPort clone() {
        TransitionSetPort transitionSetPort = (TransitionSetPort) super.clone();
        transitionSetPort.mTransitions = new ArrayList();
        int size = this.mTransitions.size();
        for (int i = 0; i < size; i += ORDERING_SEQUENTIAL) {
            transitionSetPort.addTransition(((TransitionPort) this.mTransitions.get(i)).clone());
        }
        return transitionSetPort;
    }
}
