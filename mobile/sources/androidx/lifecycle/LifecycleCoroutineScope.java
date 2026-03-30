package androidx.lifecycle;

import kotlinx.coroutines.a;

public abstract class LifecycleCoroutineScope implements hd {
    public abstract /* synthetic */ yc getCoroutineContext();

    public abstract Lifecycle getLifecycle$lifecycle_common();

    public final ev launchWhenCreated(jo<? super hd, ? super rc<? super jt0>, ? extends Object> block) {
        lu.f(block, "block");
        return v6.b(this, (yc) null, (a) null, new LifecycleCoroutineScope$launchWhenCreated$1(this, block, (rc<? super LifecycleCoroutineScope$launchWhenCreated$1>) null), 3, (Object) null);
    }

    public final ev launchWhenStarted(jo<? super hd, ? super rc<? super jt0>, ? extends Object> block) {
        lu.f(block, "block");
        return v6.b(this, (yc) null, (a) null, new LifecycleCoroutineScope$launchWhenStarted$1(this, block, (rc<? super LifecycleCoroutineScope$launchWhenStarted$1>) null), 3, (Object) null);
    }

    public final ev launchWhenResumed(jo<? super hd, ? super rc<? super jt0>, ? extends Object> block) {
        lu.f(block, "block");
        return v6.b(this, (yc) null, (a) null, new LifecycleCoroutineScope$launchWhenResumed$1(this, block, (rc<? super LifecycleCoroutineScope$launchWhenResumed$1>) null), 3, (Object) null);
    }
}
