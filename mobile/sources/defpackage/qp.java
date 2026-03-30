package defpackage;

import android.util.Log;

/* renamed from: qp  reason: default package */
public final class qp {
    private static final int a = 15;
    private static final String c = null;

    /* renamed from: a  reason: collision with other field name */
    private final String f4850a;
    private final String b;

    public qp(String str, String str2) {
        y90.k(str, "log tag cannot be null");
        y90.c(str.length() <= 23, "tag \"%s\" is longer than the %d character maximum", str, 23);
        this.f4850a = str;
        if (str2 == null || str2.length() <= 0) {
            this.b = null;
        } else {
            this.b = str2;
        }
    }

    public qp(String str) {
        this(str, (String) null);
    }

    public final boolean a(int i) {
        return Log.isLoggable(this.f4850a, i);
    }

    public final void b(String str, String str2) {
        if (a(3)) {
            Log.d(str, f(str2));
        }
    }

    public final void e(String str, String str2) {
        if (a(2)) {
            Log.v(str, f(str2));
        }
    }

    public final void c(String str, String str2) {
        if (a(6)) {
            Log.e(str, f(str2));
        }
    }

    public final void d(String str, String str2, Throwable th) {
        if (a(6)) {
            Log.e(str, f(str2), th);
        }
    }

    private final String f(String str) {
        String str2 = this.b;
        if (str2 == null) {
            return str;
        }
        return str2.concat(str);
    }
}
