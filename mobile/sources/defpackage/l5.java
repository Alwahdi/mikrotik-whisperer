package defpackage;

import java.util.concurrent.Executor;
import java.util.concurrent.Semaphore;

/* renamed from: l5  reason: default package */
public class l5 implements Executor {
    private int a = 0;

    /* renamed from: a  reason: collision with other field name */
    private Semaphore f4197a = new Semaphore(0);

    public void execute(Runnable task) {
        this.a++;
        xj.c.execute(k5.a(this, task));
    }

    static /* synthetic */ void b(l5 l5Var, Runnable task) {
        task.run();
        l5Var.f4197a.release();
    }

    public void a() {
        this.f4197a.acquire(this.a);
        this.a = 0;
    }
}
