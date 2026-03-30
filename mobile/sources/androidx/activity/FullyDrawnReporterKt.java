package androidx.activity;

public final class FullyDrawnReporterKt {
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0056, code lost:
        defpackage.ps.b(1);
        r6.removeReporter();
        defpackage.ps.a(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0062, code lost:
        return defpackage.jt0.a;
     */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x002d  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object reportWhenComplete(androidx.activity.FullyDrawnReporter r5, defpackage.vn<? super defpackage.rc<? super defpackage.jt0>, ? extends java.lang.Object> r6, defpackage.rc<? super defpackage.jt0> r7) {
        /*
            boolean r0 = r7 instanceof androidx.activity.FullyDrawnReporterKt$reportWhenComplete$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            androidx.activity.FullyDrawnReporterKt$reportWhenComplete$1 r0 = (androidx.activity.FullyDrawnReporterKt$reportWhenComplete$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            androidx.activity.FullyDrawnReporterKt$reportWhenComplete$1 r0 = new androidx.activity.FullyDrawnReporterKt$reportWhenComplete$1
            r0.<init>(r7)
        L_0x0018:
            r7 = r0
            java.lang.Object r0 = r7.result
            java.lang.Object r1 = defpackage.ou.d()
            int r2 = r7.label
            r3 = 1
            switch(r2) {
                case 0: goto L_0x0038;
                case 1: goto L_0x002d;
                default: goto L_0x0025;
            }
        L_0x0025:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x002d:
            r5 = 0
            java.lang.Object r6 = r7.L$0
            androidx.activity.FullyDrawnReporter r6 = (androidx.activity.FullyDrawnReporter) r6
            defpackage.te0.b(r0)     // Catch:{ all -> 0x0036 }
            goto L_0x0056
        L_0x0036:
            r1 = move-exception
            goto L_0x0066
        L_0x0038:
            defpackage.te0.b(r0)
            r2 = 0
            r5.addReporter()
            boolean r4 = r5.isFullyDrawnReported()
            if (r4 == 0) goto L_0x0048
            jt0 r6 = defpackage.jt0.a
            return r6
        L_0x0048:
            r7.L$0 = r5     // Catch:{ all -> 0x0063 }
            r7.label = r3     // Catch:{ all -> 0x0063 }
            java.lang.Object r4 = r6.invoke(r7)     // Catch:{ all -> 0x0063 }
            if (r4 != r1) goto L_0x0054
            return r1
        L_0x0054:
            r6 = r5
            r5 = r2
        L_0x0056:
            defpackage.ps.b(r3)
            r6.removeReporter()
            defpackage.ps.a(r3)
            jt0 r1 = defpackage.jt0.a
            return r1
        L_0x0063:
            r1 = move-exception
            r6 = r5
            r5 = r2
        L_0x0066:
            defpackage.ps.b(r3)
            r6.removeReporter()
            defpackage.ps.a(r3)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.activity.FullyDrawnReporterKt.reportWhenComplete(androidx.activity.FullyDrawnReporter, vn, rc):java.lang.Object");
    }

    /* JADX INFO: finally extract failed */
    private static final Object reportWhenComplete$$forInline(FullyDrawnReporter $this$reportWhenComplete, vn<? super rc<? super jt0>, ? extends Object> reporter, rc<? super jt0> $completion) {
        $this$reportWhenComplete.addReporter();
        if ($this$reportWhenComplete.isFullyDrawnReported()) {
            return jt0.a;
        }
        try {
            reporter.invoke($completion);
            ps.b(1);
            $this$reportWhenComplete.removeReporter();
            ps.a(1);
            return jt0.a;
        } catch (Throwable th) {
            ps.b(1);
            $this$reportWhenComplete.removeReporter();
            ps.a(1);
            throw th;
        }
    }
}
