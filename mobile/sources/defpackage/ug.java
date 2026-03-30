package defpackage;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* renamed from: ug  reason: default package */
public final class ug<T> extends qj0<T> {
    private static final /* synthetic */ AtomicIntegerFieldUpdater a = AtomicIntegerFieldUpdater.newUpdater(ug.class, "_decision");
    private volatile /* synthetic */ int _decision = 0;

    public ug(yc context, rc<? super T> uCont) {
        super(context, uCont);
    }

    private final boolean s0() {
        do {
            switch (this._decision) {
                case 0:
                    break;
                case 2:
                    return false;
                default:
                    throw new IllegalStateException("Already suspended".toString());
            }
        } while (!a.compareAndSet(this, 0, 1));
        return true;
    }

    private final boolean r0() {
        do {
            switch (this._decision) {
                case 0:
                    break;
                case 1:
                    return false;
                default:
                    throw new IllegalStateException("Already resumed".toString());
            }
        } while (!a.compareAndSet(this, 0, 2));
        return true;
    }

    /* access modifiers changed from: protected */
    public void h(Object state) {
        m0(state);
    }

    /* access modifiers changed from: protected */
    public void m0(Object state) {
        if (!r0()) {
            tg.c(nu.c(this.a), za.a(state, this.a), (vn) null, 2, (Object) null);
        }
    }

    public final Object q0() {
        if (s0()) {
            return ou.d();
        }
        Object state = nv.h(D());
        if (!(state instanceof va)) {
            return state;
        }
        throw ((va) state).f5381a;
    }
}
