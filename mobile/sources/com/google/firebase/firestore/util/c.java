package com.google.firebase.firestore.util;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public class c {
    /* access modifiers changed from: private */
    public final C0026c a = new C0026c();

    /* renamed from: a  reason: collision with other field name */
    private final ArrayList<b> f2380a = new ArrayList<>();
    private final ArrayList<d> b = new ArrayList<>();

    public enum d {
        ALL,
        LISTEN_STREAM_IDLE,
        LISTEN_STREAM_CONNECTION_BACKOFF,
        WRITE_STREAM_IDLE,
        WRITE_STREAM_CONNECTION_BACKOFF,
        ONLINE_STATE_TIMEOUT,
        GARBAGE_COLLECTION,
        RETRY_TRANSACTION,
        CONNECTIVITY_ATTEMPT_TIMER
    }

    public class b {
        private final long a;

        /* renamed from: a  reason: collision with other field name */
        private final d f2381a;

        /* renamed from: a  reason: collision with other field name */
        private final Runnable f2383a;

        /* renamed from: a  reason: collision with other field name */
        private ScheduledFuture f2384a;

        private b(d timerId, long targetTimeMs, Runnable task) {
            this.f2381a = timerId;
            this.a = targetTimeMs;
            this.f2383a = task;
        }

        /* access modifiers changed from: private */
        public void f(long delayMs) {
            this.f2384a = c.this.a.schedule(d.a(this), delayMs, TimeUnit.MILLISECONDS);
        }

        public void c() {
            c.this.n();
            ScheduledFuture scheduledFuture = this.f2384a;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(false);
                e();
            }
        }

        /* access modifiers changed from: private */
        public void d() {
            c.this.n();
            if (this.f2384a != null) {
                e();
                this.f2383a.run();
            }
        }

        private void e() {
            n4.d(this.f2384a != null, "Caller should have verified scheduledFuture is non-null.", new Object[0]);
            this.f2384a = null;
            c.this.m(this);
        }
    }

    /* renamed from: com.google.firebase.firestore.util.c$c  reason: collision with other inner class name */
    private class C0026c implements Executor {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with other field name */
        public final Thread f2385a;

        /* renamed from: a  reason: collision with other field name */
        private final ScheduledThreadPoolExecutor f2386a;

        /* renamed from: a  reason: collision with other field name */
        private boolean f2387a = false;

        /* renamed from: com.google.firebase.firestore.util.c$c$b */
        private class b implements Runnable, ThreadFactory {

            /* renamed from: a  reason: collision with other field name */
            private Runnable f2389a;

            /* renamed from: a  reason: collision with other field name */
            private final CountDownLatch f2390a;

            private b() {
                this.f2390a = new CountDownLatch(1);
            }

            public void run() {
                try {
                    this.f2390a.await();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                this.f2389a.run();
            }

            public Thread newThread(Runnable runnable) {
                n4.d(this.f2389a == null, "Only one thread may be created in an AsyncQueue.", new Object[0]);
                this.f2389a = runnable;
                this.f2390a.countDown();
                return C0026c.this.f2385a;
            }
        }

        C0026c() {
            b threadFactory = new b();
            Thread newThread = Executors.defaultThreadFactory().newThread(threadFactory);
            this.f2385a = newThread;
            newThread.setName("FirestoreWorker");
            newThread.setDaemon(true);
            newThread.setUncaughtExceptionHandler(e.a(this));
            a aVar = new a(1, threadFactory, c.this);
            this.f2386a = aVar;
            aVar.setKeepAliveTime(3, TimeUnit.SECONDS);
        }

        /* renamed from: com.google.firebase.firestore.util.c$c$a */
        class a extends ScheduledThreadPoolExecutor {

            /* renamed from: a  reason: collision with other field name */
            final /* synthetic */ c f2388a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(int corePoolSize, ThreadFactory threadFactory, c cVar) {
                super(corePoolSize, threadFactory);
                this.f2388a = cVar;
            }

            /* access modifiers changed from: protected */
            public void afterExecute(Runnable r, Throwable t) {
                super.afterExecute(r, t);
                if (t == null && (r instanceof Future)) {
                    Future<?> future = (Future) r;
                    try {
                        if (future.isDone()) {
                            future.get();
                        }
                    } catch (CancellationException e) {
                    } catch (ExecutionException ee) {
                        t = ee.getCause();
                    } catch (InterruptedException e2) {
                        Thread.currentThread().interrupt();
                    }
                }
                if (t != null) {
                    c.this.l(t);
                }
            }
        }

        /* access modifiers changed from: private */
        public synchronized boolean g() {
            return this.f2387a;
        }

        public synchronized void execute(Runnable command) {
            if (!this.f2387a) {
                this.f2386a.execute(command);
            }
        }

        /* access modifiers changed from: private */
        public <T> eq0<T> f(Callable<T> task) {
            TaskCompletionSource<T> completionSource = new gq0<>();
            try {
                execute(f.a(completionSource, task));
            } catch (RejectedExecutionException e) {
                i.d(c.class.getSimpleName(), "Refused to enqueue task after panic", new Object[0]);
            }
            return completionSource.a();
        }

        static /* synthetic */ void h(gq0 completionSource, Callable task) {
            try {
                completionSource.c(task.call());
            } catch (Exception e) {
                completionSource.b(e);
                throw new RuntimeException(e);
            }
        }

        /* access modifiers changed from: private */
        public synchronized ScheduledFuture<?> schedule(Runnable command, long delay, TimeUnit unit) {
            if (this.f2387a) {
                return null;
            }
            return this.f2386a.schedule(command, delay, unit);
        }

        /* access modifiers changed from: private */
        public void j() {
            this.f2386a.shutdownNow();
        }
    }

    public Executor h() {
        return this.a;
    }

    public void n() {
        Thread current = Thread.currentThread();
        if (this.a.f2385a != current) {
            throw n4.a("We are running on the wrong thread. Expected to be on the AsyncQueue thread %s/%d but was %s/%d", this.a.f2385a.getName(), Long.valueOf(this.a.f2385a.getId()), current.getName(), Long.valueOf(current.getId()));
        }
    }

    public <T> eq0<T> e(Callable<T> task) {
        return this.a.f(task);
    }

    public eq0<Void> d(Runnable task) {
        return e(a.a(task));
    }

    public boolean i() {
        return this.a.g();
    }

    public void g(Runnable task) {
        d(task);
    }

    public b f(d timerId, long delayMs, Runnable task) {
        if (this.b.contains(timerId)) {
            delayMs = 0;
        }
        b delayedTask = c(timerId, delayMs, task);
        this.f2380a.add(delayedTask);
        return delayedTask;
    }

    public void l(Throwable t) {
        this.a.j();
        new Handler(Looper.getMainLooper()).post(b.a(t));
    }

    static /* synthetic */ void k(Throwable t) {
        if (t instanceof OutOfMemoryError) {
            OutOfMemoryError error = new OutOfMemoryError("Firestore (21.4.0) ran out of memory. Check your queries to make sure they are not loading an excessive amount of data.");
            error.initCause(t);
            throw error;
        }
        throw new RuntimeException("Internal error in Cloud Firestore (21.4.0).", t);
    }

    private b c(d timerId, long delayMs, Runnable task) {
        b delayedTask = new b(timerId, System.currentTimeMillis() + delayMs, task);
        delayedTask.f(delayMs);
        return delayedTask;
    }

    /* access modifiers changed from: private */
    public void m(b task) {
        n4.d(this.f2380a.remove(task), "Delayed task not found.", new Object[0]);
    }
}
