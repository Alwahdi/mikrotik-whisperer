package defpackage;

import java.io.Closeable;

/* renamed from: d9  reason: default package */
public abstract class d9 {
    public static final void a(Closeable $this$closeFinally, Throwable cause) {
        if ($this$closeFinally == null) {
            return;
        }
        if (cause == null) {
            $this$closeFinally.close();
            return;
        }
        try {
            $this$closeFinally.close();
        } catch (Throwable closeException) {
            rj.a(cause, closeException);
        }
    }
}
