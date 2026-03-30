package androidx.lifecycle;

import androidx.core.app.NotificationCompat;
import androidx.lifecycle.Lifecycle;
import java.util.concurrent.CancellationException;
import kotlinx.coroutines.a;

public final class LifecycleCoroutineScopeImpl extends LifecycleCoroutineScope implements LifecycleEventObserver {
    private final yc coroutineContext;
    private final Lifecycle lifecycle;

    public Lifecycle getLifecycle$lifecycle_common() {
        return this.lifecycle;
    }

    public yc getCoroutineContext() {
        return this.coroutineContext;
    }

    public LifecycleCoroutineScopeImpl(Lifecycle lifecycle2, yc coroutineContext2) {
        lu.f(lifecycle2, "lifecycle");
        lu.f(coroutineContext2, "coroutineContext");
        this.lifecycle = lifecycle2;
        this.coroutineContext = coroutineContext2;
        if (getLifecycle$lifecycle_common().getCurrentState() == Lifecycle.State.DESTROYED) {
            kv.b(getCoroutineContext(), (CancellationException) null, 1, (Object) null);
        }
    }

    public final void register() {
        ev unused = v6.b(this, xg.c().X(), (a) null, new LifecycleCoroutineScopeImpl$register$1(this, (rc<? super LifecycleCoroutineScopeImpl$register$1>) null), 2, (Object) null);
    }

    public void onStateChanged(LifecycleOwner source, Lifecycle.Event event) {
        lu.f(source, "source");
        lu.f(event, NotificationCompat.CATEGORY_EVENT);
        if (getLifecycle$lifecycle_common().getCurrentState().compareTo(Lifecycle.State.DESTROYED) <= 0) {
            getLifecycle$lifecycle_common().removeObserver(this);
            kv.b(getCoroutineContext(), (CancellationException) null, 1, (Object) null);
        }
    }
}
