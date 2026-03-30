package defpackage;

import java.lang.Thread;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: vo0  reason: default package */
public final class vo0 implements Executor {
    private final Thread.UncaughtExceptionHandler a;

    /* renamed from: a  reason: collision with other field name */
    private final Queue<Runnable> f5398a = new ConcurrentLinkedQueue();

    /* renamed from: a  reason: collision with other field name */
    private final AtomicReference<Thread> f5399a = new AtomicReference<>();

    public vo0(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.a = (Thread.UncaughtExceptionHandler) v90.o(uncaughtExceptionHandler, "uncaughtExceptionHandler");
    }

    public final void a() {
        while (this.f5399a.compareAndSet((Object) null, Thread.currentThread())) {
            while (true) {
                try {
                    Runnable poll = this.f5398a.poll();
                    Runnable runnable = poll;
                    if (poll != null) {
                        runnable.run();
                    } else {
                        this.f5399a.set((Object) null);
                        if (this.f5398a.isEmpty()) {
                            return;
                        }
                    }
                } catch (Throwable th) {
                    this.f5399a.set((Object) null);
                    throw th;
                }
            }
        }
    }

    public final void b(Runnable runnable) {
        this.f5398a.add(v90.o(runnable, "runnable is null"));
    }

    public final void execute(Runnable task) {
        b(task);
        a();
    }

    public void d() {
        v90.u(Thread.currentThread() == this.f5399a.get(), "Not called from the SynchronizationContext");
    }

    /* renamed from: vo0$a */
    class a implements Runnable {
        final /* synthetic */ Runnable a;

        /* renamed from: a  reason: collision with other field name */
        final /* synthetic */ b f5400a;

        a(b bVar, Runnable runnable) {
            this.f5400a = bVar;
            this.a = runnable;
        }

        public void run() {
            vo0.this.execute(this.f5400a);
        }

        public String toString() {
            return this.a.toString() + "(scheduled in SynchronizationContext)";
        }
    }

    public final c c(Runnable task, long delay, TimeUnit unit, ScheduledExecutorService timerService) {
        b runnable = new b(task);
        return new c(runnable, timerService.schedule(new a(runnable, task), delay, unit), (a) null);
    }

    /* renamed from: vo0$b */
    private static class b implements Runnable {
        final Runnable a;

        /* renamed from: a  reason: collision with other field name */
        boolean f5402a;
        boolean b;

        b(Runnable task) {
            this.a = (Runnable) v90.o(task, "task");
        }

        public void run() {
            if (!this.f5402a) {
                this.b = true;
                this.a.run();
            }
        }
    }

    /* renamed from: vo0$c */
    public static final class c {
        private final ScheduledFuture<?> a;

        /* renamed from: a  reason: collision with other field name */
        private final b f5403a;

        /* synthetic */ c(b x0, ScheduledFuture x1, a x2) {
            this(x0, x1);
        }

        private c(b runnable, ScheduledFuture<?> future) {
            this.f5403a = (b) v90.o(runnable, "runnable");
            this.a = (ScheduledFuture) v90.o(future, "future");
        }

        public void a() {
            this.f5403a.f5402a = true;
            this.a.cancel(false);
        }

        public boolean b() {
            b bVar = this.f5403a;
            return !bVar.b && !bVar.f5402a;
        }
    }
}
