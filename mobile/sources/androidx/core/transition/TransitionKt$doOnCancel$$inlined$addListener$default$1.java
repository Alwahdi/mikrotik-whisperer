package androidx.core.transition;

import android.transition.Transition;

public final class TransitionKt$doOnCancel$$inlined$addListener$default$1 implements Transition.TransitionListener {
    final /* synthetic */ vn $onCancel;

    public TransitionKt$doOnCancel$$inlined$addListener$default$1(vn $onCancel2) {
        this.$onCancel = $onCancel2;
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
        this.$onCancel.invoke(transition);
    }

    public void onTransitionStart(Transition transition) {
        lu.f(transition, "transition");
        Transition transition2 = transition;
    }
}
