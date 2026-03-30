package defpackage;

import java.util.logging.Level;
import java.util.logging.Logger;

/* renamed from: ty  reason: default package */
public final class ty implements Runnable {
    private static final Logger a = Logger.getLogger(ty.class.getName());

    /* renamed from: a  reason: collision with other field name */
    private final Runnable f5180a;

    public ty(Runnable task) {
        this.f5180a = (Runnable) v90.o(task, "task");
    }

    public void run() {
        try {
            this.f5180a.run();
        } catch (Throwable t) {
            Logger logger = a;
            Level level = Level.SEVERE;
            logger.log(level, "Exception while executing runnable " + this.f5180a, t);
            hr0.f(t);
            throw new AssertionError(t);
        }
    }

    public String toString() {
        return "LogExceptionRunnable(" + this.f5180a + ")";
    }
}
