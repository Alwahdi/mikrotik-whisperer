package androidx.core.os;

import android.os.OutcomeReceiver;
import androidx.annotation.RequiresApi;
import defpackage.se0;
import java.lang.Throwable;
import java.util.concurrent.atomic.AtomicBoolean;

@RequiresApi(31)
final class ContinuationOutcomeReceiver<R, E extends Throwable> extends AtomicBoolean implements OutcomeReceiver<R, E> {
    private final rc<R> continuation;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ContinuationOutcomeReceiver(rc<? super R> continuation2) {
        super(false);
        lu.f(continuation2, "continuation");
        this.continuation = continuation2;
    }

    public void onResult(R result) {
        if (compareAndSet(false, true)) {
            rc<R> rcVar = this.continuation;
            se0.a aVar = se0.a;
            rcVar.resumeWith(se0.a(result));
        }
    }

    public void onError(E error) {
        lu.f(error, "error");
        if (compareAndSet(false, true)) {
            rc<R> rcVar = this.continuation;
            se0.a aVar = se0.a;
            rcVar.resumeWith(se0.a(te0.a(error)));
        }
    }

    public String toString() {
        return "ContinuationOutcomeReceiver(outcomeReceived = " + get() + ')';
    }
}
