package androidx.core.util;

import androidx.annotation.RequiresApi;
import java.util.function.Consumer;

@RequiresApi(24)
public final class ConsumerKt {
    @RequiresApi(24)
    public static final <T> Consumer<T> asConsumer(rc<? super T> $this$asConsumer) {
        lu.f($this$asConsumer, "<this>");
        return new ContinuationConsumer($this$asConsumer);
    }
}
