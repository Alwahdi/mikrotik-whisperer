package defpackage;

import defpackage.se0;
import java.util.List;
import java.util.ServiceLoader;

/* renamed from: cd  reason: default package */
public abstract class cd {
    private static final List<bd> a;

    static {
        Class<bd> cls = bd.class;
        a = kk0.k(ik0.c(ServiceLoader.load(cls, cls.getClassLoader()).iterator()));
    }

    public static final void a(yc context, Throwable exception) {
        for (bd handler : a) {
            try {
                handler.q(context, exception);
            } catch (Throwable t) {
                Thread currentThread = Thread.currentThread();
                currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, dd.b(exception, t));
            }
        }
        Thread currentThread2 = Thread.currentThread();
        try {
            se0.a aVar = se0.a;
            rj.a(exception, new kg(context));
            se0.a(jt0.a);
        } catch (Throwable th) {
            se0.a aVar2 = se0.a;
            se0.a(te0.a(th));
        }
        currentThread2.getUncaughtExceptionHandler().uncaughtException(currentThread2, exception);
    }
}
