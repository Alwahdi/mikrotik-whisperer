package defpackage;

import androidx.arch.core.executor.ArchTaskExecutor;
import java.util.concurrent.Executor;

/* renamed from: w3  reason: default package */
public final /* synthetic */ class w3 implements Executor {
    public static final /* synthetic */ w3 a = new w3();

    private /* synthetic */ w3() {
    }

    public final void execute(Runnable runnable) {
        ArchTaskExecutor.getInstance().postToMainThread(runnable);
    }
}
