package androidx.core.os;

import android.os.OutcomeReceiver;
import androidx.annotation.RequiresApi;

@RequiresApi(31)
public final class OutcomeReceiverKt {
    @RequiresApi(31)
    public static final <R, E extends Throwable> OutcomeReceiver<R, E> asOutcomeReceiver(rc<? super R> $this$asOutcomeReceiver) {
        lu.f($this$asOutcomeReceiver, "<this>");
        return new ContinuationOutcomeReceiver($this$asOutcomeReceiver);
    }
}
