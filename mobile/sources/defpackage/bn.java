package defpackage;

import androidx.core.location.LocationRequestCompat;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: bn  reason: default package */
public final class bn<T> extends n<T, T> {
    final long a;

    /* renamed from: a  reason: collision with other field name */
    final ga0<? super Throwable> f234a;

    public bn(km<T> source, long count, ga0<? super Throwable> predicate) {
        super(source);
        this.f234a = predicate;
        this.a = count;
    }

    public void z(ho0<? super T> s) {
        ko0 sa = new ko0();
        s.d(sa);
        new a<>(s, this.a, this.f234a, sa, this.a).b();
    }

    /* renamed from: bn$a */
    static final class a<T> extends AtomicInteger implements en<T> {
        long a;

        /* renamed from: a  reason: collision with other field name */
        final ga0<? super Throwable> f235a;

        /* renamed from: a  reason: collision with other field name */
        final ho0<? super T> f236a;

        /* renamed from: a  reason: collision with other field name */
        final ko0 f237a;

        /* renamed from: a  reason: collision with other field name */
        final rb0<? extends T> f238a;
        long b;

        a(ho0<? super T> actual, long count, ga0<? super Throwable> predicate, ko0 sa, rb0<? extends T> source) {
            this.f236a = actual;
            this.f237a = sa;
            this.f238a = source;
            this.f235a = predicate;
            this.a = count;
        }

        public void d(jo0 s) {
            this.f237a.e(s);
        }

        public void c(T t) {
            this.b++;
            this.f236a.c(t);
        }

        public void onError(Throwable t) {
            long r = this.a;
            if (r != LocationRequestCompat.PASSIVE_INTERVAL) {
                this.a = r - 1;
            }
            if (r == 0) {
                this.f236a.onError(t);
                return;
            }
            try {
                if (!this.f235a.test(t)) {
                    this.f236a.onError(t);
                } else {
                    b();
                }
            } catch (Throwable e) {
                oj.b(e);
                this.f236a.onError(new rb(t, e));
            }
        }

        public void a() {
            this.f236a.a();
        }

        /* access modifiers changed from: package-private */
        public void b() {
            if (getAndIncrement() == 0) {
                int missed = 1;
                while (!this.f237a.c()) {
                    long p = this.b;
                    if (p != 0) {
                        this.b = 0;
                        this.f237a.d(p);
                    }
                    this.f238a.a(this);
                    missed = addAndGet(-missed);
                    if (missed == 0) {
                        return;
                    }
                }
            }
        }
    }
}
