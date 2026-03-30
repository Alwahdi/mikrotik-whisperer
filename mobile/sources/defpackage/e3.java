package defpackage;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Callable;

/* renamed from: e3  reason: default package */
public abstract class e3 {
    private static final bj0 a = nf0.d(new a());

    /* renamed from: e3$b */
    private static final class b {
        static final bj0 a = new lq(new Handler(Looper.getMainLooper()));
    }

    /* renamed from: e3$a */
    static class a implements Callable<bj0> {
        a() {
        }

        /* renamed from: a */
        public bj0 call() {
            return b.a;
        }
    }

    public static bj0 a() {
        return nf0.e(a);
    }
}
