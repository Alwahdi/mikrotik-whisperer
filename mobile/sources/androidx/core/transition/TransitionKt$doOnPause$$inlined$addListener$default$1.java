package androidx.core.transition;

import android.transition.Transition;

public final class TransitionKt$doOnPause$$inlined$addListener$default$1 implements Transition.TransitionListener {
    final /* synthetic */ vn $onPause;

    public TransitionKt$doOnPause$$inlined$addListener$default$1(vn $onPause2) {
        this.$onPause = $onPause2;
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
        this.$onPause.invoke(transition);
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
