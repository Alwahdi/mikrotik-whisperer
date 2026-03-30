package androidx.activity.result.contract;

import android.content.Context;
import android.content.Intent;

public abstract class ActivityResultContract<I, O> {
    public abstract Intent createIntent(Context context, I i);

    public abstract O parseResult(int i, Intent intent);

    public SynchronousResult<O> getSynchronousResult(Context context, I input) {
        lu.f(context, "context");
        return null;
    }

    public static final class SynchronousResult<T> {
        private final T value;

        public SynchronousResult(T value2) {
            this.value = value2;
        }

        public final T getValue() {
            return this.value;
        }
    }
}
