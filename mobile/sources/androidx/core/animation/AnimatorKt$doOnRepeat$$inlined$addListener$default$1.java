package androidx.core.animation;

import android.animation.Animator;

public final class AnimatorKt$doOnRepeat$$inlined$addListener$default$1 implements Animator.AnimatorListener {
    final /* synthetic */ vn $onRepeat;

    public AnimatorKt$doOnRepeat$$inlined$addListener$default$1(vn $onRepeat2) {
        this.$onRepeat = $onRepeat2;
    }

    public void onAnimationRepeat(Animator animator) {
        lu.f(animator, "animator");
        this.$onRepeat.invoke(animator);
    }

    public void onAnimationEnd(Animator animator) {
        lu.f(animator, "animator");
        Animator animator2 = animator;
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
