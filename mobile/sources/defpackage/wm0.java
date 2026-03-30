package defpackage;

/* renamed from: wm0  reason: default package */
final class wm0<T> extends y<ym0> implements t20<T> {
    private volatile /* synthetic */ Object _state;
    private int a;

    public wm0(Object initialState) {
        this._state = initialState;
    }

    public void a(T value) {
        c((Object) null, value == null ? o30.a : value);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0036, code lost:
        r2 = (defpackage.ym0[]) r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x003a, code lost:
        if (r2 == null) goto L_0x004f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x003c, code lost:
        r4 = r2.length;
        r6 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x003f, code lost:
        if (r6 >= r4) goto L_0x004f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0041, code lost:
        r9 = r2[r6];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0045, code lost:
        if (r9 == null) goto L_0x004a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0047, code lost:
        r9.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x004a, code lost:
        r6 = r6 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0050, code lost:
        monitor-enter(r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
        r4 = r11.a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0054, code lost:
        if (r4 != r0) goto L_0x005d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0056, code lost:
        r11.a = r0 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x005b, code lost:
        monitor-exit(r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x005c, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x005d, code lost:
        r0 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:?, code lost:
        r1 = b();
        r3 = defpackage.jt0.a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0066, code lost:
        monitor-exit(r11);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean c(java.lang.Object r12, java.lang.Object r13) {
        /*
            r11 = this;
            r0 = 0
            r1 = 0
            z[] r1 = r11.b()
            r2 = 0
            monitor-enter(r11)
            r3 = 0
            java.lang.Object r4 = r11._state     // Catch:{ all -> 0x0073 }
            r5 = 0
            if (r12 == 0) goto L_0x0016
            boolean r6 = defpackage.lu.a(r4, r12)     // Catch:{ all -> 0x0073 }
            if (r6 != 0) goto L_0x0016
            monitor-exit(r11)
            return r5
        L_0x0016:
            boolean r6 = defpackage.lu.a(r4, r13)     // Catch:{ all -> 0x0073 }
            r7 = 1
            if (r6 == 0) goto L_0x001f
            monitor-exit(r11)
            return r7
        L_0x001f:
            r11._state = r13     // Catch:{ all -> 0x0073 }
            int r6 = r11.a     // Catch:{ all -> 0x0073 }
            r0 = r6
            r6 = r0 & 1
            if (r6 != 0) goto L_0x006c
            int r0 = r0 + 1
            r11.a = r0     // Catch:{ all -> 0x0073 }
            z[] r6 = r11.b()     // Catch:{ all -> 0x0073 }
            r1 = r6
            jt0 r3 = defpackage.jt0.a     // Catch:{ all -> 0x0073 }
            monitor-exit(r11)
        L_0x0036:
            r2 = r1
            ym0[] r2 = (defpackage.ym0[]) r2
            if (r2 == 0) goto L_0x004f
            r3 = 0
            int r4 = r2.length
            r6 = 0
        L_0x003f:
            if (r6 >= r4) goto L_0x004e
            r8 = r2[r6]
            r9 = r8
            r10 = 0
            if (r9 == 0) goto L_0x004a
            r9.a()
        L_0x004a:
            int r6 = r6 + 1
            goto L_0x003f
        L_0x004e:
        L_0x004f:
            r2 = 0
            monitor-enter(r11)
            r3 = 0
            int r4 = r11.a     // Catch:{ all -> 0x0069 }
            if (r4 != r0) goto L_0x005d
            int r4 = r0 + 1
            r11.a = r4     // Catch:{ all -> 0x0069 }
            monitor-exit(r11)
            return r7
        L_0x005d:
            r0 = r4
            z[] r4 = r11.b()     // Catch:{ all -> 0x0069 }
            r1 = r4
            jt0 r3 = defpackage.jt0.a     // Catch:{ all -> 0x0069 }
            monitor-exit(r11)
            goto L_0x0036
        L_0x0069:
            r3 = move-exception
            monitor-exit(r11)
            throw r3
        L_0x006c:
            int r5 = r0 + 2
            r11.a = r5     // Catch:{ all -> 0x0073 }
            monitor-exit(r11)
            return r7
        L_0x0073:
            r3 = move-exception
            monitor-exit(r11)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.wm0.c(java.lang.Object, java.lang.Object):boolean");
    }
}
