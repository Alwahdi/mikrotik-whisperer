package defpackage;

import android.util.Log;

/* renamed from: xy  reason: default package */
public abstract class xy {
    private static String d(String tag) {
        return "TransportRuntime." + tag;
    }

    public static void a(String tag, String message, Object arg1) {
        Log.d(d(tag), String.format(message, new Object[]{arg1}));
    }

    public static void b(String tag, String message, Object... args) {
        Log.d(d(tag), String.format(message, args));
    }

    public static void e(String tag, String message) {
        Log.i(d(tag), message);
    }

    public static void c(String tag, String message, Throwable e) {
        Log.e(d(tag), message, e);
    }

    public static void f(String tag, String message, Object arg1) {
        Log.w(d(tag), String.format(message, new Object[]{arg1}));
    }
}
