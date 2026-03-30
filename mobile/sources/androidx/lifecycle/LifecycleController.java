package androidx.lifecycle;

import androidx.annotation.MainThread;
import androidx.lifecycle.Lifecycle;
import defpackage.ev;
import java.util.concurrent.CancellationException;

@MainThread
public final class LifecycleController {
    private final DispatchQueue dispatchQueue;
    private final Lifecycle lifecycle;
    private final Lifecycle.State minState;
    private final LifecycleEventObserver observer;

    public LifecycleController(Lifecycle lifecycle2, Lifecycle.State minState2, DispatchQueue dispatchQueue2, ev parentJob) {
        lu.f(lifecycle2, "lifecycle");
        lu.f(minState2, "minState");
        lu.f(dispatchQueue2, "dispatchQueue");
        lu.f(parentJob, "parentJob");
        this.lifecycle = lifecycle2;
        this.minState = minState2;
        this.dispatchQueue = dispatchQueue2;
        cx cxVar = new cx(this, parentJob);
        this.observer = cxVar;
        if (lifecycle2.getCurrentState() == Lifecycle.State.DESTROYED) {
            ev.a.a(parentJob, (CancellationException) null, 1, (Object) null);
            finish();
            return;
        }
        lifecycle2.addObserver(cxVar);
    }

    /* access modifiers changed from: private */
    public static final void observer$lambda$0(LifecycleController this$0, ev $parentJob, LifecycleOwner source, Lifecycle.Event event) {
        lu.f(this$0, "this$0");
        lu.f($parentJob, "$parentJob");
        lu.f(source, "source");
        lu.f(event, "<anonymous parameter 1>");
        if (source.getLifecycle().getCurrentState() == Lifecycle.State.DESTROYED) {
            ev.a.a($parentJob, (CancellationException) null, 1, (Object) null);
            this$0.finish();
        } else if (source.getLifecycle().getCurrentState().compareTo(this$0.minState) < 0) {
            this$0.dispatchQueue.pause();
        } else {
            this$0.dispatchQueue.resume();
        }
    }

    private final void handleDestroy(ev parentJob) {
        ev.a.a(parentJob, (CancellationException) null, 1, (Object) null);
        finish();
    }

    @MainThread
    public final void finish() {
        this.lifecycle.removeObserver(this.observer);
        this.dispatchQueue.finish();
    }
}
