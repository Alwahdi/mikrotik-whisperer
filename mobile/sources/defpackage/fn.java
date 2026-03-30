package defpackage;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.internal.subscriptions.b;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: fn  reason: default package */
public final class fn<T> extends n<T, T> {
    final long a;

    public fn(km<T> source, long limit) {
        super(source);
        this.a = limit;
    }

    /* access modifiers changed from: protected */
    public void z(ho0<? super T> s) {
        this.a.y(new a(s, this.a));
    }

    /* renamed from: fn$a */
    static final class a<T> extends AtomicBoolean implements en<T>, jo0 {
        final long a;

        /* renamed from: a  reason: collision with other field name */
        final ho0<? super T> f2978a;

        /* renamed from: a  reason: collision with other field name */
        jo0 f2979a;

        /* renamed from: a  reason: collision with other field name */
        boolean f2980a;
        long b;

        a(ho0<? super T> actual, long limit) {
            this.f2978a = actual;
            this.a = limit;
            this.b = limit;
        }

        public void d(jo0 s) {
            if (b.validate(this.f2979a, s)) {
                this.f2979a = s;
                if (this.a == 0) {
                    s.cancel();
                    this.f2980a = true;
                    io.reactivex.internal.subscriptions.a.complete(this.f2978a);
                    return;
                }
                this.f2978a.d(this);
            }
        }

        public void c(T t) {
            if (!this.f2980a) {
                long j = this.b;
                long j2 = j - 1;
                this.b = j2;
                if (j > 0) {
                    boolean stop = j2 == 0;
                    this.f2978a.c(t);
                    if (stop) {
                        this.f2979a.cancel();
                        a();
                    }
                }
            }
        }

        public void onError(Throwable t) {
            if (!this.f2980a) {
                this.f2980a = true;
                this.f2979a.cancel();
                this.f2978a.onError(t);
            }
        }

        public void a() {
            if (!this.f2980a) {
                this.f2980a = true;
                this.f2978a.a();
            }
        }

        public void request(long n) {
            if (b.validate(n)) {
                if (get() || !compareAndSet(false, true) || n < this.a) {
                    this.f2979a.request(n);
                } else {
                    this.f2979a.request(LocationRequestCompat.PASSIVE_INTERVAL);
                }
            }
        }

        public void cancel() {
            this.f2979a.cancel();
        }
    }
}
