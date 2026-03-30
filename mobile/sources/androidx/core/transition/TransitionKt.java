package androidx.core.transition;

import android.transition.Transition;
import androidx.annotation.RequiresApi;

public final class TransitionKt {
    @RequiresApi(19)
    public static final Transition.TransitionListener doOnEnd(Transition $this$doOnEnd, vn<? super Transition, jt0> action) {
        lu.f($this$doOnEnd, "<this>");
        lu.f(action, "action");
        TransitionKt$doOnEnd$$inlined$addListener$default$1 listener$iv = new TransitionKt$doOnEnd$$inlined$addListener$default$1(action);
        $this$doOnEnd.addListener(listener$iv);
        return listener$iv;
    }

    @RequiresApi(19)
    public static final Transition.TransitionListener doOnStart(Transition $this$doOnStart, vn<? super Transition, jt0> action) {
        lu.f($this$doOnStart, "<this>");
        lu.f(action, "action");
        TransitionKt$doOnStart$$inlined$addListener$default$1 listener$iv = new TransitionKt$doOnStart$$inlined$addListener$default$1(action);
        $this$doOnStart.addListener(listener$iv);
        return listener$iv;
    }

    @RequiresApi(19)
    public static final Transition.TransitionListener doOnCancel(Transition $this$doOnCancel, vn<? super Transition, jt0> action) {
        lu.f($this$doOnCancel, "<this>");
        lu.f(action, "action");
        TransitionKt$doOnCancel$$inlined$addListener$default$1 listener$iv = new TransitionKt$doOnCancel$$inlined$addListener$default$1(action);
        $this$doOnCancel.addListener(listener$iv);
        return listener$iv;
    }

    @RequiresApi(19)
    public static final Transition.TransitionListener doOnResume(Transition $this$doOnResume, vn<? super Transition, jt0> action) {
        lu.f($this$doOnResume, "<this>");
        lu.f(action, "action");
        TransitionKt$doOnResume$$inlined$addListener$default$1 listener$iv = new TransitionKt$doOnResume$$inlined$addListener$default$1(action);
        $this$doOnResume.addListener(listener$iv);
        return listener$iv;
    }

    @RequiresApi(19)
    public static final Transition.TransitionListener doOnPause(Transition $this$doOnPause, vn<? super Transition, jt0> action) {
        lu.f($this$doOnPause, "<this>");
        lu.f(action, "action");
        TransitionKt$doOnPause$$inlined$addListener$default$1 listener$iv = new TransitionKt$doOnPause$$inlined$addListener$default$1(action);
        $this$doOnPause.addListener(listener$iv);
        return listener$iv;
    }

    public static /* synthetic */ Transition.TransitionListener addListener$default(Transition $this$addListener_u24default, vn onEnd, vn onStart, vn onCancel, vn onResume, vn onPause, int i, Object obj) {
        vn onStart2;
        vn onCancel2;
        vn onResume2;
        vn onPause2;
        if ((i & 1) != 0) {
            onEnd = TransitionKt$addListener$1.INSTANCE;
        }
        if ((i & 2) != 0) {
            onStart2 = TransitionKt$addListener$2.INSTANCE;
        } else {
            onStart2 = onStart;
        }
        if ((i & 4) != 0) {
            onCancel2 = TransitionKt$addListener$3.INSTANCE;
        } else {
            onCancel2 = onCancel;
        }
        if ((i & 8) != 0) {
            onResume2 = TransitionKt$addListener$4.INSTANCE;
        } else {
            onResume2 = onResume;
        }
        if ((i & 16) != 0) {
            onPause2 = TransitionKt$addListener$5.INSTANCE;
        } else {
            onPause2 = onPause;
        }
        lu.f($this$addListener_u24default, "<this>");
        lu.f(onEnd, "onEnd");
        lu.f(onStart2, "onStart");
        lu.f(onCancel2, "onCancel");
        lu.f(onResume2, "onResume");
        lu.f(onPause2, "onPause");
        TransitionKt$addListener$listener$1 listener = new TransitionKt$addListener$listener$1(onEnd, onResume2, onPause2, onCancel2, onStart2);
        $this$addListener_u24default.addListener(listener);
        return listener;
    }

    @RequiresApi(19)
    public static final Transition.TransitionListener addListener(Transition $this$addListener, vn<? super Transition, jt0> onEnd, vn<? super Transition, jt0> onStart, vn<? super Transition, jt0> onCancel, vn<? super Transition, jt0> onResume, vn<? super Transition, jt0> onPause) {
        lu.f($this$addListener, "<this>");
        lu.f(onEnd, "onEnd");
        lu.f(onStart, "onStart");
        lu.f(onCancel, "onCancel");
        lu.f(onResume, "onResume");
        lu.f(onPause, "onPause");
        TransitionKt$addListener$listener$1 listener = new TransitionKt$addListener$listener$1(onEnd, onResume, onPause, onCancel, onStart);
        $this$addListener.addListener(listener);
        return listener;
    }
}
