package defpackage;

import androidx.core.location.LocationRequestCompat;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: an  reason: default package */
public final class an<T> extends n<T, T> {
    final long a;

    public an(km<T> source, long count) {
        super(source);
        this.a = count;
    }

    public void z(ho0<? super T> s) {
        ko0 sa = new ko0();
        s.d(sa);
        long j = this.a;
        long j2 = LocationRequestCompat.PASSIVE_INTERVAL;
        if (j != LocationRequestCompat.PASSIVE_INTERVAL) {
            j2 = j - 1;
        }
        new a<>(s, j2, sa, this.a).b();
    }

    /* renamed from: an$a */
    static final class a<T> extends AtomicInteger implements en<T> {
        long a;

        /* renamed from: a  reason: collision with other field name */
        final ho0<? super T> f75a;

        /* renamed from: a  reason: collision with other field name */
        final ko0 f76a;

        /* renamed from: a  reason: collision with other field name */
        final rb0<? extends T> f77a;
        long b;

        a(ho0<? super T> actual, long count, ko0 sa, rb0<? extends T> source) {
            this.f75a = actual;
            this.f76a = sa;
            this.f77a = source;
            this.a = count;
        }

        public void d(jo0 s) {
            this.f76a.e(s);
        }

        public void c(T t) {
            this.b++;
            this.f75a.c(t);
        }

        public void onError(Throwable t) {
            this.f75a.onError(t);
        }

        public void a() {
            long r = this.a;
            if (r != LocationRequestCompat.PASSIVE_INTERVAL) {
                this.a = r - 1;
            }
            if (r != 0) {
                b();
            } else {
                this.f75a.a();
            }
        }

        /* access modifiers changed from: package-private */
        public void b() {
            if (getAndIncrement() == 0) {
                int missed = 1;
                while (!this.f76a.c()) {
                    long p = this.b;
                    if (p != 0) {
                        this.b = 0;
                        this.f76a.d(p);
                    }
                    this.f77a.a(this);
                    missed = addAndGet(-missed);
                    if (missed == 0) {
                        return;
                    }
                }
            }
        }
    }
}
