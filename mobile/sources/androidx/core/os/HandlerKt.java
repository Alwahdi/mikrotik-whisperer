package androidx.core.os;

import android.os.Handler;

public final class HandlerKt {
    public static /* synthetic */ Runnable postDelayed$default(Handler $this$postDelayed_u24default, long delayInMillis, Object token, tn action, int i, Object obj) {
        if ((i & 2) != 0) {
            token = null;
        }
        lu.f($this$postDelayed_u24default, "<this>");
        lu.f(action, "action");
        Runnable runnable = new HandlerKt$postDelayed$runnable$1(action);
        if (token == null) {
            $this$postDelayed_u24default.postDelayed(runnable, delayInMillis);
        } else {
            HandlerCompat.postDelayed($this$postDelayed_u24default, runnable, token, delayInMillis);
        }
        return runnable;
    }

    public static final Runnable postDelayed(Handler $this$postDelayed, long delayInMillis, Object token, tn<jt0> action) {
        lu.f($this$postDelayed, "<this>");
        lu.f(action, "action");
        Runnable runnable = new HandlerKt$postDelayed$runnable$1(action);
        if (token == null) {
            $this$postDelayed.postDelayed(runnable, delayInMillis);
        } else {
            HandlerCompat.postDelayed($this$postDelayed, runnable, token, delayInMillis);
        }
        return runnable;
    }

    public static /* synthetic */ Runnable postAtTime$default(Handler $this$postAtTime_u24default, long uptimeMillis, Object token, tn action, int i, Object obj) {
        if ((i & 2) != 0) {
            token = null;
        }
        lu.f($this$postAtTime_u24default, "<this>");
        lu.f(action, "action");
        Runnable runnable = new HandlerKt$postAtTime$runnable$1(action);
        $this$postAtTime_u24default.postAtTime(runnable, token, uptimeMillis);
        return runnable;
    }

    public static final Runnable postAtTime(Handler $this$postAtTime, long uptimeMillis, Object token, tn<jt0> action) {
        lu.f($this$postAtTime, "<this>");
        lu.f(action, "action");
        Runnable runnable = new HandlerKt$postAtTime$runnable$1(action);
        $this$postAtTime.postAtTime(runnable, token, uptimeMillis);
        return runnable;
    }
}
