package defpackage;

/* renamed from: c20  reason: default package */
final class c20 extends nz implements yf {
    private final String a;

    /* renamed from: a  reason: collision with other field name */
    private final Throwable f282a;

    public c20(Throwable cause, String errorHint) {
        this.f282a = cause;
        this.a = errorHint;
    }

    public nz X() {
        return this;
    }

    public boolean isDispatchNeeded(yc context) {
        a0();
        throw new jw();
    }

    public ad limitedParallelism(int parallelism) {
        a0();
        throw new jw();
    }

    /* renamed from: Z */
    public Void dispatch(yc context, Runnable block) {
        a0();
        throw new jw();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0025, code lost:
        if (r1 == null) goto L_0x0027;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.Void a0() {
        /*
            r5 = this;
            java.lang.Throwable r0 = r5.f282a
            if (r0 == 0) goto L_0x0038
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Module with the Main dispatcher had failed to initialize"
            r0.append(r1)
            java.lang.String r1 = r5.a
            if (r1 == 0) goto L_0x0027
            r2 = 0
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = ". "
            r3.append(r4)
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            if (r1 != 0) goto L_0x0029
        L_0x0027:
            java.lang.String r1 = ""
        L_0x0029:
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.Throwable r2 = r5.f282a
            r1.<init>(r0, r2)
            throw r1
        L_0x0038:
            defpackage.qz.d()
            jw r0 = new jw
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.c20.a0():java.lang.Void");
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("Dispatchers.Main[missing");
        if (this.f282a != null) {
            str = ", cause=" + this.f282a;
        } else {
            str = "";
        }
        sb.append(str);
        sb.append(']');
        return sb.toString();
    }
}
