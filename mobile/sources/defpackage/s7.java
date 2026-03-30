package defpackage;

import defpackage.ev;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* renamed from: s7  reason: default package */
public class s7<T> extends vg<T> implements r7<T>, id {
    private static final /* synthetic */ AtomicIntegerFieldUpdater a = AtomicIntegerFieldUpdater.newUpdater(s7.class, "_decision");

    /* renamed from: a  reason: collision with other field name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f4972a = AtomicReferenceFieldUpdater.newUpdater(s7.class, Object.class, "_state");
    private volatile /* synthetic */ int _decision;
    private volatile /* synthetic */ Object _state;

    /* renamed from: a  reason: collision with other field name */
    private ah f4973a;

    /* renamed from: a  reason: collision with other field name */
    private final rc<T> f4974a;

    /* renamed from: a  reason: collision with other field name */
    private final yc f4975a;

    public final rc<T> c() {
        return this.f4974a;
    }

    public s7(rc<? super T> delegate, int resumeMode) {
        super(resumeMode);
        this.f4974a = delegate;
        if (af.a()) {
            if (!(resumeMode != -1)) {
                throw new AssertionError();
            }
        }
        this.f4975a = delegate.getContext();
        this._decision = 0;
        this._state = l0.a;
    }

    public yc getContext() {
        return this.f4975a;
    }

    public final Object s() {
        return this._state;
    }

    public boolean w() {
        return !(s() instanceof n30);
    }

    private final String t() {
        Object s = s();
        if (s instanceof n30) {
            return "Active";
        }
        if (s instanceof u7) {
            return "Cancelled";
        }
        return "Completed";
    }

    public void u() {
        ah handle = v();
        if (handle != null && w()) {
            handle.dispose();
            this.f4973a = l30.a;
        }
    }

    private final boolean x() {
        return wg.c(this.a) && ((sg) this.f4974a).j();
    }

    public id getCallerFrame() {
        rc<T> rcVar = this.f4974a;
        if (rcVar instanceof id) {
            return (id) rcVar;
        }
        return null;
    }

    public StackTraceElement getStackTraceElement() {
        return null;
    }

    public Object g() {
        return s();
    }

    public void a(Object takenState, Throwable cause) {
        while (true) {
            Object state = this._state;
            if (state instanceof n30) {
                Throwable th = cause;
                throw new IllegalStateException("Not completed".toString());
            } else if (!(state instanceof va)) {
                if (!(state instanceof ta)) {
                    Throwable th2 = cause;
                    if (w.a(f4972a, this, state, new ta(state, (o7) null, (vn) null, (Object) null, cause, 14, (Cif) null))) {
                        return;
                    }
                } else if (!((ta) state).c()) {
                    if (w.a(f4972a, this, state, ta.b((ta) state, (Object) null, (o7) null, (vn) null, (Object) null, cause, 15, (Object) null))) {
                        ((ta) state).d(this, cause);
                        return;
                    }
                    Throwable th3 = cause;
                } else {
                    Throwable th4 = cause;
                    throw new IllegalStateException("Must be called at most once".toString());
                }
            } else {
                return;
            }
        }
    }

    private final boolean m(Throwable cause) {
        if (!x()) {
            return false;
        }
        return ((sg) this.f4974a).k(cause);
    }

    public boolean l(Throwable cause) {
        Object state;
        do {
            state = this._state;
            if (!(state instanceof n30)) {
                return false;
            }
        } while (!w.a(f4972a, this, state, new u7(this, cause, state instanceof o7)));
        o7 it = state instanceof o7 ? (o7) state : null;
        if (it != null) {
            i(it, cause);
        }
        o();
        p(this.a);
        return true;
    }

    public final void B(Throwable cause) {
        if (!m(cause)) {
            l(cause);
            o();
        }
    }

    private final void j(vn<? super Throwable, jt0> handler, Throwable cause) {
        try {
            handler.invoke(cause);
        } catch (Throwable ex$iv) {
            yc context = getContext();
            dd.a(context, new ya("Exception in invokeOnCancellation handler for " + this, ex$iv));
        }
    }

    public final void i(o7 handler, Throwable cause) {
        try {
            handler.b(cause);
        } catch (Throwable ex$iv) {
            yc context = getContext();
            dd.a(context, new ya("Exception in invokeOnCancellation handler for " + this, ex$iv));
        }
    }

    public final void k(vn<? super Throwable, jt0> onCancellation, Throwable cause) {
        try {
            onCancellation.invoke(cause);
        } catch (Throwable ex) {
            yc context = getContext();
            dd.a(context, new ya("Exception in resume onCancellation handler for " + this, ex));
        }
    }

    public Throwable q(ev parent) {
        return parent.K();
    }

    private final boolean H() {
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

    private final boolean G() {
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

    public final Object r() {
        ev job;
        Throwable th;
        boolean isReusable = x();
        if (H()) {
            if (this.f4973a == null) {
                v();
            }
            if (isReusable) {
                C();
            }
            return ou.d();
        }
        if (isReusable) {
            C();
        }
        Object state = s();
        if (state instanceof va) {
            Throwable exception$iv = ((va) state).f5381a;
            if (af.d()) {
                exception$iv = tm0.j(exception$iv, this);
            }
            throw exception$iv;
        } else if (!wg.b(this.a) || (job = (ev) getContext().get(ev.a)) == null || job.c()) {
            return e(state);
        } else {
            CancellationException cause = job.K();
            a(state, cause);
            if (af.d()) {
                th = tm0.j(cause, this);
            } else {
                th = cause;
            }
            throw th;
        }
    }

    private final ah v() {
        ev parent = (ev) getContext().get(ev.a);
        if (parent == null) {
            return null;
        }
        ah handle = ev.a.d(parent, true, false, new k8(this), 2, (Object) null);
        this.f4973a = handle;
        return handle;
    }

    private final void C() {
        Throwable cancellationCause;
        rc<T> rcVar = this.f4974a;
        sg sgVar = rcVar instanceof sg ? (sg) rcVar : null;
        if (sgVar != null && (cancellationCause = sgVar.m(this)) != null) {
            n();
            l(cancellationCause);
        }
    }

    public void resumeWith(Object result) {
        E(this, za.b(result, this), this.a, (vn) null, 4, (Object) null);
    }

    public void b(vn<? super Throwable, jt0> handler) {
        o7 cancelHandler = y(handler);
        while (true) {
            Object state = this._state;
            if (state instanceof l0) {
                if (w.a(f4972a, this, state, cancelHandler)) {
                    return;
                }
            } else if (state instanceof o7) {
                z(handler, state);
            } else if (state instanceof va) {
                if (!((va) state).b()) {
                    z(handler, state);
                }
                if (state instanceof u7) {
                    Throwable th = null;
                    va vaVar = state instanceof va ? (va) state : null;
                    if (vaVar != null) {
                        th = vaVar.f5381a;
                    }
                    j(handler, th);
                    return;
                }
                return;
            } else if (state instanceof ta) {
                if (((ta) state).f5094a != null) {
                    z(handler, state);
                }
                if (((ta) state).c()) {
                    j(handler, ((ta) state).f5093a);
                    return;
                } else {
                    if (w.a(f4972a, this, state, ta.b((ta) state, (Object) null, cancelHandler, (vn) null, (Object) null, (Throwable) null, 29, (Object) null))) {
                        return;
                    }
                }
            } else {
                if (w.a(f4972a, this, state, new ta(state, cancelHandler, (vn) null, (Object) null, (Throwable) null, 28, (Cif) null))) {
                    return;
                }
            }
        }
    }

    private final void z(vn<? super Throwable, jt0> handler, Object state) {
        throw new IllegalStateException(("It's prohibited to register multiple handlers, tried to register " + handler + ", already has " + state).toString());
    }

    private final o7 y(vn<? super Throwable, jt0> handler) {
        return handler instanceof o7 ? (o7) handler : new uu(handler);
    }

    private final void p(int mode) {
        if (!G()) {
            wg.a(this, mode);
        }
    }

    private final Object F(n30 state, Object proposedUpdate, int resumeMode, vn<? super Throwable, jt0> onCancellation, Object idempotent) {
        if (proposedUpdate instanceof va) {
            boolean z = true;
            if (af.a()) {
                if ((idempotent == null ? 1 : 0) == 0) {
                    throw new AssertionError();
                }
            }
            if (af.a()) {
                if (onCancellation != null) {
                    z = false;
                }
                if (!z) {
                    throw new AssertionError();
                }
            }
        } else if ((wg.b(resumeMode) || idempotent != null) && !(onCancellation == null && !(state instanceof o7) && idempotent == null)) {
            return new ta(proposedUpdate, state instanceof o7 ? (o7) state : null, onCancellation, idempotent, (Throwable) null, 16, (Cif) null);
        }
        return proposedUpdate;
    }

    static /* synthetic */ void E(s7 s7Var, Object obj, int i, vn vnVar, int i2, Object obj2) {
        if (obj2 == null) {
            if ((i2 & 4) != 0) {
                vnVar = null;
            }
            s7Var.D(obj, i, vnVar);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: resumeImpl");
    }

    private final void D(Object proposedUpdate, int resumeMode, vn<? super Throwable, jt0> onCancellation) {
        Object state;
        do {
            state = this._state;
            if (state instanceof n30) {
            } else if (!(state instanceof u7) || !((u7) state).c()) {
                h(proposedUpdate);
                throw new jw();
            } else if (onCancellation != null) {
                k(onCancellation, ((u7) state).f5381a);
                return;
            } else {
                return;
            }
        } while (!w.a(f4972a, this, state, F((n30) state, proposedUpdate, resumeMode, onCancellation, (Object) null)));
        o();
        p(resumeMode);
    }

    private final Void h(Object proposedUpdate) {
        throw new IllegalStateException(("Already resumed, but proposed with update " + proposedUpdate).toString());
    }

    private final void o() {
        if (!x()) {
            n();
        }
    }

    public final void n() {
        ah handle = this.f4973a;
        if (handle != null) {
            handle.dispose();
            this.f4973a = l30.a;
        }
    }

    public <T> T e(Object state) {
        if (state instanceof ta) {
            return ((ta) state).a;
        }
        return state;
    }

    public Throwable d(Object state) {
        Throwable it = super.d(state);
        if (it == null) {
            return null;
        }
        rc<T> rcVar = this.f4974a;
        if (!af.d() || !(rcVar instanceof id)) {
            return it;
        }
        return tm0.j(it, (id) rcVar);
    }

    public String toString() {
        return A() + '(' + ef.c(this.f4974a) + "){" + t() + "}@" + ef.b(this);
    }

    /* access modifiers changed from: protected */
    public String A() {
        return "CancellableContinuation";
    }
}
