package androidx.core.os;

public final class HandlerKt$postAtTime$runnable$1 implements Runnable {
    final /* synthetic */ tn<jt0> $action;

    public HandlerKt$postAtTime$runnable$1(tn<jt0> tnVar) {
        this.$action = tnVar;
    }

    public final void run() {
        this.$action.invoke();
    }
}
