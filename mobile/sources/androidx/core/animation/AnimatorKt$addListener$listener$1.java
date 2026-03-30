package androidx.core.animation;

import android.animation.Animator;

public final class AnimatorKt$addListener$listener$1 implements Animator.AnimatorListener {
    final /* synthetic */ vn<Animator, jt0> $onCancel;
    final /* synthetic */ vn<Animator, jt0> $onEnd;
    final /* synthetic */ vn<Animator, jt0> $onRepeat;
    final /* synthetic */ vn<Animator, jt0> $onStart;

    public AnimatorKt$addListener$listener$1(vn<? super Animator, jt0> $onRepeat2, vn<? super Animator, jt0> $onEnd2, vn<? super Animator, jt0> $onCancel2, vn<? super Animator, jt0> $onStart2) {
        this.$onRepeat = $onRepeat2;
        this.$onEnd = $onEnd2;
        this.$onCancel = $onCancel2;
        this.$onStart = $onStart2;
    }

    public void onAnimationRepeat(Animator animator) {
        lu.f(animator, "animator");
        this.$onRepeat.invoke(animator);
    }

    public void onAnimationEnd(Animator animator) {
        lu.f(animator, "animator");
        this.$onEnd.invoke(animator);
    }

    public void onAnimationCancel(Animator animator) {
        lu.f(animator, "animator");
        this.$onCancel.invoke(animator);
    }

    public void onAnimationStart(Animator animator) {
        lu.f(animator, "animator");
        this.$onStart.invoke(animator);
    }
}
