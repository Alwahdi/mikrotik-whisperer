package defpackage;

import io.reactivex.internal.disposables.a;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: bh  reason: default package */
public abstract class bh<T> implements zl0<T>, yg {
    final AtomicReference<yg> a = new AtomicReference<>();

    public final void b(yg s) {
        if (si.c(this.a, s, getClass())) {
            a();
        }
    }

    /* access modifiers changed from: protected */
    public void a() {
    }

    public final void dispose() {
        a.dispose(this.a);
    }
}
