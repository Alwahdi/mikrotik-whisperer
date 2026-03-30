package androidx.core.util;

public final class AndroidXConsumerKt {
    public static final <T> Consumer<T> asAndroidXConsumer(rc<? super T> $this$asAndroidXConsumer) {
        lu.f($this$asAndroidXConsumer, "<this>");
        return new AndroidXContinuationConsumer($this$asAndroidXConsumer);
    }
}
