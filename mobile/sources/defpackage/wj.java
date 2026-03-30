package defpackage;

import java.util.concurrent.Executor;

/* renamed from: wj  reason: default package */
final /* synthetic */ class wj implements Executor {
    private static final wj a = new wj();

    private wj() {
    }

    public static Executor a() {
        return a;
    }

    public void execute(Runnable runnable) {
        runnable.run();
    }
}
