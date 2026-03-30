package defpackage;

import io.reactivex.internal.disposables.a;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: lk0  reason: default package */
public final class lk0 extends AtomicReference<yg> implements yg {
    public boolean b(yg next) {
        return a.replace(this, next);
    }

    public void dispose() {
        a.dispose(this);
    }

    public boolean a() {
        return a.isDisposed((yg) get());
    }
}
