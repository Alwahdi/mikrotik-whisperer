package defpackage;

import kotlinx.coroutines.a;

/* renamed from: j  reason: default package */
public abstract class j<T> extends mv implements rc<T>, hd {
    private final yc a;

    public j(yc parentContext, boolean initParentJob, boolean active) {
        super(active);
        if (initParentJob) {
            G((ev) parentContext.get(ev.a));
        }
        this.a = parentContext.plus(this);
    }

    public final yc getContext() {
        return this.a;
    }

    public yc getCoroutineContext() {
        return this.a;
    }

    public boolean c() {
        return super.c();
    }

    /* access modifiers changed from: protected */
    public void o0(T value) {
    }

    /* access modifiers changed from: protected */
    public void n0(Throwable cause, boolean handled) {
    }

    /* access modifiers changed from: protected */
    public String m() {
        return ef.a(this) + " was cancelled";
    }

    /* access modifiers changed from: protected */
    public final void W(Object state) {
        if (state instanceof va) {
            n0(((va) state).f5381a, ((va) state).a());
        } else {
            o0(state);
        }
    }

    public final void resumeWith(Object result) {
        Object state = M(za.d(result, (vn) null, 1, (Object) null));
        if (state != nv.f4467b) {
            m0(state);
        }
    }

    /* access modifiers changed from: protected */
    public void m0(Object state) {
        h(state);
    }

    public final void F(Throwable exception) {
        dd.a(this.a, exception);
    }

    public String O() {
        String coroutineName = zc.b(this.a);
        if (coroutineName == null) {
            return super.O();
        }
        return '\"' + coroutineName + "\":" + super.O();
    }

    public final <R> void p0(a start, R receiver, jo<? super R, ? super rc<? super T>, ? extends Object> block) {
        start.invoke(block, receiver, this);
    }
}
