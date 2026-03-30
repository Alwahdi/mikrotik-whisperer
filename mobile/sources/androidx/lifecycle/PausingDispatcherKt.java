package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;

public final class PausingDispatcherKt {
    public static final <T> Object whenCreated(LifecycleOwner $this$whenCreated, jo<? super hd, ? super rc<? super T>, ? extends Object> block, rc<? super T> $completion) {
        return whenCreated($this$whenCreated.getLifecycle(), block, $completion);
    }

    public static final <T> Object whenCreated(Lifecycle $this$whenCreated, jo<? super hd, ? super rc<? super T>, ? extends Object> block, rc<? super T> $completion) {
        return whenStateAtLeast($this$whenCreated, Lifecycle.State.CREATED, block, $completion);
    }

    public static final <T> Object whenStarted(LifecycleOwner $this$whenStarted, jo<? super hd, ? super rc<? super T>, ? extends Object> block, rc<? super T> $completion) {
        return whenStarted($this$whenStarted.getLifecycle(), block, $completion);
    }

    public static final <T> Object whenStarted(Lifecycle $this$whenStarted, jo<? super hd, ? super rc<? super T>, ? extends Object> block, rc<? super T> $completion) {
        return whenStateAtLeast($this$whenStarted, Lifecycle.State.STARTED, block, $completion);
    }

    public static final <T> Object whenResumed(LifecycleOwner $this$whenResumed, jo<? super hd, ? super rc<? super T>, ? extends Object> block, rc<? super T> $completion) {
        return whenResumed($this$whenResumed.getLifecycle(), block, $completion);
    }

    public static final <T> Object whenResumed(Lifecycle $this$whenResumed, jo<? super hd, ? super rc<? super T>, ? extends Object> block, rc<? super T> $completion) {
        return whenStateAtLeast($this$whenResumed, Lifecycle.State.RESUMED, block, $completion);
    }

    public static final <T> Object whenStateAtLeast(Lifecycle $this$whenStateAtLeast, Lifecycle.State minState, jo<? super hd, ? super rc<? super T>, ? extends Object> block, rc<? super T> $completion) {
        return u6.c(xg.c().X(), new PausingDispatcherKt$whenStateAtLeast$2($this$whenStateAtLeast, minState, block, (rc<? super PausingDispatcherKt$whenStateAtLeast$2>) null), $completion);
    }
}
