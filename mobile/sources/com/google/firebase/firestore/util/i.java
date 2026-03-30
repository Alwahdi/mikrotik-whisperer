package com.google.firebase.firestore.util;

import android.util.Log;

public abstract class i {
    private static b a = b.WARN;

    public enum b {
        DEBUG,
        WARN,
        NONE
    }

    public static boolean c() {
        return a.ordinal() >= b.DEBUG.ordinal();
    }

    private static void b(b level, String tag, String toLog, Object... values) {
        if (level.ordinal() >= a.ordinal()) {
            String value = String.format("(%s) [%s]: ", new Object[]{"21.4.0", tag}) + String.format(toLog, values);
            switch (a.a[level.ordinal()]) {
                case 1:
                    Log.i("Firestore", value);
                    return;
                case 2:
                    Log.w("Firestore", value);
                    return;
                case 3:
                    throw new IllegalStateException("Trying to log something on level NONE");
                default:
                    return;
            }
        }
    }

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[b.values().length];
            a = iArr;
            try {
                iArr[b.DEBUG.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                a[b.WARN.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                a[b.NONE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    public static void d(String tag, String toLog, Object... values) {
        b(b.WARN, tag, toLog, values);
    }

    public static void a(String tag, String toLog, Object... values) {
        b(b.DEBUG, tag, toLog, values);
    }
}
