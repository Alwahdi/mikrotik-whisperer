package defpackage;

import defpackage.se0;

/* renamed from: wg  reason: default package */
public abstract class wg {
    public static final boolean b(int $this$isCancellableMode) {
        return $this$isCancellableMode == 1 || $this$isCancellableMode == 2;
    }

    public static final boolean c(int $this$isReusableMode) {
        return $this$isReusableMode == 2;
    }

    public static final <T> void a(vg<? super T> $this$dispatch, int mode) {
        boolean undispatched = true;
        if (af.a()) {
            if ((mode != -1 ? 1 : 0) == 0) {
                throw new AssertionError();
            }
        }
        rc<? super T> c = $this$dispatch.c();
        if (mode != 4) {
            undispatched = false;
        }
        if (undispatched || !(c instanceof sg) || b(mode) != b($this$dispatch.a)) {
            d($this$dispatch, c, undispatched);
            return;
        }
        ad dispatcher = ((sg) c).f4982a;
        yc context = c.getContext();
        if (dispatcher.isDispatchNeeded(context)) {
            dispatcher.dispatch(context, $this$dispatch);
        } else {
            e($this$dispatch);
        }
    }

    public static final <T> void d(vg<? super T> $this$resume, rc<? super T> delegate, boolean undispatched) {
        et0 undispatchedCompletion$iv$iv;
        Object state = $this$resume.g();
        Throwable exception = $this$resume.d(state);
        se0.a aVar = se0.a;
        Object result = se0.a(exception != null ? te0.a(exception) : $this$resume.e(state));
        if (undispatched) {
            sg this_$iv = (sg) delegate;
            rc continuation$iv$iv = this_$iv.f4984a;
            Object countOrElement$iv$iv = this_$iv.b;
            yc context$iv$iv = continuation$iv$iv.getContext();
            Object oldValue$iv$iv = xq0.c(context$iv$iv, countOrElement$iv$iv);
            if (oldValue$iv$iv != xq0.f5753a) {
                undispatchedCompletion$iv$iv = zc.g(continuation$iv$iv, context$iv$iv, oldValue$iv$iv);
            } else {
                undispatchedCompletion$iv$iv = null;
            }
            try {
                this_$iv.f4984a.resumeWith(result);
                jt0 jt0 = jt0.a;
            } finally {
                if (undispatchedCompletion$iv$iv == null || undispatchedCompletion$iv$iv.q0()) {
                    xq0.a(context$iv$iv, oldValue$iv$iv);
                }
            }
        } else {
            delegate.resumeWith(result);
        }
    }

    private static final void e(vg<?> $this$resumeUnconfined) {
        cj eventLoop = ar0.a.a();
        if (eventLoop.d0()) {
            eventLoop.Z($this$resumeUnconfined);
            return;
        }
        vg $this$runUnconfinedEventLoop$iv = $this$resumeUnconfined;
        eventLoop.b0(true);
        try {
            d($this$resumeUnconfined, $this$resumeUnconfined.c(), true);
            do {
            } while (eventLoop.f0());
        } catch (Throwable th) {
            eventLoop.X(true);
            throw th;
        }
        eventLoop.X(true);
    }
}
