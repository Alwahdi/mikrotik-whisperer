package defpackage;

import java.util.concurrent.Executor;

/* renamed from: u91  reason: default package */
final class u91 implements Executor {
    u91() {
    }

    public final void execute(Runnable runnable) {
        runnable.run();
    }
}
