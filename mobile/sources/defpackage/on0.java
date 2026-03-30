package defpackage;

import io.reactivex.internal.subscriptions.b;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: on0  reason: default package */
public class on0<T> extends AtomicInteger implements en<T>, jo0 {
    final ho0<? super T> a;

    /* renamed from: a  reason: collision with other field name */
    final AtomicBoolean f4561a = new AtomicBoolean();

    /* renamed from: a  reason: collision with other field name */
    final AtomicLong f4562a = new AtomicLong();

    /* renamed from: a  reason: collision with other field name */
    final AtomicReference<jo0> f4563a = new AtomicReference<>();

    /* renamed from: a  reason: collision with other field name */
    final u4 f4564a = new u4();

    /* renamed from: a  reason: collision with other field name */
    volatile boolean f4565a;

    public on0(ho0<? super T> actual) {
        this.a = actual;
    }

    public void request(long n) {
        if (n <= 0) {
            cancel();
            onError(new IllegalArgumentException("§3.9 violated: positive request amount required but it was " + n));
            return;
        }
        b.deferredRequest(this.f4563a, this.f4562a, n);
    }

    public void cancel() {
        if (!this.f4565a) {
            b.cancel(this.f4563a);
        }
    }

    public void d(jo0 s) {
        if (this.f4561a.compareAndSet(false, true)) {
            this.a.d(this);
            b.deferredSetOnce(this.f4563a, this.f4562a, s);
            return;
        }
        s.cancel();
        cancel();
        onError(new IllegalStateException("§2.12 violated: onSubscribe must be called at most once"));
    }

    public void c(T t) {
        hq.c(this.a, t, this, this.f4564a);
    }

    public void onError(Throwable t) {
        this.f4565a = true;
        hq.b(this.a, t, this, this.f4564a);
    }

    public void a() {
        this.f4565a = true;
        hq.a(this.a, this, this.f4564a);
    }
}
