package defpackage;

/* renamed from: qj0  reason: default package */
public class qj0<T> extends j<T> implements id {
    public final rc<T> a;

    public qj0(yc context, rc<? super T> uCont) {
        super(context, true, true);
        this.a = uCont;
    }

    public final id getCallerFrame() {
        rc<T> rcVar = this.a;
        if (rcVar instanceof id) {
            return (id) rcVar;
        }
        return null;
    }

    public final StackTraceElement getStackTraceElement() {
        return null;
    }

    /* access modifiers changed from: protected */
    public final boolean I() {
        return true;
    }

    /* access modifiers changed from: protected */
    public void h(Object state) {
        tg.c(nu.c(this.a), za.a(state, this.a), (vn) null, 2, (Object) null);
    }

    /* access modifiers changed from: protected */
    public void m0(Object state) {
        rc<T> rcVar = this.a;
        rcVar.resumeWith(za.a(state, rcVar));
    }
}
