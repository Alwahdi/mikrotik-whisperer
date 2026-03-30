package defpackage;

import io.reactivex.internal.subscriptions.b;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Subscriber;

/* renamed from: xi0  reason: default package */
public final class xi0<T> extends AtomicInteger implements wb0<T> {
    final ho0<? super T> a;

    /* renamed from: a  reason: collision with other field name */
    final T f5745a;

    public xi0(ho0<? super T> subscriber, T value) {
        this.a = subscriber;
        this.f5745a = value;
    }

    public void request(long n) {
        if (b.validate(n) && compareAndSet(0, 1)) {
            Subscriber<? super T> s = this.a;
            s.c(this.f5745a);
            if (get() != 2) {
                s.a();
            }
        }
    }

    public void cancel() {
        lazySet(2);
    }

    public boolean offer(T t) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    public T poll() {
        if (get() != 0) {
            return null;
        }
        lazySet(1);
        return this.f5745a;
    }

    public boolean isEmpty() {
        return get() != 0;
    }

    public void clear() {
        lazySet(1);
    }

    public int requestFusion(int mode) {
        return mode & 1;
    }
}
