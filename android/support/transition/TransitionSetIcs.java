package android.support.transition;

import android.annotation.TargetApi;
import android.support.annotation.RequiresApi;

@TargetApi(14)
@RequiresApi(14)
class TransitionSetIcs extends TransitionIcs implements TransitionSetImpl {
    private TransitionSetPort mTransitionSet;

    public TransitionSetIcs(TransitionInterface transitionInterface) {
        this.mTransitionSet = new TransitionSetPort();
        init(transitionInterface, this.mTransitionSet);
    }

    public int getOrdering() {
        return this.mTransitionSet.getOrdering();
    }

    public TransitionSetIcs setOrdering(int i) {
        this.mTransitionSet.setOrdering(i);
        return this;
    }

    public TransitionSetIcs addTransition(TransitionImpl transitionImpl) {
        this.mTransitionSet.addTransition(((TransitionIcs) transitionImpl).mTransition);
        return this;
    }

    public TransitionSetIcs removeTransition(TransitionImpl transitionImpl) {
        this.mTransitionSet.removeTransition(((TransitionIcs) transitionImpl).mTransition);
        return this;
    }
}
