package androidx.activity.contextaware;

import android.content.Context;

public final class ContextAwareKt {
    public static final <R> Object withContextAvailable(ContextAware $this$withContextAvailable, vn<Context, R> onContextAvailable, rc<R> $completion) {
        Context availableContext = $this$withContextAvailable.peekAvailableContext();
        if (availableContext != null) {
            return onContextAvailable.invoke(availableContext);
        }
        s7 cancellable$iv = new s7(nu.c($completion), 1);
        cancellable$iv.u();
        r7 co = cancellable$iv;
        ContextAwareKt$withContextAvailable$2$listener$1 listener = new ContextAwareKt$withContextAvailable$2$listener$1(co, onContextAvailable);
        $this$withContextAvailable.addOnContextAvailableListener(listener);
        co.b(new ContextAwareKt$withContextAvailable$2$1($this$withContextAvailable, listener));
        Object r = cancellable$iv.r();
        if (r == ou.d()) {
            df.c($completion);
        }
        return r;
    }

    private static final <R> Object withContextAvailable$$forInline(ContextAware $this$withContextAvailable, vn<Context, R> onContextAvailable, rc<R> $completion) {
        Context availableContext = $this$withContextAvailable.peekAvailableContext();
        if (availableContext != null) {
            return onContextAvailable.invoke(availableContext);
        }
        ps.c(0);
        s7 cancellable$iv = new s7(nu.c($completion), 1);
        cancellable$iv.u();
        r7 co = cancellable$iv;
        ContextAwareKt$withContextAvailable$2$listener$1 listener = new ContextAwareKt$withContextAvailable$2$listener$1(co, onContextAvailable);
        $this$withContextAvailable.addOnContextAvailableListener(listener);
        co.b(new ContextAwareKt$withContextAvailable$2$1($this$withContextAvailable, listener));
        jt0 jt0 = jt0.a;
        Object r = cancellable$iv.r();
        if (r == ou.d()) {
            df.c($completion);
        }
        ps.c(1);
        return r;
    }
}
