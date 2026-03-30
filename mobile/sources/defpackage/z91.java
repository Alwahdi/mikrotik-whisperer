package defpackage;

import java.util.concurrent.Callable;

/* renamed from: z91  reason: default package */
final class z91 implements Runnable {
    private final /* synthetic */ Callable a;

    /* renamed from: a  reason: collision with other field name */
    private final /* synthetic */ v91 f6016a;

    z91(v91 v91, Callable callable) {
        this.f6016a = v91;
        this.a = callable;
    }

    public final void run() {
        try {
            this.f6016a.u(this.a.call());
        } catch (Exception e) {
            this.f6016a.t(e);
        }
    }
}
