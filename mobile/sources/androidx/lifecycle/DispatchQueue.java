package androidx.lifecycle;

import androidx.annotation.AnyThread;
import androidx.annotation.MainThread;
import java.util.ArrayDeque;
import java.util.Queue;

public final class DispatchQueue {
    private boolean finished;
    private boolean isDraining;
    private boolean paused = true;
    private final Queue<Runnable> queue = new ArrayDeque();

    @MainThread
    public final void pause() {
        this.paused = true;
    }

    @MainThread
    public final void resume() {
        if (this.paused) {
            if (!this.finished) {
                this.paused = false;
                drainQueue();
                return;
            }
            throw new IllegalStateException("Cannot resume a finished dispatcher".toString());
        }
    }

    @MainThread
    public final void finish() {
        this.finished = true;
        drainQueue();
    }

    @MainThread
    public final void drainQueue() {
        if (!this.isDraining) {
            boolean z = false;
            z = true;
            try {
                while (true) {
                    if (!(this.queue.isEmpty() ^ z)) {
                        break;
                    } else if (!canRun()) {
                        break;
                    } else {
                        Runnable poll = this.queue.poll();
                        if (poll != null) {
                            poll.run();
                        }
                    }
                }
                this.isDraining = z;
            } finally {
                this.isDraining = z;
            }
        }
    }

    @MainThread
    public final boolean canRun() {
        return this.finished || !this.paused;
    }

    @AnyThread
    public final void dispatchAndEnqueue(yc context, Runnable runnable) {
        lu.f(context, "context");
        lu.f(runnable, "runnable");
        nz $this$dispatchAndEnqueue_u24lambda_u242 = xg.c().X();
        if ($this$dispatchAndEnqueue_u24lambda_u242.isDispatchNeeded(context) || canRun()) {
            $this$dispatchAndEnqueue_u24lambda_u242.dispatch(context, new rg(this, runnable));
        } else {
            enqueue(runnable);
        }
    }

    /* access modifiers changed from: private */
    public static final void dispatchAndEnqueue$lambda$2$lambda$1(DispatchQueue this$0, Runnable $runnable) {
        lu.f(this$0, "this$0");
        lu.f($runnable, "$runnable");
        this$0.enqueue($runnable);
    }

    @MainThread
    private final void enqueue(Runnable runnable) {
        if (this.queue.offer(runnable)) {
            drainQueue();
            return;
        }
        throw new IllegalStateException("cannot enqueue any more runnables".toString());
    }
}
