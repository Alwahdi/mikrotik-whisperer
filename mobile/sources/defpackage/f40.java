package defpackage;

import java.util.Arrays;

/* renamed from: f40  reason: default package */
public abstract class f40 extends hk {
    public static boolean a(Object a, Object b) {
        return a == b || (a != null && a.equals(b));
    }

    public static int b(Object... objects) {
        return Arrays.hashCode(objects);
    }
}
