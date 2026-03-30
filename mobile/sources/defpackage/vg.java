package defpackage;

/* renamed from: vg  reason: default package */
public abstract class vg<T> extends dq0 {
    public int a;

    public abstract void a(Object obj, Throwable th);

    public abstract rc<T> c();

    public abstract Object g();

    public vg(int resumeMode) {
        this.a = resumeMode;
    }

    public <T> T e(Object state) {
        return state;
    }

    public Throwable d(Object state) {
        va vaVar = state instanceof va ? (va) state : null;
        if (vaVar != null) {
            return vaVar.f5381a;
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00d6, code lost:
        if (r11.q0() != false) goto L_0x00d8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00f6, code lost:
        if (r11.q0() != false) goto L_0x00f8;
     */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00d2 A[SYNTHETIC, Splitter:B:46:0x00d2] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00f2 A[SYNTHETIC, Splitter:B:57:0x00f2] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r20 = this;
            r1 = r20
            boolean r0 = defpackage.af.a()
            if (r0 == 0) goto L_0x001a
            r0 = 0
            int r2 = r1.a
            r3 = -1
            if (r2 == r3) goto L_0x0010
            r2 = 1
            goto L_0x0011
        L_0x0010:
            r2 = 0
        L_0x0011:
            if (r2 == 0) goto L_0x0014
            goto L_0x001a
        L_0x0014:
            java.lang.AssertionError r0 = new java.lang.AssertionError
            r0.<init>()
            throw r0
        L_0x001a:
            hq0 r2 = r1.f2814a
            r3 = 0
            rc r0 = r20.c()     // Catch:{ all -> 0x00fd }
            sg r0 = (defpackage.sg) r0     // Catch:{ all -> 0x00fd }
            r4 = r0
            rc<T> r0 = r4.f4984a     // Catch:{ all -> 0x00fd }
            r5 = r0
            java.lang.Object r0 = r4.b     // Catch:{ all -> 0x00fd }
            r6 = r0
            r7 = 0
            yc r0 = r5.getContext()     // Catch:{ all -> 0x00fd }
            r8 = r0
            java.lang.Object r0 = defpackage.xq0.c(r8, r6)     // Catch:{ all -> 0x00fd }
            r9 = r0
            uo0 r0 = defpackage.xq0.f5753a     // Catch:{ all -> 0x00fd }
            r10 = 0
            if (r9 == r0) goto L_0x0040
            et0 r0 = defpackage.zc.g(r5, r8, r9)     // Catch:{ all -> 0x00fd }
            goto L_0x0041
        L_0x0040:
            r0 = r10
        L_0x0041:
            r11 = r0
            r0 = 0
            yc r12 = r5.getContext()     // Catch:{ all -> 0x00ed }
            java.lang.Object r13 = r20.g()     // Catch:{ all -> 0x00ed }
            java.lang.Throwable r14 = r1.d(r13)     // Catch:{ all -> 0x00ed }
            if (r14 != 0) goto L_0x0068
            int r15 = r1.a     // Catch:{ all -> 0x0063 }
            boolean r15 = defpackage.wg.b(r15)     // Catch:{ all -> 0x0063 }
            if (r15 == 0) goto L_0x0068
            ev$b r10 = defpackage.ev.a     // Catch:{ all -> 0x0063 }
            yc$b r10 = r12.get(r10)     // Catch:{ all -> 0x0063 }
            ev r10 = (defpackage.ev) r10     // Catch:{ all -> 0x0063 }
            goto L_0x0068
        L_0x0063:
            r0 = move-exception
            r16 = r4
            goto L_0x00f0
        L_0x0068:
            if (r10 == 0) goto L_0x00ac
            boolean r15 = r10.c()     // Catch:{ all -> 0x00ed }
            if (r15 != 0) goto L_0x00ac
            java.util.concurrent.CancellationException r15 = r10.K()     // Catch:{ all -> 0x00ed }
            r1.a(r13, r15)     // Catch:{ all -> 0x00ed }
            r16 = r5
            r17 = 0
            se0$a r18 = defpackage.se0.a     // Catch:{ all -> 0x00ed }
            r18 = 0
            boolean r19 = defpackage.af.d()     // Catch:{ all -> 0x00ed }
            if (r19 == 0) goto L_0x0098
            r19 = r0
            r0 = r16
            r16 = r4
            boolean r4 = r0 instanceof defpackage.id     // Catch:{ all -> 0x00eb }
            if (r4 != 0) goto L_0x0090
            goto L_0x009e
        L_0x0090:
            r4 = r0
            id r4 = (defpackage.id) r4     // Catch:{ all -> 0x00eb }
            java.lang.Throwable r4 = defpackage.tm0.j(r15, r4)     // Catch:{ all -> 0x00eb }
            goto L_0x009f
        L_0x0098:
            r19 = r0
            r0 = r16
            r16 = r4
        L_0x009e:
            r4 = r15
        L_0x009f:
            java.lang.Object r4 = defpackage.te0.a(r4)     // Catch:{ all -> 0x00eb }
            java.lang.Object r4 = defpackage.se0.a(r4)     // Catch:{ all -> 0x00eb }
            r0.resumeWith(r4)     // Catch:{ all -> 0x00eb }
            goto L_0x00cd
        L_0x00ac:
            r19 = r0
            r16 = r4
            if (r14 == 0) goto L_0x00c0
            se0$a r0 = defpackage.se0.a     // Catch:{ all -> 0x00eb }
            java.lang.Object r0 = defpackage.te0.a(r14)     // Catch:{ all -> 0x00eb }
            java.lang.Object r0 = defpackage.se0.a(r0)     // Catch:{ all -> 0x00eb }
            r5.resumeWith(r0)     // Catch:{ all -> 0x00eb }
            goto L_0x00cd
        L_0x00c0:
            se0$a r0 = defpackage.se0.a     // Catch:{ all -> 0x00eb }
            java.lang.Object r0 = r1.e(r13)     // Catch:{ all -> 0x00eb }
            java.lang.Object r0 = defpackage.se0.a(r0)     // Catch:{ all -> 0x00eb }
            r5.resumeWith(r0)     // Catch:{ all -> 0x00eb }
        L_0x00cd:
            jt0 r0 = defpackage.jt0.a     // Catch:{ all -> 0x00eb }
            if (r11 == 0) goto L_0x00d8
            boolean r4 = r11.q0()     // Catch:{ all -> 0x00fd }
            if (r4 == 0) goto L_0x00db
        L_0x00d8:
            defpackage.xq0.a(r8, r9)     // Catch:{ all -> 0x00fd }
        L_0x00db:
            se0$a r4 = defpackage.se0.a     // Catch:{ all -> 0x00e9 }
            r4 = r20
            r5 = 0
            r2.a()     // Catch:{ all -> 0x00e9 }
            java.lang.Object r0 = defpackage.se0.a(r0)     // Catch:{ all -> 0x00e9 }
            goto L_0x0119
        L_0x00e9:
            r0 = move-exception
            goto L_0x010f
        L_0x00eb:
            r0 = move-exception
            goto L_0x00f0
        L_0x00ed:
            r0 = move-exception
            r16 = r4
        L_0x00f0:
            if (r11 == 0) goto L_0x00f8
            boolean r4 = r11.q0()     // Catch:{ all -> 0x00fd }
            if (r4 == 0) goto L_0x00fb
        L_0x00f8:
            defpackage.xq0.a(r8, r9)     // Catch:{ all -> 0x00fd }
        L_0x00fb:
            throw r0     // Catch:{ all -> 0x00fd }
        L_0x00fd:
            r0 = move-exception
            r3 = r0
            se0$a r0 = defpackage.se0.a     // Catch:{ all -> 0x010e }
            r0 = r20
            r4 = 0
            r2.a()     // Catch:{ all -> 0x010e }
            jt0 r0 = defpackage.jt0.a     // Catch:{ all -> 0x010e }
            java.lang.Object r0 = defpackage.se0.a(r0)     // Catch:{ all -> 0x010e }
            goto L_0x0119
        L_0x010e:
            r0 = move-exception
        L_0x010f:
            se0$a r4 = defpackage.se0.a
            java.lang.Object r0 = defpackage.te0.a(r0)
            java.lang.Object r0 = defpackage.se0.a(r0)
        L_0x0119:
            java.lang.Throwable r4 = defpackage.se0.b(r0)
            r1.f(r3, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.vg.run():void");
    }

    public final void f(Throwable exception, Throwable finallyException) {
        if (exception != null || finallyException != null) {
            if (!(exception == null || finallyException == null)) {
                rj.a(exception, finallyException);
            }
            Throwable cause = exception == null ? finallyException : exception;
            lu.c(cause);
            dd.a(c().getContext(), new jd("Fatal exception in coroutines machinery for " + this + ". Please read KDoc to 'handleFatalException' method and report this incident to maintainers", cause));
        }
    }
}
