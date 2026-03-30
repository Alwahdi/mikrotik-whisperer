package androidx.core.animation;

import android.animation.Animator;

public final class AnimatorKt$doOnCancel$$inlined$addListener$default$1 implements Animator.AnimatorListener {
    final /* synthetic */ vn $onCancel;

    public AnimatorKt$doOnCancel$$inlined$addListener$default$1(vn $onCancel2) {
        this.$onCancel = $onCancel2;
    }

    public void onAnimationRepeat(Animator animator) {
        lu.f(animator, "animator");
        Animator animator2 = animator;
    }

    public void onAnimationEnd(Animator animator) {
        lu.f(animator, "animator");
        Animator animator2 = animator;
    }

    public void onAnimationCancel(Animator animator) {
        lu.f(animator, "animator");
        this.$onCancel.invoke(animator);
    }

    public void onAnimationStart(Animator animator) {
        lu.f(animator, "animator");
        Animator animator2 = animator;
    }
}
