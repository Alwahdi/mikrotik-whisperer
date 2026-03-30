package kotlin.coroutines.jvm.internal;

import defpackage.yc;

public abstract class b extends a {
    private final yc _context;
    private transient rc<Object> intercepted;

    public b(rc<Object> completion, yc _context2) {
        super(completion);
        this._context = _context2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public b(rc<Object> completion) {
        this(completion, completion != null ? completion.getContext() : null);
    }

    public yc getContext() {
        yc ycVar = this._context;
        lu.c(ycVar);
        return ycVar;
    }

    public final rc<Object> intercepted() {
        rc it = this.intercepted;
        if (it == null) {
            tc tcVar = (tc) getContext().get(tc.a);
            if (tcVar == null || (it = tcVar.interceptContinuation(this)) == null) {
                it = this;
            }
            this.intercepted = it;
        }
        return it;
    }

    /* access modifiers changed from: protected */
    public void releaseIntercepted() {
        rc intercepted2 = this.intercepted;
        if (!(intercepted2 == null || intercepted2 == this)) {
            yc.b bVar = getContext().get(tc.a);
            lu.c(bVar);
            ((tc) bVar).releaseInterceptedContinuation(intercepted2);
        }
        this.intercepted = ua.a;
    }
}
