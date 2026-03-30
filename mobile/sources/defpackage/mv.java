package defpackage;

import defpackage.ev;
import defpackage.yc;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlinx.coroutines.internal.b;

/* renamed from: mv  reason: default package */
public class mv implements ev, n8, m50 {
    private static final /* synthetic */ AtomicReferenceFieldUpdater a = AtomicReferenceFieldUpdater.newUpdater(mv.class, Object.class, "_state");
    private volatile /* synthetic */ Object _parentHandle;
    private volatile /* synthetic */ Object _state;

    public mv(boolean active) {
        this._state = active ? nv.b : nv.a;
        this._parentHandle = null;
    }

    public <R> R fold(R initial, jo<? super R, ? super yc.b, ? extends R> operation) {
        return ev.a.b(this, initial, operation);
    }

    public <E extends yc.b> E get(yc.c<E> key) {
        return ev.a.c(this, key);
    }

    public yc minusKey(yc.c<?> key) {
        return ev.a.e(this, key);
    }

    public yc plus(yc context) {
        return ev.a.f(this, context);
    }

    public final yc.c<?> getKey() {
        return ev.a;
    }

    /* renamed from: mv$c */
    public static final class c extends b.a {
        final /* synthetic */ Object a;

        /* renamed from: a  reason: collision with other field name */
        final /* synthetic */ mv f4389a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(kotlinx.coroutines.internal.b $node, mv mvVar, Object obj) {
            super($node);
            this.f4389a = mvVar;
            this.a = obj;
        }

        /* renamed from: i */
        public Object g(kotlinx.coroutines.internal.b affected) {
            if (this.f4389a.D() == this.a) {
                return null;
            }
            return kotlinx.coroutines.internal.a.a();
        }
    }

    public final l8 B() {
        return (l8) this._parentHandle;
    }

    public final void b0(l8 value) {
        this._parentHandle = value;
    }

    /* access modifiers changed from: protected */
    public final void G(ev parent) {
        if (af.a()) {
            if (!(B() == null)) {
                throw new AssertionError();
            }
        }
        if (parent == null) {
            b0(l30.a);
            return;
        }
        parent.P();
        l8 handle = parent.C(this);
        b0(handle);
        if (H()) {
            handle.dispose();
            b0(l30.a);
        }
    }

    public final Object D() {
        while (true) {
            Object state = this._state;
            if (!(state instanceof u40)) {
                return state;
            }
            ((u40) state).c(this);
        }
    }

    public boolean c() {
        Object state = D();
        return (state instanceof gs) && ((gs) state).c();
    }

    public final boolean H() {
        return !(D() instanceof gs);
    }

    private final Object t(b state, Object proposedUpdate) {
        boolean wasCancelling;
        Throwable finalCause;
        boolean handled = true;
        if (af.a()) {
            if ((D() == state ? 1 : 0) == 0) {
                throw new AssertionError();
            }
        }
        if (af.a() && (state.i() ^ 1) == 0) {
            throw new AssertionError();
        } else if (!af.a() || state.h() != 0) {
            va vaVar = proposedUpdate instanceof va ? (va) proposedUpdate : null;
            Throwable proposedException = vaVar != null ? vaVar.f5381a : null;
            synchronized (state) {
                wasCancelling = state.g();
                List exceptions = state.j(proposedException);
                finalCause = x(state, exceptions);
                if (finalCause != null) {
                    g(finalCause, exceptions);
                }
            }
            Throwable finalException = finalCause;
            Object finalState = (finalException == null || finalException == proposedException) ? proposedUpdate : new va(finalException, false, 2, (Cif) null);
            if (finalException != null) {
                if (!l(finalException) && !E(finalException)) {
                    handled = false;
                }
                if (handled) {
                    if (finalState != null) {
                        ((va) finalState).b();
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.CompletedExceptionally");
                    }
                }
            }
            if (!wasCancelling) {
                T(finalException);
            }
            W(finalState);
            boolean casSuccess = w.a(a, this, state, nv.g(finalState));
            if (!af.a() || casSuccess) {
                p(state, finalState);
                return finalState;
            }
            throw new AssertionError();
        } else {
            throw new AssertionError();
        }
    }

    private final Throwable x(b state, List<? extends Throwable> exceptions) {
        T $this$firstOrNull$iv = null;
        if (!exceptions.isEmpty()) {
            Iterator<T> it = exceptions.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                T next = it.next();
                if (!(((Throwable) next) instanceof CancellationException)) {
                    $this$firstOrNull$iv = next;
                    break;
                }
            }
            Throwable firstNonCancellation = (Throwable) $this$firstOrNull$iv;
            if (firstNonCancellation != null) {
                return firstNonCancellation;
            }
            return (Throwable) exceptions.get(0);
        } else if (state.g()) {
            return new fv(m(), (Throwable) null, this);
        } else {
            return null;
        }
    }

    private final void g(Throwable rootCause, List<? extends Throwable> exceptions) {
        if (exceptions.size() > 1) {
            Set seenExceptions = Collections.newSetFromMap(new IdentityHashMap(exceptions.size()));
            Throwable unwrappedCause = !af.d() ? rootCause : tm0.l(rootCause);
            for (Throwable exception : exceptions) {
                Throwable unwrapped = !af.d() ? exception : tm0.l(exception);
                if (unwrapped != rootCause && unwrapped != unwrappedCause && !(unwrapped instanceof CancellationException) && seenExceptions.add(unwrapped)) {
                    rj.a(rootCause, unwrapped);
                }
            }
        }
    }

    private final boolean h0(gs state, Object update) {
        if (af.a()) {
            if ((((state instanceof fi) || (state instanceof lv)) ? 1 : 0) == 0) {
                throw new AssertionError();
            }
        }
        if (af.a() && ((update instanceof va) ^ 1) == 0) {
            throw new AssertionError();
        } else if (!w.a(a, this, state, nv.g(update))) {
            return false;
        } else {
            T((Throwable) null);
            W(update);
            p(state, update);
            return true;
        }
    }

    private final void p(gs state, Object update) {
        l8 it = B();
        if (it != null) {
            it.dispose();
            b0(l30.a);
        }
        Throwable th = null;
        va vaVar = update instanceof va ? (va) update : null;
        if (vaVar != null) {
            th = vaVar.f5381a;
        }
        Throwable cause = th;
        if (state instanceof lv) {
            try {
                ((lv) state).s(cause);
            } catch (Throwable ex) {
                F(new ya("Exception in completion handler " + state + " for " + this, ex));
            }
        } else {
            k30 d = state.d();
            if (d != null) {
                S(d, cause);
            }
        }
    }

    private final void R(k30 list, Throwable cause) {
        Throwable th = cause;
        T(th);
        qy this_$iv$iv = list;
        Throwable $this$notifyHandlers_u24lambda_u2d14_u24lambda_u2d12$iv = null;
        for (kotlinx.coroutines.internal.b cur$iv$iv = (kotlinx.coroutines.internal.b) this_$iv$iv.k(); !lu.a(cur$iv$iv, this_$iv$iv); cur$iv$iv = cur$iv$iv.l()) {
            if (cur$iv$iv instanceof gv) {
                lv node$iv = (lv) cur$iv$iv;
                try {
                    node$iv.s(th);
                } catch (Throwable th2) {
                    Throwable ex$iv = th2;
                    if ($this$notifyHandlers_u24lambda_u2d14_u24lambda_u2d12$iv != null) {
                        rj.a($this$notifyHandlers_u24lambda_u2d14_u24lambda_u2d12$iv, ex$iv);
                    } else {
                        $this$notifyHandlers_u24lambda_u2d14_u24lambda_u2d12$iv = new ya("Exception in completion handler " + node$iv + " for " + this, ex$iv);
                        jt0 jt0 = jt0.a;
                    }
                }
            }
        }
        if ($this$notifyHandlers_u24lambda_u2d14_u24lambda_u2d12$iv != null) {
            F($this$notifyHandlers_u24lambda_u2d14_u24lambda_u2d12$iv);
        }
        l(th);
    }

    private final boolean l(Throwable cause) {
        if (I()) {
            return true;
        }
        boolean isCancellation = cause instanceof CancellationException;
        l8 parent = B();
        if (parent == null || parent == l30.a) {
            return isCancellation;
        }
        if (parent.b(cause) || isCancellation) {
            return true;
        }
        return false;
    }

    private final void S(k30 $this$notifyCompletion, Throwable cause) {
        qy this_$iv$iv = $this$notifyCompletion;
        Throwable $this$notifyHandlers_u24lambda_u2d14_u24lambda_u2d12$iv = null;
        for (kotlinx.coroutines.internal.b cur$iv$iv = (kotlinx.coroutines.internal.b) this_$iv$iv.k(); !lu.a(cur$iv$iv, this_$iv$iv); cur$iv$iv = cur$iv$iv.l()) {
            if (cur$iv$iv instanceof lv) {
                lv node$iv = (lv) cur$iv$iv;
                try {
                    node$iv.s(cause);
                } catch (Throwable th) {
                    Throwable ex$iv = th;
                    if ($this$notifyHandlers_u24lambda_u2d14_u24lambda_u2d12$iv != null) {
                        rj.a($this$notifyHandlers_u24lambda_u2d14_u24lambda_u2d12$iv, ex$iv);
                    } else {
                        $this$notifyHandlers_u24lambda_u2d14_u24lambda_u2d12$iv = new ya("Exception in completion handler " + node$iv + " for " + this, ex$iv);
                        jt0 jt0 = jt0.a;
                    }
                }
            } else {
                Throwable th2 = cause;
            }
        }
        Throwable th3 = cause;
        if ($this$notifyHandlers_u24lambda_u2d14_u24lambda_u2d12$iv != null) {
            F($this$notifyHandlers_u24lambda_u2d14_u24lambda_u2d12$iv);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:1:0x0002 A[LOOP_START] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean P() {
        /*
            r5 = this;
            r0 = r5
            r1 = 0
        L_0x0002:
            java.lang.Object r2 = r0.D()
            r3 = 0
            int r4 = r5.c0(r2)
            switch(r4) {
                case 0: goto L_0x0013;
                case 1: goto L_0x0011;
                default: goto L_0x000f;
            }
        L_0x000f:
            goto L_0x0002
        L_0x0011:
            r4 = 1
            return r4
        L_0x0013:
            r4 = 0
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.mv.P():boolean");
    }

    private final int c0(Object state) {
        if (state instanceof fi) {
            if (((fi) state).c()) {
                return 0;
            }
            if (!w.a(a, this, state, nv.b)) {
                return -1;
            }
            X();
            return 1;
        } else if (!(state instanceof fs)) {
            return 0;
        } else {
            if (!w.a(a, this, state, ((fs) state).d())) {
                return -1;
            }
            X();
            return 1;
        }
    }

    /* access modifiers changed from: protected */
    public void X() {
    }

    public final CancellationException K() {
        Object state = D();
        if (state instanceof b) {
            Throwable f = ((b) state).f();
            if (f != null) {
                CancellationException e0 = e0(f, ef.a(this) + " is cancelling");
                if (e0 != null) {
                    return e0;
                }
            }
            throw new IllegalStateException(("Job is still new or active: " + this).toString());
        } else if (state instanceof gs) {
            throw new IllegalStateException(("Job is still new or active: " + this).toString());
        } else if (state instanceof va) {
            return f0(this, ((va) state).f5381a, (String) null, 1, (Object) null);
        } else {
            return new fv(ef.a(this) + " has completed normally", (Throwable) null, this);
        }
    }

    public static /* synthetic */ CancellationException f0(mv mvVar, Throwable th, String str, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                str = null;
            }
            return mvVar.e0(th, str);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toCancellationException");
    }

    /* access modifiers changed from: protected */
    public final CancellationException e0(Throwable $this$toCancellationException, String message) {
        CancellationException cancellationException = $this$toCancellationException instanceof CancellationException ? (CancellationException) $this$toCancellationException : null;
        if (cancellationException != null) {
            return cancellationException;
        }
        return new fv(message == null ? m() : message, $this$toCancellationException, this);
    }

    public final ah J(boolean onCancelling, boolean invokeImmediately, vn<? super Throwable, jt0> handler) {
        boolean z = onCancelling;
        lv node = N(handler, z);
        while (true) {
            Object state = D();
            if (state instanceof fi) {
                if (!((fi) state).c()) {
                    Y((fi) state);
                } else if (w.a(a, this, state, node)) {
                    return node;
                }
            } else if (state instanceof gs) {
                k30 list = ((gs) state).d();
                if (list != null) {
                    Object rootCause = null;
                    ah ahVar = l30.a;
                    if (z && (state instanceof b)) {
                        synchronized (state) {
                            rootCause = ((b) state).f();
                            if (rootCause == null || ((handler instanceof m8) && !((b) state).h())) {
                                if (e(state, list, node)) {
                                    if (rootCause == null) {
                                        return node;
                                    }
                                    ahVar = node;
                                }
                            }
                            jt0 jt0 = jt0.a;
                        }
                    }
                    if (rootCause != null) {
                        if (invokeImmediately) {
                            handler.invoke(rootCause);
                        }
                        return ahVar;
                    } else if (e(state, list, node)) {
                        return node;
                    }
                } else if (state != null) {
                    Z((lv) state);
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.JobNode");
                }
            } else {
                if (invokeImmediately) {
                    Throwable cause$iv = null;
                    va vaVar = state instanceof va ? (va) state : null;
                    if (vaVar != null) {
                        cause$iv = vaVar.f5381a;
                    }
                    handler.invoke(cause$iv);
                }
                return l30.a;
            }
        }
    }

    private final lv N(vn<? super Throwable, jt0> handler, boolean onCancelling) {
        lv node = null;
        if (onCancelling) {
            if (handler instanceof gv) {
                node = (gv) handler;
            }
            if (node == null) {
                node = new vu(handler);
            }
        } else {
            if (handler instanceof lv) {
                node = (lv) handler;
            }
            if (node != null) {
                lv it = node;
                if (af.a() && ((it instanceof gv) ^ 1) == 0) {
                    throw new AssertionError();
                }
            } else {
                node = new wu(handler);
            }
        }
        node.u(this);
        return node;
    }

    /* JADX WARNING: Removed duplicated region for block: B:1:0x000b A[LOOP_START] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean e(java.lang.Object r6, defpackage.k30 r7, defpackage.lv r8) {
        /*
            r5 = this;
            r0 = r7
            r1 = 0
            r2 = r0
            r3 = 0
            mv$c r4 = new mv$c
            r4.<init>(r8, r5, r6)
            r2 = r4
        L_0x000b:
            kotlinx.coroutines.internal.b r3 = r0.m()
            int r4 = r3.r(r8, r0, r2)
            switch(r4) {
                case 1: goto L_0x001a;
                case 2: goto L_0x0018;
                default: goto L_0x0017;
            }
        L_0x0017:
            goto L_0x000b
        L_0x0018:
            r4 = 0
            goto L_0x001b
        L_0x001a:
            r4 = 1
        L_0x001b:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.mv.e(java.lang.Object, k30, lv):boolean");
    }

    private final void Y(fi state) {
        k30 list = new k30();
        w.a(a, this, state, state.c() ? list : new fs(list));
    }

    private final void Z(lv state) {
        state.g(new k30());
        w.a(a, this, state, state.l());
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x001f A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:3:0x000d A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a0(defpackage.lv r7) {
        /*
            r6 = this;
            r0 = r6
            r1 = 0
        L_0x0002:
            java.lang.Object r2 = r0.D()
            r3 = 0
            boolean r4 = r2 instanceof defpackage.lv
            if (r4 == 0) goto L_0x001f
            if (r2 == r7) goto L_0x0010
            return
        L_0x0010:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r4 = a
            fi r5 = defpackage.nv.b
            boolean r4 = defpackage.w.a(r4, r6, r2, r5)
            if (r4 == 0) goto L_0x001d
            return
        L_0x001d:
            goto L_0x0002
        L_0x001f:
            boolean r4 = r2 instanceof defpackage.gs
            if (r4 == 0) goto L_0x0030
            r4 = r2
            gs r4 = (defpackage.gs) r4
            k30 r4 = r4.d()
            if (r4 == 0) goto L_0x002f
            r7.o()
        L_0x002f:
            return
        L_0x0030:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.mv.a0(lv):void");
    }

    public boolean z() {
        return false;
    }

    public void o(CancellationException cause) {
        CancellationException cancellationException;
        if (cause == null) {
            cancellationException = new fv(m(), (Throwable) null, this);
        } else {
            cancellationException = cause;
        }
        j(cancellationException);
    }

    /* access modifiers changed from: protected */
    public String m() {
        return "Job was cancelled";
    }

    public void j(Throwable cause) {
        i(cause);
    }

    public final void V(m50 parentJob) {
        i(parentJob);
    }

    public boolean n(Throwable cause) {
        if (cause instanceof CancellationException) {
            return true;
        }
        if (!i(cause) || !y()) {
            return false;
        }
        return true;
    }

    public final boolean i(Object cause) {
        Object finalState = nv.f4466a;
        if (z() && (finalState = k(cause)) == nv.f4467b) {
            return true;
        }
        if (finalState == nv.f4466a) {
            finalState = L(cause);
        }
        if (finalState == nv.f4466a || finalState == nv.f4467b) {
            return true;
        }
        if (finalState == nv.d) {
            return false;
        }
        h(finalState);
        return true;
    }

    private final Object k(Object cause) {
        Object finalState;
        do {
            Object state = D();
            if (!(state instanceof gs) || ((state instanceof b) && ((b) state).h())) {
                return nv.f4466a;
            }
            finalState = j0(state, new va(s(cause), false, 2, (Cif) null));
        } while (finalState == nv.c);
        return finalState;
    }

    public CancellationException w() {
        Throwable rootCause;
        Object state = D();
        CancellationException cancellationException = null;
        if (state instanceof b) {
            rootCause = ((b) state).f();
        } else if (state instanceof va) {
            rootCause = ((va) state).f5381a;
        } else if (!(state instanceof gs)) {
            rootCause = null;
        } else {
            throw new IllegalStateException(("Cannot be cancelling child in this state: " + state).toString());
        }
        if (rootCause instanceof CancellationException) {
            cancellationException = (CancellationException) rootCause;
        }
        if (cancellationException != null) {
            return cancellationException;
        }
        return new fv("Parent job is " + d0(state), rootCause, this);
    }

    private final Throwable s(Object cause) {
        if (cause == null ? true : cause instanceof Throwable) {
            Throwable th = (Throwable) cause;
            if (th == null) {
                return new fv(m(), (Throwable) null, this);
            }
            return th;
        } else if (cause != null) {
            return ((m50) cause).w();
        } else {
            throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.ParentJob");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0052, code lost:
        r5 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0054, code lost:
        if (r5 == null) goto L_0x0062;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0056, code lost:
        R(((defpackage.mv.b) r3).d(), r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0066, code lost:
        return defpackage.nv.a();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.Object L(java.lang.Object r15) {
        /*
            r14 = this;
            r0 = 0
            r1 = r14
            r2 = 0
        L_0x0003:
            java.lang.Object r3 = r1.D()
            r4 = 0
            boolean r5 = r3 instanceof defpackage.mv.b
            r6 = 0
            r7 = 0
            if (r5 == 0) goto L_0x006d
            r5 = 0
            monitor-enter(r3)
            r8 = 0
            r9 = r3
            mv$b r9 = (defpackage.mv.b) r9     // Catch:{ all -> 0x006a }
            boolean r9 = r9.i()     // Catch:{ all -> 0x006a }
            if (r9 == 0) goto L_0x0022
            uo0 r6 = defpackage.nv.d     // Catch:{ all -> 0x006a }
            monitor-exit(r3)
            return r6
        L_0x0022:
            r9 = r3
            mv$b r9 = (defpackage.mv.b) r9     // Catch:{ all -> 0x006a }
            boolean r9 = r9.g()     // Catch:{ all -> 0x006a }
            if (r15 != 0) goto L_0x002d
            if (r9 != 0) goto L_0x0042
        L_0x002d:
            if (r0 != 0) goto L_0x003a
            java.lang.Throwable r10 = r14.s(r15)     // Catch:{ all -> 0x006a }
            r11 = r10
            r12 = 0
            r0 = r11
            r13 = r10
            r10 = r0
            r0 = r13
            goto L_0x003b
        L_0x003a:
            r10 = r0
        L_0x003b:
            r11 = r3
            mv$b r11 = (defpackage.mv.b) r11     // Catch:{ all -> 0x0067 }
            r11.a(r0)     // Catch:{ all -> 0x0067 }
            r0 = r10
        L_0x0042:
            r10 = r3
            mv$b r10 = (defpackage.mv.b) r10     // Catch:{ all -> 0x006a }
            java.lang.Throwable r10 = r10.f()     // Catch:{ all -> 0x006a }
            r11 = r10
            r12 = 0
            if (r9 != 0) goto L_0x004e
            r7 = 1
        L_0x004e:
            if (r7 == 0) goto L_0x0051
            r6 = r10
        L_0x0051:
            monitor-exit(r3)
            r5 = r6
            if (r5 == 0) goto L_0x0062
            r6 = r5
            r7 = 0
            r8 = r3
            mv$b r8 = (defpackage.mv.b) r8
            k30 r8 = r8.d()
            r14.R(r8, r6)
        L_0x0062:
            uo0 r6 = defpackage.nv.f4466a
            return r6
        L_0x0067:
            r6 = move-exception
            r0 = r10
            goto L_0x006b
        L_0x006a:
            r6 = move-exception
        L_0x006b:
            monitor-exit(r3)
            throw r6
        L_0x006d:
            boolean r5 = r3 instanceof defpackage.gs
            if (r5 == 0) goto L_0x00ce
            if (r0 != 0) goto L_0x007e
            java.lang.Throwable r5 = r14.s(r15)
            r8 = r5
            r9 = 0
            r0 = r8
            r13 = r5
            r5 = r0
            r0 = r13
            goto L_0x007f
        L_0x007e:
            r5 = r0
        L_0x007f:
            r8 = r3
            gs r8 = (defpackage.gs) r8
            boolean r8 = r8.c()
            if (r8 == 0) goto L_0x0098
            r6 = r3
            gs r6 = (defpackage.gs) r6
            boolean r6 = r14.i0(r6, r0)
            if (r6 == 0) goto L_0x0096
            uo0 r6 = defpackage.nv.f4466a
            return r6
        L_0x0096:
            goto L_0x00b0
        L_0x0098:
            va r8 = new va
            r9 = 2
            r8.<init>(r0, r7, r9, r6)
            java.lang.Object r6 = r14.j0(r3, r8)
            uo0 r7 = defpackage.nv.f4466a
            if (r6 == r7) goto L_0x00b3
            uo0 r7 = defpackage.nv.c
            if (r6 == r7) goto L_0x00b0
            return r6
        L_0x00b0:
            r0 = r5
            goto L_0x0003
        L_0x00b3:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "Cannot happen in "
            r8.append(r9)
            r8.append(r3)
            java.lang.String r8 = r8.toString()
            java.lang.String r8 = r8.toString()
            r7.<init>(r8)
            throw r7
        L_0x00ce:
            uo0 r5 = defpackage.nv.d
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.mv.L(java.lang.Object):java.lang.Object");
    }

    private final k30 A(gs state) {
        k30 d = state.d();
        if (d != null) {
            return d;
        }
        if (state instanceof fi) {
            return new k30();
        }
        if (state instanceof lv) {
            Z((lv) state);
            return null;
        }
        throw new IllegalStateException(("State should have list: " + state).toString());
    }

    private final boolean i0(gs state, Throwable rootCause) {
        if (af.a() && ((state instanceof b) ^ 1) == 0) {
            throw new AssertionError();
        } else if (!af.a() || state.c() != 0) {
            k30 list = A(state);
            if (list == null) {
                return false;
            }
            if (!w.a(a, this, state, new b(list, false, rootCause))) {
                return false;
            }
            R(list, rootCause);
            return true;
        } else {
            throw new AssertionError();
        }
    }

    public final Object M(Object proposedUpdate) {
        Object finalState;
        do {
            finalState = j0(D(), proposedUpdate);
            if (finalState == nv.f4466a) {
                throw new IllegalStateException("Job " + this + " is already complete or completing, but is being completed with " + proposedUpdate, v(proposedUpdate));
            }
        } while (finalState == nv.c);
        return finalState;
    }

    private final Object j0(Object state, Object proposedUpdate) {
        if (!(state instanceof gs)) {
            return nv.f4466a;
        }
        if ((!(state instanceof fi) && !(state instanceof lv)) || (state instanceof m8) || (proposedUpdate instanceof va)) {
            return k0((gs) state, proposedUpdate);
        }
        if (h0((gs) state, proposedUpdate)) {
            return proposedUpdate;
        }
        return nv.c;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:51:0x008a, code lost:
        r3 = (java.lang.Throwable) r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x008e, code lost:
        if (r2 == null) goto L_0x0094;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0090, code lost:
        R(r0, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0094, code lost:
        r2 = u(r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0098, code lost:
        if (r2 == null) goto L_0x00a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x009e, code lost:
        if (l0(r1, r2, r14) == false) goto L_0x00a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00a2, code lost:
        return defpackage.nv.f4467b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x00a7, code lost:
        return t(r1, r14);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.Object k0(defpackage.gs r13, java.lang.Object r14) {
        /*
            r12 = this;
            k30 r0 = r12.A(r13)
            if (r0 != 0) goto L_0x000b
            uo0 r0 = defpackage.nv.c
            return r0
        L_0x000b:
            boolean r1 = r13 instanceof defpackage.mv.b
            r2 = 0
            if (r1 == 0) goto L_0x0014
            r1 = r13
            mv$b r1 = (defpackage.mv.b) r1
            goto L_0x0015
        L_0x0014:
            r1 = r2
        L_0x0015:
            r3 = 0
            if (r1 != 0) goto L_0x001d
            mv$b r1 = new mv$b
            r1.<init>(r0, r3, r2)
        L_0x001d:
            sd0 r4 = new sd0
            r4.<init>()
            r5 = 0
            monitor-enter(r1)
            r6 = 0
            boolean r7 = r1.h()     // Catch:{ all -> 0x00a8 }
            if (r7 == 0) goto L_0x0031
            uo0 r2 = defpackage.nv.f4466a     // Catch:{ all -> 0x00a8 }
            monitor-exit(r1)
            return r2
        L_0x0031:
            r7 = 1
            r1.k(r7)     // Catch:{ all -> 0x00a8 }
            if (r1 == r13) goto L_0x0045
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r8 = a     // Catch:{ all -> 0x00a8 }
            boolean r8 = defpackage.w.a(r8, r12, r13, r1)     // Catch:{ all -> 0x00a8 }
            if (r8 != 0) goto L_0x0045
            uo0 r2 = defpackage.nv.c     // Catch:{ all -> 0x00a8 }
            monitor-exit(r1)
            return r2
        L_0x0045:
            boolean r8 = defpackage.af.a()     // Catch:{ all -> 0x00a8 }
            if (r8 == 0) goto L_0x005b
            r8 = 0
            boolean r9 = r1.i()     // Catch:{ all -> 0x00a8 }
            r8 = r9 ^ 1
            if (r8 == 0) goto L_0x0055
            goto L_0x005b
        L_0x0055:
            java.lang.AssertionError r2 = new java.lang.AssertionError     // Catch:{ all -> 0x00a8 }
            r2.<init>()     // Catch:{ all -> 0x00a8 }
            throw r2     // Catch:{ all -> 0x00a8 }
        L_0x005b:
            boolean r8 = r1.g()     // Catch:{ all -> 0x00a8 }
            boolean r9 = r14 instanceof defpackage.va     // Catch:{ all -> 0x00a8 }
            if (r9 == 0) goto L_0x0067
            r9 = r14
            va r9 = (defpackage.va) r9     // Catch:{ all -> 0x00a8 }
            goto L_0x0068
        L_0x0067:
            r9 = r2
        L_0x0068:
            if (r9 == 0) goto L_0x0070
            r10 = 0
            java.lang.Throwable r11 = r9.f5381a     // Catch:{ all -> 0x00a8 }
            r1.a(r11)     // Catch:{ all -> 0x00a8 }
        L_0x0070:
            java.lang.Throwable r9 = r1.f()     // Catch:{ all -> 0x00a8 }
            r10 = r9
            r11 = 0
            if (r8 != 0) goto L_0x0079
            r3 = 1
        L_0x0079:
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)     // Catch:{ all -> 0x00a8 }
            boolean r3 = r3.booleanValue()     // Catch:{ all -> 0x00a8 }
            if (r3 == 0) goto L_0x0084
            r2 = r9
        L_0x0084:
            r4.a = r2     // Catch:{ all -> 0x00a8 }
            jt0 r3 = defpackage.jt0.a     // Catch:{ all -> 0x00a8 }
            monitor-exit(r1)
            r3 = r2
            java.lang.Throwable r3 = (java.lang.Throwable) r3
            if (r2 == 0) goto L_0x0094
            r3 = 0
            r12.R(r0, r2)
        L_0x0094:
            m8 r2 = r12.u(r13)
            if (r2 == 0) goto L_0x00a3
            boolean r3 = r12.l0(r1, r2, r14)
            if (r3 == 0) goto L_0x00a3
            uo0 r3 = defpackage.nv.f4467b
            return r3
        L_0x00a3:
            java.lang.Object r3 = r12.t(r1, r14)
            return r3
        L_0x00a8:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.mv.k0(gs, java.lang.Object):java.lang.Object");
    }

    private final Throwable v(Object $this$exceptionOrNull) {
        va vaVar = $this$exceptionOrNull instanceof va ? (va) $this$exceptionOrNull : null;
        if (vaVar != null) {
            return vaVar.f5381a;
        }
        return null;
    }

    private final m8 u(gs state) {
        m8 m8Var = state instanceof m8 ? (m8) state : null;
        if (m8Var != null) {
            return m8Var;
        }
        k30 d = state.d();
        if (d != null) {
            return Q(d);
        }
        return null;
    }

    private final boolean l0(b state, m8 child, Object proposedUpdate) {
        m8 m8Var = child;
        while (ev.a.d(m8Var.a, false, false, new a(this, state, m8Var, proposedUpdate), 1, (Object) null) == l30.a) {
            m8Var = Q(m8Var);
            if (m8Var == null) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: private */
    public final void r(b state, m8 lastChild, Object proposedUpdate) {
        if (af.a()) {
            if (!(D() == state)) {
                throw new AssertionError();
            }
        }
        m8 waitChild = Q(lastChild);
        if (waitChild == null || !l0(state, waitChild, proposedUpdate)) {
            h(t(state, proposedUpdate));
        }
    }

    private final m8 Q(kotlinx.coroutines.internal.b $this$nextChild) {
        kotlinx.coroutines.internal.b cur = $this$nextChild;
        while (cur.n()) {
            cur = cur.m();
        }
        while (true) {
            cur = cur.l();
            if (!cur.n()) {
                if (cur instanceof m8) {
                    return (m8) cur;
                }
                if (cur instanceof k30) {
                    return null;
                }
            }
        }
    }

    public final l8 C(n8 child) {
        return (l8) ev.a.d(this, true, false, new m8(child), 2, (Object) null);
    }

    public void F(Throwable exception) {
        throw exception;
    }

    /* access modifiers changed from: protected */
    public void T(Throwable cause) {
    }

    /* access modifiers changed from: protected */
    public boolean I() {
        return false;
    }

    public boolean y() {
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean E(Throwable exception) {
        return false;
    }

    /* access modifiers changed from: protected */
    public void W(Object state) {
    }

    /* access modifiers changed from: protected */
    public void h(Object state) {
    }

    public String toString() {
        return g0() + '@' + ef.b(this);
    }

    public final String g0() {
        return O() + '{' + d0(D()) + '}';
    }

    public String O() {
        return ef.a(this);
    }

    private final String d0(Object state) {
        if (state instanceof b) {
            if (((b) state).g()) {
                return "Cancelling";
            }
            if (((b) state).h()) {
                return "Completing";
            }
            return "Active";
        } else if (state instanceof gs) {
            if (((gs) state).c()) {
                return "Active";
            }
            return "New";
        } else if (state instanceof va) {
            return "Cancelled";
        } else {
            return "Completed";
        }
    }

    /* renamed from: mv$b */
    private static final class b implements gs {
        private volatile /* synthetic */ Object _exceptionsHolder = null;
        private volatile /* synthetic */ int _isCompleting;
        private volatile /* synthetic */ Object _rootCause;
        private final k30 a;

        public k30 d() {
            return this.a;
        }

        public b(k30 list, boolean isCompleting, Throwable rootCause) {
            this.a = list;
            this._isCompleting = isCompleting;
            this._rootCause = rootCause;
        }

        /* JADX WARNING: type inference failed for: r0v0, types: [int, boolean] */
        public final boolean h() {
            return this._isCompleting;
        }

        public final void k(boolean value) {
            this._isCompleting = value;
        }

        public final Throwable f() {
            return (Throwable) this._rootCause;
        }

        public final void m(Throwable value) {
            this._rootCause = value;
        }

        private final Object e() {
            return this._exceptionsHolder;
        }

        private final void l(Object value) {
            this._exceptionsHolder = value;
        }

        public final boolean i() {
            return e() == nv.e;
        }

        public final boolean g() {
            return f() != null;
        }

        public boolean c() {
            return f() == null;
        }

        public final List<Throwable> j(Throwable proposedException) {
            ArrayList it;
            Object eh = e();
            if (eh == null) {
                it = b();
            } else if (eh instanceof Throwable) {
                it = b();
                it.add(eh);
            } else if (eh instanceof ArrayList) {
                it = (ArrayList) eh;
            } else {
                throw new IllegalStateException(("State is " + eh).toString());
            }
            ArrayList list = it;
            Throwable rootCause = f();
            if (rootCause != null) {
                list.add(0, rootCause);
            }
            if (proposedException != null && !lu.a(proposedException, rootCause)) {
                list.add(proposedException);
            }
            l(nv.e);
            return list;
        }

        public final void a(Throwable exception) {
            Throwable rootCause = f();
            if (rootCause == null) {
                m(exception);
            } else if (exception != rootCause) {
                Object eh = e();
                if (eh == null) {
                    l(exception);
                } else if (eh instanceof Throwable) {
                    if (exception != eh) {
                        ArrayList b = b();
                        ArrayList $this$addExceptionLocked_u24lambda_u2d2 = b;
                        $this$addExceptionLocked_u24lambda_u2d2.add(eh);
                        $this$addExceptionLocked_u24lambda_u2d2.add(exception);
                        l(b);
                    }
                } else if (eh instanceof ArrayList) {
                    ((ArrayList) eh).add(exception);
                } else {
                    throw new IllegalStateException(("State is " + eh).toString());
                }
            }
        }

        private final ArrayList<Throwable> b() {
            return new ArrayList<>(4);
        }

        public String toString() {
            return "Finishing[cancelling=" + g() + ", completing=" + h() + ", rootCause=" + f() + ", exceptions=" + e() + ", list=" + d() + ']';
        }
    }

    /* renamed from: mv$a */
    private static final class a extends lv {
        private final Object a;

        /* renamed from: a  reason: collision with other field name */
        private final m8 f4387a;

        /* renamed from: a  reason: collision with other field name */
        private final b f4388a;
        private final mv b;

        public /* bridge */ /* synthetic */ Object invoke(Object p1) {
            s((Throwable) p1);
            return jt0.a;
        }

        public a(mv parent, b state, m8 child, Object proposedUpdate) {
            this.b = parent;
            this.f4388a = state;
            this.f4387a = child;
            this.a = proposedUpdate;
        }

        public void s(Throwable cause) {
            this.b.r(this.f4388a, this.f4387a, this.a);
        }
    }
}
