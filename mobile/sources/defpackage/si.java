package defpackage;

import io.reactivex.internal.disposables.a;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: si  reason: default package */
public abstract class si {
    public static boolean c(AtomicReference<yg> upstream, yg next, Class<?> observer) {
        a40.c(next, "next is null");
        if (upstream.compareAndSet((Object) null, next)) {
            return true;
        }
        next.dispose();
        if (upstream.get() == a.DISPOSED) {
            return false;
        }
        b(observer);
        return false;
    }

    public static String a(String consumer) {
        return "It is not allowed to subscribe with a(n) " + consumer + " multiple times. Please create a fresh instance of " + consumer + " and subscribe that to the target source instead.";
    }

    public static void b(Class<?> consumer) {
        of0.l(new lb0(a(consumer.getName())));
    }
}
