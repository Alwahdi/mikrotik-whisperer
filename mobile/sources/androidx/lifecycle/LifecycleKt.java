package androidx.lifecycle;

public final class LifecycleKt {
    public static final LifecycleCoroutineScope getCoroutineScope(Lifecycle $this$coroutineScope) {
        LifecycleCoroutineScopeImpl newScope;
        lu.f($this$coroutineScope, "<this>");
        do {
            LifecycleCoroutineScopeImpl existing = (LifecycleCoroutineScopeImpl) $this$coroutineScope.getInternalScopeRef().get();
            if (existing != null) {
                return existing;
            }
            newScope = new LifecycleCoroutineScopeImpl($this$coroutineScope, no0.b((ev) null, 1, (Object) null).plus(xg.c().X()));
        } while (!$this$coroutineScope.getInternalScopeRef().compareAndSet((Object) null, newScope));
        newScope.register();
        return newScope;
    }
}
