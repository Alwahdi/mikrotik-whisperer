package defpackage;

import java.util.Locale;
import java.util.logging.Logger;

/* renamed from: i90  reason: default package */
abstract class i90 {
    private static final Logger a = Logger.getLogger(i90.class.getName());

    /* renamed from: a  reason: collision with other field name */
    private static final q50 f3210a = b();

    static long d() {
        return System.nanoTime();
    }

    static String a(double value) {
        return String.format(Locale.ROOT, "%.4g", new Object[]{Double.valueOf(value)});
    }

    static boolean c(String string) {
        return string == null || string.isEmpty();
    }

    private static q50 b() {
        return new b();
    }

    /* renamed from: i90$b */
    private static final class b implements q50 {
        private b() {
        }
    }
}
