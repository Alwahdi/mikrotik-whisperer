package defpackage;

import android.util.Log;

/* renamed from: ps0  reason: default package */
abstract class ps0 {
    private static boolean a = false;

    static void a(String tag, String msg) {
        if (a) {
            Log.d(tag, msg);
        }
    }

    static void c(String tag, String msg) {
        if (a) {
            Log.i(tag, msg);
        }
    }

    static void e(String tag, String msg) {
        if (a) {
            Log.w(tag, msg);
        }
    }

    static void b(String tag, String msg, Throwable t) {
        if (a) {
            Log.e(tag, msg, t);
        }
    }

    static void d(boolean isLoggingEnabled) {
        a = isLoggingEnabled;
    }
}
