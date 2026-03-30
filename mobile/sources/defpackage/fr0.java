package defpackage;

import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.Semaphore;

/* renamed from: fr0  reason: default package */
class fr0 implements Executor {
    private final Executor a;

    /* renamed from: a  reason: collision with other field name */
    private final Semaphore f2992a;

    fr0(int maximumConcurrency, Executor executor) {
        this.f2992a = new Semaphore(maximumConcurrency);
        this.a = executor;
    }

    public void execute(Runnable command) {
        if (this.f2992a.tryAcquire()) {
            try {
                this.a.execute(er0.a(this, command));
            } catch (RejectedExecutionException e) {
                command.run();
            }
        } else {
            command.run();
        }
    }

    static /* synthetic */ void a(fr0 fr0, Runnable command) {
        command.run();
        fr0.f2992a.release();
    }
}
