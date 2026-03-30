package defpackage;

import io.reactivex.functions.Predicate;
import io.reactivex.internal.fuseable.QueueSubscription;

/* renamed from: sm  reason: default package */
public final class sm<T> extends n<T, T> {
    final ga0<? super T> a;

    public sm(km<T> source, ga0<? super T> predicate) {
        super(source);
        this.a = predicate;
    }

    /* access modifiers changed from: protected */
    public void z(ho0<? super T> s) {
        if (s instanceof zb) {
            this.a.y(new a((zb) s, this.a));
        } else {
            this.a.y(new b(s, this.a));
        }
    }

    /* renamed from: sm$b */
    static final class b<T> extends d6<T, T> implements zb<T> {
        final ga0<? super T> a;

        b(ho0<? super T> actual, ga0<? super T> filter) {
            super(actual);
            this.a = filter;
        }

        public void c(T t) {
            if (!f(t)) {
                this.f2710a.request(1);
            }
        }

        public boolean f(T t) {
            if (this.f2712a) {
                return false;
            }
            if (this.a != 0) {
                this.f2709a.c(null);
                return true;
            }
            try {
                boolean b = this.a.test(t);
                if (b) {
                    this.f2709a.c(t);
                }
                return b;
            } catch (Throwable e) {
                g(e);
                return true;
            }
        }

        public int requestFusion(int mode) {
            return h(mode);
        }

        public T poll() {
            QueueSubscription<T> qs = this.f2711a;
            Predicate<? super T> f = this.a;
            while (true) {
                T t = qs.poll();
                if (t == null) {
                    return null;
                }
                if (f.test(t)) {
                    return t;
                }
                if (this.a == 2) {
                    qs.request(1);
                }
            }
        }
    }

    /* renamed from: sm$a */
    static final class a<T> extends c6<T, T> {
        final ga0<? super T> a;

        a(zb<? super T> actual, ga0<? super T> filter) {
            super(actual);
            this.a = filter;
        }

        public void c(T t) {
            if (!f(t)) {
                this.f286a.request(1);
            }
        }

        public boolean f(T t) {
            if (this.f289a) {
                return false;
            }
            if (this.a != 0) {
                return this.f288a.f(null);
            }
            try {
                if (!this.a.test(t) || !this.f288a.f(t)) {
                    return false;
                }
                return true;
            } catch (Throwable e) {
                g(e);
                return true;
            }
        }

        public int requestFusion(int mode) {
            return h(mode);
        }

        public T poll() {
            QueueSubscription<T> qs = this.f287a;
            Predicate<? super T> f = this.a;
            while (true) {
                T t = qs.poll();
                if (t == null) {
                    return null;
                }
                if (f.test(t)) {
                    return t;
                }
                if (this.a == 2) {
                    qs.request(1);
                }
            }
        }
    }
}
