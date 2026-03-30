package androidx.core.util;

import defpackage.se0;
import java.util.concurrent.atomic.AtomicBoolean;

final class ContinuationRunnable extends AtomicBoolean implements Runnable {
    private final rc<jt0> continuation;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ContinuationRunnable(rc<? super jt0> continuation2) {
        super(false);
        lu.f(continuation2, "continuation");
        this.continuation = continuation2;
    }

    public void run() {
        if (compareAndSet(false, true)) {
            rc<jt0> rcVar = this.continuation;
            se0.a aVar = se0.a;
            rcVar.resumeWith(se0.a(jt0.a));
        }
    }

    public String toString() {
        return "ContinuationRunnable(ran = " + get() + ')';
    }
}
