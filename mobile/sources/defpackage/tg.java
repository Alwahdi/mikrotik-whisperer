package defpackage;

/* renamed from: tg  reason: default package */
public abstract class tg {
    /* access modifiers changed from: private */
    public static final uo0 a = new uo0("UNDEFINED");
    public static final uo0 b = new uo0("REUSABLE_CLAIMED");

    public static /* synthetic */ void c(rc rcVar, Object obj, vn vnVar, int i, Object obj2) {
        if ((i & 2) != 0) {
            vnVar = null;
        }
        b(rcVar, obj, vnVar);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00dc, code lost:
        if (r17.q0() != false) goto L_0x00de;
     */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00fd A[Catch:{ all -> 0x00e3, all -> 0x010c }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> void b(defpackage.rc<? super T> r22, java.lang.Object r23, defpackage.vn<? super java.lang.Throwable, defpackage.jt0> r24) {
        /*
            r1 = r22
            boolean r0 = r1 instanceof defpackage.sg
            if (r0 == 0) goto L_0x012a
            r2 = r1
            sg r2 = (defpackage.sg) r2
            r3 = 0
            java.lang.Object r4 = defpackage.za.c(r23, r24)
            ad r0 = r2.f4982a
            yc r5 = r2.getContext()
            boolean r0 = r0.isDispatchNeeded(r5)
            r5 = 1
            if (r0 == 0) goto L_0x0030
            r2.f4983a = r4
            r2.a = r5
            ad r0 = r2.f4982a
            yc r5 = r2.getContext()
            r0.dispatch(r5, r2)
            r1 = r23
            r18 = r2
            r19 = r3
            goto L_0x0121
        L_0x0030:
            r0 = 1
            r6 = r2
            r7 = r0
            r8 = 0
            r9 = 0
            boolean r0 = defpackage.af.a()
            if (r0 == 0) goto L_0x003e
            r0 = 0
        L_0x003e:
            ar0 r0 = defpackage.ar0.a
            cj r10 = r0.a()
            boolean r0 = r10.d0()
            if (r0 == 0) goto L_0x005a
            r6.f4983a = r4
            r6.a = r7
            r10.Z(r6)
            r1 = r23
            r18 = r2
            r19 = r3
            goto L_0x0120
        L_0x005a:
            r11 = r6
            r12 = 0
            r10.b0(r5)
            r13 = 0
            r0 = r2
            r14 = 0
            yc r15 = r0.getContext()     // Catch:{ all -> 0x010e }
            ev$b r5 = defpackage.ev.a     // Catch:{ all -> 0x010e }
            yc$b r5 = r15.get(r5)     // Catch:{ all -> 0x010e }
            ev r5 = (defpackage.ev) r5     // Catch:{ all -> 0x010e }
            if (r5 == 0) goto L_0x0096
            boolean r15 = r5.c()     // Catch:{ all -> 0x008d }
            if (r15 != 0) goto L_0x0096
            java.util.concurrent.CancellationException r15 = r5.K()     // Catch:{ all -> 0x008d }
            r0.a(r4, r15)     // Catch:{ all -> 0x008d }
            se0$a r16 = defpackage.se0.a     // Catch:{ all -> 0x008d }
            java.lang.Object r16 = defpackage.te0.a(r15)     // Catch:{ all -> 0x008d }
            java.lang.Object r1 = defpackage.se0.a(r16)     // Catch:{ all -> 0x008d }
            r0.resumeWith(r1)     // Catch:{ all -> 0x008d }
            r1 = 1
            goto L_0x0097
        L_0x008d:
            r0 = move-exception
            r1 = r23
            r18 = r2
            r19 = r3
            goto L_0x0115
        L_0x0096:
            r1 = 0
        L_0x0097:
            if (r1 != 0) goto L_0x00fd
            r1 = r2
            r5 = 0
            rc<T> r0 = r1.f4984a     // Catch:{ all -> 0x010e }
            java.lang.Object r14 = r1.b     // Catch:{ all -> 0x010e }
            r15 = r0
            r16 = 0
            yc r0 = r15.getContext()     // Catch:{ all -> 0x010e }
            r17 = r0
            r18 = r2
            r2 = r17
            java.lang.Object r0 = defpackage.xq0.c(r2, r14)     // Catch:{ all -> 0x00f7 }
            r17 = r0
            uo0 r0 = defpackage.xq0.f5753a     // Catch:{ all -> 0x00f7 }
            r19 = r3
            r3 = r17
            if (r3 == r0) goto L_0x00c3
            et0 r0 = defpackage.zc.g(r15, r2, r3)     // Catch:{ all -> 0x00bf }
            goto L_0x00c4
        L_0x00bf:
            r0 = move-exception
            r1 = r23
            goto L_0x0115
        L_0x00c3:
            r0 = 0
        L_0x00c4:
            r17 = r0
            r0 = 0
            r20 = r0
            rc<T> r0 = r1.f4984a     // Catch:{ all -> 0x00e5 }
            r21 = r1
            r1 = r23
            r0.resumeWith(r1)     // Catch:{ all -> 0x00e3 }
            jt0 r0 = defpackage.jt0.a     // Catch:{ all -> 0x00e3 }
            if (r17 == 0) goto L_0x00de
            boolean r0 = r17.q0()     // Catch:{ all -> 0x010c }
            if (r0 == 0) goto L_0x00e1
        L_0x00de:
            defpackage.xq0.a(r2, r3)     // Catch:{ all -> 0x010c }
        L_0x00e1:
            goto L_0x0103
        L_0x00e3:
            r0 = move-exception
            goto L_0x00ea
        L_0x00e5:
            r0 = move-exception
            r21 = r1
            r1 = r23
        L_0x00ea:
            if (r17 == 0) goto L_0x00f2
            boolean r20 = r17.q0()     // Catch:{ all -> 0x010c }
            if (r20 == 0) goto L_0x00f5
        L_0x00f2:
            defpackage.xq0.a(r2, r3)     // Catch:{ all -> 0x010c }
        L_0x00f5:
            throw r0     // Catch:{ all -> 0x010c }
        L_0x00f7:
            r0 = move-exception
            r1 = r23
            r19 = r3
            goto L_0x0115
        L_0x00fd:
            r1 = r23
            r18 = r2
            r19 = r3
        L_0x0103:
        L_0x0104:
            boolean r0 = r10.f0()     // Catch:{ all -> 0x010c }
            if (r0 != 0) goto L_0x0104
            goto L_0x0119
        L_0x010c:
            r0 = move-exception
            goto L_0x0115
        L_0x010e:
            r0 = move-exception
            r1 = r23
            r18 = r2
            r19 = r3
        L_0x0115:
            r2 = 0
            r11.f(r0, r2)     // Catch:{ all -> 0x0123 }
        L_0x0119:
            r2 = 1
            r10.X(r2)
        L_0x0120:
        L_0x0121:
            goto L_0x012f
        L_0x0123:
            r0 = move-exception
            r2 = r0
            r3 = 1
            r10.X(r3)
            throw r2
        L_0x012a:
            r1 = r23
            r22.resumeWith(r23)
        L_0x012f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.tg.b(rc, java.lang.Object, vn):void");
    }
}
