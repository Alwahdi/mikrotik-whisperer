package androidx.core.animation;

import android.animation.Animator;

public final class AnimatorKt$addPauseListener$listener$1 implements Animator.AnimatorPauseListener {
    final /* synthetic */ vn<Animator, jt0> $onPause;
    final /* synthetic */ vn<Animator, jt0> $onResume;

    AnimatorKt$addPauseListener$listener$1(vn<? super Animator, jt0> $onPause2, vn<? super Animator, jt0> $onResume2) {
        this.$onPause = $onPause2;
        this.$onResume = $onResume2;
    }

    public void onAnimationPause(Animator animator) {
        lu.f(animator, "animator");
        this.$onPause.invoke(animator);
    }

    public void onAnimationResume(Animator animator) {
        lu.f(animator, "animator");
        this.$onResume.invoke(animator);
    }
}
