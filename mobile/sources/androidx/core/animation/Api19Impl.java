package androidx.core.animation;

import android.animation.Animator;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;

@RequiresApi(19)
final class Api19Impl {
    public static final Api19Impl INSTANCE = new Api19Impl();

    private Api19Impl() {
    }

    @DoNotInline
    public static final void addPauseListener(Animator animator, Animator.AnimatorPauseListener listener) {
        lu.f(animator, "animator");
        lu.f(listener, "listener");
        animator.addPauseListener(listener);
    }
}
