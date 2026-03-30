package androidx.core.util;

import androidx.annotation.RequiresApi;
import defpackage.se0;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;

@RequiresApi(24)
final class ContinuationConsumer<T> extends AtomicBoolean implements Consumer<T> {
    private final rc<T> continuation;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ContinuationConsumer(rc<? super T> continuation2) {
        super(false);
        lu.f(continuation2, "continuation");
        this.continuation = continuation2;
    }

    public void accept(T value) {
        if (compareAndSet(false, true)) {
            rc<T> rcVar = this.continuation;
            se0.a aVar = se0.a;
            rcVar.resumeWith(se0.a(value));
        }
    }

    public String toString() {
        return "ContinuationConsumer(resultAccepted = " + get() + ')';
    }
}
