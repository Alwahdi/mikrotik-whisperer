package defpackage;

import java.util.logging.Level;
import java.util.logging.Logger;

/* renamed from: a90  reason: default package */
public abstract class a90 {
    private static final ds a;

    static {
        ds instance = null;
        Level level = Level.WARNING;
        Throwable err = null;
        Class<?> clz = null;
        try {
            clz = Class.forName("io.perfmark.impl.SecretPerfMarkImpl$PerfMarkImpl");
        } catch (ClassNotFoundException e) {
            level = Level.FINE;
            err = e;
        } catch (Throwable t) {
            err = t;
        }
        if (clz != null) {
            try {
                instance = (ds) clz.asSubclass(ds.class).getConstructor(new Class[]{yp0.class}).newInstance(new Object[]{ds.f2820a});
            } catch (Throwable t2) {
                err = t2;
            }
        }
        if (instance != null) {
            a = instance;
        } else {
            a = new ds(ds.f2820a);
        }
        if (err != null) {
            Logger.getLogger(a90.class.getName()).log(level, "Error during PerfMark.<clinit>", err);
        }
    }

    public static void g(String taskName, yp0 tag) {
        a.f(taskName, tag);
    }

    public static void f(String taskName) {
        a.e(taskName);
    }

    public static void c(String eventName, yp0 tag) {
        a.b(eventName, tag);
    }

    public static void i(String taskName, yp0 tag) {
        a.h(taskName, tag);
    }

    public static void h(String taskName) {
        a.g(taskName);
    }

    public static yp0 a(String name) {
        return a.a(name, Long.MIN_VALUE);
    }

    public static yp0 b(String name, long id) {
        return a.a(name, id);
    }

    public static hx e() {
        return a.d();
    }

    public static void d(hx link) {
        a.c(link);
    }
}
