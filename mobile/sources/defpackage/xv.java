package defpackage;

/* renamed from: xv  reason: default package */
public abstract class xv {
    public static final <T> Class<T> a(aw<T> $this$java) {
        lu.f($this$java, "<this>");
        Class<?> a = ((t8) $this$java).a();
        lu.d(a, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-java>>");
        return a;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> java.lang.Class<T> b(defpackage.aw<T> r4) {
        /*
            java.lang.String r0 = "<this>"
            defpackage.lu.f(r4, r0)
            r0 = r4
            t8 r0 = (defpackage.t8) r0
            java.lang.Class r0 = r0.a()
            boolean r1 = r0.isPrimitive()
            java.lang.String r2 = "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-javaObjectType>>"
            if (r1 != 0) goto L_0x0018
            defpackage.lu.d(r0, r2)
            return r0
        L_0x0018:
            java.lang.String r1 = r0.getName()
            int r3 = r1.hashCode()
            switch(r3) {
                case -1325958191: goto L_0x0086;
                case 104431: goto L_0x007a;
                case 3039496: goto L_0x006e;
                case 3052374: goto L_0x0062;
                case 3327612: goto L_0x0056;
                case 3625364: goto L_0x004a;
                case 64711720: goto L_0x003e;
                case 97526364: goto L_0x0032;
                case 109413500: goto L_0x0025;
                default: goto L_0x0023;
            }
        L_0x0023:
            goto L_0x0092
        L_0x0025:
            java.lang.String r3 = "short"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x002e
            goto L_0x0023
        L_0x002e:
            java.lang.Class<java.lang.Short> r1 = java.lang.Short.class
            goto L_0x0093
        L_0x0032:
            java.lang.String r3 = "float"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x003b
            goto L_0x0023
        L_0x003b:
            java.lang.Class<java.lang.Float> r1 = java.lang.Float.class
            goto L_0x0093
        L_0x003e:
            java.lang.String r3 = "boolean"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x0047
            goto L_0x0023
        L_0x0047:
            java.lang.Class<java.lang.Boolean> r1 = java.lang.Boolean.class
            goto L_0x0093
        L_0x004a:
            java.lang.String r3 = "void"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x0053
            goto L_0x0023
        L_0x0053:
            java.lang.Class<java.lang.Void> r1 = java.lang.Void.class
            goto L_0x0093
        L_0x0056:
            java.lang.String r3 = "long"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x005f
            goto L_0x0023
        L_0x005f:
            java.lang.Class<java.lang.Long> r1 = java.lang.Long.class
            goto L_0x0093
        L_0x0062:
            java.lang.String r3 = "char"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x006b
            goto L_0x0023
        L_0x006b:
            java.lang.Class<java.lang.Character> r1 = java.lang.Character.class
            goto L_0x0093
        L_0x006e:
            java.lang.String r3 = "byte"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x0077
            goto L_0x0023
        L_0x0077:
            java.lang.Class<java.lang.Byte> r1 = java.lang.Byte.class
            goto L_0x0093
        L_0x007a:
            java.lang.String r3 = "int"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x0083
            goto L_0x0023
        L_0x0083:
            java.lang.Class<java.lang.Integer> r1 = java.lang.Integer.class
            goto L_0x0093
        L_0x0086:
            java.lang.String r3 = "double"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x008f
            goto L_0x0023
        L_0x008f:
            java.lang.Class<java.lang.Double> r1 = java.lang.Double.class
            goto L_0x0093
        L_0x0092:
            r1 = r0
        L_0x0093:
            defpackage.lu.d(r1, r2)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.xv.b(aw):java.lang.Class");
    }

    public static final <T> aw<T> c(Class<T> $this$kotlin) {
        lu.f($this$kotlin, "<this>");
        return xd0.b($this$kotlin);
    }
}
