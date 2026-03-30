package defpackage;

import android.os.Handler;
import java.util.concurrent.Executor;

/* renamed from: yb  reason: default package */
public final /* synthetic */ class yb implements Executor {
    public final /* synthetic */ Handler a;

    public /* synthetic */ yb(Handler handler) {
        this.a = handler;
    }

    public final void execute(Runnable runnable) {
        this.a.post(runnable);
    }
}
