package defpackage;

/* renamed from: et0  reason: default package */
public final class et0<T> extends qj0<T> {
    private ThreadLocal<j50<yc, Object>> a;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public et0(defpackage.yc r3, defpackage.rc<? super T> r4) {
        /*
            r2 = this;
            gt0 r0 = defpackage.gt0.a
            yc$b r1 = r3.get(r0)
            if (r1 != 0) goto L_0x000d
            yc r0 = r3.plus(r0)
            goto L_0x000e
        L_0x000d:
            r0 = r3
        L_0x000e:
            r2.<init>(r0, r4)
            java.lang.ThreadLocal r0 = new java.lang.ThreadLocal
            r0.<init>()
            r2.a = r0
            yc r0 = r4.getContext()
            tc$b r1 = defpackage.tc.a
            yc$b r0 = r0.get(r1)
            boolean r0 = r0 instanceof defpackage.ad
            if (r0 != 0) goto L_0x0032
            r0 = 0
            java.lang.Object r0 = defpackage.xq0.c(r3, r0)
            defpackage.xq0.a(r3, r0)
            r2.r0(r3, r0)
        L_0x0032:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.et0.<init>(yc, rc):void");
    }

    public final void r0(yc context, Object oldValue) {
        this.a.set(ws0.a(context, oldValue));
    }

    public final boolean q0() {
        if (this.a.get() == null) {
            return false;
        }
        this.a.set((Object) null);
        return true;
    }

    /* access modifiers changed from: protected */
    public void m0(Object state) {
        j50 j50 = this.a.get();
        et0 undispatchedCompletion$iv = null;
        if (j50 != null) {
            xq0.a((yc) j50.a(), j50.b());
            this.a.set(undispatchedCompletion$iv);
        }
        Object result = za.a(state, this.a);
        rc continuation$iv = this.a;
        yc context$iv = continuation$iv.getContext();
        Object oldValue$iv = xq0.c(context$iv, (Object) null);
        if (oldValue$iv != xq0.f5753a) {
            undispatchedCompletion$iv = zc.g(continuation$iv, context$iv, oldValue$iv);
        }
        try {
            this.a.resumeWith(result);
            jt0 jt0 = jt0.a;
        } finally {
            if (undispatchedCompletion$iv == null || undispatchedCompletion$iv.q0()) {
                xq0.a(context$iv, oldValue$iv);
            }
        }
    }
}
