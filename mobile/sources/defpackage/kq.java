package defpackage;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import defpackage.se0;

/* renamed from: kq  reason: default package */
public abstract class kq {
    public static final jq a;
    private static volatile Choreographer choreographer;

    public static final Handler a(Looper $this$asHandler, boolean async) {
        int i;
        if (!async || (i = Build.VERSION.SDK_INT) < 16) {
            return new Handler($this$asHandler);
        }
        if (i >= 28) {
            Object invoke = Handler.class.getDeclaredMethod("createAsync", new Class[]{Looper.class}).invoke((Object) null, new Object[]{$this$asHandler});
            if (invoke != null) {
                return (Handler) invoke;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.os.Handler");
        }
        try {
            return Handler.class.getDeclaredConstructor(new Class[]{Looper.class, Handler.Callback.class, Boolean.TYPE}).newInstance(new Object[]{$this$asHandler, null, true});
        } catch (NoSuchMethodException e) {
            return new Handler($this$asHandler);
        }
    }

    static {
        Object obj;
        jq jqVar = null;
        try {
            se0.a aVar = se0.a;
            obj = se0.a(new iq(a(Looper.getMainLooper(), true), (String) null, 2, (Cif) null));
        } catch (Throwable th) {
            se0.a aVar2 = se0.a;
            obj = se0.a(te0.a(th));
        }
        if (!se0.c(obj)) {
            jqVar = obj;
        }
        a = jqVar;
    }
}
