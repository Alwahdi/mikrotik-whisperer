package androidx.core.animation;

import android.animation.Animator;
import androidx.annotation.RequiresApi;

public final class AnimatorKt {
    public static final Animator.AnimatorListener doOnEnd(Animator $this$doOnEnd, vn<? super Animator, jt0> action) {
        lu.f($this$doOnEnd, "<this>");
        lu.f(action, "action");
        AnimatorKt$doOnEnd$$inlined$addListener$default$1 listener$iv = new AnimatorKt$doOnEnd$$inlined$addListener$default$1(action);
        $this$doOnEnd.addListener(listener$iv);
        return listener$iv;
    }

    public static final Animator.AnimatorListener doOnStart(Animator $this$doOnStart, vn<? super Animator, jt0> action) {
        lu.f($this$doOnStart, "<this>");
        lu.f(action, "action");
        AnimatorKt$doOnStart$$inlined$addListener$default$1 listener$iv = new AnimatorKt$doOnStart$$inlined$addListener$default$1(action);
        $this$doOnStart.addListener(listener$iv);
        return listener$iv;
    }

    public static final Animator.AnimatorListener doOnCancel(Animator $this$doOnCancel, vn<? super Animator, jt0> action) {
        lu.f($this$doOnCancel, "<this>");
        lu.f(action, "action");
        AnimatorKt$doOnCancel$$inlined$addListener$default$1 listener$iv = new AnimatorKt$doOnCancel$$inlined$addListener$default$1(action);
        $this$doOnCancel.addListener(listener$iv);
        return listener$iv;
    }

    public static final Animator.AnimatorListener doOnRepeat(Animator $this$doOnRepeat, vn<? super Animator, jt0> action) {
        lu.f($this$doOnRepeat, "<this>");
        lu.f(action, "action");
        AnimatorKt$doOnRepeat$$inlined$addListener$default$1 listener$iv = new AnimatorKt$doOnRepeat$$inlined$addListener$default$1(action);
        $this$doOnRepeat.addListener(listener$iv);
        return listener$iv;
    }

    @RequiresApi(19)
    public static final Animator.AnimatorPauseListener doOnResume(Animator $this$doOnResume, vn<? super Animator, jt0> action) {
        lu.f($this$doOnResume, "<this>");
        lu.f(action, "action");
        return addPauseListener$default($this$doOnResume, action, (vn) null, 2, (Object) null);
    }

    @RequiresApi(19)
    public static final Animator.AnimatorPauseListener doOnPause(Animator $this$doOnPause, vn<? super Animator, jt0> action) {
        lu.f($this$doOnPause, "<this>");
        lu.f(action, "action");
        return addPauseListener$default($this$doOnPause, (vn) null, action, 1, (Object) null);
    }

    public static /* synthetic */ Animator.AnimatorListener addListener$default(Animator $this$addListener_u24default, vn onEnd, vn onStart, vn onCancel, vn onRepeat, int i, Object obj) {
        if ((i & 1) != 0) {
            onEnd = AnimatorKt$addListener$1.INSTANCE;
        }
        if ((i & 2) != 0) {
            onStart = AnimatorKt$addListener$2.INSTANCE;
        }
        if ((i & 4) != 0) {
            onCancel = AnimatorKt$addListener$3.INSTANCE;
        }
        if ((i & 8) != 0) {
            onRepeat = AnimatorKt$addListener$4.INSTANCE;
        }
        lu.f($this$addListener_u24default, "<this>");
        lu.f(onEnd, "onEnd");
        lu.f(onStart, "onStart");
        lu.f(onCancel, "onCancel");
        lu.f(onRepeat, "onRepeat");
        AnimatorKt$addListener$listener$1 listener = new AnimatorKt$addListener$listener$1(onRepeat, onEnd, onCancel, onStart);
        $this$addListener_u24default.addListener(listener);
        return listener;
    }

    public static final Animator.AnimatorListener addListener(Animator $this$addListener, vn<? super Animator, jt0> onEnd, vn<? super Animator, jt0> onStart, vn<? super Animator, jt0> onCancel, vn<? super Animator, jt0> onRepeat) {
        lu.f($this$addListener, "<this>");
        lu.f(onEnd, "onEnd");
        lu.f(onStart, "onStart");
        lu.f(onCancel, "onCancel");
        lu.f(onRepeat, "onRepeat");
        AnimatorKt$addListener$listener$1 listener = new AnimatorKt$addListener$listener$1(onRepeat, onEnd, onCancel, onStart);
        $this$addListener.addListener(listener);
        return listener;
    }

    public static /* synthetic */ Animator.AnimatorPauseListener addPauseListener$default(Animator animator, vn vnVar, vn vnVar2, int i, Object obj) {
        if ((i & 1) != 0) {
            vnVar = AnimatorKt$addPauseListener$1.INSTANCE;
        }
        if ((i & 2) != 0) {
            vnVar2 = AnimatorKt$addPauseListener$2.INSTANCE;
        }
        return addPauseListener(animator, vnVar, vnVar2);
    }

    @RequiresApi(19)
    public static final Animator.AnimatorPauseListener addPauseListener(Animator $this$addPauseListener, vn<? super Animator, jt0> onResume, vn<? super Animator, jt0> onPause) {
        lu.f($this$addPauseListener, "<this>");
        lu.f(onResume, "onResume");
        lu.f(onPause, "onPause");
        AnimatorKt$addPauseListener$listener$1 listener = new AnimatorKt$addPauseListener$listener$1(onPause, onResume);
        Api19Impl.addPauseListener($this$addPauseListener, listener);
        return listener;
    }
}
