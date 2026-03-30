package defpackage;

import io.reactivex.internal.subscriptions.b;
import org.reactivestreams.Subscriber;

/* renamed from: wf  reason: default package */
public abstract class wf<T> extends e6<T> {
    protected final ho0<? super T> a;

    /* renamed from: a  reason: collision with other field name */
    protected T f5484a;

    public wf(ho0<? super T> actual) {
        this.a = actual;
    }

    public final void request(long n) {
        T v;
        if (b.validate(n)) {
            do {
                int state = get();
                if ((state & -2) == 0) {
                    if (state == 1) {
                        if (compareAndSet(1, 3) && (v = this.f5484a) != null) {
                            this.f5484a = null;
                            Subscriber<? super T> a2 = this.a;
                            a2.c(v);
                            if (get() != 4) {
                                a2.a();
                                return;
                            }
                            return;
                        }
                        return;
                    }
                } else {
                    return;
                }
            } while (!compareAndSet(0, 2));
        }
    }

    public final void h(T v) {
        int state = get();
        while (state != 8) {
            if ((state & -3) == 0) {
                if (state == 2) {
                    lazySet(3);
                    Subscriber<? super T> a2 = this.a;
                    a2.c(v);
                    if (get() != 4) {
                        a2.a();
                        return;
                    }
                    return;
                }
                this.f5484a = v;
                if (!compareAndSet(0, 1)) {
                    state = get();
                    if (state == 4) {
                        this.f5484a = null;
                        return;
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        }
        this.f5484a = v;
        lazySet(16);
        Subscriber<? super T> a3 = this.a;
        a3.c(v);
        if (get() != 4) {
            a3.a();
        }
    }

    public final int requestFusion(int mode) {
        if ((mode & 2) == 0) {
            return 0;
        }
        lazySet(8);
        return 2;
    }

    public final T poll() {
        if (get() != 16) {
            return null;
        }
        lazySet(32);
        T v = this.f5484a;
        this.f5484a = null;
        return v;
    }

    public final boolean isEmpty() {
        return get() != 16;
    }

    public final void clear() {
        lazySet(32);
        this.f5484a = null;
    }

    public void cancel() {
        set(4);
        this.f5484a = null;
    }
}
