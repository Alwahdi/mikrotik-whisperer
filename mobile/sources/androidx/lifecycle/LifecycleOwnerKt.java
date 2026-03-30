package androidx.lifecycle;

public final class LifecycleOwnerKt {
    public static final LifecycleCoroutineScope getLifecycleScope(LifecycleOwner $this$lifecycleScope) {
        lu.f($this$lifecycleScope, "<this>");
        return LifecycleKt.getCoroutineScope($this$lifecycleScope.getLifecycle());
    }
}
