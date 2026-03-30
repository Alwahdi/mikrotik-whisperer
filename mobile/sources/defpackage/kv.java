package defpackage;

import java.util.concurrent.CancellationException;

/* renamed from: kv  reason: default package */
abstract /* synthetic */ class kv {
    public static /* synthetic */ void b(yc ycVar, CancellationException cancellationException, int i, Object obj) {
        if ((i & 1) != 0) {
            cancellationException = null;
        }
        jv.a(ycVar, cancellationException);
    }

    public static final void a(yc $this$cancel, CancellationException cause) {
        ev evVar = (ev) $this$cancel.get(ev.a);
        if (evVar != null) {
            evVar.o(cause);
        }
    }

    public static final void d(ev $this$ensureActive) {
        if (!$this$ensureActive.c()) {
            throw $this$ensureActive.K();
        }
    }

    public static final void c(yc $this$ensureActive) {
        ev evVar = (ev) $this$ensureActive.get(ev.a);
        if (evVar != null) {
            jv.d(evVar);
        }
    }
}
