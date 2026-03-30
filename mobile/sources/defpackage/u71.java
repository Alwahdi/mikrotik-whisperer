package defpackage;

import java.util.concurrent.Executor;

/* renamed from: u71  reason: default package */
final /* synthetic */ class u71 implements Executor {
    static final Executor a = new u71();

    private u71() {
    }

    public final void execute(Runnable runnable) {
        runnable.run();
    }
}
