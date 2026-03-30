package defpackage;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

/* renamed from: u01  reason: default package */
public final class u01 implements Executor {
    private static u01 a = new u01();

    /* renamed from: a  reason: collision with other field name */
    private Handler f5185a = new f81(Looper.getMainLooper());

    private u01() {
    }

    public final void execute(Runnable runnable) {
        this.f5185a.post(runnable);
    }

    public static u01 a() {
        return a;
    }
}
