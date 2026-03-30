package io.grpc.internal;

import io.grpc.a;
import io.grpc.i;
import java.text.MessageFormat;
import java.util.logging.Level;

final class l extends io.grpc.a {
    private final m a;

    /* renamed from: a  reason: collision with other field name */
    private final nr0 f3469a;

    l(m tracer, nr0 time) {
        this.a = (m) v90.o(tracer, "tracer");
        this.f3469a = (nr0) v90.o(time, "time");
    }

    public void a(a.C0040a level, String msg) {
        d(this.a.b(), level, msg);
        if (c(level)) {
            h(level, msg);
        }
    }

    public void b(a.C0040a level, String messageFormat, Object... args) {
        String msg = null;
        Level javaLogLevel = f(level);
        if (c(level) || m.a.isLoggable(javaLogLevel)) {
            msg = MessageFormat.format(messageFormat, args);
        }
        a(level, msg);
    }

    static void d(hu logId, a.C0040a level, String msg) {
        Level javaLogLevel = f(level);
        if (m.a.isLoggable(javaLogLevel)) {
            m.d(logId, javaLogLevel, msg);
        }
    }

    static void e(hu logId, a.C0040a level, String messageFormat, Object... args) {
        Level javaLogLevel = f(level);
        if (m.a.isLoggable(javaLogLevel)) {
            m.d(logId, javaLogLevel, MessageFormat.format(messageFormat, args));
        }
    }

    private boolean c(a.C0040a level) {
        return level != a.C0040a.DEBUG && this.a.c();
    }

    private void h(a.C0040a level, String msg) {
        if (level != a.C0040a.DEBUG) {
            this.a.f(new i.a().b(msg).c(g(level)).e(this.f3469a.a()).a());
        }
    }

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[a.C0040a.values().length];
            a = iArr;
            try {
                iArr[a.C0040a.ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                a[a.C0040a.WARNING.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    private static i.b g(a.C0040a level) {
        switch (a.a[level.ordinal()]) {
            case 1:
                return i.b.CT_ERROR;
            case 2:
                return i.b.CT_WARNING;
            default:
                return i.b.CT_INFO;
        }
    }

    private static Level f(a.C0040a level) {
        switch (a.a[level.ordinal()]) {
            case 1:
                return Level.FINE;
            case 2:
                return Level.FINER;
            default:
                return Level.FINEST;
        }
    }
}
