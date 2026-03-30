package androidx.lifecycle;

public final class PausingDispatcher extends ad {
    public final DispatchQueue dispatchQueue = new DispatchQueue();

    public boolean isDispatchNeeded(yc context) {
        lu.f(context, "context");
        if (xg.c().X().isDispatchNeeded(context)) {
            return true;
        }
        return !this.dispatchQueue.canRun();
    }

    public void dispatch(yc context, Runnable block) {
        lu.f(context, "context");
        lu.f(block, "block");
        this.dispatchQueue.dispatchAndEnqueue(context, block);
    }
}
