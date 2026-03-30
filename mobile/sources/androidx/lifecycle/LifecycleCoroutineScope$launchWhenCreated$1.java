package androidx.lifecycle;

@bf(c = "androidx.lifecycle.LifecycleCoroutineScope$launchWhenCreated$1", f = "Lifecycle.kt", l = {337}, m = "invokeSuspend")
final class LifecycleCoroutineScope$launchWhenCreated$1 extends to0 implements jo<hd, rc<? super jt0>, Object> {
    final /* synthetic */ jo<hd, rc<? super jt0>, Object> $block;
    int label;
    final /* synthetic */ LifecycleCoroutineScope this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LifecycleCoroutineScope$launchWhenCreated$1(LifecycleCoroutineScope lifecycleCoroutineScope, jo<? super hd, ? super rc<? super jt0>, ? extends Object> joVar, rc<? super LifecycleCoroutineScope$launchWhenCreated$1> rcVar) {
        super(2, rcVar);
        this.this$0 = lifecycleCoroutineScope;
        this.$block = joVar;
    }

    public final rc<jt0> create(Object obj, rc<?> rcVar) {
        return new LifecycleCoroutineScope$launchWhenCreated$1(this.this$0, this.$block, rcVar);
    }

    public final Object invoke(hd hdVar, rc<? super jt0> rcVar) {
        return ((LifecycleCoroutineScope$launchWhenCreated$1) create(hdVar, rcVar)).invokeSuspend(jt0.a);
    }

    public final Object invokeSuspend(Object $result) {
        Object d = ou.d();
        switch (this.label) {
            case 0:
                te0.b($result);
                Lifecycle lifecycle$lifecycle_common = this.this$0.getLifecycle$lifecycle_common();
                jo<hd, rc<? super jt0>, Object> joVar = this.$block;
                this.label = 1;
                if (PausingDispatcherKt.whenCreated(lifecycle$lifecycle_common, joVar, this) != d) {
                    break;
                } else {
                    return d;
                }
            case 1:
                te0.b($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return jt0.a;
    }
}
