package defpackage;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

/* renamed from: jq0  reason: default package */
public abstract class jq0 {
    public static final Executor a = new a();
    static final Executor b = new u91();

    /* renamed from: jq0$a */
    private static final class a implements Executor {
        private final Handler a = new Handler(Looper.getMainLooper());

        public final void execute(Runnable runnable) {
            this.a.post(runnable);
        }
    }
}
