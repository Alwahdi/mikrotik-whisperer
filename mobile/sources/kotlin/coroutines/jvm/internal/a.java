package kotlin.coroutines.jvm.internal;

import java.io.Serializable;

public abstract class a implements rc<Object>, id, Serializable {
    private final rc<Object> completion;

    /* access modifiers changed from: protected */
    public abstract Object invokeSuspend(Object obj);

    public a(rc<Object> completion2) {
        this.completion = completion2;
    }

    public final rc<Object> getCompletion() {
        return this.completion;
    }

    /* JADX WARNING: type inference failed for: r4v0, types: [rc, rc<java.lang.Object>, java.lang.Object] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void resumeWith(java.lang.Object r8) {
        /*
            r7 = this;
            r0 = 0
            r0 = r7
            r1 = 0
            r1 = r8
        L_0x0004:
            defpackage.df.b(r0)
            r2 = r0
            kotlin.coroutines.jvm.internal.a r2 = (kotlin.coroutines.jvm.internal.a) r2
            r3 = 0
            rc<java.lang.Object> r4 = r2.completion
            defpackage.lu.c(r4)
            java.lang.Object r5 = r2.invokeSuspend(r1)     // Catch:{ all -> 0x0024 }
            java.lang.Object r6 = defpackage.ou.d()     // Catch:{ all -> 0x0024 }
            if (r5 != r6) goto L_0x001d
            return
        L_0x001d:
            se0$a r6 = defpackage.se0.a     // Catch:{ all -> 0x0024 }
            java.lang.Object r6 = defpackage.se0.a(r5)     // Catch:{ all -> 0x0024 }
            goto L_0x002f
        L_0x0024:
            r5 = move-exception
            se0$a r6 = defpackage.se0.a
            java.lang.Object r6 = defpackage.te0.a(r5)
            java.lang.Object r6 = defpackage.se0.a(r6)
        L_0x002f:
            r5 = r6
            r2.releaseIntercepted()
            boolean r6 = r4 instanceof kotlin.coroutines.jvm.internal.a
            if (r6 == 0) goto L_0x003c
            r0 = r4
            r1 = r5
            goto L_0x0004
        L_0x003c:
            r4.resumeWith(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.coroutines.jvm.internal.a.resumeWith(java.lang.Object):void");
    }

    /* access modifiers changed from: protected */
    public void releaseIntercepted() {
    }

    public rc<jt0> create(rc<?> completion2) {
        lu.f(completion2, "completion");
        throw new UnsupportedOperationException("create(Continuation) has not been overridden");
    }

    public rc<jt0> create(Object value, rc<?> completion2) {
        lu.f(completion2, "completion");
        throw new UnsupportedOperationException("create(Any?;Continuation) has not been overridden");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Continuation at ");
        Object stackTraceElement = getStackTraceElement();
        if (stackTraceElement == null) {
            stackTraceElement = getClass().getName();
        }
        sb.append(stackTraceElement);
        return sb.toString();
    }

    public id getCallerFrame() {
        rc<Object> rcVar = this.completion;
        if (rcVar instanceof id) {
            return (id) rcVar;
        }
        return null;
    }

    public StackTraceElement getStackTraceElement() {
        return cf.d(this);
    }
}
