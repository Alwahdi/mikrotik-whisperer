package androidx.core.animation;

import android.animation.Animator;

public final class AnimatorKt$doOnEnd$$inlined$addListener$default$1 implements Animator.AnimatorListener {
    final /* synthetic */ vn $onEnd;

    public AnimatorKt$doOnEnd$$inlined$addListener$default$1(vn $onEnd2) {
        this.$onEnd = $onEnd2;
    }

    public void onAnimationRepeat(Animator animator) {
        lu.f(animator, "animator");
        Animator animator2 = animator;
    }

    public void onAnimationEnd(Animator animator) {
        lu.f(animator, "animator");
        this.$onEnd.invoke(animator);
    }

    public void onAnimationCancel(Animator animator) {
        lu.f(animator, "animator");
        Animator animator2 = animator;
    }

    public void onAnimationStart(Animator animator) {
        lu.f(animator, "animator");
        Animator animator2 = animator;
    }
}
