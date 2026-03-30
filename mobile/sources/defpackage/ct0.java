package defpackage;

/* renamed from: ct0  reason: default package */
public final class ct0 extends ad {
    public static final ct0 a = new ct0();

    private ct0() {
    }

    public ad limitedParallelism(int parallelism) {
        throw new UnsupportedOperationException("limitedParallelism is not supported for Dispatchers.Unconfined");
    }

    public boolean isDispatchNeeded(yc context) {
        return false;
    }

    public void dispatch(yc context, Runnable block) {
        fw0 yieldContext = (fw0) context.get(fw0.a);
        if (yieldContext != null) {
            yieldContext.f2994a = true;
            return;
        }
        throw new UnsupportedOperationException("Dispatchers.Unconfined.dispatch function can only be used by the yield function. If you wrap Unconfined dispatcher in your code, make sure you properly delegate isDispatchNeeded and dispatch calls.");
    }

    public String toString() {
        return "Dispatchers.Unconfined";
    }
}
