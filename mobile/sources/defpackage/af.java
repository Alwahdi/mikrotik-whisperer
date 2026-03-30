package defpackage;

import java.util.concurrent.atomic.AtomicLong;

/* renamed from: af  reason: default package */
public abstract class af {
    private static final AtomicLong a = new AtomicLong(0);

    /* renamed from: a  reason: collision with other field name */
    private static final boolean f59a = false;
    private static final boolean b;
    private static final boolean c;

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002e, code lost:
        if (r1.equals("on") != false) goto L_0x0039;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0037, code lost:
        if (r1.equals("") != false) goto L_0x0039;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0039, code lost:
        r4 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x005a, code lost:
        throw new java.lang.IllegalStateException(("System property 'kotlinx.coroutines.debug' has unrecognized value '" + r1 + '\'').toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x001b, code lost:
        if (r1.equals("auto") != false) goto L_0x005b;
     */
    static {
        /*
            r0 = 0
            f59a = r0
            java.lang.String r1 = "kotlinx.coroutines.debug"
            java.lang.String r1 = defpackage.zo0.d(r1)
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L_0x005b
            int r4 = r1.hashCode()
            switch(r4) {
                case 0: goto L_0x0031;
                case 3551: goto L_0x0028;
                case 109935: goto L_0x001e;
                case 3005871: goto L_0x0015;
                default: goto L_0x0014;
            }
        L_0x0014:
            goto L_0x003b
        L_0x0015:
            java.lang.String r4 = "auto"
            boolean r4 = r1.equals(r4)
            if (r4 == 0) goto L_0x0014
            goto L_0x005b
        L_0x001e:
            java.lang.String r4 = "off"
            boolean r4 = r1.equals(r4)
            if (r4 == 0) goto L_0x0014
            r4 = 0
            goto L_0x005c
        L_0x0028:
            java.lang.String r4 = "on"
            boolean r4 = r1.equals(r4)
            if (r4 == 0) goto L_0x0014
            goto L_0x0039
        L_0x0031:
            java.lang.String r4 = ""
            boolean r4 = r1.equals(r4)
            if (r4 == 0) goto L_0x0014
        L_0x0039:
            r4 = 1
            goto L_0x005c
        L_0x003b:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "System property 'kotlinx.coroutines.debug' has unrecognized value '"
            r3.append(r4)
            r3.append(r1)
            r4 = 39
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            java.lang.String r3 = r3.toString()
            r0.<init>(r3)
            throw r0
        L_0x005b:
            r4 = 0
        L_0x005c:
            b = r4
            if (r4 == 0) goto L_0x006a
            java.lang.String r1 = "kotlinx.coroutines.stacktrace.recovery"
            boolean r1 = defpackage.zo0.e(r1, r3)
            if (r1 == 0) goto L_0x006a
            r0 = 1
        L_0x006a:
            c = r0
            java.util.concurrent.atomic.AtomicLong r0 = new java.util.concurrent.atomic.AtomicLong
            r1 = 0
            r0.<init>(r1)
            a = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.af.<clinit>():void");
    }

    public static final boolean a() {
        return f59a;
    }

    public static final boolean c() {
        return b;
    }

    public static final boolean d() {
        return c;
    }

    public static final AtomicLong b() {
        return a;
    }
}
