package defpackage;

import android.os.AsyncTask;
import java.util.concurrent.Executor;

/* renamed from: xj  reason: default package */
public abstract class xj {
    public static final Executor a = jq0.a;
    public static final Executor b = wj.a();
    public static final Executor c = new fr0(4, AsyncTask.THREAD_POOL_EXECUTOR);
}
