package androidx.core.transition;

import android.transition.Transition;

public final class TransitionKt$doOnEnd$$inlined$addListener$default$1 implements Transition.TransitionListener {
    final /* synthetic */ vn $onEnd;

    public TransitionKt$doOnEnd$$inlined$addListener$default$1(vn $onEnd2) {
        this.$onEnd = $onEnd2;
    }

    public void onTransitionEnd(Transition transition) {
        lu.f(transition, "transition");
        this.$onEnd.invoke(transition);
    }

    public void onTransitionResume(Transition transition) {
        lu.f(transition, "transition");
        Transition transition2 = transition;
    }

    public void onTransitionPause(Transition transition) {
        lu.f(transition, "transition");
        Transition transition2 = transition;
    }

    public void onTransitionCancel(Transition transition) {
        lu.f(transition, "transition");
        Transition transition2 = transition;
    }

    public void onTransitionStart(Transition transition) {
        lu.f(transition, "transition");
        Transition transition2 = transition;
    }
}
