package defpackage;

/* renamed from: t81  reason: default package */
public abstract class t81 {
    private static final int a;

    /* renamed from: a  reason: collision with other field name */
    private static final e91 f5092a;

    /* renamed from: t81$a */
    static final class a extends e91 {
        a() {
        }

        public final void a(Throwable th, Throwable th2) {
        }
    }

    public static void b(Throwable th, Throwable th2) {
        f5092a.a(th, th2);
    }

    private static Integer a() {
        try {
            return (Integer) Class.forName("android.os.Build$VERSION").getField("SDK_INT").get((Object) null);
        } catch (Exception e) {
            System.err.println("Failed to retrieve value from android.os.Build$VERSION.SDK_INT due to the following exception.");
            e.printStackTrace(System.err);
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0069  */
    static {
        /*
            r0 = 1
            java.lang.Integer r1 = a()     // Catch:{ all -> 0x002d }
            if (r1 == 0) goto L_0x0016
            int r2 = r1.intValue()     // Catch:{ all -> 0x002b }
            r3 = 19
            if (r2 < r3) goto L_0x0016
            s91 r2 = new s91     // Catch:{ all -> 0x002b }
            r2.<init>()     // Catch:{ all -> 0x002b }
            goto L_0x0064
        L_0x0016:
            java.lang.String r2 = "com.google.devtools.build.android.desugar.runtime.twr_disable_mimic"
            boolean r2 = java.lang.Boolean.getBoolean(r2)     // Catch:{ all -> 0x002b }
            r2 = r2 ^ r0
            if (r2 == 0) goto L_0x0025
            i91 r2 = new i91     // Catch:{ all -> 0x002b }
            r2.<init>()     // Catch:{ all -> 0x002b }
            goto L_0x0064
        L_0x0025:
            t81$a r2 = new t81$a     // Catch:{ all -> 0x002b }
            r2.<init>()     // Catch:{ all -> 0x002b }
            goto L_0x0064
        L_0x002b:
            r2 = move-exception
            goto L_0x002f
        L_0x002d:
            r2 = move-exception
            r1 = 0
        L_0x002f:
            java.io.PrintStream r3 = java.lang.System.err
            java.lang.Class<t81$a> r4 = defpackage.t81.a.class
            java.lang.String r4 = r4.getName()
            java.lang.String r5 = java.lang.String.valueOf(r4)
            int r5 = r5.length()
            int r5 = r5 + 133
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r5)
            java.lang.String r5 = "An error has occurred when initializing the try-with-resources desuguring strategy. The default strategy "
            r6.append(r5)
            r6.append(r4)
            java.lang.String r4 = "will be used. The error is: "
            r6.append(r4)
            java.lang.String r4 = r6.toString()
            r3.println(r4)
            java.io.PrintStream r3 = java.lang.System.err
            r2.printStackTrace(r3)
            t81$a r2 = new t81$a
            r2.<init>()
        L_0x0064:
            f5092a = r2
            if (r1 != 0) goto L_0x0069
            goto L_0x006d
        L_0x0069:
            int r0 = r1.intValue()
        L_0x006d:
            a = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.t81.<clinit>():void");
    }
}
