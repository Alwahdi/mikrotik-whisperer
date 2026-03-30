package defpackage;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* renamed from: vu  reason: default package */
final class vu extends gv {
    private static final /* synthetic */ AtomicIntegerFieldUpdater a = AtomicIntegerFieldUpdater.newUpdater(vu.class, "_invoked");
    private volatile /* synthetic */ int _invoked = 0;

    /* renamed from: a  reason: collision with other field name */
    private final vn<Throwable, jt0> f5416a;

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        s((Throwable) p1);
        return jt0.a;
    }

    public vu(vn<? super Throwable, jt0> handler) {
        this.f5416a = handler;
    }

    public void s(Throwable cause) {
        if (a.compareAndSet(this, 0, 1)) {
            this.f5416a.invoke(cause);
        }
    }
}
