package defpackage;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* renamed from: sg  reason: default package */
public final class sg<T> extends vg<T> implements id, rc<T> {
    private static final /* synthetic */ AtomicReferenceFieldUpdater a = AtomicReferenceFieldUpdater.newUpdater(sg.class, Object.class, "_reusableCancellableContinuation");
    private volatile /* synthetic */ Object _reusableCancellableContinuation = null;

    /* renamed from: a  reason: collision with other field name */
    public final ad f4982a;

    /* renamed from: a  reason: collision with other field name */
    public Object f4983a = tg.a;

    /* renamed from: a  reason: collision with other field name */
    public final rc<T> f4984a;
    public final Object b = xq0.b(getContext());

    public yc getContext() {
        return this.f4984a.getContext();
    }

    public sg(ad dispatcher, rc<? super T> continuation) {
        super(-1);
        this.f4982a = dispatcher;
        this.f4984a = continuation;
    }

    public id getCallerFrame() {
        rc<T> rcVar = this.f4984a;
        if (rcVar instanceof id) {
            return (id) rcVar;
        }
        return null;
    }

    public StackTraceElement getStackTraceElement() {
        return null;
    }

    private final s7<?> i() {
        Object obj = this._reusableCancellableContinuation;
        if (obj instanceof s7) {
            return (s7) obj;
        }
        return null;
    }

    public final boolean j() {
        return this._reusableCancellableContinuation != null;
    }

    public final void h() {
        do {
        } while (this._reusableCancellableContinuation == tg.b);
    }

    public final void l() {
        h();
        s7<?> i = i();
        if (i != null) {
            i.n();
        }
    }

    public final Throwable m(r7<?> continuation) {
        uo0 uo0;
        do {
            Object state = this._reusableCancellableContinuation;
            uo0 = tg.b;
            if (state != uo0) {
                if (!(state instanceof Throwable)) {
                    throw new IllegalStateException(("Inconsistent state " + state).toString());
                } else if (w.a(a, this, state, (Object) null)) {
                    return (Throwable) state;
                } else {
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
            }
        } while (!w.a(a, this, uo0, continuation));
        return null;
    }

    public final boolean k(Throwable cause) {
        while (true) {
            Object state = this._reusableCancellableContinuation;
            uo0 uo0 = tg.b;
            if (lu.a(state, uo0)) {
                if (w.a(a, this, uo0, cause)) {
                    return true;
                }
            } else if (state instanceof Throwable) {
                return true;
            } else {
                if (w.a(a, this, state, (Object) null)) {
                    return false;
                }
            }
        }
    }

    public Object g() {
        Object state = this.f4983a;
        if (af.a()) {
            if (!(state != tg.a)) {
                throw new AssertionError();
            }
        }
        this.f4983a = tg.a;
        return state;
    }

    public rc<T> c() {
        return this;
    }

    public void resumeWith(Object result) {
        yc context$iv;
        Object oldValue$iv;
        Object obj = result;
        yc context = this.f4984a.getContext();
        Object state = za.d(obj, (vn) null, 1, (Object) null);
        if (this.f4982a.isDispatchNeeded(context)) {
            this.f4983a = state;
            this.a = 0;
            this.f4982a.dispatch(context, this);
            return;
        }
        if (af.a()) {
        }
        cj eventLoop$iv = ar0.a.a();
        if (eventLoop$iv.d0()) {
            this.f4983a = state;
            this.a = 0;
            eventLoop$iv.Z(this);
            return;
        }
        eventLoop$iv.b0(true);
        try {
            context$iv = getContext();
            oldValue$iv = xq0.c(context$iv, this.b);
            this.f4984a.resumeWith(obj);
            jt0 jt0 = jt0.a;
            xq0.a(context$iv, oldValue$iv);
            do {
            } while (eventLoop$iv.f0());
        } catch (Throwable e$iv$iv) {
            try {
                f(e$iv$iv, (Throwable) null);
            } catch (Throwable th) {
                Throwable th2 = th;
                eventLoop$iv.X(true);
                throw th2;
            }
        }
        eventLoop$iv.X(true);
    }

    public void a(Object takenState, Throwable cause) {
        if (takenState instanceof wa) {
            ((wa) takenState).f5472a.invoke(cause);
        }
    }

    public String toString() {
        return "DispatchedContinuation[" + this.f4982a + ", " + ef.c(this.f4984a) + ']';
    }
}
