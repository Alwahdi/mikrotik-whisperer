package androidx.core.animation;

import android.animation.Animator;

public final class AnimatorKt$doOnStart$$inlined$addListener$default$1 implements Animator.AnimatorListener {
    final /* synthetic */ vn $onStart;

    public AnimatorKt$doOnStart$$inlined$addListener$default$1(vn $onStart2) {
        this.$onStart = $onStart2;
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
        Animator animator2 = animator;
    }

    public void onAnimationStart(Animator animator) {
        lu.f(animator, "animator");
        this.$onStart.invoke(animator);
    }
}
