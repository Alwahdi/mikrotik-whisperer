package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import java.util.concurrent.CancellationException;

@bf(c = "androidx.lifecycle.LifecycleCoroutineScopeImpl$register$1", f = "Lifecycle.kt", l = {}, m = "invokeSuspend")
final class LifecycleCoroutineScopeImpl$register$1 extends to0 implements jo<hd, rc<? super jt0>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ LifecycleCoroutineScopeImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LifecycleCoroutineScopeImpl$register$1(LifecycleCoroutineScopeImpl lifecycleCoroutineScopeImpl, rc<? super LifecycleCoroutineScopeImpl$register$1> rcVar) {
        super(2, rcVar);
        this.this$0 = lifecycleCoroutineScopeImpl;
    }

    public final rc<jt0> create(Object obj, rc<?> rcVar) {
        LifecycleCoroutineScopeImpl$register$1 lifecycleCoroutineScopeImpl$register$1 = new LifecycleCoroutineScopeImpl$register$1(this.this$0, rcVar);
        lifecycleCoroutineScopeImpl$register$1.L$0 = obj;
        return lifecycleCoroutineScopeImpl$register$1;
    }

    public final Object invoke(hd hdVar, rc<? super jt0> rcVar) {
        return ((LifecycleCoroutineScopeImpl$register$1) create(hdVar, rcVar)).invokeSuspend(jt0.a);
    }

    public final Object invokeSuspend(Object obj) {
        Object unused = ou.d();
        switch (this.label) {
            case 0:
                te0.b(obj);
                hd $this$launch = (hd) this.L$0;
                if (this.this$0.getLifecycle$lifecycle_common().getCurrentState().compareTo(Lifecycle.State.INITIALIZED) >= 0) {
                    this.this$0.getLifecycle$lifecycle_common().addObserver(this.this$0);
                } else {
                    kv.b($this$launch.getCoroutineContext(), (CancellationException) null, 1, (Object) null);
                }
                return jt0.a;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
