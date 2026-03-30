package defpackage;

import androidx.arch.core.executor.ArchTaskExecutor;
import java.util.concurrent.Executor;

/* renamed from: v3  reason: default package */
public final /* synthetic */ class v3 implements Executor {
    public static final /* synthetic */ v3 a = new v3();

    private /* synthetic */ v3() {
    }

    public final void execute(Runnable runnable) {
        ArchTaskExecutor.getInstance().executeOnDiskIO(runnable);
    }
}
