package defpackage;

import java.lang.reflect.Method;

/* renamed from: k90  reason: default package */
public class k90 {

    /* renamed from: k90$a */
    private static final class a {
        public static final Method a;

        /* renamed from: a  reason: collision with other field name */
        public static final a f4109a = new a();
        public static final Method b;

        private a() {
        }

        /* JADX WARNING: Removed duplicated region for block: B:10:0x0042 A[LOOP:0: B:1:0x0016->B:10:0x0042, LOOP_END] */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x0046 A[EDGE_INSN: B:21:0x0046->B:12:0x0046 ?: BREAK  , SYNTHETIC] */
        static {
            /*
                k90$a r0 = new k90$a
                r0.<init>()
                f4109a = r0
                java.lang.Class<java.lang.Throwable> r0 = java.lang.Throwable.class
                java.lang.reflect.Method[] r1 = r0.getMethods()
                java.lang.String r2 = "throwableMethods"
                defpackage.lu.e(r1, r2)
                int r2 = r1.length
                r3 = 0
                r4 = 0
            L_0x0016:
                r5 = 0
                if (r4 >= r2) goto L_0x0045
                r6 = r1[r4]
                r7 = r6
                r8 = 0
                java.lang.String r9 = r7.getName()
                java.lang.String r10 = "addSuppressed"
                boolean r9 = defpackage.lu.a(r9, r10)
                if (r9 == 0) goto L_0x003e
                java.lang.Class[] r9 = r7.getParameterTypes()
                java.lang.String r10 = "it.parameterTypes"
                defpackage.lu.e(r9, r10)
                java.lang.Object r9 = defpackage.l4.m(r9)
                boolean r9 = defpackage.lu.a(r9, r0)
                if (r9 == 0) goto L_0x003e
                r9 = 1
                goto L_0x003f
            L_0x003e:
                r9 = 0
            L_0x003f:
                if (r9 == 0) goto L_0x0042
                goto L_0x0046
            L_0x0042:
                int r4 = r4 + 1
                goto L_0x0016
            L_0x0045:
                r6 = r5
            L_0x0046:
                a = r6
                int r2 = r1.length
            L_0x0049:
                if (r3 >= r2) goto L_0x0060
                r4 = r1[r3]
                r6 = r4
                r7 = 0
                java.lang.String r8 = r6.getName()
                java.lang.String r9 = "getSuppressed"
                boolean r6 = defpackage.lu.a(r8, r9)
                if (r6 == 0) goto L_0x005d
                r5 = r4
                goto L_0x0060
            L_0x005d:
                int r3 = r3 + 1
                goto L_0x0049
            L_0x0060:
                b = r5
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.k90.a.<clinit>():void");
        }
    }

    public void a(Throwable cause, Throwable exception) {
        lu.f(cause, "cause");
        lu.f(exception, "exception");
        Method method = a.a;
        if (method != null) {
            method.invoke(cause, new Object[]{exception});
        }
    }

    public bd0 b() {
        return new jk();
    }
}
