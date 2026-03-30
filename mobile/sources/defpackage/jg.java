package defpackage;

import android.content.Context;

/* renamed from: jg  reason: default package */
public abstract class jg {
    private static Boolean a;
    private static Boolean b;
    private static Boolean c;

    public static boolean b(Context context) {
        if (a == null) {
            a = Boolean.valueOf(n90.e() && context.getPackageManager().hasSystemFeature("android.hardware.type.watch"));
        }
        return a.booleanValue();
    }

    public static boolean c(Context context) {
        if (!b(context)) {
            return false;
        }
        if (n90.g()) {
            return a(context) && !n90.h();
        }
        return true;
    }

    public static boolean a(Context context) {
        if (b == null) {
            b = Boolean.valueOf(n90.f() && context.getPackageManager().hasSystemFeature("cn.google"));
        }
        return b.booleanValue();
    }

    public static boolean d(Context context) {
        if (c == null) {
            c = Boolean.valueOf(context.getPackageManager().hasSystemFeature("android.hardware.type.iot") || context.getPackageManager().hasSystemFeature("android.hardware.type.embedded"));
        }
        return c.booleanValue();
    }
}
