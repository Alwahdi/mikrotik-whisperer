package androidx.core.transition;

import android.transition.Transition;

public final class TransitionKt$doOnResume$$inlined$addListener$default$1 implements Transition.TransitionListener {
    final /* synthetic */ vn $onResume;

    public TransitionKt$doOnResume$$inlined$addListener$default$1(vn $onResume2) {
        this.$onResume = $onResume2;
    }

    public void onTransitionEnd(Transition transition) {
        lu.f(transition, "transition");
        Transition transition2 = transition;
    }

    public void onTransitionResume(Transition transition) {
        lu.f(transition, "transition");
        this.$onResume.invoke(transition);
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
