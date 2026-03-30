package androidx.core.transition;

import android.transition.Transition;

public final class TransitionKt$doOnStart$$inlined$addListener$default$1 implements Transition.TransitionListener {
    final /* synthetic */ vn $onStart;

    public TransitionKt$doOnStart$$inlined$addListener$default$1(vn $onStart2) {
        this.$onStart = $onStart2;
    }

    public void onTransitionEnd(Transition transition) {
        lu.f(transition, "transition");
        Transition transition2 = transition;
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
        this.$onStart.invoke(transition);
    }
}
