package defpackage;

import java.util.concurrent.atomic.AtomicReference;

/* renamed from: nj  reason: default package */
public abstract class nj {
    public static final Throwable a = new a();

    public static RuntimeException d(Throwable error) {
        if (error instanceof Error) {
            throw ((Error) error);
        } else if (error instanceof RuntimeException) {
            return (RuntimeException) error;
        } else {
            return new RuntimeException(error);
        }
    }

    public static <T> boolean a(AtomicReference<Throwable> field, Throwable exception) {
        Throwable current;
        Throwable update;
        do {
            current = field.get();
            if (current == a) {
                return false;
            }
            if (current == null) {
                update = exception;
            } else {
                update = new rb(current, exception);
            }
        } while (!field.compareAndSet(current, update));
        return true;
    }

    public static <T> Throwable b(AtomicReference<Throwable> field) {
        Throwable current = field.get();
        Throwable th = a;
        if (current != th) {
            return field.getAndSet(th);
        }
        return current;
    }

    public static <E extends Throwable> Exception c(Throwable e) {
        if (e instanceof Exception) {
            return (Exception) e;
        }
        throw e;
    }

    /* renamed from: nj$a */
    static final class a extends Throwable {
        a() {
            super("No further exceptions");
        }

        public Throwable fillInStackTrace() {
            return this;
        }
    }
}
