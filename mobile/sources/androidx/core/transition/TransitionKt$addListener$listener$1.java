package androidx.core.transition;

import android.transition.Transition;

public final class TransitionKt$addListener$listener$1 implements Transition.TransitionListener {
    final /* synthetic */ vn<Transition, jt0> $onCancel;
    final /* synthetic */ vn<Transition, jt0> $onEnd;
    final /* synthetic */ vn<Transition, jt0> $onPause;
    final /* synthetic */ vn<Transition, jt0> $onResume;
    final /* synthetic */ vn<Transition, jt0> $onStart;

    public TransitionKt$addListener$listener$1(vn<? super Transition, jt0> $onEnd2, vn<? super Transition, jt0> $onResume2, vn<? super Transition, jt0> $onPause2, vn<? super Transition, jt0> $onCancel2, vn<? super Transition, jt0> $onStart2) {
        this.$onEnd = $onEnd2;
        this.$onResume = $onResume2;
        this.$onPause = $onPause2;
        this.$onCancel = $onCancel2;
        this.$onStart = $onStart2;
    }

    public void onTransitionEnd(Transition transition) {
        lu.f(transition, "transition");
        this.$onEnd.invoke(transition);
    }

    public void onTransitionResume(Transition transition) {
        lu.f(transition, "transition");
        this.$onResume.invoke(transition);
    }

    public void onTransitionPause(Transition transition) {
        lu.f(transition, "transition");
        this.$onPause.invoke(transition);
    }

    public void onTransitionCancel(Transition transition) {
        lu.f(transition, "transition");
        this.$onCancel.invoke(transition);
    }

    public void onTransitionStart(Transition transition) {
        lu.f(transition, "transition");
        this.$onStart.invoke(transition);
    }
}
