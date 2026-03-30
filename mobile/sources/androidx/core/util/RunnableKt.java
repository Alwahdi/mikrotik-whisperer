package androidx.core.util;

public final class RunnableKt {
    public static final Runnable asRunnable(rc<? super jt0> $this$asRunnable) {
        lu.f($this$asRunnable, "<this>");
        return new ContinuationRunnable($this$asRunnable);
    }
}
