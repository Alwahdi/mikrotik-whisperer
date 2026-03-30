package defpackage;

import androidx.core.location.LocationRequestCompat;
import defpackage.bj0;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;

/* renamed from: ym  reason: default package */
public final class ym<T> extends n<T, T> {
    final bj0 a;

    /* renamed from: a  reason: collision with other field name */
    final boolean f5897a;
    final int b;

    public ym(km<T> source, bj0 scheduler, boolean delayError, int prefetch) {
        super(source);
        this.a = scheduler;
        this.f5897a = delayError;
        this.b = prefetch;
    }

    public void z(ho0<? super T> s) {
        bj0.b worker = this.a.a();
        if (s instanceof zb) {
            this.a.y(new b((zb) s, worker, this.f5897a, this.b));
        } else {
            this.a.y(new c(s, worker, this.f5897a, this.b));
        }
    }

    /* renamed from: ym$a */
    static abstract class a<T> extends e6<T> implements en<T>, Runnable {
        final int a;

        /* renamed from: a  reason: collision with other field name */
        long f5898a;

        /* renamed from: a  reason: collision with other field name */
        final bj0.b f5899a;

        /* renamed from: a  reason: collision with other field name */
        Throwable f5900a;

        /* renamed from: a  reason: collision with other field name */
        final AtomicLong f5901a = new AtomicLong();

        /* renamed from: a  reason: collision with other field name */
        jo0 f5902a;

        /* renamed from: a  reason: collision with other field name */
        ul0<T> f5903a;

        /* renamed from: a  reason: collision with other field name */
        final boolean f5904a;
        final int b;

        /* renamed from: b  reason: collision with other field name */
        volatile boolean f5905b;
        int c;

        /* renamed from: c  reason: collision with other field name */
        volatile boolean f5906c;
        boolean d;

        /* access modifiers changed from: package-private */
        public abstract void i();

        /* access modifiers changed from: package-private */
        public abstract void j();

        /* access modifiers changed from: package-private */
        public abstract void k();

        a(bj0.b worker, boolean delayError, int prefetch) {
            this.f5899a = worker;
            this.f5904a = delayError;
            this.a = prefetch;
            this.b = prefetch - (prefetch >> 2);
        }

        public final void c(T t) {
            if (!this.f5906c) {
                if (this.c == 2) {
                    l();
                    return;
                }
                if (!this.f5903a.offer(t)) {
                    this.f5902a.cancel();
                    this.f5900a = new a20("Queue is full?!");
                    this.f5906c = true;
                }
                l();
            }
        }

        public final void onError(Throwable t) {
            if (this.f5906c) {
                of0.l(t);
                return;
            }
            this.f5900a = t;
            this.f5906c = true;
            l();
        }

        public final void a() {
            if (!this.f5906c) {
                this.f5906c = true;
                l();
            }
        }

        public final void request(long n) {
            if (io.reactivex.internal.subscriptions.b.validate(n)) {
                m5.a(this.f5901a, n);
                l();
            }
        }

        public final void cancel() {
            if (!this.f5905b) {
                this.f5905b = true;
                this.f5902a.cancel();
                this.f5899a.dispose();
                if (getAndIncrement() == 0) {
                    this.f5903a.clear();
                }
            }
        }

        /* access modifiers changed from: package-private */
        public final void l() {
            if (getAndIncrement() == 0) {
                this.f5899a.b(this);
            }
        }

        public final void run() {
            if (this.d) {
                j();
            } else if (this.c == 1) {
                k();
            } else {
                i();
            }
        }

        /* access modifiers changed from: package-private */
        public final boolean h(boolean d2, boolean empty, ho0<?> a2) {
            if (this.f5905b) {
                clear();
                return true;
            } else if (!d2) {
                return false;
            } else {
                if (!this.f5904a) {
                    Throwable e = this.f5900a;
                    if (e != null) {
                        clear();
                        a2.onError(e);
                        this.f5899a.dispose();
                        return true;
                    } else if (!empty) {
                        return false;
                    } else {
                        a2.a();
                        this.f5899a.dispose();
                        return true;
                    }
                } else if (!empty) {
                    return false;
                } else {
                    Throwable e2 = this.f5900a;
                    if (e2 != null) {
                        a2.onError(e2);
                    } else {
                        a2.a();
                    }
                    this.f5899a.dispose();
                    return true;
                }
            }
        }

        public final int requestFusion(int requestedMode) {
            if ((requestedMode & 2) == 0) {
                return 0;
            }
            this.d = true;
            return 2;
        }

        public final void clear() {
            this.f5903a.clear();
        }

        public final boolean isEmpty() {
            return this.f5903a.isEmpty();
        }
    }

    /* renamed from: ym$c */
    static final class c<T> extends a<T> {
        final ho0<? super T> a;

        c(ho0<? super T> actual, bj0.b worker, boolean delayError, int prefetch) {
            super(worker, delayError, prefetch);
            this.a = actual;
        }

        public void d(jo0 s) {
            if (io.reactivex.internal.subscriptions.b.validate(this.f5902a, s)) {
                this.f5902a = s;
                if (s instanceof wb0) {
                    QueueSubscription<T> f = (wb0) s;
                    int m = f.requestFusion(7);
                    if (m == 1) {
                        this.c = 1;
                        this.f5903a = f;
                        this.f5906c = true;
                        this.a.d(this);
                        return;
                    } else if (m == 2) {
                        this.c = 2;
                        this.f5903a = f;
                        this.a.d(this);
                        s.request((long) this.a);
                        return;
                    }
                }
                this.f5903a = new rm0(this.a);
                this.a.d(this);
                s.request((long) this.a);
            }
        }

        /* access modifiers changed from: package-private */
        public void k() {
            int missed = 1;
            Subscriber<? super T> a2 = this.a;
            SimpleQueue<T> q = this.f5903a;
            long e = this.f5898a;
            while (true) {
                long r = this.f5901a.get();
                while (e != r) {
                    try {
                        T v = q.poll();
                        if (!this.f5905b) {
                            if (v == null) {
                                a2.a();
                                this.f5899a.dispose();
                                return;
                            }
                            a2.c(v);
                            e++;
                        } else {
                            return;
                        }
                    } catch (Throwable ex) {
                        oj.b(ex);
                        this.f5902a.cancel();
                        a2.onError(ex);
                        this.f5899a.dispose();
                        return;
                    }
                }
                if (!this.f5905b) {
                    if (q.isEmpty()) {
                        a2.a();
                        this.f5899a.dispose();
                        return;
                    }
                    int w = get();
                    if (missed == w) {
                        this.f5898a = e;
                        missed = addAndGet(-missed);
                        if (missed == 0) {
                            return;
                        }
                    } else {
                        missed = w;
                    }
                } else {
                    return;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void i() {
            int missed = 1;
            Subscriber<? super T> a2 = this.a;
            SimpleQueue<T> q = this.f5903a;
            long e = this.f5898a;
            while (true) {
                long r = this.f5901a.get();
                while (e != r) {
                    boolean d = this.f5906c;
                    try {
                        T v = q.poll();
                        boolean empty = v == null;
                        if (!h(d, empty, a2)) {
                            if (empty) {
                                break;
                            }
                            a2.c(v);
                            e++;
                            if (e == ((long) this.b)) {
                                if (r != LocationRequestCompat.PASSIVE_INTERVAL) {
                                    r = this.f5901a.addAndGet(-e);
                                }
                                this.f5902a.request(e);
                                e = 0;
                            }
                        } else {
                            return;
                        }
                    } catch (Throwable ex) {
                        oj.b(ex);
                        this.f5902a.cancel();
                        q.clear();
                        a2.onError(ex);
                        this.f5899a.dispose();
                        return;
                    }
                }
                if (e != r || !h(this.f5906c, q.isEmpty(), a2)) {
                    int w = get();
                    if (missed == w) {
                        this.f5898a = e;
                        missed = addAndGet(-missed);
                        if (missed == 0) {
                            return;
                        }
                    } else {
                        missed = w;
                    }
                } else {
                    return;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void j() {
            int missed = 1;
            while (!this.f5905b) {
                boolean d = this.f5906c;
                this.a.c(null);
                if (d) {
                    Throwable e = this.f5900a;
                    if (e != null) {
                        this.a.onError(e);
                    } else {
                        this.a.a();
                    }
                    this.f5899a.dispose();
                    return;
                }
                missed = addAndGet(-missed);
                if (missed == 0) {
                    return;
                }
            }
        }

        public T poll() {
            T v = this.f5903a.poll();
            if (!(v == null || this.c == 1)) {
                long p = this.f5898a + 1;
                if (p == ((long) this.b)) {
                    this.f5898a = 0;
                    this.f5902a.request(p);
                } else {
                    this.f5898a = p;
                }
            }
            return v;
        }
    }

    /* renamed from: ym$b */
    static final class b<T> extends a<T> {
        final zb<? super T> a;
        long b;

        b(zb<? super T> actual, bj0.b worker, boolean delayError, int prefetch) {
            super(worker, delayError, prefetch);
            this.a = actual;
        }

        public void d(jo0 s) {
            if (io.reactivex.internal.subscriptions.b.validate(this.f5902a, s)) {
                this.f5902a = s;
                if (s instanceof wb0) {
                    QueueSubscription<T> f = (wb0) s;
                    int m = f.requestFusion(7);
                    if (m == 1) {
                        this.c = 1;
                        this.f5903a = f;
                        this.f5906c = true;
                        this.a.d(this);
                        return;
                    } else if (m == 2) {
                        this.c = 2;
                        this.f5903a = f;
                        this.a.d(this);
                        s.request((long) this.a);
                        return;
                    }
                }
                this.f5903a = new rm0(this.a);
                this.a.d(this);
                s.request((long) this.a);
            }
        }

        /* access modifiers changed from: package-private */
        public void k() {
            int missed = 1;
            ConditionalSubscriber<? super T> a2 = this.a;
            SimpleQueue<T> q = this.f5903a;
            long e = this.f5898a;
            while (true) {
                long r = this.f5901a.get();
                while (e != r) {
                    try {
                        T v = q.poll();
                        if (!this.f5905b) {
                            if (v == null) {
                                a2.a();
                                this.f5899a.dispose();
                                return;
                            } else if (a2.f(v)) {
                                e++;
                            }
                        } else {
                            return;
                        }
                    } catch (Throwable ex) {
                        oj.b(ex);
                        this.f5902a.cancel();
                        a2.onError(ex);
                        this.f5899a.dispose();
                        return;
                    }
                }
                if (!this.f5905b) {
                    if (q.isEmpty()) {
                        a2.a();
                        this.f5899a.dispose();
                        return;
                    }
                    int w = get();
                    if (missed == w) {
                        this.f5898a = e;
                        missed = addAndGet(-missed);
                        if (missed == 0) {
                            return;
                        }
                    } else {
                        missed = w;
                    }
                } else {
                    return;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void i() {
            int missed = 1;
            ConditionalSubscriber<? super T> a2 = this.a;
            SimpleQueue<T> q = this.f5903a;
            long emitted = this.f5898a;
            long polled = this.b;
            while (true) {
                long r = this.f5901a.get();
                while (emitted != r) {
                    boolean d = this.f5906c;
                    try {
                        T v = q.poll();
                        boolean empty = v == null;
                        if (!h(d, empty, a2)) {
                            if (empty) {
                                break;
                            }
                            if (a2.f(v)) {
                                emitted++;
                            }
                            polled++;
                            if (polled == ((long) this.b)) {
                                this.f5902a.request(polled);
                                polled = 0;
                            }
                        } else {
                            return;
                        }
                    } catch (Throwable ex) {
                        oj.b(ex);
                        this.f5902a.cancel();
                        q.clear();
                        a2.onError(ex);
                        this.f5899a.dispose();
                        return;
                    }
                }
                if (emitted != r || !h(this.f5906c, q.isEmpty(), a2)) {
                    int w = get();
                    if (missed == w) {
                        this.f5898a = emitted;
                        this.b = polled;
                        missed = addAndGet(-missed);
                        if (missed == 0) {
                            return;
                        }
                    } else {
                        missed = w;
                    }
                } else {
                    return;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void j() {
            int missed = 1;
            while (!this.f5905b) {
                boolean d = this.f5906c;
                this.a.c(null);
                if (d) {
                    Throwable e = this.f5900a;
                    if (e != null) {
                        this.a.onError(e);
                    } else {
                        this.a.a();
                    }
                    this.f5899a.dispose();
                    return;
                }
                missed = addAndGet(-missed);
                if (missed == 0) {
                    return;
                }
            }
        }

        public T poll() {
            T v = this.f5903a.poll();
            if (!(v == null || this.c == 1)) {
                long p = this.b + 1;
                if (p == ((long) this.b)) {
                    this.b = 0;
                    this.f5902a.request(p);
                } else {
                    this.b = p;
                }
            }
            return v;
        }
    }
}
