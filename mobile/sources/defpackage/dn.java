package defpackage;

import defpackage.bj0;
import io.reactivex.internal.operators.flowable.FlowableSubscribeOn;
import io.reactivex.internal.subscriptions.b;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;

/* renamed from: dn  reason: default package */
public final class dn<T> extends n<T, T> {
    final bj0 a;

    /* renamed from: a  reason: collision with other field name */
    final boolean f2789a;

    public dn(km<T> source, bj0 scheduler, boolean nonScheduledRequests) {
        super(source);
        this.a = scheduler;
        this.f2789a = nonScheduledRequests;
    }

    public void z(ho0<? super T> s) {
        bj0.b w = this.a.a();
        FlowableSubscribeOn.SubscribeOnSubscriber<T> sos = new a<>(s, w, this.a, this.f2789a);
        s.d(sos);
        w.b(sos);
    }

    /* renamed from: dn$a */
    static final class a<T> extends AtomicReference<Thread> implements en<T>, jo0, Runnable {
        final bj0.b a;

        /* renamed from: a  reason: collision with other field name */
        final ho0<? super T> f2790a;

        /* renamed from: a  reason: collision with other field name */
        final AtomicLong f2791a = new AtomicLong();

        /* renamed from: a  reason: collision with other field name */
        final AtomicReference<jo0> f2792a = new AtomicReference<>();

        /* renamed from: a  reason: collision with other field name */
        rb0<T> f2793a;

        /* renamed from: a  reason: collision with other field name */
        final boolean f2794a;

        a(ho0<? super T> actual, bj0.b worker, rb0<T> source, boolean requestOn) {
            this.f2790a = actual;
            this.a = worker;
            this.f2793a = source;
            this.f2794a = !requestOn;
        }

        public void run() {
            lazySet(Thread.currentThread());
            Publisher<T> src = this.f2793a;
            this.f2793a = null;
            src.a(this);
        }

        public void d(jo0 s) {
            if (b.setOnce(this.f2792a, s)) {
                long r = this.f2791a.getAndSet(0);
                if (r != 0) {
                    b(r, s);
                }
            }
        }

        public void c(T t) {
            this.f2790a.c(t);
        }

        public void onError(Throwable t) {
            this.f2790a.onError(t);
            this.a.dispose();
        }

        public void a() {
            this.f2790a.a();
            this.a.dispose();
        }

        public void request(long n) {
            if (b.validate(n)) {
                jo0 s = this.f2792a.get();
                if (s != null) {
                    b(n, s);
                    return;
                }
                m5.a(this.f2791a, n);
                jo0 s2 = this.f2792a.get();
                if (s2 != null) {
                    long r = this.f2791a.getAndSet(0);
                    if (r != 0) {
                        b(r, s2);
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void b(long n, jo0 s) {
            if (this.f2794a || Thread.currentThread() == get()) {
                s.request(n);
            } else {
                this.a.b(new C0038a(s, n));
            }
        }

        public void cancel() {
            b.cancel(this.f2792a);
            this.a.dispose();
        }

        /* renamed from: dn$a$a  reason: collision with other inner class name */
        static final class C0038a implements Runnable {
            private final long a;

            /* renamed from: a  reason: collision with other field name */
            private final jo0 f2795a;

            C0038a(jo0 s, long n) {
                this.f2795a = s;
                this.a = n;
            }

            public void run() {
                this.f2795a.request(this.a);
            }
        }
    }
}
